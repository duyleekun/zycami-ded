/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons;

import com.mob.commons.b$4$1;
import com.mob.commons.e;
import com.mob.tools.MobHandlerThread;
import java.io.File;

public final class b$4
extends MobHandlerThread {
    public final /* synthetic */ String a;

    public b$4(String string2) {
        this.a = string2;
    }

    private void a() {
        super.run();
    }

    public static /* synthetic */ void a(b$4 b$4) {
        b$4.a();
    }

    public void run() {
        File file = e.a("comm/locks/.dy_lock");
        b$4$1 b$4$1 = new b$4$1(this);
        e.a(file, true, b$4$1);
    }
}

