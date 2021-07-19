/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.Platform;
import java.util.Comparator;

public final class h$1
implements Comparator {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int a(Platform platform, Platform platform2) {
        int n10;
        int n11;
        int n12;
        int n13 = platform.getSortId();
        if (n13 != (n12 = platform2.getSortId())) {
            n11 = platform.getSortId();
            n10 = platform2.getSortId();
            return n11 - n10;
        }
        n11 = platform.getPlatformId();
        n10 = platform2.getPlatformId();
        return n11 - n10;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        object = (Platform)object;
        object2 = (Platform)object2;
        return this.a((Platform)object, (Platform)object2);
    }
}

