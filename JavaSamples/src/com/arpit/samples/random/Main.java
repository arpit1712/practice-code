import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Main m = new Main();
		//m.linkedListTest();
		//m.treeTest(args);
        m.hashtableTest();
	}

    public void hashtableTest()
    {
        Hashtable<String, String> map = new Hashtable<String, String>();
        int[] keys = {10,20,30,40,50, 60};
        String[] vals = {"arpit", "abhi", "shobha", "subbu", "prash", "pinks"};
        for(int i = 0; i < keys.length; i++)
        {
            map.put(vals[i], UUID.randomUUID().toString());
        }
        System.out.println("-----------GET VALUE-----------------");
        for(String v : vals)
        {
            System.out.println(v + " : " + map.get(v));
        }
        System.out.println("-----------PRINT TABLE-----------------");
        map.print();
    }

	public void treeTest(String[] args)
	{
		if(args.length == 0) return;
        int x = Integer.parseInt(args[0]);
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		int[] arr = {20, 15, 25, 32, 14, 11, 16, 26, 31, 3,2,1,4,5};
		for(int a : arr)
		{
			tree.insert(a);
		}
		System.out.println("Recursive Inorder : " + tree.traverseInorder());

		List<Integer> inorder = tree.traverseInorderIter();
		System.out.print("Iterative Inorder : ");
		for(int i : inorder)
		{
			System.out.print(i + " ");
		}
		System.out.println();

		List<Integer> preorderRec = tree.traversePreorder();
		System.out.print("Recursive Preorder : ");
		for(int i : preorderRec)
                {
                        System.out.print(i + " ");
                }
                System.out.println();


		List<Integer> preorder = tree.traversePreorderIter();
		System.out.print("Iterative Preorder : ");
		for(int i : preorder)
		{
			System.out.print(i + " ");
		}
		System.out.println();

		List<Integer> postorderRec = tree.traversePostorder();
                System.out.print("Recursive PostOrder : ");
                for(int i : postorderRec)
                {
                        System.out.print(i + " ");
                }
                System.out.println();


		List<Integer> postorder = tree.traversePostorderIter();
                System.out.print("Iterative PostOrder : ");
                for(int i : postorder)
                {
                        System.out.print(i + " ");
                }
                System.out.println();


		List<Integer> ancestors = tree.getAncestors(x);
		System.out.print("Ancestors of x = ");
		for(Integer a : ancestors)
		{
			System.out.print(a + " ");
		}
		System.out.println();

		System.out.println("Level of x = " + tree.getLevel(x));

		System.out.println("Inorder Successor of x = " + tree.findInorderSuccessor(x));
		
	}

	public void linkedListTest()
	{
		LinkedList<Integer> ll = new LinkedList<Integer>();
		int[] arr = {1,2,3,4,5};
		for(int a : arr)
		{
			ll.append(a);
		}
		System.out.println(ll.findLoop());
		ll.makeLoop();
		System.out.println(ll.findLoop());
	}
}
