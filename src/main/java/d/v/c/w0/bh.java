/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.VideoView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import com.zhiyun.cama.splash.SplashFragment$c;
import d.v.c.t1.s;
import d.v.c.w0.ah;
import d.v.c.w0.bh$a;
import d.v.c.w0.bh$b;
import d.v.c.w0.bh$c;
import l.a.q.g0.u;

public class bh
extends ah {
    private static final ViewDataBinding$IncludedLayouts s;
    private static final SparseIntArray t;
    private final ConstraintLayout n;
    private bh$c o;
    private bh$a p;
    private bh$b q;
    private long r;

    static {
        SparseIntArray sparseIntArray;
        t = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363667, 10);
        sparseIntArray.put(2131362700, 11);
    }

    public bh(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = s;
        SparseIntArray sparseIntArray = t;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 12, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private bh(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[3];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[1];
        object3 = (ImageView)object;
        Object object4 = object = objectArray[11];
        object4 = (ImageView)object;
        Object object5 = object = objectArray[9];
        object5 = (LinearLayout)object;
        Object object6 = object = objectArray[4];
        object6 = (TextView)object;
        Object object7 = object = objectArray[7];
        object7 = (TextView)object;
        Object object8 = object = objectArray[8];
        object8 = (TextView)object;
        Object object9 = object = objectArray[6];
        object9 = (TextView)object;
        Object object10 = object = objectArray[2];
        object10 = (VideoView)object;
        Object object11 = object = objectArray[10];
        object11 = (VideoView)object;
        Object object12 = object = objectArray[5];
        object12 = (ViewPager)((Object)object);
        object = this;
        super(dataBindingComponent, view, 6, (ImageView)object2, (ImageView)object3, (ImageView)object4, (LinearLayout)object5, (TextView)object6, (TextView)object7, (TextView)object8, (TextView)object9, (VideoView)object10, (VideoView)object11, (ViewPager)((Object)object12));
        this.r = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.n = object;
        object.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.k.setTag(null);
        object = view;
        this.setRootTag(view);
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
                long l10 = this.r;
                long l11 = 8;
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
    private boolean D(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.r;
                long l11 = 16;
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
    private boolean E(MutableLiveData mutableLiveData, int n10) {
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
    private boolean F(MutableLiveData mutableLiveData, int n10) {
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
    private boolean G(MutableLiveData mutableLiveData, int n10) {
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
    private boolean H(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.r;
                long l11 = 32;
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
    public void A(SplashFragment$c splashFragment$c) {
        this.m = splashFragment$c;
        synchronized (this) {
            long l10 = this.r;
            long l11 = 64;
            this.r = l10 |= l11;
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
        this.l = s10;
        synchronized (this) {
            long l10 = this.r;
            long l11 = 128L;
            this.r = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block74: {
            block75: {
                block82: {
                    block81: {
                        block80: {
                            block79: {
                                block78: {
                                    block77: {
                                        block76: {
                                            var1_1 = this;
                                            synchronized (this) {
                                                var2_2 = this.r;
                                                this.r = var4_3 = 0L;
                                            }
                                            var6_4 /* !! */  = this.m;
                                            var7_5 = this.l;
                                            var8_6 = 320L;
                                            var10_7 = var2_2 & var8_6;
                                            var12_8 = var10_7 == var4_3 ? 0 : (var10_7 < var4_3 ? -1 : 1);
                                            if (var12_8 != false && var6_4 /* !! */  != null) {
                                                var13_9 = this.o;
                                                if (var13_9 == null) {
                                                    this.o = var13_9 = new bh$c();
                                                }
                                                var13_9 = var13_9.b((SplashFragment$c)var6_4 /* !! */ );
                                                var14_10 = var1_1.p;
                                                if (var14_10 == null) {
                                                    var1_1.p = var14_10 = new bh$a();
                                                }
                                                var14_10 = var14_10.b((SplashFragment$c)var6_4 /* !! */ );
                                                var15_11 = var1_1.q;
                                                if (var15_11 == null) {
                                                    var15_11 = new bh$b();
                                                    var1_1.q = var15_11;
                                                }
                                                var6_4 /* !! */  = var15_11.b((SplashFragment$c)var6_4 /* !! */ );
                                            } else {
                                                var16_12 = false;
                                                var6_4 /* !! */  = null;
                                                var12_8 = 0;
                                                var13_9 = null;
                                                var14_10 = null;
                                            }
                                            var17_13 = 447L & var2_2;
                                            var19_14 /* !! */  = var17_13 == var4_3 ? 0 : (var17_13 < var4_3 ? -1 : 1);
                                            var20_15 = 1;
                                            var21_16 = 392L;
                                            var23_17 = 16384L;
                                            var25_18 = 385L;
                                            var27_19 = 65536L;
                                            var29_20 = 386L;
                                            var31_21 = 388L;
                                            var33_22 = 400L;
                                            var35_23 = 402L;
                                            var37_24 = 8;
                                            var38_25 = 1.1E-44f;
                                            var39_26 = 420L;
                                            var41_27 = 4;
                                            var42_28 = 5.6E-45f;
                                            var43_29 = 0;
                                            var44_30 = null;
                                            if (var19_14 /* !! */  == false) break block75;
                                            var45_31 = var2_2 & var25_18;
                                            cfr_temp_0 = var45_31 - var4_3;
                                            var19_14 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                            if (var19_14 /* !! */  == false) ** GOTO lbl-1000
                                            if (var7_5 != null) {
                                                var15_11 = var7_5.f();
                                            } else {
                                                var19_14 /* !! */  = 0;
                                                var15_11 = null;
                                            }
                                            var1_1.updateLiveDataRegistration(0, (LiveData)var15_11);
                                            if (var15_11 != null) {
                                                var15_11 = (String)var15_11.getValue();
                                            } else lbl-1000:
                                            // 2 sources

                                            {
                                                var19_14 /* !! */  = 0;
                                                var15_11 = null;
                                            }
                                            var45_31 = var2_2 & var35_23;
                                            var47_32 = var45_31 == var4_3 ? 0 : (var45_31 < var4_3 ? -1 : 1);
                                            if (var47_32 == false) break block76;
                                            if (var7_5 != null) {
                                                var48_33 = var7_5.e();
                                                var44_30 = var48_33;
                                            } else {
                                                var43_29 = 0;
                                                var44_30 = null;
                                            }
                                            var1_1.updateLiveDataRegistration(var20_15, (LiveData)var44_30);
                                            if (var44_30 != null) {
                                                var44_30 = (Boolean)var44_30.getValue();
                                            } else {
                                                var43_29 = 0;
                                                var44_30 = null;
                                            }
                                            var43_29 = ViewDataBinding.safeUnbox((Boolean)var44_30);
                                            if (var47_32 != false) {
                                                if (var43_29 != 0) {
                                                    var2_2 |= var27_19;
                                                } else {
                                                    var49_34 = 32768L;
                                                    var2_2 |= var49_34;
                                                }
                                            }
                                            if ((var47_32 = (cfr_temp_1 = (var49_34 = var2_2 & var29_20) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
                                                if (var43_29 != 0) {
                                                    var2_2 |= 0x100000L;
                                                    var49_34 = 0x400000L;
                                                } else {
                                                    var2_2 |= 524288L;
                                                    var49_34 = 0x200000L;
                                                }
                                                var2_2 |= var49_34;
                                            }
                                            if ((var47_32 = (cfr_temp_2 = (var49_34 = var2_2 & var29_20) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) == false) break block77;
                                            if (var43_29 != 0) {
                                                var47_32 = 0;
                                                var51_35 = 0.0f;
                                            } else {
                                                var47_32 = var37_24;
                                                var51_36 = var38_25;
                                            }
                                            if (var43_29 != 0) break block78;
                                            var52_38 = var41_27;
                                            var53_39 = var42_28;
                                            break block79;
                                        }
                                        var43_29 = 0;
                                        var44_30 = null;
                                    }
                                    var47_32 = 0;
                                    var51_37 = 0.0f;
                                }
                                var52_38 = 0;
                                var53_40 = 0.0f;
                            }
                            var54_41 = var2_2 & var39_26;
                            var56_42 = var54_41 == var4_3 ? 0 : (var54_41 < var4_3 ? -1 : 1);
                            if (var56_42 == false) break block80;
                            if (var7_5 != null) {
                                var57_43 = var7_5.e;
                            } else {
                                var20_15 = 0;
                                var57_43 = null;
                            }
                            var58_46 = 2;
                            var1_1.updateLiveDataRegistration(var58_46, (LiveData)var57_43);
                            if (var57_43 != null) {
                                var57_43 = (Boolean)var57_43.getValue();
                            } else {
                                var20_15 = 0;
                                var57_43 = null;
                            }
                            var20_15 = (int)ViewDataBinding.safeUnbox((Boolean)var57_43);
                            var59_47 = var2_2 & var31_21;
                            var58_46 = (int)(var59_47 == var4_3 ? 0 : (var59_47 < var4_3 ? -1 : 1));
                            if (var58_46 != 0) {
                                var59_47 = var20_15 != 0 ? 1024L : 512L;
                                var2_2 |= var59_47;
                            }
                            if ((var58_46 = (int)((cfr_temp_3 = (var59_47 = var2_2 & var39_26) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) != 0) {
                                if (var20_15 != 0) {
                                    var2_2 |= var23_17;
                                } else {
                                    var59_47 = 8192L;
                                    var2_2 |= var59_47;
                                }
                            }
                            if ((var58_46 = (int)((cfr_temp_4 = (var59_47 = var2_2 & var31_21) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) == 0 || var20_15 != 0) break block81;
                            var58_46 = var37_24;
                            break block82;
                        }
                        var20_15 = 0;
                        var57_44 = null;
                    }
                    var58_46 = 0;
                }
                var61_48 = var2_2 & var21_16;
                var63_49 = var61_48 == var4_3 ? 0 : (var61_48 < var4_3 ? -1 : 1);
                if (var63_49 == false) ** GOTO lbl-1000
                var64_50 = var7_5 != null ? var7_5.g : null;
                var65_51 = 3;
                var1_1.updateLiveDataRegistration(var65_51, (LiveData)var64_50);
                if (var64_50 != null) {
                    var64_50 = (String)var64_50.getValue();
                } else lbl-1000:
                // 2 sources

                {
                    var64_50 = null;
                }
                var66_52 = var2_2 & var33_22;
                var65_51 = (int)(var66_52 == var4_3 ? 0 : (var66_52 < var4_3 ? -1 : 1));
                if (var65_51 != 0) {
                    if (var7_5 != null) {
                        var68_53 = var7_5.c();
                        var69_54 = var68_53;
                    } else {
                        var70_55 = 0;
                        var69_54 = null;
                    }
                    var1_1.updateLiveDataRegistration(var41_27, (LiveData)var69_54);
                    if (var69_54 != null) {
                        var71_56 = (Boolean)var69_54.getValue();
                    } else {
                        var72_57 /* !! */  = 0;
                        var71_56 = null;
                    }
                    var63_49 = (long)ViewDataBinding.safeUnbox((Boolean)var71_56);
                    if (var65_51 != 0) {
                        if (var63_49 != false) {
                            var61_48 = 0x1000000L;
                            var2_2 |= var61_48;
                        } else {
                            var73_58 = 0x800000L;
                            var2_2 |= var73_58;
                        }
                    }
                    var65_51 = var63_49 != false ? 0 : var41_27;
                    var75_59 = var47_32;
                    var76_60 = var52_38;
                    break block74;
                } else {
                    var75_59 = var47_32;
                    var76_60 = var52_38;
                    var70_55 = 0;
                    var69_54 = null;
                    var72_57 /* !! */  = 0;
                    var71_56 = null;
                    var65_51 = 0;
                }
                break block74;
            }
            var70_55 = 0;
            var69_54 = null;
            var72_57 /* !! */  = 0;
            var71_56 = null;
            var43_29 = 0;
            var44_30 = null;
            var20_15 = 0;
            var57_45 = null;
            var19_14 /* !! */  = 0;
            var15_11 = null;
            var64_50 = null;
            var65_51 = 0;
            var58_46 = 0;
            var75_59 = 0;
            var76_60 = 0;
        }
        var27_19 = var2_2 & var27_19;
        var66_52 = 0L;
        var63_49 = var27_19 == var66_52 ? 0 : (var27_19 < var66_52 ? -1 : 1);
        if (var63_49 != false) {
            if (var7_5 != null) {
                var69_54 = var7_5.c();
            }
            var1_1.updateLiveDataRegistration(var41_27, (LiveData)var69_54);
            if (var69_54 != null) {
                var71_56 = var69_54 = var69_54.getValue();
                var71_56 = (Boolean)var69_54;
            }
            var70_55 = ViewDataBinding.safeUnbox(var71_56);
            var27_19 = var2_2 & var33_22;
            var66_52 = 0L;
            cfr_temp_5 = var27_19 - var66_52;
            var72_57 /* !! */  = (int)(cfr_temp_5 == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1));
            if (var72_57 /* !! */  != 0) {
                var27_19 = var70_55 != 0 ? 0x1000000L : 0x800000L;
                var2_2 |= var27_19;
            }
            var72_57 /* !! */  = 1;
            var70_55 ^= var72_57 /* !! */ ;
        } else {
            var70_55 = 0;
            var69_54 = null;
        }
        var23_17 = var2_2 & var23_17;
        var27_19 = 0L;
        var72_57 /* !! */  = var23_17 == var27_19 ? 0 : (var23_17 < var27_19 ? -1 : 1);
        if (var72_57 /* !! */  != 0) {
            if (var7_5 != null) {
                var71_56 = var7_5.f;
            } else {
                var72_57 /* !! */  = 0;
                var71_56 = null;
            }
            var77_61 = 5;
            var1_1.updateLiveDataRegistration(var77_61, (LiveData)var71_56);
            if (var71_56 != null) {
                var71_56 = (Boolean)var71_56.getValue();
            } else {
                var72_57 /* !! */  = 0;
                var71_56 = null;
            }
            var72_57 /* !! */  = ViewDataBinding.safeUnbox((Boolean)var71_56);
        } else {
            var72_57 /* !! */  = 0;
            var71_56 = null;
        }
        var23_17 = var2_2 & var39_26;
        var27_19 = 0L;
        var77_61 = (int)(var23_17 == var27_19 ? 0 : (var23_17 < var27_19 ? -1 : 1));
        if (var77_61 == 0) ** GOTO lbl-1000
        if (var20_15 == 0) {
            var72_57 /* !! */  = 0;
            var71_56 = null;
        }
        if (var77_61 != 0) {
            var23_17 = var72_57 /* !! */  != 0 ? 0x4000000L : 0x2000000L;
            var2_2 |= var23_17;
        }
        if (var72_57 /* !! */  == 0) {
            var72_57 /* !! */  = var37_24;
        } else lbl-1000:
        // 2 sources

        {
            var72_57 /* !! */  = 0;
            var71_56 = null;
        }
        var23_17 = var2_2 & var35_23;
        var27_19 = 0L;
        var77_61 = (int)(var23_17 == var27_19 ? 0 : (var23_17 < var27_19 ? -1 : 1));
        if (var77_61 != 0) {
            if (var43_29 == 0) {
                var70_55 = 0;
                var69_54 = null;
            }
            if (var77_61 != 0) {
                if (var70_55 != 0) {
                    var2_2 |= 4096L;
                    var23_17 = 262144L;
                } else {
                    var2_2 |= 2048L;
                    var23_17 = 131072L;
                }
                var2_2 |= var23_17;
            }
            if (var70_55 != 0) {
                var41_27 = 0;
                var42_28 = 0.0f;
            }
            if (var70_55 != 0) {
                var37_24 = 0;
                var38_25 = 0.0f;
            }
            var43_29 = var41_27;
            var70_55 = var37_24;
            var78_62 = 320L;
        } else {
            var70_55 = 0;
            var69_54 = null;
            var78_62 = 320L;
            var43_29 = 0;
            var44_30 = null;
        }
        var23_17 = 0L;
        cfr_temp_6 = (var78_62 &= var2_2) - var23_17;
        var77_61 = (int)(cfr_temp_6 == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1));
        if (var77_61 != 0) {
            var1_1.a.setOnClickListener((View.OnClickListener)var14_10);
            var7_5 = var1_1.e;
            var7_5.setOnClickListener((View.OnClickListener)var6_4 /* !! */ );
            var1_1.g.setOnClickListener((View.OnClickListener)var13_9);
            var6_4 /* !! */  = var1_1.h;
            var6_4 /* !! */ .setOnClickListener((View.OnClickListener)var13_9);
        }
        if (var16_12 = (cfr_temp_7 = (var78_62 = var2_2 & var31_21) - (var10_7 = 0L)) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1)) {
            var1_1.a.setVisibility(var58_46);
            var1_1.b.setVisibility(var58_46);
            var6_4 /* !! */  = var1_1.e;
            var6_4 /* !! */ .setVisibility(var58_46);
        }
        if (var16_12 = (cfr_temp_8 = (var78_62 = var2_2 & var35_23) - var10_7) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1)) {
            var1_1.d.setVisibility(var43_29);
            var6_4 /* !! */  = var1_1.h;
            var6_4 /* !! */ .setVisibility(var70_55);
        }
        if (var16_12 = (cfr_temp_9 = (var78_62 = var2_2 & var21_16) - var10_7) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1)) {
            var6_4 /* !! */  = var1_1.e;
            var70_55 = 0;
            var69_54 = null;
            u.n((TextView)var6_4 /* !! */ , (String)var64_50, null, null);
        }
        if (var16_12 = (cfr_temp_10 = (var78_62 = var2_2 & var29_20) - var10_7) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1)) {
            var6_4 /* !! */  = var1_1.f;
            var70_55 = var76_60;
            var6_4 /* !! */ .setVisibility(var76_60);
            var6_4 /* !! */  = var1_1.k;
            var70_55 = var75_59;
            var6_4 /* !! */ .setVisibility(var75_59);
        }
        if (var16_12 = (cfr_temp_11 = (var78_62 = var2_2 & var25_18) - var10_7) == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1)) {
            var6_4 /* !! */  = var1_1.f;
            var70_55 = 0;
            var69_54 = null;
            u.n((TextView)var6_4 /* !! */ , (String)var15_11, null, null);
        }
        if (var16_12 = (cfr_temp_12 = (var78_62 = var2_2 & var33_22) - var10_7) == 0L ? 0 : (cfr_temp_12 < 0L ? -1 : 1)) {
            var6_4 /* !! */  = var1_1.g;
            var6_4 /* !! */ .setVisibility(var65_51);
        }
        if (var16_12 = (cfr_temp_13 = (var2_2 &= var39_26) - var10_7) == 0L ? 0 : (cfr_temp_13 < 0L ? -1 : 1)) {
            var6_4 /* !! */  = var1_1.i;
            var6_4 /* !! */ .setVisibility(var72_57 /* !! */ );
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
            this.r = l10 = 256L;
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
                            n12 = 5;
                            if (n10 != n12) {
                                return false;
                            }
                            object = (MutableLiveData)object;
                            return this.H((MutableLiveData)object, n11);
                        }
                        object = (MutableLiveData)object;
                        return this.D((MutableLiveData)object, n11);
                    }
                    object = (MutableLiveData)object;
                    return this.C((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.G((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.E((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.F((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (SplashFragment$c)object;
            this.A((SplashFragment$c)object);
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

