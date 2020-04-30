import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import service.FirebaseService;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;


public class mainTest {

    public static void main(String[] args) {
        FirebaseService service = new FirebaseService();
        service.initializeService();
//        service.CreateUser("Edgar","1@1.com","1234567","+34684274030");


    }

    public static void testFireStore() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();

        HashMap<String, String> map= new HashMap<>();
        map.put("Hola","Yo");

        ApiFuture<WriteResult> future = db.collection("Users").document("algo").set(map);
        System.out.println("completado"+ future.get().getUpdateTime());
    }
}
