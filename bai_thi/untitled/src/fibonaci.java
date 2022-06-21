import java.util.ArrayList;
import java.util.List;

public class fibonaci {
    public static void main(String[] args) {
        List<Long> arr = new ArrayList<>();
        arr.add((long) 0);
        arr.add((long) 1);
        Long total = null;
        for (int i = 1; i < 50 ; i++) {
            Long x;
            x = arr.get(i)+arr.get(i-1);
            arr.add(x);
            total=arr.get(i)+arr.get(i+1);
        }
        System.out.println(arr.toString());
        System.out.println(total);
    }
}
