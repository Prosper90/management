import students.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    //data structure to store our students for now
    static ArrayList<Student> Studentrecord = new ArrayList<>(); 

    //data structure to map students to their individual results
    static Map<Student, int[]> results = new HashMap<>();
    
    public static void main(String[] args) throws Exception {
      Scanner in = new Scanner(System.in);
      boolean exit = false;
      //while to continue
      while (!exit) {
         //To check selected input
       String selectedInput;
  
       System.out.println("Welcome Teacher, Enter keyword \n" +
        "*  AB to add a student in bulk, \n" + 
        "*  A to add a single student, \n" +
        " * E to edit a student, \n" +
        " * D to delete a Student, \n" +
        " * GA to get all student, \n" +
        " * G to get a particular student \n" +
        " * AR to add student result \n" +
        " * ER to edit student result \n" +
        " * EX to exit the app. \n " 
        );
       selectedInput = in.nextLine();

       if(selectedInput.equalsIgnoreCase("A")) {
         addoneStudent();
       } else if(selectedInput.equalsIgnoreCase("AB")){
        addmultipleStudent();
       } else if(selectedInput.equalsIgnoreCase("E")) {
         editStudent();
       } else if(selectedInput.equalsIgnoreCase("D")){
        deleteStudent();
       } else if(selectedInput.equalsIgnoreCase("GA")) {
        getAllStudent();
       } else if(selectedInput.equalsIgnoreCase("G")){
        getStudent();
       } else if(selectedInput.equalsIgnoreCase("AR")) {
          addResultStudent();
       } else if(selectedInput.equalsIgnoreCase("ER")) {
        editResultStudent();
       } else if(selectedInput.equalsIgnoreCase("EX")) {
         exit = true;
       } else {
        System.out.println("This option selected is not allowed");
       }


      }

    }


    //getting student
    public static void getAllStudent() {
       System.out.println("The total children in this record are");
       
       for (Student student : Studentrecord) {
        System.out.println(student);
       }
    }

    public static void getStudent() {
       System.out.println("enter the the name or something close to the name to get the corresponding students or student");
       Scanner in = new Scanner(System.in);

       String searchValue = in.nextLine();

       ArrayList<Student> searchedResult = new ArrayList<>();

       for(Student students: Studentrecord) {
          String firstname = students.getfirstName();
          String lastname = students.getLastName();
         if(searchValue.split(",").length == 2 ) {
          if(firstname.equalsIgnoreCase(searchValue.split(",")[0] ) && lastname.equalsIgnoreCase(searchValue.split(",")[0])) {
            searchedResult.add(students);
          }
         } else if(firstname.contains(searchValue) || lastname.contains(searchValue)) {
           searchedResult.add(students);
        } else {
          System.out.println("This search didnt find anything");
        }
       }

       System.out.println(searchedResult);
    }

    //adding student
    public static void addoneStudent() {
       System.out.println("Enter the student full name, in format, Lastname, space then Firstname");
       Scanner in = new Scanner(System.in);

       String studentname = in.nextLine();
       String[] nameParts = studentname.split(" ");

       if(nameParts.length != 2) {
        System.out.println("Enter name must be in lastName and Firstname");
        return;
       }

       String lastname = nameParts[0];
       String firstname = nameParts[1];

       //make a new Student Object
       Student newStudent = new Student(lastname, firstname);

       //now add student to the Array list
       Studentrecord.add(newStudent);
    }

    public static void addmultipleStudent() {
       Scanner in = new Scanner(System.in);

       System.out.println("Enter their names, seperated by comma's e.g silver tony, vincent micheal");
       System.out.println("Remember to enter the names in the order of , lastname then firstname");

       String studentNames = in.nextLine();
       String[] studentsAdded = studentNames.split(",");

       for(String check: studentsAdded) {
        if(check.split(" ").length != 2) {
          System.out.println("All names entered must be in two's, lastname and firstname");
          return;
         }
       }
       
       for (String student : studentsAdded) {
          Student newstudent = new Student(student.split(" ")[0], student.split(" ")[1]);

          Studentrecord.add(newstudent);
       }
    }

    //editing student
    public static void editStudent() {
       System.out.println("Enter the student's full name, you are interested in");

       //take the student we need lastname and firstname
       Scanner in = new Scanner(System.in);       

       String studentEntered = in.nextLine();
       String[] nameParts = studentEntered.split(" ");

       if(nameParts.length != 2) {
        System.out.println("You must enter the Student complete name");
        return;
       }


       //find the particular student
       for(int i = 0; i <= Studentrecord.size(); i++) {
         Student student = Studentrecord.get(i);
         if(nameParts[0].equals(student.getLastName()) && nameParts[1].equals(student.getfirstName())){
          
          System.out.println("Enter * F to change the first name , \n * L to change the last name");
          String selected = in.nextLine();
    
          if(selected.equalsIgnoreCase("F")) {
             System.out.println("Enter the new first name of this student");
             String newFirstName = in.nextLine();
             
             //change the value of the Object
             student.setfirstName(newFirstName);

             //resave to the Student record
          } else if(selected.equalsIgnoreCase("L")) {
            System.out.println("Enter the new last name of this student");
            String newlastName = in.nextLine();
    
            //change the value of the Object
            student.setLastName(newlastName);

          } else {
            System.out.println("Invalid option");
          }

          return;
         }
       }
      


    }

    //deleting student
    public static void deleteStudent() {
      System.out.println("Enter the student full name, in format, Lastname, space then Firstname");
      Scanner in = new Scanner(System.in);

      String studentname = in.nextLine();
      String[] nameParts = studentname.split(" ");

      if(nameParts.length != 2) {
       System.out.println("Enter name must be in lastName and Firstname");
       return;
      }

      String lastname = nameParts[0];
      String firstname = nameParts[1];


      for(int i = 0; i <= Studentrecord.size(); i++) {
        Student student = Studentrecord.get(i);
        if(lastname.equalsIgnoreCase(student.getLastName()) && firstname.equalsIgnoreCase(student.getfirstName())){
          Studentrecord.remove(i);
        }
      }
    }

    //add student result
    public static void addResultStudent() {
      System.out.println("Enter the student name");
      Scanner in = new Scanner(System.in);
      String[] namesPart = in.nextLine().split(" ");

      if(namesPart.length != 2){
        System.out.println("Student name must be in the order : firstname lastname");
        return;
      }

      for (Student student : Studentrecord) {
        if(namesPart[0].equalsIgnoreCase(student.getLastName()) && namesPart[1].equalsIgnoreCase(student.getfirstName())) {
          System.out.println("Enter the subjects scores in the order for math, biology, chemistry, physics, like this :  20, 30, 50, 70");
          String[] subjectsEntered = in.nextLine().split(",");
          

          //representation of subjects, where 0 is math, 1 is biology, 2 is chem, and 3 physics
          int[] subjects = new int[6];

          for (int i = 0; i < subjectsEntered.length; i++) {
            subjects[i] = Integer.parseInt(subjectsEntered[i]);
          }

          //add the array to the results map
          results.put(student, subjects);           

          System.out.println("Scores entered successfully");
          return;
        }
      }


    }

    //edit student result
    public static void editResultStudent() {
      System.out.println("Enter the student name");
      Scanner in = new Scanner(System.in);
      String[] namesPart = in.nextLine().split(" ");

      if(namesPart.length != 2){
        System.out.println("Student name must be in the order : firstname lastname");
        return;
      }

      //find the student object in student record first
      for (Student student : Studentrecord) {
        if(namesPart[0].equalsIgnoreCase(student.getLastName()) && namesPart[1].equalsIgnoreCase(student.getfirstName())) { 
           System.out.println("Enter the subject you want to edit, \n" +
           "* M for math, \n B for biology, \n C for chemistry, \n P for physics");

            String[] Options = {"M", "B", "C", "P"};
            String selectedSubject = in.nextLine();

            for (int i = 0; i < namesPart.length; i++) {
              if(selectedSubject.equalsIgnoreCase(Options[i])) {
                //get the old values for the student by finding the student and getting the subjects
                int[] gottenResults = results.get(student);
                System.out.println("Enter the value of the selected Subject");
                int score = in.nextInt();
                gottenResults[i] = score;

                return;
              }
            }
            

        }
      }



    }
}
