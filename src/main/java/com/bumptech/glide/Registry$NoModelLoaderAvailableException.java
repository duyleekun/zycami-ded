/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide;

import com.bumptech.glide.Registry$MissingComponentException;
import java.util.List;

public class Registry$NoModelLoaderAvailableException
extends Registry$MissingComponentException {
    public Registry$NoModelLoaderAvailableException(Class object, Class clazz) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to find any ModelLoaders for model: ");
        stringBuilder.append(object);
        stringBuilder.append(" and data: ");
        stringBuilder.append(clazz);
        object = stringBuilder.toString();
        super((String)object);
    }

    public Registry$NoModelLoaderAvailableException(Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to find any ModelLoaders registered for model class: ");
        object = object.getClass();
        stringBuilder.append(object);
        object = stringBuilder.toString();
        super((String)object);
    }

    public Registry$NoModelLoaderAvailableException(Object object, List list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Found ModelLoaders for model class: ");
        stringBuilder.append(list);
        stringBuilder.append(", but none that handle this specific model instance: ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        super((String)object);
    }
}

