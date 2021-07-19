/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 */
package d.v.c.s0.a7;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.widget.WheelPicker;
import com.zhiyun.cama.camera.widget.WheelPicker$b;
import d.v.c.s0.a7.b;
import d.v.c.s0.a7.c;
import d.v.c.s0.a7.d;
import d.v.c.s0.a7.e;
import d.v.c.s0.a7.u0;
import d.v.c.s0.a7.x0$a;
import d.v.c.s0.u6;
import d.v.c.w0.t1;
import d.v.e.h.a;
import d.v.e.l.h2;
import d.v.e.l.o1;
import java.util.Arrays;
import java.util.List;

public class x0
extends u0 {
    private t1 h;
    private u6 i;
    private List j;
    private List k;
    private List l;

    private void B() {
        u6 u62;
        this.i = u62 = (u6)d.v.i0.b.c(this.requireActivity()).get(u6.class);
    }

    private void C() {
        Object object = this.h.m;
        Object object2 = new c(this);
        object.setOnWheelChangeListener((WheelPicker$b)object2);
        object = this.h.n;
        object2 = new d(this);
        object.setOnWheelChangeListener((WheelPicker$b)object2);
        object = this.h.l;
        object2 = new b(this);
        object.setOnWheelChangeListener((WheelPicker$b)object2);
        object = this.h.e;
        object2 = new e(this);
        object.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)object2);
        object = (Boolean)this.i.h0().getValue();
        int n10 = a.c((Boolean)object);
        object2 = this.h.e;
        n10 = n10 != 0 ? 2131363040 : 2131363018;
        object2.check(n10);
    }

    private void D() {
        List<String> list;
        this.e();
        this.j = list = Arrays.asList(o1.U(this.getResources(), 2130903041));
        this.h.m.setDataList(list);
        this.k = list = Arrays.asList(o1.U(this.getResources(), 2130903042));
        this.h.n.setDataList(list);
        this.l = list = Arrays.asList(o1.U(this.getResources(), 2130903040));
        this.h.l.setDataList(list);
    }

    private /* synthetic */ void E(String string2, int n10) {
        this.i.P1(string2);
        Object object = (Boolean)this.i.h0().getValue();
        n10 = (int)(a.c((Boolean)object) ? 1 : 0);
        if (n10 != 0) {
            object = this.i;
            ((u6)object).u1(string2);
        }
    }

    private /* synthetic */ void G(String string2, int n10) {
        this.i.R1(string2);
        Object object = (Boolean)this.i.h0().getValue();
        n10 = (int)(a.c((Boolean)object) ? 1 : 0);
        if (n10 != 0) {
            object = this.i;
            ((u6)object).v1(string2);
        }
    }

    private /* synthetic */ void I(String string2, int n10) {
        this.i.O1(string2);
    }

    private /* synthetic */ void K(RadioGroup object, int n10) {
        Object object2;
        object = null;
        boolean bl2 = true;
        int n11 = 2131363040;
        if (n10 == n11) {
            this.i.Q1(bl2);
            this.h.l.setScrollEnable(false);
            this.h.m.setScrollEnable(bl2);
            this.h.n.setScrollEnable(bl2);
            object = this.h.m;
            object2 = this.j;
            Object object3 = this.i.N().getValue();
            n10 = object2.indexOf(object3);
            ((WheelPicker)((Object)object)).setCurrentPosition(n10);
            object = this.h.n;
            object2 = this.k;
            object3 = this.i.P().getValue();
            n10 = object2.indexOf(object3);
            ((WheelPicker)((Object)object)).setCurrentPosition(n10);
        } else {
            n11 = 2131363018;
            if (n10 == n11) {
                this.i.Q1(false);
                this.h.l.setScrollEnable(bl2);
                this.h.m.setScrollEnable(false);
                this.h.n.setScrollEnable(false);
                object = this.i;
                object2 = "1/60";
                ((u6)object).R1((String)object2);
                object = this.h.n;
                List list = this.k;
                n10 = list.indexOf(object2);
                ((WheelPicker)((Object)object)).setCurrentPosition(n10);
            }
        }
        object = this.i;
        object2 = "0";
        ((u6)object).O1((String)object2);
        object = this.h.l;
        n10 = this.l.indexOf(object2);
        ((WheelPicker)((Object)object)).setCurrentPosition(n10);
    }

    public static x0 M() {
        x0 x02 = new x0();
        return x02;
    }

    public /* synthetic */ void F(String string2, int n10) {
        this.E(string2, n10);
    }

    public /* synthetic */ void H(String string2, int n10) {
        this.G(string2, n10);
    }

    public /* synthetic */ void J(String string2, int n10) {
        this.I(string2, n10);
    }

    public /* synthetic */ void L(RadioGroup radioGroup, int n10) {
        this.K(radioGroup, n10);
    }

    public void e() {
        ImageView imageView = this.h.b;
        Drawable drawable2 = o1.o(this.getResources(), 2131231362);
        imageView.setImageDrawable(drawable2);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.B();
        this.D();
        this.C();
    }

    public int s() {
        return 2131558476;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (t1)viewDataBinding;
        this.h = viewDataBinding;
        x0$a x0$a = new x0$a(this);
        ((t1)viewDataBinding).z(x0$a);
        int n10 = h2.b(310.0f);
        this.z(n10);
    }
}

