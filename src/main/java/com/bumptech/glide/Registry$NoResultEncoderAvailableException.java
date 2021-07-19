/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide;

import com.bumptech.glide.Registry$MissingComponentException;

public class Registry$NoResultEncoderAvailableException
extends Registry$MissingComponentException {
    public Registry$NoResultEncoderAvailableException(Class object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to find result encoder for resource class: ");
        stringBuilder.append(object);
        stringBuilder.append(", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        object = stringBuilder.toString();
        super((String)object);
    }
}

