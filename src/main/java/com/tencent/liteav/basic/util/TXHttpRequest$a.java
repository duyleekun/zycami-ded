/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  android.os.Handler
 *  android.os.Looper
 */
package com.tencent.liteav.basic.util;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXHttpRequest;
import com.tencent.liteav.basic.util.TXHttpRequest$a$1;
import com.tencent.liteav.basic.util.TXHttpRequest$b;
import java.lang.ref.WeakReference;
import java.util.Map;

public class TXHttpRequest$a
extends AsyncTask {
    private WeakReference a;
    private Handler b = null;
    private Map c;

    public TXHttpRequest$a(TXHttpRequest tXHttpRequest, Map handler) {
        this.c = handler;
        this.a = handler = new WeakReference(tXHttpRequest);
        tXHttpRequest = Looper.myLooper();
        this.b = tXHttpRequest != null ? (handler = new Handler((Looper)tXHttpRequest)) : null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public TXHttpRequest$b a(byte[] ... object) {
        TXHttpRequest$b tXHttpRequest$b = new TXHttpRequest$b();
        int n10 = 1;
        try {
            byte[] byArray = object[0];
            Object object2 = new String(byArray);
            String string2 = "https";
            boolean bl2 = ((String)object2).startsWith(string2);
            if (bl2) {
                object2 = this.c;
                byte[] byArray2 = object[0];
                String string3 = new String(byArray2);
                byte[] byArray4 = object[n10];
                byArray4 = TXHttpRequest.getHttpsPostRsp((Map)object2, string3, byArray4);
                tXHttpRequest$b.c = byArray4;
            } else {
                object2 = this.c;
                byte[] byArray5 = object[0];
                String string4 = new String(byArray5);
                byte[] byArray7 = object[n10];
                byArray7 = TXHttpRequest.getHttpPostRsp((Map)object2, string4, byArray7);
                tXHttpRequest$b.c = byArray7;
            }
            tXHttpRequest$b.a = 0;
        }
        catch (Exception exception) {
            String string5;
            tXHttpRequest$b.b = string5 = exception.toString();
            tXHttpRequest$b.a = n10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TXPostRequest->result: ");
        n10 = tXHttpRequest$b.a;
        stringBuilder.append(n10);
        stringBuilder.append("|");
        String string6 = tXHttpRequest$b.b;
        stringBuilder.append(string6);
        String string7 = stringBuilder.toString();
        TXCLog.i("TXHttpRequest", string7);
        return tXHttpRequest$b;
    }

    public void a(TXHttpRequest$b object) {
        long l10;
        long l11;
        long l12;
        long l13;
        super.onPostExecute(object);
        TXHttpRequest tXHttpRequest = (TXHttpRequest)this.a.get();
        if (tXHttpRequest != null && (l13 = (l12 = (l11 = TXHttpRequest.access$000(tXHttpRequest)) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            Object object2 = this.b;
            if (object2 != null) {
                TXHttpRequest$a$1 tXHttpRequest$a$1 = new TXHttpRequest$a$1(this, (TXHttpRequest$b)object, tXHttpRequest);
                object2.post((Runnable)tXHttpRequest$a$1);
            } else {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("TXPostRequest->recvMsg: ");
                int n10 = ((TXHttpRequest$b)object).a;
                ((StringBuilder)object2).append(n10);
                ((StringBuilder)object2).append("|");
                String string2 = ((TXHttpRequest$b)object).b;
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                string2 = "TXHttpRequest";
                TXCLog.i(string2, (String)object2);
                l11 = TXHttpRequest.access$000(tXHttpRequest);
                int n11 = ((TXHttpRequest$b)object).a;
                object = ((TXHttpRequest$b)object).c;
                TXHttpRequest.access$100(tXHttpRequest, l11, n11, (byte[])object);
            }
        }
    }

    public /* synthetic */ Object doInBackground(Object[] object) {
        object = (byte[][])object;
        return this.a((byte[][])object);
    }

    public /* synthetic */ void onPostExecute(Object object) {
        object = (TXHttpRequest$b)object;
        this.a((TXHttpRequest$b)object);
    }
}

