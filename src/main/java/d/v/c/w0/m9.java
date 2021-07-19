/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 *  android.widget.VideoView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.widget.ShadowContainer;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.p0.p$c;
import d.v.c.s0.h7.p0.q;
import d.v.c.w0.l9;
import d.v.l.g.a;

public class m9
extends l9
implements b$a {
    private static final ViewDataBinding$IncludedLayouts C;
    private static final SparseIntArray D;
    private final View.OnClickListener A;
    private long B;
    private final ConstraintLayout s;
    private final ImageView t;
    private final ImageView u;
    private final View.OnClickListener v;
    private final View.OnClickListener w;
    private final View.OnClickListener x;
    private final View.OnClickListener y;
    private final View.OnClickListener z;

    static {
        SparseIntArray sparseIntArray;
        D = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363674, 11);
        sparseIntArray.put(2131363083, 12);
        sparseIntArray.put(2131363670, 13);
        sparseIntArray.put(2131363595, 14);
        sparseIntArray.put(2131363594, 15);
        sparseIntArray.put(2131363691, 16);
        sparseIntArray.put(2131363158, 17);
    }

    public m9(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = C;
        SparseIntArray sparseIntArray = D;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 18, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private m9(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        m9 m92 = this;
        Object object = this;
        Object object2 = dataBindingComponent;
        ConstraintLayout constraintLayout = (ConstraintLayout)((Object)objectArray[5]);
        ImageView imageView = (ImageView)objectArray[1];
        ImageView imageView2 = (ImageView)objectArray[2];
        ImageView imageView3 = (ImageView)objectArray[8];
        ImageView imageView4 = (ImageView)objectArray[9];
        ImageView imageView5 = (ImageView)objectArray[3];
        RecyclerView recyclerView = (RecyclerView)objectArray[12];
        ShadowContainer shadowContainer = (ShadowContainer)objectArray[17];
        TextView textView = (TextView)objectArray[10];
        TextView textView2 = (TextView)objectArray[15];
        TextView textView3 = (TextView)objectArray[14];
        View view2 = (View)objectArray[4];
        VideoView videoView = (VideoView)objectArray[13];
        View view3 = (View)objectArray[11];
        View view4 = (View)objectArray[16];
        int n10 = 5;
        super(dataBindingComponent, view, n10, constraintLayout, imageView, imageView2, imageView3, imageView4, imageView5, recyclerView, shadowContainer, textView, textView2, textView3, view2, videoView, view3, view4);
        this.B = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.s = object;
        object.setTag(null);
        int n11 = 6;
        m92 = (ImageView)objectArray[n11];
        this.t = m92;
        m92.setTag(null);
        m92 = (ImageView)objectArray[7];
        this.u = m92;
        m92.setTag(null);
        this.i.setTag(null);
        this.l.setTag(null);
        object2 = view;
        this.setRootTag(view);
        object2 = new b(this, 3);
        this.v = object2;
        object2 = new b(this, 4);
        this.w = object2;
        object2 = new b(this, 5);
        this.x = object2;
        object2 = new b(this, 1);
        this.y = object2;
        object2 = new b(this, n11);
        this.z = object2;
        super(this, 2);
        this.A = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(MediatorLiveData mediatorLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.B;
                long l11 = 8;
                this.B = l10 |= l11;
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
                long l10 = this.B;
                long l11 = 4;
                this.B = l10 |= l11;
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
    private boolean G(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.B;
                long l11 = 1L;
                this.B = l10 |= l11;
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
    private boolean H(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.B;
                long l11 = 16;
                this.B = l10 |= l11;
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
    private boolean I(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.B;
                long l11 = 2;
                this.B = l10 |= l11;
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
    public void B(p$c p$c) {
        this.r = p$c;
        synchronized (this) {
            long l10 = this.B;
            long l11 = 64;
            this.B = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(m0 m02) {
        this.q = m02;
        synchronized (this) {
            long l10 = this.B;
            long l11 = 32;
            this.B = l10 |= l11;
        }
        this.notifyPropertyChanged(2);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(q q10) {
        this.p = q10;
        synchronized (this) {
            long l10 = this.B;
            long l11 = 128L;
            this.B = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View object) {
        boolean bl2 = true;
        switch (n10) {
            default: {
                break;
            }
            case 6: {
                Object object2 = this.q;
                p$c p$c = this.r;
                boolean bl3 = object2 != null ? bl2 : false;
                if (!bl3 || !(bl3 = (object2 = ((m0)object2).l()) != null ? bl2 : false) || (bl3 = (object2 = (Integer)((LiveData)object2).getValue()) == null ? bl2 : false)) break;
                if (p$c == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                n10 = (Integer)object2;
                p$c.i((View)object, n10);
                break;
            }
            case 5: {
                Object var5_11;
                boolean bl4;
                p$c p$c = this.r;
                object = this.p;
                if (p$c != null) {
                    bl4 = bl2;
                } else {
                    bl4 = false;
                    var5_11 = null;
                }
                if (!bl4) break;
                if (object != null) {
                    bl4 = bl2;
                } else {
                    bl4 = false;
                    var5_11 = null;
                }
                if (!bl4) break;
                if ((object = ((q)object).e()) == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                object = (TemplateData)((LiveData)object).getValue();
                p$c.c((TemplateData)object);
                break;
            }
            case 4: {
                p$c p$c = this.r;
                object = this.q;
                Object object3 = this.p;
                boolean bl5 = p$c != null ? bl2 : false;
                if (!bl5 || !(bl5 = object3 != null ? bl2 : false) || !(bl5 = (object3 = ((q)object3).e()) != null ? bl2 : false)) break;
                object3 = (TemplateData)((LiveData)object3).getValue();
                bl5 = object != null ? bl2 : false;
                if (!bl5) break;
                if ((object = ((m0)object).l()) == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                object = (Integer)((LiveData)object).getValue();
                int n11 = (Integer)object;
                p$c.b((TemplateData)object3, n11);
                break;
            }
            case 3: {
                p$c p$c = this.r;
                if (p$c == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                p$c.d();
                break;
            }
            case 2: {
                p$c p$c = this.r;
                if (p$c == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                p$c.j();
                break;
            }
            case 1: {
                p$c p$c = this.r;
                if (p$c == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                p$c.e();
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
        block42: {
            block43: {
                var1_1 = this;
                synchronized (this) {
                    var2_2 = this.B;
                    this.B = var4_3 = 0L;
                }
                var6_4 = this.q;
                var7_5 = this.p;
                var8_6 = 296L;
                var10_7 = var2_2 & var8_6;
                var12_8 /* !! */  = var10_7 == var4_3 ? 0 : (var10_7 < var4_3 ? -1 : 1);
                var13_9 = 4;
                var14_10 = 0;
                var15_11 = null;
                if (var12_8 /* !! */  == false) ** GOTO lbl-1000
                if (var6_4 != null) {
                    var6_4 = var6_4.m;
                } else {
                    var16_12 = 0;
                    var6_4 = null;
                }
                var17_13 = 3;
                var1_1.updateLiveDataRegistration(var17_13, (LiveData)var6_4);
                if (var6_4 != null) {
                    var6_4 = (Boolean)var6_4.getValue();
                } else {
                    var16_12 = 0;
                    var6_4 = null;
                }
                var16_12 = ViewDataBinding.safeUnbox((Boolean)var6_4);
                if (var12_8 /* !! */  != false) {
                    var18_14 = var16_12 != 0 ? 1024L : 512L;
                    var2_2 |= var18_14;
                }
                if (var16_12 == 0) {
                    var16_12 = var13_9;
                } else lbl-1000:
                // 2 sources

                {
                    var16_12 = 0;
                    var6_4 = null;
                }
                var12_8 /* !! */  = (cfr_temp_0 = (407L & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
                var18_14 = 388L;
                var20_15 = true;
                var21_16 = 386L;
                var23_17 = 400L;
                var25_18 = 385L;
                if (var12_8 /* !! */  == false) break block43;
                var27_19 = var2_2 & var25_18;
                cfr_temp_1 = var27_19 - var4_3;
                var12_8 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                if (var12_8 /* !! */  != false) {
                    var30_21 = var7_5 != null ? (var29_20 = var7_5.e()) : null;
                    var1_1.updateLiveDataRegistration(0, (LiveData)var30_21);
                    var30_21 = var30_21 != null ? (TemplateData)var30_21.getValue() : null;
                    if (var30_21 != null) {
                        var31_22 = (long)var30_21.isPrimeUsable();
                        var30_21 = var30_21.getCoverUrl();
                    } else {
                        var31_22 = 0;
                        var30_21 = null;
                    }
                    if (var12_8 /* !! */  != false) {
                        var32_23 = var31_22 != false ? 16384L : 8192L;
                        var2_2 |= var32_23;
                    }
                    var12_8 /* !! */  = var31_22 != false ? (long)0 : (long)var13_9;
                } else {
                    var12_8 /* !! */  = 0;
                    var30_21 = null;
                }
                var34_24 = var2_2 & var21_16;
                var31_22 = var34_24 == var4_3 ? 0 : (var34_24 < var4_3 ? -1 : 1);
                var36_25 = 8;
                var37_26 = 1.1E-44f;
                if (var31_22 == false) ** GOTO lbl-1000
                if (var7_5 != null) {
                    var15_11 = var7_5.d;
                } else {
                    var14_10 = 0;
                    var15_11 = null;
                }
                var1_1.updateLiveDataRegistration((int)var20_15, (LiveData)var15_11);
                if (var15_11 != null) {
                    var15_11 = (Boolean)var15_11.getValue();
                } else {
                    var14_10 = 0;
                    var15_11 = null;
                }
                var14_10 = (int)ViewDataBinding.safeUnbox((Boolean)var15_11);
                if (var31_22 != false) {
                    var38_27 = var14_10 != 0 ? 262144L : 131072L;
                    var2_2 |= var38_27;
                }
                if (var14_10 == 0) {
                    var14_10 = var36_25;
                } else lbl-1000:
                // 2 sources

                {
                    var14_10 = 0;
                    var15_11 = null;
                }
                var38_27 = var2_2 & var18_14;
                var31_22 = var38_27 == var4_3 ? 0 : (var38_27 < var4_3 ? -1 : 1);
                if (var31_22 == false) ** GOTO lbl-1000
                if (var7_5 != null) {
                    var40_28 = var7_5.c();
                    var41_29 = var40_28;
                } else {
                    var42_31 = 0;
                    var41_29 = null;
                }
                var43_32 = 2;
                var1_1.updateLiveDataRegistration((int)var43_32, (LiveData)var41_29);
                if (var41_29 != null) {
                    var41_29 = (Boolean)var41_29.getValue();
                } else {
                    var42_31 = 0;
                    var41_29 = null;
                }
                var42_31 = ViewDataBinding.safeUnbox((Boolean)var41_29);
                if (var31_22 != false) {
                    var44_33 = var42_31 != 0 ? 65536L : 32768L;
                    var2_2 |= var44_33;
                }
                if (var42_31 == 0) {
                    var42_31 = var36_25;
                } else lbl-1000:
                // 2 sources

                {
                    var42_31 = 0;
                    var41_29 = null;
                }
                var44_33 = var2_2 & var23_17;
                var43_32 = var44_33 == var4_3 ? 0 : (var44_33 < var4_3 ? -1 : 1);
                if (var43_32 != false) {
                    if (var7_5 != null) {
                        var7_5 = var7_5.c;
                    } else {
                        var46_34 = 0;
                        var7_5 = null;
                    }
                    var1_1.updateLiveDataRegistration(var13_9, (LiveData)var7_5);
                    var29_20 = var7_5 != null ? (var7_5 = (Boolean)var7_5.getValue()) : null;
                    var46_34 = (int)ViewDataBinding.safeUnbox((Boolean)var29_20);
                    if (var43_32 != false) {
                        var27_19 = var46_34 != 0 ? 4096L : 2048L;
                        var2_2 |= var27_19;
                    }
                    if (var46_34 != 0) {
                        var36_25 = 0;
                        var37_26 = 0.0f;
                    }
                    var47_35 = var30_21;
                    var46_34 = var14_10;
                    var14_10 = var36_25;
                    break block42;
                } else {
                    var47_35 = var30_21;
                    var46_34 = var14_10;
                    var14_10 = 0;
                    var15_11 = null;
                }
                break block42;
            }
            var46_34 = 0;
            var7_5 = null;
            var42_31 = 0;
            var41_30 = null;
            var12_8 /* !! */  = 0;
            var14_10 = 0;
            var15_11 = null;
            var47_35 = null;
        }
        var48_36 = 256L & var2_2;
        var43_32 = var48_36 == var4_3 ? 0 : (var48_36 < var4_3 ? -1 : 1);
        if (var43_32 != false) {
            var43_32 = ViewDataBinding.getBuildSdkInt();
            if (var43_32 >= (var13_9 = 21)) {
                var50_37 = var1_1.a;
                var50_37.setClipToOutline(var20_15);
            }
            var50_37 = var1_1.b;
            var51_38 = var1_1.y;
            var50_37.setOnClickListener(var51_38);
            var50_37 = var1_1.c;
            var51_38 = var1_1.A;
            var50_37.setOnClickListener(var51_38);
            var50_37 = var1_1.d;
            var51_38 = var1_1.w;
            var50_37.setOnClickListener(var51_38);
            var50_37 = var1_1.e;
            var51_38 = var1_1.x;
            var50_37.setOnClickListener(var51_38);
            var50_37 = var1_1.f;
            var51_38 = var1_1.v;
            var50_37.setOnClickListener(var51_38);
            var50_37 = var1_1.i;
            var51_38 = var1_1.z;
            var50_37.setOnClickListener(var51_38);
        }
        if ((var43_32 = (cfr_temp_2 = (var48_36 = var2_2 & var23_17) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
            var50_37 = var1_1.d;
            var50_37.setVisibility(var14_10);
        }
        if ((var43_32 = (cfr_temp_3 = (var48_36 = var2_2 & var21_16) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
            var50_37 = var1_1.e;
            var50_37.setVisibility(var46_34);
        }
        if ((var46_34 = (int)((cfr_temp_4 = (var48_36 = var2_2 & var25_18) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) != 0) {
            var1_1.t.setVisibility((int)var12_8 /* !! */ );
            var7_5 = var1_1.u;
            var52_39 = true;
            d.v.l.g.a.b((ImageView)var7_5, var47_35, null, null, 0, var52_39, false, null, null, null);
        }
        if ((var46_34 = (int)((cfr_temp_5 = (var53_40 = var2_2 & var18_14) - var4_3) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0) {
            var7_5 = var1_1.u;
            var7_5.setVisibility(var42_31);
        }
        if ((var57_42 = (cfr_temp_6 = (var2_2 &= (var55_41 = 296L)) - var4_3) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1)) != false) {
            var58_43 = var1_1.l;
            var58_43.setVisibility(var16_12);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.B;
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
            this.B = l10 = 256L;
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
                        n12 = 4;
                        if (n10 != n12) {
                            return false;
                        }
                        object = (MutableLiveData)object;
                        return this.H((MutableLiveData)object, n11);
                    }
                    object = (MediatorLiveData)object;
                    return this.E((MediatorLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.F((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.I((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.G((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 2;
        if (n11 == n10) {
            object = (m0)object;
            this.C((m0)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 == n10) {
                object = (p$c)object;
                this.B((p$c)object);
                return 1 != 0;
            } else {
                n11 = 152;
                if (n11 != n10) return 0 != 0;
                object = (q)object;
                this.D((q)object);
            }
        }
        return 1 != 0;
    }
}

