class Solution(object):

    def isValidNextWord(self, start, end):
        count = 0

        for i in range(len(start)):
            if start[i] != end[i]:
                count += 1

        return count == 1

    def findNextWord(self, beginWord, endWord, wordList):
        minN = 10000000

        for next in wordList:
            isValidNext = self.isValidNextWord(beginWord, next)
            if isValidNext and endWord == next:
                return 1

            if isValidNext:
                nextWorld = [w for w in wordList if w != next]
                minN = min(self.findNextWord(next, endWord, nextWorld)+1, minN)


        return minN

    def ladderLength(self, beginWord, endWord, wordList):
        if endWord not in wordList:
            return 0

        ans = self.findNextWord(beginWord, endWord, wordList)

        if ans >= 10000000:
            return 0

        return ans+1

if __name__ == "__main__" :
    print Solution().ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"])