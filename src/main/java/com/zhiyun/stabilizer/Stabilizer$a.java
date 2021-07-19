/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer;

import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.oe.q;
import e.a.v0.g;

public class Stabilizer$a
implements g {
    public final /* synthetic */ Stabilizer a;

    public Stabilizer$a(Stabilizer stabilizer) {
        this.a = stabilizer;
    }

    public void a(String[] object) {
        CharSequence charSequence = new StringBuilder();
        for (String string2 : object) {
            charSequence.append(string2);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("#uploadJsonFile#  ");
        charSequence = charSequence.toString();
        ((StringBuilder)object).append((String)charSequence);
        q.a(((StringBuilder)object).toString());
    }
}

