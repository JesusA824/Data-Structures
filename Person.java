public class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String l, String f, int a){
        lastName=l;
        firstName=f;
        age=a;

    }
    public void displayPerson(){
        System.out.print("Last name: "+lastName+" , First name: "+firstName+"\n age: "+age);
    }
    public String getLastName(){
        return lastName;
    }
}
