/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.PointF
 */
package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;
import java.util.List;

public class TransformKeyframeAnimation {
    private BaseKeyframeAnimation anchorPoint;
    private BaseKeyframeAnimation endOpacity;
    private final Matrix matrix;
    private BaseKeyframeAnimation opacity;
    private BaseKeyframeAnimation position;
    private BaseKeyframeAnimation rotation;
    private BaseKeyframeAnimation scale;
    private FloatKeyframeAnimation skew;
    private FloatKeyframeAnimation skewAngle;
    private final Matrix skewMatrix1;
    private final Matrix skewMatrix2;
    private final Matrix skewMatrix3;
    private final float[] skewValues;
    private BaseKeyframeAnimation startOpacity;

    public TransformKeyframeAnimation(AnimatableTransform object) {
        int n10;
        Object object2;
        this.matrix = object2 = new Matrix();
        object2 = ((AnimatableTransform)object).getAnchorPoint();
        if (object2 == null) {
            n10 = 0;
            object2 = null;
        } else {
            object2 = ((AnimatableTransform)object).getAnchorPoint().createAnimation();
        }
        this.anchorPoint = object2;
        object2 = ((AnimatableTransform)object).getPosition();
        if (object2 == null) {
            n10 = 0;
            object2 = null;
        } else {
            object2 = ((AnimatableTransform)object).getPosition().createAnimation();
        }
        this.position = object2;
        object2 = ((AnimatableTransform)object).getScale();
        if (object2 == null) {
            n10 = 0;
            object2 = null;
        } else {
            object2 = ((AnimatableTransform)object).getScale().createAnimation();
        }
        this.scale = object2;
        object2 = ((AnimatableTransform)object).getRotation();
        if (object2 == null) {
            n10 = 0;
            object2 = null;
        } else {
            object2 = ((AnimatableTransform)object).getRotation().createAnimation();
        }
        this.rotation = object2;
        object2 = ((AnimatableTransform)object).getSkew();
        if (object2 == null) {
            n10 = 0;
            object2 = null;
        } else {
            object2 = (FloatKeyframeAnimation)((AnimatableTransform)object).getSkew().createAnimation();
        }
        this.skew = object2;
        if (object2 != null) {
            this.skewMatrix1 = object2 = new Matrix();
            this.skewMatrix2 = object2 = new Matrix();
            this.skewMatrix3 = object2 = new Matrix();
            n10 = 9;
            object2 = new float[n10];
            this.skewValues = (float[])object2;
        } else {
            this.skewMatrix1 = null;
            this.skewMatrix2 = null;
            this.skewMatrix3 = null;
            this.skewValues = null;
        }
        object2 = ((AnimatableTransform)object).getSkewAngle();
        if (object2 == null) {
            n10 = 0;
            object2 = null;
        } else {
            object2 = (FloatKeyframeAnimation)((AnimatableTransform)object).getSkewAngle().createAnimation();
        }
        this.skewAngle = object2;
        object2 = ((AnimatableTransform)object).getOpacity();
        if (object2 != null) {
            object2 = ((AnimatableTransform)object).getOpacity().createAnimation();
            this.opacity = object2;
        }
        if ((object2 = ((AnimatableTransform)object).getStartOpacity()) != null) {
            object2 = ((AnimatableTransform)object).getStartOpacity().createAnimation();
            this.startOpacity = object2;
        } else {
            this.startOpacity = null;
        }
        object2 = ((AnimatableTransform)object).getEndOpacity();
        this.endOpacity = object2 != null ? (object = ((AnimatableTransform)object).getEndOpacity().createAnimation()) : null;
    }

    private void clearSkewValues() {
        int n10;
        for (int i10 = 0; i10 < (n10 = 9); ++i10) {
            float[] fArray = this.skewValues;
            fArray[i10] = 0.0f;
        }
    }

    public void addAnimationsToLayer(BaseLayer baseLayer) {
        BaseKeyframeAnimation baseKeyframeAnimation = this.opacity;
        baseLayer.addAnimation(baseKeyframeAnimation);
        baseKeyframeAnimation = this.startOpacity;
        baseLayer.addAnimation(baseKeyframeAnimation);
        baseKeyframeAnimation = this.endOpacity;
        baseLayer.addAnimation(baseKeyframeAnimation);
        baseKeyframeAnimation = this.anchorPoint;
        baseLayer.addAnimation(baseKeyframeAnimation);
        baseKeyframeAnimation = this.position;
        baseLayer.addAnimation(baseKeyframeAnimation);
        baseKeyframeAnimation = this.scale;
        baseLayer.addAnimation(baseKeyframeAnimation);
        baseKeyframeAnimation = this.rotation;
        baseLayer.addAnimation(baseKeyframeAnimation);
        baseKeyframeAnimation = this.skew;
        baseLayer.addAnimation(baseKeyframeAnimation);
        baseKeyframeAnimation = this.skewAngle;
        baseLayer.addAnimation(baseKeyframeAnimation);
    }

