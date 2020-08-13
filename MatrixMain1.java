/*Name: Jesus Adame 
  Date: February 13 2017
 
 */
import java.util.*;

public class MatrixMain1 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		
		//below i will prompt the user to enter the size for its desired matrices
		System.out.println("Please enter the size of rows for the Matrix");
		int row=in.nextInt();	
		
		System.out.println("Please enter the size of columns for the Matrix");
		int col=in.nextInt();
		
		System.out.println("Please enter the size of rows for Matrix B");
		int row2=in.nextInt();
		
		System.out.println("Please enter the size of columns for Matrix B");
		int col2=in.nextInt();
		
		
		System.out.println("Please enter your number for the operation");
		Matrix1 result;
		//below is created 2 objects or instances that will create the matrix
		Matrix1 mmatrixA=new Matrix1(row,col);
		
		Matrix1 mmatrixB=new Matrix1(row2,col2);
		//below are the options that the user has to input
		System.out.println("1. Add");
		System.out.println("2. Subract");
		System.out.println("3. Multiply");
		System.out.println("4. to do Hadamards Product");
		System.out.println(">1");
		int num=in.nextInt();//declared the var num to hold user input
		/*in the nested if statement we check for the user input and
		 * and then we call the desired method 
		 */
		if(num==1)
		{
		System.out.println("The following is adding matrices");
		result=mmatrixA.add(mmatrixB);
		System.out.println("This is your first matrix");
		System.out.println(mmatrixA.toString());
		System.out.println("This is your second matrix");
		System.out.println(mmatrixB.toString());
		
		System.out.println(result);
		//call add method here
		
		}
		else if(num==2)
		{
			System.out.println("The following is subtracting matrices");	
			result=mmatrixA.subtract(mmatrixB);
			System.out.println("This is your first matrix");
			System.out.println(mmatrixA.toString());
			System.out.println("This is your second matrix");
			System.out.println(mmatrixB.toString());
			System.out.println(result);
		}
		else if(num==3)
		{
			System.out.println("The following is multiplying matrices ");
			result=mmatrixA.dotProduct(mmatrixB);
			System.out.println("This is your first matrix");
			System.out.println(mmatrixA.toString());
			System.out.println("This is your second matrix");
			System.out.println(mmatrixB.toString());
			System.out.println(result);
		}
		else if(num==4)
		{
			System.out.println("The following is multiplying using Hadamard product");
			result=mmatrixA.HadamardProduct(mmatrixB);
			System.out.println("This is your first matrix");
			System.out.println(mmatrixA.toString());
			System.out.println("This is your second matrix");
			System.out.println(mmatrixB.toString());
			System.out.println(result);
		}
		else
			System.out.println("Error wrong number has been inputed");
		
		
		
	}//main method

}//class
