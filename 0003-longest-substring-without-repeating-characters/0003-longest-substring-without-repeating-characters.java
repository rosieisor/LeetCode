class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            sb.setLength(0);
            sb.append(s.charAt(i));
            for(int j=i+1; j<s.length(); j++) {
                if (sb.toString().contains(String.valueOf(s.charAt(j)))) {
                    break;
                }
                sb.append(s.charAt(j));
            }
            result = Math.max(result, sb.toString().length());
        }

        return result;
    }
}