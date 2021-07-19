/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.TypedArray
 *  android.graphics.Typeface
 *  android.text.TextPaint
 *  android.util.Log
 */
package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance$1;
import com.google.android.material.resources.TextAppearanceConfig;

public class TextAppearance {
    private static final String TAG = "TextAppearance";
    private static final int TYPEFACE_MONOSPACE = 3;
    private static final int TYPEFACE_SANS = 1;
    private static final int TYPEFACE_SERIF = 2;
    private Typeface font;
    public final String fontFamily;
    private final int fontFamilyResourceId;
    private boolean fontResolved = false;
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;
    public final ColorStateList textColor;
    public final ColorStateList textColorHint;
    public final ColorStateList textColorLink;
    public final float textSize;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(Context context, int n10) {
        float f10;
        int n11;
        float f11;
        Object object = R$styleable.TextAppearance;
        TypedArray typedArray = context.obtainStyledAttributes(n10, object);
        int n12 = R$styleable.TextAppearance_android_textSize;
        this.textSize = f11 = typedArray.getDimension(n12, 0.0f);
        n12 = R$styleable.TextAppearance_android_textColor;
        object = MaterialResources.getColorStateList(context, typedArray, n12);
        this.textColor = (ColorStateList)object;
        n12 = R$styleable.TextAppearance_android_textColorHint;
        object = MaterialResources.getColorStateList(context, typedArray, n12);
        this.textColorHint = (ColorStateList)object;
        n12 = R$styleable.TextAppearance_android_textColorLink;
        object = MaterialResources.getColorStateList(context, typedArray, n12);
        this.textColorLink = (ColorStateList)object;
        n12 = R$styleable.TextAppearance_android_textStyle;
        this.textStyle = n12 = typedArray.getInt(n12, 0);
        n12 = R$styleable.TextAppearance_android_typeface;
        this.typeface = n12 = typedArray.getInt(n12, 1);
        n12 = R$styleable.TextAppearance_fontFamily;
        int n13 = R$styleable.TextAppearance_android_fontFamily;
        n12 = MaterialResources.getIndexWithValue(typedArray, n12, n13);
        this.fontFamilyResourceId = n13 = typedArray.getResourceId(n12, 0);
        object = typedArray.getString(n12);
        this.fontFamily = object;
        n12 = R$styleable.TextAppearance_textAllCaps;
        this.textAllCaps = n11 = typedArray.getBoolean(n12, false);
        n11 = R$styleable.TextAppearance_android_shadowColor;
        context = MaterialResources.getColorStateList(context, typedArray, n11);
        this.shadowColor = context;
        int n14 = R$styleable.TextAppearance_android_shadowDx;
        this.shadowDx = f10 = typedArray.getFloat(n14, 0.0f);
        n14 = R$styleable.TextAppearance_android_shadowDy;
        this.shadowDy = f10 = typedArray.getFloat(n14, 0.0f);
        n14 = R$styleable.TextAppearance_android_shadowRadius;
        this.shadowRadius = f10 = typedArray.getFloat(n14, 0.0f);
        typedArray.recycle();
    }

    public static /* synthetic */ Typeface access$002(TextAppearance textAppearance, Typeface typeface) {
        textAppearance.font = typeface;
        return typeface;
    }

    public static /* synthetic */ boolean access$102(TextAppearance textAppearance, boolean bl2) {
        textAppearance.fontResolved = bl2;
        return bl2;
    }

    public static /* synthetic */ void access$200(TextAppearance textAppearance) {
        textAppearance.createFallbackTypeface();
    }

