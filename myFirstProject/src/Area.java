class Area
{
int length, breadth;
Area(int l,int b)
{
length=l;
breadth=b;
}
public int setDim()
{
int results = length*breadth;
return results;
}
public void getArea()
{
System.out.println("Area="+setDim());
	}
	public static void main(String args[])
	{
	Area a=new Area(14,75);
	Area a1=new Area(50,25);
	Area a2=new Area(46,23);
	a.getArea();
	a1.getArea();
	a2.getArea();
	}
	}


