package br.com.haka.domain.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hivisonmoura on 2016-12-27.
 */
public class EncryptPassword {

    public String EncryptPassword (String senha){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.update(senha.getBytes());

            byte byteData[] = messageDigest.digest();

            StringBuffer stringBuffer = new StringBuffer();
            for (int i =0; i < byteData.length; i++){
                stringBuffer.append(Integer.toString((byteData[i] & 0xff)+ 0x100, 16).substring(1));
            }
           senha = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return senha;
    }
}
