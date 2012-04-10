public class IntToBin
{
	public static void main(String[] args)
	{
		if(args.length < 1)	return;
		System.out.println(Integer.toBinaryString(Integer.parseInt(args[0])));
	}
}