    public void addListener(BaseKeyframeAnimation$AnimationListener baseKeyframeAnimation$AnimationListener) {
        BaseKeyframeAnimation baseKeyframeAnimation = this.opacity;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.addUpdateListener(baseKeyframeAnimation$AnimationListener);
        }
        if ((baseKeyframeAnimation = this.startOpacity) != null) {
            baseKeyframeAnimation.addUpdateListener(baseKeyframeAnimation$AnimationListener);
        }
        if ((baseKeyframeAnimation = this.endOpacity) != null) {
            baseKeyframeAnimation.addUpdateListener(baseKeyframeAnimation$AnimationListener);
        }
        if ((baseKeyframeAnimation = this.anchorPoint) != null) {
            baseKeyframeAnimation.addUpdateListener(baseKeyframeAnimation$AnimationListener);
        }
        if ((baseKeyframeAnimation = this.position) != null) {
            baseKeyframeAnimation.addUpdateListener(baseKeyframeAnimation$AnimationListener);
        }
        if ((baseKeyframeAnimation = this.scale) != null) {
            baseKeyframeAnimation.addUpdateListener(baseKeyframeAnimation$AnimationListener);
        }
        if ((baseKeyframeAnimation = this.rotation) != null) {
            baseKeyframeAnimation.addUpdateListener(baseKeyframeAnimation$AnimationListener);
        }
        if ((baseKeyframeAnimation = this.skew) != null) {
            baseKeyframeAnimation.addUpdateListener(baseKeyframeAnimation$AnimationListener);
        }
        if ((baseKeyframeAnimation = this.skewAngle) != null) {
            baseKeyframeAnimation.addUpdateListener(baseKeyframeAnimation$AnimationListener);
        }
    }

    public boolean applyValueCallback(Object object, LottieValueCallback lottieValueCallback) {
        block28: {
            block20: {
                Float f10;
                Object object2;
                block27: {
                    block26: {
                        int n10;
                        block25: {
                            block24: {
                                block23: {
                                    block22: {
                                        block21: {
                                            block19: {
                                                object2 = LottieProperty.TRANSFORM_ANCHOR_POINT;
                                                if (object != object2) break block19;
                                                object = this.anchorPoint;
                                                if (object == null) {
                                                    object2 = new PointF();
                                                    this.anchorPoint = object = new ValueCallbackKeyframeAnimation(lottieValueCallback, object2);
                                                } else {
                                                    ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
                                                }
                                                break block20;
                                            }
                                            object2 = LottieProperty.TRANSFORM_POSITION;
                                            if (object != object2) break block21;
                                            object = this.position;
                                            if (object == null) {
                                                object2 = new PointF();
                                                this.position = object = new ValueCallbackKeyframeAnimation(lottieValueCallback, object2);
                                            } else {
                                                ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
                                            }
                                            break block20;
                                        }
                                        object2 = LottieProperty.TRANSFORM_SCALE;
                                        if (object != object2) break block22;
                                        object = this.scale;
                                        if (object == null) {
                                            object2 = new ScaleXY();
                                            this.scale = object = new ValueCallbackKeyframeAnimation(lottieValueCallback, object2);
                                        } else {
                                            ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
                                        }
                                        break block20;
                                    }
                                    object2 = LottieProperty.TRANSFORM_ROTATION;
                                    f10 = null;
                                    if (object != object2) break block23;
                                    object = this.rotation;
                                    if (object == null) {
                                        object2 = Float.valueOf(0.0f);
                                        this.rotation = object = new ValueCallbackKeyframeAnimation(lottieValueCallback, object2);
                                    } else {
                                        ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
                                    }
                                    break block20;
                                }
                                object2 = LottieProperty.TRANSFORM_OPACITY;
                                n10 = 100;
                                if (object != object2) break block24;
                                object = this.opacity;
                                if (object == null) {
                                    object2 = n10;
                                    this.opacity = object = new ValueCallbackKeyframeAnimation(lottieValueCallback, object2);
                                } else {
                                    ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
                                }
                                break block20;
                            }
                            object2 = LottieProperty.TRANSFORM_START_OPACITY;
                            if (object != object2 || (object2 = this.startOpacity) == null) break block25;
                            if (object2 == null) {
                                object2 = n10;
                                this.startOpacity = object = new ValueCallbackKeyframeAnimation(lottieValueCallback, object2);
                            } else {
                                object2.setValueCallback(lottieValueCallback);
                            }
                            break block20;
                        }
                        object2 = LottieProperty.TRANSFORM_END_OPACITY;
                        if (object != object2 || (object2 = this.endOpacity) == null) break block26;
                        if (object2 == null) {
                            object2 = n10;
                            this.endOpacity = object = new ValueCallbackKeyframeAnimation(lottieValueCallback, object2);
                        } else {
                            object2.setValueCallback(lottieValueCallback);
                        }
                        break block20;
                    }
                    object2 = LottieProperty.TRANSFORM_SKEW;
                    if (object != object2 || (object2 = this.skew) == null) break block27;
                    if (object2 == null) {
                        f10 = Float.valueOf(0.0f);
                        object2 = new Keyframe(f10);
                        object2 = Collections.singletonList(object2);
                        this.skew = object = new FloatKeyframeAnimation((List)object2);
                    }
                    object = this.skew;
                    ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
                    break block20;
                }
                object2 = LottieProperty.TRANSFORM_SKEW_ANGLE;
                if (object != object2 || (object = this.skewAngle) == null) break block28;
                if (object == null) {
                    f10 = Float.valueOf(0.0f);
                    object2 = new Keyframe(f10);
                    object2 = Collections.singletonList(object2);
                    this.skewAngle = object = new FloatKeyframeAnimation((List)object2);
                }
                object = this.skewAngle;
                ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
            }
            return true;
        }
        return false;
    }

    public BaseKeyframeAnimation getEndOpacity() {
        return this.endOpacity;
    }

    public Matrix getMatrix() {
        float f10;
        float f11;
        Matrix matrix;
        int n10;
        float f12;
        Matrix matrix2;
        float f13;
        Object object;
        float f14;
        this.matrix.reset();
        Object object2 = this.position;
        boolean bl2 = false;
        Matrix matrix3 = null;
        if (object2 != null) {
            float f15;
            object2 = (PointF)((BaseKeyframeAnimation)object2).getValue();
            f14 = ((PointF)object2).x;
            float f16 = f14 - 0.0f;
            object = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
            if (object != false || (object = (f15 = (f13 = ((PointF)object2).y) - 0.0f) == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1)) != false) {
                matrix2 = this.matrix;
                f12 = ((PointF)object2).y;
                matrix2.preTranslate(f14, f12);
            }
        }
        if ((object2 = this.rotation) != null) {
            float f17;
            n10 = object2 instanceof ValueCallbackKeyframeAnimation;
            if (n10 != 0) {
                object2 = (Float)((BaseKeyframeAnimation)object2).getValue();
                f12 = ((Float)object2).floatValue();
            } else {
                object2 = (FloatKeyframeAnimation)object2;
                f12 = ((FloatKeyframeAnimation)object2).getFloatValue();
            }
            n10 = (int)((f17 = f12 - 0.0f) == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1));
            if (n10 != 0) {
                matrix = this.matrix;
                matrix.preRotate(f12);
            }
        }
        object2 = this.skew;
        n10 = 1065353216;
        f14 = 1.0f;
        if (object2 != null) {
            float f18;
            double d10;
            object2 = this.skewAngle;
            object = 1119092736;
            f13 = 90.0f;
            if (object2 == null) {
                object2 = null;
                f12 = 0.0f;
            } else {
                d10 = Math.cos(Math.toRadians(-((FloatKeyframeAnimation)object2).getFloatValue() + f13));
                f12 = (float)d10;
            }
            Object object3 = this.skewAngle;
            if (object3 == null) {
                object = n10;
                f13 = f14;
            } else {
                f18 = -((FloatKeyframeAnimation)object3).getFloatValue() + f13;
                double d11 = Math.sin(Math.toRadians(f18));
                f13 = (float)d11;
            }
            d10 = Math.tan(Math.toRadians(this.skew.getFloatValue()));
            f18 = (float)d10;
            this.clearSkewValues();
            float[] fArray = this.skewValues;
            fArray[0] = f12;
            int n11 = 1;
            fArray[n11] = f13;
            float f19 = -f13;
            int n12 = 3;
            fArray[n12] = f19;
            int n13 = 4;
            fArray[n13] = f12;
            int n14 = 8;
            fArray[n14] = f14;
            Matrix matrix4 = this.skewMatrix1;
            matrix4.setValues(fArray);
            this.clearSkewValues();
            fArray = this.skewValues;
            fArray[0] = f14;
            fArray[n12] = f18;
            fArray[n13] = f14;
            fArray[n14] = f14;
            this.skewMatrix2.setValues(fArray);
            this.clearSkewValues();
            object3 = this.skewValues;
            object3[0] = f12;
            object3[n11] = f19;
            object3[n12] = f13;
            object3[n13] = f12;
            object3[n14] = f14;
            this.skewMatrix3.setValues((float[])object3);
            object2 = this.skewMatrix2;
            matrix2 = this.skewMatrix1;
            object2.preConcat(matrix2);
            object2 = this.skewMatrix3;
            matrix2 = this.skewMatrix2;
            object2.preConcat(matrix2);
            object2 = this.matrix;
            matrix2 = this.skewMatrix3;
            object2.preConcat(matrix2);
        }
        if ((object2 = this.scale) != null && ((object = (f11 = (f13 = ((ScaleXY)(object2 = (ScaleXY)((BaseKeyframeAnimation)object2).getValue())).getScaleX()) - f14) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false || (n10 = (int)((f10 = (f13 = ((ScaleXY)object2).getScaleY()) - f14) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1))) != 0)) {
            matrix = this.matrix;
            f13 = ((ScaleXY)object2).getScaleX();
            f12 = ((ScaleXY)object2).getScaleY();
            matrix.preScale(f13, f12);
        }
        if ((object2 = this.anchorPoint) != null) {
            float f20;
            object2 = (PointF)((BaseKeyframeAnimation)object2).getValue();
            f14 = ((PointF)object2).x;
            float f21 = f14 - 0.0f;
            object = f21 == 0.0f ? 0 : (f21 > 0.0f ? 1 : -1);
            if (object != false || (bl2 = (f20 = (f13 = ((PointF)object2).y) - 0.0f) == 0.0f ? 0 : (f20 > 0.0f ? 1 : -1))) {
                matrix3 = this.matrix;
                f14 = -f14;
                f12 = -((PointF)object2).y;
                matrix3.preTranslate(f14, f12);
            }
        }
        return this.matrix;
    }

    public Matrix getMatrixForRepeater(float f10) {
        float f11;
        float f12;
        float f13;
        Object object = this.position;
        PointF pointF = null;
        if (object == null) {
            object = null;
            f13 = 0.0f;
        } else {
            object = (PointF)((BaseKeyframeAnimation)object).getValue();
        }
        Object object2 = this.scale;
        if (object2 == null) {
            object2 = null;
            f12 = 0.0f;
        } else {
            object2 = (ScaleXY)((BaseKeyframeAnimation)object2).getValue();
        }
        Matrix matrix = this.matrix;
        matrix.reset();
        if (object != null) {
            matrix = this.matrix;
            float f14 = ((PointF)object).x * f10;
            f13 = ((PointF)object).y * f10;
            matrix.preTranslate(f14, f13);
        }
        if (object2 != null) {
            object = this.matrix;
            double d10 = ((ScaleXY)object2).getScaleX();
            double d11 = f10;
            d10 = Math.pow(d10, d11);
            f11 = (float)d10;
            double d12 = ((ScaleXY)object2).getScaleY();
            double d13 = Math.pow(d12, d11);
            f12 = (float)d13;
            object.preScale(f11, f12);
        }
        if ((object = this.rotation) != null) {
            object = (Float)((BaseKeyframeAnimation)object).getValue();
            f13 = ((Float)object).floatValue();
            object2 = this.anchorPoint;
            if (object2 != null) {
                pointF = (PointF)((BaseKeyframeAnimation)object2).getValue();
            }
            object2 = this.matrix;
            f13 *= f10;
            f10 = 0.0f;
            if (pointF == null) {
                matrix = null;
                f11 = 0.0f;
            } else {
                f11 = pointF.x;
            }
            if (pointF != null) {
                f10 = pointF.y;
            }
            object2.preRotate(f13, f11, f10);
        }
        return this.matrix;
    }

    public BaseKeyframeAnimation getOpacity() {
        return this.opacity;
    }

    public BaseKeyframeAnimation getStartOpacity() {
        return this.startOpacity;
    }

    public void setProgress(float f10) {
        BaseKeyframeAnimation baseKeyframeAnimation = this.opacity;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.setProgress(f10);
        }
        if ((baseKeyframeAnimation = this.startOpacity) != null) {
            baseKeyframeAnimation.setProgress(f10);
        }
        if ((baseKeyframeAnimation = this.endOpacity) != null) {
            baseKeyframeAnimation.setProgress(f10);
        }
        if ((baseKeyframeAnimation = this.anchorPoint) != null) {
            baseKeyframeAnimation.setProgress(f10);
        }
        if ((baseKeyframeAnimation = this.position) != null) {
            baseKeyframeAnimation.setProgress(f10);
        }
        if ((baseKeyframeAnimation = this.scale) != null) {
            baseKeyframeAnimation.setProgress(f10);
        }
        if ((baseKeyframeAnimation = this.rotation) != null) {
            baseKeyframeAnimation.setProgress(f10);
        }
        if ((baseKeyframeAnimation = this.skew) != null) {
            baseKeyframeAnimation.setProgress(f10);
        }
        if ((baseKeyframeAnimation = this.skewAngle) != null) {
            baseKeyframeAnimation.setProgress(f10);
        }
    }
}

