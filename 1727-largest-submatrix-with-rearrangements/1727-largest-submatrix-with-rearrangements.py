class Solution:
    def largestSubmatrix(self, matrix: List[List[int]]) -> int:
        for row in range(1, len(matrix)):
            for col in range(len(matrix[0])):
                if matrix[row][col] == 1:
                    matrix[row][col] = matrix[row - 1][col] + 1
        max_area = 0
        for row in matrix:
            row.sort(reverse=True)
            for width, height in enumerate(row, start=1):
                current_area = width * height
                max_area = max(max_area, current_area)
      
        return max_area