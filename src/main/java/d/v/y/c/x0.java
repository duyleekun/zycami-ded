/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.usb.DataType;
import com.zhiyun.protocol.message.usb.LenType;
import com.zhiyun.protocol.message.usb.command.CmdType;
import d.v.y.c.a1;
import d.v.y.c.p;
import d.v.y.c.u1.c.a;
import d.v.y.c.u1.c.b;

public class x0
extends a1 {
    public x0() {
        Object object = new a();
        super((d.v.y.c.u1.a)object);
        object = (d.v.y.c.u1.b)this.g();
        Enum enum_ = DataType.COMMAND;
        ((d.v.y.c.u1.b)object).s((DataType)enum_);
        object = (d.v.y.c.u1.b)this.g();
        enum_ = LenType.BIT_2;
        ((d.v.y.c.u1.b)object).u((LenType)enum_);
        ((d.v.y.c.u1.b)this.g()).d(8);
        object = (a)this.f();
        enum_ = CmdType.ZYBL;
        ((b)object).e((CmdType)enum_);
    }

    public p r() {
        return ((a)this.f()).f();
    }

    public void s(p p10) {
        ((a)this.f()).g(p10);
    }
}

