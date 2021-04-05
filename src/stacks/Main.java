package stacks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import errors.StackOverflowException;
import errors.StackUnderflowException;

public class Main {

    private static final Map<Character, Character> matchingParenMap = new HashMap<>();
    private static final Set<Character> openingParenSet = new HashSet<>();

    static {
        matchingParenMap.put(')', '(');
        matchingParenMap.put(']', '[');
        matchingParenMap.put('}', '{');
        openingParenSet.addAll(matchingParenMap.values());
    }


	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		Stack newStack = new Stack();

		newStack.push("word1");
		newStack.push("word2");
		newStack.push("word3");

		System.out.println(newStack.pop());

		System.out.println(newStack.getSize());

        System.out.println(String.format(
                "Has matching parens %s : %s", "(abcd)", hasMatchingParens("(abcd)")));
        System.out.println(String.format(
                "Has matching parens %s : %s", "{{{{}}", hasMatchingParens("{{{{}}")));
        System.out.println(String.format(
                "Has matching parens %s : %s", "{{{{}}})", hasMatchingParens("{{{{}}})")));
        System.out.println(String.format(
                "Has matching parens %s : %s", "{{{}}}()", hasMatchingParens("{{{}}}()")));
        System.out.println(String.format(
                "Has matching parens %s : %s", "{{{}}]()", hasMatchingParens("{{{}}]()")));
        System.out.println(String.format(
                "Has matching parens %s : %s", "{{}}([]){}{}{}{}{[[[[]]]]}",
                hasMatchingParens("{{}}([]){}{}{}{}{[[[[]]]]}")));

        
        MinimumStack minStack = new MinimumStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(2);
        minStack.push(4);
        minStack.push(6);
        minStack.push(8);
        
        System.out.println(String.format("Minimum value in minStack is: %s", minStack.getMinimum()));
        
	}

    public static boolean hasMatchingParens(String input) {

        try {
            Stack<Character> parenStack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                // Add to the stack for an opening paren.
                if (openingParenSet.contains(ch)) {
                    parenStack.push(ch);
                }
                if (matchingParenMap.containsKey(ch)) {
                    Character lastParen = parenStack.pop();
                    if (lastParen != matchingParenMap.get(ch)) {
                        return false;
                    }
                }
            }

            return parenStack.isEmpty();
        } catch (StackOverflowException soe) {
            System.err.println("Stack Overflow");
        } catch (StackUnderflowException sue) {
            System.err.println("Stack Underflow");
        }

        return false;
    }

}
