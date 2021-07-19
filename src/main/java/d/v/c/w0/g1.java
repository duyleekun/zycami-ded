/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import d.v.c.f1.a.b$a;
import d.v.c.s0.a7.d1$a;
import d.v.c.s0.s6;
import d.v.c.w0.f1;
import l.a.q.g0.u;

public class g1
extends f1
implements b$a {
    private static final ViewDataBinding$IncludedLayouts p0;
    private static final SparseIntArray q0;
    private final ConstraintLayout P;
    private final View.OnClickListener Q;
    private final View.OnClickListener R;
    private final View.OnClickListener S;
    private final View.OnClickListener T;
    private final View.OnClickListener U;
    private final View.OnClickListener V;
    private final View.OnClickListener W;
    private final View.OnClickListener X;
    private final View.OnClickListener Y;
    private final View.OnClickListener Z;
    private long k0;
    private long o0;

    static {
        SparseIntArray sparseIntArray;
        q0 = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363608, 36);
        sparseIntArray.put(2131362799, 37);
        sparseIntArray.put(2131363119, 38);
        sparseIntArray.put(2131362155, 39);
    }

    public g1(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = p0;
        SparseIntArray sparseIntArray = q0;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 40, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private g1(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        long l10;
        Object object = this;
        Button button = (Button)objectArray[35];
        Button button2 = (Button)objectArray[1];
        Guideline guideline = (Guideline)((Object)objectArray[39]);
        ImageView imageView = (ImageView)objectArray[11];
        ImageView imageView2 = (ImageView)objectArray[12];
        ImageView imageView3 = (ImageView)objectArray[14];
        ImageView imageView4 = (ImageView)objectArray[15];
        ImageView imageView5 = (ImageView)objectArray[29];
        ImageView imageView6 = (ImageView)objectArray[30];
        ImageView imageView7 = (ImageView)objectArray[26];
        ImageView imageView8 = (ImageView)objectArray[27];
        ImageView imageView9 = (ImageView)objectArray[17];
        ImageView imageView10 = (ImageView)objectArray[18];
        ImageView imageView11 = (ImageView)objectArray[23];
        ImageView imageView12 = (ImageView)objectArray[24];
        ImageView imageView13 = (ImageView)objectArray[20];
        ImageView imageView14 = (ImageView)objectArray[21];
        ImageView imageView15 = (ImageView)objectArray[32];
        ImageView imageView16 = (ImageView)objectArray[33];
        View view2 = (View)objectArray[37];
        View view3 = (View)objectArray[38];
        TextView textView = (TextView)objectArray[13];
        TextView textView2 = (TextView)objectArray[16];
        TextView textView3 = (TextView)objectArray[31];
        TextView textView4 = (TextView)objectArray[8];
        TextView textView5 = (TextView)objectArray[10];
        TextView textView6 = (TextView)objectArray[9];
        TextView textView7 = (TextView)objectArray[28];
        TextView textView8 = (TextView)objectArray[19];
        TextView textView9 = (TextView)objectArray[25];
        TextView textView10 = (TextView)objectArray[22];
        TextView textView11 = (TextView)objectArray[34];
        TextView textView12 = (TextView)objectArray[2];
        TextView textView13 = (TextView)objectArray[5];
        TextView textView14 = (TextView)objectArray[4];
        TextView textView15 = (TextView)objectArray[7];
        TextView textView16 = (TextView)objectArray[3];
        TextView textView17 = (TextView)objectArray[6];
        TextView textView18 = (TextView)objectArray[36];
        int n10 = 4;
        super(dataBindingComponent, view, n10, button, button2, guideline, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, imageView13, imageView14, imageView15, imageView16, view2, view3, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18);
        this.k0 = l10 = (long)-1;
        this.o0 = l10;
        this.a.setTag(null);
        this.b.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.P = object;
        object.setTag(null);
        this.v.setTag(null);
        this.w.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        this.A.setTag(null);
        this.B.setTag(null);
        this.C.setTag(null);
        this.D.setTag(null);
        this.E.setTag(null);
        this.F.setTag(null);
        this.G.setTag(null);
        this.H.setTag(null);
        this.I.setTag(null);
        this.J.setTag(null);
        this.K.setTag(null);
        this.L.setTag(null);
        object = view;
        this.setRootTag(view);
        super(this, 6);
        this.Q = object;
        super(this, 10);
        this.R = object;
        super(this, 7);
        this.S = object;
        super(this, 4);
        this.T = object;
        super(this, 5);
        this.U = object;
        super(this, 9);
        this.V = object;
        super(this, 8);
        this.W = object;
        super(this, 2);
        this.X = object;
        super(this, 3);
        this.Y = object;
        super(this, 1);
        this.Z = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.k0;
                long l11 = 8;
                this.k0 = l10 |= l11;
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
    private boolean D(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.k0;
                long l11 = 1L;
                this.k0 = l10 |= l11;
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
    private boolean E(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.k0;
                long l11 = 2;
                this.k0 = l10 |= l11;
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
    private boolean F(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.k0;
                long l11 = 4;
                this.k0 = l10 |= l11;
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
    public void A(s6 s62) {
        this.O = s62;
        synchronized (this) {
            long l10 = this.k0;
            long l11 = 16;
            this.k0 = l10 |= l11;
        }
        this.notifyPropertyChanged(14);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(d1$a d1$a) {
        this.N = d1$a;
        synchronized (this) {
            long l10 = this.k0;
            long l11 = 32;
            this.k0 = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        boolean bl2 = true;
        switch (n10) {
            default: {
                break;
            }
            case 10: {
                d1$a d1$a = this.N;
                if (d1$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                d1$a.h();
                break;
            }
            case 9: {
                d1$a d1$a = this.N;
                if (d1$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                d1$a.c();
                break;
            }
            case 8: {
                d1$a d1$a = this.N;
                if (d1$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                d1$a.i();
                break;
            }
            case 7: {
                d1$a d1$a = this.N;
                if (d1$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                d1$a.d();
                break;
            }
            case 6: {
                d1$a d1$a = this.N;
                if (d1$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                d1$a.f();
                break;
            }
            case 5: {
                d1$a d1$a = this.N;
                if (d1$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                d1$a.g();
                break;
            }
            case 4: {
                d1$a d1$a = this.N;
                if (d1$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                d1$a.e();
                break;
            }
            case 3: {
                d1$a d1$a = this.N;
                if (d1$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                d1$a.b();
                break;
            }
            case 2: {
                d1$a d1$a = this.N;
                if (d1$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                d1$a.a();
                break;
            }
            case 1: {
                d1$a d1$a = this.N;
                if (d1$a == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                d1$a.j();
            }
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
        int n10;
        long l13;
        Context context;
        MutableLiveData mutableLiveData;
        View.OnClickListener onClickListener;
        Object object;
        int n11;
        int n12;
        int n13;
        MutableLiveData mutableLiveData2;
        int n14;
        int n15;
        Context context2;
        Context context3;
        MutableLiveData mutableLiveData3;
        Object object2;
        int n16;
        Object object3;
        int n17;
        Context context4;
        int n18;
        Object object4;
        boolean bl2;
        Object object5;
        int n19;
        int n20;
        float f10;
        int n21;
        Object object6;
        View.OnClickListener onClickListener2;
        int n22;
        Object object7;
        Object object8;
        MutableLiveData mutableLiveData4;
        long l14;
        float f11;
        int n23;
        Context context5;
        int n24;
        Object object9;
        Object object10;
        TextView textView;
        Object object11;
        Object object12;
        Object object13;
        MutableLiveData mutableLiveData5;
        int n25;
        int n26;
        int n27;
        int n28;
        int n29;
        int n30;
        long l15;
        long l16;
        g1 g12 = this;
        synchronized (this) {
            l16 = this.k0;
            this.k0 = l15 = 0L;
            this.o0 = l15;
        }
        Object object14 = this.O;
        long l17 = (long)95 & l16;
        long l18 = l17 == l15 ? 0 : (l17 < l15 ? -1 : 1);
        long l19 = 84;
        long l20 = 81;
        int n31 = 0;
        Context context6 = null;
        if (l18 != false) {
            int n32;
            long l21;
            int n33;
            float f12;
            int n34;
            int n35;
            int n36;
            int n37;
            int n38;
            int n39;
            String string2;
            Context context7;
            int n40;
            View.OnClickListener onClickListener3;
            Object object15;
            int n41;
            float f13;
            int n42;
            MutableLiveData mutableLiveData6;
            float f14;
            TextView textView2;
            Context context8;
            int n43;
            int n44;
            long l22 = l16 & l20;
            l18 = l22 == l15 ? 0 : (l22 < l15 ? -1 : 1);
            n30 = 2;
            n29 = 3;
            n28 = 2131232185;
            n27 = 2131232102;
            n26 = 2131099754;
            n25 = 2131099772;
            int n45 = 1;
            if (l18 != false) {
                long l23;
                long l24;
                long l25;
                int n46;
                if (object14 != null) {
                    mutableLiveData5 = ((s6)object14).i();
                    object13 = mutableLiveData5;
                } else {
                    n46 = 0;
                    object13 = null;
                }
                g12.updateLiveDataRegistration(0, (LiveData)object13);
                if (object13 != null) {
                    object13 = (Integer)((LiveData)object13).getValue();
                } else {
                    n46 = 0;
                    object13 = null;
                }
                n46 = ViewDataBinding.safeUnbox((Integer)object13);
                if (n46 == n29) {
                    n44 = n45;
                } else {
                    n44 = 0;
                    object12 = null;
                }
                if (n46 == n45) {
                    n43 = n45;
                } else {
                    n43 = 0;
                    object11 = null;
                }
                if (n46 == n30) {
                    n46 = n45;
                } else {
                    n46 = 0;
                    object13 = null;
                }
                if (l18 != false) {
                    if (n44 != 0) {
                        l16 |= 0x1000000000L;
                        l25 = 0x400000000000L;
                    } else {
                        l16 |= 0x800000000L;
                        l25 = 0x200000000000L;
                    }
                    l16 |= l25;
                }
                if ((l18 = (l24 = (l25 = l16 & l20) - l15) == 0L ? 0 : (l24 < 0L ? -1 : 1)) != false) {
                    if (n43 != 0) {
                        l16 |= 0x40000000000L;
                        l25 = 0x4000000000000L;
                    } else {
                        l16 = l16 | 0x20000000000L | 0x2000000000000L;
                        l25 = Long.MIN_VALUE;
                    }
                    l16 |= l25;
                }
                if ((l18 = (l23 = (l25 = l16 & l20) - l15) == 0L ? 0 : (l23 < 0L ? -1 : 1)) != false) {
                    if (n46 != 0) {
                        l16 |= 0x400000L;
                        l25 = 0x4000000000000000L;
                    } else {
                        l16 |= 0x200000L;
                        l25 = 0x2000000000000000L;
                    }
                    l16 |= l25;
                }
                context8 = g12.s.getContext();
                n31 = n44 != 0 ? 2131231471 : 2131231472;
                context8 = AppCompatResources.getDrawable(context8, n31);
                context6 = g12.r.getContext();
                context6 = n44 != 0 ? AppCompatResources.getDrawable(context6, n28) : AppCompatResources.getDrawable(context6, n27);
                TextView textView3 = g12.F;
                n30 = n44 != 0 ? ViewDataBinding.getColorFromResource((View)textView3, n26) : ViewDataBinding.getColorFromResource((View)textView3, n25);
                textView = g12.B;
                n29 = n43 != 0 ? ViewDataBinding.getColorFromResource((View)textView, n26) : ViewDataBinding.getColorFromResource((View)textView, n25);
                object10 = g12.j.getContext();
                object10 = n43 != 0 ? AppCompatResources.getDrawable(object10, n28) : AppCompatResources.getDrawable(object10, n27);
                object9 = g12.k.getContext();
                n24 = n43 != 0 ? 2131231469 : 2131231470;
                object9 = AppCompatResources.getDrawable((Context)object9, n24);
                textView2 = g12.x;
                n24 = n46 != 0 ? ViewDataBinding.getColorFromResource((View)textView2, n26) : ViewDataBinding.getColorFromResource((View)textView2, n25);
                context5 = g12.h.getContext();
                context5 = n46 != 0 ? AppCompatResources.getDrawable(context5, n28) : AppCompatResources.getDrawable(context5, n27);
                if (n46 != 0) {
                    object13 = g12.i.getContext();
                    n26 = 2131231473;
                } else {
                    object13 = g12.i.getContext();
                    n26 = 2131231474;
                }
                object13 = AppCompatResources.getDrawable((Context)object13, n26);
            } else {
                n23 = 0;
                f11 = 0.0f;
                object9 = null;
                n24 = 0;
                textView2 = null;
                l18 = 0;
                f14 = 0.0f;
                context8 = null;
                n45 = 0;
                object10 = null;
                n31 = 0;
                context6 = null;
                n30 = 0;
                Object var35_35 = null;
                boolean bl3 = false;
                object13 = null;
                n29 = 0;
                textView = null;
                n25 = 0;
                context5 = null;
            }
            long l26 = 82;
            long l27 = l16 & l26;
            l14 = 0L;
            n26 = (int)(l27 == l14 ? 0 : (l27 < l14 ? -1 : 1));
            if (n26 != 0) {
                long l28;
                long l29;
                long l30;
                if (object14 != null) {
                    MutableLiveData mutableLiveData7;
                    mutableLiveData4 = mutableLiveData7 = ((s6)object14).n();
                    n28 = 1;
                } else {
                    n28 = 1;
                    n27 = 0;
                    mutableLiveData4 = null;
                }
                g12.updateLiveDataRegistration(n28, mutableLiveData4);
                if (mutableLiveData4 != null) {
                    object8 = (Integer)mutableLiveData4.getValue();
                } else {
                    n28 = 0;
                    object8 = null;
                }
                n28 = ViewDataBinding.safeUnbox((Integer)object8);
                n27 = 3;
                mutableLiveData6 = object9;
                n23 = 2;
                f11 = 2.8E-45f;
                if (n28 == n27) {
                    n27 = 1;
                } else {
                    n27 = 0;
                    mutableLiveData4 = null;
                }
                n42 = n24;
                if (n28 == n23) {
                    n23 = 1;
                    f11 = Float.MIN_VALUE;
                } else {
                    n23 = 0;
                    f11 = 0.0f;
                    object9 = null;
                }
                n24 = 1;
                if (n28 == n24) {
                    n28 = 1;
                } else {
                    n28 = 0;
                    object8 = null;
                }
                if (n26 != 0) {
                    if (n27 != 0) {
                        l16 |= 0x40000000L;
                        l30 = 0x400000000000000L;
                    } else {
                        l16 |= 0x20000000L;
                        l30 = 0x200000000000000L;
                    }
                    l16 |= l30;
                }
                if ((n24 = (int)((l29 = (l30 = l16 & (l26 = (long)82)) - (l14 = 0L)) == 0L ? 0 : (l29 < 0L ? -1 : 1))) != 0) {
                    if (n23 != 0) {
                        l16 |= 0x100L;
                        l30 = 0x400000000L;
                    } else {
                        l16 |= 0x80L;
                        l30 = 0x200000000L;
                    }
                    l16 |= l30;
                }
                if ((n24 = (int)((l28 = (l30 = l16 & (l26 = (long)82)) - (l14 = 0L)) == 0L ? 0 : (l28 < 0L ? -1 : 1))) != 0) {
                    l30 = n28 != 0 ? 0x1000000000000L : 0x800000000000L;
                    l16 |= l30;
                }
                textView2 = g12.o.getContext();
                n26 = n27 != 0 ? 2131231475 : 2131231476;
                textView2 = AppCompatResources.getDrawable((Context)textView2, n26);
                if (n27 != 0) {
                    object7 = g12.n.getContext();
                    l30 = l16;
                    n22 = 2131232185;
                    f13 = 1.8080472E38f;
                    onClickListener2 = AppCompatResources.getDrawable(object7, n22);
                } else {
                    l30 = l16;
                    object6 = g12.n.getContext();
                    n21 = 2131232102;
                    f10 = 1.8080304E38f;
                    object6 = AppCompatResources.getDrawable((Context)object6, n21);
                    onClickListener2 = object6;
                }
                if (n27 != 0) {
                    object6 = g12.D;
                    n27 = 2131099754;
                    n22 = ViewDataBinding.getColorFromResource((View)object6, n27);
                    n26 = 2131099772;
                } else {
                    n27 = 2131099754;
                    object6 = g12.D;
                    n26 = 2131099772;
                    n22 = ViewDataBinding.getColorFromResource((View)object6, n26);
                }
                if (n23 != 0) {
                    object7 = g12.E;
                    n26 = ViewDataBinding.getColorFromResource((View)object7, n27);
                } else {
                    mutableLiveData4 = g12.E;
                    n26 = n27 = ViewDataBinding.getColorFromResource((View)mutableLiveData4, 2131099772);
                }
                if (n23 != 0) {
                    mutableLiveData4 = g12.q.getContext();
                    n41 = n22;
                    n22 = 2131231477;
                    f13 = 1.8079036E38f;
                    object6 = AppCompatResources.getDrawable((Context)mutableLiveData4, n22);
                } else {
                    n41 = n22;
                    object6 = g12.q.getContext();
                    n27 = 2131231478;
                    object6 = AppCompatResources.getDrawable((Context)object6, n27);
                }
                if (n23 != 0) {
                    object9 = AppCompatResources.getDrawable(g12.p.getContext(), 2131232185);
                    n27 = 2131232102;
                } else {
                    object9 = g12.p.getContext();
                    n27 = 2131232102;
                    object9 = AppCompatResources.getDrawable((Context)object9, n27);
                }
                if (n28 != 0) {
                    mutableLiveData4 = g12.l.getContext();
                    object15 = object6;
                    n22 = 2131232185;
                    f13 = 1.8080472E38f;
                    mutableLiveData4 = AppCompatResources.getDrawable((Context)mutableLiveData4, n22);
                } else {
                    object15 = object6;
                    object6 = g12.l.getContext();
                    n27 = 2131232102;
                    object6 = AppCompatResources.getDrawable((Context)object6, n27);
                    mutableLiveData4 = object6;
                }
                if (n28 != 0) {
                    object6 = g12.m.getContext();
                    onClickListener3 = onClickListener2;
                    n21 = 2131231537;
                    f10 = 1.8079158E38f;
                } else {
                    onClickListener3 = onClickListener2;
                    object6 = g12.m.getContext();
                    n21 = 2131231538;
                    f10 = 1.807916E38f;
                }
                object6 = AppCompatResources.getDrawable((Context)object6, n21);
                onClickListener2 = g12.C;
                n28 = n28 != 0 ? 2131099754 : 2131099772;
                n21 = ViewDataBinding.getColorFromResource((View)onClickListener2, n28);
                object8 = object9;
                object9 = object6;
                n24 = n21;
                l16 = l30;
                n40 = n26;
                object7 = mutableLiveData4;
                mutableLiveData4 = textView2;
            } else {
                mutableLiveData6 = object9;
                n42 = n24;
                n23 = 0;
                f11 = 0.0f;
                object9 = null;
                n24 = 0;
                textView2 = null;
                n28 = 0;
                object8 = null;
                n27 = 0;
                mutableLiveData4 = null;
                n26 = 0;
                object7 = null;
                n40 = 0;
                n41 = 0;
                object15 = null;
                onClickListener3 = null;
            }
            long l31 = l16 & l19;
            l14 = 0L;
            n20 = l31 == l14 ? 0 : (l31 < l14 ? -1 : 1);
            MutableLiveData mutableLiveData8 = object9;
            if (n20 != 0) {
                float f15;
                long l32;
                long l33;
                long l34;
                long l35;
                long l36;
                float f16;
                if (object14 != null) {
                    object9 = ((s6)object14).s;
                    n44 = n24;
                } else {
                    n44 = n24;
                    n23 = 0;
                    f11 = 0.0f;
                    object9 = null;
                }
                n24 = 2;
                g12.updateLiveDataRegistration(n24, (LiveData)object9);
                if (object9 != null) {
                    object9 = (Integer)((LiveData)object9).getValue();
                } else {
                    n23 = 0;
                    f11 = 0.0f;
                    object9 = null;
                }
                n23 = ViewDataBinding.safeUnbox((Integer)object9);
                n24 = 3;
                context7 = context8;
                if (n23 == n24) {
                    n24 = 1;
                } else {
                    n24 = 0;
                    textView2 = null;
                }
                l18 = 2;
                f14 = 2.8E-45f;
                if (n23 == l18) {
                    l18 = 1;
                    f14 = Float.MIN_VALUE;
                    n19 = 1;
                    f16 = Float.MIN_VALUE;
                } else {
                    l18 = 1;
                    f14 = Float.MIN_VALUE;
                    n19 = 0;
                    f16 = 0.0f;
                }
                if (n23 != l18) {
                    l18 = 0;
                    f14 = 0.0f;
                    context8 = null;
                }
                if (n20 != 0) {
                    if (n24 != 0) {
                        l16 = l16 | 0x1000L | 0x10000L | 0x40000L | 0x4000000000L | 0x40000000000000L;
                        l36 = 0x100000000000000L;
                    } else {
                        l16 = l16 | 0x800L | 0x8000L | 0x20000L | 0x2000000000L | 0x20000000000000L;
                        l36 = 0x80000000000000L;
                    }
                    l16 |= l36;
                }
                if ((n23 = (int)((l35 = (l36 = l16 & l19) - (l14 = 0L)) == 0L ? 0 : (l35 < 0L ? -1 : 1))) != 0) {
                    if (n19 != 0) {
                        l16 = l16 | 0x400L | 0x100000L;
                        l36 = 0x100000000L;
                    } else {
                        l34 = 512L;
                        l16 = l16 | l34 | 0x80000L;
                        l36 = 0x80000000L;
                    }
                    l16 |= l36;
                }
                if ((n23 = (int)((l33 = (l36 = l16 & l19) - (l14 = 0L)) == 0L ? 0 : (l33 < 0L ? -1 : 1))) != 0) {
                    if (l18 != false) {
                        l16 |= 0x1000000L;
                        l36 = 0x4000000L;
                    } else {
                        l16 |= 0x800000L;
                        l36 = 0x2000000L;
                    }
                    l16 |= l36;
                }
                if ((n23 = (int)((l32 = (l36 = l16 & (l34 = 512L)) - (l14 = 0L)) == 0L ? 0 : (l32 < 0L ? -1 : 1))) != 0) {
                    l36 = l18 != false ? 0x10000000L : 0x8000000L;
                    l16 |= l36;
                }
                if (n24 != 0) {
                    object9 = g12.I;
                    l36 = l16;
                    n22 = 2131099754;
                    f13 = 1.781187E38f;
                    n21 = ViewDataBinding.getColorFromResource((View)object9, n22);
                } else {
                    l36 = l16;
                    object6 = g12.I;
                    f10 = 1.7811925E38f;
                    n21 = n22 = ViewDataBinding.getColorFromResource((View)object6, 2131099781);
                }
                if (n24 != 0) {
                    n23 = 0;
                    f11 = 0.0f;
                    object9 = null;
                } else {
                    n23 = 4;
                    f11 = 5.6E-45f;
                }
                string2 = n24 != 0 ? "@string/set_completed" : "@string/next";
                if (n24 != 0) {
                    object6 = g12.J;
                    n39 = n21;
                    n21 = 2131099772;
                    f10 = 1.7811907E38f;
                } else {
                    n39 = n21;
                    object6 = g12.J;
                    n21 = 2131099781;
                    f10 = 1.7811925E38f;
                }
                n22 = ViewDataBinding.getColorFromResource((View)object6, n21);
                if (n24 != 0) {
                    n21 = 4;
                    f10 = 5.6E-45f;
                } else {
                    n21 = 0;
                    f10 = 0.0f;
                    onClickListener2 = null;
                }
                if (n24 != 0) {
                    textView2 = g12.I.getContext();
                    n38 = n22;
                    n22 = 2131232067;
                    f13 = 1.8080233E38f;
                    textView2 = AppCompatResources.getDrawable((Context)textView2, n22);
                } else {
                    n38 = n22;
                    object6 = g12.I.getContext();
                    n24 = 2131232047;
                    object6 = AppCompatResources.getDrawable((Context)object6, n24);
                    textView2 = object6;
                }
                if (n19 != 0) {
                    object6 = g12.L;
                    n37 = n21;
                    n22 = ViewDataBinding.getColorFromResource((View)object6, 2131099772);
                    n21 = 2131099781;
                    f10 = 1.7811925E38f;
                } else {
                    n37 = n21;
                    object6 = g12.L;
                    n21 = 2131099781;
                    f10 = 1.7811925E38f;
                    n22 = ViewDataBinding.getColorFromResource((View)object6, n21);
                }
                if (n19 != 0) {
                    n20 = 0;
                    f15 = 0.0f;
                } else {
                    n20 = 4;
                    f15 = 5.6E-45f;
                }
                n36 = n22;
                object6 = g12.K;
                if (l18 == false) {
                    n21 = 2131099754;
                    f10 = 1.781187E38f;
                }
                n22 = ViewDataBinding.getColorFromResource((View)object6, n21);
                if (l18 != false) {
                    onClickListener2 = g12.H;
                    n35 = n22;
                    n22 = 2131099772;
                    f13 = 1.7811907E38f;
                    n21 = ViewDataBinding.getColorFromResource((View)onClickListener2, n22);
                } else {
                    n35 = n22;
                    object6 = g12.H;
                    f10 = 1.7811925E38f;
                    n21 = ViewDataBinding.getColorFromResource((View)object6, 2131099781);
                }
                if (l18 != false) {
                    n22 = 0;
                    f13 = 0.0f;
                    object6 = null;
                } else {
                    n22 = 4;
                    f13 = 5.6E-45f;
                }
                n34 = n22;
                f12 = f13;
                if (l18 != false) {
                    object6 = g12.G.getContext();
                    n33 = n21;
                    n21 = 2131232067;
                    f10 = 1.8080233E38f;
                } else {
                    n33 = n21;
                    object6 = g12.G.getContext();
                    n21 = 2131232063;
                    f10 = 1.8080225E38f;
                }
                object6 = AppCompatResources.getDrawable((Context)object6, n21);
                l21 = 88;
                object9 = object6;
                l16 = l36;
                n32 = n20;
                n20 = n19;
                f15 = f16;
                n19 = (int)l18;
                f16 = f14;
                context8 = textView2;
                n24 = n23;
            } else {
                n44 = n24;
                context7 = context8;
                n23 = 0;
                f11 = 0.0f;
                object9 = null;
                n24 = 0;
                textView2 = null;
                l18 = 0;
                f14 = 0.0f;
                context8 = null;
                l21 = 88;
                n19 = 0;
                float f17 = 0.0f;
                n20 = 0;
                float f18 = 0.0f;
                n32 = 0;
                string2 = null;
                n34 = 0;
                f12 = 0.0f;
                n39 = 0;
                n38 = 0;
                n37 = 0;
                n36 = 0;
                n33 = 0;
                n35 = 0;
            }
            long l37 = l16 & l21;
            l14 = 0L;
            long l38 = l37 == l14 ? 0 : (l37 < l14 ? -1 : 1);
            if (l38 != false) {
                if (object14 != null) {
                    object14 = ((s6)object14).e();
                    object5 = object9;
                } else {
                    object5 = object9;
                    bl2 = false;
                    object14 = null;
                }
                n23 = 3;
                f11 = 4.2E-45f;
                g12.updateLiveDataRegistration(n23, (LiveData)object14);
                if (object14 != null) {
                    object14 = (Boolean)((LiveData)object14).getValue();
                } else {
                    bl2 = false;
                    object14 = null;
                }
                bl2 = ViewDataBinding.safeUnbox((Boolean)object14);
                if (l38 != false) {
                    if (bl2) {
                        l16 = l16 | 0x4000L | 0x10000000000L | 0x100000000000L | 0x10000000000000L;
                        l37 = 0x1000000000000000L;
                    } else {
                        l16 = l16 | 0x2000L | 0x8000000000L | 0x80000000000L | 0x8000000000000L;
                        l37 = 0x800000000000000L;
                    }
                    l16 |= l37;
                }
                if (bl2) {
                    object9 = g12.g.getContext();
                    l37 = l16;
                    n22 = 2131231467;
                    f13 = 1.8079016E38f;
                    object6 = AppCompatResources.getDrawable((Context)object9, n22);
                } else {
                    l37 = l16;
                    object6 = g12.g.getContext();
                    n21 = 2131231468;
                    f10 = 1.8079018E38f;
                    object6 = AppCompatResources.getDrawable((Context)object6, n21);
                }
                if (bl2) {
                    onClickListener2 = g12.v;
                    n21 = ViewDataBinding.getColorFromResource((View)onClickListener2, 2131099772);
                    n23 = 2131099754;
                    f11 = 1.781187E38f;
                } else {
                    onClickListener2 = g12.v;
                    n23 = 2131099754;
                    f11 = 1.781187E38f;
                    n21 = ViewDataBinding.getColorFromResource((View)onClickListener2, n23);
                }
                object4 = object6;
                object6 = g12.w;
                if (!bl2) {
                    n23 = 2131099772;
                    f11 = 1.7811907E38f;
                }
                n22 = ViewDataBinding.getColorFromResource((View)object6, n23);
                if (bl2) {
                    object9 = g12.f.getContext();
                    n43 = n22;
                    n22 = 2131232185;
                    f13 = 1.8080472E38f;
                    object9 = AppCompatResources.getDrawable((Context)object9, n22);
                    object6 = object9;
                    n23 = 2131232102;
                    f11 = 1.8080304E38f;
                } else {
                    n43 = n22;
                    object6 = g12.f.getContext();
                    n23 = 2131232102;
                    f11 = 1.8080304E38f;
                    object6 = AppCompatResources.getDrawable((Context)object6, n23);
                }
                Object object16 = object6;
                object6 = g12.d.getContext();
                if (!bl2) {
                    n23 = 2131232185;
                    f11 = 1.8080472E38f;
                }
                object6 = AppCompatResources.getDrawable((Context)object6, n23);
                if (bl2) {
                    object14 = g12.e.getContext();
                    n23 = 2131231470;
                    f11 = 1.8079022E38f;
                } else {
                    object14 = g12.e.getContext();
                    n23 = 2131231469;
                    f11 = 1.807902E38f;
                }
                object14 = AppCompatResources.getDrawable((Context)object14, n23);
                object9 = object6;
                n18 = n21;
                mutableLiveData5 = object10;
                context4 = context6;
                n17 = n30;
                object3 = object13;
                n16 = n29;
                object2 = object8;
                mutableLiveData3 = mutableLiveData4;
                context3 = object7;
                context2 = context5;
                n15 = n44;
                n14 = n43;
                object12 = object4;
                object10 = object5;
                object11 = object16;
                mutableLiveData2 = mutableLiveData6;
                n13 = n42;
                n12 = n40;
                n11 = n41;
                object = object15;
                onClickListener = onClickListener3;
                mutableLiveData = mutableLiveData8;
                context = context7;
                n28 = n32;
                n27 = n39;
                n26 = n37;
                n30 = n36;
                n31 = n33;
                n29 = n35;
                l16 = l37;
                l13 = 512L;
                object4 = object14;
                n25 = n24;
                object13 = context8;
                object14 = string2;
            } else {
                object5 = object9;
                mutableLiveData5 = object10;
                context4 = context6;
                n17 = n30;
                object3 = object13;
                n16 = n29;
                object2 = object8;
                mutableLiveData3 = mutableLiveData4;
                context3 = object7;
                context2 = context5;
                n15 = n44;
                object10 = object9;
                mutableLiveData2 = mutableLiveData6;
                n13 = n42;
                n12 = n40;
                n11 = n41;
                object = object15;
                onClickListener = onClickListener3;
                mutableLiveData = mutableLiveData8;
                context = context7;
                n28 = n32;
                object14 = string2;
                n27 = n39;
                n26 = n37;
                n30 = n36;
                n31 = n33;
                n29 = n35;
                n23 = 0;
                f11 = 0.0f;
                object9 = null;
                n44 = 0;
                object12 = null;
                n43 = 0;
                object11 = null;
                object4 = null;
                l13 = 512L;
                n18 = 0;
                n14 = 0;
                n25 = n24;
                object13 = context8;
            }
            l18 = n34;
            f14 = f12;
            n24 = n38;
        } else {
            bl2 = false;
            object14 = null;
            n23 = 0;
            f11 = 0.0f;
            object9 = null;
            n24 = 0;
            Object var40_42 = null;
            l18 = 0;
            float f19 = 0.0f;
            Object var34_33 = null;
            boolean bl4 = false;
            object10 = null;
            n31 = 0;
            context6 = null;
            n30 = 0;
            Object var35_36 = null;
            boolean bl5 = false;
            object13 = null;
            n29 = 0;
            textView = null;
            n28 = 0;
            object8 = null;
            n27 = 0;
            mutableLiveData4 = null;
            n26 = 0;
            object7 = null;
            n25 = 0;
            context5 = null;
            mutableLiveData = null;
            context = null;
            mutableLiveData2 = null;
            mutableLiveData5 = null;
            boolean bl6 = false;
            object12 = null;
            boolean bl7 = false;
            object11 = null;
            object4 = null;
            n19 = 0;
            float f20 = 0.0f;
            l13 = 512L;
            n20 = 0;
            float f21 = 0.0f;
            n18 = 0;
            n14 = 0;
            context4 = null;
            n13 = 0;
            n16 = 0;
            n17 = 0;
            n15 = 0;
            n11 = 0;
            n12 = 0;
            object3 = null;
            object2 = null;
            mutableLiveData3 = null;
            context3 = null;
            context2 = null;
            object = null;
            onClickListener = null;
        }
        l13 = l16 & l13;
        l14 = 0L;
        long l39 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        if (l39 != false) {
            object5 = object9;
            if (n19 != 0) {
                object9 = g12.K.getContext();
                n19 = n30;
                n30 = 2131232047;
            } else {
                n19 = n30;
                object9 = g12.K.getContext();
                n30 = 2131232063;
            }
            object9 = AppCompatResources.getDrawable((Context)object9, n30);
        } else {
            object5 = object9;
            n19 = n30;
            n23 = 0;
            f11 = 0.0f;
            object9 = null;
        }
        l19 = l16 & l19;
        long l40 = 0L;
        n30 = (int)(l19 == l40 ? 0 : (l19 < l40 ? -1 : 1));
        if (n30 != 0) {
            if (n20 != 0) {
                object9 = g12.K.getContext();
                n10 = n29;
                n29 = 2131232067;
                object9 = AppCompatResources.getDrawable((Context)object9, n29);
            } else {
                n10 = n29;
            }
        } else {
            n10 = n29;
            n23 = 0;
            f11 = 0.0f;
            object9 = null;
        }
        l40 = l16 & (long)64;
        l14 = 0L;
        n29 = (int)(l40 == l14 ? 0 : (l40 < l14 ? -1 : 1));
        if (n29 != 0) {
            textView = g12.a;
            l40 = l16;
            object6 = g12.R;
            textView.setOnClickListener((View.OnClickListener)object6);
            object6 = g12.b;
            onClickListener2 = g12.Z;
            object6.setOnClickListener(onClickListener2);
            object6 = g12.d;
            onClickListener2 = g12.X;
            object6.setOnClickListener(onClickListener2);
            object6 = g12.f;
            onClickListener2 = g12.Y;
            object6.setOnClickListener(onClickListener2);
            object6 = g12.h;
            onClickListener2 = g12.W;
            object6.setOnClickListener(onClickListener2);
            object6 = g12.j;
            onClickListener2 = g12.S;
            object6.setOnClickListener(onClickListener2);
            object6 = g12.l;
            onClickListener2 = g12.T;
            object6.setOnClickListener(onClickListener2);
            object6 = g12.n;
            onClickListener2 = g12.Q;
            object6.setOnClickListener(onClickListener2);
            object6 = g12.p;
            onClickListener2 = g12.U;
            object6.setOnClickListener(onClickListener2);
            object6 = g12.r;
            onClickListener2 = g12.V;
            object6.setOnClickListener(onClickListener2);
        } else {
            l40 = l16;
        }
        if (n30 != 0) {
            object6 = g12.a;
            n21 = 0;
            f10 = 0.0f;
            onClickListener2 = null;
            l.a.q.g0.u.n((TextView)object6, (String)object14, null, null);
            g12.b.setVisibility(n26);
            g12.d.setVisibility(n28);
            g12.e.setVisibility(n28);
            g12.f.setVisibility(n28);
            g12.g.setVisibility(n28);
            g12.h.setVisibility((int)l18);
            g12.i.setVisibility((int)l18);
            g12.j.setVisibility((int)l18);
            g12.k.setVisibility((int)l18);
            g12.l.setVisibility(n25);
            g12.m.setVisibility(n25);
            g12.n.setVisibility(n25);
            g12.o.setVisibility(n25);
            g12.p.setVisibility(n25);
            g12.q.setVisibility(n25);
            g12.r.setVisibility((int)l18);
            g12.s.setVisibility((int)l18);
            g12.v.setVisibility(n28);
            g12.w.setVisibility(n28);
            g12.x.setVisibility((int)l18);
            g12.y.setVisibility((int)l18);
            g12.z.setVisibility(n25);
            g12.A.setVisibility(n28);
            g12.B.setVisibility((int)l18);
            g12.C.setVisibility(n25);
            g12.D.setVisibility(n25);
            g12.E.setVisibility(n25);
            g12.F.setVisibility((int)l18);
            ViewBindingAdapter.setBackground((View)g12.G, (Drawable)object10);
            g12.H.setTextColor(n31);
            ViewBindingAdapter.setBackground((View)g12.I, (Drawable)object13);
            g12.I.setTextColor(n27);
            g12.J.setTextColor(n24);
            ViewBindingAdapter.setBackground((View)g12.K, (Drawable)object9);
            object14 = g12.K;
            n22 = n10;
            object14.setTextColor(n10);
            object14 = g12.L;
            n22 = n19;
            object14.setTextColor(n19);
        }
        if (bl2 = (l12 = (l16 = l40 & (long)88) - (l15 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) {
            object14 = g12.d;
            object6 = object5;
            ViewBindingAdapter.setBackground((View)object14, (Drawable)object5);
            object14 = g12.e;
            object6 = object4;
            ImageViewBindingAdapter.setImageDrawable((ImageView)object14, object4);
            object14 = g12.f;
            object6 = object11;
            ViewBindingAdapter.setBackground((View)object14, object11);
            object14 = g12.g;
            object6 = object12;
            ImageViewBindingAdapter.setImageDrawable((ImageView)object14, object12);
            object14 = g12.v;
            n21 = n18;
            object14.setTextColor(n18);
            object14 = g12.w;
            n22 = n14;
            object14.setTextColor(n14);
        }
        if (bl2 = (l11 = (l16 = l40 & l20) - (l15 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) {
            object14 = g12.h;
            context5 = context2;
            ViewBindingAdapter.setBackground((View)object14, context2);
            object14 = g12.i;
            object13 = object3;
            ImageViewBindingAdapter.setImageDrawable((ImageView)object14, (Drawable)object3);
            object14 = g12.j;
            object10 = mutableLiveData5;
            ViewBindingAdapter.setBackground((View)object14, (Drawable)mutableLiveData5);
            object14 = g12.k;
            object6 = mutableLiveData2;
            ImageViewBindingAdapter.setImageDrawable((ImageView)object14, (Drawable)mutableLiveData2);
            object14 = g12.r;
            context6 = context4;
            ViewBindingAdapter.setBackground((View)object14, (Drawable)context4);
            object14 = g12.s;
            object6 = context;
            ImageViewBindingAdapter.setImageDrawable((ImageView)object14, (Drawable)context);
            object14 = g12.x;
            n22 = n13;
            object14.setTextColor(n13);
            object14 = g12.B;
            n29 = n16;
            object14.setTextColor(n16);
            object14 = g12.F;
            n30 = n17;
            object14.setTextColor(n17);
        }
        if (bl2 = (l10 = (l16 = l40 & (long)82) - (l15 = 0L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            object14 = g12.l;
            object7 = context3;
            ViewBindingAdapter.setBackground((View)object14, (Drawable)context3);
            object14 = g12.m;
            object6 = mutableLiveData;
            ImageViewBindingAdapter.setImageDrawable((ImageView)object14, mutableLiveData);
            object14 = g12.n;
            object6 = onClickListener;
            ViewBindingAdapter.setBackground((View)object14, onClickListener);
            object14 = g12.o;
            mutableLiveData4 = mutableLiveData3;
            ImageViewBindingAdapter.setImageDrawable((ImageView)object14, (Drawable)mutableLiveData3);
            object14 = g12.p;
            object8 = object2;
            ViewBindingAdapter.setBackground((View)object14, (Drawable)object2);
            object14 = g12.q;
            object6 = object;
            ImageViewBindingAdapter.setImageDrawable((ImageView)object14, (Drawable)object);
            object14 = g12.C;
            n22 = n15;
            object14.setTextColor(n15);
            object14 = g12.D;
            n22 = n11;
            object14.setTextColor(n11);
            object14 = g12.E;
            n22 = n12;
            object14.setTextColor(n12);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.k0;
            long l11 = 0L;
            Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (object != false) return (boolean)((Object)1);
            l10 = this.o0;
            long l12 = l10 - l11;
            object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object != false) return (boolean)((Object)1);
            return false;
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
            this.k0 = l10 = (long)64;
            this.o0 = l10 = 0L;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    n12 = 3;
                    if (n10 != n12) {
                        return false;
                    }
                    object = (MutableLiveData)object;
                    return this.C((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.F((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.E((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.D((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 14;
        if (n11 == n10) {
            object = (s6)object;
            this.A((s6)object);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 != n10) return 0 != 0;
            object = (d1$a)object;
            this.B((d1$a)object);
        }
        return 1 != 0;
    }
}

