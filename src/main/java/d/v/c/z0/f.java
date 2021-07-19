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
import d.v.c.z0.j;

public final class f
implements DialogInterface.OnKeyListener {
    public final /* synthetic */ j a;

    public /* synthetic */ f(j j10) {
        this.a = j10;
    }

    public final boolean onKey(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        return this.a.x(dialogInterface, n10, keyEvent);
    }
}

