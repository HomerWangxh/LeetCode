/**
 *  the 1 - 10 questions of the leetcode
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * 1.Two Sum 
		 * Input : { 3,2,4}} Output : [2,3]
		 */
		int[] nums = { 3, 2, 4 };
		for (int i : twoSum(nums, 6)) {
			System.out.println(i + " ");
		}

		/*
		 * 2.Add Two Numbers 
		 * Input : [5,5,5] [5,5,5] Output : [0,1,1,1]
		 */
		ListNode l1 = new ListNode(5);
		l1.next = new ListNode(5);
		l1.next.next = new ListNode(5);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(5);
		l2.next.next = new ListNode(5);
		addTwoNumbers(l1, l2);

		/*
		 * 3.Longest Substring Without Repeating Characters 
		 * Input : "abcabcbb"
		 * Output : 3 Consider of very long String(Time Limit)
		 */
		System.out.println(lengthOfLongestSubstring("abcabcbb"));

		/*
		 * 4.Median of Two Sorted Arrays 
		 * Input : { 1 } { 1,2,3,4} Output : 2.0
		 */
		int[] nums1 = { 1 };
		int[] nums2 = { 1, 2, 3, 4 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
		
		/*
		 * 6. ZigZag Conversion
		 * Input : "PAYPALISHIRING", 3(can change from 1 - 6 for test)
		 * OutPut : "PAHNAPLSIIGYIR"
		 */
		String s = "PAYPALISHIRING";
		System.out.println(s + " convert to " + convert(s , 3));
		
		/*
		 * 7. Reverse Integer
		 * Input  x = 123, return 321
         * Input  x = -123, return -321
		 */
		System.out.println(reverse(-123));
		
		/*
		 * 8. String to Integer (atoi)
		 * Input : "     -0000013213.9" Output : -13213 
		 */
		String s1 = "     -0000013213.9";
		System.out.println(myAtoi(s1));
		
	}

	/**
	 * Solution : make a searching loop to find the two nums' sum equals target
	 */
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i + 1;
					result[1] = j + 1;
					return result;
				}
			}
		}
		return result;
	}

	/**
	 * Solution : l1 and l2 's next are not null -> l1's next is null -> 
	 * l2's next is null -> consider the reminder
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sumVal = l1.val + l2.val;
		int yu = 0;
		if (sumVal > 9) {
			yu = 1;
			sumVal = sumVal % 10;
		}
		ListNode sum = new ListNode(sumVal);
		ListNode temp = sum;
		l1 = l1.next;
		l2 = l2.next;
		while (l1 != null && l2 != null) {
			sumVal = l1.val + l2.val + yu;
			if (sumVal > 9) {
				yu = 1;
				sumVal = sumVal % 10;
			}
			if (l1 != null && l2 != null) {
				temp.next = new ListNode(sumVal);
				l1 = l1.next;
				l2 = l2.next;
			}
			temp = temp.next;
		}
		while (l2 != null) {
			temp.next = new ListNode(l2.val + yu);
			yu = 0;
			l2 = l2.next;
			temp = temp.next;
			continue;
		}
		while (l1 != null) {
			temp.next = new ListNode(l1.val + yu);
			yu = 0;
			l1 = l1.next;
			temp = temp.next;
			continue;
		}
		if (yu != 0) {
			temp.next = new ListNode(yu);
		}
		return sum;
	}

	/**
	 * Solution : the longest substring without repeating letters(Considering
	 * the very long String testcase and suitable data structure)
	 */
	public static int lengthOfLongestSubstring(String s) {
		int len = 0;
		for (int i = 0; i < s.length(); i++) {
			HashSet<Character> sb = new HashSet<Character>();
			String str = s.substring(i);
			for (int j = 0; j < str.length(); j++) {
				if (!sb.contains(str.charAt(j))) {
					sb.add(str.charAt(j));
					if (sb.size() > len) {
						len = sb.size();
					}
					if (sb.size() > 94) {
						return sb.size();
					}
				} else {
					break;
				}
			}
		}
		return len;
	}

	/**
	 * Solution : new a int array that it's length is m+n,and put the two arrays
	 * in it by order
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median = 0.0d; // Median
		int m = nums1.length;
		int n = nums2.length;
		boolean isOdd = true; // the length is Odd or Even

		if ((m + n) % 2 == 0) {
			isOdd = false;
		}

		int[] nums = new int[m + n];
		int i = 0;
		int j = 0;
		for (int x = 0; x < m + n; x++) {
			if (j >= n) {
				nums[x] = nums1[i];
				i++;
				continue;
			}
			if (i < m && nums1[i] <= nums2[j]) {
				nums[x] = nums1[i];
				i++;
				continue;
			} else if (j < n) {
				nums[x] = nums2[j];
				j++;
				continue;
			}
		}
		if (isOdd) {
			median = nums[(m + n) / 2];
		} else {
			median = nums[(m + n) / 2] + nums[(m + n) / 2 - 1];
			median = (double) median / 2;
		}
		return median;
	}

	/**
	 * Solution : make a two-dimensional array to hold the String and convert it, then
	 * return the result
	 */
	public static String convert(String s, int numRows) {
		//if the rowNum is 1 , return the s directly
        if(numRows == 1){
            return s;
        }
        
       	int len = s.length();
		int line = 0;
		int x = 2 * (numRows - 1);
		int div = len / x;
		int mod = len % x;
	    //according to the numRows and the s.length , calculate the line.
     	if (mod == 0) {
			line = (numRows - 1) * div;
		} else if (mod <= numRows) {
			line = (numRows - 1) * div + 1;
		} else {
			line = (numRows - 1) * div + (mod - numRows + 1);
		}
     	
     	//make the two-dimensional array to hold the convert String
		String[][] str = new String[numRows][line];
		int index = 0;

		for (int i = 0; i < line; i++) {
			for (int j = 0; j < numRows; j++) {
				int y = i % (numRows - 1);
				if (index / numRows > 0 && y != 0) {
					str[numRows - 1 - y][i] = s.charAt(index) + "";
					index++;
					break;
				}
				if (index < len) {
					str[j][i] = s.charAt(index) + "";
					index++;
				}
			}
		}
		//Convert the two-dimensional array into String and return it
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < line; j++) {
				if (str[i][j] != null) {
					sb.append(str[i][j]);
				}
			}
		}
		return sb.toString();
    }

	/**
	 * Solution : Considering the input situation of minus and overflow
	 */
	public static int reverse(int x) {
		int isMinus = 1;
		StringBuffer sb = new StringBuffer();
		String str = x + "";
		if (str.startsWith("-")) {
			isMinus = -1;
			str = str.substring(1);
		}
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(str.length() - i - 1));
		}
		try {
			x = Integer.parseInt(sb.toString()) * isMinus;
		} catch (Exception e) {
			return 0;
		}
		return x;
	}

	/**
	 * Solution : Considering the space and minus in the head of the string and 
	 * the other character in the middle of the String
	 */
	public static int myAtoi(String str) {
		int result = 0;
		if (str.equals("")) {
			return result;
		}
		int x = 0;
		int n = 0;
		char head = str.charAt(0);
		try {
			while (head == '0' || head == ' ' || head == '\t') {
				str = str.substring(1);
				head = str.charAt(0);
			}
			if (head == '-' || head == '+') {
				n = 1;
			}
			for (int i = n; i < str.length(); i++) {
				x = Integer.parseInt(str.charAt(i) + "");
				if (x >= 0 && x < 10) {
					String temp = str.substring(0, i + 1);
					result = (int) Double.parseDouble(temp);
				} else {
					break;
				}
			}
		} catch (Exception e) {
			return result;
		}
		return result;
	}


}
