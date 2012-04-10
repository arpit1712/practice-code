import java.util.*;

public class Trie
{
    private class Node
    {
        char value;
        HashMap<Character, Node> charMap = new HashMap<Character, Node>();
        boolean isBranchNode;

        public Node(char value, boolean isBranchNode)
        {
            this.value = value;
            this.isBranchNode = isBranchNode;
        }

        public Node(){}
    }

    private Node root = new Node();

    public Trie()
    {
        this.root.isBranchNode = true;
    }

    public void insert(String s)
    {
        Node crawl = root;
        for(int i = 0; i < s.length(); i++)
        {
            Node nextNode = crawl.charMap.get(s.charAt(i));
            if(nextNode == null)
            {
                nextNode = new Node(s.charAt(i), true);
                crawl.charMap.put(s.charAt(i), nextNode);
            }
            crawl = nextNode;
        }

        //mark last node as terminal node
        crawl.isBranchNode = false;
    }

    public void print()
    {
        for(Character ch : this.root.charMap.keySet())
        {
            print(this.root.charMap.get(ch));
        }
    }

    private void print(Node root)
    {
        
    }

    public boolean search(String s)
    {
        Node crawl = root;
        for(int i = 0; i < s.length(); i++)
        {
            Node nextNode = crawl.charMap.get(s.charAt(i));
            if(nextNode == null)
            {
                return false;
            }
            crawl = nextNode;
        }
        return !crawl.isBranchNode;
    }

    public static void main(String[] args)
    {
        if(args.length < 1) return;

        Trie trie = new Trie();
        String[] arr = {"This", "is", "an", "interview", "question."};
        for(String s : arr)
        {
            trie.insert(s);
        }

        System.out.println(args[0] + " : " + trie.search(args[0]));
    }
}
