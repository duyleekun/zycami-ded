/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 */
package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CompoundTrimPathContent {
    private List contents;

    public CompoundTrimPathContent() {
        ArrayList arrayList;
        this.contents = arrayList = new ArrayList();
    }

    public void addTrimPath(TrimPathContent trimPathContent) {
        this.contents.add(trimPathContent);
    }

    public void apply(Path path) {
        List list = this.contents;
        for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
            TrimPathContent trimPathContent = (TrimPathContent)this.contents.get(i10);
            Utils.applyTrimPathIfNeeded(path, trimPathContent);
        }
    }
}

