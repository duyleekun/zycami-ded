/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.L;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$EmptyKeyframeWrapper;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapper;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$KeyframesWrapperImpl;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$SingleKeyframeWrapper;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseKeyframeAnimation {
    private float cachedEndProgress;
    private Object cachedGetValue;
    private float cachedStartDelayProgress;
    private boolean isDiscrete;
    private final BaseKeyframeAnimation$KeyframesWrapper keyframesWrapper;
    public final List listeners;
    public float progress;
    public LottieValueCallback valueCallback;

    public BaseKeyframeAnimation(List object) {
        float f10;
        ArrayList arrayList;
        this.listeners = arrayList = new ArrayList(1);
        this.isDiscrete = false;
        this.progress = 0.0f;
        this.cachedGetValue = null;
        this.cachedStartDelayProgress = f10 = -1.0f;
        this.cachedEndProgress = f10;
        this.keyframesWrapper = object = BaseKeyframeAnimation.wrap((List)object);
    }

    private float getStartDelayProgress() {
        float f10 = this.cachedStartDelayProgress;
        float f11 = -1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            BaseKeyframeAnimation$KeyframesWrapper baseKeyframeAnimation$KeyframesWrapper = this.keyframesWrapper;
            this.cachedStartDelayProgress = f10 = baseKeyframeAnimation$KeyframesWrapper.getStartDelayProgress();
        }
        return this.cachedStartDelayProgress;
    }

    private static BaseKeyframeAnimation$KeyframesWrapper wrap(List object) {
        int n10;
        int n11 = object.isEmpty();
        if (n11 != 0) {
            object = new BaseKeyframeAnimation$EmptyKeyframeWrapper(null);
            return object;
        }
        n11 = object.size();
        if (n11 == (n10 = 1)) {
            BaseKeyframeAnimation$SingleKeyframeWrapper baseKeyframeAnimation$SingleKeyframeWrapper = new BaseKeyframeAnimation$SingleKeyframeWrapper((List)object);
            return baseKeyframeAnimation$SingleKeyframeWrapper;
        }
        BaseKeyframeAnimation$KeyframesWrapperImpl baseKeyframeAnimation$KeyframesWrapperImpl = new BaseKeyframeAnimation$KeyframesWrapperImpl((List)object);
        return baseKeyframeAnimation$KeyframesWrapperImpl;
    }

    public void addUpdateListener(BaseKeyframeAnimation$AnimationListener baseKeyframeAnimation$AnimationListener) {
        this.listeners.add(baseKeyframeAnimation$AnimationListener);
    }

    public Keyframe getCurrentKeyframe() {
        String string2 = "BaseKeyframeAnimation#getCurrentKeyframe";
        L.beginSection(string2);
        Keyframe keyframe = this.keyframesWrapper.getCurrentKeyframe();
        L.endSection(string2);
        return keyframe;
    }

    public float getEndProgress() {
        float f10 = this.cachedEndProgress;
        float f11 = -1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            BaseKeyframeAnimation$KeyframesWrapper baseKeyframeAnimation$KeyframesWrapper = this.keyframesWrapper;
            this.cachedEndProgress = f10 = baseKeyframeAnimation$KeyframesWrapper.getEndProgress();
        }
        return this.cachedEndProgress;
    }

    public float getInterpolatedCurrentKeyframeProgress() {
        Keyframe keyframe = this.getCurrentKeyframe();
        boolean bl2 = keyframe.isStatic();
        if (bl2) {
            return 0.0f;
        }
        keyframe = keyframe.interpolator;
        float f10 = this.getLinearCurrentKeyframeProgress();
        return keyframe.getInterpolation(f10);
    }

    public float getLinearCurrentKeyframeProgress() {
        boolean bl2 = this.isDiscrete;
        float f10 = 0.0f;
        if (bl2) {
            return 0.0f;
        }
        Keyframe keyframe = this.getCurrentKeyframe();
        boolean bl3 = keyframe.isStatic();
        if (bl3) {
            return 0.0f;
        }
        f10 = this.progress;
        float f11 = keyframe.getStartProgress();
        f10 -= f11;
        f11 = keyframe.getEndProgress();
        float f12 = keyframe.getStartProgress();
        return f10 / (f11 -= f12);
    }

    public float getProgress() {
        return this.progress;
    }

    public Object getValue() {
        Object object;
        boolean bl2;
        float f10 = this.getInterpolatedCurrentKeyframeProgress();
        Object object2 = this.valueCallback;
        if (object2 == null && (bl2 = (object2 = this.keyframesWrapper).isCachedValueEnabled(f10))) {
            return this.cachedGetValue;
        }
        object2 = this.getCurrentKeyframe();
        this.cachedGetValue = object = this.getValue((Keyframe)object2, f10);
        return object;
    }

    public abstract Object getValue(Keyframe var1, float var2);

    public void notifyListeners() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.listeners).size()); ++i10) {
            object = (BaseKeyframeAnimation$AnimationListener)this.listeners.get(i10);
            object.onValueChanged();
        }
    }

    public void setIsDiscrete() {
        this.isDiscrete = true;
    }

    public void setProgress(float f10) {
        BaseKeyframeAnimation$KeyframesWrapper baseKeyframeAnimation$KeyframesWrapper = this.keyframesWrapper;
        Object object = baseKeyframeAnimation$KeyframesWrapper.isEmpty();
        if (object != 0) {
            return;
        }
        float f11 = this.getStartDelayProgress();
        float f12 = f10 - f11;
        object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object < 0) {
            f10 = this.getStartDelayProgress();
        } else {
            f11 = this.getEndProgress();
            float f13 = f10 - f11;
            object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
            if (object > 0) {
                f10 = this.getEndProgress();
            }
        }
        f11 = this.progress;
        object = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (object == 0) {
            return;
        }
        this.progress = f10;
        baseKeyframeAnimation$KeyframesWrapper = this.keyframesWrapper;
        boolean bl2 = baseKeyframeAnimation$KeyframesWrapper.isValueChanged(f10);
        if (bl2) {
            this.notifyListeners();
        }
    }

    public void setValueCallback(LottieValueCallback lottieValueCallback) {
        LottieValueCallback lottieValueCallback2 = this.valueCallback;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.setAnimation(null);
        }
        this.valueCallback = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.setAnimation(this);
        }
    }
}

