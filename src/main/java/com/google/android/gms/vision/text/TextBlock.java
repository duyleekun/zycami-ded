/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.util.SparseArray
 */
package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzab;
import com.google.android.gms.internal.vision.zzah;
import com.google.android.gms.vision.text.Line;
import com.google.android.gms.vision.text.Text;
import com.google.android.gms.vision.text.zza;
import com.google.android.gms.vision.text.zzc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextBlock
implements Text {
    private Point[] cornerPoints;
    private zzah[] zzeh;
    private List zzei;
    private String zzej;
    private Rect zzek;

    public TextBlock(SparseArray sparseArray) {
        zzah[] zzahArray;
        int n10;
        zzah[] zzahArray2 = new zzah[sparseArray.size()];
        this.zzeh = zzahArray2;
        zzahArray2 = null;
        for (int i10 = 0; i10 < (n10 = (zzahArray = this.zzeh).length); ++i10) {
            zzah zzah2;
            zzahArray[i10] = zzah2 = (zzah)sparseArray.valueAt(i10);
        }
    }

    public Rect getBoundingBox() {
        Rect rect = this.zzek;
        if (rect == null) {
            this.zzek = rect = zzc.zza(this);
        }
        return this.zzek;
    }

    public List getComponents() {
        zzah[] object = this.zzeh;
        int n10 = object.length;
        if (n10 == 0) {
            ArrayList arrayList = new ArrayList(0);
            return arrayList;
        }
        List list = this.zzei;
        if (list == null) {
            ArrayList arrayList;
            zzah[] zzahArray = this.zzeh;
            int n11 = zzahArray.length;
            this.zzei = arrayList = new ArrayList(n11);
            for (zzah zzah2 : this.zzeh) {
                List list2 = this.zzei;
                Line line = new Line(zzah2);
                list2.add(line);
            }
        }
        return this.zzei;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Point[] getCornerPoints() {
        int n10;
        double d10;
        int n11;
        int n12;
        zzah[] zzahArray;
        int n13;
        zzah zzah2;
        int n14;
        int n15;
        Object object = this;
        Point[] pointArray = this.cornerPoints;
        if (pointArray == null) {
            pointArray = this.zzeh;
            n15 = pointArray.length;
            n14 = 0;
            zzah2 = null;
            if (n15 == 0) {
                pointArray = new Point[]{};
                this.cornerPoints = pointArray;
            }
        } else {
            pointArray = object;
            return pointArray.cornerPoints;
        }
        n15 = -1 << -1;
        int n16 = 0;
        float f10 = 0.0f;
        int n17 = n13 = -1 >>> 1;
        int n18 = n15;
        while (true) {
            Point point;
            zzahArray = ((TextBlock)object).zzeh;
            int n19 = zzahArray.length;
            n12 = 4;
            if (n16 >= n19) break;
            zzab zzab2 = zzahArray[n16].zzep;
            zzab zzab3 = zzahArray[0].zzep;
            int n20 = -zzab3.left;
            int n21 = -zzab3.top;
            float f11 = zzab3.zzen;
            double d11 = Math.sin(Math.toRadians(f11));
            float f12 = zzab3.zzen;
            n11 = n20;
            d10 = Math.cos(Math.toRadians(f12));
            Point[] pointArray2 = new Point[n12];
            n12 = zzab2.left;
            n10 = zzab2.top;
            pointArray2[0] = point = new Point(n12, n10);
            object = pointArray2[0];
            n12 = n20;
            object.offset(n20, n21);
            double d12 = (double)pointArray2[0].x * d10;
            n10 = pointArray2[0].y;
            n11 = n18;
            double d13 = (double)n10 * d11;
            n10 = (int)(d12 + d13);
            n14 = 0;
            d12 = (double)(-pointArray2[0].x) * d11;
            Point point2 = pointArray2[0];
            d11 = (double)point2.y * d10;
            n18 = (int)(d12 += d11);
            pointArray2[0].x = n10;
            Point point3 = pointArray2[0];
            point3.y = n18;
            int n22 = zzab2.width + n10;
            zzah2 = new Point(n22, n18);
            pointArray2[1] = zzah2;
            n22 = zzab2.width + n10;
            int n23 = zzab2.height + n18;
            zzah2 = new Point(n22, n23);
            n22 = 2;
            pointArray2[n22] = zzah2;
            n19 = zzab2.height;
            zzah2 = new Point(n10, n18 += n19);
            pointArray2[3] = zzah2;
            n18 = n11;
            object = null;
            for (n10 = 0; n10 < (n14 = 4); ++n10) {
                zzah2 = pointArray2[n10];
                n19 = ((Point)zzah2).x;
                n13 = Math.min(n13, n19);
                n19 = ((Point)zzah2).x;
                n15 = Math.max(n15, n19);
                n19 = ((Point)zzah2).y;
                n17 = Math.min(n17, n19);
                n14 = ((Point)zzah2).y;
                n18 = Math.max(n18, n14);
            }
            ++n16;
            n14 = 0;
            zzah2 = null;
            object = this;
        }
        n11 = n18;
        zzah2 = zzahArray[0];
        object = zzah2.zzep;
        n14 = ((zzab)object).left;
        n18 = ((zzab)object).top;
        f10 = ((zzab)object).zzen;
        double d14 = Math.sin(Math.toRadians(f10));
        double d15 = Math.cos(Math.toRadians(((zzab)object).zzen));
        Point[] pointArray3 = new Point[4];
        object = new Point(n13, n17);
        n12 = 0;
        pointArray3[0] = object;
        object = new Point(n15, n17);
        pointArray3[1] = object;
        n17 = n11;
        object = new Point(n15, n11);
        pointArray3[2] = object;
        object = new Point(n13, n11);
        n15 = 3;
        pointArray3[n15] = object;
        n10 = 4;
        while (true) {
            if (n12 >= n10) {
                pointArray = this;
                this.cornerPoints = pointArray3;
                return pointArray.cornerPoints;
            }
            double d16 = (double)pointArray3[n12].x * d15;
            d10 = (double)pointArray3[n12].y * d14;
            n15 = (int)(d16 - d10);
            Point point = pointArray3[n12];
            d16 = (double)point.x * d14;
            Point point4 = pointArray3[n12];
            int n24 = point4.y;
            d10 = (double)n24 * d15;
            n13 = (int)(d16 += d10);
            Point point5 = pointArray3[n12];
            point5.x = n15;
            pointArray3[n12].y = n13;
            pointArray = pointArray3[n12];
            pointArray.offset(n14, n18);
            ++n12;
        }
    }

    public String getLanguage() {
        boolean bl2;
        Object object = this.zzej;
        if (object != null) {
            return object;
        }
        object = new HashMap();
        for (zzah zzah2 : this.zzeh) {
            Object object2 = zzah2.zzej;
            int n10 = (int)(((HashMap)object).containsKey(object2) ? 1 : 0);
            if (n10 != 0) {
                object2 = zzah2.zzej;
                object2 = (Integer)((HashMap)object).get(object2);
                n10 = (Integer)object2;
            } else {
                n10 = 0;
                object2 = null;
            }
            String string2 = zzah2.zzej;
            object2 = ++n10;
            ((HashMap)object).put(string2, object2);
        }
        object = ((HashMap)object).entrySet();
        zza zza2 = new zza(this);
        this.zzej = object = (String)((Map.Entry)Collections.max(object, zza2)).getKey();
        if (object == null || (bl2 = ((String)object).isEmpty())) {
            this.zzej = object = "und";
        }
        return this.zzej;
    }

    public String getValue() {
        Object object = this.zzeh;
        int n10 = ((zzah[])object).length;
        if (n10 == 0) {
            return "";
        }
        int n11 = 0;
        Object object2 = null;
        object = object[0].zzes;
        StringBuilder stringBuilder = new StringBuilder((String)object);
        for (int i10 = 1; i10 < (n11 = ((zzah[])(object2 = this.zzeh)).length); ++i10) {
            stringBuilder.append("\n");
            object2 = this.zzeh[i10].zzes;
            stringBuilder.append((String)object2);
        }
        return stringBuilder.toString();
    }
}

