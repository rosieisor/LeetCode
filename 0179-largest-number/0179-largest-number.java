class Solution {
    public String largestNumber(int[] nums) {
        List<String> numList = new ArrayList<>();

        int count = 0;
        for(int num : nums) {
            numList.add(String.valueOf(num));

            if (num == 0) {
                count++;
            }
        }

        if (nums.length == count) {
            return "0";
        }

        Collections.sort(numList, (o1, o2) -> {
            if ((o1 + o2).compareTo(o2 + o1) > 0) {
                return -1;
            } else {
                return 1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String num : numList) {
            sb.append(num);
        }

        return sb.toString();
    }
}