/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.j.c;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.data.api.entity.BindThirdEntity;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.net.DataListEntity;
import d.v.a.f.b.a;
import d.v.a.j.c.y;
import java.util.ArrayList;

public class y$f
extends a {
    public final /* synthetic */ y a;

    public y$f(y y10) {
        this.a = y10;
    }

    public void a(DataListEntity iterator2) {
        Object object = this.a;
        Object object2 = "";
        y.e((y)object, (String)object2);
        if (iterator2 != null && (iterator2 = ((DataListEntity)iterator2).list) != null) {
            boolean bl2;
            iterator2 = ((ArrayList)((Object)iterator2)).iterator();
            while (bl2 = iterator2.hasNext()) {
                object = (BindThirdEntity)iterator2.next();
                object2 = ((BindThirdEntity)object).platform;
                String string2 = ThirdPlatform.WE_CHAT.getApiName();
                boolean bl3 = string2.equals(object2);
                if (bl3) {
                    object2 = this.a.k;
                    ((MutableLiveData)object2).setValue(object);
                    continue;
                }
                string2 = ThirdPlatform.WEIBO.getApiName();
                bl3 = string2.equals(object2);
                if (bl3) {
                    object2 = this.a.l;
                    ((MutableLiveData)object2).setValue(object);
                    continue;
                }
                string2 = ThirdPlatform.QQ.getApiName();
                bl3 = string2.equals(object2);
                if (bl3) {
                    object2 = this.a.m;
                    ((MutableLiveData)object2).setValue(object);
                    continue;
                }
                string2 = ThirdPlatform.FACEBOOK.getApiName();
                boolean bl4 = string2.equals(object2);
                if (!bl4) continue;
                object2 = this.a.n;
                ((MutableLiveData)object2).setValue(object);
            }
        }
    }

    public void onError(Throwable throwable, int n10, String string2) {
        y.f(this.a, n10, "show_error_page");
    }
}

