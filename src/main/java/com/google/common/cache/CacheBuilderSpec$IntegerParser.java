/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$ValueParser;

public abstract class CacheBuilderSpec$IntegerParser
implements CacheBuilderSpec$ValueParser {
    public void parse(CacheBuilderSpec cacheBuilderSpec, String string2, String string3) {
        IllegalArgumentException illegalArgumentException;
        int n10;
        int n11 = 1;
        if (string3 != null && (n10 = string3.isEmpty()) == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            illegalArgumentException = null;
        }
        Object[] objectArray = "value of key %s omitted";
        Preconditions.checkArgument(n10 != 0, (String)objectArray, (Object)string2);
        try {
            n10 = Integer.parseInt(string3);
        }
        catch (NumberFormatException numberFormatException) {
            objectArray = new Object[2];
            objectArray[0] = string2;
            objectArray[n11] = string3;
            string2 = CacheBuilderSpec.access$000("key %s value set to %s, must be integer", objectArray);
            illegalArgumentException = new IllegalArgumentException(string2, numberFormatException);
            throw illegalArgumentException;
        }
        this.parseInteger(cacheBuilderSpec, n10);
    }

    public abstract void parseInteger(CacheBuilderSpec var1, int var2);
}

