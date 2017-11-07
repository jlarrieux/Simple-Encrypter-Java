package entity;



import lombok.extern.java.Log;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;



@Log
public class Cryptographer {

    private static Base64.Encoder encoder = Base64.getEncoder();
    private static Base64.Decoder decoder = Base64.getDecoder();
    private static final Charset CHARSET_ISO_8859_1 = Charset.forName("ISO-8859-1");
    private static String DUMMY_KEY = "Something";

    private enum  MODE {ENCRYPT, DECRYPT};

    public static void main(String[] main){
        String algorithm = "Blowfish";
        byte[] e = encrypt("I am great",DUMMY_KEY, algorithm);
        String en = new String(encoder.encode(e));
        byte[] ded =  decoder.decode(en.getBytes());
        System.out.println(String.format("Raw: %s\nEncrypted: %s\nDecoded: %s\n\nEquals?: %b",new String(ded),new String(e),en, e==ded));

//        byte[] d = decrypt(en, DUMMY_KEY, algorithm);
//        String de = new String(decoder.decode(d));
//        System.out.println("Decrypted: "+ de);

    }



    public static byte[] encrypt(String toEncrpyt, String key, String algorithm) {
        try {
            SecretKeySpec keySpec = getSecretKeySpeck(key,algorithm);
            Cipher cipher = getCipher(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            return cipher.doFinal(toEncrpyt.getBytes());

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static byte[] decrypt(String encrypted,String key, String algorithm){
        try {
            SecretKeySpec  keySpec= getSecretKeySpeck(key,algorithm);
            Cipher cipher = getCipher(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            return cipher.doFinal(encrypted.getBytes());


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static Cipher getCipher(String Algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException {

        return Cipher.getInstance(Algorithm);
    }


    public static SecretKeySpec getSecretKeySpeck(String key, String algorithm){
        return new SecretKeySpec(key.getBytes(CHARSET_ISO_8859_1), algorithm);
    }

}
