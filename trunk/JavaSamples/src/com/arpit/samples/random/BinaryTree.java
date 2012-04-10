import java.util.*;

public class BinaryTree<T extends Comparable<T>>
{
	protected class Node
	{
		T data;
		Node left = null;
		Node right = null;
		public Node(T data)
		{
			this.data = data;
		}
	}
	protected Node root = null;
	
	public void insert(T data)
	{
		Node newNode = new Node(data);
		if(root == null)
		{
			root = newNode;
			return;
		}

		Node copy = root;
		Node prvs = null;
		while(copy != null)
		{
			prvs = copy;
			if(data.compareTo(copy.data) < 0)
			{
				copy = copy.left;
			}
			else
			{
				copy = copy.right;
			}
		}
		if(data.compareTo(prvs.data) < 0)
		{
			prvs.left = newNode;
		}
		else
		{
			prvs.right = newNode;
		}
	}

	public String traverseInorder()
	{
		StringBuilder sb = new StringBuilder();
		traverseInorder(root, sb);
		return sb.toString();
	}

	private void traverseInorder(Node aNode, StringBuilder sb)
	{
		if(aNode == null)	return;
		traverseInorder(aNode.left, sb);
		sb.append(aNode.data + " ");
		traverseInorder(aNode.right, sb);
	}

	public List<T> getAncestors(T nodeVal)
	{
		List<T> ancestors = new ArrayList<T>();
		if(nodeVal == null)	return ancestors;
		getAncestors(this.root, nodeVal, ancestors);
		return ancestors;
	}

	private boolean getAncestors(Node root, T nodeVal, List<T> ancestors)
	{
		if(root == null)
		{
			return false;
		}
		
		if(root.data.equals(nodeVal))
		{
			return true;
		}

		Node searchNode = null;
		if(root.data.compareTo(nodeVal) > 0)	searchNode = root.left;
		else	searchNode = root.right;
		if(getAncestors(searchNode, nodeVal, ancestors))
		{
			ancestors.add(root.data);
			return true;
		}
		
		return false;
	}

	public int getLevel(T data)
	{
		if(data == null)	return -1;
		return getLevel(this.root, data, 0);
	}

	private int getLevel(Node root, T data, int level)
	{
		if(root == null)	return -1;
		if(root.data.equals(data))
		{
			return level;
		}
		int left = getLevel(root.left, data, level+1);
		int right = getLevel(root.right, data, level+1);
		if(left == -1)	return right;
		return left;
	}

	public List<T> traverseInorderIter()
	{
		List<T> traversedData = new ArrayList<T>();
		Stack<Node> s = new Stack<Node>();
		Node copy = root;
		while(!s.isEmpty() || copy != null)
		{
			if(copy != null)
			{
				s.push(copy);
				copy = copy.left;
			}
			else
			{
				copy = s.pop();
				traversedData.add(copy.data);
				copy = copy.right;
			}
		}
		return traversedData;
	}

	public List<T> traversePreorder()
	{
		List<T> list = new ArrayList<T>();
		if(root != null)
			traversePreorder(root, list);
		return list;
	}

	private void traversePreorder(Node root, List<T> list)
	{
		if(root == null) return;
		list.add(root.data);
		traversePreorder(root.left, list);
		traversePreorder(root.right, list);
	}

	public List<T> traversePreorderIter()
	{
		List<T> traversedData = new ArrayList<T>();
                Stack<Node> s = new Stack<Node>();
                Node copy = root;
		s.push(root);
                while(!s.isEmpty())
		{
			Node temp = s.pop();
			traversedData.add(temp.data);
			if(temp.right != null)	s.push(temp.right);
			if(temp.left != null) s.push(temp.left);
		}
		return traversedData;
	}

	public List<T> traversePostorder()
	{
		List<T> list = new ArrayList<T>();
                if(root != null)
                        traversePostorder(root, list);
                return list;
        }

        private void traversePostorder(Node root, List<T> list)
        {
                if(root == null) return;
                traversePostorder(root.left, list);
                traversePostorder(root.right, list);
                list.add(root.data);
	}
	
	public List<T> traversePostorderIter()
	{
		List<T> traversedData = new ArrayList<T>();
                Stack<Node> s = new Stack<Node>();
                Node node = root;
		while(true)
		{
			if(node != null)
			{
				if(node.right != null)	
				{
					s.push(node.right);
				}
				s.push(node);
				node = node.left;
				continue;
			}
			
			if(s.isEmpty())
				break;
			
			node = s.pop();
			if(node.right != null && !s.isEmpty() && s.peek() == node.right)
			{
				s.pop();
				s.push(node);
				node = node.right;
			}
			else
			{
				traversedData.add(node.data);
				node = null;
			}
		}
		return traversedData;
	}

	public T findInorderSuccessor(T val)
	{
		Node node = root;
		Node successor = null;
		while(node != null)
		{
			if(val.compareTo(node.data) < 0)
			{
				successor = node;
				node = node.left;
			}
			else if(val.compareTo(node.data) > 0)
			{
				node = node.right;
			}
			else	//equals
			{
				if(node.right != null)
				{
					return findMin(node.right);
				}
				else
				{
					break;
				}
			}
		}
		if(successor != null)
		{
			return successor.data;
		}
		return null;
	}

	private T findMin(Node root)
	{
		if(root == null)	return null;
		while(root.left != null)
		{
			root = root.left;
		}
		return root.data;
	}

}
