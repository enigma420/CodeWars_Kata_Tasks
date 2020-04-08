package kyu_5.LargestRectangleInBackground;

public class Histogram {

    private final int[] values;

    public Histogram(int... values) {
        this.values = values;
    }

    public long largestRect() {
        long theHighestNumberOfStarsInQuadrate = 0;
        for(int i = 1 ; i <= values.length ; i++){
            int k = 0;
           for(int j = 0 ; j < values.length ; j++){
                if(values[j] >= i){
                    k++;
                    if(k*i > theHighestNumberOfStarsInQuadrate) theHighestNumberOfStarsInQuadrate = k*i;
                }else {
                    k = 0;
                }
            }
        }
        return theHighestNumberOfStarsInQuadrate;
    }

    public static void main(String[] args){

        Histogram histogram = new Histogram(3, 5, 12, 4, 10);
        Histogram histogram1 = new Histogram(6, 2, 5, 4, 5, 1, 6);

        long result = histogram1.largestRect();

    }

}
