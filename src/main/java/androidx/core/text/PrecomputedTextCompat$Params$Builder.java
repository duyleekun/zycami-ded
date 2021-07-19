/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.TextDirectionHeuristic
 *  android.text.TextDirectionHeuristics
 *  android.text.TextPaint
 */
package androidx.core.text;

import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import androidx.core.text.PrecomputedTextCompat$Params;

public class PrecomputedTextCompat$Params$Builder {
    private int mBreakStrategy;
    private int mHyphenationFrequency;
    private final TextPaint mPaint;
    private TextDirectionHeuristic mTextDir;

    public PrecomputedTextCompat$Params$Builder(TextPaint textPaint) {
        this.mPaint = textPaint;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            this.mBreakStrategy = n11 = 1;
            this.mHyphenationFrequency = n11;
        } else {
            n11 = 0;
            this.mHyphenationFrequency = 0;
            this.mBreakStrategy = 0;
        }
        n11 = 18;
        if (n10 >= n11) {
            textPaint = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            this.mTextDir = textPaint;
        } else {
            n10 = 0;
            textPaint = null;
            this.mTextDir = null;
        }
    }

    public PrecomputedTextCompat$Params build() {
        TextPaint textPaint = this.mPaint;
        TextDirectionHeuristic textDirectionHeuristic = this.mTextDir;
        int n10 = this.mBreakStrategy;
        int n11 = this.mHyphenationFrequency;
        PrecomputedTextCompat$Params precomputedTextCompat$Params = new PrecomputedTextCompat$Params(textPaint, textDirectionHeuristic, n10, n11);
        return precomputedTextCompat$Params;
    }

    public PrecomputedTextCompat$Params$Builder setBreakStrategy(int n10) {
        this.mBreakStrategy = n10;
        return this;
    }

    public PrecomputedTextCompat$Params$Builder setHyphenationFrequency(int n10) {
        this.mHyphenationFrequency = n10;
        return this;
    }

    public PrecomputedTextCompat$Params$Builder setTextDirection(TextDirectionHeuristic textDirectionHeuristic) {
        this.mTextDir = textDirectionHeuristic;
        return this;
    }
}

