class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int ts = 0;
        int s = 0;

        for(int i = 0; i<nums.size(); i++){
            ts += nums[i];
        }

        for(int i = 0; i<nums.size(); i++){
            if((ts - nums[i]) == s*2){
                return i;
            }
            s += nums[i]; 
        }
        return -1;
    }
};