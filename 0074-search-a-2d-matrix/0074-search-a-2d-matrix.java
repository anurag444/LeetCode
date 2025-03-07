class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high)/2;

            if(matrix[mid][0] <= target && target <= matrix[mid][n - 1]){
                break;
            }

            if(matrix[mid][0] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        low = 0;
        high = n - 1;
        int mid2;

        while(low <= high){
            mid2 = (low + high)/2;

            if(matrix[mid][mid2] == target) return true;
            else if(matrix[mid][mid2] < target) low = mid2 +1;
            else high = mid2 - 1;
        } 

        return false;
    }
}