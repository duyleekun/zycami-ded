/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableInt;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.zhiyun.cama.widget.RingProgressBar;
import com.zhiyun.cama.widget.RoundImageView;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.c.d1.e;
import d.v.c.d1.h;
import d.v.c.f1.a.b$a;
import d.v.c.w0.ya;
import d.v.l.g.a;
import java.io.Serializable;
import l.a.q.g0.u;

public class za
extends ya
implements b$a {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private final ConstraintLayout i;
    private final View j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private long m;

    public za(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private za(DataBindingComponent object, View object2, Object[] view) {
        Object object3;
        int n10 = 1;
        Object object4 = object3 = view[n10];
        object4 = (RoundImageView)object3;
        Object object5 = object3 = view[5];
        object5 = (TextView)object3;
        Object object6 = object3 = view[3];
        object6 = (View)object3;
        Object object7 = object3 = view[4];
        object7 = (RingProgressBar)((Object)object3);
        super(object, (View)object2, 3, (RoundImageView)object4, (TextView)object5, (View)object6, (RingProgressBar)((Object)object7));
        this.m = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)view[0]);
        this.i = object;
        object.setTag(null);
        int n11 = 2;
        this.j = view = (View)view[n11];
        view.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.setRootTag((View)object2);
        super(this, n11);
        this.k = object2;
        super(this, n10);
        this.l = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean G(ObservableInt observableInt, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 4;
                this.m = l10 |= l11;
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
    private boolean H(MediatorLiveData mediatorLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 2;
                this.m = l10 |= l11;
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
    private boolean I(ObservableList observableList, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 1L;
                this.m = l10 |= l11;
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
    public void C(e e10) {
        this.e = e10;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 32;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(52);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(h h10) {
        this.h = h10;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 16;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(53);
        super.requestRebind();
    }

    public void E(ObservableList observableList) {
        this.g = observableList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(Integer n10) {
        this.f = n10;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 8;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(101);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                int n14;
                Object object;
                int n15;
                Serializable serializable = this.f;
                h h10 = this.h;
                e e10 = this.e;
                if (e10 != null) {
                    n15 = n12;
                } else {
                    n15 = 0;
                    object = null;
                }
                if (n15 != 0 && (n14 = (object = e10.b()) != null ? n12 : 0) != 0 && (n14 = (object = ((TemplatePOJO)object).getTemplateData()) != null ? n12 : 0) != 0) {
                    n15 = (int)(((TemplateData)object).isDownloadFinished() ? 1 : 0);
                    if (n15 != 0) {
                        if (h10 != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            n10 = (Integer)serializable;
                            h10.o(n10);
                        }
                    } else {
                        serializable = e10.a();
                        if (serializable != null) {
                            n15 = n12;
                        } else {
                            n15 = 0;
                            object = null;
                        }
                        if (n15 != 0) {
                            n10 = ((ObservableInt)serializable).get();
                            if (n10 == 0) {
                                n10 = n12;
                            } else {
                                n10 = 0;
                                serializable = null;
                            }
                            if (n10 != 0) {
                                if (h10 != null) {
                                    n11 = n12;
                                }
                                if (n11 != 0) {
                                    h10.c(e10);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            Object var10_15;
            int n16;
            Integer n17 = this.f;
            h h11 = this.h;
            Object object = this.e;
            if (object != null) {
                n16 = n12;
            } else {
                n16 = 0;
                var10_15 = null;
            }
            if (n16 != 0) {
                if ((object = ((e)object).b()) != null) {
                    n16 = n12;
                } else {
                    n16 = 0;
                    var10_15 = null;
                }
                if (n16 != 0) {
                    boolean bl2;
                    if ((object = ((TemplatePOJO)object).getTemplateData()) != null) {
                        n16 = n12;
                    } else {
                        n16 = 0;
                        var10_15 = null;
                    }
                    if (n16 != 0 && (bl2 = ((TemplateData)object).isDownloadFinished())) {
                        if (h11 != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            n10 = n17;
                            h11.o(n10);
                        }
                    }
                }
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
        block29: {
            block28: {
                block27: {
                    var1_1 = this;
                    synchronized (this) {
                        var2_2 = this.m;
                        this.m = var4_3 = 0L;
                    }
                    var6_4 = this.f;
                    var7_5 = this.h;
                    var8_6 /* !! */  = this.e;
                    var9_7 = 90;
                    var11_8 = var2_2 & var9_7;
                    var13_9 = var11_8 == var4_3 ? 0 : (var11_8 < var4_3 ? -1 : 1);
                    var14_10 = 0;
                    if (var13_9 == false) ** GOTO lbl-1000
                    if (var7_5 != null) {
                        var7_5 = var7_5.l();
                    } else {
                        var15_11 = 0;
                        var7_5 = null;
                    }
                    var16_12 = 1;
                    var1_1.updateLiveDataRegistration(var16_12, (LiveData)var7_5);
                    if (var7_5 != null) {
                        var7_5 = (Integer)var7_5.getValue();
                    } else {
                        var15_11 = 0;
                        var7_5 = null;
                    }
                    if (var6_4 != var7_5) {
                        var16_12 = 0;
                    }
                    if (var13_9 != false) {
                        var17_13 = var16_12 != 0 ? 1024L : 512L;
                        var2_2 |= var17_13;
                    }
                    if (var16_12 == 0) {
                        var19_14 = 4;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var19_14 = 0;
                        var6_4 = null;
                    }
                    var20_15 = 100;
                    cfr_temp_0 = (var2_2 & var20_15) - var4_3;
                    var15_11 = cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
                    var22_16 = 96;
                    if (var15_11 == 0) break block27;
                    if (var8_6 /* !! */  != null) {
                        var7_5 = var8_6 /* !! */ .a();
                    } else {
                        var15_11 = 0;
                        var7_5 = null;
                    }
                    var13_9 = 2;
                    var1_1.updateRegistration((int)var13_9, (Observable)var7_5);
                    if (var7_5 != null) {
                        var15_11 = var7_5.get();
                    } else {
                        var15_11 = 0;
                        var7_5 = null;
                    }
                    var24_17 = var2_2 & var22_16;
                    var13_9 = var24_17 == var4_3 ? 0 : (var24_17 < var4_3 ? -1 : 1);
                    if (var13_9 == false) break block28;
                    if (var8_6 /* !! */  != null) {
                        var8_6 /* !! */  = var8_6 /* !! */ .b();
                    } else {
                        var26_18 = 0;
                        var8_6 /* !! */  = null;
                    }
                    if (var8_6 /* !! */  != null) {
                        var8_6 /* !! */  = var8_6 /* !! */ .getTemplateData();
                    } else {
                        var26_18 = 0;
                        var8_6 /* !! */  = null;
                    }
                    if (var8_6 /* !! */  != null) {
                        var27_19 = var8_6 /* !! */ .getCoverUrl();
                        var28_20 = var8_6 /* !! */ .showTitle();
                        var26_18 = var8_6 /* !! */ .isDownloadFinished();
                    } else {
                        var26_18 = 0;
                        var8_6 /* !! */  = null;
                        var27_19 = null;
                        var28_20 = null;
                    }
                    if (var13_9 != false) {
                        var29_21 = var26_18 != 0 ? 256L : 128L;
                        var2_2 |= var29_21;
                    }
                    if (var26_18 != 0) {
                        var14_10 = var26_18 = 8;
                    }
                    var8_6 /* !! */  = var28_20;
                    var28_20 = var27_19;
                    break block29;
                }
                var15_11 = 0;
                var7_5 = null;
            }
            var26_18 = 0;
            var8_6 /* !! */  = null;
            var28_20 = null;
        }
        var13_9 = (cfr_temp_1 = (var22_16 &= var2_2) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1);
        if (var13_9 != false) {
            var31_22 = var1_1.a;
            var32_23 = var31_22.getContext();
            var16_12 = 2131231217;
            var33_24 = AppCompatResources.getDrawable(var32_23, var16_12);
            var34_25 = true;
            var27_19 = var31_22;
            d.v.l.g.a.b(var31_22, var28_20, null, var33_24, 0, var34_25, false, null, null, null);
            var1_1.j.setVisibility(var14_10);
            var31_22 = var1_1.b;
            u.n((TextView)var31_22, (String)var8_6 /* !! */ , null, null);
            var8_6 /* !! */  = var1_1.d;
            var8_6 /* !! */ .setVisibility(var14_10);
        }
        if ((var26_18 = (cfr_temp_2 = (var11_8 = (long)64 & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != 0) {
            var8_6 /* !! */  = var1_1.i;
            var31_22 = var1_1.l;
            var8_6 /* !! */ .setOnClickListener((View.OnClickListener)var31_22);
            var8_6 /* !! */  = var1_1.d;
            var31_22 = var1_1.k;
            var8_6 /* !! */ .setOnClickListener((View.OnClickListener)var31_22);
        }
        if ((var26_18 = (cfr_temp_3 = (var35_26 = var2_2 & var9_7) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != 0) {
            var8_6 /* !! */  = var1_1.c;
            var8_6 /* !! */ .setVisibility(var19_14);
        }
        if ((var19_14 = (int)((cfr_temp_4 = (var2_2 &= (var35_26 = (long)100)) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) != 0) {
            var6_4 = var1_1.d;
            var6_4.setProgress(var15_11);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.m;
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
            this.m = l10 = (long)64;
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
                object = (ObservableInt)object;
                return this.G((ObservableInt)object, n11);
            }
            object = (MediatorLiveData)object;
            return this.H((MediatorLiveData)object, n11);
        }
        object = (ObservableList)object;
        return this.I((ObservableList)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 101;
        if (n11 == n10) {
            object = (Integer)object;
            this.F((Integer)object);
            return 1 != 0;
        } else {
            n11 = 78;
            if (n11 == n10) {
                object = (ObservableList)object;
                this.E((ObservableList)object);
                return 1 != 0;
            } else {
                n11 = 53;
                if (n11 == n10) {
                    object = (h)object;
                    this.D((h)object);
                    return 1 != 0;
                } else {
                    n11 = 52;
                    if (n11 != n10) return 0 != 0;
                    object = (e)object;
                    this.C((e)object);
                }
            }
        }
        return 1 != 0;
    }
}

