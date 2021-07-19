/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ax {
    public int a;
    public String a;
    public Map a;

    public ax() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    public String a() {
        return this.a;
    }

    public String toString() {
        Object object = this.a;
        Object[] objectArray = new Object[]{object, object = this.a.toString(), object = this.a};
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", objectArray);
    }
}

