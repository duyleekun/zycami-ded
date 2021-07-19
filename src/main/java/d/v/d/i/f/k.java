/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Range
 */
package d.v.d.i.f;

import android.util.Range;
import d.v.d.h.f;
import d.v.d.i.a.a;

public class k
extends a {
    private Range[] h;

    public k() {
        Integer n10 = 30;
        this.a = n10;
        this.c = n10;
        n10 = 1;
        this.b = n10;
    }

    public Range[] n() {
        return this.h;
    }

    public void o(Range[] rangeArray) {
        String string2 = "set fps support range ";
        d.v.d.h.f.a(string2);
        int n10 = rangeArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = rangeArray[i10];
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "range =";
            stringBuilder.append(string3);
            object = object.toString();
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            d.v.d.h.f.a((String)object);
        }
        this.h = rangeArray;
    }
}

