class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> map = new HashSet<>(wordList);
        if(!map.contains(endWord))return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int count = 1;

        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0; i<s; i++){
                String word = q.poll();
                if(word.equals(endWord)){
                    return count;
                }

                char[] arr = word.toCharArray();

                for(int j=0; j<arr.length; j++){
                    char c = arr[j];
                    for(char ch='a'; ch<='z'; ch++){
                        arr[j] = ch;
                        String curr = new String(arr);

                        if(map.contains(curr)){
                            q.add(curr);
                            map.remove(curr);
                        }
                    }
                    arr[j] = c;
                }
            }
            count++;
        }

        return 0;
    }
}
