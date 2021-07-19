/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.RectF
 *  android.graphics.Xfermode
 *  android.os.Build$VERSION
 */
package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.PerformanceTracker;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.Mask$MaskMode;
import com.airbnb.lottie.model.layer.BaseLayer$1;
import com.airbnb.lottie.model.layer.BaseLayer$2;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.model.layer.ImageLayer;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.Layer$MatteType;
import com.airbnb.lottie.model.layer.NullLayer;
import com.airbnb.lottie.model.layer.ShapeLayer;
import com.airbnb.lottie.model.layer.SolidLayer;
import com.airbnb.lottie.model.layer.TextLayer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseLayer
implements DrawingContent,
BaseKeyframeAnimation$AnimationListener,
KeyPathElement {
    private static final int CLIP_SAVE_FLAG = 2;
    private static final int CLIP_TO_LAYER_SAVE_FLAG = 16;
    private static final int MATRIX_SAVE_FLAG = 1;
    private static final int SAVE_FLAGS = 19;
    private final List animations;
    public final Matrix boundsMatrix;
    private final Paint clearPaint;
    private final Paint contentPaint;
    private final String drawTraceName;
    private final Paint dstInPaint;
    private final Paint dstOutPaint;
    private FloatKeyframeAnimation inOutAnimation;
    public final Layer layerModel;
    public final LottieDrawable lottieDrawable;
    private MaskKeyframeAnimation mask;
    private final RectF maskBoundsRect;
    private final Matrix matrix;
    private final RectF matteBoundsRect;
    private BaseLayer matteLayer;
    private final Paint mattePaint;
    private boolean outlineMasksAndMattes;
    private Paint outlineMasksAndMattesPaint;
    private BaseLayer parentLayer;
    private List parentLayers;
    private final Path path;
    private final RectF rect;
    private final RectF tempMaskBoundsRect;
    public final TransformKeyframeAnimation transform;
    private boolean visible;

    public BaseLayer(LottieDrawable object, Layer object2) {
        boolean bl2;
        Object object3;
        this.path = object3 = new Path();
        this.matrix = object3;
        int n10 = 1;
        super(n10);
        this.contentPaint = object3;
        Object object4 = PorterDuff.Mode.DST_IN;
        super(n10, (PorterDuff.Mode)object4);
        this.dstInPaint = object3;
        object4 = PorterDuff.Mode.DST_OUT;
        super(n10, (PorterDuff.Mode)object4);
        this.dstOutPaint = object3;
        super(n10);
        this.mattePaint = object3;
        PorterDuff.Mode mode = PorterDuff.Mode.CLEAR;
        super(mode);
        this.clearPaint = object4;
        super();
        this.rect = object4;
        super();
        this.maskBoundsRect = object4;
        super();
        this.matteBoundsRect = object4;
        super();
        this.tempMaskBoundsRect = object4;
        super();
        this.boundsMatrix = object4;
        super();
        this.animations = object4;
        this.visible = n10;
        this.lottieDrawable = object;
        this.layerModel = object2;
        super();
        Object object5 = ((Layer)object2).getName();
        ((StringBuilder)object).append((String)object5);
        ((StringBuilder)object).append("#draw");
        this.drawTraceName = object = ((StringBuilder)object).toString();
        object = ((Layer)object2).getMatteType();
        object5 = Layer$MatteType.INVERT;
        if (object == object5) {
            object5 = PorterDuff.Mode.DST_OUT;
            super((PorterDuff.Mode)object5);
            object3.setXfermode((Xfermode)object);
        } else {
            object5 = PorterDuff.Mode.DST_IN;
            super((PorterDuff.Mode)object5);
            object3.setXfermode((Xfermode)object);
        }
        object = ((Layer)object2).getTransform().createAnimation();
        this.transform = object;
        ((TransformKeyframeAnimation)object).addListener(this);
        object = ((Layer)object2).getMasks();
        if (object != null && !(bl2 = (object = ((Layer)object2).getMasks()).isEmpty())) {
            boolean bl3;
            object2 = ((Layer)object2).getMasks();
            this.mask = object = new MaskKeyframeAnimation((List)object2);
            object = ((MaskKeyframeAnimation)object).getMaskAnimations().iterator();
            while (bl3 = object.hasNext()) {
                object2 = (BaseKeyframeAnimation)object.next();
                ((BaseKeyframeAnimation)object2).addUpdateListener(this);
            }
            object = this.mask.getOpacityAnimations().iterator();
            while (bl3 = object.hasNext()) {
                object2 = (BaseKeyframeAnimation)object.next();
                this.addAnimation((BaseKeyframeAnimation)object2);
                ((BaseKeyframeAnimation)object2).addUpdateListener(this);
            }
        }
        this.setupInOutAnimations();
    }

    public static /* synthetic */ FloatKeyframeAnimation access$000(BaseLayer baseLayer) {
        return baseLayer.inOutAnimation;
    }

    public static /* synthetic */ void access$100(BaseLayer baseLayer, boolean bl2) {
        baseLayer.setVisible(bl2);
    }

    private void applyAddMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation baseKeyframeAnimation, BaseKeyframeAnimation baseKeyframeAnimation2) {
        mask = (Path)baseKeyframeAnimation.getValue();
        this.path.set((Path)mask);
        this.path.transform(matrix);
        matrix = this.contentPaint;
        int n10 = (int)((float)((Integer)baseKeyframeAnimation2.getValue()).intValue() * 2.55f);
        matrix.setAlpha(n10);
        matrix = this.path;
        mask = this.contentPaint;
        canvas.drawPath((Path)matrix, (Paint)mask);
    }

    private void applyIntersectMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation baseKeyframeAnimation, BaseKeyframeAnimation baseKeyframeAnimation2) {
        mask = this.rect;
        Paint paint = this.dstInPaint;
        Utils.saveLayerCompat(canvas, (RectF)mask, paint);
        mask = (Path)baseKeyframeAnimation.getValue();
        this.path.set((Path)mask);
        this.path.transform(matrix);
        matrix = this.contentPaint;
        int n10 = (int)((float)((Integer)baseKeyframeAnimation2.getValue()).intValue() * 2.55f);
        matrix.setAlpha(n10);
        matrix = this.path;
        mask = this.contentPaint;
        canvas.drawPath((Path)matrix, (Paint)mask);
        canvas.restore();
    }

    private void applyInvertedAddMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation baseKeyframeAnimation, BaseKeyframeAnimation baseKeyframeAnimation2) {
        mask = this.rect;
        Paint paint = this.contentPaint;
        Utils.saveLayerCompat(canvas, (RectF)mask, paint);
        mask = this.rect;
        paint = this.contentPaint;
        canvas.drawRect((RectF)mask, paint);
        mask = (Path)baseKeyframeAnimation.getValue();
        this.path.set((Path)mask);
        this.path.transform(matrix);
        matrix = this.contentPaint;
        int n10 = (int)((float)((Integer)baseKeyframeAnimation2.getValue()).intValue() * 2.55f);
        matrix.setAlpha(n10);
        matrix = this.path;
        mask = this.dstOutPaint;
        canvas.drawPath((Path)matrix, (Paint)mask);
        canvas.restore();
    }

    private void applyInvertedIntersectMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation baseKeyframeAnimation, BaseKeyframeAnimation baseKeyframeAnimation2) {
        mask = this.rect;
        Paint paint = this.dstInPaint;
        Utils.saveLayerCompat(canvas, (RectF)mask, paint);
        mask = this.rect;
        paint = this.contentPaint;
        canvas.drawRect((RectF)mask, paint);
        mask = this.dstOutPaint;
        int n10 = (int)((float)((Integer)baseKeyframeAnimation2.getValue()).intValue() * 2.55f);
        mask.setAlpha(n10);
        mask = (Path)baseKeyframeAnimation.getValue();
        this.path.set((Path)mask);
        this.path.transform(matrix);
        matrix = this.path;
        mask = this.dstOutPaint;
        canvas.drawPath((Path)matrix, (Paint)mask);
        canvas.restore();
    }

    private void applyInvertedSubtractMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation baseKeyframeAnimation, BaseKeyframeAnimation baseKeyframeAnimation2) {
        mask = this.rect;
        Paint paint = this.dstOutPaint;
        Utils.saveLayerCompat(canvas, (RectF)mask, paint);
        mask = this.rect;
        paint = this.contentPaint;
        canvas.drawRect((RectF)mask, paint);
        mask = this.dstOutPaint;
        int n10 = (int)((float)((Integer)baseKeyframeAnimation2.getValue()).intValue() * 2.55f);
        mask.setAlpha(n10);
        mask = (Path)baseKeyframeAnimation.getValue();
        this.path.set((Path)mask);
        this.path.transform(matrix);
        matrix = this.path;
        mask = this.dstOutPaint;
        canvas.drawPath((Path)matrix, (Paint)mask);
        canvas.restore();
    }

    private void applyMasks(Canvas canvas, Matrix object) {
        String string2 = "Layer#saveLayer";
        L.beginSection(string2);
        Object object2 = this.rect;
        Object object3 = this.dstInPaint;
        Object object4 = 19;
        Utils.saveLayerCompat(canvas, object2, (Paint)object3, object4);
        Object object5 = Build.VERSION.SDK_INT;
        int n10 = 28;
        if (object5 < n10) {
            this.clearCanvas(canvas);
        }
        L.endSection(string2);
        string2 = null;
        for (int i10 = 0; i10 < (object5 = (object2 = this.mask.getMasks()).size()); ++i10) {
            object2 = this.mask.getMasks().get(i10);
            Object object6 = object2;
            object6 = (Mask)object2;
            Object object7 = object2 = this.mask.getMaskAnimations().get(i10);
            object7 = (BaseKeyframeAnimation)object2;
            Object object8 = object2 = this.mask.getOpacityAnimations().get(i10);
            object8 = (BaseKeyframeAnimation)object2;
            object2 = BaseLayer$2.$SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode;
            object3 = ((Mask)object6).getMaskMode();
            n10 = ((Enum)object3).ordinal();
            object5 = object2[n10];
            n10 = 255;
            object4 = 1;
            if (object5 != object4) {
                object4 = 2;
                if (object5 != object4) {
                    n10 = 3;
                    if (object5 != n10) {
                        n10 = 4;
                        if (object5 != n10) continue;
                        object5 = ((Mask)object6).isInverted();
                        if (object5 != 0) {
                            object3 = this;
                            this.applyInvertedAddMask(canvas, (Matrix)object, (Mask)object6, (BaseKeyframeAnimation)object7, (BaseKeyframeAnimation)object8);
                            continue;
                        }
                        object3 = this;
                        this.applyAddMask(canvas, (Matrix)object, (Mask)object6, (BaseKeyframeAnimation)object7, (BaseKeyframeAnimation)object8);
                        continue;
                    }
                    object5 = ((Mask)object6).isInverted();
                    if (object5 != 0) {
                        object3 = this;
                        this.applyInvertedIntersectMask(canvas, (Matrix)object, (Mask)object6, (BaseKeyframeAnimation)object7, (BaseKeyframeAnimation)object8);
                        continue;
                    }
                    object3 = this;
                    this.applyIntersectMask(canvas, (Matrix)object, (Mask)object6, (BaseKeyframeAnimation)object7, (BaseKeyframeAnimation)object8);
                    continue;
                }
                if (i10 == 0) {
                    object2 = this.contentPaint;
                    object4 = -16777216;
                    object2.setColor(object4);
                    this.contentPaint.setAlpha(n10);
                    object2 = this.rect;
                    object3 = this.contentPaint;
                    canvas.drawRect(object2, (Paint)object3);
                }
                if ((object5 = (Object)((Mask)object6).isInverted()) != 0) {
                    object3 = this;
                    this.applyInvertedSubtractMask(canvas, (Matrix)object, (Mask)object6, (BaseKeyframeAnimation)object7, (BaseKeyframeAnimation)object8);
                    continue;
                }
                object3 = this;
                this.applySubtractMask(canvas, (Matrix)object, (Mask)object6, (BaseKeyframeAnimation)object7, (BaseKeyframeAnimation)object8);
                continue;
            }
            object5 = this.areAllMasksNone();
            if (object5 == 0) continue;
            this.contentPaint.setAlpha(n10);
            object2 = this.rect;
            object3 = this.contentPaint;
            canvas.drawRect(object2, (Paint)object3);
        }
        object = "Layer#restoreLayer";
        L.beginSection((String)object);
        canvas.restore();
        L.endSection((String)object);
    }

    private void applySubtractMask(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation baseKeyframeAnimation, BaseKeyframeAnimation baseKeyframeAnimation2) {
        mask = (Path)baseKeyframeAnimation.getValue();
        this.path.set((Path)mask);
        this.path.transform(matrix);
        matrix = this.path;
        mask = this.dstOutPaint;
        canvas.drawPath((Path)matrix, (Paint)mask);
    }

    private boolean areAllMasksNone() {
        Object object;
        int n10;
        List list = this.mask.getMaskAnimations();
        int n11 = list.isEmpty();
        if (n11 != 0) {
            return false;
        }
        list = null;
        for (n11 = 0; n11 < (n10 = (object = this.mask.getMasks()).size()); ++n11) {
            Mask$MaskMode mask$MaskMode;
            object = ((Mask)this.mask.getMasks().get(n11)).getMaskMode();
            if (object == (mask$MaskMode = Mask$MaskMode.MASK_MODE_NONE)) continue;
            return false;
        }
        return true;
    }

    private void buildParentLayerListIfNeeded() {
        Object object = this.parentLayers;
        if (object != null) {
            return;
        }
        object = this.parentLayer;
        if (object == null) {
            object = Collections.emptyList();
            this.parentLayers = object;
            return;
        }
        object = new ArrayList();
        this.parentLayers = object;
        object = this.parentLayer;
        while (object != null) {
            List list = this.parentLayers;
            list.add(object);
            object = ((BaseLayer)object).parentLayer;
        }
    }

    private void clearCanvas(Canvas canvas) {
        String string2 = "Layer#clearLayer";
        L.beginSection(string2);
        RectF rectF = this.rect;
        float f10 = rectF.left;
        float f11 = 1.0f;
        float f12 = f10 - f11;
        float f13 = rectF.top - f11;
        float f14 = rectF.right + f11;
        float f15 = rectF.bottom + f11;
        Paint paint = this.clearPaint;
        canvas.drawRect(f12, f13, f14, f15, paint);
        L.endSection(string2);
    }

    public static BaseLayer forModel(Layer object, LottieDrawable object2, LottieComposition object3) {
        Object object4 = BaseLayer$2.$SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType;
        Object object5 = object.getLayerType();
        int n10 = object5.ordinal();
        int n11 = object4[n10];
        switch (n11) {
            default: {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Unknown layer type ");
                object = object.getLayerType();
                ((StringBuilder)object2).append(object);
                Logger.warning(((StringBuilder)object2).toString());
                return null;
            }
            case 6: {
                object3 = new TextLayer((LottieDrawable)((Object)object2), (Layer)object);
                return object3;
            }
            case 5: {
                object3 = new NullLayer((LottieDrawable)((Object)object2), (Layer)object);
                return object3;
            }
            case 4: {
                object3 = new ImageLayer((LottieDrawable)((Object)object2), (Layer)object);
                return object3;
            }
            case 3: {
                object3 = new SolidLayer((LottieDrawable)((Object)object2), (Layer)object);
                return object3;
            }
            case 2: {
                object4 = new CompositionLayer;
                object5 = object.getRefId();
                object5 = ((LottieComposition)object3).getPrecomps((String)object5);
                object4((LottieDrawable)((Object)object2), (Layer)object, (List)object5, (LottieComposition)object3);
                return object4;
            }
            case 1: 
        }
        object3 = new ShapeLayer((LottieDrawable)((Object)object2), (Layer)object);
        return object3;
    }

    private void intersectBoundsWithMask(RectF rectF, Matrix matrix) {
        Object object = this.maskBoundsRect;
        object.set(0.0f, 0.0f, 0.0f, 0.0f);
        int n10 = this.hasMasksOnThisLayer();
        if (n10 == 0) {
            return;
        }
        object = this.mask.getMasks();
        n10 = object.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            block8: {
                float f10;
                Mask$MaskMode mask$MaskMode;
                Object object2;
                Mask mask;
                block10: {
                    boolean bl2;
                    block9: {
                        mask = (Mask)this.mask.getMasks().get(i10);
                        object2 = (Path)((BaseKeyframeAnimation)this.mask.getMaskAnimations().get(i10)).getValue();
                        this.path.set(object2);
                        this.path.transform(matrix);
                        object2 = BaseLayer$2.$SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode;
                        mask$MaskMode = mask.getMaskMode();
                        int n11 = mask$MaskMode.ordinal();
                        Path path = object2[n11];
                        n11 = 1;
                        f10 = Float.MIN_VALUE;
                        if (path == n11) break block8;
                        n11 = 2;
                        f10 = 2.8E-45f;
                        if (path == n11) break block8;
                        n11 = 3;
                        f10 = 4.2E-45f;
                        if (path == n11) break block9;
                        n11 = 4;
                        f10 = 5.6E-45f;
                        if (path != n11) break block10;
                    }
                    if (bl2 = mask.isInverted()) {
                        return;
                    }
                }
                mask = this.path;
                object2 = this.tempMaskBoundsRect;
                mask.computeBounds((RectF)object2, false);
                if (i10 == 0) {
                    mask = this.maskBoundsRect;
                    object2 = this.tempMaskBoundsRect;
                    mask.set((RectF)object2);
                    continue;
                }
                mask = this.maskBoundsRect;
                float f11 = ((RectF)mask).left;
                f10 = this.tempMaskBoundsRect.left;
                f11 = Math.min(f11, f10);
                mask$MaskMode = this.maskBoundsRect;
                f10 = ((RectF)mask$MaskMode).top;
                float f12 = this.tempMaskBoundsRect.top;
                f10 = Math.min(f10, f12);
                RectF rectF2 = this.maskBoundsRect;
                f12 = rectF2.right;
                float f13 = this.tempMaskBoundsRect.right;
                f12 = Math.max(f12, f13);
                RectF rectF3 = this.maskBoundsRect;
                f13 = rectF3.bottom;
                RectF rectF4 = this.tempMaskBoundsRect;
                float f14 = rectF4.bottom;
                f13 = Math.max(f13, f14);
                mask.set(f11, f10, f12, f13);
                continue;
            }
            return;
        }
        matrix = this.maskBoundsRect;
        boolean bl3 = rectF.intersect((RectF)matrix);
        if (!bl3) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void intersectBoundsWithMatte(RectF rectF, Matrix matrix) {
        Layer$MatteType layer$MatteType;
        boolean bl2 = this.hasMatteOnThisLayer();
        if (!bl2) {
            return;
        }
        Object object = this.layerModel.getMatteType();
        if (object == (layer$MatteType = Layer$MatteType.INVERT)) {
            return;
        }
        object = this.matteBoundsRect;
        layer$MatteType = null;
        object.set(0.0f, 0.0f, 0.0f, 0.0f);
        object = this.matteLayer;
        RectF rectF2 = this.matteBoundsRect;
        boolean bl3 = true;
        ((BaseLayer)object).getBounds(rectF2, matrix, bl3);
        matrix = this.matteBoundsRect;
        boolean bl4 = rectF.intersect((RectF)matrix);
        if (!bl4) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void invalidateSelf() {
        this.lottieDrawable.invalidateSelf();
    }

    private void recordRenderTime(float f10) {
        PerformanceTracker performanceTracker = this.lottieDrawable.getComposition().getPerformanceTracker();
        String string2 = this.layerModel.getName();
        performanceTracker.recordRenderTime(string2, f10);
    }

    private void setVisible(boolean bl2) {
        boolean bl3 = this.visible;
        if (bl2 != bl3) {
            this.visible = bl2;
            this.invalidateSelf();
        }
    }

    private void setupInOutAnimations() {
        Object object = this.layerModel.getInOutKeyframes();
        boolean bl2 = object.isEmpty();
        boolean bl3 = true;
        if (!bl2) {
            Object object2 = this.layerModel.getInOutKeyframes();
            this.inOutAnimation = object = new FloatKeyframeAnimation((List)object2);
            ((BaseKeyframeAnimation)object).setIsDiscrete();
            object = this.inOutAnimation;
            object2 = new BaseLayer$1(this);
            ((BaseKeyframeAnimation)object).addUpdateListener((BaseKeyframeAnimation$AnimationListener)object2);
            object = (Float)this.inOutAnimation.getValue();
            float f10 = ((Float)object).floatValue();
            float f11 = 1.0f;
            bl2 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
            if (bl2) {
                bl3 = false;
            }
            this.setVisible(bl3);
            object = this.inOutAnimation;
            this.addAnimation((BaseKeyframeAnimation)object);
        } else {
            this.setVisible(bl3);
        }
    }

    public void addAnimation(BaseKeyframeAnimation baseKeyframeAnimation) {
        if (baseKeyframeAnimation == null) {
            return;
        }
        this.animations.add(baseKeyframeAnimation);
    }

    public void addValueCallback(Object object, LottieValueCallback lottieValueCallback) {
        this.transform.applyValueCallback(object, lottieValueCallback);
    }

    public void draw(Canvas canvas, Matrix matrix, int n10) {
        Object object = this.drawTraceName;
        L.beginSection((String)object);
        int n11 = this.visible;
        if (n11 != 0 && (n11 = ((Layer)(object = this.layerModel)).isHidden()) == 0) {
            boolean bl2;
            float f10;
            Matrix matrix2;
            Object object2;
            int n12;
            this.buildParentLayerListIfNeeded();
            object = "Layer#parentMatrix";
            L.beginSection((String)object);
            this.matrix.reset();
            this.matrix.set(matrix);
            Object object3 = this.parentLayers;
            for (n12 = object3.size() + -1; n12 >= 0; n12 += -1) {
                object2 = this.matrix;
                matrix2 = ((BaseLayer)this.parentLayers.get((int)n12)).transform.getMatrix();
                object2.preConcat(matrix2);
            }
            L.endSection((String)object);
            object = this.transform.getOpacity();
            if (object == null) {
                n11 = 100;
                f10 = 1.4E-43f;
            } else {
                object = (Integer)this.transform.getOpacity().getValue();
                n11 = (Integer)object;
            }
            float f11 = n10;
            n12 = 1132396544;
            float f12 = 255.0f;
            f11 /= f12;
            f10 = n11;
            f11 *= f10;
            f10 = 100.0f;
            f11 = f11 / f10 * f12;
            n10 = (int)f11;
            n11 = (int)(this.hasMatteOnThisLayer() ? 1 : 0);
            object3 = "Layer#drawLayer";
            if (n11 == 0 && (n11 = (int)(this.hasMasksOnThisLayer() ? 1 : 0)) == 0) {
                matrix = this.matrix;
                object = this.transform.getMatrix();
                matrix.preConcat((Matrix)object);
                L.beginSection((String)object3);
                matrix = this.matrix;
                this.drawLayer(canvas, matrix, n10);
                L.endSection((String)object3);
                float f13 = L.endSection(this.drawTraceName);
                this.recordRenderTime(f13);
                return;
            }
            object = "Layer#computeBounds";
            L.beginSection((String)object);
            object2 = this.rect;
            matrix2 = this.matrix;
            Paint paint = null;
            this.getBounds((RectF)object2, matrix2, false);
            object2 = this.rect;
            this.intersectBoundsWithMatte((RectF)object2, matrix);
            object2 = this.matrix;
            matrix2 = this.transform.getMatrix();
            object2.preConcat(matrix2);
            object2 = this.rect;
            matrix2 = this.matrix;
            this.intersectBoundsWithMask((RectF)object2, matrix2);
            object2 = this.rect;
            int n13 = canvas.getWidth();
            float f14 = n13;
            int n14 = canvas.getHeight();
            float f15 = n14;
            int n15 = 0;
            boolean bl3 = object2.intersect(0.0f, 0.0f, f14, f15);
            if (!bl3) {
                object2 = this.rect;
                object2.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            L.endSection((String)object);
            object = this.rect;
            n11 = (int)(object.isEmpty() ? 1 : 0);
            if (n11 == 0) {
                object = "Layer#saveLayer";
                L.beginSection((String)object);
                object2 = this.contentPaint;
                n13 = 255;
                f14 = 3.57E-43f;
                object2.setAlpha(n13);
                object2 = this.rect;
                matrix2 = this.contentPaint;
                Utils.saveLayerCompat(canvas, (RectF)object2, (Paint)matrix2);
                L.endSection((String)object);
                this.clearCanvas(canvas);
                L.beginSection((String)object3);
                object2 = this.matrix;
                this.drawLayer(canvas, (Matrix)object2, n10);
                L.endSection((String)object3);
                n12 = (int)(this.hasMasksOnThisLayer() ? 1 : 0);
                if (n12 != 0) {
                    object3 = this.matrix;
                    this.applyMasks(canvas, (Matrix)object3);
                }
                n12 = (int)(this.hasMatteOnThisLayer() ? 1 : 0);
                object2 = "Layer#restoreLayer";
                if (n12 != 0) {
                    object3 = "Layer#drawMatte";
                    L.beginSection((String)object3);
                    L.beginSection((String)object);
                    matrix2 = this.rect;
                    paint = this.mattePaint;
                    n15 = 19;
                    Utils.saveLayerCompat(canvas, (RectF)matrix2, paint, n15);
                    L.endSection((String)object);
                    this.clearCanvas(canvas);
                    object = this.matteLayer;
                    ((BaseLayer)object).draw(canvas, matrix, n10);
                    L.beginSection((String)object2);
                    canvas.restore();
                    L.endSection((String)object2);
                    L.endSection((String)object3);
                }
                L.beginSection((String)object2);
                canvas.restore();
                L.endSection((String)object2);
            }
            if ((bl2 = this.outlineMasksAndMattes) && (matrix = this.outlineMasksAndMattesPaint) != null) {
                Paint.Style style2 = Paint.Style.STROKE;
                matrix.setStyle(style2);
                this.outlineMasksAndMattesPaint.setColor(-251901);
                this.outlineMasksAndMattesPaint.setStrokeWidth(4.0f);
                matrix = this.rect;
                style2 = this.outlineMasksAndMattesPaint;
                canvas.drawRect((RectF)matrix, (Paint)style2);
                matrix = this.outlineMasksAndMattesPaint;
                style2 = Paint.Style.FILL;
                matrix.setStyle(style2);
                matrix = this.outlineMasksAndMattesPaint;
                n10 = 1357638635;
                f11 = 3.1664855E10f;
                matrix.setColor(n10);
                matrix = this.rect;
                style2 = this.outlineMasksAndMattesPaint;
                canvas.drawRect((RectF)matrix, (Paint)style2);
            }
            float f16 = L.endSection(this.drawTraceName);
            this.recordRenderTime(f16);
            return;
        }
        L.endSection(this.drawTraceName);
    }

    public abstract void drawLayer(Canvas var1, Matrix var2, int var3);

    public void getBounds(RectF object, Matrix matrix, boolean bl2) {
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.buildParentLayerListIfNeeded();
        object = this.boundsMatrix;
        object.set(matrix);
        if (bl2) {
            object = this.parentLayers;
            if (object != null) {
                for (int i10 = object.size() + -1; i10 >= 0; i10 += -1) {
                    matrix = this.boundsMatrix;
                    Matrix matrix2 = ((BaseLayer)this.parentLayers.get((int)i10)).transform.getMatrix();
                    matrix.preConcat(matrix2);
                }
            } else {
                object = this.parentLayer;
                if (object != null) {
                    matrix = this.boundsMatrix;
                    object = ((BaseLayer)object).transform.getMatrix();
                    matrix.preConcat((Matrix)object);
                }
            }
        }
        object = this.boundsMatrix;
        matrix = this.transform.getMatrix();
        object.preConcat(matrix);
    }

    public Layer getLayerModel() {
        return this.layerModel;
    }

    public String getName() {
        return this.layerModel.getName();
    }

    public boolean hasMasksOnThisLayer() {
        boolean bl2;
        Object object = this.mask;
        if (object != null && !(bl2 = (object = ((MaskKeyframeAnimation)object).getMaskAnimations()).isEmpty())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean hasMatteOnThisLayer() {
        boolean bl2;
        BaseLayer baseLayer = this.matteLayer;
        if (baseLayer != null) {
            bl2 = true;
        } else {
            bl2 = false;
            baseLayer = null;
        }
        return bl2;
    }

    public void onValueChanged() {
        this.invalidateSelf();
    }

    public void removeAnimation(BaseKeyframeAnimation baseKeyframeAnimation) {
        this.animations.remove(baseKeyframeAnimation);
    }

    public void resolveChildKeyPath(KeyPath keyPath, int n10, List list, KeyPath keyPath2) {
    }

    public void resolveKeyPath(KeyPath keyPath, int n10, List list, KeyPath keyPath2) {
        Object object = this.getName();
        int n11 = keyPath.matches((String)object, n10);
        if (n11 == 0) {
            return;
        }
        String string2 = "__container";
        object = this.getName();
        n11 = string2.equals(object);
        if (n11 == 0) {
            object = this.getName();
            keyPath2 = keyPath2.addKey((String)object);
            object = this.getName();
            n11 = keyPath.fullyResolvesTo((String)object, n10);
            if (n11 != 0) {
                object = keyPath2.resolve(this);
                list.add(object);
            }
        }
        if ((n11 = keyPath.propagateToChildren((String)(object = this.getName()), n10)) != 0) {
            object = this.getName();
            n11 = keyPath.incrementDepthBy((String)object, n10);
            this.resolveChildKeyPath(keyPath, n10 += n11, list, keyPath2);
        }
    }

    public void setContents(List list, List list2) {
    }

    public void setMatteLayer(BaseLayer baseLayer) {
        this.matteLayer = baseLayer;
    }

    public void setOutlineMasksAndMattes(boolean bl2) {
        Paint paint;
        if (bl2 && (paint = this.outlineMasksAndMattesPaint) == null) {
            this.outlineMasksAndMattesPaint = paint = new LPaint();
        }
        this.outlineMasksAndMattes = bl2;
    }

    public void setParentLayer(BaseLayer baseLayer) {
        this.parentLayer = baseLayer;
    }

    public void setProgress(float f10) {
        Object object;
        int n10;
        int n11;
        float f11;
        this.transform.setProgress(f10);
        Object object2 = this.mask;
        int n12 = 0;
        if (object2 != null) {
            object2 = null;
            f11 = 0.0f;
            for (n11 = 0; n11 < (n10 = (object = this.mask.getMaskAnimations()).size()); ++n11) {
                object = (BaseKeyframeAnimation)this.mask.getMaskAnimations().get(n11);
                ((BaseKeyframeAnimation)object).setProgress(f10);
            }
        }
        object2 = this.layerModel;
        f11 = ((Layer)object2).getTimeStretch();
        n10 = 0;
        float f12 = 0.0f;
        object = null;
        float f13 = f11 - 0.0f;
        n11 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
        if (n11 != 0) {
            object2 = this.layerModel;
            f11 = ((Layer)object2).getTimeStretch();
            f10 /= f11;
        }
        if ((object2 = this.inOutAnimation) != null) {
            object = this.layerModel;
            f12 = ((Layer)object).getTimeStretch();
            f12 = f10 / f12;
            ((BaseKeyframeAnimation)object2).setProgress(f12);
        }
        if ((object2 = this.matteLayer) != null) {
            object2 = ((BaseLayer)object2).layerModel;
            f11 = ((Layer)object2).getTimeStretch();
            object = this.matteLayer;
            ((BaseLayer)object).setProgress(f11 *= f10);
        }
        while (n12 < (n11 = (object2 = this.animations).size())) {
            object2 = (BaseKeyframeAnimation)this.animations.get(n12);
            ((BaseKeyframeAnimation)object2).setProgress(f10);
            ++n12;
        }
    }
}

