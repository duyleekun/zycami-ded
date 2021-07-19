/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zacd;
import com.google.android.gms.common.api.internal.zacm;
import com.google.android.gms.internal.base.zap;

public final class zaco
extends zap {
    private final /* synthetic */ zacm zakw;

    public zaco(zacm zacm2, Looper looper) {
        this.zakw = zacm2;
        super(looper);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void handleMessage(Message object) {
        int n10 = ((Message)object).what;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                StringBuilder stringBuilder = new StringBuilder(70);
                stringBuilder.append("TransformationResultHandler received unknown message type: ");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                Log.e((String)"TransformedResultImpl", (String)string2);
                return;
            }
            object = (RuntimeException)((Message)object).obj;
            String string3 = "TransformedResultImpl";
            String string4 = "Runtime exception on the transformation worker thread: ";
            String string5 = String.valueOf(((Throwable)object).getMessage());
            int n12 = string5.length();
            string4 = n12 != 0 ? string4.concat(string5) : (string5 = new String(string4));
            Log.e((String)string3, (String)string4);
            throw object;
        }
        object = (PendingResult)((Message)object).obj;
        Object object2 = zacm.zaf(this.zakw);
        synchronized (object2) {
            if (object == null) {
                object = this.zakw;
                object = zacm.zag((zacm)object);
                int n13 = 13;
                String string6 = "Transform returned null";
                Status status = new Status(n13, string6);
                zacm.zaa((zacm)object, status);
            } else {
                boolean bl2 = object instanceof zacd;
                if (bl2) {
                    zacm zacm2 = this.zakw;
                    zacm2 = zacm.zag(zacm2);
                    object = (zacd)object;
                    object = ((zacd)object).getStatus();
                    zacm.zaa(zacm2, (Status)object);
                } else {
                    zacm zacm3 = this.zakw;
                    zacm3 = zacm.zag(zacm3);
                    zacm3.zaa((PendingResult)object);
                }
            }
            return;
        }
    }
}

