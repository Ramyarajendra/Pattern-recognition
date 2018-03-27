import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;
public class CondensedNearestNeighbour {
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
				double train[][]=new double[11][2];
				double test[][]=new double[60][4];
				int classtrain[]=new int[11];
				double condensed[][]=new double[11][2];
				Scanner sc=new Scanner(System.in);
				for(int i=0;i<11;i++)
				{
					for(int j=0;j<2;j++)
					{
						train[i][j]=sc.nextDouble();
					}
					classtrain[i]=sc.nextInt();
				}
				System.out.println("train");
				for(int i=0;i<11;i++)
				{
					for(int j=0;j<2;j++)
					{
						System.out.print(train[i][j]+" ");
						condensed[0][j]=train[0][j];
					}
					System.out.println(classtrain[i]);
				}
				double reduced[][]=new double[11][2];
				Set condensedSet=new HashSet();
				condensedSet.add(classtrain[0]);
				for(int i=0;i<10;i++)
				{
					for(int j=0;j<2;j++)
					{
						
						reduced[i][j]=train[i+1][j]-condensed[i+1][j];
						System.out.print(reduced[i][j]+" ");
					}
					System.out.println();
				}
				LinkedHashMap<Double,Integer> h=new LinkedHashMap<Double,Integer>();
				for(int i=0;i<10;i++)
				{
					double dist=0;
					int k=0;
					for(int j=0;j<2;j++)
					{
						dist=dist+Math.pow((reduced[i][j]-condensed[k][j]),2);
					}
					dist=Math.sqrt(dist);
					System.out.println(dist);
					h.put(dist,classtrain[i]);
				}
				ArrayList<Double> a=new ArrayList<Double>(h.keySet());
				Collections.sort(a);
				for(double key:a)
				{
					System.out.println(key+" "+h.get(key));
				}
	}
}
