package entity;



import lombok.extern.java.Log;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;



@Log
public class Cryptographer {

    private static Base64.Encoder encoder = Base64.getEncoder();
    private static Base64.Decoder decoder = Base64.getDecoder();
//    private static final Charset CHARSET_ISO_8859_1 = Charset.forName("ISO-8859-1");
    private static String DUMMY_KEY = "Something";

    private enum  MODE {ENCRYPT, DECRYPT};
    public static enum CIPHER{BLOWFISH, AES, RC2, RC4}


    public static void main(String[] main){
        String algorithm = "Blowfish";
        String to_encrypt = "I am great";
        String en = encrypt(to_encrypt,DUMMY_KEY, algorithm);
        byte[] ded =  decoder.decode(en.getBytes());


        String de = decrypt(en, DUMMY_KEY, algorithm);

        log.info(String.format("Encrypted String: %s\n equals?: %b", en,to_encrypt.equals(de) ));


    }


    private static boolean byteArrayComparator(byte[] one, byte[] two){
        if(one.length!= two.length) return false;
        boolean result = true;
        for(int i=0; i<one.length; i++){
            Byte first =one[i];
            Byte second = two[i];
            if(first.compareTo(second)!=0){
                result = false;
                break;
            }
        }

        return result;
    }

    public static String encrypt(String toEncrpyt, String key, String algorithm) {
        try {
            SecretKeySpec keySpec = getSecretKeySpeck(key,algorithm);
            Cipher cipher = getCipher(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] e = cipher.doFinal(toEncrpyt.getBytes());
            return new String(encoder.encode(e));


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static String decrypt(String encrypted,String key, String algorithm){
        try {
            byte[] en = decoder.decode(encrypted.getBytes());
            SecretKeySpec  keySpec= getSecretKeySpeck(key,algorithm);
            Cipher cipher = getCipher(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            return new String(cipher.doFinal(en));


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static Cipher getCipher(String Algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException {

        return Cipher.getInstance(Algorithm);
    }


    public static SecretKeySpec getSecretKeySpeck(String key, String algorithm){
        return new SecretKeySpec(key.getBytes(), algorithm);
    }

}
