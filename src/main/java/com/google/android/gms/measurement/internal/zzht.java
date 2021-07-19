/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.measurement.internal.zzfd;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public final class zzht {
    public static String zza(Context context, String string2) {
        StringResourceValueReader stringResourceValueReader;
        string2 = "google_app_id";
        try {
            stringResourceValueReader = new StringResourceValueReader(context);
        }
        catch (Resources.NotFoundException notFoundException) {
            return null;
        }
        return stringResourceValueReader.getString(string2);
    }

    public static String zzb(Context context, String string2, String string3) {
        Preconditions.checkNotNull(context);
        string2 = context.getResources();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2) {
            string3 = zzfd.zza(context);
        }
        return zzfd.zzb("google_app_id", (Resources)string2, string3);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object zzc(Object object) {
        block19: {
            void var1_5;
            ObjectOutputStream objectOutputStream;
            block18: {
                if (object == null) break block19;
                Object object2 = new ByteArrayOutputStream();
                objectOutputStream = new ObjectOutputStream((OutputStream)object2);
                objectOutputStream.writeObject(object);
                objectOutputStream.flush();
                object2 = ((ByteArrayOutputStream)object2).toByteArray();
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])object2);
                object = new ObjectInputStream(byteArrayInputStream);
                try {
                    object2 = ((ObjectInputStream)object).readObject();
                }
                catch (Throwable throwable) {
                    break block18;
                }
                objectOutputStream.close();
                ((ObjectInputStream)object).close();
                return object2;
                catch (Throwable throwable) {
                    object = null;
                }
                break block18;
                catch (Throwable throwable) {
                    object = null;
                    objectOutputStream = null;
                }
            }
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            if (object == null) throw var1_5;
            try {
                ((ObjectInputStream)object).close();
                throw var1_5;
            }
            catch (IOException | ClassNotFoundException exception) {
                return null;
            }
        }
        return null;
    }

    public static String zzd(String string2, String[] stringArray, String[] stringArray2) {
        Preconditions.checkNotNull(stringArray);
        Preconditions.checkNotNull(stringArray2);
        int n10 = stringArray.length;
        int n11 = stringArray2.length;
        n10 = Math.min(n10, n11);
        for (n11 = 0; n11 < n10; ++n11) {
            boolean bl2;
            String string3 = stringArray[n11];
            if ((string2 != null || string3 != null) && (string2 == null || !(bl2 = string2.equals(string3)))) continue;
            return stringArray2[n11];
        }
        return null;
    }
}

