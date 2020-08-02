	import java.util.Scanner;

	public class FooProblem {
		private static double min_wage = 8.0;
		private static int max_hours = 60;
		// avoid using static methods
		// adopt OO
		// avoid if else statements
		// variable naming convention
		// unable to test
		// have to have a proper return type - no void
		// validation not there eg : -1
		// system.out.println should not be used
		public static void salaryCalculation(double basePay, int hoursWorked) {
			double totalSalary;
			if ((!(basePay < min_wage)) && (hoursWorked <= max_hours)) {
				totalSalary = hoursWorked > 40 ? basePay * 40 + 1.5 * basePay * (hoursWorked - 40) : basePay * hoursWorked;
				System.out.println("total salary : " + totalSalary);
			} else {
				System.out.println("Error!");
			}
		}

		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the total no.of employees in foo corp: ");
			int n = scanner.nextInt();
			int i = 1;
			while (i <= n) {
				System.out.println("Enter details for emp id: " + i + " ");
				System.out.println("base pay: ");
				double base_pay = scanner.nextDouble();
				System.out.println("total hours worked: ");
				int hours_worked = scanner.nextInt();
				salaryCalculation(base_pay, hours_worked);
				i++;
			}
		}
	}
