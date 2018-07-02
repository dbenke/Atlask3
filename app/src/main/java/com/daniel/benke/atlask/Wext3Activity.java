package com.daniel.benke.atlask;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Wext3Activity extends Activity {

    File myTelasFile;

    String filename = "Telas.txt";

    String filepath = "MyFileStorage";
    String acesso;
    public Wext3Activity(){
    }

    public void Write(Context context,String textolog) {
        /*if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
        }
        else {
           File myExternalFile = new File(context.getExternalFilesDir(filepath), filename);
        }
        */
       this.acesso = textolog;

        try {
            // Context context = getContext();
            myTelasFile = new File(context.getExternalFilesDir(filepath), filename);
            BufferedWriter writer = new BufferedWriter(new FileWriter(myTelasFile,true));

            if (!myTelasFile.exists()){
                myTelasFile.createNewFile();
                writer.write("Daniel Benke");
            }


            writer.write(acesso);
            SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM HH:mm:ss");
            //SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM HH:mm");

            Date currentTime = Calendar.getInstance().getTime();

            dateformat.format(currentTime);
            writer.write(String.valueOf(dateformat.format(currentTime))+"\n");



            writer.close();

/*            filename = "Tempos.txt";
            myTelasFile = new File(context.getExternalFilesDir(filepath), filename);
            writer = new BufferedWriter(new FileWriter(myTelasFile,true));
            if (!myTelasFile.exists()){
                myTelasFile.createNewFile();
                writer.write("Daniel Benke");
            }





            writer.close();

            */


            //FileOutputStream fos = new FileOutputStream(myTelasFile);
            //fos.write(acesso.getBytes());
            //fos.close();













        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }
}
