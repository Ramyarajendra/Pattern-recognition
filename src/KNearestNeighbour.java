import java.util.*;
import java.io.*;
public class KNearestNeighbour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double train[][]=new double[90][4];
		double test[][]=new double[60][4];
		Scanner sc=new Scanner(System.in);
		try {
			BufferedReader fp=null;
			 fp=new BufferedReader(new FileReader(("test.txt")));
			BufferedReader fp1=null;
			fp1=new BufferedReader(new FileReader(("train.txt")));
			String c;
			String arr[]=new String[100];
			int classtest[]=new int[60];
			int classtrain[]=new int[90];
			System.out.println("test");
			for(int i=0; ((c=fp.readLine())!=null)&& (i<60);i++)
			{
					String s1[]=c.split(",");
					String s2[]=new String[4];
					for(int k=0;k<4;k++)
					{
						s2[k]=s1[k];
					}
					for(int j=0;j<s2.length;j++)
					{
							test[i][j]=Double.parseDouble(s2[j]);
							System.out.print(test[i][j]+" ");
					}
					classtest[i]=Integer.parseInt(s1[4]);
					System.out.print(" "+classtest[i]);
					System.out.println();
			}
			
			System.out.println("train");
			for(int i=0;( (c=fp1.readLine())!=null)&&(i<90);i++)
			{
					String s1[]=c.split(",");
					String s2[]=new String[4];
					for(int k=0;k<4;k++)
					{
						s2[k]=s1[k];
					}
					for(int j=0;j<s2.length;j++)
					{
						train[i][j]=Double.parseDouble(s2[j]);
							System.out.print(train[i][j]+" ");
							
					}
					classtrain[i]=Integer.parseInt(s1[4]);
					System.out.print(" "+classtrain[i]);
					System.out.println();
			}
			double dist=0;
			int corr=0;
			for(int i=0;i<60;i++)
			{
				LinkedHashMap<Double,Integer> h=new LinkedHashMap<Double,Integer>();
				for(int j=0;j<90;j++)
				{
					dist=0;
					for(int k=0;k<4;k++)
					{
						//System.out.print(train[j][k]+" ");
						//System.out.print(test[i][k]+" ");
						dist=dist+ Math.pow((train[j][k]-test[i][k]),2);
					}
					
					dist=Math.sqrt(dist);
					h.put(dist,classtrain[j]);
				}
				//Arrays.sort(distances);
				//System.out.println("enter value of k");
				//for(double key:h.keySet())
					//System.out.println(key +" "+h.get(key));
				ArrayList<Double> a=new ArrayList<Double>(h.keySet());
				Collections.sort(a);
				//for(double s:a)
					//System.out.println(s);
				int k=3;
				System.out.println("k nearest distances for test pattern "+(i+1));
				int freq1=0,freq2=0,freq3=0;
				for(Double d:a)
				{
					System.out.println("distance "+d+" class "+h.get(d));
					k--;
				
					if(h.get(d)==1)
						freq1++;
					else if(h.get(d)==2)
						freq2++;
					else if(h.get(d)==3)
						freq3++;
					if(k==0)
						break;
				}
				int d=max(freq1,freq2,freq3);
				System.out.println("classified as class "+d);
				if(d==classtest[i])
					corr++;
			}
			System.out.println(corr);
			double ca=((double)corr/60)*100;
			System.out.println("classification accuracy "+ca);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static int max(int a,int b,int c)
	{
		if(a>b)
		{
			if(a>c)
			{
				return 1;
			}
			else
				return 3;
		}
		else if(b>c)
		{
			return 2;
		}
		else
			return 3;
	}		
}



