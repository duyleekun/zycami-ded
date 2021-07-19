/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.ProgressBar
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.main.home.ExViewPager;
import com.zhiyun.cama.main.me.MeFragment$b;
import d.v.c.f1.a.b$a;
import d.v.c.i1.t2.i0;
import d.v.c.m1.c;
import d.v.c.w0.cf;
import d.v.c.w0.df$a;
import d.v.c.w0.df$b;
import d.v.c.w0.df$c;
import d.v.c.w0.df$d;
import d.v.c.w0.df$e;
import d.v.c.w0.df$f;
import d.v.c.w0.df$g;

public class df
extends cf
implements b$a {
    private static final ViewDataBinding$IncludedLayouts S;
    private static final SparseIntArray T;
    private final ConstraintLayout G;
    private final ImageView H;
    private final ImageButton I;
    private final View.OnClickListener J;
    private df$g K;
    private df$a L;
    private df$b M;
    private df$c N;
    private df$d O;
    private df$e P;
    private df$f Q;
    private long R;

    static {
        SparseIntArray sparseIntArray;
        T = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363728, 16);
        sparseIntArray.put(2131362746, 17);
        sparseIntArray.put(2131362826, 18);
        sparseIntArray.put(2131362184, 19);
        sparseIntArray.put(2131362725, 20);
        sparseIntArray.put(2131363541, 21);
        sparseIntArray.put(2131363540, 22);
        sparseIntArray.put(2131363683, 23);
        sparseIntArray.put(2131362056, 24);
        sparseIntArray.put(2131363067, 25);
        sparseIntArray.put(2131363039, 26);
        sparseIntArray.put(2131363743, 27);
        sparseIntArray.put(2131362670, 28);
        sparseIntArray.put(2131362984, 29);
        sparseIntArray.put(2131362671, 30);
        sparseIntArray.put(2131363438, 31);
    }

    public df(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = S;
        SparseIntArray sparseIntArray = T;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 32, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private df(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object = this;
        RadioGroup radioGroup = (RadioGroup)objectArray[24];
        ConstraintLayout constraintLayout = (ConstraintLayout)((Object)objectArray[19]);
        RelativeLayout relativeLayout = (RelativeLayout)objectArray[13];
        FrameLayout frameLayout = (FrameLayout)objectArray[11];
        FrameLayout frameLayout2 = (FrameLayout)objectArray[12];
        ImageView imageView = (ImageView)objectArray[4];
        ImageView imageView2 = (ImageView)objectArray[1];
        ImageView imageView3 = (ImageView)objectArray[28];
        ImageView imageView4 = (ImageView)objectArray[30];
        ImageView imageView5 = (ImageView)objectArray[3];
        ImageView imageView6 = (ImageView)objectArray[6];
        ImageView imageView7 = (ImageView)objectArray[20];
        ImageView imageView8 = (ImageView)objectArray[2];
        ImageView imageView9 = (ImageView)objectArray[17];
        LinearLayout linearLayout = (LinearLayout)objectArray[18];
        ProgressBar progressBar = (ProgressBar)objectArray[29];
        RadioButton radioButton = (RadioButton)objectArray[26];
        RadioButton radioButton2 = (RadioButton)objectArray[25];
        TextView textView = (TextView)objectArray[7];
        TextView textView2 = (TextView)objectArray[8];
        TextView textView3 = (TextView)objectArray[31];
        TextView textView4 = (TextView)objectArray[5];
        TextView textView5 = (TextView)objectArray[10];
        TextView textView6 = (TextView)objectArray[22];
        TextView textView7 = (TextView)objectArray[21];
        TextView textView8 = (TextView)objectArray[9];
        View view2 = (View)objectArray[23];
        View view3 = (View)objectArray[16];
        ExViewPager exViewPager = (ExViewPager)((Object)objectArray[27]);
        int n10 = 1;
        super(dataBindingComponent, view, n10, radioGroup, constraintLayout, relativeLayout, frameLayout, frameLayout2, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, linearLayout, progressBar, radioButton, radioButton2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, view2, view3, exViewPager);
        this.R = -1;
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.m.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.G = object;
        object.setTag(null);
        object = (ImageView)objectArray[14];
        this.H = object;
        object.setTag(null);
        object = (ImageButton)objectArray[15];
        this.I = object;
        object.setTag(null);
        this.s.setTag(null);
        this.t.setTag(null);
        this.v.setTag(null);
        this.w.setTag(null);
        this.z.setTag(null);
        object = view;
        this.setRootTag(view);
        super(this, 1);
        this.J = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.R;
                long l11 = 1L;
                this.R = l10 |= l11;
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
    public void B(MeFragment$b meFragment$b) {
        this.D = meFragment$b;
        synchronized (this) {
            long l10 = this.R;
            long l11 = 4;
            this.R = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    public void C(c c10) {
        this.F = c10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(i0 i02) {
        this.E = i02;
        synchronized (this) {
            long l10 = this.R;
            long l11 = 8;
            this.R = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        MeFragment$b meFragment$b = this.D;
        boolean bl2 = meFragment$b != null;
        if (bl2) {
            meFragment$b.b(view);
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
        int n10;
        int n11;
        long l14;
        long l15;
        int n12;
        int n13;
        df$e df$e;
        Object object;
        df$c df$c;
        df$b df$b;
        Object object2;
        df$g df$g;
        long l16;
        long l17;
        df df2 = this;
        synchronized (this) {
            l17 = this.R;
            this.R = l16 = 0L;
        }
        Object object3 = this.D;
        Object object4 = this.E;
        long l18 = 29;
        long l19 = l17 & l18;
        Object object5 = l19 == l16 ? 0 : (l19 < l16 ? -1 : 1);
        long l20 = 20;
        long l21 = 25;
        int n14 = 0;
        if (object5 != false) {
            long l22;
            Object object6;
            Object object7;
            long l23 = l17 & l20;
            long l24 = l23 - l16;
            object5 = l24 == 0L ? 0 : (l24 < 0L ? -1 : 1);
            if (object5 != false && object3 != null) {
                df$g = this.K;
                if (df$g == null) {
                    this.K = df$g = new df$g();
                }
                df$g = df$g.b((MeFragment$b)object3);
                object2 = df2.L;
                if (object2 == null) {
                    object2 = new df$a();
                    df2.L = object2;
                }
                object2 = ((df$a)object2).b((MeFragment$b)object3);
                df$b = df2.M;
                if (df$b == null) {
                    df2.M = df$b = new df$b();
                }
                df$b = df$b.b((MeFragment$b)object3);
                df$c = df2.N;
                if (df$c == null) {
                    df2.N = df$c = new df$c();
                }
                df$c = df$c.b((MeFragment$b)object3);
                object = df2.O;
                if (object == null) {
                    object = new df$d();
                    df2.O = object;
                }
                object = ((df$d)object).b((MeFragment$b)object3);
                df$e = df2.P;
                if (df$e == null) {
                    df2.P = df$e = new df$e();
                }
                df$e = df$e.b((MeFragment$b)object3);
            } else {
                df$b = null;
                df$c = null;
                object5 = 0;
                df$g = null;
                object = null;
                df$e = null;
                object2 = null;
            }
            if (object3 != null) {
                object7 = df2.Q;
                if (object7 == null) {
                    df2.Q = object7 = new df$f();
                }
                object3 = ((df$f)object7).b((MeFragment$b)object3);
            } else {
                n13 = 0;
                object3 = null;
            }
            if (object4 != null) {
                object7 = ((i0)object4).d();
            } else {
                n12 = 0;
                object7 = null;
            }
            df2.updateLiveDataRegistration(0, (LiveData)object7);
            if (object7 != null) {
                object6 = object7 = (Boolean)((LiveData)object7).getValue();
            } else {
                l15 = 0;
                object6 = null;
            }
            n12 = ViewDataBinding.safeUnbox((Boolean)object6);
            long l25 = l17 & l21;
            l14 = 0L;
            n11 = l25 == l14 ? 0 : (l25 < l14 ? -1 : 1);
            if (n11 != 0) {
                if (n12 != 0) {
                    l17 = l17 | (long)64 | 0x100L;
                    l25 = 1024L;
                } else {
                    l17 = l17 | (long)32 | 0x80L;
                    l25 = 512L;
                }
                l17 |= l25;
            }
            if ((n11 = (l22 = (l25 = l17 & l21) - (l14 = 0L)) == 0L ? 0 : (l22 < 0L ? -1 : 1)) != 0) {
                if (n12 != 0) {
                    n11 = 0;
                    float f10 = 0.0f;
                } else {
                    n11 = 8;
                    float f11 = 1.1E-44f;
                }
                n10 = 4;
                float f12 = 5.6E-45f;
                if (n12 != 0) {
                    l15 = n10;
                } else {
                    l15 = 0;
                    object6 = null;
                }
                if (n12 == 0) {
                    n14 = n10;
                }
                object4 = object2;
                l13 = 20;
                object2 = object;
                object = object3;
                n13 = (int)l15;
                int n15 = n11;
                n11 = n12;
                n12 = n14;
                n14 = n15;
            } else {
                n11 = n12;
                n12 = 0;
                object7 = null;
                object4 = object2;
                l13 = 20;
                object2 = object;
                object = object3;
                n13 = 0;
                object3 = null;
            }
        } else {
            l13 = l20;
            n13 = 0;
            object3 = null;
            n12 = 0;
            Object var26_20 = null;
            n11 = 0;
            float f13 = 0.0f;
            n10 = 0;
            float f14 = 0.0f;
            object4 = null;
            df$b = null;
            df$c = null;
            object5 = 0;
            df$g = null;
            object = null;
            df$e = null;
            object2 = null;
        }
        l13 = l17 & l13;
        l14 = 0L;
        l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        if (l15 != false) {
            df2.c.setOnClickListener((View.OnClickListener)object2);
            df2.e.setOnClickListener((View.OnClickListener)object2);
            ImageView imageView = df2.j;
            imageView.setOnClickListener((View.OnClickListener)object4);
            df2.k.setOnClickListener((View.OnClickListener)df$c);
            df2.m.setOnClickListener((View.OnClickListener)df$b);
            df2.H.setOnClickListener((View.OnClickListener)df$g);
            df2.I.setOnClickListener((View.OnClickListener)df$e);
            df2.w.setOnClickListener((View.OnClickListener)df$c);
            object4 = df2.z;
            object4.setOnClickListener((View.OnClickListener)df$c);
            l12 = 25;
        } else {
            l12 = l21;
        }
        long l26 = 0L;
        long l27 = (l12 &= l17) - l26;
        n10 = l27 == 0L ? 0 : (l27 < 0L ? -1 : 1);
        if (n10 != 0) {
            df2.d.setVisibility(n14);
            object4 = df2.g;
            object4.setVisibility(n13);
            df2.j.setVisibility(n12);
            object3 = df2.m;
            object3.setVisibility(n12);
        }
        if ((n13 = (int)((l11 = (l12 = (long)29 & l17) - (l26 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) != 0) {
            ViewBindingAdapter.setOnClick((View)df2.f, (View.OnClickListener)object, n11 != 0);
            ViewBindingAdapter.setOnClick((View)df2.s, (View.OnClickListener)object, n11 != 0);
            ViewBindingAdapter.setOnClick((View)df2.t, (View.OnClickListener)object, n11 != 0);
            object3 = df2.v;
            ViewBindingAdapter.setOnClick((View)object3, (View.OnClickListener)object, n11 != 0);
        }
        if ((n13 = (int)((l10 = (l17 &= (long)16) - (l16 = 0L)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0) {
            object3 = df2.g;
            View.OnClickListener onClickListener = df2.J;
            object3.setOnClickListener(onClickListener);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.R;
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
            this.R = l10 = (long)16;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (MutableLiveData)object;
        return this.E((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 103;
        if (n11 == n10) {
            object = (c)object;
            this.C((c)object);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 == n10) {
                object = (MeFragment$b)object;
                this.B((MeFragment$b)object);
                return 1 != 0;
            } else {
                n11 = 152;
                if (n11 != n10) return 0 != 0;
                object = (i0)object;
                this.D((i0)object);
            }
        }
        return 1 != 0;
    }
}

