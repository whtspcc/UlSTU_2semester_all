public class ArrayParser {

    public static int[] parse1D(String text) {
        text = text.replace(",", " ");

        String[] parts = text.trim().split("\\s+");
        int[] array = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i]);
        }

        return array;
    }

    public static int[][] parse2D(String text) {

        String[] lines = text.trim().split("\\n");
        int rows = lines.length;

        String[] first = lines[0].trim().split("\\s+");
        int cols = first.length;

        int[][] array = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            String[] numbers = lines[i].trim().split("\\s+");

            for (int j = 0; j < cols; j++) {
                array[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        return array;
    }

}