/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.view.View
 */
package d.v.a.i.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.zhiyun.account.R$string;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.data.me.remote.AccountManager$AuthData;
import com.zhiyun.account.me.account.getcode.GetCodeStatus;
import d.v.a.f.b.a;
import d.v.a.f.c.b;
import d.v.a.f.c.c;
import d.v.a.i.a.m0$a;
import d.v.a.i.a.m0$b;
import d.v.a.i.a.m0$c;
import d.v.a.i.a.m0$d;
import d.v.a.i.a.m0$e;
import d.v.a.i.a.m0$f;
import d.v.a.i.a.m0$g;
import d.v.a.i.a.m0$h;
import d.v.a.i.a.m0$i;
import d.v.a.i.a.m0$j;
import d.v.a.i.a.m0$k;
import d.v.e.i.j;
import d.v.f.i.g;

public class m0
extends ViewModel {
    public final j A;
    public final j B;
    public final j C;
    public final j D;
    public final j E;
    private String F;
    private String G;
    private String H;
    private String I;
    private c a;
    public final MutableLiveData b;
    public final MutableLiveData c;
    public final MutableLiveData d;
    public final MutableLiveData e;
    public final MutableLiveData f;
    public final MutableLiveData g;
    public final MutableLiveData h;
    public final MutableLiveData i;
    public final MutableLiveData j;
    public final MutableLiveData k;
    public final MutableLiveData l;
    public final MutableLiveData m;
    public final MutableLiveData n;
    public final MutableLiveData o;
    public final MutableLiveData p;
    public final MutableLiveData q;
    public final MutableLiveData r;
    public final MutableLiveData s;
    public final LiveData t;
    private boolean u;
    public final j v;
    public final j w;
    public final j x;
    public final j y;
    public final j z;

    public m0() {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        MutableLiveData mutableLiveData4;
        Object object;
        this.b = object = new MutableLiveData();
        this.c = object = new MutableLiveData();
        this.d = mutableLiveData4 = new MutableLiveData();
        this.e = mutableLiveData4 = new MutableLiveData();
        this.f = mutableLiveData4 = new MutableLiveData();
        Boolean bl2 = Boolean.FALSE;
        this.g = mutableLiveData4 = new MutableLiveData(bl2);
        this.h = mutableLiveData4 = new MutableLiveData();
        this.i = mutableLiveData4 = new MutableLiveData();
        this.j = mutableLiveData3 = new MutableLiveData();
        this.k = mutableLiveData2 = new MutableLiveData();
        this.l = mutableLiveData = new MutableLiveData();
        Object object2 = new MutableLiveData();
        this.m = object2;
        object2 = new MutableLiveData();
        this.n = object2;
        object2 = new MutableLiveData();
        this.o = object2;
        object2 = new MutableLiveData();
        this.p = object2;
        object2 = new MutableLiveData();
        this.q = object2;
        object2 = new MutableLiveData();
        this.r = object2;
        object2 = new MutableLiveData();
        this.s = object2;
        this.v = object2;
        super();
        this.w = object2;
        super();
        this.x = object2;
        super();
        this.y = object2;
        super();
        this.z = object2;
        super();
        this.A = object2;
        super();
        this.B = object2;
        super();
        this.C = object2;
        super();
        this.D = object2;
        super();
        this.E = object2;
        this.a = object2 = d.v.a.f.c.b.N();
        object.setValue(bl2);
        mutableLiveData4.setValue(bl2);
        mutableLiveData3.setValue(bl2);
        object = GetCodeStatus.REGISTER;
        mutableLiveData.setValue(object);
        mutableLiveData2.setValue("86");
        super(this);
        object = Transformations.map(mutableLiveData, (Function)object);
        this.t = object;
    }

    private void F(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            j j10 = this.A;
            j10.setValue(string2);
        }
    }

    private void G(Context object, GetCodeStatus getCodeStatus, String string2, int n10, String string3) {
        int n11 = 202;
        if (n11 == n10) {
            GetCodeStatus getCodeStatus2 = GetCodeStatus.REGISTER;
            if (getCodeStatus2 == getCodeStatus) {
                object = this.y;
                ((j)object).setValue(string3);
            } else {
                int n12 = TextUtils.isEmpty((CharSequence)string2);
                if (n12 != 0) {
                    n12 = R$string.me_email_bound;
                    object = d.v.f.i.g.m((Context)object, n12);
                    this.w((String)object);
                } else {
                    n12 = R$string.me_phone_bound;
                    object = d.v.f.i.g.m((Context)object, n12);
                    this.w((String)object);
                }
            }
        } else {
            n11 = 211;
            if (n11 == n10) {
                GetCodeStatus getCodeStatus3 = GetCodeStatus.FORGET_PASS;
                if (getCodeStatus3 == getCodeStatus) {
                    int n13 = TextUtils.isEmpty((CharSequence)string2);
                    if (n13 != 0) {
                        n13 = R$string.me_email_not_register;
                        object = d.v.f.i.g.m((Context)object, n13);
                        this.w((String)object);
                    } else {
                        n13 = R$string.me_phone_not_register;
                        object = d.v.f.i.g.m((Context)object, n13);
                        this.w((String)object);
                    }
                } else {
                    this.w(string3);
                }
            } else {
                this.w(string3);
            }
        }
    }

    public static /* synthetic */ void b(m0 m02, String string2) {
        m02.F(string2);
    }

    public static /* synthetic */ void c(m0 m02, String string2) {
        m02.w(string2);
    }

    public static /* synthetic */ void d(m0 m02, Context context, GetCodeStatus getCodeStatus, String string2, int n10, String string3) {
        m02.G(context, getCodeStatus, string2, n10, string3);
    }

    public static /* synthetic */ String e(m0 m02, String string2) {
        m02.H = string2;
        return string2;
    }

    public static /* synthetic */ void f(m0 m02, View view, GetCodeStatus getCodeStatus) {
        m02.p(view, getCodeStatus);
    }

    public static /* synthetic */ void g(m0 m02, ThirdPlatform thirdPlatform, AccountManager$AuthData accountManager$AuthData, a a10) {
        m02.i(thirdPlatform, accountManager$AuthData, a10);
    }

    private void i(ThirdPlatform thirdPlatform, AccountManager$AuthData accountManager$AuthData, a a10) {
        this.a.z(thirdPlatform, accountManager$AuthData, a10);
    }

    private /* synthetic */ Boolean n(GetCodeStatus object) {
        boolean bl2;
        GetCodeStatus getCodeStatus = GetCodeStatus.REGISTER;
        if (getCodeStatus == object && !(bl2 = (object = this.a).B())) {
            this.a.l(true);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private void p(View object, GetCodeStatus object2) {
        Object object3 = this.E;
        Object object4 = Boolean.TRUE;
        ((j)object3).setValue(object4);
        object3 = new m0$c(this, (GetCodeStatus)((Object)object2), (View)object);
        object = this.G;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.I)))) {
            object = this.a;
            object2 = this.F;
            object4 = this.G;
            String string2 = this.I;
            object.J((String)object2, (String)object4, string2, (a)object3);
        } else {
            bl2 = false;
            object = null;
            int n10 = -1;
            object4 = "";
            object3.onError(null, n10, (String)object4);
        }
    }

    private void w(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            j j10 = this.x;
            j10.setValue(string2);
        }
    }

    public void A(View object, boolean bl2, String string2) {
        this.I = string2;
        GetCodeStatus getCodeStatus = (GetCodeStatus)((Object)this.l.getValue());
        if (getCodeStatus == null) {
            return;
        }
        Object object2 = this.v;
        Boolean bl3 = Boolean.TRUE;
        ((j)object2).setValue(bl3);
        object2 = new m0$j(this, getCodeStatus, (View)object);
        object = m0$b.a;
        int n10 = getCodeStatus.ordinal();
        View view = object[n10];
        n10 = 1;
        if (view != n10) {
            n10 = 2;
            if (view != n10) {
                c c10 = this.a;
                String string3 = this.F;
                String string4 = this.G;
                String string5 = this.H;
                c10.I(string3, string4, string2, string5, bl2, (a)object2);
            } else {
                object = this.a;
                object.k(string2, (a)object2);
            }
        } else {
            c c11 = this.a;
            String string6 = this.F;
            String string7 = this.G;
            String string8 = this.H;
            c11.y(string6, string7, string2, string8, (a)object2);
        }
    }

    public void H(View view, ThirdPlatform thirdPlatform) {
        Object object = this.v;
        Object object2 = Boolean.TRUE;
        ((j)object).setValue(object2);
        object = new m0$k(this, view);
        object2 = this.a;
        m0$a m0$a = new m0$a(this, (a)object, view);
        object2.o(thirdPlatform, m0$a);
    }

    public void j() {
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
    }

    public void k(Context object, GetCodeStatus object2, String string2, String string3, String string4) {
        this.F = string2;
        this.G = string3;
        j j10 = this.v;
        Boolean bl2 = Boolean.TRUE;
        j10.setValue(bl2);
        m0$h m0$h = new m0$h(this, (GetCodeStatus)((Object)object2), (Context)object, string2);
        object = m0$b.a;
        int n10 = object2.ordinal();
        Context context = object[n10];
        n10 = 1;
        if (context != n10) {
            n10 = 2;
            if (context != n10) {
                c c10 = this.a;
                boolean bl3 = true;
                c10.E(string2, string3, string4, bl3, m0$h);
            } else {
                object = this.a;
                object2 = new m0$i(this, m0$h);
                object.t(string2, string3, string4, (a)object2);
            }
        } else {
            c c11 = this.a;
            boolean bl4 = false;
            c11.E(string2, string3, string4, false, m0$h);
        }
    }

    public LiveData l() {
        return this.a.c();
    }

    public boolean m() {
        return this.u;
    }

    public /* synthetic */ Boolean o(GetCodeStatus getCodeStatus) {
        return this.n(getCodeStatus);
    }

    public void r(View view, String string2, String string3, String string4) {
        Object object = this.v;
        Object object2 = Boolean.TRUE;
        ((j)object).setValue(object2);
        object = this.a;
        object2 = new m0$d(this, view, string2);
        object.J(string2, string3, string4, (a)object2);
    }

    public void s(View view, String string2, String string3, String string4) {
        Object object = this.v;
        Object object2 = Boolean.TRUE;
        ((j)object).setValue(object2);
        object = this.a;
        object2 = new m0$e(this, view);
        object.f(string2, string3, string4, (a)object2);
    }

    public void t(Context context, String string2, String string3, String string4, String string5, String string6) {
        j j10 = this.v;
        Boolean bl2 = Boolean.TRUE;
        j10.setValue(bl2);
        c c10 = this.a;
        j10 = context;
        m0$f m0$f = new m0$f(this, context);
        c10.K(string2, string3, string4, string5, string6, false, m0$f);
    }

    public void u(Context context, GetCodeStatus getCodeStatus, String string2, String string3, String string4, String string5, String string6) {
        Object object = this.D;
        Object object2 = Boolean.TRUE;
        ((j)object).setValue(object2);
        object2 = context;
        Object object3 = getCodeStatus;
        object = new m0$g(this, getCodeStatus, context, string2);
        object2 = m0$b.a;
        int n10 = getCodeStatus.ordinal();
        Object object4 = object2[n10];
        n10 = 1;
        if (object4 != n10) {
            object3 = this.a;
            boolean bl2 = true;
            object3.K(string2, string3, string4, string5, string6, bl2, (a)object);
        } else {
            object3 = this.a;
            object3.u(string2, string3, string4, string5, string6, (a)object);
        }
    }

    public void v(boolean bl2) {
        this.u = bl2;
    }

    /*
     * WARNING - void declaration
     */
    public void x(boolean bl2) {
        void var1_8;
        Object object = this.m;
        Object object2 = bl2;
        ((MutableLiveData)object).setValue(object2);
        object = (GetCodeStatus)((Object)this.l.getValue());
        if (object == null) {
            return;
        }
        object2 = m0$b.a;
        Object object3 = ((Enum)object).ordinal();
        Object object4 = 1;
        if ((object3 = (Object)object2[object3]) != object4) {
            object4 = 2;
            if (object3 != object4) {
                if (bl2) {
                    int n10 = R$string.me_register_by_email;
                } else {
                    int n11 = R$string.me_register_by_phone;
                }
            } else {
                object = this.n;
                object4 = bl2 ? R$string.me_bind_phone : R$string.me_bind_email;
                object2 = object4;
                ((MutableLiveData)object).setValue(object2);
                if (bl2) {
                    int n12 = R$string.me_bind_by_email;
                } else {
                    int n13 = R$string.me_bind_by_phone;
                }
            }
        } else if (bl2) {
            int n14 = R$string.me_forget_by_email;
        } else {
            int n15 = R$string.me_forget_by_phone;
        }
        object = this.p;
        Integer n16 = (int)var1_8;
        ((MutableLiveData)object).setValue(n16);
    }

    /*
     * WARNING - void declaration
     */
    public void y(GetCodeStatus object) {
        void var6_18;
        void var8_23;
        void var5_10;
        MutableLiveData mutableLiveData;
        Comparable<Boolean> comparable = Boolean.TRUE;
        Boolean bl2 = Boolean.FALSE;
        this.l.setValue(object);
        int[] nArray = m0$b.a;
        int n10 = ((Enum)object).ordinal();
        n10 = nArray[n10];
        int n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 != n12) {
                int n13 = R$string.me_register_zhiyun;
                int n14 = R$string.me_register;
                this.r.setValue(comparable);
                mutableLiveData = this.s;
                mutableLiveData.setValue(comparable);
                int n15 = n13;
            } else {
                int n16 = R$string.me_bind_phone;
                int n17 = R$string.me_set_pass;
                int n18 = R$string.me_login;
                this.r.setValue(bl2);
                MutableLiveData mutableLiveData2 = this.s;
                mutableLiveData2.setValue(comparable);
                int n19 = n17;
                int n20 = n18;
            }
        } else {
            int n21 = R$string.me_reset_pass;
            int n22 = R$string.me_set_new_pass;
            int n23 = R$string.me_confirm_reset;
            this.r.setValue(bl2);
            mutableLiveData = this.s;
            mutableLiveData.setValue(bl2);
        }
        mutableLiveData = this.n;
        object = (int)var5_10;
        mutableLiveData.setValue(object);
        object = this.o;
        comparable = (int)var8_23;
        ((MutableLiveData)object).setValue(comparable);
        object = this.q;
        comparable = (int)var6_18;
        ((MutableLiveData)object).setValue(comparable);
        this.i.setValue(bl2);
        this.j.setValue(bl2);
        object = this.m.getValue();
        if (object != null) {
            object = (Boolean)this.m.getValue();
            boolean bl4 = (Boolean)object;
            this.x(bl4);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void z(boolean bl2) {
        void var1_4;
        MutableLiveData mutableLiveData = this.d;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
        mutableLiveData = this.e;
        if (bl2) {
            int n10 = R$string.me_login_by_email;
        } else {
            int n11 = R$string.me_login_by_phone;
        }
        Integer n12 = (int)var1_4;
        mutableLiveData.setValue(n12);
    }
}

