/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.view.View
 *  android.widget.TextView
 */
package d.v.c.p0.o;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.account.SimpleWebViewActivity;
import com.zhiyun.account.data.me.remote.AccountManager;
import com.zhiyun.cama.appeal.AppealActivity;
import com.zhiyun.common.util.Times;
import com.zhiyun.net.BaseEntity;
import com.zhiyun.net.Punish;
import d.v.c.p0.o.a;
import d.v.c.p0.o.b;
import d.v.c.p0.o.c;
import d.v.c.p0.o.d;
import d.v.c.p0.o.e;
import d.v.e.l.n2;
import d.v.e.l.o1;
import d.v.e.l.t1;
import d.v.f.g.b$b;
import d.v.f.i.g;
import d.v.g0.k;
import d.v.g0.k$a;
import d.v.g0.k$b;
import java.util.function.Consumer;

public class f {
    private static k a;

    public static /* synthetic */ void a(FragmentActivity fragmentActivity, View object) {
        object = g.m((Context)fragmentActivity, 2131951876);
        String string2 = g.m((Context)fragmentActivity, 2131951874);
        SimpleWebViewActivity.h(fragmentActivity, (String)object, string2);
    }

    public static /* synthetic */ void b(FragmentActivity fragmentActivity, Punish punish, DialogFragment dialogFragment) {
        dialogFragment.dismissAllowingStateLoss();
        AppealActivity.F(fragmentActivity, "punish_notice", punish);
    }

    public static /* synthetic */ void c(String string2, FragmentActivity fragmentActivity, d.v.g0.t.e e10) {
        TextView textView = e10.h;
        LinkMovementMethod linkMovementMethod = new LinkMovementMethod();
        textView.setMovementMethod((MovementMethod)linkMovementMethod);
        e10 = e10.h;
        String string3 = g.m((Context)fragmentActivity, 2131951876);
        int n10 = o1.a((Context)fragmentActivity, 2131099756);
        d d10 = new d(fragmentActivity);
        string2 = t1.a(null, string2, string3, n10, false, d10);
        e10.setText(string2);
    }

    public static /* synthetic */ void d() {
        a = null;
    }

    public static boolean e(FragmentActivity fragmentActivity, BaseEntity object) {
        int n10;
        Object object2;
        if (object != null && (object2 = ((BaseEntity)object).punish) != null) {
            int n11 = 10185;
            int n12 = ((BaseEntity)object).errcode;
            boolean bl2 = true;
            if (n11 == n12) {
                object2 = d.v.a.f.c.b.N();
                boolean bl3 = ((d.v.a.f.c.b)object2).s();
                if (bl3) {
                    AccountManager.requestLogout();
                    object2 = d.v.a.f.c.d.d.F();
                    n11 = 0;
                    ((d.v.a.f.c.d.d)object2).c0(null);
                }
                object = ((BaseEntity)object).punish;
                f.f(fragmentActivity, (Punish)object);
                return bl2;
            }
            n11 = 10184;
            if (n11 == n12 && (n10 = (int)(TextUtils.isEmpty((CharSequence)(object2 = ((Punish)object2).getPath())) ? 1 : 0)) == 0 && (n10 = (int)(f.h(fragmentActivity, (String)(object2 = ((BaseEntity)object).punish.getPath())) ? 1 : 0)) != 0) {
                d.v.a.f.c.b.N().d("2");
                return bl2;
            }
        }
        n10 = object != null ? ((BaseEntity)object).errcode : -1;
        object = object != null ? ((BaseEntity)object).errmsg : "";
        n2.e(d.v.a.f.b.a.fromErrCodeToMessage((Context)fragmentActivity, n10, (String)object));
        return false;
    }

    public static void f(FragmentActivity object, Punish object2) {
        Object object3;
        String string2;
        Object object4 = a;
        if (object4 != null) {
            return;
        }
        Object object5 = "1";
        object4 = ((Punish)object2).getForever();
        boolean n10 = ((String)object5).equals(object4);
        if (n10) {
            int n11 = 2131951713;
            object4 = g.m((Context)object, n11);
        } else {
            int n12 = 2131951712;
            int n13 = 1;
            object5 = new Object[n13];
            string2 = null;
            object5[0] = object3 = Times.getTimeZoneDescribe(((Punish)object2).getPunish_endtime());
            object4 = g.n((Context)object, n12, (Object[])object5);
        }
        object5 = new k$b((Context)object);
        string2 = g.m((Context)object, 2131953237);
        object5 = (k$b)((k$b)((k$a)object5).B(string2)).n("ignore");
        string2 = g.m((Context)object, 2131952621);
        object3 = e.a;
        object5 = (k$b)((k$a)object5).x(string2, (d.v.f.f.a)object3);
        string2 = g.m((Context)object, 2131951647);
        object3 = new a((FragmentActivity)object, (Punish)object2);
        object2 = (k$b)((k$b)((k$a)object5).q(string2, (d.v.f.f.a)object3)).s();
        object5 = new b((String)object4, (FragmentActivity)object);
        a = object2 = ((k$b)((k$a)object2).u((Consumer)object5)).b();
        object4 = c.a;
        ((d.v.f.g.b)object2).n((b$b)object4);
        object2 = a;
        object = ((FragmentActivity)object).getSupportFragmentManager();
        ((d.v.f.g.b)object2).q((FragmentManager)object);
    }

