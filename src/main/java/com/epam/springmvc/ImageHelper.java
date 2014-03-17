package com.epam.springmvc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.DatatypeConverter;

public class ImageHelper {
    /*
    public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            Base64.decodeBase64()
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
    */
    public static String encodeToString(InputStream inputStream) {
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
