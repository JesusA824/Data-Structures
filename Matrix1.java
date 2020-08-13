/*Name: Jesus Adame 
  Date: February 13 2017
 */
 
import java.util.*;

public class Matrix1 {
	
	 private int row;//instance variables
	 private int col;//
	 private int[][]elem;//
	 //below is the first constructor where the field variables are assigned and the populate matrix is called.
	public Matrix1(int rows, int columns)
	{                               
		this.row=rows;//the keyword "this" refers to this specific instance of the variable to make it look neater
		this.col=columns;
        elem = new int[row][col];
		populatematrix(-100, 100);//calling the populate matrix method
	}
	//below is the second constructor where we create a similar array to the elem array
	public Matrix1(int[][] matrixArray){
		this.row=matrixArray.length;
        this.col = (matrixArray[0]).length;
        elem= new int [row][col];
        for (int i=0; i<row;i+=1){
            for (int j=0; j<col;j+=1){
            elem[i] = matrixArray[i].clone();//the purpose of this is clone or copy the array
            }
        }
	}
	//in the populate matrix the matrices will assign random values to the Matrix
	//the nested for loop iterates through and the numbers are randomly generated
	private void populatematrix(int min, int max)
	{
			Random randnum=new Random();
			
			for (int i=0; i<row; i+=1)
			{
                for (int j= 0;i<row;i+=1)
                {
                    elem[i][j] = randnum.nextInt((max - min) + 1) + min;
                }
            }
	}//populatematrix
	//in the add method you simply iterate through the array and add the elements together
	public Matrix1 add(Matrix1 otherMatrix)
	{
        int[][] resultMatrixArray = new int[row][col];
        for (int i=0; i<row; i+=1){
            for (int j=0; j<col; j+=1){ 
                resultMatrixArray[i][j] = this.elem[i][j] + otherMatrix.elem[i][j];

            }

        }        	
	return new Matrix1(resultMatrixArray);
	}//add method
	//Extremely similar to the add method same concept just switch the "+" to "-"
	public Matrix1 subtract(Matrix1 otherMatrix)
	{//same way as adding just change + to -
		int[][] resultMatrixArray=new int[row][col];
		
		for (int i=0; i<row; i+=1){
            for (int j=0; j<col; j+=1){ 
                resultMatrixArray[i][j] = this.elem[i][j] - otherMatrix.elem[i][j];

            }

        }        
		
	return new Matrix1(resultMatrixArray);
	}//subtract method
	
	//pseudocode given in class for dot product
	//you loop through rows, then the other matrix col, and rows
	//i created an int answer to hold the value of the arithmetic of the dot product
	public Matrix1 dotProduct(Matrix1 otherMatrix)
	{
		int[][] resultMatrixArray = new int[row][col];
        int answer = 0;
        
        for (int c=0; c<this.row;c++){
            for (int d = 0; d<otherMatrix.col;d++){
                for (int k = 0; k<otherMatrix.row; k++){
                    answer = answer+((this.elem[c][k])*(otherMatrix.elem[k][d]));
                }
                resultMatrixArray[c][d]=answer;
                answer = 0;
            }
        }
	return new Matrix1(resultMatrixArray);
	}
	//Again similar to the add and subtarct method just change the sign to multiplication
	public Matrix1 HadamardProduct(Matrix1 otherMatrix)
	{
		int[][] resultMatrixArray = new int[row][col];
		
		for (int i=0; i<row; i+=1){
			for (int j=0; j<col; j+=1){ 
            resultMatrixArray[i][j] = this.elem[i][j]*otherMatrix.elem[i][j];

			}

		}  
	return new Matrix1(resultMatrixArray);
	}
	//the to String method converts the matrix object into string
	//Inside you iterate through the matrix using a for each loop, such as the one givn in the notes
	//then you return the result
	public String toString()
	{
	String result = "";
	 for (int[] myArray: elem)//these for each loops make sure i iterate through the 2d array as mentioned in notes
	 {
         for (int element:myArray)
         {
             result +=""+element + "";

         }
         result +="\n";//the "\n" creates a new line
     }
	return result;
	}
	
}//class