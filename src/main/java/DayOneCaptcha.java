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

    int captchaHalfwaySum(String input){
        int sum = 0;
        for (int i = 0; i < input.length()/2; i++) {
            char next = input.charAt(i + input.length()/2);
            char current = input.charAt(i);
            if (current == next) {
                sum += Character.getNumericValue(current);
            }
        }
        sum = sum * 2;
        return sum;
    }
}
