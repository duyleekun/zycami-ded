/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.g1;

import android.text.TextUtils;
import com.zhiyun.cama.data.api.entity.HotResEntity;
import com.zhiyun.net.BaseEntity;
import d.v.c.g1.i;
import java.io.File;
import k.d;
import k.f;
import k.r;
import m.a.a;

public class i$a
implements f {
    public final /* synthetic */ i a;

    public i$a(i i10) {
        this.a = i10;
    }

    public void onFailure(d object, Throwable serializable) {
        int n10;
        object = this.a;
        int n11 = i.g((i)object);
        if (n11 <= (n10 = 2)) {
            object = this.a;
            ((i)object).j();
        } else {
            object = this.a;
            serializable = i.d((i)object, "hotres/translation");
            i.e((i)object, (File)serializable);
        }
    }

    public void onResponse(d object, r object2) {
        object = (BaseEntity)object2.a();
        if (object != null) {
            int n10 = ((BaseEntity)object).errcode;
            object2 = (HotResEntity)object2.a();
            String string2 = "hotres/translation";
            if (n10 != 0) {
                object2 = new StringBuilder();
                String string3 = "\u6ca1\u6709\u65b0\u7248\u672c\uff0c\u6216\u53c2\u6570\u9519\u8bef\uff0c\u8bfb\u53d6\u4e0a\u6b21\u7684\u7ffb\u8bd1\u8d44\u6e90\uff0ccode:";
                object2.append(string3);
                object2.append(n10);
                object2.append(",");
                object = i.d(this.a, string2);
                object2.append(object);
                object = object2.toString();
                object2 = new Object[]{};
                m.a.a.i((String)object, object2);
                object = this.a;
                object2 = i.d((i)object, string2);
                i.e((i)object, (File)object2);
            } else if (object2 != null) {
                object = this.a;
                int n11 = object2.getVer();
                i.a((i)object, n11);
                object = this.a;
                object2 = object2.getUrl();
                i.c((i)object, (String)object2);
                object = i.b(this.a);
                n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                if (n10 != 0) {
                    object = this.a;
                    object2 = i.d((i)object, string2);
                    i.e((i)object, (File)object2);
                    return;
                }
                object = this.a;
                object2 = i.b((i)object);
                i.f((i)object, (String)object2);
            }
        }
    }
}

