package objects.transportsystem;

public abstract class Transport {
    protected int transportId;
    protected String status;

    public Transport(int transportId, String status) {
        this.transportId = transportId;
        this.status = status;
    }

    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
