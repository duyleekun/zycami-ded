/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.zhiyun.mediapipe.ZYMPController
 */
package d.v.r;

import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.PacketCallback;
import com.zhiyun.mediapipe.ZYMPController;

public final class b
implements PacketCallback {
    public final /* synthetic */ ZYMPController a;

    public /* synthetic */ b(ZYMPController zYMPController) {
        this.a = zYMPController;
    }

    public final void process(Packet packet) {
        this.a.h(packet);
    }
}

