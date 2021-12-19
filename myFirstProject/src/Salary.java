import java.util.*;
class Salary
{
public static void main(String args[])
{
Double basicsalary,DA,HRA,GrossSalary,pf,NetSalary;
int CCA=240,pt=100;
@SuppressWarnings("resource")
Scanner sc=new Scanner(System.in);
@SuppressWarnings("unused")
Salary s=new Salary();
System.out.println("Enter your Amount: ");
basicsalary =sc.nextDouble();
DA=0.7 * basicsalary;
HRA=0.3 * basicsalary;
pf=0.1 * basicsalary;
GrossSalary= basicsalary + DA + HRA + CCA;
System.out.println("Your Value Of Gross Salary is: "+GrossSalary);
NetSalary= basicsalary + DA + HRA + CCA - pf - pt;
System.out.println("Your Value Of Net Salary is: "+NetSalary);
}
}
