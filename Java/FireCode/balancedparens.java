public static boolean isBalanced(String input) {
    //this is a simple stack problem. we will use a stack and whenever we encounter a right parenthesis we will pop off
    // the stack and verify it is a matching left.
    if(input == null) return false;
    Stack<Character> stack = new Stack<>();
    for(char c : input.toCharArray()){
       if(c == ')'){
           if(stack.isEmpty() || stack.pop() != '(') return false;
       }
       else if(c == ']'){
           if(stack.isEmpty() || stack.pop() != '[') return false;
       }
       else if(c == '}'){
           if(stack.isEmpty() || stack.pop() != '{') return false;
       }
       else {
          stack.push(c);
       }
    }
    //if there are remaining elements in our stack that indicates it is unbalanced ex: [() it would verify ()
    // and leave [ in the stack.
    return (stack.isEmpty())?true:false;

}
