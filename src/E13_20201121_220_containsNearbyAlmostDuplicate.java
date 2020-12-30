package E13_20201121_220_containsNearbyAlmostDuplicate;

import java.util.HashMap;
import java.util.Map;

public class E13_20201121_220_containsNearbyAlmostDuplicate {
    //E13 220.存在重复元素 问题来源:https://leetcode-cn.com/problems/contains-duplicate-iii/

    public static void main(String[] args){
        int[] nums={1,2,3,1};
        int k=3,t=1;
        Solution solution=new Solution();
        System.out.println(solution.containsNearbyAlmostDuplicate(nums, k, t));
    }
}
class Solution {//解法来源:https://leetcode-cn.com/problems/contains-duplicate-iii/solution/cun-zai-zhong-fu-yuan-su-iii-by-leetcode/
    // Get the ID of the bucket from element value x and bucket width w
    // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
    private long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            // check if bucket m is empty, each bucket may contain at most one element
            if (d.containsKey(m))
                return true;
            // check the nei***or buckets for almost duplicate
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            // now bucket m is empty and no almost duplicate in nei***or buckets
            d.put(m, (long)nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }
}
