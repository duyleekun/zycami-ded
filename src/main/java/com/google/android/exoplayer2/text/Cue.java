/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.text.Layout$Alignment
 */
package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout;
import com.google.android.exoplayer2.text.Cue$1;
import com.google.android.exoplayer2.text.Cue$Builder;
import com.google.android.exoplayer2.util.Assertions;

public final class Cue {
    public static final int ANCHOR_TYPE_END = 2;
    public static final int ANCHOR_TYPE_MIDDLE = 1;
    public static final int ANCHOR_TYPE_START = 0;
    public static final float DIMEN_UNSET = -3.4028235E38f;
    public static final Cue EMPTY;
    public static final int LINE_TYPE_FRACTION = 0;
    public static final int LINE_TYPE_NUMBER = 1;
    public static final int TEXT_SIZE_TYPE_ABSOLUTE = 2;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL = 0;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL_IGNORE_PADDING = 1;
    public static final int TYPE_UNSET = Integer.MIN_VALUE;
    public static final int VERTICAL_TYPE_LR = 2;
    public static final int VERTICAL_TYPE_RL = 1;
    public final Bitmap bitmap;
    public final float bitmapHeight;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final int positionAnchor;
    public final float size;
    public final CharSequence text;
    public final Layout.Alignment textAlignment;
    public final float textSize;
    public final int textSizeType;
    public final int verticalType;
    public final int windowColor;
    public final boolean windowColorSet;

    static {
        Cue$Builder cue$Builder = new Cue$Builder();
        EMPTY = cue$Builder.setText("").build();
    }

    public Cue(CharSequence charSequence) {
        this(charSequence, null, -3.4028235E38f, -1 << -1, -1 << -1, -3.4028235E38f, -1 << -1, -3.4028235E38f);
    }

    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f10, int n10, int n11, float f11, int n12, float f12) {
        this(charSequence, alignment, f10, n10, n11, f11, n12, f12, false, -16777216);
    }

    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f10, int n10, int n11, float f11, int n12, float f12, int n13, float f13) {
        this(charSequence, alignment, null, f10, n10, n11, f11, n12, n13, f13, f12, -3.4028235E38f, false, -16777216, -1 << -1);
    }

    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f10, int n10, int n11, float f11, int n12, float f12, boolean bl2, int n13) {
        this(charSequence, alignment, null, f10, n10, n11, f11, n12, -1 << -1, -3.4028235E38f, f12, -3.4028235E38f, bl2, n13, -1 << -1);
    }

    private Cue(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap, float f10, int n10, int n11, float f11, int n12, int n13, float f12, float f13, float f14, boolean bl2, int n14, int n15) {
        Cue cue = this;
        CharSequence charSequence2 = charSequence;
        Bitmap bitmap2 = bitmap;
        if (charSequence == null) {
            Assertions.checkNotNull(bitmap);
        } else {
            boolean bl3 = bitmap == null;
            Assertions.checkArgument(bl3);
        }
        cue.text = charSequence2;
        charSequence2 = alignment;
        cue.textAlignment = alignment;
        cue.bitmap = bitmap2;
        cue.line = f10;
        cue.lineType = n10;
        cue.lineAnchor = n11;
        cue.position = f11;
        cue.positionAnchor = n12;
        cue.size = f13;
        cue.bitmapHeight = f14;
        cue.windowColorSet = bl2;
        cue.windowColor = n14;
        cue.textSizeType = n13;
        cue.textSize = f12;
        cue.verticalType = n15;
    }

    public /* synthetic */ Cue(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap, float f10, int n10, int n11, float f11, int n12, int n13, float f12, float f13, float f14, boolean bl2, int n14, int n15, Cue$1 cue$1) {
        this(charSequence, alignment, bitmap, f10, n10, n11, f11, n12, n13, f12, f13, f14, bl2, n14, n15);
    }

    public Cue$Builder buildUpon() {
        Cue$Builder cue$Builder = new Cue$Builder(this, null);
        return cue$Builder;
    }
}

