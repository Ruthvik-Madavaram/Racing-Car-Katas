package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TelemetryDiagnosticControlsTest
{
    
	@Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        TelemetryActions mockedTelemetryActions = mock(TelemetryActions.class);
        Connection mockedConnection = mock(Connection.class);
        TelemetryDiagnosticControls diagnosticControls = new TelemetryDiagnosticControls(mockedTelemetryActions);

        when(mockedConnection.getOnlineStatus()).thenReturn(true);
        when(mockedTelemetryActions.receive()).thenReturn("Status Message");

        diagnosticControls.checkTransmission();

        verify(mockedTelemetryActions).send(TelemetryActionsImpl.DIAGNOSTIC_MESSAGE);
        verify(mockedTelemetryActions).receive();
        assertEquals("Status Message", diagnosticControls.getDiagnosticInfo());
    }

}
