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
import com.google.android.gms.internal.vision.zzah;
import com.google.android.gms.internal.vision.zzao;
import com.google.android.gms.vision.text.Element;
import com.google.android.gms.vision.text.Text;
import com.google.android.gms.vision.text.zzc;
import java.util.ArrayList;
import java.util.List;

public class Line
implements Text {
    private zzah zzef;
    private List zzeg;

    public Line(zzah zzah2) {
        this.zzef = zzah2;
    }

    public float getAngle() {
        return this.zzef.zzep.zzen;
    }

    public Rect getBoundingBox() {
        return zzc.zza(this);
    }

    public List getComponents() {
        zzao[] object = this.zzef.zzeo;
        int n10 = object.length;
        if (n10 == 0) {
            ArrayList arrayList = new ArrayList(0);
            return arrayList;
        }
        List list = this.zzeg;
        if (list == null) {
            ArrayList arrayList;
            zzao[] zzaoArray = this.zzef.zzeo;
            int n11 = zzaoArray.length;
            this.zzeg = arrayList = new ArrayList(n11);
            for (zzao zzao2 : this.zzef.zzeo) {
                List list2 = this.zzeg;
                Element element = new Element(zzao2);
                list2.add(element);
            }
        }
        return this.zzeg;
    }

    public Point[] getCornerPoints() {
        return zzc.zza(this.zzef.zzep);
    }

    public String getLanguage() {
        return this.zzef.zzej;
    }

    public String getValue() {
        return this.zzef.zzes;
    }

    public boolean isVertical() {
        return this.zzef.zzeu;
    }
}

