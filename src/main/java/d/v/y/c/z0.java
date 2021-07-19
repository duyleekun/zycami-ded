/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.usb.DataType;
import com.zhiyun.protocol.message.usb.LenType;
import com.zhiyun.protocol.message.usb.media.MediaType;
import d.v.y.c.a1;
import d.v.y.c.u1.a;
import d.v.y.c.u1.b;
import d.v.y.c.u1.d.c;

public class z0
extends a1 {
    public z0() {
        Object object = new c();
        super((a)object);
        ((b)this.g()).q(false);
        object = (b)this.g();
        Enum enum_ = DataType.MEDIA;
        ((b)object).s((DataType)enum_);
        object = (b)this.g();
        enum_ = LenType.BIT_4;
        ((b)object).u((LenType)enum_);
        ((b)this.g()).d(10);
        ((c)this.f()).c(false);
        this.p(false);
    }

    public void A(int n10) {
        ((c)this.f()).n(n10);
    }

    public void B(int n10) {
        ((c)this.f()).o(n10);
    }

    public void C(MediaType mediaType) {
        ((c)this.f()).e(mediaType);
    }

    public void D(int n10) {
        ((c)this.f()).p(n10);
    }

    public void E(int n10) {
        ((c)this.f()).q(n10);
    }

    public void F(int n10) {
        ((c)this.f()).r(n10);
    }

    public void G(boolean bl2) {
        ((c)this.f()).s(bl2);
    }

    public boolean parseFrom(byte[] byArray) {
        return super.parseFrom(byArray);
    }

    public byte[] r() {
        return ((c)this.f()).f();
    }

    public int s() {
        return ((c)this.f()).g();
    }

    public int t() {
        return ((c)this.f()).h();
    }

    public MediaType u() {
        return ((c)this.f()).d();
    }

    public int v() {
        return ((c)this.f()).i();
    }

    public int w() {
        return ((c)this.f()).j();
    }

    public int x() {
        return ((c)this.f()).k();
    }

    public boolean y() {
        return ((c)this.f()).l();
    }

    public void z(byte[] byArray) {
        ((c)this.f()).m(byArray);
    }
}

