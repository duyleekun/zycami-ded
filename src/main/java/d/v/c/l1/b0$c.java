/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import com.zhiyun.net.BaseEntity;
import d.v.c.l1.b0;
import k.d;
import k.f;
import k.r;
import m.a.a;

public class b0$c
implements f {
    public final /* synthetic */ b0 a;

    public b0$c(b0 b02) {
        this.a = b02;
    }

    public void onFailure(d objectArray, Throwable throwable) {
        throwable.printStackTrace();
        objectArray = new Object[]{};
        m.a.a.e("\u901a\u77e5\u670d\u52a1\u5668\u8ba2\u5355\u5931\u8d25\u4e0d\u6210\u529f", objectArray);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onResponse(d objectArray, r object) {
        int n10 = ((r)object).g();
        if (n10 != 0 && (objectArray = ((r)object).a()) != null) {
            objectArray = (BaseEntity)((r)object).a();
            n10 = objectArray.errcode;
            if (n10 == 0) {
                objectArray = new Object[]{};
                object = "\u901a\u77e5\u670d\u52a1\u5668\u8ba2\u5355\u5931\u8d25\u6210\u529f";
                m.a.a.e((String)object, objectArray);
                return;
            }
        }
        objectArray = new Object[]{};
        object = "\u901a\u77e5\u670d\u52a1\u5668\u8ba2\u5355\u5931\u8d25\u4e0d\u6210\u529f";
        m.a.a.e((String)object, objectArray);
    }
}

