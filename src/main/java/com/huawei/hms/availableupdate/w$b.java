/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.view.KeyEvent
 */
package com.huawei.hms.availableupdate;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.huawei.hms.availableupdate.w$a;

public class w$b
implements DialogInterface.OnKeyListener {
    public w$b() {
    }

    public /* synthetic */ w$b(w$a w$a) {
        this();
    }

    public boolean onKey(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        int n11 = 4;
        n11 = n10 == n11 && (n11 = keyEvent.getRepeatCount()) == 0 ? 1 : 0;
        return n11 != 0;
    }
}

