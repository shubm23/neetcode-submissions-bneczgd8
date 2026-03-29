class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //Generate the Pattern Adjacency List
        Map<String, List<String>> adjList = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                adjList.computeIfAbsent(pattern, (k) -> new ArrayList<>()).add(word);
            }
        }
        
        
        Deque<String> deque = new ArrayDeque<>();
        deque.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int res = 1;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String word = deque.poll();
                if (endWord.equals(word)) return res;
                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    for (String str : adjList.getOrDefault(pattern, new ArrayList<>())) {
                        if (!visited.contains(str)) {
                            visited.add(str);
                            deque.offer(str);
                        }
                    }
                }
            }
            res++;
        }

        return 0;
    }
}
