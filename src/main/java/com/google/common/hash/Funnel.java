/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.PrimitiveSink;
import java.io.Serializable;

public interface Funnel
extends Serializable {
    public void funnel(Object var1, PrimitiveSink var2);
}

