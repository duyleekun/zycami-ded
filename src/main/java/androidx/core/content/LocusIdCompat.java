/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.LocusId
 *  android.os.Build$VERSION
 */
package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.core.content.LocusIdCompat$Api29Impl;
import androidx.core.util.Preconditions;

public final class LocusIdCompat {
    private final String mId;
    private final LocusId mWrapped;

    public LocusIdCompat(String string2) {
        String string3;
        this.mId = string3 = (String)Preconditions.checkStringNotEmpty(string2, "id cannot be empty");
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            string2 = LocusIdCompat$Api29Impl.create(string2);
            this.mWrapped = string2;
        } else {
            string2 = null;
            this.mWrapped = null;
        }
    }

    private String getSanitizedId() {
        int n10 = this.mId.length();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n10);
        stringBuilder.append("_chars");
        return stringBuilder.toString();
    }

    public static LocusIdCompat toLocusIdCompat(LocusId object) {
        Preconditions.checkNotNull(object, "locusId cannot be null");
        object = (String)Preconditions.checkStringNotEmpty(LocusIdCompat$Api29Impl.getId(object), "id cannot be empty");
        LocusIdCompat locusIdCompat = new LocusIdCompat((String)object);
        return locusIdCompat;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object == null) {
            return false;
        }
        Object object2 = LocusIdCompat.class;
        Class<?> clazz = object.getClass();
        if (object2 != clazz) {
            return false;
        }
        object = (LocusIdCompat)object;
        object2 = this.mId;
        if (object2 == null) {
            object = ((LocusIdCompat)object).mId;
            if (object != null) {
                bl2 = false;
            }
            return bl2;
        }
        object = ((LocusIdCompat)object).mId;
        return ((String)object2).equals(object);
    }

    public String getId() {
        return this.mId;
    }

    public int hashCode() {
        int n10;
        String string2 = this.mId;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        return 31 + n10;
    }

    public LocusId toLocusId() {
        return this.mWrapped;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LocusIdCompat[");
        String string2 = this.getSanitizedId();
        stringBuilder.append(string2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

