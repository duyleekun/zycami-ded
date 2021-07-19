/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.util.Log
 */
package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.zzd;
import com.google.android.gms.common.zze;
import com.google.android.gms.common.zzj;
import com.google.android.gms.common.zzl;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import com.google.android.gms.dynamite.DynamiteModule$VersionPolicy;
import java.util.concurrent.Callable;

public final class zzc {
    private static volatile zzq zza;
    private static final Object zzb;
    private static Context zzc;

    static {
        Object object;
        zzb = object = new Object();
    }

    public static zzl zza(String object, zzd zzd2, boolean bl2, boolean bl3) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
        try {
            object = com.google.android.gms.common.zzc.zzb((String)object, zzd2, bl2, bl3);
            return object;
        }
        finally {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        }
    }

    public static final /* synthetic */ String zza(boolean bl2, String string2, zzd zzd2) {
        boolean bl3;
        block3: {
            block2: {
                bl3 = true;
                if (bl2) break block2;
                zzl zzl2 = com.google.android.gms.common.zzc.zzb(string2, zzd2, bl3, false);
                boolean bl4 = zzl2.zza;
                if (bl4) break block3;
            }
            bl3 = false;
        }
        return zzl.zza(string2, zzd2, bl2, bl3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void zza(Context object) {
        Class<zzc> clazz = zzc.class;
        synchronized (clazz) {
            Context context = zzc;
            if (context == null) {
                if (object != null) {
                    Context context2;
                    zzc = context2 = object.getApplicationContext();
                    return;
                }
            } else {
                String string2 = "GoogleCertificates";
                String string3 = "GoogleCertificates has been initialized already";
                Log.w((String)string2, (String)string3);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static zzl zzb(String string2, zzd object, boolean bl2, boolean bl3) {
        Object object2;
        block9: {
            Object object3;
            Object object4;
            block8: {
                String string3;
                Object object5;
                try {
                    object4 = zza;
                    if (object4 != null) break block8;
                    object4 = zzc;
                    Preconditions.checkNotNull(object4);
                    object4 = zzb;
                    synchronized (object4) {
                        object3 = zza;
                        if (object3 != null) break block8;
                        object3 = zzc;
                        object5 = DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING;
                        string3 = "com.google.android.gms.googlecertificates";
                    }
                }
                catch (DynamiteModule$LoadingException dynamiteModule$LoadingException) {
                    Log.e((String)"GoogleCertificates", (String)"Failed to get Google certificates from remote", (Throwable)dynamiteModule$LoadingException);
                    object = "module init: ";
                    String string4 = String.valueOf(dynamiteModule$LoadingException.getMessage());
                    bl3 = string4.length();
                    if (bl3) {
                        object = ((String)object).concat(string4);
                        return zzl.zza((String)object, dynamiteModule$LoadingException);
                    }
                    string4 = new String((String)object);
                    object = string4;
                    return zzl.zza((String)object, dynamiteModule$LoadingException);
                }
                {
                    object3 = DynamiteModule.load((Context)object3, (DynamiteModule$VersionPolicy)object5, string3);
                    object5 = "com.google.android.gms.common.GoogleCertificatesImpl";
                    object3 = ((DynamiteModule)object3).instantiate((String)object5);
                    zza = object3 = zzp.zza((IBinder)object3);
                }
            }
            Preconditions.checkNotNull(zzc);
            object4 = new zzj(string2, (zzd)object, bl2, bl3);
            try {
                object2 = zza;
                object3 = zzc;
                object3 = object3.getPackageManager();
                object3 = ObjectWrapper.wrap(object3);
                bl3 = object2.zza((zzj)object4, (IObjectWrapper)object3);
                if (!bl3) break block9;
                return zzl.zza();
            }
            catch (RemoteException remoteException) {
                Log.e((String)"GoogleCertificates", (String)"Failed to get Google certificates from remote", (Throwable)remoteException);
                return zzl.zza("module call", remoteException);
            }
        }
        object2 = new zze(bl2, string2, (zzd)object);
        return zzl.zza((Callable)object2);
    }
}

