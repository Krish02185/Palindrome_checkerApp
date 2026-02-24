import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class Palindrome_checkerApp {

    public static boolean stackMethod(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static boolean dequeMethod(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public static boolean twoPointerMethod(String input) {
        int start = 0;
        int end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        String input = "racecar";

        long startTime, endTime;

        startTime = System.nanoTime();
        boolean result1 = stackMethod(input);
        endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        startTime = System.nanoTime();
        boolean result2 = dequeMethod(input);
        endTime = System.nanoTime();
        long dequeTime = endTime - startTime;

        startTime = System.nanoTime();
        boolean result3 = twoPointerMethod(input);
        endTime = System.nanoTime();
        long twoPointerTime = endTime - startTime;

        System.out.println("Input : " + input);
        System.out.println("Stack Result : " + result1 + " | Time : " + stackTime + " ns");
        System.out.println("Deque Result : " + result2 + " | Time : " + dequeTime + " ns");
        System.out.println("Two Pointer Result : " + result3 + " | Time : " + twoPointerTime + " ns");
    }
}