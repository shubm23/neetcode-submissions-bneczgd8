class Solution {
public List<String> findItinerary(List<List<String>> tickets) {
        // Build adjacency list with sorted destinations
        Map<String, List<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
        }
        for (List<String> dests : adj.values()) {
            Collections.sort(dests);
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");
        if (findItineraryDfs("JFK", adj, res, tickets.size() + 1)) {
            return res;
        }
        return new ArrayList<>(); // Should not happen if input is valid
    }

    private boolean findItineraryDfs(String src, Map<String, List<String>> adj, List<String> res, int targetLen) {
        if (res.size() == targetLen) return true;
        if (!adj.containsKey(src)) return false;
        List<String> temp = new ArrayList<>(adj.get(src));
        for (int i = 0; i < temp.size(); i++) {
            String v = temp.get(i);
            adj.get(src).remove(i);
            res.add(v);
            if (findItineraryDfs(v, adj, res, targetLen)) return true;
            adj.get(src).add(i, v);
            res.remove(res.size() - 1);
        }
        return false;
    }
}
