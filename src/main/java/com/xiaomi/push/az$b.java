/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class az$b {
    public int a;
    public Map a;

    public String toString() {
        Object object = this.a;
        Object[] objectArray = new Object[]{object, object = this.a.toString()};
        return String.format("resCode = %1$d, headers = %2$s", objectArray);
    }
}

