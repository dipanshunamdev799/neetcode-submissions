class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;
        for(int i=0; i<n; i++){
            String x = tokens[i];
            if(x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/")){
                int q = stack.pop();
                int p = stack.pop();
                switch (tokens[i]){
                    case "+":
                        stack.push(p+q);
                        break;
                    case "-":
                        stack.push(p-q);
                        break;
                    case "/":
                        stack.push(p/q);
                        break;
                    case "*":
                        stack.push(p*q);                    
                        break;
                }
            }else{
                stack.add(Integer.parseInt(x));
            }
        }
        return stack.pop();
    }
}
