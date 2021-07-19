/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View
 *  android.view.Window
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.ImageButton
 */
package d.v.c.i1.s2;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.me.account.AccountActivity;
import com.zhiyun.cama.device.active.ActivationActivity;
import com.zhiyun.cama.device.connect.DeviceConnectActivity;
import com.zhiyun.cama.main.me.WebViewFragment;
import com.zhiyun.common.util.StatusBarUtil;
import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.device.connection.BleConnection$j;
import com.zhiyun.device.connection.BleDevice;
import com.zhiyun.device.data.local.entity.DeviceInfo;
import com.zhiyun.permission.Permission;
import com.zhiyun.protocol.constants.Model;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.c.i1.o2;
import d.v.c.i1.o2$b;
import d.v.c.i1.r2;
import d.v.c.i1.s2.c;
import d.v.c.i1.s2.d;
import d.v.c.i1.s2.e;
import d.v.c.i1.s2.f;
import d.v.c.i1.s2.g;
import d.v.c.i1.s2.h;
import d.v.c.i1.s2.i;
import d.v.c.i1.s2.j;
import d.v.c.i1.s2.k;
import d.v.c.i1.s2.l;
import d.v.c.i1.s2.m;
import d.v.c.i1.s2.n;
import d.v.c.i1.s2.o;
import d.v.c.i1.s2.p;
import d.v.c.i1.s2.r$a;
import d.v.c.i1.s2.r$b;
import d.v.c.i1.s2.r$c;
import d.v.c.i1.s2.s;
import d.v.c.v0.p.a;
import d.v.c.v0.u.z;
import d.v.c.w0.t9;
import d.v.c.z0.k$b;
import d.v.e.l.h2;
import d.v.e.l.m2;
import d.v.e.l.m2$b;
import d.v.e.l.m2$d;
import d.v.e0.ce;
import d.v.g.e.q;
import d.v.g.g.c1;
import d.v.g.g.e1;
import d.v.x.b;
import d.v.x.c$b;
import java.util.ArrayList;
import java.util.List;

