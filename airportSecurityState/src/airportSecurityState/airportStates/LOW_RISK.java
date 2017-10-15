package airportSecurityState.airportStates;

public class LOW_RISK implements AirportStateI {
    AirportState airportState;
    public LOW_RISK(AirportState state){
        this.airportState = state;
    }
    @Override
    public void operationsToDo() {
        System.out.println("1 3 5 7 9");
    }
}
