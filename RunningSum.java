public class RunningSum {

    public static void main(String[] args) {
        System.out.println("test");
    }

    public int[] runningSumBadSpace(int[] nums) {
        int sum = 0;
        int[] sums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        return sums;
    }

    // One less iteration of for loop
    public int[] runningSumGoodSpace(int[] nums) {

        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
