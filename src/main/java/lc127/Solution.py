import collections
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        wordset = set(wordList)
        if endWord not in wordset:
            return 0
        visited = set([beginWord])
        chrs = [chr(ord('a') + i) for i in range(26)]
        print chrs
        bfs = collections.deque([beginWord])
        res = 1
        while bfs:
            len_bfs = len(bfs)
            for _ in range(len_bfs):
                origin = bfs.popleft()
                print 'pop', origin
                for i in range(len(origin)):
                    originlist = list(origin)
                    for c in chrs:
                        originlist[i] = c
                        transword = "".join(originlist)
                        if transword not in visited:
                            if transword == endWord:
                                return res + 1
                            elif transword in wordset:
                                bfs.append(transword)
                                visited.add(transword)
            res += 1
        return 0


if __name__ == "__main__" :
    print Solution().ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"])