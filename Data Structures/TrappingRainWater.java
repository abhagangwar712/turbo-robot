import java.util.Scanner;

public class TrappingRainWater {
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    waterTrapped += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    waterTrapped += rightMax - height[right];
                }
                right--;
            }
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the height array: ");
        int n = scanner.nextInt();
        int[] height = new int[n];

        System.out.println("Enter the elements of the height array: ");
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }

        int result = trap(height);
        System.out.println("Water trapped: " + result + " units");

        scanner.close();
    }
}
