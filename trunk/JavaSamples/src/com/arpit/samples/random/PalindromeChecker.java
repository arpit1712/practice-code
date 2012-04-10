public class PalindromeChecker
{
	public static void main(String[] args)
	{
		if(args.length < 1) return;
		PalindromeChecker pc = new PalindromeChecker();
		System.out.println("is Palindrome = " + pc.isPalindrome(args[0]));
	}

	public boolean isPalindrome(String str)
	{
		return isPalindrome(str, 0, str.length() - 1);
	}

	private boolean isPalindrome(String str, int start, int end)
	{
		if(start >= end) return true;
		if(str.charAt(start) == (str.charAt(end)))
		{
			return isPalindrome(str, start +1, end -1);
		}
		else
		{
			return false;
		}
	}
}
