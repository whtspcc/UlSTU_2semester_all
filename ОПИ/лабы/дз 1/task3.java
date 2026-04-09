import java.util.Scanner;

// номер 10
public class task3 {
    	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        	int number = scanner.nextInt();
        	int[] counts = new int[10];
        
        	int temp = Math.abs(number);

        	if (temp == 0) {
            		counts[0]++;
        	}

        	while (temp > 0) {
            		int digit = temp % 10;
            		counts[digit]++;
            		temp /= 10;
        	}

        	System.out.print("Повторяющиеся цифры: ");
        	boolean found = false;
        
        	for (int i = 0; i < 10; i++) {
            		if (counts[i] > 1) {
                		System.out.print(i + " ");
                		found = true;
            		}	
        	}
        
        	if (!found) {
            		System.out.print("нет повторяющихся цифр");
        	}

        System.out.println();
    	}
}