/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.tencent.liteav;

import android.os.Bundle;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.f;
import java.lang.ref.WeakReference;

public class f$5
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Bundle b;
    public final /* synthetic */ f c;

    public f$5(f f10, int n10, Bundle bundle) {
        this.c = f10;
        this.a = n10;
        this.b = bundle;
    }

    public void run() {
        WeakReference weakReference = this.c.e;
        int n10 = this.a;
        Bundle bundle = this.b;
        g.a(weakReference, n10, bundle);
    }
}

