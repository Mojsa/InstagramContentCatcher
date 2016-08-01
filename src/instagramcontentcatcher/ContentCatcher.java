/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instagramcontentcatcher;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mario
 */
public class ContentCatcher {
    private String max_id = "";
    //otvoriti datoteku
    public void getCaptionText(){
        try {
            WriterToFile.openFile();
            URL insta = new URL("https://www.instagram.com/trip_aum_shanti/media/");
            if(!max_id.isEmpty()){
                insta = new URL("https://www.instagram.com/trip_aum_shanti/media/?max_id="+max_id);
            }
            HttpURLConnection request = (HttpURLConnection) insta.openConnection();
            request.connect();
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject rootobj = root.getAsJsonObject();
            JsonArray array = rootobj.getAsJsonArray("items");
            String more_available = rootobj.get("more_available").getAsString();
            for (int i = 0; i < array.size(); i++) {
                JsonObject item_broj = (JsonObject) array.get(i);
                JsonObject caption = (JsonObject) item_broj.getAsJsonObject("caption");
                String caption_text = caption.get("text").getAsString();
                if(i == array.size()-1){
                    max_id = item_broj.get("id").getAsString();
                }
                WriterToFile.writeContent(caption_text);
            }
            if(more_available.equals("true")){
                getCaptionText();
            }
        } catch (IOException ex) {
            Logger.getLogger(ContentCatcher.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            WriterToFile.closeFile();
        }
    }
}
