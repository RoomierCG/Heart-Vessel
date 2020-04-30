package service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FirebaseService {

    /*
        ES: Para poder conectarse a Firebase desde nuestro proyecto java necesitaremos usar la API mediante el SDK-Admin
            conectarse requiere, una key json y la conexion a la base de datos.
            Cualquier interaccion con Firebase necesitara de la llamada de este metodo para poder conectarse
        EN:
     */
    public void initializeService() {
        try {
            FileInputStream serviceAccount = new FileInputStream("D:\\Repositorios\\Heart-Vessel\\Heart-Vessel\\src\\main\\resources\\FirebaseKey\\serviceAccountKey.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://heart-vessel.firebaseio.com")
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        ES:
        EN:
     */
    public void CreateUser(String Name, String Email, String Password, String PhoneNumber) {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(Email)
                .setEmailVerified(false)
                .setPassword(Password)
                .setPhoneNumber(PhoneNumber)
                .setDisplayName(Name)
                //.setPhotoUrl("http://www.example.com/12345678/photo.png")
                .setDisabled(false);
        try {
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            System.out.println("Successfully created new user: " + userRecord.getDisplayName() + "\n Your UID: "+userRecord.getUid());
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
        }
    }

    /*
        ES:
        EN:
     */
    public void LoginUser() {
    }

}
