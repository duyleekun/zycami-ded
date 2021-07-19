/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.network;

import java.io.Closeable;
import java.io.InputStream;

public interface LottieFetchResult
extends Closeable {
    public InputStream bodyByteStream();

    public String contentType();

    public String error();

    public boolean isSuccessful();
}

