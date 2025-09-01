class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSort(0, nums.length-1, nums);

        return nums[nums.length-k];
    }

    public void quickSort(int left, int right, int[] nums) {
        if (left < right) {
            int mid = partition(left, right, nums);

            quickSort(left, mid, nums);
            quickSort(mid + 1, right, nums);
        }
    }

    public int partition(int left, int right, int[] nums) {
        int low = left;
        int high = right;

        int pivot = nums[(left+right)/2];

        while(true) {
            while(nums[low] < pivot) {
                low++;
            }

            while(nums[high] > pivot) {
                high--;
            }

            if (low >= high) {
                return high;
            }

            swap(low, high, nums);

            low++;
            high--;
        }

    }

    public void swap(int low, int right, int[] nums) {
        int temp = nums[low];
        nums[low] = nums[right];
        nums[right] = temp;
    }
}