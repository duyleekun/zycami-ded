/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.u1.c;

import com.zhiyun.protocol.message.usb.command.CmdType;
import com.zhiyun.protocol.message.usb.command.Flag;
import com.zhiyun.protocol.message.usb.command.UsbStatus;
import d.v.y.c.u1.c.b;

public class d
extends b {
    private UsbStatus c;
    private Flag d;

    public byte[] a() {
        byte by2 = (byte)CmdType.toValue(this.b);
        byte[] byArray = new byte[]{by2, by2 = (byte)UsbStatus.toValue(this.c), by2 = (byte)Flag.toValue(this.d)};
        return byArray;
    }

    public void clear() {
        Enum enum_ = UsbStatus.UNKNOWN;
        this.c = enum_;
        this.d = enum_ = Flag.DISABLE;
    }

    public Flag f() {
        return this.d;
    }

    public UsbStatus g() {
        return this.c;
    }

    public void h(Flag flag) {
        this.d = flag;
    }

    public void i(UsbStatus usbStatus) {
        this.c = usbStatus;
    }

    public boolean parseFrom(byte[] object) {
        int n10 = ((byte[])object).length;
        int n11 = 0;
        int n12 = 3;
        if (n10 >= n12) {
            CmdType cmdType;
            this.b = cmdType = CmdType.toType(object[0]);
            n10 = 1;
            Enum enum_ = UsbStatus.toStatus(object[n10]);
            this.c = enum_;
            n12 = 2;
            byte by2 = object[n12];
            object = (Object)Flag.toFlag(by2);
            this.d = (Flag)((Object)object);
            object = (Object)this.b;
            enum_ = CmdType.MEDIA;
            if (object == enum_) {
                n11 = n10;
            }
        }
        return n11 != 0;
    }
}

