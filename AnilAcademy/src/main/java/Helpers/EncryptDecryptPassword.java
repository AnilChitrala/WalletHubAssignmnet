package Helpers;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class EncryptDecryptPassword {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        String originalPassword = "";
        try {
            originalPassword = JOptionPane.showInputDialog("Please enter the password to be encrypted : ");
            if (originalPassword == "")
                JOptionPane.showMessageDialog(null, "password is empty Please try Again entering valid data");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String encrypted = encrypt(originalPassword);
        System.out.println("Original password is : " + originalPassword);
        System.out.println("Encrypted password is : +" + encrypted);
    }



    private static String encrypt(String data) {
        String encryptedDataValue = "";
        try {
            String key = "*****************";
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF8"));
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
            byte[] dataBytes = data.getBytes("UTF8");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] dataBytesEncrypted = (cipher.doFinal(dataBytes));
            encryptedDataValue = Base64.getEncoder().encodeToString(dataBytesEncrypted);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return encryptedDataValue;

    }

}

