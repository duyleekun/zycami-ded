/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 *  android.text.method.PasswordTransformationMethod
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextHelper$1;
import androidx.appcompat.widget.AppCompatTextHelper$2;
import androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintInfo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

public class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = 255;
    private boolean mAsyncFontPending;
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableStartTint;
    private TintInfo mDrawableTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;
    private int mFontWeight = -1;
    private int mStyle = 0;
    private final TextView mView;

    public AppCompatTextHelper(TextView textView) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper;
        this.mView = textView;
        this.mAutoSizeTextHelper = appCompatTextViewAutoSizeHelper = new AppCompatTextViewAutoSizeHelper(textView);
    }

    private void applyCompoundDrawableTint(Drawable drawable2, TintInfo tintInfo) {
        if (drawable2 != null && tintInfo != null) {
            int[] nArray = this.mView.getDrawableState();
            AppCompatDrawableManager.tintDrawable(drawable2, tintInfo, nArray);
        }
    }

    private static TintInfo createTintInfo(Context context, AppCompatDrawableManager object, int n10) {
        if ((context = ((AppCompatDrawableManager)object).getTintList(context, n10)) != null) {
            object = new TintInfo();
            ((TintInfo)object).mHasTintList = true;
            ((TintInfo)object).mTintList = context;
            return object;
        }
        return null;
    }

    private void setCompoundDrawables(Drawable textView, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        int n12 = 3;
        int n13 = 1;
        int n14 = 2;
        if (n10 >= n11 && (drawable5 != null || drawable6 != null)) {
            textView = this.mView.getCompoundDrawablesRelative();
            drawable3 = this.mView;
            if (drawable5 == null) {
                drawable5 = textView[0];
            }
            if (drawable2 == null) {
                drawable2 = textView[n13];
            }
            if (drawable6 == null) {
                drawable6 = textView[n14];
            }
            if (drawable4 == null) {
                drawable4 = textView[n12];
            }
            drawable3.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (textView != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            if (n10 >= n11 && ((drawable6 = (drawable5 = this.mView.getCompoundDrawablesRelative())[0]) != null || (drawable6 = drawable5[n14]) != null)) {
                textView = this.mView;
                drawable3 = drawable5[0];
                if (drawable2 == null) {
                    drawable2 = drawable5[n13];
                }
                drawable6 = drawable5[n14];
                if (drawable4 == null) {
                    drawable4 = drawable5[n12];
                }
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable3, drawable2, drawable6, drawable4);
                return;
            }
            drawable5 = this.mView.getCompoundDrawables();
            drawable6 = this.mView;
            if (textView == null) {
                textView = drawable5[0];
            }
            if (drawable2 == null) {
                drawable2 = drawable5[n13];
            }
            if (drawable3 == null) {
                drawable3 = drawable5[n14];
            }
            if (drawable4 == null) {
                drawable4 = drawable5[n12];
            }
            drawable6.setCompoundDrawablesWithIntrinsicBounds((Drawable)textView, drawable2, drawable3, drawable4);
        }
    }

    private void setCompoundTints() {
        TintInfo tintInfo;
        this.mDrawableLeftTint = tintInfo = this.mDrawableTint;
        this.mDrawableTopTint = tintInfo;
        this.mDrawableRightTint = tintInfo;
        this.mDrawableBottomTint = tintInfo;
        this.mDrawableStartTint = tintInfo;
        this.mDrawableEndTint = tintInfo;
    }

    private void setTextSizeInternal(int n10, float f10) {
        this.mAutoSizeTextHelper.setTextSizeInternal(n10, f10);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void updateTypefaceAndStyle(Context object, TintTypedArray tintTypedArray) {
        Typeface typeface;
        int n10;
        Typeface typeface2;
        int n11;
        void var2_19;
        int n12 = Build.VERSION.SDK_INT;
        int n13 = R$styleable.TextAppearance_android_textStyle;
        int n14 = this.mStyle;
        this.mStyle = n13 = var2_19.getInt(n13, n14);
        n13 = 28;
        n14 = 2;
        int n15 = -1;
        int n16 = 0;
        if (n12 >= n13) {
            n11 = R$styleable.TextAppearance_android_textFontWeight;
            this.mFontWeight = n11 = var2_19.getInt(n11, n15);
            if (n11 != n15) {
                this.mStyle = n11 = this.mStyle & n14 | 0;
            }
        }
        n11 = R$styleable.TextAppearance_android_fontFamily;
        int n17 = var2_19.hasValue(n11);
        int n18 = 1;
        if (n17 == 0) {
            n17 = R$styleable.TextAppearance_fontFamily;
            if ((n17 = (int)(var2_19.hasValue(n17) ? 1 : 0)) == 0) {
                Typeface typeface3;
                int n19 = R$styleable.TextAppearance_android_typeface;
                n12 = var2_19.hasValue(n19) ? 1 : 0;
                if (n12 == 0) return;
                this.mAsyncFontPending = false;
                if ((n19 = var2_19.getInt(n19, n18)) == n18) {
                    Typeface typeface4;
                    this.mFontTypeface = typeface4 = Typeface.SANS_SERIF;
                    return;
                }
                if (n19 == n14) {
                    Typeface typeface5;
                    this.mFontTypeface = typeface5 = Typeface.SERIF;
                    return;
                }
                int n20 = 3;
                if (n19 != n20) {
                    return;
                }
                this.mFontTypeface = typeface3 = Typeface.MONOSPACE;
                return;
            }
        }
        this.mFontTypeface = null;
        n17 = R$styleable.TextAppearance_fontFamily;
        int n21 = var2_19.hasValue(n17);
        if (n21 != 0) {
            n11 = n17;
        }
        n17 = this.mFontWeight;
        n21 = this.mStyle;
        int n22 = object.isRestricted();
        if (n22 == 0) {
            TextView textView = this.mView;
            WeakReference<TextView> weakReference = new WeakReference<TextView>(textView);
            AppCompatTextHelper$1 appCompatTextHelper$1 = new AppCompatTextHelper$1(this, n17, n21, weakReference);
            try {
                Typeface typeface6;
                n22 = this.mStyle;
                Typeface typeface7 = var2_19.getFont(n11, n22, appCompatTextHelper$1);
                if (typeface7 != null) {
                    if (n12 >= n13 && (n17 = this.mFontWeight) != n15) {
                        Typeface typeface8;
                        Typeface typeface9 = Typeface.create((Typeface)typeface7, (int)0);
                        n17 = this.mFontWeight;
                        n21 = this.mStyle & n14;
                        n21 = n21 != 0 ? n18 : 0;
                        this.mFontTypeface = typeface8 = Typeface.create((Typeface)typeface9, (int)n17, n21 != 0);
                    } else {
                        this.mFontTypeface = typeface7;
                    }
                }
                if ((typeface6 = this.mFontTypeface) == null) {
                    n22 = n18;
                } else {
                    n22 = 0;
                    Object var1_11 = null;
                }
                this.mAsyncFontPending = n22;
            }
            catch (Resources.NotFoundException | UnsupportedOperationException throwable) {}
        }
        if ((typeface2 = this.mFontTypeface) != null) return;
        String string2 = var2_19.getString(n11);
        if (string2 == null) return;
        if (n12 >= n13 && (n10 = this.mFontWeight) != n15) {
            Typeface typeface10;
            Typeface typeface11 = Typeface.create((String)string2, (int)0);
            n10 = this.mFontWeight;
            n12 = this.mStyle & n14;
            if (n12 != 0) {
                n16 = n18;
            }
            this.mFontTypeface = typeface10 = Typeface.create((Typeface)typeface11, (int)n10, n16 != 0);
            return;
        }
        n10 = this.mStyle;
        this.mFontTypeface = typeface = Typeface.create((String)string2, (int)n10);
    }

    public void applyCompoundDrawablesTints() {
        int n10;
        int n11;
        Object object;
        Drawable drawable2 = this.mDrawableLeftTint;
        int n12 = 2;
        Drawable drawable3 = null;
        if (drawable2 != null || (drawable2 = this.mDrawableTopTint) != null || (drawable2 = this.mDrawableRightTint) != null || (drawable2 = this.mDrawableBottomTint) != null) {
            drawable2 = this.mView.getCompoundDrawables();
            object = drawable2[0];
            TintInfo tintInfo = this.mDrawableLeftTint;
            this.applyCompoundDrawableTint((Drawable)object, tintInfo);
            object = drawable2[1];
            tintInfo = this.mDrawableTopTint;
            this.applyCompoundDrawableTint((Drawable)object, tintInfo);
            object = drawable2[n12];
            tintInfo = this.mDrawableRightTint;
            this.applyCompoundDrawableTint((Drawable)object, tintInfo);
            n11 = 3;
            drawable2 = drawable2[n11];
            object = this.mDrawableBottomTint;
            this.applyCompoundDrawableTint(drawable2, (TintInfo)object);
        }
        if ((n10 = Build.VERSION.SDK_INT) >= (n11 = 17) && ((drawable2 = this.mDrawableStartTint) != null || (drawable2 = this.mDrawableEndTint) != null)) {
            drawable2 = this.mView.getCompoundDrawablesRelative();
            drawable3 = drawable2[0];
            object = this.mDrawableStartTint;
            this.applyCompoundDrawableTint(drawable3, (TintInfo)object);
            drawable2 = drawable2[n12];
            TintInfo tintInfo = this.mDrawableEndTint;
            this.applyCompoundDrawableTint(drawable2, tintInfo);
        }
    }

    public void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    public int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    public int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    public int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    public int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    public int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    public ColorStateList getCompoundDrawableTintList() {
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo = tintInfo != null ? tintInfo.mTintList : null;
        return tintInfo;
    }

    public PorterDuff.Mode getCompoundDrawableTintMode() {
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo = tintInfo != null ? tintInfo.mTintMode : null;
        return tintInfo;
    }

    public boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    public void loadFromAttributes(AttributeSet attributeSet, int n10) {
        Object object;
        AppCompatDrawableManager appCompatDrawableManager;
        boolean bl2;
        AttributeSet attributeSet2;
        boolean bl3;
        String string2;
        ColorStateList colorStateList;
        int n11;
        boolean bl4;
        float f10;
        int n12;
        float f11;
        int n13;
        int n14;
        int n15;
        int n16;
        Object object2;
        Object object3;
        boolean bl5;
        Object object4;
        Object object5;
        Object object6;
        TintTypedArray tintTypedArray;
        int n17;
        Object object7;
        AppCompatDrawableManager appCompatDrawableManager2;
        Context context;
        int n18;
        Object object8;
        AppCompatTextHelper appCompatTextHelper;
        block64: {
            int n19;
            block60: {
                boolean bl6;
                block63: {
                    block62: {
                        block61: {
                            appCompatTextHelper = this;
                            object8 = attributeSet;
                            n18 = n10;
                            context = this.mView.getContext();
                            appCompatDrawableManager2 = AppCompatDrawableManager.get();
                            object7 = R$styleable.AppCompatTextHelper;
                            n17 = 0;
                            tintTypedArray = TintTypedArray.obtainStyledAttributes(context, attributeSet, (int[])object7, n10, 0);
                            object6 = this.mView;
                            object5 = object6.getContext();
                            object4 = tintTypedArray.getWrappedTypeArray();
                            bl5 = false;
                            object3 = null;
                            object2 = attributeSet;
                            n16 = n10;
                            ViewCompat.saveAttributeDataForStyleable((View)object6, object5, (int[])object7, attributeSet, object4, n10, 0);
                            n15 = R$styleable.AppCompatTextHelper_android_textAppearance;
                            n19 = -1;
                            n15 = tintTypedArray.getResourceId(n15, n19);
                            n14 = R$styleable.AppCompatTextHelper_android_drawableLeft;
                            n13 = tintTypedArray.hasValue(n14);
                            if (n13 != 0) {
                                n14 = tintTypedArray.getResourceId(n14, 0);
                                object5 = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager2, n14);
                                this.mDrawableLeftTint = object5;
                            }
                            if ((n13 = tintTypedArray.hasValue(n14 = R$styleable.AppCompatTextHelper_android_drawableTop)) != 0) {
                                n14 = tintTypedArray.getResourceId(n14, 0);
                                object5 = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager2, n14);
                                appCompatTextHelper.mDrawableTopTint = object5;
                            }
                            if ((n13 = tintTypedArray.hasValue(n14 = R$styleable.AppCompatTextHelper_android_drawableRight)) != 0) {
                                n14 = tintTypedArray.getResourceId(n14, 0);
                                object5 = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager2, n14);
                                appCompatTextHelper.mDrawableRightTint = object5;
                            }
                            if ((n13 = tintTypedArray.hasValue(n14 = R$styleable.AppCompatTextHelper_android_drawableBottom)) != 0) {
                                n14 = tintTypedArray.getResourceId(n14, 0);
                                object5 = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager2, n14);
                                appCompatTextHelper.mDrawableBottomTint = object5;
                            }
                            n14 = Build.VERSION.SDK_INT;
                            n13 = 17;
                            f11 = 2.4E-44f;
                            if (n14 >= n13) {
                                n13 = R$styleable.AppCompatTextHelper_android_drawableStart;
                                n12 = tintTypedArray.hasValue(n13);
                                if (n12 != 0) {
                                    n13 = tintTypedArray.getResourceId(n13, 0);
                                    object7 = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager2, n13);
                                    appCompatTextHelper.mDrawableStartTint = object7;
                                }
                                if ((n12 = (int)(tintTypedArray.hasValue(n13 = R$styleable.AppCompatTextHelper_android_drawableEnd) ? 1 : 0)) != 0) {
                                    n13 = tintTypedArray.getResourceId(n13, 0);
                                    object7 = AppCompatTextHelper.createTintInfo(context, appCompatDrawableManager2, n13);
                                    appCompatTextHelper.mDrawableEndTint = object7;
                                }
                            }
                            tintTypedArray.recycle();
                            object7 = appCompatTextHelper.mView.getTransformationMethod();
                            n13 = object7 instanceof PasswordTransformationMethod;
                            n12 = 26;
                            f10 = 3.6E-44f;
                            n16 = 23;
                            if (n15 == n19) break block60;
                            object3 = R$styleable.TextAppearance;
                            object6 = TintTypedArray.obtainStyledAttributes(context, n15, object3);
                            if (n13 == 0 && (bl4 = object6.hasValue((bl5 = R$styleable.TextAppearance_textAllCaps) ? 1 : 0))) {
                                bl5 = object6.getBoolean(bl5 ? 1 : 0, false);
                                bl4 = true;
                            } else {
                                bl5 = false;
                                object3 = null;
                                bl4 = false;
                            }
                            appCompatTextHelper.updateTypefaceAndStyle(context, (TintTypedArray)object6);
                            if (n14 >= n16) break block61;
                            n11 = R$styleable.TextAppearance_android_textColor;
                            boolean bl7 = object6.hasValue(n11);
                            if (bl7) {
                                object4 = object6.getColorStateList(n11);
                            } else {
                                n11 = 0;
                                object4 = null;
                            }
                            int n20 = R$styleable.TextAppearance_android_textColorHint;
                            boolean bl8 = object6.hasValue(n20);
                            if (bl8) {
                                tintTypedArray = object6.getColorStateList(n20);
                            } else {
                                n20 = 0;
                                tintTypedArray = null;
                            }
                            n19 = R$styleable.TextAppearance_android_textColorLink;
                            boolean bl9 = object6.hasValue(n19);
                            if (!bl9) break block62;
                            colorStateList = object6.getColorStateList(n19);
                            break block63;
                        }
                        n11 = 0;
                        object4 = null;
                        boolean bl10 = false;
                        tintTypedArray = null;
                    }
                    n19 = 0;
                    colorStateList = null;
                }
                n16 = R$styleable.TextAppearance_textLocale;
                boolean bl11 = object6.hasValue(n16);
                if (bl11) {
                    string2 = object6.getString(n16);
                } else {
                    n16 = 0;
                    string2 = null;
                }
                if (n14 >= n12 && (bl6 = object6.hasValue(n12 = R$styleable.TextAppearance_fontVariationSettings))) {
                    object2 = object6.getString(n12);
                } else {
                    n12 = 0;
                    f10 = 0.0f;
                    object2 = null;
                }
                object6.recycle();
                break block64;
            }
            bl5 = false;
            object3 = null;
            bl4 = false;
            n12 = 0;
            f10 = 0.0f;
            object2 = null;
            n11 = 0;
            object4 = null;
            n16 = 0;
            string2 = null;
            boolean bl12 = false;
            tintTypedArray = null;
            n19 = 0;
            colorStateList = null;
        }
        object6 = R$styleable.TextAppearance;
        object6 = TintTypedArray.obtainStyledAttributes(context, (AttributeSet)object8, (int[])object6, n18, 0);
        if (n13 == 0 && (bl3 = object6.hasValue(n17 = R$styleable.TextAppearance_textAllCaps))) {
            attributeSet2 = object2;
            object2 = null;
            bl5 = object6.getBoolean(n17, false);
            n12 = 23;
            f10 = 3.2E-44f;
            bl4 = true;
        } else {
            attributeSet2 = object2;
            n12 = 23;
            f10 = 3.2E-44f;
        }
        if (n14 < n12) {
            n12 = R$styleable.TextAppearance_android_textColor;
            n17 = object6.hasValue(n12) ? 1 : 0;
            if (n17 != 0) {
                object4 = object6.getColorStateList(n12);
            }
            if ((n17 = (int)(object6.hasValue(n12 = R$styleable.TextAppearance_android_textColorHint) ? 1 : 0)) != 0) {
                tintTypedArray = object6.getColorStateList(n12);
            }
            if ((n17 = (int)(object6.hasValue(n12 = R$styleable.TextAppearance_android_textColorLink) ? 1 : 0)) != 0) {
                colorStateList = object6.getColorStateList(n12);
            }
        }
        if ((n17 = (int)(object6.hasValue(n12 = R$styleable.TextAppearance_textLocale) ? 1 : 0)) != 0) {
            string2 = object6.getString(n12);
        }
        n12 = 26;
        f10 = 3.6E-44f;
        object2 = n14 >= n12 && (n17 = (int)(object6.hasValue(n12 = R$styleable.TextAppearance_fontVariationSettings) ? 1 : 0)) != 0 ? object6.getString(n12) : attributeSet2;
        n17 = 28;
        if (n14 >= n17 && (bl2 = object6.hasValue(n17 = R$styleable.TextAppearance_android_textSize))) {
            appCompatDrawableManager = appCompatDrawableManager2;
            int n21 = -1;
            if ((n17 = object6.getDimensionPixelSize(n17, n21)) == 0) {
                appCompatDrawableManager2 = appCompatTextHelper.mView;
                n17 = 0;
                object8 = null;
                appCompatDrawableManager2.setTextSize(0, 0.0f);
            }
        } else {
            appCompatDrawableManager = appCompatDrawableManager2;
        }
        appCompatTextHelper.updateTypefaceAndStyle(context, (TintTypedArray)object6);
        object6.recycle();
        if (object4 != null) {
            object6 = appCompatTextHelper.mView;
            object6.setTextColor((ColorStateList)object4);
        }
        if (tintTypedArray != null) {
            object6 = appCompatTextHelper.mView;
            object6.setHintTextColor((ColorStateList)tintTypedArray);
        }
        if (colorStateList != null) {
            object6 = appCompatTextHelper.mView;
            object6.setLinkTextColor(colorStateList);
        }
        if (n13 == 0 && bl4) {
            appCompatTextHelper.setAllCaps(bl5);
        }
        if ((object6 = appCompatTextHelper.mFontTypeface) != null) {
            n13 = appCompatTextHelper.mFontWeight;
            n11 = -1;
            if (n13 == n11) {
                object7 = appCompatTextHelper.mView;
                n11 = appCompatTextHelper.mStyle;
                object7.setTypeface((Typeface)object6, n11);
            } else {
                object7 = appCompatTextHelper.mView;
                object7.setTypeface((Typeface)object6);
            }
        }
        if (object2 != null) {
            object6 = appCompatTextHelper.mView;
            object6.setFontVariationSettings((String)object2);
        }
        if (string2 != null) {
            n15 = 24;
            if (n14 >= n15) {
                object6 = appCompatTextHelper.mView;
                object5 = LocaleList.forLanguageTags((String)string2);
                object6.setTextLocales((LocaleList)object5);
            } else {
                n15 = 21;
                if (n14 >= n15) {
                    n15 = string2.indexOf(44);
                    n14 = 0;
                    object6 = string2.substring(0, n15);
                    object5 = appCompatTextHelper.mView;
                    object6 = Locale.forLanguageTag((String)object6);
                    object5.setTextLocale((Locale)object6);
                }
            }
        }
        object6 = appCompatTextHelper.mAutoSizeTextHelper;
        object5 = attributeSet;
        object6.loadFromAttributes(attributeSet, n18);
        n15 = AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE ? 1 : 0;
        if (n15 != 0 && (n15 = (object6 = appCompatTextHelper.mAutoSizeTextHelper).getAutoSizeTextType()) != 0 && (n13 = ((TextView)(object6 = (Object)appCompatTextHelper.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes())).length) > 0) {
            object7 = appCompatTextHelper.mView;
            f11 = object7.getAutoSizeStepGranularity();
            n12 = -1082130432;
            f10 = -1.0f;
            float f12 = f11 - f10;
            n13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (n13 != 0) {
                object6 = appCompatTextHelper.mView;
                object7 = appCompatTextHelper.mAutoSizeTextHelper;
                n13 = ((AppCompatTextViewAutoSizeHelper)object7).getAutoSizeMinTextSize();
                object2 = appCompatTextHelper.mAutoSizeTextHelper;
                n12 = ((AppCompatTextViewAutoSizeHelper)object2).getAutoSizeMaxTextSize();
                object4 = appCompatTextHelper.mAutoSizeTextHelper;
                n11 = object4.getAutoSizeStepGranularity();
                n16 = 0;
                string2 = null;
                object6.setAutoSizeTextTypeUniformWithConfiguration(n13, n12, n11, 0);
            } else {
                n16 = 0;
                string2 = null;
                object7 = appCompatTextHelper.mView;
                object7.setAutoSizeTextTypeUniformWithPresetSizes((int[])object6, 0);
            }
        }
        object6 = R$styleable.AppCompatTextView;
        object8 = TintTypedArray.obtainStyledAttributes(context, (AttributeSet)object5, (int[])object6);
        n15 = R$styleable.AppCompatTextView_drawableLeftCompat;
        n14 = -1;
        n15 = ((TintTypedArray)object8).getResourceId(n15, n14);
        object7 = appCompatDrawableManager;
        if (n15 != n14) {
            object6 = appCompatDrawableManager.getDrawable(context, n15);
            object2 = object6;
        } else {
            n12 = 0;
            f10 = 0.0f;
            object2 = null;
        }
        n15 = R$styleable.AppCompatTextView_drawableTopCompat;
        n15 = ((TintTypedArray)object8).getResourceId(n15, n14);
        if (n15 != n14) {
            object6 = ((AppCompatDrawableManager)object7).getDrawable(context, n15);
            object4 = object6;
        } else {
            n11 = 0;
            object4 = null;
        }
        n15 = R$styleable.AppCompatTextView_drawableRightCompat;
        n15 = ((TintTypedArray)object8).getResourceId(n15, n14);
        if (n15 != n14) {
            object6 = ((AppCompatDrawableManager)object7).getDrawable(context, n15);
            string2 = object6;
        } else {
            n16 = 0;
            string2 = null;
        }
        n15 = R$styleable.AppCompatTextView_drawableBottomCompat;
        n15 = ((TintTypedArray)object8).getResourceId(n15, n14);
        if (n15 != n14) {
            object6 = ((AppCompatDrawableManager)object7).getDrawable(context, n15);
            object3 = object6;
        } else {
            bl5 = false;
            object3 = null;
        }
        n15 = R$styleable.AppCompatTextView_drawableStartCompat;
        n15 = ((TintTypedArray)object8).getResourceId(n15, n14);
        if (n15 != n14) {
            object = object6 = ((AppCompatDrawableManager)object7).getDrawable(context, n15);
        } else {
            n18 = 0;
            object = null;
        }
        n15 = R$styleable.AppCompatTextView_drawableEndCompat;
        n15 = ((TintTypedArray)object8).getResourceId(n15, n14);
        if (n15 != n14) {
            object6 = ((AppCompatDrawableManager)object7).getDrawable(context, n15);
            context = object6;
        } else {
            context = null;
        }
        object6 = this;
        object5 = object2;
        object7 = object4;
        object2 = string2;
        object4 = object3;
        string2 = object;
        object3 = context;
        this.setCompoundDrawables((Drawable)object5, (Drawable)object7, (Drawable)object2, (Drawable)object4, (Drawable)object, (Drawable)context);
        n15 = R$styleable.AppCompatTextView_drawableTint;
        n14 = ((TintTypedArray)object8).hasValue(n15) ? 1 : 0;
        if (n14 != 0) {
            object6 = ((TintTypedArray)object8).getColorStateList(n15);
            object5 = appCompatTextHelper.mView;
            TextViewCompat.setCompoundDrawableTintList((TextView)object5, (ColorStateList)object6);
        }
        if ((n14 = (int)(((TintTypedArray)object8).hasValue(n15 = R$styleable.AppCompatTextView_drawableTintMode) ? 1 : 0)) != 0) {
            n14 = -1;
            n15 = ((TintTypedArray)object8).getInt(n15, n14);
            n13 = 0;
            f11 = 0.0f;
            object6 = DrawableUtils.parseTintMode(n15, null);
            object7 = appCompatTextHelper.mView;
            TextViewCompat.setCompoundDrawableTintMode((TextView)object7, (PorterDuff.Mode)object6);
        } else {
            n14 = -1;
        }
        n15 = R$styleable.AppCompatTextView_firstBaselineToTopHeight;
        n15 = ((TintTypedArray)object8).getDimensionPixelSize(n15, n14);
        n13 = R$styleable.AppCompatTextView_lastBaselineToBottomHeight;
        n13 = ((TintTypedArray)object8).getDimensionPixelSize(n13, n14);
        n12 = R$styleable.AppCompatTextView_lineHeight;
        n12 = ((TintTypedArray)object8).getDimensionPixelSize(n12, n14);
        ((TintTypedArray)object8).recycle();
        if (n15 != n14) {
            object4 = appCompatTextHelper.mView;
            TextViewCompat.setFirstBaselineToTopHeight((TextView)object4, n15);
        }
        if (n13 != n14) {
            object6 = appCompatTextHelper.mView;
            TextViewCompat.setLastBaselineToBottomHeight(object6, n13);
        }
        if (n12 != n14) {
            object6 = appCompatTextHelper.mView;
            TextViewCompat.setLineHeight(object6, n12);
        }
    }

    public void onAsyncTypefaceReceived(WeakReference weakReference, Typeface typeface) {
        int n10 = this.mAsyncFontPending;
        if (n10 != 0) {
            this.mFontTypeface = typeface;
            if ((weakReference = (TextView)weakReference.get()) != null) {
                n10 = ViewCompat.isAttachedToWindow((View)weakReference);
                if (n10 != 0) {
                    n10 = this.mStyle;
                    AppCompatTextHelper$2 appCompatTextHelper$2 = new AppCompatTextHelper$2(this, (TextView)weakReference, typeface, n10);
                    weakReference.post(appCompatTextHelper$2);
                } else {
                    n10 = this.mStyle;
                    weakReference.setTypeface(typeface, n10);
                }
            }
        }
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        bl2 = AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE;
        if (!bl2) {
            this.autoSizeText();
        }
    }

    public void onSetCompoundDrawables() {
        this.applyCompoundDrawablesTints();
    }

    public void onSetTextAppearance(Context object, int n10) {
        TextView textView;
        ColorStateList colorStateList;
        int n11;
        int n12;
        Object object2 = R$styleable.TextAppearance;
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(object, n10, object2);
        int n13 = tintTypedArray.hasValue(n12 = R$styleable.TextAppearance_textAllCaps);
        if (n13 != 0) {
            n12 = tintTypedArray.getBoolean(n12, false) ? 1 : 0;
            this.setAllCaps(n12 != 0);
        }
        if ((n12 = Build.VERSION.SDK_INT) < (n13 = 23)) {
            n13 = R$styleable.TextAppearance_android_textColor;
            n11 = tintTypedArray.hasValue(n13);
            if (n11 != 0 && (colorStateList = tintTypedArray.getColorStateList(n13)) != null) {
                textView = this.mView;
                textView.setTextColor(colorStateList);
            }
            if ((n11 = (int)(tintTypedArray.hasValue(n13 = R$styleable.TextAppearance_android_textColorLink) ? 1 : 0)) != 0 && (colorStateList = tintTypedArray.getColorStateList(n13)) != null) {
                textView = this.mView;
                textView.setLinkTextColor(colorStateList);
            }
            if ((n11 = (int)(tintTypedArray.hasValue(n13 = R$styleable.TextAppearance_android_textColorHint) ? 1 : 0)) != 0 && (colorStateList = tintTypedArray.getColorStateList(n13)) != null) {
                textView = this.mView;
                textView.setHintTextColor(colorStateList);
            }
        }
        if ((n11 = tintTypedArray.hasValue(n13 = R$styleable.TextAppearance_android_textSize)) != 0 && (n13 = tintTypedArray.getDimensionPixelSize(n13, n11 = -1)) == 0) {
            colorStateList = this.mView;
            n11 = 0;
            textView = null;
            colorStateList.setTextSize(0, 0.0f);
        }
        this.updateTypefaceAndStyle((Context)object, tintTypedArray);
        int n14 = 26;
        if (n12 >= n14 && (n12 = (int)(tintTypedArray.hasValue(n14 = R$styleable.TextAppearance_fontVariationSettings) ? 1 : 0)) != 0 && (object = tintTypedArray.getString(n14)) != null) {
            object2 = this.mView;
            object2.setFontVariationSettings((String)object);
        }
        tintTypedArray.recycle();
        object = this.mFontTypeface;
        if (object != null) {
            tintTypedArray = this.mView;
            n12 = this.mStyle;
            tintTypedArray.setTypeface((Typeface)object, n12);
        }
    }

    public void populateSurroundingTextIfNeeded(TextView object, InputConnection inputConnection, EditorInfo editorInfo) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 < n11 && inputConnection != null) {
            object = object.getText();
            EditorInfoCompat.setInitialSurroundingText(editorInfo, (CharSequence)object);
        }
    }

    public void setAllCaps(boolean bl2) {
        this.mView.setAllCaps(bl2);
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int n10, int n11, int n12, int n13) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(n10, n11, n12, n13);
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] nArray, int n10) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(nArray, n10);
    }

    public void setAutoSizeTextTypeWithDefaults(int n10) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(n10);
    }

    public void setCompoundDrawableTintList(ColorStateList colorStateList) {
        boolean bl2;
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo == null) {
            this.mDrawableTint = tintInfo = new TintInfo();
        }
        tintInfo = this.mDrawableTint;
        tintInfo.mTintList = colorStateList;
        if (colorStateList != null) {
            bl2 = true;
        } else {
            bl2 = false;
            colorStateList = null;
        }
        tintInfo.mHasTintList = bl2;
        this.setCompoundTints();
    }

    public void setCompoundDrawableTintMode(PorterDuff.Mode mode) {
        boolean bl2;
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo == null) {
            this.mDrawableTint = tintInfo = new TintInfo();
        }
        tintInfo = this.mDrawableTint;
        tintInfo.mTintMode = mode;
        if (mode != null) {
            bl2 = true;
        } else {
            bl2 = false;
            mode = null;
        }
        tintInfo.mHasTintMode = bl2;
        this.setCompoundTints();
    }

    public void setTextSize(int n10, float f10) {
        boolean bl2 = AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE;
        if (!bl2 && !(bl2 = this.isAutoSizeEnabled())) {
            this.setTextSizeInternal(n10, f10);
        }
    }
}

