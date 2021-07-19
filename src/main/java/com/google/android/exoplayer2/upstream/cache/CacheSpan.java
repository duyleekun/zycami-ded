/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

import java.io.File;

public class CacheSpan
implements Comparable {
    public final File file;
    public final boolean isCached;
    public final String key;
    public final long lastTouchTimestamp;
    public final long length;
    public final long position;

    public CacheSpan(String string2, long l10, long l11) {
        this(string2, l10, l11, -9223372036854775807L, null);
    }

    public CacheSpan(String string2, long l10, long l11, long l12, File file) {
        boolean bl2;
        this.key = string2;
        this.position = l10;
        this.length = l11;
        if (file != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        this.isCached = bl2;
        this.file = file;
        this.lastTouchTimestamp = l12;
    }

    public int compareTo(CacheSpan object) {
        String string2 = this.key;
        String string3 = ((CacheSpan)object).key;
        boolean bl2 = string2.equals(string3);
        if (!bl2) {
            string2 = this.key;
            object = ((CacheSpan)object).key;
            return string2.compareTo((String)object);
        }
        long l10 = this.position;
        long l11 = ((CacheSpan)object).position;
        long l12 = (l10 -= l11) - (l11 = 0L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            object2 = 0;
            object = null;
        } else {
            object2 = object2 < 0 ? (Object)-1 : (Object)1;
        }
        return (int)object2;
    }

    public boolean isHoleSpan() {
        return this.isCached ^ true;
    }

    public boolean isOpenEnded() {
        long l10 = this.length;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public String toString() {
        long l10 = this.position;
        long l11 = this.length;
        StringBuilder stringBuilder = new StringBuilder(44);
        stringBuilder.append("[");
        stringBuilder.append(l10);
        stringBuilder.append(", ");
        stringBuilder.append(l11);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

