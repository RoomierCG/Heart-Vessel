package objects.transportsystem;

import objects.Generic;

public abstract class Transport extends Generic {

    protected String status;

    public Transport(String transportId, String nombre, String status) {
        super(transportId,nombre);
        this.status = status;
    }

    public Transport() {
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
