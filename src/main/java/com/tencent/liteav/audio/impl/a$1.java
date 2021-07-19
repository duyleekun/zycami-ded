/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.telephony.PhoneStateListener
 *  android.telephony.TelephonyManager
 */
package com.tencent.liteav.audio.impl;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.liteav.audio.impl.a;
import com.tencent.liteav.audio.impl.a$1$1;
import com.tencent.liteav.basic.log.TXCLog;

public class a$1
implements Runnable {
    public final /* synthetic */ a a;

    public a$1(a a10) {
        this.a = a10;
    }

    public void run() {
        Object object = com.tencent.liteav.audio.impl.a.a(this.a);
        if (object != null) {
            return;
        }
        object = this.a;
        Object object2 = new a$1$1(this);
        com.tencent.liteav.audio.impl.a.a((a)object, object2);
        object = this.a;
        object = com.tencent.liteav.audio.impl.a.b((a)object);
        object2 = "phone";
        object = object.getSystemService((String)object2);
        object = (TelephonyManager)object;
        object2 = this.a;
        object2 = com.tencent.liteav.audio.impl.a.a((a)object2);
        int n10 = 32;
        try {
            object.listen((PhoneStateListener)object2, n10);
        }
        catch (Exception exception) {
            object2 = "AudioCenter:TXCTelephonyMgr";
            String string2 = "TelephonyManager listen error ";
            TXCLog.e((String)object2, string2, exception);
        }
    }
}

