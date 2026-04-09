import java.util.Scanner;

// задание номер 8

public class task1 {
    	public static void main(String[] args) {
        	Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

        	String result = "";

        	if (n == 0) {
            		result = "нулевое число";
        	} else {
            		result = (n > 0) ? "положительное " : "отрицательное ";
            
            	int absN = Math.abs(n);
            	if (absN < 10) result += "однозначное ";
            	else if (absN < 100) result += "двузначное ";
           	else result += "трехзначное ";
            
           	result += "число";
        	}

        	System.out.println(result);
    	}
}