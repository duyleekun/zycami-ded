/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.CharMatcher;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath$ResourceInfo;
import com.google.common.reflect.Reflection;

public final class ClassPath$ClassInfo
extends ClassPath$ResourceInfo {
    private final String className;

    public ClassPath$ClassInfo(String string2, ClassLoader classLoader) {
        super(string2, classLoader);
        this.className = string2 = ClassPath.getClassName(string2);
    }

    public static /* synthetic */ String access$000(ClassPath$ClassInfo classPath$ClassInfo) {
        return classPath$ClassInfo.className;
    }

    public String getName() {
        return this.className;
    }

    public String getPackageName() {
        return Reflection.getPackageName(this.className);
    }

    public String getSimpleName() {
        int n10;
        String string2 = this.className;
        int n11 = string2.lastIndexOf(36);
        if (n11 != (n10 = -1)) {
            String string3 = this.className;
            string2 = string3.substring(++n11);
            return CharMatcher.inRange('0', '9').trimLeadingFrom(string2);
        }
        string2 = this.getPackageName();
        n10 = (int)(string2.isEmpty() ? 1 : 0);
        if (n10 != 0) {
            return this.className;
        }
        String string4 = this.className;
        n11 = string2.length() + 1;
        return string4.substring(n11);
    }

    public Class load() {
        Object object;
        ClassLoader classLoader;
        try {
            classLoader = this.loader;
        }
        catch (ClassNotFoundException classNotFoundException) {
            object = new IllegalStateException(classNotFoundException);
            throw object;
        }
        object = this.className;
        return classLoader.loadClass((String)object);
    }

    public String toString() {
        return this.className;
    }
}

