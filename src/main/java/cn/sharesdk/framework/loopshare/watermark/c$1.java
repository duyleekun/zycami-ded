/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.loopshare.watermark;

import cn.sharesdk.framework.loopshare.watermark.a;

public final class c$1
implements Runnable {
    public final /* synthetic */ boolean[] a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String[] c;

    public c$1(boolean[] blArray, String string2, String[] stringArray) {
        this.a = blArray;
        this.b = string2;
        this.c = stringArray;
    }

    public void run() {
        boolean bl2;
        boolean[] blArray = this.a;
        String string2 = this.b;
        String[] stringArray = this.c;
        blArray[0] = bl2 = cn.sharesdk.framework.loopshare.watermark.a.a(string2, stringArray);
    }
}

