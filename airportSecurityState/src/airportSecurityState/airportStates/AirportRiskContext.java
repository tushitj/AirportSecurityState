package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.PassengerData;
import airportSecurityState.util.Results;

public class AirportRiskContext implements AirportStateI {

    private AverageCalculator averageCalculator;

    private AirportStateI LowRisk;
    private AirportStateI ModerateRisk;
    private AirportStateI HighRisk;

    AirportStateI state;



    public AirportRiskContext() {

        this.LowRisk = new LOW_RISK(this);
        this.ModerateRisk = new MODERATE_RISK(this);
        this.HighRisk = new HIGH_RISK(this);
        this.setState(getLowRisk());
        averageCalculator = new AverageCalculator();

        MyLogger.writeMessage("AirportRiskContext class constructor." , MyLogger.DebugLevel.CONSTRUCTOR);
    }

    public void setState(AirportStateI stateI) {
        this.state = stateI;
    }

    @Override
    public void operationsToDo(AverageData data) {
        state.operationsToDo(data);
    }

    public void tightenOrLoosenSecurity(PassengerData data, Results result) {
        AverageData averageData= averageCalculator.calculate(data);
        operationsToDo(averageData);
        result.storeNewResult(this.state.toString());
        MyLogger.writeMessage("State Changed to " + this.state.getClass().getSimpleName() , MyLogger.DebugLevel.IN_RUN);
    }

    public AirportStateI getLowRisk() {
        return LowRisk;
    }

    public AirportStateI getModerateRisk() {
        return ModerateRisk;
    }

    public AirportStateI getHighRisk() {
        return HighRisk;
    }
}

