import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by July on 09.11.2017.
 */
public class JSONwriter {

    public void simulator(String Path){
        System.out.println("work started!");
        File folder = new File(Path);

        if (!folder.exists()) folder.mkdirs();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {}

            System.out.println("work is going on...");
            String path = Path + "1.json";
            JSONObject object = new JSONObject();
            object.put("name", "j4web");
            object.put("site", "http://j4web.ru");
            object.put("age", 2);
            JSONArray messages = new JSONArray();
            messages.add("Message 1");
            messages.add("Message 2");
            messages.add("Message 3");
            object.put("messages", messages);
            try (FileWriter writer = new FileWriter(path)) {
                writer.write(object.toJSONString());
                writer.flush();
                writer.close();
                System.out.println("written!");
            } catch (IOException ex) {
                Logger.getLogger(JSONwriter.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        System.out.println("work finished!");
    }
}
