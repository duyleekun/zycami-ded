/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.tencent.liteav.txcvodplayer.a;

import android.util.Log;
import com.tencent.liteav.txcvodplayer.a.b;
import java.io.File;

public class b$1
implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ b c;

    public b$1(b b10, String string2, String string3) {
        this.c = b10;
        this.a = string2;
        this.b = string3;
    }

    public void run() {
        Object object = this.a;
        Object object2 = new File((String)object);
        ((File)object2).delete();
        object2 = this.b;
        object = "mp4";
        boolean bl2 = ((String)object2).equals(object);
        if (bl2) {
            object2 = this.a.concat(".info");
            object = new File((String)object2);
            ((File)object).delete();
        }
        object2 = com.tencent.liteav.txcvodplayer.a.b.d();
        object = new StringBuilder();
        ((StringBuilder)object).append("delete ");
        String string2 = this.a;
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        Log.w((String)object2, (String)object);
    }
}

