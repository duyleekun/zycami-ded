/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CommonPattern;

public interface PatternCompiler {
    public CommonPattern compile(String var1);

    public boolean isPcreLike();
}

