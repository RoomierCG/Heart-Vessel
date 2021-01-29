package objects.provider;

import objects.Generic;

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

    @Override
    public String[] gatherInfo() {return new String[]{super.getId(),super.getName(),account};}
}
