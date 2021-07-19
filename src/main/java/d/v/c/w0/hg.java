/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.CheckedTextView
 *  android.widget.CompoundButton
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.ProgressBar
 *  android.widget.ScrollView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.internal.FlowLayout;
import com.zhiyun.cama.publish.PublishFragment$f;
import d.v.c.f1.a.b$a;
import d.v.c.n1.j2;
import d.v.c.q1.g0;
import d.v.c.u0.l;
import d.v.c.w0.gg;
import d.v.c.w0.hg$a;
import d.v.c.w0.hg$b;
import d.v.c.w0.hg$c;
import d.v.c.w0.hg$d;
import d.v.c.w0.hg$e;
import d.v.c.w0.hg$f;
import d.v.c.w0.hg$g;
import d.v.c.w0.hg$h;
import d.v.c.w0.hg$i;
import d.v.c.w0.hg$j;
import d.v.c.w0.hg$k;
import d.v.e.l.s1;
import l.a.q.g0.u;

public class hg
extends gg
implements b$a {
    private static final ViewDataBinding$IncludedLayouts u0;
    private static final SparseIntArray v0;
    private final ConstraintLayout P;
    private final TextView Q;
    private final TextView R;
    private final TextView S;
    private final ImageView T;
    private final View.OnClickListener U;
    private hg$k V;
    private hg$b W;
    private hg$c X;
    private hg$d Y;
    private hg$e Z;
    private hg$f k0;
    private hg$g o0;
    private hg$h p0;
    private hg$i q0;
    private hg$j r0;
    private hg$a s0;
    private long t0;

    static {
        SparseIntArray sparseIntArray;
        v0 = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362498, 22);
        sparseIntArray.put(2131363615, 23);
        sparseIntArray.put(2131362373, 24);
        sparseIntArray.put(2131363272, 25);
        sparseIntArray.put(2131362493, 26);
        sparseIntArray.put(2131363703, 27);
        sparseIntArray.put(2131363597, 28);
        sparseIntArray.put(2131363702, 29);
        sparseIntArray.put(2131362692, 30);
        sparseIntArray.put(2131363696, 31);
        sparseIntArray.put(2131362693, 32);
        sparseIntArray.put(2131362839, 33);
        sparseIntArray.put(2131362980, 34);
        sparseIntArray.put(2131363475, 35);
        sparseIntArray.put(2131362838, 36);
        sparseIntArray.put(2131362978, 37);
        sparseIntArray.put(2131362470, 38);
        sparseIntArray.put(2131363679, 39);
        sparseIntArray.put(2131362483, 40);
        sparseIntArray.put(2131363010, 41);
    }

    public hg(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = u0;
        SparseIntArray sparseIntArray = v0;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 42, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private hg(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object = this;
        CheckBox checkBox = (CheckBox)objectArray[11];
        CheckedTextView checkedTextView = (CheckedTextView)objectArray[14];
        ConstraintLayout constraintLayout = (ConstraintLayout)((Object)objectArray[7]);
        EditText editText = (EditText)objectArray[24];
        FrameLayout frameLayout = (FrameLayout)objectArray[38];
        FlowLayout flowLayout = (FlowLayout)((Object)objectArray[6]);
        FrameLayout frameLayout2 = (FrameLayout)objectArray[40];
        ConstraintLayout constraintLayout2 = (ConstraintLayout)((Object)objectArray[15]);
        FlowLayout flowLayout2 = (FlowLayout)((Object)objectArray[26]);
        FrameLayout frameLayout3 = (FrameLayout)objectArray[22];
        ImageView imageView = (ImageView)objectArray[3];
        ImageView imageView2 = (ImageView)objectArray[2];
        TextView textView = (TextView)objectArray[4];
        ImageView imageView3 = (ImageView)objectArray[30];
        ImageView imageView4 = (ImageView)objectArray[32];
        ImageView imageView5 = (ImageView)objectArray[9];
        ImageView imageView6 = (ImageView)objectArray[1];
        LinearLayout linearLayout = (LinearLayout)objectArray[36];
        LinearLayout linearLayout2 = (LinearLayout)objectArray[33];
        ProgressBar progressBar = (ProgressBar)objectArray[37];
        ProgressBar progressBar2 = (ProgressBar)objectArray[34];
        ProgressBar progressBar3 = (ProgressBar)objectArray[41];
        ScrollView scrollView = (ScrollView)objectArray[25];
        TextView textView2 = (TextView)objectArray[35];
        TextView textView3 = (TextView)objectArray[10];
        TextView textView4 = (TextView)objectArray[16];
        TextView textView5 = (TextView)objectArray[18];
        TextView textView6 = (TextView)objectArray[17];
        TextView textView7 = (TextView)objectArray[12];
        TextView textView8 = (TextView)objectArray[28];
        TextView textView9 = (TextView)objectArray[23];
        View view2 = (View)objectArray[39];
        View view3 = (View)objectArray[31];
        View view4 = (View)objectArray[5];
        View view5 = (View)objectArray[29];
        View view6 = (View)objectArray[27];
        View view7 = (View)objectArray[13];
        int n10 = 7;
        super(dataBindingComponent, view, n10, checkBox, checkedTextView, constraintLayout, editText, frameLayout, flowLayout, frameLayout2, constraintLayout2, flowLayout2, frameLayout3, imageView, imageView2, textView, imageView3, imageView4, imageView5, imageView6, linearLayout, linearLayout2, progressBar, progressBar2, progressBar3, scrollView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, view2, view3, view4, view5, view6, view7);
        this.t0 = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.f.setTag(null);
        this.h.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.P = object;
        object.setTag(null);
        object = (TextView)objectArray[19];
        this.Q = object;
        object.setTag(null);
        object = (TextView)objectArray[20];
        this.R = object;
        object.setTag(null);
        object = (TextView)objectArray[21];
        this.S = object;
        object.setTag(null);
        object = (ImageView)objectArray[8];
        this.T = object;
        object.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        this.A.setTag(null);
        this.B.setTag(null);
        this.C.setTag(null);
        this.H.setTag(null);
        this.K.setTag(null);
        object = view;
        this.setRootTag(view);
        super(this, 1);
        this.U = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean G(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.t0;
                long l11 = 64;
                this.t0 = l10 |= l11;
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
    private boolean H(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.t0;
                long l11 = 4;
                this.t0 = l10 |= l11;
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
    private boolean I(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.t0;
                long l11 = 8;
                this.t0 = l10 |= l11;
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
    private boolean J(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.t0;
                long l11 = 16;
                this.t0 = l10 |= l11;
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
    private boolean K(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.t0;
                long l11 = 1L;
                this.t0 = l10 |= l11;
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
    private boolean L(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.t0;
                long l11 = 2;
                this.t0 = l10 |= l11;
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
                long l10 = this.t0;
                long l11 = 32;
                this.t0 = l10 |= l11;
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
    public void C(PublishFragment$f publishFragment$f) {
        this.L = publishFragment$f;
        synchronized (this) {
            long l10 = this.t0;
            long l11 = 128L;
            this.t0 = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(l l10) {
        this.M = l10;
        synchronized (this) {
            long l11 = this.t0;
            long l12 = 1024L;
            this.t0 = l11 |= l12;
        }
        this.notifyPropertyChanged(28);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(j2 j22) {
        this.O = j22;
        synchronized (this) {
            long l10 = this.t0;
            long l11 = 256L;
            this.t0 = l10 |= l11;
        }
        this.notifyPropertyChanged(105);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(g0 g02) {
        this.N = g02;
        synchronized (this) {
            long l10 = this.t0;
            long l11 = 512L;
            this.t0 = l10 |= l11;
        }
        this.notifyPropertyChanged(120);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        PublishFragment$f publishFragment$f = this.L;
        boolean bl2 = publishFragment$f != null;
        if (bl2) {
            publishFragment$f.G();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        long l17;
        long l18;
        long l19;
        long l20;
        long l21;
        boolean bl2;
        boolean bl3;
        long l22;
        Object object;
        Object object2;
        long l23;
        long l24;
        boolean bl4;
        Object object3;
        Object object4;
        int n10;
        long l25;
        long l26;
        long l27;
        boolean bl5;
        long l28;
        boolean bl6;
        int n11;
        Object object5;
        long l29;
        long l30;
        boolean bl7;
        long l31;
        boolean bl8;
        boolean bl9;
        Object object6;
        int n12;
        boolean bl10;
        MutableLiveData mutableLiveData;
        hg$c hg$c;
        Object object7;
        long l32;
        long l33;
        long l34;
        long l35;
        long l36;
        long l37;
        long l38;
        long l39;
        boolean bl11;
        long l40;
        long l41;
        Object object8;
        long l42;
        long l43;
        boolean bl12;
        boolean bl13;
        float f10;
        int n13;
        Object object9;
        Object object10;
        Object object11;
        Object object12;
        Object object13;
        Object object14;
        Object object15;
        Object object16;
        long l44;
        Object object17;
        Object object18;
        Object object19;
        Object object20;
        long l45;
        hg hg2;
        block131: {
            float f11;
            Object object21;
            block144: {
                long l46;
                long l47;
                long l48;
                float f12;
                Object object22;
                block147: {
                    block146: {
                        block145: {
                            float f13;
                            block130: {
                                Object object23;
                                block137: {
                                    boolean bl14;
                                    float f14;
                                    float f15;
                                    float f16;
                                    float f17;
                                    boolean bl15;
                                    block143: {
                                        block142: {
                                            block141: {
                                                long l49;
                                                long l50;
                                                long l51;
                                                long l52;
                                                block140: {
                                                    block139: {
                                                        block138: {
                                                            long l53;
                                                            block135: {
                                                                boolean bl16;
                                                                block136: {
                                                                    Object object24;
                                                                    block133: {
                                                                        block134: {
                                                                            long l54;
                                                                            hg2 = this;
                                                                            synchronized (this) {
                                                                                l45 = this.t0;
                                                                                this.t0 = l54 = 0L;
                                                                            }
                                                                            object20 = this.L;
                                                                            object19 = this.O;
                                                                            object18 = this.N;
                                                                            object17 = this.M;
                                                                            l44 = 0xD8CL & l45;
                                                                            object24 = l44 == l54 ? 0 : (l44 < l54 ? -1 : 1);
                                                                            long l55 = 2176L;
                                                                            if (object24 == false) break block133;
                                                                            long l56 = l45 & l55;
                                                                            long l57 = l56 - l54;
                                                                            object24 = l57 == 0L ? 0 : (l57 < 0L ? -1 : 1);
                                                                            if (object24 != false && object20 != null) {
                                                                                object16 = this.V;
                                                                                if (object16 == null) {
                                                                                    object16 = new hg$k();
                                                                                    this.V = object16;
                                                                                }
                                                                                object16 = ((hg$k)object16).b((PublishFragment$f)object20);
                                                                                object15 = hg2.W;
                                                                                if (object15 == null) {
                                                                                    hg2.W = object15 = new hg$b();
                                                                                }
                                                                                object15 = object15.b((PublishFragment$f)object20);
                                                                                object21 = hg2.X;
                                                                                if (object21 == null) {
                                                                                    object21 = new hg$c();
                                                                                    hg2.X = object21;
                                                                                }
                                                                                object21 = ((hg$c)object21).b((PublishFragment$f)object20);
                                                                                object14 = hg2.Z;
                                                                                if (object14 == null) {
                                                                                    hg2.Z = object14 = new hg$e();
                                                                                }
                                                                                object14 = object14.b((PublishFragment$f)object20);
                                                                                object13 = hg2.k0;
                                                                                if (object13 == null) {
                                                                                    hg2.k0 = object13 = new hg$f();
                                                                                }
                                                                                object13 = object13.b((PublishFragment$f)object20);
                                                                                object12 = hg2.o0;
                                                                                if (object12 == null) {
                                                                                    hg2.o0 = object12 = new hg$g();
                                                                                }
                                                                                object12 = ((hg$g)object12).b((PublishFragment$f)object20);
                                                                                object11 = hg2.q0;
                                                                                if (object11 == null) {
                                                                                    object11 = new hg$i();
                                                                                    hg2.q0 = object11;
                                                                                }
                                                                                object11 = ((hg$i)object11).b((PublishFragment$f)object20);
                                                                                object10 = hg2.r0;
                                                                                if (object10 == null) {
                                                                                    object10 = new hg$j();
                                                                                    hg2.r0 = object10;
                                                                                }
                                                                                object10 = ((hg$j)object10).b((PublishFragment$f)object20);
                                                                                object9 = hg2.s0;
                                                                                if (object9 == null) {
                                                                                    object9 = new hg$a();
                                                                                    hg2.s0 = object9;
                                                                                }
                                                                                object9 = ((hg$a)object9).b((PublishFragment$f)object20);
                                                                            } else {
                                                                                n13 = 0;
                                                                                f10 = 0.0f;
                                                                                object12 = null;
                                                                                object11 = null;
                                                                                object24 = 0;
                                                                                object16 = null;
                                                                                object14 = null;
                                                                                object13 = null;
                                                                                object10 = null;
                                                                                bl13 = false;
                                                                                object9 = null;
                                                                                bl12 = false;
                                                                                f11 = 0.0f;
                                                                                object21 = null;
                                                                                object15 = null;
                                                                            }
                                                                            l43 = 3464L;
                                                                            long l58 = l45 & l43;
                                                                            l42 = 0L;
                                                                            bl16 = l58 == l42 ? 0 : (l58 < l42 ? -1 : 1);
                                                                            if (bl16 && object20 != null) {
                                                                                object8 = object12;
                                                                                object12 = hg2.Y;
                                                                                if (object12 == null) {
                                                                                    hg2.Y = object12 = new hg$d();
                                                                                }
                                                                                object12 = ((hg$d)object12).b((PublishFragment$f)object20);
                                                                            } else {
                                                                                object8 = object12;
                                                                                n13 = 0;
                                                                                f10 = 0.0f;
                                                                                object12 = null;
                                                                            }
                                                                            l41 = 3212L;
                                                                            l53 = l45 & l41;
                                                                            l42 = 0L;
                                                                            l40 = l53 == l42 ? 0 : (l53 < l42 ? -1 : 1);
                                                                            if (l40 == false || object20 == null) break block134;
                                                                            object23 = object12;
                                                                            object12 = hg2.p0;
                                                                            if (object12 == null) {
                                                                                hg2.p0 = object12 = new hg$h();
                                                                            }
                                                                            object20 = ((hg$h)object12).b((PublishFragment$f)object20);
                                                                            object12 = object23;
                                                                            object22 = object8;
                                                                            object8 = object20;
                                                                            object20 = object15;
                                                                            object15 = object21;
                                                                            object21 = object9;
                                                                            object9 = object10;
                                                                            object10 = object13;
                                                                            object13 = object14;
                                                                            object14 = object16;
                                                                            object16 = object11;
                                                                            object11 = object22;
                                                                            break block135;
                                                                        }
                                                                        object23 = object12;
                                                                        object20 = object15;
                                                                        object15 = object21;
                                                                        object21 = object9;
                                                                        object9 = object10;
                                                                        object10 = object13;
                                                                        object13 = object14;
                                                                        object14 = object16;
                                                                        object16 = object11;
                                                                        object11 = object8;
                                                                        break block136;
                                                                    }
                                                                    bl11 = false;
                                                                    object20 = null;
                                                                    n13 = 0;
                                                                    f10 = 0.0f;
                                                                    object12 = null;
                                                                    object11 = null;
                                                                    object24 = 0;
                                                                    object16 = null;
                                                                    object14 = null;
                                                                    object13 = null;
                                                                    object10 = null;
                                                                    bl13 = false;
                                                                    object9 = null;
                                                                    bl12 = false;
                                                                    f11 = 0.0f;
                                                                    object21 = null;
                                                                    object15 = null;
                                                                }
                                                                bl16 = false;
                                                                object8 = null;
                                                            }
                                                            l53 = l45 & 0x913L;
                                                            l42 = 0L;
                                                            l40 = l53 == l42 ? 0 : (l53 < l42 ? -1 : 1);
                                                            l39 = 524288L;
                                                            l38 = 8192L;
                                                            l37 = 262144L;
                                                            l36 = 4096L;
                                                            l35 = 2320L;
                                                            l34 = 2306L;
                                                            l33 = 2305L;
                                                            l32 = 2304L;
                                                            object7 = object12;
                                                            n13 = 0;
                                                            f10 = 0.0f;
                                                            object12 = null;
                                                            if (l40 == false) break block137;
                                                            long l59 = l45 & l33;
                                                            l42 = 0L;
                                                            l40 = l59 == l42 ? 0 : (l59 < l42 ? -1 : 1);
                                                            bl15 = 8 != 0;
                                                            f17 = 1.1E-44f;
                                                            if (l40 == false) break block138;
                                                            if (object19 != null) {
                                                                object22 = ((j2)object19).K();
                                                                hg$c = object21;
                                                                object21 = object22;
                                                            } else {
                                                                hg$c = object21;
                                                                bl12 = false;
                                                                f11 = 0.0f;
                                                                object21 = null;
                                                            }
                                                            hg2.updateLiveDataRegistration(0, (LiveData)object21);
                                                            if (object21 != null) {
                                                                object21 = (Boolean)((LiveData)object21).getValue();
                                                            } else {
                                                                bl12 = false;
                                                                f11 = 0.0f;
                                                                object21 = null;
                                                            }
                                                            bl12 = ViewDataBinding.safeUnbox((Boolean)object21);
                                                            if (l40 != false) {
                                                                l52 = bl12 ? 0x2000000000L : 0x1000000000L;
                                                                l45 |= l52;
                                                            }
                                                            if (bl12) break block139;
                                                            bl12 = bl15;
                                                            f11 = f17;
                                                            break block140;
                                                        }
                                                        hg$c = object21;
                                                    }
                                                    bl12 = false;
                                                    object21 = null;
                                                    f11 = 0.0f;
                                                }
                                                l52 = l45 & l34;
                                                l42 = 0L;
                                                l40 = l52 == l42 ? 0 : (l52 < l42 ? -1 : 1);
                                                if (l40 != false) {
                                                    if (object19 != null) {
                                                        mutableLiveData = ((j2)object19).M();
                                                        bl10 = bl12;
                                                        f16 = f11;
                                                        object12 = mutableLiveData;
                                                    } else {
                                                        bl10 = bl12;
                                                        f16 = f11;
                                                        n13 = 0;
                                                        f10 = 0.0f;
                                                        object12 = null;
                                                    }
                                                    bl12 = true;
                                                    f11 = Float.MIN_VALUE;
                                                    hg2.updateLiveDataRegistration((int)(bl12 ? 1 : 0), (LiveData)object12);
                                                    if (object12 != null) {
                                                        object12 = (Boolean)((LiveData)object12).getValue();
                                                    } else {
                                                        n13 = 0;
                                                        f10 = 0.0f;
                                                        object12 = null;
                                                    }
                                                    n13 = ViewDataBinding.safeUnbox((Boolean)object12);
                                                    if (l40 != false) {
                                                        if (n13 != 0) {
                                                            l45 |= 0x800000L;
                                                            l51 = 0x8000000000L;
                                                        } else {
                                                            l45 |= 0x400000L;
                                                            l51 = 0x4000000000L;
                                                        }
                                                        l45 |= l51;
                                                    }
                                                    if (n13 != 0) {
                                                        object21 = hg2.p.getContext();
                                                        l51 = l45;
                                                        n12 = 2131231614;
                                                        object6 = AppCompatResources.getDrawable((Context)object21, n12);
                                                    } else {
                                                        l51 = l45;
                                                        object6 = hg2.p.getContext();
                                                        bl9 = 2131231595 != 0;
                                                        f12 = 1.8079275E38f;
                                                        object6 = AppCompatResources.getDrawable(object6, (int)(bl9 ? 1 : 0));
                                                    }
                                                    if (n13 != 0) {
                                                        bl9 = bl15;
                                                        f12 = f17;
                                                    } else {
                                                        bl9 = false;
                                                        f12 = 0.0f;
                                                    }
                                                    object12 = object6;
                                                    bl12 = bl9;
                                                    f11 = f12;
                                                    l45 = l51;
                                                } else {
                                                    bl10 = bl12;
                                                    f16 = f11;
                                                    n13 = 0;
                                                    f10 = 0.0f;
                                                    object12 = null;
                                                    bl12 = false;
                                                    f11 = 0.0f;
                                                    object21 = null;
                                                }
                                                l51 = l45 & l32;
                                                l42 = 0L;
                                                l40 = l51 == l42 ? 0 : (l51 < l42 ? -1 : 1);
                                                if (l40 == false) break block141;
                                                if (object19 != null) {
                                                    bl8 = ((j2)object19).W();
                                                    l31 = (long)((j2)object19).X();
                                                    bl7 = ((j2)object19).V();
                                                } else {
                                                    bl8 = false;
                                                    f15 = 0.0f;
                                                    l31 = 0;
                                                    f13 = 0.0f;
                                                    bl7 = false;
                                                }
                                                if (l40 != false) {
                                                    l30 = bl8 ? 131072L : 65536L;
                                                    l45 |= l30;
                                                }
                                                if ((l40 = (l50 = (l30 = l45 & l32) - (l42 = 0L)) == 0L ? 0 : (l50 < 0L ? -1 : 1)) != false) {
                                                    l30 = l31 != false ? 32768L : 16384L;
                                                    l45 |= l30;
                                                }
                                                if ((l40 = (l49 = (l30 = l45 & l32) - l42) == 0L ? 0 : (l49 < 0L ? -1 : 1)) != false) {
                                                    l45 = bl7 ? l45 | l38 | l39 : l45 | l36 | l37;
                                                }
                                                if (bl8) {
                                                    l40 = 0;
                                                    f14 = 0.0f;
                                                    object23 = null;
                                                } else {
                                                    l40 = (long)bl15;
                                                    f14 = f17;
                                                }
                                                if (l31 != false) {
                                                    bl8 = false;
                                                    f15 = 0.0f;
                                                } else {
                                                    bl8 = bl15;
                                                    f15 = f17;
                                                }
                                                if (bl7) {
                                                    l31 = 0;
                                                    f13 = 0.0f;
                                                } else {
                                                    l31 = (long)bl15;
                                                    f13 = f17;
                                                }
                                                if (!bl7) break block142;
                                                bl14 = bl15;
                                                float f18 = f17;
                                                break block143;
                                            }
                                            l40 = 0;
                                            f14 = 0.0f;
                                            object23 = null;
                                            bl8 = false;
                                            f15 = 0.0f;
                                            l31 = 0;
                                            f13 = 0.0f;
                                            bl7 = false;
                                        }
                                        bl14 = false;
                                        float f19 = 0.0f;
                                    }
                                    long l60 = l45 & l35;
                                    l42 = 0L;
                                    long l61 = l60 == l42 ? 0 : (l60 < l42 ? -1 : 1);
                                    if (l61 != false) {
                                        float f20;
                                        boolean bl17;
                                        Object object25;
                                        if (object19 != null) {
                                            object25 = ((j2)object19).J();
                                            bl17 = bl12;
                                            f20 = f11;
                                            object22 = object25;
                                            object25 = object12;
                                            object12 = object22;
                                        } else {
                                            object25 = object12;
                                            bl17 = bl12;
                                            f20 = f11;
                                            n13 = 0;
                                            f10 = 0.0f;
                                            object12 = null;
                                        }
                                        bl12 = 4 != 0;
                                        f11 = 5.6E-45f;
                                        hg2.updateLiveDataRegistration((int)(bl12 ? 1 : 0), (LiveData)object12);
                                        if (object12 != null) {
                                            object12 = (Boolean)((LiveData)object12).getValue();
                                        } else {
                                            n13 = 0;
                                            f10 = 0.0f;
                                            object12 = null;
                                        }
                                        n13 = (int)(ViewDataBinding.safeUnbox((Boolean)object12) ? 1 : 0);
                                        if (l61 != false) {
                                            l29 = n13 != 0 ? 0x20000000L : 0x10000000L;
                                            l45 |= l29;
                                        }
                                        if (n13 != 0) {
                                            bl15 = false;
                                            f17 = 0.0f;
                                            object5 = null;
                                        }
                                        n13 = (int)l40;
                                        f10 = f14;
                                        l40 = (long)bl10;
                                        f14 = f16;
                                        bl12 = bl8;
                                        f11 = f15;
                                        n11 = l31;
                                        bl6 = bl14;
                                        bl10 = bl17;
                                        f16 = f20;
                                        bl8 = bl15;
                                        f15 = f17;
                                        object5 = object25;
                                        break block130;
                                    } else {
                                        Object object26 = object12;
                                        boolean bl18 = bl12;
                                        float f21 = f11;
                                        n13 = l40;
                                        f10 = f14;
                                        l40 = (long)bl10;
                                        f14 = f16;
                                        bl12 = bl8;
                                        f11 = f15;
                                        n11 = l31;
                                        bl6 = bl14;
                                        object5 = object12;
                                        bl10 = bl18;
                                        f16 = f21;
                                        bl8 = false;
                                        f15 = 0.0f;
                                    }
                                    break block130;
                                }
                                hg$c = object21;
                                n13 = 0;
                                f10 = 0.0f;
                                object12 = null;
                                bl12 = false;
                                f11 = 0.0f;
                                object21 = null;
                                l40 = 0;
                                float f22 = 0.0f;
                                object23 = null;
                                boolean bl19 = false;
                                float f23 = 0.0f;
                                object5 = null;
                                bl10 = false;
                                float f24 = 0.0f;
                                bl8 = false;
                                float f25 = 0.0f;
                                bl7 = false;
                                n11 = 0;
                                bl6 = false;
                            }
                            l30 = 2592L;
                            l28 = l45 & l30;
                            l42 = 0L;
                            l31 = l28 == l42 ? 0 : (l28 < l42 ? -1 : 1);
                            if (l31 != false) {
                                if (object18 != null) {
                                    object18 = ((g0)object18).y();
                                    l31 = (long)bl12;
                                    f13 = f11;
                                } else {
                                    l31 = (long)bl12;
                                    f13 = f11;
                                    bl5 = false;
                                    object18 = null;
                                }
                                bl12 = 5 != 0;
                                f11 = 7.0E-45f;
                                hg2.updateLiveDataRegistration((int)(bl12 ? 1 : 0), (LiveData)object18);
                                if (object18 != null) {
                                    object18 = (Boolean)((LiveData)object18).getValue();
                                } else {
                                    bl5 = false;
                                    object18 = null;
                                }
                                bl5 = ViewDataBinding.safeUnbox((Boolean)object18);
                            } else {
                                l31 = (long)bl12;
                                f13 = f11;
                                bl5 = false;
                                object18 = null;
                            }
                            l28 = l45 & 0xDCCL;
                            l42 = 0L;
                            bl12 = (boolean)(l28 == l42 ? 0 : (l28 < l42 ? -1 : 1));
                            l28 = 3144L;
                            l29 = 0x8000000L;
                            l27 = 0x40000000L;
                            l26 = 0x1000000L;
                            l25 = 3136L;
                            if (!bl12) break block144;
                            l41 = 3212L;
                            long l62 = l45 & l41;
                            long l63 = l62 - l42;
                            bl12 = (boolean)(l63 == 0L ? 0 : (l63 < 0L ? -1 : 1));
                            if (!bl12) break block145;
                            if (object17 != null) {
                                object21 = ((l)object17).w();
                                n10 = n13;
                            } else {
                                n10 = n13;
                                bl12 = false;
                                f11 = 0.0f;
                                object21 = null;
                            }
                            n13 = 2;
                            f10 = 2.8E-45f;
                            hg2.updateLiveDataRegistration(n13, (LiveData)object21);
                            if (object21 != null) {
                                object12 = (String)((LiveData)object21).getValue();
                            } else {
                                n13 = 0;
                                f10 = 0.0f;
                                object12 = null;
                            }
                            if (object12 == null) break block146;
                            bl12 = true;
                            f11 = Float.MIN_VALUE;
                            break block147;
                        }
                        n10 = n13;
                    }
                    bl12 = false;
                    f11 = 0.0f;
                    object21 = null;
                }
                if (object17 != null) {
                    object12 = ((l)object17).A();
                    object4 = object9;
                } else {
                    object4 = object9;
                    n13 = 0;
                    f10 = 0.0f;
                    object12 = null;
                }
                bl13 = 3 != 0;
                hg2.updateLiveDataRegistration((int)(bl13 ? 1 : 0), (LiveData)object12);
                if (object12 != null) {
                    object12 = (String)((LiveData)object12).getValue();
                } else {
                    n13 = 0;
                    f10 = 0.0f;
                    object12 = null;
                }
                bl13 = s1.q((String)object12);
                long l64 = l45 & l28;
                l42 = 0L;
                long l65 = l64 == l42 ? 0 : (l64 < l42 ? -1 : 1);
                if (l65 != false) {
                    if (bl13) {
                        l64 = 0x2000000L;
                        l45 |= l64;
                    } else {
                        l45 |= l26;
                    }
                }
                if ((l65 = (l48 = (l64 = l45 & (l43 = 3464L)) - l42) == 0L ? 0 : (l48 < 0L ? -1 : 1)) != false) {
                    if (bl13) {
                        l45 |= l29;
                    } else {
                        l64 = 0x4000000L;
                        l45 |= l64;
                    }
                }
                if ((l65 = (l47 = (l64 = l45 & (l41 = 3212L)) - l42) == 0L ? 0 : (l47 < 0L ? -1 : 1)) != false) {
                    bl12 &= bl13;
                    if (l65 != false) {
                        l64 = bl12 ? 0x200000000L : 0x100000000L;
                        l45 |= l64;
                    }
                } else {
                    bl12 = false;
                    f11 = 0.0f;
                    object21 = null;
                }
                if ((l65 = (l46 = (l64 = l45 & l25) - (l42 = 0L)) == 0L ? 0 : (l46 < 0L ? -1 : 1)) != false) {
                    long l66;
                    long l67;
                    boolean bl20;
                    if (object17 != null) {
                        object3 = ((l)object17).p();
                        bl20 = bl13;
                        object22 = object3;
                        object3 = object12;
                        object12 = object22;
                    } else {
                        object3 = object12;
                        bl20 = bl13;
                        n13 = 0;
                        f10 = 0.0f;
                        object12 = null;
                    }
                    bl13 = 6 != 0;
                    hg2.updateLiveDataRegistration((int)(bl13 ? 1 : 0), (LiveData)object12);
                    if (object12 != null) {
                        object9 = (Exception)((LiveData)object12).getValue();
                    } else {
                        bl13 = false;
                        object9 = null;
                    }
                    bl4 = object9 != null;
                    l24 = l45 & l27;
                    l42 = 0L;
                    l23 = l24 == l42 ? 0 : (l24 < l42 ? -1 : 1);
                    if (l23 != false) {
                        l24 = bl4 ? 0x200000L : 0x100000L;
                        l45 |= l24;
                    }
                    if ((l23 = (l67 = (l24 = l45 & l25) - l42) == 0L ? 0 : (l67 < 0L ? -1 : 1)) != false) {
                        l24 = bl4 ? 0x800000000L : 0x400000000L;
                        l45 |= l24;
                    }
                    if (bl4) {
                        l66 = l45;
                        object6 = hg2.z.getContext();
                        bl9 = 2131231333 != 0;
                        f12 = 1.8078744E38f;
                        object6 = AppCompatResources.getDrawable(object6, (int)(bl9 ? 1 : 0));
                    } else {
                        l66 = l45;
                        n12 = 0;
                        object6 = null;
                    }
                    object22 = object12;
                    object12 = object6;
                    l45 = l66;
                    bl4 = bl12;
                    bl12 = bl20;
                    object2 = object9;
                    object9 = object3;
                    object3 = object22;
                    break block131;
                } else {
                    object3 = object12;
                    boolean bl21 = bl13;
                    bl4 = bl12;
                    object9 = object12;
                    bl12 = bl13;
                    n13 = 0;
                    f10 = 0.0f;
                    object12 = null;
                    l65 = 0;
                    object3 = null;
                    bl21 = false;
                    object2 = null;
                }
                break block131;
            }
            n10 = n13;
            object4 = object9;
            n13 = 0;
            f10 = 0.0f;
            object12 = null;
            bl13 = false;
            object9 = null;
            bl12 = false;
            f11 = 0.0f;
            object21 = null;
            boolean bl22 = false;
            object3 = null;
            boolean bl23 = false;
            object2 = null;
            bl4 = false;
        }
        l24 = l45 & 0x101000000L;
        l42 = 0L;
        l23 = l24 == l42 ? 0 : (l24 < l42 ? -1 : 1);
        if (l23 != false) {
            object = object12;
            if (object9 != null) {
                object12 = "http";
                n13 = (int)(((String)object9).startsWith((String)object12) ? 1 : 0);
            } else {
                n13 = 0;
                f10 = 0.0f;
                object12 = null;
            }
            long l68 = l45 & l26;
            bl13 = (boolean)(l68 == l42 ? 0 : (l68 < l42 ? -1 : 1));
            if (bl13) {
                if (n13 != 0) {
                    l68 = 0x80000000L;
                    l45 |= l68;
                } else {
                    l45 |= l27;
                }
            }
        } else {
            object = object12;
            n13 = 0;
            f10 = 0.0f;
            object12 = null;
        }
        if (bl13 = (boolean)((l22 = (l29 = l45 & l29) - l42) == 0L ? 0 : (l22 < 0L ? -1 : 1))) {
            long l69;
            if (object19 != null) {
                bl7 = ((j2)object19).V();
            }
            if (bl3 = (l69 = (l29 = l45 & l32) - l42) == 0L ? 0 : (l69 < 0L ? -1 : 1)) {
                l45 = bl7 ? l45 | l38 | l39 : l45 | l36 | l37;
            }
            bl3 = true;
            bl13 = bl7 ^ true;
        } else {
            bl3 = true;
            bl13 = false;
            object9 = null;
        }
        l43 = 3464L;
        l39 = l45 & l43;
        l42 = 0L;
        long l70 = l39 == l42 ? 0 : (l39 < l42 ? -1 : 1);
        if (l70 == false || !bl12) {
            bl13 = false;
            object9 = null;
        }
        l41 = 3212L;
        l39 = l45 & l41;
        l70 = l39 == l42 ? 0 : (l39 < l42 ? -1 : 1);
        if (l70 != false) {
            l70 = bl4 ? (long)bl3 : (long)n13;
            bl3 = (boolean)l70;
        } else {
            bl3 = false;
            object19 = null;
        }
        l39 = l45 & l27;
        l70 = l39 == l42 ? 0 : (l39 < l42 ? -1 : 1);
        if (l70 != false) {
            long l71;
            boolean bl24;
            if (object17 != null) {
                object17 = ((l)object17).p();
                bl2 = bl3;
            } else {
                bl2 = bl3;
                object17 = object3;
            }
            bl3 = 6 != 0;
            hg2.updateLiveDataRegistration((int)(bl3 ? 1 : 0), (LiveData)object17);
            if (object17 != null) {
                object2 = object19 = ((LiveData)object17).getValue();
                object2 = (Exception)object19;
            }
            if (object2 != null) {
                bl24 = true;
            } else {
                bl24 = false;
                mutableLiveData = null;
            }
            if (l70 != false) {
                l38 = bl24 ? 0x200000L : 0x100000L;
                l45 |= l38;
            }
            if (bl3 = (boolean)((l71 = (l38 = l45 & l25) - (l42 = 0L)) == 0L ? 0 : (l71 < 0L ? -1 : 1))) {
                l38 = bl24 ? 0x800000000L : 0x400000000L;
                l45 |= l38;
            }
            object19 = bl24 ? "@string/media_compose_failure" : "@string/media_composing";
        } else {
            bl2 = bl3;
            bl3 = false;
            object19 = null;
        }
        l38 = l45 & l26;
        l42 = 0L;
        long l72 = l38 == l42 ? 0 : (l38 < l42 ? -1 : 1);
        if (l72 != false) {
            if (n13 != 0) {
                object19 = "@string/publish_works";
            }
        } else {
            bl3 = false;
            object19 = null;
        }
        if ((n13 = (int)((l21 = (l38 = l45 & l28) - l42) == 0L ? 0 : (l21 < 0L ? -1 : 1))) != 0) {
            if (bl12) {
                object19 = "@string/publish_works";
            }
        } else {
            bl3 = false;
            object19 = null;
        }
        if ((l72 = (l20 = (l38 = l45 & l30) - l42) == 0L ? 0 : (l20 < 0L ? -1 : 1)) != false) {
            object17 = hg2.a;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)object17, bl5);
        }
        if (bl5 = (l19 = (l18 = 0x880L & l45) - l42) == 0L ? 0 : (l19 < 0L ? -1 : 1)) {
            hg2.b.setOnClickListener((View.OnClickListener)object16);
            hg2.q.setOnClickListener((View.OnClickListener)object15);
            object18 = hg2.Q;
            object18.setOnClickListener((View.OnClickListener)object20);
            hg2.R.setOnClickListener((View.OnClickListener)object13);
            hg2.S.setOnClickListener((View.OnClickListener)object10);
            hg2.y.setOnClickListener((View.OnClickListener)object14);
            hg2.A.setOnClickListener((View.OnClickListener)object11);
            object20 = hg2.B;
            object10 = object4;
            object20.setOnClickListener((View.OnClickListener)object4);
            object20 = hg2.K;
            object11 = hg$c;
            object20.setOnClickListener((View.OnClickListener)hg$c);
        }
        if (bl11 = (l17 = (l18 = l45 & l32) - (l44 = 0L)) == 0L ? 0 : (l17 < 0L ? -1 : 1)) {
            hg2.b.setVisibility(n10);
            object20 = hg2.f;
            bl5 = l31;
            object20.setVisibility((int)l31);
            object20 = hg2.l;
            l72 = (long)bl6;
            object20.setVisibility((int)(bl6 ? 1 : 0));
            hg2.m.setVisibility((int)(bl6 ? 1 : 0));
            hg2.z.setVisibility((int)(bl6 ? 1 : 0));
            object20 = hg2.A;
            l72 = n11;
            object20.setVisibility(n11);
            hg2.B.setVisibility(n11);
            hg2.C.setVisibility(n10);
            hg2.H.setVisibility((int)l31);
            object20 = hg2.K;
            object20.setVisibility(n10);
        }
        if (bl11 = (l16 = (l18 = 0x800L & l45) - (l44 = 0L)) == 0L ? 0 : (l16 < 0L ? -1 : 1)) {
            object20 = hg2.c;
            object11 = hg2.U;
            object20.setOnClickListener((View.OnClickListener)object11);
        }
        if (bl11 = (l15 = (l18 = l45 & l35) - l44) == 0L ? 0 : (l15 < 0L ? -1 : 1)) {
            object20 = hg2.c;
            object20.setVisibility((int)(bl8 ? 1 : 0));
        }
        if (bl11 = (l14 = (l18 = l45 & l34) - l44) == 0L ? 0 : (l14 < 0L ? -1 : 1)) {
            hg2.h.setVisibility((int)(bl10 ? 1 : 0));
            object20 = hg2.p;
            object11 = object5;
            ImageViewBindingAdapter.setImageDrawable((ImageView)object20, (Drawable)object5);
        }
        if (bl11 = (l13 = (l18 = 0xD88L & l45) - l44) == 0L ? 0 : (l13 < 0L ? -1 : 1)) {
            object20 = hg2.k;
            object11 = object7;
            ViewBindingAdapter.setOnClick((View)object20, (View.OnClickListener)object7, bl13);
        } else {
            object11 = object7;
        }
        l18 = 0xC88L & l45;
        bl11 = l18 == l44 ? 0 : (l18 < l44 ? -1 : 1);
        if (bl11) {
            object20 = hg2.m;
            ViewBindingAdapter.setOnClick((View)object20, (View.OnClickListener)object11, bl12);
        }
        if (bl11 = (l12 = (l18 = l45 & l33) - l44) == 0L ? 0 : (l12 < 0L ? -1 : 1)) {
            object20 = hg2.T;
            object20.setVisibility((int)l40);
        }
        if (bl11 = (l11 = (l18 = l45 & l25) - l44) == 0L ? 0 : (l11 < 0L ? -1 : 1)) {
            object20 = hg2.z;
            object11 = object;
            TextViewBindingAdapter.setDrawableEnd((TextView)object20, (Drawable)object);
        }
        if (bl11 = (l10 = (l45 &= (l18 = 3212L)) - l44) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            object20 = hg2.z;
            object6 = object8;
            bl9 = bl2;
            ViewBindingAdapter.setOnClick((View)object20, (View.OnClickListener)object8, bl2);
        }
        if (n13 != 0) {
            object20 = hg2.z;
            n12 = 0;
            object6 = null;
            l.a.q.g0.u.n((TextView)object20, (String)object19, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.t0;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 == false) return false;
            return (boolean)((long)1);
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
            this.t0 = l10 = 2048L;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        switch (n10) {
            default: {
                return false;
            }
            case 6: {
                object = (MutableLiveData)object;
                return this.G((MutableLiveData)object, n11);
            }
            case 5: {
                object = (LiveData)object;
                return this.M((LiveData)object, n11);
            }
            case 4: {
                object = (MutableLiveData)object;
                return this.J((MutableLiveData)object, n11);
            }
            case 3: {
                object = (MutableLiveData)object;
                return this.I((MutableLiveData)object, n11);
            }
            case 2: {
                object = (MutableLiveData)object;
                return this.H((MutableLiveData)object, n11);
            }
            case 1: {
                object = (MutableLiveData)object;
                return this.L((MutableLiveData)object, n11);
            }
            case 0: 
        }
        object = (MutableLiveData)object;
        return this.K((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (PublishFragment$f)object;
            this.C((PublishFragment$f)object);
            return 1 != 0;
        } else {
            n11 = 105;
            if (n11 == n10) {
                object = (j2)object;
                this.E((j2)object);
                return 1 != 0;
            } else {
                n11 = 120;
                if (n11 == n10) {
                    object = (g0)object;
                    this.F((g0)object);
                    return 1 != 0;
                } else {
                    n11 = 28;
                    if (n11 != n10) return 0 != 0;
                    object = (l)object;
                    this.D((l)object);
                }
            }
        }
        return 1 != 0;
    }
}

