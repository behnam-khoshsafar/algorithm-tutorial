package leetcode.container_with_most_water;

public class ContainerWithMostWater {

    public static int maxAreaBruteForce(int[] items) {
        int result = 0;
        for (int left = 0; left < items.length; left++) {
            for (int right = left + 1; right < items.length; right++) {
                int area = (right - left) * Math.min(items[left], items[right]);
                result = Math.max(result, area);
            }
        }
        return result;
    }

    public static int maxArea(int[] items) {
        int result = 0;
        int left = 0;
        int right = items.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(items[left], items[right]);
            result = Math.max(result, area);
            if (items[left] > items[right])
                right--;
            else
                left++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxAreaBruteForce(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
