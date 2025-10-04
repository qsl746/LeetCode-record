package bitedance;

import java.util.Stack;

public class isValid_20 {
    class Solution {
        public boolean isValid(String s) {
            //自解
            char[] charArray = s.toCharArray();
            Stack<Character> stack=new Stack<>();
            for(int i=0;i<charArray.length;i++){
                if(isLeft(charArray[i])){
                    stack.push(charArray[i]);
                }else {
                    if (stack.isEmpty())return false;
                    Character pop = stack.pop();

                    if(!match(pop,charArray[i]))return false;
                }
            }
            return true;
        }

        boolean isLeft(Character c){
            return  c=='('||c=='{'||c=='[';
        }
        boolean match(Character left,Character right){
            if(!isLeft(left))return false;

            return (left=='('&&right==')')
                    ||(left=='{'&&right=='}')
                    ||(left=='['&&right==']');
        }
    }
    class Solution_2 {
        //借鉴
        public boolean isValid(String s) {
            if(s.length()==0)return false;

            Stack<Character> stack=new Stack<>();
            for (char c:s.toCharArray()) {
                if(c=='('){
                    stack.push(')');
                } else if (c == '{') {
                    stack.push('}');
                } else if (c == '[') {
                    stack.push(']');
                }else if(stack.isEmpty()||stack.pop()!=c){
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
