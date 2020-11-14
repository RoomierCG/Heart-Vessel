package objects.provider;

public class Provider {

    private String idProvider;
    private String name;
    private String account;

    public Provider(String idProvider, String name, String account) {
        this.idProvider = idProvider;
        this.name = name;
        this.account = account;
    }

    public Provider(){}

    public String getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(String idProvider) {
        this.idProvider = idProvider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
