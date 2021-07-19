/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

import com.google.common.flogger.LazyArg;
import com.google.common.flogger.util.Checks;

public final class LazyArgs {
    private LazyArgs() {
    }

    public static LazyArg lazy(LazyArg lazyArg) {
        return (LazyArg)Checks.checkNotNull(lazyArg, "lazy arg");
    }
}

