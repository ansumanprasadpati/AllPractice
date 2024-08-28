import java.util.HashSet;
import java.util.Set;

public class PairSum {
    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int sum = 10;
        
        Set<Integer> set = new HashSet<>();
        System.out.println("Pairs with sum " + sum + ":");
        for (int num : arr) {
            int target = sum - num;
            if (set.contains(target)) {
                System.out.println("(" + target + ", " + num + ")");
            }
            set.add(num);
        }
    }
}
