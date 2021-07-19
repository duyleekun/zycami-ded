/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.LocusId
 */
package androidx.core.content;

import android.content.LocusId;

public class LocusIdCompat$Api29Impl {
    private LocusIdCompat$Api29Impl() {
    }

    public static LocusId create(String string2) {
        LocusId locusId = new LocusId(string2);
        return locusId;
    }

    public static String getId(LocusId locusId) {
        return locusId.getId();
    }
}

