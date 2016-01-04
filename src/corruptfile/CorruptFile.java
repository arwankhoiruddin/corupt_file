/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corruptfile;

import java.io.RandomAccessFile;
import java.util.Random;

/**
 *
 * @author arwankhoiruddin
 */
public class CorruptFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String FILEPATH = args[0];

        System.out.println("File to corrupt: " + FILEPATH);
        System.out.println("File corruption process started");
        
        try {
            RandomAccessFile file = new RandomAccessFile(FILEPATH, "rw");
            Random r = new Random();
            for (int i=0; i<file.length(); i++) {
                String dt = "" + (char) r.nextInt(255);
                file.seek(i);
                file.write(dt.getBytes());
            }
            file.close();
            
            System.out.println("File " + FILEPATH + " has now been corrupted and will be irrevertible. Enjoy!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
