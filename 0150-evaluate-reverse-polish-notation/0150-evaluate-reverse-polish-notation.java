class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
                
        for(String op : tokens){
            if(op.equals("+") || op.equals("*") || op.equals("-") || op.equals("/")){
                int x = st.pop();
                int y = st.pop();
                
                if(op.equals("+")){
                    st.push(y + x);
                }
                else if(op.equals("-")){
                    st.push(y - x);
                }
                else if(op.equals("/")){
                    st.push(y / x);
                }else{
                    st.push(y * x);
                }
            }else{
                st.push(Integer.parseInt(op));
            }
        }
        
        return st.pop();
    }
}