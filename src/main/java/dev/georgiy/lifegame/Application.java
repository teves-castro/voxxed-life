package dev.georgiy.lifegame;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.*;


public class Application {
    private Application (){}

    public static void main(String... args){
        out.println("Welcome to the Life-Game");
        Set<Point> points = new HashSet<>();
        Scanner scanner = new Scanner(in);
        out.println("Please enter seeds location:");
        String exitKey="";
        while(!exitKey.equals("q")){
            out.println("Please enter seeds location X:");
            int x = scanner.nextInt();
            out.println("Please enter seeds location Y:");
            int y = scanner.nextInt();
            points.add(new PointIntImpl(x,y));
            scanner.nextLine();
            out.println("Press enter to add one more point, enter q to proceed");
            exitKey = scanner.nextLine();
        }
        out.println("The initial seed is:");
        out.println(points);
        out.println("Please enter number of generations:");
        int generations = scanner.nextInt();
        Set<Point> newPoints = points;
        for(int i=0; i< generations; i++){
            newPoints = RoundUtils.getNextGeneration(newPoints);
        }
        out.println();
        out.println("Generations result");
        out.println(newPoints);


    }
}