public class r
extends d.v.f.h.a {
    private static final int n = 1;
    private static final int o = 2;
    private static final int p = 3;
    private final long b;
    private t9 c;
    private r2 d;
    private c1 e;
    private d.v.c.m1.c f;
    private List g;
    private BleConnection$j h;
    private s i;
    private m2$d j;
    private m2$d k;
    private WebViewFragment l;
    private d.v.c.z0.k m;

    public r() {
        ArrayList arrayList;
        this.b = 5000L;
        this.g = arrayList = new ArrayList();
    }

    private void A() {
        boolean bl2 = this.isAdded();
        if (bl2) {
            bl2 = BleConnection.W().e0() ^ true;
            o2$b o2$b = o2.a();
            o2$b o2$b2 = o2$b.b(bl2);
            d.v.c.x1.l.f(this, o2$b2);
        }
    }

    private void B() {
        Object object = Permission.LOCATION;
        c$b c$b = new c$b((Permission)((Object)object));
        object = new k(this);
        c$b = c$b.a((b)object);
        object = this.getChildFragmentManager();
        c$b.b((FragmentManager)object);
    }

    private void C() {
        MutableLiveData mutableLiveData = this.i.a;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new j(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.i.d;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new p(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.e.a;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new o(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.f.k();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new e(this);
        mutableLiveData.observe(lifecycleOwner, observer);
    }

    private boolean D(Stabilizer stabilizer) {
        boolean bl2;
        block1: {
            boolean bl3;
            Object object;
            Object object2 = d.v.g.f.b.e.a.B().A();
            bl2 = true;
            Object object3 = new Object[bl2];
            int n10 = object2.size();
            object3[0] = object = Integer.valueOf(n10);
            object = "list.size = %s";
            m.a.a.b((String)object, object3);
            object2 = object2.iterator();
            while (bl3 = object2.hasNext()) {
                object3 = (String)object2.next();
                object = stabilizer.F2();
                bl3 = ((String)object).equals(object3);
                if (!bl3) continue;
                break block1;
            }
            bl2 = false;
        }
        return bl2;
    }

    private boolean E() {
        Lifecycle$State lifecycle$State = this.getLifecycle().getCurrentState();
        Lifecycle$State lifecycle$State2 = Lifecycle$State.RESUMED;
        return lifecycle$State.isAtLeast(lifecycle$State2);
    }

    public static /* synthetic */ void F(r r10) {
        r10.k0();
    }

    public static /* synthetic */ void G(CompoundButton object, boolean bl2) {
        object = a.g();
        ((a)object).p(bl2 ^= true);
    }

    private /* synthetic */ void H(DialogFragment dialogFragment) {
        this.m0();
    }

    private /* synthetic */ void J(DialogFragment dialogFragment) {
        AccountActivity.h(this.getActivity());
    }

    private /* synthetic */ void L() {
        this.k = null;
        this.w();
    }

    private /* synthetic */ void N() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean bl2 = bluetoothAdapter.isEnabled();
        if (bl2) {
            Context context = this.getContext();
            Class<DeviceConnectActivity> clazz = DeviceConnectActivity.class;
            bluetoothAdapter = new Intent(context, clazz);
            int n10 = 2;
            this.startActivityForResult((Intent)bluetoothAdapter, n10);
        } else {
            String string2 = "android.bluetooth.adapter.action.REQUEST_ENABLE";
            bluetoothAdapter = new Intent(string2);
            int n11 = 1;
            this.startActivityForResult((Intent)bluetoothAdapter, n11);
        }
    }

    private /* synthetic */ void P(Integer n10) {
        int n11;
        int n12 = n10;
        if (n12 == (n11 = 1) || (n12 = n10.intValue()) == (n11 = 2)) {
            int n13 = n10;
            this.h0(n13);
        }
    }

    private /* synthetic */ void R(Boolean bl2) {
        ImageButton imageButton = this.c.f;
        boolean bl3 = bl2;
        imageButton.setSelected(bl3);
    }

    private /* synthetic */ void T(Boolean bl2) {
        boolean bl3;
        m2$d m2$d = this.k;
        if (m2$d != null && !(bl3 = m2$d.b())) {
            m2.a(this.k);
            bl3 = false;
            m2$d = null;
            this.k = null;
            boolean bl4 = bl2;
            if (!bl4) {
                this.w();
            } else {
                bl4 = true;
                e1.i(bl4);
            }
        }
    }

    private /* synthetic */ void V(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2 && (bl2 = ((d.v.a.f.c.b)(object = d.v.a.f.c.b.N())).s()) && (bl2 = this.E())) {
            object = d.v.c.m1.d.p.K();
            FragmentManager fragmentManager = this.getChildFragmentManager();
            ((d.v.f.g.b)object).q(fragmentManager);
            object = this.f;
            ((d.v.c.m1.c)object).y();
        }
    }

    private /* synthetic */ void X(int n10) {
        int n11 = this.E();
        if (n11 != 0 && n10 == (n11 = 2) && (n10 = (int)(ce.z1() ? 1 : 0)) != 0) {
            MutableLiveData mutableLiveData = this.i.d;
            Boolean bl2 = Boolean.TRUE;
            mutableLiveData.setValue(bl2);
        }
        this.i.d(0);
    }

    public static /* synthetic */ void Z(DialogFragment dialogFragment) {
        BleConnection.W().R();
    }

    private /* synthetic */ void a0(DialogFragment dialogFragment) {
        dialogFragment = new Intent("android.settings.WIFI_SETTINGS");
        this.startActivityForResult((Intent)dialogFragment, 3);
    }

    private /* synthetic */ void c0() {
        d.v.c.x1.l.d(this, 2131362093);
    }

    private void e0() {
        this.v();
        Object object = BleConnection.W();
        boolean bl2 = ((BleConnection)object).c0();
        if (bl2) {
            return;
        }
        this.i.c(null);
        object = this.i.d;
        Boolean bl3 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(bl3);
        object = this.d;
        bl2 = ((r2)object).f();
        if (!bl2) {
            return;
        }
        i i10 = new i(this);
        m2.X(1000L, this, i10);
    }

    private void f0() {
        Object object = new StringBuilder();
        Object object2 = z.m().g();
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("index");
        this.l = object = WebViewFragment.S(((StringBuilder)object).toString(), true, false, false);
        object = this.getChildFragmentManager().beginTransaction();
        object2 = this.l;
        ((FragmentTransaction)object).replace(2131362512, (Fragment)object2).commit();
    }

    private void g0() {
        Window window = this.requireActivity().getWindow();
        window.getDecorView().setSystemUiVisibility(0);
        int n10 = this.getResources().getColor(2131099772, null);
        StatusBarUtil.z(window, n10);
        StatusBarUtil.E(this.requireActivity().getWindow(), true);
    }

    private void h0(int n10) {
        m2$d m2$d;
        boolean bl2;
        m2$d m2$d2 = this.j;
        if (m2$d2 != null && !(bl2 = m2$d2.b())) {
            m2$d2 = this.j;
            m2.a(m2$d2);
        }
        g g10 = new g(this, n10);
        this.j = m2$d = m2.Y(2000L, g10);
    }

    private void i0() {
        Object object = new k$b();
        Object object2 = d.v.f.i.g.m(this.requireContext(), 2131952619);
        object = ((k$b)object).J((String)object2);
        object2 = d.v.f.i.g.m(this.requireContext(), 2131951947);
        object = ((k$b)object).y((String)object2);
        object2 = d.v.f.i.g.m(this.requireContext(), 2131951833);
        d.v.f.f.a a10 = d.v.c.i1.s2.h.a;
        object = ((k$b)object).D((String)object2, a10);
        object2 = d.v.f.i.g.m(this.requireContext(), 2131951991);
        a10 = new l(this);
        object = ((k$b)object).G((String)object2, a10);
        int n10 = h2.b(300.0f);
        object = ((k$b)object).O(n10).v();
        object2 = this.getChildFragmentManager();
        ((d.v.f.g.b)object).q((FragmentManager)object2);
    }

    public static /* synthetic */ List j(r r10) {
        return r10.g;
    }

    private void j0() {
        String string2;
        Object object;
        Object object2 = BleConnection.W().Y();
        if (object2 == null) {
            object2 = "";
        } else {
            object = new StringBuilder();
            string2 = "(";
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(")");
            object2 = ((StringBuilder)object).toString();
        }
        object = d.v.f.i.g.m(this.requireContext(), 2131952853);
        string2 = this.requireContext();
        Object[] objectArray = new Object[]{object, object2};
        object2 = d.v.f.i.g.n((Context)string2, 2131951948, objectArray);
        object = new k$b();
        string2 = d.v.f.i.g.m(this.requireContext(), 2131952619);
        object2 = ((k$b)object).J(string2).y((String)object2).D(null, null);
        string2 = d.v.f.i.g.m(this.requireContext(), 2131952621);
        object2 = ((k$b)object2).G(string2, null);
        int n10 = h2.b(300.0f);
        object2 = ((k$b)object2).O(n10).v();
        object = this.getChildFragmentManager();
        ((d.v.f.g.b)object2).q((FragmentManager)object);
    }

    public static /* synthetic */ void k(r r10) {
        r10.B();
    }

    private void k0() {
        String string2;
        Object object = this.requireContext();
        int n10 = ContextCompat.checkSelfPermission((Context)object, string2 = "android.permission.ACCESS_COARSE_LOCATION");
        if (n10 != 0) {
            return;
        }
        this.d.l(false);
        this.g.clear();
        object = q.b();
        r$a r$a = new r$a(this);
        ((q)object).c(5000L, r$a);
    }

    public static /* synthetic */ WebViewFragment l(r r10) {
        return r10.l;
    }

    private void l0() {
        ActivationActivity.i(this.getContext());
    }

    public static /* synthetic */ c1 m(r r10) {
        return r10.e;
    }

    private void m0() {
        Object object = Permission.CAMERA_GROUP;
        c$b c$b = new c$b((Permission)((Object)object));
        object = new d(this);
        c$b = c$b.a((b)object);
        object = this.getChildFragmentManager();
        c$b.b((FragmentManager)object);
    }

    public static /* synthetic */ List n(r r10, List list) {
        return r10.x(list);
    }

    public static /* synthetic */ s o(r r10) {
        return r10.i;
    }

    public static /* synthetic */ void p(r r10, int n10) {
        r10.h0(n10);
    }

    public static /* synthetic */ void q(r r10) {
        r10.l0();
    }

    public static /* synthetic */ void r(r r10) {
        r10.A();
    }

    public static /* synthetic */ void s(r r10) {
        r10.i0();
    }

    public static /* synthetic */ void t(r r10) {
        r10.j0();
    }

    public static /* synthetic */ void u(r r10) {
        r10.z();
    }

    private void v() {
        Object object = new r$b(this);
        this.h = object;
        object = BleConnection.W();
        BleConnection$j bleConnection$j = this.h;
        ((BleConnection)object).J(bleConnection$j);
    }

    private void w() {
        boolean bl2;
        Object object = this.i.c.getValue();
        if ((object == null || (bl2 = ((Boolean)(object = (Boolean)this.i.c.getValue())).booleanValue())) && (bl2 = this.E())) {
            Object object2;
            object = ce.E0().a1().H2();
            if (object == (object2 = Model.SMOOTHXS) && (bl2 = ((a)(object = a.g())).i())) {
                object = d.v.a.f.c.b.N();
                bl2 = ((d.v.a.f.c.b)object).s();
                if (!bl2) {
                    object = this.y();
                    object2 = this.getChildFragmentManager();
                    ((d.v.f.g.b)object).q((FragmentManager)object2);
                } else {
                    this.m0();
                }
            } else {
                this.m0();
            }
        }
    }

    private List x(List object) {
        boolean bl2;
        ArrayList<BleDevice> arrayList = new ArrayList<BleDevice>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            BleDevice bleDevice = (BleDevice)object.next();
            Stabilizer stabilizer = bleDevice.a;
            boolean bl3 = this.D(stabilizer);
            if (!bl3) continue;
            arrayList.add(bleDevice);
        }
        return arrayList;
    }

    private d.v.c.z0.k y() {
        Object object = this.m;
        if (object == null) {
            object = new k$b();
            String string2 = d.v.f.i.g.m(this.requireContext(), 2131951989);
            object = ((k$b)object).J(string2);
            string2 = d.v.f.i.g.m(this.requireContext(), 2131951990);
            Object object2 = new m(this);
            object = ((k$b)object).D(string2, (d.v.f.f.a)object2);
            string2 = d.v.f.i.g.m(this.requireContext(), 2131952534);
            n n10 = new n(this);
            object = ((k$b)object).H(string2, false, n10);
            string2 = this.requireContext();
            int n11 = 2131952000;
            string2 = d.v.f.i.g.m((Context)string2, n11);
            object2 = d.v.c.i1.s2.f.a;
            this.m = object = ((k$b)object).w(string2, (CompoundButton.OnCheckedChangeListener)object2).v();
        }
        return this.m;
    }

    private void z() {
        Object object = BleConnection.W();
        boolean bl2 = ((BleConnection)object).f0();
        if (bl2) {
            bl2 = z.m().B();
            c1 c12 = this.e;
            Object object2 = BleConnection.W().T();
            c12.M((Stabilizer)object2, bl2);
            object = BleConnection.W();
            c12 = null;
            ((BleConnection)object).a1(false);
            long l10 = 1000L;
            object2 = new c(this);
            this.k = object = m2.X(l10, this, (m2$b)object2);
        } else {
            this.w();
        }
    }

    public /* synthetic */ void I(DialogFragment dialogFragment) {
        this.H(dialogFragment);
    }

    public /* synthetic */ void K(DialogFragment dialogFragment) {
        this.J(dialogFragment);
    }

    public /* synthetic */ void M() {
        this.L();
    }

    public /* synthetic */ void O() {
        this.N();
    }

    public /* synthetic */ void Q(Integer n10) {
        this.P(n10);
    }

    public /* synthetic */ void S(Boolean bl2) {
        this.R(bl2);
    }

    public /* synthetic */ void U(Boolean bl2) {
        this.T(bl2);
    }

    public /* synthetic */ void W(Boolean bl2) {
        this.V(bl2);
    }

    public /* synthetic */ void Y(int n10) {
        this.X(n10);
    }

    public /* synthetic */ void b0(DialogFragment dialogFragment) {
        this.a0(dialogFragment);
    }

    public /* synthetic */ void d0() {
        this.c0();
    }

    public int h() {
        return 2131558615;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (t9)viewDataBinding;
        this.c = viewDataBinding;
        Object object = this.i;
        ((t9)viewDataBinding).D((s)object);
        viewDataBinding = this.c;
        object = this.e;
        ((t9)viewDataBinding).C((c1)object);
        viewDataBinding = this.c;
        object = new r$c(this, null);
        ((t9)viewDataBinding).B((r$c)object);
    }

    public void onActivityCreated(Bundle object) {
        super.onActivityCreated((Bundle)object);
        object = (Boolean)this.d.c().getValue();
        boolean bl2 = d.v.e.h.a.c((Boolean)object);
        if (bl2) {
            this.g0();
        }
    }

    public void onActivityResult(int n10, int n11, Intent object) {
        super.onActivityResult(n10, n11, (Intent)object);
        int n12 = 1;
        int n13 = 2;
        if (n10 != n12) {
            int n14 = 3;
            if (n10 != n13) {
                if (n10 == n14) {
                    Object object2 = BleConnection.W();
                    n10 = (int)(((BleConnection)object2).c0() ? 1 : 0);
                    if (n10 != 0) {
                        object2 = BleConnection.W();
                        ((BleConnection)object2).M();
                    } else {
                        object2 = this.i;
                        n11 = 0;
                        ((s)object2).c(null);
                        object2 = this.i.d;
                        Boolean bl2 = Boolean.FALSE;
                        ((MutableLiveData)object2).setValue(bl2);
                    }
                }
            } else if (n11 != n12) {
                if (n11 != n13) {
                    if (n11 != n14) {
                        n10 = 5;
                        if (n11 == n10) {
                            this.m0();
                        }
                    } else {
                        this.l0();
                    }
                } else {
                    this.A();
                }
            } else {
                this.z();
            }
        } else {
            Context context = this.getContext();
            object = DeviceConnectActivity.class;
            Intent intent = new Intent(context, (Class)object);
            this.startActivityForResult(intent, n13);
        }
    }

    public void onAttach(Context object) {
        ViewModel viewModel;
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        this.d = viewModel = (r2)((ViewModelProvider)object).get(r2.class);
        viewModel = (s)d.v.i0.b.a(this).get(s.class);
        this.i = viewModel;
        viewModel = (c1)((ViewModelProvider)object).get(c1.class);
        this.e = viewModel;
        this.f = object = (d.v.c.m1.c)((ViewModelProvider)object).get(d.v.c.m1.c.class);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onPause() {
        this.d.k(false);
        q.b().d();
        super.onPause();
    }

    public void onResume() {
        boolean bl2;
        Object object;
        super.onResume();
        Object object2 = this.d;
        boolean bl3 = true;
        ((r2)object2).k(bl3);
        object2 = d.v.a.f.c.b.N().i();
        if (object2 != null && ((bl3 = ((d.v.a.f.c.b)(object = d.v.a.f.c.b.N())).s()) || (bl3 = ((d.v.a.f.c.b)(object = d.v.a.f.c.b.N())).j()))) {
            object = this.f;
            object2 = ((UserInfo)object2).getToken();
            ((d.v.c.m1.c)object).w((String)object2);
        }
        if (!(bl2 = ((d.v.a.f.c.b)(object2 = d.v.a.f.c.b.N())).D())) {
            object2 = this.f;
            ((d.v.c.m1.c)object2).u();
        }
        if ((bl2 = ((d.v.a.f.c.b)(object2 = d.v.a.f.c.b.N())).s()) && (bl2 = ((Fragment)(object2 = this.y())).isVisible())) {
            object2 = this.y();
            ((DialogFragment)object2).dismiss();
        }
        this.g0();
    }

    public void onStart() {
        super.onStart();
        boolean bl2 = e1.e();
        Object object = null;
        if (bl2) {
            e1.a(false);
            Object object2 = this.e.b.getValue();
            if (object2 != null) {
                object2 = (DeviceInfo)((Pair)this.e.b.getValue()).first;
                object = BleConnection.W().T();
                if (object != null && !(bl2 = ((String)(object = ((Stabilizer)object).G2())).equals(object2 = ((DeviceInfo)object2).getDeviceSn()))) {
                    object2 = this.e.b;
                    object = null;
                    ((MutableLiveData)object2).setValue(null);
                }
            }
            this.A();
            return;
        }
        BleConnection bleConnection = BleConnection.W();
        bl2 = bleConnection.f0();
        if (bl2) {
            bl2 = z.m().B();
            c1 c12 = this.e;
            Stabilizer stabilizer = BleConnection.W().T();
            c12.M(stabilizer, bl2);
            bleConnection = BleConnection.W();
            bleConnection.a1(false);
        }
        this.e0();
    }

    public void onStop() {
        super.onStop();
        Object object = BleConnection.W();
        BleConnection$j bleConnection$j = this.h;
        ((BleConnection)object).N0(bleConnection$j);
        object = this.j;
        if (object != null) {
            m2.a((m2$d)object);
        }
        this.i.d(0);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f0();
        this.C();
    }
}

