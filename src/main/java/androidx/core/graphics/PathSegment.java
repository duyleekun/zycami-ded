/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package androidx.core.graphics;

import android.graphics.PointF;
import androidx.core.util.Preconditions;

public final class PathSegment {
    private final PointF mEnd;
    private final float mEndFraction;
    private final PointF mStart;
    private final float mStartFraction;

    public PathSegment(PointF pointF, float f10, PointF pointF2, float f11) {
        this.mStart = pointF = (PointF)Preconditions.checkNotNull(pointF, "start == null");
        this.mStartFraction = f10;
        this.mEnd = pointF = (PointF)Preconditions.checkNotNull(pointF2, "end == null");
        this.mEndFraction = f11;
    }

    public boolean equals(Object object) {
        boolean bl2;
        PointF pointF;
        PointF pointF2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        int n10 = object instanceof PathSegment;
        if (n10 == 0) {
            return false;
        }
        object = (PathSegment)object;
        float f10 = this.mStartFraction;
        float f11 = ((PathSegment)object).mStartFraction;
        n10 = Float.compare(f10, f11);
        if (n10 != 0 || (n10 = Float.compare(f10 = this.mEndFraction, f11 = ((PathSegment)object).mEndFraction)) != 0 || (n10 = (int)((pointF2 = this.mStart).equals((Object)(pointF = ((PathSegment)object).mStart)) ? 1 : 0)) == 0 || !(bl2 = (pointF2 = this.mEnd).equals(object = ((PathSegment)object).mEnd))) {
            bl3 = false;
        }
        return bl3;
    }

    public PointF getEnd() {
        return this.mEnd;
    }

    public float getEndFraction() {
        return this.mEndFraction;
    }

    public PointF getStart() {
        return this.mStart;
    }

    public float getStartFraction() {
        return this.mStartFraction;
    }

    public int hashCode() {
        PointF pointF;
        int n10;
        PointF pointF2 = this.mStart;
        int n11 = pointF2.hashCode() * 31;
        float f10 = this.mStartFraction;
        boolean bl2 = false;
        float f11 = f10 - 0.0f;
        float f12 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        int n12 = 0;
        if (f12 != false) {
            n10 = Float.floatToIntBits(f10);
        } else {
            n10 = 0;
            pointF = null;
            f10 = 0.0f;
        }
        n11 = (n11 + n10) * 31;
        pointF = this.mEnd;
        n10 = pointF.hashCode();
        n11 = (n11 + n10) * 31;
        f10 = this.mEndFraction;
        float f13 = f10 - 0.0f;
        bl2 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (bl2) {
            n12 = Float.floatToIntBits(f10);
        }
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PathSegment{start=");
        PointF pointF = this.mStart;
        stringBuilder.append(pointF);
        stringBuilder.append(", startFraction=");
        float f10 = this.mStartFraction;
        stringBuilder.append(f10);
        stringBuilder.append(", end=");
        pointF = this.mEnd;
        stringBuilder.append(pointF);
        stringBuilder.append(", endFraction=");
        f10 = this.mEndFraction;
        stringBuilder.append(f10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

