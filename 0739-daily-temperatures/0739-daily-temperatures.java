class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        res[n- 1] = 0;

        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >=0; i--){
            while(!st.isEmpty()){
                if(temperatures[st.peek()] > temperatures[i]) break;
                st.pop();
            }

            if(!st.isEmpty()) res[i] = st.peek() - i;

            st.push(i);
        }

        return res;
    }
}