import java.util.Stack;

    public class Calculator {
        public  double decide(String expression) throws IllegalArgumentException{
            LineInExpression lineInExpression = new LineInExpression();
            MathCalculations mathCalculations = new MathCalculations();
            String prepared = preparingExpression(expression);
            String rpn = lineInExpression.reversePolishNotation(prepared);
            return  mathCalculations.reversePolishNotationToAnswer(rpn);
        }

        private String preparingExpression(String expression){
            StringBuilder preparingExpression = new StringBuilder();
            for(int i = 0;i < expression.length();i++){
                char symbol = expression.charAt(i);
                if(symbol == '-'){
                    if(i == 0){
                        preparingExpression.append('0');
                    }
                    else if(expression.charAt(i-1) == '('){
                        preparingExpression.append(0);
                    }
                }
                preparingExpression.append(symbol);
            }
            return preparingExpression.toString();
        }


        public static int determiningPriority(char sign) {
            if (sign == '*' || sign == '/') {
                return 3;
            } else if (sign == '+' || sign == '-') {
                return 2;
            } else if (sign == '(') {
                return 1;
            } else if (sign == ')') {
                return -1;
            } else {
                return 0;
            }
        }
    }

