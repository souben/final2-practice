package lambdalib;

import java.util.List;

import quizclasses.Employee;
import quizclasses.EmployeeTestData;
import quizclasses.TraderTransactTestData;
import quizclasses.Transaction;

/** SOLVE THE PROBLEMS HERE USING A LAMBDA LIBRARY */
public class Main {
	public static void main(String[] args) {
		System.out.println("Sample Query");
		List<Employee> sampleData = EmployeeTestData.getList();
		System.out.println(LambdaLibrary.SAMPLE.apply(sampleData, 5, 1970));

		prob1();
		prob2();
		prob3();
	}

	public static void prob1() {
		List<Employee> list = EmployeeTestData.getList();
		System.out.println(LambdaLibrary.IMPLEMENT);
		System.out.println(LambdaLibrary.FIRST.apply(list, 55000, 120000));

	}


	public static void prob2() {
		List<Transaction> list = TraderTransactTestData.getTransactions();
		System.out.println(LambdaLibrary.IMPLEMENT);
		System.out.println(LambdaLibrary.SECOND.apply(list, 2011));
	}

	public static void prob3() {
		List<Transaction> list = TraderTransactTestData.getTransactions();
		System.out.println(LambdaLibrary.IMPLEMENT);
		System.out.println(LambdaLibrary.THIRD.apply(list, "Cambridge"));

	}

}
