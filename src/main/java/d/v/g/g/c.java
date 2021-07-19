/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import com.zhiyun.device.data.local.entity.FirmwareInfo;
import d.v.g.g.c1$a;

public final class c
implements Runnable {
    public final /* synthetic */ c1$a a;
    public final /* synthetic */ FirmwareInfo b;

    public /* synthetic */ c(c1$a a10, FirmwareInfo firmwareInfo) {
        this.a = a10;
        this.b = firmwareInfo;
    }

    public final void run() {
        c1$a c1$a = this.a;
        FirmwareInfo firmwareInfo = this.b;
        c1$a.b(firmwareInfo);
    }
}

