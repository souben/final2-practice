package innerclass;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import quizclasses.Employee;
import quizclasses.EmployeeTestData;
import quizclasses.Trader;
import quizclasses.TraderTransactTestData;
import quizclasses.Transaction;

/**
 * SOLVE THE PROBLEMS HERE BY REPLACING LAMBDA EXPRESSIONS IN YOUR PIPELINE
 * SOLUTIONS WITH LOCAL INNER CLASSES
 *
 */
public class Main {
	public static void main(String[] args) {

		// SAMPLE: Use local inner classes to replace lambdas in your pipeline solution
		// to
		// this sample problem:
		// Print all Employee records for which name has length > 5 and birth year is >
		// 1970

		class NameLength implements Predicate<Employee> {
			public boolean test(Employee e) {
				return e.getName().length() > 5;
			}
		}
		class BirthYear implements Predicate<Employee> {
			public boolean test(Employee e) {
				return e.getYearOfBirth() > 1970;
			}
		}
		System.out.println("Sample Query");
		List<Employee> sampleData = EmployeeTestData.getList();

		List<Employee> result = sampleData.stream().filter(new NameLength()).filter(new BirthYear())
				.collect(Collectors.toList());
		System.out.println(result);

		prob1();
		prob2();
		prob3();
	}

	// Transform your pipeline solution to prob1 in the pipeline package so that
	// every lambda is replaced by an instance of a
	// local inner class of the correct type
	public static void prob1() {
		class RangeOfSalary implements Predicate<Employee> {
			public boolean test(Employee e) {
				return e.getSalary() > 55000 && e.getSalary() < 120000;
			}
		}
		class EmployeeInfo implements Function<Employee, String> {
			@Override
			public String apply(Employee e) {
				return e.getName() + ":" + e.getSalary();
			}
		}

		// use this list
		List<Employee> list = EmployeeTestData.getList();
		List<String> result = list
				.stream()
				.filter(new RangeOfSalary())
				.sorted(Comparator.comparing(Employee::getName)
						.thenComparing(Employee::getSalary, Comparator.reverseOrder()))
				.map(new EmployeeInfo())
				.collect(Collectors.toList());
		
		System.out.println(result);

	}

	/// Transform your pipeline solution to prob2 so that
	// every lambda is replaced by an instance of a
	// local inner class of the correct type
	public static void prob2() {
		class CheckYear implements Predicate<Transaction> {
			public boolean test(Transaction t) {
				return t.getYear() > 2011;
			}
		}
		class ValueComparator implements Comparator<Transaction> {
			@Override
			public int compare(Transaction t1, Transaction t2) {
				return t1.getValue() - t2.getValue();
			}
		}
		// use this list
		List<Transaction> list = TraderTransactTestData.getTransactions();
		List<Transaction> result = list
				.stream()
				.filter(new CheckYear())
				.sorted(new ValueComparator())
				.collect(Collectors.toList());
		
		System.out.println(result);
	}

	// Transform your pipeline solution to prob3 so that
	// every lambda is replaced by an instance of a
	// local inner class of the correct type
	public static void prob3() {
		class TraderOfTransaction implements Function<Transaction, Trader> {
			@Override
			public Trader apply(Transaction t) {
				return t.getTrader();
			}
		}
		class InCambridge implements Predicate<Trader> {
			public boolean test(Trader t) {
				return t.getCity().equalsIgnoreCase("Cambridge");
			}
		}
		class TraderNameComparator implements Comparator<Trader> {
			@Override
			public int compare(Trader t1, Trader t2) {
				return t1.getName().compareTo(t2.getName());
			}
		}
		// Use this list
		List<Transaction> list = TraderTransactTestData.getTransactions();
		List<Trader> result = list.stream().map(new TraderOfTransaction()).distinct()
				.filter(new InCambridge()).sorted(new TraderNameComparator())
				.collect(Collectors.toList());
		System.out.println(result);

	}
}
