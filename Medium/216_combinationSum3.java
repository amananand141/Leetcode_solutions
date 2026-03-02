class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(k, n, 1, ans, new ArrayList<>());

        return ans;
    }

    public void helper(int k, int n, int index, List<List<Integer>> ans, List<Integer> curr){
        if(curr.size() == k && n==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(curr.size() == k)return;

        for(int i=index; i<=9; i++){
            curr.add(i);
            helper(k, n-i, i+1, ans, curr); // Recursion
            curr.remove(curr.size()-1); // Backtrack
        }
    }
}
