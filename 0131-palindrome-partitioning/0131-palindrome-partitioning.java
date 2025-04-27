class Solution {
    public List<List<String>> partition(String s){
        List<List<String>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), s, 0);

        return res;
    }

    public void backtrack(List<List<String>> res, List<String> list, String s, int idx){
        //add the temp to res, and we have to add by creating new list due to how java handles references
        // by using new java will create a copy, if we not use it then everytime list is updated, it will
        // be updated in the res as well.
        if(idx == s.length()){
            res.add(new ArrayList<>(list));
        }

        for(int i = idx; i < s.length(); i++){

            if(isPalindrome(s, idx, i)){
                list.add(s.substring(idx, i + 1));
                backtrack(res, list, s, i + 1);

                list.remove(list.size() - 1);
            }
            
        } 
    
    }
    public boolean isPalindrome(String s, int start, int end){ 
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}