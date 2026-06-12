//problem 1
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int rsum=0;
        int count=0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            rsum+=nums[i];
            if(map.containsKey(rsum-k)){
                count+=map.get(rsum-k);
            }
            if(map.containsKey(rsum)){
                map.put(rsum,map.get(rsum)+1);
            }else{
                map.put(rsum,1);
            }
        }
        return count;
    }
}
//problem 2
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int maxi=0;
        int rsum=0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                rsum+=1;
            }else{
                rsum-=1;
            }
            if(map.containsKey(rsum)){
                maxi=Math.max(maxi,i-map.get(rsum));
            }else{
                map.put(rsum,i);
            }
        }
        return maxi;
    }
}
//problem 3
class Solution {
    public int longestPalindrome(String s) {
        int n=s.length();
        int count=0;
        HashSet<Character> map=new HashSet<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(map.contains(ch)){
                count+=2;
                map.remove(ch);
            }else{
                map.add(ch);
            }
        }
        if(!map.isEmpty()) count+=1;
        return count;
    }
}
