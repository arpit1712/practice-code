public class BinaryTreeInt extends BinaryTree<Integer>
{
    public boolean isSumTree()
    {
        return isSumTree(this.root);
    }
    
    private boolean isSumTree(Node root)
    {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
    
        int sum = 0;
        sum += getSum(root.left);
        sum += getSum(root.right);

        return (sum == root.data) && isSumTree(root.left) && isSumTree(root.right);
    }

    private int getSum(Node aNode)
    {
        if(aNode == null)   return 0;
        if(aNode.left == null && aNode.right == null)
        {
            return aNode.data;
        }
        return aNode.data * 2;
    }

    public static void main(String[] args)
    {
        BinaryTreeInt bt = new BinaryTreeInt();
        bt.insert(26);
        bt.root.left = bt.new Node(10);
        bt.root.right = bt.new Node(3);
        bt.root.left.left = bt.new Node(4);
        bt.root.left.right = bt.new Node(6);
        bt.root.right.right = bt.new Node(3);

        System.out.println(bt.traverseInorder());
        System.out.println("Is sum tree = " + bt.isSumTree());
    }

    public boolean isFoldable()
    {
        if(this.root == null)   return true;
    }
}

