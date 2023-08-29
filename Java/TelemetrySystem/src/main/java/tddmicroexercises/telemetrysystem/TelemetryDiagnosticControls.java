package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls
{
    private final String DiagnosticChannelConnectionString = "*111#";
    private TelemetryActions telemetryActions;

    public TelemetryDiagnosticControls(TelemetryActions telemetryActions)
    {
        this.telemetryActions = telemetryActions;
    }
    private String diagnosticInfo = "";

    public String getDiagnosticInfo(){
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo){
        this.diagnosticInfo = diagnosticInfo;
    }
 
    public void checkTransmission() throws Exception
    {
        Connection connection = new TelemetryClientConnection();
        diagnosticInfo = "";

        connection.disconnect();
    
        int retryLeft = 3;
        while (connection.getOnlineStatus() == false && retryLeft > 0)
        {
            connection.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }
             
        if(connection.getOnlineStatus() == false)
        {
            throw new Exception("Unable to connect.");
        }
    
        telemetryActions.send(TelemetryActionsImpl.DIAGNOSTIC_MESSAGE);
        setDiagnosticInfo(telemetryActions.receive());
    }
}
