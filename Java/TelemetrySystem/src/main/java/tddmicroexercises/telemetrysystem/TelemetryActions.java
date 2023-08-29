package tddmicroexercises.telemetrysystem;

public interface TelemetryActions {
    void send(String message);
    String receive();
}
