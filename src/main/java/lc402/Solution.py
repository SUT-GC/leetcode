#! -*- coding:utf8 -*-

class Solution(object):
    def removeKdigits(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """

        if not num or k >= len(num):
            return "0"

        if 0 == k:
            return num

        l = len(num)
        i = 1
        while k > 0 and i < l:
            p = num[i-1]
            n = num[i]

            if p > n:
                k-=1
                num = num[0:i-1]+num[i:]
                l = len(num)
                i=( i-1 if i - 1 > 0 else 1)
            else:
                i+=1

        num = num[0:l-k]

        while num != "" and "0" == num[0]:
            num = num[1:]

        return "0" if not num else num

if __name__ == "__main__":
    solution = Solution()
    print solution.removeKdigits("1234567890", 9)