/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera$Size
 */
package com.tencent.liteav.capturer;

import android.hardware.Camera;
import java.util.Comparator;

public final class a$1
implements Comparator {
    public int a(Camera.Size size, Camera.Size size2) {
        int n10 = size2.width;
        int n11 = size2.height;
        n10 *= n11;
        n11 = size.width;
        int n12 = size.height;
        return n10 - (n11 *= n12);
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        object = (Camera.Size)object;
        object2 = (Camera.Size)object2;
        return this.a((Camera.Size)object, (Camera.Size)object2);
    }
}

