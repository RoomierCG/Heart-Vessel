package objects.provider;

import objects.Generic;

import java.util.ArrayList;

public class Provider extends Generic {

    private String account;

    public Provider(String idProvider, String name, String account) {
        super(idProvider, name);
        this.account = account;
    }

    public Provider(){}

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public ArrayList<String> gatherInfo() {
        return null;
    }

    @Override
    public ArrayList<ArrayList<String>> gatherListedInfo() {
        return null;
    }
}
