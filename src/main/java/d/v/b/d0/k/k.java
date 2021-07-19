/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package d.v.b.d0.k;

import android.util.Size;
import d.v.b.c0.b;

public class k
extends b {
    public k() {
        Size size = new Size(1280, 720);
        this.a = size;
    }

    public int o() {
        return ((Size)this.a).getHeight();
    }

    public int p() {
        return ((Size)this.a).getWidth();
    }
}

