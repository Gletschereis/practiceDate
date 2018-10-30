import java.util.Scanner;

class Date{
    int day;
    String month;
    int year;
    String weekday;
}

public class Gaußer_Datum {
    static int calculateFirstOfJanuary(Date x){
        //method calculateFirstOfJanuary calculates what day the first January of year x is returns a value between 0 and 6 ;
        int firstJanuary = (1 + 5 * ((x.year - 1) % 4) + 4 * ((x.year - 1) % 100) + 6 * ((x.year - 1) % 400)) % 7;
        return firstJanuary;
    }
    static int calculateEnteredDate(Date x){
        int temp = convertXdotMonthtoInt(x);
        int sum = 0;
        int [] months = convertMonthsToIntArray(x);
        for (int i = 0; i < temp; i++){
            sum += months[i];
        }
        sum += x.day;
        sum = sum % 7;
        int [] arrayWeekdays = new int [7];
        int tempHelp = 0;
        for (int i = 0; i <arrayWeekdays.length; i++){
            arrayWeekdays [i] = calculateFirstOfJanuary(x) + tempHelp;
            if (arrayWeekdays[i] > 6){
                tempHelp = 0;
                for (int j = i; j < arrayWeekdays.length; j++){
                    arrayWeekdays [j] = tempHelp;
                    tempHelp++;
                }
                i = arrayWeekdays.length;
            }
            tempHelp++;
        }
        int value = arrayWeekdays [sum];
        if (value == 0){
            return 6;
        } else {
            return value - 1;
        }
    }
    static String generateIntToString (Date x){
        //method generateIntToString declares and initialize an array (array.length = 7) index [0] starts with Sunday;
        String [] weekdays = new String [7];
        weekdays [0] = "Sunday";
        weekdays [1] = "Monday";
        weekdays [2] = "Tuesday";
        weekdays [3] = "Wednesday";
        weekdays [4] = "Thursday";
        weekdays [5] = "Friday";
        weekdays [6] = "Saturday";
        String weekday = weekdays[calculateEnteredDate(x)];
        return weekday;
    }
    static boolean checkIfLeapyear(Date x){
        //method checkIfLeapyear checks if the entered year is a leap year, if true returns true, else false;
        if (x.year == 0){
            return true;
        } else if (x.year % 4 == 0 && x.year %100 != 0){
            return true;
        } else if (x.year % 400 == 0){
            return true;
        } else{
            return false;
        }
    }
    static int [] convertMonthsToIntArray (Date x ){
        //method convertMonthsToIntArray sets how many days each month have index [0] is the month January;
        int [] months = new int [12];
        months [0] = 31;
        if (checkIfLeapyear(x)){
            months [1] = 29;
        } else {
            months [1] = 28;
        }
        months [2] = 31;
        months [3] = 30;
        months [4] = 31;
        months [5] = 30;
        months [6] = 31;
        months [7] = 31;
        months [8] = 30;
        months [9] = 31;
        months [10] = 30;
        months [11] = 31;
        return months;
    }
    static int convertXdotMonthtoInt(Date x){
        /*method converXdotMonthtoInt checks if entered String equals a month and returns the corresponding number from the month, if
        no month matches returns -1; */
        if (x.month.equals("January")){
            return 0;
        } else if (x.month.equals("February")){
            return 1;
        } else if (x.month.equals("March")){
            return 2;
        } else if (x.month.equals("April")){
            return 3;
        } else if (x.month.equals("May")){
            return 4;
        } else if (x.month.equals("June")){
            return 5;
        } else if (x.month.equals("July")){
            return 6;
        } else if (x.month.equals("August")){
            return 7;
        } else if (x.month.equals("September")){
            return 8;
        } else if (x.month.equals("October")){
            return 9;
        } else if (x.month.equals("November")){
            return 10;
        } else if (x.month.equals("December")){
            return 11;
        } else{
            return - 1;
        }
    }

    public static void main (String [] args){
        System.out.println("Please enter a date:");
        Date x;
        x = new Date();
        Scanner valueX = new Scanner(System.in);
        System.out.print("(int) day:");
        x.day = valueX.nextInt();
        System.out.print("(String) month:");
        x.month = valueX.next();
        System.out.print("(int) year: (>=1553)");
        x.year = valueX.nextInt();
        x.weekday = generateIntToString(x);
        System.out.println(x.day + ". " + x.month + " " + x.year + " was a " + x.weekday + ".");




    }
}
