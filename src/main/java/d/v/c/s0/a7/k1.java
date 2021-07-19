/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.Size
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 */
package d.v.c.s0.a7;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.data.database.model.CameraParam;
import d.v.c.s0.a7.g0;
import d.v.c.s0.a7.h0;
import d.v.c.s0.a7.i0;
import d.v.c.s0.a7.j0;
import d.v.c.s0.a7.k0;
import d.v.c.s0.a7.k1$a;
import d.v.c.s0.a7.u0;
import d.v.c.s0.u6;
import d.v.c.w0.r1;
import d.v.d.i.g.k;
import d.v.d.i.g.k$a;
import d.v.e.l.h2;
import d.v.e.l.o1;
import d.v.f.i.g;
import d.v.i0.b;
import java.util.ArrayList;

public class k1
extends u0 {
    private r1 h;
    private u6 i;

    private void B() {
        Object object;
        this.i = object = (u6)b.c(this.requireActivity()).get(u6.class);
        r1 r12 = this.h;
        object = object.I();
        r12.B((CameraSet$Mode)((Object)object));
    }

    private void C() {
        RadioGroup radioGroup = this.h.o;
        Object object = new k0(this);
        radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)object);
        radioGroup = this.h.c;
        object = new g0(this);
        radioGroup.setOnClickListener((View.OnClickListener)object);
        radioGroup = this.h.d;
        object = new i0(this);
        radioGroup.setOnClickListener((View.OnClickListener)object);
        radioGroup = this.h.e;
        object = new j0(this);
        radioGroup.setOnClickListener((View.OnClickListener)object);
        radioGroup = this.h.n;
        object = new h0(this);
        radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)object);
    }

    private void D() {
        Object object;
        boolean bl2;
        this.e();
        Object object2 = (CameraParam)this.i.J().getValue();
        Object object3 = this.i.t0();
        int n10 = 0;
        object2 = object2 == null ? (k$a)object3.get(0) : ((CameraParam)object2).getVideoResolution();
        RadioButton radioButton = (RadioButton)this.h.o.getChildAt(0);
        int bl22 = 8;
        radioButton.setVisibility(bl22);
        Object object4 = this.h.o;
        int n11 = 1;
        object4 = (RadioButton)object4.getChildAt(n11);
        object4.setVisibility(bl22);
        RadioGroup radioGroup = this.h.o;
        int n12 = 2;
        radioGroup = (RadioButton)radioGroup.getChildAt(n12);
        radioGroup.setVisibility(bl22);
        object3 = object3.iterator();
        while (bl2 = object3.hasNext()) {
            CameraSet$Mode cameraSet$Mode;
            boolean bl3;
            object = (k$a)object3.next();
            Size size = ((k$a)object).a;
            Object object5 = ((k$a)object2).a;
            boolean bl4 = size.equals(object5);
            if (bl4) {
                this.P((k$a)object);
            }
            if (bl3 = k.u(object5 = ((k$a)object).a)) {
                radioButton.setVisibility(0);
                radioButton.setChecked(bl4);
                object5 = ((k$a)object).b;
                radioButton.setText((CharSequence)object5);
            }
            if (bl3 = k.r(object5 = ((k$a)object).a)) {
                object4.setVisibility(0);
                object4.setChecked(bl4);
                object5 = ((k$a)object).b;
                object4.setText((CharSequence)object5);
            }
            if (!(bl3 = k.s(object5 = ((k$a)object).a)) || (object5 = (CameraSet$Mode)((Object)this.i.H().getValue())) == (cameraSet$Mode = CameraSet$Mode.sport_delay) || object5 == (cameraSet$Mode = CameraSet$Mode.dolly_zoom)) continue;
            radioGroup.setVisibility(0);
            radioGroup.setChecked(bl4);
            object = ((k$a)object).b;
            radioGroup.setText((CharSequence)object);
        }
        object2 = this.i.E0();
        int n13 = object2.size();
        while (n10 < n13) {
            radioButton = (RadioButton)this.h.n.getChildAt(n10);
            object = (String)object2.get(n10);
            radioButton.setText((CharSequence)object);
            object4 = this.i.y0();
            boolean bl5 = ((String)object).equals(object4);
            radioButton.setChecked(bl5);
            ++n10;
        }
    }

    private /* synthetic */ void E(RadioGroup object, int n10) {
        int n11 = 2131363059;
        if (n10 == n11) {
            object = k.r;
        } else {
            n11 = 2131363055;
            if (n10 == n11) {
                object = k.s;
            } else {
                n11 = 2131363058;
                if (n10 == n11) {
                    object = k.t;
                } else {
                    n11 = 0;
                    object = null;
                }
            }
        }
        if (object != null) {
            Integer n12;
            Object object2;
            int n13;
            Object object3 = ((k$a)object).a;
            n10 = (int)(k.s((Size)object3) ? 1 : 0);
            if (n10 != 0 && (n10 = (int)(((u6)(object3 = this.i)).k1() ? 1 : 0)) != 0) {
                object3 = this.i;
                n13 = 2131951769;
                object2 = g.s(this, n13);
                ((u6)object3).o2((String)object2);
            }
            object3 = ((CameraParam)this.i.J().getValue()).getVideoResolution();
            n10 = ((k$a)object3).c();
            object2 = ((k$a)object).a();
            n13 = (int)(object2.contains(n12 = Integer.valueOf(n10)) ? 1 : 0);
            if (n13 != 0) {
                ((k$a)object).i(n10);
            } else {
                ((k$a)object).f();
            }
            object3 = this.i;
            ((u6)object3).S1((k$a)object);
            this.P((k$a)object);
        }
    }

    private /* synthetic */ void G(View view) {
        int n10 = Integer.parseInt(this.h.c.getText().toString().substring(0, 2));
        k$a k$a = this.i.Q();
        k$a.i(n10);
        this.i.S1(k$a);
    }

    private /* synthetic */ void I(View view) {
        int n10 = Integer.parseInt(this.h.d.getText().toString().substring(0, 2));
        k$a k$a = this.i.Q();
        k$a.i(n10);
        this.i.S1(k$a);
    }

    private /* synthetic */ void K(View view) {
        int n10 = Integer.parseInt(this.h.e.getText().toString().substring(0, 2));
        k$a k$a = this.i.Q();
        k$a.i(n10);
        this.i.S1(k$a);
    }

    private /* synthetic */ void M(RadioGroup object, int n10) {
        int n11 = 2131363048;
        if (n10 == n11) {
            object = this.h.i.getText();
        } else {
            n11 = 2131363045;
            if (n10 == n11) {
                object = this.h.f.getText();
            } else {
                n11 = 2131363046;
                if (n10 == n11) {
                    object = this.h.g.getText();
                } else {
                    n11 = 2131363047;
                    if (n10 == n11) {
                        object = this.h.h.getText();
                    } else {
                        n11 = 0;
                        object = null;
                    }
                }
            }
        }
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 == 0) {
            u6 u62 = this.i;
            object = object.toString();
            u62.l2((String)object);
        }
    }

    public static k1 O() {
        k1 k12 = new k1();
        return k12;
    }

    private void P(k$a k$a) {
        Object object = new ArrayList();
        int n10 = 24;
        Integer n11 = n10;
        object.add(n11);
        int n12 = 30;
        Integer n13 = n12;
        object.add(n13);
        int n14 = k$a.b();
        int n15 = 60;
        if (n14 >= n15) {
            n13 = n15;
            object.add(n13);
        }
        n13 = this.h.m;
        int n16 = 2131363025;
        n13 = (RadioButton)n13.findViewById(n16);
        RadioGroup radioGroup = this.h.m;
        int n17 = 2131363026;
        radioGroup = (RadioButton)radioGroup.findViewById(n17);
        RadioButton radioButton = (RadioButton)this.h.m.findViewById(2131363027);
        int n18 = 8;
        n13.setVisibility(n18);
        radioGroup.setVisibility(n18);
        radioButton.setVisibility(n18);
        object = object.iterator();
        while ((n18 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            int n19;
            Object object2 = (Integer)object.next();
            int n20 = (Integer)object2;
            n20 = n20 == (n19 = k$a.c()) ? 1 : 0;
            n18 = (Integer)object2;
            if (n18 != n10) {
                if (n18 != n12) {
                    CameraSet$Mode cameraSet$Mode;
                    if (n18 != n15 || (object2 = this.i.H().getValue()) == (cameraSet$Mode = CameraSet$Mode.delay_video)) continue;
                    radioButton.setVisibility(0);
                    radioButton.setChecked(n20 != 0);
                    object2 = "60fps";
                    radioButton.setText((CharSequence)object2);
                    continue;
                }
                radioGroup.setVisibility(0);
                radioGroup.setChecked(n20 != 0);
                object2 = "30fps";
                radioGroup.setText((CharSequence)object2);
                continue;
            }
            n13.setVisibility(0);
            n13.setChecked(n20 != 0);
            object2 = "24fps";
            n13.setText((CharSequence)object2);
        }
    }

    public /* synthetic */ void F(RadioGroup radioGroup, int n10) {
        this.E(radioGroup, n10);
    }

    public /* synthetic */ void H(View view) {
        this.G(view);
    }

    public /* synthetic */ void J(View view) {
        this.I(view);
    }

    public /* synthetic */ void L(View view) {
        this.K(view);
    }

    public /* synthetic */ void N(RadioGroup radioGroup, int n10) {
        this.M(radioGroup, n10);
    }

    public void e() {
        ImageView imageView = this.h.a;
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
        return 2131558475;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (r1)viewDataBinding;
        this.h = viewDataBinding;
        k1$a k1$a = new k1$a(this);
        ((r1)viewDataBinding).A(k1$a);
        int n10 = h2.b(260.0f);
        this.z(n10);
    }
}

