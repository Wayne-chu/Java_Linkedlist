

class Node
{
	int Uid;
	Node next;
	public Node(int Uid)
	{
		this.Uid = Uid;
		this.next = null;
	}
}
class TreeNode
{
	int Uid;
	TreeNode left_node;
	TreeNode right_node;
	public TreeNode(int Uid)
	{
		this.Uid = Uid;
		this.left_node = null;
		this.right_node = null;
	}
}
public class Tree {
	public TreeNode rootnode;
	public Node top;
	public Node down;
	public int Tree_level =0;
	
	public void Add(int Uid)
	{
		int level = 1;
		TreeNode current = rootnode;
		TreeNode newnode = new TreeNode(Uid);
		if(rootnode == null) rootnode = newnode;
		else
		{
			while(true)
			{
				if(newnode.Uid > current.Uid)
				{
					if(current.right_node == null)
					{
						current.right_node = newnode;
						level ++;
						if(Tree_level > level)
						{
							return;
						}else
						{
							Tree_level = level;
						}
						
						return;
					}else
					{
						current = current.right_node;
						level ++;
					}
				}else
				{
					if(current.left_node == null)
					{
						current.left_node = newnode;
						level += 1;
						if(Tree_level > level)
						{
							return;
						}else
						{
							Tree_level = level;
						}
						return;
					}else
					{ 
						current = current.left_node;
						level += 1;
					}
				}
			}
		}
		if(Tree_level > level)
		{
			return;
		}else
		{
			Tree_level = level;
		}
	}
	//*****************************************
	public void Delete(int Uid)
	{
		TreeNode tmp = rootnode;
		while(true)
		{
			if(Uid == tmp.Uid)
			{
				tmp = null;
			}else//******
			{
				if(Uid > tmp.Uid)//右
				{
					try
					{
						if(tmp.right_node.Uid == Uid)
						{
							tmp.right_node = null;
							System.out.print("以刪除UID: "+ Uid);
							return;
						
						}else if(tmp.right_node !=null)
						{
							tmp = tmp.right_node;
						}
					}catch(Exception e)
					{
						System.out.print("以機器無與倫比的魅力，發現裡面並沒有您的數字...");
						break;
					}
				}else
				{
					try
					{
						if(tmp.left_node.Uid == Uid)
						{
							tmp.left_node = null;
							System.out.print("以刪除UID: "+ Uid);
							return;
						
						}else if(tmp.left_node !=null)
						{
							tmp = tmp.left_node;
						}
					}catch(Exception e)
					{
						System.out.print("以機器無與倫比的魅力，發現裡面並沒有您的數字...");
						break;
					}
				}
			}
		}
	}
	//********************************************
	public void rebstack(int Uid)//反轉stack
	{
		Node newnode = new Node(Uid);
		if(top == null)
		{
			top = newnode;
			down = newnode;
		}
		else
		{
			top.next = newnode;
			top = newnode;
		}
	}
	public int repop()//反轉print
	{
		
		Node current = down;
		if(current != top)
		{
			while(current.next != top)
			{
				current = current.next;
			}
			System.out.print("[" + top.Uid + "]");
			current.next = top.next;
			top = current;
			return 0;
		}else
		{
			System.out.print("[" + top.Uid + "]");
			return -1;
		}
		
	}
	public void inorder(TreeNode node)
	{
		if(node != null)
		{
			
				inorder(node.left_node);
				System.out.print("[" + node.Uid+"]");
				rebstack(node.Uid);
				inorder(node.right_node);
			
		}
	}
	public void preorder(TreeNode node)
	{
		if(node != null)
		{
			System.out.print("[" + node.Uid+"]");
			preorder(node.left_node);
			preorder(node.right_node);
		}
	}
	public void poseorder(TreeNode node)
	{
		if(node  != null)
		{
			poseorder(node.left_node);
			poseorder(node.right_node);
			System.out.print("[" + node.Uid+"]");
		}
	}
//********************************************************
	public void search(int Uid)//搜尋
	{
		int x = 0;
		TreeNode sh = rootnode;
		if(rootnode.Uid == Uid)
		{
			System.out.print("以查詢..翻查" + x + " 筆資料 您的資料在第 " + (x+1) + " 筆");
		}else
		{
			x++;
			while(true)
			{
				if(Uid > sh.Uid)//右子樹
				{
					try
					{
						if(sh.right_node.Uid == Uid)
						{
							System.out.print("以查詢..翻查" + x + " 筆資料 您的資料在第 " + (x+1) + " 筆");
							return;
						}else if(sh.right_node !=null)
						{
							sh = sh.right_node;
							x++;
						}
					}catch(Exception e)
					{
						System.out.print("以機器無與倫比的智力，發現裡面並沒有您的數字...");
						break;
					}
				}else if(Uid < sh.Uid)
				{
					try
					{
						if(sh.left_node.Uid == Uid)
						{
							System.out.print("以查詢..翻查" + x + " 筆資料 您的資料在第 " + (x+1) + " 筆");
							return;
						}else if(sh.left_node !=null)
						{
							sh = sh.left_node;
							x++;
						}
					}catch(Exception e)
					{
						System.out.print("以機器無與倫比的魅力，發現裡面並沒有您的數字...");
						break;
					}
				}
			}
		}
	}
	public void print()
	{
		space(2*Tree_level,rootnode);
	}
	public int space(int s,TreeNode node_print)
	{
		try
		{
			if(s>=0)
			{
				System.out.print("  ");
				return space(s-1,rootnode);
			}else
			{
				System.out.print(s);
				System.out.println();
				return space(2*Tree_level-3,rootnode.left_node);
			}
		}catch(Exception e)
		{
			System.out.print("未完成的指令...");
			return 0;
		}
	}
	
}
