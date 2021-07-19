/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.content.BaseStrokeContent$1;
import com.airbnb.lottie.animation.content.TrimPathContent;
import java.util.ArrayList;
import java.util.List;

public final class BaseStrokeContent$PathGroup {
    private final List paths;
    private final TrimPathContent trimPath;

    private BaseStrokeContent$PathGroup(TrimPathContent trimPathContent) {
        ArrayList arrayList;
        this.paths = arrayList = new ArrayList();
        this.trimPath = trimPathContent;
    }

    public /* synthetic */ BaseStrokeContent$PathGroup(TrimPathContent trimPathContent, BaseStrokeContent$1 baseStrokeContent$1) {
        this(trimPathContent);
    }

    public static /* synthetic */ List access$100(BaseStrokeContent$PathGroup baseStrokeContent$PathGroup) {
        return baseStrokeContent$PathGroup.paths;
    }

    public static /* synthetic */ TrimPathContent access$200(BaseStrokeContent$PathGroup baseStrokeContent$PathGroup) {
        return baseStrokeContent$PathGroup.trimPath;
    }
}

