/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.util.Log
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.api.internal.zacc;
import com.google.android.gms.common.api.internal.zacn;
import com.google.android.gms.common.api.internal.zaco;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class zacm
extends TransformedResult
implements ResultCallback {
    private final Object zado;
    private final WeakReference zadq;
    private ResultTransform zako = null;
    private zacm zakp = null;
    private volatile ResultCallbacks zakq = null;
    private PendingResult zakr = null;
    private Status zaks;
    private final zaco zakt;
    private boolean zaku;

    public zacm(WeakReference object) {
        zaco zaco2;
        Object object2;
        this.zado = object2 = new Object();
        this.zaks = null;
        this.zaku = false;
        Preconditions.checkNotNull(object, "GoogleApiClient reference must not be null");
        this.zadq = object;
        object = (GoogleApiClient)((Reference)object).get();
        object = object != null ? ((GoogleApiClient)object).getLooper() : Looper.getMainLooper();
        this.zakt = zaco2 = new zaco(this, (Looper)object);
    }

    public static /* synthetic */ void zaa(zacm zacm2, Result result2) {
        zacm.zab(result2);
    }

    public static /* synthetic */ void zaa(zacm zacm2, Status status) {
        zacm2.zad(status);
    }

    private static void zab(Result object) {
        boolean bl2 = object instanceof Releasable;
        if (bl2) {
            Object object2 = object;
            object2 = (Releasable)object;
            try {
                object2.release();
                return;
            }
            catch (RuntimeException runtimeException) {
                object = String.valueOf(object);
                int n10 = String.valueOf(object).length() + 18;
                StringBuilder stringBuilder = new StringBuilder(n10);
                stringBuilder.append("Unable to release ");
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                String string2 = "TransformedResultImpl";
                Log.w((String)string2, (String)object, (Throwable)runtimeException);
            }
        }
    }

    private final void zabu() {
        ResultTransform resultTransform;
        Object object = this.zako;
        if (object == null && (object = this.zakq) == null) {
            return;
        }
        object = (GoogleApiClient)this.zadq.get();
        boolean bl2 = this.zaku;
        if (!bl2 && (resultTransform = this.zako) != null && object != null) {
            boolean bl3;
            ((GoogleApiClient)object).zaa(this);
            this.zaku = bl3 = true;
        }
        if ((object = this.zaks) != null) {
            this.zae((Status)object);
            return;
        }
        object = this.zakr;
        if (object != null) {
            ((PendingResult)object).setResultCallback(this);
        }
    }

    private final boolean zabw() {
        GoogleApiClient googleApiClient = (GoogleApiClient)this.zadq.get();
        ResultCallbacks resultCallbacks = this.zakq;
        return resultCallbacks != null && googleApiClient != null;
    }

    public static /* synthetic */ ResultTransform zac(zacm zacm2) {
        return zacm2.zako;
    }

    public static /* synthetic */ zaco zad(zacm zacm2) {
        return zacm2.zakt;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void zad(Status status) {
        Object object = this.zado;
        synchronized (object) {
            this.zaks = status;
            this.zae(status);
            return;
        }
    }

    public static /* synthetic */ WeakReference zae(zacm zacm2) {
        return zacm2.zadq;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void zae(Status status) {
        Object object = this.zado;
        synchronized (object) {
            Object object2 = this.zako;
            if (object2 != null) {
                status = ((ResultTransform)object2).onFailure(status);
                object2 = "onFailure must not return null";
                Preconditions.checkNotNull(status, object2);
                object2 = this.zakp;
                super.zad(status);
            } else {
                boolean bl2 = this.zabw();
                if (bl2) {
                    object2 = this.zakq;
                    ((ResultCallbacks)object2).onFailure(status);
                }
            }
            return;
        }
    }

    public static /* synthetic */ Object zaf(zacm zacm2) {
        return zacm2.zado;
    }

    public static /* synthetic */ zacm zag(zacm zacm2) {
        return zacm2.zakp;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void andFinally(ResultCallbacks resultCallbacks) {
        Object object = this.zado;
        synchronized (object) {
            boolean bl2;
            Object object2 = this.zakq;
            boolean bl3 = true;
            if (object2 == null) {
                bl2 = bl3;
            } else {
                bl2 = false;
                object2 = null;
            }
            String string2 = "Cannot call andFinally() twice.";
            Preconditions.checkState(bl2, string2);
            object2 = this.zako;
            if (object2 != null) {
                bl3 = false;
            }
            object2 = "Cannot call then() and andFinally() on the same TransformedResult.";
            Preconditions.checkState(bl3, object2);
            this.zakq = resultCallbacks;
            this.zabu();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onResult(Result result2) {
        Object object = this.zado;
        synchronized (object) {
            block6: {
                Object object2;
                block5: {
                    object2 = result2.getStatus();
                    boolean bl2 = ((Status)object2).isSuccess();
                    if (!bl2) break block5;
                    object2 = this.zako;
                    if (object2 != null) {
                        object2 = zacc.zabb();
                        zacn zacn2 = new zacn(this, result2);
                        object2.submit(zacn2);
                        break block6;
                    } else {
                        bl2 = this.zabw();
                        if (bl2) {
                            object2 = this.zakq;
                            ((ResultCallbacks)object2).onSuccess(result2);
                        }
                    }
                    break block6;
                }
                object2 = result2.getStatus();
                this.zad((Status)object2);
                zacm.zab(result2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final TransformedResult then(ResultTransform object) {
        Object object2 = this.zado;
        synchronized (object2) {
            boolean bl2;
            Object object3 = this.zako;
            boolean bl3 = true;
            if (object3 == null) {
                bl2 = bl3;
            } else {
                bl2 = false;
                object3 = null;
            }
            String string2 = "Cannot call then() twice.";
            Preconditions.checkState(bl2, string2);
            object3 = this.zakq;
            if (object3 != null) {
                bl3 = false;
            }
            object3 = "Cannot call then() and andFinally() on the same TransformedResult.";
            Preconditions.checkState(bl3, object3);
            this.zako = object;
            object3 = this.zadq;
            this.zakp = object = new zacm((WeakReference)object3);
            this.zabu();
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zaa(PendingResult pendingResult) {
        Object object = this.zado;
        synchronized (object) {
            this.zakr = pendingResult;
            this.zabu();
            return;
        }
    }

    public final void zabv() {
        this.zakq = null;
    }
}

