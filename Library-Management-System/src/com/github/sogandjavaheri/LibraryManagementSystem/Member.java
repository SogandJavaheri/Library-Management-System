package com.github.sogandjavaheri.LibraryManagementSystem;

public class Member {

    private String name;
    private int id;
    private int age;
    private String gender;


    public Member() {
        this("Anonymous ", 0, "Male/Female");

    }

    public Member(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Member(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        //System.out.println(memberName + " is now entered");
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
        //System.out.println("Your ID is: " + "0000" + memberId)
        //System.out.println(name + "'s ID number is" + memberId);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        //System.out.println(memberName + "is" + age);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        //System.out.println(memberName + "is" + gender);
    }

    public void printMemberInfo() {
        System.out.println(name + " is a " + gender + " and " + age + " years old." );
    }

    public void printId(){
        System.out.println("Defined ID is: " + id);
    }
}
