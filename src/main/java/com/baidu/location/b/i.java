/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.b;

import com.baidu.location.b.g;
import com.baidu.location.h.l;
import java.io.File;

public class i
extends Thread {
    public final /* synthetic */ g a;

    public i(g g10) {
        this.a = g10;
    }

    public void run() {
        CharSequence charSequence = new StringBuilder();
        String string2 = l.k();
        charSequence.append(string2);
        charSequence.append("/baidu/tempdata");
        charSequence = charSequence.toString();
        File file = new File((String)charSequence, "intime.dat");
        g.a(this.a, file, "https://itsdata.map.baidu.com/long-conn-gps/sdk.php");
    }
}

