package easy;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Samaritan on 2019/10/7.
 */
public class TwoSumAnswer {
    public static void main(String[] args) {
       int[] numbers = {2,7,11,15};int target = 9;
       //run here
    }

    public int[] twoSumSorted(int[] sums, int target) {
        int[] res = new int[2];
        int left =0;
        int right = sums.length - 1;
        while (left < right) {
            int sum = sums[left] + sums[right];
            if (sum == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.get(target - nums[i]) != null) {
                return new int[]{numMap.get(target - nums[i]), i};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }
}
