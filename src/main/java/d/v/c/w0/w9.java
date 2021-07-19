/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.album.AlbumSection;
import com.zhiyun.image.Images$CacheStrategy;
import d.v.c.w0.v9;
import d.v.e.l.m1;
import d.v.l.g.a;
import l.a.q.g0.u;

public class w9
extends v9 {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private final ConstraintLayout g;
    private long h;

    public w9(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private w9(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[5];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[1];
        object4 = (ImageView)object2;
        Object object5 = object2 = objectArray[4];
        object5 = (ImageView)object2;
        Object object6 = object2 = objectArray[3];
        object6 = (TextView)object2;
        Object object7 = object2 = objectArray[2];
        object7 = (TextView)object2;
        super(object, view, 2, (ImageView)object3, (ImageView)object4, (ImageView)object5, (TextView)object6, (TextView)object7);
        this.h = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.g = object;
        object.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean A(ObservableBoolean observableBoolean, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.h;
                long l11 = 2;
                this.h = l10 |= l11;
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
    private boolean B(ObservableBoolean observableBoolean, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.h;
                long l11 = 1L;
                this.h = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block29: {
            block28: {
                var1_1 = this;
                synchronized (this) {
                    var2_2 = this.h;
                    this.h = var4_3 = 0L;
                }
                var6_4 = this.f;
                var7_5 = (long)15 & var2_2;
                var9_6 = var7_5 == var4_3 ? 0 : (var7_5 < var4_3 ? -1 : 1);
                var10_7 = 13;
                var12_8 = 12;
                var14_9 = 0;
                if (var9_6 == false) break block28;
                if (var6_4 != null) {
                    var6_4 = var6_4.getAlbum();
                } else {
                    var15_10 = false;
                    var6_4 = null;
                }
                var16_11 = var2_2 & var12_8;
                var9_6 = var16_11 == var4_3 ? 0 : (var16_11 < var4_3 ? -1 : 1);
                if (var9_6 != false) {
                    if (var6_4 != null) {
                        var18_12 = var6_4.storyName;
                        var19_13 = var6_4.getDurationSec();
                        var20_14 /* !! */  = var6_4.isVideo;
                        var21_15 = var19_13;
                    } else {
                        var21_15 = 0;
                        var22_18 = null;
                        var23_19 = 0.0f;
                        var20_14 /* !! */  = 0;
                        var18_12 = null;
                    }
                    if (var9_6 != false) {
                        var24_22 = var20_14 /* !! */  != 0 ? (long)32 : (long)16;
                        var2_2 |= var24_22;
                    }
                    var9_6 = (long)TextUtils.isEmpty((CharSequence)var18_12);
                    var23_19 = var21_15;
                    var21_15 = Math.round(var23_19);
                    var26_23 = var20_14 /* !! */  != 0 ? 0 : 8;
                    var24_22 = var2_2 & var12_8;
                    cfr_temp_0 = var24_22 - var4_3;
                    var20_14 /* !! */  = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                    if (var20_14 /* !! */  != 0) {
                        var24_22 = var9_6 != false ? 512L : 256L;
                        var2_2 |= var24_22;
                    }
                    var27_24 = var9_6 != false ? Images$CacheStrategy.DEFAULT : Images$CacheStrategy.NONE;
                    var22_18 = m1.D(var21_15);
                } else {
                    var26_23 = 0;
                    var9_6 = 0;
                    var27_24 = null;
                    var21_16 = false;
                    var23_20 = 0.0f;
                    var22_18 = null;
                    var18_12 = null;
                }
                var24_22 = var2_2 & var10_7;
                var20_14 /* !! */  = var24_22 == var4_3 ? 0 : (var24_22 < var4_3 ? -1 : 1);
                if (var20_14 /* !! */  == 0) ** GOTO lbl-1000
                if (var6_4 != null) {
                    var28_25 = var6_4.isChecked;
                } else {
                    var29_27 = 0;
                    var28_25 = null;
                }
                var1_1.updateRegistration(0, var28_25);
                if (var28_25 != null) {
                    var29_27 = var28_25.get();
                } else {
                    var29_27 = 0;
                    var28_25 = null;
                }
                if (var20_14 /* !! */  != 0) {
                    var30_28 = var29_27 != 0 ? 2048L : 1024L;
                    var2_2 |= var30_28;
                }
                if (var29_27 == 0) {
                    var29_27 = 8;
                } else lbl-1000:
                // 2 sources

                {
                    var29_27 = 0;
                    var28_25 = null;
                }
                var32_29 = 14;
                var30_28 = var2_2 & var32_29;
                var34_30 = var30_28 == var4_3 ? 0 : (var30_28 < var4_3 ? -1 : 1);
                if (var34_30 != false) {
                    if (var6_4 != null) {
                        var6_4 = var6_4.favorite;
                    } else {
                        var15_10 = false;
                        var6_4 = null;
                    }
                    var20_14 /* !! */  = 1;
                    var1_1.updateRegistration(var20_14 /* !! */ , (Observable)var6_4);
                    if (var6_4 != null) {
                        var15_10 = var6_4.get();
                    } else {
                        var15_10 = false;
                        var6_4 = null;
                    }
                    if (var34_30 != false) {
                        var30_28 = var15_10 != false ? 128L : (long)64;
                        var2_2 |= var30_28;
                    }
                    if (!var15_10) {
                        var14_9 = 8;
                    }
                }
                var35_31 = var27_24;
                var36_32 = 14;
                break block29;
            }
            var29_27 = 0;
            var28_26 = null;
            var26_23 = 0;
            var21_17 = false;
            var23_21 = 0.0f;
            var22_18 = null;
            var18_12 = null;
            var36_32 = 14;
            var35_31 = null;
        }
        var36_32 = var2_2 & var36_32;
        var15_10 = var36_32 == var4_3 ? 0 : (var36_32 < var4_3 ? -1 : 1);
        if (var15_10) {
            var6_4 = var1_1.a;
            var6_4.setVisibility(var14_9);
        }
        if (var15_10 = (cfr_temp_1 = (var12_8 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) {
            d.v.l.g.a.b(var1_1.b, null, null, null, 0, false, false, var35_31, null, null);
            var6_4 = var1_1.d;
            var9_6 = 0;
            var27_24 = null;
            u.n((TextView)var6_4, var18_12, null, null);
            var1_1.e.setVisibility(var26_23);
            var6_4 = var1_1.e;
            u.n((TextView)var6_4, var22_18, null, null);
        }
        if (var15_10 = (cfr_temp_2 = (var2_2 &= (var38_33 = (long)13)) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) {
            var6_4 = var1_1.c;
            var6_4.setVisibility(var29_27);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.h;
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
            this.h = l10 = (long)8;
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
            return this.A((ObservableBoolean)object, n11);
        }
        object = (ObservableBoolean)object;
        return this.B((ObservableBoolean)object, n11);
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 116;
        if (n11 == n10) {
            object = (AlbumSection)object;
            this.z((AlbumSection)object);
            n10 = 1;
        } else {
            n10 = 0;
        }
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void z(AlbumSection albumSection) {
        this.f = albumSection;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 4;
            this.h = l10 |= l11;
        }
        this.notifyPropertyChanged(116);
        super.requestRebind();
    }
}

