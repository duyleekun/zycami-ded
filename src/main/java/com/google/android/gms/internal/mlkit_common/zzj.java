/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.system.OsConstants
 *  android.system.StructStat
 */
package com.google.android.gms.internal.mlkit_common;

import android.os.Build;
import android.system.OsConstants;
import android.system.StructStat;
import com.google.android.gms.internal.mlkit_common.zzi;
import com.google.android.gms.internal.mlkit_common.zzk;
import com.google.android.gms.internal.mlkit_common.zzl;
import com.google.android.gms.internal.mlkit_common.zzn;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.concurrent.Callable;

public final class zzj {
    public final long zza;
    public final long zzb;
    public final boolean zzc;

    private zzj(long l10, long l11, boolean bl2) {
        this.zza = l10;
        this.zzb = l11;
        this.zzc = bl2;
    }

    public /* synthetic */ zzj(long l10, long l11, boolean bl2, zzk zzk2) {
        this(l10, l11, bl2);
    }

    public static zzj zza(FileDescriptor fileDescriptor) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            zzj zzj2;
            Object object = new zzi(fileDescriptor);
            fileDescriptor = (StructStat)zzj.zza((Callable)object);
            long l10 = ((StructStat)fileDescriptor).st_dev;
            long l11 = ((StructStat)fileDescriptor).st_ino;
            boolean bl2 = OsConstants.S_ISLNK((int)((StructStat)fileDescriptor).st_mode);
            object = zzj2;
            zzj2 = new zzj(l10, l11, bl2);
            return zzj2;
        }
        return zzn.zza(fileDescriptor);
    }

    public static zzj zza(String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            zzj zzj2;
            Object object = new zzl(string2);
            string2 = (StructStat)zzj.zza((Callable)object);
            long l10 = ((StructStat)string2).st_dev;
            long l11 = ((StructStat)string2).st_ino;
            boolean bl2 = OsConstants.S_ISLNK((int)((StructStat)string2).st_mode);
            object = zzj2;
            zzj2 = new zzj(l10, l11, bl2);
            return zzj2;
        }
        return zzn.zza(string2);
    }

    private static Object zza(Callable callable) {
        try {
            return callable.call();
        }
        catch (Throwable throwable) {
            IOException iOException = new IOException(throwable);
            throw iOException;
        }
    }
}

