class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int result = 0;

        String[] arr = stones.split("");

        for(int i=0; i<arr.length; i++) {
            if (jewels.contains(arr[i])){
                result++;
            }
        }
        
        return result;
    }
}