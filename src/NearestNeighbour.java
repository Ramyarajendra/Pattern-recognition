
import java.util.*;
import java.io.*;
public class NearestNeighbour {
	public static void main(String[] args) 
	{
		double train[][]=new double[90][4];
		double test[][]=new double[60][4];
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
					System.out.print(i+1+"  ");
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
					System.out.print(i+1+"  ");
					for(int j=0;j<s2.length;j++)
					{
						train[i][j]=Double.parseDouble(s2[j]);
							System.out.print(train[i][j]+" ");
							
					}
					classtrain[i]=Integer.parseInt(s1[4]);
					System.out.print(" "+classtrain[i]);
					System.out.println();
			}
			double corr=0;
			int index=0;
			double mindist=0,dist=0;
			for(int i=0;i<60;i++)
			{
				mindist=1000.0;
				index=0;
				System.out.println("test pattern "+(i+1));
				for(int j=0;j<90;j++)
				{
					dist=0;
					for(int k=0;k<4;k++)
					{
						dist=dist+(Math.pow((train[j][k]-test[i][k]),2));
					}
					dist=Math.sqrt(dist);
					if(dist<mindist)
					{
						mindist=dist;
						index=j;
						//System.out.println(classtrain[index]);
					}
				}
				if(classtest[i]==classtrain[index])
				{
						corr++;
				}
				System.out.println("mindist "+mindist);
				System.out.println("training pattern "+(index+1)+" class "+classtrain[index]);
				System.out.println();
			}
			System.out.println(corr);
			double ca=(corr/60)*100;
			System.out.println("classification accuracy "+ca);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
