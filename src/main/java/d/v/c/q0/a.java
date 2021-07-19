/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.Window
 */
package d.v.c.q0;

import android.os.Bundle;
import android.view.Window;
import d.v.f.c.e;

public abstract class a
extends e {
    public void onCreate(Bundle bundle) {
        Window window = this.getWindow();
        int n10 = 1024;
        window.setFlags(n10, n10);
        super.onCreate(bundle);
    }
}

