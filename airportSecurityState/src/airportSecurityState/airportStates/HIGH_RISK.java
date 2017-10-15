package airportSecurityState.airportStates;

public class HIGH_RISK implements AirportStateI {
    AirportState airportState;
    public HIGH_RISK(AirportState state){
        this.airportState = state;
    }

    @Override
    public void operationsToDo() {
        System.out.println("2 4 6 8 10");
    }
}
