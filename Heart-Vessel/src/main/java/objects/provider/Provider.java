package objects.provider;

public class Provider {

    private int idProvider;
    private String name;
    private String account;

    public Provider(int idProvider, String name, String account) {
        this.idProvider = idProvider;
        this.name = name;
        this.account = account;
    }

    public Provider(){}

    public int getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(int idProvider) {
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
