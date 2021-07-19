/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.zhiyun.cama.album.AlbumDetailFragment$c;
import com.zhiyun.cama.album.AlbumSection;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.f1.a.f;
import d.v.c.f1.a.f$a;
import d.v.c.w0.t5;
import d.v.e.l.m1;
import d.v.f.e.c;
import d.v.f.f.d;
import l.a.q.g0.u;

public class u5
extends t5
implements f$a,
b$a {
    private static final ViewDataBinding$IncludedLayouts s;
    private static final SparseIntArray t;
    private final ConstraintLayout l;
    private final d m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;
    private long r;

    static {
        SparseIntArray sparseIntArray;
        t = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363708, 8);
    }

    public u5(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = s;
        SparseIntArray sparseIntArray = t;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 9, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private u5(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[1];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[6];
        object3 = (ImageView)object;
        Object object4 = object = objectArray[7];
        object4 = (ImageView)object;
        int n10 = 5;
        Object object5 = object = objectArray[n10];
        object5 = (ImageView)object;
        Object object6 = object = objectArray[3];
        object6 = (ImageView)object;
        int n11 = 2;
        Object object7 = object = objectArray[n11];
        object7 = (TextView)object;
        int n12 = 4;
        Object object8 = object = objectArray[n12];
        object8 = (View)object;
        Object object9 = object = objectArray[8];
        object9 = (ViewPager2)((Object)object);
        object = this;
        super(dataBindingComponent, view, 3, (ImageView)object2, (ImageView)object3, (ImageView)object4, (ImageView)object5, (ImageView)object6, (TextView)object7, (View)object8, (ViewPager2)((Object)object9));
        this.r = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.l = object;
        object.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new f(this, n12);
        this.m = object;
        object = new b(this, n11);
        this.n = object;
        object = new b(this, n10);
        this.o = object;
        object = new b(this, 3);
        this.p = object;
        object = new b(this, 1);
        this.q = object;
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
                long l10 = this.r;
                long l11 = 2;
                this.r = l10 |= l11;
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
    private boolean F(ObservableField observableField, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.r;
                long l11 = 1L;
                this.r = l10 |= l11;
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
    private boolean G(ObservableBoolean observableBoolean, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.r;
                long l11 = 4;
                this.r = l10 |= l11;
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
    public void B(AlbumDetailFragment$c albumDetailFragment$c) {
        this.k = albumDetailFragment$c;
        synchronized (this) {
            long l10 = this.r;
            long l11 = 8;
            this.r = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(ObservableBoolean observableBoolean) {
        int n10 = 1;
        this.updateRegistration(n10, observableBoolean);
        this.j = observableBoolean;
        synchronized (this) {
            long l10 = this.r;
            long l11 = 2;
            this.r = l10 |= l11;
        }
        this.notifyPropertyChanged(107);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(ObservableField observableField) {
        this.updateRegistration(0, observableField);
        this.i = observableField;
        synchronized (this) {
            long l10 = this.r;
            long l11 = 1L;
            this.r = l10 |= l11;
        }
        this.notifyPropertyChanged(116);
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
                    n14 = 5;
                    if (n10 == n14) {
                        AlbumDetailFragment$c albumDetailFragment$c = this.k;
                        if (albumDetailFragment$c != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            albumDetailFragment$c.c();
                        }
                    }
                } else {
                    AlbumDetailFragment$c albumDetailFragment$c = this.k;
                    if (albumDetailFragment$c != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        albumDetailFragment$c.e();
                    }
                }
            } else {
                AlbumDetailFragment$c albumDetailFragment$c = this.k;
                if (albumDetailFragment$c != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    albumDetailFragment$c.d(view);
                }
            }
        } else {
            AlbumDetailFragment$c albumDetailFragment$c = this.k;
            if (albumDetailFragment$c != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                albumDetailFragment$c.a();
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
            var2_2 = this.r;
            this.r = var4_3 = 0L;
        }
        var6_4 = this.i;
        var7_5 = this.j;
        var8_6 = 21;
        var10_7 = var2_2 & var8_6;
        var12_8 = var10_7 == var4_3 ? 0 : (var10_7 < var4_3 ? -1 : 1);
        var13_9 = 17;
        if (var12_8 != false) {
            if (var6_4 != null) {
                var15_10 = (AlbumSection)var6_4.get();
            } else {
                var16_11 = 0;
                var15_10 = null;
            }
            var17_12 = var15_10 != null ? var15_10.getAlbum() : null;
            var18_13 = var2_2 & var13_9;
            var20_14 = var18_13 == var4_3 ? 0 : (var18_13 < var4_3 ? -1 : 1);
            var21_15 = var15_10;
            if (var20_14 != false) {
                var22_16 = var17_12 != null ? var17_12.addDate : var4_3;
                var24_17 = m1.l(var22_16, "yyyy-MM-dd HH:mm");
            } else {
                var24_17 = null;
            }
            if (var17_12 != null) {
                var25_18 = var17_12.favorite;
            } else {
                var26_19 = 0;
                var25_18 = null;
            }
            var16_11 = 2;
            var1_1.updateRegistration(var16_11, var25_18);
            if (var25_18 != null) {
                var26_19 = (long)var25_18.get();
            } else {
                var26_19 = 0;
                var25_18 = null;
            }
            if (var12_8 != false) {
                var27_20 = var26_19 != false ? (long)64 : (long)32;
                var2_2 |= var27_20;
            }
            var29_21 = var1_1.d.getContext();
            var26_19 = var26_19 != false ? (long)2131231580 : (long)2131231578;
            var29_21 = AppCompatResources.getDrawable(var29_21, (int)var26_19);
            var15_10 = var21_15;
        } else {
            var12_8 = 0;
            var29_21 = null;
            var24_17 = null;
            var16_11 = 0;
            var15_10 = null;
            var17_12 = null;
        }
        var27_20 = 19;
        cfr_temp_0 = (var2_2 & var27_20) - var4_3;
        var26_19 = cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
        var30_22 = 8;
        var31_23 = 1024L;
        var33_24 = 18;
        if (var26_19 != false) {
            if (var7_5 != null) {
                var35_25 = var7_5.get();
            } else {
                var35_25 = 0;
                var7_5 = null;
            }
            var36_26 = var2_2 & var33_24;
            var26_19 = var36_26 == var4_3 ? 0 : (var36_26 < var4_3 ? -1 : 1);
            if (var26_19 != false) {
                var36_26 = var35_25 != 0 ? 4096L : 2048L;
                var2_2 |= var36_26;
            }
            var26_19 = var35_25 ^ 1;
            var36_26 = var2_2 & var27_20;
            cfr_temp_1 = var36_26 - var4_3;
            var38_27 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
            if (var38_27 /* !! */  != false) {
                if (var26_19 != false) {
                    var2_2 |= var31_23;
                } else {
                    var36_26 = 512L;
                    var2_2 |= var36_26;
                }
            }
            if ((var38_27 /* !! */  = (cfr_temp_2 = (var36_26 = var2_2 & var33_24) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false && var35_25 != 0) {
                var35_25 = var30_22;
            } else {
                var35_25 = 0;
                var7_5 = null;
            }
        } else {
            var35_25 = 0;
            var7_5 = null;
            var26_19 = 0;
            var25_18 = null;
        }
        var31_23 = var2_2 & var31_23;
        var39_28 = var31_23 == var4_3 ? 0 : (var31_23 < var4_3 ? -1 : 1);
        if (var39_28 == false) ** GOTO lbl-1000
        if (var6_4 != null) {
            var15_10 = var6_4 = var6_4.get();
            var15_10 = (AlbumSection)var6_4;
        }
        if (var15_10 != null) {
            var17_12 = var15_10.getAlbum();
        }
        if (var17_12 != null) {
            var40_29 = var17_12.isVideo;
        } else lbl-1000:
        // 2 sources

        {
            var40_29 = false;
            var6_4 = null;
        }
        var41_30 = var2_2 & var27_20;
        var16_11 = (int)(var41_30 == var4_3 ? 0 : (var41_30 < var4_3 ? -1 : 1));
        if (var16_11 == 0) ** GOTO lbl-1000
        if (var26_19 == false) {
            var40_29 = false;
            var6_4 = null;
        }
        if (var16_11 != 0) {
            var22_16 = var40_29 != false ? 256L : 128L;
            var2_2 |= var22_16;
        }
        if (!var40_29) {
            var26_19 = var30_22;
        } else lbl-1000:
        // 2 sources

        {
            var26_19 = 0;
            var25_18 = null;
        }
        var41_30 = (long)16 & var2_2;
        var40_29 = var41_30 == var4_3 ? 0 : (var41_30 < var4_3 ? -1 : 1);
        if (var40_29) {
            var6_4 = var1_1.a;
            var15_10 = var1_1.q;
            var6_4.setOnClickListener((View.OnClickListener)var15_10);
            var6_4 = var1_1.b;
            var15_10 = var1_1.m;
            d.v.f.e.c.f((View)var6_4, (d)var15_10);
            var6_4 = var1_1.c;
            var15_10 = var1_1.o;
            var6_4.setOnClickListener((View.OnClickListener)var15_10);
            var6_4 = var1_1.d;
            var15_10 = var1_1.p;
            var6_4.setOnClickListener((View.OnClickListener)var15_10);
            var6_4 = var1_1.e;
            var15_10 = var1_1.n;
            var6_4.setOnClickListener((View.OnClickListener)var15_10);
        }
        if (var40_29 = (cfr_temp_3 = (var41_30 = var2_2 & var33_24) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) {
            var1_1.a.setVisibility(var35_25);
            var1_1.b.setVisibility(var35_25);
            var1_1.d.setVisibility(var35_25);
            var1_1.e.setVisibility(var35_25);
            var1_1.f.setVisibility(var35_25);
            var6_4 = var1_1.g;
            var6_4.setVisibility(var35_25);
        }
        if (var40_29 = (cfr_temp_4 = (var41_30 = var2_2 & var27_20) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) {
            var6_4 = var1_1.c;
            var6_4.setVisibility((int)var26_19);
        }
        if (var40_29 = (cfr_temp_5 = (var43_31 = var2_2 & var8_6) - var4_3) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1)) {
            var6_4 = var1_1.d;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var6_4, (Drawable)var29_21);
        }
        if (var40_29 = (cfr_temp_6 = (var2_2 &= var13_9) - var4_3) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1)) {
            var6_4 = var1_1.f;
            u.n((TextView)var6_4, var24_17, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.r;
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
            this.r = l10 = (long)16;
        }
        this.requestRebind();
    }

    public final void m(int n10, View view) {
        AlbumDetailFragment$c albumDetailFragment$c = this.k;
        boolean bl2 = albumDetailFragment$c != null;
        if (bl2) {
            albumDetailFragment$c.b(view);
        }
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    return false;
                }
                object = (ObservableBoolean)object;
                return this.G((ObservableBoolean)object, n11);
            }
            object = (ObservableBoolean)object;
            return this.E((ObservableBoolean)object, n11);
        }
        object = (ObservableField)object;
        return this.F((ObservableField)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 116;
        if (n11 == n10) {
            object = (ObservableField)object;
            this.D((ObservableField)object);
            return 1 != 0;
        } else {
            n11 = 107;
            if (n11 == n10) {
                object = (ObservableBoolean)object;
                this.C((ObservableBoolean)object);
                return 1 != 0;
            } else {
                n11 = 25;
                if (n11 != n10) return 0 != 0;
                object = (AlbumDetailFragment$c)object;
                this.B((AlbumDetailFragment$c)object);
            }
        }
        return 1 != 0;
    }
}

