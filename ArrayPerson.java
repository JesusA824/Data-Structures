public class ArrayPerson {
    private Person[] a;//array of object type Person
    private int numelem;//counts the number of elements in array

    ArrayPerson(int max){
        a=new Person[max];//holds the max number of elements, this is fixed
        numelem=0;// initially there is nothing in the array or 0 elements
    }
    public void insert(String last ,String first,int age){
        a[numelem]=new Person(last,first,age); //some value is inserted in the first index position aka 0
        numelem++;//now that an element has been inserted, increase the size of the array by one.
    }
    public void display(){ //display the array contents
        for(int i=0; i<numelem;i++){
            a[i].displayPerson();
            System.out.println("");
        }

    }
    public void insertionSort() {
        int j;
        for (int i = 1; i < numelem; i++) {
            Person  temp=a[i];//iterate through the Person array
            j=i;//assign the counter variable to j

                while(j>0 &&a[j-1].getLastName().compareTo(temp.getLastName())>0){//as long as j is greater than 0 and the element of the left is comparing strings aka last names
                    a[j]=a[j-1];//assign element of left index to current index
                    --j;//decrement index
                }
            a[j]=temp;//put the temp person object into the sorted array by last names


        }//for loop
    } //end of insertionSort

}
