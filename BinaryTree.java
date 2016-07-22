import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BinaryTree {
	
	
	public static void main(String[] args) throws IOException
	{
		long alltime1 = System.currentTimeMillis();
		Tree list = new Tree();
		System.out.println("BinaryTree_2 (��Jlook,inorder,add...�i�H�O�������X�ʧ@)");
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
			System.out.print("\n�п�J�ݨD: ");
			listen = buf.readLine();
			L = listen.toUpperCase();
			
			if(L.equals("SEE")|| L.equals("LOOK") || L.equals("WATCH"))
			{
				long starttime = System.currentTimeMillis();
				System.out.print("��:");
				list.inorder(list.rootnode);
				System.out.print("\n�e:");
				list.preorder(list.rootnode);
				System.out.print("\n��:");
				list.poseorder(list.rootnode);
				long endtime = System.currentTimeMillis();
				long cu = endtime - starttime;
				System.out.print("\n���������ɶ�: " +cu + " �@��");
			}else if("INORDER".equals(L))
			{
				long starttime = System.currentTimeMillis();
				
				list.inorder(list.rootnode);
				System.out.println("");
				long endtime = System.currentTimeMillis();
				long cu = endtime - starttime;
				System.out.print("\n���������ɶ�: " +cu + " �@��");
			}else if("PREORDER".equals(L))
			{
				long starttime = System.currentTimeMillis();
				list.preorder(list.rootnode);
				System.out.println("");
				long endtime = System.currentTimeMillis();
				long cu = endtime - starttime;
				System.out.print("\n���������ɶ�: " +cu + " �@��");
			}else if("POSEORDER".equals(L))
			{
				long starttime = System.currentTimeMillis();
				list.poseorder(list.rootnode);
				System.out.println("");
				long endtime = System.currentTimeMillis();
				long cu = endtime - starttime;
				System.out.print("\n���������ɶ�: " +cu + " �@��");
			}else if("ADD".equals(L) || "INPUT".equals(L))//�s�WUID 
			{
				TreeNode tn = list.rootnode;
				System.out.print("�s�WUid: ");
				x = Integer.parseInt(buf.readLine());
				long starttime = System.currentTimeMillis();
				list.Add(x);
				long endtime = System.currentTimeMillis();
				long cu = endtime - starttime;
				System.out.print("\n���������ɶ�: " +cu + " �@��");
			}else if("EXIT".equals(L))
			{
				System.out.print("�����N�i�J��v-----");
				long alltime2 = System.currentTimeMillis();
				long alltime = (alltime2 - alltime1)/1000;
				System.out.print("\n���{���@��O: "+alltime + " ��");
				break;
			}
			else if("REVERSION".equals(L) || "RE".equals(L))//�ϦL
			{
				long starttime = System.currentTimeMillis();
				if(list.down ==null)
				{
					System.out.print("�Х����������X 'preorder'�� 'see' �����P�_�H�i���s");
				}else
				{
					while(num != -1)
					{
						num = list.repop();
					}
				}
				long endtime = System.currentTimeMillis();
				long cu = endtime - starttime;
				System.out.print("\n���������ɶ�: " +cu + " �@��");
			}else if("SEARCH".equals(L))//�j�M
			{
				System.out.print("�n�j�M��uid: ");
				x = Integer.parseInt(buf.readLine());
				long starttime = System.currentTimeMillis();
				list.search(x);
				long endtime = System.currentTimeMillis();
				long cu = endtime - starttime;
				System.out.print("\n���������ɶ�: " +cu + " �@��");
			}else if("HI".equals(L) || "HELLO".equals(L))
			{
				System.out.print("(������ۧA�I�F�I�Y) ");
			}else if("DELETE".equals(L) || "KILL".equals(L) || "D".equals(L))//�R��UID�`�I(�G����)
			{
				System.out.print("�n�R����Uid(�`�I�R��): ");
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
				System.out.print("���𪺶��� " + list.Tree_level +"�h");
			}else
			{
				if(num<2)
				{
					System.out.println("(������ܵL�k�z�ѧA���N��...)");
					num++;
				}else if(num>=2&&num <4)
				{
					System.out.println("(�����n���ͮ�F!!)");
					num++;
				}else if(num>=4)
				{
					System.out.println("(�������Q�z�A)");
					num=0;
				}		
			}
			
		}
	}


}
