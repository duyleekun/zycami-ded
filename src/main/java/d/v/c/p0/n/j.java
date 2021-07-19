/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.p0.n;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.data.database.model.Appeal;
import com.zhiyun.cama.data.database.model.Approval;
import com.zhiyun.cama.data.me.remote.CommunityManager;
import com.zhiyun.net.Punish;
import d.v.a.f.b.a;
import d.v.c.p0.m;
import d.v.c.p0.n.c;
import d.v.c.v0.u.b0.b;
import d.v.c.v0.u.b0.d;
import d.v.c.v0.u.v;
import d.v.c.v0.u.x;
import d.v.e.l.c1;
import d.v.f.i.g;
import java.util.Arrays;

public class j
extends ViewModel {
    private final x a;
    private final MutableLiveData b;
    private final MutableLiveData c;
    private final MutableLiveData d;
    private final MutableLiveData e;
    private final MutableLiveData f;
    private final MutableLiveData g;
    private final MutableLiveData h;
    private final MutableLiveData i;
    private final MutableLiveData j;
    private final MutableLiveData k;
    private final MutableLiveData l;

    public j() {
        Object object = new MutableLiveData();
        this.b = object;
        object = new MutableLiveData();
        this.c = object;
        object = new MutableLiveData();
        this.d = object;
        object = new MutableLiveData();
        this.e = object;
        object = new MutableLiveData();
        this.f = object;
        object = new MutableLiveData();
        this.g = object;
        object = new MutableLiveData();
        this.h = object;
        object = new MutableLiveData();
        this.i = object;
        object = new MutableLiveData();
        this.j = object;
        object = new MutableLiveData();
        this.k = object;
        object = new MutableLiveData();
        this.l = object;
        object = c1.b();
        CommunityManager communityManager = CommunityManager.getInstance();
        b b10 = d.v.c.v0.u.b0.b.g();
        d d10 = d.v.c.v0.u.b0.d.a();
        this.a = object = v.M((c1)object, communityManager, b10, d10);
    }

    private /* synthetic */ void o(View object) {
        object = this.b;
        Boolean bl2 = Boolean.TRUE;
        ((MutableLiveData)object).setValue(bl2);
    }

    public MutableLiveData b() {
        return this.l;
    }

    public MutableLiveData c() {
        return this.j;
    }

    public void d(String string2, a a10) {
        this.a.d(string2, a10);
    }

    public MutableLiveData e() {
        return this.c;
    }

    public MutableLiveData f() {
        return this.d;
    }

    public MutableLiveData g() {
        return this.e;
    }

    public MutableLiveData i() {
        return this.i;
    }

    public MutableLiveData j() {
        return this.f;
    }

    public MutableLiveData k() {
        return this.g;
    }

    public MutableLiveData l() {
        return this.k;
    }

    public MutableLiveData m() {
        return this.h;
    }

    public MutableLiveData n() {
        return this.b;
    }

    public /* synthetic */ void p(View view) {
        this.o(view);
    }

    public void r(Context object, String object2, Approval object3, Punish punish, Appeal appeal) {
        Boolean bl2 = Boolean.TRUE;
        if (object3 == null) {
            object3 = new Approval();
        }
        if (appeal == null) {
            appeal = new Appeal();
        }
        Object object4 = new c(this);
        object2 = m.f((Context)object, (String)object2, (Approval)object3, punish, (View.OnClickListener)object4);
        object3 = this.c;
        punish = object2.get(0);
        ((MutableLiveData)object3).setValue(punish);
        object3 = this.d;
        int n10 = 1;
        object2 = object2.get(n10);
        ((MutableLiveData)object3).setValue(object2);
        int n11 = appeal.getStatus();
        object3 = this.h;
        object4 = Boolean.FALSE;
        ((MutableLiveData)object3).setValue(object4);
        if (n11 == 0) {
            object = this.e;
            object2 = 2131231282;
            ((MutableLiveData)object).setValue(object2);
            object = this.f;
            n11 = 2131951642;
            object2 = n11;
            ((MutableLiveData)object).setValue(object2);
            object = this.g;
            ((MutableLiveData)object).setValue(object4);
        } else if (n11 == n10) {
            this.h.setValue(bl2);
            object2 = this.e;
            object3 = 2131231279;
            ((MutableLiveData)object2).setValue(object3);
            object2 = this.f;
            object3 = 2131951653;
            ((MutableLiveData)object2).setValue(object3);
            this.g.setValue(bl2);
            object2 = this.i;
            int n12 = 2131951759;
            object = d.v.f.i.g.m((Context)object, n12);
            ((MutableLiveData)object2).setValue(object);
        } else {
            int n13 = 2;
            if (n11 == n13) {
                this.h.setValue(bl2);
                object = this.e;
                object2 = 2131231281;
                ((MutableLiveData)object).setValue(object2);
                object = this.f;
                n11 = 2131951646;
                object2 = n11;
                ((MutableLiveData)object).setValue(object2);
                this.g.setValue(bl2);
                object = this.i;
                object2 = appeal.getRefuse_reason();
                ((MutableLiveData)object).setValue(object2);
            }
        }
        object = this.j;
        object2 = appeal.getAppeal_reason();
        ((MutableLiveData)object).setValue(object2);
        object = appeal.getSourceUrls();
        n11 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n11 == 0) {
            this.k.setValue(bl2);
            object = ((String)object).split(",");
            object2 = this.l;
            object = Arrays.asList(object);
            ((MutableLiveData)object2).setValue(object);
        } else {
            object = this.k;
            ((MutableLiveData)object).setValue(object4);
        }
    }
}

