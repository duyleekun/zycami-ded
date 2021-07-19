/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.text;

import androidx.core.text.BidiFormatter;
import androidx.core.text.TextDirectionHeuristicCompat;
import java.util.Locale;

public final class BidiFormatter$Builder {
    private int mFlags;
    private boolean mIsRtlContext;
    private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

    public BidiFormatter$Builder() {
        boolean bl2 = BidiFormatter.isRtlLocale(Locale.getDefault());
        this.initialize(bl2);
    }

    public BidiFormatter$Builder(Locale locale) {
        boolean bl2 = BidiFormatter.isRtlLocale(locale);
        this.initialize(bl2);
    }

    public BidiFormatter$Builder(boolean bl2) {
        this.initialize(bl2);
    }

    private static BidiFormatter getDefaultInstanceFromContext(boolean bl2) {
        BidiFormatter bidiFormatter = bl2 ? BidiFormatter.DEFAULT_RTL_INSTANCE : BidiFormatter.DEFAULT_LTR_INSTANCE;
        return bidiFormatter;
    }

    private void initialize(boolean bl2) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat;
        this.mIsRtlContext = bl2;
        this.mTextDirectionHeuristicCompat = textDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
        this.mFlags = 2;
    }

    public BidiFormatter build() {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat;
        Object object;
        int n10 = this.mFlags;
        int n11 = 2;
        if (n10 == n11 && (object = this.mTextDirectionHeuristicCompat) == (textDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC)) {
            return BidiFormatter$Builder.getDefaultInstanceFromContext(this.mIsRtlContext);
        }
        n11 = (int)(this.mIsRtlContext ? 1 : 0);
        int n12 = this.mFlags;
        TextDirectionHeuristicCompat textDirectionHeuristicCompat2 = this.mTextDirectionHeuristicCompat;
        object = new BidiFormatter(n11 != 0, n12, textDirectionHeuristicCompat2);
        return object;
    }

    public BidiFormatter$Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
        return this;
    }

    public BidiFormatter$Builder stereoReset(boolean bl2) {
        int n10;
        int n11;
        this.mFlags = bl2 ? (n11 = this.mFlags | 2) : (n10 = this.mFlags & 0xFFFFFFFD);
        return this;
    }
}

