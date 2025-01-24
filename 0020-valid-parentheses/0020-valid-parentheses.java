class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));

        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ')' && st.peek() != '('){
                return false;
            } else if(c == ')' && st.peek() == '(') st.pop();
            else if(c == '}' && st.peek() != '{') return false;
            else if(c == '}' && st.peek() == '{') st.pop();
            else if(c == ']' && st.peek() != '[') return false;
            else if(c == ']' && st.peek() == '[') st.pop();
            
            else st.push(c);
        }

        return st.isEmpty();
    }
}