/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.a;

import android.content.Context;
import android.view.View;
import d.v.a.c;

public final class a
implements View.OnClickListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ a(Context context, String string2, String string3) {
        this.a = context;
        this.b = string2;
        this.c = string3;
    }

    public final void onClick(View view) {
        Context context = this.a;
        String string2 = this.b;
        String string3 = this.c;
        d.v.a.c.g(context, string2, string3, view);
    }
}

