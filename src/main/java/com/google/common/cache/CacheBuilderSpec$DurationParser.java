/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$ValueParser;
import java.util.concurrent.TimeUnit;

public abstract class CacheBuilderSpec$DurationParser
implements CacheBuilderSpec$ValueParser {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void parse(CacheBuilderSpec object, String string2, String string3) {
        int n10;
        int n11;
        Object[] objectArray;
        int n12;
        int n13 = 1;
        if (string3 != null && (n12 = string3.isEmpty()) == 0) {
            n12 = n13;
        } else {
            n12 = 0;
            objectArray = null;
        }
        String string4 = "value of key %s omitted";
        Preconditions.checkArgument(n12 != 0, string4, (Object)string2);
        n12 = 2;
        try {
            n11 = string3.length() - n13;
        }
        catch (NumberFormatException numberFormatException) {
            objectArray = new Object[n12];
            objectArray[0] = string2;
            objectArray[n13] = string3;
            string2 = CacheBuilderSpec.access$000("key %s value set to %s, must be integer", objectArray);
            object = new IllegalArgumentException(string2);
            throw object;
        }
        {
            block11: {
                block12: {
                    n11 = string3.charAt(n11);
                    n10 = 100;
                    if (n11 == n10) break block12;
                    n10 = 104;
                    if (n11 != n10) {
                        n10 = 109;
                        if (n11 != n10) {
                            n10 = 115;
                            if (n11 != n10) {
                                String string5 = "key %s invalid format.  was %s, must end with one of [dDhHmMsS]";
                                Object[] objectArray2 = new Object[n12];
                                objectArray2[0] = string2;
                                objectArray2[n13] = string3;
                                String string6 = CacheBuilderSpec.access$000(string5, objectArray2);
                                object = new IllegalArgumentException(string6);
                                throw object;
                            }
                            TimeUnit timeUnit = TimeUnit.SECONDS;
                            break block11;
                        } else {
                            TimeUnit timeUnit = TimeUnit.MINUTES;
                        }
                        break block11;
                    } else {
                        TimeUnit timeUnit = TimeUnit.HOURS;
                    }
                    break block11;
                }
                TimeUnit timeUnit = TimeUnit.DAYS;
            }
            n10 = string3.length() - n13;
        }
        {
            void var7_14;
            String string7 = string3.substring(0, n10);
            long l10 = Long.parseLong(string7);
            this.parseDuration((CacheBuilderSpec)object, l10, (TimeUnit)var7_14);
            return;
        }
    }

    public abstract void parseDuration(CacheBuilderSpec var1, long var2, TimeUnit var4);
}

