/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public abstract class zzd
extends zzn {
    private int zza;

    public zzd(byte[] byArray) {
        int n10;
        boolean bl2 = byArray.length;
        boolean bl3 = 25 != 0;
        bl2 = bl2 == bl3;
        Preconditions.checkArgument(bl2);
        this.zza = n10 = Arrays.hashCode(byArray);
    }

    public static byte[] zza(String string2) {
        Object object = "ISO-8859-1";
        try {
            return string2.getBytes((String)object);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object = new AssertionError((Object)unsupportedEncodingException);
            throw object;
        }
    }

    public boolean equals(Object object) {
        int n10;
        if (object != null && (n10 = object instanceof zzl) != 0) {
            block11: {
                block10: {
                    object = (zzl)object;
                    n10 = object.zzc();
                    int n11 = this.hashCode();
                    if (n10 == n11) break block10;
                    return false;
                }
                object = object.zzb();
                if (object != null) break block11;
                return false;
            }
            object = ObjectWrapper.unwrap((IObjectWrapper)object);
            object = (byte[])object;
            Object object2 = this.zza();
            try {
                return Arrays.equals((byte[])object2, (byte[])object);
            }
            catch (RemoteException remoteException) {
                object2 = "GoogleCertificates";
                String string2 = "Failed to get Google certificates from remote";
                Log.e((String)object2, (String)string2, (Throwable)remoteException);
            }
        }
        return false;
    }

    public int hashCode() {
        return this.zza;
    }

    public abstract byte[] zza();

    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this.zza());
    }

    public final int zzc() {
        return this.hashCode();
    }
}

