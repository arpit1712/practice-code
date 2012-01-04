public class Ans5
{
	public static void main(String[] args)
	{
		LinkedList<Integer> ll = new LinkedList<Integer>();
                int[] arr = new int[]{2,3,1,4,0,5,-20,40};
                for(int element : arr)
                {
                        ll.append(element);
                }
                ll.print();
		System.out.println("Loop at element : " + ll.makeLoop());
		ll.print();
		System.out.println(ll.findStartOfLoop());
	}
}
