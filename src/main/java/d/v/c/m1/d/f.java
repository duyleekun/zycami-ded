/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.view.KeyEvent
 */
package d.v.c.m1.d;

import android.content.DialogInterface;
import android.view.KeyEvent;
import d.v.c.m1.d.l;

public final class f
implements DialogInterface.OnKeyListener {
    public final /* synthetic */ l a;

    public /* synthetic */ f(l l10) {
        this.a = l10;
    }

    public final boolean onKey(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        return this.a.x(dialogInterface, n10, keyEvent);
    }
}

