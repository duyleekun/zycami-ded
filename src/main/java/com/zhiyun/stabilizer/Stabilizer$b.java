/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer;

import androidx.core.util.Pair;
import com.zhiyun.protocol.message.bl.other.UpgradeLink;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.rd;
import d.v.y.d.h;
import e.a.v0.o;

public class Stabilizer$b
implements o {
    public final /* synthetic */ Stabilizer a;

    public Stabilizer$b(Stabilizer stabilizer) {
        this.a = stabilizer;
    }

    public Pair a(rd object) {
        UpgradeLink upgradeLink = h.f(((rd)object).b());
        object = h.e(((rd)object).b());
        return Pair.create((Object)upgradeLink, object);
    }
}

