/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.content.ShapeTrimPath$Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class TrimPathContent
implements Content,
BaseKeyframeAnimation$AnimationListener {
    private final BaseKeyframeAnimation endAnimation;
    private final boolean hidden;
    private final List listeners;
    private final String name;
    private final BaseKeyframeAnimation offsetAnimation;
    private final BaseKeyframeAnimation startAnimation;
    private final ShapeTrimPath$Type type;

    public TrimPathContent(BaseLayer baseLayer, ShapeTrimPath object) {
        BaseKeyframeAnimation baseKeyframeAnimation;
        boolean bl2;
        Object object2 = new ArrayList();
        this.listeners = object2;
        this.name = object2 = ((ShapeTrimPath)object).getName();
        this.hidden = bl2 = ((ShapeTrimPath)object).isHidden();
        object2 = ((ShapeTrimPath)object).getType();
        this.type = object2;
        object2 = ((ShapeTrimPath)object).getStart().createAnimation();
        this.startAnimation = object2;
        this.endAnimation = baseKeyframeAnimation = ((ShapeTrimPath)object).getEnd().createAnimation();
        this.offsetAnimation = object = ((ShapeTrimPath)object).getOffset().createAnimation();
        baseLayer.addAnimation((BaseKeyframeAnimation)object2);
        baseLayer.addAnimation(baseKeyframeAnimation);
        baseLayer.addAnimation((BaseKeyframeAnimation)object);
        ((BaseKeyframeAnimation)object2).addUpdateListener(this);
        baseKeyframeAnimation.addUpdateListener(this);
        ((BaseKeyframeAnimation)object).addUpdateListener(this);
    }

    public void addListener(BaseKeyframeAnimation$AnimationListener baseKeyframeAnimation$AnimationListener) {
        this.listeners.add(baseKeyframeAnimation$AnimationListener);
    }

    public BaseKeyframeAnimation getEnd() {
        return this.endAnimation;
    }

    public String getName() {
        return this.name;
    }

    public BaseKeyframeAnimation getOffset() {
        return this.offsetAnimation;
    }

    public BaseKeyframeAnimation getStart() {
        return this.startAnimation;
    }

    public ShapeTrimPath$Type getType() {
        return this.type;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public void onValueChanged() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.listeners).size()); ++i10) {
            object = (BaseKeyframeAnimation$AnimationListener)this.listeners.get(i10);
            object.onValueChanged();
        }
    }

    public void setContents(List list, List list2) {
    }
}

