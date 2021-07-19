/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 */
package i.f.b;

import android.app.Activity;
import android.content.DialogInterface;
import i.f.b.e;

public class e$a
implements DialogInterface.OnClickListener {
    public final /* synthetic */ e a;

    public e$a(e e10) {
        this.a = e10;
    }

    public void onClick(DialogInterface dialogInterface, int n10) {
        dialogInterface.dismiss();
        ((Activity)this.a.getContext()).finish();
    }
}

