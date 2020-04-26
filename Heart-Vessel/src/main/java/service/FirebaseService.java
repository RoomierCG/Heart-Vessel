package service;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class FirebaseService {

    private static final String UID = "user";

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        FileInputStream serviceAccount =
                new FileInputStream("D:\\Repositorios\\Heart-Vessel\\Heart-Vessel\\src\\main\\resources\\FirebaseKey\\serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://com-fedgar-heart-vessel.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);

        //Map<String, Object> additionalClaims = new HashMap<String, Object>();
        //additionalClaims.put("some",true);
        String customToken = FirebaseAuth.getInstance().createCustomTokenAsync(UID).get();
        System.out.println(customToken);
    }

}
