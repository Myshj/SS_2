import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        while (true) {
            // Local variable
            int swValue;

            // Display menu graphics
            showMainMenu();
            swValue = Keyin.inInt(" Select option: ");

            // Switch construct
            switch (swValue) {
                case 1:
                    System.out.println("Show current weather.");
                    showCurrentWeather();
                    break;
                case 2:
                    System.out.println("Edit current weather.");
                    editCurrentWeather();
                    break;
                case 3:
                    System.out.println("Exit selected");
                    return;
                default:
                    System.out.println("Invalid selection");
                    break; // This break is not really necessary
            }
        }
    }

    private static void showMainMenu() {
        clearConsole();
        System.out.println("\tMAIN MENU");
        System.out.println("Options");
        System.out.println("1. Show weather");
        System.out.println("2. Edit weather");
        System.out.println("3. Exit");
    }

    private static void showCurrentWeather(){
        clearConsole();
        System.out.println("\tCURRENT WEATHER");
        System.out.println("Parameters");
        System.out.println("1. Wind speed (m/s): " + weather.getWindSpeed().getAsMetersPerSecond());
        System.out.println("              (km/h): " + weather.getWindSpeed().getAsKilometersPerHour());
        System.out.println("2. Wind direction (degrees): " + weather.getWindDirection().getDoubleDirectionInDegrees());
        System.out.println("                  (general): " + weather.getWindDirection().getAsPredefinedDirection());
        System.out.println("3. Cloudiness (oktas): " + weather.getCloudiness().getScaleInOktas());
        System.out.println("4. Temperature (by Celsius): " + weather.getTemperature().getAsCelsius());
        System.out.println("               (by Fahrenheit): " + weather.getTemperature().getAsFahrenheit());
        System.out.println("5. Precipitation (scale): " + weather.getPrecipitation().getScale());
        System.out.println("Press Enter to return to main menu.");
        scanner.nextLine();
    }

    private static void editCurrentWeather(){
        clearConsole();
        System.out.println("\tEDIT CURRENT WEATHER");

        System.out.println("Current wind speed is (m/s): " + weather.getWindSpeed().getAsMetersPerSecond());
        System.out.println("                      (km/h): " + weather.getWindSpeed().getAsKilometersPerHour());
        System.out.println("Do you want to change wind speed? (y/n)");
        if(0 == scanner.nextLine().compareToIgnoreCase("y")){
            System.out.println("Enter new wind speed (m/s).\nSpeed must be greater than 0.");
            try{
                weather.getWindSpeed().setAsMetersPerSecond(Keyin.inDouble(""));
                System.out.println("Wind speed changed.");
            }catch (Exception ex){
                System.out.println("New speed is incorrect. Nothing changed.");
            }
        }

        System.out.println("Current wind direction is (degrees): " + weather.getWindDirection().getDoubleDirectionInDegrees());
        System.out.println("                          (general): " + weather.getWindDirection().getAsPredefinedDirection());
        System.out.println("Do you want to change wind direction? (y/n)");
        if(0 == scanner.nextLine().compareToIgnoreCase("y")){
            System.out.println("Enter new wind direction (degrees).");
            try{
                weather.getWindDirection().setInDegrees(Keyin.inDouble(""));
                System.out.println("Wind direction changed.");
            }catch (Exception ex){
                System.out.println("Something went wrong. Nothing changed.");
            }
        }

        System.out.println("Current cloudiness is (oktas): " + weather.getCloudiness().getScaleInOktas());
        System.out.println("Do you want to change cloudiness? (y/n)");
        if(0 == scanner.nextLine().compareToIgnoreCase("y")){
            System.out.println("Enter new scale (oktas). Scale must be not less than 0 and not greater than 9.");
            try{
                weather.getCloudiness().setScaleInOktas((byte)(Keyin.inInt("")));
                System.out.println("Cloudiness changed.");
            }catch (Exception ex){
                System.out.println("New scale is incorrect. Nothing changed.");
            }
        }

        System.out.println("Current temperature is (by Celsius): " + weather.getTemperature().getAsCelsius());
        System.out.println("                       (by Fahrenheit): " + weather.getTemperature().getAsFahrenheit());
        System.out.println("Do you want to change temperature? (y/n)");
        if(0 == scanner.nextLine().compareToIgnoreCase("y")){
            System.out.println("Enter new temperature (by Celsius).");
            try{
                weather.getTemperature().setAsCelsius(Keyin.inDouble(""));
                System.out.println("Temperature changed.");
            }catch (Exception ex){
                System.out.println("Something went wrong. Nothing changed.");
            }
        }

        System.out.println("Current precipitation is (scale): " + weather.getPrecipitation().getScale());
        System.out.println("Do you want to change precipitation? (y/n)");
        if(0 == scanner.nextLine().compareToIgnoreCase("y")){
            System.out.println("Enter new scale.\nScale must be not less than 0 and not greater than 10.");
            try{
                weather.getPrecipitation().setScale((byte)(Keyin.inInt("")));
                System.out.println("Precipitaton changed.");
            }catch (Exception ex){
                System.out.println("Incorrect scale. Nothing changed.");
            }
        }
    }

    public static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

    private static Scanner scanner = new Scanner(System.in);

    private static Weather weather = new Weather();
}

//**********************************************************
//**********************************************************
//Program: Keyin
//Reference: Session 20
//Topics:
// 1. Using the read() method of the ImputStream class
//    in the java.io package
// 2. Developing a class for performing basic console
//    input of character and numeric types
//**********************************************************
//**********************************************************

class Keyin {

    //*******************************
    //   support methods
    //*******************************
    //Method to display the user's prompt string
    public static void printPrompt(String prompt) {
        System.out.print(prompt + " ");
        System.out.flush();
    }

    //Method to make sure no data is available in the
    //input stream
    public static void inputFlush() {
        int dummy;
        int bAvail;

        try {
            while ((System.in.available()) != 0)
                dummy = System.in.read();
        } catch (java.io.IOException e) {
            System.out.println("Input error");
        }
    }

    //********************************
    //  data input methods for
    //string, int, char, and double
    //********************************
    public static String inString(String prompt) {
        inputFlush();
        printPrompt(prompt);
        return inString();
    }

    public static String inString() {
        int aChar;
        String s = "";
        boolean finished = false;

        while (!finished) {
            try {
                aChar = System.in.read();
                if (aChar < 0 || (char) aChar == '\n')
                    finished = true;
                else if ((char) aChar != '\r')
                    s = s + (char) aChar; // Enter into string
            }

            catch (java.io.IOException e) {
                System.out.println("Input error");
                finished = true;
            }
        }
        return s;
    }

    public static int inInt(String prompt) {
        while (true) {
            inputFlush();
            printPrompt(prompt);
            try {
                return Integer.valueOf(inString().trim());
            }

            catch (NumberFormatException e) {
                System.out.println("Invalid input. Not an integer");
            }
        }
    }

    public static char inChar(String prompt) {
        int aChar = 0;

        inputFlush();
        printPrompt(prompt);

        try {
            aChar = System.in.read();
        }

        catch (java.io.IOException e) {
            System.out.println("Input error");
        }
        inputFlush();
        return (char) aChar;
    }

    public static double inDouble(String prompt) {
        while (true) {
            inputFlush();
            printPrompt(prompt);
            try {
                return Double.valueOf(inString().trim());
            }

            catch (NumberFormatException e) {
                System.out
                        .println("Invalid input. Not a floating point number");
            }
        }
    }
}
