/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.vision.text;

import com.google.android.gms.vision.text.TextBlock;
import java.util.Comparator;
import java.util.Map;

public final class zza
implements Comparator {
    public zza(TextBlock textBlock) {
    }

    public final /* synthetic */ int compare(Object object, Object object2) {
        object = (Map.Entry)object;
        object2 = (Map.Entry)object2;
        object = (Integer)object.getValue();
        object2 = (Integer)object2.getValue();
        return ((Integer)object).compareTo((Integer)object2);
    }
}

