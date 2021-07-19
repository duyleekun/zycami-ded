/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.flags;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import com.google.android.gms.dynamite.DynamiteModule$VersionPolicy;
import com.google.android.gms.flags.Flag;
import com.google.android.gms.flags.zzc;
import com.google.android.gms.flags.zzd;

public final class zzb {
    private boolean zzj = false;
    private zzc zzk = null;

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void initialize(Context object) {
        synchronized (this) {
            block6: {
                void var1_4;
                boolean bl2 = this.zzj;
                if (bl2) {
                    return;
                }
                try {
                    boolean bl3;
                    Object object2 = DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING;
                    String string2 = "com.google.android.gms.flags";
                    object2 = DynamiteModule.load(object, (DynamiteModule$VersionPolicy)object2, string2);
                    string2 = "com.google.android.gms.flags.impl.FlagProviderImpl";
                    object2 = ((DynamiteModule)object2).instantiate(string2);
                    this.zzk = object2 = zzd.asInterface((IBinder)object2);
                    object = ObjectWrapper.wrap(object);
                    object2.init((IObjectWrapper)object);
                    this.zzj = bl3 = true;
                    break block6;
                }
                catch (RemoteException remoteException) {
                }
                catch (DynamiteModule$LoadingException dynamiteModule$LoadingException) {
                    // empty catch block
                }
                String string3 = "FlagValueProvider";
                String string4 = "Failed to initialize flags module.";
                Log.w((String)string3, (String)string4, (Throwable)var1_4);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zzb(Flag object) {
        synchronized (this) {
            boolean bl2 = this.zzj;
            if (!bl2) {
                return ((Flag)object).zzb();
            }
        }
        zzc zzc2 = this.zzk;
        return ((Flag)object).zza(zzc2);
    }
}

