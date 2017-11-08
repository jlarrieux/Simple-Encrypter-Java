package sample;



import entity.Cryptographer;
import lombok.extern.java.Log;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;


@Log
public class Controller {


    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher c = Cipher.getInstance(Cryptographer.CIPHER.BLOWFISH.toString());
        log.info(String.valueOf(Cipher.getMaxAllowedKeyLength(Cryptographer.CIPHER.BLOWFISH.toString())));
    }
}