    private void createFallbackTypeface() {
        int n10;
        Object object = this.font;
        if (object == null) {
            object = this.fontFamily;
            n10 = this.textStyle;
            this.font = object = Typeface.create((String)object, (int)n10);
        }
        if ((object = this.font) == null) {
            int n11 = this.typeface;
            n10 = 1;
            this.font = n11 != n10 ? (n11 != (n10 = 2) ? (n11 != (n10 = 3) ? (object = Typeface.DEFAULT) : (object = Typeface.MONOSPACE)) : (object = Typeface.SERIF)) : (object = Typeface.SANS_SERIF);
            object = this.font;
            if (object != null) {
                n10 = this.textStyle;
                this.font = object = Typeface.create((Typeface)object, (int)n10);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Typeface getFont(Context context) {
        int n10 = this.fontResolved;
        if (n10 != 0) {
            return this.font;
        }
        n10 = context.isRestricted();
        if (n10 == 0) {
            try {
                n10 = this.fontFamilyResourceId;
                context = ResourcesCompat.getFont(context, n10);
                this.font = context;
                if (context != null) {
                    n10 = this.textStyle;
                    context = Typeface.create((Typeface)context, (int)n10);
                    this.font = context;
                }
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error loading font ");
                String string2 = this.fontFamily;
                stringBuilder.append(string2);
                String string3 = stringBuilder.toString();
                string2 = TAG;
                Log.d((String)string2, (String)string3, (Throwable)exception);
            }
            catch (Resources.NotFoundException | UnsupportedOperationException throwable) {}
        }
        this.createFallbackTypeface();
        this.fontResolved = true;
        return this.font;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void getFontAsync(Context context, TextPaint object, ResourcesCompat$FontCallback object2) {
        int n10 = this.fontResolved;
        if (n10 != 0) {
            context = this.font;
            this.updateTextPaintMeasureState((TextPaint)object, (Typeface)context);
            return;
        }
        this.createFallbackTypeface();
        n10 = context.isRestricted();
        if (n10 != 0) {
            this.fontResolved = true;
            context = this.font;
            this.updateTextPaintMeasureState((TextPaint)object, (Typeface)context);
            return;
        }
        try {
            n10 = this.fontFamilyResourceId;
            TextAppearance$1 textAppearance$1 = new TextAppearance$1(this, (TextPaint)object, (ResourcesCompat$FontCallback)object2);
            object = null;
            ResourcesCompat.getFont(context, n10, textAppearance$1, null);
            return;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Error loading font ");
            object2 = this.fontFamily;
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            object2 = TAG;
            Log.d((String)object2, (String)object, (Throwable)exception);
            return;
        }
        catch (Resources.NotFoundException | UnsupportedOperationException throwable) {
            return;
        }
    }

    public void updateDrawState(Context context, TextPaint textPaint, ResourcesCompat$FontCallback object) {
        int n10;
        float f10;
        int n11;
        this.updateMeasureState(context, textPaint, (ResourcesCompat$FontCallback)object);
        context = this.textColor;
        if (context != null) {
            object = textPaint.drawableState;
            int n12 = context.getDefaultColor();
            n11 = context.getColorForState((int[])object, n12);
        } else {
            n11 = -16777216;
            f10 = -1.7014118E38f;
        }
        textPaint.setColor(n11);
        f10 = this.shadowRadius;
        float f11 = this.shadowDx;
        float f12 = this.shadowDy;
        ColorStateList colorStateList = this.shadowColor;
        if (colorStateList != null) {
            int[] nArray = textPaint.drawableState;
            int n13 = colorStateList.getDefaultColor();
            n10 = colorStateList.getColorForState(nArray, n13);
        } else {
            n10 = 0;
            colorStateList = null;
        }
        textPaint.setShadowLayer(f10, f11, f12, n10);
    }

    public void updateMeasureState(Context context, TextPaint textPaint, ResourcesCompat$FontCallback resourcesCompat$FontCallback) {
        boolean bl2 = TextAppearanceConfig.shouldLoadFontSynchronously();
        if (bl2) {
            context = this.getFont(context);
            this.updateTextPaintMeasureState(textPaint, (Typeface)context);
        } else {
            this.getFontAsync(context, textPaint, resourcesCompat$FontCallback);
            boolean bl3 = this.fontResolved;
            if (!bl3) {
                context = this.font;
                this.updateTextPaintMeasureState(textPaint, (Typeface)context);
            }
        }
    }

    public void updateTextPaintMeasureState(TextPaint textPaint, Typeface typeface) {
        float f10;
        textPaint.setTypeface(typeface);
        int n10 = this.textStyle;
        int n11 = ~typeface.getStyle() & n10;
        n10 = n11 & 1;
        n10 = n10 != 0 ? 1 : 0;
        textPaint.setFakeBoldText(n10 != 0);
        if ((n11 &= 2) != 0) {
            n11 = -1098907648;
            f10 = -0.25f;
        } else {
            n11 = 0;
            f10 = 0.0f;
            typeface = null;
        }
        textPaint.setTextSkewX(f10);
        f10 = this.textSize;
        textPaint.setTextSize(f10);
    }
}

