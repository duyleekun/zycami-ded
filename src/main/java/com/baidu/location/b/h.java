/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.Location
 */
package com.baidu.location.b;

import android.location.Location;
import com.baidu.location.b.g;

public class h
implements Runnable {
    public final /* synthetic */ Location a;
    public final /* synthetic */ g b;

    public h(g g10, Location location) {
        this.b = g10;
        this.a = location;
    }

    public void run() {
        g g10 = this.b;
        Location location = this.a;
        g.a(g10, location);
    }
}

