import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMap{
    public static void main(String[] args) {
        List<Employee1> l= new ArrayList<>();
        l.add(new Employee1(1,"Amit",1000));
        l.add(new Employee1(2,"Bring",2000));
        l.add(new Employee1(3,"sanju",1));
        System.out.println("ArrayList ::"+l);

        Map<Integer, String> map = l.stream().collect(Collectors.toMap(Employee1::getId, Employee1::getName));
        System.out.println("map ::"+map);

        Map<Integer, Employee1> collect = l.stream().collect(Collectors.toMap(Employee1::getId, Function.identity()));
        System.out.println("collect ::"+collect);

        List<Employee1> filteredList = l.stream().filter(i -> i.getSalary() > 2000).collect(Collectors.toList());
        System.out.println("filteredList ::"+filteredList);

        Map<Integer, Employee1> map2 = l.stream().collect(Collectors.toMap(i -> i.id, Function.identity()));
        System.out.println("map2 ::"+map2);

    }
}
class Employee1 {
    Integer id;
    String name;
    Integer salary;

    public Employee1(Integer id, String name, Integer salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
