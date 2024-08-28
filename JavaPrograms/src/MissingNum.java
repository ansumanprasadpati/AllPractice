
public class MissingNum {
	    public static void main(String[] args) {
	        int[] nums = {0, 1, 2, 4, 5};
	        int n = nums.length;
	        int totalSum = n * (n + 1) / 2;
	        int arraySum = 0;
	        
	        for (int num : nums) {
	            arraySum += num;
	        }
	       int  missingNumber= totalSum-arraySum;
	        System.out.println("Missing number is: " + missingNumber);
	    }
	}