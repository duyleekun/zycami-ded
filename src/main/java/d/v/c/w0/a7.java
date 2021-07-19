/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CompoundButton
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.a7$a;
import d.v.c.w0.a7$b;
import d.v.c.w0.z6;
import d.v.c.y1.f.p$b;
import d.v.c.y1.f.u;

public class a7
extends z6
implements b$a {
    private static final ViewDataBinding$IncludedLayouts u;
    private static final SparseIntArray v;
    private final ConstraintLayout m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;
    private a7$b r;
    private a7$a s;
    private long t;

    static {
        SparseIntArray sparseIntArray;
        v = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362467, 10);
    }

    public a7(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = u;
        SparseIntArray sparseIntArray = v;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 11, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private a7(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[6];
        object2 = (ConstraintLayout)((Object)object);
        Object object3 = object = objectArray[10];
        object3 = (FrameLayout)object;
        Object object4 = object = objectArray[7];
        object4 = (ImageView)object;
        int n10 = 3;
        Object object5 = object = objectArray[n10];
        object5 = (RadioButton)object;
        Object object6 = object = objectArray[2];
        object6 = (RadioButton)object;
        Object object7 = object = objectArray[4];
        object7 = (RadioButton)object;
        Object object8 = object = objectArray[1];
        object8 = (RadioGroup)object;
        Object object9 = object = objectArray[9];
        object9 = (TextView)object;
        Object object10 = object = objectArray[8];
        object10 = (TextView)object;
        Object object11 = object = objectArray[5];
        object11 = (ViewPager2)((Object)object);
        object = this;
        super(dataBindingComponent, view, 2, (ConstraintLayout)((Object)object2), (FrameLayout)object3, (ImageView)object4, (RadioButton)object5, (RadioButton)object6, (RadioButton)object7, (RadioGroup)object8, (TextView)object9, (TextView)object10, (ViewPager2)((Object)object11));
        this.t = -1;
        this.a.setTag(null);
        this.c.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.m = object;
        object.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n10);
        this.n = object;
        object = new b(this, 4);
        this.o = object;
        object = new b(this, 1);
        this.p = object;
        object = new b(this, 2);
        this.q = object;
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
                long l10 = this.t;
                long l11 = 1L;
                this.t = l10 |= l11;
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
                long l10 = this.t;
                long l11 = 2;
                this.t = l10 |= l11;
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
    public void A(p$b p$b) {
        this.l = p$b;
        synchronized (this) {
            long l10 = this.t;
            long l11 = 8;
            this.t = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(u u10) {
        this.k = u10;
        synchronized (this) {
            long l10 = this.t;
            long l11 = 4;
            this.t = l10 |= l11;
        }
        this.notifyPropertyChanged(95);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                int n14 = 3;
                if (n10 != n14) {
                    int n15 = 4;
                    if (n10 == n15) {
                        u u10 = this.k;
                        if (u10 != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            u10.j();
                        }
                    }
                } else {
                    p$b p$b = this.l;
                    if (p$b != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        p$b.c(view, n13);
                    }
                }
            } else {
                p$b p$b = this.l;
                if (p$b != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    p$b.c(view, n12);
                }
            }
        } else {
            p$b p$b = this.l;
            if (p$b == null) {
                n12 = 0;
            }
            if (n12 != 0) {
                p$b.c(view, 0);
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
        a7$b a7$b;
        Object object;
        int n10;
        int n11;
        ViewPager2 viewPager2;
        float f10;
        int n12;
        ImageView imageView;
        float f11;
        int n13;
        int n14;
        long l12;
        int n15;
        int n16;
        float f12;
        int n17;
        long l13;
        long l14;
        long l15;
        a7 a72 = this;
        synchronized (this) {
            l15 = this.t;
            this.t = l14 = 0L;
        }
        Object object2 = this.k;
        Object object3 = this.l;
        long l16 = (long)23 & l15;
        long l17 = l16 == l14 ? 0 : (l16 < l14 ? -1 : 1);
        int n18 = 0;
        float f13 = 0.0f;
        Object object4 = null;
        long l18 = 21;
        int n19 = 0;
        float f14 = 0.0f;
        if (l17 != false) {
            float f15;
            int n20;
            long l19;
            float f16;
            float f17;
            l13 = l15 & l18;
            l17 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
            n17 = 1;
            f12 = Float.MIN_VALUE;
            if (l17 != false) {
                long l20;
                long l21;
                if (object2 != null) {
                    object4 = ((u)object2).c();
                } else {
                    n18 = 0;
                    f13 = 0.0f;
                    object4 = null;
                }
                a72.updateLiveDataRegistration(0, (LiveData)object4);
                if (object4 != null) {
                    object4 = (Integer)((LiveData)object4).getValue();
                } else {
                    n18 = 0;
                    f13 = 0.0f;
                    object4 = null;
                }
                n18 = ViewDataBinding.safeUnbox((Integer)object4);
                n16 = n18 == n17 ? n17 : 0;
                n15 = 2;
                n15 = n18 == n15 ? n17 : 0;
                if (n18 == 0) {
                    n18 = n17;
                    f13 = f12;
                } else {
                    n18 = 0;
                    object4 = null;
                    f13 = 0.0f;
                }
                if (l17 != false) {
                    if (n16 != 0) {
                        l15 |= 0x400L;
                        l12 = 16384L;
                    } else {
                        l15 |= 0x200L;
                        l12 = 8192L;
                    }
                    l15 |= l12;
                }
                if ((l17 = (l21 = (l12 = l15 & l18) - l14) == 0L ? 0 : (l21 < 0L ? -1 : 1)) != false) {
                    if (n15 != 0) {
                        l15 |= (long)64;
                        l12 = 4096L;
                    } else {
                        l15 |= (long)32;
                        l12 = 2048L;
                    }
                    l15 |= l12;
                }
                if ((l17 = (l20 = (l12 = l15 & l18) - l14) == 0L ? 0 : (l20 < 0L ? -1 : 1)) != false) {
                    if (n18 != 0) {
                        l15 |= 0x100L;
                        l12 = 0x100000L;
                    } else {
                        l15 |= 0x80L;
                        l12 = 524288L;
                    }
                    l15 |= l12;
                }
                l17 = 2131099772;
                n19 = 2131099781;
                f14 = 1.7811925E38f;
                RadioButton radioButton = a72.d;
                n14 = n16 != 0 ? ViewDataBinding.getColorFromResource((View)radioButton, (int)l17) : ViewDataBinding.getColorFromResource((View)radioButton, n19);
                n13 = 2131165275;
                f17 = 1.7944763E38f;
                n17 = 2131165277;
                f12 = 1.7944767E38f;
                Resources resources = a72.d.getResources();
                f11 = n16 != 0 ? resources.getDimension(n13) : resources.getDimension(n17);
                imageView = a72.f;
                n12 = n15 != 0 ? ViewDataBinding.getColorFromResource((View)imageView, (int)l17) : ViewDataBinding.getColorFromResource((View)imageView, n19);
                Resources resources2 = a72.f.getResources();
                f10 = n15 != 0 ? resources2.getDimension(n13) : resources2.getDimension(n17);
                Resources resources3 = a72.e.getResources();
                f16 = n18 != 0 ? resources3.getDimension(n13) : resources3.getDimension(n17);
                if (n18 != 0) {
                    RadioButton radioButton2 = a72.e;
                    l17 = ViewDataBinding.getColorFromResource((View)radioButton2, (int)l17);
                } else {
                    viewPager2 = a72.e;
                    l17 = ViewDataBinding.getColorFromResource((View)viewPager2, n19);
                }
                l19 = 22;
                n20 = n18;
                f15 = f13;
                f13 = f16;
                n11 = n18;
                f16 = f15;
            } else {
                Object var30_28 = null;
                f11 = 0.0f;
                Object var34_34 = null;
                f10 = 0.0f;
                n12 = 0;
                imageView = null;
                l17 = 0;
                viewPager2 = null;
                n11 = 0;
                f16 = 0.0f;
                Object var36_38 = null;
                n14 = 0;
                Object var26_21 = null;
                n15 = 0;
                l19 = 22;
                n16 = 0;
            }
            long l22 = l15 & l19;
            l19 = 0L;
            n13 = l22 == l19 ? 0 : (l22 < l19 ? -1 : 1);
            if (n13 != 0) {
                if (object2 != null) {
                    object2 = ((u)object2).d();
                } else {
                    n10 = 0;
                    object2 = null;
                }
                n19 = 1;
                f14 = Float.MIN_VALUE;
                a72.updateLiveDataRegistration(n19, (LiveData)object2);
                if (object2 != null) {
                    object2 = (Boolean)((LiveData)object2).getValue();
                } else {
                    n10 = 0;
                    object2 = null;
                }
                n10 = (int)(ViewDataBinding.safeUnbox((Boolean)object2) ? 1 : 0);
                if (n13 != 0) {
                    if (n10 != 0) {
                        l15 |= 0x10000L;
                        l19 = 262144L;
                    } else {
                        l15 |= 0x8000L;
                        l19 = 131072L;
                    }
                    l15 |= l19;
                }
                n13 = 8;
                f17 = 1.1E-44f;
                if (n10 != 0) {
                    n19 = 0;
                    f14 = 0.0f;
                } else {
                    n19 = n13;
                    f14 = f17;
                }
                int n21 = n10 != 0 ? n13 : 0;
                n13 = n11;
                f17 = f16;
                n10 = n16;
                n11 = (int)l17;
                l17 = n21;
                n20 = n19;
                f15 = f14;
                n19 = n12;
                n12 = n20;
            } else {
                n19 = n12;
                n13 = n11;
                f17 = f16;
                n10 = n16;
                n12 = 0;
                imageView = null;
                n11 = l17;
                l17 = 0;
                viewPager2 = null;
            }
        } else {
            Object var30_29 = null;
            f11 = 0.0f;
            Object var34_35 = null;
            f10 = 0.0f;
            n10 = 0;
            object2 = null;
            n12 = 0;
            imageView = null;
            l17 = 0;
            viewPager2 = null;
            n11 = 0;
            float f18 = 0.0f;
            Object var36_39 = null;
            n14 = 0;
            Object var26_22 = null;
            n13 = 0;
            float f19 = 0.0f;
            Object var38_43 = null;
            n15 = 0;
            n19 = 0;
            f14 = 0.0f;
        }
        l13 = (long)24 & l15;
        long l23 = 0L;
        n17 = (int)(l13 == l23 ? 0 : (l13 < l23 ? -1 : 1));
        if (n17 != 0 && object3 != null) {
            n16 = n17;
            object = a72.r;
            if (object == null) {
                a72.r = object = new a7$b();
            }
            a7$b = object.b((p$b)object3);
            object = a72.s;
            if (object == null) {
                object = new a7$a();
                a72.s = object;
            }
            object = ((a7$a)object).b((p$b)object3);
            object3 = a7$b;
        } else {
            n16 = n17;
            object3 = null;
            n17 = 0;
            f12 = 0.0f;
            object = null;
        }
        long l24 = l15 & (long)22;
        l23 = 0L;
        long l25 = l24 == l23 ? 0 : (l24 < l23 ? -1 : 1);
        if (l25 != false) {
            a7$b = object;
            object = a72.a;
            object.setVisibility((int)l17);
            a72.g.setVisibility(n12);
            viewPager2 = a72.j;
            viewPager2.setVisibility(n12);
        } else {
            a7$b = object;
        }
        long l26 = l15 & (long)16;
        l23 = 0L;
        n12 = (int)(l26 == l23 ? 0 : (l26 < l23 ? -1 : 1));
        if (n12 != 0) {
            imageView = a72.c;
            viewPager2 = a72.o;
            imageView.setOnClickListener((View.OnClickListener)viewPager2);
            imageView = a72.d;
            viewPager2 = a72.q;
            imageView.setOnClickListener((View.OnClickListener)viewPager2);
            imageView = a72.e;
            viewPager2 = a72.p;
            imageView.setOnClickListener((View.OnClickListener)viewPager2);
            imageView = a72.f;
            viewPager2 = a72.n;
            imageView.setOnClickListener((View.OnClickListener)viewPager2);
        }
        if ((l11 = (l10 = (l15 &= (long)21) - (l12 = 0L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            RadioButton radioButton = a72.d;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)radioButton, n10 != 0);
            a72.d.setTextColor(n14);
            TextViewBindingAdapter.setTextSize((TextView)a72.d, f11);
            CompoundButtonBindingAdapter.setChecked((CompoundButton)a72.e, n13 != 0);
            a72.e.setTextColor(n11);
            TextViewBindingAdapter.setTextSize((TextView)a72.e, f13);
            CompoundButtonBindingAdapter.setChecked((CompoundButton)a72.f, n15 != 0);
            a72.f.setTextColor(n19);
            object2 = a72.f;
            TextViewBindingAdapter.setTextSize((TextView)object2, f10);
        }
        if (n16 != 0) {
            a72.h.setOnClickListener((View.OnClickListener)object3);
            object2 = a72.i;
            object3 = a7$b;
            object2.setOnClickListener((View.OnClickListener)a7$b);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.t;
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
            this.t = l10 = (long)16;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                return false;
            }
            object = (MutableLiveData)object;
            return this.D((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.C((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 95;
        if (n11 == n10) {
            object = (u)object;
            this.B((u)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 != n10) return 0 != 0;
            object = (p$b)object;
            this.A((p$b)object);
        }
        return 1 != 0;
    }
}

