class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder curr = new StringBuilder();
        int n = digits.length();

        helper(digits, 0, map, curr, n);

        return ans;
    }

    public void helper(String digits, int idx, HashMap<Character, String> map, StringBuilder curr, int n){
        if(curr.length() == n){
            ans.add(curr.toString());
            return;
        }
        char digit = digits.charAt(idx);
        String sOnNumber = map.get(digit);
        
        for(int i=0; i<sOnNumber.length(); i++){
            char choice = sOnNumber.charAt(i);
            curr.append(choice);
            idx++;
            helper(digits, idx, map, curr, n);
            curr.deleteCharAt(curr.length()-1);
            idx--;
        }
    }
}
