package Main;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileStorage {
    private static Bucket bucket;
    public static void init(){
        try{
            Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("src/main/i-classroom-kmitl-89782e0165a1.json"));
            Storage storage = StorageOptions.newBuilder().setCredentials(credentials).setProjectId("i-classroom-kmitl").build().getService();
            bucket = storage.get("iclassroom");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static String upload(File file, int courseID, String userID){
//        System.out.println(filePath);
        Path file_data = Paths.get(file.getPath());
        try {
            byte[] fileContent = Files.readAllBytes(file_data);
            String uploadPath = courseID+"/"+userID+"/"+file.getName();
            Blob blob = bucket.create(uploadPath, fileContent);
            System.out.println(blob.getMediaLink());
            return "https://storage.googleapis.com/iclassroom/uploads/"+courseID+"/"+userID+"/"+file.getName();
        }catch (Exception e){
            e.printStackTrace();
        }

//        String value = "Hello, World!";
//        byte[] bytes = value.getBytes(UTF_8);
//        Blob blob = bucket.create("555/my-first-blo555", bytes);
        return "";
    }
}
