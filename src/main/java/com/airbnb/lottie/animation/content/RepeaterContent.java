/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Path
 *  android.graphics.RectF
 */
package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.content.GreedyContent;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.content.PathContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class RepeaterContent
implements DrawingContent,
PathContent,
GreedyContent,
BaseKeyframeAnimation$AnimationListener,
KeyPathElementContent {
    private ContentGroup contentGroup;
    private final BaseKeyframeAnimation copies;
    private final boolean hidden;
    private final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final String name;
    private final BaseKeyframeAnimation offset;
    private final Path path;
    private final TransformKeyframeAnimation transform;

    public RepeaterContent(LottieDrawable object, BaseLayer baseLayer, Repeater repeater) {
        boolean bl2;
        Matrix matrix;
        this.matrix = matrix = new Matrix();
        this.path = matrix;
        this.lottieDrawable = object;
        this.layer = baseLayer;
        object = repeater.getName();
        this.name = object;
        this.hidden = bl2 = repeater.isHidden();
        object = repeater.getCopies().createAnimation();
        this.copies = object;
        baseLayer.addAnimation((BaseKeyframeAnimation)object);
        ((BaseKeyframeAnimation)object).addUpdateListener(this);
        this.offset = object = repeater.getOffset().createAnimation();
        baseLayer.addAnimation((BaseKeyframeAnimation)object);
        ((BaseKeyframeAnimation)object).addUpdateListener(this);
        this.transform = object = repeater.getTransform().createAnimation();
        ((TransformKeyframeAnimation)object).addAnimationsToLayer(baseLayer);
        ((TransformKeyframeAnimation)object).addListener(this);
    }

    public void absorbContent(ListIterator object) {
        boolean bl2;
        ContentGroup contentGroup = this.contentGroup;
        if (contentGroup != null) {
            return;
        }
        while ((bl2 = object.hasPrevious()) && (contentGroup = object.previous()) != this) {
        }
        ArrayList<ContentGroup> arrayList = new ArrayList<ContentGroup>();
        while (bl2 = object.hasPrevious()) {
            contentGroup = object.previous();
            arrayList.add(contentGroup);
            object.remove();
        }
        Collections.reverse(arrayList);
        LottieDrawable lottieDrawable = this.lottieDrawable;
        BaseLayer baseLayer = this.layer;
        boolean bl3 = this.hidden;
        this.contentGroup = object = new ContentGroup(lottieDrawable, baseLayer, "Repeater", bl3, arrayList, null);
    }

    public void addValueCallback(Object object, LottieValueCallback lottieValueCallback) {
        Object object2 = this.transform;
        boolean bl2 = ((TransformKeyframeAnimation)object2).applyValueCallback(object, lottieValueCallback);
        if (bl2) {
            return;
        }
        object2 = LottieProperty.REPEATER_COPIES;
        if (object == object2) {
            object = this.copies;
            ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
        } else {
            object2 = LottieProperty.REPEATER_OFFSET;
            if (object == object2) {
                object = this.offset;
                ((BaseKeyframeAnimation)object).setValueCallback(lottieValueCallback);
            }
        }
    }

    public void draw(Canvas canvas, Matrix matrix, int n10) {
        Float f10 = (Float)this.copies.getValue();
        float f11 = f10.floatValue();
        Float f12 = (Float)this.offset.getValue();
        float f13 = f12.floatValue();
        Float f14 = (Float)this.transform.getStartOpacity().getValue();
        float f15 = f14.floatValue();
        float f16 = 100.0f;
        f15 /= f16;
        Float f17 = (Float)this.transform.getEndOpacity().getValue();
        float f18 = f17.floatValue() / f16;
        for (int i10 = (int)f11 + -1; i10 >= 0; i10 += -1) {
            this.matrix.set(matrix);
            Matrix matrix2 = this.matrix;
            Object object = this.transform;
            float f19 = i10;
            float f20 = f19 + f13;
            object = ((TransformKeyframeAnimation)object).getMatrixForRepeater(f20);
            matrix2.preConcat((Matrix)object);
            float f21 = n10;
            float f22 = MiscUtils.lerp(f15, f18, f19 /= f11);
            object = this.contentGroup;
            Matrix matrix3 = this.matrix;
            int n11 = (int)(f21 *= f22);
            ((ContentGroup)object).draw(canvas, matrix3, n11);
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean bl2) {
        this.contentGroup.getBounds(rectF, matrix, bl2);
    }

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        Path path = this.contentGroup.getPath();
        this.path.reset();
        Float f10 = (Float)this.copies.getValue();
        float f11 = f10.floatValue();
        Float f12 = (Float)this.offset.getValue();
        float f13 = f12.floatValue();
        for (int i10 = (int)f11 + -1; i10 >= 0; i10 += -1) {
            Matrix matrix = this.matrix;
            TransformKeyframeAnimation transformKeyframeAnimation = this.transform;
            float f14 = (float)i10 + f13;
            transformKeyframeAnimation = transformKeyframeAnimation.getMatrixForRepeater(f14);
            matrix.set((Matrix)transformKeyframeAnimation);
            matrix = this.path;
            transformKeyframeAnimation = this.matrix;
            matrix.addPath(path, (Matrix)transformKeyframeAnimation);
        }
        return this.path;
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public void resolveKeyPath(KeyPath keyPath, int n10, List list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, n10, list, keyPath2, this);
    }

    public void setContents(List list, List list2) {
        this.contentGroup.setContents(list, list2);
    }
}

