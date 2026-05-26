
class Solution:
    def rotate(self, matrix):
        return [list(row) for row in zip(*matrix[::-1])]
    
    def findRotation(self, mat, target):
        for _ in range(4):
            if mat == target:
                return True
            mat = self.rotate(mat)
        return False