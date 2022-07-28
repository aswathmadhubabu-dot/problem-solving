import java.util.Arrays;
import java.util.Stack;

class DailyTemperatures {
    class Temperature {
        int answer;
        int temperature;

        public Temperature(int answer, int temperature) {
            this.answer = answer;
            this.temperature = temperature;
        }
    }

    Stack<Temperature> temp;

    public int[] dailyTemperatures(int[] temperatures) {
        temp = new Stack<>();

        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = n - 1; i > 0; i--) {
            int count = 0;
            while (!temp.isEmpty() && temp.peek().temperature >= temperatures[i]) {
                count++;
                temp.pop();
            }

            temp.add(new Temperature(count, temperatures[i]));
            result[i] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(temp)));
    }
}