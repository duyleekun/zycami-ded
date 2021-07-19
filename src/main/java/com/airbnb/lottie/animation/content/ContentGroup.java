/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.RectF
 */
package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.content.GreedyContent;
import com.airbnb.lottie.animation.content.PathContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ContentGroup
implements DrawingContent,
PathContent,
BaseKeyframeAnimation$AnimationListener,
KeyPathElement {
    private final List contents;
    private final boolean hidden;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final String name;
    private Paint offScreenPaint;
    private RectF offScreenRectF;
    private final Path path;
    private List pathContents;
    private final RectF rect;
    private TransformKeyframeAnimation transformAnimation;

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeGroup shapeGroup) {
        String string2 = shapeGroup.getName();
        boolean bl2 = shapeGroup.isHidden();
        Object object = shapeGroup.getItems();
        List list = ContentGroup.contentsFromModels(lottieDrawable, baseLayer, (List)object);
        AnimatableTransform animatableTransform = ContentGroup.findTransform(shapeGroup.getItems());
        object = this;
        this(lottieDrawable, baseLayer, string2, bl2, list, animatableTransform);
    }

    /*
     * WARNING - void declaration
     */
    public ContentGroup(LottieDrawable object, BaseLayer baseLayer, String object2, boolean bl2, List list, AnimatableTransform animatableTransform) {
        int n10;
        void var6_8;
        void var5_7;
        LPaint lPaint = new LPaint();
        this.offScreenPaint = lPaint;
        this.offScreenRectF = lPaint;
        super();
        this.matrix = lPaint;
        super();
        this.path = lPaint;
        super();
        this.rect = lPaint;
        this.name = object2;
        this.lottieDrawable = object;
        this.hidden = bl2;
        this.contents = var5_7;
        if (var6_8 != null) {
            this.transformAnimation = object = var6_8.createAnimation();
            ((TransformKeyframeAnimation)object).addAnimationsToLayer(baseLayer);
            object = this.transformAnimation;
            ((TransformKeyframeAnimation)object).addListener(this);
        }
        object = new ArrayList();
        for (n10 = var5_7.size() + -1; n10 >= 0; n10 += -1) {
            object2 = (Content)var5_7.get(n10);
            boolean bl3 = object2 instanceof GreedyContent;
            if (!bl3) continue;
            object2 = (GreedyContent)object2;
            object.add(object2);
        }
        for (n10 = object.size() + -1; n10 >= 0; n10 += -1) {
            object2 = (GreedyContent)object.get(n10);
            int n11 = var5_7.size();
            ListIterator listIterator = var5_7.listIterator(n11);
            object2.absorbContent(listIterator);
        }
    }

    private static List contentsFromModels(LottieDrawable lottieDrawable, BaseLayer baseLayer, List list) {
        int n10;
        int n11 = list.size();
        ArrayList<Content> arrayList = new ArrayList<Content>(n11);
        for (n11 = 0; n11 < (n10 = list.size()); ++n11) {
            Content content = ((ContentModel)list.get(n11)).toContent(lottieDrawable, baseLayer);
            if (content == null) continue;
            arrayList.add(content);
        }
        return arrayList;
    }

    public static AnimatableTransform findTransform(List list) {
        int n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            ContentModel contentModel = (ContentModel)list.get(i10);
            boolean bl2 = contentModel instanceof AnimatableTransform;
            if (!bl2) continue;
            return (AnimatableTransform)contentModel;
        }
        return null;
    }

    private boolean hasTwoOrMoreDrawableContent() {
        List list;
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = (list = this.contents).size()); ++i10) {
            list = this.contents.get(i10);
            n10 = list instanceof DrawingContent;
            if (n10 == 0 || ++n11 < (n10 = 2)) continue;
            return true;
        }
        return false;
    }

    public void addValueCallback(Object object, LottieValueCallback lottieValueCallback) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.applyValueCallback(object, lottieValueCallback);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void draw(Canvas canvas, Matrix object, int n10) {
        RectF rectF;
        void var6_13;
        boolean bl2;
        float f10;
        float f11;
        float f12;
        int n12 = this.hidden;
        if (n12 != 0) {
            return;
        }
        Object object2 = this.matrix;
        object2.set((Matrix)object);
        object = this.transformAnimation;
        if (object != null) {
            void var6_8;
            object2 = this.matrix;
            object = ((TransformKeyframeAnimation)object).getMatrix();
            object2.preConcat((Matrix)object);
            object = this.transformAnimation.getOpacity();
            if (object == null) {
                int n11 = 100;
                f12 = 1.4E-43f;
            } else {
                object = (Integer)this.transformAnimation.getOpacity().getValue();
                int n11 = (Integer)object;
            }
            f12 = (float)var6_8;
            n12 = 1120403456;
            f11 = 100.0f;
            f12 /= f11;
            f10 = n10;
            f12 *= f10;
            f10 = 255.0f;
            f12 = f12 / f10 * f10;
            n10 = (int)f12;
        }
        object = this.lottieDrawable;
        boolean bl3 = ((LottieDrawable)((Object)object)).isApplyingOpacityToLayersEnabled();
        n12 = 255;
        f11 = 3.57E-43f;
        int n13 = 1;
        float f13 = Float.MIN_VALUE;
        if (bl3 && (bl2 = this.hasTwoOrMoreDrawableContent()) && n10 != n12) {
            int n14 = n13;
            f12 = f13;
        } else {
            boolean bl4 = false;
            f12 = 0.0f;
            object = null;
        }
        if (var6_13 != false) {
            this.offScreenRectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            rectF = this.offScreenRectF;
            Matrix matrix = this.matrix;
            this.getBounds(rectF, matrix, n13 != 0);
            this.offScreenPaint.setAlpha(n10);
            rectF = this.offScreenRectF;
            matrix = this.offScreenPaint;
            Utils.saveLayerCompat(canvas, rectF, (Paint)matrix);
        }
        if (var6_13 != false) {
            n10 = n12;
            f10 = f11;
        }
        object2 = this.contents;
        for (n12 = object2.size() - n13; n12 >= 0; n12 += -1) {
            Object object3 = this.contents.get(n12);
            boolean bl5 = object3 instanceof DrawingContent;
            if (!bl5) continue;
            object3 = (DrawingContent)object3;
            rectF = this.matrix;
            object3.draw(canvas, (Matrix)rectF, n10);
        }
        if (var6_13 != false) {
            canvas.restore();
        }
    }

    public void getBounds(RectF rectF, Matrix object, boolean bl2) {
        Object object2 = this.matrix;
        object2.set((Matrix)object);
        object = this.transformAnimation;
        if (object != null) {
            object2 = this.matrix;
            object = ((TransformKeyframeAnimation)object).getMatrix();
            object2.preConcat((Matrix)object);
        }
        object = this.rect;
        object2 = null;
        object.set(0.0f, 0.0f, 0.0f, 0.0f);
        object = this.contents;
        for (int i10 = object.size() + -1; i10 >= 0; i10 += -1) {
            object2 = (Content)this.contents.get(i10);
            boolean bl3 = object2 instanceof DrawingContent;
            if (!bl3) continue;
            object2 = (DrawingContent)object2;
            RectF rectF2 = this.rect;
            Matrix matrix = this.matrix;
            object2.getBounds(rectF2, matrix, bl2);
            object2 = this.rect;
            rectF.union((RectF)object2);
        }
    }

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        Object object;
        this.matrix.reset();
        Object object2 = this.transformAnimation;
        if (object2 != null) {
            object = this.matrix;
            object2 = ((TransformKeyframeAnimation)object2).getMatrix();
            object.set((Matrix)object2);
        }
        object2 = this.path;
        object2.reset();
        int n10 = this.hidden;
        if (n10 != 0) {
            return this.path;
        }
        object2 = this.contents;
        for (n10 = object2.size() + -1; n10 >= 0; n10 += -1) {
            object = (Content)this.contents.get(n10);
            boolean bl2 = object instanceof PathContent;
            if (!bl2) continue;
            Path path = this.path;
            object = ((PathContent)object).getPath();
            Matrix matrix = this.matrix;
            path.addPath((Path)object, matrix);
        }
        return this.path;
    }

    public List getPathList() {
        ArrayList arrayList = this.pathContents;
        if (arrayList == null) {
            Object object;
            int n10;
            this.pathContents = arrayList = new ArrayList();
            arrayList = null;
            for (int i10 = 0; i10 < (n10 = (object = this.contents).size()); ++i10) {
                object = (Content)this.contents.get(i10);
                boolean bl2 = object instanceof PathContent;
                if (!bl2) continue;
                List list = this.pathContents;
                object = (PathContent)object;
                list.add(object);
            }
        }
        return this.pathContents;
    }

    public Matrix getTransformationMatrix() {
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            return transformKeyframeAnimation.getMatrix();
        }
        this.matrix.reset();
        return this.matrix;
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    /*
     * WARNING - void declaration
     */
    public void resolveKeyPath(KeyPath keyPath, int n10, List list, KeyPath keyPath2) {
        boolean bl2;
        Object object = this.getName();
        boolean n11 = keyPath.matches((String)object, n10);
        if (!n11) {
            return;
        }
        Object object2 = "__container";
        object = this.getName();
        boolean bl3 = ((String)object2).equals(object);
        if (!bl3) {
            object = this.getName();
            keyPath2 = keyPath2.addKey((String)object);
            object = this.getName();
            boolean bl4 = keyPath.fullyResolvesTo((String)object, n10);
            if (bl4) {
                object = keyPath2.resolve(this);
                list.add(object);
            }
        }
        if (bl2 = keyPath.propagateToChildren((String)(object = this.getName()), n10)) {
            int n12;
            void var6_12;
            object = this.getName();
            int n13 = keyPath.incrementDepthBy((String)object, n10);
            n10 += n13;
            boolean bl5 = false;
            object = null;
            while (++var6_12 < (n12 = (object2 = this.contents).size())) {
                object2 = (Content)this.contents.get((int)var6_12);
                boolean bl6 = object2 instanceof KeyPathElement;
                if (bl6) {
                    object2 = (KeyPathElement)object2;
                    object2.resolveKeyPath(keyPath, n10, list, keyPath2);
                }
            }
        }
    }

    public void setContents(List list, List arrayList) {
        int n10 = list.size();
        List list2 = this.contents;
        int n11 = list2.size();
        arrayList = new ArrayList<Content>(n10 += n11);
        arrayList.addAll(list);
        list = this.contents;
        for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
            Content content = (Content)this.contents.get(i10);
            list2 = this.contents.subList(0, i10);
            content.setContents(arrayList, list2);
            arrayList.add(content);
        }
    }
}

