public class kthsmallest {
    public static void main(String[] args) {
        int arr[] = { 7, 3, 1, 15, 17, 17 };
        int temp[] = new int[18];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;
        }
        int k = 5;
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 0) {
                count = count + temp[i];
                if (count >= k) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
