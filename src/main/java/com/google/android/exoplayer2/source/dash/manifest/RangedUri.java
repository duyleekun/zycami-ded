/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.util.UriUtil;

public final class RangedUri {
    private int hashCode;
    public final long length;
    private final String referenceUri;
    public final long start;

    public RangedUri(String string2, long l10, long l11) {
        if (string2 == null) {
            string2 = "";
        }
        this.referenceUri = string2;
        this.start = l10;
        this.length = l11;
    }

    public RangedUri attemptMerge(RangedUri rangedUri, String object) {
        Object object2;
        String string2 = this.resolveUriString((String)object);
        Object object3 = false;
        if (rangedUri != null && (object2 = string2.equals(object = rangedUri.resolveUriString((String)object)))) {
            long l10;
            long l11;
            long l12;
            long l13;
            long l14;
            long l15;
            long l16;
            long l17 = this.length;
            long l18 = -1;
            long l19 = l17 - l18;
            object2 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
            if (object2 && !(object2 = (l16 = (l15 = (l14 = this.start) + l17) - (l13 = rangedUri.start)) == 0L ? 0 : (l16 < 0L ? -1 : 1))) {
                l15 = rangedUri.length;
                long l20 = l15 - l18;
                Object object4 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                if (object4 != false) {
                    l18 = l17 += l15;
                }
                l17 = l14;
                object = new RangedUri(string2, l14, l18);
                return object;
            }
            l14 = rangedUri.length;
            long l21 = l14 - l18;
            object2 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
            if (object2 && (l12 = (l11 = (l15 = (l10 = rangedUri.start) + l14) - (l13 = this.start)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false) {
                object3 = l17 == l18 ? 0 : (l17 < l18 ? -1 : 1);
                if (object3) {
                    l18 = l14 += l17;
                }
                l17 = l10;
                RangedUri rangedUri2 = new RangedUri(string2, l10, l18);
                return rangedUri2;
            }
        }
        return null;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object2 = RangedUri.class) == (clazz = object.getClass())) {
            boolean bl3;
            long l10;
            object = (RangedUri)object;
            long l11 = this.start;
            long l12 = ((RangedUri)object).start;
            long l13 = l11 - l12;
            Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object3 != false || (object3 = (l10 = (l11 = this.length) - (l12 = ((RangedUri)object).length)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false || !(bl3 = ((String)(object2 = this.referenceUri)).equals(object = ((RangedUri)object).referenceUri))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.hashCode;
        if (n10 == 0) {
            int n11 = (int)this.start;
            n10 = (527 + n11) * 31;
            long l10 = this.length;
            n11 = (int)l10;
            n10 = (n10 + n11) * 31;
            String string2 = this.referenceUri;
            n11 = string2.hashCode();
            this.hashCode = n10 += n11;
        }
        return this.hashCode;
    }

    public Uri resolveUri(String string2) {
        String string3 = this.referenceUri;
        return UriUtil.resolveToUri(string2, string3);
    }

    public String resolveUriString(String string2) {
        String string3 = this.referenceUri;
        return UriUtil.resolve(string2, string3);
    }

    public String toString() {
        String string2 = this.referenceUri;
        long l10 = this.start;
        long l11 = this.length;
        int n10 = String.valueOf(string2).length() + 81;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("RangedUri(referenceUri=");
        stringBuilder.append(string2);
        stringBuilder.append(", start=");
        stringBuilder.append(l10);
        stringBuilder.append(", length=");
        stringBuilder.append(l11);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

