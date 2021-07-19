/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.PrecomputedText$Params
 *  android.text.PrecomputedText$Params$Builder
 *  android.text.TextDirectionHeuristic
 *  android.text.TextPaint
 *  android.text.TextUtils
 */
package androidx.core.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.util.ObjectsCompat;
import java.io.Serializable;
import java.lang.constant.Constable;
import java.util.Locale;

public final class PrecomputedTextCompat$Params {
    private final int mBreakStrategy;
    private final int mHyphenationFrequency;
    private final TextPaint mPaint;
    private final TextDirectionHeuristic mTextDir;
    public final PrecomputedText.Params mWrapped;

    public PrecomputedTextCompat$Params(PrecomputedText.Params params) {
        int n10;
        TextPaint textPaint;
        this.mPaint = textPaint = params.getTextPaint();
        textPaint = params.getTextDirection();
        this.mTextDir = textPaint;
        this.mBreakStrategy = n10 = params.getBreakStrategy();
        this.mHyphenationFrequency = n10 = params.getHyphenationFrequency();
        n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 < n11) {
            params = null;
        }
        this.mWrapped = params;
    }

    public PrecomputedTextCompat$Params(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int n10, int n11) {
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 29;
        if (n12 >= n13) {
            PrecomputedText.Params.Builder builder = new PrecomputedText.Params.Builder(textPaint);
            builder = builder.setBreakStrategy(n10).setHyphenationFrequency(n11).setTextDirection(textDirectionHeuristic).build();
            this.mWrapped = builder;
        } else {
            n12 = 0;
            Object var7_8 = null;
            this.mWrapped = null;
        }
        this.mPaint = textPaint;
        this.mTextDir = textDirectionHeuristic;
        this.mBreakStrategy = n10;
        this.mHyphenationFrequency = n11;
    }

    public boolean equals(Object object) {
        TextDirectionHeuristic textDirectionHeuristic;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof PrecomputedTextCompat$Params;
        if (n10 == 0) {
            return false;
        }
        n10 = this.equalsWithoutTextDirection((PrecomputedTextCompat$Params)(object = (PrecomputedTextCompat$Params)object));
        if (n10 == 0) {
            return false;
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11 && (textDirectionHeuristic = this.mTextDir) != (object = ((PrecomputedTextCompat$Params)object).getTextDirection())) {
            return false;
        }
        return bl2;
    }

    public boolean equalsWithoutTextDirection(PrecomputedTextCompat$Params precomputedTextCompat$Params) {
        boolean bl2;
        Object object;
        Object object2;
        float f10;
        Object object3;
        float f11;
        int n10;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        float f12 = 3.2E-44f;
        if (n11 >= n12) {
            n12 = this.mBreakStrategy;
            n10 = precomputedTextCompat$Params.getBreakStrategy();
            if (n12 != n10) {
                return false;
            }
            n12 = this.mHyphenationFrequency;
            n10 = precomputedTextCompat$Params.getHyphenationFrequency();
            if (n12 != n10) {
                return false;
            }
        }
        if ((n12 = (int)((f11 = (f12 = (object3 = this.mPaint).getTextSize()) - (f10 = (object2 = precomputedTextCompat$Params.getTextPaint()).getTextSize())) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) != 0) {
            return false;
        }
        object3 = this.mPaint;
        f12 = object3.getTextScaleX();
        float f13 = f12 - (f10 = (object2 = precomputedTextCompat$Params.getTextPaint()).getTextScaleX());
        n12 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
        if (n12 != 0) {
            return false;
        }
        object3 = this.mPaint;
        f12 = object3.getTextSkewX();
        float f14 = f12 - (f10 = (object2 = precomputedTextCompat$Params.getTextPaint()).getTextSkewX());
        n12 = (int)(f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1));
        if (n12 != 0) {
            return false;
        }
        n12 = 21;
        f12 = 2.9E-44f;
        if (n11 >= n12) {
            object3 = this.mPaint;
            f12 = object3.getLetterSpacing();
            float f15 = f12 - (f10 = (object2 = precomputedTextCompat$Params.getTextPaint()).getLetterSpacing());
            n12 = (int)(f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1));
            if (n12 != 0) {
                return false;
            }
            object3 = this.mPaint.getFontFeatureSettings();
            n12 = (int)(TextUtils.equals((CharSequence)object3, (CharSequence)(object2 = precomputedTextCompat$Params.getTextPaint().getFontFeatureSettings())) ? 1 : 0);
            if (n12 == 0) {
                return false;
            }
        }
        if ((n12 = (object3 = this.mPaint).getFlags()) != (n10 = (object2 = precomputedTextCompat$Params.getTextPaint()).getFlags())) {
            return false;
        }
        n12 = 24;
        f12 = 3.4E-44f;
        if (n11 >= n12) {
            object = this.mPaint.getTextLocales();
            n11 = (int)(object.equals(object3 = precomputedTextCompat$Params.getTextPaint().getTextLocales()) ? 1 : 0);
            if (n11 == 0) {
                return false;
            }
        } else {
            n12 = 17;
            f12 = 2.4E-44f;
            if (n11 >= n12 && (n11 = (int)(((Locale)(object = this.mPaint.getTextLocale())).equals(object3 = precomputedTextCompat$Params.getTextPaint().getTextLocale()) ? 1 : 0)) == 0) {
                return false;
            }
        }
        return !((object = this.mPaint.getTypeface()) == null ? (precomputedTextCompat$Params = precomputedTextCompat$Params.getTextPaint().getTypeface()) != null : !(bl2 = (object = this.mPaint.getTypeface()).equals((Object)(precomputedTextCompat$Params = precomputedTextCompat$Params.getTextPaint().getTypeface()))));
    }

    public int getBreakStrategy() {
        return this.mBreakStrategy;
    }

    public int getHyphenationFrequency() {
        return this.mHyphenationFrequency;
    }

    public TextDirectionHeuristic getTextDirection() {
        return this.mTextDir;
    }

    public TextPaint getTextPaint() {
        return this.mPaint;
    }

    public int hashCode() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 10;
        int n12 = 11;
        int n13 = 9;
        int n14 = 8;
        int n15 = 7;
        int n16 = 6;
        int n17 = 5;
        int n18 = 4;
        int n19 = 3;
        int n20 = 2;
        int n21 = 1;
        int n22 = 24;
        if (n10 >= n22) {
            Object[] objectArray = new Object[n12];
            Constable constable = Float.valueOf(this.mPaint.getTextSize());
            objectArray[0] = constable;
            constable = Float.valueOf(this.mPaint.getTextScaleX());
            objectArray[n21] = constable;
            constable = Float.valueOf(this.mPaint.getTextSkewX());
            objectArray[n20] = constable;
            constable = Float.valueOf(this.mPaint.getLetterSpacing());
            objectArray[n19] = constable;
            constable = this.mPaint.getFlags();
            objectArray[n18] = constable;
            constable = this.mPaint.getTextLocales();
            objectArray[n17] = constable;
            constable = this.mPaint.getTypeface();
            objectArray[n16] = constable;
            constable = Boolean.valueOf(this.mPaint.isElegantTextHeight());
            objectArray[n15] = constable;
            constable = this.mTextDir;
            objectArray[n14] = constable;
            constable = this.mBreakStrategy;
            objectArray[n13] = constable;
            constable = this.mHyphenationFrequency;
            objectArray[n11] = constable;
            return ObjectsCompat.hash(objectArray);
        }
        n22 = 21;
        if (n10 >= n22) {
            Object[] objectArray = new Object[n12];
            Serializable serializable = Float.valueOf(this.mPaint.getTextSize());
            objectArray[0] = serializable;
            serializable = Float.valueOf(this.mPaint.getTextScaleX());
            objectArray[n21] = serializable;
            serializable = Float.valueOf(this.mPaint.getTextSkewX());
            objectArray[n20] = serializable;
            serializable = Float.valueOf(this.mPaint.getLetterSpacing());
            objectArray[n19] = serializable;
            serializable = this.mPaint.getFlags();
            objectArray[n18] = serializable;
            serializable = this.mPaint.getTextLocale();
            objectArray[n17] = serializable;
            serializable = this.mPaint.getTypeface();
            objectArray[n16] = serializable;
            serializable = Boolean.valueOf(this.mPaint.isElegantTextHeight());
            objectArray[n15] = serializable;
            serializable = this.mTextDir;
            objectArray[n14] = serializable;
            serializable = this.mBreakStrategy;
            objectArray[n13] = serializable;
            serializable = this.mHyphenationFrequency;
            objectArray[n11] = serializable;
            return ObjectsCompat.hash(objectArray);
        }
        n11 = 18;
        if (n10 >= n11) {
            Object[] objectArray = new Object[n13];
            Serializable serializable = Float.valueOf(this.mPaint.getTextSize());
            objectArray[0] = serializable;
            serializable = Float.valueOf(this.mPaint.getTextScaleX());
            objectArray[n21] = serializable;
            serializable = Float.valueOf(this.mPaint.getTextSkewX());
            objectArray[n20] = serializable;
            serializable = this.mPaint.getFlags();
            objectArray[n19] = serializable;
            serializable = this.mPaint.getTextLocale();
            objectArray[n18] = serializable;
            serializable = this.mPaint.getTypeface();
            objectArray[n17] = serializable;
            serializable = this.mTextDir;
            objectArray[n16] = serializable;
            serializable = this.mBreakStrategy;
            objectArray[n15] = serializable;
            serializable = this.mHyphenationFrequency;
            objectArray[n14] = serializable;
            return ObjectsCompat.hash(objectArray);
        }
        n11 = 17;
        if (n10 >= n11) {
            Object[] objectArray = new Object[n13];
            Serializable serializable = Float.valueOf(this.mPaint.getTextSize());
            objectArray[0] = serializable;
            serializable = Float.valueOf(this.mPaint.getTextScaleX());
            objectArray[n21] = serializable;
            serializable = Float.valueOf(this.mPaint.getTextSkewX());
            objectArray[n20] = serializable;
            serializable = this.mPaint.getFlags();
            objectArray[n19] = serializable;
            serializable = this.mPaint.getTextLocale();
            objectArray[n18] = serializable;
            serializable = this.mPaint.getTypeface();
            objectArray[n17] = serializable;
            serializable = this.mTextDir;
            objectArray[n16] = serializable;
            serializable = this.mBreakStrategy;
            objectArray[n15] = serializable;
            serializable = this.mHyphenationFrequency;
            objectArray[n14] = serializable;
            return ObjectsCompat.hash(objectArray);
        }
        Object[] objectArray = new Object[n14];
        Number number = Float.valueOf(this.mPaint.getTextSize());
        objectArray[0] = number;
        number = Float.valueOf(this.mPaint.getTextScaleX());
        objectArray[n21] = number;
        number = Float.valueOf(this.mPaint.getTextSkewX());
        objectArray[n20] = number;
        number = this.mPaint.getFlags();
        objectArray[n19] = number;
        number = this.mPaint.getTypeface();
        objectArray[n18] = number;
        number = this.mTextDir;
        objectArray[n17] = number;
        number = this.mBreakStrategy;
        objectArray[n16] = number;
        number = this.mHyphenationFrequency;
        objectArray[n15] = number;
        return ObjectsCompat.hash(objectArray);
    }

    public String toString() {
        Object object;
        StringBuilder stringBuilder = new StringBuilder("{");
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("textSize=");
        float f10 = this.mPaint.getTextSize();
        ((StringBuilder)charSequence).append(f10);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(", textScaleX=");
        f10 = this.mPaint.getTextScaleX();
        ((StringBuilder)charSequence).append(f10);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(", textSkewX=");
        Object object2 = this.mPaint;
        f10 = object2.getTextSkewX();
        ((StringBuilder)charSequence).append(f10);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        f10 = 2.9E-44f;
        if (n10 >= n11) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(", letterSpacing=");
            float f11 = this.mPaint.getLetterSpacing();
            ((StringBuilder)object2).append(f11);
            object2 = ((StringBuilder)object2).toString();
            stringBuilder.append((String)object2);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(", elegantTextHeight=");
            object = this.mPaint;
            boolean bl2 = object.isElegantTextHeight();
            ((StringBuilder)object2).append(bl2);
            object2 = ((StringBuilder)object2).toString();
            stringBuilder.append((String)object2);
        }
        n11 = 24;
        f10 = 3.4E-44f;
        object = ", textLocale=";
        if (n10 >= n11) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            object = this.mPaint.getTextLocales();
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            stringBuilder.append((String)object2);
        } else {
            n11 = 17;
            f10 = 2.4E-44f;
            if (n10 >= n11) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object);
                object = this.mPaint.getTextLocale();
                ((StringBuilder)object2).append(object);
                object2 = ((StringBuilder)object2).toString();
                stringBuilder.append((String)object2);
            }
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(", typeface=");
        object = this.mPaint.getTypeface();
        ((StringBuilder)object2).append(object);
        object2 = ((StringBuilder)object2).toString();
        stringBuilder.append((String)object2);
        n11 = 26;
        f10 = 3.6E-44f;
        if (n10 >= n11) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(", variationSettings=");
            object2 = this.mPaint.getFontVariationSettings();
            ((StringBuilder)charSequence).append((String)object2);
            charSequence = ((StringBuilder)charSequence).toString();
            stringBuilder.append((String)charSequence);
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(", textDir=");
        object2 = this.mTextDir;
        ((StringBuilder)charSequence).append(object2);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(", breakStrategy=");
        n11 = this.mBreakStrategy;
        ((StringBuilder)charSequence).append(n11);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(", hyphenationFrequency=");
        n11 = this.mHyphenationFrequency;
        ((StringBuilder)charSequence).append(n11);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

