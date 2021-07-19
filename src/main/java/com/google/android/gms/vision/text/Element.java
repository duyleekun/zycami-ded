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
import com.google.android.gms.internal.vision.zzao;
import com.google.android.gms.vision.text.Text;
import com.google.android.gms.vision.text.zzc;
import java.util.ArrayList;
import java.util.List;

public class Element
implements Text {
    private zzao zzee;

    public Element(zzao zzao2) {
        this.zzee = zzao2;
    }

    public Rect getBoundingBox() {
        return zzc.zza(this);
    }

    public List getComponents() {
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

    public Point[] getCornerPoints() {
        return zzc.zza(this.zzee.zzep);
    }

    public String getLanguage() {
        return this.zzee.zzej;
    }

    public String getValue() {
        return this.zzee.zzes;
    }
}

