class Solution {
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            int len = str.length();
            sb.append(len).append("#").append(str);
        }
        return sb.toString();
    }
    //5#Hello5#World
    public static List<String> decode(String str) {
        int i = 0;
        List<String> res = new ArrayList<>();
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            int start = j + 1;
            String currStr = str.substring(start, start + len);
            res.add(currStr);
            i = start + len;
        }
        return res;
    }
}
