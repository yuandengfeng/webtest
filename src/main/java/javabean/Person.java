package javabean;

/**
 * Created by Administrator on 2016/8/22.
 */
public class Person {

    private String name="zhangsan";
    private int age=10;
    private String address="beijing";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
