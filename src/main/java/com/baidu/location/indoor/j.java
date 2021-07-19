/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

import com.baidu.location.indoor.g;
import com.baidu.location.indoor.mapversion.a.a;
import com.baidu.location.indoor.mapversion.b.a$c;

public class j
implements a$c {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ g c;

    public j(g g10, String string2, String string3) {
        this.c = g10;
        this.a = string2;
        this.b = string3;
    }

    public void a(boolean bl2, String object) {
        object = this.c;
        g.a((g)object, bl2);
        if (bl2) {
            g g10 = this.c;
            object = this.b;
            boolean bl3 = com.baidu.location.indoor.mapversion.a.a.a((String)object);
            g.b(g10, bl3);
        }
    }
}

