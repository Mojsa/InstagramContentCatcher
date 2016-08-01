/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instagramcontentcatcher;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class WriterToFile {

    private static PrintWriter out = null;

    public static void writeContent(String content) {
        out.println(content);
        out.println();
    }

    public static void openFile() throws IOException {
        out = new PrintWriter(new BufferedWriter(new FileWriter("G:\\content.txt", true)));

    }
    
    public static void closeFile(){
        if(out != null){
            out.close();
        }
    }
}
