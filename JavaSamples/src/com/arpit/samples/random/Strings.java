import java.util.*;

public class Strings
{
    public static void main(String[] args)
    {
        substringTest(args);
        //reverseTest(args);
        //permuteTest(args);
    }

    private static void substringTest(String[] args)
    {
        if(args.length < 2) return;
        System.out.println(args[0] + " occurs inside " + args[1] + " at position = " + Strings.substring(args[0], args[1]));
        System.out.println(args[0] + " occurs inside " + args[1] + " at position = " + Strings.findMatch(args[1], args[0]));
    }

    private static void reverseTest(String[] args)
    {
        if(args.length < 1) return;
        for(String str : args)
        {
            System.out.println(str + " : reversed = " + Strings.reverse(str));
            System.out.println(str + " : reverse words = " + Strings.reverseWords(str));

        }
     }

     private static void permuteTest(String[] args)
     {
            if(args.length < 1) return;
        for(String str : args)
        {
            List<String> allPerms = Strings.permute(str);
            System.out.println("All Permutations : ");
            for(String s : allPerms)
            {
                System.out.print("\t" + s);
            }
            System.out.println();
        }
    }

    public static int findMatch(String text, String pattern)
    {
        int tLen = text.length();
        int pLen = pattern.length();

        for(int i = 0; i < tLen - pLen + 1; i++)
        {
            int j = 0;
            while(j < pLen && text.charAt(i+j) == pattern.charAt(j))
            {
                j++;
            }
            if(j == pLen)   return i;
        }
        return -1;
    }

    public static List<String> permute(String str)
    {
        List<String> allPerms = new ArrayList<String>();
        if(str.length() == 1)
        {
            allPerms.add(str);
            return allPerms;
        }
            String first = str.substring(0, 1);
            String last = str.substring(1);
            place(allPerms, first, permute(last));
        return allPerms;
    }

    private static void place(List<String> allPerms, String first, List<String> bunch)
    {
        for(String s : bunch)
        {
            for(int i = 0; i <= s.length(); i++)
            {
                allPerms.add(s.substring(0,i) + first + s.substring(i));
            }
        }
    }

    public static String reverse(String str)
    {
        char[] arr = str.toCharArray();
        reverse(arr, 0, arr.length - 1);
        return new String(arr);
    }

    private static void reverse(char[] arr, int start, int end)
    {
        for(; start < end; start++, end--)
        {
            swap(arr, start, end);
        }
    }

    private static void swap(char[] arr, int i , int j)
    {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static String reverseWords(String str)
    {
        String reversed = Strings.reverse(str);
        char[] arr = reversed.toCharArray();
        int lastLocation = 0;
        for(int i = 0, j = arr.length; i < j; i++)
        {
            if(arr[i] == ' ')
            {
                reverse(arr, lastLocation, i - 1);
                i++;
                lastLocation = i;
            }
        }
        reverse(arr, lastLocation, arr.length - 1);
        return new String(arr);
    }

    /**
    * returns starting index of substring occurrence
    */
    public static int substring(String needle, String haystack)
    {
        char[] narray = needle.toCharArray();
        char[] harray = haystack.toCharArray();

        for(int i = 0; i < harray.length - narray.length + 1; i++)
        {
            int j = 0;
            for(; j < narray.length && narray[j] == harray[i+j]; j++);
            if(j == narray.length)  return i;
        }

        return -1;
    } 
}
