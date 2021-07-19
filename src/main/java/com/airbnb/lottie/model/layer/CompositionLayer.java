/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.RectF
 */
package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.CompositionLayer$1;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.ShapeLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositionLayer
extends BaseLayer {
    private Boolean hasMasks;
    private Boolean hasMatte;
    private Paint layerPaint;
    private final List layers;
    private final RectF newClipRect;
    private final RectF rect;
    private BaseKeyframeAnimation timeRemapping;

    public CompositionLayer(LottieDrawable object, Layer object2, List object3, LottieComposition lottieComposition) {
        super((LottieDrawable)((Object)object), (Layer)object2);
        int n10;
        int n11;
        RectF rectF;
        this.layers = rectF = new ArrayList();
        this.rect = rectF = new RectF();
        this.newClipRect = rectF = new RectF();
        super();
        this.layerPaint = rectF;
        object2 = ((Layer)object2).getTimeRemapping();
        rectF = null;
        if (object2 != null) {
            this.timeRemapping = object2 = ((AnimatableFloatValue)object2).createAnimation();
            this.addAnimation((BaseKeyframeAnimation)object2);
            object2 = this.timeRemapping;
            ((BaseKeyframeAnimation)object2).addUpdateListener(this);
        } else {
            this.timeRemapping = null;
        }
        List list = lottieComposition.getLayers();
        int n12 = list.size();
        object2 = new LongSparseArray(n12);
        n12 = object3.size();
        int n13 = 1;
        n12 -= n13;
        BaseLayer baseLayer = null;
        while (true) {
            int[] nArray = null;
            if (n12 < 0) break;
            Object object4 = (Layer)object3.get(n12);
            BaseLayer baseLayer2 = BaseLayer.forModel((Layer)object4, (LottieDrawable)((Object)object), lottieComposition);
            if (baseLayer2 != null) {
                Object object5 = baseLayer2.getLayerModel();
                long l10 = ((Layer)object5).getId();
                ((LongSparseArray)object2).put(l10, baseLayer2);
                if (baseLayer != null) {
                    baseLayer.setMatteLayer(baseLayer2);
                    baseLayer = null;
                } else {
                    object5 = this.layers;
                    object5.add(0, baseLayer2);
                    nArray = CompositionLayer$1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType;
                    object4 = ((Layer)object4).getMatteType();
                    int n14 = ((Enum)object4).ordinal();
                    n11 = nArray[n14];
                    if (n11 == n13 || n11 == (n14 = 2)) {
                        baseLayer = baseLayer2;
                    }
                }
            }
            n12 += -1;
        }
        for (n11 = 0; n11 < (n10 = ((LongSparseArray)object2).size()); ++n11) {
            long l11 = ((LongSparseArray)object2).keyAt(n11);
            object = (BaseLayer)((LongSparseArray)object2).get(l11);
            if (object == null || (object3 = (BaseLayer)((LongSparseArray)object2).get(l11 = ((BaseLayer)object).getLayerModel().getParentId())) == null) continue;
            ((BaseLayer)object).setParentLayer((BaseLayer)object3);
        }
    }

    public void addValueCallback(Object object, LottieValueCallback lottieValueCallback) {
        super.addValueCallback(object, lottieValueCallback);
        Float f10 = LottieProperty.TIME_REMAP;
        if (object == f10) {
            if (lottieValueCallback == null) {
                object = this.timeRemapping;
                if (object != null) {
                    lottieValueCallback = null;
                    ((BaseKeyframeAnimation)object).setValueCallback(null);
                }
            } else {
                this.timeRemapping = object = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                ((BaseKeyframeAnimation)object).addUpdateListener(this);
                object = this.timeRemapping;
                this.addAnimation((BaseKeyframeAnimation)object);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public void drawLayer(Canvas canvas, Matrix matrix, int n10) {
        void var11_15;
        int n11;
        String string2 = "CompositionLayer#draw";
        L.beginSection(string2);
        Object object = this.newClipRect;
        Object object2 = this.layerModel;
        float f10 = ((Layer)object2).getPreCompWidth();
        Layer layer = this.layerModel;
        float f11 = layer.getPreCompHeight();
        RectF rectF = null;
        object.set(0.0f, 0.0f, f10, f11);
        object = this.newClipRect;
        matrix.mapRect((RectF)object);
        object = this.lottieDrawable;
        boolean n112 = ((LottieDrawable)((Object)object)).isApplyingOpacityToLayersEnabled();
        int n12 = 255;
        f10 = 3.57E-43f;
        int n13 = 1;
        f11 = Float.MIN_VALUE;
        if (n112 && (n11 = (object = this.layers).size()) > n13 && n10 != n12) {
            int n14 = n13;
        } else {
            boolean bl2 = false;
            object = null;
        }
        if (var11_15 != false) {
            this.layerPaint.setAlpha(n10);
            rectF = this.newClipRect;
            Paint paint = this.layerPaint;
            Utils.saveLayerCompat(canvas, rectF, paint);
        } else {
            canvas.save();
        }
        if (var11_15 != false) {
            n10 = n12;
        }
        object = this.layers;
        int n15 = object.size() - n13;
        while ((var11_17 += -1) >= 0) {
            void var11_17;
            object2 = this.newClipRect;
            n12 = (int)(object2.isEmpty() ? 1 : 0);
            if (n12 == 0) {
                object2 = this.newClipRect;
                n12 = (int)(canvas.clipRect((RectF)object2) ? 1 : 0);
            } else {
                n12 = n13;
                f10 = f11;
            }
            if (n12 == 0) continue;
            object2 = (BaseLayer)this.layers.get((int)var11_17);
            ((BaseLayer)object2).draw(canvas, matrix, n10);
        }
        canvas.restore();
        L.endSection(string2);
    }

    public void getBounds(RectF rectF, Matrix object, boolean bl2) {
        super.getBounds(rectF, (Matrix)object, bl2);
        object = this.layers;
        int n10 = object.size();
        bl2 = true;
        n10 -= bl2;
        while (n10 >= 0) {
            this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
            BaseLayer baseLayer = (BaseLayer)this.layers.get(n10);
            RectF rectF2 = this.rect;
            Matrix matrix = this.boundsMatrix;
            baseLayer.getBounds(rectF2, matrix, bl2);
            baseLayer = this.rect;
            rectF.union((RectF)baseLayer);
            n10 += -1;
        }
    }

    public boolean hasMasks() {
        Boolean bl2 = Boolean.TRUE;
        Object object = this.hasMasks;
        if (object == null) {
            object = this.layers;
            int n10 = object.size();
            int n11 = 1;
            n10 -= n11;
            while (n10 >= 0) {
                boolean bl3;
                BaseLayer baseLayer = (BaseLayer)this.layers.get(n10);
                boolean bl4 = baseLayer instanceof ShapeLayer;
                if (bl4) {
                    bl3 = baseLayer.hasMasksOnThisLayer();
                    if (bl3) {
                        this.hasMasks = bl2;
                        return n11 != 0;
                    }
                } else {
                    bl4 = baseLayer instanceof CompositionLayer;
                    if (bl4 && (bl3 = ((CompositionLayer)(baseLayer = (CompositionLayer)baseLayer)).hasMasks())) {
                        this.hasMasks = bl2;
                        return n11 != 0;
                    }
                }
                n10 += -1;
            }
            this.hasMasks = bl2 = Boolean.FALSE;
        }
        return this.hasMasks;
    }

    public boolean hasMatte() {
        Boolean bl2 = Boolean.TRUE;
        Object object = this.hasMatte;
        if (object == null) {
            int n10 = this.hasMatteOnThisLayer();
            int n11 = 1;
            if (n10 != 0) {
                this.hasMatte = bl2;
                return n11 != 0;
            }
            object = this.layers;
            for (n10 = object.size() - n11; n10 >= 0; n10 += -1) {
                BaseLayer baseLayer = (BaseLayer)this.layers.get(n10);
                boolean bl3 = baseLayer.hasMatteOnThisLayer();
                if (!bl3) continue;
                this.hasMatte = bl2;
                return n11 != 0;
            }
            this.hasMatte = bl2 = Boolean.FALSE;
        }
        return this.hasMatte;
    }

    public void resolveChildKeyPath(KeyPath keyPath, int n10, List list, KeyPath keyPath2) {
        Object object;
        int n11;
        for (int i10 = 0; i10 < (n11 = (object = this.layers).size()); ++i10) {
            object = (BaseLayer)this.layers.get(i10);
            ((BaseLayer)object).resolveKeyPath(keyPath, n10, list, keyPath2);
        }
    }

    public void setOutlineMasksAndMattes(boolean bl2) {
        boolean bl3;
        super.setOutlineMasksAndMattes(bl2);
        Iterator iterator2 = this.layers.iterator();
        while (bl3 = iterator2.hasNext()) {
            BaseLayer baseLayer = (BaseLayer)iterator2.next();
            baseLayer.setOutlineMasksAndMattes(bl2);
        }
    }

    public void setProgress(float f10) {
        float f11;
        Object object;
        float f12;
        int n10;
        super.setProgress(f10);
        Object object2 = this.timeRemapping;
        if (object2 != null) {
            LottieComposition lottieComposition = this.lottieDrawable.getComposition();
            f10 = lottieComposition.getDurationFrames();
            n10 = 1008981770;
            f10 += 0.01f;
            object2 = this.layerModel.getComposition();
            f12 = ((LottieComposition)object2).getStartFrame();
            object = (Float)this.timeRemapping.getValue();
            f11 = ((Float)object).floatValue();
            LottieComposition lottieComposition2 = this.layerModel.getComposition();
            float f13 = lottieComposition2.getFrameRate();
            f11 = f11 * f13 - f12;
            f10 = f11 / f10;
        }
        if ((object2 = this.timeRemapping) == null) {
            object2 = this.layerModel;
            f12 = ((Layer)object2).getStartProgress();
            f10 -= f12;
        }
        object2 = this.layerModel;
        f12 = ((Layer)object2).getTimeStretch();
        f11 = 0.0f;
        object = null;
        float f14 = f12 - 0.0f;
        n10 = (int)(f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1));
        if (n10 != 0) {
            object2 = this.layerModel;
            f12 = ((Layer)object2).getTimeStretch();
            f10 /= f12;
        }
        object2 = this.layers;
        for (n10 = object2.size() + -1; n10 >= 0; n10 += -1) {
            object = (BaseLayer)this.layers.get(n10);
            ((BaseLayer)object).setProgress(f10);
        }
    }
}

