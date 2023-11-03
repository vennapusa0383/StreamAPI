import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortEmployeeBasedOnNameAndSalary {

    public static void main(String[] args) {

        ArrayList<Employee> liseEmp = new ArrayList<>();
        liseEmp.add(new Employee(1,"ABC",1000.0,23,"M","IT",2010));
        liseEmp.add(new Employee(2,"DEF",1234.87,66,"F","Admin",2011));
        liseEmp.add(new Employee(3,"DEF",1234.87,66,"F","Testing",2023));
        liseEmp.add(new Employee(4,"GHI",4776.89,45,"F","devops",2016));
        liseEmp.add(new Employee(5,"JKL",7376.854,66,"F","IT",2022));
        liseEmp.add(new Employee(6,"BCD",73545.485,56,"M","devops",2023));
        liseEmp.add(new Employee(7,"EFG",894896.485,34,"M","Testing",2019));
        liseEmp.add(new Employee(8,"BDF",5553.46,45,"F","HR",2014));
        liseEmp.add(new Employee(9,"zxc",54346.5454,66,"M","IT",2009));


        //sort Employee based on the name and salary
        liseEmp.stream().sorted(Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getSalary)
                .thenComparing(Employee::getAge))
                .forEach(System.out::println);

        Map<String, Long> collect = liseEmp.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("no of male and female employees ::"+collect);

        //print all dept
        List<String> nameOfDept = liseEmp.stream().map(Employee::getDept).distinct().collect(Collectors.toList());
        System.out.println("name of dept ::"+nameOfDept);

        //What is the average age of male and female employees?
        Map<String, Double> avreageAge = liseEmp.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println("average age ::"+avreageAge);

        //Get the details of highest paid employee in the organization?
        Employee highest = liseEmp.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();
        System.out.println("name ::"+highest.getName()+" --salry-- "+highest.getSalary());

        //Get the names of all employees who have joined after 2015?
        List<Employee> joinedAfter2015 = liseEmp.stream().filter(i -> i.getDateOfJoin() > 2011).collect(Collectors.toList());
        System.out.println("joinedAfter2015 ::"+joinedAfter2015);

        //Count the number of employees in each department?
        Map<String, Long> numberOfEmployeeWorkingInEachDept = liseEmp.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
        System.out.println("numberOfEmployeeWorkingInEachDept ::"+numberOfEmployeeWorkingInEachDept);

        //What is the average salary of each department?
        liseEmp.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.averagingDouble(Employee::getSalary)))
                .entrySet().stream().forEach(e-> System.out.println("Dept :"+e.getKey()+", Average Salary:"+e.getValue()));

        //Get the details of youngest male employee in the IT  department?
        Employee e1=liseEmp.stream().filter(f->f.getGender().equalsIgnoreCase("M") && f.getDept().equalsIgnoreCase("IT"))
                .min(Comparator.comparing(Employee::getAge)).get();
        System.out.println("younget Employee in IT:: "+e1);
        //select min(age) from employee e where e.dept_name="IT" and e.gender="male";

        Employee employee = liseEmp.stream().filter(e -> e.getDept() == "IT" && e.getGender() == "M").sorted(Comparator.comparingInt(Employee::getAge)).findFirst().get();
        System.out.println("Employee ::"+employee);
        //Who has the most working experience in the organization?
        Employee expEmployee = liseEmp.stream().sorted(Comparator.comparingInt(Employee::getDateOfJoin)).findFirst().get();
        System.out.println("experience person ::"+expEmployee);

       // How many male and female employees are there in the devops team?
        Map<String, Long> employesOfDevops = liseEmp.stream()
                .filter(e -> e.getDept() == "devops")
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("employees of devops ::"+employesOfDevops);

        //What is the average salary of male and female employees?
        Map<String, Double> averageSalaryBasedOnGender = liseEmp.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Average Salary Based On Gender:: "+averageSalaryBasedOnGender);

        //List down the names of all employees in each department?
        //Map<String, List<Employee>> employeeListBasedOnDept = liseEmp.stream().collect(Collectors.groupingBy(Employee::getDept));
        liseEmp.stream().collect(Collectors.groupingBy(Employee::getDept)).entrySet().forEach(e->{
            System.out.println("=================");
            System.out.println(e.getKey());
            e.getValue().forEach(e2->{
                System.out.println("ID ::"+e2.getId());
                System.out.println("name ::"+e2.getName());
                System.out.println("salary ::"+e2.getSalary());
            });

        });

        //What is the average salary and total salary of the whole organization?
        Double averageSalary=liseEmp.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getAverage();
        System.out.println("Average salary ::"+averageSalary);

        double sum = liseEmp.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getSum();
        System.out.println("sum ::"+sum);

        //Who is the oldest employee in the organization? What is his age and which department he belongs to?
        Employee oldAgeEmployee = liseEmp.stream().max(Comparator.comparing(Employee::getAge)).get();
        System.out.println("Oldest Employee in organisation ==>"+"name ::"+oldAgeEmployee.getName()+", age ::"+oldAgeEmployee.getAge()+", dept ::"+oldAgeEmployee.getDept());

        /*
        //SORT BASED ON NAME THEN SALARY

        liseEmp.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
        Employee{id=1, name='ABC', salary=1000.0, age=23}
        Employee{id=8, name='BDF', salary=5553.46, age=45}
        Employee{id=2, name='DEF', salary=1234.87, age=66}
        Employee{id=3, name='DEF', salary=1234.87, age=66}
        Employee{id=7, name='EFG', salary=894896.485, age=34}
        Employee{id=4, name='GHI', salary=4776.89, age=45}
        Employee{id=6, name='BCD', salary=73545.485, age=56}
        Employee{id=5, name='JKL', salary=7376.854, age=66}

        //SORT BASED ON SALARY THEN NAME

        liseEmp.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));
        Employee{id=1, name='ABC', salary=1000.0, age=23}
        Employee{id=2, name='DEF', salary=1234.87, age=66}
        Employee{id=3, name='DEF', salary=1234.87, age=66}
        Employee{id=4, name='GHI', salary=4776.89, age=45}
        Employee{id=8, name='BDF', salary=5553.46, age=45}
        Employee{id=6, name='BCD', salary=73545.485, age=56}
        Employee{id=7, name='EFG', salary=894896.485, age=34}
         */

    }


}


class Employee{
    private int id;
    private String name;
    private Double salary;
    private int age;
    private String gender;
    private String dept;
    private int dateOfJoin;

    public Employee(int id, String name, Double salary, int age, String gender,String dept,int dateOfJoin) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.gender = gender;
        this.dept = dept;
        this.dateOfJoin = dateOfJoin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(int dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", dept='" + dept + '\'' +
                ", dateOfJoin=" + dateOfJoin +
                '}';
    }
}
