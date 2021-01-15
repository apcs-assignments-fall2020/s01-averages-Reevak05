import java.util.ArrayList;

public class MyMain {

    // Returns the mean of the 2D array mat
    public static double mean(double[][] mat) { 
        // YOUR CODE HERE
        double sum = 0;
        for (double[] row: mat) {
            for (double value: row) {
                sum+=value;
            }
        }
        return sum/(mat.length*mat[0].length);
    }

    // Returns the median of the 2D array mat
    public static double median(double[][] mat) { 
        // YOUR CODE HERE
        ArrayList<Double> matValues = new ArrayList<>();
        for (double[] row: mat) for (double value: row) matValues.add(value);
        if (matValues.size()%2==0) return (matValues.get(matValues.size()/2-1) + matValues.get(matValues.size()/2))/2;
        else return matValues.get(matValues.size()/2);
    }
    

    // Returns the mode of the 2D array mat
    public static double mode(double[][] mat) { 
        // YOUR CODE HERE
        ArrayList<Double> values = new ArrayList<>();
        ArrayList<Integer> occurrences = new ArrayList<>();
        for (double[] row: mat) for (double value: row) {
                if (values.indexOf(value) == -1) {
                    values.add(value);
                    occurrences.add(1);
                }
                else occurrences.set(values.indexOf(value), occurrences.get(values.indexOf(value))+1);
        }
        int max = occurrences.get(0);
        for (Integer valueOccurrences: occurrences) if (valueOccurrences>max) max = valueOccurrences;
        return values.get(occurrences.indexOf(max));
    }


    public static void main(String[] args) {
        // Write some code here to test your methods!
        double[][] mat1 = new double[][]{{1, 1, 2, 3, 4, 4}, {4, 5, 5, 5, 6, 6}, {7, 8, 8, 8, 8, 9}, {9, 9, 10, 11, 12, 12}};
        System.out.println("matrix:");
        for (double[] row: mat1) {
            for (double value: row) {
                System.out.print((int)value + " ");
            }
            System.out.println();
        }
        System.out.println("mean: " + mean(mat1));
        System.out.println("median: " + median(mat1));
        System.out.println("mode: " + mode(mat1));
    }
}