    private static void g(FragmentActivity object, String object2, String string2) {
        Object object3 = new k$b((Context)object);
        object2 = (k$b)((k$b)((k$a)object3).B((String)object2)).n(string2);
        string2 = g.m((Context)object, 2131952621);
        object3 = e.a;
        object2 = (k$b)((k$a)object2).x(string2, (d.v.f.f.a)object3);
        object = ((FragmentActivity)object).getSupportFragmentManager();
        ((k$a)object2).D((FragmentManager)object);
    }

    /*
     * WARNING - void declaration
     */
    private static boolean h(FragmentActivity fragmentActivity, String string2) {
        void var6_22;
        int n10;
        String string3 = "/v1/";
        String string4 = "";
        string2 = string2.replace(string3, string4);
        string2.hashCode();
        int n11 = string2.hashCode();
        boolean bl2 = true;
        int bl3 = -1;
        switch (n11) {
            default: {
                break;
            }
            case 1782017484: {
                string3 = "share/reply/add";
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                int n12 = 14;
                break;
            }
            case 1380300496: {
                string3 = "share/post/publish";
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                int n13 = 13;
                break;
            }
            case 1367754724: {
                string3 = "school/post/unlike";
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                int n14 = 12;
                break;
            }
            case 1151333327: {
                string3 = "share/post/unlike";
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                int n15 = 11;
                break;
            }
            case 988376880: {
                string3 = "school/reply/unlike";
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                int n16 = 10;
                break;
            }
            case 882006733: {
                string3 = "circle/circleAddComment";
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                int n17 = 9;
                break;
            }
            case 660456225: {
                string3 = "school/reply/add";
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                int n18 = 8;
                break;
            }
            case 639486747: {
                string3 = "share/post/create";
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                int n19 = 7;
                break;
            }
            case 455970020: {
                string3 = "circle/articleFav";
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                int n20 = 6;
                break;
            }
            case -119745162: {
                string3 = "share/post/like";
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                int n21 = 5;
                break;
            }
            case -274657297: {
                string3 = "profile/update";
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                int n22 = 4;
                break;
            }
            case -1000360681: {
                string3 = "school/reply/like";
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                int n23 = 3;
                break;
            }
            case -1241306421: {
                string3 = "school/post/like";
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                int n24 = 2;
                break;
            }
            case -1912756522: {
                string3 = "school/comment/add";
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                boolean bl4 = bl2;
                break;
            }
            case -2129177919: {
                string3 = "share/comment/add";
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                boolean bl5 = false;
            }
        }
        switch (var6_22) {
            default: {
                string2 = string4;
                break;
            }
            case 7: 
            case 13: {
                string4 = g.m((Context)fragmentActivity, 2131951673);
                n10 = 2131951674;
                string2 = g.m((Context)fragmentActivity, n10);
                break;
            }
            case 4: {
                string4 = g.m((Context)fragmentActivity, 2131951669);
                n10 = 2131951670;
                string2 = g.m((Context)fragmentActivity, n10);
                break;
            }
            case 2: 
            case 3: 
            case 5: 
            case 6: 
            case 10: 
            case 11: 
            case 12: {
                string4 = g.m((Context)fragmentActivity, 2131951667);
                n10 = 2131951668;
                string2 = g.m((Context)fragmentActivity, n10);
                break;
            }
            case 0: 
            case 1: 
            case 8: 
            case 9: 
            case 14: {
                string4 = g.m((Context)fragmentActivity, 2131951659);
                n10 = 2131951660;
                string2 = g.m((Context)fragmentActivity, n10);
            }
        }
        n11 = (int)(TextUtils.isEmpty((CharSequence)string4) ? 1 : 0);
        if (n11 != 0) {
            return false;
        }
        f.g(fragmentActivity, string4, string2);
        return bl2;
    }
}

