class Solution {
    public int findKthLargest(int[] nums, int k) {
      // initialize a priority queue of k size to keep k largest element at that particular time
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);

        for(int i=0; i<nums.length; i++){
            if(pq.size() == k){
              // check if the kth lowest element is smaller than the upcoming element
                if(nums[i] > pq.peek()){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }else{
                pq.add(nums[i]);
            }
        }

        // return the top element of the min heap of size k
        return pq.poll();
    }
}
