/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.OnNmeaMessageListener
 */
package com.baidu.location.f;

import android.location.OnNmeaMessageListener;
import com.baidu.location.f.f;

public class g
implements OnNmeaMessageListener {
    public final /* synthetic */ f a;

    public g(f f10) {
        this.a = f10;
    }

    public void onNmeaMessage(String string2, long l10) {
        f.a(this.a, string2);
    }
}

