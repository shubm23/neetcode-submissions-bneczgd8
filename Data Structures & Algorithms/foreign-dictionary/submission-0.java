class Solution {
    Map<Character, Set<Character>> adjList = new HashMap<>();
    Map<Character, Boolean> visited = new HashMap<>();
    List<Character> res = new ArrayList<>();
    
    public String foreignDictionary(String[] words) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                adjList.putIfAbsent(word.charAt(i), new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            int l1 = words[i].length(), l2 = words[i + 1].length();
            int minLen = Math.min(l1, l2);

            if (l1 > l2 && words[i].substring(0, minLen).equals(words[i + 1].substring(0, minLen))) {
                return "";
            }

            for (int j = 0; j < minLen; j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    adjList.get(words[i].charAt(j)).add(words[i + 1].charAt(j));
                    break;
                }
            }
        }

        for (char ch : adjList.keySet()) {
            if (dfs(ch)) return "";
        }

        Collections.reverse(res);
        StringBuilder sb = new StringBuilder();
        for (char ch : res) {
            sb.append(ch);
        }
        return sb.toString();
    }

    private boolean dfs(char ch) {
        if (visited.containsKey(ch)) return visited.get(ch);
        visited.put(ch, true);
        for (char c : adjList.get(ch)) {
            if (dfs(c)) {
                return true;
            }
        }
        visited.put(ch, false);
        res.add(ch);
        return false;
    }
}
