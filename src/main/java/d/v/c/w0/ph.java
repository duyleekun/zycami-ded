/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

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
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import d.v.c.f1.a.b$a;
import d.v.c.s0.h7.r0.r$d;
import d.v.c.s0.h7.r0.s;
import d.v.c.w0.oh;

public class ph
extends oh
implements b$a {
    private static final ViewDataBinding$IncludedLayouts l;
    private static final SparseIntArray m;
    private final TextView h;
    private final View.OnClickListener i;
    private final View.OnClickListener j;
    private long k;

    static {
        SparseIntArray sparseIntArray;
        m = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363278, 4);
        sparseIntArray.put(2131363708, 5);
    }

    public ph(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = l;
        SparseIntArray sparseIntArray = m;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private ph(DataBindingComponent dataBindingComponent, View object, Object[] textView) {
        Object object2;
        Object object3;
        Object object4 = object3 = textView[0];
        object4 = (ConstraintLayout)((Object)object3);
        int n10 = 1;
        Object object5 = object2 = textView[n10];
        object5 = (ImageView)object2;
        Object object6 = object2 = textView[4];
        object6 = (TabLayout)((Object)object2);
        Object object7 = object2 = textView[3];
        object7 = (TextView)object2;
        Object object8 = object2 = textView[5];
        object8 = (ViewPager)((Object)object2);
        object2 = this;
        super(dataBindingComponent, (View)object, 2, (ConstraintLayout)((Object)object4), (ImageView)object5, (TabLayout)((Object)object6), (TextView)object7, (ViewPager)((Object)object8));
        this.k = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        int n11 = 2;
        this.h = textView = (TextView)textView[n11];
        textView.setTag(null);
        this.d.setTag(null);
        this.setRootTag((View)object);
        super(this, n10);
        this.i = object;
        super(this, n11);
        this.j = object;
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
                long l10 = this.k;
                long l11 = 2;
                this.k = l10 |= l11;
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
                long l10 = this.k;
                long l11 = 1L;
                this.k = l10 |= l11;
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
    public void A(r$d r$d) {
        this.f = r$d;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 4;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(s s10) {
        this.g = s10;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 8;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                r$d r$d = this.f;
                if (r$d != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    r$d.a(view);
                }
            }
        } else {
            r$d r$d = this.f;
            if (r$d != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                r$d.b(view);
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
        block20: {
            block19: {
                var1_1 = this;
                synchronized (this) {
                    var2_2 = this.k;
                    this.k = var4_3 = 0L;
                }
                var6_4 = this.g;
                var7_5 = (long)27 & var2_2;
                var9_6 = var7_5 == var4_3 ? 0 : (var7_5 < var4_3 ? -1 : 1);
                var10_7 = 26;
                var12_8 = 25;
                var14_9 = 0;
                if (var9_6 == false) break block19;
                var15_10 = var2_2 & var12_8;
                var9_6 = var15_10 == var4_3 ? 0 : (var15_10 < var4_3 ? -1 : 1);
                var17_11 = 8;
                var18_12 = 1.1E-44f;
                var19_13 = null;
                if (var9_6 == false) ** GOTO lbl-1000
                if (var6_4 != null) {
                    var20_14 = var6_4.a;
                } else {
                    var21_15 = false;
                    var20_14 = null;
                }
                var1_1.updateLiveDataRegistration(0, (LiveData)var20_14);
                if (var20_14 != null) {
                    var20_14 = (Boolean)var20_14.getValue();
                } else {
                    var21_15 = false;
                    var20_14 = null;
                }
                var21_15 = ViewDataBinding.safeUnbox((Boolean)var20_14);
                if (var9_6 != false) {
                    var22_16 = var21_15 != false ? 256L : 128L;
                    var2_2 |= var22_16;
                }
                if (!var21_15) {
                    var9_6 = var17_11;
                    var24_17 = var18_12;
                } else lbl-1000:
                // 2 sources

                {
                    var9_6 = 0;
                    var25_19 = null;
                    var24_18 = 0.0f;
                }
                var26_20 = var2_2 & var10_7;
                var21_15 = var26_20 == var4_3 ? 0 : (var26_20 < var4_3 ? -1 : 1);
                if (var21_15) {
                    if (var6_4 != null) {
                        var6_4 = var6_4.b;
                    } else {
                        var28_21 = 0;
                        var6_4 = null;
                    }
                    var29_22 = 1;
                    var1_1.updateLiveDataRegistration(var29_22, (LiveData)var6_4);
                    if (var6_4 != null) {
                        var19_13 = var6_4 = var6_4.getValue();
                        var19_13 = (Boolean)var6_4;
                    }
                    var28_21 = (int)ViewDataBinding.safeUnbox(var19_13);
                    if (var21_15) {
                        var30_23 = var28_21 != 0 ? (long)64 : (long)32;
                        var2_2 |= var30_23;
                    }
                    if (var28_21 == 0) {
                        var14_9 = var17_11;
                    }
                }
                var28_21 = var14_9;
                var14_9 = (int)var9_6;
                break block20;
            }
            var28_21 = 0;
            var6_4 = null;
        }
        var15_10 = (long)16 & var2_2;
        var9_6 = var15_10 == var4_3 ? 0 : (var15_10 < var4_3 ? -1 : 1);
        if (var9_6 != false) {
            var25_19 = var1_1.b;
            var32_24 = var1_1.i;
            var25_19.setOnClickListener(var32_24);
            var25_19 = var1_1.d;
            var32_24 = var1_1.j;
            var25_19.setOnClickListener(var32_24);
        }
        if ((var9_6 = (cfr_temp_0 = (var12_8 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false) {
            var25_19 = var1_1.h;
            var25_19.setVisibility(var14_9);
        }
        if ((var33_25 = (cfr_temp_1 = (var2_2 &= var10_7) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
            var34_26 = var1_1.d;
            var34_26.setVisibility(var28_21);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.k;
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
            this.k = l10 = (long)16;
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
        int n11 = 23;
        if (n11 == n10) {
            object = (r$d)object;
            this.A((r$d)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 != n10) return 0 != 0;
            object = (s)object;
            this.B((s)object);
        }
        return 1 != 0;
    }
}

