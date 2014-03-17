package com.epam.springmvc.services.article.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.DatatypeConverter;

public class ThumbnailHelper {

    public static String encodeToString(InputStream inputStream) {
    	if(inputStream == null) {
    		return "";
    	}
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        String imageString = null;

        try {
            int buffer = 0;

            while((buffer = inputStream.read()) != -1) {
                bos.write(buffer);
            }
            
            imageString = DatatypeConverter.printBase64Binary(bos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imageString;
    }
}
