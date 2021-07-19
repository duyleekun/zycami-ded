/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.d;

import com.zhiyun.net.BaseEntity;
import com.zhiyun.net.NetCallback;
import k.d;
import k.f;
import k.r;

public abstract class a
implements f,
NetCallback {
    private static final int a = 255;
    private static final int b = 254;

    public void onFailure(d d10, Throwable throwable) {
        this.onError(throwable, -1, "\u7f51\u7edc\u8fde\u63a5\u8d85\u65f6\uff0c\u8bf7\u91cd\u8bd5");
    }

    public void onResponse(d object, r object2) {
        int n10;
        object = (BaseEntity)((r)object2).a();
        if (object != null) {
            n10 = ((BaseEntity)object).errcode;
            object = ((BaseEntity)object).errmsg;
        } else {
            object = new StringBuilder();
            String string2 = ((r)object2).toString();
            ((StringBuilder)object).append(string2);
            string2 = ",isSuccessful = ";
            ((StringBuilder)object).append(string2);
            n10 = (int)(((r)object2).g() ? 1 : 0);
            ((StringBuilder)object).append(n10 != 0);
            object = ((StringBuilder)object).toString();
            n10 = -2;
        }
        if (n10 == 0) {
            object = ((r)object2).a();
            this.onSuccess(object);
        } else {
            CharSequence charSequence = new StringBuilder();
            charSequence.append(n10);
            charSequence.append((String)object);
            charSequence = charSequence.toString();
            object2 = new Throwable((String)charSequence);
            this.onError((Throwable)object2, n10, (String)object);
        }
    }
}

