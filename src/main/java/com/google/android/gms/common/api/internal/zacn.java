/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Message
 */
package com.google.android.gms.common.api.internal;

import android.os.Message;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zacm;

public final class zacn
implements Runnable {
    private final /* synthetic */ Result zakv;
    private final /* synthetic */ zacm zakw;

    public zacn(zacm zacm2, Result result2) {
        this.zakw = zacm2;
        this.zakv = result2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Throwable throwable2222222;
        Object object;
        block7: {
            object = Boolean.FALSE;
            Object object2 = BasePendingResult.zadn;
            Object object3 = Boolean.TRUE;
            ((ThreadLocal)object2).set(object3);
            object3 = this.zakw;
            object3 = zacm.zac((zacm)object3);
            Object object4 = this.zakv;
            object3 = ((ResultTransform)object3).onSuccess((Result)object4);
            object4 = this.zakw;
            object4 = zacm.zad((zacm)object4);
            Object object5 = this.zakw;
            object5 = zacm.zad(object5);
            object3 = object5.obtainMessage(0, object3);
            object4.sendMessage((Message)object3);
            {
                Object object6;
                catch (Throwable throwable2222222) {
                    break block7;
                }
                catch (RuntimeException runtimeException) {}
                {
                    Object object7 = this.zakw;
                    object7 = zacm.zad(object7);
                    Object object8 = this.zakw;
                    object8 = zacm.zad(object8);
                    int n10 = 1;
                    object6 = object8.obtainMessage(n10, runtimeException);
                    object7.sendMessage(object6);
                    BasePendingResult.zadn.set(object);
                    object = this.zakw;
                    object6 = this.zakv;
                }
                zacm.zaa((zacm)object, (Result)object6);
                object = (GoogleApiClient)zacm.zae(this.zakw).get();
                if (object != null) {
                    object6 = this.zakw;
                    ((GoogleApiClient)object).zab((zacm)object6);
                }
                return;
            }
            ((ThreadLocal)object2).set(object);
            object = this.zakw;
            object2 = this.zakv;
            zacm.zaa((zacm)object, (Result)object2);
            object = (GoogleApiClient)zacm.zae(this.zakw).get();
            if (object != null) {
                object2 = this.zakw;
                ((GoogleApiClient)object).zab((zacm)object2);
            }
            return;
        }
        BasePendingResult.zadn.set(object);
        object = this.zakw;
        Object object9 = this.zakv;
        zacm.zaa((zacm)object, (Result)object9);
        object = (GoogleApiClient)zacm.zae(this.zakw).get();
        if (object != null) {
            object9 = this.zakw;
            ((GoogleApiClient)object).zab((zacm)object9);
        }
        throw throwable2222222;
    }
}

