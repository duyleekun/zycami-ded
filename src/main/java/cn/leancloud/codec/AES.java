/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.codec;

import cn.leancloud.AVLogger;
import cn.leancloud.codec.Base64Decoder;
import cn.leancloud.codec.Base64Encoder;
import cn.leancloud.utils.LogUtil;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    private static final String CIPHERMODEPADDING = "AES/CBC/PKCS7Padding";
    private static final int HASH_ITERATIONS = 10000;
    private static final String KEY_GENERATION_ALG = "PBKDF2WithHmacSHA1";
    private static final int KEY_LENGTH = 256;
    private static final AVLogger Log = LogUtil.getLogger(AES.class);
    private IvParameterSpec IV;
    private char[] humanPassphrase;
    private byte[] iv;
    private SecretKeyFactory keyfactory;
    private PBEKeySpec myKeyspec;
    private byte[] salt;
    private SecretKey sk;
    private SecretKeySpec skforAES;

    public AES() {
        Object object;
        Object object2 = "QxciDjdHjuAIf8VCsqhmGK3OZV7pBQTZ".toCharArray();
        this.humanPassphrase = object2;
        int n10 = 16;
        byte[] byArray = object = new byte[n10];
        byte[] byArray2 = object;
        byArray[0] = 0;
        byArray2[1] = 1;
        byArray[2] = 2;
        byArray2[3] = 3;
        byArray[4] = 4;
        byArray2[5] = 5;
        byArray[6] = 6;
        byArray2[7] = 7;
        byArray[8] = 8;
        byArray2[9] = 9;
        byArray[10] = 10;
        byArray2[11] = 11;
        byArray[12] = 12;
        byArray2[13] = 13;
        byArray[14] = 14;
        byArray2[15] = 15;
        this.salt = object;
        object = new PBEKeySpec;
        char[] cArray = this.humanPassphrase;
        byte[] byArray3 = this.salt;
        int n11 = 10000;
        int n12 = 256;
        super(cArray, byArray3, n11, n12);
        this.myKeyspec = object;
        object = null;
        this.keyfactory = null;
        this.sk = null;
        this.skforAES = null;
        Object[] objectArray = object2 = (Object)new byte[n10];
        Object[] objectArray2 = object2;
        objectArray[0] = 10;
        objectArray2[1] = '\u0001';
        objectArray[2] = 11;
        objectArray2[3] = 5;
        objectArray[4] = 4;
        objectArray2[5] = 15;
        objectArray[6] = 7;
        objectArray2[7] = 9;
        objectArray[8] = 23;
        objectArray2[9] = 3;
        objectArray[10] = '\u0001';
        objectArray2[11] = 6;
        objectArray[12] = 8;
        objectArray2[13] = 12;
        objectArray[14] = 13;
        objectArray2[15] = 91;
        this.iv = (byte[])object2;
        object2 = KEY_GENERATION_ALG;
        object2 = SecretKeyFactory.getInstance((String)object2);
        this.keyfactory = object2;
        object = this.myKeyspec;
        object2 = object2.generateSecret((KeySpec)object);
        try {
            this.sk = object2;
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
            object2 = Log;
            object = "invalid key spec for PBEWITHSHAANDTWOFISH-CBC";
            object2.e((String)object);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object2 = Log;
            object = "no key factory support for PBEWITHSHAANDTWOFISH-CBC";
            object2.e((String)object);
        }
        object2 = this.sk.getEncoded();
        object = new SecretKeySpec;
        super((byte[])object2, "AES");
        this.skforAES = object;
        object2 = new IvParameterSpec;
        object = this.iv;
        super((byte[])object);
        this.IV = object2;
    }

    private byte[] addPadding(byte[] byArray) {
        int n10;
        int n11;
        int n12 = byArray.length;
        int n13 = 16;
        n12 %= n13;
        if ((n12 = 16 - n12) != 0) {
            n13 = n12;
        }
        n12 = byArray.length + n13;
        byte[] byArray2 = new byte[n12];
        for (n11 = 0; n11 < (n10 = byArray.length); ++n11) {
            byArray2[n11] = n10 = byArray[n11];
        }
        for (n11 = byArray.length; n11 < (n10 = byArray.length + n13); ++n11) {
            byArray2[n11] = n10 = (int)((byte)n13);
        }
        return byArray2;
    }

    private byte[] decrypt(String object, SecretKey object2, IvParameterSpec object3, byte[] object4) {
        Cipher cipher = Cipher.getInstance((String)object);
        int n10 = 2;
        cipher.init(n10, (Key)object2, (AlgorithmParameterSpec)object3);
        try {
            return cipher.doFinal((byte[])object4);
        }
        catch (BadPaddingException badPaddingException) {
            object = Log;
            object2 = "bad padding exception";
            ((AVLogger)object).e((String)object2);
        }
        catch (IllegalBlockSizeException illegalBlockSizeException) {
            object = Log;
            object2 = "illegal block size exception";
            ((AVLogger)object).e((String)object2);
        }
        catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
            object = Log;
            object2 = "invalid algorithm parameter exception";
            ((AVLogger)object).e((String)object2);
        }
        catch (InvalidKeyException invalidKeyException) {
            object = Log;
            object2 = "invalid key exception";
            ((AVLogger)object).e((String)object2);
        }
        catch (NoSuchPaddingException noSuchPaddingException) {
            object2 = Log;
            object3 = new StringBuilder();
            object4 = "no cipher getinstance support for padding ";
            ((StringBuilder)object3).append((String)object4);
            ((StringBuilder)object3).append((String)object);
            object = ((StringBuilder)object3).toString();
            ((AVLogger)object2).e((String)object);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object2 = Log;
            object3 = new StringBuilder();
            object4 = "no cipher getinstance support for ";
            ((StringBuilder)object3).append((String)object4);
            ((StringBuilder)object3).append((String)object);
            object = ((StringBuilder)object3).toString();
            ((AVLogger)object2).e((String)object);
        }
        return null;
    }

    private byte[] dropPadding(byte[] byArray) {
        int n10 = byArray.length + -1;
        n10 = byArray[n10];
        int n11 = byArray.length - n10;
        byte[] byArray2 = new byte[n11];
        for (int i10 = 0; i10 < n11; ++i10) {
            byte by2;
            byArray2[i10] = by2 = byArray[i10];
            byArray[i10] = 0;
        }
        return byArray2;
    }

    private byte[] encrypt(String object, SecretKey object2, IvParameterSpec object3, byte[] object4) {
        Cipher cipher = Cipher.getInstance((String)object);
        int n10 = 1;
        cipher.init(n10, (Key)object2, (AlgorithmParameterSpec)object3);
        try {
            return cipher.doFinal((byte[])object4);
        }
        catch (BadPaddingException badPaddingException) {
            object = Log;
            object2 = "bad padding exception";
            ((AVLogger)object).e((String)object2);
        }
        catch (IllegalBlockSizeException illegalBlockSizeException) {
            object = Log;
            object2 = "illegal block size exception";
            ((AVLogger)object).e((String)object2);
        }
        catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
            object = Log;
            object2 = "invalid algorithm parameter exception";
            ((AVLogger)object).e((String)object2);
        }
        catch (InvalidKeyException invalidKeyException) {
            object = Log;
            object2 = "invalid key exception";
            ((AVLogger)object).e((String)object2);
        }
        catch (NoSuchPaddingException noSuchPaddingException) {
            object2 = Log;
            object3 = new StringBuilder();
            object4 = "no cipher getinstance support for padding ";
            ((StringBuilder)object3).append((String)object4);
            ((StringBuilder)object3).append((String)object);
            object = ((StringBuilder)object3).toString();
            ((AVLogger)object2).e((String)object);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object2 = Log;
            object3 = new StringBuilder();
            object4 = "no cipher getinstance support for ";
            ((StringBuilder)object3).append((String)object4);
            ((StringBuilder)object3).append((String)object);
            object = ((StringBuilder)object3).toString();
            ((AVLogger)object2).e((String)object);
        }
        return null;
    }

    public String decrypt(String object) {
        object = Base64Decoder.decodeToBytes((String)object);
        SecretKeySpec secretKeySpec = this.skforAES;
        IvParameterSpec ivParameterSpec = this.IV;
        object = this.decrypt(CIPHERMODEPADDING, secretKeySpec, ivParameterSpec, (byte[])object);
        String string2 = new String((byte[])object);
        return string2;
    }

    public String encrypt(byte[] byArray) {
        SecretKeySpec secretKeySpec = this.skforAES;
        IvParameterSpec ivParameterSpec = this.IV;
        return Base64Encoder.encode(this.encrypt(CIPHERMODEPADDING, secretKeySpec, ivParameterSpec, byArray));
    }
}

