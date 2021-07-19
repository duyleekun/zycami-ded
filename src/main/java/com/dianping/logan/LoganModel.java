/*
 * Decompiled with CFR 0.151.
 */
package com.dianping.logan;

import com.dianping.logan.LoganModel$Action;
import d.e.a.j;
import d.e.a.o;

public class LoganModel {
    public LoganModel$Action a;
    public o b;
    public j c;

    public boolean a() {
        boolean bl2;
        LoganModel$Action loganModel$Action;
        Object object = this.a;
        boolean bl3 = true;
        if (!(object != null && (object == (loganModel$Action = LoganModel$Action.SEND) && (object = this.c) != null && (bl2 = ((j)object).a()) || (object = this.a) == (loganModel$Action = LoganModel$Action.WRITE) && (object = this.b) != null && (bl2 = ((o)object).a()) || (object = this.a) == (loganModel$Action = LoganModel$Action.FLUSH)))) {
            bl3 = false;
        }
        return bl3;
    }
}

