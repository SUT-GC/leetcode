class Solution(object):
    def numOne(self, x):
        c = 0
        for ch in iter(str(bin(x))):
            if ch == '1':
                c+=1

        return c


    def compare(self, x, y):
        nx = self.numOne(x)
        ny = self.numOne(y)
        print x,nx
        print y,ny
        if nx > ny:
            return 1
        if nx < ny:
            return -1

        if x > y:
            return 1
        if x < y:
            return -1

        return 0


    def sortByBits(self, arr):
        """
        :type arr: List[int]
        :rtype: List[int]
        """
        if not arr:
            return arr

        return sorted(arr, self.compare)

if __name__ == "__main__":
    solution = Solution()
    print solution.sortByBits([0,1,2,3,4,5,6,7,8])