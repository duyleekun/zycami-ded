/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import d.v.d.i.g.k;
import d.v.d.i.g.k$a;

public class TypeFpsSizeConverters {
    public String fpsSizeToString(k$a k$a) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = String.valueOf(k$a.c());
        stringBuilder.append(string2);
        int n10 = k$a.b();
        stringBuilder.append(n10);
        int n11 = k$a.a.getHeight();
        stringBuilder.append(n11);
        return stringBuilder.toString();
    }

    public k$a stringToFpsSize(String object) {
        int n10;
        if (object != null && (n10 = ((String)object).isEmpty()) == 0) {
            int n11;
            block15: {
                block13: {
                    block14: {
                        n10 = 0;
                        String string2 = null;
                        n11 = 2;
                        string2 = ((String)object).substring(0, n11);
                        n10 = Integer.parseInt(string2);
                        int n12 = 4;
                        String string3 = ((String)object).substring(n11, n12);
                        n11 = Integer.parseInt(string3);
                        object = ((String)object).substring(n12);
                        int n13 = Integer.parseInt((String)object);
                        n12 = 720;
                        if (n13 == n12) break block13;
                        n12 = 2160;
                        if (n13 == n12) break block14;
                        object = k.s;
                        break block15;
                    }
                    object = k.t;
                    break block15;
                }
                object = k.r;
            }
            ((k$a)object).h(n11);
            try {
                ((k$a)object).i(n10);
            }
            catch (Exception exception) {
                object = k.s;
            }
            return object;
        }
        return k.s;
    }
}

