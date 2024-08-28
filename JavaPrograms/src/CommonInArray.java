import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommonInArray {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6};
        int[] array2 = {4, 5, 6, 7, 8, 9};

        List<Integer> commonElements = findCommonElements(array1, array2);

        System.out.println("Common elements: " + commonElements);
    }

    public static List<Integer> findCommonElements(int[] array1, int[] array2) {
        List<Integer> list1 = Arrays.stream(array1).boxed().collect(Collectors.toList());

        return Arrays.stream(array2)
                .boxed()
                .filter(list1::contains)
                .distinct()
                .collect(Collectors.toList());
    }
}
