package projetschedule;

import java.util.*;
// code d'exemple multi entré manuelle
public class Job
{
  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the number of Jobs");
    int n=sc.nextInt();
    String a[]=new String[n];
    int b[]=new int[n];
    int c[]=new int[n];
    for(int i=0;i<n;i++)
    {
      System.out.println("Jobs");
      a[i]=sc.next();
      System.out.println("Operations");
      b[i]=sc.nextInt();
      System.out.println("Durée");
      c[i]=sc.nextInt();
    }
    System.out.println("--Arranged Order--");
    System.out.print("Jobs:    ");
    for(int i=0;i<n;i++)
    {
      System.out.print(a[i]+" ");
    }
    System.out.println();
    System.out.print("priorités:  ");
    for(int i=0;i<n;i++)
    {
      System.out.print(b[i]+" ");
    }
    System.out.println();
    System.out.print("Durée:");
    for(int i=0;i<n;i++)
    {
      System.out.print(c[i]+" ");
    }
    for(int i=0;i<n-1;i++)
    {
      for(int j=i+1;j<n;j++)
      {
          if(b[i]<b[j])
          {
              int temp=b[i];
              b[i]=b[j];
               b[j]=temp;
              temp=c[i];
              c[i]=c[j];
               c[j]=temp;
              String temp1=a[i];
              a[i]=a[j];
               a[j]=temp1;
          }
      }
    }
    System.out.println();
    System.out.println("--Sorted Order--");
    System.out.print("Jobs:    ");
    for(int i=0;i<n;i++)
    {
      System.out.print(a[i]+" ");
    }
    System.out.println();
    System.out.print("priorités:  ");
    for(int i=0;i<n;i++)
    {
      System.out.print(b[i]+" ");
    }
    System.out.println();
    System.out.print("Durée:");
    for(int i=0;i<n;i++)
    {
      System.out.print(c[i]+" ");
    }
    System.out.println();
    int max=c[0];
    for(int i=0;i<n;i++)
    {
      if(c[i]>max)
      {
        max=c[i];
      }
    }
    String x[]=new String[max];
    int xx[]=new int[max];
    int Operations=0;
    for(int i=0;i<n;i++)
    {
      int pp=c[i];
      pp=pp-1;
      if(x[pp]==null )
      {
        x[pp]=a[i];
        Operations+=b[i];
      }
      else
      {
        while(pp!=-1)
        {
          if(x[pp]==null)
          {
            x[pp]=a[i];
            Operations+=b[i];
            break;
          }
            pp=pp-1;
        }
      }
      System.out.println(Thread.currentThread().getName()+" "+a[i]+" the task has executed successfully "+ new Date());
      if(a[i]!=null){
          try {
          Thread.sleep(2000);
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
    }

    }
    for(int i=0;i<max;i++)
    {
        System.out.print("-->"+x[i]);
    }
    System.out.println();
    System.out.print("Profit  totale d'ordancement "+Operations);
 }
}