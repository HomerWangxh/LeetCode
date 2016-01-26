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

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Two Sum
		 * Input : { 3,2,4}} Output : [2,3]
		 */
		int[] nums = { 3, 2, 4 };
		for (int i : twoSum(nums, 6)) {
			System.out.print(i + " ");
		}

		/*
		 * Add Two Numbers
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
		 * Longest Substring Without Repeating Characters
		 * Input : "abcabcbb" Output : 3
		 * Consider of very long String(Time Limit)
		 */
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		
	}

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
					if(sb.size() > 94){
					    return sb.size();
					}
				} else {
					break;
				}
			}
		}
		return len;
    }
}
