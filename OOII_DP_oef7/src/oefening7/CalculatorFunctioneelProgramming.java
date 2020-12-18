package oefening7;

import java.util.function.BinaryOperator;

public class CalculatorFunctioneelProgramming {

	public static void main(String[] args) {
		
		BinaryOperator<Integer> add = (x, y) -> x + y;
		BinaryOperator<Integer> subtract = (x, y) -> x - y;
		BinaryOperator<Integer> multiply = (x, y) -> x * y;
		
		System.out.printf("5 + 5 = %s%n", compute(add, 5, 5));
		System.out.printf("5 - 5 = %s%n", compute(subtract, 5, 5));
		System.out.printf("5 * 5 = %s%n", compute(multiply, 5, 5));
	}
	
	private static Integer compute(BinaryOperator<Integer> computation, int x, int y) {
		return computation.apply(x, y);
	}
}
