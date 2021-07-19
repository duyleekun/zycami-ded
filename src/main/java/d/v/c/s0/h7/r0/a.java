/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 */
package d.v.c.s0.h7.r0;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import d.v.c.s0.h7.r0.q;

public final class a
implements Observer {
    public final /* synthetic */ q a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Bundle c;

    public /* synthetic */ a(q q10, View view, Bundle bundle) {
        this.a = q10;
        this.b = view;
        this.c = bundle;
    }

    public final void onChanged(Object object) {
        q q10 = this.a;
        View view = this.b;
        Bundle bundle = this.c;
        object = (Boolean)object;
        q10.G(view, bundle, (Boolean)object);
    }
}

