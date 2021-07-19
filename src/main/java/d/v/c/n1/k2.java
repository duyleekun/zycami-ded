/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.view.View
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.PopupWindow
 */
package d.v.c.n1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.data.me.remote.AccountManager$AuthData;
import d.v.c.n1.j2;
import d.v.c.n1.k2$a;
import d.v.c.n1.k2$b;
import d.v.c.n1.o1;
import d.v.c.s0.d7.a0;
import d.v.c.w0.yf;
import d.v.e.i.h;
import d.v.n.j.c.a;
import k.f;

public class k2
extends PopupWindow {
    private yf a;
    private j2 b;
    private k2$b c;

    public k2(Context context, yf yf2) {
        super(context);
        this.setHeight(-2);
        this.setWidth(-1);
        boolean bl2 = true;
        this.setOutsideTouchable(bl2);
        this.setFocusable(bl2);
        super(0);
        this.setBackgroundDrawable((Drawable)context);
        this.a = yf2;
        context = yf2.getRoot();
        this.setContentView((View)context);
        this.c();
    }

    public static /* synthetic */ j2 a(k2 k22) {
        return k22.b;
    }

    public static /* synthetic */ k2$b b(k2 k22) {
        return k22.c;
    }

    private void c() {
        CheckBox checkBox = this.a.a;
        o1 o12 = new o1(this);
        checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)o12);
    }

    private /* synthetic */ void d(CompoundButton object, boolean bl2) {
        object = this.b.K();
        Object object2 = bl2;
        h.g((MutableLiveData)object, object2);
        if (bl2) {
            long l10;
            long l11;
            long l12;
            long l13;
            boolean bl3;
            String string2 = "";
            String string3 = "";
            String string4 = "";
            String string5 = "";
            String string6 = "";
            object = new AccountManager$AuthData(string2, string3, string4, string5, string6);
            Object object3 = a0.e();
            object2 = "kuaishou";
            object = ((a0)object3).d((String)object2, (AccountManager$AuthData)object);
            object3 = ((AccountManager$AuthData)object).access_token;
            if (object3 != null && !(bl3 = TextUtils.isEmpty((CharSequence)object3)) && (l13 = (l12 = (l11 = ((AccountManager$AuthData)object).expires_at * 1000L) - (l10 = System.currentTimeMillis())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) >= 0) {
                object = d.v.n.j.c.a.c.b("ks680887970458072564", (String)object3);
                object2 = new k2$a(this, (String)object3);
                object.h((f)object2);
            } else {
                object = this.c;
                if (object != null) {
                    object.a();
                }
            }
        }
    }

    public /* synthetic */ void e(CompoundButton compoundButton, boolean bl2) {
        this.d(compoundButton, bl2);
    }

    public void f(k2$b k2$b) {
        this.c = k2$b;
    }

    public void g(j2 j22) {
        this.b = j22;
        this.a.z(j22);
    }
}

