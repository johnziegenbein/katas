public class Runes {
  public static int solveExpression(final String expression) {
    final String operators = "+-*";

    String operator = "";

    StringBuilder leftExpressionBuilder = new StringBuilder();
    StringBuilder rightExpressionBuilder = new StringBuilder();
    StringBuilder termBuilder = new StringBuilder();

    boolean leftExpressionFilled = false;
    boolean rightExpressionFilled = false;

    StringBuilder digitsFound = new StringBuilder();

    // set left expression, right expression and term
    for (char c : expression.toCharArray()) {
      if (Character.isDigit(c)) {
        // Save which digits that are known
        digitsFound.append(c);
      }
      if (Character.isDigit(c) || c == '?' ||
          declaresNegativeNumber(leftExpressionBuilder.toString(),
              rightExpressionBuilder.toString(),
              leftExpressionFilled,
              rightExpressionFilled,
              c)) {
        if (!leftExpressionFilled) {
          leftExpressionBuilder.append(c);
        } else if (!rightExpressionFilled) {
          rightExpressionBuilder.append(c);
        } else {
          termBuilder.append(c);
        }
      } else if (operators.contains(Character.toString(c))) {
        operator = Character.toString(c);
        leftExpressionFilled = true;
      } else if (c == '=') {
        rightExpressionFilled = true;
      }
    }

    // Increment ? with 1 until true
    return SolveEquation(operator,
        leftExpressionBuilder.toString(),
        rightExpressionBuilder.toString(),
        termBuilder.toString(),
        digitsFound.toString());
  }

  private static boolean declaresNegativeNumber(String leftExpressionBuilder, String rightExpressionBuilder,
                                                boolean leftExpressionFilled, boolean rightExpressionFilled, char c) {
    return (c == '-' && !leftExpressionFilled && leftExpressionBuilder.equals("")) ||
        (c == '-' && leftExpressionFilled && !rightExpressionFilled && rightExpressionBuilder.equals("")) ||
        (c == '-' && leftExpressionFilled && rightExpressionFilled);
  }

  private static Integer SolveEquation(String operator,
                                       String leftExpressionBuilder,
                                       String rightExpressionBuilder,
                                       String termBuilder,
                                       String digitsFound) {
    for (int i = 0; i < 10; i++) {
      if (digitsFound.contains(String.valueOf(i))) {
        continue;
      }

      String leftExpression = leftExpressionBuilder.replace("?", String.valueOf(i));
      String rightExpression = rightExpressionBuilder.replace("?", String.valueOf(i));
      String term = termBuilder.replace("?", String.valueOf(i));

      if (leftExpression.matches("0[0-9]") ||
          rightExpression.matches("0[0-9]") ||
          term.matches("0[0-9]")) {
        continue;
      }

      int left = Integer.parseInt(leftExpression);
      int right = Integer.parseInt(rightExpression);
      int intTerm = Integer.parseInt(term);

      int expressionValue = 0;
      switch (operator) {
        case "*":
          expressionValue = left * right;
          break;
        case "+":
          expressionValue = left + right;
          break;
        case "-":
          expressionValue = left - right;
          break;
      }

      if (expressionValue == intTerm) {
        return i;
      }
    }
    return -1;
  }

}