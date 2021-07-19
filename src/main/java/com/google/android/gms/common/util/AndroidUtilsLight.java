/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.Signature
 */
package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.Signature;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.common.zzm;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AndroidUtilsLight {
    private static volatile int zza = 255;

    public static Context getDeviceProtectedStorageContext(Context context) {
        boolean bl2 = zzm.zza();
        if (bl2) {
            context = zzm.zza(context);
        }
        return context;
    }

    public static byte[] getPackageCertificateHashBytes(Context object, String object2) {
        int n10;
        object = Wrappers.packageManager(object);
        int n11 = 64;
        object = object.getPackageInfo((String)object2, n11);
        object2 = object.signatures;
        if (object2 != null && (n10 = ((Signature[])object2).length) == (n11 = 1) && (object2 = AndroidUtilsLight.zza("SHA1")) != null) {
            object = object.signatures[0].toByteArray();
            return ((MessageDigest)object2).digest((byte[])object);
        }
        return null;
    }

    public static MessageDigest zza(String string2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = 2); ++i10) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(string2);
                if (messageDigest == null) continue;
                return messageDigest;
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
        }
        return null;
    }
}

