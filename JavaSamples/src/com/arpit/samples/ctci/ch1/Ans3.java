public class Ans3
{
	public String removeDups(String str, boolean extraBufferAllowed)
	{
		char[] chars = str.toCharArray();
		int len = chars.length;
		if(!extraBufferAllowed)
		{
			for(int i = 0; i < len; i++)
			{
				char aChar = chars[i];
				for(int j = 0; j < i; j++)
				{
					if(chars[j] == aChar)
					{
						//shift remaining chars
						shiftCharsFromPosition(chars, j+1);
						len--;
						i--;
						break;
					}
				}
			}
			
		}
		else
		{
			throw new UnsupportedOperationException();
		}
		return new String(chars,0,len);
	}

	private void shiftCharsFromPosition(char[] str, int pos)
	{
		for(int i = pos; i < str.length; i++)
		{
			str[i-1] = str[i];
		}
	}

	public static void main(String[] args)
        {
                if(args.length < 1)
                {
                        System.out.println("Usage : java Ans3 <string1> <string2> ...");
                        return;
                }

                Ans3 obj = new Ans3();
                for(String str : args)
                {
                        System.out.println(str + " : " + obj.removeDups(str, false));
                }
        }		
}
