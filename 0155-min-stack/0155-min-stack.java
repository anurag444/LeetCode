class MinStack {
    
    Stack<Integer> st;
    Stack<Integer> min;

    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        
        //We check if the min stack is either empty or do we have a new min, tehn we push the val to min stack
        if(min.isEmpty() || st.peek() <= min.peek()){
            min.push(val);
        }
    }
    
    public void pop() {
        int n = st.pop();
        if(n == min.peek()){
            min.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */