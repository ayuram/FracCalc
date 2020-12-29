public class FracCalcTestHelper
{
    public static boolean areFracsEqual(String answer, String candidate)
    {
        int answerNumerator = parseValue(answer, 1);
        int answerDenominator = parseValue(answer, 2);
        int answerWhole = parseValue(answer, 3);

        boolean isNegative = answerWhole < 0;
        answerNumerator += Math.abs(answerWhole) * answerDenominator;
        if (isNegative) {
            answerNumerator *= -1;
        }
        int candidateNumerator = parseValue(candidate, 1);
        int candidateDenominator = parseValue(candidate, 2);
        int candidateWhole = parseValue(candidate, 3);
        if (candidateDenominator == 0) {
            return false;
        }
        isNegative = candidateWhole < 0;
        candidateNumerator += Math.abs(candidateWhole) * candidateDenominator;
        if (isNegative) {
            candidateNumerator *= -1;
        }
        return answerNumerator * candidateDenominator == candidateNumerator * answerDenominator;
    }

    private static int parseValue(String value, int what)
    {
        int whole = 0;
        int num = 0;
        int den = 1;

        int iUnderscore = value.indexOf("_");
        int iWholeEnd = iUnderscore;
        int iNum = iUnderscore + 1;
        int iSlash = value.indexOf("/");
        if (iUnderscore == -1)
        {
            if (iSlash == -1) {
                iWholeEnd = value.length();
            } else {
                iWholeEnd = 0;
            }
        }
        else
        {
            if (iSlash == -1) {
                return 0;
            }
            iWholeEnd = iUnderscore;
        }
        if (iWholeEnd != 0)
        {
            String wholeString = value.substring(0, iWholeEnd);
            if (!isInteger(wholeString)) {
                return 0;
            }
            whole = Integer.parseInt(wholeString);
        }
        if (iSlash == -1)
        {
            if (what == 0) {
                return 1;
            }
            if (what == 1) {
                return 0;
            }
            if (what == 2) {
                return 1;
            }
            return whole;
        }
        String numString = value.substring(iNum, iSlash);
        if (!isInteger(numString)) {
            return 0;
        }
        num = Integer.parseInt(numString);

        String denString = value.substring(iSlash + 1);
        if (!isInteger(denString)) {
            return 0;
        }
        den = Integer.parseInt(denString);
        if (what == 0) {
            return 1;
        }
        if (den < 0)
        {
            den *= -1;
            num *= -1;
        }
        if (what == 1) {
            return num;
        }
        if (what == 2) {
            return den;
        }
        return whole;
    }

    private static boolean isInteger(String s)
    {
        int i = 0;
        if (s.charAt(0) == '-') {}
        for (i = 1; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if ((c < '0') || (c > '9')) {
                return false;
            }
        }
        return true;
    }
}

