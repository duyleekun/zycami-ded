/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioManager
 */
package d.v.d.i.g;

import android.content.Context;
import android.media.AudioManager;
import d.v.d.h.f;
import d.v.d.i.a.a;

public class g
extends a {
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 3;
    private final AudioManager h;

    public g(Context context) {
        Integer n10 = 1;
        this.a = n10;
        context = (AudioManager)context.getSystemService("audio");
        this.h = context;
    }

    public Integer n() {
        int n10 = 3;
        Integer n11 = (Integer)this.a;
        int n12 = n11;
        n12 = n10 == n12 ? 5 : 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecordMic get value=");
        stringBuilder.append(n12);
        stringBuilder.append(",mT=");
        Object object = this.a;
        stringBuilder.append(object);
        d.v.d.h.f.a(stringBuilder.toString());
        return n12;
    }

    public void o(Integer n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecordMic set integer=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        super.set(n10);
    }
}

