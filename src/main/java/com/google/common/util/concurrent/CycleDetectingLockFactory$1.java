/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.Lists;
import java.util.ArrayList;

public final class CycleDetectingLockFactory$1
extends ThreadLocal {
    public ArrayList initialValue() {
        return Lists.newArrayListWithCapacity(3);
    }
}

