class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int h = m - 1;
        int mid = 0;

        while(l <= h){
            mid = (l + h)/2;

            if(matrix[mid][0] <= target && matrix[mid][n - 1] >= target){
                //binary search for row

                int low = 0;
                int high = n - 1;
                int mid2 = 0;

                //corner case when col is 1
                if(matrix[mid][mid2] == target) return true;

                while(low <= high){
                    mid2 = (low + high)/2;

                    if(matrix[mid][mid2] == target){
                        return true;
                    }else if(matrix[mid][mid2] < target){
                        low = mid2 + 1;
                    }else{
                        high = mid2 - 1;
                    }
                }

                return false;

            }

            else if(matrix[mid][0] < target && matrix[mid][n - 1] < target){
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }

        return false;
    }
}