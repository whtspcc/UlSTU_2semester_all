import java.util.Random;

// номер 3

public class task1 {
	public static void main(String[] args) {
		int[] arr = new int[10];
        Random random = new Random();
        
        System.out.println("Исходный массив:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(200);
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n\n");

        int[] evenDigits = new int[10];
        int[] oddDigits = new int[10];

        for (int num : arr) {
            int temp = Math.abs(num);
            int[] currentMap = (num % 2 == 0) ? evenDigits : oddDigits;
            
            if (temp == 0) currentMap[0]++;
            while (temp > 0) {
                currentMap[temp % 10]++;
                temp /= 10;
            }
        }

        int evenRepeats = 0, oddRepeats = 0;
        
        System.out.println("повторы в четных числах:");
        for (int i = 0; i < 10; i++) {
            if (evenDigits[i] > 1) {
                System.out.println("цифра " + i + ": " + evenDigits[i] + " раз");
                evenRepeats++;
            }
        }

        System.out.println("\nповторы в нечетных числах:");
        for (int i = 0; i < 10; i++) {
            if (oddDigits[i] > 1) {
                System.out.println("цифра " + i + ": " + oddDigits[i] + " раз");
                oddRepeats++;
            }
        }

        System.out.println("\nИтог: " + (evenRepeats > oddRepeats ? "В ЧЕТНЫХ БОЛЬШЕ" : "В НЕЧЕТНЫХ БОЛЬШЕ"));
    }
}