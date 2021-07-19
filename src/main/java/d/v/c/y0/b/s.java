/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.Intent
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.util.Base64
 *  android.view.View
 *  android.view.WindowManager$LayoutParams
 */
package d.v.c.y0.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.WindowManager;
import androidx.core.app.ActivityCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.camera.StackLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.device.connection.BleDevice;
import com.zhiyun.device.connection.BleDevice$State;
import com.zhiyun.device.connection.BleDeviceViewModel;
import com.zhiyun.device.connection.BleDeviceViewModel$ConnectStatus;
import com.zhiyun.device.connection.BleDeviceViewModel$OperationStatus;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.c.n0.c;
import d.v.c.s0.s6;
import d.v.c.v0.u.z;
import d.v.c.w0.j3;
import d.v.c.y0.b.a;
import d.v.c.y0.b.d;
import d.v.c.y0.b.e;
import d.v.c.y0.b.f;
import d.v.c.y0.b.g;
import d.v.c.y0.b.h;
import d.v.c.y0.b.i;
import d.v.c.y0.b.j;
import d.v.c.y0.b.s$b;
import d.v.c.y0.b.s$c;
import d.v.c.y0.b.s$d;
import d.v.c.y0.b.s$e;
import d.v.c.y0.b.v.b;
import d.v.c.z0.k$b;
import d.v.e.l.h2;
import d.v.e.l.m2;
import d.v.e.l.m2$d;
import d.v.e.l.n2;
import d.v.e0.ce;
import d.v.g.g.c1;
import java.util.ArrayList;

