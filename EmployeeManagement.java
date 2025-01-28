
class Employee {

    protected String name;
    protected int id;
    protected int age;
    protected String role;

    public Employee(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.role = "None";
    }

    public void printDetails() {
        System.out.println("**********DETAIL********");
        System.out.println("Id : " + id);
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.err.println("Role : " + role);
    }

}

class Developer extends Employee {

    public Developer(String name, int id, int age) {
        super(name, id, age);
        this.role = "Developer";
    }
}

class Manager extends Employee {

    public Manager(String name, int id, int age) {
        super(name, id, age);
        this.role = "Manager";
    }
}
class  EmployeeManagement
{
    public static void main(String[] args) {
        Employee emp1=new Employee("name1", 1, 17);
        Employee emp2=new Developer("name2",2,22);
        Employee emp3=new Manager("name3",3,27);
        emp1.printDetails();
        emp2.printDetails();
        emp3.printDetails();
    }
}
