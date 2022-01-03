package com.company;

public class Student {
    private String id;
    private String name;
    private int age;
    private String address;
    private String level;

    public Student(String id, String name, String address,int age,String level){
        setId(id);
        setName(name);
        setAddress(address);//Student student =new Student("moo",5.g);==>student.display;
        setAge(age);
        setLevel(level);
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge(int age) {
        if (age> 6 && age<28)
            this.age = age;
        else
            System.out.println("Invalid Age");
    }

    public int getAge() {

        return age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    public void setLevel(String  level){
        this.level=level;
    }
    public String getLevel(){
        return level;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getId() {
        return id;
    }
    public String display(){
        return  id+","+name+","+address+","+age+","+level;
    }

}
