class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int low = 0;
        int high = 0;
        int count = 0;
        for(high=0; high<s2.length(); high++){
            char curr = s2.charAt(high);
            if(map.containsKey(curr)){
                map.put(curr, map.get(curr)-1);
                if(map.get(curr)>=0)count++;
            }

            if(high-low+1 > s1.length()){
                char rem = s2.charAt(low);
                if(map.containsKey(rem)){
                    map.put(rem, map.get(rem)+1);
                    if(map.get(rem) > 0){
                        count--;
                    }
                }
                low++;
            }
            if(count == s1.length()){
                return true;
            }
        }

        return false;
    }
}
