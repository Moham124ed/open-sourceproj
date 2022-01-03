package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //make input public to use it easy...
    static Scanner input=new Scanner(System.in).useDelimiter("\n"); //useDelimiter: to write with space

    public static void add(){
        System.out.println("Enter Your Id");
        String id=input.next();
        System.out.println("Enter your Name");
        String name=input.next();
        System.out.println("Enter your Address");
        String address=input.next();
        System.out.println("Enter your Age");
        int age=input.nextInt();
        System.out.println("Enter your Level");
        String level=input.next();
        Student student=new Student(id,name,address,age,level);
        try {
            FileWriter writer=new FileWriter(filename,true);// true to enabel us to add data and dont make override
            writer.append(student.display());
            writer.append("\n");
            writer.close();
            System.out.println("Student Added Successfully");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    //********************************************************************

    public static void delete(){
        ArrayList<String> arrayList=new ArrayList<>();
        getAll();
        System.out.println("Enter your search  key to delete a record");
        String searchKey= input.next();
        String line;
        // String display;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            while ((line= reader.readLine())!=null) {
                if (line.contains(searchKey)){
                    System.out.println(line);
                }
                else{
                    arrayList.add(line);

                }
            }


        }catch (Exception e){

        }
        try {
            FileWriter writer=new FileWriter(filename);
            for (int i=0;i< arrayList.size();i++){
                writer.append(arrayList.get(i));
                writer.append("\n");
            }
            writer.close();
            System.out.println("Record Deleted");


        }catch (Exception e){
            System.out.println(e);
        }

    }
    //********************************************************************

    public static void update(){
        ArrayList<String> arrayList=new ArrayList<>();
        getAll();
        try{

            BufferedReader reader=new BufferedReader(new FileReader(filename));
            System.out.println("Enter key to update the record");
            String searchkey=input.next();
            String line;
            while ((line= reader.readLine())!=null) {
                if (line.contains(searchkey)){
                    System.out.println("Enter the text you want to change");
                    String oldValue=input.next();
                    System.out.println("Enter the new value of the record");
                    String newValue=input.next();
                   arrayList.add( line.replace(oldValue,newValue));
                }
                else {
                    arrayList.add(line);
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }
        try {
            FileWriter writer=new FileWriter(filename);
            for (int i=0;i<  arrayList.size();i++){
                writer.append(arrayList.get(i));
                writer.append("\n");
            }
            writer.close();
            System.out.println("Record updated");


        }catch (Exception e){
            System.out.println(e);
        }



    }
    //********************************************************************

    public static void getById(){
        getAll();
        try{

            BufferedReader reader=new BufferedReader(new FileReader(filename));
            System.out.println("Enter key to get the record");
            String searchkey=input.next();
            String line;
            while ((line= reader.readLine())!=null) {
                if (line.contains(searchkey)) {
                    System.out.println(line);
                }
            }
            reader.close();

        }catch (Exception e){
            System.out.println(e);
        }

    }
    //********************************************************************

    public static void getAll(){

        try{
            //FileReader filename=new FileReader

            BufferedReader reader=new BufferedReader(new FileReader(filename));// for reading from the file

            String line;
            while ((line= reader.readLine())!=null) {

                    System.out.println(line);
            }
            reader.close();

        }catch (Exception e){
            System.out.println(e);
        }


    }

    //********************************************************************

    // show our services

public static void services(){

   while (true){
       System.out.println("Choose any service");
       System.out.println("----------------------------");
       System.out.println("press 1 to add new student");
       System.out.println("press 2 to delete student");
       System.out.println("press 3 to update student");
       System.out.println("press 4 to get user by id");
       System.out.println("press 5 to get all students");
       System.out.println("press 0 to Exit");
       int select=input.nextInt();
       if(select==0) break ;
       else if (select==1) add();
       else if (select==2) delete();
       else if(select==3) update();
       else if(select==4) getById();
       else if(select==5) getAll();
       else System.out.println("Invalid Number");
   }
}
//name of our file.csv
public static String filename="data.csv";// for name of our file to be used pubic


// our main method
    public static void main(String[] args) {
	File data=new File(filename);//take object from class file

        try {
            if(data.createNewFile()==true){    //to create our file
                FileWriter writer=new FileWriter(filename,true);
                writer.append("ID"+","+"Name"+","+"Address"+","+"age"+","+"level");
                writer.append("\n");
                writer.close();
                System.out.println("done");// print for one time
            }
            else{

                // to tell us that file was created before


            }
        } catch (IOException e) {
            System.out.println(e);
        }
        services();

    }
}

