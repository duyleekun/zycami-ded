/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.message.bl.other.OtherStatus;
import d.v.e0.ce;
import d.v.e0.ie.d;
import d.v.e0.oe.q;
import e.a.v0.g;

public class ce$d1
implements g {
    public final /* synthetic */ d a;
    public final /* synthetic */ ce b;

    public ce$d1(ce ce2, d d10) {
        this.b = ce2;
        this.a = d10;
    }

    public void a(OtherStatus object) {
        d d10 = this.a;
        if (d10 != null) {
            Object object2 = OtherStatus.NONE_ERROR;
            if (object == object2) {
                d10.c();
                object = "\u56fa\u4ef6\u4e0a\u4f20\u6210\u529f";
                q.a((String)object);
            } else {
                object2 = "MD5\u6821\u9a8c\u5931\u8d25,\u4e0a\u4f20\u5931\u8d25.";
                object = new ArithmeticException((String)object2);
                d10.d((Throwable)object);
                q.j((String)object2);
            }
        }
    }
}

