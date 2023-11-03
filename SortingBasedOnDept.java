import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class  SortingBasedOnDept{

    public static void main(String[] args) {
        ArrayList<Employee> al = new ArrayList<>();
        al.add(new Employee(1,"Arun",2000.0,15,"HR"));
        al.add(new Employee(2,"Varun",3000.0,25,"ADMIN"));
        al.add(new Employee(3,"Sanjay",4000.0,25,"IT"));
        al.add(new Employee(4,"AJAY",5000.0,35,"HR"));
        al.add(new Employee(5,"kARAN",5000.0,15,"IT"));
        al.add(new Employee(6,"Hemanth",1000.0,25,"support"));

        //Highest salary of the employee from each department
        Comparator<Employee> c = Comparator.comparing(Employee::getSalary);
        Map<String, Optional<Employee>> collect = al.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.reducing(BinaryOperator.maxBy(c))));
        System.out.println("collect ::"+collect.toString());

        //printing number of employee name based on department
        Map<String, List<Employee>> map = al.stream().collect(Collectors.groupingBy(Employee::getDept));
        Set<Map.Entry<String, List<Employee>>> entries = map.entrySet();
        for(Map.Entry<String,List<Employee>> entry: entries){
            System.out.println("dept name ---->::"+entry.getKey());
            List<Employee> e=entry.getValue();
            for (Employee e1:e){
                System.out.println(e1.getName());
            }
        }


        //number of employee working in each dept

       Map<String,Long> e1=al.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));
        System.out.println("e ::"+e1);






        //print number of departement
        al.stream()
                .map(Employee::getDept)
                .distinct()
                .forEach(System.out::println);

    }
}

class Employee{
    private int id;
    private String name;
    private double salary;
    private int age;
    private String dept;

    public Employee(int id, String name, double salary, int age, String dept) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getDept() {
        return dept;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", dept='" + dept + '\'' +
                '}';
    }
}
