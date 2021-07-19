/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.voice.music.mine.MusicLocalImportViewModel;
import d.v.c.f1.a.b$a;
import d.v.c.w0.h9;
import d.v.c.w0.wi;
import d.v.c.y1.f.x.i0$a;

public class i9
extends h9
implements b$a {
    private static final ViewDataBinding$IncludedLayouts l;
    private static final SparseIntArray m;
    private final ConstraintLayout h;
    private final View.OnClickListener i;
    private final View.OnClickListener j;
    private long k;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        l = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(6);
        String[] stringArray = new String[]{"widget_titlebar_no_button"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 4;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558817;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        m = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131363076, 5);
    }

    public i9(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = l;
        SparseIntArray sparseIntArray = m;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private i9(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[5];
        object4 = (RecyclerView)object3;
        int n10 = 1;
        Object object5 = object2 = objectArray[n10];
        object5 = (SwipeRefreshLayout)object2;
        Object object6 = object2 = objectArray[4];
        object6 = (wi)object2;
        int n11 = 2;
        Object object7 = object2 = objectArray[n11];
        object7 = (TextView)object2;
        Object object8 = object2 = objectArray[3];
        object8 = (StatusView)((Object)object2);
        object2 = this;
        super(object, view, 3, (RecyclerView)object4, (SwipeRefreshLayout)object5, (wi)object6, (TextView)object7, (StatusView)((Object)object8));
        this.k = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.h = object;
        object.setTag(null);
        this.b.setTag(null);
        object = this.c;
        this.setContainedBinding((ViewDataBinding)object);
        this.d.setTag(null);
        this.e.setTag(null);
        this.setRootTag(view);
        super(this, n11);
        this.i = object;
        super(this, n10);
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
    private boolean D(MutableLiveData mutableLiveData, int n10) {
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
    private boolean E(wi wi2, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.k;
                long l11 = 4;
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
    public void A(i0$a i0$a) {
        this.f = i0$a;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 8;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(MusicLocalImportViewModel musicLocalImportViewModel) {
        this.g = musicLocalImportViewModel;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 16;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(82);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                i0$a i0$a = this.f;
                if (i0$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    i0$a.f();
                }
            }
        } else {
            i0$a i0$a = this.f;
            if (i0$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                i0$a.c();
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
        block21: {
            block22: {
                var1_1 = this;
                synchronized (this) {
                    var2_2 = this.k;
                    this.k = var4_3 = 0L;
                }
                var6_4 = this.f;
                var7_5 = this.g;
                var8_6 = (long)51 & var2_2;
                var10_7 = var8_6 == var4_3 ? 0 : (var8_6 < var4_3 ? -1 : 1);
                var11_8 = 50;
                var13_9 = 49;
                var15_10 = null;
                if (var10_7 == false) break block22;
                var16_11 = var2_2 & var13_9;
                var10_7 = var16_11 == var4_3 ? 0 : (var16_11 < var4_3 ? -1 : 1);
                var18_12 = 1;
                var19_13 = 0;
                var20_14 = null;
                if (var10_7 == false) ** GOTO lbl-1000
                if (var7_5 != null) {
                    var21_15 = var7_5.I();
                } else {
                    var22_16 = 0;
                    var21_15 = null;
                }
                var1_1.updateLiveDataRegistration(0, (LiveData)var21_15);
                if (var21_15 != null) {
                    var21_15 = (Integer)var21_15.getValue();
                } else {
                    var22_16 = 0;
                    var21_15 = null;
                }
                var22_16 = ViewDataBinding.safeUnbox((Integer)var21_15);
                if (var22_16 == 0) {
                    var22_16 = var18_12;
                } else {
                    var22_16 = 0;
                    var21_15 = null;
                }
                if (var10_7 != false) {
                    var23_17 = var22_16 != 0 ? 128L : (long)64;
                    var2_2 |= var23_17;
                }
                if (var22_16 != 0) {
                    var10_7 = 8;
                } else lbl-1000:
                // 2 sources

                {
                    var10_7 = 0;
                }
                var25_18 = var2_2 & var11_8;
                var22_16 = var25_18 == var4_3 ? 0 : (var25_18 < var4_3 ? -1 : 1);
                if (var22_16 != 0) {
                    if (var7_5 != null) {
                        var7_5 = var7_5.P();
                    } else {
                        var27_19 = false;
                        var7_5 = null;
                    }
                    var1_1.updateLiveDataRegistration(var18_12, (LiveData)var7_5);
                    if (var7_5 != null) {
                        var20_14 = var7_5 = var7_5.getValue();
                        var20_14 = (Boolean)var7_5;
                    }
                    var27_19 = ViewDataBinding.safeUnbox(var20_14);
                    break block21;
                } else {
                    var27_19 = false;
                    var7_5 = null;
                }
                break block21;
            }
            var27_19 = false;
            var7_5 = null;
            var10_7 = 0;
        }
        var16_11 = (long)32 & var2_2;
        var18_12 = var16_11 == var4_3 ? 0 : (var16_11 < var4_3 ? -1 : 1);
        if (var18_12 != 0) {
            var1_1.b.setEnabled(false);
            var15_10 = var1_1.d;
            var28_20 = var1_1.j;
            var15_10.setOnClickListener(var28_20);
            var15_10 = var1_1.e;
            var28_20 = var15_10.getContext();
            var19_13 = 2131231810;
            var28_20 = AppCompatResources.getDrawable((Context)var28_20, var19_13);
            var15_10.setEmptyImage((Drawable)var28_20);
            var1_1.e.setEmptyText("@string/edit_no_local_muisc");
            var15_10 = var1_1.e;
            var28_20 = AppCompatResources.getDrawable(var15_10.getContext(), var19_13);
            var15_10.setErrorImage((Drawable)var28_20);
            var1_1.e.setErrorText("@string/edit_music_load_error");
            var15_10 = var1_1.e;
            var28_20 = var1_1.i;
            var15_10.setOnClickErrorListener(var28_20);
        }
        if ((var29_21 = (cfr_temp_0 = (var11_8 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false) {
            var30_22 = var1_1.b;
            var30_22.setRefreshing(var27_19);
        }
        if (var27_19 = (cfr_temp_1 = (var11_8 = (long)40 & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) {
            var7_5 = var1_1.c;
            var7_5.z(var6_4);
        }
        if ((var31_23 = (cfr_temp_2 = (var2_2 &= var13_9) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.d;
            var6_4.setVisibility((int)var10_7);
        }
        ViewDataBinding.executeBindingsOn(var1_1.c);
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
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            wi wi2 = this.c;
            l12 = (long)wi2.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
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
            this.k = l10 = (long)32;
        }
        this.c.invalidateAll();
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
                object = (wi)object;
                return this.E((wi)object, n11);
            }
            object = (MutableLiveData)object;
            return this.D((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.C((MutableLiveData)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.c.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (i0$a)object;
            this.A((i0$a)object);
            return 1 != 0;
        } else {
            n11 = 82;
            if (n11 != n10) return 0 != 0;
            object = (MusicLocalImportViewModel)object;
            this.B((MusicLocalImportViewModel)object);
        }
        return 1 != 0;
    }
}

