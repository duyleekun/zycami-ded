/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.MergePathsContent;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.MergePaths$MergePathsMode;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Logger;

public class MergePaths
implements ContentModel {
    private final boolean hidden;
    private final MergePaths$MergePathsMode mode;
    private final String name;

    public MergePaths(String string2, MergePaths$MergePathsMode mergePaths$MergePathsMode, boolean bl2) {
        this.name = string2;
        this.mode = mergePaths$MergePathsMode;
        this.hidden = bl2;
    }

    public MergePaths$MergePathsMode getMode() {
        return this.mode;
    }

    public String getName() {
        return this.name;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public Content toContent(LottieDrawable object, BaseLayer baseLayer) {
        boolean bl2 = object.enableMergePathsForKitKatAndAbove();
        if (!bl2) {
            Logger.warning("Animation contains merge paths but they are disabled.");
            return null;
        }
        object = new MergePathsContent(this);
        return object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MergePaths{mode=");
        MergePaths$MergePathsMode mergePaths$MergePathsMode = this.mode;
        stringBuilder.append((Object)mergePaths$MergePathsMode);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

