import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

class Person {

    private Integer id;
    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Employee {

    private String name;
    private Integer salary;
    private String department;

    public Employee(String name, Integer salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}

public class App {
    public static void main(String[] args) throws Exception {

        // Given a list of integers, filter out even numbers and collect the result into a new list.

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> evenList1 = list1.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(evenList1); // [2, 4, 6, 8]

        System.out.println();

        // Convert a list of strings to uppercase using streams.

        List<String> list2 = Arrays.asList("apple", "banana", "guava", "pumpkin");
        list2.stream().map(x -> x.toUpperCase()).forEach(x -> System.out.println(x)); // [APPLE, BANANA, GUAVA, PUMPKIN]

        System.out.println();
        
        // Find the sum of all even numbers in a list using Java Streams.

        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(list3.stream().filter(x -> x % 2 == 0).reduce(0, (x, y) -> x + y)); // 20

        System.out.println();

        // Given a list of integers, find the maximum and minimum value using Streams API.

        List<Integer> list4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(list4.stream().sorted().collect(Collectors.toList()).get(0)); // Smallest Number : 1
        System.out.println(list4.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(0)); // Largest Number : 9

        System.out.println();

        // Count strings with length greater than 5.

        List<String> list5 = Arrays.asList("apple", "banana", "guava", "pumpkin");
        list5.stream().filter(x -> x.length() > 5).forEach(x -> System.out.println(x)); // [banana, pumpkin]

        System.out.println();

        // Given a list of strings, filter out duplicates and sort them in natural order.
        List<String> list6 = Arrays.asList("apple", "banana", "guava", "pumpkin", "apple", "pear", "guava");
        list6.stream().distinct().sorted(Comparator.naturalOrder()).forEach(x -> System.out.println(x)); // [apple, banana, guava, pear, pumpkin]

        System.out.println();

        // Convert a list of Person objects to a map where the key is the person's ID and the value is their name.

        List<Person> list7 = List.of(
            new Person(1, "Alice"),
            new Person(2, "Bob"),
            new Person(3, "Charlie"),
            new Person(4, "David")
        );
        Map<Integer, String> map7 = list7.stream().collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));
        System.out.println(map7); // {1=Alice, 2=Bob, 3=Charlie, 4=David}

        System.out.println();

        // Find the second highest number from a list of integers using Streams API.

        List<Integer> list8 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 7);
        System.out.println(list8.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(1)); // Largest Number : 8

        System.out.println();

        // Find the first non-repeating character in a Integer list using Streams.

