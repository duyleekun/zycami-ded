/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.q1.h0.k0$a;
import d.v.c.w0.h3;
import d.v.e0.td;
import l.a.q.g0.u;

public class i3
extends h3
implements b$a {
    private static final ViewDataBinding$IncludedLayouts t;
    private static final SparseIntArray u;
    private final ConstraintLayout n;
    private final ImageView o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;
    private final View.OnClickListener r;
    private long s;

    static {
        SparseIntArray sparseIntArray;
        u = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362553, 7);
        sparseIntArray.put(2131363608, 8);
        sparseIntArray.put(2131362291, 9);
        sparseIntArray.put(2131362478, 10);
        sparseIntArray.put(2131362278, 11);
        sparseIntArray.put(2131362821, 12);
    }

    public i3(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = t;
        SparseIntArray sparseIntArray = u;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 13, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private i3(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[11];
        object2 = (View)object;
        Object object3 = object = objectArray[9];
        object3 = (View)object;
        Object object4 = object = objectArray[10];
        object4 = (ConstraintLayout)((Object)object);
        Object object5 = object = objectArray[7];
        object5 = (Guideline)((Object)object);
        Object object6 = object = objectArray[12];
        object6 = (LinearLayout)object;
        Object object7 = object = objectArray[5];
        object7 = (Button)object;
        Object object8 = object = objectArray[6];
        object8 = (Button)object;
        Object object9 = object = objectArray[2];
        object9 = (TextView)object;
        Object object10 = object = objectArray[3];
        object10 = (TextView)object;
        Object object11 = object = objectArray[4];
        object11 = (TextView)object;
        Object object12 = object = objectArray[8];
        object12 = (TextView)object;
        object = this;
        Object object13 = dataBindingComponent;
        View view2 = view;
        super(dataBindingComponent, view, 0, (View)object2, (View)object3, (ConstraintLayout)((Object)object4), (Guideline)((Object)object5), (LinearLayout)object6, (Button)object7, (Button)object8, (TextView)object9, (TextView)object10, (TextView)object11, (TextView)object12);
        this.s = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.n = object;
        object.setTag(null);
        int n10 = 1;
        view2 = (ImageView)objectArray[n10];
        this.o = view2;
        view2.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        object13 = view;
        this.setRootTag(view);
        object13 = new b(this, n10);
        this.p = object13;
        object = new b(this, 3);
        this.q = object;
        object = new b(this, 2);
        this.r = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A(k0$a k0$a) {
        this.l = k0$a;
        synchronized (this) {
            long l10 = this.s;
            long l11 = 2;
            this.s = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(td td2) {
        this.m = td2;
        synchronized (this) {
            long l10 = this.s;
            long l11 = 1L;
            this.s = l10 |= l11;
        }
        this.notifyPropertyChanged(37);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 == n13) {
                    k0$a k0$a = this.l;
                    if (k0$a != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        k0$a.b();
                    }
                }
            } else {
                k0$a k0$a = this.l;
                if (k0$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    k0$a.c();
                }
            }
        } else {
            k0$a k0$a = this.l;
            if (k0$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                k0$a.a();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        Object object;
        Object object2;
        long l10;
        long l11;
        long l12;
        long l13;
        int n10;
        String string2;
        Object object3;
        long l14;
        long l15;
        i3 i32 = this;
        synchronized (this) {
            l15 = this.s;
            this.s = l14 = 0L;
        }
        Object object4 = this.m;
        long l16 = 5;
        long l17 = l15 & l16;
        long l18 = l17 == l14 ? 0 : (l17 < l14 ? -1 : 1);
        int n11 = 0;
        if (l18 != false) {
            long l19;
            long l20;
            long l21;
            int n12;
            if (object4 != null) {
                object3 = ((td)object4).b;
                string2 = ((td)object4).e;
                object4 = ((td)object4).a;
            } else {
                object4 = null;
                object3 = null;
                string2 = null;
            }
            object3 = object3 != null ? object3.toString() : null;
            int n13 = 1;
            float f10 = Float.MIN_VALUE;
            n10 = string2 == null ? n13 : 0;
            if (object4 == null) {
                n12 = n13;
                float f11 = f10;
            } else {
                n12 = 0;
                float f12 = 0.0f;
            }
            if (l18 != false) {
                l21 = n10 != 0 ? (long)64 : (long)32;
                l15 |= l21;
            }
            if ((l18 = (l20 = (l21 = l15 & l16) - l14) == 0L ? 0 : (l20 < 0L ? -1 : 1)) != false) {
                l21 = n12 != 0 ? (long)16 : (long)8;
                l15 |= l21;
            }
            if (object3 == null) {
                n11 = n13;
            }
            if ((l18 = (l19 = (l21 = l15 & l16) - l14) == 0L ? 0 : (l19 < 0L ? -1 : 1)) != false) {
                l21 = n11 != 0 ? 256L : 128L;
                l15 |= l21;
            }
            l18 = n11;
            n11 = n12;
        } else {
            l18 = 0;
            n10 = 0;
            object4 = null;
            object3 = null;
            string2 = null;
        }
        long l22 = (l13 = (l16 &= l15) - l14) == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l22 != false) {
            if (n11 != 0) {
                object4 = "";
            }
            if (n10 != 0) {
                string2 = "";
            }
            if (l18 != false) {
                object3 = "";
            }
        } else {
            object4 = null;
            object3 = null;
            string2 = null;
        }
        if ((l12 = (l11 = (l15 &= (l10 = (long)4)) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            object2 = i32.o;
            object = i32.p;
            object2.setOnClickListener(object);
            object2 = i32.f;
            object = i32.r;
            object2.setOnClickListener(object);
            object2 = i32.g;
            object = i32.q;
            object2.setOnClickListener(object);
        }
        if (l22 != false) {
            l.a.q.g0.u.n(i32.h, "@string/bind_device_model", object3, null);
            object2 = i32.i;
            object = "@string/bind_device_name";
            l.a.q.g0.u.n((TextView)object2, (String)object, object4, null);
            object4 = i32.j;
            object2 = "@string/bind_device_sn";
            l.a.q.g0.u.n((TextView)object4, (String)object2, string2, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.s;
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
            this.s = l10 = (long)4;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 37;
        if (n11 == n10) {
            object = (td)object;
            this.B((td)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 != n10) return 0 != 0;
            object = (k0$a)object;
            this.A((k0$a)object);
        }
        return 1 != 0;
    }
}

