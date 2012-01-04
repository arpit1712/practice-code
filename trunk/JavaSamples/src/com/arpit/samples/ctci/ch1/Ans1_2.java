public class Ans1_2
{

	public static void main(String[] args)
	{
		if(args.length < 1)
		{
			System.out.println("Usage : java Ans1_1 <string1> <string2> ...");
			return;
		}
		
		Ans1_2 obj = new Ans1_2();
		for(String str : args)
		{
			System.out.println(str + " : " + obj.reverse(str));
		}
	}

	public String reverse(String str)
	{
		char[] charArr = str.toCharArray();
		for(int i = 0, j = charArr.length-1; i < j; i++, j--)
		{
			char temp = charArr[i];
			charArr[i] = charArr[j];
			charArr[j] = temp;
		}
		return new String(charArr);
	}
}
		
