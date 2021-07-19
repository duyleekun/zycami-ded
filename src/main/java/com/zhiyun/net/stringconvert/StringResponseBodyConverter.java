/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.stringconvert;

import g.d0;
import k.h;

public class StringResponseBodyConverter
implements h {
    public String convert(d0 d02) {
        try {
            String string2 = d02.string();
            return string2;
        }
        finally {
            d02.close();
        }
    }
}

