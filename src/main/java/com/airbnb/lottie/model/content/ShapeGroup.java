/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;

public class ShapeGroup
implements ContentModel {
    private final boolean hidden;
    private final List items;
    private final String name;

    public ShapeGroup(String string2, List list, boolean bl2) {
        this.name = string2;
        this.items = list;
        this.hidden = bl2;
    }

    public List getItems() {
        return this.items;
    }

    public String getName() {
        return this.name;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        ContentGroup contentGroup = new ContentGroup(lottieDrawable, baseLayer, this);
        return contentGroup;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShapeGroup{name='");
        String string2 = this.name;
        stringBuilder.append(string2);
        stringBuilder.append("' Shapes: ");
        string2 = Arrays.toString(this.items.toArray());
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

