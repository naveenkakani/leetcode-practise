class Solution {
    
    private void decode(Stack<String> stk){
        
        StringBuilder tempString = new StringBuilder();
        StringBuilder number = new StringBuilder();
        
        while(!stk.isEmpty() && (stk.peek()).charAt(0) != '['){
            tempString.insert(0, stk.pop());
        }
        
        if(!stk.isEmpty() && (stk.peek()).charAt(0) == '[') stk.pop();
        
        while(!stk.isEmpty() && ((stk.peek()).charAt(0) >= '0' && (stk.peek()).charAt(0) <= '9')){
            number.insert(0, stk.pop());
        }
        
        int n = Integer.parseInt(number.toString());
        StringBuilder partialResult = new StringBuilder();
        while(n > 0){
            partialResult.append(tempString);
            n--;
        }
        stk.push(partialResult.toString());
    }
    
    public String decodeString(String s) {
        int n = s.length();
        Stack<String> stk = new Stack<String>();
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != ']') stk.push(s.charAt(i)+"");
            else{
                decode(stk);
            }
        }
        
        /* Return final string from stack */
        while(!stk.isEmpty()){
               result.insert(0, stk.pop());
        }
        return result.toString();
    }
}
