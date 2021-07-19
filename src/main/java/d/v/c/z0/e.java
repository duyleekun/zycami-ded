/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.view.KeyEvent
 */
package d.v.c.z0;

import android.content.DialogInterface;
import android.view.KeyEvent;
import d.v.c.z0.i;

public final class e
implements DialogInterface.OnKeyListener {
    public static final /* synthetic */ e a;

    static {
        e e10;
        a = e10 = new e();
    }

    public final boolean onKey(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        return i.C(dialogInterface, n10, keyEvent);
    }
}

