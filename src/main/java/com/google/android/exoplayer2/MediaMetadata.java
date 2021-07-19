/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.MediaMetadata$1;
import com.google.android.exoplayer2.util.Util;

public final class MediaMetadata {
    public final String title;

    private MediaMetadata(String string2) {
        this.title = string2;
    }

    public /* synthetic */ MediaMetadata(String string2, MediaMetadata$1 mediaMetadata$1) {
        this(string2);
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        if (this == object) {
            return true;
        }
        if (object != null && (object2 = MediaMetadata.class) == (clazz = object.getClass())) {
            object = (MediaMetadata)object;
            object2 = this.title;
            object = ((MediaMetadata)object).title;
            return Util.areEqual(object2, object);
        }
        return false;
    }

    public int hashCode() {
        int n10;
        String string2 = this.title;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        return n10;
    }
}

