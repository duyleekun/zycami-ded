/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 */
package i.f.b;

import android.content.DialogInterface;
import i.f.b.b;
import i.f.b.j;

public class b$g
implements DialogInterface.OnClickListener {
    public final /* synthetic */ j a;
    public final /* synthetic */ b b;

    public b$g(b b10, j j10) {
        this.b = b10;
        this.a = j10;
    }

    public void onClick(DialogInterface dialogInterface, int n10) {
        this.a.cancel();
    }
}

