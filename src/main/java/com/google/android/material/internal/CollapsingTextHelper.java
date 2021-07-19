/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.os.Build$VERSION
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.view.View
 */
package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;

public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    private static final Paint DEBUG_DRAW_PAINT;
    private static final boolean USE_SCALING_TEXTURE;
    private boolean boundsChanged;
    private final Rect collapsedBounds;
    private float collapsedDrawX;
    private float collapsedDrawY;
    private int collapsedShadowColor;
    private float collapsedShadowDx;
    private float collapsedShadowDy;
    private float collapsedShadowRadius;
    private ColorStateList collapsedTextColor;
    private int collapsedTextGravity;
    private float collapsedTextSize;
    private Typeface collapsedTypeface;
    private final RectF currentBounds;
    private float currentDrawX;
    private float currentDrawY;
    private float currentTextSize;
    private Typeface currentTypeface;
    private boolean drawTitle;
    private final Rect expandedBounds;
    private float expandedDrawX;
    private float expandedDrawY;
    private float expandedFraction;
    private int expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private ColorStateList expandedTextColor;
    private int expandedTextGravity;
    private float expandedTextSize;
    private Bitmap expandedTitleTexture;
    private Typeface expandedTypeface;
    private boolean isRtl;
    private TimeInterpolator positionInterpolator;
    private float scale;
    private int[] state;
    private CharSequence text;
    private final TextPaint textPaint;
    private TimeInterpolator textSizeInterpolator;
    private CharSequence textToDraw;
    private float textureAscent;
    private float textureDescent;
    private Paint texturePaint;
    private final TextPaint tmpPaint;
    private boolean useTexture;
    private final View view;

    static {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 1;
        int n12 = 18;
        n10 = n10 < n12 ? n11 : 0;
        USE_SCALING_TEXTURE = n10;
        n10 = 0;
        DEBUG_DRAW_PAINT = null;
        if (false) {
            null.setAntiAlias(n11 != 0);
            n11 = -65281;
            null.setColor(n11);
        }
    }

    public CollapsingTextHelper(View view) {
        TextPaint textPaint;
        float f10;
        int n10;
        this.expandedTextGravity = n10 = 16;
        this.collapsedTextGravity = n10;
        this.expandedTextSize = f10 = 15.0f;
        this.collapsedTextSize = f10;
        this.view = view;
        super(129);
        this.textPaint = view;
        this.tmpPaint = textPaint = new TextPaint((Paint)view);
        super();
        this.collapsedBounds = view;
        super();
        this.expandedBounds = view;
        super();
        this.currentBounds = view;
    }

    private static int blendColors(int n10, int n11, float f10) {
        float f11 = 1.0f - f10;
        float f12 = (float)Color.alpha((int)n10) * f11;
        float f13 = (float)Color.alpha((int)n11) * f10;
        f12 += f13;
        f13 = (float)Color.red((int)n10) * f11;
        float f14 = (float)Color.red((int)n11) * f10;
        f13 += f14;
        f14 = (float)Color.green((int)n10) * f11;
        float f15 = (float)Color.green((int)n11) * f10;
        float f16 = (float)Color.blue((int)n10) * f11;
        float f17 = (float)Color.blue((int)n11) * f10;
        n11 = (int)f12;
        int n12 = (int)f13;
        int n13 = (int)(f14 += f15);
        n10 = (int)(f16 += f17);
        return Color.argb((int)n11, (int)n12, (int)n13, (int)n10);
    }

    private void calculateBaseOffsets() {
        float f10;
        int n10;
        float f11;
        float f12;
        int n11;
        int n12;
        TextPaint textPaint;
        float f13 = this.currentTextSize;
        float f14 = this.collapsedTextSize;
        this.calculateUsingTextSize(f14);
        CharSequence charSequence = this.textToDraw;
        int n13 = 0;
        float f15 = 0.0f;
        Rect rect = null;
        float f16 = 0.0f;
        TextPaint textPaint2 = null;
        if (charSequence != null) {
            textPaint = this.textPaint;
            n12 = charSequence.length();
            f14 = textPaint.measureText(charSequence, 0, n12);
        } else {
            n11 = 0;
            charSequence = null;
            f14 = 0.0f;
        }
        int n14 = this.collapsedTextGravity;
        n12 = (int)(this.isRtl ? 1 : 0);
        n14 = GravityCompat.getAbsoluteGravity(n14, n12);
        n12 = n14 & 0x70;
        int n15 = 80;
        int n16 = 48;
        float f17 = 2.0f;
        if (n12 != n16) {
            if (n12 != n15) {
                TextPaint textPaint3 = this.textPaint;
                f12 = textPaint3.descent();
                f11 = this.textPaint.ascent();
                f12 = (f12 - f11) / f17;
                f11 = this.textPaint.descent();
                f12 -= f11;
                Rect rect2 = this.collapsedBounds;
                n10 = rect2.centerY();
                this.collapsedDrawY = f11 = (float)n10 + f12;
            } else {
                Rect rect3 = this.collapsedBounds;
                n12 = rect3.bottom;
                this.collapsedDrawY = f12 = (float)n12;
            }
        } else {
            Rect rect4 = this.collapsedBounds;
            n12 = rect4.top;
            f12 = n12;
            TextPaint textPaint4 = this.textPaint;
            f11 = textPaint4.ascent();
            this.collapsedDrawY = f12 -= f11;
        }
        n12 = 0x800007;
        f12 = 1.1754953E-38f;
        n10 = 5;
        f11 = 7.0E-45f;
        int n17 = 1;
        if ((n14 &= n12) != n17) {
            if (n14 != n10) {
                charSequence = this.collapsedBounds;
                n11 = ((Rect)charSequence).left;
                this.collapsedDrawX = f14 = (float)n11;
            } else {
                textPaint = this.collapsedBounds;
                n14 = textPaint.right;
                this.collapsedDrawX = f10 = (float)n14 - f14;
            }
        } else {
            textPaint = this.collapsedBounds;
            n14 = textPaint.centerX();
            f10 = n14;
            this.collapsedDrawX = f10 -= (f14 /= f17);
        }
        f14 = this.expandedTextSize;
        this.calculateUsingTextSize(f14);
        charSequence = this.textToDraw;
        if (charSequence != null) {
            textPaint2 = this.textPaint;
            n14 = charSequence.length();
            f16 = textPaint2.measureText(charSequence, 0, n14);
        }
        n11 = this.expandedTextGravity;
        n13 = this.isRtl;
        if ((n13 = (n11 = GravityCompat.getAbsoluteGravity(n11, n13)) & 0x70) != n16) {
            if (n13 != n15) {
                rect = this.textPaint;
                f15 = rect.descent();
                f10 = this.textPaint.ascent();
                f15 = (f15 - f10) / f17;
                f10 = this.textPaint.descent();
                f15 -= f10;
                textPaint = this.expandedBounds;
                n14 = textPaint.centerY();
                this.expandedDrawY = f10 = (float)n14 + f15;
            } else {
                rect = this.expandedBounds;
                n13 = rect.bottom;
                this.expandedDrawY = f15 = (float)n13;
            }
        } else {
            rect = this.expandedBounds;
            n13 = rect.top;
            f15 = n13;
            textPaint = this.textPaint;
            f10 = textPaint.ascent();
            this.expandedDrawY = f15 -= f10;
        }
        if ((n11 &= n12) != n17) {
            if (n11 != n10) {
                charSequence = this.expandedBounds;
                n11 = ((Rect)charSequence).left;
                this.expandedDrawX = f14 = (float)n11;
            } else {
                charSequence = this.expandedBounds;
                n11 = ((Rect)charSequence).right;
                this.expandedDrawX = f14 = (float)n11 - f16;
            }
        } else {
            charSequence = this.expandedBounds;
            n11 = charSequence.centerX();
            f14 = n11;
            this.expandedDrawX = f14 -= (f16 /= f17);
        }
        this.clearTexture();
        this.setInterpolatedTextSize(f13);
    }

    private void calculateCurrentOffsets() {
        float f10 = this.expandedFraction;
        this.calculateOffsets(f10);
    }

    private boolean calculateIsRtl(CharSequence charSequence) {
        int n10;
        Object object = this.view;
        int n11 = ViewCompat.getLayoutDirection((View)object);
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        object = n10 != 0 ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        n10 = charSequence.length();
        return object.isRtl(charSequence, 0, n10);
    }

    private void calculateOffsets(float f10) {
        this.interpolateBounds(f10);
        float f11 = this.expandedDrawX;
        float f12 = this.collapsedDrawX;
        TimeInterpolator timeInterpolator = this.positionInterpolator;
        this.currentDrawX = f11 = CollapsingTextHelper.lerp(f11, f12, f10, timeInterpolator);
        f11 = this.expandedDrawY;
        f12 = this.collapsedDrawY;
        timeInterpolator = this.positionInterpolator;
        this.currentDrawY = f11 = CollapsingTextHelper.lerp(f11, f12, f10, timeInterpolator);
        f11 = this.expandedTextSize;
        f12 = this.collapsedTextSize;
        timeInterpolator = this.textSizeInterpolator;
        f11 = CollapsingTextHelper.lerp(f11, f12, f10, timeInterpolator);
        this.setInterpolatedTextSize(f11);
        ColorStateList colorStateList = this.collapsedTextColor;
        ColorStateList colorStateList2 = this.expandedTextColor;
        if (colorStateList != colorStateList2) {
            colorStateList = this.textPaint;
            int n10 = this.getCurrentExpandedTextColor();
            int n11 = this.getCurrentCollapsedTextColor();
            n10 = CollapsingTextHelper.blendColors(n10, n11, f10);
            colorStateList.setColor(n10);
        } else {
            colorStateList = this.textPaint;
            int n12 = this.getCurrentCollapsedTextColor();
            colorStateList.setColor(n12);
        }
        colorStateList = this.textPaint;
        f12 = this.expandedShadowRadius;
        float f13 = this.collapsedShadowRadius;
        f12 = CollapsingTextHelper.lerp(f12, f13, f10, null);
        f13 = this.expandedShadowDx;
        float f14 = this.collapsedShadowDx;
        f13 = CollapsingTextHelper.lerp(f13, f14, f10, null);
        f14 = this.expandedShadowDy;
        float f15 = this.collapsedShadowDy;
        float f16 = CollapsingTextHelper.lerp(f14, f15, f10, null);
        int n13 = this.expandedShadowColor;
        int n14 = this.collapsedShadowColor;
        int n15 = CollapsingTextHelper.blendColors(n13, n14, f10);
        colorStateList.setShadowLayer(f12, f13, f16, n15);
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    /*
     * WARNING - void declaration
     */
    private void calculateUsingTextSize(float f10) {
        void var6_13;
        CharSequence charSequence;
        Typeface typeface;
        CharSequence charSequence2 = this.text;
        if (charSequence2 == null) {
            return;
        }
        charSequence2 = this.collapsedBounds;
        int n10 = charSequence2.width();
        float f11 = n10;
        Rect rect = this.expandedBounds;
        int bl2 = rect.width();
        float f12 = bl2;
        float f13 = this.collapsedTextSize;
        int n11 = CollapsingTextHelper.isClose(f10, f13);
        float f14 = 1.0f;
        boolean bl3 = true;
        float f15 = Float.MIN_VALUE;
        if (n11 != 0) {
            f10 = this.collapsedTextSize;
            this.scale = f14;
            rect = this.currentTypeface;
            typeface = this.collapsedTypeface;
            if (rect != typeface) {
                this.currentTypeface = typeface;
                boolean bl4 = bl3;
                f12 = f15;
            } else {
                boolean bl5 = false;
                rect = null;
                f12 = 0.0f;
            }
        } else {
            float f16;
            float f17;
            boolean bl6;
            f13 = this.expandedTextSize;
            Typeface typeface2 = this.currentTypeface;
            Typeface typeface3 = this.expandedTypeface;
            if (typeface2 != typeface3) {
                this.currentTypeface = typeface3;
                bl6 = bl3;
                f17 = f15;
            } else {
                bl6 = false;
                typeface2 = null;
                f17 = 0.0f;
            }
            int n12 = CollapsingTextHelper.isClose(f10, f13);
            if (n12 != 0) {
                this.scale = f14;
            } else {
                f16 = this.expandedTextSize;
                this.scale = f10 /= f16;
            }
            f10 = this.collapsedTextSize;
            f16 = this.expandedTextSize;
            f10 /= f16;
            f16 = f12 * f10;
            n12 = f16 == f11 ? 0 : (f16 > f11 ? 1 : -1);
            f11 = n12 > 0 ? Math.min(f11 / f10, f12) : f12;
            f10 = f13;
            boolean bl7 = bl6;
            f12 = f17;
        }
        f13 = 0.0f;
        typeface = null;
        float f18 = f11 - 0.0f;
        n11 = f18 == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1);
        if (n11 > 0) {
            void var6_10;
            f13 = this.currentTextSize;
            float f19 = f13 - f10;
            n11 = (int)(f19 == 0.0f ? 0 : (f19 > 0.0f ? 1 : -1));
            if (n11 == 0 && (n11 = (int)(this.boundsChanged ? 1 : 0)) == 0 && var6_10 == false) {
                boolean bl8 = false;
                rect = null;
                f12 = 0.0f;
            } else {
                boolean bl9 = bl3;
                f12 = f15;
            }
            this.currentTextSize = f10;
            this.boundsChanged = false;
        }
        if ((charSequence = this.textToDraw) == null || var6_13 != false) {
            charSequence = this.textPaint;
            f12 = this.currentTextSize;
            charSequence.setTextSize(f12);
            charSequence = this.textPaint;
            rect = this.currentTypeface;
            charSequence.setTypeface((Typeface)rect);
            charSequence = this.textPaint;
            f12 = this.scale;
            float f20 = f12 == f14 ? 0 : (f12 > f14 ? 1 : -1);
            if (f20 == false) {
                bl3 = false;
                f15 = 0.0f;
            }
            charSequence.setLinearText(bl3);
            charSequence = this.text;
            rect = this.textPaint;
            typeface = TextUtils.TruncateAt.END;
            charSequence = TextUtils.ellipsize((CharSequence)charSequence, (TextPaint)rect, (float)f11, (TextUtils.TruncateAt)typeface);
            charSequence2 = this.textToDraw;
            n10 = (int)(TextUtils.equals((CharSequence)charSequence, (CharSequence)charSequence2) ? 1 : 0);
            if (n10 == 0) {
                boolean bl10;
                this.textToDraw = charSequence;
                this.isRtl = bl10 = this.calculateIsRtl(charSequence);
            }
        }
    }

    private void clearTexture() {
        Bitmap bitmap = this.expandedTitleTexture;
        if (bitmap != null) {
            bitmap.recycle();
            bitmap = null;
            this.expandedTitleTexture = null;
        }
    }

    private void ensureExpandedTexture() {
        int n10;
        Object object = this.expandedTitleTexture;
        if (object == null && (n10 = (object = this.expandedBounds).isEmpty()) == 0 && (n10 = TextUtils.isEmpty((CharSequence)(object = this.textToDraw))) == 0) {
            float f10;
            this.calculateOffsets(0.0f);
            this.textureAscent = f10 = this.textPaint.ascent();
            this.textureDescent = f10 = this.textPaint.descent();
            object = this.textPaint;
            CharSequence charSequence = this.textToDraw;
            Bitmap.Config config = null;
            int n11 = charSequence.length();
            f10 = object.measureText(charSequence, 0, n11);
            n10 = Math.round(f10);
            float f11 = this.textureDescent;
            float f12 = this.textureAscent;
            int n12 = Math.round(f11 -= f12);
            if (n10 > 0 && n12 > 0) {
                config = Bitmap.Config.ARGB_8888;
                object = this.expandedTitleTexture = (object = Bitmap.createBitmap((int)n10, (int)n12, (Bitmap.Config)config));
                config = new Canvas(object);
                CharSequence charSequence2 = this.textToDraw;
                int n13 = charSequence2.length();
                f10 = n12;
                charSequence = this.textPaint;
                f11 = charSequence.descent();
                float f13 = f10 - f11;
                TextPaint textPaint = this.textPaint;
                config.drawText(charSequence2, 0, n13, 0.0f, f13, (Paint)textPaint);
                object = this.texturePaint;
                if (object == null) {
                    n12 = 3;
                    f11 = 4.2E-45f;
                    object = new Paint(n12);
                    this.texturePaint = object;
                }
            }
        }
    }

    private int getCurrentExpandedTextColor() {
        int[] nArray = this.state;
        if (nArray != null) {
            return this.expandedTextColor.getColorForState(nArray, 0);
        }
        return this.expandedTextColor.getDefaultColor();
    }

    private void getTextPaintCollapsed(TextPaint textPaint) {
        float f10 = this.collapsedTextSize;
        textPaint.setTextSize(f10);
        Typeface typeface = this.collapsedTypeface;
        textPaint.setTypeface(typeface);
    }

    private void interpolateBounds(float f10) {
        RectF rectF = this.currentBounds;
        float f11 = this.expandedBounds.left;
        float f12 = this.collapsedBounds.left;
        TimeInterpolator timeInterpolator = this.positionInterpolator;
        rectF.left = f11 = CollapsingTextHelper.lerp(f11, f12, f10, timeInterpolator);
        rectF = this.currentBounds;
        f11 = this.expandedDrawY;
        f12 = this.collapsedDrawY;
        timeInterpolator = this.positionInterpolator;
        rectF.top = f11 = CollapsingTextHelper.lerp(f11, f12, f10, timeInterpolator);
        rectF = this.currentBounds;
        f11 = this.expandedBounds.right;
        f12 = this.collapsedBounds.right;
        timeInterpolator = this.positionInterpolator;
        rectF.right = f11 = CollapsingTextHelper.lerp(f11, f12, f10, timeInterpolator);
        rectF = this.currentBounds;
        f11 = this.expandedBounds.bottom;
        f12 = this.collapsedBounds.bottom;
        timeInterpolator = this.positionInterpolator;
        rectF.bottom = f10 = CollapsingTextHelper.lerp(f11, f12, f10, timeInterpolator);
    }

    private static boolean isClose(float f10, float f11) {
        float f12 = (f10 = Math.abs(f10 - f11)) - (f11 = 0.001f);
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object < 0) {
            object = true;
            f10 = Float.MIN_VALUE;
        } else {
            object = false;
            f10 = 0.0f;
        }
        return (boolean)object;
    }

    private static float lerp(float f10, float f11, float f12, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f12 = timeInterpolator.getInterpolation(f12);
        }
        return AnimationUtils.lerp(f10, f11, f12);
    }

    private Typeface readFontFamilyTypeface(int n10) {
        TypedArray typedArray;
        block4: {
            int n11;
            Object object = this.view.getContext();
            int n12 = 1;
            int[] nArray = new int[n12];
            nArray[0] = n11 = 16843692;
            typedArray = object.obtainStyledAttributes(n10, nArray);
            object = typedArray.getString(0);
            if (object == null) break block4;
            object = Typeface.create((String)object, (int)0);
            return object;
        }
        typedArray.recycle();
        return null;
        finally {
            typedArray.recycle();
        }
    }

    private static boolean rectEquals(Rect rect, int n10, int n11, int n12, int n13) {
        int n14;
        int n15 = rect.left;
        if (n15 == n10 && (n10 = rect.top) == n11 && (n10 = rect.right) == n12 && (n14 = rect.bottom) == n13) {
            n14 = 1;
        } else {
            n14 = 0;
            rect = null;
        }
        return n14 != 0;
    }

    private void setInterpolatedTextSize(float f10) {
        float f11;
        float f12;
        this.calculateUsingTextSize(f10);
        boolean bl2 = USE_SCALING_TEXTURE;
        if (bl2 && (bl2 = (f12 = (f10 = this.scale) - (f11 = 1.0f)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) {
            bl2 = true;
            f10 = Float.MIN_VALUE;
        } else {
            bl2 = false;
            f10 = 0.0f;
        }
        this.useTexture = bl2;
        if (bl2) {
            this.ensureExpandedTexture();
        }
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    public float calculateCollapsedTextWidth() {
        CharSequence charSequence = this.text;
        if (charSequence == null) {
            return 0.0f;
        }
        charSequence = this.tmpPaint;
        this.getTextPaintCollapsed((TextPaint)charSequence);
        charSequence = this.tmpPaint;
        CharSequence charSequence2 = this.text;
        int n10 = charSequence2.length();
        return charSequence.measureText(charSequence2, 0, n10);
    }

    public void draw(Canvas canvas) {
        boolean bl2;
        int n10 = canvas.save();
        CharSequence charSequence = this.textToDraw;
        if (charSequence != null && (bl2 = this.drawTitle)) {
            TextPaint textPaint;
            Object object;
            float f10;
            float f11;
            Bitmap bitmap;
            float f12 = this.currentDrawX;
            float f13 = this.currentDrawY;
            boolean bl3 = this.useTexture;
            if (bl3 && (bitmap = this.expandedTitleTexture) != null) {
                bl3 = true;
            } else {
                bl3 = false;
                bitmap = null;
            }
            if (bl3) {
                f11 = this.textureAscent;
                f10 = this.scale;
                f11 *= f10;
            } else {
                object = this.textPaint;
                f11 = object.ascent();
                f10 = this.scale;
                f11 *= f10;
                textPaint = this.textPaint;
                textPaint.descent();
            }
            if (bl3) {
                f13 += f11;
            }
            float f14 = f13;
            f13 = this.scale;
            f11 = 1.0f;
            float f15 = f13 - f11;
            Object object2 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
            if (object2 != false) {
                canvas.scale(f13, f13, f12, f14);
            }
            if (bl3) {
                charSequence = this.expandedTitleTexture;
                bitmap = this.texturePaint;
                canvas.drawBitmap((Bitmap)charSequence, f12, f14, (Paint)bitmap);
            } else {
                object = this.textToDraw;
                f10 = 0.0f;
                textPaint = null;
                int n11 = object.length();
                TextPaint textPaint2 = this.textPaint;
                bitmap = canvas;
                canvas.drawText((CharSequence)object, 0, n11, f12, f14, (Paint)textPaint2);
            }
        }
        canvas.restoreToCount(n10);
    }

    public void getCollapsedTextActualBounds(RectF rectF) {
        float f10;
        float f11;
        float f12;
        CharSequence charSequence = this.text;
        int n10 = this.calculateIsRtl(charSequence);
        Rect rect = this.collapsedBounds;
        if (n10 == 0) {
            int n11 = rect.left;
            f12 = n11;
        } else {
            int n12 = rect.right;
            f12 = n12;
            float f13 = this.calculateCollapsedTextWidth();
            f12 -= f13;
        }
        rectF.left = f12;
        Rect rect2 = this.collapsedBounds;
        int n13 = rect2.top;
        rectF.top = f11 = (float)n13;
        if (n10 == 0) {
            f10 = this.calculateCollapsedTextWidth();
            f12 += f10;
        } else {
            n10 = rect2.right;
            f12 = n10;
        }
        rectF.right = f12;
        f10 = this.collapsedBounds.top;
        f12 = this.getCollapsedTextHeight();
        rectF.bottom = f10 += f12;
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public float getCollapsedTextHeight() {
        TextPaint textPaint = this.tmpPaint;
        this.getTextPaintCollapsed(textPaint);
        return -this.tmpPaint.ascent();
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.collapsedTypeface;
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        return typeface;
    }

    public int getCurrentCollapsedTextColor() {
        int[] nArray = this.state;
        if (nArray != null) {
            return this.collapsedTextColor.getColorForState(nArray, 0);
        }
        return this.collapsedTextColor.getDefaultColor();
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.expandedTypeface;
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        return typeface;
    }

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public CharSequence getText() {
        return this.text;
    }

    public final boolean isStateful() {
        boolean bl2;
        ColorStateList colorStateList = this.collapsedTextColor;
        if (colorStateList != null && (bl2 = colorStateList.isStateful()) || (colorStateList = this.expandedTextColor) != null && (bl2 = colorStateList.isStateful())) {
            bl2 = true;
        } else {
            bl2 = false;
            colorStateList = null;
        }
        return bl2;
    }

    public void onBoundsChanged() {
        Rect rect = this.collapsedBounds;
        int n10 = rect.width();
        if (n10 > 0 && (n10 = (rect = this.collapsedBounds).height()) > 0 && (n10 = (rect = this.expandedBounds).width()) > 0 && (n10 = (rect = this.expandedBounds).height()) > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            rect = null;
        }
        this.drawTitle = n10;
    }

    public void recalculate() {
        View view = this.view;
        int n10 = view.getHeight();
        if (n10 > 0 && (n10 = (view = this.view).getWidth()) > 0) {
            this.calculateBaseOffsets();
            this.calculateCurrentOffsets();
        }
    }

    public void setCollapsedBounds(int n10, int n11, int n12, int n13) {
        Rect rect = this.collapsedBounds;
        boolean bl2 = CollapsingTextHelper.rectEquals(rect, n10, n11, n12, n13);
        if (!bl2) {
            rect = this.collapsedBounds;
            rect.set(n10, n11, n12, n13);
            n10 = 1;
            this.boundsChanged = n10;
            this.onBoundsChanged();
        }
    }

    public void setCollapsedTextAppearance(int n10) {
        float f10;
        float f11;
        boolean bl2;
        int n11;
        Object object = this.view.getContext();
        Object object2 = R$styleable.TextAppearance;
        boolean n12 = ((TintTypedArray)(object = TintTypedArray.obtainStyledAttributes((Context)object, n10, object2))).hasValue(n11 = R$styleable.TextAppearance_android_textColor);
        if (n12) {
            object2 = ((TintTypedArray)object).getColorStateList(n11);
            this.collapsedTextColor = (ColorStateList)object2;
        }
        if (bl2 = ((TintTypedArray)object).hasValue(n11 = R$styleable.TextAppearance_android_textSize)) {
            f11 = this.collapsedTextSize;
            int n13 = (int)f11;
            n11 = ((TintTypedArray)object).getDimensionPixelSize(n11, n13);
            this.collapsedTextSize = f10 = (float)n11;
        }
        n11 = R$styleable.TextAppearance_android_shadowColor;
        this.collapsedShadowColor = n11 = ((TintTypedArray)object).getInt(n11, 0);
        n11 = R$styleable.TextAppearance_android_shadowDx;
        boolean bl3 = false;
        f11 = 0.0f;
        this.collapsedShadowDx = f10 = ((TintTypedArray)object).getFloat(n11, 0.0f);
        n11 = R$styleable.TextAppearance_android_shadowDy;
        this.collapsedShadowDy = f10 = ((TintTypedArray)object).getFloat(n11, 0.0f);
        n11 = R$styleable.TextAppearance_android_shadowRadius;
        this.collapsedShadowRadius = f10 = ((TintTypedArray)object).getFloat(n11, 0.0f);
        ((TintTypedArray)object).recycle();
        int n14 = Build.VERSION.SDK_INT;
        n11 = 16;
        f10 = 2.24E-44f;
        if (n14 >= n11) {
            Typeface typeface;
            this.collapsedTypeface = typeface = this.readFontFamilyTypeface(n10);
        }
        this.recalculate();
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        ColorStateList colorStateList2 = this.collapsedTextColor;
        if (colorStateList2 != colorStateList) {
            this.collapsedTextColor = colorStateList;
            this.recalculate();
        }
    }

    public void setCollapsedTextGravity(int n10) {
        int n11 = this.collapsedTextGravity;
        if (n11 != n10) {
            this.collapsedTextGravity = n10;
            this.recalculate();
        }
    }

    public void setCollapsedTextSize(float f10) {
        float f11 = this.collapsedTextSize;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.collapsedTextSize = f10;
            this.recalculate();
        }
    }

    public void setCollapsedTypeface(Typeface typeface) {
        Typeface typeface2 = this.collapsedTypeface;
        if (typeface2 != typeface) {
            this.collapsedTypeface = typeface;
            this.recalculate();
        }
    }

    public void setExpandedBounds(int n10, int n11, int n12, int n13) {
        Rect rect = this.expandedBounds;
        boolean bl2 = CollapsingTextHelper.rectEquals(rect, n10, n11, n12, n13);
        if (!bl2) {
            rect = this.expandedBounds;
            rect.set(n10, n11, n12, n13);
            n10 = 1;
            this.boundsChanged = n10;
            this.onBoundsChanged();
        }
    }

    public void setExpandedTextAppearance(int n10) {
        float f10;
        float f11;
        boolean bl2;
        int n11;
        Object object = this.view.getContext();
        Object object2 = R$styleable.TextAppearance;
        boolean n12 = ((TintTypedArray)(object = TintTypedArray.obtainStyledAttributes((Context)object, n10, object2))).hasValue(n11 = R$styleable.TextAppearance_android_textColor);
        if (n12) {
            object2 = ((TintTypedArray)object).getColorStateList(n11);
            this.expandedTextColor = (ColorStateList)object2;
        }
        if (bl2 = ((TintTypedArray)object).hasValue(n11 = R$styleable.TextAppearance_android_textSize)) {
            f11 = this.expandedTextSize;
            int n13 = (int)f11;
            n11 = ((TintTypedArray)object).getDimensionPixelSize(n11, n13);
            this.expandedTextSize = f10 = (float)n11;
        }
        n11 = R$styleable.TextAppearance_android_shadowColor;
        this.expandedShadowColor = n11 = ((TintTypedArray)object).getInt(n11, 0);
        n11 = R$styleable.TextAppearance_android_shadowDx;
        boolean bl3 = false;
        f11 = 0.0f;
        this.expandedShadowDx = f10 = ((TintTypedArray)object).getFloat(n11, 0.0f);
        n11 = R$styleable.TextAppearance_android_shadowDy;
        this.expandedShadowDy = f10 = ((TintTypedArray)object).getFloat(n11, 0.0f);
        n11 = R$styleable.TextAppearance_android_shadowRadius;
        this.expandedShadowRadius = f10 = ((TintTypedArray)object).getFloat(n11, 0.0f);
        ((TintTypedArray)object).recycle();
        int n14 = Build.VERSION.SDK_INT;
        n11 = 16;
        f10 = 2.24E-44f;
        if (n14 >= n11) {
            Typeface typeface;
            this.expandedTypeface = typeface = this.readFontFamilyTypeface(n10);
        }
        this.recalculate();
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        ColorStateList colorStateList2 = this.expandedTextColor;
        if (colorStateList2 != colorStateList) {
            this.expandedTextColor = colorStateList;
            this.recalculate();
        }
    }

    public void setExpandedTextGravity(int n10) {
        int n11 = this.expandedTextGravity;
        if (n11 != n10) {
            this.expandedTextGravity = n10;
            this.recalculate();
        }
    }

    public void setExpandedTextSize(float f10) {
        float f11 = this.expandedTextSize;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.expandedTextSize = f10;
            this.recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        Typeface typeface2 = this.expandedTypeface;
        if (typeface2 != typeface) {
            this.expandedTypeface = typeface;
            this.recalculate();
        }
    }

    public void setExpansionFraction(float f10) {
        float f11;
        float f12 = 1.0f;
        float f13 = (f10 = MathUtils.clamp(f10, 0.0f, f12)) - (f11 = this.expandedFraction);
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object != false) {
            this.expandedFraction = f10;
            this.calculateCurrentOffsets();
        }
    }

    public void setPositionInterpolator(TimeInterpolator timeInterpolator) {
        this.positionInterpolator = timeInterpolator;
        this.recalculate();
    }

    public final boolean setState(int[] nArray) {
        this.state = nArray;
        boolean bl2 = this.isStateful();
        if (bl2) {
            this.recalculate();
            return true;
        }
        return false;
    }

    public void setText(CharSequence charSequence) {
        CharSequence charSequence2;
        boolean bl2;
        if (charSequence == null || !(bl2 = charSequence.equals(charSequence2 = this.text))) {
            this.text = charSequence;
            charSequence = null;
            this.textToDraw = null;
            this.clearTexture();
            this.recalculate();
        }
    }

    public void setTextSizeInterpolator(TimeInterpolator timeInterpolator) {
        this.textSizeInterpolator = timeInterpolator;
        this.recalculate();
    }

    public void setTypefaces(Typeface typeface) {
        this.expandedTypeface = typeface;
        this.collapsedTypeface = typeface;
        this.recalculate();
    }
}

