/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.OrientationEventListener
 */
package d.v.b.e0;

import android.content.Context;
import android.view.OrientationEventListener;
import d.v.b.e0.b;

public class b$a
extends OrientationEventListener {
    public final /* synthetic */ b a;

    public b$a(b b10, Context context) {
        this.a = b10;
        super(context);
    }

    public void onOrientationChanged(int n10) {
        b.f(this.a, n10);
    }
}

