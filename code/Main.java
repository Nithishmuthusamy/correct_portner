import java.util.*;
public class Main
{
    String name;
    String gender;
    Main father;
    Main mother;
    Main son;
    Main daughter;
    Main brother;
    Main sister;
	public static void main(String[] args) {
	    Scanner input=new Scanner(System.in);
	    int n=input.nextInt();
	    input.nextLine();
	    Main[] a=new Main[n];
	    for(int i=0;i<n;i++)
	    {
	        a[i]=new Main();
	        System.out.print("name: ");
	        a[i].name=input.nextLine();
	        System.out.print("gender: ");
	        a[i].gender=input.nextLine();
	        a[i].father=new Main();
	        if(a[i].gender.equals("male"))
	        {
	            System.out.print("father: ");
	        a[i].father.name=input.nextLine();
	        a[i].father.gender="male";
	        a[i].mother=new Main();
	        System.out.print("mother: ");
	        a[i].mother.name=input.nextLine();
	        a[i].mother.gender="female";
	        a[i].father.son=a[i];
	        a[i].mother.son=a[i];
	        }
	        if(a[i].gender.equals("female"))
	        {
	            System.out.print("father: ");
	        a[i].father.name=input.nextLine();
	        a[i].father.gender="male";
	        a[i].mother=new Main();
	        System.out.print("mother: ");
	        a[i].mother.name=input.nextLine();
	        a[i].mother.gender="female";
	        a[i].father.daughter=a[i];
	        a[i].mother.daughter=a[i];
	        }
	        System.out.println("-----------------------------------------------------------------");
	    }
	    for(int i=0;i<n;i++)
	    {
	        for(int j=0;j<n;j++)
	        {
	            if(i!=j)
	            {
	            //System.out.println(a[i].father.name);
	                if(a[i].father.name.equals(a[j].father.name))
	                {
	                    //System.out.println("one");
	                    if(a[i].father.son==null)
	                    {
	                        a[i].father.son=a[j];
	                        a[i].brother=a[j];
	                        //System.out.println(a[i].brother.name);
	                        a[j].father.daughter=a[i];
	                        a[j].sister=a[i];
	                    }
	                    else if(a[i].father.daughter==null)
	                    {
	                        a[i].father.daughter=a[j];
	                        a[i].sister=a[j];
	                        a[j].father.son=a[i];
	                        a[j].brother=a[i];
	                    }
	                }
	                if(a[i].mother.name.equals(a[j].mother.name))
	                {
	                    if(a[i].mother.son==null)
	                    {
	                        a[i].mother.son=a[j];
	                        a[i].brother=a[j];
	                        a[j].mother.daughter=a[i];
	                        a[j].sister=a[i];
	                    }
	                    else if(a[i].mother.daughter==null)
	                    {
	                        a[i].mother.daughter=a[j];
	                        a[i].sister=a[j];
	                        a[j].mother.son=a[i];
	                        a[j].brother=a[i];
	                    }
	                }
	            }
	        }
	    }
	    for(int i=0;i<n;i++)
	    {
	        for(int j=0;j<n;j++)
	        {
	            if(i!=j)
	            {
	                if(a[i].father.name.equals(a[j].name))
	                {
	                    a[i].father=a[j];
	                    if(a[i].gender.equals("male"))
	                    a[j].son=a[i];
	                    else
	                    a[j].daughter=a[i];
	                }
	                if(a[i].mother.name.equals(a[j].name))
	                {
	                    a[i].mother=a[j];
	                    if(a[i].gender.equals("male"))
	                    a[j].son=a[i];
	                    else
	                    a[j].daughter=a[i];
	                }
	            }
	        }
	    }
	    System.out.println("ready to go");
	    while(true)
	    {
	    String temp=input.nextLine();
	    if(temp.equals("break"))
	    break;
	    for(int i=0;i<n;i++)
	    {
	        if(temp.equals(a[i].name))
	        {
	            if(a[i].gender.equals("male"))
	            {
	            try{
	                    if(a[i].father.sister.daughter.name!=null)
	                    System.out.println(a[i].father.sister.daughter.name);
	                }
	            catch(Exception e)
	            {
	                    System.out.println("there is no match in father relation");
	            }
	            try{
	                if(a[i].mother.brother.daughter.name!=null)
	                System.out.println(a[i].mother.brother.daughter.name);
	            }
	            catch(Exception e)
	            {
	                System.out.println("there is no match in mothers relation");
	            }
	        }
	            else
	            {
	            try{
	                if(a[i].father.sister.son.name!=null)
	                System.out.println(a[i].father.sister.son.name);
	            }
	            catch(Exception e)
	            {
	                System.out.println("there is no match in father relation");
	            }
	            try{
	                if(a[i].mother.brother.son.name!=null)
	                System.out.println(a[i].mother.brother.son.name);
	            }
	            catch(Exception e)
	            {
	                System.out.println("there is no match in mothers relation");
	            }
	            }
	        }
	       
	        }
	        System.out.println("-----------------------------------------------------------------");
	    }
	}
}
