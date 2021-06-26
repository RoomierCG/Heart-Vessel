package objects.provider;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import objects.Generic;
import service.utility.UserInteractions;

import java.util.ArrayList;

import static service.background_sim.SimulatorThread.randomNum;

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

    public boolean checkAccNum(){
        if(this.account.length()!=24){
            System.out.println("aqui wey 1");
            return false;
        }
        if(!Character.isLetter(this.getAccount().charAt(0)) || !Character.isLetter(this.getAccount().charAt(1))){
            System.out.println("aqui wey 2");
            return false;
        }
        for(int i = 2;i<24;i++){
            try{
                Integer.parseInt(this.getAccount().substring(i,i+1));
            }catch (NumberFormatException e){
                System.out.println("aqui wey 3");
                return false;
            }
        }
        return true;
    }

    public void modifyMe(ArrayList<String> atribMod) {
        if (atribMod.contains("IBAN") || atribMod.contains("*")) {
            this.setAccount(UserInteractions.strRequest("Introduzca su IBAN"));
            if(this.account.equals("random")){
                this.setAccount("ES");
                do {
                    this.setAccount(this.getAccount() + randomNum(0, 9));
                } while (this.getAccount().length() < 24);
                System.out.println(this.account);
            }

            if(!this.checkAccNum()){
                System.out.println("IBAN Invalido");
                this.modifyMe(new ArrayList<String>(){{add("IBAN");}});
            }
        }
    }
}
