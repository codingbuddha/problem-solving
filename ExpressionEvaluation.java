/* A Java program to evaluate a given expression where tokens are separated 
   by space.
   Test Cases:
     "10 + 2 * 6"            ---> 22
     "100 * 2 + 12"          ---> 212
     "100 * ( 2 + 12 )"      ---> 1400
     "100 * ( 2 + 12 ) / 14" ---> 100    
*/

/*  Bug 1000 : 100 * ( 2 + 12 ) / 14 giving output 100 */

import java.util.*;

	public class ExpressionEvaluation {
		
		public int evaluateExpression (String expression){
				
			char[] tokens = expression.toCharArray();
			Stack<Integer> values = new Stack<Integer>();
			Stack<Character> ops = new Stack<Character>();
			Set<Character> operators = new HashSet<Character>();
			
			operators.add('+');
			operators.add('-');
			operators.add('*');
			operators.add('/');

			for(int i = 0 ; i < tokens.length ; i++){
				
				if(tokens[i] == ' ')
					continue;
				
				if(tokens[i] == '(' )
					ops.push(tokens[i]);
				//There may be more than one digit in a number
				else if(tokens[i] >= '0' &&  tokens[i] <= '9'){ 
					StringBuffer sbuf = new StringBuffer();
					while(i < tokens.length && tokens[i] >= '0' &&  tokens[i] <= '9')
						sbuf.append(tokens[i++]);																
					
					values.push(Integer.parseInt(sbuf.toString()));						
				} else if(tokens[i] == ')'){					
					while(ops.peek() != '(')
						values.push(compute(values.pop(), values.pop(), ops.pop()));					
					
					ops.pop();						
				} else if(operators.contains(tokens[i])){
					while(!ops.isEmpty() && hasPrecedence(tokens[i], ops.peek()) )
						values.push(compute(values.pop(), values.pop(), ops.pop()));	
					
					ops.push(tokens[i]);
				}
									
			}			
			while(!ops.isEmpty())
				values.push(compute(values.pop(), values.pop(), ops.pop()));	
			
			return values.pop();
		}
		
		/** 
		* Utility to apply operation on two operands 
		*/
		public int compute(int a, int b, char op){
			
			switch(op){
				case '+' :  return a + b;
				case '-' :  return a - b;
				case '*' :  return a * b;
				case '/' :  
					if(b == 0)
						throw new UnsupportedOperationException("Can not divide by zero");
					return a / b;				
			}
			return 0;
		}
		// Utility to check precedence of two operators
		public boolean hasPrecedence(char op1, char op2){
			
			if(op2 == '(' || op2 == ')' )
				return false;
			
			if(  (op1 == '*' || op1 == '/') && (op2 == '+' || op1 == '-')  )
				return false;
			else
				return true;
		}
		public static void main(String[] args){

			String expression = "100 * ( 2 + 12 ) / 14";
			ExpressionEvaluation problem = new ExpressionEvaluation();			
			 System.out.println(problem.evaluateExpression("10 + 2 * 6"));
			System.out.println(problem.evaluateExpression("100 * 2 + 12"));
			System.out.println(problem.evaluateExpression("100 * ( 2 + 12 )"));
			System.out.println(problem.evaluateExpression("100 * ( 2 + 12 ) / 14"));
		}
	}