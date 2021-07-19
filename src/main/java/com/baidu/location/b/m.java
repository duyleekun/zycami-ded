/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.baidu.location.b;

import android.util.Base64;
import com.baidu.location.Jni;
import com.baidu.location.b.m$1;
import com.baidu.location.b.m$a;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class m {
    private IvParameterSpec a;
    private SecretKeySpec b;
    private boolean c;

    private m() {
        block14: {
            Object object = "UTF-8";
            String string2 = null;
            this.c = false;
            String[] stringArray = Jni.getldkaiv();
            if (stringArray == null) break block14;
            Object object2 = "|";
            boolean bl2 = stringArray.contains((CharSequence)object2);
            if (!bl2) break block14;
            object2 = "\\|";
            stringArray = stringArray.split((String)object2);
            int n10 = 1;
            Object object3 = stringArray[n10];
            object3 = ((String)object3).getBytes((String)object);
            object2 = new IvParameterSpec((byte[])object3);
            this.a = object2;
            string2 = stringArray[0];
            object = string2.getBytes((String)object);
            string2 = "AES";
            object2 = new SecretKeySpec((byte[])object, string2);
            this.b = object2;
            try {
                this.c = n10;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public /* synthetic */ m(m$1 m$1) {
        this();
    }

    public static m a() {
        return m$a.a();
    }

    public String a(String object) {
        boolean bl2 = this.c;
        if (bl2) {
            Object object2 = "AES/CBC/PKCS5PADDING";
            object2 = Cipher.getInstance((String)object2);
            int n10 = 1;
            SecretKeySpec secretKeySpec = this.b;
            IvParameterSpec ivParameterSpec = this.a;
            ((Cipher)object2).init(n10, (Key)secretKeySpec, ivParameterSpec);
            object = ((String)object).getBytes();
            object = ((Cipher)object2).doFinal((byte[])object);
            bl2 = false;
            object2 = null;
            try {
                return Base64.encodeToString((byte[])object, (int)0);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public String b(String object) {
        synchronized (this) {
            block14: {
                boolean bl2 = this.c;
                if (bl2) break block14;
                return null;
            }
            Object object2 = "AES/CBC/PKCS5PADDING";
            object2 = Cipher.getInstance((String)object2);
            int n10 = 2;
            SecretKeySpec secretKeySpec = this.b;
            IvParameterSpec ivParameterSpec = this.a;
            ((Cipher)object2).init(n10, (Key)secretKeySpec, ivParameterSpec);
            n10 = 0;
            String string2 = null;
            object = Base64.decode((String)object, (int)0);
            object = ((Cipher)object2).doFinal((byte[])object);
            string2 = "UTF-8";
            try {
                object2 = new String((byte[])object, string2);
                return object2;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            finally {
            }
        }
    }

    public boolean b() {
        return this.c;
    }
}

