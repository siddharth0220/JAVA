public class smallest {
    public static int smallestP(int arr[], int st, int en) {
        if (st == en)
            return arr[st];
        int mid = st + (en - st) / 2;
        int leftSmallest = smallestP(arr, st, mid);
        int rightSmallest = smallestP(arr, mid + 1, en);
        return Math.min(leftSmallest, rightSmallest);
    }

    public static void main(String[] args) {
        int arr[] = { 7, 3, 1, 21, 34 };
        int small = smallestP(arr, 0, arr.length - 1);
        System.out.println(small);
    }
}