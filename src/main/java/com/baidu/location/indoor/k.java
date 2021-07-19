/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

import com.baidu.location.indoor.d$b;
import com.baidu.location.indoor.g;
import com.baidu.location.indoor.g$i;

public class k
implements d$b {
    public final /* synthetic */ g$i a;

    public k(g$i g$i) {
        this.a = g$i;
    }

    public void a(boolean bl2, String string2, String string3, String string4) {
        if (bl2) {
            g g10 = this.a.a;
            StringBuilder stringBuilder = new StringBuilder();
            String string5 = "&ibuuid=";
            stringBuilder.append(string5);
            stringBuilder.append(string2);
            stringBuilder.append("&ibname=");
            stringBuilder.append(string3);
            stringBuilder.append("&ibfls=");
            stringBuilder.append(string4);
            string2 = stringBuilder.toString();
            g.a(g10, string2);
        }
    }
}

