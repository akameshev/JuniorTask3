package Examples;

import java.io.Serializable;

public class Person implements Serializable {
    //region Fields
    private String name;
    private int age;
    //endregion

    //region Constructors
    public Person(){
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //endregion

    //region Getters and Setter

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //endregion

    //region Methods

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //endregion

}
