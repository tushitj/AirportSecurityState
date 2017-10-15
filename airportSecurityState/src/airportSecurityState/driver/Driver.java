package airportSecurityState.driver;

import airportSecurityState.airportStates.AirportRiskContext;
import airportSecurityState.airportStates.AirportStateI;
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
        AirportRiskContext airportState= new AirportRiskContext();
        while((str=fPro.readLine())!=null) {
            PassengerData data = PassengerData.parser(str);
            airportState.tightenOrLoosenSecurity(data);
            //dataArrayList.add(data);

        }


    }
}
