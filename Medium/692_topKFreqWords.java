class Solution {
    class Pair{
        String word;
        int freq;
        Pair(String word, int freq){
            this.word = word;
            this.freq = freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.freq == b.freq){
                return a.word.compareTo(b.word);//min heap
            }
            return b.freq-a.freq;//max heap
        });

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        for(String key : map.keySet()){
            pq.add(new Pair(key, map.get(key)));
        }

        List<String> ans = new ArrayList<>();

        for(int i=0; i<k; i++){
            ans.add(pq.poll().word);
        }

        return ans;
    }
}
