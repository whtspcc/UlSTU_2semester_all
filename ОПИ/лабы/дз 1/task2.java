import java.util.Scanner;

// номер 9

public class task2 {
    	public static void main(String[] args) {
        	Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

        	String result = "";

        	if (n % 2 == 0) {
            		result = "четное ";
        	} else {
            		result = "нечетное ";
        	}

        	if (n < 10) {
            		result += "однозначное ";
        	} else if (n < 100) {
            		result += "двузначное ";
        	} else if (n < 1000) {
            		result += "трехзначное ";
        	} else {
            		result += "четырехзначное ";
        	}

        	result += "число";
        	System.out.println(result);
    	}
}