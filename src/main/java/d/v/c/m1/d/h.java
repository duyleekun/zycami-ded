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
import d.v.c.m1.d.p;

public final class h
implements DialogInterface.OnKeyListener {
    public final /* synthetic */ p a;

    public /* synthetic */ h(p p10) {
        this.a = p10;
    }

    public final boolean onKey(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        return this.a.F(dialogInterface, n10, keyEvent);
    }
}

