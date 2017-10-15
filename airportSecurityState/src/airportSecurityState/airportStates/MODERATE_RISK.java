package airportSecurityState.airportStates;

public class MODERATE_RISK implements AirportStateI {
    AirportState airportState;
    public MODERATE_RISK(AirportState state){
        this.airportState = state;
    }
    @Override
    public void operationsToDo() {
        System.out.println("2 3 5 8 9");

    }
}
