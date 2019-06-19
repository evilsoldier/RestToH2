package com.rest.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

/**
 * @author Georgi Trendafilov
 */
public class PasswordUtils {

    public static String getKeyFromKeystore(String pathToFile, String instance, String keystorePassword, String alias) {
        String plainTextPasword = "";
        try {
            FileInputStream is = new FileInputStream(pathToFile);
            KeyStore keystore = KeyStore.getInstance(instance);
            keystore.load(is, keystorePassword.toCharArray());
            Key key = keystore.getKey(alias, keystorePassword.toCharArray());
            if (key instanceof PrivateKey) {
                // Get certificate of public key
                Certificate cert = keystore.getCertificate(alias);
                // Get public key
                PublicKey publicKey = cert.getPublicKey();
                plainTextPasword = Base64.encodeBase64String(publicKey.getEncoded());
            }
            plainTextPasword = new String(key.getEncoded());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plainTextPasword;
    }
}
