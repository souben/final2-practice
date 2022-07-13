package lambdalib;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import quizclasses.Employee;
import quizclasses.Trader;
import quizclasses.Transaction;

public class LambdaLibrary {
	public final static String IMPLEMENT = "implement!";

	// sample query
	public final static TriFunction<List<Employee>, Integer, Integer, List<Employee>> SAMPLE = (list, namelength,
			year) -> list.stream().filter(e -> e.getName().length() > namelength).filter(e -> e.getYearOfBirth() > year)
					.collect(Collectors.toList());

	public final static TriFunction<List<Employee>, Integer, Integer, List<String>> FIRST = (list, minimum,
			maximum) -> list.stream().filter(e -> e.getSalary() > minimum).filter(e -> e.getSalary() < maximum)
					.sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary,
							Comparator.reverseOrder()))
					.map(e -> e.getName() + ":" + e.getSalary()).collect(Collectors.toList());

	public final static BiFunction<List<Transaction>, Integer, List<Transaction>> SECOND = (list, year) -> list.stream()
			.filter(t -> t.getYear() >= year).sorted(Comparator.comparing(Transaction::getValue))
			.collect(Collectors.toList());

	public final static BiFunction<List<Transaction>, String, List<Trader>> THIRD = (list, city) -> list.stream().map(Transaction::getTrader)
			.filter(t -> t.getCity().equalsIgnoreCase(city)).sorted(Comparator.comparing(Trader::getName))
			.collect(Collectors.toList());
}
