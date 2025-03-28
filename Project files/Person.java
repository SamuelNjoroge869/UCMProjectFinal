public abstract class Person {
    private String name;
    private String email;
    private int age;

    public Person() {}

    protected Person(String name, String email, int age){
        this.name=name;
        this.email=email;
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public void setName(String myName){
        this.name=myName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String Email){
        this.email=Email;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int myAge){
        this.age=myAge;
    }


    public abstract void displayDetails();

}

