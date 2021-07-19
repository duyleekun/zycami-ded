/*
 * Decompiled with CFR 0.151.
 */
package d.v.z.l;

import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import com.zhiyun.remoteprotocol.constant.ProtoType;

public interface h {
    public ProtoType a();

    public void b(ZYEnumDefine.ErrorCode var1);

    public byte[] c();

    public void clear();

    public ZYEnumDefine.ErrorCode getErrorCode();

    public int getLength();

    public boolean parseFrom(byte[] var1);
}

