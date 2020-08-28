public class BsortDriver {
    public static void main(String[] args){
        Bsort maharray=new Bsort(4);
        maharray.insert(1);
        maharray.insert(3);
        maharray.insert(7);
        maharray.insert(6);

        maharray.display();
        maharray.bubbleSort();
        System.out.println();
        maharray.display();
    }
}