        List<Integer> list9 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 7);
        Set<Integer> setRepeat9 = new HashSet<>();
        list9.stream().filter(x -> !setRepeat9.add(x)).forEach(x -> System.out.println(x)); // 7 (first repeating number)
        Set<Integer> setNonRepeat9 = new HashSet<>();
        System.out.println(list9.stream().filter(x -> setNonRepeat9.add(x)).collect(Collectors.toList()).get(0)); // 1 (first non-repeating number)

        System.out.println();

        // Find the first non-repeating character in a string using Streams.

        String name10 = "Debayan Senapati";
        Map<Character, Long> map10 = name10.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(map10.entrySet().stream().filter(x -> x.getValue() == 1).map(x -> x.getKey()).findFirst().orElse(null));   

        System.out.println();
        
        // Group a list of Employee objects by department using Collectors.groupingBy().

        List<Employee> list11 = List.of(
            new Employee("Alice", 50000, "HR"),
            new Employee("Bob", 60000, "IT"),
            new Employee("Charlie", 70000, "Finance"),
            new Employee("David", 55000, "IT"),
            new Employee("Eve", 65000, "Finance"),
            new Employee("Frank", 48000, "HR")
        );
        Map<String, List<Employee>> map11 = list11.stream().collect(Collectors.groupingBy(x -> x.getDepartment()));

        map11.forEach((department, employee) -> {
            System.out.println(department + ": " + employee.stream()
                .map(x -> x.getName())
                .collect(Collectors.joining(", ")));
        });

        System.out.println();

        // Given a list of integers, use the Stream API to filter out only the odd numbers.

        List<Integer> list12 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> oddList12 = list12.stream().filter(x -> x % 2 == 1).collect(Collectors.toList());
        System.out.println(oddList12); // [2, 4, 6, 8]

        System.out.println();

        // Given a list of strings, convert all of them to uppercase using Java Streams.

        List<String> list13 = Arrays.asList("apple", "banana", "guava", "pumpkin");
        list13.stream().map(x -> x.toUpperCase()).forEach(x -> System.out.println(x)); // [APPLE, BANANA, GUAVA, PUMPKIN]

        System.out.println();

        // Given a list of integers, use Java Streams to sort them in ascending order.

        List<Integer> list14 = Arrays.asList(11, 92, 33, 4, 5, 62, 7, 8, 9);
        List<Integer> answer14 = list14.stream().sorted().collect(Collectors.toList());
        System.out.println(answer14); // [4, 5, 7, 8, 9, 11, 33, 62, 92]

        System.out.println();

        // Find Strings Starting with 'A'

        List<String> list15 = Arrays.asList("apple", "banana", "guava", "pumpkin");
        list15.stream().map(x -> x.toUpperCase()).filter(x -> x.startsWith("A")).forEach(x -> System.out.println(x)); // APPLE

        System.out.println();

        // Sum of All Numbers

        List<Integer> list16 = Arrays.asList(11, 92, 33, 4, 5, 62, 7, 8, 9);
        System.out.println(list16.stream().reduce(0, (x, y) -> x + y)); // 231

        System.out.println();

        // Given a list of integers, use Java Streams to find the maximum number in the list.

        List<Integer> list17 = Arrays.asList(11, 92, 33, 4, 5, 62, 7, 8, 9);
        System.out.println(list17.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(0)); // 92

        System.out.println();

        // Convert List of Strings to a Single Comma-Separated String

        List<String> list18 = List.of("Alice", "Bob", "Charlie");
        System.out.println(list18.stream().collect(Collectors.joining(", ")));

        System.out.println();

        // Count Elements in a List

        List<String> list19 = Arrays.asList("apple", "banana", "guava", "pumpkin"); // 4
        System.out.println(list19.stream().count());

        System.out.println();

        // Check if a List Contains Any Odd Number

        List<Integer> list20 = Arrays.asList(11, 92, 33, 4, 5, 62, 7, 8, 9);
        System.out.println(list20.stream().anyMatch(x -> x % 2 == 0)); // true

        System.out.println();

        // Remove Duplicates from a List

        List<Integer> list21 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 7);
        Set<Integer> set21 = new HashSet<>();
        System.out.println(list21.stream().filter(x -> set21.add(x)).collect(Collectors.toList())); // [1, 2, 3, 4, 5, 6, 7, 8, 9]

        System.out.println();

        // Find Employees with Salary > 60,000

        List<Employee> list22 = List.of(
            new Employee("Alice", 50000, "HR"),
            new Employee("Bob", 60000, "IT"),
            new Employee("Charlie", 70000, "Finance"),
            new Employee("David", 55000, "IT"),
            new Employee("Eve", 65000, "Finance"),
            new Employee("Frank", 48000, "HR")
        );

        List<Employee> newList22 = list22.stream().filter(x -> x.getSalary() > 60000).collect(Collectors.toList());
        System.out.println(newList22.stream().map(x -> x.getName()).collect(Collectors.toList())); // [Charlie, Eve]
        
        System.out.println();

        // Find the Employee with the Highest Salary

        List<Employee> list23 = List.of(
            new Employee("Alice", 50000, "HR"),
            new Employee("Bob", 60000, "IT"),
            new Employee("Charlie", 70000, "Finance"),
            new Employee("David", 55000, "IT"),
            new Employee("Eve", 65000, "Finance"),
            new Employee("Frank", 48000, "HR")
        );
        Employee answer23 = list23.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).findFirst().orElse(null);
        if (answer23 != null) {
            System.out.println("Highest Paid Employee: " + answer23.getName() + " with salary " + answer23.getSalary()); // Highest Paid Employee: Charlie with salary 70000
        } else {
            System.out.println("No employees found.");
        }

        System.out.println();

        // Sort Employees by Salary (Descending Order)

        List<Employee> list24 = List.of(
            new Employee("Alice", 50000, "HR"),
            new Employee("Bob", 60000, "IT"),
            new Employee("Charlie", 70000, "Finance"),
            new Employee("David", 55000, "IT"),
            new Employee("Eve", 65000, "Finance"),
            new Employee("Frank", 48000, "HR")
        );
        List<Employee> answer24 = list24.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).collect(Collectors.toList());
        if (answer24 != null) {
            answer24.stream().forEach(x -> System.out.println(x.getName())); // [Charlie, Eve, Bob, David, Alice, Frank]
        } else {
            System.out.println("No employees found.");
        }

        System.out.println();

        // Concatenate Names of All Employees in a Single String

        List<Employee> list25 = List.of(
            new Employee("Alice", 50000, "HR"),
            new Employee("Bob", 60000, "IT"),
            new Employee("Charlie", 70000, "Finance"),
            new Employee("David", 55000, "IT"),
            new Employee("Eve", 65000, "Finance"),
            new Employee("Frank", 48000, "HR")
        );
        System.out.println(list25.stream().map(x -> x.getName()).collect(Collectors.joining(", "))); // Alice, Bob, Charlie, David, Eve, Frank

        System.out.println();

        // Partition Employees Based on Salary (Above & Below 50,000)

        List<Employee> list26 = List.of(
            new Employee("Alice", 50000, "HR"),
            new Employee("Bob", 60000, "IT"),
            new Employee("Charlie", 70000, "Finance"),
            new Employee("David", 55000, "IT"),
            new Employee("Eve", 65000, "Finance"),
            new Employee("Frank", 48000, "HR")
        );
        Map<Boolean, List<Employee>> answer26 = list26.stream()
        .collect(Collectors.partitioningBy(emp -> emp.getSalary() >= 60000));

        // Print the results
        System.out.println("Employees earning ₹60,000 or more:");
        answer26.get(true).forEach(emp -> 
            System.out.println("  " + emp.getName() + " - " + emp.getSalary()));

        System.out.println("\nEmployees earning less than ₹60,000:");
        answer26.get(false).forEach(emp -> 
            System.out.println("  " + emp.getName() + " - " + emp.getSalary()));

        System.out.println();

        // Find Duplicate Elements in a List

        List<Integer> list27 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 7);
        Set<Integer> set27 = new HashSet<>();
        System.out.println(list27.stream().filter(x -> !set27.add(x)).collect(Collectors.toList())); // [7]

        System.out.println();

        // Find the most frequently occurring character

        String string28 = "banana";
        Character answer28 = string28.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream() .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);

        if (answer28 != null) {
            System.out.println("Most Frequent Character: " + answer28);
        } else {
            System.out.println("Input string is empty.");
        }

        System.out.println();

        // Filter Even Numbers: Given a list of integers, filter out the even numbers using Java Streams.

        List<Integer> list28 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 7);
        System.out.println(list28.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()));

        System.out.println();

        // Convert Strings to Uppercase: Given a list of strings, convert them all to uppercase using Streams.

        List<String> list29 = Arrays.asList("apple", "banana", "guava", "pumpkin");
        System.out.println(list29.stream().map(x -> x.toUpperCase()).collect(Collectors.toList()));

        System.out.println();

        // Find the First Element: Given a list of integers, use Streams to find the first element greater than 10.

        List<Integer> list30 = Arrays.asList(1, 2, 3, 40, 5, 6, 7, 81, 9, 7);
        System.out.println(list30.stream().filter(x -> x > 10).collect(Collectors.toList()).get(0));

        System.out.println();

        // Sum of List Elements: Find the sum of all even elements in a list using Streams.

        List<Integer> list31 = Arrays.asList(1, 2, 3, 40, 5, 6, 7, 81, 9, 7);
        System.out.println(list31.stream().filter(x -> x % 2 == 0).reduce(0, (x, y) -> x + y));

        System.out.println();

        // Count Words Starting with 'A': Given a list of words, count how many start with the letter ‘A’.
        
        List<String> list32 = Arrays.asList("apple", "banana", "guava", "pumpkin");
        System.out.println(list32.stream().map(x -> x.toUpperCase()).filter(x -> x.startsWith("A")).count());

        System.out.println();

        // Find Maximum and Minimum: Given a list of numbers, find the maximum and minimum values using Streams.

        List<Integer> list33 = Arrays.asList(1, 2, 3, 40, 5, 6, 7, 81, 9, 7);
        System.out.println(list33.stream().min((x, y) -> x - y));
        System.out.println(list33.stream().min((x, y) -> y - x));
        
        System.out.println();

        // Square and Collect: Given a list of integers, square each number and collect the results into a list.

        List<Integer> list34 = Arrays.asList(1, 2, 3, 40, 5, 6, 7, 81, 9, 7);
        System.out.println(list34.stream().map(x -> x * x).collect(Collectors.toList()));

        System.out.println();

        // Remove Duplicates: Given a list with duplicate elements, remove the duplicates using Streams.

        List<Integer> list35 = Arrays.asList(1, 2, 1, 40, 7, 6, 7, 81, 9, 7);
        System.out.println(list35.stream().distinct().collect(Collectors.toList()));

        System.out.println();

        // Check if Any Element Matches: Given a list of strings, check if any string contains the word "Java".

        List<String> list36 = Arrays.asList("apple", "banana", "guava", "pumpkin");
        System.out.println(list36.stream().anyMatch(x -> x.equals("Java")));

        System.out.println();

        // Sort a List of Strings: Sort a list of names alphabetically using Streams.

        List<String> list37 = Arrays.asList("carrot", "apple", "banana", "guava", "pumpkin");
        System.out.println(list37.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()));

        System.out.println();

    }
}