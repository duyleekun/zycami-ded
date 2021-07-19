/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.CamcorderProfile
 *  android.util.Size
 */
package d.v.d.i.g;

import android.media.CamcorderProfile;
import android.util.Size;
import d.v.d.h.f;
import d.v.d.i.a.a;
import d.v.d.i.g.k;

public class d
extends a {
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;

    public d() {
        Integer n10 = 1;
        this.a = n10;
    }

    private int o(Size size, int n10) {
        boolean bl2;
        int n11 = size.getWidth();
        int n12 = size.getHeight();
        double d10 = n11 * n12 * 30;
        double d11 = 0.2;
        n11 = (int)(d10 *= d11);
        Size size2 = k.r.a;
        n12 = (int)(size.equals((Object)size2) ? 1 : 0);
        if (n12 != 0 && (bl2 = CamcorderProfile.hasProfile((int)n10, (int)(n12 = 5)))) {
            return CamcorderProfile.get((int)n10, (int)n12).videoBitRate;
        }
        size2 = k.s.a;
        n12 = (int)(size.equals((Object)size2) ? 1 : 0);
        if (n12 != 0 && (bl2 = CamcorderProfile.hasProfile((int)n10, (int)(n12 = 6)))) {
            return CamcorderProfile.get((int)n10, (int)n12).videoBitRate;
        }
        size2 = k.t.a;
        int n13 = size.equals((Object)size2);
        if (n13 != 0 && (n12 = (int)(CamcorderProfile.hasProfile((int)n10, (int)(n13 = 8)) ? 1 : 0)) != 0) {
            return CamcorderProfile.get((int)n10, (int)n13).videoBitRate;
        }
        return n11;
    }

    public int n(Size size, int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get BitRate size=");
        stringBuilder.append(size);
        stringBuilder.append(",cameraId=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        return this.o(size, n10);
    }

    public CamcorderProfile p(Size size, int n10) {
        Size size2 = k.r.a;
        boolean bl2 = size.equals((Object)size2);
        int n11 = 2003;
        if (bl2) {
            return CamcorderProfile.get((int)n10, (int)n11);
        }
        size2 = k.s.a;
        bl2 = size.equals((Object)size2);
        if (bl2) {
            return CamcorderProfile.get((int)n10, (int)2004);
        }
        size2 = k.t.a;
        boolean bl3 = size.equals((Object)size2);
        if (bl3) {
            return CamcorderProfile.get((int)n10, (int)2005);
        }
        return CamcorderProfile.get((int)n10, (int)n11);
    }

    public int q(int n10, Size size) {
        boolean bl2;
        int n11 = size.getWidth();
        int n12 = size.getHeight();
        double d10 = n11 * n12 * 30;
        double d11 = 0.2;
        n11 = (int)(d10 *= d11);
        Size size2 = k.r.a;
        n12 = (int)(size.equals((Object)size2) ? 1 : 0);
        if (n12 != 0 && (bl2 = CamcorderProfile.hasProfile((int)n10, (int)(n12 = 1005)))) {
            return CamcorderProfile.get((int)n10, (int)n12).videoBitRate;
        }
        size2 = k.s.a;
        n12 = (int)(size.equals((Object)size2) ? 1 : 0);
        if (n12 != 0 && (bl2 = CamcorderProfile.hasProfile((int)n10, (int)(n12 = 1006)))) {
            return CamcorderProfile.get((int)n10, (int)n12).videoBitRate;
        }
        size2 = k.t.a;
        int n13 = size.equals((Object)size2);
        if (n13 != 0 && (n12 = (int)(CamcorderProfile.hasProfile((int)n10, (int)(n13 = 1008)) ? 1 : 0)) != 0) {
            return CamcorderProfile.get((int)n10, (int)n13).videoBitRate;
        }
        return n11;
    }
}

