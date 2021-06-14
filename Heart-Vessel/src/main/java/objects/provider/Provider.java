package objects.provider;

import objects.Generic;
import service.utility.UserInteractions;

import java.util.ArrayList;

public class Provider extends Generic {

    private String account;

    public Provider(String idProvider, String name, String account) {
        super(idProvider, name);
        this.account = account;
    }

    public Provider() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public ArrayList<String> gatherInfo() {
        ArrayList<String> s = super.gatherInfo();
        s.add(account);

        return s;
    }

    public ArrayList<ArrayList<String>> gatherListedInfo() {
        return null;
    }

    public void modifyMe(ArrayList<String> atribMod) {
        if (atribMod.contains("IBAN")) {
            this.setAccount(UserInteractions.strRequest("Seleccione una categirio de riesgo nuevo"));
        }
    }
}
