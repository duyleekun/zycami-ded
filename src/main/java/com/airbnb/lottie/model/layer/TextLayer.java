/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.RectF
 *  android.graphics.Typeface
 */
package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.DocumentData$Justification;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.TextLayer$3;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TextLayer
extends BaseLayer {
    private final LongSparseArray codePointCache;
    private BaseKeyframeAnimation colorAnimation;
    private BaseKeyframeAnimation colorCallbackAnimation;
    private final LottieComposition composition;
    private final Map contentsForCharacter;
    private final Paint fillPaint;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final RectF rectF;
    private final StringBuilder stringBuilder;
    private BaseKeyframeAnimation strokeColorAnimation;
    private BaseKeyframeAnimation strokeColorCallbackAnimation;
    private final Paint strokePaint;
    private BaseKeyframeAnimation strokeWidthAnimation;
    private BaseKeyframeAnimation strokeWidthCallbackAnimation;
    private final TextKeyframeAnimation textAnimation;
    private BaseKeyframeAnimation textSizeAnimation;
    private BaseKeyframeAnimation textSizeCallbackAnimation;
    private BaseKeyframeAnimation trackingAnimation;
    private BaseKeyframeAnimation trackingCallbackAnimation;

    public TextLayer(LottieDrawable object, Layer object2) {
        super((LottieDrawable)((Object)object), (Layer)object2);
        Object object3;
        this.stringBuilder = object3 = new StringBuilder(2);
        super();
        this.rectF = object3;
        super();
        this.matrix = object3;
        int n10 = 1;
        super(this, n10);
        this.fillPaint = object3;
        super(this, n10);
        this.strokePaint = object3;
        super();
        this.contentsForCharacter = object3;
        super();
        this.codePointCache = object3;
        this.lottieDrawable = object;
        object = ((Layer)object2).getComposition();
        this.composition = object;
        object = ((Layer)object2).getText().createAnimation();
        this.textAnimation = object;
        ((BaseKeyframeAnimation)object).addUpdateListener(this);
        this.addAnimation((BaseKeyframeAnimation)object);
        object = ((Layer)object2).getTextProperties();
        if (object != null && (object2 = ((AnimatableTextProperties)object).color) != null) {
            this.colorAnimation = object2 = ((AnimatableColorValue)object2).createAnimation();
            ((BaseKeyframeAnimation)object2).addUpdateListener(this);
            object2 = this.colorAnimation;
            this.addAnimation((BaseKeyframeAnimation)object2);
        }
        if (object != null && (object2 = ((AnimatableTextProperties)object).stroke) != null) {
            this.strokeColorAnimation = object2 = ((AnimatableColorValue)object2).createAnimation();
            ((BaseKeyframeAnimation)object2).addUpdateListener(this);
            object2 = this.strokeColorAnimation;
            this.addAnimation((BaseKeyframeAnimation)object2);
        }
        if (object != null && (object2 = ((AnimatableTextProperties)object).strokeWidth) != null) {
            this.strokeWidthAnimation = object2 = ((AnimatableFloatValue)object2).createAnimation();
            ((BaseKeyframeAnimation)object2).addUpdateListener(this);
            object2 = this.strokeWidthAnimation;
            this.addAnimation((BaseKeyframeAnimation)object2);
        }
        if (object != null && (object = ((AnimatableTextProperties)object).tracking) != null) {
            this.trackingAnimation = object = ((AnimatableFloatValue)object).createAnimation();
            ((BaseKeyframeAnimation)object).addUpdateListener(this);
            object = this.trackingAnimation;
            this.addAnimation((BaseKeyframeAnimation)object);
        }
    }

    private void applyJustification(DocumentData$Justification documentData$Justification, Canvas canvas, float f10) {
        int[] nArray = TextLayer$3.$SwitchMap$com$airbnb$lottie$model$DocumentData$Justification;
        int n10 = documentData$Justification.ordinal();
        int n11 = 2;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 3;
            if (n10 == n11) {
                float f11 = -f10;
                f10 = 2.0f;
                canvas.translate(f11 /= f10, 0.0f);
            }
        } else {
            float f12 = -f10;
            canvas.translate(f12, 0.0f);
        }
    }

    private String codePointToString(String string2, int n10) {
        int n11;
        int n12;
        int n13;
        int n14 = string2.codePointAt(n10);
        for (n12 = Character.charCount(n14) + n10; n12 < (n11 = string2.length()) && (n13 = this.isModifier(n11 = string2.codePointAt(n12))) != 0; n12 += n13) {
            n13 = Character.charCount(n11);
            n14 = n14 * 31 + n11;
        }
        Object object = this.codePointCache;
        long l10 = n14;
        if ((n14 = (int)(((LongSparseArray)object).containsKey(l10) ? 1 : 0)) != 0) {
            return (String)this.codePointCache.get(l10);
        }
        StringBuilder stringBuilder = this.stringBuilder;
        n11 = 0;
        object = null;
        stringBuilder.setLength(0);
        while (n10 < n12) {
            n14 = string2.codePointAt(n10);
            object = this.stringBuilder;
            ((StringBuilder)object).appendCodePoint(n14);
            n14 = Character.charCount(n14);
            n10 += n14;
        }
        string2 = this.stringBuilder.toString();
        this.codePointCache.put(l10, string2);
        return string2;
    }

    private void drawCharacter(String string2, Paint paint, Canvas canvas) {
        Paint.Style style2;
        int n10 = paint.getColor();
        if (n10 == 0) {
            return;
        }
        Paint.Style style3 = paint.getStyle();
        if (style3 == (style2 = Paint.Style.STROKE)) {
            float f10 = paint.getStrokeWidth();
            style2 = null;
            float f11 = f10 - 0.0f;
            n10 = (int)(f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1));
            if (n10 == 0) {
                return;
            }
        }
        int n11 = string2.length();
        style2 = canvas;
        canvas.drawText(string2, 0, n11, 0.0f, 0.0f, paint);
    }

    private void drawCharacterAsGlyph(FontCharacter object, Matrix matrix, float f10, DocumentData documentData, Canvas canvas) {
        int n10;
        object = this.getContentsForCharacter((FontCharacter)object);
        for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
            Path path = ((ContentGroup)object.get(i10)).getPath();
            RectF rectF = this.rectF;
            path.computeBounds(rectF, false);
            this.matrix.set(matrix);
            rectF = this.matrix;
            float f11 = -documentData.baselineShift;
            float f12 = Utils.dpScale();
            rectF.preTranslate(0.0f, f11 *= f12);
            this.matrix.preScale(f10, f10);
            rectF = this.matrix;
            path.transform((Matrix)rectF);
            boolean bl2 = documentData.strokeOverFill;
            if (bl2) {
                rectF = this.fillPaint;
                this.drawGlyph(path, (Paint)rectF, canvas);
                rectF = this.strokePaint;
                this.drawGlyph(path, (Paint)rectF, canvas);
                continue;
            }
            rectF = this.strokePaint;
            this.drawGlyph(path, (Paint)rectF, canvas);
            rectF = this.fillPaint;
            this.drawGlyph(path, (Paint)rectF, canvas);
        }
    }

    private void drawCharacterFromFont(String string2, DocumentData documentData, Canvas canvas) {
        boolean bl2 = documentData.strokeOverFill;
        if (bl2) {
            documentData = this.fillPaint;
            this.drawCharacter(string2, (Paint)documentData, canvas);
            documentData = this.strokePaint;
            this.drawCharacter(string2, (Paint)documentData, canvas);
        } else {
            documentData = this.strokePaint;
            this.drawCharacter(string2, (Paint)documentData, canvas);
            documentData = this.fillPaint;
            this.drawCharacter(string2, (Paint)documentData, canvas);
        }
    }

    private void drawFontTextLine(String string2, DocumentData documentData, Canvas canvas, float f10) {
        int n10;
        int n11;
        for (int i10 = 0; i10 < (n10 = string2.length()); i10 += n11) {
            String string3 = this.codePointToString(string2, i10);
            n11 = string3.length();
            this.drawCharacterFromFont(string3, documentData, canvas);
            float f11 = this.fillPaint.measureText(string3) + f10;
            n11 = 0;
            canvas.translate(f11, 0.0f);
        }
    }

    private void drawGlyph(Path path, Paint paint, Canvas canvas) {
        Paint.Style style2;
        int n10 = paint.getColor();
        if (n10 == 0) {
            return;
        }
        Paint.Style style3 = paint.getStyle();
        if (style3 == (style2 = Paint.Style.STROKE)) {
            float f10 = paint.getStrokeWidth();
            style2 = null;
            float f11 = f10 - 0.0f;
            n10 = (int)(f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1));
            if (n10 == 0) {
                return;
            }
        }
        canvas.drawPath(path, paint);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void drawGlyphTextLine(String string2, DocumentData documentData, Matrix matrix, Font font2, Canvas canvas, float f10, float f11) {
        int n10 = 0;
        while (true) {
            block5: {
                int n11;
                float f12;
                Object object;
                block8: {
                    float f13;
                    block7: {
                        Object object2;
                        block6: {
                            int n12;
                            if (n10 >= (n12 = string2.length())) {
                                return;
                            }
                            n12 = string2.charAt(n10);
                            object = font2.getFamily();
                            object2 = font2.getStyle();
                            n12 = FontCharacter.hashFor((char)n12, (String)object, (String)object2);
                            object = this.composition.getCharacters();
                            FontCharacter fontCharacter = (FontCharacter)((SparseArrayCompat)object).get(n12);
                            if (fontCharacter == null) break block5;
                            object = this;
                            object2 = fontCharacter;
                            this.drawCharacterAsGlyph(fontCharacter, matrix, f11, documentData, canvas);
                            double d10 = fontCharacter.getWidth();
                            float f14 = (float)d10 * f11;
                            f12 = Utils.dpScale();
                            f14 = f14 * f12 * f10;
                            n11 = documentData.tracking;
                            f12 = n11;
                            f13 = 10.0f;
                            f12 /= f13;
                            object2 = this.trackingCallbackAnimation;
                            if (object2 == null) break block6;
                            object2 = (Float)((BaseKeyframeAnimation)object2).getValue();
                            f13 = ((Float)object2).floatValue();
                            break block7;
                        }
                        object2 = this.trackingAnimation;
                        if (object2 == null) break block8;
                        object2 = (Float)((BaseKeyframeAnimation)object2).getValue();
                        f13 = ((Float)object2).floatValue();
                    }
                    f12 += f13;
                }
                n11 = 0;
                f12 = 0.0f;
                object = null;
                canvas.translate(f14 += (f12 *= f10), 0.0f);
            }
            ++n10;
        }
    }

    private void drawTextGlyphs(DocumentData documentData, Matrix matrix, Font font2, Canvas canvas) {
        float f10;
        TextLayer textLayer = this;
        DocumentData documentData2 = documentData;
        Canvas canvas2 = canvas;
        Object object = this.textSizeCallbackAnimation;
        if (object != null) {
            object = (Float)((BaseKeyframeAnimation)object).getValue();
            f10 = ((Float)object).floatValue();
        } else {
            object = this.textSizeAnimation;
            if (object != null) {
                object = (Float)((BaseKeyframeAnimation)object).getValue();
                f10 = ((Float)object).floatValue();
            } else {
                f10 = documentData.size;
            }
        }
        float f11 = f10 / 100.0f;
        float f12 = Utils.getScale(matrix);
        object = documentData2.text;
        float f13 = documentData2.lineHeight;
        float f14 = Utils.dpScale();
        float f15 = f13 * f14;
        List list = textLayer.getTextLines((String)object);
        int n10 = list.size();
        f10 = 0.0f;
        object = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = object = list.get(i10);
            object2 = (String)object;
            f10 = textLayer.getTextLineWidthForGlyphs((String)object2, font2, f11, f12);
            canvas.save();
            Object object3 = documentData2.justification;
            textLayer.applyJustification((DocumentData$Justification)((Object)object3), canvas2, f10);
            f10 = (float)(n10 + -1) * f15 / 2.0f;
            f14 = (float)i10 * f15 - f10;
            f10 = 0.0f;
            canvas2.translate(0.0f, f14);
            object = this;
            object3 = documentData;
            this.drawGlyphTextLine((String)object2, documentData, matrix, font2, canvas, f12, f11);
            canvas.restore();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void drawTextWithFont(DocumentData documentData, Font object, Matrix object2, Canvas canvas) {
        Object object3;
        float f10;
        int n10;
        float f11;
        float f12;
        float f13;
        block13: {
            block12: {
                block11: {
                    Utils.getScale((Matrix)object2);
                    object2 = this.lottieDrawable;
                    Object object4 = ((Font)object).getFamily();
                    object = ((Font)object).getStyle();
                    object = ((LottieDrawable)((Object)object2)).getTypeface((String)object4, (String)object);
                    if (object == null) {
                        return;
                    }
                    object2 = documentData.text;
                    object4 = this.lottieDrawable.getTextDelegate();
                    if (object4 != null) {
                        object2 = ((TextDelegate)object4).getTextInternal((String)object2);
                    }
                    object4 = this.fillPaint;
                    object4.setTypeface((Typeface)object);
                    object = this.textSizeCallbackAnimation;
                    if (object != null) {
                        object = (Float)((BaseKeyframeAnimation)object).getValue();
                        f13 = ((Float)object).floatValue();
                    } else {
                        object = this.textSizeAnimation;
                        if (object != null) {
                            object = (Float)((BaseKeyframeAnimation)object).getValue();
                            f13 = ((Float)object).floatValue();
                        } else {
                            f13 = documentData.size;
                        }
                    }
                    object4 = this.fillPaint;
                    f12 = Utils.dpScale() * f13;
                    object4.setTextSize(f12);
                    object4 = this.strokePaint;
                    Typeface typeface = this.fillPaint.getTypeface();
                    object4.setTypeface(typeface);
                    object4 = this.strokePaint;
                    typeface = this.fillPaint;
                    f12 = typeface.getTextSize();
                    object4.setTextSize(f12);
                    f11 = documentData.lineHeight;
                    f12 = Utils.dpScale();
                    f11 *= f12;
                    int n11 = documentData.tracking;
                    f12 = n11;
                    n10 = 1092616192;
                    f10 = 10.0f;
                    f12 /= f10;
                    object3 = this.trackingCallbackAnimation;
                    if (object3 == null) break block11;
                    object3 = (Float)((BaseKeyframeAnimation)object3).getValue();
                    f10 = ((Float)object3).floatValue();
                    break block12;
                }
                object3 = this.trackingAnimation;
                if (object3 == null) break block13;
                object3 = (Float)((BaseKeyframeAnimation)object3).getValue();
                f10 = ((Float)object3).floatValue();
            }
            f12 += f10;
        }
        f10 = Utils.dpScale();
        f12 = f12 * f10 * f13;
        f13 = 100.0f;
        f12 /= f13;
        object = this.getTextLines((String)object2);
        int n12 = object.size();
        n10 = 0;
        f10 = 0.0f;
        object3 = null;
        while (n10 < n12) {
            String string2 = (String)object.get(n10);
            float f14 = this.strokePaint.measureText(string2);
            float f15 = (float)(string2.length() + -1) * f12;
            canvas.save();
            DocumentData$Justification documentData$Justification = documentData.justification;
            this.applyJustification(documentData$Justification, canvas, f14 += f15);
            f14 = (float)(n12 + -1) * f11;
            f15 = (float)n10 * f11 - (f14 /= 2.0f);
            f14 = 0.0f;
            canvas.translate(0.0f, f15);
            this.drawFontTextLine(string2, documentData, canvas, f12);
            canvas.restore();
            ++n10;
        }
        return;
    }

    private List getContentsForCharacter(FontCharacter fontCharacter) {
        Object object = this.contentsForCharacter;
        boolean bl2 = object.containsKey(fontCharacter);
        if (bl2) {
            return (List)this.contentsForCharacter.get(fontCharacter);
        }
        object = fontCharacter.getShapes();
        int n10 = object.size();
        ArrayList<ContentGroup> arrayList = new ArrayList<ContentGroup>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            ShapeGroup shapeGroup = (ShapeGroup)object.get(i10);
            LottieDrawable lottieDrawable = this.lottieDrawable;
            ContentGroup contentGroup = new ContentGroup(lottieDrawable, this, shapeGroup);
            arrayList.add(contentGroup);
        }
        this.contentsForCharacter.put(fontCharacter, arrayList);
        return arrayList;
    }

    private float getTextLineWidthForGlyphs(String string2, Font font2, float f10, float f11) {
        int n10;
        float f12 = 0.0f;
        for (int i10 = 0; i10 < (n10 = string2.length()); ++i10) {
            n10 = string2.charAt(i10);
            Object object = font2.getFamily();
            String string3 = font2.getStyle();
            n10 = FontCharacter.hashFor((char)n10, (String)object, string3);
            object = this.composition.getCharacters();
            FontCharacter fontCharacter = (FontCharacter)((SparseArrayCompat)object).get(n10);
            if (fontCharacter == null) continue;
            double d10 = f12;
            double d11 = fontCharacter.getWidth();
            double d12 = f10;
            d11 *= d12;
            d12 = Utils.dpScale();
            d11 *= d12;
            d12 = f11;
            f12 = (float)(d10 += (d11 *= d12));
        }
        return f12;
    }

    private List getTextLines(String string2) {
        String string3 = "\r";
        return Arrays.asList(string2.replaceAll("\r\n", string3).replaceAll("\n", string3).split(string3));
    }

    private boolean isModifier(int n10) {
        int n11;
        int n12 = Character.getType(n10);
        n10 = n12 != (n11 = 16) && (n12 = Character.getType(n10)) != (n11 = 27) && (n12 = Character.getType(n10)) != (n11 = 6) && (n12 = Character.getType(n10)) != (n11 = 28) && (n10 = Character.getType(n10)) != (n12 = 19) ? 0 : 1;
        return n10 != 0;
    }

    public void addValueCallback(Object object, LottieValueCallback lottieValueCallback) {
        super.addValueCallback(object, lottieValueCallback);
        Number number = LottieProperty.COLOR;
        if (object == number) {
            object = this.colorCallbackAnimation;
            if (object != null) {
                this.removeAnimation((BaseKeyframeAnimation)object);
            }
            if (lottieValueCallback == null) {
                this.colorCallbackAnimation = null;
            } else {
                this.colorCallbackAnimation = object = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                ((BaseKeyframeAnimation)object).addUpdateListener(this);
                object = this.colorCallbackAnimation;
                this.addAnimation((BaseKeyframeAnimation)object);
            }
        } else {
            number = LottieProperty.STROKE_COLOR;
            if (object == number) {
                object = this.strokeColorCallbackAnimation;
                if (object != null) {
                    this.removeAnimation((BaseKeyframeAnimation)object);
                }
                if (lottieValueCallback == null) {
                    this.strokeColorCallbackAnimation = null;
                } else {
                    this.strokeColorCallbackAnimation = object = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                    ((BaseKeyframeAnimation)object).addUpdateListener(this);
                    object = this.strokeColorCallbackAnimation;
                    this.addAnimation((BaseKeyframeAnimation)object);
                }
            } else {
                number = LottieProperty.STROKE_WIDTH;
                if (object == number) {
                    object = this.strokeWidthCallbackAnimation;
                    if (object != null) {
                        this.removeAnimation((BaseKeyframeAnimation)object);
                    }
                    if (lottieValueCallback == null) {
                        this.strokeWidthCallbackAnimation = null;
                    } else {
                        this.strokeWidthCallbackAnimation = object = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                        ((BaseKeyframeAnimation)object).addUpdateListener(this);
                        object = this.strokeWidthCallbackAnimation;
                        this.addAnimation((BaseKeyframeAnimation)object);
                    }
                } else {
                    number = LottieProperty.TEXT_TRACKING;
                    if (object == number) {
                        object = this.trackingCallbackAnimation;
                        if (object != null) {
                            this.removeAnimation((BaseKeyframeAnimation)object);
                        }
                        if (lottieValueCallback == null) {
                            this.trackingCallbackAnimation = null;
                        } else {
                            this.trackingCallbackAnimation = object = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                            ((BaseKeyframeAnimation)object).addUpdateListener(this);
                            object = this.trackingCallbackAnimation;
                            this.addAnimation((BaseKeyframeAnimation)object);
                        }
                    } else {
                        number = LottieProperty.TEXT_SIZE;
                        if (object == number) {
                            object = this.textSizeCallbackAnimation;
                            if (object != null) {
                                this.removeAnimation((BaseKeyframeAnimation)object);
                            }
                            if (lottieValueCallback == null) {
                                this.textSizeCallbackAnimation = null;
                            } else {
                                this.textSizeCallbackAnimation = object = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                                ((BaseKeyframeAnimation)object).addUpdateListener(this);
                                object = this.textSizeCallbackAnimation;
                                this.addAnimation((BaseKeyframeAnimation)object);
                            }
                        }
                    }
                }
            }
        }
    }

    public void drawLayer(Canvas canvas, Matrix matrix, int n10) {
        float f10;
        int n11;
        int n12;
        Paint paint;
        canvas.save();
        Object object = this.lottieDrawable;
        n10 = (int)(object.useTextGlyphs() ? 1 : 0);
        if (n10 == 0) {
            canvas.concat(matrix);
        }
        object = (DocumentData)this.textAnimation.getValue();
        Object object2 = this.composition.getFonts();
        Object object3 = ((DocumentData)object).fontName;
        if ((object2 = (Font)object2.get(object3)) == null) {
            canvas.restore();
            return;
        }
        object3 = this.colorCallbackAnimation;
        if (object3 != null) {
            paint = this.fillPaint;
            object3 = (Integer)((BaseKeyframeAnimation)object3).getValue();
            n12 = (Integer)object3;
            paint.setColor(n12);
        } else {
            object3 = this.colorAnimation;
            if (object3 != null) {
                paint = this.fillPaint;
                object3 = (Integer)((BaseKeyframeAnimation)object3).getValue();
                n12 = (Integer)object3;
                paint.setColor(n12);
            } else {
                object3 = this.fillPaint;
                n11 = ((DocumentData)object).color;
                object3.setColor(n11);
            }
        }
        object3 = this.strokeColorCallbackAnimation;
        if (object3 != null) {
            paint = this.strokePaint;
            object3 = (Integer)((BaseKeyframeAnimation)object3).getValue();
            n12 = (Integer)object3;
            paint.setColor(n12);
        } else {
            object3 = this.strokeColorAnimation;
            if (object3 != null) {
                paint = this.strokePaint;
                object3 = (Integer)((BaseKeyframeAnimation)object3).getValue();
                n12 = (Integer)object3;
                paint.setColor(n12);
            } else {
                object3 = this.strokePaint;
                n11 = ((DocumentData)object).strokeColor;
                object3.setColor(n11);
            }
        }
        object3 = this.transform.getOpacity();
        n11 = 100;
        float f11 = 1.4E-43f;
        if (object3 == null) {
            n12 = n11;
            f10 = f11;
        } else {
            object3 = (Integer)this.transform.getOpacity().getValue();
            n12 = (Integer)object3;
        }
        n12 = n12 * 255 / n11;
        this.fillPaint.setAlpha(n12);
        paint = this.strokePaint;
        paint.setAlpha(n12);
        object3 = this.strokeWidthCallbackAnimation;
        if (object3 != null) {
            paint = this.strokePaint;
            object3 = (Float)((BaseKeyframeAnimation)object3).getValue();
            f10 = ((Float)object3).floatValue();
            paint.setStrokeWidth(f10);
        } else {
            object3 = this.strokeWidthAnimation;
            if (object3 != null) {
                paint = this.strokePaint;
                object3 = (Float)((BaseKeyframeAnimation)object3).getValue();
                f10 = ((Float)object3).floatValue();
                paint.setStrokeWidth(f10);
            } else {
                f10 = Utils.getScale(matrix);
                paint = this.strokePaint;
                float f12 = ((DocumentData)object).strokeWidth;
                float f13 = Utils.dpScale();
                f12 = f12 * f13 * f10;
                paint.setStrokeWidth(f12);
            }
        }
        object3 = this.lottieDrawable;
        n12 = (int)(((LottieDrawable)((Object)object3)).useTextGlyphs() ? 1 : 0);
        if (n12 != 0) {
            this.drawTextGlyphs((DocumentData)object, matrix, (Font)object2, canvas);
        } else {
            this.drawTextWithFont((DocumentData)object, (Font)object2, matrix, canvas);
        }
        canvas.restore();
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean bl2) {
        super.getBounds(rectF, matrix, bl2);
        float f10 = this.composition.getBounds().width();
        float f11 = this.composition.getBounds().height();
        rectF.set(0.0f, 0.0f, f10, f11);
    }
}

