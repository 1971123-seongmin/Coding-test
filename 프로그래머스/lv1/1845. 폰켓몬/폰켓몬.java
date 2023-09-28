import java.util.*; 

class Solution {
    public int solution(int[] nums) {
        int middle = nums.length / 2;
        int ans = middle;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        if(middle >= set.size()) ans = set.size();
        
        return ans;
    }
}