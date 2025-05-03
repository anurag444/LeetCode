class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //2 steps - first find the row and then binary search in column

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m - 1;

        int mid = 0;
        
        while(start <= end){
            mid = (start + end)/2;

            if(matrix[mid][0] <= target && matrix[mid][n - 1] >= target){
                //we found the row now do binary search here

                int startrow = 0;
                int endrow = n - 1;

                int midrow = 0;

                while(startrow <= endrow){
                    midrow = (startrow + endrow)/2;
                    if(matrix[mid][midrow] == target) return true;

                    else if(matrix[mid][midrow] > target) endrow = midrow - 1;
                    else startrow = midrow + 1;
                }

                return false;

            }
            else if(target < matrix[mid][0]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return false;
    }
}