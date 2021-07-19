/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.text.TextUtils
 *  android.view.View
 */
package d.v.a.j.c;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.zhiyun.account.R$string;
import com.zhiyun.account.data.NetworkState;
import com.zhiyun.account.data.NetworkState$Status;
import com.zhiyun.account.data.api.entity.BindThirdEntity;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.set.privacy.getcode.PrivateGetCodeStatus;
import d.v.a.f.b.a;
import d.v.a.f.c.b;
import d.v.a.f.c.c;
import d.v.a.i.b.e;
import d.v.a.i.b.f;
import d.v.a.j.c.k;
import d.v.a.j.c.l;
import d.v.a.j.c.y$a;
import d.v.a.j.c.y$b;
import d.v.a.j.c.y$c;
import d.v.a.j.c.y$d;
import d.v.a.j.c.y$e;
import d.v.a.j.c.y$f;
import d.v.a.j.c.y$g;
import d.v.a.j.c.y$h;
import d.v.a.j.c.y$i;
import d.v.e.i.j;
import d.v.f.i.g;

public class y
extends ViewModel {
    public static final String D = "show_error_page";
    public final MutableLiveData A;
    public final MutableLiveData B;
    public final MutableLiveData C;
    private c a;
    public final MutableLiveData b;
    public final MutableLiveData c;
    public final MutableLiveData d;
    public final MutableLiveData e;
    public final MutableLiveData f;
    public final MutableLiveData g;
    public final MutableLiveData h;
    public final LiveData i;
    public final j j;
    public final MutableLiveData k;
    public final MutableLiveData l;
    public final MutableLiveData m;
    public final MutableLiveData n;
    public final j o;
    public final j p;
    public final j q;
    public final j r;
    public final j s;
    public final j t;
    public final j u;
    private String v;
    private String w;
    private String x;
    public final LiveData y;
    public final MutableLiveData z;

    public y() {
        LiveData liveData;
        this.b = liveData = new MutableLiveData();
        this.c = liveData = new MutableLiveData();
        this.d = liveData = new MutableLiveData();
        this.e = liveData = new MutableLiveData();
        this.f = liveData = new MutableLiveData();
        this.g = liveData = new MutableLiveData();
        Object object = new MutableLiveData();
        this.h = object;
        this.j = object;
        object = new MutableLiveData();
        this.k = object;
        object = new MutableLiveData();
        this.l = object;
        object = new MutableLiveData();
        this.m = object;
        object = new MutableLiveData();
        this.n = object;
        super();
        this.o = object;
        super();
        this.p = object;
        super();
        this.q = object;
        super();
        this.r = object;
        super();
        this.s = object;
        super();
        this.t = object;
        super();
        this.u = object;
        object = new MutableLiveData();
        this.z = object;
        object = new MutableLiveData();
        this.A = object;
        object = new MutableLiveData();
        this.B = object;
        object = new MutableLiveData();
        this.C = object;
        this.a = object = d.v.a.f.c.b.N();
        object = new k(this);
        liveData = Transformations.map(liveData, (Function)object);
        this.i = liveData;
        liveData = this.a.c();
        object = new l(this);
        liveData = Transformations.map(liveData, (Function)object);
        this.y = liveData;
    }

    private void G(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            j j10 = this.r;
            j10.setValue(string2);
        }
    }

    private void H(String string2) {
        j j10 = this.j;
        NetworkState$Status networkState$Status = NetworkState$Status.SUCCESS;
        NetworkState networkState = new NetworkState(networkState$Status, 0, string2);
        j10.setValue(networkState);
    }

    public static /* synthetic */ void b(y y10, String string2) {
        y10.z(string2);
    }

    public static /* synthetic */ String c(y y10, String string2) {
        y10.x = string2;
        return string2;
    }

    public static /* synthetic */ void d(y y10, String string2) {
        y10.G(string2);
    }

    public static /* synthetic */ void e(y y10, String string2) {
        y10.H(string2);
    }

    public static /* synthetic */ void f(y y10, int n10, String string2) {
        y10.k(n10, string2);
    }

    public static /* synthetic */ c g(y y10) {
        return y10.a;
    }

    private void k(int n10, String string2) {
        j j10 = this.j;
        NetworkState$Status networkState$Status = NetworkState$Status.FAILED;
        NetworkState networkState = new NetworkState(networkState$Status, n10, string2);
        j10.setValue(networkState);
    }

    private /* synthetic */ String r(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            boolean bl3;
            object = this.a.v();
            String string2 = "";
            object = ((String)object).replace("+", string2);
            Object object2 = d.v.a.i.b.f.b(d.v.e.f.a().c().getResources()).iterator();
            String string3 = "86";
            while (bl3 = object2.hasNext()) {
                string3 = ((e)object2.next()).b();
                bl3 = TextUtils.isEmpty((CharSequence)string3);
                bl3 = !bl3 && (bl3 = ((String)object).startsWith(string3));
                if (!bl3) continue;
                object2 = this.h;
                ((MutableLiveData)object2).setValue(string3);
                break;
            }
            return ((String)object).replaceFirst(string3, string2);
        }
        return this.a.b();
    }

    private /* synthetic */ Integer t(UserInfo object) {
        Object object2;
        Object object3 = "";
        if (object != null) {
            object2 = ((UserInfo)object).getMobile();
            boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((UserInfo)object).getMail()));
            if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object2))) {
                this.z.setValue(object2);
                this.B.setValue(object);
                object = this.A;
                int n10 = R$string.set_manage;
                object2 = n10;
                ((MutableLiveData)object).setValue(object2);
                object = this.C;
                object3 = n10;
                ((MutableLiveData)object).setValue(object3);
                return 3;
            }
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (!bl2) {
                this.z.setValue(object3);
                this.B.setValue(object);
                object = this.A;
                object3 = R$string.set_un_bind;
                ((MutableLiveData)object).setValue(object3);
                object = this.C;
                object3 = R$string.device_replace;
                ((MutableLiveData)object).setValue(object3);
                return 2;
            }
            boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl3) {
                this.z.setValue(object2);
                this.B.setValue(object3);
                object = this.A;
                object3 = R$string.device_replace;
                ((MutableLiveData)object).setValue(object3);
                object = this.C;
                object3 = R$string.set_un_bind;
                ((MutableLiveData)object).setValue(object3);
                return 1;
            }
        }
        object = this.A;
        int n11 = R$string.set_un_bind;
        Integer n12 = n11;
        ((MutableLiveData)object).setValue(n12);
        object = this.C;
        object2 = n11;
        ((MutableLiveData)object).setValue(object2);
        this.z.setValue(object3);
        this.B.setValue(object3);
        return 0;
    }

    private void y() {
        j j10 = this.j;
        NetworkState$Status networkState$Status = NetworkState$Status.RUNNING;
        NetworkState networkState = new NetworkState(networkState$Status);
        j10.setValue(networkState);
    }

    private void z(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            j j10 = this.q;
            j10.setValue(string2);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void A(PrivateGetCodeStatus object) {
        void var3_10;
        Object object2;
        this.f.setValue(object);
        Object object3 = this.g.getValue();
        if (object3 != null) {
            object3 = (Boolean)this.g.getValue();
            boolean n10 = (Boolean)object3;
            object2 = this.g;
            Boolean bl2 = n10;
            ((MutableLiveData)object2).setValue(bl2);
        } else {
            boolean bl3 = false;
            object3 = null;
        }
        object2 = y$i.a;
        int n10 = ((Enum)object).ordinal();
        n10 = object2[n10];
        int n11 = 1;
        if (n10 != n11) {
            void var3_5;
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n10 = var3_5 != false ? R$string.me_bind_phone : R$string.me_bind_email;
                    int n12 = R$string.set_bind;
                } else {
                    n10 = var3_5 != false ? R$string.set_bind_cahnge_phone : R$string.set_bind_change_email;
                    int n13 = R$string.set_bind_commit;
                }
            } else {
                n10 = var3_5 != false ? R$string.set_bind_cahnge_phone : R$string.set_bind_change_email;
                int n14 = R$string.me_next;
            }
        } else {
            n10 = R$string.set_private_reset_pass;
            int n15 = R$string.me_next;
        }
        object2 = this.d;
        object = n10;
        ((MutableLiveData)object2).setValue(object);
        object = this.e;
        object3 = (int)var3_10;
        ((MutableLiveData)object).setValue(object3);
    }

    public void F(View view, String string2) {
        j j10 = this.o;
        Boolean bl2 = Boolean.TRUE;
        j10.setValue(bl2);
        y$d y$d = new y$d(this, view);
        c c10 = this.a;
        String string3 = this.v;
        String string4 = this.w;
        String string5 = this.x;
        c10.y(string3, string4, string2, string5, y$d);
    }

    public void i(Context context, ThirdPlatform thirdPlatform) {
        this.y();
        c c10 = this.a;
        y$g y$g = new y$g(this, context);
        c10.o(thirdPlatform, y$g);
    }

    public void j() {
        this.v = null;
        this.w = null;
        this.x = null;
    }

    public String l(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return "";
        }
        return "\uff1a";
    }

    public void m(boolean bl2) {
        Object object;
        Object object2;
        this.y();
        if (bl2) {
            object2 = new BindThirdEntity();
            this.k.setValue(object2);
            this.l.setValue(object2);
            this.m.setValue(object2);
            object = this.n;
            ((MutableLiveData)object).setValue(object2);
        }
        object2 = this.a;
        object = new y$f(this);
        object2.F((a)object);
    }

    public void n(View object, PrivateGetCodeStatus object2, String string2, String string3, String string4) {
        this.v = string2;
        this.w = string3;
        Object object3 = this.o;
        Boolean bl2 = Boolean.TRUE;
        ((j)object3).setValue(bl2);
        y$b y$b = new y$b(this, (PrivateGetCodeStatus)((Object)object2), (View)object);
        object = new y$c(this, y$b);
        object3 = y$i.a;
        Object object4 = ((Enum)object2).ordinal();
        object4 = object3[object4];
        Object object5 = 1;
        if (object4 != object5) {
            object5 = 2;
            if (object4 != object5) {
                object2 = this.a;
                object2.t(string2, string3, string4, (a)object);
            } else {
                object2 = this.a;
                object2.n(string2, string3, string4, (a)object);
            }
        } else {
            c c10 = this.a;
            c10.E(string2, string3, string4, false, y$b);
        }
    }

    public String o(Context object, BindThirdEntity bindThirdEntity) {
        boolean bl2 = this.p(bindThirdEntity);
        if (bl2) {
            object = bindThirdEntity.nickname;
        } else {
            int n10 = R$string.set_un_bind;
            object = d.v.f.i.g.m(object, n10);
        }
        return object;
    }

    public boolean p(BindThirdEntity object) {
        boolean bl2;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((BindThirdEntity)object).nickname)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public /* synthetic */ String s(Boolean bl2) {
        return this.r(bl2);
    }

    public /* synthetic */ Integer u(UserInfo userInfo) {
        return this.t(userInfo);
    }

    public void v(Context context, boolean bl2) {
        Object object = this.o;
        Boolean bl3 = Boolean.TRUE;
        ((j)object).setValue(bl3);
        object = new y$e(this, context);
        this.a.h(bl2, (a)object);
    }

    public void w(Resources resources, ThirdPlatform thirdPlatform, int n10) {
        this.y();
        c c10 = this.a;
        y$h y$h = new y$h(this, thirdPlatform, resources);
        c10.L(n10, y$h);
    }

    public void x(Context context, PrivateGetCodeStatus privateGetCodeStatus, String string2, String string3, String string4, String string5, String string6) {
        Object object = this.u;
        Object object2 = Boolean.TRUE;
        ((j)object).setValue(object2);
        object2 = context;
        Object object3 = privateGetCodeStatus;
        object = new y$a(this, privateGetCodeStatus, context);
        object2 = y$i.a;
        int n10 = privateGetCodeStatus.ordinal();
        Object object4 = object2[n10];
        n10 = 1;
        if (object4 != n10) {
            n10 = 2;
            if (object4 != n10) {
                object3 = this.a;
                boolean bl2 = true;
                object3.K(string2, string3, string4, string5, string6, bl2, (a)object);
            } else {
                object3 = this.a;
                boolean bl3 = false;
                object3.K(string2, string3, string4, string5, string6, false, (a)object);
            }
        } else {
            object3 = this.a;
            object3.u(string2, string3, string4, string5, string6, (a)object);
        }
    }
}

