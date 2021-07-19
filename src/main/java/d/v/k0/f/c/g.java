/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.c;

import com.zhiyun.zysocket.udp.interactive.UdpInteractiveException;
import e.a.g0;

public interface g
extends g0 {
    public void j(UdpInteractiveException var1);

    default public void onError(Throwable throwable) {
        boolean bl2 = throwable instanceof UdpInteractiveException;
        if (bl2) {
            throwable = (UdpInteractiveException)throwable;
            this.j((UdpInteractiveException)throwable);
        }
    }
}

