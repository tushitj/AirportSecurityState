package airportSecurityState.driver;

import airportSecurityState.airportStates.AirportRiskContext;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.PassengerData;
import airportSecurityState.util.Results;


public class Driver {
    /**
     * A function that checks the valid file names
     * @param args: array of string of filenames
     * @return true if all the arguments are correct filenames
     */
    public static boolean checkArgs(String... args) {
        boolean flag = true;
        for (String str : args)
            flag = flag && str != null && str.trim().length() > 0 && !str.contains("${arg");
        return flag;
    }

    public static void main(String args[]) {
        int debugValue = 0;
        int argLength = args.length;
       // for(String arg : args)
       // System.out.println(arg);
        if (argLength != 3 | !checkArgs(args)) {
            MyLogger.writeMessage("Error in Driver class. The length is of input is not correct." , MyLogger.DebugLevel.IN_RESULTS);
            System.err.println("Incorrect number of arguments " +
                    "Correct Format: input.txt output.txt debugValue");
            System.exit(1);
        }
        try{
            debugValue = Integer.parseInt(args[2]);

            if(debugValue<0 || debugValue>4 ){
                MyLogger.writeMessage("Error in Driver class. Debug Value must be between 0 and 4." , MyLogger.DebugLevel.IN_RESULTS);
                System.err.println("Debug Value must be between 0 and 4");
                System.exit(1);

            }
            //System.out.println(debugValue);
            MyLogger.setDebugValue(debugValue);
        }catch(NumberFormatException e){
            MyLogger.writeMessage("Error in Driver class. The value passed is not an Integer." , MyLogger.DebugLevel.IN_RESULTS);
            System.err.println("Number Expected in debug value\n" +e);
            System.exit(1);
        }
        String inputFile = args[0];
        String outputFile = args[1];
        //ArrayList<PassengerData> dataArrayList = new ArrayList<>();
        Results results = new Results();
        FileProcessor fPro = new FileProcessor(inputFile);
        String str="";
        AirportRiskContext airportState= new AirportRiskContext();
        while((str=fPro.readLine())!=null) {
            PassengerData data = PassengerData.parser(str);
            airportState.tightenOrLoosenSecurity(data,results);
            //dataArrayList.add(data);

        }
        results.writeToFile(outputFile);
        if(debugValue >0)
            results.writeToStdout(null);


    }
}
