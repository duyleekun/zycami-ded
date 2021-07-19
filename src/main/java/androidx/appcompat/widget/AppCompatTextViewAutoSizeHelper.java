/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.RectF
 *  android.os.Build$VERSION
 *  android.text.Layout$Alignment
 *  android.text.StaticLayout
 *  android.text.StaticLayout$Builder
 *  android.text.TextPaint
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.View
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper$Impl;
import androidx.core.view.ViewCompat;
import java.io.Serializable;
import java.lang.constant.Constable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public class AppCompatTextViewAutoSizeHelper {
    private static final int DEFAULT_AUTO_SIZE_GRANULARITY_IN_PX = 1;
    private static final int DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE_IN_SP = 112;
    private static final int DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE_IN_SP = 12;
    private static final String TAG = "ACTVAutoSizeHelper";
    private static final RectF TEMP_RECTF;
    public static final float UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE = -1.0f;
    private static final int VERY_WIDE = 0x100000;
    private static ConcurrentHashMap sTextViewFieldByNameCache;
    private static ConcurrentHashMap sTextViewMethodByNameCache;
    private float mAutoSizeMaxTextSizeInPx;
    private float mAutoSizeMinTextSizeInPx;
    private float mAutoSizeStepGranularityInPx;
    private int[] mAutoSizeTextSizesInPx;
    private int mAutoSizeTextType = 0;
    private final Context mContext;
    private boolean mHasPresetAutoSizeValues;
    private final AppCompatTextViewAutoSizeHelper$Impl mImpl;
    private boolean mNeedsAutoSizeText = false;
    private TextPaint mTempTextPaint;
    private final TextView mTextView;

    static {
        Object object;
        TEMP_RECTF = object = new RectF();
        object = new ConcurrentHashMap();
        sTextViewMethodByNameCache = object;
        object = new ConcurrentHashMap();
        sTextViewFieldByNameCache = object;
    }

    public AppCompatTextViewAutoSizeHelper(TextView object) {
        float f10;
        this.mAutoSizeStepGranularityInPx = f10 = -1.0f;
        this.mAutoSizeMinTextSizeInPx = f10;
        this.mAutoSizeMaxTextSizeInPx = f10;
        int[] nArray = new int[]{};
        this.mAutoSizeTextSizesInPx = nArray;
        this.mHasPresetAutoSizeValues = false;
        this.mTextView = object;
        object = object.getContext();
        this.mContext = object;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            this.mImpl = object;
        } else {
            n11 = 23;
            if (n10 >= n11) {
                super();
                this.mImpl = object;
            } else {
                super();
                this.mImpl = object;
            }
        }
    }

    private static Object accessAndReturnWithDefault(Object object, String string2, Object object2) {
        Object object3;
        block3: {
            try {
                object3 = AppCompatTextViewAutoSizeHelper.getTextViewField(string2);
                if (object3 != null) break block3;
                return object2;
            }
            catch (IllegalAccessException illegalAccessException) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("Failed to access TextView#");
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append(" member");
                string2 = ((StringBuilder)object3).toString();
                Log.w((String)TAG, (String)string2, (Throwable)illegalAccessException);
                return object2;
            }
        }
        return ((Field)object3).get(object);
    }

    private int[] cleanupAutoSizePresetSizes(int[] nArray) {
        int n10;
        int n11 = nArray.length;
        if (n11 == 0) {
            return nArray;
        }
        Arrays.sort(nArray);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n12 = 0;
        Integer n13 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            Integer n14;
            int n15;
            int n16 = nArray[n10];
            if (n16 <= 0 || (n15 = Collections.binarySearch(arrayList, n14 = Integer.valueOf(n16))) >= 0) continue;
            Integer n17 = n16;
            arrayList.add(n17);
        }
        n10 = arrayList.size();
        if (n11 == n10) {
            return nArray;
        }
        int n18 = arrayList.size();
        int[] nArray2 = new int[n18];
        while (n12 < n18) {
            n13 = (Integer)arrayList.get(n12);
            nArray2[n12] = n10 = n13.intValue();
            ++n12;
        }
        return nArray2;
    }

    private void clearAutoSizeConfiguration() {
        float f10;
        this.mAutoSizeTextType = 0;
        this.mAutoSizeMinTextSizeInPx = f10 = -1.0f;
        this.mAutoSizeMaxTextSizeInPx = f10;
        this.mAutoSizeStepGranularityInPx = f10;
        int[] nArray = new int[]{};
        this.mAutoSizeTextSizesInPx = nArray;
        this.mNeedsAutoSizeText = false;
    }

    private StaticLayout createStaticLayoutForMeasuring(CharSequence charSequence, Layout.Alignment object, int n10, int n11) {
        int n12 = charSequence.length();
        TextPaint textPaint = this.mTempTextPaint;
        charSequence = StaticLayout.Builder.obtain((CharSequence)charSequence, (int)0, (int)n12, (TextPaint)textPaint, (int)n10);
        object = charSequence.setAlignment((Layout.Alignment)object);
        float f10 = this.mTextView.getLineSpacingExtra();
        TextView textView = this.mTextView;
        float f11 = textView.getLineSpacingMultiplier();
        object = object.setLineSpacing(f10, f11);
        n10 = this.mTextView.getIncludeFontPadding() ? 1 : 0;
        object = object.setIncludePad(n10 != 0);
        n10 = this.mTextView.getBreakStrategy();
        object = object.setBreakStrategy(n10);
        Object object2 = this.mTextView;
        n10 = object2.getHyphenationFrequency();
        object = object.setHyphenationFrequency(n10);
        n10 = -1;
        f10 = 0.0f / 0.0f;
        if (n11 == n10) {
            n11 = -1 >>> 1;
        }
        object.setMaxLines(n11);
        object = this.mImpl;
        object2 = this.mTextView;
        try {
            ((AppCompatTextViewAutoSizeHelper$Impl)object).computeAndSetTextDirection((StaticLayout.Builder)charSequence, (TextView)object2);
        }
        catch (ClassCastException classCastException) {
            object = TAG;
            object2 = "Failed to obtain TextDirectionHeuristic, auto size may be incorrect";
            Log.w((String)object, (String)object2);
        }
        return charSequence.build();
    }

    private StaticLayout createStaticLayoutForMeasuringPre16(CharSequence charSequence, Layout.Alignment alignment, int n10) {
        TextView textView = this.mTextView;
        Constable constable = Float.valueOf(1.0f);
        float f10 = ((Float)AppCompatTextViewAutoSizeHelper.accessAndReturnWithDefault(textView, "mSpacingMult", constable)).floatValue();
        textView = this.mTextView;
        constable = Float.valueOf(0.0f);
        float f11 = ((Float)AppCompatTextViewAutoSizeHelper.accessAndReturnWithDefault(textView, "mSpacingAdd", constable)).floatValue();
        textView = this.mTextView;
        constable = Boolean.TRUE;
        boolean bl2 = (Boolean)AppCompatTextViewAutoSizeHelper.accessAndReturnWithDefault(textView, "mIncludePad", constable);
        TextPaint textPaint = this.mTempTextPaint;
        constable = textView;
        textView = new StaticLayout(charSequence, textPaint, n10, alignment, f10, f11, bl2);
        return textView;
    }

    private StaticLayout createStaticLayoutForMeasuringPre23(CharSequence charSequence, Layout.Alignment alignment, int n10) {
        float f10 = this.mTextView.getLineSpacingMultiplier();
        float f11 = this.mTextView.getLineSpacingExtra();
        boolean bl2 = this.mTextView.getIncludeFontPadding();
        TextPaint textPaint = this.mTempTextPaint;
        StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, n10, alignment, f10, f11, bl2);
        return staticLayout;
    }

    private int findLargestTextSizeWhichFits(RectF object) {
        int[] nArray = this.mAutoSizeTextSizesInPx;
        int n10 = nArray.length;
        if (n10 != 0) {
            int n11 = 0;
            int n12 = 1;
            n10 -= n12;
            block0: while (true) {
                int n13 = ++n12;
                n12 = n11;
                n11 = n13;
                while (n11 <= n10) {
                    n12 = (n11 + n10) / 2;
                    int[] nArray2 = this.mAutoSizeTextSizesInPx;
                    int n14 = nArray2[n12];
                    if ((n14 = (int)(this.suggestedSizeFitsInSpace(n14, (RectF)object) ? 1 : 0)) != 0) continue block0;
                    n10 = n12 += -1;
                }
                break;
            }
            return this.mAutoSizeTextSizesInPx[n12];
        }
        object = new IllegalStateException("No available text sizes to choose from.");
        throw object;
    }

    private static Field getTextViewField(String string2) {
        Object object;
        block7: {
            Serializable serializable;
            try {
                object = sTextViewFieldByNameCache;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                serializable = new StringBuilder();
                ((StringBuilder)serializable).append("Failed to access TextView#");
                ((StringBuilder)serializable).append(string2);
                ((StringBuilder)serializable).append(" member");
                string2 = ((StringBuilder)serializable).toString();
                Log.w((String)TAG, (String)string2, (Throwable)noSuchFieldException);
                return null;
            }
            object = ((ConcurrentHashMap)object).get(string2);
            object = (Field)object;
            if (object != null) break block7;
            object = TextView.class;
            object = ((Class)object).getDeclaredField(string2);
            if (object == null) break block7;
            boolean bl2 = true;
            ((Field)object).setAccessible(bl2);
            serializable = sTextViewFieldByNameCache;
            ((ConcurrentHashMap)serializable).put(string2, object);
        }
        return object;
    }

    private static Method getTextViewMethod(String string2) {
        Object object;
        block8: {
            Object object2;
            try {
                object = sTextViewMethodByNameCache;
            }
            catch (Exception exception) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Failed to retrieve TextView#");
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append("() method");
                string2 = ((StringBuilder)object2).toString();
                Log.w((String)TAG, (String)string2, (Throwable)exception);
                return null;
            }
            object = ((ConcurrentHashMap)object).get(string2);
            object = (Method)object;
            if (object != null) break block8;
            object = TextView.class;
            boolean bl2 = false;
            object2 = null;
            object2 = new Class[]{};
            object = ((Class)object).getDeclaredMethod(string2, (Class<?>)object2);
            if (object == null) break block8;
            bl2 = true;
            ((Method)object).setAccessible(bl2);
            object2 = sTextViewMethodByNameCache;
            ((ConcurrentHashMap)object2).put(string2, object);
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object invokeAndReturnWithDefault(Object object, String string2, Object object2) {
        try {
            Method method = AppCompatTextViewAutoSizeHelper.getTextViewMethod(string2);
            Object[] objectArray = new Object[]{};
            return method.invoke(object, objectArray);
        }
        catch (Exception exception) {
            String string3 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "Failed to invoke TextView#";
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            string2 = "() method";
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            Log.w((String)string3, (String)string2, (Throwable)exception);
            return object2;
        }
    }

    private void setRawTextSize(float f10) {
        Object object = this.mTextView.getPaint();
        float f11 = object.getTextSize();
        float f12 = f10 - f11;
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (f13 != false) {
            TextView textView;
            object = this.mTextView.getPaint();
            object.setTextSize(f10);
            int n10 = Build.VERSION.SDK_INT;
            f13 = 18;
            f11 = 2.5E-44f;
            Object[] objectArray = null;
            if (n10 >= f13) {
                textView = this.mTextView;
                n10 = textView.isInLayout() ? 1 : 0;
            } else {
                n10 = 0;
                textView = null;
                f10 = 0.0f;
            }
            object = this.mTextView.getLayout();
            if (object != null) {
                block11: {
                    this.mNeedsAutoSizeText = false;
                    object = "nullLayouts";
                    object = AppCompatTextViewAutoSizeHelper.getTextViewMethod((String)object);
                    if (object == null) break block11;
                    String string2 = this.mTextView;
                    objectArray = new Object[]{};
                    try {
                        ((Method)object).invoke(string2, objectArray);
                    }
                    catch (Exception exception) {
                        objectArray = "ACTVAutoSizeHelper";
                        string2 = "Failed to invoke TextView#nullLayouts() method";
                        Log.w((String)objectArray, (String)string2, (Throwable)exception);
                    }
                }
                if (n10 == 0) {
                    textView = this.mTextView;
                    textView.requestLayout();
                } else {
                    textView = this.mTextView;
                    textView.forceLayout();
                }
                textView = this.mTextView;
                textView.invalidate();
            }
        }
    }

    private boolean setupAutoSizeText() {
        int n10;
        int n11 = this.supportsAutoSizeText();
        if (n11 != 0 && (n11 = this.mAutoSizeTextType) == (n10 = 1)) {
            int[] nArray;
            n11 = this.mHasPresetAutoSizeValues ? 1 : 0;
            if (n11 == 0 || (n11 = (nArray = this.mAutoSizeTextSizesInPx).length) == 0) {
                float f10 = this.mAutoSizeMaxTextSizeInPx;
                float f11 = this.mAutoSizeMinTextSizeInPx;
                f10 -= f11;
                f11 = this.mAutoSizeStepGranularityInPx;
                double d10 = Math.floor(f10 /= f11);
                n11 = (int)d10 + n10;
                int[] nArray2 = new int[n11];
                for (int i10 = 0; i10 < n11; ++i10) {
                    int n12;
                    float f12 = this.mAutoSizeMinTextSizeInPx;
                    float f13 = i10;
                    float f14 = this.mAutoSizeStepGranularityInPx;
                    nArray2[i10] = n12 = Math.round(f12 += (f13 *= f14));
                }
                this.mAutoSizeTextSizesInPx = nArray = this.cleanupAutoSizePresetSizes(nArray2);
            }
            this.mNeedsAutoSizeText = n10;
        } else {
            this.mNeedsAutoSizeText = false;
        }
        return this.mNeedsAutoSizeText;
    }

    private void setupAutoSizeUniformPresetSizes(TypedArray object) {
        int n10 = object.length();
        int[] nArray = new int[n10];
        if (n10 > 0) {
            for (int i10 = 0; i10 < n10; ++i10) {
                int n11;
                nArray[i10] = n11 = object.getDimensionPixelSize(i10, -1);
            }
            object = this.cleanupAutoSizePresetSizes(nArray);
            this.mAutoSizeTextSizesInPx = (int[])object;
            this.setupAutoSizeUniformPresetSizesConfiguration();
        }
    }

    private boolean setupAutoSizeUniformPresetSizesConfiguration() {
        int[] nArray = this.mAutoSizeTextSizesInPx;
        int n10 = nArray.length;
        int n11 = 0;
        float f10 = 0.0f;
        int n12 = 1;
        int n13 = n10 > 0 ? n12 : 0;
        this.mHasPresetAutoSizeValues = n13;
        if (n13 != 0) {
            float f11;
            this.mAutoSizeTextType = n12;
            n11 = nArray[0];
            this.mAutoSizeMinTextSizeInPx = f10 = (float)n11;
            this.mAutoSizeMaxTextSizeInPx = f11 = (float)nArray[n10 -= n12];
            this.mAutoSizeStepGranularityInPx = f11 = -1.0f;
        }
        return n13 != 0;
    }

    private boolean suggestedSizeFitsInSpace(int n10, RectF rectF) {
        float f10;
        float f11;
        float f12;
        int n11;
        TextView textView;
        block7: {
            block8: {
                int n12;
                TextView textView2;
                CharSequence charSequence = this.mTextView.getText();
                Object object = this.mTextView.getTransformationMethod();
                if (object != null && (object = object.getTransformation(charSequence, (View)(textView2 = this.mTextView))) != null) {
                    charSequence = object;
                }
                int n13 = Build.VERSION.SDK_INT;
                int n14 = 16;
                int n15 = -1;
                if (n13 >= n14) {
                    object = this.mTextView;
                    n13 = object.getMaxLines();
                } else {
                    n13 = n15;
                }
                this.initTempTextPaint(n10);
                textView = this.mTextView;
                textView2 = Layout.Alignment.ALIGN_NORMAL;
                String string2 = "getLayoutAlignment";
                textView = (Layout.Alignment)AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, string2, textView2);
                n14 = Math.round(rectF.right);
                textView = this.createLayout(charSequence, (Layout.Alignment)textView, n14, n13);
                n14 = 0;
                textView2 = null;
                n11 = 1;
                if (n13 == n15) break block7;
                n15 = textView.getLineCount();
                if (n15 > n13) break block8;
                n13 = textView.getLineCount() - n11;
                if ((n13 = textView.getLineEnd(n13)) == (n12 = charSequence.length())) break block7;
            }
            return false;
        }
        if ((n10 = (int)((f12 = (f11 = (float)textView.getHeight()) - (f10 = rectF.bottom)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) > 0) {
            return false;
        }
        return n11 != 0;
    }

    private boolean supportsAutoSizeText() {
        return this.mTextView instanceof AppCompatEditText ^ true;
    }

    private void validateAndSetAutoSizeTextTypeUniformConfiguration(float f10, float f11, float f12) {
        int n10 = 0;
        StringBuilder stringBuilder = null;
        float f13 = f10 - 0.0f;
        float f14 = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        String string2 = "px) is less or equal to (0px)";
        if (f14 > 0) {
            f14 = f11 == f10 ? 0 : (f11 < f10 ? -1 : 1);
            if (f14 > 0) {
                float f15 = f12 - 0.0f;
                n10 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
                if (n10 > 0) {
                    this.mAutoSizeTextType = 1;
                    this.mAutoSizeMinTextSizeInPx = f10;
                    this.mAutoSizeMaxTextSizeInPx = f11;
                    this.mAutoSizeStepGranularityInPx = f12;
                    this.mHasPresetAutoSizeValues = false;
                    return;
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append("The auto-size step granularity (");
                charSequence.append(f12);
                charSequence.append(string2);
                charSequence = charSequence.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
                throw illegalArgumentException;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Maximum auto-size text size (");
            stringBuilder.append(f11);
            stringBuilder.append("px) is less or equal to minimum auto-size text size (");
            stringBuilder.append(f10);
            stringBuilder.append("px)");
            String string3 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Minimum auto-size text size (");
        stringBuilder2.append(f10);
        stringBuilder2.append(string2);
        String string4 = stringBuilder2.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string4);
        throw illegalArgumentException;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void autoSizeText() {
        int n10 = this.isAutoSizeEnabled();
        if (n10 == 0) {
            return;
        }
        n10 = this.mNeedsAutoSizeText;
        if (n10 != 0) {
            int n11;
            float f10;
            Object object = this.mTextView;
            n10 = object.getMeasuredHeight();
            if (n10 <= 0) return;
            object = this.mTextView;
            n10 = object.getMeasuredWidth();
            if (n10 <= 0) {
                return;
            }
            object = this.mImpl;
            TextView textView = this.mTextView;
            n10 = ((AppCompatTextViewAutoSizeHelper$Impl)object).isHorizontallyScrollable(textView) ? 1 : 0;
            if (n10 != 0) {
                n10 = 0x100000;
                f10 = 1.469368E-39f;
            } else {
                object = this.mTextView;
                n10 = object.getMeasuredWidth();
                n11 = this.mTextView.getTotalPaddingLeft();
                n10 -= n11;
                textView = this.mTextView;
                n11 = textView.getTotalPaddingRight();
                n10 -= n11;
            }
            textView = this.mTextView;
            n11 = textView.getHeight();
            int n12 = this.mTextView.getCompoundPaddingBottom();
            n11 -= n12;
            TextView textView2 = this.mTextView;
            n12 = textView2.getCompoundPaddingTop();
            if (n10 <= 0) return;
            if ((n11 -= n12) <= 0) {
                return;
            }
            textView2 = TEMP_RECTF;
            synchronized (textView2) {
                textView2.setEmpty();
                textView2.right = f10 = (float)n10;
                textView2.bottom = f10 = (float)n11;
                n10 = this.findLargestTextSizeWhichFits((RectF)textView2);
                f10 = n10;
                textView = this.mTextView;
                float f11 = textView.getTextSize();
                n11 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
                if (n11 != 0) {
                    n11 = 0;
                    f11 = 0.0f;
                    textView = null;
                    this.setTextSizeInternal(0, f10);
                }
            }
        }
        this.mNeedsAutoSizeText = true;
    }

    public StaticLayout createLayout(CharSequence charSequence, Layout.Alignment alignment, int n10, int n11) {
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 23;
        if (n12 >= n13) {
            return this.createStaticLayoutForMeasuring(charSequence, alignment, n10, n11);
        }
        n11 = 16;
        if (n12 >= n11) {
            return this.createStaticLayoutForMeasuringPre23(charSequence, alignment, n10);
        }
        return this.createStaticLayoutForMeasuringPre16(charSequence, alignment, n10);
    }

    public int getAutoSizeMaxTextSize() {
        return Math.round(this.mAutoSizeMaxTextSizeInPx);
    }

    public int getAutoSizeMinTextSize() {
        return Math.round(this.mAutoSizeMinTextSizeInPx);
    }

    public int getAutoSizeStepGranularity() {
        return Math.round(this.mAutoSizeStepGranularityInPx);
    }

    public int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextSizesInPx;
    }

    public int getAutoSizeTextType() {
        return this.mAutoSizeTextType;
    }

    public void initTempTextPaint(int n10) {
        TextPaint textPaint = this.mTempTextPaint;
        if (textPaint == null) {
            this.mTempTextPaint = textPaint = new TextPaint();
        } else {
            textPaint.reset();
        }
        textPaint = this.mTempTextPaint;
        TextPaint textPaint2 = this.mTextView.getPaint();
        textPaint.set(textPaint2);
        textPaint = this.mTempTextPaint;
        float f10 = n10;
        textPaint.setTextSize(f10);
    }

    public boolean isAutoSizeEnabled() {
        boolean bl2 = this.supportsAutoSizeText();
        bl2 = bl2 && (bl2 = this.mAutoSizeTextType);
        return bl2;
    }

    public void loadFromAttributes(AttributeSet attributeSet, int n10) {
        float f10;
        float f11;
        float f12;
        Context context = this.mContext;
        Object object = R$styleable.AppCompatTextView;
        context = context.obtainStyledAttributes(attributeSet, object, n10, 0);
        TextView textView = this.mTextView;
        Context context2 = textView.getContext();
        AttributeSet attributeSet2 = attributeSet;
        ViewCompat.saveAttributeDataForStyleable((View)textView, context2, object, attributeSet, (TypedArray)context, n10, 0);
        int n11 = R$styleable.AppCompatTextView_autoSizeTextType;
        n10 = context.hasValue(n11) ? 1 : 0;
        if (n10 != 0) {
            this.mAutoSizeTextType = n11 = context.getInt(n11, 0);
        }
        n11 = R$styleable.AppCompatTextView_autoSizeStepGranularity;
        n10 = context.hasValue(n11) ? 1 : 0;
        int n12 = -1082130432;
        float f13 = -1.0f;
        if (n10 != 0) {
            f12 = context.getDimension(n11, f13);
        } else {
            n11 = n12;
            f12 = f13;
        }
        n10 = R$styleable.AppCompatTextView_autoSizeMinTextSize;
        int n13 = context.hasValue(n10);
        if (n13 != 0) {
            f11 = context.getDimension(n10, f13);
        } else {
            n10 = n12;
            f11 = f13;
        }
        n13 = R$styleable.AppCompatTextView_autoSizeMaxTextSize;
        int n14 = context.hasValue(n13);
        if (n14 != 0) {
            f10 = context.getDimension(n13, f13);
        } else {
            n13 = n12;
            f10 = f13;
        }
        n14 = R$styleable.AppCompatTextView_autoSizePresetSizes;
        int n15 = context.hasValue(n14);
        if (n15 != 0 && (n14 = context.getResourceId(n14, 0)) > 0) {
            attributeSet2 = context.getResources();
            object = attributeSet2.obtainTypedArray(n14);
            this.setupAutoSizeUniformPresetSizes((TypedArray)object);
            object.recycle();
        }
        context.recycle();
        int n16 = this.supportsAutoSizeText();
        if (n16 != 0) {
            n16 = this.mAutoSizeTextType;
            n14 = 1;
            if (n16 == n14) {
                n16 = this.mHasPresetAutoSizeValues ? 1 : 0;
                if (n16 == 0) {
                    context = this.mContext.getResources().getDisplayMetrics();
                    n14 = f11 == f13 ? 0 : (f11 > f13 ? 1 : -1);
                    n15 = 2;
                    if (n14 == 0) {
                        n10 = 0x41400000;
                        f11 = TypedValue.applyDimension((int)n15, (float)12.0f, (DisplayMetrics)context);
                    }
                    if ((n14 = (int)(f10 == f13 ? 0 : (f10 > f13 ? 1 : -1))) == 0) {
                        n13 = 1121976320;
                        f10 = TypedValue.applyDimension((int)n15, (float)112.0f, (DisplayMetrics)context);
                    }
                    if ((n16 = (int)(f12 == f13 ? 0 : (f12 > f13 ? 1 : -1))) == 0) {
                        n11 = 1065353216;
                        f12 = 1.0f;
                    }
                    this.validateAndSetAutoSizeTextTypeUniformConfiguration(f11, f10, f12);
                }
                this.setupAutoSizeText();
            }
        } else {
            this.mAutoSizeTextType = 0;
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int n10, int n11, int n12, int n13) {
        boolean bl2 = this.supportsAutoSizeText();
        if (bl2) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            float f10 = n10;
            f10 = TypedValue.applyDimension((int)n13, (float)f10, (DisplayMetrics)displayMetrics);
            float f11 = n11;
            f11 = TypedValue.applyDimension((int)n13, (float)f11, (DisplayMetrics)displayMetrics);
            float f12 = n12;
            f12 = TypedValue.applyDimension((int)n13, (float)f12, (DisplayMetrics)displayMetrics);
            this.validateAndSetAutoSizeTextTypeUniformConfiguration(f10, f11, f12);
            n10 = this.setupAutoSizeText() ? 1 : 0;
            if (n10 != 0) {
                this.autoSizeText();
            }
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] object, int n10) {
        int n11 = this.supportsAutoSizeText();
        if (n11 != 0) {
            n11 = ((int[])object).length;
            if (n11 > 0) {
                int[] nArray = new int[n11];
                if (n10 == 0) {
                    nArray = Arrays.copyOf(object, n11);
                } else {
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    for (int i10 = 0; i10 < n11; ++i10) {
                        int n12;
                        float f10 = object[i10];
                        f10 = TypedValue.applyDimension((int)n10, (float)f10, (DisplayMetrics)displayMetrics);
                        nArray[i10] = n12 = Math.round(f10);
                    }
                }
                Object object2 = this.cleanupAutoSizePresetSizes(nArray);
                this.mAutoSizeTextSizesInPx = object2;
                n10 = this.setupAutoSizeUniformPresetSizesConfiguration() ? 1 : 0;
                if (n10 == 0) {
                    object2 = new IllegalArgumentException;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("None of the preset sizes is valid: ");
                    object = Arrays.toString(object);
                    stringBuilder.append((String)object);
                    object = stringBuilder.toString();
                    object2((String)object);
                    throw object2;
                }
            } else {
                this.mHasPresetAutoSizeValues = false;
            }
            boolean bl2 = this.setupAutoSizeText();
            if (bl2) {
                this.autoSizeText();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setAutoSizeTextTypeWithDefaults(int n10) {
        int n11 = this.supportsAutoSizeText();
        if (n11 == 0) return;
        if (n10 == 0) {
            this.clearAutoSizeConfiguration();
            return;
        }
        n11 = 1;
        float f10 = Float.MIN_VALUE;
        if (n10 == n11) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            n11 = 0x41400000;
            int n12 = 2;
            f10 = TypedValue.applyDimension((int)n12, (float)12.0f, (DisplayMetrics)displayMetrics);
            float f11 = 112.0f;
            float f12 = TypedValue.applyDimension((int)n12, (float)f11, (DisplayMetrics)displayMetrics);
            n12 = 1065353216;
            float f13 = 1.0f;
            this.validateAndSetAutoSizeTextTypeUniformConfiguration(f10, f12, f13);
            n10 = this.setupAutoSizeText() ? 1 : 0;
            if (n10 == 0) return;
            this.autoSizeText();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown auto-size text type: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public void setTextSizeInternal(int n10, float f10) {
        Context context = this.mContext;
        context = context == null ? Resources.getSystem() : context.getResources();
        context = context.getDisplayMetrics();
        float f11 = TypedValue.applyDimension((int)n10, (float)f10, (DisplayMetrics)context);
        this.setRawTextSize(f11);
    }
}

