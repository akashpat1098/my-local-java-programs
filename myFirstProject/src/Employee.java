class Employee2
{
private String name,address;
private int year; 
private double salary;
public Employee2(String n,int y,double z,String x)
{	
name = n;
address = x;
year = y;
salary = z;
}
public String getName()
{
return name;
}
public int getYear()
{
return year;
}
public double getSalary()
{
return salary;
}
public String getAddress()
{
return address;
}
}
class Employee
{
public static void main(String args[])
{
Employee2 e1 = new Employee2("Robert", 1994, 50000, "64C- WallsStreet");
Employee2 e2 = new Employee2("Sam", 2000, 74000, "68D- WallsStreet");
Employee2 e3 = new Employee2("John", 1999, 60000, "26B- WallsStreet");
System.out.println("Name\tYearOfJoining\tSalary\t\tAddress");
System.out.println(e1.getName()+"\t"+e1.getYear()+"\t\t"+e1.getSalary()+"\t\t"
+e1.getAddress());
System.out.println(e2.getName()+"\t"+e2.getYear()+"\t\t"+e2.getSalary()+"\t\t"
+e2.getAddress());
System.out.println(e3.getName()+"\t"+e3.getYear()+"\t\t"+e3.getSalary()+"\t\t"
+e3.getAddress());
}
}
