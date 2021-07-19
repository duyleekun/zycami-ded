/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide;

import com.bumptech.glide.Registry$MissingComponentException;

public class Registry$NoSourceEncoderAvailableException
extends Registry$MissingComponentException {
    public Registry$NoSourceEncoderAvailableException(Class object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to find source encoder for data class: ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        super((String)object);
    }
}

