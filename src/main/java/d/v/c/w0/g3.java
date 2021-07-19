/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import d.v.c.f1.a.b$a;
import d.v.c.m1.d.l$a;
import d.v.c.m1.d.m;
import d.v.c.w0.f3;
import d.v.f.i.g;
import l.a.q.g0.u;

public class g3
extends f3
implements b$a {
    private static final ViewDataBinding$IncludedLayouts o;
    private static final SparseIntArray p;
    private final ConstraintLayout i;
    private final TextView j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private long n;

    static {
        SparseIntArray sparseIntArray;
        p = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362224, 5);
        sparseIntArray.put(2131363678, 6);
        sparseIntArray.put(2131362723, 7);
    }

    public g3(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = o;
        SparseIntArray sparseIntArray = p;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 8, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private g3(DataBindingComponent object, View object2, Object[] textView) {
        Object object3;
        Object object4;
        Object object5 = object4 = textView[5];
        object5 = (ConstraintLayout)((Object)object4);
        int n10 = 1;
        Object object6 = object3 = textView[n10];
        object6 = (ImageView)object3;
        Object object7 = object3 = textView[7];
        object7 = (ImageView)object3;
        Object object8 = object3 = textView[4];
        object8 = (TextView)object3;
        int n11 = 3;
        Object object9 = object3 = textView[n11];
        object9 = (TextView)object3;
        Object object10 = object3 = textView[6];
        object10 = (View)object3;
        object3 = this;
        super(object, (View)object2, 3, (ConstraintLayout)((Object)object5), (ImageView)object6, (ImageView)object7, (TextView)object8, (TextView)object9, (View)object10);
        this.n = -1;
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)textView[0]);
        this.i = object;
        object.setTag(null);
        int n12 = 2;
        this.j = textView = (TextView)textView[n12];
        textView.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.setRootTag((View)object2);
        super(this, n10);
        this.k = object2;
        super(this, n11);
        this.l = object2;
        super(this, n12);
        this.m = object2;
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
                long l10 = this.n;
                long l11 = 4;
                this.n = l10 |= l11;
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
                long l10 = this.n;
                long l11 = 2;
                this.n = l10 |= l11;
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
                long l10 = this.n;
                long l11 = 1L;
                this.n = l10 |= l11;
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
    public void A(l$a l$a) {
        this.g = l$a;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 16;
            this.n = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(m m10) {
        this.h = m10;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 8;
            this.n = l10 |= l11;
        }
        this.notifyPropertyChanged(40);
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
                    l$a l$a = this.g;
                    if (l$a != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        l$a.c();
                    }
                }
            } else {
                l$a l$a = this.g;
                if (l$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    l$a.b();
                }
            }
        } else {
            l$a l$a = this.g;
            if (l$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                l$a.a();
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block26: {
            block27: {
                var1_1 = this;
                synchronized (this) {
                    var2_2 = this.n;
                    this.n = var4_3 = 0L;
                }
                var6_4 = this.h;
                var7_5 = (long)47 & var2_2;
                var9_6 /* !! */  = var7_5 == var4_3 ? 0 : (var7_5 < var4_3 ? -1 : 1);
                var10_7 = 42;
                var12_8 = 44;
                var14_9 = 41;
                var16_10 = 0;
                var17_11 = null;
                if (var9_6 /* !! */  == false) break block27;
                var18_12 = var2_2 & var14_9;
                cfr_temp_0 = var18_12 - var4_3;
                var9_6 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                if (var9_6 /* !! */  != false) {
                    if (var6_4 != null) {
                        var20_13 = var6_4.b;
                    } else {
                        var9_6 /* !! */  = 0;
                        var20_13 = null;
                    }
                    var1_1.updateLiveDataRegistration(0, (LiveData)var20_13);
                    if (var20_13 != null) {
                        var20_13 = (Integer)var20_13.getValue();
                    } else {
                        var9_6 /* !! */  = 0;
                        var20_13 = null;
                    }
                    var9_6 /* !! */  = ViewDataBinding.safeUnbox((Integer)var20_13);
                    var21_14 = this.getRoot().getContext();
                    var20_13 = d.v.f.i.g.m(var21_14, (int)var9_6 /* !! */ );
                } else {
                    var9_6 /* !! */  = 0;
                    var20_13 = null;
                }
                var18_12 = var2_2 & var10_7;
                var22_15 = var18_12 == var4_3 ? 0 : (var18_12 < var4_3 ? -1 : 1);
                if (var22_15 == false) ** GOTO lbl-1000
                if (var6_4 != null) {
                    var17_11 = var6_4.c;
                } else {
                    var16_10 = 0;
                    var17_11 = null;
                }
                var23_16 = 1;
                var1_1.updateLiveDataRegistration((int)var23_16, var17_11);
                if (var17_11 != null) {
                    var24_17 /* !! */  = (Boolean)var17_11.getValue();
                } else {
                    var23_16 = 0;
                    var24_17 /* !! */  = null;
                }
                var23_16 = (long)ViewDataBinding.safeUnbox((Boolean)var24_17 /* !! */ );
                if (var22_15 != false) {
                    var25_18 = var23_16 != false ? 128L : (long)64;
                    var2_2 |= var25_18;
                }
                if (var23_16 == false) {
                    var16_10 = 8;
                } else lbl-1000:
                // 2 sources

                {
                    var16_10 = 0;
                    var17_11 = null;
                }
                var14_9 = var2_2 & var12_8;
                var23_16 = var14_9 == var4_3 ? 0 : (var14_9 < var4_3 ? -1 : 1);
                if (var23_16 != false) {
                    if (var6_4 != null) {
                        var6_4 = var6_4.a;
                    } else {
                        var27_19 = 0;
                        var6_4 = null;
                    }
                    var23_16 = 2;
                    var1_1.updateLiveDataRegistration((int)var23_16, (LiveData)var6_4);
                    if (var6_4 != null) {
                        var6_4 = (Integer)var6_4.getValue();
                    } else {
                        var27_19 = 0;
                        var6_4 = null;
                    }
                    var27_19 = ViewDataBinding.safeUnbox((Integer)var6_4);
                    var24_17 /* !! */  = this.getRoot().getContext();
                    var6_4 = d.v.f.i.g.m((Context)var24_17 /* !! */ , var27_19);
                    break block26;
                } else {
                    var27_19 = 0;
                    var6_4 = null;
                }
                break block26;
            }
            var27_19 = 0;
            var6_4 = null;
            var9_6 /* !! */  = 0;
            var20_13 = null;
            var16_10 = 0;
            var17_11 = null;
        }
        var14_9 = (long)32 & var2_2;
        var23_16 = var14_9 == var4_3 ? 0 : (var14_9 < var4_3 ? -1 : 1);
        if (var23_16 != false) {
            var24_17 /* !! */  = var1_1.b;
            var28_20 = var1_1.k;
            var24_17 /* !! */ .setOnClickListener(var28_20);
            var24_17 /* !! */  = var1_1.d;
            var28_20 = var1_1.l;
            var24_17 /* !! */ .setOnClickListener(var28_20);
            var24_17 /* !! */  = var1_1.e;
            var28_20 = var1_1.m;
            var24_17 /* !! */ .setOnClickListener(var28_20);
        }
        if ((var29_21 = (cfr_temp_1 = (var12_8 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
            var30_22 = var1_1.j;
            u.n(var30_22, (String)var6_4, null, null);
        }
        if ((var27_19 = (cfr_temp_2 = (var10_7 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != 0) {
            var6_4 = var1_1.e;
            var6_4.setVisibility(var16_10);
        }
        if ((var27_19 = (cfr_temp_3 = (var2_2 &= (var10_7 = (long)41)) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != 0) {
            var6_4 = var1_1.e;
            u.n((TextView)var6_4, (String)var20_13, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.n;
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
            this.n = l10 = (long)32;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    return false;
                }
                object = (MutableLiveData)object;
                return this.C((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.D((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.E((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 40;
        if (n11 == n10) {
            object = (m)object;
            this.B((m)object);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 != n10) return 0 != 0;
            object = (l$a)object;
            this.A((l$a)object);
        }
        return 1 != 0;
    }
}

