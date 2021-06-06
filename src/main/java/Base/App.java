/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package Base;

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main( String[] args )
    {
        String gender = getGender();
        String totalOZ = getOZ();
        String weight = getWeight();
        String hours = getHours();
        double weightNum = stringToDouble(weight);
        double OZNum = stringToDouble(totalOZ);
        double hoursNum = stringToDouble(hours);
        double BAC = calcBAC(gender, weightNum, OZNum, hoursNum);
        printOutput(BAC);
    }
    public static String getWeight()
    {
        System.out.println( "Please enter your weight: " );
        String input = in.nextLine();

        boolean validFlag = false;
        while(!validFlag)
        try
        {
            Double.parseDouble(input);
            validFlag = true;
        }
        catch (NumberFormatException e)
        {
            System.out.println("Please enter a valid number: ");
            input = in.nextLine();
        }
        return input;
    }

    public static String getGender()
    {
        System.out.println( "Please enter your Gender (M/F): " );
        return in.nextLine();
    }

    public static String getOZ()
    {
        System.out.println( "Please enter the number of ounces you drank: " );
        String input = in.nextLine();

        boolean validFlag = false;
        while(!validFlag)
            try
            {
                Double.parseDouble(input);
                validFlag = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a valid number: ");
                input = in.nextLine();
            }
        return input;
    }

    public static String getHours()
    {
        System.out.println( "Please enter the number of hours since you last drank: " );
        String input = in.nextLine();

        boolean validFlag = false;
        while(!validFlag)
            try
            {
                Double.parseDouble(input);
                validFlag = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a valid number: ");
                input = in.nextLine();
            }
        return input;
    }

    public static double stringToDouble(String number)
    {
        return Double.parseDouble(number);
    }

    public static double calcBAC(String gender, double weightNum, double OZNum, double hoursNum)
    {
        if (gender.equals("F") || gender.equals("f"))
        {
            return ((OZNum * 5.14 / weightNum * 0.66) - 0.015 * hoursNum);
        }
        else if (gender.equals("M")|| gender.equals("m"))
        {
            return ((OZNum * 5.14 / weightNum * 0.73) - 0.015 * hoursNum);
        }
        else return -1;
    }

    public static void printOutput(double BAC)
    {
        if (BAC < 0)
        {
            System.out.print("Your BAC is 0.000\n");
        }
        else System.out.printf("Your BAC is %.3f\n", BAC);

        if(BAC > 0.08)
        {
            System.out.print("It is not legal for you to drive.");
        }
        else System.out.print("It is legal for you to drive");
    }
}
