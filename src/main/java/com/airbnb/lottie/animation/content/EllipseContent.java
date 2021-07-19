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
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath$Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class EllipseContent
implements PathContent,
BaseKeyframeAnimation$AnimationListener,
KeyPathElementContent {
    private static final float ELLIPSE_CONTROL_POINT_PERCENTAGE = 0.55228f;
    private final CircleShape circleShape;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path;
    private final BaseKeyframeAnimation positionAnimation;
    private final BaseKeyframeAnimation sizeAnimation;
    private CompoundTrimPathContent trimPaths;

    public EllipseContent(LottieDrawable object, BaseLayer baseLayer, CircleShape circleShape) {
        Object object2 = new Path();
        this.path = object2;
        this.trimPaths = object2;
        object2 = circleShape.getName();
        this.name = object2;
        this.lottieDrawable = object;
        object = circleShape.getSize().createAnimation();
        this.sizeAnimation = object;
        object2 = circleShape.getPosition().createAnimation();
        this.positionAnimation = object2;
        this.circleShape = circleShape;
        baseLayer.addAnimation((BaseKeyframeAnimation)object);
        baseLayer.addAnimation((BaseKeyframeAnimation)object2);
        ((BaseKeyframeAnimation)object).addUpdateListener(this);
        ((BaseKeyframeAnimation)object2).addUpdateListener(this);
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    public void addValueCallback(Object object, LottieValueCallback lottieValueCallback) {
        PointF pointF = LottieProperty.ELLIPSE_SIZE;
        if (object == pointF) {
            object = this.sizeAnimation;
            ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
        } else {
            pointF = LottieProperty.POSITION;
            if (object == pointF) {
                object = this.positionAnimation;
                ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        EllipseContent ellipseContent = this;
        boolean bl2 = this.isPathValid;
        if (bl2) {
            return this.path;
        }
        this.path.reset();
        Object object = this.circleShape;
        bl2 = ((CircleShape)object).isHidden();
        boolean bl3 = true;
        if (bl2) {
            this.isPathValid = bl3;
            return this.path;
        }
        object = (PointF)this.sizeAnimation.getValue();
        float f10 = ((PointF)object).x;
        float f11 = 2.0f;
        f10 /= f11;
        float f12 = ((PointF)object).y / f11;
        f11 = 0.55228f;
        float f13 = f10 * f11;
        f11 *= f12;
        this.path.reset();
        CircleShape circleShape = this.circleShape;
        boolean bl4 = circleShape.isReversed();
        if (bl4) {
            circleShape = this.path;
            float f14 = -f12;
            circleShape.moveTo(0.0f, f14);
            Path path = this.path;
            float f15 = 0.0f - f13;
            float f16 = -f10;
            float f17 = 0.0f - f11;
            float f18 = f15;
            float f19 = f14;
            float f20 = f16;
            path.cubicTo(f15, f14, f16, f17, f16, 0.0f);
            circleShape = this.path;
            float f21 = f14;
            f14 = f12;
            circleShape.cubicTo(f16, f11 += 0.0f, f15, f12, 0.0f, f12);
            circleShape = this.path;
            f16 = f13 += 0.0f;
            f15 = f10;
            circleShape.cubicTo(f13, f12, f10, f11, f10, 0.0f);
            circleShape = this.path;
            f16 = f10;
            f15 = f13;
            f14 = f19;
            circleShape.cubicTo(f10, f17, f13, f19, 0.0f, f19);
        } else {
            circleShape = this.path;
            float f22 = -f12;
            circleShape.moveTo(0.0f, f22);
            circleShape = this.path;
            float f23 = f13 + 0.0f;
            float f24 = 0.0f - f11;
            float f25 = f23;
            float f26 = f10;
            circleShape.cubicTo(f23, f22, f10, f24, f10, 0.0f);
            circleShape = this.path;
            f25 = f10;
            f26 = f23;
            float f27 = f12;
            circleShape.cubicTo(f10, f11 += 0.0f, f23, f12, 0.0f, f12);
            circleShape = this.path;
            float f28 = 0.0f - f13;
            f10 = -f10;
            f27 = 0.0f;
            f25 = f28;
            f26 = f10;
            circleShape.cubicTo(f28, f12, f10, f11, f10, 0.0f);
            Path path = this.path;
            f12 = f22;
            f22 = f10;
            path.cubicTo(f10, f24, f28, f12, 0.0f, f12);
        }
        object = (PointF)ellipseContent.positionAnimation.getValue();
        Path path = ellipseContent.path;
        f11 = ((PointF)object).x;
        f12 = ((PointF)object).y;
        path.offset(f11, f12);
        ellipseContent.path.close();
        object = ellipseContent.trimPaths;
        path = ellipseContent.path;
        ((CompoundTrimPathContent)object).apply(path);
        ellipseContent.isPathValid = bl3;
        return ellipseContent.path;
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

