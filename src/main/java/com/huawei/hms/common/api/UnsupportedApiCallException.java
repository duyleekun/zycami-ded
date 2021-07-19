/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.api;

import com.huawei.hms.common.Feature;

public final class UnsupportedApiCallException
extends UnsupportedOperationException {
    private final Feature feature;

    public UnsupportedApiCallException(Feature feature) {
        this.feature = feature;
    }

    public final String getMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        Feature feature = this.feature;
        stringBuilder.append(feature);
        stringBuilder.append(" is unsupported");
        return stringBuilder.toString();
    }
}

