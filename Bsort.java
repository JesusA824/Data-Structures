public class Bsort {
    // field variables
    private int[] a; //creates an array to put numbers
    private int nelem; //this is a variable to hold the size of array or num of elements

    //constructor
    public Bsort(int max){
        a=new int [max];//holds the max number of elements, this is fixed
        nelem=0;// initially there is nothing in the array or 0 elements
    }
    public void insert(int value){
        a[nelem]=value; //some value is inserted in the first index position aka 0
        nelem++;//now that an element has been inserted, increase the size of the array by one.
    }
    public void display(){ //display the array contents
        for( int e: a)
            System.out.print(e+" ");
    }
    public void bubbleSort(){ //slow algorithm basically goes through N array and swaps until highest int is last. Repeat.
        for(int i=nelem-1; i>1; i--)//starts looping at the last element index
            for(int j=0; j<i;i++) //starts looping at the first index and keep looping as long as there is still elements
                if(a[j]>a[j+1]) //compare if element on left  is bigger than element  on right swap them two
                    swap(j,j+1); //calls swap method
    }
    public void swap(int e1, int e2){ //swaps two elements together
        int temp=a[e1];
        a[e1]=a[e2];
        a[e2]=temp;

    }
} //end of class
