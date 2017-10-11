package airportSecurityState.driver;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.PassengerData;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.time.LocalTime;
import java.util.ArrayList;

public class Driver {

    public static void main(String args[]) {
        System.out.println(args[0]);
        ArrayList<PassengerData> dataArrayList = new ArrayList<>();
        FileProcessor fPro = new FileProcessor(args[0]);
        String str="";
        while((str=fPro.readLine())!=null) {
            PassengerData data = parser(str);
            dataArrayList.add(data);
        }

        for(PassengerData pd : dataArrayList){
            System.out.println(pd.getDay() + " " + pd.getTime() + " " + pd.getAirline() + " " + pd.getItem());

        }


    }

    static String getValue(String key, String[] sarr) {
        for (int i = 0; i < sarr.length ; i++) {
            if (sarr[i].toLowerCase().contains(key.toLowerCase()))
                return sarr[i].split(":")[1];
        }
        return null;
    }

    public static PassengerData parser(String input) {
        int day;
        LocalTime time;
        String airline;
        String item;

        String[] words = input.split(";");
        //code
        if (words.length == 4) {
            day = Integer.parseInt(getValue("day", words));
            String str ="";
            time = LocalTime.parse((str = getValue("TOD", words))+":"+getValue(str,words));

            airline = getValue("Airline", words);

            item = getValue("Item", words);
            return new PassengerData(day,time,airline,item);
        }
        return null;
    }
}
