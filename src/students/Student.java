package students;

public class Student {
    private String firstName;
    private String lastName;
    private String position;

    public Student(String last, String first) {
        this.firstName = first;
        this.lastName = last;
    }




    public String getLastName() {
        return this.lastName;
      }

    public String getfirstName() {
      return this.firstName;
    }

    public String getPosition() {
        return this.position;
      }


    public void setLastName(String lastname) {
         this.lastName = lastname;
    }

    public void setfirstName(String firstname) {
       this.firstName = firstname;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Override
    public String toString() {
        return "Name :" + this.lastName + ", " + this.firstName +", Position: " + this.position +"";  
    }

}
