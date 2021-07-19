/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CommonPattern;
import com.google.common.base.JdkPattern;
import com.google.common.base.PatternCompiler;
import com.google.common.base.Platform$1;
import java.util.regex.Pattern;

public final class Platform$JdkPatternCompiler
implements PatternCompiler {
    private Platform$JdkPatternCompiler() {
    }

    public /* synthetic */ Platform$JdkPatternCompiler(Platform$1 platform$1) {
        this();
    }

    public CommonPattern compile(String object) {
        object = Pattern.compile((String)object);
        JdkPattern jdkPattern = new JdkPattern((Pattern)object);
        return jdkPattern;
    }

    public boolean isPcreLike() {
        return true;
    }
}

