/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.q1.i0;

import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.data.api.entity.ServerEntity;
import com.zhiyun.cama.data.me.remote.CommunityManager;
import d.v.a.f.b.a;
import d.v.a.f.c.b;
import d.v.c.q1.i0.g$a;
import d.v.c.q1.i0.g$b;
import d.v.c.v0.u.z;
import d.v.e.i.j;

public class g
extends ViewModel {
    private static final String d = "v1/";
    public final j a;
    public final j b;
    public final j c;

    public g() {
        j j10;
        this.a = j10 = new j();
        this.b = j10 = new j();
        this.c = j10 = new j();
    }

    public static /* synthetic */ String b(g g10, String string2, String string3) {
        return g10.g(string2, string3);
    }

    private void e() {
        Object object = d.v.a.f.c.b.N();
        boolean bl2 = ((b)object).s();
        if (bl2) {
            object = CommunityManager.getInstance().createMessageUnreadCount();
            g$b g$b = new g$b(this);
            object.h(g$b);
        }
    }

    private String g(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = string3;
        } else {
            string3 = d;
            bl2 = string2.contains(string3);
            if (!bl2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(string3);
                string2 = stringBuilder.toString();
            }
        }
        return string2;
    }

    public ServerEntity c() {
        return z.m().o();
    }

    public void d() {
        Object object = this.c;
        Object object2 = Boolean.TRUE;
        ((j)object).setValue(object2);
        object = z.m();
        object2 = new g$a(this);
        ((z)object).s((a)object2);
    }

    public void f(ServerEntity serverEntity) {
        z.m().D(serverEntity);
        this.e();
    }
}

