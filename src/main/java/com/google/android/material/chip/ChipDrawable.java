/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$FontMetrics
 *  android.graphics.Paint$Style
 *  android.graphics.PointF
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.util.AttributeSet
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.text.BidiFormatter;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.chip.ChipDrawable$1;
import com.google.android.material.chip.ChipDrawable$Delegate;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ChipDrawable
extends Drawable
implements TintAwareDrawable,
Drawable.Callback {
    private static final boolean DEBUG = false;
    private static final int[] DEFAULT_STATE;
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    private int alpha;
    private boolean checkable;
    private Drawable checkedIcon;
    private boolean checkedIconVisible;
    private ColorStateList chipBackgroundColor;
    private float chipCornerRadius;
    private float chipEndPadding;
    private Drawable chipIcon;
    private float chipIconSize;
    private ColorStateList chipIconTint;
    private boolean chipIconVisible;
    private float chipMinHeight;
    private final Paint chipPaint;
    private float chipStartPadding;
    private ColorStateList chipStrokeColor;
    private float chipStrokeWidth;
    private Drawable closeIcon;
    private CharSequence closeIconContentDescription;
    private float closeIconEndPadding;
    private float closeIconSize;
    private float closeIconStartPadding;
    private int[] closeIconStateSet;
    private ColorStateList closeIconTint;
    private boolean closeIconVisible;
    private ColorFilter colorFilter;
    private ColorStateList compatRippleColor;
    private final Context context;
    private boolean currentChecked;
    private int currentChipBackgroundColor;
    private int currentChipStrokeColor;
    private int currentCompatRippleColor;
    private int currentTextColor;
    private int currentTint;
    private final Paint debugPaint;
    private WeakReference delegate;
    private final ResourcesCompat$FontCallback fontCallback;
    private final Paint.FontMetrics fontMetrics;
    private MotionSpec hideMotionSpec;
    private float iconEndPadding;
    private float iconStartPadding;
    private int maxWidth;
    private final PointF pointF;
    private CharSequence rawText;
    private final RectF rectF;
    private ColorStateList rippleColor;
    private boolean shouldDrawText;
    private MotionSpec showMotionSpec;
    private TextAppearance textAppearance;
    private float textEndPadding;
    private final TextPaint textPaint;
    private float textStartPadding;
    private float textWidth;
    private boolean textWidthDirty;
    private ColorStateList tint;
    private PorterDuffColorFilter tintFilter;
    private PorterDuff.Mode tintMode;
    private TextUtils.TruncateAt truncateAt;
    private CharSequence unicodeWrappedText;
    private boolean useCompatRipple;

    static {
        int[] nArray = new int[]{16842910};
        DEFAULT_STATE = nArray;
    }

    private ChipDrawable(Context object) {
        float f10;
        Object object2;
        ChipDrawable$1 chipDrawable$1 = new ChipDrawable$1(this);
        this.fontCallback = chipDrawable$1;
        int n10 = 1;
        super(n10);
        this.textPaint = chipDrawable$1;
        this.chipPaint = object2 = new Paint(n10);
        super();
        this.fontMetrics = object2;
        super();
        this.rectF = object2;
        super();
        this.pointF = object2;
        this.alpha = 255;
        object2 = PorterDuff.Mode.SRC_IN;
        this.tintMode = object2;
        super(null);
        this.delegate = object2;
        this.textWidthDirty = n10;
        this.context = object;
        this.rawText = "";
        ((TextPaint)chipDrawable$1).density = f10 = object.getResources().getDisplayMetrics().density;
        this.debugPaint = null;
        object = DEFAULT_STATE;
        this.setState((int[])object);
        this.setCloseIconState((int[])object);
        this.shouldDrawText = n10;
    }

    public static /* synthetic */ boolean access$002(ChipDrawable chipDrawable, boolean bl2) {
        chipDrawable.textWidthDirty = bl2;
        return bl2;
    }

    private void applyChildDrawable(Drawable drawable2) {
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback)this);
            int bl2 = DrawableCompat.getLayoutDirection(this);
            DrawableCompat.setLayoutDirection(drawable2, bl2);
            int n10 = this.getLevel();
            drawable2.setLevel(n10);
            boolean bl3 = this.isVisible();
            drawable2.setVisible(bl3, false);
            Object object = this.closeIcon;
            if (drawable2 == object) {
                boolean bl4 = drawable2.isStateful();
                if (bl4) {
                    object = this.getCloseIconState();
                    drawable2.setState((int[])object);
                }
                object = this.closeIconTint;
                DrawableCompat.setTintList(drawable2, (ColorStateList)object);
            } else {
                boolean bl5 = drawable2.isStateful();
                if (bl5) {
                    object = this.getState();
                    drawable2.setState((int[])object);
                }
            }
        }
    }

    private void calculateChipIconBounds(Rect rect, RectF rectF) {
        rectF.setEmpty();
        boolean bl2 = this.showsChipIcon();
        if (bl2 || (bl2 = this.showsCheckedIcon())) {
            float f10 = this.chipStartPadding;
            float f11 = this.iconStartPadding;
            f10 += f11;
            int n10 = DrawableCompat.getLayoutDirection(this);
            if (n10 == 0) {
                n10 = rect.left;
                rectF.left = f11 = (float)n10 + f10;
                f10 = this.chipIconSize;
                rectF.right = f11 += f10;
            } else {
                n10 = rect.right;
                rectF.right = f11 = (float)n10 - f10;
                f10 = this.chipIconSize;
                rectF.left = f11 -= f10;
            }
            float f12 = rect.exactCenterY();
            f10 = this.chipIconSize;
            n10 = 0x40000000;
            f11 = f10 / 2.0f;
            rectF.top = f12 -= f11;
            rectF.bottom = f12 += f10;
        }
    }

    private void calculateChipTouchBounds(Rect rect, RectF rectF) {
        rectF.set(rect);
        boolean bl2 = this.showsCloseIcon();
        if (bl2) {
            float f10 = this.chipEndPadding;
            float f11 = this.closeIconEndPadding;
            f10 += f11;
            f11 = this.closeIconSize;
            f10 += f11;
            f11 = this.closeIconStartPadding;
            f10 += f11;
            f11 = this.textEndPadding;
            f10 += f11;
            int n10 = DrawableCompat.getLayoutDirection(this);
            if (n10 == 0) {
                float f12;
                int n11 = rect.right;
                rectF.right = f12 = (float)n11 - f10;
            } else {
                float f13;
                int n12 = rect.left;
                rectF.left = f13 = (float)n12 + f10;
            }
        }
    }

    private void calculateCloseIconBounds(Rect rect, RectF rectF) {
        rectF.setEmpty();
        boolean bl2 = this.showsCloseIcon();
        if (bl2) {
            float f10 = this.chipEndPadding;
            float f11 = this.closeIconEndPadding;
            f10 += f11;
            int n10 = DrawableCompat.getLayoutDirection(this);
            if (n10 == 0) {
                n10 = rect.right;
                rectF.right = f11 = (float)n10 - f10;
                f10 = this.closeIconSize;
                rectF.left = f11 -= f10;
            } else {
                n10 = rect.left;
                rectF.left = f11 = (float)n10 + f10;
                f10 = this.closeIconSize;
                rectF.right = f11 += f10;
            }
            float f12 = rect.exactCenterY();
            f10 = this.closeIconSize;
            n10 = 0x40000000;
            f11 = f10 / 2.0f;
            rectF.top = f12 -= f11;
            rectF.bottom = f12 += f10;
        }
    }

    private void calculateCloseIconTouchBounds(Rect rect, RectF rectF) {
        rectF.setEmpty();
        int n10 = this.showsCloseIcon();
        if (n10 != 0) {
            float f10;
            float f11 = this.chipEndPadding;
            float f12 = this.closeIconEndPadding;
            f11 += f12;
            f12 = this.closeIconSize;
            f11 += f12;
            f12 = this.closeIconStartPadding;
            f11 += f12;
            f12 = this.textEndPadding;
            f11 += f12;
            int n11 = DrawableCompat.getLayoutDirection(this);
            if (n11 == 0) {
                n11 = rect.right;
                rectF.right = f12 = (float)n11;
                rectF.left = f12 -= f11;
            } else {
                float f13;
                n11 = rect.left;
                rectF.left = f13 = (float)n11;
                rectF.right = f12 = (float)n11 + f11;
            }
            n10 = rect.top;
            rectF.top = f11 = (float)n10;
            int n12 = rect.bottom;
            rectF.bottom = f10 = (float)n12;
        }
    }

    private float calculateCloseIconWidth() {
        boolean bl2 = this.showsCloseIcon();
        if (bl2) {
            float f10 = this.closeIconStartPadding;
            float f11 = this.closeIconSize;
            f10 += f11;
            f11 = this.closeIconEndPadding;
            return f10 + f11;
        }
        return 0.0f;
    }

    private void calculateTextBounds(Rect rect, RectF rectF) {
        rectF.setEmpty();
        CharSequence charSequence = this.unicodeWrappedText;
        if (charSequence != null) {
            float f10;
            int n10;
            float f11 = this.chipStartPadding;
            float f12 = this.calculateChipIconWidth();
            f11 += f12;
            f12 = this.textStartPadding;
            f11 += f12;
            f12 = this.chipEndPadding;
            float f13 = this.calculateCloseIconWidth();
            f12 += f13;
            f13 = this.textEndPadding;
            f12 += f13;
            int n11 = DrawableCompat.getLayoutDirection(this);
            if (n11 == 0) {
                n11 = rect.left;
                rectF.left = f13 = (float)n11 + f11;
                n10 = rect.right;
                rectF.right = f11 = (float)n10 - f12;
            } else {
                n11 = rect.left;
                rectF.left = f13 = (float)n11 + f12;
                int n12 = rect.right;
                rectF.right = f12 = (float)n12 - f11;
            }
            n10 = rect.top;
            rectF.top = f11 = (float)n10;
            int n13 = rect.bottom;
            rectF.bottom = f10 = (float)n13;
        }
    }

    private float calculateTextCenterFromBaseline() {
        TextPaint textPaint = this.textPaint;
        Paint.FontMetrics fontMetrics = this.fontMetrics;
        textPaint.getFontMetrics(fontMetrics);
        textPaint = this.fontMetrics;
        float f10 = textPaint.descent;
        float f11 = textPaint.ascent;
        return (f10 + f11) / 2.0f;
    }

    private float calculateTextWidth(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        TextPaint textPaint = this.textPaint;
        int n10 = charSequence.length();
        return textPaint.measureText(charSequence, 0, n10);
    }

    private boolean canShowCheckedIcon() {
        Drawable drawable2;
        boolean bl2 = this.checkedIconVisible;
        if (bl2 && (drawable2 = this.checkedIcon) != null && (bl2 = this.checkable)) {
            bl2 = true;
        } else {
            bl2 = false;
            drawable2 = null;
        }
        return bl2;
    }

    public static ChipDrawable createFromAttributes(Context context, AttributeSet attributeSet, int n10, int n11) {
        ChipDrawable chipDrawable = new ChipDrawable(context);
        chipDrawable.loadFromAttributes(attributeSet, n10, n11);
        return chipDrawable;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ChipDrawable createFromResource(Context object, int n10) {
        void var0_3;
        try {
            String string2;
            int n11;
            int n12;
            int n13;
            Object object2 = object.getResources();
            object2 = object2.getXml(n10);
            while ((n13 = object2.next()) != (n12 = 2) && n13 != (n11 = 1)) {
            }
            if (n13 != n12) {
                object2 = "No start tag found";
                object = new XmlPullParserException((String)object2);
                throw object;
            }
            String string3 = object2.getName();
            n13 = (int)(TextUtils.equals((CharSequence)string3, (CharSequence)(string2 = "chip")) ? 1 : 0);
            if (n13 == 0) {
                object2 = "Must have a <chip> start tag";
                object = new XmlPullParserException((String)object2);
                throw object;
            }
            n13 = (object2 = Xml.asAttributeSet((XmlPullParser)object2)).getStyleAttribute();
            if (n13 == 0) {
                n13 = R$style.Widget_MaterialComponents_Chip_Entry;
            }
            n12 = R$attr.chipStandaloneStyle;
            return ChipDrawable.createFromAttributes(object, (AttributeSet)object2, n12, n13);
        }
        catch (IOException iOException) {
        }
        catch (XmlPullParserException xmlPullParserException) {
            // empty catch block
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't load chip resource ID #0x");
        String string4 = Integer.toHexString(n10);
        stringBuilder.append(string4);
        string4 = stringBuilder.toString();
        Resources.NotFoundException notFoundException = new Resources.NotFoundException(string4);
        notFoundException.initCause((Throwable)var0_3);
        throw notFoundException;
    }

    private void drawCheckedIcon(Canvas canvas, Rect rect) {
        boolean bl2 = this.showsCheckedIcon();
        if (bl2) {
            RectF rectF = this.rectF;
            this.calculateChipIconBounds(rect, rectF);
            rect = this.rectF;
            float f10 = rect.left;
            float f11 = rect.top;
            canvas.translate(f10, f11);
            Drawable drawable2 = this.checkedIcon;
            RectF rectF2 = this.rectF;
            float f12 = rectF2.width();
            int n10 = (int)f12;
            RectF rectF3 = this.rectF;
            float f13 = rectF3.height();
            int n11 = (int)f13;
            drawable2.setBounds(0, 0, n10, n11);
            drawable2 = this.checkedIcon;
            drawable2.draw(canvas);
            f10 = -f10;
            f11 = -f11;
            canvas.translate(f10, f11);
        }
    }

    private void drawChipBackground(Canvas canvas, Rect rect) {
        Paint paint = this.chipPaint;
        int n10 = this.currentChipBackgroundColor;
        paint.setColor(n10);
        paint = this.chipPaint;
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        paint = this.chipPaint;
        style2 = this.getTintColorFilter();
        paint.setColorFilter((ColorFilter)style2);
        this.rectF.set(rect);
        rect = this.rectF;
        float f10 = this.chipCornerRadius;
        style2 = this.chipPaint;
        canvas.drawRoundRect((RectF)rect, f10, f10, (Paint)style2);
    }

    private void drawChipIcon(Canvas canvas, Rect rect) {
        boolean bl2 = this.showsChipIcon();
        if (bl2) {
            RectF rectF = this.rectF;
            this.calculateChipIconBounds(rect, rectF);
            rect = this.rectF;
            float f10 = rect.left;
            float f11 = rect.top;
            canvas.translate(f10, f11);
            Drawable drawable2 = this.chipIcon;
            RectF rectF2 = this.rectF;
            float f12 = rectF2.width();
            int n10 = (int)f12;
            RectF rectF3 = this.rectF;
            float f13 = rectF3.height();
            int n11 = (int)f13;
            drawable2.setBounds(0, 0, n10, n11);
            drawable2 = this.chipIcon;
            drawable2.draw(canvas);
            f10 = -f10;
            f11 = -f11;
            canvas.translate(f10, f11);
        }
    }

    private void drawChipStroke(Canvas canvas, Rect rect) {
        float f10 = this.chipStrokeWidth;
        int n10 = 0;
        float f11 = 0.0f;
        Paint.Style style2 = null;
        float f12 = f10 - 0.0f;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object > 0) {
            Paint paint = this.chipPaint;
            n10 = this.currentChipStrokeColor;
            paint.setColor(n10);
            paint = this.chipPaint;
            style2 = Paint.Style.STROKE;
            paint.setStyle(style2);
            paint = this.chipPaint;
            style2 = this.getTintColorFilter();
            paint.setColorFilter((ColorFilter)style2);
            paint = this.rectF;
            n10 = rect.left;
            f11 = n10;
            float f13 = this.chipStrokeWidth;
            float f14 = 2.0f;
            float f15 = f13 / f14;
            f11 += f15;
            int n11 = rect.top;
            f15 = n11;
            float f16 = f13 / f14;
            f15 += f16;
            int n12 = rect.right;
            f16 = n12;
            float f17 = f13 / f14;
            int n13 = rect.bottom;
            float f18 = n13;
            paint.set(f11, f15, f16 -= f17, f18 -= (f13 /= f14));
            f18 = this.chipCornerRadius;
            f10 = this.chipStrokeWidth / f14;
            paint = this.rectF;
            style2 = this.chipPaint;
            canvas.drawRoundRect((RectF)paint, f18 -= f10, f18, (Paint)style2);
        }
    }

    private void drawCloseIcon(Canvas canvas, Rect rect) {
        boolean bl2 = this.showsCloseIcon();
        if (bl2) {
            RectF rectF = this.rectF;
            this.calculateCloseIconBounds(rect, rectF);
            rect = this.rectF;
            float f10 = rect.left;
            float f11 = rect.top;
            canvas.translate(f10, f11);
            Drawable drawable2 = this.closeIcon;
            RectF rectF2 = this.rectF;
            float f12 = rectF2.width();
            int n10 = (int)f12;
            RectF rectF3 = this.rectF;
            float f13 = rectF3.height();
            int n11 = (int)f13;
            drawable2.setBounds(0, 0, n10, n11);
            drawable2 = this.closeIcon;
            drawable2.draw(canvas);
            f10 = -f10;
            f11 = -f11;
            canvas.translate(f10, f11);
        }
    }

    private void drawCompatRipple(Canvas canvas, Rect rect) {
        Paint paint = this.chipPaint;
        int n10 = this.currentCompatRippleColor;
        paint.setColor(n10);
        paint = this.chipPaint;
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        this.rectF.set(rect);
        rect = this.rectF;
        float f10 = this.chipCornerRadius;
        style2 = this.chipPaint;
        canvas.drawRoundRect((RectF)rect, f10, f10, (Paint)style2);
    }

    private void drawDebug(Canvas canvas, Rect rect) {
        Object object = this.debugPaint;
        if (object != null) {
            Paint paint;
            int n10 = 127;
            int n11 = ColorUtils.setAlphaComponent(-16777216, n10);
            object.setColor(n11);
            object = this.debugPaint;
            canvas.drawRect(rect, object);
            int n12 = this.showsChipIcon();
            if (n12 != 0 || (n12 = this.showsCheckedIcon()) != 0) {
                object = this.rectF;
                this.calculateChipIconBounds(rect, (RectF)object);
                object = this.rectF;
                paint = this.debugPaint;
                canvas.drawRect((RectF)object, paint);
            }
            if ((object = this.unicodeWrappedText) != null) {
                float f10 = rect.left;
                float f11 = rect.exactCenterY();
                n12 = rect.right;
                float f12 = n12;
                float f13 = rect.exactCenterY();
                Paint paint2 = this.debugPaint;
                canvas.drawLine(f10, f11, f12, f13, paint2);
            }
            if ((n12 = this.showsCloseIcon()) != 0) {
                object = this.rectF;
                this.calculateCloseIconBounds(rect, (RectF)object);
                object = this.rectF;
                paint = this.debugPaint;
                canvas.drawRect((RectF)object, paint);
            }
            object = this.debugPaint;
            n11 = ColorUtils.setAlphaComponent(-65536, n10);
            object.setColor(n11);
            object = this.rectF;
            this.calculateChipTouchBounds(rect, (RectF)object);
            object = this.rectF;
            paint = this.debugPaint;
            canvas.drawRect((RectF)object, paint);
            object = this.debugPaint;
            n11 = ColorUtils.setAlphaComponent(-16711936, n10);
            object.setColor(n11);
            object = this.rectF;
            this.calculateCloseIconTouchBounds(rect, (RectF)object);
            rect = this.rectF;
            object = this.debugPaint;
            canvas.drawRect((RectF)rect, object);
        }
    }

    private void drawText(Canvas canvas, Rect object) {
        CharSequence charSequence = this.unicodeWrappedText;
        if (charSequence != null) {
            TextUtils.TruncateAt truncateAt;
            Object object2;
            TextPaint textPaint;
            charSequence = this.pointF;
            charSequence = this.calculateTextOriginAndAlignment((Rect)object, (PointF)charSequence);
            Object object3 = this.rectF;
            this.calculateTextBounds((Rect)object, (RectF)object3);
            object = this.textAppearance;
            if (object != null) {
                object = this.textPaint;
                object3 = this.getState();
                ((TextPaint)object).drawableState = (int[])object3;
                object = this.textAppearance;
                object3 = this.context;
                textPaint = this.textPaint;
                object2 = this.fontCallback;
                ((TextAppearance)object).updateDrawState((Context)object3, textPaint, (ResourcesCompat$FontCallback)object2);
            }
            object = this.textPaint;
            object.setTextAlign((Paint.Align)charSequence);
            float f10 = this.getTextWidth();
            int n10 = Math.round(f10);
            charSequence = this.rectF;
            float f11 = charSequence.width();
            int n11 = Math.round(f11);
            int n12 = 0;
            object3 = null;
            if (n10 > n11) {
                n10 = 1;
                f10 = Float.MIN_VALUE;
            } else {
                n10 = 0;
                object = null;
                f10 = 0.0f;
            }
            if (n10 != 0) {
                n12 = canvas.save();
                charSequence = this.rectF;
                canvas.clipRect((RectF)charSequence);
            }
            charSequence = this.unicodeWrappedText;
            if (n10 != 0 && (textPaint = this.truncateAt) != null) {
                textPaint = this.textPaint;
                object2 = this.rectF;
                float f12 = object2.width();
                truncateAt = this.truncateAt;
                charSequence = TextUtils.ellipsize((CharSequence)charSequence, (TextPaint)textPaint, (float)f12, (TextUtils.TruncateAt)truncateAt);
            }
            object2 = charSequence;
            truncateAt = null;
            int n13 = charSequence.length();
            charSequence = this.pointF;
            float f13 = ((PointF)charSequence).x;
            float f14 = ((PointF)charSequence).y;
            TextPaint textPaint2 = this.textPaint;
            textPaint = canvas;
            canvas.drawText((CharSequence)object2, 0, n13, f13, f14, (Paint)textPaint2);
            if (n10 != 0) {
                canvas.restoreToCount(n12);
            }
        }
    }

    private float getTextWidth() {
        float f10;
        boolean bl2 = this.textWidthDirty;
        if (!bl2) {
            return this.textWidth;
        }
        CharSequence charSequence = this.unicodeWrappedText;
        this.textWidth = f10 = this.calculateTextWidth(charSequence);
        this.textWidthDirty = false;
        return f10;
    }

    private ColorFilter getTintColorFilter() {
        ColorFilter colorFilter = this.colorFilter;
        if (colorFilter == null) {
            colorFilter = this.tintFilter;
        }
        return colorFilter;
    }

    private static boolean hasState(int[] nArray, int n10) {
        if (nArray == null) {
            return false;
        }
        for (int n11 : nArray) {
            if (n11 != n10) continue;
            return true;
        }
        return false;
    }

    private static boolean isStateful(ColorStateList colorStateList) {
        boolean bl2;
        if (colorStateList != null && (bl2 = colorStateList.isStateful())) {
            bl2 = true;
        } else {
            bl2 = false;
            colorStateList = null;
        }
        return bl2;
    }

    private static boolean isStateful(Drawable drawable2) {
        boolean bl2;
        if (drawable2 != null && (bl2 = drawable2.isStateful())) {
            bl2 = true;
        } else {
            bl2 = false;
            drawable2 = null;
        }
        return bl2;
    }

    private static boolean isStateful(TextAppearance textAppearance) {
        boolean bl2;
        if (textAppearance != null && (textAppearance = textAppearance.textColor) != null && (bl2 = textAppearance.isStateful())) {
            bl2 = true;
        } else {
            bl2 = false;
            textAppearance = null;
        }
        return bl2;
    }

    private void loadFromAttributes(AttributeSet object, int n10, int n11) {
        int n12;
        Context context = this.context;
        int[] nArray = R$styleable.Chip;
        int[] nArray2 = new int[]{};
        Object object2 = object;
        TypedArray typedArray = ThemeEnforcement.obtainStyledAttributes(context, object, nArray, n10, n11, nArray2);
        Object object3 = this.context;
        int n13 = R$styleable.Chip_chipBackgroundColor;
        object3 = MaterialResources.getColorStateList(object3, typedArray, n13);
        this.setChipBackgroundColor((ColorStateList)object3);
        n11 = R$styleable.Chip_chipMinHeight;
        n13 = 0;
        context = null;
        float f10 = typedArray.getDimension(n11, 0.0f);
        this.setChipMinHeight(f10);
        n11 = R$styleable.Chip_chipCornerRadius;
        f10 = typedArray.getDimension(n11, 0.0f);
        this.setChipCornerRadius(f10);
        object3 = this.context;
        int n14 = R$styleable.Chip_chipStrokeColor;
        object3 = MaterialResources.getColorStateList(object3, typedArray, n14);
        this.setChipStrokeColor((ColorStateList)object3);
        n11 = R$styleable.Chip_chipStrokeWidth;
        f10 = typedArray.getDimension(n11, 0.0f);
        this.setChipStrokeWidth(f10);
        object3 = this.context;
        n14 = R$styleable.Chip_rippleColor;
        object3 = MaterialResources.getColorStateList(object3, typedArray, n14);
        this.setRippleColor((ColorStateList)object3);
        n11 = R$styleable.Chip_android_text;
        object3 = typedArray.getText(n11);
        this.setText((CharSequence)object3);
        object3 = this.context;
        n14 = R$styleable.Chip_android_textAppearance;
        object3 = MaterialResources.getTextAppearance(object3, typedArray, n14);
        this.setTextAppearance((TextAppearance)object3);
        n11 = R$styleable.Chip_android_ellipsize;
        n11 = typedArray.getInt(n11, 0);
        n14 = 1;
        float f11 = Float.MIN_VALUE;
        if (n11 != n14) {
            n14 = 2;
            f11 = 2.8E-45f;
            if (n11 != n14) {
                n14 = 3;
                f11 = 4.2E-45f;
                if (n11 == n14) {
                    object3 = TextUtils.TruncateAt.END;
                    this.setEllipsize((TextUtils.TruncateAt)object3);
                }
            } else {
                object3 = TextUtils.TruncateAt.MIDDLE;
                this.setEllipsize((TextUtils.TruncateAt)object3);
            }
        } else {
            object3 = TextUtils.TruncateAt.START;
            this.setEllipsize((TextUtils.TruncateAt)object3);
        }
        n11 = R$styleable.Chip_chipIconVisible;
        n11 = (int)(typedArray.getBoolean(n11, false) ? 1 : 0);
        this.setChipIconVisible(n11 != 0);
        object3 = NAMESPACE_APP;
        if (object != null && (object2 = object.getAttributeValue((String)object3, "chipIconEnabled")) != null && (object2 = object.getAttributeValue((String)object3, "chipIconVisible")) == null) {
            n14 = R$styleable.Chip_chipIconEnabled;
            n14 = (int)(typedArray.getBoolean(n14, false) ? 1 : 0);
            this.setChipIconVisible(n14 != 0);
        }
        object2 = this.context;
        int n15 = R$styleable.Chip_chipIcon;
        object2 = MaterialResources.getDrawable((Context)object2, typedArray, n15);
        this.setChipIcon((Drawable)object2);
        object2 = this.context;
        n15 = R$styleable.Chip_chipIconTint;
        object2 = MaterialResources.getColorStateList((Context)object2, typedArray, n15);
        this.setChipIconTint((ColorStateList)object2);
        n14 = R$styleable.Chip_chipIconSize;
        f11 = typedArray.getDimension(n14, 0.0f);
        this.setChipIconSize(f11);
        n14 = R$styleable.Chip_closeIconVisible;
        n14 = (int)(typedArray.getBoolean(n14, false) ? 1 : 0);
        this.setCloseIconVisible(n14 != 0);
        if (object != null && (object2 = object.getAttributeValue((String)object3, "closeIconEnabled")) != null && (object2 = object.getAttributeValue((String)object3, "closeIconVisible")) == null) {
            n14 = R$styleable.Chip_closeIconEnabled;
            n14 = (int)(typedArray.getBoolean(n14, false) ? 1 : 0);
            this.setCloseIconVisible(n14 != 0);
        }
        object2 = this.context;
        n15 = R$styleable.Chip_closeIcon;
        object2 = MaterialResources.getDrawable((Context)object2, typedArray, n15);
        this.setCloseIcon((Drawable)object2);
        object2 = this.context;
        n15 = R$styleable.Chip_closeIconTint;
        object2 = MaterialResources.getColorStateList((Context)object2, typedArray, n15);
        this.setCloseIconTint((ColorStateList)object2);
        n14 = R$styleable.Chip_closeIconSize;
        f11 = typedArray.getDimension(n14, 0.0f);
        this.setCloseIconSize(f11);
        n14 = R$styleable.Chip_android_checkable;
        n14 = (int)(typedArray.getBoolean(n14, false) ? 1 : 0);
        this.setCheckable(n14 != 0);
        n14 = R$styleable.Chip_checkedIconVisible;
        n14 = (int)(typedArray.getBoolean(n14, false) ? 1 : 0);
        this.setCheckedIconVisible(n14 != 0);
        if (object != null && (object2 = object.getAttributeValue((String)object3, "checkedIconEnabled")) != null && (object = object.getAttributeValue((String)object3, (String)(object2 = "checkedIconVisible"))) == null) {
            n12 = R$styleable.Chip_checkedIconEnabled;
            n12 = (int)(typedArray.getBoolean(n12, false) ? 1 : 0);
            this.setCheckedIconVisible(n12 != 0);
        }
        object = this.context;
        n11 = R$styleable.Chip_checkedIcon;
        object = MaterialResources.getDrawable((Context)object, typedArray, n11);
        this.setCheckedIcon((Drawable)object);
        object = this.context;
        n11 = R$styleable.Chip_showMotionSpec;
        object = MotionSpec.createFromAttribute((Context)object, typedArray, n11);
        this.setShowMotionSpec((MotionSpec)object);
        object = this.context;
        n11 = R$styleable.Chip_hideMotionSpec;
        object = MotionSpec.createFromAttribute((Context)object, typedArray, n11);
        this.setHideMotionSpec((MotionSpec)object);
        n12 = R$styleable.Chip_chipStartPadding;
        float f12 = typedArray.getDimension(n12, 0.0f);
        this.setChipStartPadding(f12);
        n12 = R$styleable.Chip_iconStartPadding;
        f12 = typedArray.getDimension(n12, 0.0f);
        this.setIconStartPadding(f12);
        n12 = R$styleable.Chip_iconEndPadding;
        f12 = typedArray.getDimension(n12, 0.0f);
        this.setIconEndPadding(f12);
        n12 = R$styleable.Chip_textStartPadding;
        f12 = typedArray.getDimension(n12, 0.0f);
        this.setTextStartPadding(f12);
        n12 = R$styleable.Chip_textEndPadding;
        f12 = typedArray.getDimension(n12, 0.0f);
        this.setTextEndPadding(f12);
        n12 = R$styleable.Chip_closeIconStartPadding;
        f12 = typedArray.getDimension(n12, 0.0f);
        this.setCloseIconStartPadding(f12);
        n12 = R$styleable.Chip_closeIconEndPadding;
        f12 = typedArray.getDimension(n12, 0.0f);
        this.setCloseIconEndPadding(f12);
        n12 = R$styleable.Chip_chipEndPadding;
        f12 = typedArray.getDimension(n12, 0.0f);
        this.setChipEndPadding(f12);
        n12 = R$styleable.Chip_android_maxWidth;
        n12 = typedArray.getDimensionPixelSize(n12, -1 >>> 1);
        this.setMaxWidth(n12);
        typedArray.recycle();
    }

    private boolean onStateChange(int[] object, int[] nArray) {
        boolean bl2;
        Drawable drawable2;
        Drawable drawable3;
        float f10;
        float f11;
        int n10;
        int n11;
        Object object2 = super.onStateChange(object);
        Object object3 = this.chipBackgroundColor;
        int n12 = 0;
        PorterDuff.Mode mode = null;
        if (object3 != null) {
            n11 = this.currentChipBackgroundColor;
            n10 = object3.getColorForState(object, n11);
        } else {
            n10 = 0;
            object3 = null;
            f11 = 0.0f;
        }
        n11 = this.currentChipBackgroundColor;
        boolean bl3 = true;
        float f12 = Float.MIN_VALUE;
        if (n11 != n10) {
            this.currentChipBackgroundColor = n10;
            object2 = bl3;
            f10 = f12;
        }
        if ((object3 = this.chipStrokeColor) != null) {
            n11 = this.currentChipStrokeColor;
            n10 = object3.getColorForState(object, n11);
        } else {
            n10 = 0;
            object3 = null;
            f11 = 0.0f;
        }
        n11 = this.currentChipStrokeColor;
        if (n11 != n10) {
            this.currentChipStrokeColor = n10;
            object2 = bl3;
            f10 = f12;
        }
        if ((object3 = this.compatRippleColor) != null) {
            n11 = this.currentCompatRippleColor;
            n10 = object3.getColorForState(object, n11);
        } else {
            n10 = 0;
            object3 = null;
            f11 = 0.0f;
        }
        n11 = this.currentCompatRippleColor;
        if (n11 != n10) {
            this.currentCompatRippleColor = n10;
            n10 = (int)(this.useCompatRipple ? 1 : 0);
            if (n10 != 0) {
                object2 = bl3;
                f10 = f12;
            }
        }
        if ((object3 = this.textAppearance) != null && (object3 = object3.textColor) != null) {
            n11 = this.currentTextColor;
            n10 = object3.getColorForState(object, n11);
        } else {
            n10 = 0;
            object3 = null;
            f11 = 0.0f;
        }
        n11 = this.currentTextColor;
        if (n11 != n10) {
            this.currentTextColor = n10;
            object2 = bl3;
            f10 = f12;
        }
        if ((n10 = (int)(ChipDrawable.hasState((int[])(object3 = (Object)this.getState()), n11 = 0x10100A0) ? 1 : 0)) != 0 && (n10 = (int)(this.checkable ? 1 : 0)) != 0) {
            n10 = (int)(bl3 ? 1 : 0);
            f11 = f12;
        } else {
            n10 = 0;
            object3 = null;
            f11 = 0.0f;
        }
        n11 = (int)(this.currentChecked ? 1 : 0);
        if (n11 != n10 && (drawable3 = this.checkedIcon) != null) {
            f10 = this.calculateChipIconWidth();
            this.currentChecked = n10;
            f11 = this.calculateChipIconWidth();
            float f13 = f10 - f11;
            object2 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
            if (object2) {
                object2 = bl3;
                f10 = f12;
                n10 = (int)(bl3 ? 1 : 0);
                f11 = f12;
            } else {
                n10 = 0;
                object3 = null;
                f11 = 0.0f;
                object2 = bl3;
                f10 = f12;
            }
        } else {
            n10 = 0;
            object3 = null;
            f11 = 0.0f;
        }
        drawable3 = this.tint;
        if (drawable3 != null) {
            n12 = this.currentTint;
            n12 = drawable3.getColorForState(object, n12);
        }
        if ((n11 = this.currentTint) != n12) {
            this.currentTint = n12;
            drawable2 = this.tint;
            mode = this.tintMode;
            drawable2 = DrawableUtils.updateTintFilter(this, (ColorStateList)drawable2, mode);
            this.tintFilter = drawable2;
        } else {
            bl3 = object2;
        }
        drawable2 = this.chipIcon;
        object2 = ChipDrawable.isStateful(drawable2);
        if (object2) {
            drawable2 = this.chipIcon;
            object2 = drawable2.setState(object);
            bl3 |= object2;
        }
        if (object2 = ChipDrawable.isStateful(drawable2 = this.checkedIcon)) {
            drawable2 = this.checkedIcon;
            bl2 = drawable2.setState(object);
            bl3 |= bl2;
        }
        if (bl2 = ChipDrawable.isStateful((Drawable)(object = (Object)this.closeIcon))) {
            object = this.closeIcon;
            bl2 = object.setState(nArray);
            bl3 |= bl2;
        }
        if (bl3) {
            this.invalidateSelf();
        }
        if (n10 != 0) {
            this.onSizeChange();
        }
        return bl3;
    }

    private boolean showsCheckedIcon() {
        Drawable drawable2;
        boolean bl2 = this.checkedIconVisible;
        if (bl2 && (drawable2 = this.checkedIcon) != null && (bl2 = this.currentChecked)) {
            bl2 = true;
        } else {
            bl2 = false;
            drawable2 = null;
        }
        return bl2;
    }

    private boolean showsChipIcon() {
        Drawable drawable2;
        boolean bl2 = this.chipIconVisible;
        if (bl2 && (drawable2 = this.chipIcon) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            drawable2 = null;
        }
        return bl2;
    }

    private boolean showsCloseIcon() {
        Drawable drawable2;
        boolean bl2 = this.closeIconVisible;
        if (bl2 && (drawable2 = this.closeIcon) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            drawable2 = null;
        }
        return bl2;
    }

    private void unapplyChildDrawable(Drawable drawable2) {
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
    }

    private void updateCompatRippleColor() {
        ColorStateList colorStateList;
        boolean bl2 = this.useCompatRipple;
        if (bl2) {
            colorStateList = RippleUtils.convertToRippleDrawableColor(this.rippleColor);
        } else {
            bl2 = false;
            colorStateList = null;
        }
        this.compatRippleColor = colorStateList;
    }

    public float calculateChipIconWidth() {
        boolean bl2 = this.showsChipIcon();
        if (!bl2 && !(bl2 = this.showsCheckedIcon())) {
            return 0.0f;
        }
        float f10 = this.iconStartPadding;
        float f11 = this.chipIconSize;
        f10 += f11;
        f11 = this.iconEndPadding;
        return f10 + f11;
    }

    public Paint.Align calculateTextOriginAndAlignment(Rect rect, PointF pointF) {
        float f10 = 0.0f;
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        CharSequence charSequence = this.unicodeWrappedText;
        if (charSequence != null) {
            f10 = this.chipStartPadding;
            float f11 = this.calculateChipIconWidth();
            f10 += f11;
            f11 = this.textStartPadding;
            f10 += f11;
            int n10 = DrawableCompat.getLayoutDirection(this);
            if (n10 == 0) {
                n10 = rect.left;
                pointF.x = f11 = (float)n10 + f10;
                align = Paint.Align.LEFT;
            } else {
                n10 = rect.right;
                pointF.x = f11 = (float)n10 - f10;
                align = Paint.Align.RIGHT;
            }
            int n11 = rect.centerY();
            float f12 = n11;
            f11 = this.calculateTextCenterFromBaseline();
            pointF.y = f12 -= f11;
        }
        return align;
    }

    public void draw(Canvas canvas) {
        Rect rect = this.getBounds();
        int n10 = rect.isEmpty();
        if (n10 == 0 && (n10 = this.getAlpha()) != 0) {
            n10 = 0;
            int n11 = this.alpha;
            int n12 = 255;
            if (n11 < n12) {
                float f10 = rect.left;
                float f11 = rect.top;
                float f12 = rect.right;
                float f13 = rect.bottom;
                n10 = CanvasCompat.saveLayerAlpha(canvas, f10, f11, f12, f13, n11);
            }
            this.drawChipBackground(canvas, rect);
            this.drawChipStroke(canvas, rect);
            this.drawCompatRipple(canvas, rect);
            this.drawChipIcon(canvas, rect);
            this.drawCheckedIcon(canvas, rect);
            boolean bl2 = this.shouldDrawText;
            if (bl2) {
                this.drawText(canvas, rect);
            }
            this.drawCloseIcon(canvas, rect);
            this.drawDebug(canvas, rect);
            int n13 = this.alpha;
            if (n13 < n12) {
                canvas.restoreToCount(n10);
            }
        }
    }

    public int getAlpha() {
        return this.alpha;
    }

    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    public ColorStateList getChipBackgroundColor() {
        return this.chipBackgroundColor;
    }

    public float getChipCornerRadius() {
        return this.chipCornerRadius;
    }

    public float getChipEndPadding() {
        return this.chipEndPadding;
    }

    public Drawable getChipIcon() {
        Object object = this.chipIcon;
        object = object != null ? DrawableCompat.unwrap(object) : null;
        return object;
    }

    public float getChipIconSize() {
        return this.chipIconSize;
    }

    public ColorStateList getChipIconTint() {
        return this.chipIconTint;
    }

    public float getChipMinHeight() {
        return this.chipMinHeight;
    }

    public float getChipStartPadding() {
        return this.chipStartPadding;
    }

    public ColorStateList getChipStrokeColor() {
        return this.chipStrokeColor;
    }

    public float getChipStrokeWidth() {
        return this.chipStrokeWidth;
    }

    public void getChipTouchBounds(RectF rectF) {
        Rect rect = this.getBounds();
        this.calculateChipTouchBounds(rect, rectF);
    }

    public Drawable getCloseIcon() {
        Object object = this.closeIcon;
        object = object != null ? DrawableCompat.unwrap(object) : null;
        return object;
    }

    public CharSequence getCloseIconContentDescription() {
        return this.closeIconContentDescription;
    }

    public float getCloseIconEndPadding() {
        return this.closeIconEndPadding;
    }

    public float getCloseIconSize() {
        return this.closeIconSize;
    }

    public float getCloseIconStartPadding() {
        return this.closeIconStartPadding;
    }

    public int[] getCloseIconState() {
        return this.closeIconStateSet;
    }

    public ColorStateList getCloseIconTint() {
        return this.closeIconTint;
    }

    public void getCloseIconTouchBounds(RectF rectF) {
        Rect rect = this.getBounds();
        this.calculateCloseIconTouchBounds(rect, rectF);
    }

    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public TextUtils.TruncateAt getEllipsize() {
        return this.truncateAt;
    }

    public MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public float getIconEndPadding() {
        return this.iconEndPadding;
    }

    public float getIconStartPadding() {
        return this.iconStartPadding;
    }

    public int getIntrinsicHeight() {
        return (int)this.chipMinHeight;
    }

    public int getIntrinsicWidth() {
        float f10 = this.chipStartPadding;
        float f11 = this.calculateChipIconWidth();
        f10 += f11;
        f11 = this.textStartPadding;
        f10 += f11;
        f11 = this.getTextWidth();
        f10 += f11;
        f11 = this.textEndPadding;
        f10 += f11;
        f11 = this.calculateCloseIconWidth();
        f10 += f11;
        f11 = this.chipEndPadding;
        int n10 = Math.round(f10 + f11);
        int n11 = this.maxWidth;
        return Math.min(n10, n11);
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        Rect rect = this.getBounds();
        boolean bl2 = rect.isEmpty();
        if (!bl2) {
            float f10 = this.chipCornerRadius;
            outline.setRoundRect(rect, f10);
        } else {
            int n10 = this.getIntrinsicWidth();
            int n11 = this.getIntrinsicHeight();
            float f11 = this.chipCornerRadius;
            outline.setRoundRect(0, 0, n10, n11, f11);
        }
        float f12 = (float)this.getAlpha() / 255.0f;
        outline.setAlpha(f12);
    }

    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    public MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    public CharSequence getText() {
        return this.rawText;
    }

    public TextAppearance getTextAppearance() {
        return this.textAppearance;
    }

    public float getTextEndPadding() {
        return this.textEndPadding;
    }

    public float getTextStartPadding() {
        return this.textStartPadding;
    }

    public boolean getUseCompatRipple() {
        return this.useCompatRipple;
    }

    public void invalidateDrawable(Drawable drawable2) {
        drawable2 = this.getCallback();
        if (drawable2 != null) {
            drawable2.invalidateDrawable((Drawable)this);
        }
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    public boolean isCheckedIconEnabled() {
        return this.isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        return this.checkedIconVisible;
    }

    public boolean isChipIconEnabled() {
        return this.isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        return this.chipIconVisible;
    }

    public boolean isCloseIconEnabled() {
        return this.isCloseIconVisible();
    }

    public boolean isCloseIconStateful() {
        return ChipDrawable.isStateful(this.closeIcon);
    }

    public boolean isCloseIconVisible() {
        return this.closeIconVisible;
    }

    public boolean isStateful() {
        Object object = this.chipBackgroundColor;
        boolean bl2 = ChipDrawable.isStateful(object);
        if (!(bl2 || (bl2 = ChipDrawable.isStateful(object = this.chipStrokeColor)) || (bl2 = this.useCompatRipple) && (bl2 = ChipDrawable.isStateful(object = this.compatRippleColor)) || (bl2 = ChipDrawable.isStateful((TextAppearance)(object = this.textAppearance))) || (bl2 = this.canShowCheckedIcon()) || (bl2 = ChipDrawable.isStateful((Drawable)(object = this.chipIcon))) || (bl2 = ChipDrawable.isStateful((Drawable)(object = this.checkedIcon))) || (bl2 = ChipDrawable.isStateful(object = this.tint)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean onLayoutDirectionChanged(int n10) {
        int n11;
        int n12;
        int n13;
        Drawable drawable2;
        boolean n112 = super.onLayoutDirectionChanged(n10);
        int n14 = (int)(this.showsChipIcon() ? 1 : 0);
        if (n14 != 0) {
            drawable2 = this.chipIcon;
            n14 = drawable2.setLayoutDirection(n10);
            n13 = n112 | n14;
        }
        if ((n14 = this.showsCheckedIcon()) != 0) {
            drawable2 = this.checkedIcon;
            n14 = drawable2.setLayoutDirection(n10);
            n12 = n13 | n14;
        }
        if ((n14 = this.showsCloseIcon()) != 0) {
            drawable2 = this.closeIcon;
            n10 = (int)(drawable2.setLayoutDirection(n10) ? 1 : 0);
            n11 = n12 | n10;
        }
        if (n11 != 0) {
            this.invalidateSelf();
        }
        return true;
    }

    public boolean onLevelChange(int n10) {
        int n11;
        int n12;
        int n13;
        Drawable drawable2;
        boolean n112 = super.onLevelChange(n10);
        int n14 = (int)(this.showsChipIcon() ? 1 : 0);
        if (n14 != 0) {
            drawable2 = this.chipIcon;
            n14 = drawable2.setLevel(n10);
            n13 = n112 | n14;
        }
        if ((n14 = this.showsCheckedIcon()) != 0) {
            drawable2 = this.checkedIcon;
            n14 = drawable2.setLevel(n10);
            n12 = n13 | n14;
        }
        if ((n14 = this.showsCloseIcon()) != 0) {
            drawable2 = this.closeIcon;
            n10 = (int)(drawable2.setLevel(n10) ? 1 : 0);
            n11 = n12 | n10;
        }
        if (n11 != 0) {
            this.invalidateSelf();
        }
        return n11 != 0;
    }

    public void onSizeChange() {
        ChipDrawable$Delegate chipDrawable$Delegate = (ChipDrawable$Delegate)this.delegate.get();
        if (chipDrawable$Delegate != null) {
            chipDrawable$Delegate.onChipDrawableSizeChange();
        }
    }

    public boolean onStateChange(int[] nArray) {
        int[] nArray2 = this.getCloseIconState();
        return this.onStateChange(nArray, nArray2);
    }

    public void scheduleDrawable(Drawable drawable2, Runnable runnable, long l10) {
        drawable2 = this.getCallback();
        if (drawable2 != null) {
            drawable2.scheduleDrawable((Drawable)this, runnable, l10);
        }
    }

    public void setAlpha(int n10) {
        int n11 = this.alpha;
        if (n11 != n10) {
            this.alpha = n10;
            this.invalidateSelf();
        }
    }

    public void setCheckable(boolean bl2) {
        boolean bl3 = this.checkable;
        if (bl3 != bl2) {
            float f10;
            this.checkable = bl2;
            float f11 = this.calculateChipIconWidth();
            if (!bl2 && (bl2 = this.currentChecked)) {
                bl2 = false;
                f10 = 0.0f;
                this.currentChecked = false;
            }
            f10 = this.calculateChipIconWidth();
            this.invalidateSelf();
            bl2 = f11 == f10 ? 0 : (f11 > f10 ? 1 : -1);
            if (bl2) {
                this.onSizeChange();
            }
        }
    }

    public void setCheckableResource(int n10) {
        n10 = (int)(this.context.getResources().getBoolean(n10) ? 1 : 0);
        this.setCheckable(n10 != 0);
    }

    public void setCheckedIcon(Drawable drawable2) {
        Drawable drawable3 = this.checkedIcon;
        if (drawable3 != drawable2) {
            float f10 = this.calculateChipIconWidth();
            this.checkedIcon = drawable2;
            float f11 = this.calculateChipIconWidth();
            Drawable drawable4 = this.checkedIcon;
            this.unapplyChildDrawable(drawable4);
            drawable4 = this.checkedIcon;
            this.applyChildDrawable(drawable4);
            this.invalidateSelf();
            float f12 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
            if (f12 != false) {
                this.onSizeChange();
            }
        }
    }

    public void setCheckedIconEnabled(boolean bl2) {
        this.setCheckedIconVisible(bl2);
    }

    public void setCheckedIconEnabledResource(int n10) {
        n10 = (int)(this.context.getResources().getBoolean(n10) ? 1 : 0);
        this.setCheckedIconVisible(n10 != 0);
    }

    public void setCheckedIconResource(int n10) {
        Drawable drawable2 = AppCompatResources.getDrawable(this.context, n10);
        this.setCheckedIcon(drawable2);
    }

    public void setCheckedIconVisible(int n10) {
        n10 = (int)(this.context.getResources().getBoolean(n10) ? 1 : 0);
        this.setCheckedIconVisible(n10 != 0);
    }

    public void setCheckedIconVisible(boolean bl2) {
        boolean bl3 = this.checkedIconVisible;
        if (bl3 != bl2) {
            bl3 = this.showsCheckedIcon();
            this.checkedIconVisible = bl2;
            bl2 = this.showsCheckedIcon();
            if (bl3 = bl3 != bl2) {
                if (bl2) {
                    Drawable drawable2 = this.checkedIcon;
                    this.applyChildDrawable(drawable2);
                } else {
                    Drawable drawable3 = this.checkedIcon;
                    this.unapplyChildDrawable(drawable3);
                }
                this.invalidateSelf();
                this.onSizeChange();
            }
        }
    }

    public void setChipBackgroundColor(ColorStateList object) {
        ColorStateList colorStateList = this.chipBackgroundColor;
        if (colorStateList != object) {
            this.chipBackgroundColor = object;
            object = this.getState();
            this.onStateChange((int[])object);
        }
    }

    public void setChipBackgroundColorResource(int n10) {
        ColorStateList colorStateList = AppCompatResources.getColorStateList(this.context, n10);
        this.setChipBackgroundColor(colorStateList);
    }

    public void setChipCornerRadius(float f10) {
        float f11 = this.chipCornerRadius;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.chipCornerRadius = f10;
            this.invalidateSelf();
        }
    }

    public void setChipCornerRadiusResource(int n10) {
        float f10 = this.context.getResources().getDimension(n10);
        this.setChipCornerRadius(f10);
    }

    public void setChipEndPadding(float f10) {
        float f11 = this.chipEndPadding;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.chipEndPadding = f10;
            this.invalidateSelf();
            this.onSizeChange();
        }
    }

    public void setChipEndPaddingResource(int n10) {
        float f10 = this.context.getResources().getDimension(n10);
        this.setChipEndPadding(f10);
    }

    public void setChipIcon(Drawable drawable2) {
        Drawable drawable3 = this.getChipIcon();
        if (drawable3 != drawable2) {
            float f10;
            boolean bl2;
            float f11 = this.calculateChipIconWidth();
            if (drawable2 != null) {
                drawable2 = DrawableCompat.wrap(drawable2).mutate();
            } else {
                bl2 = false;
                f10 = 0.0f;
                drawable2 = null;
            }
            this.chipIcon = drawable2;
            f10 = this.calculateChipIconWidth();
            this.unapplyChildDrawable(drawable3);
            boolean bl3 = this.showsChipIcon();
            if (bl3) {
                drawable3 = this.chipIcon;
                this.applyChildDrawable(drawable3);
            }
            this.invalidateSelf();
            bl2 = f11 == f10 ? 0 : (f11 > f10 ? 1 : -1);
            if (bl2) {
                this.onSizeChange();
            }
        }
    }

    public void setChipIconEnabled(boolean bl2) {
        this.setChipIconVisible(bl2);
    }

    public void setChipIconEnabledResource(int n10) {
        this.setChipIconVisible(n10);
    }

    public void setChipIconResource(int n10) {
        Drawable drawable2 = AppCompatResources.getDrawable(this.context, n10);
        this.setChipIcon(drawable2);
    }

    public void setChipIconSize(float f10) {
        float f11 = this.chipIconSize;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            f11 = this.calculateChipIconWidth();
            this.chipIconSize = f10;
            f10 = this.calculateChipIconWidth();
            this.invalidateSelf();
            float f13 = f11 == f10 ? 0 : (f11 > f10 ? 1 : -1);
            if (f13 != false) {
                this.onSizeChange();
            }
        }
    }

    public void setChipIconSizeResource(int n10) {
        float f10 = this.context.getResources().getDimension(n10);
        this.setChipIconSize(f10);
    }

    public void setChipIconTint(ColorStateList object) {
        ColorStateList colorStateList = this.chipIconTint;
        if (colorStateList != object) {
            this.chipIconTint = object;
            boolean bl2 = this.showsChipIcon();
            if (bl2) {
                colorStateList = this.chipIcon;
                DrawableCompat.setTintList((Drawable)colorStateList, object);
            }
            object = this.getState();
            this.onStateChange((int[])object);
        }
    }

    public void setChipIconTintResource(int n10) {
        ColorStateList colorStateList = AppCompatResources.getColorStateList(this.context, n10);
        this.setChipIconTint(colorStateList);
    }

    public void setChipIconVisible(int n10) {
        n10 = (int)(this.context.getResources().getBoolean(n10) ? 1 : 0);
        this.setChipIconVisible(n10 != 0);
    }

    public void setChipIconVisible(boolean bl2) {
        boolean bl3 = this.chipIconVisible;
        if (bl3 != bl2) {
            bl3 = this.showsChipIcon();
            this.chipIconVisible = bl2;
            bl2 = this.showsChipIcon();
            if (bl3 = bl3 != bl2) {
                if (bl2) {
                    Drawable drawable2 = this.chipIcon;
                    this.applyChildDrawable(drawable2);
                } else {
                    Drawable drawable3 = this.chipIcon;
                    this.unapplyChildDrawable(drawable3);
                }
                this.invalidateSelf();
                this.onSizeChange();
            }
        }
    }

    public void setChipMinHeight(float f10) {
        float f11 = this.chipMinHeight;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.chipMinHeight = f10;
            this.invalidateSelf();
            this.onSizeChange();
        }
    }

    public void setChipMinHeightResource(int n10) {
        float f10 = this.context.getResources().getDimension(n10);
        this.setChipMinHeight(f10);
    }

    public void setChipStartPadding(float f10) {
        float f11 = this.chipStartPadding;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.chipStartPadding = f10;
            this.invalidateSelf();
            this.onSizeChange();
        }
    }

    public void setChipStartPaddingResource(int n10) {
        float f10 = this.context.getResources().getDimension(n10);
        this.setChipStartPadding(f10);
    }

    public void setChipStrokeColor(ColorStateList object) {
        ColorStateList colorStateList = this.chipStrokeColor;
        if (colorStateList != object) {
            this.chipStrokeColor = object;
            object = this.getState();
            this.onStateChange((int[])object);
        }
    }

    public void setChipStrokeColorResource(int n10) {
        ColorStateList colorStateList = AppCompatResources.getColorStateList(this.context, n10);
        this.setChipStrokeColor(colorStateList);
    }

    public void setChipStrokeWidth(float f10) {
        float f11 = this.chipStrokeWidth;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.chipStrokeWidth = f10;
            Paint paint = this.chipPaint;
            paint.setStrokeWidth(f10);
            this.invalidateSelf();
        }
    }

    public void setChipStrokeWidthResource(int n10) {
        float f10 = this.context.getResources().getDimension(n10);
        this.setChipStrokeWidth(f10);
    }

    public void setCloseIcon(Drawable drawable2) {
        Drawable drawable3 = this.getCloseIcon();
        if (drawable3 != drawable2) {
            float f10;
            boolean bl2;
            float f11 = this.calculateCloseIconWidth();
            if (drawable2 != null) {
                drawable2 = DrawableCompat.wrap(drawable2).mutate();
            } else {
                bl2 = false;
                f10 = 0.0f;
                drawable2 = null;
            }
            this.closeIcon = drawable2;
            f10 = this.calculateCloseIconWidth();
            this.unapplyChildDrawable(drawable3);
            boolean bl3 = this.showsCloseIcon();
            if (bl3) {
                drawable3 = this.closeIcon;
                this.applyChildDrawable(drawable3);
            }
            this.invalidateSelf();
            bl2 = f11 == f10 ? 0 : (f11 > f10 ? 1 : -1);
            if (bl2) {
                this.onSizeChange();
            }
        }
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        Object object = this.closeIconContentDescription;
        if (object != charSequence) {
            object = BidiFormatter.getInstance();
            this.closeIconContentDescription = charSequence = ((BidiFormatter)object).unicodeWrap(charSequence);
            this.invalidateSelf();
        }
    }

    public void setCloseIconEnabled(boolean bl2) {
        this.setCloseIconVisible(bl2);
    }

    public void setCloseIconEnabledResource(int n10) {
        this.setCloseIconVisible(n10);
    }

    public void setCloseIconEndPadding(float f10) {
        float f11 = this.closeIconEndPadding;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.closeIconEndPadding = f10;
            this.invalidateSelf();
            boolean bl2 = this.showsCloseIcon();
            if (bl2) {
                this.onSizeChange();
            }
        }
    }

    public void setCloseIconEndPaddingResource(int n10) {
        float f10 = this.context.getResources().getDimension(n10);
        this.setCloseIconEndPadding(f10);
    }

    public void setCloseIconResource(int n10) {
        Drawable drawable2 = AppCompatResources.getDrawable(this.context, n10);
        this.setCloseIcon(drawable2);
    }

    public void setCloseIconSize(float f10) {
        float f11 = this.closeIconSize;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.closeIconSize = f10;
            this.invalidateSelf();
            boolean bl2 = this.showsCloseIcon();
            if (bl2) {
                this.onSizeChange();
            }
        }
    }

    public void setCloseIconSizeResource(int n10) {
        float f10 = this.context.getResources().getDimension(n10);
        this.setCloseIconSize(f10);
    }

    public void setCloseIconStartPadding(float f10) {
        float f11 = this.closeIconStartPadding;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.closeIconStartPadding = f10;
            this.invalidateSelf();
            boolean bl2 = this.showsCloseIcon();
            if (bl2) {
                this.onSizeChange();
            }
        }
    }

    public void setCloseIconStartPaddingResource(int n10) {
        float f10 = this.context.getResources().getDimension(n10);
        this.setCloseIconStartPadding(f10);
    }

    public boolean setCloseIconState(int[] nArray) {
        int[] nArray2 = this.closeIconStateSet;
        boolean bl2 = Arrays.equals(nArray2, nArray);
        if (!bl2) {
            this.closeIconStateSet = nArray;
            bl2 = this.showsCloseIcon();
            if (bl2) {
                nArray2 = this.getState();
                return this.onStateChange(nArray2, nArray);
            }
        }
        return false;
    }

    public void setCloseIconTint(ColorStateList object) {
        ColorStateList colorStateList = this.closeIconTint;
        if (colorStateList != object) {
            this.closeIconTint = object;
            boolean bl2 = this.showsCloseIcon();
            if (bl2) {
                colorStateList = this.closeIcon;
                DrawableCompat.setTintList((Drawable)colorStateList, object);
            }
            object = this.getState();
            this.onStateChange((int[])object);
        }
    }

    public void setCloseIconTintResource(int n10) {
        ColorStateList colorStateList = AppCompatResources.getColorStateList(this.context, n10);
        this.setCloseIconTint(colorStateList);
    }

    public void setCloseIconVisible(int n10) {
        n10 = (int)(this.context.getResources().getBoolean(n10) ? 1 : 0);
        this.setCloseIconVisible(n10 != 0);
    }

    public void setCloseIconVisible(boolean bl2) {
        boolean bl3 = this.closeIconVisible;
        if (bl3 != bl2) {
            bl3 = this.showsCloseIcon();
            this.closeIconVisible = bl2;
            bl2 = this.showsCloseIcon();
            if (bl3 = bl3 != bl2) {
                if (bl2) {
                    Drawable drawable2 = this.closeIcon;
                    this.applyChildDrawable(drawable2);
                } else {
                    Drawable drawable3 = this.closeIcon;
                    this.unapplyChildDrawable(drawable3);
                }
                this.invalidateSelf();
                this.onSizeChange();
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        ColorFilter colorFilter2 = this.colorFilter;
        if (colorFilter2 != colorFilter) {
            this.colorFilter = colorFilter;
            this.invalidateSelf();
        }
    }

    public void setDelegate(ChipDrawable$Delegate chipDrawable$Delegate) {
        WeakReference<ChipDrawable$Delegate> weakReference;
        this.delegate = weakReference = new WeakReference<ChipDrawable$Delegate>(chipDrawable$Delegate);
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        this.truncateAt = truncateAt;
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        this.hideMotionSpec = motionSpec;
    }

    public void setHideMotionSpecResource(int n10) {
        MotionSpec motionSpec = MotionSpec.createFromResource(this.context, n10);
        this.setHideMotionSpec(motionSpec);
    }

    public void setIconEndPadding(float f10) {
        float f11 = this.iconEndPadding;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            f11 = this.calculateChipIconWidth();
            this.iconEndPadding = f10;
            f10 = this.calculateChipIconWidth();
            this.invalidateSelf();
            float f13 = f11 == f10 ? 0 : (f11 > f10 ? 1 : -1);
            if (f13 != false) {
                this.onSizeChange();
            }
        }
    }

    public void setIconEndPaddingResource(int n10) {
        float f10 = this.context.getResources().getDimension(n10);
        this.setIconEndPadding(f10);
    }

    public void setIconStartPadding(float f10) {
        float f11 = this.iconStartPadding;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            f11 = this.calculateChipIconWidth();
            this.iconStartPadding = f10;
            f10 = this.calculateChipIconWidth();
            this.invalidateSelf();
            float f13 = f11 == f10 ? 0 : (f11 > f10 ? 1 : -1);
            if (f13 != false) {
                this.onSizeChange();
            }
        }
    }

    public void setIconStartPaddingResource(int n10) {
        float f10 = this.context.getResources().getDimension(n10);
        this.setIconStartPadding(f10);
    }

    public void setMaxWidth(int n10) {
        this.maxWidth = n10;
    }

    public void setRippleColor(ColorStateList object) {
        ColorStateList colorStateList = this.rippleColor;
        if (colorStateList != object) {
            this.rippleColor = object;
            this.updateCompatRippleColor();
            object = this.getState();
            this.onStateChange((int[])object);
        }
    }

    public void setRippleColorResource(int n10) {
        ColorStateList colorStateList = AppCompatResources.getColorStateList(this.context, n10);
        this.setRippleColor(colorStateList);
    }

    public void setShouldDrawText(boolean bl2) {
        this.shouldDrawText = bl2;
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        this.showMotionSpec = motionSpec;
    }

    public void setShowMotionSpecResource(int n10) {
        MotionSpec motionSpec = MotionSpec.createFromResource(this.context, n10);
        this.setShowMotionSpec(motionSpec);
    }

    public void setText(CharSequence charSequence) {
        Object object;
        if (charSequence == null) {
            charSequence = "";
        }
        if ((object = this.rawText) != charSequence) {
            boolean bl2;
            this.rawText = charSequence;
            object = BidiFormatter.getInstance();
            this.unicodeWrappedText = charSequence = ((BidiFormatter)object).unicodeWrap(charSequence);
            this.textWidthDirty = bl2 = true;
            this.invalidateSelf();
            this.onSizeChange();
        }
    }

    public void setTextAppearance(TextAppearance object) {
        TextAppearance textAppearance = this.textAppearance;
        if (textAppearance != object) {
            this.textAppearance = object;
            if (object != null) {
                boolean bl2;
                textAppearance = this.context;
                TextPaint textPaint = this.textPaint;
                ResourcesCompat$FontCallback resourcesCompat$FontCallback = this.fontCallback;
                ((TextAppearance)object).updateMeasureState((Context)textAppearance, textPaint, resourcesCompat$FontCallback);
                this.textWidthDirty = bl2 = true;
            }
            object = this.getState();
            this.onStateChange((int[])object);
            this.onSizeChange();
        }
    }

    public void setTextAppearanceResource(int n10) {
        Context context = this.context;
        TextAppearance textAppearance = new TextAppearance(context, n10);
        this.setTextAppearance(textAppearance);
    }

    public void setTextEndPadding(float f10) {
        float f11 = this.textEndPadding;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.textEndPadding = f10;
            this.invalidateSelf();
            this.onSizeChange();
        }
    }

    public void setTextEndPaddingResource(int n10) {
        float f10 = this.context.getResources().getDimension(n10);
        this.setTextEndPadding(f10);
    }

    public void setTextResource(int n10) {
        String string2 = this.context.getResources().getString(n10);
        this.setText(string2);
    }

    public void setTextStartPadding(float f10) {
        float f11 = this.textStartPadding;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.textStartPadding = f10;
            this.invalidateSelf();
            this.onSizeChange();
        }
    }

    public void setTextStartPaddingResource(int n10) {
        float f10 = this.context.getResources().getDimension(n10);
        this.setTextStartPadding(f10);
    }

    public void setTintList(ColorStateList object) {
        ColorStateList colorStateList = this.tint;
        if (colorStateList != object) {
            this.tint = object;
            object = this.getState();
            this.onStateChange((int[])object);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        PorterDuff.Mode mode2 = this.tintMode;
        if (mode2 != mode) {
            this.tintMode = mode;
            mode2 = this.tint;
            mode = DrawableUtils.updateTintFilter(this, (ColorStateList)mode2, mode);
            this.tintFilter = mode;
            this.invalidateSelf();
        }
    }

    public void setUseCompatRipple(boolean bl2) {
        boolean bl3 = this.useCompatRipple;
        if (bl3 != bl2) {
            this.useCompatRipple = bl2;
            this.updateCompatRippleColor();
            int[] nArray = this.getState();
            this.onStateChange(nArray);
        }
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        Drawable drawable2;
        boolean bl4 = super.setVisible(bl2, bl3);
        boolean bl5 = this.showsChipIcon();
        if (bl5) {
            drawable2 = this.chipIcon;
            bl5 = drawable2.setVisible(bl2, bl3);
            bl4 |= bl5;
        }
        if (bl5 = this.showsCheckedIcon()) {
            drawable2 = this.checkedIcon;
            bl5 = drawable2.setVisible(bl2, bl3);
            bl4 |= bl5;
        }
        if (bl5 = this.showsCloseIcon()) {
            drawable2 = this.closeIcon;
            bl2 = drawable2.setVisible(bl2, bl3);
            bl4 |= bl2;
        }
        if (bl4) {
            this.invalidateSelf();
        }
        return bl4;
    }

    public boolean shouldDrawText() {
        return this.shouldDrawText;
    }

    public void unscheduleDrawable(Drawable drawable2, Runnable runnable) {
        drawable2 = this.getCallback();
        if (drawable2 != null) {
            drawable2.unscheduleDrawable((Drawable)this, runnable);
        }
    }
}

