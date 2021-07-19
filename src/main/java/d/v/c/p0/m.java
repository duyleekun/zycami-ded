/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.SpannableString
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.p0;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.data.database.model.Approval;
import com.zhiyun.cama.data.me.remote.CommunityManager;
import com.zhiyun.net.Punish;
import d.v.a.f.b.a;
import d.v.c.p0.g;
import d.v.c.p0.h;
import d.v.c.p0.i;
import d.v.c.v0.u.b0.b;
import d.v.c.v0.u.b0.d;
import d.v.c.v0.u.v;
import d.v.c.v0.u.x;
import d.v.e.l.c1;
import d.v.e.l.m1;
import d.v.e.l.o1;
import d.v.e.l.t1;
import java.util.ArrayList;
import java.util.List;

public class m
extends ViewModel {
    private x a;
    private MutableLiveData b;
    private MutableLiveData c;
    private final MutableLiveData d;
    private final MutableLiveData e;
    private final MutableLiveData f;
    private final MutableLiveData g;

    public m() {
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
        object = c1.b();
        CommunityManager communityManager = CommunityManager.getInstance();
        b b10 = d.v.c.v0.u.b0.b.g();
        d d10 = d.v.c.v0.u.b0.d.a();
        this.a = object = v.M((c1)object, communityManager, b10, d10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static List f(Context var0, String var1_1, Approval var2_2, Punish var3_3, View.OnClickListener var4_4) {
        block21: {
            var5_5 = var0;
            var6_6 = var1_1;
            var7_7 = var4_4;
            var9_9 = 2;
            var8_8 = new ArrayList<Object>(var9_9);
            var10_10 = "punish_notice";
            var11_11 = var10_10.equals(var1_1);
            var12_12 = "";
            if (var11_11 != 0 && var3_3 == null && var2_2 == null) {
                var5_5 = new SpannableString((CharSequence)var12_12);
                var8_8.add(var5_5);
                var5_5 = new SpannableString((CharSequence)var12_12);
                var8_8.add(var5_5);
                return var8_8;
            }
            var1_1.hashCode();
            var11_11 = -1;
            var13_13 = var1_1.hashCode();
            var14_14 = 1;
            var15_15 /* !! */  = null;
            switch (var13_13) lbl-1000:
            // 4 sources

            {
                default: {
                    var9_9 = var11_11;
                    break;
                }
                case 1890717688: {
                    var16_16 = "person_production_approval_notice";
                    var13_13 = (int)var6_6.equals(var16_16);
                    if (var13_13 != 0) break;
                    ** GOTO lbl-1000
                }
                case 999771522: {
                    var9_9 = (int)var6_6.equals(var10_10);
                    if (var9_9 == 0) ** GOTO lbl-1000
                    var9_9 = var14_14;
                    break;
                }
                case 413606253: {
                    var17_17 = "person_info_approval_notice";
                    var9_9 = (int)var6_6.equals(var17_17);
                    if (var9_9 == 0) ** GOTO lbl-1000
                    var9_9 = 0;
                    var17_17 = null;
                }
            }
            switch (var9_9) {
                default: {
                    ** GOTO lbl61
                }
                case 2: {
                    var9_9 = 2131951682;
                    var17_17 = d.v.f.i.g.m(var5_5, var9_9);
                    var11_11 = 2131951683;
                    var16_16 = new Object[var14_14];
                    var18_18 = var2_2.getCreateAt();
                    var18_18 = m1.H(var5_5, (String)var18_18);
                    var16_16[0] = var18_18;
                    var19_19 = d.v.f.i.g.n(var5_5, var11_11, (Object[])var16_16);
lbl55:
                    // 2 sources

                    while (true) {
                        var15_15 /* !! */  = var12_12;
                        var12_12 = var19_19;
                        break block21;
                        break;
                    }
                }
                case 1: {
                    if (var3_3 != null) ** GOTO lbl64
lbl61:
                    // 2 sources

                    var17_17 = var12_12;
                    var15_15 /* !! */  = var12_12;
                    break block21;
lbl64:
                    // 1 sources

                    var9_9 = 2131951718;
                    var17_17 = d.v.f.i.g.m(var5_5, var9_9);
                    var16_16 = "1";
                    var19_20 = var3_3.getPunish();
                    var11_11 = (int)var16_16.equals(var19_20);
                    if (var11_11 != 0) {
                        var19_20 = var3_3.getForever();
                        var11_11 = (int)var16_16.equals(var19_20);
                        if (var11_11 != 0) {
                            var12_12 = d.v.f.i.g.m(var5_5, 2131951678);
                            var11_11 = 2131952951;
                            var19_20 = d.v.f.i.g.m(var5_5, var11_11);
                        } else {
                            var12_12 = new Object[var14_14];
                            var16_16 = var3_3.getPunish_endtime();
                            var12_12[0] = var16_16 = m1.H(var5_5, (String)var16_16);
                            var12_12 = d.v.f.i.g.n(var5_5, 2131951679, (Object[])var12_12);
                            var11_11 = 2131952952;
                            var19_20 = d.v.f.i.g.m(var5_5, var11_11);
                        }
lbl83:
                        // 4 sources

                        while (true) {
                            var15_15 /* !! */  = var19_20;
                            break block21;
                            break;
                        }
                    }
                    var20_21 = "2";
                    var19_20 = var3_3.getPunish();
                    var11_11 = (int)var20_21.equals(var19_20);
                    if (var11_11 == 0) ** GOTO lbl104
                    var19_20 = var3_3.getForever();
                    var11_11 = (int)var16_16.equals(var19_20);
                    if (var11_11 == 0) ** GOTO lbl97
                    var12_12 = d.v.f.i.g.m(var5_5, 2131951656);
                    var11_11 = 2131951762;
                    var19_20 = d.v.f.i.g.m(var5_5, var11_11);
                    ** GOTO lbl83
lbl97:
                    // 1 sources

                    var12_12 = new Object[var14_14];
                    var16_16 = var3_3.getPunish_endtime();
                    var12_12[0] = var16_16 = m1.H(var5_5, (String)var16_16);
                    var12_12 = d.v.f.i.g.n(var5_5, 2131951657, (Object[])var12_12);
                    var11_11 = 2131951763;
                    var19_20 = d.v.f.i.g.m(var5_5, var11_11);
                    ** continue;
lbl104:
                    // 1 sources

                    var15_15 /* !! */  = var12_12;
                    break block21;
                }
                case 0: 
            }
            var9_9 = 2131951671;
            var17_17 = d.v.f.i.g.m(var5_5, var9_9);
            var11_11 = 2131951672;
            var16_16 = new Object[var14_14];
            var18_18 = var2_2.getCreateAt();
            var18_18 = m1.H(var5_5, (String)var18_18);
            var16_16[0] = var18_18;
            var19_19 = d.v.f.i.g.n(var5_5, var11_11, (Object[])var16_16);
            ** while (true)
        }
        var21_22 = var10_10.equals(var6_6);
        if (var21_22 == 0 && (var21_22 = TextUtils.isEmpty((CharSequence)(var6_6 = var2_2.getRefuse_reason()))) == 0) {
            var6_6 = new StringBuilder();
            var6_6.append((String)var12_12);
            var6_6.append("\n");
            var22_23 = 2131951663;
            var10_10 = d.v.f.i.g.m(var5_5, var22_23);
            var6_6.append(var10_10);
            var10_10 = var2_2.getRefuse_reason();
            var6_6.append(var10_10);
            var12_12 = var6_6.toString();
        }
        var18_18 = var12_12;
        var6_6 = new SpannableString((CharSequence)var17_17);
        var8_8.add(var6_6);
        var21_22 = 2131951876;
        var17_17 = d.v.f.i.g.m(var5_5, var21_22);
        var20_21 = new SpannableString((CharSequence)var12_12);
        var22_23 = (int)TextUtils.isEmpty((CharSequence)var12_12);
        if (var22_23 == 0 && (var9_9 = (int)var12_12.contains(var17_17)) != 0) {
            var23_24 = d.v.f.i.g.m(var5_5, var21_22);
            var21_22 = 2131099756;
            var24_25 = o1.a(var5_5, var21_22);
            var6_6 = new g(var7_7);
            var16_16 = var6_6 = t1.a((SpannableString)var20_21, (String)var12_12, (String)var23_24, var24_25, false, (View.OnClickListener)var6_6);
        } else {
            var16_16 = var20_21;
        }
        var21_22 = (int)TextUtils.isEmpty((CharSequence)var15_15 /* !! */ );
        if (var21_22 == 0) {
            var21_22 = 2131099814;
            var25_26 = o1.a(var5_5, var21_22);
            var23_24 = new i(var7_7);
            var16_16 = t1.a((SpannableString)var16_16, (String)var18_18, (String)var15_15 /* !! */ , var25_26, false, (View.OnClickListener)var23_24);
        }
        var8_8.add(var16_16);
        return var8_8;
    }

    private /* synthetic */ void m(View object) {
        object = this.g;
        Boolean bl2 = Boolean.TRUE;
        ((MutableLiveData)object).setValue(bl2);
    }

    public static /* synthetic */ void o(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static /* synthetic */ void p(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void b(String string2, Approval approval, Punish punish, String string3, List list, a a10) {
        this.a.E(string2, approval, punish, string3, list, a10);
    }

    public void c(Context object, String object2, Approval approval, Punish punish) {
        if (approval == null) {
            approval = new Approval();
        }
        if (punish == null) {
            punish = new Punish();
        }
        h h10 = new h(this);
        object = m.f(object, (String)object2, approval, punish, h10);
        object2 = this.b;
        approval = object.get(0);
        ((MutableLiveData)object2).setValue(approval);
        object2 = this.c;
        object = object.get(1);
        ((MutableLiveData)object2).setValue(object);
    }

    public void d(String string2) {
        Boolean bl2 = Boolean.TRUE;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (bl3) {
            this.d.setValue(bl2);
            return;
        }
        this.e.setValue(bl2);
        this.f.setValue(bl2);
    }

    public MutableLiveData e() {
        return this.b;
    }

    public MutableLiveData g() {
        return this.c;
    }

    public MutableLiveData i() {
        return this.d;
    }

    public MutableLiveData j() {
        return this.e;
    }

    public MutableLiveData k() {
        return this.f;
    }

    public MutableLiveData l() {
        return this.g;
    }

    public /* synthetic */ void n(View view) {
        this.m(view);
    }
}

