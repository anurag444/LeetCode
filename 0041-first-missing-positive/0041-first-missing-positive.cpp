class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        // first make all the -ve values n + 1
        for(int i = 0; i<nums.size(); i++){
            if(nums[i] <= 0){
                nums[i] = nums.size() + 1;
            }
        }

        //find the value at index and make it as -ve so that we can iterate over again
        for(int i = 0; i < nums.size(); i++){
            int index = abs(nums[i]) - 1;
            if(index < nums.size() && nums[index] > 0){
                nums[index] *= -1;
            }
        }

        //find the positive number as it will not be present in the array and should be the answer
        for(int i = 0; i< nums.size(); i++){
            if(nums[i] > 0)
                return i + 1;
        }

        return nums.size() + 1;
    }
};