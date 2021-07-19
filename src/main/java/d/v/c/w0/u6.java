/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.widget.FrameLayout
 *  android.widget.HorizontalScrollView
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.main.EditorMainFragment$g;
import com.zhiyun.cama.widget.EditorAudioBeatBar;
import com.zhiyun.cama.widget.EditorHorizontalScrollView;
import com.zhiyun.cama.widget.EditorRuler;
import com.zhiyun.cama.widget.EditorStickerBar;
import com.zhiyun.cama.widget.EditorTextBar;
import com.zhiyun.cama.widget.EditorThumbnail;
import com.zhiyun.cama.widget.EditorThumbnail$b;
import com.zhiyun.cama.widget.EditorVoiceBar;
import com.zhiyun.cama.widget.ScrollRecyclerViewImpl;
import d.v.c.b2.p;
import d.v.c.b2.p$b;
import d.v.c.b2.w.e;
import d.v.c.b2.w.i;
import d.v.c.b2.w.k;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.f1.a.d;
import d.v.c.f1.a.d$a;
import d.v.c.f1.a.f;
import d.v.c.f1.a.f$a;
import d.v.c.f1.a.o$a;
import d.v.c.f1.a.q;
import d.v.c.f1.a.q$a;
import d.v.c.i1.h2;
import d.v.c.i1.i2;
import d.v.c.w0.p4;
import d.v.c.w0.r4;
import d.v.c.w0.t4;
import d.v.c.w0.t6;
import d.v.c.w0.u6$a;
import d.v.c.w0.u6$b;
import d.v.c.w0.u6$c;
import d.v.c.w0.u6$d;
import d.v.c.w0.v4;
import d.v.e.i.j;
import d.v.f.e.c;
import java.util.List;

