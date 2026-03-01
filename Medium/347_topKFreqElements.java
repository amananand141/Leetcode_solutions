class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] arr = new List[nums.length + 1];

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key : map.keySet()){
            int freq = map.get(key);
            if(arr[freq] == null){
                arr[freq] = new ArrayList<>();
            }
            arr[freq].add(key);
        }

        int [] ans = new int[k];
        int position = 0;
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] != null){
                for(int j=0; j<arr[i].size() && position<k; j++){
                    ans[position] = arr[i].get(j);
                    position++;
                }
            }
        }
        return ans;
    }
}
