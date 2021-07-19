/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import d.c.a.o.k.x.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

public interface ImageHeaderParser {
    public static final int a = 255;

    public ImageHeaderParser$ImageType a(ByteBuffer var1);

    public int b(ByteBuffer var1, b var2);

    public ImageHeaderParser$ImageType c(InputStream var1);

    public int d(InputStream var1, b var2);
}