public class u6
extends t6
implements o$a,
f$a,
d$a,
b$a,
q$a {
    private static final ViewDataBinding$IncludedLayouts X0;
    private static final SparseIntArray Y0;
    private final d.v.f.f.d A0;
    private final ImageButton B;
    private final d.v.f.f.d B0;
    private final ImageButton C;
    private final d.v.c.b2.x.c C0;
    private final ImageButton D;
    private final View.OnClickListener D0;
    private final ImageButton E;
    private final d.v.f.f.d E0;
    private final View F;
    private final d.v.f.f.d F0;
    private final TextView G;
    private final d.v.c.b2.x.c G0;
    private final TextView H;
    private final d.v.f.f.d H0;
    private final TextView I;
    private final d.v.f.f.d I0;
    private final View J;
    private final d.v.f.f.d J0;
    private final TextView K;
    private final d.v.f.f.d K0;
    private final TextView L;
    private final EditorThumbnail$b L0;
    private final TextView M;
    private final d.v.f.f.d M0;
    private final TextView N;
    private final d.v.f.f.d N0;
    private final TextView O;
    private e O0;
    private final TextView P;
    private e P0;
    private final TextView Q;
    private e Q0;
    private final ConstraintLayout R;
    private e R0;
    private final LinearLayout S;
    private InverseBindingListener S0;
    private final TextView T;
    private InverseBindingListener T0;
    private final LinearLayout U;
    private InverseBindingListener U0;
    private final TextView V;
    private InverseBindingListener V0;
    private final TextView W;
    private long W0;
    private final TextView X;
    private final TextView Y;
    private final LinearLayout Z;
    private final EditorVoiceBar k0;
    private final TextView o0;
    private final EditorAudioBeatBar p0;
    private final EditorTextBar q0;
    private final EditorStickerBar r0;
    private final EditorRuler s0;
    private final View.OnTouchListener t0;
    private final d.v.f.f.d u0;
    private final d.v.f.f.d v0;
    private final d.v.f.f.d w0;
    private final d.v.c.b2.x.c x0;
    private final d.v.f.f.d y0;
    private final d.v.c.b2.x.c z0;

    static {
        int[] nArray;
        int[] nArray2;
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        X0 = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(55);
        String[] stringArray = new String[]{"editor_home_music_pop_layout", "editor_home_record_pop_layout", "editor_home_text_pop_layout", "editor_home_sticker_pop_layout"};
        int n10 = 4;
        int[] nArray3 = nArray2 = new int[n10];
        int[] nArray4 = nArray2;
        nArray3[0] = 41;
        nArray4[1] = 42;
        nArray3[2] = 43;
        nArray4[3] = 44;
        int[] nArray5 = nArray = new int[n10];
        int[] nArray6 = nArray;
        nArray5[0] = 2131558532;
        nArray6[1] = 2131558533;
        nArray5[2] = 2131558535;
        nArray6[3] = 2131558534;
        viewDataBinding$IncludedLayouts.setIncludes(1, stringArray, nArray2, nArray);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        Y0 = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131362322, 45);
        viewDataBinding$IncludedLayouts.put(2131362351, 46);
        viewDataBinding$IncludedLayouts.put(2131362500, 47);
        viewDataBinding$IncludedLayouts.put(2131362352, 48);
        viewDataBinding$IncludedLayouts.put(2131362320, 49);
        viewDataBinding$IncludedLayouts.put(2131362350, 50);
        viewDataBinding$IncludedLayouts.put(2131362347, 51);
        viewDataBinding$IncludedLayouts.put(2131362321, 52);
        viewDataBinding$IncludedLayouts.put(2131362570, 53);
        viewDataBinding$IncludedLayouts.put(2131362820, 54);
    }

    public u6(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = X0;
        SparseIntArray sparseIntArray = Y0;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 55, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private u6(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        u6 u62 = this;
        Object object = this;
        Object object2 = view;
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView)objectArray[15];
        TextView textView = (TextView)objectArray[16];
        TextView textView2 = (TextView)objectArray[20];
        LinearLayout linearLayout = (LinearLayout)objectArray[49];
        ImageView imageView = (ImageView)objectArray[52];
        FrameLayout frameLayout = (FrameLayout)objectArray[45];
        Object object3 = (LinearLayout)objectArray[51];
        ConstraintLayout constraintLayout = (ConstraintLayout)((Object)objectArray[1]);
        Object object4 = (LinearLayout)objectArray[3];
        View view2 = (View)objectArray[50];
        Object object5 = (ScrollRecyclerViewImpl)objectArray[46];
        Object object6 = (EditorHorizontalScrollView)((Object)objectArray[48]);
        Object object7 = (EditorThumbnail)objectArray[8];
        FrameLayout frameLayout2 = (FrameLayout)objectArray[0];
        FrameLayout frameLayout3 = (FrameLayout)objectArray[47];
        FrameLayout frameLayout4 = (FrameLayout)objectArray[53];
        LinearLayout linearLayout2 = (LinearLayout)objectArray[54];
        p4 p42 = (p4)objectArray[41];
        r4 r42 = (r4)objectArray[42];
        t4 t42 = (t4)objectArray[44];
        v4 v42 = (v4)objectArray[43];
        TextView textView3 = (TextView)objectArray[30];
        TextView textView4 = (TextView)objectArray[29];
        TextView textView5 = (TextView)objectArray[31];
        int n10 = 21;
        super(dataBindingComponent, view, n10, horizontalScrollView, textView, textView2, linearLayout, imageView, frameLayout, (LinearLayout)object3, constraintLayout, (LinearLayout)object4, view2, (ScrollRecyclerViewImpl)object5, (EditorHorizontalScrollView)((Object)object6), (EditorThumbnail)object7, frameLayout2, frameLayout3, frameLayout4, linearLayout2, p42, r42, t42, v42, textView3, textView4, textView5);
        this.S0 = object = new u6$a(this);
        this.T0 = object = new u6$b(this);
        this.U0 = object = new u6$c(this);
        this.V0 = object = new u6$d(this);
        this.W0 = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        int n11 = 10;
        u62 = (ImageButton)objectArray[n11];
        this.B = u62;
        u62.setTag(null);
        n10 = 11;
        horizontalScrollView = (ImageButton)objectArray[n10];
        this.C = horizontalScrollView;
        horizontalScrollView.setTag(null);
        int n12 = 12;
        textView = (ImageButton)objectArray[n12];
        this.D = textView;
        textView.setTag(null);
        int n13 = 13;
        textView2 = (ImageButton)objectArray[n13];
        this.E = textView2;
        textView2.setTag(null);
        int n14 = 14;
        linearLayout = (View)objectArray[n14];
        this.F = linearLayout;
        linearLayout.setTag(null);
        int n15 = 17;
        imageView = (TextView)objectArray[n15];
        this.G = imageView;
        imageView.setTag(null);
        int n16 = 18;
        frameLayout = (TextView)objectArray[n16];
        this.H = frameLayout;
        frameLayout.setTag(null);
        int n17 = 19;
        object3 = (TextView)objectArray[n17];
        this.I = object3;
        object3.setTag(null);
        constraintLayout = (View)objectArray[2];
        this.J = constraintLayout;
        constraintLayout.setTag(null);
        int n18 = 21;
        object4 = (TextView)objectArray[n18];
        this.K = object4;
        object4.setTag(null);
        object4 = (TextView)objectArray[22];
        this.L = object4;
        object4.setTag(null);
        object4 = (TextView)objectArray[23];
        this.M = object4;
        object4.setTag(null);
        object4 = (TextView)objectArray[24];
        this.N = object4;
        object4.setTag(null);
        object4 = (TextView)objectArray[25];
        this.O = object4;
        object4.setTag(null);
        object4 = (TextView)objectArray[26];
        this.P = object4;
        object4.setTag(null);
        object4 = (TextView)objectArray[27];
        this.Q = object4;
        object4.setTag(null);
        object4 = (ConstraintLayout)((Object)objectArray[28]);
        this.R = object4;
        object4.setTag(null);
        this.S = object4 = (LinearLayout)objectArray[32];
        object4.setTag(null);
        object4 = (TextView)objectArray[33];
        this.T = object4;
        object4.setTag(null);
        this.U = object4 = (LinearLayout)objectArray[34];
        object4.setTag(null);
        object4 = (TextView)objectArray[35];
        this.V = object4;
        object4.setTag(null);
        object4 = (TextView)objectArray[36];
        this.W = object4;
        object4.setTag(null);
        object4 = (TextView)objectArray[37];
        this.X = object4;
        object4.setTag(null);
        object4 = (TextView)objectArray[38];
        this.Y = object4;
        object4.setTag(null);
        this.Z = object4 = (LinearLayout)objectArray[39];
        object4.setTag(null);
        int n19 = 4;
        view2 = (EditorVoiceBar)objectArray[n19];
        this.k0 = view2;
        view2.setTag(null);
        view2 = (TextView)objectArray[40];
        this.o0 = view2;
        view2.setTag(null);
        int n20 = 5;
        this.p0 = object5 = (EditorAudioBeatBar)objectArray[n20];
        object5.setTag(null);
        int n21 = 6;
        object6 = (EditorTextBar)objectArray[n21];
        this.q0 = object6;
        object6.setTag(null);
        object7 = objectArray[7];
        object3 = object7;
        object3 = (EditorStickerBar)object7;
        this.r0 = object3;
        object3.setTag(null);
        int n22 = 9;
        object7 = objectArray[n22];
        object6 = object7;
        object6 = (EditorRuler)object7;
        this.s0 = object6;
        object6.setTag(null);
        object6 = this.r;
        this.setContainedBinding((ViewDataBinding)object6);
        object6 = this.s;
        this.setContainedBinding((ViewDataBinding)object6);
        object6 = this.t;
        this.setContainedBinding((ViewDataBinding)object6);
        object6 = this.u;
        this.setContainedBinding((ViewDataBinding)object6);
        this.v.setTag(null);
        this.w.setTag(null);
        this.x.setTag(null);
        this.setRootTag(view);
        super(this, n12);
        this.t0 = object2;
        super(this, n13);
        this.u0 = object2;
        super(this, n15);
        this.v0 = object2;
        super(this, n11);
        this.w0 = object2;
        this.x0 = object = new d(this, n20);
        this.y0 = object = new f(this, n10);
        this.z0 = object = new d(this, n21);
        this.A0 = object = new f(this, 8);
        this.B0 = object = new f(this, 20);
        this.C0 = object = new d(this, 3);
        object = new b(this, 16);
        this.D0 = object;
        this.E0 = object = new f(this, n18);
        this.F0 = object = new f(this, n22);
        this.G0 = object = new d(this, n19);
        this.H0 = object = new f(this, n16);
        this.I0 = object = new f(this, 1);
        this.J0 = object = new f(this, n14);
        this.K0 = object = new f(this, n17);
        this.L0 = object = new q(this, 7);
        this.M0 = object = new f(this, 2);
        this.N0 = object = new f(this, 15);
        this.invalidateAll();
    }

    public static /* synthetic */ EditorVoiceBar E(u6 u62) {
        return u62.k0;
    }

    public static /* synthetic */ EditorTextBar F(u6 u62) {
        return u62.q0;
    }

    public static /* synthetic */ EditorStickerBar G(u6 u62) {
        return u62.r0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean H(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 512L;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean I(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 1L;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean J(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 1024L;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean K(MediatorLiveData mediatorLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 16384L;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean L(MediatorLiveData mediatorLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 2;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean M(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 4096L;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean N(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 262144L;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean O(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 524288L;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean P(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 32;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean Q(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 4;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean R(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 0x100000L;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean S(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 65536L;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean T(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 8;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean U(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 64;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean V(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 8192L;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean W(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 256L;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean X(p4 p42, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 32768L;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean Y(r4 r42, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 2048L;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean Z(t4 t42, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 131072L;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a0(v4 v42, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 128L;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean b0(j j10, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.W0;
                long l11 = 16;
                this.W0 = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(EditorMainFragment$g editorMainFragment$g) {
        this.z = editorMainFragment$g;
        synchronized (this) {
            long l10 = this.W0;
            long l11 = 0x200000L;
            this.W0 = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(h2 h22) {
        this.A = h22;
        synchronized (this) {
            long l10 = this.W0;
            long l11 = 0x400000L;
            this.W0 = l10 |= l11;
        }
        this.notifyPropertyChanged(48);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(i2 i22) {
        this.y = i22;
        synchronized (this) {
            long l10 = this.W0;
            long l11 = 0x800000L;
            this.W0 = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        EditorMainFragment$g editorMainFragment$g = this.z;
        boolean bl2 = editorMainFragment$g != null;
        if (bl2) {
            editorMainFragment$g.s();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block175: {
            block174: {
                block173: {
                    block172: {
                        block152: {
                            block171: {
                                block170: {
                                    block169: {
                                        block168: {
                                            block167: {
                                                block166: {
                                                    block165: {
                                                        block164: {
                                                            block162: {
                                                                block163: {
                                                                    block161: {
                                                                        block160: {
                                                                            block159: {
                                                                                block158: {
                                                                                    block157: {
                                                                                        block156: {
                                                                                            block155: {
                                                                                                block154: {
                                                                                                    block153: {
                                                                                                        var1_1 = this;
                                                                                                        synchronized (this) {
                                                                                                            var2_2 = this.W0;
                                                                                                            this.W0 = var4_3 = 0L;
                                                                                                        }
                                                                                                        var6_4 = this.z;
                                                                                                        var7_5 = this.A;
                                                                                                        var8_6 = this.y;
                                                                                                        var9_7 = 0x1200000L;
                                                                                                        var11_8 = var2_2 & var9_7;
                                                                                                        var13_9 = var11_8 == var4_3 ? 0 : (var11_8 < var4_3 ? -1 : 1);
                                                                                                        var14_10 = 6;
                                                                                                        var15_11 = 9;
                                                                                                        var16_12 = 10;
                                                                                                        var17_13 = 8;
                                                                                                        var18_14 = 1.1E-44f;
                                                                                                        var19_15 = 2;
                                                                                                        var20_16 = 1;
                                                                                                        var21_17 = 4;
                                                                                                        var22_18 = 0;
                                                                                                        var23_19 = null;
                                                                                                        var24_20 = 0;
                                                                                                        var25_21 = null;
                                                                                                        if (var13_9 != false && var6_4 != null) {
                                                                                                            var26_22 = var6_4.B();
                                                                                                            var27_23 = var6_4.p();
                                                                                                            var28_24 = 7;
                                                                                                            var29_26 = var6_4.h0(var28_24);
                                                                                                            var30_27 = var6_4.h0(0);
                                                                                                            var31_28 = var6_4.h0(var16_12);
                                                                                                            var32_29 = var6_4.h0(var15_11);
                                                                                                            var33_30 = var6_4.h0(var19_15);
                                                                                                            var34_31 = var6_4.z();
                                                                                                            var35_32 = var6_4.h0(var21_17);
                                                                                                            var36_33 = var6_4.h0(var17_13);
                                                                                                            var37_34 = var6_4.h0(var14_10);
                                                                                                            var21_17 = 11;
                                                                                                            var38_35 /* !! */  = var6_4.h0(var21_17);
                                                                                                            var39_36 = var6_4.o();
                                                                                                            var40_37 = var6_4.h0(var20_16);
                                                                                                            var41_38 = var6_4.A();
                                                                                                            var16_12 = 3;
                                                                                                            var42_39 = var6_4.h0(var16_12);
                                                                                                            var43_40 = var6_4.C();
                                                                                                            var44_41 = var6_4.n();
                                                                                                            var15_11 = 5;
                                                                                                            var45_42 = var6_4.h0(var15_11);
                                                                                                            var46_43 = var27_23;
                                                                                                            var47_44 = var30_27;
                                                                                                            var48_45 = var31_28;
                                                                                                            var49_46 = var32_29;
                                                                                                            var50_47 = var33_30;
                                                                                                            var51_48 = var34_31;
                                                                                                            var52_49 = var35_32;
                                                                                                            var53_50 = var36_33;
                                                                                                            var54_51 = var37_34;
                                                                                                            var55_52 = var39_36;
                                                                                                            var56_53 = var40_37;
                                                                                                            var57_54 = var41_38;
                                                                                                            var58_55 = var42_39;
                                                                                                            var59_56 = var44_41;
                                                                                                            var60_57 = var45_42;
                                                                                                        } else {
                                                                                                            var21_17 = 0;
                                                                                                            var38_35 /* !! */  = null;
                                                                                                            var13_9 = 0;
                                                                                                            var26_22 = null;
                                                                                                            var28_25 = false;
                                                                                                            var29_26 = null;
                                                                                                            var15_11 = 0;
                                                                                                            var46_43 = null;
                                                                                                            var16_12 = 0;
                                                                                                            var43_40 = null;
                                                                                                            var47_44 = null;
                                                                                                            var48_45 = null;
                                                                                                            var49_46 = null;
                                                                                                            var50_47 = null;
                                                                                                            var51_48 = null;
                                                                                                            var52_49 = null;
                                                                                                            var53_50 = null;
                                                                                                            var54_51 = null;
                                                                                                            var55_52 = null;
                                                                                                            var56_53 = null;
                                                                                                            var57_54 = null;
                                                                                                            var58_55 = null;
                                                                                                            var59_56 = null;
                                                                                                            var60_57 = null;
                                                                                                        }
                                                                                                        var61_58 = var2_2 & 31291263L;
                                                                                                        var63_59 = 0L;
                                                                                                        var65_60 /* !! */  = var61_58 == var63_59 ? 0 : (var61_58 < var63_59 ? -1 : 1);
                                                                                                        var61_58 = 20971522L;
                                                                                                        var66_61 = 0x80000000L;
                                                                                                        var68_62 = 0x1400001L;
                                                                                                        var70_63 = 20979712L;
                                                                                                        var72_64 = 21495808L;
                                                                                                        var74_65 = 0x1400004L;
                                                                                                        var76_66 = 21504004L;
                                                                                                        if (var65_60 /* !! */  == false) break block152;
                                                                                                        var78_67 = var2_2 & var68_62;
                                                                                                        cfr_temp_0 = var78_67 - var63_59;
                                                                                                        var65_60 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                                                                                        if (var65_60 /* !! */  != false) {
                                                                                                            if (var7_5 != null) {
                                                                                                                var80_68 = var27_23 = var7_5.z();
                                                                                                            } else {
                                                                                                                var17_13 = 0;
                                                                                                                var80_68 = null;
                                                                                                                var18_14 = 0.0f;
                                                                                                            }
                                                                                                            var1_1.updateLiveDataRegistration(0, (LiveData)var80_68);
                                                                                                            if (var80_68 != null) {
                                                                                                                var80_68 = (Boolean)var80_68.getValue();
                                                                                                            } else {
                                                                                                                var17_13 = 0;
                                                                                                                var80_68 = null;
                                                                                                                var18_14 = 0.0f;
                                                                                                            }
                                                                                                            var17_13 = (int)ViewDataBinding.safeUnbox((Boolean)var80_68);
                                                                                                        } else {
                                                                                                            var17_13 = 0;
                                                                                                            var80_68 = null;
                                                                                                            var18_14 = 0.0f;
                                                                                                        }
                                                                                                        var78_67 = var2_2 & var61_58;
                                                                                                        var63_59 = 0L;
                                                                                                        var81_69 = var78_67 == var63_59 ? 0 : (var78_67 < var63_59 ? -1 : 1);
                                                                                                        if (var81_69 != false) {
                                                                                                            if (var7_5 != null) {
                                                                                                                var23_19 = var41_38 = var7_5.K();
                                                                                                            } else {
                                                                                                                var22_18 = 0;
                                                                                                                var23_19 = null;
                                                                                                            }
                                                                                                            var1_1.updateLiveDataRegistration(var20_16, (LiveData)var23_19);
                                                                                                            if (var23_19 != null) {
                                                                                                                var23_19 = (Boolean)var23_19.getValue();
                                                                                                            } else {
                                                                                                                var22_18 = 0;
                                                                                                                var23_19 = null;
                                                                                                            }
                                                                                                            var22_18 = ViewDataBinding.safeUnbox((Boolean)var23_19);
                                                                                                        } else {
                                                                                                            var22_18 = 0;
                                                                                                            var23_19 = null;
                                                                                                        }
                                                                                                        var78_67 = var2_2 & var74_65;
                                                                                                        var63_59 = 0L;
                                                                                                        var82_70 = var78_67 == var63_59 ? 0 : (var78_67 < var63_59 ? -1 : 1);
                                                                                                        if (var82_70 != false) {
                                                                                                            if (var7_5 != null) {
                                                                                                                var83_71 = var7_5.k0();
                                                                                                                var84_72 = var83_71;
                                                                                                            } else {
                                                                                                                var20_16 = 0;
                                                                                                                var84_72 = null;
                                                                                                            }
                                                                                                            var1_1.updateLiveDataRegistration(var19_15, (LiveData)var84_72);
                                                                                                            var85_73 = var84_72 != null ? (e)var84_72.getValue() : null;
                                                                                                            var86_74 = var85_73 != null ? var85_73.d() : false;
                                                                                                            if (var82_70 != false) {
                                                                                                                var87_75 = var86_74 != false ? 0x4000000000L : 0x2000000000L;
                                                                                                                var2_2 |= var87_75;
                                                                                                            }
                                                                                                            if (var86_74) {
                                                                                                                var82_70 = 0;
                                                                                                                var89_76 = 0.0f;
                                                                                                                var45_42 = null;
                                                                                                            } else {
                                                                                                                var82_70 = 4;
                                                                                                                var89_77 = 5.6E-45f;
                                                                                                            }
                                                                                                        } else {
                                                                                                            var20_16 = 0;
                                                                                                            var84_72 = null;
                                                                                                            var85_73 = null;
                                                                                                            var82_70 = 0;
                                                                                                            var89_78 = 0.0f;
                                                                                                            var45_42 = null;
                                                                                                            var86_74 = false;
                                                                                                        }
                                                                                                        var87_75 = var2_2 & 20971528L;
                                                                                                        var63_59 = 0L;
                                                                                                        var90_80 = var87_75 == var63_59 ? 0 : (var87_75 < var63_59 ? -1 : 1);
                                                                                                        if (var90_80 == false) ** GOTO lbl-1000
                                                                                                        if (var7_5 != null) {
                                                                                                            var91_81 = var7_5.v0();
                                                                                                            var92_82 = var91_81;
                                                                                                        } else {
                                                                                                            var19_15 = 0;
                                                                                                            var92_82 = null;
                                                                                                        }
                                                                                                        var14_10 = 3;
                                                                                                        var1_1.updateLiveDataRegistration(var14_10, (LiveData)var92_82);
                                                                                                        if (var92_82 != null) {
                                                                                                            var92_82 = (e)var92_82.getValue();
                                                                                                        } else lbl-1000:
                                                                                                        // 2 sources

                                                                                                        {
                                                                                                            var19_15 = 0;
                                                                                                            var92_82 = null;
                                                                                                        }
                                                                                                        var93_83 = var2_2 & 20971552L;
                                                                                                        var63_59 = 0L;
                                                                                                        var14_10 = (int)(var93_83 == var63_59 ? 0 : (var93_83 < var63_59 ? -1 : 1));
                                                                                                        if (var14_10 == 0) break block153;
                                                                                                        if (var7_5 != null) {
                                                                                                            var95_84 = var7_5.h0();
                                                                                                            var96_85 = var84_72;
                                                                                                        } else {
                                                                                                            var96_85 = var84_72;
                                                                                                            var14_10 = 0;
                                                                                                            var95_84 = null;
                                                                                                        }
                                                                                                        var20_16 = 5;
                                                                                                        var1_1.updateLiveDataRegistration(var20_16, (LiveData)var95_84);
                                                                                                        if (var95_84 == null) break block154;
                                                                                                        var84_72 = (List)var95_84.getValue();
                                                                                                        break block155;
                                                                                                    }
                                                                                                    var96_85 = var84_72;
                                                                                                }
                                                                                                var20_16 = 0;
                                                                                                var84_72 = null;
                                                                                            }
                                                                                            var93_83 = var2_2 & 0x1400040L;
                                                                                            var63_59 = 0L;
                                                                                            var14_10 = (int)(var93_83 == var63_59 ? 0 : (var93_83 < var63_59 ? -1 : 1));
                                                                                            if (var14_10 == 0) break block156;
                                                                                            if (var7_5 != null) {
                                                                                                var95_84 = var7_5.z0();
                                                                                                var97_86 = var84_72;
                                                                                            } else {
                                                                                                var97_86 = var84_72;
                                                                                                var14_10 = 0;
                                                                                                var95_84 = null;
                                                                                            }
                                                                                            var20_16 = 6;
                                                                                            var1_1.updateLiveDataRegistration(var20_16, (LiveData)var95_84);
                                                                                            if (var95_84 == null) break block157;
                                                                                            var84_72 = (List)var95_84.getValue();
                                                                                            break block158;
                                                                                        }
                                                                                        var97_86 = var84_72;
                                                                                    }
                                                                                    var20_16 = 0;
                                                                                    var84_72 = null;
                                                                                }
                                                                                var93_83 = var2_2 & 0x1400100L;
                                                                                var63_59 = 0L;
                                                                                var14_10 = (int)(var93_83 == var63_59 ? 0 : (var93_83 < var63_59 ? -1 : 1));
                                                                                if (var14_10 == 0) break block159;
                                                                                if (var7_5 != null) {
                                                                                    var95_84 = var7_5.F0();
                                                                                    var27_23 = var84_72;
                                                                                } else {
                                                                                    var27_23 = var84_72;
                                                                                    var14_10 = 0;
                                                                                    var95_84 = null;
                                                                                }
                                                                                var20_16 = 8;
                                                                                var1_1.updateLiveDataRegistration(var20_16, (LiveData)var95_84);
                                                                                if (var95_84 == null) break block160;
                                                                                var95_84 = (List)var95_84.getValue();
                                                                                break block161;
                                                                            }
                                                                            var27_23 = var84_72;
                                                                            var20_16 = 8;
                                                                        }
                                                                        var14_10 = 0;
                                                                        var95_84 = null;
                                                                    }
                                                                    var93_83 = var2_2 & 20972032L;
                                                                    var63_59 = 0L;
                                                                    var98_87 = var93_83 == var63_59 ? 0 : (var93_83 < var63_59 ? -1 : 1);
                                                                    if (var98_87 != false) {
                                                                        if (var7_5 != null) {
                                                                            var99_88 = var7_5.x();
                                                                            var100_89 = var17_13;
                                                                            var84_72 = var99_88;
                                                                        } else {
                                                                            var100_89 = var17_13;
                                                                            var20_16 = 0;
                                                                            var84_72 = null;
                                                                        }
                                                                        var17_13 = 9;
                                                                        var18_14 = 1.3E-44f;
                                                                        var1_1.updateLiveDataRegistration(var17_13, (LiveData)var84_72);
                                                                        if (var84_72 != null) {
                                                                            var84_72 = (Boolean)var84_72.getValue();
                                                                        } else {
                                                                            var20_16 = 0;
                                                                            var84_72 = null;
                                                                        }
                                                                        var20_16 = (int)ViewDataBinding.safeUnbox((Boolean)var84_72);
                                                                    } else {
                                                                        var100_89 = var17_13;
                                                                        var20_16 = 0;
                                                                        var84_72 = null;
                                                                    }
                                                                    var101_91 = var2_2 & 0x1400400L;
                                                                    var63_59 = 0L;
                                                                    var17_13 = (int)(var101_91 == var63_59 ? 0 : (var101_91 < var63_59 ? -1 : 1));
                                                                    if (var17_13 != 0) {
                                                                        if (var7_5 != null) {
                                                                            var80_68 = var7_5.F();
                                                                            var103_92 = var20_16;
                                                                        } else {
                                                                            var103_92 = var20_16;
                                                                            var17_13 = 0;
                                                                            var80_68 = null;
                                                                            var18_14 = 0.0f;
                                                                        }
                                                                        var20_16 = 10;
                                                                        var1_1.updateLiveDataRegistration(var20_16, (LiveData)var80_68);
                                                                        if (var80_68 != null) {
                                                                            var84_72 = (Boolean)var80_68.getValue();
                                                                        } else {
                                                                            var20_16 = 0;
                                                                            var84_72 = null;
                                                                        }
                                                                        var20_16 = (int)ViewDataBinding.safeUnbox((Boolean)var84_72);
                                                                    } else {
                                                                        var103_92 = var20_16;
                                                                        var20_16 = 0;
                                                                        var84_72 = null;
                                                                    }
                                                                    var101_91 = var2_2 & 0x1401000L;
                                                                    var63_59 = 0L;
                                                                    var17_13 = (int)(var101_91 == var63_59 ? 0 : (var101_91 < var63_59 ? -1 : 1));
                                                                    if (var17_13 != 0) {
                                                                        if (var7_5 != null) {
                                                                            var80_68 = var7_5.N();
                                                                            var104_93 = var20_16;
                                                                        } else {
                                                                            var104_93 = var20_16;
                                                                            var17_13 = 0;
                                                                            var80_68 = null;
                                                                            var18_14 = 0.0f;
                                                                        }
                                                                        var20_16 = 12;
                                                                        var1_1.updateLiveDataRegistration(var20_16, (LiveData)var80_68);
                                                                        if (var80_68 != null) {
                                                                            var84_72 = (Boolean)var80_68.getValue();
                                                                        } else {
                                                                            var20_16 = 0;
                                                                            var84_72 = null;
                                                                        }
                                                                        var20_16 = (int)ViewDataBinding.safeUnbox((Boolean)var84_72);
                                                                    } else {
                                                                        var104_93 = var20_16;
                                                                        var20_16 = 0;
                                                                        var84_72 = null;
                                                                    }
                                                                    var105_94 = var2_2 & var76_66;
                                                                    var63_59 = 0L;
                                                                    var17_13 = (int)(var105_94 == var63_59 ? 0 : (var105_94 < var63_59 ? -1 : 1));
                                                                    if (var17_13 == 0) break block162;
                                                                    if (var7_5 != null) {
                                                                        var107_95 = var7_5.C0();
                                                                        var108_96 = var92_82;
                                                                        var109_97 = var107_95;
                                                                        var110_98 = var20_16;
                                                                        var84_72 = var107_95;
                                                                    } else {
                                                                        var110_98 = var20_16;
                                                                        var108_96 = var92_82;
                                                                        var20_16 = 0;
                                                                        var84_72 = null;
                                                                    }
                                                                    var19_15 = 13;
                                                                    var1_1.updateLiveDataRegistration(var19_15, (LiveData)var84_72);
                                                                    if (var84_72 != null) {
                                                                        var84_72 = (e)var84_72.getValue();
                                                                    } else {
                                                                        var20_16 = 0;
                                                                        var84_72 = null;
                                                                    }
                                                                    if (var84_72 != null) {
                                                                        var19_15 = (int)var84_72.d();
                                                                    } else {
                                                                        var19_15 = 0;
                                                                        var92_82 = null;
                                                                    }
                                                                    if (var17_13 != 0) {
                                                                        if (var19_15 != 0) {
                                                                            var111_99 = 0x100000000L;
                                                                            var2_2 |= var111_99;
                                                                        } else {
                                                                            var2_2 |= var66_61;
                                                                        }
                                                                    }
                                                                    if ((var17_13 = (int)((cfr_temp_1 = (var111_99 = var2_2 & var70_63) - (var63_59 = 0L)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) == 0) break block163;
                                                                    if (var84_72 != null) {
                                                                        var113_100 = (k)var84_72.a();
                                                                    } else {
                                                                        var114_101 = 0;
                                                                        var113_100 = null;
                                                                        var115_102 = 0.0f;
                                                                    }
                                                                    if (var113_100 != null) {
                                                                        var116_103 = (long)var113_100.x();
                                                                        var114_101 = var113_100.w();
                                                                    } else {
                                                                        var114_101 = 0;
                                                                        var115_102 = 0.0f;
                                                                        var113_100 = null;
                                                                        var116_103 = 0;
                                                                        var117_104 = null;
                                                                    }
                                                                    if (var17_13 != 0) {
                                                                        var118_105 = var116_103 != false ? 0x400000000L : 0x200000000L;
                                                                        var2_2 |= var118_105;
                                                                    }
                                                                    if ((var17_13 = (int)((cfr_temp_2 = (var118_105 = var2_2 & var70_63) - (var63_59 = 0L)) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) != 0) {
                                                                        var118_105 = var114_101 != 0 ? 0x40000000L : 0x20000000L;
                                                                        var2_2 |= var118_105;
                                                                    }
                                                                    if (var116_103 != false) {
                                                                        var17_13 = 0;
                                                                        var18_14 = 0.0f;
                                                                        var80_68 = null;
                                                                    } else {
                                                                        var17_13 = 4;
                                                                        var18_14 = 5.6E-45f;
                                                                    }
                                                                    if (var114_101 != 0) break block164;
                                                                    var114_101 = 4;
                                                                    var115_102 = 5.6E-45f;
                                                                    break block165;
                                                                }
                                                                var17_13 = 0;
                                                                var18_14 = 0.0f;
                                                                var80_68 = null;
                                                                break block164;
                                                            }
                                                            var110_98 = var20_16;
                                                            var108_96 = var92_82;
                                                            var20_16 = 0;
                                                            var84_72 = null;
                                                            var17_13 = 0;
                                                            var18_14 = 0.0f;
                                                            var80_68 = null;
                                                            var19_15 = 0;
                                                            var92_82 = null;
                                                        }
                                                        var114_101 = 0;
                                                        var115_102 = 0.0f;
                                                        var113_100 = null;
                                                    }
                                                    var120_106 = var2_2 & 0x1404000L;
                                                    var63_59 = 0L;
                                                    var116_103 = var120_106 == var63_59 ? 0 : (var120_106 < var63_59 ? -1 : 1);
                                                    if (var116_103 != false) {
                                                        if (var7_5 != null) {
                                                            var117_104 = var7_5.H();
                                                            var122_107 = var17_13;
                                                            var123_108 = var18_14;
                                                            var109_97 = var117_104;
                                                            var117_104 = var84_72;
                                                            var84_72 = var109_97;
                                                        } else {
                                                            var117_104 = var84_72;
                                                            var122_107 = var17_13;
                                                            var123_109 = var18_14;
                                                            var20_16 = 0;
                                                            var84_72 = null;
                                                        }
                                                        var17_13 = 14;
                                                        var18_14 = 2.0E-44f;
                                                        var1_1.updateLiveDataRegistration(var17_13, (LiveData)var84_72);
                                                        if (var84_72 != null) {
                                                            var84_72 = (Boolean)var84_72.getValue();
                                                        } else {
                                                            var20_16 = 0;
                                                            var84_72 = null;
                                                        }
                                                        var20_16 = (int)ViewDataBinding.safeUnbox((Boolean)var84_72);
                                                    } else {
                                                        var117_104 = var84_72;
                                                        var122_107 = var17_13;
                                                        var123_110 = var18_14;
                                                        var20_16 = 0;
                                                        var84_72 = null;
                                                    }
                                                    var124_111 = var2_2 & 0x1410000L;
                                                    var63_59 = 0L;
                                                    var17_13 = (int)(var124_111 == var63_59 ? 0 : (var124_111 < var63_59 ? -1 : 1));
                                                    if (var17_13 == 0) break block166;
                                                    if (var7_5 != null) {
                                                        var80_68 = var7_5.q0();
                                                        var126_112 = var20_16;
                                                    } else {
                                                        var126_112 = var20_16;
                                                        var17_13 = 0;
                                                        var80_68 = null;
                                                        var18_14 = 0.0f;
                                                    }
                                                    var20_16 = 16;
                                                    var1_1.updateLiveDataRegistration(var20_16, (LiveData)var80_68);
                                                    if (var80_68 == null) break block167;
                                                    var84_72 = (i)var80_68.getValue();
                                                    break block168;
                                                }
                                                var126_112 = var20_16;
                                            }
                                            var20_16 = 0;
                                            var84_72 = null;
                                        }
                                        var127_113 = var2_2 & 0x1440000L;
                                        var63_59 = 0L;
                                        var17_13 = (int)(var127_113 == var63_59 ? 0 : (var127_113 < var63_59 ? -1 : 1));
                                        if (var17_13 != 0) {
                                            if (var7_5 != null) {
                                                var80_68 = var7_5.P();
                                                var129_114 = var84_72;
                                            } else {
                                                var129_114 = var84_72;
                                                var17_13 = 0;
                                                var80_68 = null;
                                                var18_14 = 0.0f;
                                            }
                                            var20_16 = 18;
                                            var1_1.updateLiveDataRegistration(var20_16, (LiveData)var80_68);
                                            if (var80_68 != null) {
                                                var84_72 = (Boolean)var80_68.getValue();
                                            } else {
                                                var20_16 = 0;
                                                var84_72 = null;
                                            }
                                            var20_16 = (int)ViewDataBinding.safeUnbox((Boolean)var84_72);
                                        } else {
                                            var129_114 = var84_72;
                                            var20_16 = 0;
                                            var84_72 = null;
                                        }
                                        var130_115 = var2_2 & var72_64;
                                        var63_59 = 0L;
                                        var17_13 = (int)(var130_115 == var63_59 ? 0 : (var130_115 < var63_59 ? -1 : 1));
                                        if (var17_13 != 0) {
                                            if (var7_5 != null) {
                                                var132_116 = var7_5.e0();
                                                var133_117 = var19_15;
                                                var109_97 = var132_116;
                                                var134_118 = var20_16;
                                                var84_72 = var132_116;
                                            } else {
                                                var134_118 = var20_16;
                                                var133_117 = var19_15;
                                                var20_16 = 0;
                                                var84_72 = null;
                                            }
                                            var19_15 = 19;
                                            var1_1.updateLiveDataRegistration(var19_15, (LiveData)var84_72);
                                            if (var84_72 != null) {
                                                var92_82 = (e)var84_72.getValue();
                                            } else {
                                                var19_15 = 0;
                                                var92_82 = null;
                                            }
                                            var135_119 = var92_82 != null ? var92_82.d() : false;
                                            if (var17_13 != 0) {
                                                var136_120 = var135_119 != false ? 0x1000000000L : 0x800000000L;
                                                var2_2 |= var136_120;
                                            }
                                            if (var135_119) {
                                                var17_13 = 0;
                                                var18_14 = 0.0f;
                                                var80_68 = null;
                                            } else {
                                                var17_13 = 4;
                                                var18_14 = 5.6E-45f;
                                            }
                                        } else {
                                            var134_118 = var20_16;
                                            var133_117 = var19_15;
                                            var20_16 = 0;
                                            var84_72 = null;
                                            var19_15 = 0;
                                            var92_82 = null;
                                            var17_13 = 0;
                                            var18_14 = 0.0f;
                                            var80_68 = null;
                                            var135_119 = false;
                                        }
                                        var136_120 = var2_2 & 0x1500000L;
                                        var63_59 = 0L;
                                        var138_121 = var136_120 == var63_59 ? 0 : (var136_120 < var63_59 ? -1 : 1);
                                        if (var138_121 == false) break block169;
                                        if (var7_5 != null) {
                                            var139_122 = var7_5.n0();
                                            var140_123 = var139_122;
                                            var136_120 = var2_2;
                                        } else {
                                            var136_120 = var2_2;
                                            var141_124 = false;
                                            var140_123 = null;
                                        }
                                        var142_125 = 20;
                                        var1_1.updateLiveDataRegistration(var142_125, (LiveData)var140_123);
                                        if (var140_123 == null) break block170;
                                        var140_123 = (List)var140_123.getValue();
                                        var143_126 = var17_13;
                                        var144_127 = var22_18;
                                        var145_128 = var95_84;
                                        var23_19 = var27_23;
                                        var146_129 = var97_86;
                                        var147_130 = (int)var82_70;
                                        var14_10 = var104_93;
                                        var80_68 = var108_96;
                                        var148_131 = var114_101;
                                        var149_132 = var117_104;
                                        var150_133 = var122_107;
                                        var151_134 = var126_112;
                                        var152_135 = var134_118;
                                        var97_86 = var140_123;
                                        var27_23 = var84_72;
                                        var82_70 = var103_92;
                                        var20_16 = var100_89;
                                        var103_92 = var110_98;
                                        var2_2 = var136_120;
                                        break block171;
                                    }
                                    var136_120 = var2_2;
                                }
                                var143_126 = var17_13;
                                var144_127 = var22_18;
                                var145_128 = var95_84;
                                var23_19 = var27_23;
                                var146_129 = var97_86;
                                var147_130 = var82_70;
                                var14_10 = var104_93;
                                var80_68 = var108_96;
                                var148_131 = var114_101;
                                var149_132 = var117_104;
                                var150_133 = var122_107;
                                var151_134 = var126_112;
                                var152_135 = var134_118;
                                var2_2 = var136_120;
                                var27_23 = var84_72;
                                var97_86 = null;
                                var82_70 = var103_92;
                                var20_16 = var100_89;
                                var103_92 = var110_98;
                            }
                            var153_136 = var92_82;
                            var92_82 = var129_114;
                            break block172;
                        }
                        var17_13 = 0;
                        var80_68 = null;
                        var18_14 = 0.0f;
                        var19_15 = 0;
                        var92_82 = null;
                        var22_18 = 0;
                        var23_19 = null;
                        var96_85 = null;
                        var65_60 /* !! */  = 0;
                        var27_23 = null;
                        var97_86 = null;
                        var100_90 = false;
                        var153_136 = null;
                        var85_73 = null;
                        var149_132 = null;
                        var146_129 = null;
                        var145_128 = null;
                        var20_16 = 0;
                        var84_72 = null;
                        var14_10 = 0;
                        var95_84 = null;
                        var103_92 = 0;
                        var82_70 = 0;
                        var89_79 = 0.0f;
                        var45_42 = null;
                        var86_74 = false;
                        var133_117 = 0;
                        var135_119 = false;
                        var151_134 = 0;
                        var152_135 = 0;
                        var150_133 = 0;
                        var143_126 = 0;
                        var144_127 = 0;
                        var147_130 = 0;
                        var148_131 = 0;
                    }
                    var101_91 = 0x1C00010L;
                    var154_137 = var2_2 & var101_91;
                    var63_59 = 0L;
                    var156_138 = var154_137 == var63_59 ? 0 : (var154_137 < var63_59 ? -1 : 1);
                    if (var156_138 == false) break block173;
                    if (var8_6 != null) {
                        var8_6 = var8_6.R0();
                        var157_139 = var20_16;
                    } else {
                        var157_139 = var20_16;
                        var158_140 = 0;
                        var8_6 = null;
                    }
                    var20_16 = 4;
                    var1_1.updateLiveDataRegistration(var20_16, (LiveData)var8_6);
                    if (var8_6 != null) {
                        var25_21 = var84_72 = var8_6.getValue();
                        var25_21 = (Integer)var84_72;
                    }
                    var20_16 = ViewDataBinding.safeUnbox(var25_21);
                    if (var7_5 == null) break block174;
                    var158_140 = var7_5.z1(var20_16);
                    break block175;
                }
                var157_139 = var20_16;
                var20_16 = 0;
                var84_72 = null;
            }
            var158_140 = 0;
            var8_6 = null;
        }
        var66_61 = var2_2 & var66_61;
        var63_59 = 0L;
        var24_20 = var66_61 == var63_59 ? 0 : (var66_61 < var63_59 ? -1 : 1);
        if (var24_20 != 0) {
            if (var7_5 != null) {
                var96_85 = var7_5.k0();
            }
            var24_20 = var14_10;
            var95_84 = var96_85;
            var96_85 = var23_19;
            var22_18 = 2;
            var1_1.updateLiveDataRegistration(var22_18, (LiveData)var95_84);
            if (var95_84 != null) {
                var85_73 = var23_19 = var95_84.getValue();
                var85_73 = (e)var23_19;
            }
            if (var85_73 != null) {
                var86_74 = var85_73.d();
            }
            if ((var22_18 = (int)((cfr_temp_3 = (var66_61 = var2_2 & var74_65) - (var63_59 = 0L)) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) != 0) {
                var66_61 = var86_74 != false ? 0x4000000000L : 0x2000000000L;
                var2_2 |= var66_61;
            }
        } else {
            var96_85 = var23_19;
            var24_20 = var14_10;
        }
        var23_19 = var85_73;
        var66_61 = var2_2 & var76_66;
        var63_59 = 0L;
        var14_10 = (int)(var66_61 == var63_59 ? 0 : (var66_61 < var63_59 ? -1 : 1));
        var66_61 = 0x2000000L;
        if (var14_10 != 0) {
            if (var133_117 != 0) {
                var86_74 = true;
            }
            if (var14_10 != 0) {
                if (var86_74) {
                    var154_137 = 0x4000000L;
                    var2_2 |= var154_137;
                } else {
                    var2_2 |= var66_61;
                }
            }
        } else {
            var86_74 = false;
        }
        if ((var14_10 = (int)((cfr_temp_4 = (var66_61 = var2_2 & var66_61) - (var63_59 = 0L)) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) != 0) {
            var95_84 = var7_5 != null ? var7_5.e0() : var27_23;
            var27_23 = var7_5;
            var159_141 = 19;
            var1_1.updateLiveDataRegistration(var159_141, (LiveData)var95_84);
            if (var95_84 != null) {
                var153_136 = var7_5 = var95_84.getValue();
                var153_136 = (e)var7_5;
            }
            if (var153_136 != null) {
                var135_119 = var153_136.d();
            }
            if ((var159_141 = (int)((cfr_temp_5 = (var66_61 = var2_2 & var72_64) - (var63_59 = 0L)) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0) {
                var66_61 = var135_119 != false ? 0x1000000000L : 0x800000000L;
                var2_2 |= var66_61;
            }
        } else {
            var27_23 = var7_5;
        }
        var7_5 = var153_136;
        var66_61 = var2_2 & var76_66;
        var63_59 = 0L;
        cfr_temp_6 = var66_61 - var63_59;
        var14_10 = (int)(cfr_temp_6 == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1));
        if (var14_10 != 0) {
            if (var86_74) {
                var135_119 = true;
            }
            if (var14_10 != 0) {
                var66_61 = var135_119 != false ? 0x10000000L : 0x8000000L;
                var2_2 |= var66_61;
            }
            if (var135_119) {
                var81_69 = 8;
            } else {
                var81_69 = 0;
                var41_38 = null;
            }
            var14_10 = (int)var81_69;
        } else {
            var14_10 = 0;
            var95_84 = null;
        }
        var66_61 = var2_2 & var76_66;
        var63_59 = 0L;
        var160_142 = var66_61 == var63_59 ? 0 : (var66_61 < var63_59 ? -1 : 1);
        if (var160_142 != false) {
            var32_29 = var7_5;
            var7_5 = var1_1.a;
            var7_5.setVisibility(var14_10);
        } else {
            var32_29 = var7_5;
        }
        var161_143 = var2_2 & 0x1200000L;
        var159_141 = (int)(var161_143 == var63_59 ? 0 : (var161_143 < var63_59 ? -1 : 1));
        if (var159_141 != 0) {
            var7_5 = var1_1.b;
            var95_84 = var47_44;
            d.v.f.e.c.f((View)var7_5, var47_44);
            d.v.f.e.c.f((View)var1_1.c, (d.v.f.f.d)var38_35 /* !! */ );
            var1_1.m.setOnDragListener((p$b)var26_22);
            var38_35 /* !! */  = var1_1.G;
            var7_5 = var56_53;
            d.v.f.e.c.f((View)var38_35 /* !! */ , var56_53);
            var38_35 /* !! */  = var1_1.H;
            var7_5 = var50_47;
            d.v.f.e.c.f((View)var38_35 /* !! */ , var50_47);
            var38_35 /* !! */  = var1_1.I;
            var7_5 = var58_55;
            d.v.f.e.c.f((View)var38_35 /* !! */ , var58_55);
            var38_35 /* !! */  = var1_1.K;
            var7_5 = var48_45;
            d.v.f.e.c.f((View)var38_35 /* !! */ , var48_45);
            var38_35 /* !! */  = var1_1.L;
            var7_5 = var52_49;
            d.v.f.e.c.f((View)var38_35 /* !! */ , var52_49);
            var38_35 /* !! */  = var1_1.M;
            var7_5 = var60_57;
            d.v.f.e.c.f((View)var38_35 /* !! */ , var60_57);
            var38_35 /* !! */  = var1_1.N;
            var7_5 = var54_51;
            d.v.f.e.c.f((View)var38_35 /* !! */ , var54_51);
            d.v.f.e.c.f((View)var1_1.O, (d.v.f.f.d)var29_26);
            var38_35 /* !! */  = var1_1.P;
            var7_5 = var53_50;
            d.v.f.e.c.f((View)var38_35 /* !! */ , var53_50);
            var38_35 /* !! */  = var1_1.Q;
            var7_5 = var49_46;
            d.v.f.e.c.f((View)var38_35 /* !! */ , var49_46);
            var1_1.k0.setOnClickEmptyListener(var46_43);
            var1_1.k0.setOnDragListener(var43_40);
            var38_35 /* !! */  = var1_1.q0;
            var7_5 = var55_52;
            var38_35 /* !! */ .setOnClickEmptyListener(var55_52);
            var38_35 /* !! */  = var1_1.q0;
            var7_5 = var57_54;
            var38_35 /* !! */ .setOnDragListener(var57_54);
            var38_35 /* !! */  = var1_1.r0;
            var7_5 = var59_56;
            var38_35 /* !! */ .setOnClickEmptyListener(var59_56);
            var38_35 /* !! */  = var1_1.r0;
            var7_5 = var51_48;
            var38_35 /* !! */ .setOnDragListener(var51_48);
            var1_1.r.A((EditorMainFragment$g)var6_4);
            var1_1.s.A((EditorMainFragment$g)var6_4);
            var1_1.t.A((EditorMainFragment$g)var6_4);
            var38_35 /* !! */  = var1_1.u;
            var38_35 /* !! */ .A((EditorMainFragment$g)var6_4);
        }
        if ((var167_146 = (cfr_temp_7 = (var163_144 = var2_2 & var101_91) - (var165_145 = 0L)) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1)) != false) {
            var1_1.c.setEnabled((boolean)var158_140);
            var6_4 = var1_1.I;
            var6_4.setEnabled((boolean)var158_140);
        }
        if ((var167_146 = (cfr_temp_8 = (var163_144 = 0x1000000L & var2_2) - var165_145) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.i;
            var38_35 /* !! */  = var1_1.M0;
            d.v.f.e.c.f((View)var6_4, (d.v.f.f.d)var38_35 /* !! */ );
            var6_4 = var1_1.m;
            var38_35 /* !! */  = var1_1.S0;
            d.v.c.b2.p.n0((p)var6_4, (InverseBindingListener)var38_35 /* !! */ );
            var6_4 = var1_1.m;
            var38_35 /* !! */  = var1_1.z0;
            var6_4.setOnItemSelectedListener((d.v.c.b2.x.c)var38_35 /* !! */ );
            var6_4 = var1_1.m;
            var38_35 /* !! */  = var1_1.L0;
            var6_4.setOnTransitionBtnClickListener((EditorThumbnail$b)var38_35 /* !! */ );
            var6_4 = var1_1.B;
            var38_35 /* !! */  = var1_1.A0;
            d.v.f.e.c.f((View)var6_4, (d.v.f.f.d)var38_35 /* !! */ );
            var6_4 = var1_1.C;
            var38_35 /* !! */  = var1_1.F0;
            d.v.f.e.c.f((View)var6_4, (d.v.f.f.d)var38_35 /* !! */ );
            var6_4 = var1_1.D;
            var38_35 /* !! */  = var1_1.w0;
            d.v.f.e.c.f((View)var6_4, (d.v.f.f.d)var38_35 /* !! */ );
            var6_4 = var1_1.E;
            var38_35 /* !! */  = var1_1.y0;
            d.v.f.e.c.f((View)var6_4, (d.v.f.f.d)var38_35 /* !! */ );
            var6_4 = var1_1.F;
            var38_35 /* !! */  = var1_1.t0;
            var6_4.setOnTouchListener((View.OnTouchListener)var38_35 /* !! */ );
            var6_4 = var1_1.J;
            var38_35 /* !! */  = var1_1.I0;
            d.v.f.e.c.f((View)var6_4, (d.v.f.f.d)var38_35 /* !! */ );
            var6_4 = var1_1.T;
            var38_35 /* !! */  = var1_1.D0;
            var6_4.setOnClickListener((View.OnClickListener)var38_35 /* !! */ );
            var6_4 = var1_1.V;
            var38_35 /* !! */  = var1_1.v0;
            d.v.f.e.c.f((View)var6_4, (d.v.f.f.d)var38_35 /* !! */ );
            var6_4 = var1_1.W;
            var38_35 /* !! */  = var1_1.H0;
            d.v.f.e.c.f((View)var6_4, (d.v.f.f.d)var38_35 /* !! */ );
            var6_4 = var1_1.X;
            var38_35 /* !! */  = var1_1.K0;
            d.v.f.e.c.f((View)var6_4, (d.v.f.f.d)var38_35 /* !! */ );
            var6_4 = var1_1.Y;
            var38_35 /* !! */  = var1_1.B0;
            d.v.f.e.c.f((View)var6_4, (d.v.f.f.d)var38_35 /* !! */ );
            var6_4 = var1_1.k0;
            var38_35 /* !! */  = var1_1.T0;
            d.v.c.b2.p.n0((p)var6_4, (InverseBindingListener)var38_35 /* !! */ );
            var6_4 = var1_1.k0;
            var38_35 /* !! */  = var1_1.C0;
            var6_4.setOnItemSelectedListener((d.v.c.b2.x.c)var38_35 /* !! */ );
            var6_4 = var1_1.o0;
            var38_35 /* !! */  = var1_1.E0;
            d.v.f.e.c.f((View)var6_4, (d.v.f.f.d)var38_35 /* !! */ );
            var6_4 = var1_1.q0;
            var38_35 /* !! */  = var1_1.U0;
            d.v.c.b2.p.n0((p)var6_4, (InverseBindingListener)var38_35 /* !! */ );
            var6_4 = var1_1.q0;
            var38_35 /* !! */  = var1_1.G0;
            var6_4.setOnItemSelectedListener((d.v.c.b2.x.c)var38_35 /* !! */ );
            var6_4 = var1_1.r0;
            var38_35 /* !! */  = var1_1.V0;
            d.v.c.b2.p.n0((p)var6_4, (InverseBindingListener)var38_35 /* !! */ );
            var6_4 = var1_1.r0;
            var38_35 /* !! */  = var1_1.x0;
            var6_4.setOnItemSelectedListener((d.v.c.b2.x.c)var38_35 /* !! */ );
            var6_4 = var1_1.v;
            var38_35 /* !! */  = var1_1.J0;
            d.v.f.e.c.f((View)var6_4, (d.v.f.f.d)var38_35 /* !! */ );
            var6_4 = var1_1.w;
            var38_35 /* !! */  = var1_1.u0;
            d.v.f.e.c.f((View)var6_4, (d.v.f.f.d)var38_35 /* !! */ );
            var6_4 = var1_1.x;
            var38_35 /* !! */  = var1_1.N0;
            d.v.f.e.c.f((View)var6_4, (d.v.f.f.d)var38_35 /* !! */ );
        }
        if ((var167_146 = (cfr_temp_9 = (var163_144 = 20971528L & var2_2) - (var165_145 = 0L)) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1)) != false) {
            var38_35 /* !! */  = var1_1.m;
            var7_5 = var1_1.O0;
            d.v.c.b2.p.p0((p)var38_35 /* !! */ , (e)var7_5, (e)var80_68);
        }
        if ((var21_17 = (int)((cfr_temp_10 = (var163_144 = 0x1800010L & var2_2) - var165_145) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1))) != 0) {
            var38_35 /* !! */  = var1_1.m;
            var38_35 /* !! */ .setCurPositionIndex(var20_16);
        }
        if ((var20_16 = (int)((cfr_temp_11 = (var4_3 = 0x1410000L & var2_2) - var165_145) == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1))) != 0) {
            var1_1.m.setTimeAxisData((i)var92_82);
            var1_1.k0.setTimeAxisData((i)var92_82);
            var1_1.p0.setTimeAxisData((i)var92_82);
            var1_1.q0.setTimeAxisData((i)var92_82);
            var1_1.r0.setTimeAxisData((i)var92_82);
            var84_72 = var1_1.s0;
            var84_72.setTimeAxisData((i)var92_82);
        }
        if ((var20_16 = (int)((cfr_temp_12 = (var4_3 = 0x1400040L & var2_2) - (var168_147 = 0L)) == 0L ? 0 : (cfr_temp_12 < 0L ? -1 : 1))) != 0) {
            var84_72 = var1_1.m;
            var38_35 /* !! */  = var96_85;
            var84_72.setUiData((List)var96_85);
        }
        if ((var20_16 = (int)((cfr_temp_13 = (var4_3 = 0x1400400L & var2_2) - var168_147) == 0L ? 0 : (cfr_temp_13 < 0L ? -1 : 1))) != 0) {
            var84_72 = var1_1.B;
            var21_17 = var24_20;
            var84_72.setEnabled((boolean)var24_20);
        }
        if ((var20_16 = (int)((cfr_temp_14 = (var4_3 = var2_2 & var68_62) - var168_147) == 0L ? 0 : (cfr_temp_14 < 0L ? -1 : 1))) != 0) {
            var84_72 = var1_1.C;
            var21_17 = var157_139;
            var84_72.setEnabled((boolean)var157_139);
        }
        if ((var20_16 = (cfr_temp_15 = (var4_3 = 20972032L & var2_2) - var168_147) == 0L ? 0 : (cfr_temp_15 < 0L ? -1 : 1)) != 0) {
            var84_72 = var1_1.D;
            var21_17 = (int)var82_70;
            var84_72.setEnabled((boolean)var82_70);
        }
        if ((var20_16 = (int)((cfr_temp_16 = (var4_3 = 0x1401000L & var2_2) - var168_147) == 0L ? 0 : (cfr_temp_16 < 0L ? -1 : 1))) != 0) {
            var84_72 = var1_1.H;
            var21_17 = var103_92;
            var84_72.setEnabled((boolean)var103_92);
        }
        if ((var20_16 = (cfr_temp_17 = (var4_3 = 0x1404000L & var2_2) - var168_147) == 0L ? 0 : (cfr_temp_17 < 0L ? -1 : 1)) != 0) {
            var84_72 = var1_1.L;
            var21_17 = var151_134;
            var84_72.setEnabled((boolean)var151_134);
        }
        if ((var20_16 = (cfr_temp_18 = (var4_3 = var2_2 & var61_58) - var168_147) == 0L ? 0 : (cfr_temp_18 < 0L ? -1 : 1)) != 0) {
            var84_72 = var1_1.P;
            var21_17 = var144_127;
            var84_72.setEnabled((boolean)var144_127);
        }
        if ((var20_16 = (cfr_temp_19 = (var4_3 = 0x1440000L & var2_2) - var168_147) == 0L ? 0 : (cfr_temp_19 < 0L ? -1 : 1)) != 0) {
            var84_72 = var1_1.Q;
            var21_17 = var152_135;
            var84_72.setEnabled((boolean)var152_135);
        }
        if ((var20_16 = (cfr_temp_20 = (var4_3 = var2_2 & var70_63) - var168_147) == 0L ? 0 : (cfr_temp_20 < 0L ? -1 : 1)) != 0) {
            var38_35 /* !! */  = var1_1.R;
            var159_141 = var148_131;
            var38_35 /* !! */ .setVisibility(var148_131);
            var38_35 /* !! */  = var1_1.S;
            var158_140 = var150_133;
            var38_35 /* !! */ .setVisibility(var150_133);
            var38_35 /* !! */  = var1_1.k0;
            var92_82 = var1_1.P0;
            var26_22 = var149_132;
            d.v.c.b2.p.p0((p)var38_35 /* !! */ , (e)var92_82, (e)var149_132);
            var1_1.r.getRoot().setVisibility(var148_131);
            var38_35 /* !! */  = var1_1.s.getRoot();
            var38_35 /* !! */ .setVisibility(var150_133);
        } else {
            var26_22 = var149_132;
        }
        var163_144 = var2_2 & var74_65;
        var165_145 = 0L;
        var21_17 = var163_144 == var165_145 ? 0 : (var163_144 < var165_145 ? -1 : 1);
        if (var21_17 != 0) {
            var7_5 = var1_1.U;
            var158_140 = var147_130;
            var7_5.setVisibility(var147_130);
            var7_5 = var1_1.q0;
            var92_82 = var1_1.Q0;
            d.v.c.b2.p.p0((p)var7_5, (e)var92_82, (e)var23_19);
            var7_5 = var1_1.u.getRoot();
            var7_5.setVisibility(var147_130);
        }
        if ((var159_141 = (int)((cfr_temp_21 = (var168_147 = var2_2 & var72_64) - (var165_145 = 0L)) == 0L ? 0 : (cfr_temp_21 < 0L ? -1 : 1))) != 0) {
            var8_6 = var1_1.Z;
            var19_15 = var143_126;
            var8_6.setVisibility(var143_126);
            var8_6 = var1_1.r0;
            var29_26 = var1_1.R0;
            var95_84 = var32_29;
            d.v.c.b2.p.p0((p)var8_6, (e)var29_26, (e)var32_29);
            var8_6 = var1_1.t.getRoot();
            var8_6.setVisibility(var143_126);
        } else {
            var95_84 = var32_29;
        }
        var170_148 = 0x1400100L & var2_2;
        var161_143 = 0L;
        var158_140 = (int)(var170_148 == var161_143 ? 0 : (var170_148 < var161_143 ? -1 : 1));
        if (var158_140 != 0) {
            var8_6 = var1_1.k0;
            var92_82 = var145_128;
            var8_6.setUiData((List)var145_128);
            var8_6 = var1_1.p0;
            var8_6.setUiData((List)var145_128);
        }
        if ((var158_140 = (int)((cfr_temp_22 = (var170_148 = 0x1500000L & var2_2) - var161_143) == 0L ? 0 : (cfr_temp_22 < 0L ? -1 : 1))) != 0) {
            var8_6 = var1_1.q0;
            var92_82 = var97_86;
            var8_6.setUiData((List)var97_86);
        }
        if ((var158_140 = (int)((cfr_temp_23 = (var170_148 = 20971552L & var2_2) - var161_143) == 0L ? 0 : (cfr_temp_23 < 0L ? -1 : 1))) != 0) {
            var8_6 = var1_1.r0;
            var92_82 = var146_129;
            var8_6.setUiData((List)var146_129);
        }
        if (var141_124 = (cfr_temp_24 = (var2_2 &= (var170_148 = 0x1400000L)) - var161_143) == 0L ? 0 : (cfr_temp_24 < 0L ? -1 : 1)) {
            var1_1.r.B((h2)var27_23);
            var1_1.s.B((h2)var27_23);
            var1_1.t.B((h2)var27_23);
            var140_123 = var1_1.u;
            var140_123.B((h2)var27_23);
        }
        if (var167_146 != false) {
            var1_1.O0 = var80_68;
        }
        if (var20_16 != 0) {
            var1_1.P0 = var26_22;
        }
        if (var21_17 != 0) {
            var1_1.Q0 = var23_19;
        }
        if (var159_141 != 0) {
            var1_1.R0 = var95_84;
        }
        ViewDataBinding.executeBindingsOn(var1_1.r);
        ViewDataBinding.executeBindingsOn(var1_1.s);
        ViewDataBinding.executeBindingsOn(var1_1.u);
        ViewDataBinding.executeBindingsOn(var1_1.t);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.W0;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            ViewDataBinding viewDataBinding = this.r;
            l12 = (long)viewDataBinding.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            viewDataBinding = this.s;
            l12 = (long)viewDataBinding.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            viewDataBinding = this.u;
            l12 = (long)viewDataBinding.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            viewDataBinding = this.t;
            l12 = (long)viewDataBinding.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            return false;
        }
    }

    public final void i(int n10, e e10, View view) {
        int n11 = 3;
        boolean bl2 = true;
        if (n10 != n11) {
            n11 = 4;
            if (n10 != n11) {
                n11 = 5;
                if (n10 != n11) {
                    n11 = 6;
                    if (n10 == n11) {
                        EditorMainFragment$g editorMainFragment$g = this.z;
                        if (editorMainFragment$g == null) {
                            bl2 = false;
                        }
                        if (bl2) {
                            editorMainFragment$g.g0(e10, view);
                        }
                    }
                } else {
                    EditorMainFragment$g editorMainFragment$g = this.z;
                    if (editorMainFragment$g == null) {
                        bl2 = false;
                    }
                    if (bl2) {
                        editorMainFragment$g.g0(e10, view);
                    }
                }
            } else {
                EditorMainFragment$g editorMainFragment$g = this.z;
                if (editorMainFragment$g == null) {
                    bl2 = false;
                }
                if (bl2) {
                    editorMainFragment$g.g0(e10, view);
                }
            }
        } else {
            EditorMainFragment$g editorMainFragment$g = this.z;
            if (editorMainFragment$g == null) {
                bl2 = false;
            }
            if (bl2) {
                editorMainFragment$g.g0(e10, view);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void invalidateAll() {
        synchronized (this) {
            long l10;
            this.W0 = l10 = 0x1000000L;
        }
        this.r.invalidateAll();
        this.s.invalidateAll();
        this.u.invalidateAll();
        this.t.invalidateAll();
        this.requestRebind();
    }

    public final void m(int n10, View view) {
        int n11 = 1;
        int n12 = 0;
        switch (n10) {
            default: {
                break;
            }
            case 21: {
                EditorMainFragment$g editorMainFragment$g = this.z;
                if (editorMainFragment$g == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                editorMainFragment$g.m();
                break;
            }
            case 20: {
                EditorMainFragment$g editorMainFragment$g = this.z;
                if (editorMainFragment$g == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                n11 = 3;
                editorMainFragment$g.t(n11);
                break;
            }
            case 19: {
                EditorMainFragment$g editorMainFragment$g = this.z;
                if (editorMainFragment$g == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                n11 = 2;
                editorMainFragment$g.t(n11);
                break;
            }
            case 18: {
                EditorMainFragment$g editorMainFragment$g = this.z;
                if (editorMainFragment$g != null) {
                    n12 = n11;
                }
                if (n12 == 0) break;
                editorMainFragment$g.t(n11);
                break;
            }
            case 17: {
                EditorMainFragment$g editorMainFragment$g = this.z;
                if (editorMainFragment$g == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                editorMainFragment$g.t(0);
                break;
            }
            case 15: {
                EditorMainFragment$g editorMainFragment$g = this.z;
                if (editorMainFragment$g == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                editorMainFragment$g.r();
                break;
            }
            case 14: {
                EditorMainFragment$g editorMainFragment$g = this.z;
                if (editorMainFragment$g == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                editorMainFragment$g.q();
                break;
            }
            case 13: {
                EditorMainFragment$g editorMainFragment$g = this.z;
                if (editorMainFragment$g == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                editorMainFragment$g.l();
                break;
            }
            case 11: {
                EditorMainFragment$g editorMainFragment$g = this.z;
                if (editorMainFragment$g == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                editorMainFragment$g.j();
                break;
            }
            case 10: {
                EditorMainFragment$g editorMainFragment$g = this.z;
                if (editorMainFragment$g == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                editorMainFragment$g.g();
                break;
            }
            case 9: {
                EditorMainFragment$g editorMainFragment$g = this.z;
                if (editorMainFragment$g == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                editorMainFragment$g.h();
                break;
            }
            case 8: {
                EditorMainFragment$g editorMainFragment$g = this.z;
                if (editorMainFragment$g == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                editorMainFragment$g.k();
                break;
            }
            case 2: {
                EditorMainFragment$g editorMainFragment$g = this.z;
                if (editorMainFragment$g == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                editorMainFragment$g.d();
                break;
            }
            case 1: {
                EditorMainFragment$g editorMainFragment$g = this.z;
                if (editorMainFragment$g == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                editorMainFragment$g.d();
            }
        }
    }

    public final void o(int n10, int n11) {
        EditorMainFragment$g editorMainFragment$g = this.z;
        boolean bl2 = editorMainFragment$g != null;
        if (bl2) {
            editorMainFragment$g.i(n11);
        }
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        switch (n10) {
            default: {
                return false;
            }
            case 20: {
                object = (MutableLiveData)object;
                return this.R((MutableLiveData)object, n11);
            }
            case 19: {
                object = (MutableLiveData)object;
                return this.O((MutableLiveData)object, n11);
            }
            case 18: {
                object = (LiveData)object;
                return this.N((LiveData)object, n11);
            }
            case 17: {
                object = (t4)object;
                return this.Z((t4)object, n11);
            }
            case 16: {
                object = (LiveData)object;
                return this.S((LiveData)object, n11);
            }
            case 15: {
                object = (p4)object;
                return this.X((p4)object, n11);
            }
            case 14: {
                object = (MediatorLiveData)object;
                return this.K((MediatorLiveData)object, n11);
            }
            case 13: {
                object = (MutableLiveData)object;
                return this.V((MutableLiveData)object, n11);
            }
            case 12: {
                object = (LiveData)object;
                return this.M((LiveData)object, n11);
            }
            case 11: {
                object = (r4)object;
                return this.Y((r4)object, n11);
            }
            case 10: {
                object = (LiveData)object;
                return this.J((LiveData)object, n11);
            }
            case 9: {
                object = (LiveData)object;
                return this.H((LiveData)object, n11);
            }
            case 8: {
                object = (LiveData)object;
                return this.W((LiveData)object, n11);
            }
            case 7: {
                object = (v4)object;
                return this.a0((v4)object, n11);
            }
            case 6: {
                object = (LiveData)object;
                return this.U((LiveData)object, n11);
            }
            case 5: {
                object = (MutableLiveData)object;
                return this.P((MutableLiveData)object, n11);
            }
            case 4: {
                object = (j)object;
                return this.b0((j)object, n11);
            }
            case 3: {
                object = (MutableLiveData)object;
                return this.T((MutableLiveData)object, n11);
            }
            case 2: {
                object = (MutableLiveData)object;
                return this.Q((MutableLiveData)object, n11);
            }
            case 1: {
                object = (MediatorLiveData)object;
                return this.L((MediatorLiveData)object, n11);
            }
            case 0: 
        }
        object = (LiveData)object;
        return this.I((LiveData)object, n11);
    }

    public final boolean p(int n10, View view, MotionEvent motionEvent) {
        EditorMainFragment$g editorMainFragment$g = this.z;
        boolean bl2 = false;
        boolean bl3 = editorMainFragment$g != null;
        if (bl3) {
            bl2 = editorMainFragment$g.L();
        }
        return bl2;
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.r.setLifecycleOwner(lifecycleOwner);
        this.s.setLifecycleOwner(lifecycleOwner);
        this.u.setLifecycleOwner(lifecycleOwner);
        this.t.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (EditorMainFragment$g)object;
            this.B((EditorMainFragment$g)object);
            return 1 != 0;
        } else {
            n11 = 48;
            if (n11 == n10) {
                object = (h2)object;
                this.C((h2)object);
                return 1 != 0;
            } else {
                n11 = 152;
                if (n11 != n10) return 0 != 0;
                object = (i2)object;
                this.D((i2)object);
            }
        }
        return 1 != 0;
    }
}

