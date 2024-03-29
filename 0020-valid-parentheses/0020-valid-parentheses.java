class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if(s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') return false;

        int n = s.length();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(c == ')'){
                    if(stack.isEmpty() || stack.peek() != '(') return false;
                }

                if(c == ']'){
                    if(stack.isEmpty() || stack.peek() != '[') return false;
                }

                if(c == '}'){
                    if(stack.isEmpty() || stack.peek() != '{') return false;
                }

                stack.pop();
            }
        }

        if(!stack.isEmpty()) return false;

        return true;
    }
}