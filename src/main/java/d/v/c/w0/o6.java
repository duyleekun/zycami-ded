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
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.widget.LineProgressBar;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.n6;
import d.v.c.w0.o6$a;
import d.v.c.w0.o6$b;
import d.v.c.w0.o6$c;
import d.v.c.y1.h.i$a;
import d.v.c.y1.h.j;
import d.v.f.e.c;
import d.v.f.f.d;
import l.a.q.g0.u;

public class o6
extends n6
implements b$a {
    private static final ViewDataBinding$IncludedLayouts t;
    private static final SparseIntArray u;
    private final ConstraintLayout n;
    private final View.OnClickListener o;
    private o6$b p;
    private o6$a q;
    private o6$c r;
    private long s;

    static {
        SparseIntArray sparseIntArray;
        u = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362172, 10);
        sparseIntArray.put(2131362266, 11);
    }

    public o6(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = t;
        SparseIntArray sparseIntArray = u;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 12, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private o6(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[10];
        object2 = (ConstraintLayout)((Object)object);
        Object object3 = object = objectArray[6];
        object3 = (ConstraintLayout)((Object)object);
        Object object4 = object = objectArray[11];
        object4 = (ExoVideoView)object;
        Object object5 = object = objectArray[1];
        object5 = (ImageView)object;
        Object object6 = object = objectArray[9];
        object6 = (LineProgressBar)((Object)object);
        Object object7 = object = objectArray[2];
        object7 = (LineProgressBar)((Object)object);
        Object object8 = object = objectArray[8];
        object8 = (TextView)object;
        Object object9 = object = objectArray[5];
        object9 = (TextView)object;
        Object object10 = object = objectArray[7];
        object10 = (TextView)object;
        Object object11 = object = objectArray[3];
        object11 = (TextView)object;
        Object object12 = object = objectArray[4];
        object12 = (ImageButton)object;
        object = this;
        super(dataBindingComponent, view, 4, (ConstraintLayout)((Object)object2), (ConstraintLayout)((Object)object3), (ExoVideoView)object4, (ImageView)object5, (LineProgressBar)((Object)object6), (LineProgressBar)((Object)object7), (TextView)object8, (TextView)object9, (TextView)object10, (TextView)object11, (ImageButton)object12);
        this.s = -1;
        this.b.setTag(null);
        this.d.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.n = object;
        object.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, 1);
        this.o = object;
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
                long l10 = this.s;
                long l11 = 2;
                this.s = l10 |= l11;
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
                long l10 = this.s;
                long l11 = 1L;
                this.s = l10 |= l11;
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
                long l10 = this.s;
                long l11 = 8;
                this.s = l10 |= l11;
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
                long l10 = this.s;
                long l11 = 4;
                this.s = l10 |= l11;
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
    public void A(i$a i$a) {
        this.l = i$a;
        synchronized (this) {
            long l10 = this.s;
            long l11 = 32;
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
    public void B(j j10) {
        this.m = j10;
        synchronized (this) {
            long l10 = this.s;
            long l11 = 16;
            this.s = l10 |= l11;
        }
        this.notifyPropertyChanged(55);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        i$a i$a = this.l;
        boolean bl2 = i$a != null;
        if (bl2) {
            i$a.d();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block38: {
            block37: {
                var1_1 = this;
                synchronized (this) {
                    var2_2 = this.s;
                    this.s = var4_3 = 0L;
                }
                var6_4 = this.m;
                var7_5 = this.l;
                var8_6 = (long)95 & var2_2;
                var10_7 /* !! */  = var8_6 == var4_3 ? 0 : (var8_6 < var4_3 ? -1 : 1);
                var11_8 = 84;
                var13_9 = 82;
                var15_10 = 81;
                var17_11 = 0;
                var18_12 = null;
                if (var10_7 /* !! */  == false) break block37;
                var19_13 = var2_2 & var15_10;
                cfr_temp_0 = var19_13 - var4_3;
                var10_7 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                if (var10_7 /* !! */  == false) ** GOTO lbl-1000
                if (var6_4 != null) {
                    var21_14 = var6_4.f();
                    var22_15 = var21_14;
                } else {
                    var23_17 = 0;
                    var22_15 = null;
                }
                var1_1.updateLiveDataRegistration(0, (LiveData)var22_15);
                if (var22_15 != null) {
                    var22_15 = (Boolean)var22_15.getValue();
                } else {
                    var23_17 = 0;
                    var22_15 = null;
                }
                var23_17 = ViewDataBinding.safeUnbox((Boolean)var22_15);
                if (var10_7 /* !! */  != false) {
                    var24_18 = var23_17 != 0 ? 256L : 128L;
                    var2_2 |= var24_18;
                }
                if (var23_17 == 0) {
                    var10_7 /* !! */  = 8;
                } else lbl-1000:
                // 2 sources

                {
                    var10_7 /* !! */  = 0;
                }
                var24_18 = var2_2 & var13_9;
                var23_17 = var24_18 == var4_3 ? 0 : (var24_18 < var4_3 ? -1 : 1);
                if (var23_17 != 0) {
                    if (var6_4 != null) {
                        var22_15 = var6_4.d();
                    } else {
                        var23_17 = 0;
                        var22_15 = null;
                    }
                    var17_11 = 1;
                    var1_1.updateLiveDataRegistration(var17_11, (LiveData)var22_15);
                    if (var22_15 != null) {
                        var18_12 = (Integer)var22_15.getValue();
                    } else {
                        var17_11 = 0;
                        var18_12 = null;
                    }
                    var23_17 = ViewDataBinding.safeUnbox(var18_12);
                } else {
                    var17_11 = 0;
                    var18_12 = null;
                    var23_17 = 0;
                    var22_15 = null;
                }
                var26_19 = var2_2 & var11_8;
                var28_20 = var26_19 == var4_3 ? 0 : (var26_19 < var4_3 ? -1 : 1);
                if (var28_20 != false) {
                    if (var6_4 != null) {
                        var29_21 = var6_4.i();
                        var30_23 = var29_21;
                    } else {
                        var31_24 = 0;
                        var30_23 = null;
                    }
                    var32_26 = 2;
                    var1_1.updateLiveDataRegistration((int)var32_26, (LiveData)var30_23);
                    if (var30_23 != null) {
                        var30_23 = (Integer)var30_23.getValue();
                    } else {
                        var31_24 = 0;
                        var30_23 = null;
                    }
                    var33_27 = var31_24 = ViewDataBinding.safeUnbox((Integer)var30_23);
                    var11_8 = 88;
                } else {
                    var11_8 = 88;
                    var33_27 = 0;
                    var29_22 = null;
                }
                var34_28 = var2_2 & var11_8;
                var31_24 = var34_28 == var4_3 ? 0 : (var34_28 < var4_3 ? -1 : 1);
                if (var31_24 == 0) ** GOTO lbl-1000
                if (var6_4 != null) {
                    var6_4 = var6_4.g();
                } else {
                    var36_29 = false;
                    var6_4 = null;
                }
                var31_24 = 3;
                var1_1.updateLiveDataRegistration(var31_24, (LiveData)var6_4);
                if (var6_4 != null) {
                    var6_4 = (String)var6_4.getValue();
                    var30_23 = var18_12;
                } else lbl-1000:
                // 2 sources

                {
                    var30_23 = var18_12;
                    var36_29 = false;
                    var6_4 = null;
                }
                var17_11 = (int)var10_7 /* !! */ ;
                var10_7 /* !! */  = var33_27;
                break block38;
            }
            var36_29 = false;
            var6_4 = null;
            var10_7 /* !! */  = 0;
            var17_11 = 0;
            var18_12 = null;
            var23_17 = 0;
            var22_16 = null;
            var31_25 = false;
            var30_23 = null;
        }
        var34_28 = var2_2 & (long)96;
        var32_26 = var34_28 == var4_3 ? 0 : (var34_28 < var4_3 ? -1 : 1);
        if (var32_26 != false && var7_5 != null) {
            var37_30 = var1_1.p;
            if (var37_30 == null) {
                var1_1.p = var37_30 = new o6$b();
            }
            var37_30 = var37_30.b(var7_5);
            var38_31 = var1_1.q;
            if (var38_31 == null) {
                var1_1.q = var38_31 = new o6$a();
            }
            var38_31 = var38_31.b(var7_5);
            var39_32 = var1_1.r;
            if (var39_32 == null) {
                var39_32 = new o6$c();
                var1_1.r = var39_32;
            }
            var39_32 = var39_32.b(var7_5);
        } else {
            var40_33 = false;
            var39_32 = null;
            var37_30 = null;
            var38_31 = null;
        }
        var41_34 = var2_2 & var15_10;
        var15_10 = 0L;
        var43_35 = var41_34 == var15_10 ? 0 : (var41_34 < var15_10 ? -1 : 1);
        if (var43_35 != false) {
            var44_36 /* !! */  = var1_1.b;
            var44_36 /* !! */ .setVisibility(var17_11);
        }
        if (var32_26 != false) {
            var1_1.d.setOnClickListener((View.OnClickListener)var37_30);
            var1_1.g.setOnClickListener((View.OnClickListener)var38_31);
            var44_36 /* !! */  = var1_1.h;
            d.v.f.e.c.f((View)var44_36 /* !! */ , (d)var39_32);
        }
        if (var40_33 = (cfr_temp_1 = (var4_3 = (long)82 & var2_2) - (var45_37 = 0L)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) {
            var1_1.e.setProgress(var23_17);
            var39_32 = var1_1.i;
            var44_36 /* !! */  = "@string/edit_extracting";
            var7_5 = null;
            l.a.q.g0.u.n((TextView)var39_32, (String)var44_36 /* !! */ , var30_23, null);
        }
        if (var40_33 = (cfr_temp_2 = (var4_3 = (long)84 & var2_2) - var45_37) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) {
            var39_32 = var1_1.f;
            var39_32.setProgress((int)var10_7 /* !! */ );
        }
        if (var40_33 = (cfr_temp_3 = (var4_3 = (long)88 & var2_2) - var45_37) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) {
            var39_32 = var1_1.j;
            var43_35 = 0;
            var44_36 /* !! */  = null;
            l.a.q.g0.u.n((TextView)var39_32, (String)var6_4, null, null);
        }
        if (var36_29 = (cfr_temp_4 = (var2_2 &= (var4_3 = (long)64)) - var45_37) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) {
            var6_4 = var1_1.k;
            var47_38 = var1_1.o;
            var6_4.setOnClickListener(var47_38);
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
            this.s = l10 = (long)64;
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
                    return this.E((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.F((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.C((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.D((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 55;
        if (n11 == n10) {
            object = (j)object;
            this.B((j)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 != n10) return 0 != 0;
            object = (i$a)object;
            this.A((i$a)object);
        }
        return 1 != 0;
    }
}

