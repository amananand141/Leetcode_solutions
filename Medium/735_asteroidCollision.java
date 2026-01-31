class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int asteroid : asteroids){
            boolean destroyed = false;
            
            while(!st.isEmpty() && st.peek()>0 && asteroid<0){
                int top = st.peek();
                if(Math.abs(top) < Math.abs(asteroid)){
                    // top asteroid Explodes
                    st.pop();
                }else if(Math.abs(top) == Math.abs(asteroid)){
                    // Both explodes
                    st.pop();
                    destroyed = true;
                    break;
                }else{
                    // Upcoming asteroid gets destroyed
                    destroyed = true;
                    break;
                }
            }

            // Push the current asteroid to the stack as it survived all the collisions
            if(!destroyed){
                st.push(asteroid);
            }
        }

        int[] arr = new int[st.size()];
        for(int i=arr.length-1; i>=0; i--){
            arr[i] = st.pop();
        }

        return arr;
    }
}
