/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.tencent.liteav;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.b;
import com.tencent.liteav.b$b;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.Reference;

public class b$a
extends Handler {
    public final /* synthetic */ b a;
    private int b;
    private long c;

    public b$a(b object, Looper object2, int n10, long l10) {
        this.a = object;
        super((Looper)object2);
        this.b = 300;
        this.c = 0L;
        this.b = n10;
        this.c = l10;
        object = com.tencent.liteav.b.c();
        super();
        ((StringBuilder)object2).append("bkgpush:init publish time delay:");
        n10 = this.b;
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append(", end:");
        long l11 = this.c;
        ((StringBuilder)object2).append(l11);
        object2 = ((StringBuilder)object2).toString();
        TXCLog.w((String)object, (String)object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void handleMessage(Message object) {
        int n10 = ((Message)object).what;
        int n11 = 1001;
        if (n10 != n11) return;
        try {
            long l10;
            object = this.a;
            com.tencent.liteav.b.a((b)object);
            long l11 = this.c;
            long l12 = 0L;
            n10 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
            if (n10 >= 0 && (n10 = (int)((l10 = (l11 = System.currentTimeMillis()) - (l12 = this.c)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) >= 0) {
                object = com.tencent.liteav.b.c();
                String string2 = "bkgpush:stop background publish when timeout";
                TXCLog.w((String)object, string2);
                object = this.a;
                object = com.tencent.liteav.b.b((b)object);
                if (object == null) return;
                object = this.a;
                n10 = (int)(com.tencent.liteav.b.c((b)object) ? 1 : 0);
                if (n10 == 0) return;
                object = this.a;
                object = com.tencent.liteav.b.b((b)object);
                object = ((Reference)object).get();
                if ((object = (b$b)object) != null) {
                    object.a();
                }
                object = this.a;
                n11 = 0;
                string2 = null;
                com.tencent.liteav.b.a((b)object, false);
                return;
            }
            n10 = this.b;
            l11 = n10;
            this.sendEmptyMessageDelayed(n11, l11);
            return;
        }
        catch (Exception exception) {
            String string3 = com.tencent.liteav.b.c();
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "publish image failed.";
            stringBuilder.append(string4);
            String string5 = exception.getMessage();
            stringBuilder.append(string5);
            string5 = stringBuilder.toString();
            TXCLog.e(string3, string5);
        }
    }
}

