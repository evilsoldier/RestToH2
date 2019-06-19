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

    private static void getKeyFromKeystore() {
        try {
            FileInputStream is = new FileInputStream("C:\\path\\to\\keystore.jceks");
            KeyStore keystore = KeyStore.getInstance("JCEKS");
            String password = "keystorePassword";
            char[] passwd = password.toCharArray();
            keystore.load(is, passwd);
            String alias = "alias";
            Key key = keystore.getKey(alias, passwd);
            if (key instanceof PrivateKey) {
                // Get certificate of public key
                Certificate cert = keystore.getCertificate(alias);
                // Get public key
                PublicKey publicKey = cert.getPublicKey();

                String publicKeyString = Base64.encodeBase64String(publicKey
                        .getEncoded());
                System.out.println(publicKeyString);
            }
            System.out.println(new String(key.getEncoded()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
