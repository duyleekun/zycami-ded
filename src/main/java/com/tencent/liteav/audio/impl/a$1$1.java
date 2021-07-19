/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.telephony.PhoneStateListener
 */
package com.tencent.liteav.audio.impl;

import android.telephony.PhoneStateListener;
import com.tencent.liteav.audio.impl.a;
import com.tencent.liteav.audio.impl.a$1;
import com.tencent.liteav.basic.log.TXCLog;

public class a$1$1
extends PhoneStateListener {
    public final /* synthetic */ a$1 a;

    public a$1$1(a$1 var1_1) {
        this.a = var1_1;
    }

    public void onCallStateChanged(int n10, String charSequence) {
        super.onCallStateChanged(n10, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("onCallStateChanged:");
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        TXCLog.i("AudioCenter:TXCTelephonyMgr", (String)charSequence);
        com.tencent.liteav.audio.impl.a.a(this.a.a, n10);
    }
}

