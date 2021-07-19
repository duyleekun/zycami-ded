/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Paint
 *  android.graphics.Paint$FontMetricsInt
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.icu.text.DecimalFormatSymbols
 *  android.os.Build$VERSION
 *  android.text.PrecomputedText$Params
 *  android.text.TextDirectionHeuristic
 *  android.text.TextDirectionHeuristics
 *  android.text.TextPaint
 *  android.text.method.PasswordTransformationMethod
 *  android.text.method.TransformationMethod
 *  android.util.Log
 *  android.view.ActionMode$Callback
 *  android.widget.TextView
 */
package androidx.core.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.text.PrecomputedTextCompat$Params;
import androidx.core.text.PrecomputedTextCompat$Params$Builder;
import androidx.core.util.Preconditions;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat$OreoCallback;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.lang.reflect.Field;
import java.util.Locale;

public final class TextViewCompat {
    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;
    private static final int LINES = 1;
    private static final String LOG_TAG = "TextViewCompat";
    private static Field sMaxModeField;
    private static boolean sMaxModeFieldFetched;
    private static Field sMaximumField;
    private static boolean sMaximumFieldFetched;
    private static Field sMinModeField;
    private static boolean sMinModeFieldFetched;
    private static Field sMinimumField;
    private static boolean sMinimumFieldFetched;

    private TextViewCompat() {
    }

