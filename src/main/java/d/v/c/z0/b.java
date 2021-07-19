/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.z0;

import android.app.Activity;
import android.view.View;
import d.v.c.z0.h;

public final class b
implements View.OnClickListener {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ b(Activity activity, String string2, String string3) {
        this.a = activity;
        this.b = string2;
        this.c = string3;
    }

    public final void onClick(View view) {
        Activity activity = this.a;
        String string2 = this.b;
        String string3 = this.c;
        h.x(activity, string2, string3, view);
    }
}

