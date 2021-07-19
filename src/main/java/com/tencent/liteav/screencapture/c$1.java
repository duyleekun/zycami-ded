/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.projection.MediaProjection$Callback
 */
package com.tencent.liteav.screencapture;

import android.media.projection.MediaProjection;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.screencapture.c;
import com.tencent.liteav.screencapture.c$a;
import com.tencent.liteav.screencapture.c$b;
import java.util.HashMap;

public class c$1
extends MediaProjection.Callback {
    public final /* synthetic */ c a;

    public c$1(c c10) {
        this.a = c10;
    }

    public void onStop() {
        boolean bl2;
        TXCLog.e("VirtualDisplayManager", "MediaProjection session is no longer valid");
        Object object = c.a(this.a);
        Object object2 = new HashMap(object);
        object = c.a(this.a);
        object.clear();
        object2 = object2.values().iterator();
        while (bl2 = object2.hasNext()) {
            object = (c$a)object2.next();
            c$b c$b = ((c$a)object).d;
            if (c$b == null) continue;
            object = ((c$a)object).e;
            if (object != null) {
                c$b.a();
                continue;
            }
            c$b.a(false, false);
        }
        c.a(this.a, false);
    }
}

