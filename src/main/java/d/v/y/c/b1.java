/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.usb.DataType;
import com.zhiyun.protocol.message.usb.LenType;
import com.zhiyun.protocol.message.usb.command.CmdType;
import d.v.y.c.a1;
import d.v.y.c.u1.a;
import d.v.y.c.u1.c.b;
import d.v.y.c.u1.c.e;

public class b1
extends a1 {
    public b1() {
        Object object = new e();
        super((a)object);
        object = (d.v.y.c.u1.b)this.g();
        Enum enum_ = DataType.COMMAND;
        ((d.v.y.c.u1.b)object).s((DataType)enum_);
        object = (d.v.y.c.u1.b)this.g();
        enum_ = LenType.BIT_2;
        ((d.v.y.c.u1.b)object).u((LenType)enum_);
        ((d.v.y.c.u1.b)this.g()).d(8);
        object = (e)this.f();
        enum_ = CmdType.PING;
        ((b)object).e((CmdType)enum_);
    }

    public boolean r() {
        return ((e)this.f()).h();
    }

    public String toString() {
        return ((e)this.f()).toString();
    }
}

