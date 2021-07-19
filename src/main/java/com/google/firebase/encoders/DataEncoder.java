/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.encoders;

import java.io.Writer;

public interface DataEncoder {
    public String encode(Object var1);

    public void encode(Object var1, Writer var2);
}

