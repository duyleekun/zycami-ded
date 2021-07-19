/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.webkit.ValueCallback
 */
package d.v.c.i1.t2;

import android.webkit.ValueCallback;
import d.v.c.i1.t2.f0;

public final class b
implements ValueCallback {
    public final /* synthetic */ f0 a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(f0 f02, String string2) {
        this.a = f02;
        this.b = string2;
    }

    public final void onReceiveValue(Object object) {
        f0 f02 = this.a;
        String string2 = this.b;
        object = (String)object;
        f02.x(string2, (String)object);
    }
}