public class s
extends d.v.f.g.a {
    private static final int r = 1;
    private j3 f;
    private BleViewModel g;
    private s6 h;
    private c1 i;
    private b j;
    private BleDeviceViewModel k;
    private m2$d l;
    private boolean m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private s$e q;

    public s() {
        this(false, false);
    }

    public s(boolean bl2, boolean bl3) {
        boolean bl4;
        this.m = bl4 = true;
        this.n = bl2;
        this.o = bl3;
        this.p = bl2 ^= bl4;
    }

    private void A(BleDevice object) {
        Object[] objectArray = this.j.getData();
        int n10 = objectArray.indexOf(object);
        int n11 = 1;
        if (n10 >= 0) {
            objectArray = (BleDevice)objectArray.get(n10);
            BleDevice$State bleDevice$State = objectArray.b;
            BleDevice$State bleDevice$State2 = ((BleDevice)object).b;
            if (bleDevice$State != bleDevice$State2) {
                objectArray.b = bleDevice$State2;
                objectArray = new Object[n11];
                objectArray[0] = object = ((BleDevice)object).b;
                m.a.a.b("change device device state = %s", objectArray);
                object = this.j;
                ((RecyclerView$Adapter)object).notifyItemChanged(n10);
            }
        } else {
            objectArray.add(object);
            Object[] objectArray2 = new Object[n11];
            objectArray2[0] = object = ((BleDevice)object).b;
            m.a.a.b("add device device state = %s", objectArray2);
            object = this.j;
            int n12 = objectArray.size();
            ((RecyclerView$Adapter)object).notifyItemChanged(n12);
        }
    }

    private void B(BleDevice object, int n10) {
        Object object2;
        Object object3 = BleDevice$State.CONNECTING;
        this.c0(n10, (BleDevice$State)((Object)object3));
        n10 = (int)(ce.z1() ? 1 : 0);
        if (n10 != 0) {
            object2 = ce.E0();
            ((ce)object2).U();
        }
        this.k.H();
        object2 = d.v.a.f.c.b.N();
        n10 = (int)(((d.v.a.f.c.b)object2).s() ? 1 : 0);
        object3 = null;
        if (n10 != 0) {
            n10 = d.v.a.f.c.b.N().i().getId();
            object3 = String.valueOf(n10);
            object2 = d.v.a.f.c.b.N().i().getToken();
        } else {
            n10 = 0;
            object2 = null;
        }
        BleConnection bleConnection = BleConnection.W();
        object = ((BleDevice)object).a;
        bleConnection.P((Stabilizer)object, (String)object3, (String)object2);
    }

    private void C() {
        Object object = BleConnection.W().T();
        if (object == null) {
            return;
        }
        Object object2 = d.v.a.f.c.b.N().P();
        String string2 = Base64.encodeToString((byte[])BleConnection.W().S().activeCode, (int)0);
        d.v.c.v0.l.e e10 = d.v.c.v0.l.e.a;
        object = ((Stabilizer)object).G2();
        object = e10.a((String)object2, (String)object, string2);
        object2 = new s$b(this);
        object.h((k.f)object2);
    }

    private void D() {
        this.k.G();
    }

    private void E() {
    }

    private void F() {
        MutableLiveData mutableLiveData = this.k.A();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new f(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.k.s();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new d(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.k.w();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new i(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.g.k;
        lifecycleOwner = this.getViewLifecycleOwner();
        h h10 = new h(this);
        observer = new d.v.e.i.f(h10);
        ((StackLiveData)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.h.f;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new a(this);
        mutableLiveData.observe(lifecycleOwner, observer);
    }

    private void G() {
        Object object = this.f.g;
        Context context = this.getContext();
        ArrayList arrayList = new ArrayList(context);
        ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)((Object)arrayList));
        object = this.f.g;
        arrayList = new ArrayList();
        ((RecyclerView)object).setItemAnimator((RecyclerView$ItemAnimator)((Object)arrayList));
        object = this.f.g;
        boolean bl2 = this.p;
        arrayList = new ArrayList(this, bl2);
        this.j = arrayList;
        ((RecyclerView)object).setAdapter((RecyclerView$Adapter)((Object)arrayList));
        object = this.j;
        arrayList = new ArrayList();
        ((c)object).d(arrayList);
    }

    public static /* synthetic */ void H(s s10, BleDevice bleDevice) {
        s10.A(bleDevice);
    }

    private /* synthetic */ void I(BleDeviceViewModel$ConnectStatus object) {
        Object object2 = s$c.b;
        int n10 = ((Enum)object).ordinal();
        int n11 = 1;
        if ((n10 = object2[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 == n11 && (object = this.k.u()) != null) {
                    object2 = new BleDevice;
                    object2((Stabilizer)object);
                    this.j.getData().remove(object2);
                    object = this.j;
                    ((RecyclerView$Adapter)object).notifyDataSetChanged();
                }
            } else {
                n10 = 2131951954;
                object = d.v.f.i.g.s(this, n10);
                n11 = this.k();
                n2.f((String)object, n11);
            }
        } else {
            n10 = 2131951890;
            object = d.v.f.i.g.s(this, n10);
            n11 = this.k();
            n2.f((String)object, n11);
        }
    }

    private /* synthetic */ void K(BleDeviceViewModel$OperationStatus object) {
        block12: {
            block7: {
                block8: {
                    Object object2;
                    block9: {
                        block11: {
                            block10: {
                                int n10;
                                object2 = s$c.a;
                                int n11 = ((Enum)object).ordinal();
                                n11 = object2[n11];
                                if (n11 == (n10 = 1)) break block7;
                                int n12 = 2;
                                if (n11 == n12) break block8;
                                int n13 = 3;
                                if (n11 == n13) break block9;
                                int n14 = 4;
                                if (n11 == n14) break block10;
                                int n15 = 5;
                                if (n11 == n15) break block11;
                                break block12;
                            }
                            this.Z();
                            this.a0();
                        }
                        this.Z();
                        this.b0();
                        break block12;
                    }
                    this.Z();
                    object = d.v.f.i.g.m(this.getContext(), 2131951951);
                    int n16 = this.k();
                    n2.f((String)object, n16);
                    object = z.m();
                    boolean bl2 = ((z)object).B();
                    object2 = this.i;
                    Stabilizer stabilizer = BleConnection.W().T();
                    object2.M(stabilizer, bl2);
                    boolean bl3 = this.n;
                    if (bl3) {
                        this.C();
                    }
                    break block12;
                }
                this.dismiss();
                boolean bl4 = this.n;
                if (!bl4) {
                    object = this.requireActivity();
                    ActivityCompat.finishAfterTransition((Activity)object);
                } else {
                    object = this.q;
                    if (object != null) {
                        object.c();
                    }
                }
                break block12;
            }
            this.dismiss();
            boolean bl5 = this.n;
            if (!bl5) {
                object = this.requireActivity();
                ActivityCompat.finishAfterTransition((Activity)object);
            } else {
                object = this.q;
                if (object != null) {
                    object.b();
                }
            }
        }
    }

    private /* synthetic */ void M(Boolean bl2) {
        this.dismissAllowingStateLoss();
    }

    private /* synthetic */ void O(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            this.dismissAllowingStateLoss();
            object = this.h.f;
            Boolean bl3 = Boolean.FALSE;
            ((MutableLiveData)object).setValue(bl3);
        }
    }

    private /* synthetic */ void Q(DialogFragment activityResultCaller) {
        this.dismiss();
        boolean bl2 = this.n;
        if (!bl2) {
            activityResultCaller = this.requireActivity();
            ActivityCompat.finishAfterTransition((Activity)activityResultCaller);
        }
    }

    private /* synthetic */ void S(DialogFragment dialogFragment) {
        dialogFragment = new Intent("android.settings.WIFI_SETTINGS");
        this.startActivityForResult((Intent)dialogFragment, 1);
    }

    private /* synthetic */ void U(DialogFragment activityResultCaller) {
        this.dismiss();
        boolean bl2 = this.n;
        if (!bl2) {
            activityResultCaller = this.requireActivity();
            ActivityCompat.finishAfterTransition((Activity)activityResultCaller);
        }
    }

    private void W() {
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            int n10;
            int n11;
            dialog = this.getDialog();
            int n12 = 0;
            float f10 = 0.0f;
            dialog.setCanceledOnTouchOutside(false);
            dialog = this.getDialog().getWindow();
            dialog.getDecorView().setPadding(0, 0, 0, 0);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)colorDrawable);
            colorDrawable = dialog.getAttributes();
            colorDrawable.gravity = 17;
            float f11 = 300.0f;
            colorDrawable.width = n11 = h2.b(f11);
            colorDrawable.height = n10 = h2.b(f11);
            n10 = (int)(this.p ? 1 : 0);
            if (n10 != 0) {
                n10 = 0;
                f11 = 0.0f;
                colorDrawable.dimAmount = 0.0f;
            }
            dialog.setAttributes((WindowManager.LayoutParams)colorDrawable);
            int n13 = this.m;
            if (n13 != 0) {
                int n14;
                n13 = this.k();
                if (n13 == 0 || n13 == (n14 = 2)) {
                    n12 = -90;
                    f10 = 0.0f / 0.0f;
                }
                if ((dialog = this.getView()) != null) {
                    f10 = n12;
                    dialog.setRotation(f10);
                }
            }
        }
    }

    private void Z() {
        Object object = this.k.u();
        Object object2 = BleConnection.W();
        boolean bl2 = ((BleConnection)object2).c0();
        if (bl2 && object != null) {
            object2 = this.j.getData();
            BleDevice bleDevice = new BleDevice((Stabilizer)object);
            object2.remove(bleDevice);
            object = this.j;
            ((RecyclerView$Adapter)object).notifyDataSetChanged();
        }
    }

    private void a0() {
        Object object = new k$b();
        Object object2 = d.v.f.i.g.s(this, 2131952619);
        object = ((k$b)object).J((String)object2);
        object2 = d.v.f.i.g.s(this, 2131951947);
        object = ((k$b)object).y((String)object2);
        int n10 = this.n;
        n10 = n10 == 0 ? 2131952142 : 2131951833;
        object2 = d.v.f.i.g.s(this, n10);
        d.v.f.f.a a10 = new j(this);
        object = ((k$b)object).D((String)object2, a10);
        object2 = d.v.f.i.g.s(this, 2131951991);
        a10 = new e(this);
        object = ((k$b)object).G((String)object2, a10);
        n10 = h2.b(300.0f);
        object = ((k$b)object).O(n10).B(true).v();
        object2 = this.getChildFragmentManager();
        ((d.v.f.g.b)object).q((FragmentManager)object2);
    }

    private void b0() {
        Object object;
        Object object2;
        Object object3 = BleConnection.W().Y();
        if (object3 == null) {
            object3 = "";
        } else {
            object2 = new StringBuilder();
            object = "(";
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(")");
            object3 = ((StringBuilder)object2).toString();
        }
        object2 = d.v.f.i.g.m(this.requireContext(), 2131952853);
        object = this.requireContext();
        int n10 = 2131951948;
        Object[] objectArray = new Object[2];
        objectArray[0] = object2;
        int n11 = 1;
        objectArray[n11] = object3;
        object3 = d.v.f.i.g.n((Context)object, n10, objectArray);
        object = new k$b();
        Object object4 = this.requireContext();
        int n12 = 2131952619;
        object4 = d.v.f.i.g.m(object4, n12);
        object3 = ((k$b)object).J((String)object4).y((String)object3);
        object = null;
        object3 = ((k$b)object3).D(null, null);
        int n13 = this.n;
        n13 = n13 == 0 ? 2131952142 : 2131951887;
        object = d.v.f.i.g.s(this, n13);
        object4 = new g(this);
        object3 = ((k$b)object3).G((String)object, (d.v.f.f.a)object4).B(n11 != 0);
        n11 = h2.b(300.0f);
        object3 = ((k$b)object3).O(n11).v();
        object2 = this.getChildFragmentManager();
        ((d.v.f.g.b)object3).q((FragmentManager)object2);
    }

    private void c0(int n10, BleDevice$State bleDevice$State) {
        ((BleDevice)this.j.getData().get((int)n10)).b = bleDevice$State;
        this.j.notifyItemChanged(n10);
    }

    public static /* synthetic */ void u(s s10, BleDevice bleDevice, int n10) {
        s10.B(bleDevice, n10);
    }

    public static /* synthetic */ BleDeviceViewModel v(s s10) {
        return s10.k;
    }

    public static /* synthetic */ j3 w(s s10) {
        return s10.f;
    }

    public static /* synthetic */ m2$d x(s s10, m2$d m2$d) {
        s10.l = m2$d;
        return m2$d;
    }

    public static /* synthetic */ boolean y(s s10) {
        return s10.o;
    }

    public static /* synthetic */ s$e z(s s10) {
        return s10.q;
    }

    public /* synthetic */ void J(BleDeviceViewModel$ConnectStatus bleDeviceViewModel$ConnectStatus) {
        this.I(bleDeviceViewModel$ConnectStatus);
    }

    public /* synthetic */ void L(BleDeviceViewModel$OperationStatus bleDeviceViewModel$OperationStatus) {
        this.K(bleDeviceViewModel$OperationStatus);
    }

    public /* synthetic */ void N(Boolean bl2) {
        this.M(bl2);
    }

    public /* synthetic */ void P(Boolean bl2) {
        this.O(bl2);
    }

    public /* synthetic */ void R(DialogFragment dialogFragment) {
        this.Q(dialogFragment);
    }

    public /* synthetic */ void T(DialogFragment dialogFragment) {
        this.S(dialogFragment);
    }

    public /* synthetic */ void V(DialogFragment dialogFragment) {
        this.U(dialogFragment);
    }

    public void X(boolean bl2) {
        this.m = bl2;
    }

    public void Y(s$e s$e) {
        this.q = s$e;
    }

    public int k() {
        int n10 = this.m;
        n10 = n10 != 0 ? super.k() : 3;
        return n10;
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        BleConnection bleConnection;
        super.onActivityResult(n10, n11, intent);
        n11 = 1;
        if (n10 == n11 && (n10 = (int)((bleConnection = BleConnection.W()).c0() ? 1 : 0)) != 0) {
            bleConnection = BleConnection.W();
            bleConnection.M();
        }
    }

    public void onAttach(Context object) {
        BleDeviceViewModel bleDeviceViewModel;
        super.onAttach((Context)object);
        object = d.v.i0.b.a(this);
        ViewModelProvider viewModelProvider = d.v.i0.b.c(this.requireActivity());
        this.k = bleDeviceViewModel = (BleDeviceViewModel)((ViewModelProvider)object).get(BleDeviceViewModel.class);
        this.g = object = (BleViewModel)((ViewModelProvider)object).get(BleViewModel.class);
        this.h = object = (s6)viewModelProvider.get(s6.class);
        this.i = object = (c1)viewModelProvider.get(c1.class);
    }

    public void onDismiss(DialogInterface object) {
        super.onDismiss((DialogInterface)object);
        object = this.l;
        if (object != null) {
            m2.a((m2$d)object);
        }
    }

    public void onResume() {
        super.onResume();
        this.W();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.G();
        this.D();
        this.E();
        this.F();
    }

    public void p(int n10) {
        super.p(n10);
        n10 = (int)(this.m ? 1 : 0);
        if (n10 != 0) {
            this.W();
        }
    }

    public int s() {
        return 2131558515;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (j3)viewDataBinding;
        this.f = viewDataBinding;
        Object object = this.k;
        ((j3)viewDataBinding).F((BleDeviceViewModel)object);
        viewDataBinding = this.f;
        boolean bl2 = this.p;
        ((j3)viewDataBinding).E(bl2);
        viewDataBinding = this.f;
        bl2 = this.o;
        ((j3)viewDataBinding).C(bl2);
        viewDataBinding = this.f;
        object = new s$d(this);
        ((j3)viewDataBinding).D((s$d)object);
    }
}

