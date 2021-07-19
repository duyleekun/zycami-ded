/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.publish.UploadWorksFragment$a;
import d.v.c.f1.a.b$a;
import d.v.c.n1.l2;
import d.v.c.w0.mi;

public class ni
extends mi
implements b$a {
    private static final ViewDataBinding$IncludedLayouts m;
    private static final SparseIntArray n;
    private final ConstraintLayout i;
    private final View.OnClickListener j;
    private final View.OnClickListener k;
    private long l;

    static {
        SparseIntArray sparseIntArray;
        n = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363319, 4);
        sparseIntArray.put(2131362888, 5);
    }

    public ni(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = m;
        SparseIntArray sparseIntArray = n;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private ni(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        int n10 = 1;
        Object object4 = object3 = objectArray[n10];
        object4 = (ImageView)object3;
        Object object5 = object3 = objectArray[3];
        object5 = (ProgressBar)object3;
        Object object6 = object3 = objectArray[5];
        object6 = (RecyclerView)object3;
        int n11 = 2;
        Object object7 = object2 = objectArray[n11];
        object7 = (TextView)object2;
        Object object8 = object2 = objectArray[4];
        object8 = (TextView)object2;
        object2 = this;
        super(object, view, 2, (ImageView)object4, (ProgressBar)object5, (RecyclerView)object6, (TextView)object7, (TextView)object8);
        this.l = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.i = object;
        object.setTag(null);
        this.d.setTag(null);
        this.setRootTag(view);
        super(this, n11);
        this.j = object;
        super(this, n10);
        this.k = object;
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
                long l10 = this.l;
                long l11 = 2;
                this.l = l10 |= l11;
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
                long l10 = this.l;
                long l11 = 1L;
                this.l = l10 |= l11;
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
    public void B(ObservableBoolean observableBoolean) {
        int n10 = 1;
        this.updateRegistration(n10, observableBoolean);
        this.f = observableBoolean;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 2;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(18);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(UploadWorksFragment$a uploadWorksFragment$a) {
        this.h = uploadWorksFragment$a;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 8;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(l2 l22) {
        this.g = l22;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 4;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(148);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                UploadWorksFragment$a uploadWorksFragment$a = this.h;
                if (uploadWorksFragment$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    uploadWorksFragment$a.b();
                }
            }
        } else {
            UploadWorksFragment$a uploadWorksFragment$a = this.h;
            if (uploadWorksFragment$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                uploadWorksFragment$a.a();
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
            var2_2 = this.l;
            this.l = var4_3 = 0L;
        }
        var6_4 = 0.0f;
        var7_5 = null;
        var8_6 = this.g;
        var9_7 = this.f;
        var10_8 = 21;
        var12_9 = var2_2 & var10_8;
        var14_10 = var12_9 == var4_3 ? 0 : (var12_9 < var4_3 ? -1 : 1);
        var15_11 = false;
        if (var14_10 == false) ** GOTO lbl-1000
        var16_12 = null;
        if (var8_6 != null) {
            var8_6 = var8_6.f();
        } else {
            var17_13 = 0;
            var8_6 = null;
        }
        var1_1.updateLiveDataRegistration(0, (LiveData)var8_6);
        if (var8_6 != null) {
            var16_12 = var8_6 = var8_6.getValue();
            var16_12 = (Boolean)var8_6;
        }
        var17_13 = ViewDataBinding.safeUnbox(var16_12);
        if (var14_10 != false) {
            var18_14 = var17_13 != 0 ? 256L : 128L;
            var2_2 |= var18_14;
        }
        if (var17_13 == 0) {
            var17_13 = 8;
        } else lbl-1000:
        // 2 sources

        {
            var17_13 = 0;
            var8_6 = null;
        }
        var18_14 = 18;
        var20_15 = var2_2 & var18_14;
        var14_10 = var20_15 == var4_3 ? 0 : (var20_15 < var4_3 ? -1 : 1);
        if (var14_10 != false) {
            if (var9_7 != null) {
                var15_11 = var9_7.get();
            }
            if (var14_10 != false) {
                if (var15_11) {
                    var2_2 |= (long)64;
                    var20_15 = 1024L;
                } else {
                    var2_2 |= (long)32;
                    var20_15 = 512L;
                }
                var2_2 |= var20_15;
            }
            var6_4 = var15_11 != false ? 1.0f : 0.4f;
            var9_7 = var1_1.d;
            var14_10 = var15_11 != false ? (long)2131099727 : (long)2131100029;
            var22_16 = ViewDataBinding.getColorFromResource((View)var9_7, (int)var14_10);
            var23_17 = var15_11;
            var15_11 = var22_16;
            var22_16 = var23_17;
        } else {
            var22_16 = false;
            var9_7 = null;
        }
        var20_15 = (long)16 & var2_2;
        var14_10 = var20_15 == var4_3 ? 0 : (var20_15 < var4_3 ? -1 : 1);
        if (var14_10 != false) {
            var24_18 = var1_1.a;
            var25_19 = var1_1.k;
            var24_18.setOnClickListener(var25_19);
        }
        if ((var26_20 = (cfr_temp_0 = (var10_8 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false) {
            var27_21 = var1_1.b;
            var27_21.setVisibility(var17_13);
        }
        if ((var28_22 = (cfr_temp_1 = (var2_2 &= var18_14) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
            var28_22 = ViewDataBinding.getBuildSdkInt();
            if (var28_22 >= (var29_23 = 11)) {
                var30_24 = var1_1.d;
                var30_24.setAlpha(var6_4);
            }
            var1_1.d.setTextColor((int)var15_11);
            var7_5 = var1_1.d;
            var30_24 = var1_1.j;
            ViewBindingAdapter.setOnClick((View)var7_5, (View.OnClickListener)var30_24, var22_16);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.l;
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
            this.l = l10 = (long)16;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                return false;
            }
            object = (ObservableBoolean)object;
            return this.E((ObservableBoolean)object, n11);
        }
        object = (MutableLiveData)object;
        return this.F((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 148;
        if (n11 == n10) {
            object = (l2)object;
            this.D((l2)object);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 == n10) {
                object = (UploadWorksFragment$a)object;
                this.C((UploadWorksFragment$a)object);
                return 1 != 0;
            } else {
                n11 = 18;
                if (n11 != n10) return 0 != 0;
                object = (ObservableBoolean)object;
                this.B((ObservableBoolean)object);
            }
        }
        return 1 != 0;
    }
}

