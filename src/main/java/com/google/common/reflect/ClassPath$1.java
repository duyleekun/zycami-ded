/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Predicate;
import com.google.common.reflect.ClassPath$ClassInfo;

public final class ClassPath$1
implements Predicate {
    public boolean apply(ClassPath$ClassInfo object) {
        int n10;
        int n11 = ((String)(object = ClassPath$ClassInfo.access$000((ClassPath$ClassInfo)object))).indexOf(36);
        if (n11 == (n10 = -1)) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11 != 0;
    }
}

