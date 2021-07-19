/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.p0.o;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import d.v.c.p0.o.f;

public final class d
implements View.OnClickListener {
    public final /* synthetic */ FragmentActivity a;

    public /* synthetic */ d(FragmentActivity fragmentActivity) {
        this.a = fragmentActivity;
    }

    public final void onClick(View view) {
        f.a(this.a, view);
    }
}

