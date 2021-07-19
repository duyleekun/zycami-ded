/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.view.KeyEvent
 */
package d.v.c.i1;

import android.content.DialogInterface;
import android.view.KeyEvent;
import d.v.c.i1.l2;

public final class k1
implements DialogInterface.OnKeyListener {
    public static final /* synthetic */ k1 a;

    static {
        k1 k12;
        a = k12 = new k1();
    }

    public final boolean onKey(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        return l2.x(dialogInterface, n10, keyEvent);
    }
}

