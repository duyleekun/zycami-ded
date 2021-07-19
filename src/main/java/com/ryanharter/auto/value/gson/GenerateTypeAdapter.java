/*
 * Decompiled with CFR 0.151.
 */
package com.ryanharter.auto.value.gson;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter$1;

public @interface GenerateTypeAdapter {
    public static final TypeAdapterFactory K;

    static {
        GenerateTypeAdapter$1 generateTypeAdapter$1 = new GenerateTypeAdapter$1();
        K = generateTypeAdapter$1;
    }
}

