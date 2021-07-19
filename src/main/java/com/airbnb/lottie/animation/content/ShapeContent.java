/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 */
package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.CompoundTrimPathContent;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.PathContent;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath$Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

public class ShapeContent
implements PathContent,
BaseKeyframeAnimation$AnimationListener {
    private final boolean hidden;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path;
    private final BaseKeyframeAnimation shapeAnimation;
    private CompoundTrimPathContent trimPaths;

    public ShapeContent(LottieDrawable object, BaseLayer baseLayer, ShapePath shapePath) {
        boolean bl2;
        Object object2;
        this.path = object2 = new Path();
        this.trimPaths = object2;
        object2 = shapePath.getName();
        this.name = object2;
        this.hidden = bl2 = shapePath.isHidden();
        this.lottieDrawable = object;
        object = shapePath.getShapePath().createAnimation();
        this.shapeAnimation = object;
        baseLayer.addAnimation((BaseKeyframeAnimation)object);
        ((BaseKeyframeAnimation)object).addUpdateListener(this);
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        boolean bl2 = this.isPathValid;
        if (bl2) {
            return this.path;
        }
        Object object = this.path;
        object.reset();
        bl2 = this.hidden;
        boolean bl3 = true;
        if (bl2) {
            this.isPathValid = bl3;
            return this.path;
        }
        object = this.path;
        Path path = (Path)this.shapeAnimation.getValue();
        object.set(path);
        object = this.path;
        path = Path.FillType.EVEN_ODD;
        object.setFillType((Path.FillType)path);
        object = this.trimPaths;
        path = this.path;
        ((CompoundTrimPathContent)object).apply(path);
        this.isPathValid = bl3;
        return this.path;
    }

    public void onValueChanged() {
        this.invalidate();
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

