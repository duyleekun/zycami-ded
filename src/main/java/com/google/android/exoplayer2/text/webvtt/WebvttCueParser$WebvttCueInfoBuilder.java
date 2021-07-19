/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Layout$Alignment
 */
package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Cue$Builder;
import com.google.android.exoplayer2.text.webvtt.WebvttCueInfo;
import com.google.android.exoplayer2.util.Log;

public final class WebvttCueParser$WebvttCueInfoBuilder {
    public long endTimeUs;
    public float line;
    public int lineAnchor;
    public int lineType;
    public float position;
    public int positionAnchor;
    public float size;
    public long startTimeUs;
    public CharSequence text;
    public int textAlignment;
    public int verticalType;

    public WebvttCueParser$WebvttCueInfoBuilder() {
        int n10;
        float f10;
        long l10;
        this.startTimeUs = l10 = 0L;
        this.endTimeUs = l10;
        this.textAlignment = 2;
        this.line = f10 = -3.4028235E38f;
        this.lineType = 1;
        this.lineAnchor = 0;
        this.position = f10;
        this.positionAnchor = n10 = -1 << -1;
        this.size = 1.0f;
        this.verticalType = n10;
    }

    private static float computeLine(float f10, int n10) {
        float f11;
        float f12;
        float f13 = -3.4028235E38f;
        float f14 = f10 == f13 ? 0 : (f10 > f13 ? 1 : -1);
        float f15 = 1.0f;
        if (f14 != false && n10 == 0 && ((f12 = (f11 = f10 - 0.0f) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) < 0 || (f12 = f10 == f15 ? 0 : (f10 > f15 ? 1 : -1)) > 0)) {
            return f15;
        }
        if (f14 != false) {
            return f10;
        }
        if (n10 == 0) {
            return f15;
        }
        return f13;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static Layout.Alignment convertTextAlignment(int n10) {
        int n11 = 1;
        if (n10 == n11) return Layout.Alignment.ALIGN_NORMAL;
        n11 = 2;
        if (n10 == n11) return Layout.Alignment.ALIGN_CENTER;
        n11 = 3;
        if (n10 == n11) return Layout.Alignment.ALIGN_OPPOSITE;
        n11 = 4;
        if (n10 == n11) return Layout.Alignment.ALIGN_NORMAL;
        n11 = 5;
        if (n10 == n11) return Layout.Alignment.ALIGN_OPPOSITE;
        StringBuilder stringBuilder = new StringBuilder(34);
        stringBuilder.append("Unknown textAlignment: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        Log.w("WebvttCueParser", string2);
        return null;
    }

    private static float deriveMaxSize(int n10, float f10) {
        int n11 = 1065353216;
        float f11 = 1.0f;
        if (n10 != 0) {
            int n12 = 1;
            float f12 = Float.MIN_VALUE;
            if (n10 != n12) {
                n11 = 2;
                f11 = 2.8E-45f;
                if (n10 == n11) {
                    return f10;
                }
                String string2 = String.valueOf(n10);
                IllegalStateException illegalStateException = new IllegalStateException(string2);
                throw illegalStateException;
            }
            float f13 = 0.5f;
            n10 = (int)(f10 == f13 ? 0 : (f10 < f13 ? -1 : 1));
            n12 = 0x40000000;
            f12 = 2.0f;
            if (n10 <= 0) {
                return f10 * f12;
            }
            return (f11 - f10) * f12;
        }
        return f11 - f10;
    }

    private static float derivePosition(int n10) {
        int n11 = 4;
        if (n10 != n11) {
            n11 = 5;
            if (n10 != n11) {
                return 0.5f;
            }
            return 1.0f;
        }
        return 0.0f;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int derivePositionAnchor(int n10) {
        int n11 = 1;
        if (n10 == n11) return 0;
        int n12 = 3;
        if (n10 == n12) return 2;
        n12 = 4;
        if (n10 == n12) return 0;
        n12 = 5;
        if (n10 == n12) return 2;
        return n11;
    }

    public WebvttCueInfo build() {
        Cue cue = this.toCueBuilder().build();
        long l10 = this.startTimeUs;
        long l11 = this.endTimeUs;
        WebvttCueInfo webvttCueInfo = new WebvttCueInfo(cue, l10, l11);
        return webvttCueInfo;
    }

    public Cue$Builder toCueBuilder() {
        float f10 = this.position;
        float f11 = -3.4028235E38f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            int n10 = this.textAlignment;
            f10 = WebvttCueParser$WebvttCueInfoBuilder.derivePosition(n10);
        }
        object = this.positionAnchor;
        int n11 = -1 << -1;
        if (object == n11) {
            object = WebvttCueParser$WebvttCueInfoBuilder.derivePositionAnchor(this.textAlignment);
        }
        Cue$Builder cue$Builder = new Cue$Builder();
        Layout.Alignment alignment = WebvttCueParser$WebvttCueInfoBuilder.convertTextAlignment(this.textAlignment);
        cue$Builder = cue$Builder.setTextAlignment(alignment);
        float f13 = this.line;
        int n12 = this.lineType;
        f13 = WebvttCueParser$WebvttCueInfoBuilder.computeLine(f13, n12);
        n12 = this.lineType;
        cue$Builder = cue$Builder.setLine(f13, n12);
        int n13 = this.lineAnchor;
        cue$Builder = cue$Builder.setLineAnchor(n13).setPosition(f10).setPositionAnchor((int)object);
        f13 = this.size;
        f10 = WebvttCueParser$WebvttCueInfoBuilder.deriveMaxSize((int)object, f10);
        f10 = Math.min(f13, f10);
        Cue$Builder cue$Builder2 = cue$Builder.setSize(f10);
        object = this.verticalType;
        cue$Builder2 = cue$Builder2.setVerticalType((int)object);
        CharSequence charSequence = this.text;
        if (charSequence != null) {
            cue$Builder2.setText(charSequence);
        }
        return cue$Builder2;
    }
}

