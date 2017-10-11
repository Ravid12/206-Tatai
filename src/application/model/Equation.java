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
		
		public Equation(Operator operator, int maxVal, int minVal)
		{
			Random rand = new Random();
			
			this.operator = operator;
			this.max = maxVal;
			this.min = minVal;
			this.result = rand.nextInt((max - min) + 1) + min;
			
	        switch (operator) {
	        
	        case ADDITION:
	        	
	        	firstNumber = rand.nextInt((result - min - min) + 1) + min;
	        	secondNumber = firstNumber - result;
	            break;
	            
	        case SUBTRACTION:
	        	firstNumber = rand.nextInt((max - result) + 1) + result;
	        	secondNumber = firstNumber + result;
	            break;
	             
	        case MULTIPLICATION:
	        	ArrayList<Integer> al = new ArrayList<Integer>();
	        	
	    		for(int i = 1; i <= result; i++) {
	    			if(result%i == 0) {
	    				al.add(i);
	    			}
	    		}
	    		
	    		Random factorDecider = new Random();
	    		int index = factorDecider.nextInt((al.size() - 0) + 1) + 0;
	    		
	    		Random decider = new Random();
	        	int decision = decider.nextInt((2 - 1) + 1) + 1;
	        	
	        	if(decision == 1)
	        	{
	        		firstNumber = al.get(index);
	        		secondNumber = result / firstNumber;
	        	}
	        	
	        	else
	        	{
	        		secondNumber = al.get(index);
	        		firstNumber = result / firstNumber;
	        		
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
		
		public int[] getNumbers()
		{
			return new int[] {firstNumber, secondNumber, result};
		}
		
		public Operator getOperator()
		{
			return this.operator;
		}
 
}
