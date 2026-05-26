class Solution:
    def areSimilar(self, mat: List[List[int]], k: int) -> bool:
        num_cols = len(mat[0])
        for row_idx, row in enumerate(mat):
            for col_idx, element in enumerate(row):
                if row_idx % 2 == 1:
                    shifted_position = (col_idx + k) % num_cols
                    if element != mat[row_idx][shifted_position]:
                        return False
                if row_idx % 2 == 0:
                    shifted_position = (col_idx - k + num_cols) % num_cols
                    if element != mat[row_idx][shifted_position]:
                        return False
        return True