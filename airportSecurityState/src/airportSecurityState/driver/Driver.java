package airportSecurityState.driver;

public class Driver {

    int day;
    String time;
    String airline;
    String item;


    public static void main(String args[]){

    }

    public void parser(String input){

        String[] words = input.split(";");

        String[] days = words[0].split(":");
        day = Integer.parseInt(days[1]);

        String[] times = words[1].split(":");
        time = times[1];

        String[] airlines = words[2].split(":");
        airline = airlines[1];

        String[] items = words[3].split(":");
        item = items[1];
    }
}
