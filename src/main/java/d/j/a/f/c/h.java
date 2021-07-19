/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package d.j.a.f.c;

import android.content.Context;
import android.util.Log;
import d.j.a.f.c.d;
import d.j.a.f.c.f;
import d.j.a.f.c.g;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class h
extends g {
    private final Map c;
    private final Object d;
    private SecretKey e;
    private boolean f;

    public h(Context object, String object2) {
        boolean bl2;
        block12: {
            super((Context)object, (String)object2);
            super();
            this.c = object;
            super();
            this.d = object;
            this.f = bl2 = true;
            object = "/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138";
            object = this.e((String)object);
            object2 = "/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C";
            object2 = this.e((String)object2);
            Object object3 = "/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B";
            object3 = this.e((String)object3);
            Object object4 = "/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD";
            object4 = this.e((String)object4);
            if (object == null || object2 == null || object3 == null || object4 == null) break block12;
            object = d.j.a.f.c.d.b((String)object);
            object2 = d.j.a.f.c.d.b((String)object2);
            object3 = d.j.a.f.c.d.b((String)object3);
            object4 = d.j.a.f.c.d.b((String)object4);
            object = d.j.a.f.c.f.a((byte[])object, (byte[])object2, (byte[])object3, (byte[])object4);
            this.e = object;
        }
        bl2 = false;
        object = null;
        try {
            this.f = false;
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException generalSecurityException) {
            object2 = "Exception when reading the 'K&I' for 'Config'.";
            Log.e((String)"SecurityResourcesReader", (String)object2);
            bl2 = false;
            object = null;
            this.e = null;
        }
    }

    private static byte[] d(SecretKey serializable, byte[] byArray) {
        if (serializable != null && byArray != null) {
            int n10 = 1;
            byte[] byArray2 = Arrays.copyOfRange(byArray, n10, 17);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(byArray2);
            cipher.init(2, (Key)serializable, ivParameterSpec);
            int n11 = byArray2.length + n10;
            int n12 = byArray.length;
            int n13 = byArray2.length;
            n12 = n12 - n13 - n10;
            return cipher.doFinal(byArray, n11, n12);
        }
        serializable = new NullPointerException("key or cipherText must not be null.");
        throw serializable;
    }

    private String e(String string2) {
        return super.a(string2, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String a(String string2, String string3) {
        boolean bl2 = this.f;
        if (!bl2) {
            if ((string2 = this.e(string2)) == null) return string3;
            return string2;
        }
        Object object = this.e;
        if (object == null) {
            Log.e((String)"SecurityResourcesReader", (String)"KEY is null return def directly");
            return string3;
        }
        object = this.d;
        synchronized (object) {
            Object object2 = this.c;
            object2 = object2.get(string2);
            object2 = (String)object2;
            if (object2 != null) {
                return object2;
            }
            object2 = this.e(string2);
            if (object2 == null) {
                return string3;
            }
            try {
                Object object3 = this.e;
                object2 = d.j.a.f.c.d.b((String)object2);
                object2 = h.d((SecretKey)object3, (byte[])object2);
                object3 = "UTF-8";
                String string4 = new String((byte[])object2, (String)object3);
                object2 = this.c;
                object2.put(string2, string4);
                return string4;
            }
            catch (UnsupportedEncodingException | GeneralSecurityException exception) {
                string2 = "SecurityResourcesReader";
                object2 = "Exception when reading the 'V' for 'Config'.";
                Log.e((String)string2, (String)object2);
                return string3;
            }
        }
    }
}

