package com.example.vishnuprasad.camera;

import android.os.AsyncTask;

import java.io.File;
import java.io.IOException;

/**
 * Created by vishnuprasad on 3/4/2016.
 */
public class UploadTask extends AsyncTask<String,Void,String> {
File uploadFile ;
    String charset = "UTF-8";
    String requestURL = "http://54.201.94.219/getimage";
    public UploadTask(File uploadFile)
    {
        this.uploadFile =uploadFile;

    }
    @Override
    protected String doInBackground(String... params) {
        try {
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);

          //multipart.addHeaderField("User-Agent", "CodeJava");
            //multipart.addHeaderField("Test-Header", "Header-Value");

            //multipart.addFormField("description", "Cool Pictures");
            //multipart.addFormField("keywords", "Java,upload,Spring");

            multipart.addFilePart("image", uploadFile);


            String response = multipart.finish();

            System.out.println("SERVER REPLIED:");


                System.out.println(response);
            return  response;
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return "";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

    }
}
