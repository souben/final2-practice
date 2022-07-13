package pipeline;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import quizclasses.Employee;
import quizclasses.EmployeeTestData;
import quizclasses.Trader;
import quizclasses.TraderTransactTestData;
import quizclasses.Transaction;

/** USE STREAM PIPELINES TO SOLVE THE PROBLEMS HERE */
public class Main {
	public static void main(String[] args) {
		System.out.println("Sample Query");
		List<Employee> sampleData = EmployeeTestData.getList();
		
		List<Employee> result = sampleData
				.stream()
				.filter(e -> e.getName().length() > 5)
				.filter(e -> e.getYearOfBirth() > 1970)
				.collect(Collectors.toList());
		
		System.out.println(result);

		prob1();
		prob2();
		prob3();
	}

	public static void prob1() {
		List<Employee> list = EmployeeTestData.getList();
		List<String> result = list
				.stream()
				.filter(e -> e.getSalary() < 120000)
				.filter(e -> e.getSalary() > 55000)
				.sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary,
						Comparator.reverseOrder()))
				.map(e -> e.getName() + ":" + e.getSalary())
				.collect(Collectors.toList());
		
		System.out.println(result);

	}

	
	public static void prob2() {
		List<Transaction> list = TraderTransactTestData.getTransactions();
		List<Transaction> result = list
				.stream()
				.filter(t -> t.getYear() >= 2011)
				.sorted(Comparator.comparing(Transaction::getValue))
				.collect(Collectors.toList());
		
		System.out.println(result);
	}

	
	public static void prob3() {
		List<Transaction> list = TraderTransactTestData.getTransactions();
		
		List<Trader> result = list
				.stream()
				.map(Transaction::getTrader)
				.distinct()
				.filter(t -> t.getCity().equalsIgnoreCase("Cambridge"))
				.sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toList());
		
		System.out.println(result);

	}
}
