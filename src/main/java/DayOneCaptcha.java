public class DayOneCaptcha {
    int captchaSum(String input) {
        int sum = 0;
        input = input + input.charAt(0);
        for (int i = 0; i < input.length() - 1; i++) {
            char next = input.charAt(i + 1);
            char current = input.charAt(i);
            if (current == next) {
                sum += Character.getNumericValue(current);
            }
        }
        return sum;
    }
}
