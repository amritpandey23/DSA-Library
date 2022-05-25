package searching;

public class FloydWarshall {
    public static void main(String[] args) {
        int[] A = {5, 2, 3, 4, 5, 1};
        System.out.println(repeatingElement(A)); 
    }

    public static int repeatingElement(int[] A) {
        int slow, fast;
        slow = A[0];
        fast = A[0];
        do {
            slow = A[slow];
            fast = A[A[fast]];
        } while (slow != fast);
        slow = A[0];
        while (slow != fast) {
            slow = A[slow];
            fast = A[fast];
        }
        return slow;
    }
}
