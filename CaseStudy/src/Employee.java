public class Employee {
    //Properties
    private int employeeId;
    private String name;
    private String department;
    private String email;
    private int vacationDays;
    //Constructor
    public Employee(int employeeId, String name, String department, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.email = email;
        this.vacationDays = 28;
    }

    //Methods
    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }
}

/*
public class Employee implements Cloneable {
    //Properties
    private String name;
    private int age;
    private double salary;

    //Constructor
    public Employee() {
        this.name = "Unknown";
        this.age = 18;
        this.salary = 0.0;
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setName(String name) {
        if(name != null && name != "") {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if(age >= 18 && age <= 65) {
            this.age = age;
        }
    }

    public void setSalary(double salary) {
        if(salary >= 0.0) {
            this.salary = salary;
        }
    }

    public double calculateAnnualSalary() {
        return this.salary * 12;
    }

    public void giveRaise(double percentage) {
        this.salary = this.salary * (100.0 + percentage) / 100.0;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nAge: " + this.age +
                "\nMonthly salary: " + this.salary + "\nAnnual salary: " + this.calculateAnnualSalary();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
*/

/*
// Student class to store and manage student information
public class Student {
    private String studentId;
    private String name;
    private double grade;
    private boolean isActive;

    public String getStudentId() {
        return this.studentId;
    }

    public String getName() {
        return this.name;
    }

    public double getGrade() {
        return this.grade;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setStudentId(String id) {
        this.studentId = id;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setGrade(double newGrade) {
       if(newGrade <= 100 && newGrade >= 0) {
        this.grade = newGrade;
       }
    }

    public void setIsActive(boolean status) {
        this.isActive = status;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + this.studentId +
        "\nName: " + this.name + "\nGrade: " + this.grade + "\nStatus: " +
        (this.isActive? "Active":"Inactive"));
    }

    public char letterGrade() {
        if(this.grade >= 90) {
            return 'A';
        } else if(this.grade >= 80 && this.grade < 90) {
            return 'B';
        } else if(this.grade >= 70 && this.grade < 80) {
            return 'C';
        } else if(this.grade >= 60 && this.grade < 70) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public boolean isPassing() {
        if(this.grade >= 60) {
            return true;
        } else {
            return false;
        }
    }
}
*/

/*
// Student class to store and manage student information
public class Student {
    private String studentId;
    private String name;
    private double grade;
    private boolean isActive;

    public String getStudentId() {
        return this.studentId;
    }

    public String getName() {
        return this.name;
    }

    public double getGrade() {
        return this.grade;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setStudentId(String id) {
        this.studentId = id;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setGrade(double newGrade) {
       if(newGrade <= 100 && newGrade >= 0) {
        this.grade = newGrade;
       }
    }

    public void setIsActive(boolean status) {
        this.isActive = status;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + this.studentId +
        "\nName: " + this.name + "\nGrade: " + this.grade + "\nStatus: " +
        (this.isActive? "Active":"Inactive"));
    }

    public char letterGrade() {
        if(this.grade >= 90) {
            return 'A';
        } else if(this.grade >= 80 && this.grade < 90) {
            return 'B';
        } else if(this.grade >= 70 && this.grade < 80) {
            return 'C';
        } else if(this.grade >= 60 && this.grade < 70) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public boolean isPassing() {
        if(this.grade >= 60) {
            return true;
        } else {
            return false;
        }
    }
}
 */