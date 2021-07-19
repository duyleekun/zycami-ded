/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

import com.tencent.liteav.basic.util.g;
import com.tencent.rtmp.b;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class b$10
implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ b b;

    public b$10(b b10, String string2) {
        this.b = b10;
        this.a = string2;
    }

    public void run() {
        Object object = this.a;
        Object object2 = new File((String)object);
        object2 = object2.getParentFile();
        object = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
        long l10 = System.currentTimeMillis();
        Object object3 = new Date(l10);
        object = ((DateFormat)object).format((Date)object3);
        object3 = new StringBuilder();
        ((StringBuilder)object3).append(object2);
        object2 = File.separator;
        ((StringBuilder)object3).append((String)object2);
        object2 = new Object[]{object};
        object2 = String.format("TXUGCCover_%s.jpg", object2);
        ((StringBuilder)object3).append((String)object2);
        object2 = ((StringBuilder)object3).toString();
        g.a(this.a, (String)object2);
        object = this.b;
        object3 = this.a;
        com.tencent.rtmp.b.a((b)object, (String)object3, (String)object2);
    }
}

