import java.util.Stack;

public class MathCalculations {

    public double reversePolishNotationToAnswer(String rpn) throws IllegalArgumentException{
        StringBuilder oper = new StringBuilder();
        Stack<Double> stack = new Stack<>();


        for (int i = 0; i < rpn.length(); i++) {
            if (rpn.charAt(i) == ' ') {
                continue;
            }
            if (Calculator.determiningPriority(rpn.charAt(i)) == 0) {
                while (rpn.charAt(i) != ' ' && Calculator.determiningPriority(rpn.charAt(i)) == 0) {
                    oper.append(rpn.charAt(i++));
                    if (i == rpn.length()) {
                        break;
                    }
                }
                stack.push(Double.parseDouble(oper.toString()));
                oper = new StringBuilder();
            }
            if (Calculator.determiningPriority(rpn.charAt(i)) > 1) {
                double x = stack.pop(), y = stack.pop();
                if (rpn.charAt(i) == '+') {
                    stack.push(y + x);
                }
                if (rpn.charAt(i) == '-') {
                    stack.push(y - x);
                }
                if (rpn.charAt(i) == '*') {
                    stack.push(y * x);
                }
                if (rpn.charAt(i) == '/') {
                    if(x == 0){
                        throw new IllegalArgumentException();
                    }else{
                        stack.push(y / x);
                    }
                }
            }
        }

        return stack.pop();
    }
}
