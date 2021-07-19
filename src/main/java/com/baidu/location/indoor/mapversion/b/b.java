/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.baidu.location.indoor.mapversion.b.a
 */
package com.baidu.location.indoor.mapversion.b;

import com.baidu.location.indoor.mapversion.b.a;
import java.io.File;
import java.io.FilenameFilter;

public class b
implements FilenameFilter {
    public final /* synthetic */ String a;
    public final /* synthetic */ a b;

    public b(a a10, String string2) {
        this.b = a10;
        this.a = string2;
    }

    public boolean accept(File object, String string2) {
        object = new StringBuilder();
        Object object2 = this.b;
        String string3 = this.a;
        object2 = com.baidu.location.indoor.mapversion.b.a.a((a)object2, (String)string3);
        ((StringBuilder)object).append((String)object2);
        object2 = "_";
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        boolean bl2 = string2.startsWith((String)object);
        return bl2;
    }
}

