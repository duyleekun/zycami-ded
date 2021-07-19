/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.usb.DataType;
import com.zhiyun.protocol.message.usb.LenType;
import com.zhiyun.protocol.message.usb.command.CmdType;
import com.zhiyun.protocol.message.usb.command.Flag;
import com.zhiyun.protocol.message.usb.command.UsbStatus;
import d.v.y.c.a1;
import d.v.y.c.u1.a;
import d.v.y.c.u1.c.b;
import d.v.y.c.u1.c.d;

public class y0
extends a1 {
    public y0() {
        Object object = new d();
        super((a)object);
        ((d.v.y.c.u1.b)this.g()).q(false);
        object = (d.v.y.c.u1.b)this.g();
        Enum enum_ = DataType.COMMAND;
        ((d.v.y.c.u1.b)object).s((DataType)enum_);
        object = (d.v.y.c.u1.b)this.g();
        enum_ = LenType.BIT_2;
        ((d.v.y.c.u1.b)object).u((LenType)enum_);
        ((d.v.y.c.u1.b)this.g()).d(8);
        ((d)this.f()).c(false);
        object = (d)this.f();
        enum_ = CmdType.MEDIA;
        ((b)object).e((CmdType)enum_);
        this.p(false);
        this.q(18);
    }

    public Flag r() {
        return ((d)this.f()).f();
    }

    public UsbStatus s() {
        return ((d)this.f()).g();
    }

    public void t(Flag flag) {
        ((d)this.f()).h(flag);
    }

    public void u(UsbStatus usbStatus) {
        ((d)this.f()).i(usbStatus);
    }
}

