/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.CheckedTextView
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 */
package d.v.c.s0.d7;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.account.me.account.AccountActivity;
import com.zhiyun.cama.camera.CameraFragment$j;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.data.me.remote.KWaiManager;
import com.zhiyun.cama.data.me.remote.KWaiManager$OnKWaiLoginCallback;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import com.zhiyun.common.viewmodel.DeviceViewModel$NetWorkEvent;
import com.zhiyun.live.CropPhotoActivity;
import com.zhiyun.live.data.LivePlatform;
import com.zhiyun.live.data.api.entity.ReStreamChannel;
import d.v.c.s0.d7.a;
import d.v.c.s0.d7.a0;
import d.v.c.s0.d7.b;
import d.v.c.s0.d7.c;
import d.v.c.s0.d7.d;
import d.v.c.s0.d7.e;
import d.v.c.s0.d7.f;
import d.v.c.s0.d7.g;
import d.v.c.s0.d7.h;
import d.v.c.s0.d7.i;
import d.v.c.s0.d7.j;
import d.v.c.s0.d7.k;
import d.v.c.s0.d7.l;
import d.v.c.s0.d7.m;
import d.v.c.s0.d7.n;
import d.v.c.s0.d7.o;
import d.v.c.s0.d7.u$a;
import d.v.c.s0.d7.u$b;
import d.v.c.s0.d7.u$c;
import d.v.c.s0.d7.v;
import d.v.c.s0.d7.v$d;
import d.v.c.s0.d7.w;
import d.v.c.s0.d7.x;
import d.v.c.s0.d7.y;
import d.v.c.s0.d7.z;
import d.v.c.s0.q6;
import d.v.c.w0.si;
import d.v.c.w0.x0;
import d.v.e.l.b2;
import d.v.e.l.h2;
import d.v.e.l.k2;
import d.v.e.l.n2;
import d.v.e.l.o1;
import d.v.n.l.d$f;
import e.a.i0;
import e.a.p0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class u {
    public static final String j = "https://restream.io/";
    private final Fragment a;
    private final Context b;
    private final Resources c;
    private final LifecycleOwner d;
    private final z e;
    private final DeviceViewModel f;
    private y g;
    private x h;
    private int i;

    public u(Fragment fragment, LifecycleOwner lifecycleOwner, z z10, DeviceViewModel deviceViewModel) {
        this.a = fragment;
        fragment = fragment.requireContext();
        this.b = fragment;
        fragment = fragment.getResources();
        this.c = fragment;
        this.d = lifecycleOwner;
        this.e = z10;
        this.f = deviceViewModel;
    }

    private /* synthetic */ void B(Boolean object) {
        Object object2;
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = d.v.f.i.g.o(this.c, 2131952399);
            object2 = this.e;
            int n10 = ((z)object2).k;
            n2.f((String)object, n10);
            this.e.a.pop();
            object = this.e;
            n10 = 3;
            ((z)object).y0(n10);
        }
        object = this.e.L();
        object2 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(object2);
    }

    public static /* synthetic */ void D(si si2, Boolean bl2) {
        int n10 = bl2.booleanValue();
        if (n10 == 0) {
            n10 = 2131232148;
            si2.g.n.setBackgroundResource(n10);
            RelativeLayout relativeLayout = si2.g.k;
            relativeLayout.setBackgroundResource(n10);
            si2 = si2.g.l;
            si2.setBackgroundResource(n10);
        }
    }

    public static /* synthetic */ void E(si si2, Boolean bl2) {
        int n10 = bl2.booleanValue();
        if (n10 == 0) {
            n10 = 2131232148;
            si2 = si2.g.m;
            si2.setBackgroundResource(n10);
        }
    }

    private /* synthetic */ void F(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (!bl2) {
            object = this.e.U();
            Boolean bl3 = Boolean.FALSE;
            ((MutableLiveData)object).setValue(bl3);
        }
    }

    private /* synthetic */ void H(si object, Boolean object2) {
        boolean n10 = (Boolean)object2;
        if (n10) {
            int n11;
            this.i = n11 = 3;
            object2 = ((si)object).j;
            object2.setVisibility(0);
            this.f0((si)object);
        } else {
            object = ((si)object).j;
            int n12 = 8;
            object.setVisibility(n12);
        }
    }

    private /* synthetic */ void J(Integer object) {
        Object object2 = Boolean.TRUE;
        Boolean bl2 = Boolean.FALSE;
        int n10 = (Integer)object;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 == n11) {
                        object = this.e;
                        n11 = 0;
                        ((z)object).y0(0);
                        this.e.L().setValue(bl2);
                        object = this.e.H();
                        ((MutableLiveData)object).setValue(object2);
                    }
                } else {
                    object = this.e.L();
                    ((MutableLiveData)object).setValue(object2);
                }
            } else {
                this.e.L().setValue(bl2);
                object = this.e.H();
                ((MutableLiveData)object).setValue(bl2);
            }
        } else {
            this.e.L().setValue(bl2);
            this.e.H().setValue(bl2);
            object = this.e.p;
            object2 = this.W();
            ((MutableLiveData)object).setValue(object2);
        }
    }

    public static /* synthetic */ void L(x0 x02, Pair object) {
        boolean bl2 = b2.o();
        if (!bl2) {
            Boolean bl3 = (Boolean)((Pair)object).second;
            bl2 = d.v.e.h.a.c(bl3);
            object = (Integer)((Pair)object).first;
            int n10 = d.v.e.h.d.c((Integer)object);
            n10 = q6.d(bl2, n10);
            x02 = x02.t;
            x02.setImageResource(n10);
        }
    }

    private /* synthetic */ void M(String string2) {
        int n10;
        z z10 = this.e;
        String string3 = this.e.z();
        boolean bl2 = z10.m0(string3);
        if (bl2 && (n10 = string3.equals(string2)) == 0) {
            n10 = 2;
            this.X(n10);
        }
    }

    private /* synthetic */ void O(si si2) {
        this.f0(si2);
    }

    private boolean T(String string2, String string3) {
        Object object = this.e;
        boolean bl2 = ((z)object).m0(string2);
        if (!bl2) {
            string2 = d.v.f.i.g.m(this.b, 2131952406);
            int n10 = this.e.l;
            n2.f(string2, n10);
            return false;
        }
        bl2 = TextUtils.isEmpty((CharSequence)string3);
        int n11 = 1;
        if (!bl2) {
            object = "/";
            int n12 = string2.endsWith((String)object);
            if (n12 != 0) {
                n12 = string2.length() - n11;
                string2 = string2.substring(0, n12);
            }
            if ((n12 = string3.startsWith((String)object)) != 0) {
                string3 = string3.substring(n11);
            }
            n12 = 3;
            Object[] objectArray = new Object[n12];
            objectArray[0] = string2;
            objectArray[n11] = object;
            int n13 = 2;
            objectArray[n13] = string3;
            string2 = String.format("%s%s%s", objectArray);
        }
        this.e.x0(string2);
        return n11 != 0;
    }

    private boolean U(String string2, String string3) {
        LivePlatform livePlatform;
        Object object;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2 && (object = this.e.M()) != (livePlatform = LivePlatform.RESTREAM)) {
            string2 = d.v.f.i.g.o(this.c, 2131952418);
            int n10 = this.e.l;
            n2.f(string2, n10);
            return false;
        }
        object = this.e.M();
        if (object == (livePlatform = LivePlatform.KWAI) && (bl2 = TextUtils.isEmpty((CharSequence)(object = this.e.K().d())))) {
            string2 = d.v.f.i.g.o(this.c, 2131952416);
            int n11 = this.e.l;
            n2.f(string2, n11);
            return false;
        }
        this.e.K().N(string2);
        this.e.K().K(string3);
        return true;
    }

    private d.v.n.j.b W() {
        Object object;
        d.v.n.j.b b10 = this.e.K();
        Object object2 = this.c;
        int n10 = 1;
        Object object3 = new Object[n10];
        object3[0] = object = b10.k();
        object2 = d.v.f.i.g.p(object2, 2131952470, object3);
        b10.X((String)object2);
        object2 = this.c;
        object3 = new Object[n10];
        object3[0] = object = this.e.d0();
        object2 = d.v.f.i.g.p(object2, 2131952476, object3);
        b10.c0((String)object2);
        object2 = this.c;
        object3 = new Object[2];
        object3[0] = object = Float.valueOf(this.e.h0());
        object3[n10] = object = this.e.g0();
        object2 = d.v.f.i.g.p(object2, 2131952471, object3);
        b10.Y((String)object2);
        object2 = this.c;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object3 = this.e.Q();
        object2 = d.v.f.i.g.p(object2, 2131952472, objectArray);
        b10.Z((String)object2);
        return b10;
    }

    private boolean Y() {
        Object object = this.b;
        boolean bl2 = b2.m(object);
        if (!bl2) {
            object = d.v.f.i.g.o(this.c, 2131952413);
            int n10 = this.e.k;
            n2.f((String)object, n10);
            return false;
        }
        bl2 = b2.o();
        int n11 = 1;
        if (!bl2 && !(bl2 = d.v.e.h.a.c((Boolean)(object = (Boolean)this.e.S().getValue())))) {
            this.X(n11);
            return false;
        }
        return n11 != 0;
    }

    public static /* synthetic */ Fragment a(u u10) {
        return u10.a;
    }

    /*
     * WARNING - void declaration
     */
    private int c(boolean bl2) {
        void var1_4;
        int n10;
        Boolean bl3 = (Boolean)this.e.T().getValue();
        int n11 = d.v.e.h.a.c(bl3);
        int n12 = -1;
        if (n11 == 0) {
            return n12;
        }
        bl3 = this.g.b();
        n11 = bl3.getId();
        if (n11 != (n10 = 2131363128)) {
            return n12;
        }
        if (bl2) {
            int n13 = y.m;
        } else {
            int n14 = y.l;
        }
        return (int)var1_4;
    }

    private void f0(si si2) {
        Object object = (Boolean)this.e.H().getValue();
        int n10 = d.v.e.h.a.c((Boolean)object);
        if (n10 == 0) {
            return;
        }
        object = si2.j;
        Object object2 = null;
        object.setVisibility(0);
        n10 = this.i;
        if (n10 == 0) {
            si2.j.setVisibility(8);
            this.e.A0();
            return;
        }
        object2 = si2.j;
        object = String.valueOf(n10);
        object2.setText((CharSequence)object);
        this.i = n10 = this.i + -1;
        object = si2.j;
        object2 = new e(this, si2);
        object.postDelayed((Runnable)object2, 1000L);
    }

    private d.v.n.j.b j() {
        d.v.n.j.b b10 = this.e.K();
        Object object = this.c;
        int n10 = 1;
        Object object2 = new Object[n10];
        Integer n11 = b10.z();
        object2[0] = n11;
        object = d.v.f.i.g.p(object, 2131952459, object2);
        b10.T((String)object);
        object = this.c;
        object2 = new Object[n10];
        n11 = b10.b();
        object2[0] = n11;
        object = d.v.f.i.g.p(object, 2131952456, object2);
        b10.E((String)object);
        object = this.c;
        object2 = new Object[n10];
        n11 = b10.e();
        object2[0] = n11;
        object = d.v.f.i.g.p(object, 2131952454, object2);
        b10.H((String)object);
        object = this.c;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object2 = Integer.valueOf(b10.n());
        object = d.v.f.i.g.p(object, 2131952464, objectArray);
        b10.S((String)object);
        return b10;
    }

    private d.v.n.j.b k(LivePlatform object) {
        d.v.n.j.b b10 = this.j();
        Object[] objectArray = object.getPlatformName();
        b10.L((String)objectArray);
        int n10 = object.getPlatformIcon();
        b10.U(n10);
        objectArray = this.c;
        int n11 = object.getPlatformNameRes();
        object = d.v.f.i.g.o((Resources)objectArray, n11);
        b10.M((String)object);
        object = this.c;
        objectArray = new Object[1];
        String string2 = b10.k();
        objectArray[0] = string2;
        object = d.v.f.i.g.p((Resources)object, 2131952409, objectArray);
        b10.J((String)object);
        return b10;
    }

    private d.v.n.j.b l() {
        d.v.n.j.b b10 = this.e.K();
        Object object = this.c;
        int n10 = 1;
        Object object2 = new Object[n10];
        Integer n11 = b10.z();
        object2[0] = n11;
        object = d.v.f.i.g.p(object, 2131952473, object2);
        b10.a0((String)object);
        object = this.c;
        object2 = new Object[n10];
        n11 = b10.b();
        object2[0] = n11;
        object = d.v.f.i.g.p(object, 2131952468, object2);
        b10.V((String)object);
        object = this.c;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object2 = Integer.valueOf(b10.e());
        object = d.v.f.i.g.p(object, 2131952469, objectArray);
        b10.W((String)object);
        object = this.m();
        b10.b0((String)object);
        return b10;
    }

    private String m() {
        float f10 = k2.e();
        float f11 = 1.07374182E9f;
        float f12 = (float)k2.S() / f11;
        Resources resources = this.c;
        Object[] objectArray = new Object[2];
        Float f13 = Float.valueOf(f10 /= f11);
        objectArray[0] = f13;
        f13 = Float.valueOf(f12);
        objectArray[1] = f13;
        return d.v.f.i.g.p(resources, 2131952474, objectArray);
    }

    private void o(x0 object, si object2) {
        Object object3 = this.e.N();
        Object object4 = this.d;
        Observer observer = new m(this);
        ((LiveData)object3).observe((LifecycleOwner)object4, observer);
        object3 = this.e.W();
        object4 = this.d;
        observer = new a(this);
        ((LiveData)object3).observe((LifecycleOwner)object4, observer);
        object3 = this.e.A();
        object4 = this.d;
        observer = new i(this);
        ((LiveData)object3).observe((LifecycleOwner)object4, observer);
        object3 = this.e.c0();
        object4 = this.d;
        observer = new g(this);
        ((LiveData)object3).observe((LifecycleOwner)object4, observer);
        object3 = this.e.T();
        object4 = this.d;
        observer = new d((si)object2);
        ((LiveData)object3).observe((LifecycleOwner)object4, observer);
        object3 = this.e.U();
        object4 = this.d;
        observer = new k((si)object2);
        ((LiveData)object3).observe((LifecycleOwner)object4, observer);
        object3 = this.e.W();
        object4 = this.d;
        observer = new o(this);
        ((LiveData)object3).observe((LifecycleOwner)object4, observer);
        object3 = this.e.H();
        object4 = this.d;
        observer = new h(this, (si)object2);
        ((LiveData)object3).observe((LifecycleOwner)object4, observer);
        object2 = this.e.a0();
        object3 = this.d;
        object4 = new c(this);
        ((LiveData)object2).observe((LifecycleOwner)object3, (Observer)object4);
        object2 = this.f.e;
        object3 = this.d;
        object4 = new l((x0)object);
        ((LiveData)object2).observe((LifecycleOwner)object3, (Observer)object4);
        object2 = this.f.g;
        object3 = this.d;
        object4 = new b((x0)object);
        ((LiveData)object2).observe((LifecycleOwner)object3, (Observer)object4);
        object = this.e.R();
        object2 = this.d;
        object3 = new j(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)object3);
    }

    private /* synthetic */ void q(int n10) {
        if (n10 == 0) {
            Fragment fragment = this.a;
            CropPhotoActivity.h(fragment);
        } else {
            int n11 = 1;
            if (n11 == n10) {
                Fragment fragment = this.a;
                CropPhotoActivity.f(fragment);
            }
        }
    }

    private /* synthetic */ void s(ReStreamChannel[] object) {
        this.h.g((ReStreamChannel[])object);
        MutableLiveData mutableLiveData = this.e.P();
        boolean bl2 = ((ReStreamChannel[])object).length;
        if (bl2 > false) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        object = bl2;
        mutableLiveData.setValue(object);
    }

    private /* synthetic */ void u(Boolean object) {
        int n10;
        Object object2 = this.e;
        int n11 = ((z)object2).b0();
        if (n11 == (n10 = 1)) {
            Object object3 = (Boolean)object;
            if (object3 != 0) {
                long l10;
                long l11 = d.v.d.i.g.c.p();
                long l12 = l11 - (l10 = (long)100);
                object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object3 < 0) {
                    object = this.e.R();
                    object2 = Boolean.TRUE;
                    ((MutableLiveData)object).setValue(object2);
                    object = this.e.W();
                    object2 = Boolean.FALSE;
                    ((MutableLiveData)object).setValue(object2);
                }
            } else {
                object = this.e;
                ((z)object).F0();
            }
        }
    }

    public static /* synthetic */ void w(x0 x02, Integer n10) {
        x02 = x02.t;
        int n11 = n10;
        n11 = q6.d(false, n11);
        x02.setImageResource(n11);
    }

    private /* synthetic */ void x(Boolean bl2) {
        long l10;
        long l11;
        long l12;
        int n10 = bl2.booleanValue();
        if (n10 != 0 && (n10 = (l12 = (l11 = d.v.d.i.g.c.p()) - (l10 = (long)100)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) < 0) {
            n10 = 5;
            this.X(n10);
        }
    }

    private /* synthetic */ void z(Integer object) {
        Object object2;
        int n10;
        block18: {
            block16: {
                block17: {
                    int n11 = (Integer)object;
                    if (n11 == (n10 = 2)) break block16;
                    n10 = 10002;
                    if (n11 == n10) break block17;
                    n10 = 10004;
                    if (n11 == n10) break block16;
                    n10 = 20001;
                    if (n11 != n10) {
                        n10 = 374;
                        if (n11 != n10) {
                            n10 = 375;
                            if (n11 != n10) {
                                n10 = 377;
                                if (n11 != n10) {
                                    n10 = 378;
                                    if (n11 != n10) {
                                        n10 = 20004;
                                        if (n11 != n10) {
                                            n10 = 20005;
                                            if (n11 != n10) {
                                                object = "";
                                            } else {
                                                object = this.c;
                                                n10 = 2131952414;
                                                object = d.v.f.i.g.o((Resources)object, n10);
                                            }
                                        } else {
                                            object = this.c;
                                            n10 = 2131952422;
                                            object = d.v.f.i.g.o((Resources)object, n10);
                                        }
                                    } else {
                                        object = this.c;
                                        n10 = 2131952478;
                                        int n12 = 1;
                                        Object[] objectArray = new Object[n12];
                                        String string2 = this.j().k();
                                        objectArray[0] = string2;
                                        object = d.v.f.i.g.p((Resources)object, n10, objectArray);
                                    }
                                } else {
                                    object = this.c;
                                    n10 = 2131952425;
                                    object = d.v.f.i.g.o((Resources)object, n10);
                                }
                            } else {
                                object = this.c;
                                n10 = 2131952398;
                                object = d.v.f.i.g.o((Resources)object, n10);
                            }
                        } else {
                            object = this.e.M();
                            if (object == (object2 = LivePlatform.RTMP)) {
                                this.X(3);
                                return;
                            }
                            object = this.c;
                            n10 = 2131952421;
                            object = d.v.f.i.g.o((Resources)object, n10);
                        }
                    } else {
                        object = this.c;
                        n10 = 2131952396;
                        object = d.v.f.i.g.o((Resources)object, n10);
                    }
                    break block18;
                }
                object = this.c;
                n10 = 2131952419;
                object = d.v.f.i.g.o((Resources)object, n10);
                break block18;
            }
            object = this.c;
            n10 = 2131952404;
            object = d.v.f.i.g.o((Resources)object, n10);
        }
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 == 0) {
            object2 = this.e;
            n10 = object2.k;
            n2.f((String)object, n10);
        }
    }

    public /* synthetic */ void A(Integer n10) {
        this.z(n10);
    }

    public /* synthetic */ void C(Boolean bl2) {
        this.B(bl2);
    }

    public /* synthetic */ void G(Boolean bl2) {
        this.F(bl2);
    }

    public /* synthetic */ void I(si si2, Boolean bl2) {
        this.H(si2, bl2);
    }

    public /* synthetic */ void K(Integer n10) {
        this.J(n10);
    }

    public /* synthetic */ void N(String string2) {
        this.M(string2);
    }

    public /* synthetic */ void P(si si2) {
        this.O(si2);
    }

    public void Q() {
        int n10;
        int n11;
        Object object = this.e;
        int n12 = ((z)object).b0();
        if (n12 != (n11 = 1) && (n12 = ((z)(object = this.e)).b0()) != (n10 = 3)) {
            object = this.e;
            n12 = ((z)object).Y();
            if (n12 != 0) {
                if (n12 != n11) {
                    n11 = 7;
                    if (n12 == n11) {
                        object = this.e.p;
                        d.v.n.j.b b10 = this.l();
                        ((MutableLiveData)object).setValue(b10);
                    }
                } else {
                    object = d.v.f.i.g.o(this.c, 2131952401);
                    z z10 = this.e;
                    n11 = z10.k;
                    n2.f((String)object, n11);
                }
            } else {
                object = this.e;
                ((z)object).y0(n11);
            }
        } else {
            n12 = 4;
            this.X(n12);
        }
    }

    public void R(DeviceViewModel$NetWorkEvent object) {
        int n10;
        int n11;
        Object object2 = this.e;
        int n12 = object2.b0();
        if (n12 == (n11 = 1) && object == (object2 = DeviceViewModel$NetWorkEvent.NET_WORK_WIFI_DISCONNECTED) && (n10 = d.v.e.h.a.c((Boolean)(object = (Boolean)this.e.S().getValue()))) == 0 && (n10 = b2.l((Context)(object = this.b))) != 0) {
            n10 = 6;
            this.X(n10);
        }
    }

    public void S(int n10, Intent object) {
        int n11 = 10023;
        if (n11 == n10) {
            Object object2 = object.getStringExtra("action_crop_photo_uri");
            object = this.e.K();
            ((d.v.n.j.b)object).F((String)object2);
            object2 = this.e.p;
            ((MutableLiveData)object2).setValue(object);
        }
    }

    public void V() {
        int n10;
        Object object = this.e;
        int n11 = ((z)object).Y();
        if (n11 == (n10 = 6)) {
            object = this.e.L();
            Boolean bl2 = Boolean.TRUE;
            ((MutableLiveData)object).setValue(bl2);
            object = this.e;
            ((z)object).p0();
        }
    }

    public void X(int n10) {
        Bundle bundle = new Bundle();
        bundle.putInt("LIVE_DIALOG_TYPE", n10);
        n10 = this.e.k;
        bundle.putInt("LIVE_DIALOG_ROTATION", n10);
        d.v.c.x1.l.e(this.a, 2131361808, bundle);
    }

    public void Z(String object) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)object);
        if (n11 != 0) {
            return;
        }
        Object object2 = this.e;
        n11 = ((z)object2).Y();
        if (n11 != (n10 = 5)) {
            return;
        }
        object = i0.x0(object);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        object = ((i0)object).J(200L, timeUnit);
        object2 = d.v.e.k.e.f();
        object = ((i0)object).s((p0)object2);
        object2 = new n(this);
        ((i0)object).b0((e.a.v0.g)object2).a();
    }

    public void a0() {
        int n10;
        Object object = this.e;
        int n11 = ((z)object).b0();
        if (n11 == (n10 = 1)) {
            object = this.e;
            n11 = ((z)object).Y();
            if (n11 == (n10 = 7)) {
                object = this.e;
                n10 = 0;
                ((z)object).y0(0);
            } else {
                object = this.e.p;
                d.v.n.j.b b10 = this.l();
                ((MutableLiveData)object).setValue(b10);
                object = this.e;
                ((z)object).y0(n10);
            }
        }
    }

    public void b() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri uri = Uri.parse((String)j);
        intent.setData(uri);
        this.a.requireActivity().startActivity(intent);
    }

    public boolean b0() {
        boolean bl2;
        Object object = this.e;
        int bl22 = ((z)object).b0();
        boolean bl3 = true;
        if (bl22 == 0 && (bl2 = ((z)(object = this.e)).Y()) <= bl3) {
            return false;
        }
        object = d.v.f.i.g.o(this.c, 2131953166);
        int n10 = this.e.l;
        n2.f((String)object, n10);
        return bl3;
    }

    public void c0(si object, View object2, boolean n10) {
        this.g.h((View)object2);
        RecyclerView recyclerView = object.g.i;
        Context context = this.b;
        Object object3 = new LinearLayoutManager(context);
        recyclerView.setLayoutManager((RecyclerView$LayoutManager)object3);
        recyclerView = object.g.i;
        object3 = this.g;
        recyclerView.setAdapter((RecyclerView$Adapter)object3);
        float f10 = object.g.p.getScrollY();
        object3 = object.g.i;
        float f11 = object2.getY();
        float f12 = object2.getHeight();
        f11 = f11 + f12 - f10;
        object3.setY(f11);
        recyclerView = object.g.i.getLayoutParams();
        object3 = new RelativeLayout.LayoutParams((ViewGroup.LayoutParams)recyclerView);
        int n11 = object2.getId();
        int n12 = 2131232151;
        f11 = 1.8080403E38f;
        int n13 = 2131363130;
        f12 = 1.834606E38f;
        if (n11 == n13) {
            int n14;
            object2 = object.g.n;
            object2.setBackgroundResource(n12);
            ((RelativeLayout.LayoutParams)object3).height = n14 = y.l;
        } else {
            n11 = object2.getId();
            n13 = 2131363128;
            f12 = 1.8346056E38f;
            if (n11 == n13) {
                object2 = object.g.l;
                object2.setBackgroundResource(n12);
                int n15 = n10 != 0 ? y.m : y.l;
                ((RelativeLayout.LayoutParams)object3).height = n15;
            } else {
                int n16 = object2.getId();
                if (n16 == (n10 = 2131363127)) {
                    object2 = object.g.k;
                    object2.setBackgroundResource(n12);
                    ((RelativeLayout.LayoutParams)object3).height = n16 = y.k;
                }
            }
        }
        object.g.i.setLayoutParams((ViewGroup.LayoutParams)object3);
        object = this.e.T();
        object2 = Boolean.TRUE;
        ((MutableLiveData)object).setValue(object2);
        object = this.e.U();
        object2 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(object2);
    }

    public void d() {
        Object object = new ArrayList();
        int n10 = o1.a(this.b, 2131099772);
        String string2 = d.v.f.i.g.m(this.b, 2131952498);
        Object object2 = new d.v.g0.o(string2, n10);
        object.add(object2);
        string2 = d.v.f.i.g.m(this.b, 2131952497);
        object2 = new d.v.g0.o(string2, n10);
        object.add(object2);
        object = v.m().q((List)object);
        Object object3 = new f(this);
        object = ((v)object).s((v$d)object3);
        object3 = this.a.getChildFragmentManager();
        object2 = v.class.getName();
        int n11 = this.e.k;
        ((v)object).v((FragmentManager)object3, (String)object2, n11);
    }

    public void d0() {
        this.e.y0(6);
        MutableLiveData mutableLiveData = this.e.L();
        Boolean bl2 = Boolean.TRUE;
        mutableLiveData.setValue(bl2);
        this.e.p0();
    }

    public void e(LivePlatform object, String object2) {
        this.e.v0((LivePlatform)((Object)object));
        Object object3 = this.e.p;
        d.v.n.j.b b10 = this.k((LivePlatform)((Object)object));
        object3.setValue(b10);
        object3 = LivePlatform.RTMP;
        if (object == object3) {
            this.e.y0(5);
            this.Z((String)object2);
            return;
        }
        object2 = LivePlatform.RESTREAM;
        int n10 = 2;
        if (object == object2) {
            object = this.b;
            boolean bl2 = d.v.c.m1.b.b((Context)object);
            if (bl2) {
                object = this.e;
                ((z)object).y0(n10);
            }
            return;
        }
        object = d.v.a.f.c.b.N();
        boolean bl3 = ((d.v.a.f.c.b)object).s();
        if (!bl3) {
            AccountActivity.k(this.a.requireActivity());
            return;
        }
        this.e.y0(n10);
    }

    public void e0(si object) {
        boolean bl2;
        LivePlatform livePlatform;
        Object object2 = this.e.M();
        if (object2 == (livePlatform = LivePlatform.RTMP)) {
            object2 = object.c.b.getText().toString();
            object = object.c.a.getText().toString();
            bl2 = this.T((String)object2, (String)object);
        } else {
            object2 = object.d.b.getText().toString();
            object = object.d.a.getText().toString();
            bl2 = this.U((String)object2, (String)object);
        }
        if (!bl2) {
            return;
        }
        bl2 = this.Y();
        if (bl2) {
            object = this.e;
            ((z)object).u();
        }
    }

    public void f() {
        this.e.w();
        this.e.y0(1);
    }

    public void g() {
        Object object = a0.e();
        Object object2 = this.e.M().getPlatformName();
        ((a0)object).b((String)object2);
        this.e.z0();
        object = this.e.M();
        object2 = LivePlatform.RESTREAM;
        if (object == object2) {
            object = this.h;
            ((x)object).clear();
        }
    }

    public void g0(CameraSet$Mode object) {
        CameraSet$Mode cameraSet$Mode = CameraSet$Mode.live;
        if (cameraSet$Mode == object) {
            object = this.e;
            int n10 = 1;
            ((z)object).y0(n10);
        } else {
            object = this.e;
            ((z)object).w();
        }
    }

    public void h(x0 object, View view, int n10, int n11) {
        int n12;
        int n13;
        si si2 = (si)object.k0.getBinding();
        if (si2 == null) {
            return;
        }
        int n14 = view.getId();
        Object object2 = si2.d.getRoot();
        int n15 = object2.getId();
        boolean bl2 = true;
        int n16 = -1;
        if (n14 == n15 || (n14 = view.getId()) == (n15 = (object2 = si2.g.getRoot()).getId()) || (n14 = view.getId()) == (n15 = (object2 = si2.f.getRoot()).getId())) {
            float f10;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            n15 = 2;
            if (n10 == 0) {
                CheckedTextView checkedTextView = object.b;
                float f11 = checkedTextView.getX();
                int n17 = (int)f11;
                float f12 = 180.0f;
                int n18 = h2.b(f12);
                layoutParams.height = n17 -= n18;
                object = object.d;
                n13 = object.getHeight();
                n17 -= n13;
                n13 = -n17 / n15;
            } else {
                layoutParams.height = n16;
                n13 = 0;
                object = null;
                f10 = 0.0f;
            }
            view.setLayoutParams(layoutParams);
            float f13 = view.getTranslationY();
            object2 = new float[n15];
            object2[0] = (View)f13;
            f10 = n13;
            object2[bl2] = (View)f10;
            object = ObjectAnimator.ofFloat((Object)view, (String)"translationY", (float[])object2);
            long l10 = 0L;
            object = object.setDuration(l10);
            object.start();
        }
        if ((n13 = view.getId()) == (n12 = (view = si2.g.getRoot()).getId())) {
            if (n10 != 0) {
                bl2 = false;
            }
            n13 = this.c(bl2);
            if (n13 == n16) {
                return;
            }
            view = si2.g.i.getLayoutParams();
            view.height = n13;
            object = si2.g.i;
            object.setLayoutParams((ViewGroup.LayoutParams)view);
        }
    }

    public void i() {
        Object object = this.b;
        boolean bl2 = b2.m(object);
        if (!bl2) {
            object = d.v.f.i.g.m(this.b, 2131952413);
            int n10 = this.e.l;
            n2.f((String)object, n10);
            return;
        }
        object = this.e.L();
        Object object2 = Boolean.TRUE;
        object.setValue(object2);
        object = d.v.n.l.d.i();
        Object object3 = this.e.J();
        object.w((d$f)object3);
        object = this.e.n0();
        bl2 = object.booleanValue();
        if (bl2) {
            object = this.e.M();
            if (object == (object3 = LivePlatform.RESTREAM)) {
                object = d.v.n.l.d.i();
                object2 = this.e.M();
                object3 = this.e.y().openid;
                object.t((LivePlatform)((Object)object2), (String)object3);
                return;
            }
            this.e.c0().setValue(object2);
            return;
        }
        object = this.e.M();
        if (object == (object2 = LivePlatform.KWAI)) {
            object = KWaiManager.getInstance();
            object2 = this.a.requireActivity();
            object3 = new u$c(this);
            object.getKwaiAccessToken((Activity)object2, (KWaiManager$OnKWaiLoginCallback)object3);
            return;
        }
        object = this.e.M();
        if (object == (object2 = LivePlatform.RESTREAM)) {
            object = d.v.n.l.d.i();
            object2 = this.a.requireActivity();
            object3 = this.e.M().getPlatformName();
            object.u((Activity)object2, (String)object3);
            return;
        }
        this.e.x(false);
    }

    public void n() {
        Object object = this.e.T();
        Boolean bl2 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(bl2);
        this.e.U().setValue(bl2);
        bl2 = this.b;
        z z10 = this.e;
        this.g = object = new y((Context)bl2, z10);
        this.e.y0(4);
    }

    public void p(x0 x02, CameraFragment$j object) {
        si si2 = (si)x02.k0.getBinding();
        Object object2 = this.b;
        Object object3 = new LinearLayoutManager((Context)object2);
        si2.b.a.setLayoutManager((RecyclerView$LayoutManager)object3);
        object2 = si2.b.a;
        w w10 = new w((CameraFragment$j)object);
        ((RecyclerView)object2).setAdapter(w10);
        object2 = this.b;
        int n10 = ((LinearLayoutManager)object3).getOrientation();
        object = new DividerItemDecoration((Context)object2, n10);
        object3 = o1.m(this.b, 2131232159);
        ((DividerItemDecoration)object).setDrawable((Drawable)object3);
        si2.b.a.addItemDecoration((RecyclerView$ItemDecoration)object);
        object3 = this.e;
        this.h = object = new x((z)object3);
        object = si2.f.c;
        object2 = this.b;
        object3 = new LinearLayoutManager((Context)object2);
        ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)object3);
        object = si2.f.c;
        object3 = this.h;
        ((RecyclerView)object).setAdapter((RecyclerView$Adapter)object3);
        object = si2.h.b;
        object2 = this.b;
        object3 = new LinearLayoutManager((Context)object2);
        ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)object3);
        object = si2.h.b;
        object3 = this.h;
        ((RecyclerView)object).setAdapter((RecyclerView$Adapter)object3);
        object = si2.g.j;
        object2 = this.b;
        object3 = new LinearLayoutManager((Context)object2);
        ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)object3);
        object = si2.g.j;
        object3 = this.g;
        ((RecyclerView)object).setAdapter((RecyclerView$Adapter)object3);
        object = si2.d.b;
        object3 = new u$a(this, si2);
        object.addTextChangedListener((TextWatcher)object3);
        object = si2.d.a;
        object3 = new u$b(this, si2);
        object.addTextChangedListener((TextWatcher)object3);
        this.o(x02, si2);
    }

    public /* synthetic */ void r(int n10) {
        this.q(n10);
    }

    public /* synthetic */ void t(ReStreamChannel[] reStreamChannelArray) {
        this.s(reStreamChannelArray);
    }

    public /* synthetic */ void v(Boolean bl2) {
        this.u(bl2);
    }

    public /* synthetic */ void y(Boolean bl2) {
        this.x(bl2);
    }
}

