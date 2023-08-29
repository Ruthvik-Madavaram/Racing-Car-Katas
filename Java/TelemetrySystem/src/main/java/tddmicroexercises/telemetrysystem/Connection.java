package tddmicroexercises.telemetrysystem;

public interface Connection {
    void connect(String connectionString);
    void disconnect();
    boolean getOnlineStatus();
}
