/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 */
package d.v.e.l;

import android.app.Activity;
import android.view.View;
import d.v.e.l.m2$c;
import d.v.e.l.v1;

public final class a
implements m2$c {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ View b;

    public /* synthetic */ a(Activity activity, View view) {
        this.a = activity;
        this.b = view;
    }

    public final void onComplete() {
        Activity activity = this.a;
        View view = this.b;
        v1.g(activity, view);
    }
}

