class Solution {
    public static String encode(List<String> strs) {
        return strs.stream().map(el -> el.length()+"#"+el).collect(Collectors.joining());
    }
    public static List<String> decode(String str) {
        int i = 0;
        List<String> res = new ArrayList<>();
        while (i < str.length()){
            int j = i;
            while (str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            int start = j+1;
            String currStr  = str.substring(start, start+len);
            res.add(currStr);
            i = start+len;
        }
        return res;
    }
}
