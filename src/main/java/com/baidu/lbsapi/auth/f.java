/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.e;
import java.util.List;

public class f
implements Runnable {
    public final /* synthetic */ e a;

    public f(e e10) {
        this.a = e10;
    }

    public void run() {
        e e10 = this.a;
        List list = e.a(e10);
        e.a(e10, list);
    }
}

