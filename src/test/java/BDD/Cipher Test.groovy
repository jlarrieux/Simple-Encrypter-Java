package BDD

import entity.Cryptographer
import spock.lang.Specification

class CipherTest  extends Specification{

    String TO_ENCRYPT="I am legend"
    String KEY ="Greates key ever"
    String algorithm, encrypted, decrypted;

    def "test blowfish"(){
        given: "Blowfish algorithm and a key and a string to encrypt"
        algorithm = Cryptographer.CIPHER.BLOWFISH
        print(KEY.length())


        when: "We encrypt using a key"
        encrypted = Cryptographer.encrypt(TO_ENCRYPT, KEY, algorithm)
        decrypted = Cryptographer.decrypt(encrypted, KEY, algorithm)

        then:"decrypted key should be equal"
        TO_ENCRYPT.equals(decrypted)

    }


    def "test AES"(){
        given: "Blowfish algorithm and a key and a string to encrypt"
        algorithm = Cryptographer.CIPHER.AES
        print(KEY.length())


        when: "We encrypt using a key"
        encrypted = Cryptographer.encrypt(TO_ENCRYPT, KEY, algorithm)
        decrypted = Cryptographer.decrypt(encrypted, KEY, algorithm)

        then:"decrypted key should be equal"
        TO_ENCRYPT.equals(decrypted)

    }

    def "test RC2"(){
        given: "Blowfish algorithm and a key and a string to encrypt"
        algorithm = Cryptographer.CIPHER.RC2
        print(KEY.length())


        when: "We encrypt using a key"
        encrypted = Cryptographer.encrypt(TO_ENCRYPT, KEY, algorithm)
        decrypted = Cryptographer.decrypt(encrypted, KEY, algorithm)

        then:"decrypted key should be equal"
        TO_ENCRYPT.equals(decrypted)

    }


    def "test RC4"(){
        given: "Blowfish algorithm and a key and a string to encrypt"
        algorithm = Cryptographer.CIPHER.RC4
        print(KEY.length())


        when: "We encrypt using a key"
        encrypted = Cryptographer.encrypt(TO_ENCRYPT, KEY, algorithm)
        decrypted = Cryptographer.decrypt(encrypted, KEY, algorithm)

        then:"decrypted key should be equal"
        TO_ENCRYPT.equals(decrypted)

    }






















}
