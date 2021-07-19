/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.h7.o0.v0$b;
import d.v.c.s0.h7.o0.w0;
import d.v.c.w0.ch;
import java.util.List;
import l.a.q.g0.u;

public class dh
extends ch
implements b$a {
    private static final ViewDataBinding$IncludedLayouts q;
    private static final SparseIntArray r;
    private final ConstraintLayout k;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private long p;

    static {
        SparseIntArray sparseIntArray;
        r = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363319, 6);
        sparseIntArray.put(2131363091, 7);
    }

    public dh(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = q;
        SparseIntArray sparseIntArray = r;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 8, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private dh(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        int n10 = 1;
        Object object2 = object = objectArray[n10];
        object2 = (ImageView)object;
        int n11 = 4;
        Object object3 = object = objectArray[n11];
        object3 = (ImageButton)object;
        Object object4 = object = objectArray[5];
        object4 = (Group)((Object)object);
        Object object5 = object = objectArray[7];
        object5 = (RecyclerView)object;
        int n12 = 3;
        Object object6 = object = objectArray[n12];
        object6 = (ImageButton)object;
        int n13 = 2;
        Object object7 = object = objectArray[n13];
        object7 = (TextView)object;
        Object object8 = object = objectArray[6];
        object8 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 2, (ImageView)object2, (ImageButton)object3, (Group)((Object)object4), (RecyclerView)object5, (ImageButton)object6, (TextView)object7, (TextView)object8);
        this.p = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.k = object;
        object.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n11);
        this.l = object;
        object = new b(this, n13);
        this.m = object;
        object = new b(this, n12);
        this.n = object;
        object = new b(this, n10);
        this.o = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(ObservableBoolean observableBoolean, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.p;
                long l11 = 1L;
                this.p = l10 |= l11;
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
                long l10 = this.p;
                long l11 = 2;
                this.p = l10 |= l11;
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
    public void B(v0$b v0$b) {
        this.j = v0$b;
        synchronized (this) {
            long l10 = this.p;
            long l11 = 8;
            this.p = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(ObservableBoolean observableBoolean) {
        this.updateRegistration(0, observableBoolean);
        this.h = observableBoolean;
        synchronized (this) {
            long l10 = this.p;
            long l11 = 1L;
            this.p = l10 |= l11;
        }
        this.notifyPropertyChanged(117);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(w0 w02) {
        this.i = w02;
        synchronized (this) {
            long l10 = this.p;
            long l11 = 4;
            this.p = l10 |= l11;
        }
        this.notifyPropertyChanged(129);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 != n13) {
                    n13 = 4;
                    if (n10 == n13) {
                        v0$b v0$b = this.j;
                        if (v0$b != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            v0$b.f();
                        }
                    }
                } else {
                    v0$b v0$b = this.j;
                    if (v0$b != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        v0$b.g();
                    }
                }
            } else {
                v0$b v0$b = this.j;
                if (v0$b != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    v0$b.h();
                }
            }
        } else {
            v0$b v0$b = this.j;
            if (v0$b != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                v0$b.e();
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
        var1_1 = this;
        synchronized (this) {
            var2_2 = this.p;
            this.p = var4_3 = 0L;
        }
        var6_4 = this.h;
        var7_5 = this.i;
        var8_6 = 17;
        var10_7 = var2_2 & var8_6;
        var12_8 = var10_7 == var4_3 ? 0 : (var10_7 < var4_3 ? -1 : 1);
        var13_9 = 64;
        var15_10 = 32;
        if (var12_8 != false) {
            var17_11 = var6_4 != null ? var6_4.get() : false;
            if (var12_8 != false) {
                var2_2 = var17_11 ? (var2_2 |= var13_9) : (var2_2 |= var15_10);
            }
            var18_12 = var17_11 ? "@string/cancel" : "@string/select";
        } else {
            var12_8 = 0;
            var18_12 = null;
            var17_11 = false;
        }
        var19_13 = 23;
        var21_14 = var2_2 & var19_13;
        var23_15 = var21_14 == var4_3 ? 0 : (var21_14 < var4_3 ? -1 : 1);
        var24_16 = 8;
        var25_17 = 4096L;
        var27_18 = 22;
        if (var23_15 != false) {
            if (var7_5 != null) {
                var7_5 = var7_5.a;
            } else {
                var29_19 = 0;
                var7_5 = null;
            }
            var30_20 = 1;
            var1_1.updateLiveDataRegistration(var30_20, (LiveData)var7_5);
            if (var7_5 != null) {
                var7_5 = (List)var7_5.getValue();
            } else {
                var29_19 = 0;
                var7_5 = null;
            }
            if (var7_5 != null) {
                var29_19 = var7_5.isEmpty();
            } else {
                var29_19 = 0;
                var7_5 = null;
            }
            var31_21 = var2_2 & var27_18;
            var30_20 = (int)(var31_21 == var4_3 ? 0 : (var31_21 < var4_3 ? -1 : 1));
            if (var30_20 != 0) {
                var31_21 = var29_19 != 0 ? 1024L : 512L;
                var2_2 |= var31_21;
            }
            var30_20 = var29_19 ^ 1;
            var31_21 = var2_2 & var19_13;
            cfr_temp_0 = var31_21 - var4_3;
            var33_22 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
            if (var33_22 /* !! */  != false) {
                if (var30_20 != 0) {
                    var2_2 |= var25_17;
                } else {
                    var31_21 = 2048L;
                    var2_2 |= var31_21;
                }
            }
            if ((var33_22 /* !! */  = (cfr_temp_1 = (var31_21 = var2_2 & var27_18) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false && var29_19 != 0) {
                var29_19 = var24_16;
            } else {
                var29_19 = 0;
                var7_5 = null;
            }
        } else {
            var29_19 = 0;
            var7_5 = null;
            var30_20 = 0;
        }
        var25_17 = var2_2 & var25_17;
        var34_23 = var25_17 == var4_3 ? 0 : (var25_17 < var4_3 ? -1 : 1);
        if (var34_23 != false) {
            if (var6_4 != null) {
                var17_11 = var6_4.get();
            }
            if ((var35_24 = (cfr_temp_2 = (var25_17 = var2_2 & var8_6) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
                var2_2 = var17_11 ? (var2_2 |= var13_9) : (var2_2 |= var15_10);
            }
        }
        if ((var35_24 = (cfr_temp_3 = (var13_9 = var2_2 & var19_13) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) == false) ** GOTO lbl-1000
        if (var30_20 == 0) {
            var17_11 = false;
        }
        if (var35_24 != false) {
            var13_9 = var17_11 != false ? 256L : 128L;
            var2_2 |= var13_9;
        }
        if (!var17_11) {
            var30_20 = var24_16;
        } else lbl-1000:
        // 2 sources

        {
            var30_20 = 0;
        }
        var13_9 = (long)16 & var2_2;
        var35_24 = var13_9 == var4_3 ? 0 : (var13_9 < var4_3 ? -1 : 1);
        if (var35_24 != false) {
            var6_4 = var1_1.a;
            var36_25 = var1_1.o;
            var6_4.setOnClickListener(var36_25);
            var6_4 = var1_1.b;
            var36_25 = var1_1.l;
            var6_4.setOnClickListener(var36_25);
            var6_4 = var1_1.e;
            var36_25 = var1_1.n;
            var6_4.setOnClickListener(var36_25);
            var6_4 = var1_1.f;
            var36_25 = var1_1.m;
            var6_4.setOnClickListener(var36_25);
        }
        if ((var35_24 = (cfr_temp_4 = (var13_9 = var2_2 & var19_13) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.c;
            var6_4.setVisibility(var30_20);
        }
        if ((var35_24 = (cfr_temp_5 = (var13_9 = var2_2 & var27_18) - var4_3) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.f;
            var6_4.setVisibility(var29_19);
        }
        if ((var35_24 = (cfr_temp_6 = (var2_2 &= var8_6) - var4_3) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.f;
            u.n((TextView)var6_4, var18_12, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.p;
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
            this.p = l10 = (long)16;
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
            return this.F((MutableLiveData)object, n11);
        }
        object = (ObservableBoolean)object;
        return this.E((ObservableBoolean)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 117;
        if (n11 == n10) {
            object = (ObservableBoolean)object;
            this.C((ObservableBoolean)object);
            return 1 != 0;
        } else {
            n11 = 129;
            if (n11 == n10) {
                object = (w0)object;
                this.D((w0)object);
                return 1 != 0;
            } else {
                n11 = 23;
                if (n11 != n10) return 0 != 0;
                object = (v0$b)object;
                this.B((v0$b)object);
            }
        }
        return 1 != 0;
    }
}

