/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PointF
 */
package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.CompoundTrimPathContent;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.content.PathContent;
import com.airbnb.lottie.animation.content.PolystarContent$1;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.PolystarShape$Type;
import com.airbnb.lottie.model.content.ShapeTrimPath$Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PolystarContent
implements PathContent,
BaseKeyframeAnimation$AnimationListener,
KeyPathElementContent {
    private static final float POLYGON_MAGIC_NUMBER = 0.25f;
    private static final float POLYSTAR_MAGIC_NUMBER = 0.47829f;
    private final boolean hidden;
    private final BaseKeyframeAnimation innerRadiusAnimation;
    private final BaseKeyframeAnimation innerRoundednessAnimation;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation outerRadiusAnimation;
    private final BaseKeyframeAnimation outerRoundednessAnimation;
    private final Path path;
    private final BaseKeyframeAnimation pointsAnimation;
    private final BaseKeyframeAnimation positionAnimation;
    private final BaseKeyframeAnimation rotationAnimation;
    private CompoundTrimPathContent trimPaths;
    private final PolystarShape$Type type;

    public PolystarContent(LottieDrawable object, BaseLayer baseLayer, PolystarShape object2) {
        BaseKeyframeAnimation baseKeyframeAnimation;
        BaseKeyframeAnimation baseKeyframeAnimation2;
        BaseKeyframeAnimation baseKeyframeAnimation3;
        BaseKeyframeAnimation baseKeyframeAnimation4;
        boolean bl2;
        Object object3 = new Path();
        this.path = object3;
        this.trimPaths = object3;
        this.lottieDrawable = object;
        object = ((PolystarShape)object2).getName();
        this.name = object;
        object = ((PolystarShape)object2).getType();
        this.type = object;
        this.hidden = bl2 = ((PolystarShape)object2).isHidden();
        object3 = ((PolystarShape)object2).getPoints().createAnimation();
        this.pointsAnimation = object3;
        this.positionAnimation = baseKeyframeAnimation4 = ((PolystarShape)object2).getPosition().createAnimation();
        this.rotationAnimation = baseKeyframeAnimation3 = ((PolystarShape)object2).getRotation().createAnimation();
        this.outerRadiusAnimation = baseKeyframeAnimation2 = ((PolystarShape)object2).getOuterRadius().createAnimation();
        this.outerRoundednessAnimation = baseKeyframeAnimation = ((PolystarShape)object2).getOuterRoundedness().createAnimation();
        PolystarShape$Type polystarShape$Type = PolystarShape$Type.STAR;
        if (object == polystarShape$Type) {
            BaseKeyframeAnimation baseKeyframeAnimation5;
            this.innerRadiusAnimation = baseKeyframeAnimation5 = ((PolystarShape)object2).getInnerRadius().createAnimation();
            this.innerRoundednessAnimation = object2 = ((PolystarShape)object2).getInnerRoundedness().createAnimation();
        } else {
            object2 = null;
            this.innerRadiusAnimation = null;
            this.innerRoundednessAnimation = null;
        }
        baseLayer.addAnimation((BaseKeyframeAnimation)object3);
        baseLayer.addAnimation(baseKeyframeAnimation4);
        baseLayer.addAnimation(baseKeyframeAnimation3);
        baseLayer.addAnimation(baseKeyframeAnimation2);
        baseLayer.addAnimation(baseKeyframeAnimation);
        if (object == polystarShape$Type) {
            object2 = this.innerRadiusAnimation;
            baseLayer.addAnimation((BaseKeyframeAnimation)object2);
            object2 = this.innerRoundednessAnimation;
            baseLayer.addAnimation((BaseKeyframeAnimation)object2);
        }
        ((BaseKeyframeAnimation)object3).addUpdateListener(this);
        baseKeyframeAnimation4.addUpdateListener(this);
        baseKeyframeAnimation3.addUpdateListener(this);
        baseKeyframeAnimation2.addUpdateListener(this);
        baseKeyframeAnimation.addUpdateListener(this);
        if (object == polystarShape$Type) {
            this.innerRadiusAnimation.addUpdateListener(this);
            object = this.innerRoundednessAnimation;
            ((BaseKeyframeAnimation)object).addUpdateListener(this);
        }
    }

    private void createPolygonPath() {
        float f10;
        double d10;
        double d11;
        double d12;
        float f11;
        double d13;
        PolystarContent polystarContent = this;
        Float f12 = (Float)this.pointsAnimation.getValue();
        float f13 = f12.floatValue();
        double d14 = Math.floor(f13);
        int n10 = (int)d14;
        Object object = this.rotationAnimation;
        if (object == null) {
            d13 = 0.0;
        } else {
            object = (Float)((BaseKeyframeAnimation)object).getValue();
            f11 = ((Float)object).floatValue();
            d13 = f11;
        }
        d13 = Math.toRadians(d13 - 90.0);
        double d15 = n10;
        double d16 = Math.PI * 2 / d15;
        f13 = (float)d16;
        Float f14 = (Float)polystarContent.outerRoundednessAnimation.getValue();
        float f15 = f14.floatValue() / 100.0f;
        Float f16 = (Float)polystarContent.outerRadiusAnimation.getValue();
        float f17 = f16.floatValue();
        double d17 = f17;
        double d18 = Math.cos(d13) * d17;
        float f18 = (float)d18;
        double d19 = Math.sin(d13) * d17;
        float f19 = (float)d19;
        Path path = polystarContent.path;
        path.moveTo(f18, f19);
        double d20 = f13;
        d13 += d20;
        d15 = Math.ceil(d15);
        n10 = 0;
        f13 = 0.0f;
        f12 = null;
        while ((d12 = (d11 = (d10 = (double)n10) - d15) == 0.0 ? 0 : (d11 < 0.0 ? -1 : 1)) < 0) {
            double d21;
            double d22;
            int n11;
            double d23;
            d10 = Math.cos(d13) * d17;
            float f20 = (float)d10;
            double d24 = Math.sin(d13);
            double d25 = d15;
            d15 = d17 * d24;
            float f21 = (float)d15;
            float f22 = 0.0f;
            Path path2 = null;
            float f23 = f15 - 0.0f;
            Object object2 = f23 == 0.0f ? 0 : (f23 > 0.0f ? 1 : -1);
            if (object2 != false) {
                d23 = d17;
                double d26 = f19;
                n11 = n10;
                d22 = d13;
                d14 = f18;
                d14 = (float)(Math.atan2(d26, d14) - 1.5707963267948966);
                f10 = (float)Math.cos(d14);
                d14 = Math.sin(d14);
                f13 = (float)d14;
                d26 = f21;
                d21 = d20;
                d20 = f20;
                d26 = (float)(Math.atan2(d26, d20) - 1.5707963267948966);
                d20 = Math.cos(d26);
                f11 = (float)d20;
                d26 = Math.sin(d26);
                f22 = (float)d26;
                float f24 = f17 * f15;
                float f25 = 0.25f;
                f13 *= f24;
                f11 *= f24;
                path2 = polystarContent.path;
                float f26 = f18 - (f10 *= (f24 *= f25));
                float f27 = f19 - f13;
                float f28 = f20 + f11;
                float f29 = f21 + (f24 *= f22);
                path2.cubicTo(f26, f27, f28, f29, f20, f21);
            } else {
                d22 = d13;
                d23 = d17;
                d21 = d20;
                n11 = n10;
                f12 = polystarContent.path;
                f12.lineTo(f20, f21);
            }
            d13 = d22 + d21;
            n10 = n11 + 1;
            f19 = f21;
            f18 = f20;
            d15 = d25;
            d17 = d23;
            d20 = d21;
        }
        f12 = (PointF)polystarContent.positionAnimation.getValue();
        object = polystarContent.path;
        f10 = ((PointF)f12).x;
        f13 = ((PointF)f12).y;
        object.offset(f10, f13);
        polystarContent.path.close();
    }

    private void createStarPath() {
        double d10;
        double d11;
        float f10;
        Path path;
        float f11;
        int n10;
        float f12;
        double d12;
        double d13;
        double d14;
        double d15;
        float f13;
        float f14;
        float f15;
        double d16;
        float f16;
        int n11;
        double d17;
        PolystarContent polystarContent = this;
        Float f17 = (Float)this.pointsAnimation.getValue();
        float f18 = f17.floatValue();
        Object object = this.rotationAnimation;
        if (object == null) {
            d17 = 0.0;
        } else {
            object = (Float)((BaseKeyframeAnimation)object).getValue();
            float f19 = ((Float)object).floatValue();
            d17 = f19;
        }
        d17 = Math.toRadians(d17 - 90.0);
        double d18 = f18;
        double d19 = Math.PI * 2 / d18;
        float f20 = (float)d19;
        float f21 = 2.0f;
        float f22 = f20 / f21;
        float f23 = (int)f18;
        f18 -= f23;
        f23 = 0.0f;
        Path path2 = null;
        float f24 = f18 - 0.0f;
        float f25 = f24 == 0.0f ? 0 : (f24 > 0.0f ? 1 : -1);
        if (f25 != false) {
            n11 = 1065353216;
            f16 = (1.0f - f18) * f22;
            d16 = f16;
            d17 += d16;
        }
        Float f26 = (Float)polystarContent.outerRadiusAnimation.getValue();
        f16 = f26.floatValue();
        Float f27 = (Float)polystarContent.innerRadiusAnimation.getValue();
        float f28 = f27.floatValue();
        Object object2 = polystarContent.innerRoundednessAnimation;
        float f29 = 100.0f;
        if (object2 != null) {
            object2 = (Float)((BaseKeyframeAnimation)object2).getValue();
            f15 = ((Float)object2).floatValue() / f29;
        } else {
            object2 = null;
            f15 = 0.0f;
        }
        Object object3 = polystarContent.outerRoundednessAnimation;
        if (object3 != null) {
            object3 = (Float)((BaseKeyframeAnimation)object3).getValue();
            f14 = ((Float)object3).floatValue() / f29;
        } else {
            object3 = null;
            f14 = 0.0f;
        }
        if (f25 != false) {
            f29 = (f16 - f28) * f18 + f28;
            f13 = f25;
            d15 = f29;
            d14 = Math.cos(d17);
            d13 = d18;
            d12 = d15 * d14;
            f21 = (float)d12;
            d14 = Math.sin(d17);
            f12 = (float)(d15 * d14);
            path2 = polystarContent.path;
            path2.moveTo(f21, f12);
            f23 = f20 * f18;
            n10 = 0x40000000;
            f11 = 2.0f;
            d15 = f23 /= f11;
            d17 += d15;
        } else {
            d13 = d18;
            f13 = f25;
            d12 = f16;
            d15 = Math.cos(d17) * d12;
            f23 = (float)d15;
            d14 = Math.sin(d17);
            f12 = (float)(d12 * d14);
            path = polystarContent.path;
            path.moveTo(f23, f12);
            f10 = f12;
            d12 = f22;
            d17 += d12;
            f21 = f23;
            f29 = 0.0f;
        }
        d15 = Math.ceil(d13);
        d14 = 2.0;
        d15 *= d14;
        float f30 = 0.0f;
        float f31 = f16;
        float f32 = f28;
        n10 = 0;
        f11 = 0.0f;
        boolean bl2 = false;
        while ((d11 = (d10 = (d16 = (double)n10) - d15) == 0.0 ? 0 : (d10 < 0.0 ? -1 : 1)) < 0) {
            float f33;
            float f34;
            double d20;
            double d21;
            float f35;
            double d22;
            double d23;
            double d24;
            float f36 = bl2 ? f31 : f32;
            float f37 = 0.0f;
            float f38 = f29 - 0.0f;
            Object object4 = f38 == 0.0f ? 0 : (f38 > 0.0f ? 1 : -1);
            if (object4 != false && (d24 = (d23 = d16 - (d22 = d15 - d14)) == 0.0 ? 0 : (d23 > 0.0 ? 1 : -1)) == false) {
                f35 = f20 * f18;
                f30 = 2.0f;
                float f39 = f35 / f30;
                f35 = f20;
                f20 = f39;
            } else {
                f30 = 2.0f;
                f35 = f20;
                f20 = f22;
            }
            double d25 = 1.0;
            if (object4 != false && (object4 = (Object)((d21 = d16 - (d20 = d15 - d25)) == 0.0 ? 0 : (d21 > 0.0 ? 1 : -1))) == false) {
                f34 = f22;
                d20 = d16;
                f22 = f29;
            } else {
                f34 = f22;
                d20 = d16;
                f22 = f36;
            }
            d16 = f22;
            double d26 = Math.cos(d17);
            double d27 = d15;
            double d28 = d16 * d26;
            f22 = (float)d28;
            d15 = Math.sin(d17);
            f23 = (float)(d16 *= d15);
            f25 = 0.0f;
            f10 = 0.0f;
            Path path3 = null;
            float f40 = f15 - 0.0f;
            n11 = (int)(f40 == 0.0f ? 0 : (f40 > 0.0f ? 1 : -1));
            if (n11 == 0 && (n11 = (int)((f33 = f14 - 0.0f) == 0.0f ? 0 : (f33 > 0.0f ? 1 : -1))) == 0) {
                path = polystarContent.path;
                path.lineTo(f22, f23);
                f37 = f15;
                f36 = f29;
            } else {
                d16 = f12;
                f37 = f15;
                f36 = f29;
                double d29 = f21;
                d16 = (float)(Math.atan2(d16, d29) - 1.5707963267948966);
                d29 = Math.cos(d16);
                f15 = (float)d29;
                d16 = Math.sin(d16);
                f29 = f16 = (float)d16;
                double d30 = f23;
                float f41 = f15;
                double d31 = f22;
                d30 = (float)(Math.atan2(d30, d31) - 1.5707963267948966);
                d31 = Math.cos(d30);
                f28 = (float)d31;
                d30 = Math.sin(d30);
                f10 = (float)d30;
                f16 = bl2 ? f37 : f14;
                f15 = bl2 ? f14 : f37;
                float f42 = bl2 ? f32 : f31;
                float f43 = bl2 ? f31 : f32;
                f42 *= f16;
                n11 = 1056236141;
                f16 = 0.47829f;
                f41 *= (f42 *= f16);
                f42 *= f29;
                f43 = f43 * f15 * f16;
                f28 *= f43;
                f43 *= f10;
                if (f13 != false) {
                    if (n10 == 0) {
                        f41 *= f18;
                        f42 *= f18;
                    } else {
                        d30 = d27 - d25;
                        double d32 = d20 - d30;
                        f25 = (float)(d32 == 0.0 ? 0 : (d32 > 0.0 ? 1 : -1));
                        if (f25 == false) {
                            f28 *= f18;
                            f43 *= f18;
                        }
                    }
                }
                path3 = polystarContent.path;
                float f44 = f21 - f41;
                float f45 = f12 - f42;
                float f46 = f22 + f28;
                float f47 = f23 + f43;
                path3.cubicTo(f44, f45, f46, f47, f22, f23);
            }
            d19 = f20;
            d17 += d19;
            bl2 ^= true;
            ++n10;
            f21 = f22;
            f12 = f23;
            f15 = f37;
            f29 = f36;
            f22 = f34;
            f20 = f35;
            d15 = d27;
        }
        f17 = (PointF)polystarContent.positionAnimation.getValue();
        object = polystarContent.path;
        float f48 = ((PointF)f17).x;
        f18 = ((PointF)f17).y;
        object.offset(f48, f18);
        polystarContent.path.close();
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    public void addValueCallback(Object object, LottieValueCallback lottieValueCallback) {
        Object object2 = LottieProperty.POLYSTAR_POINTS;
        if (object == object2) {
            object = this.pointsAnimation;
            ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
        } else {
            object2 = LottieProperty.POLYSTAR_ROTATION;
            if (object == object2) {
                object = this.rotationAnimation;
                ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
            } else {
                object2 = LottieProperty.POSITION;
                if (object == object2) {
                    object = this.positionAnimation;
                    ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
                } else {
                    object2 = LottieProperty.POLYSTAR_INNER_RADIUS;
                    if (object == object2 && (object2 = this.innerRadiusAnimation) != null) {
                        ((BaseKeyframeAnimation)object2).setValueCallback(lottieValueCallback);
                    } else {
                        object2 = LottieProperty.POLYSTAR_OUTER_RADIUS;
                        if (object == object2) {
                            object = this.outerRadiusAnimation;
                            ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
                        } else {
                            object2 = LottieProperty.POLYSTAR_INNER_ROUNDEDNESS;
                            if (object == object2 && (object2 = this.innerRoundednessAnimation) != null) {
                                ((BaseKeyframeAnimation)object2).setValueCallback(lottieValueCallback);
                            } else {
                                object2 = LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS;
                                if (object == object2) {
                                    object = this.outerRoundednessAnimation;
                                    ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        Object object = this.isPathValid;
        if (object != 0) {
            return this.path;
        }
        Object object2 = this.path;
        object2.reset();
        object = this.hidden;
        Object object3 = 1;
        if (object != 0) {
            this.isPathValid = object3;
            return this.path;
        }
        object2 = PolystarContent$1.$SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type;
        PolystarShape$Type polystarShape$Type = this.type;
        int n10 = polystarShape$Type.ordinal();
        object = object2[n10];
        if (object != object3) {
            n10 = 2;
            if (object == n10) {
                this.createPolygonPath();
            }
        } else {
            this.createStarPath();
        }
        this.path.close();
        object2 = this.trimPaths;
        polystarShape$Type = this.path;
        ((CompoundTrimPathContent)object2).apply((Path)polystarShape$Type);
        this.isPathValid = object3;
        return this.path;
    }

    public void onValueChanged() {
        this.invalidate();
    }

    public void resolveKeyPath(KeyPath keyPath, int n10, List list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, n10, list, keyPath2, this);
    }

    public void setContents(List list, List list2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            ShapeTrimPath$Type shapeTrimPath$Type;
            Object object;
            Content content = (Content)list.get(i10);
            boolean bl2 = content instanceof TrimPathContent;
            if (!bl2 || (object = ((TrimPathContent)(content = (TrimPathContent)content)).getType()) != (shapeTrimPath$Type = ShapeTrimPath$Type.SIMULTANEOUSLY)) continue;
            object = this.trimPaths;
            ((CompoundTrimPathContent)object).addTrimPath((TrimPathContent)content);
            ((TrimPathContent)content).addListener(this);
        }
    }
}

