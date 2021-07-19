/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.view.KeyEvent
 */
package com.huawei.hms.ui;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.huawei.hms.ui.AbstractDialog;

public class AbstractDialog$d
implements DialogInterface.OnKeyListener {
    public final /* synthetic */ AbstractDialog a;

    public AbstractDialog$d(AbstractDialog abstractDialog) {
        this.a = abstractDialog;
    }

    public boolean onKey(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        int n11 = 4;
        if (n11 == n10 && (n11 = keyEvent.getAction()) == (n10 = 1)) {
            this.a.cancel();
            return n10 != 0;
        }
        return false;
    }
}

