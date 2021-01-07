import java.util.Stack;

public class LineInExpression {
    public String reversePolishNotation(String expr) {
        StringBuilder current = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int priority;

        for (int i = 0; i < expr.length(); i++) {
            priority = Calculator.determiningPriority(expr.charAt(i));
            if (priority == 0) {
                current.append(expr.charAt(i));
            }
            if (priority == 1) {
                stack.push(expr.charAt(i));
            }
            if (priority > 1) {
                current.append(' ');
                while (!stack.empty()) {
                    if (Calculator.determiningPriority(stack.peek()) >= priority) {
                        current.append(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(expr.charAt(i));
            }
            if (priority == -1){
                current.append(' ');
                while (Calculator.determiningPriority(stack.peek()) != 1){
                    current.append(stack.pop());
                }
                stack.pop();
            }
        }
        while (!stack.empty()){
            current.append(stack.pop());
        }

        return current.toString();
    }
}
