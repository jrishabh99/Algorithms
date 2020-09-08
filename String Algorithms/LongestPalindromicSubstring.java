import java.util.*;
class LongestPalindromicSubstring {

	public static String longestPalindrome(String str) {


		StringBuilder sb = new StringBuilder("$#");
		for(char c : str.toCharArray()) {
			sb.append(c+"#");
		}
		sb.append("@");
		int len = sb.length();
		int c = 0;
		int r = 0;
		int[] p = new int[len];
		int maxIndex = 1;
		for (int i = 1; i < len - 1; i++) {
			// calculate the mirror position
			int mirror = 2 * c - i;
			// if index lies within range
			if (i < r) {
				p[i] = Math.min(p[mirror], r - i);
			}
			// extend the String
			while(sb.charAt(i + p[i] + 1) == sb.charAt(i - p[i] - 1))
				p[i]++;

			if(p[maxIndex] < p[i])
				maxIndex = i;

			// update the center and right pointers
			if(i + p[i] > r) {
				r = i + p[i];
				c = i;
			}
		}
		String ans = sb.substring(maxIndex - p[maxIndex], maxIndex + p[maxIndex] + 1);
		ans = ans.replace("#","");
		return ans;
	}
	public static void main(String[] args) {
		String str = "abbabaaba";
		System.out.println(longestPalindrome(str));
	}
}