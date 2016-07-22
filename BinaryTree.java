import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BinaryTree {
	
	
	public static void main(String[] args) throws IOException
	{
		long alltime1 = System.currentTimeMillis();
		Tree list = new Tree();
		System.out.println("BinaryTree_2 (輸入look,inorder,add...可以令機器做出動作)");
		int[] array = {50,60,40,22,35,99,85,64,70,88,111,102,101,23,11};
		for(int i =0;i<array.length;i++)
		{
			list.Add(array[i]);
		}
		int x,num = 0;
		String listen,L;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.print("\n請輸入需求: ");
			listen = buf.readLine();
			L = listen.toUpperCase();
			
			if(L.equals("SEE")|| L.equals("LOOK") || L.equals("WATCH"))
			{
				long starttime = System.currentTimeMillis();
				System.out.print("中:");
				list.inorder(list.rootnode);
				System.out.print("\n前:");
				list.preorder(list.rootnode);
				System.out.print("\n後:");
				list.poseorder(list.rootnode);
				long endtime = System.currentTimeMillis();
				long cu = endtime - starttime;
				System.out.print("\n機器反應時間: " +cu + " 毫秒");
			}else if("INORDER".equals(L))
			{
				long starttime = System.currentTimeMillis();
				
				list.inorder(list.rootnode);
				System.out.println("");
				long endtime = System.currentTimeMillis();
				long cu = endtime - starttime;
				System.out.print("\n機器反應時間: " +cu + " 毫秒");
			}else if("PREORDER".equals(L))
			{
				long starttime = System.currentTimeMillis();
				list.preorder(list.rootnode);
				System.out.println("");
				long endtime = System.currentTimeMillis();
				long cu = endtime - starttime;
				System.out.print("\n機器反應時間: " +cu + " 毫秒");
			}else if("POSEORDER".equals(L))
			{
				long starttime = System.currentTimeMillis();
				list.poseorder(list.rootnode);
				System.out.println("");
				long endtime = System.currentTimeMillis();
				long cu = endtime - starttime;
				System.out.print("\n機器反應時間: " +cu + " 毫秒");
			}else if("ADD".equals(L) || "INPUT".equals(L))//新增UID 
			{
				TreeNode tn = list.rootnode;
				System.out.print("新增Uid: ");
				x = Integer.parseInt(buf.readLine());
				long starttime = System.currentTimeMillis();
				list.Add(x);
				long endtime = System.currentTimeMillis();
				long cu = endtime - starttime;
				System.out.print("\n機器反應時間: " +cu + " 毫秒");
			}else if("EXIT".equals(L))
			{
				System.out.print("機器將進入休眠-----");
				long alltime2 = System.currentTimeMillis();
				long alltime = (alltime2 - alltime1)/1000;
				System.out.print("\n本程式共花費: "+alltime + " 秒");
				break;
			}
			else if("REVERSION".equals(L) || "RE".equals(L))//反印
			{
				long starttime = System.currentTimeMillis();
				if(list.down ==null)
				{
					System.out.print("請先讓機器做出 'preorder'或 'see' 類似判斷以進行更新");
				}else
				{
					while(num != -1)
					{
						num = list.repop();
					}
				}
				long endtime = System.currentTimeMillis();
				long cu = endtime - starttime;
				System.out.print("\n機器反應時間: " +cu + " 毫秒");
			}else if("SEARCH".equals(L))//搜尋
			{
				System.out.print("要搜尋的uid: ");
				x = Integer.parseInt(buf.readLine());
				long starttime = System.currentTimeMillis();
				list.search(x);
				long endtime = System.currentTimeMillis();
				long cu = endtime - starttime;
				System.out.print("\n機器反應時間: " +cu + " 毫秒");
			}else if("HI".equals(L) || "HELLO".equals(L))
			{
				System.out.print("(機器對著你點了點頭) ");
			}else if("DELETE".equals(L) || "KILL".equals(L) || "D".equals(L))//刪除UID節點(二元數)
			{
				System.out.print("要刪除的Uid(節點刪除): ");
				x = Integer.parseInt(buf.readLine());
				list.Delete(x);
				
			}else if("FUCK".equals(L) || "FK".equals(L))
			{
				System.out.print(listen);
			}else if("PRINT".equals(L))
			{
				list.print();
			}else if("LEVEL".equals(L))
			{
				System.out.print("此樹的階乘 " + list.Tree_level +"層");
			}else
			{
				if(num<2)
				{
					System.out.println("(機器表示無法理解你的意思...)");
					num++;
				}else if(num>=2&&num <4)
				{
					System.out.println("(機器好像生氣了!!)");
					num++;
				}else if(num>=4)
				{
					System.out.println("(機器不想理你)");
					num=0;
				}		
			}
			
		}
	}


}
