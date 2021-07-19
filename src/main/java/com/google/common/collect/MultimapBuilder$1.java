/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.Platform;
import java.util.Map;

public final class MultimapBuilder$1
extends MultimapBuilder$MultimapBuilderWithKeys {
    public final /* synthetic */ int val$expectedKeys;

    public MultimapBuilder$1(int n10) {
        this.val$expectedKeys = n10;
    }

    public Map createMap() {
        return Platform.newHashMapWithExpectedSize(this.val$expectedKeys);
    }
}

