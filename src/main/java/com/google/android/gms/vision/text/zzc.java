/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.graphics.Rect
 */
package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzab;
import com.google.android.gms.vision.text.Text;

public final class zzc {
    public static Rect zza(Text rect) {
        rect = rect.getCornerPoints();
        int n10 = ((Point[])rect).length;
        int n11 = -1 << -1;
        int n12 = -1 >>> 1;
        int n13 = n11;
        int n14 = n12;
        for (int i10 = 0; i10 < n10; ++i10) {
            Rect rect2 = rect[i10];
            int n15 = rect2.x;
            n14 = Math.min(n14, n15);
            n15 = rect2.x;
            n11 = Math.max(n11, n15);
            n15 = rect2.y;
            n12 = Math.min(n12, n15);
            int n16 = rect2.y;
            n13 = Math.max(n13, n16);
        }
        rect = new Rect(n14, n12, n11, n13);
        return rect;
    }

    public static Point[] zza(zzab zzab2) {
        Point point;
        Point point2;
        Point[] pointArray = new Point[4];
        double d10 = Math.sin(Math.toRadians(zzab2.zzen));
        double d11 = Math.cos(Math.toRadians(zzab2.zzen));
        int n10 = zzab2.left;
        int n11 = zzab2.top;
        pointArray[0] = point2 = new Point(n10, n11);
        double d12 = zzab2.left;
        int n12 = zzab2.width;
        double d13 = (double)n12 * d11;
        n11 = (int)(d12 + d13);
        d13 = zzab2.top;
        double d14 = (double)n12 * d10;
        int n13 = (int)(d13 + d14);
        point2 = new Point(n11, n13);
        n11 = 1;
        pointArray[n11] = point2;
        d14 = pointArray[n11].x;
        int n14 = zzab2.height;
        d13 = (double)n14 * d10;
        int n15 = (int)(d14 - d13);
        d14 = pointArray[n11].y;
        d13 = (double)n14 * d11;
        n14 = (int)(d14 + d13);
        point2 = new Point(n15, n14);
        n14 = 2;
        pointArray[n14] = point2;
        int n16 = pointArray[0].x;
        int n17 = pointArray[n14].x;
        int n18 = pointArray[n11].x;
        n16 += (n17 -= n18);
        n17 = pointArray[0].y;
        n14 = pointArray[n14].y;
        n18 = pointArray[n11].y;
        pointArray[3] = point = new Point(n16, n17 += (n14 -= n18));
        return pointArray;
    }
}

