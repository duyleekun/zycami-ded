/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

import com.baidu.location.indoor.n;
import java.util.TimerTask;

public class p
extends TimerTask {
    public final /* synthetic */ n a;

    public p(n n10) {
        this.a = n10;
    }

    public void run() {
        n n10 = this.a;
        try {
            n.n(n10);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

