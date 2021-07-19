/*
 * Decompiled with CFR 0.151.
 */
package d.v.z.l;

import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import d.v.z.l.h;

public abstract class c
implements h {
    private int a;
    private ZYEnumDefine$ErrorCode b;

    public c() {
        ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode = ZYEnumDefine$ErrorCode.ErrorCodeNon;
        this.b(zYEnumDefine$ErrorCode);
    }

    public void b(ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode) {
        this.b = zYEnumDefine$ErrorCode;
    }

    public void clear() {
        this.a = 0;
        ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode = ZYEnumDefine$ErrorCode.ErrorCodeNon;
        this.b(zYEnumDefine$ErrorCode);
    }

    public abstract boolean d(byte[] var1);

    public void e(c c10) {
        c10.clear();
        int n10 = this.a;
        c10.h(n10);
        ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode = this.b;
        c10.b(zYEnumDefine$ErrorCode);
    }

    public abstract h f();

    public c g(c object) {
        object = object.c();
        this.parseFrom((byte[])object);
        return this;
    }

    public ZYEnumDefine$ErrorCode getErrorCode() {
        return this.b;
    }

    public int getLength() {
        return this.a;
    }

    public void h(int n10) {
        this.a = n10;
    }

    public boolean parseFrom(byte[] byArray) {
        if (byArray == null) {
            return false;
        }
        int n10 = byArray.length;
        this.h(n10);
        return this.d(byArray);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{length=");
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(", errorCode=");
        ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode = this.b;
        stringBuilder.append(zYEnumDefine$ErrorCode);
        stringBuilder.append(", ");
        return stringBuilder.toString();
    }
}

