package ms;

import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import java.io.IOException;

public class HttpRequestUtil {
    @FunctionalInterface
    public interface Call<T> {

        /**
         * Gets a result.
         *
         * @return a result
         */
        T get() throws Exception;
    }

    public static class BizException extends Exception {
        private int code;

        public BizException(int code, String message, Throwable cause) {
            super(message, cause);
            this.code = code;
        }

        public BizException(int code, String message) {
            super(message);
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

    private static final int REQUEST_TIME_OUT = 500;
    private static final int CONNECT_TIME_OUT = 1000;
    private static final int SOCKET_TIME_OUT = 1000;

    private static final int IO_ERROR_CODE = 550;
    private static final int PROTOCOL_ERROR_CODE = 560;
    private static final int BODY_DECODE_ERROR_CODE = 570;
    private static final int UNDEFIND_ERROR_CODE = 600;

    public static final Header CONTENT_TYPE_HEADER = new BasicHeader("Content-type", "application/json");
    public static final Header ACCEPT_HEADER = new BasicHeader("Accept", "application/json");

    public void doPost(String url, String jsonBody) throws BizException {
        // 创建请求池
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建post请求
        HttpPost post = new HttpPost(url);

        // 配置post请求
        post.setConfig(RequestConfig.custom() // 设置超时配置
                .setConnectionRequestTimeout(REQUEST_TIME_OUT)
                .setConnectTimeout(CONNECT_TIME_OUT)
                .setSocketTimeout(SOCKET_TIME_OUT).build());

        // 配置header
        post.setHeaders(new Header[]{CONTENT_TYPE_HEADER, ACCEPT_HEADER});

        // 设置json body
        try {
            StringEntity entity = new StringEntity(jsonBody);
            post.setEntity(entity);
        } catch (Exception e) {

            throw new BizException(BODY_DECODE_ERROR_CODE, e.getMessage(), e);
        }


        try {
            // 执行POST请求 带重试
            CloseableHttpResponse httpResponse = retry(2, () -> httpClient.execute(post), null);

            // 成功的话pass
            if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {

                throw new BizException(httpResponse.getStatusLine().getStatusCode(), httpResponse.getStatusLine().getReasonPhrase());
            }

            // 关闭
            httpClient.close();

        } catch (Exception e) {
            if (e instanceof ClientProtocolException) {

                throw new BizException(PROTOCOL_ERROR_CODE, e.getMessage(), e);
            }

            if (e instanceof IOException) {

                throw new BizException(IO_ERROR_CODE, e.getMessage(), e);
            }

            if (e instanceof BizException) {

                throw (BizException) e;
            }

            throw new BizException(UNDEFIND_ERROR_CODE, e.getMessage(), e);
        }
    }

    public static <T> T retry(int maxTimes, Call<T> action, Call<T> callBack) throws Exception {
        Exception exception = null;

        for (int i = 1; i <= maxTimes; i++) {
            try {
                return action.get();
            } catch (Exception e) {
                exception = e;
            }
        }

        // 重试次数达到 retryMaxCount 则触发retryMaxHook
        if (callBack != null) {
            return callBack.get();
        }

        throw exception == null ? new Exception("无异常信息") : exception;
    }
}
