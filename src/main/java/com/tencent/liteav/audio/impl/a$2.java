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
import com.tencent.liteav.basic.log.TXCLog;

public class a$2
implements Runnable {
    public final /* synthetic */ a a;

    public a$2(a a10) {
        this.a = a10;
    }

    public void run() {
        Object object = com.tencent.liteav.audio.impl.a.a(this.a);
        if (object != null && (object = com.tencent.liteav.audio.impl.a.b(this.a)) != null) {
            object = this.a;
            object = com.tencent.liteav.audio.impl.a.b((a)object);
            object = object.getApplicationContext();
            Object object2 = "phone";
            object = object.getSystemService((String)object2);
            object = (TelephonyManager)object;
            object2 = this.a;
            object2 = com.tencent.liteav.audio.impl.a.a((a)object2);
            String string2 = null;
            try {
                object.listen((PhoneStateListener)object2, 0);
            }
            catch (Exception exception) {
                object2 = "AudioCenter:TXCTelephonyMgr";
                string2 = "TelephonyManager listen error ";
                TXCLog.e((String)object2, string2, exception);
            }
        }
        com.tencent.liteav.audio.impl.a.a(this.a, null);
    }
}