    public static int getAutoSizeMaxTextSize(TextView textView) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 27;
        if (n10 >= n11) {
            return textView.getAutoSizeMaxTextSize();
        }
        n10 = textView instanceof AutoSizeableTextView;
        if (n10 != 0) {
            return ((AutoSizeableTextView)textView).getAutoSizeMaxTextSize();
        }
        return -1;
    }

    public static int getAutoSizeMinTextSize(TextView textView) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 27;
        if (n10 >= n11) {
            return textView.getAutoSizeMinTextSize();
        }
        n10 = textView instanceof AutoSizeableTextView;
        if (n10 != 0) {
            return ((AutoSizeableTextView)textView).getAutoSizeMinTextSize();
        }
        return -1;
    }

    public static int getAutoSizeStepGranularity(TextView textView) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 27;
        if (n10 >= n11) {
            return textView.getAutoSizeStepGranularity();
        }
        n10 = textView instanceof AutoSizeableTextView;
        if (n10 != 0) {
            return ((AutoSizeableTextView)textView).getAutoSizeStepGranularity();
        }
        return -1;
    }

    public static int[] getAutoSizeTextAvailableSizes(TextView textView) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 27;
        if (n10 >= n11) {
            return textView.getAutoSizeTextAvailableSizes();
        }
        n10 = textView instanceof AutoSizeableTextView;
        if (n10 != 0) {
            return ((AutoSizeableTextView)textView).getAutoSizeTextAvailableSizes();
        }
        return new int[0];
    }

    public static int getAutoSizeTextType(TextView textView) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 27;
        if (n10 >= n11) {
            return textView.getAutoSizeTextType();
        }
        n10 = textView instanceof AutoSizeableTextView;
        if (n10 != 0) {
            return ((AutoSizeableTextView)textView).getAutoSizeTextType();
        }
        return 0;
    }

    public static ColorStateList getCompoundDrawableTintList(TextView textView) {
        Preconditions.checkNotNull(textView);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return textView.getCompoundDrawableTintList();
        }
        n10 = textView instanceof TintableCompoundDrawablesView;
        if (n10 != 0) {
            return ((TintableCompoundDrawablesView)textView).getSupportCompoundDrawablesTintList();
        }
        return null;
    }

    public static PorterDuff.Mode getCompoundDrawableTintMode(TextView textView) {
        Preconditions.checkNotNull(textView);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return textView.getCompoundDrawableTintMode();
        }
        n10 = textView instanceof TintableCompoundDrawablesView;
        if (n10 != 0) {
            return ((TintableCompoundDrawablesView)textView).getSupportCompoundDrawablesTintMode();
        }
        return null;
    }

    public static Drawable[] getCompoundDrawablesRelative(TextView drawableArray) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            return drawableArray.getCompoundDrawablesRelative();
        }
        n11 = 17;
        if (n10 >= n11) {
            Drawable drawable2;
            n10 = drawableArray.getLayoutDirection();
            if (n10 != (n11 = 1)) {
                n11 = 0;
                drawable2 = null;
            }
            drawableArray = drawableArray.getCompoundDrawables();
            if (n11 != 0) {
                n10 = 2;
                drawable2 = drawableArray[n10];
                Drawable drawable3 = drawableArray[0];
                drawableArray[0] = drawable2;
                drawableArray[n10] = drawable3;
            }
            return drawableArray;
        }
        return drawableArray.getCompoundDrawables();
    }

    public static int getFirstBaselineToTopHeight(TextView textView) {
        int n10 = textView.getPaddingTop();
        int n11 = textView.getPaint().getFontMetricsInt().top;
        return n10 - n11;
    }

    public static int getLastBaselineToBottomHeight(TextView textView) {
        int n10 = textView.getPaddingBottom();
        int n11 = textView.getPaint().getFontMetricsInt().bottom;
        return n10 + n11;
    }

    public static int getMaxLines(TextView textView) {
        Field field;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return textView.getMaxLines();
        }
        n10 = (int)(sMaxModeFieldFetched ? 1 : 0);
        n11 = 1;
        if (n10 == 0) {
            sMaxModeField = field = TextViewCompat.retrieveField("mMaxMode");
            sMaxModeFieldFetched = n11;
        }
        if ((field = sMaxModeField) != null && (n10 = TextViewCompat.retrieveIntFromField(field, textView)) == n11) {
            n10 = (int)(sMaximumFieldFetched ? 1 : 0);
            if (n10 == 0) {
                sMaximumField = field = TextViewCompat.retrieveField("mMaximum");
                sMaximumFieldFetched = n11;
            }
            if ((field = sMaximumField) != null) {
                return TextViewCompat.retrieveIntFromField(field, textView);
            }
        }
        return -1;
    }

    public static int getMinLines(TextView textView) {
        Field field;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return textView.getMinLines();
        }
        n10 = (int)(sMinModeFieldFetched ? 1 : 0);
        n11 = 1;
        if (n10 == 0) {
            sMinModeField = field = TextViewCompat.retrieveField("mMinMode");
            sMinModeFieldFetched = n11;
        }
        if ((field = sMinModeField) != null && (n10 = TextViewCompat.retrieveIntFromField(field, textView)) == n11) {
            n10 = (int)(sMinimumFieldFetched ? 1 : 0);
            if (n10 == 0) {
                sMinimumField = field = TextViewCompat.retrieveField("mMinimum");
                sMinimumFieldFetched = n11;
            }
            if ((field = sMinimumField) != null) {
                return TextViewCompat.retrieveIntFromField(field, textView);
            }
        }
        return -1;
    }

    private static int getTextDirection(TextDirectionHeuristic textDirectionHeuristic) {
        TextDirectionHeuristic textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int n10 = 1;
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return n10;
        }
        textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return n10;
        }
        textDirectionHeuristic2 = TextDirectionHeuristics.ANYRTL_LTR;
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return 2;
        }
        textDirectionHeuristic2 = TextDirectionHeuristics.LTR;
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return 3;
        }
        textDirectionHeuristic2 = TextDirectionHeuristics.RTL;
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return 4;
        }
        textDirectionHeuristic2 = TextDirectionHeuristics.LOCALE;
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return 5;
        }
        textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return 6;
        }
        textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return 7;
        }
        return n10;
    }

    private static TextDirectionHeuristic getTextDirectionHeuristic(TextView object) {
        TransformationMethod transformationMethod = object.getTransformationMethod();
        int n10 = transformationMethod instanceof PasswordTransformationMethod;
        if (n10 != 0) {
            return TextDirectionHeuristics.LTR;
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        int n12 = 0;
        int n13 = 1;
        if (n10 >= n11 && (n10 = object.getInputType() & 0xF) == (n11 = 3)) {
            byte by2 = Character.getDirectionality(((String)(object = DecimalFormatSymbols.getInstance((Locale)object.getTextLocale()).getDigitStrings()[0])).codePointAt(0));
            if (by2 != n13 && by2 != (n10 = 2)) {
                return TextDirectionHeuristics.LTR;
            }
            return TextDirectionHeuristics.RTL;
        }
        n10 = object.getLayoutDirection();
        if (n10 == n13) {
            n12 = n13;
        }
        int n14 = object.getTextDirection();
        switch (n14) {
            default: {
                object = n12 != 0 ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            case 7: {
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            }
            case 6: {
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            case 5: {
                return TextDirectionHeuristics.LOCALE;
            }
            case 4: {
                return TextDirectionHeuristics.RTL;
            }
            case 3: {
                return TextDirectionHeuristics.LTR;
            }
            case 2: {
                return TextDirectionHeuristics.ANYRTL_LTR;
            }
        }
        return object;
    }

    public static PrecomputedTextCompat$Params getTextMetricsParams(TextView textView) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            textView = textView.getTextMetricsParams();
            PrecomputedTextCompat$Params precomputedTextCompat$Params = new PrecomputedTextCompat$Params((PrecomputedText.Params)textView);
            return precomputedTextCompat$Params;
        }
        TextPaint textPaint = textView.getPaint();
        TextPaint textPaint2 = new TextPaint((Paint)textPaint);
        PrecomputedTextCompat$Params$Builder precomputedTextCompat$Params$Builder = new PrecomputedTextCompat$Params$Builder(textPaint2);
        int n12 = 23;
        if (n10 >= n12) {
            n12 = textView.getBreakStrategy();
            precomputedTextCompat$Params$Builder.setBreakStrategy(n12);
            n12 = textView.getHyphenationFrequency();
            precomputedTextCompat$Params$Builder.setHyphenationFrequency(n12);
        }
        if (n10 >= (n12 = 18)) {
            textView = TextViewCompat.getTextDirectionHeuristic(textView);
            precomputedTextCompat$Params$Builder.setTextDirection((TextDirectionHeuristic)textView);
        }
        return precomputedTextCompat$Params$Builder.build();
    }

    private static Field retrieveField(String string2) {
        Field field = null;
        Object object = TextView.class;
        field = ((Class)object).getDeclaredField(string2);
        boolean bl2 = true;
        try {
            field.setAccessible(bl2);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            object = new StringBuilder();
            String string3 = "Could not retrieve ";
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" field.");
            string2 = ((StringBuilder)object).toString();
            object = LOG_TAG;
            Log.e((String)object, (String)string2);
        }
        return field;
    }

    private static int retrieveIntFromField(Field object, TextView object2) {
        try {
            return ((Field)object).getInt(object2);
        }
        catch (IllegalAccessException illegalAccessException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Could not retrieve value of ");
            object = ((Field)object).getName();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" field.");
            object = ((StringBuilder)object2).toString();
            Log.d((String)LOG_TAG, (String)object);
            return -1;
        }
    }

    public static void setAutoSizeTextTypeUniformWithConfiguration(TextView object, int n10, int n11, int n12, int n13) {
        int n14 = Build.VERSION.SDK_INT;
        int n15 = 27;
        if (n14 >= n15) {
            object.setAutoSizeTextTypeUniformWithConfiguration(n10, n11, n12, n13);
        } else {
            n14 = object instanceof AutoSizeableTextView;
            if (n14 != 0) {
                object = (AutoSizeableTextView)object;
                object.setAutoSizeTextTypeUniformWithConfiguration(n10, n11, n12, n13);
            }
        }
    }

    public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView object, int[] nArray, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 27;
        if (n11 >= n12) {
            object.setAutoSizeTextTypeUniformWithPresetSizes(nArray, n10);
        } else {
            n11 = object instanceof AutoSizeableTextView;
            if (n11 != 0) {
                object = (AutoSizeableTextView)object;
                object.setAutoSizeTextTypeUniformWithPresetSizes(nArray, n10);
            }
        }
    }

    public static void setAutoSizeTextTypeWithDefaults(TextView object, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 27;
        if (n11 >= n12) {
            object.setAutoSizeTextTypeWithDefaults(n10);
        } else {
            n11 = object instanceof AutoSizeableTextView;
            if (n11 != 0) {
                object = (AutoSizeableTextView)object;
                object.setAutoSizeTextTypeWithDefaults(n10);
            }
        }
    }

    public static void setCompoundDrawableTintList(TextView object, ColorStateList colorStateList) {
        Preconditions.checkNotNull(object);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            object.setCompoundDrawableTintList(colorStateList);
        } else {
            n10 = object instanceof TintableCompoundDrawablesView;
            if (n10 != 0) {
                object = (TintableCompoundDrawablesView)object;
                object.setSupportCompoundDrawablesTintList(colorStateList);
            }
        }
    }

    public static void setCompoundDrawableTintMode(TextView object, PorterDuff.Mode mode) {
        Preconditions.checkNotNull(object);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            object.setCompoundDrawableTintMode(mode);
        } else {
            n10 = object instanceof TintableCompoundDrawablesView;
            if (n10 != 0) {
                object = (TintableCompoundDrawablesView)object;
                object.setSupportCompoundDrawablesTintMode(mode);
            }
        }
    }

    public static void setCompoundDrawablesRelative(TextView textView, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            textView.setCompoundDrawablesRelative(drawable2, drawable3, drawable4, drawable5);
        } else {
            n11 = 17;
            if (n10 >= n11) {
                n10 = textView.getLayoutDirection();
                if (n10 != (n11 = 1)) {
                    n11 = 0;
                }
                Drawable drawable6 = n11 != 0 ? drawable4 : drawable2;
                if (n11 == 0) {
                    drawable2 = drawable4;
                }
                textView.setCompoundDrawables(drawable6, drawable3, drawable2, drawable5);
            } else {
                textView.setCompoundDrawables(drawable2, drawable3, drawable4, drawable5);
            }
        }
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, int n10, int n11, int n12, int n13) {
        int n14 = Build.VERSION.SDK_INT;
        int n15 = 18;
        if (n14 >= n15) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(n10, n11, n12, n13);
        } else {
            n15 = 17;
            if (n14 >= n15) {
                n14 = textView.getLayoutDirection();
                if (n14 != (n15 = 1)) {
                    n15 = 0;
                }
                n14 = n15 != 0 ? n12 : n10;
                if (n15 == 0) {
                    n10 = n12;
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(n14, n11, n10, n13);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(n10, n11, n12, n13);
            }
        }
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable5);
        } else {
            n11 = 17;
            if (n10 >= n11) {
                n10 = textView.getLayoutDirection();
                if (n10 != (n11 = 1)) {
                    n11 = 0;
                }
                Drawable drawable6 = n11 != 0 ? drawable4 : drawable2;
                if (n11 == 0) {
                    drawable2 = drawable4;
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable6, drawable3, drawable2, drawable5);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable5);
            }
        }
    }

    public static void setCustomSelectionActionModeCallback(TextView textView, ActionMode.Callback callback) {
        callback = TextViewCompat.wrapCustomSelectionActionModeCallback(textView, callback);
        textView.setCustomSelectionActionModeCallback(callback);
    }

    public static void setFirstBaselineToTopHeight(TextView textView, int n10) {
        Preconditions.checkArgumentNonnegative(n10);
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 28;
        if (n11 >= n12) {
            textView.setFirstBaselineToTopHeight(n10);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int n13 = 16;
        n11 = n11 >= n13 && (n11 = (int)(textView.getIncludeFontPadding() ? 1 : 0)) == 0 ? fontMetricsInt.ascent : fontMetricsInt.top;
        n12 = Math.abs(n11);
        if (n10 > n12) {
            n10 += n11;
            n11 = textView.getPaddingLeft();
            n12 = textView.getPaddingRight();
            n13 = textView.getPaddingBottom();
            textView.setPadding(n11, n10, n12, n13);
        }
    }

    public static void setLastBaselineToBottomHeight(TextView textView, int n10) {
        Preconditions.checkArgumentNonnegative(n10);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        int n13 = n11 >= n12 && (n11 = (int)(textView.getIncludeFontPadding() ? 1 : 0)) == 0 ? fontMetricsInt.descent : fontMetricsInt.bottom;
        n11 = Math.abs(n13);
        if (n10 > n11) {
            n10 -= n13;
            n13 = textView.getPaddingLeft();
            n11 = textView.getPaddingTop();
            n12 = textView.getPaddingRight();
            textView.setPadding(n13, n11, n12, n10);
        }
    }

    public static void setLineHeight(TextView textView, int n10) {
        Preconditions.checkArgumentNonnegative(n10);
        TextPaint textPaint = textView.getPaint();
        int n11 = textPaint.getFontMetricsInt(null);
        if (n10 != n11) {
            float f10 = n10 -= n11;
            n11 = 1065353216;
            float f11 = 1.0f;
            textView.setLineSpacing(f10, f11);
        }
    }

    public static void setPrecomputedText(TextView object, PrecomputedTextCompat precomputedTextCompat) {
        block4: {
            block3: {
                PrecomputedTextCompat$Params precomputedTextCompat$Params;
                int n10;
                block2: {
                    n10 = Build.VERSION.SDK_INT;
                    int n11 = 29;
                    if (n10 < n11) break block2;
                    precomputedTextCompat = precomputedTextCompat.getPrecomputedText();
                    object.setText((CharSequence)((Object)precomputedTextCompat));
                    break block3;
                }
                PrecomputedTextCompat$Params precomputedTextCompat$Params2 = TextViewCompat.getTextMetricsParams(object);
                n10 = (int)(precomputedTextCompat$Params2.equalsWithoutTextDirection(precomputedTextCompat$Params = precomputedTextCompat.getParams()) ? 1 : 0);
                if (n10 == 0) break block4;
                object.setText((CharSequence)((Object)precomputedTextCompat));
            }
            return;
        }
        object = new IllegalArgumentException("Given text can not be applied to TextView.");
        throw object;
    }

    public static void setTextAppearance(TextView textView, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            textView.setTextAppearance(n10);
        } else {
            Context context = textView.getContext();
            textView.setTextAppearance(context, n10);
        }
    }

    public static void setTextMetricsParams(TextView textView, PrecomputedTextCompat$Params precomputedTextCompat$Params) {
        TextDirectionHeuristic textDirectionHeuristic;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        float f10 = 2.5E-44f;
        if (n10 >= n11) {
            textDirectionHeuristic = precomputedTextCompat$Params.getTextDirection();
            n11 = TextViewCompat.getTextDirection(textDirectionHeuristic);
            textView.setTextDirection(n11);
        }
        n11 = 23;
        f10 = 3.2E-44f;
        if (n10 < n11) {
            TextPaint textPaint = precomputedTextCompat$Params.getTextPaint();
            float f11 = textPaint.getTextScaleX();
            textDirectionHeuristic = textView.getPaint();
            precomputedTextCompat$Params = precomputedTextCompat$Params.getTextPaint();
            textDirectionHeuristic.set((TextPaint)precomputedTextCompat$Params);
            float f12 = textView.getTextScaleX();
            float f13 = f11 == f12 ? 0 : (f11 > f12 ? 1 : -1);
            if (f13 == false) {
                f13 = 0x40000000;
                f12 = f11 / 2.0f;
                n11 = 1065353216;
                f10 = 1.0f;
                textView.setTextScaleX(f12 += f10);
            }
            textView.setTextScaleX(f11);
        } else {
            TextPaint textPaint = textView.getPaint();
            textDirectionHeuristic = precomputedTextCompat$Params.getTextPaint();
            textPaint.set((TextPaint)textDirectionHeuristic);
            n10 = precomputedTextCompat$Params.getBreakStrategy();
            textView.setBreakStrategy(n10);
            int n12 = precomputedTextCompat$Params.getHyphenationFrequency();
            textView.setHyphenationFrequency(n12);
        }
    }

    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(TextView textView, ActionMode.Callback callback) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11 && n10 <= (n11 = 27) && (n10 = callback instanceof TextViewCompat$OreoCallback) == 0) {
            TextViewCompat$OreoCallback textViewCompat$OreoCallback = new TextViewCompat$OreoCallback(callback, textView);
            return textViewCompat$OreoCallback;
        }
        return callback;
    }
}

