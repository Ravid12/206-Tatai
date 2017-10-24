package application.model;

import java.util.ArrayList;
import java.util.Random;

public class Equation{

		private int max;
		private int min;
		private int firstNumber;
		private int secondNumber;
		private int result;
		private Operator operator;
		
		
		
		
		/**
		 * Constructor for Equation object
		 * @param operator: The operator that is used in the equation
		 * @param maxVal: The Lower bound for values that can appear in the equation
		 * @param minVal: The Upper bound for values that can appear in the equation
		 */
		
		public Equation(Operator operator, int maxVal, int minVal)
		{
			Random rand = new Random();
			
			this.operator = operator;
			this.max = maxVal;
			this.min = minVal;
			this.result = rand.nextInt((max - min) + 1) + min;
			
	        switch (operator) {
	        case ADDITION:
	        	this.result = rand.nextInt((max - 2*min) + 1) + 2*min;
	        	firstNumber = rand.nextInt((result - min - min) + 1) + min;
	        	secondNumber = result - firstNumber;
	            break;
	            
	        case SUBTRACTION:
	        	this.result = rand.nextInt((max - min - min) + 1) + min;
	        	firstNumber = rand.nextInt((max - (result + min)) + 1) + result + min;
	        	secondNumber = firstNumber - result;
	            break;
	             
	        case MULTIPLICATION:
	        	ArrayList<Integer> al = new ArrayList<Integer>();
	        	
	    		for(int i = 1; i <= result; i++) {
	    			if(result%i == 0) {
	    				al.add(i);
	    			}
	    		}
	    		
	    		Random factorDecider = new Random();
	    		int index = factorDecider.nextInt((al.size() -1 - 0) + 1) + 0;
	    		
	    		Random decider = new Random();
	        	int decision = decider.nextInt((2 - 1) + 1) + 1;
	        	
	        	if(decision == 1) {
	        		firstNumber = al.get(index);
	        		secondNumber = result / firstNumber;
	        	} 
	        	
	        	else {
	        		secondNumber = al.get(index);
	        		firstNumber = result / secondNumber;
	        		
	        	}
	    		
	    		
	            break;
	             
	        case DIVISION:
	        	secondNumber = rand.nextInt(((max / result) - min) + 1) + min;
	        	firstNumber = secondNumber * result;
	            break;
	             
	        default: ;
	            break;
	        }
		}
		
		
		
		
		public int getResult() {
			return result;
		}
		
		
		
		
		public Operator getOperator() {
			return this.operator;
		}
		
		
		
		
		/**
		 * Returns a string that represents the equation for user to solve
		 */
		
		@Override
		public String toString() {
			return firstNumber + " " + operator.toString() + " " + secondNumber;
		   
		}
}
