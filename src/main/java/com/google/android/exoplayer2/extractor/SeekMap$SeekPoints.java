/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Assertions;

public final class SeekMap$SeekPoints {
    public final SeekPoint first;
    public final SeekPoint second;

    public SeekMap$SeekPoints(SeekPoint seekPoint) {
        this(seekPoint, seekPoint);
    }

    public SeekMap$SeekPoints(SeekPoint seekPoint, SeekPoint seekPoint2) {
        this.first = seekPoint = (SeekPoint)Assertions.checkNotNull(seekPoint);
        this.second = seekPoint = (SeekPoint)Assertions.checkNotNull(seekPoint2);
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = SeekMap$SeekPoints.class) == (object2 = object.getClass())) {
            boolean bl3;
            object = (SeekMap$SeekPoints)object;
            object3 = this.first;
            object2 = ((SeekMap$SeekPoints)object).first;
            boolean bl4 = ((SeekPoint)object3).equals(object2);
            if (!bl4 || !(bl3 = ((SeekPoint)(object3 = this.second)).equals(object = ((SeekMap$SeekPoints)object).second))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.first.hashCode() * 31;
        int n11 = this.second.hashCode();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder;
        int n10;
        String string2 = String.valueOf(this.first);
        Object object = this.first;
        Object object2 = this.second;
        boolean bl2 = ((SeekPoint)object).equals(object2);
        if (bl2) {
            object = "";
        } else {
            object = String.valueOf(this.second);
            n10 = String.valueOf(object).length() + 2;
            stringBuilder = new StringBuilder(n10);
            object2 = ", ";
            stringBuilder.append((String)object2);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
        }
        n10 = String.valueOf(string2).length() + 2;
        int n11 = String.valueOf(object).length();
        stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append("[");
        stringBuilder.append(string2);
        stringBuilder.append((String)object);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

