/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide;

import com.bumptech.glide.Registry$MissingComponentException;

public final class Registry$NoImageHeaderParserException
extends Registry$MissingComponentException {
    public Registry$NoImageHeaderParserException() {
        super("Failed to find image header parser.");
    }
}

