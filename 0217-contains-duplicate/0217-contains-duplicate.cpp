class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        set<int> set;

        for(int i = 0; i<nums.size(); i++){
            if(!set.count(nums[i])){
                set.insert(nums[i]);
            }else{
                return true;
            }
        }

        return false;
    }
};