class Solution {
    // public boolean checkValidString(String s) {
    //     int starCount = 0;
    //     // Instead of tracking the parenthesis we'll be tracking the indexes of the open and the star in seperate stacks
    //     Stack<Integer> open = new Stack<>();
    //     Stack<Integer> star = new Stack<>();

    //     for(int i=0; i<s.length(); i++){
    //         char curr = s.charAt(i);
    //         if(curr == '*'){
    //             star.push(i);
    //         }else if(curr == '('){
    //             open.push(i);
    //         }else{// ')'
    //             if(!open.isEmpty()){
    //                 open.pop();
    //             }else if(!star.isEmpty()){
    //                 star.pop();
    //             }else{
    //                 return false;
    //             }
    //         }
    //     }

    //     // case where we have left with '(' and '*' but the order matters
    //     while(!open.isEmpty() && !star.isEmpty()){
    //         if(open.peek() < star.peek()){
    //             open.pop();
    //             star.pop();
    //         }else{
    //             return false;
    //         }
    //     }

    //     return open.isEmpty();
    // }

    // Another approach

    public boolean checkValidString(String s){
        int low = 0; // minimum number of '('
        int high = 0; // Maximum number of '('

        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);

            if(curr == '('){
                low++;
                high++;
            }else if(curr == ')'){
                low--;
                high--;
            }else{
                // curr == '*'
                low--; // if treated as ')'
                high++; // if treated as '{'
            }

            if(high < 0){
                return false;
            }
            if(low < 0){
                low = 0;
            }
        }

        return low==0;
    }
}
