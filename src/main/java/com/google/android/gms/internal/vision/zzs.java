/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import com.google.android.gms.dynamite.DynamiteModule$VersionPolicy;
import com.google.android.gms.vision.L;

public abstract class zzs {
    private final Object lock;
    private final String tag;
    private final String zzdm;
    private final String zzdn;
    private boolean zzdo;
    private boolean zzdp;
    private Object zzdq;
    private final Context zzg;

    public zzs(Context object, String string2, String string3) {
        Object object2;
        this.lock = object2 = new Object();
        this.zzdo = false;
        this.zzdp = false;
        this.zzg = object;
        this.tag = string2;
        object = String.valueOf(string3);
        int n10 = ((String)object).length();
        object2 = "com.google.android.gms.vision.dynamite.";
        object = n10 != 0 ? ((String)object2).concat((String)object) : new String((String)object2);
        this.zzdm = object;
        this.zzdn = string3;
    }

    public final boolean isOperational() {
        Object object = this.zzr();
        return object != null;
    }

    public abstract Object zza(DynamiteModule var1, Context var2);

    public abstract void zzp();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzq() {
        Object object = this.lock;
        synchronized (object) {
            Object object2 = this.zzdq;
            if (object2 == null) {
                return;
            }
            try {
                this.zzp();
            }
            catch (RemoteException remoteException) {
                String string2 = this.tag;
                String string3 = "Could not finalize native handle";
                Log.e((String)string2, (String)string3, (Throwable)remoteException);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zzr() {
        Object object = this.lock;
        synchronized (object) {
            Object object2;
            int n10;
            boolean bl2;
            Object object3;
            block15: {
                Intent intent;
                block14: {
                    object3 = this.zzdq;
                    if (object3 != null) {
                        return object3;
                    }
                    bl2 = false;
                    object3 = null;
                    n10 = 1;
                    try {
                        object2 = this.zzg;
                        intent = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
                        String string2 = this.zzdm;
                        object3 = DynamiteModule.load(object2, (DynamiteModule$VersionPolicy)intent, string2);
                    }
                    catch (DynamiteModule$LoadingException dynamiteModule$LoadingException) {
                        object2 = "%s.%s";
                        int n11 = 2;
                        intent = new Object[n11];
                        Object object4 = "com.google.android.gms.vision";
                        String string3 = null;
                        intent[0] = object4;
                        object4 = this.zzdn;
                        intent[n10] = object4;
                        object2 = String.format((String)object2, (Object[])intent);
                        intent = "Cannot load thick client module, fall back to load optional module %s";
                        object4 = new Object[n10];
                        object4[0] = object2;
                        L.d((String)intent, object4);
                        try {
                            intent = this.zzg;
                            object4 = DynamiteModule.PREFER_REMOTE;
                            object3 = DynamiteModule.load((Context)intent, (DynamiteModule$VersionPolicy)object4, (String)object2);
                        }
                        catch (DynamiteModule$LoadingException dynamiteModule$LoadingException2) {
                            object4 = "Error loading optional module %s";
                            Object[] objectArray = new Object[n10];
                            objectArray[0] = object2;
                            L.e(dynamiteModule$LoadingException2, (String)object4, objectArray);
                            boolean bl3 = this.zzdo;
                            if (bl3) break block14;
                            object2 = "Broadcasting download intent for dependency %s";
                            intent = new Object[n10];
                            intent[0] = object4 = this.zzdn;
                            L.d((String)object2, (Object[])intent);
                            object2 = this.zzdn;
                            intent = new Intent();
                            object4 = "com.google.android.gms";
                            string3 = "com.google.android.gms.vision.DependencyBroadcastReceiverProxy";
                            intent.setClassName((String)object4, string3);
                            object4 = "com.google.android.gms.vision.DEPENDENCIES";
                            intent.putExtra((String)object4, (String)object2);
                            object2 = "com.google.android.gms.vision.DEPENDENCY";
                            intent.setAction((String)object2);
                            object2 = this.zzg;
                            object2.sendBroadcast(intent);
                            this.zzdo = n10;
                        }
                    }
                }
                if (object3 != null) {
                    try {
                        object2 = this.zzg;
                        this.zzdq = object3 = this.zza((DynamiteModule)object3, (Context)object2);
                        break block15;
                    }
                    catch (RemoteException remoteException) {
                    }
                    catch (DynamiteModule$LoadingException dynamiteModule$LoadingException) {
                        // empty catch block
                    }
                    object2 = this.tag;
                    intent = "Error creating remote native handle";
                    Log.e((String)object2, (String)intent, (Throwable)object3);
                }
            }
            if (!(bl2 = this.zzdp) && (object2 = this.zzdq) == null) {
                object3 = this.tag;
                object2 = "Native handle not yet available. Reverting to no-op handle.";
                Log.w((String)object3, (String)object2);
                this.zzdp = n10;
                return this.zzdq;
            } else {
                if (!bl2) return this.zzdq;
                object3 = this.zzdq;
                if (object3 == null) return this.zzdq;
                object3 = this.tag;
                String string4 = "Native handle is now available.";
                Log.w((String)object3, (String)string4);
            }
            return this.zzdq;
        }
    }
}

