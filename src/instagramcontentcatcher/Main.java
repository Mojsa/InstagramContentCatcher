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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

/**
 *
 * @author Mario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PrintWriter out = null;
        /*try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("G:\\content.txt", true)));
            //JsonObject rootobj = ContentCatcher.getJsonResponse();
           /* String status = rootobj.get("status").getAsString();
            String more_available = rootobj.get("more_available").getAsString();
            JsonArray array = rootobj.getAsJsonArray("items");
            System.out.println("Status: " + status);
            System.out.println("More available "+ more_available);
            for (int i = 0; i < array.size(); i++) {
                JsonObject item_broj = (JsonObject) array.get(i);
                JsonObject caption = (JsonObject) item_broj.getAsJsonObject("caption");
                String caption_text = caption.get("text").getAsString();
                //System.out.println("Caption: " + caption_text);
                out.println(caption_text);
                out.println();
            }
        } catch (Exception e) {

        } finally {
            if (out != null) {
                out.close();
            }
        }
    }*/
        ContentCatcher hehe = new ContentCatcher();
        hehe.getCaptionText();

}
}
