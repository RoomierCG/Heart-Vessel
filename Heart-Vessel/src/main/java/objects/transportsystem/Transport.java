package objects.transportsystem;

public abstract class Transport {
    protected String transportId;
    protected String status;

    public Transport(String transportId, String status) {
        this.transportId = transportId;
        this.status = status;
    }

    public Transport() {

    }

    public String getTransportId() {
        return transportId;
    }

    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
