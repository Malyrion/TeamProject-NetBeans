package java_system;


import java.awt.List;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author katoj
 */
public final class CreateLog {
        public static void writeLog(String fileLoc, String[] logContents){
         try {
            FileWriter writer = new FileWriter(fileLoc, true);
            
            String date = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
            
            writer.write(date);
            
            for(int i = 0; i < logContents.length; i++){
                writer.write(" " + logContents[i]);
            }
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
