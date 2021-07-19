/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model;

import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public interface KeyPathElement {
    public void addValueCallback(Object var1, LottieValueCallback var2);

    public void resolveKeyPath(KeyPath var1, int var2, List var3, KeyPath var4);
}

