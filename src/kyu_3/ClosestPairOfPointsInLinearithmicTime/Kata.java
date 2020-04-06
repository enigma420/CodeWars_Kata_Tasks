package kyu_3.ClosestPairOfPointsInLinearithmicTime;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static java.lang.Math.*;

public class Kata {

    public static List<Point> closestPair(List<Point> points) {
        Point point_1 = null;
        Point point_2 = null;
        if(points.size() == 0) return Collections.emptyList();

            double distance = Double.MAX_VALUE;
            Point[] arrayOfPoints = new Point[points.size()];
            points.toArray(arrayOfPoints);
            for (int i = 0 ; i <= arrayOfPoints.length-1 ; i++){
                for(int j = i+1 ; j <= arrayOfPoints.length-1 ; j++){
                    if(distance >= countDistanceBetweenPoints(arrayOfPoints[i],arrayOfPoints[j])){
                        point_1 = arrayOfPoints[i];
                        point_2 = arrayOfPoints[j];
                        distance = countDistanceBetweenPoints(arrayOfPoints[i],arrayOfPoints[j]);
                    }
                }
            }
        return Arrays.asList(point_1,point_2);
    }

    public static double countDistanceBetweenPoints(Point point_1, Point point_2){
        double distance = 0.0;
        double x = pow((point_1.x-point_2.x),2.0);
        double y = pow((point_1.y-point_2.y),2.0);
        distance = sqrt(x+y);

        return distance;
    }
    public static void main(String[] args){
        List<Point> points = Arrays.asList(
                new Point(2, 2), //A
                new Point(2, 8), //B
                new Point(5, 5), //C
                new Point(6, 3), //D
                new Point(6, 7), //E
                new Point(7, 4), //F
                new Point(7, 9)  //G
        );

        List<Point> result = closestPair(points);

    }

}
