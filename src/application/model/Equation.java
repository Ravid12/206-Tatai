package application.model;

import java.util.Random;

public class Equation{

		private int max = 99;
		private int min = 1;
		private int firstNumber;
		private int secondNumber;
		private int result;
		private Operator operator;
		
		public Equation(Operator operator)
		{
			Random rand = new Random();
			this.operator = operator;
	        switch (operator) {
	        
	        case ADDITION:
	        	firstNumber = rand.nextInt((max - min) + 1) + min - min;
	        	secondNumber = rand.nextInt((max - firstNumber - min) + 1) + min;
	        	result = firstNumber + secondNumber;
	            break;
	            
	        case SUBTRACTION:
	        	firstNumber = rand.nextInt((max - min) + 1) + min;
	        	secondNumber = rand.nextInt((firstNumber - min) + 1) + min - min;
	        	result = firstNumber - secondNumber;
	             break;
	             
	        case MULTIPLICATION:
	        	firstNumber = rand.nextInt((max - min) + 1) + min;
	        	secondNumber = rand.nextInt(((max / firstNumber) - min) + 1) + min;
	        	result = firstNumber * secondNumber;
	             break;
	             
	        case DIVISION:
	        	int num1 = rand.nextInt((max - min) + 1) + min;
	        	int num2 = rand.nextInt(((max / firstNumber) - min) + 1) + min;
	        	int num3 = num1 * num2;
	        	
	        	Random decider = new Random();
	        	int decision = decider.nextInt((2 - 1) + 1) + 1;
	        	
	        	firstNumber = num3;
	        	if(decision == 1)
	        	{
	        		secondNumber = num1;
	        		result = num2;
	        	}
	        	
	        	else
	        	{
	        		secondNumber = num2;
	        		result = num1;
	        	}
	            break;
	             
	        default: ;
	            break;
	        }
		}
		
		public int[] getNumbers()
		{
			return new int[] {firstNumber, secondNumber, result};
		}
		
		public Operator getOperator()
		{
			return this.operator;
		}
		   
}
