class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ']'){
                if(stack.isEmpty()) return false;
                if(stack.peek()!='[') return false;
                stack.pop();
            }else if(ch == '}'){
                if(stack.isEmpty()) return false;
                if(stack.peek()!='{') return false;
                stack.pop();
            }else if(ch == ')'){
                if(stack.isEmpty()) return false;
                if(stack.peek()!='(') return false;
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
