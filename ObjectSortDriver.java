public class ObjectSortDriver {
    public static void main(String[] args){
        int size=100;
        ArrayPerson arr=new ArrayPerson(size);
        arr.insert("Lol","Math",24);
        arr.insert("Bryant","Kobe",42);
        arr.insert("Li","Jet",40);
        arr.insert("Jimenez","Raul",21);
        arr.insert("Cube","Ice",18);

        System.out.println("Before Sorting: ");
        arr.display();
        arr.insertionSort();

        System.out.println("After Sorting: ");
        arr.display();


    }//main
}//class
