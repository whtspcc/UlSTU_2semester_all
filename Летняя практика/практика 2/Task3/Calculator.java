package Task3;

public class Calculator<T extends Number> {
    public double divide(T a, T b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("На ноль делить нельзя");
        }

        return a.doubleValue() / b.doubleValue();
    }
}