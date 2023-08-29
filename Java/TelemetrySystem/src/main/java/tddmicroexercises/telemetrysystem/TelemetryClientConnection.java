package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class TelemetryClientConnection implements Connection{
    private boolean onlineStatus;
    private final Random connectionEventsSimulator = new Random(42);

    @Override
    public void connect(String connectionString) {
        if (connectionString == null || "".equals(connectionString))
        {
            throw new IllegalArgumentException();
        }

        boolean success = connectionEventsSimulator.nextInt(10) <= 8;

        onlineStatus = success;
    }

    @Override
    public void disconnect() {
        onlineStatus = false;
    }

    @Override
    public boolean getOnlineStatus() {
        return onlineStatus;
    }
}
