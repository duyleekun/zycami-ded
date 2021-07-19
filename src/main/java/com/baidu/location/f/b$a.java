/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.telephony.TelephonyManager$CellInfoCallback
 */
package com.baidu.location.f;

import android.telephony.TelephonyManager;
import com.baidu.location.f.b;
import com.baidu.location.f.b$1;
import com.baidu.location.f.c;
import java.util.List;

public class b$a
extends TelephonyManager.CellInfoCallback {
    public final /* synthetic */ b a;

    private b$a(b b10) {
        this.a = b10;
    }

    public /* synthetic */ b$a(b b10, b$1 b$1) {
        this(b10);
    }

    public void onCellInfo(List list) {
        if (list == null) {
            return;
        }
        list = b.b(this.a);
        c c10 = new c(this);
        list.post(c10);
    }

    public void onError(int n10, Throwable throwable) {
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }
}

