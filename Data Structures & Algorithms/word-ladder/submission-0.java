class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Map<String, List<String>> adjList = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String sb = word.substring(0, i) +
                        "*" +
                        word.substring(i + 1);
                adjList.computeIfAbsent(sb, k -> new ArrayList<>()).add(word);
            }
        }

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int res = 1;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (endWord.equals(word)) return res;
                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    for (String neiWord : adjList.getOrDefault(pattern, new ArrayList<>())) {
                        if (!visited.contains(neiWord)) {
                            visited.add(neiWord);
                            queue.offer(neiWord);
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }
}
