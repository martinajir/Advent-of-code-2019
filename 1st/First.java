import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.nio.file.*;

class First {
    public static void main(String[] args) throws FileNotFoundException{
        //System.out.println(new File(".").getAbsolutePath());
        ArrayList<Integer> masses = parseFile("./Desktop/input.txt");
        int finalSum = 0;
        
        for(int i = 0; i < masses.size(); i++){
            int fuel = (int)Math.floor(masses.get(i)/3) - 2;
            int thisSum = 0;
            while(fuel >= 0){
                thisSum += fuel;
                fuel = (int)Math.floor(fuel/3) - 2;
            }
            finalSum += thisSum;
        }

    
        System.out.println(finalSum);

    }

    public static ArrayList<Integer> parseFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        ArrayList<Integer> resultingArray = new ArrayList<>();

        while (sc.hasNextLine()){
            int thisInt = Integer.parseInt(sc.nextLine());
            resultingArray.add(thisInt);
        }

        return resultingArray;
    }
}