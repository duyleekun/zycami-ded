/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.u1.c;

import com.zhiyun.protocol.message.usb.command.CmdType;
import d.v.y.c.u1.a;

public abstract class b
extends a {
    public CmdType b;

    public b() {
        CmdType cmdType;
        this.b = cmdType = CmdType.UNKNOWN;
    }

    public CmdType d() {
        return this.b;
    }

    public void e(CmdType cmdType) {
        this.b = cmdType;
    }
}

