/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.me.help.FeedbackDetailFragment$b;
import com.zhiyun.cama.me.help.data.FeedbackSet$DealStatus;
import com.zhiyun.cama.me.help.data.FeedbackSet$Lang;
import com.zhiyun.cama.me.help.data.FeedbackSet$Rate;
import com.zhiyun.cama.me.help.data.FeedbackSet$Type;
import com.zhiyun.common.util.Times;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.f1.a.f;
import d.v.c.f1.a.f$a;
import d.v.c.w0.qe;
import d.v.c.w0.re$a;
import d.v.f.e.c;
import d.v.f.f.d;
import d.v.f.i.g;
import l.a.q.g0.u;

public class re
extends qe
implements f$a,
b$a {
    private static final ViewDataBinding$IncludedLayouts V;
    private static final SparseIntArray W;
    private final LinearLayout A;
    private final TextView B;
    private final LinearLayout C;
    private final TextView D;
    private final LinearLayout E;
    private final TextView F;
    private final LinearLayout G;
    private final TextView H;
    private final TextView I;
    private final LinearLayout J;
    private final TextView K;
    private final LinearLayout L;
    private final TextView M;
    private final LinearLayout N;
    private final TextView O;
    private final LinearLayout P;
    private final TextView Q;
    private final d R;
    private final View.OnClickListener S;
    private re$a T;
    private long U;
    private final FrameLayout n;
    private final LinearLayout o;
    private final TextView p;
    private final LinearLayout q;
    private final TextView r;
    private final LinearLayout s;
    private final TextView t;
    private final LinearLayout u;
    private final TextView v;
    private final LinearLayout w;
    private final TextView x;
    private final LinearLayout y;
    private final TextView z;

    static {
        SparseIntArray sparseIntArray;
        W = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362498, 33);
        sparseIntArray.put(2131363615, 34);
        sparseIntArray.put(2131362834, 35);
        sparseIntArray.put(2131362667, 36);
        sparseIntArray.put(2131362669, 37);
        sparseIntArray.put(2131362668, 38);
    }

    public re(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = V;
        SparseIntArray sparseIntArray = W;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 39, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private re(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[33];
        object2 = (FrameLayout)object;
        Object object3 = object = objectArray[36];
        object3 = (ImageView)object;
        Object object4 = object = objectArray[38];
        object4 = (ImageView)object;
        Object object5 = object = objectArray[37];
        object5 = (ImageView)object;
        int n10 = 1;
        Object object6 = object = objectArray[n10];
        object6 = (ImageView)object;
        int n11 = 2;
        Object object7 = object = objectArray[n11];
        object7 = (ImageView)object;
        Object object8 = object = objectArray[35];
        object8 = (LinearLayout)object;
        Object object9 = object = objectArray[32];
        object9 = (StatusView)((Object)object);
        Object object10 = object = objectArray[34];
        object10 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 0, (FrameLayout)object2, (ImageView)object3, (ImageView)object4, (ImageView)object5, (ImageView)object6, (ImageView)object7, (LinearLayout)object8, (StatusView)((Object)object9), (TextView)object10);
        this.U = -1;
        this.e.setTag(null);
        this.f.setTag(null);
        object = (FrameLayout)objectArray[0];
        this.n = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[10];
        this.o = object;
        object.setTag(null);
        object = (TextView)objectArray[11];
        this.p = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[12];
        this.q = object;
        object.setTag(null);
        object = (TextView)objectArray[13];
        this.r = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[14];
        this.s = object;
        object.setTag(null);
        object = (TextView)objectArray[15];
        this.t = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[16];
        this.u = object;
        object.setTag(null);
        object = (TextView)objectArray[17];
        this.v = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[18];
        this.w = object;
        object.setTag(null);
        object = (TextView)objectArray[19];
        this.x = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[20];
        this.y = object;
        object.setTag(null);
        object = (TextView)objectArray[21];
        this.z = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[22];
        this.A = object;
        object.setTag(null);
        object = (TextView)objectArray[23];
        this.B = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[24];
        this.C = object;
        object.setTag(null);
        object = (TextView)objectArray[25];
        this.D = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[26];
        this.E = object;
        object.setTag(null);
        object = (TextView)objectArray[27];
        this.F = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[28];
        this.G = object;
        object.setTag(null);
        object = (TextView)objectArray[29];
        this.H = object;
        object.setTag(null);
        object = (TextView)objectArray[3];
        this.I = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[30];
        this.J = object;
        object.setTag(null);
        object = (TextView)objectArray[31];
        this.K = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[4];
        this.L = object;
        object.setTag(null);
        object = (TextView)objectArray[5];
        this.M = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[6];
        this.N = object;
        object.setTag(null);
        object = (TextView)objectArray[7];
        this.O = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[8];
        this.P = object;
        object.setTag(null);
        object = (TextView)objectArray[9];
        this.Q = object;
        object.setTag(null);
        this.h.setTag(null);
        object = view;
        this.setRootTag(view);
        this.R = object = new f(this, n11);
        object = new b(this, n10);
        this.S = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(FeedbackDetailFragment$b feedbackDetailFragment$b) {
        this.j = feedbackDetailFragment$b;
        synchronized (this) {
            long l10 = this.U;
            long l11 = 1L;
            this.U = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(FeedbackSet$DealStatus feedbackSet$DealStatus) {
        this.l = feedbackSet$DealStatus;
        synchronized (this) {
            long l10 = this.U;
            long l11 = 8;
            this.U = l10 |= l11;
        }
        this.notifyPropertyChanged(34);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(Feedback feedback) {
        this.k = feedback;
        synchronized (this) {
            long l10 = this.U;
            long l11 = 2;
            this.U = l10 |= l11;
        }
        this.notifyPropertyChanged(57);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(PagingRequestHelper$Status pagingRequestHelper$Status) {
        this.m = pagingRequestHelper$Status;
        synchronized (this) {
            long l10 = this.U;
            long l11 = 4;
            this.U = l10 |= l11;
        }
        this.notifyPropertyChanged(97);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        FeedbackDetailFragment$b feedbackDetailFragment$b = this.j;
        boolean bl2 = feedbackDetailFragment$b != null;
        if (bl2) {
            feedbackDetailFragment$b.b(view);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block194: {
            block193: {
                block192: {
                    block184: {
                        block191: {
                            var1_1 = this;
                            synchronized (this) {
                                var2_2 = this.U;
                                this.U = var4_3 = 0L;
                            }
                            var6_4 /* !! */  = this.j;
                            var7_5 = this.k;
                            var8_6 = this.m;
                            var9_7 /* !! */  = this.l;
                            var10_8 = 17;
                            var12_9 = var2_2 & var10_8;
                            var14_10 = var12_9 == var4_3 ? 0 : (var12_9 < var4_3 ? -1 : 1);
                            if (var14_10 != false && var6_4 /* !! */  != null) {
                                var15_11 = this.T;
                                if (var15_11 == null) {
                                    var15_11 = new re$a();
                                    this.T = var15_11;
                                }
                                var6_4 /* !! */  = var15_11.b((FeedbackDetailFragment$b)var6_4 /* !! */ );
                            } else {
                                var16_12 = 0;
                                var6_4 /* !! */  = null;
                            }
                            var17_13 = 18;
                            cfr_temp_0 = (var2_2 & var17_13) - var4_3;
                            var14_10 = cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
                            var19_14 = 0x800000000L;
                            var21_15 = 2048L;
                            var23_16 = 0x2000000000L;
                            var25_17 = 0x8000000000000L;
                            var27_18 = 0x1000000000L;
                            var29_19 = 4096L;
                            var31_20 = 16384L;
                            var33_21 = 8;
                            var34_22 = 1.1E-44f;
                            var35_23 = 1;
                            var36_24 = 1.4E-45f;
                            if (var14_10 != false) {
                                if (var7_5 != null) {
                                    var37_25 = var7_5.getFirmwareVersion();
                                    var38_26 = var7_5.getMobileModel();
                                    var39_27 = var7_5.getPlatform();
                                    var40_28 = var7_5.getContact();
                                    var41_29 = var7_5.getContent();
                                    var42_30 = var7_5.getAppVersion();
                                    var43_31 = var7_5.getType();
                                    var44_32 = var7_5.getFrequency();
                                    var45_33 = var7_5.getUser_lang();
                                    var46_34 = var7_5.getExtras();
                                    var47_35 = var7_5.getTitle();
                                    var48_36 = var7_5.getDeviceModel();
                                    var49_37 = var7_5.getMobileOSVersion();
                                    var50_38 = var7_5.getCreateAt();
                                } else {
                                    var44_32 = 0;
                                    var51_39 = null;
                                    var52_40 = 0.0f;
                                    var37_25 = null;
                                    var38_26 = null;
                                    var39_27 = null;
                                    var40_28 = null;
                                    var41_29 = null;
                                    var42_30 = null;
                                    var43_31 = null;
                                    var53_41 = 0;
                                    var54_42 = 0.0f;
                                    var45_33 = null;
                                    var46_34 = null;
                                    var47_35 = null;
                                    var48_36 = null;
                                    var55_43 = 0;
                                    var49_37 = null;
                                    var56_44 = 0;
                                    var57_45 = 0.0f;
                                    var50_38 = null;
                                }
                                var58_46 /* !! */  = FeedbackSet$Type.from(var43_31);
                                var59_47 = String.valueOf(var44_32);
                                var51_39 = FeedbackSet$Lang.from(var45_33);
                                var60_48 = var46_34 == null ? var35_23 : 0;
                                var61_49 = Times.getTimeZoneDesSecond(var50_38);
                                if (var14_10 != false) {
                                    if (var60_48 != 0) {
                                        var62_50 = 0x10000000000000L;
                                        var2_2 |= var62_50;
                                    } else {
                                        var2_2 |= var25_17;
                                    }
                                }
                                if (var38_26 != null) {
                                    var15_11 = var38_26.trim();
                                } else {
                                    var14_10 = 0;
                                    var15_11 = null;
                                }
                                if (var39_27 != null) {
                                    var64_51 = var39_27.trim();
                                } else {
                                    var65_52 = 0;
                                    var66_53 = 0.0f;
                                    var64_51 = null;
                                }
                                if (var40_28 != null) {
                                    var67_54 = var40_28.trim();
                                } else {
                                    var68_55 = 0;
                                    var69_56 = 0.0f;
                                    var67_54 = null;
                                }
                                if (var41_29 != null) {
                                    var70_57 = var41_29.trim();
                                } else {
                                    var71_58 = 0;
                                    var72_59 = 0.0f;
                                    var70_57 = null;
                                }
                                if (var42_30 != null) {
                                    var73_60 = var42_30.trim();
                                } else {
                                    var74_61 = 0;
                                    var75_62 = 0.0f;
                                    var73_60 = null;
                                }
                                if (var45_33 != null) {
                                    var45_33 = var45_33.trim();
                                } else {
                                    var53_41 = 0;
                                    var54_42 = 0.0f;
                                    var45_33 = null;
                                }
                                if (var47_35 != null) {
                                    var76_63 = var47_35.trim();
                                } else {
                                    var77_64 = 0;
                                    var78_65 = 0.0f;
                                    var76_63 = null;
                                }
                                if (var49_37 != null) {
                                    var79_66 = var49_37.trim();
                                } else {
                                    var80_67 = false;
                                    var79_66 = null;
                                }
                                if (var50_38 != null) {
                                    var50_38 = var50_38.trim();
                                } else {
                                    var56_44 = 0;
                                    var57_45 = 0.0f;
                                    var50_38 = null;
                                }
                                var81_68 /* !! */  = FeedbackSet$Type.FIRMWARE;
                                if (var81_68 /* !! */  == var58_46 /* !! */ ) {
                                    var82_69 = var35_23;
                                    var83_70 = var36_24;
                                } else {
                                    var82_69 = 0;
                                    var81_68 /* !! */  = null;
                                    var83_70 = 0.0f;
                                }
                                var84_71 = var58_46 /* !! */  == null ? var35_23 : 0;
                                var85_72 = var58_46 /* !! */  != null ? var35_23 : 0;
                                var59_47 = FeedbackSet$Rate.from((String)var59_47);
                                var14_10 = (long)TextUtils.isEmpty((CharSequence)var15_11);
                                var65_52 = TextUtils.isEmpty((CharSequence)var64_51);
                                var68_55 = TextUtils.isEmpty((CharSequence)var67_54);
                                var71_58 = TextUtils.isEmpty((CharSequence)var70_57);
                                var74_61 = TextUtils.isEmpty((CharSequence)var73_60);
                                var53_41 = TextUtils.isEmpty((CharSequence)var45_33);
                                var77_64 = TextUtils.isEmpty((CharSequence)var76_63);
                                var80_67 = TextUtils.isEmpty((CharSequence)var79_66);
                                var56_44 = TextUtils.isEmpty((CharSequence)var50_38);
                                var86_73 = var2_2 & var17_13;
                                var88_74 = var86_73 == var4_3 ? 0 : (var86_73 < var4_3 ? -1 : 1);
                                if (var88_74 != false) {
                                    var2_2 = var82_69 != 0 ? var2_2 | var29_19 | var27_18 : var2_2 | var21_15 | var19_14;
                                }
                                if ((var88_74 = (cfr_temp_1 = (var86_73 = var2_2 & var17_13) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
                                    if (var84_71 != 0) {
                                        var2_2 |= 65536L;
                                        var86_73 = 0x4000000000L;
                                        var2_2 |= var86_73;
                                    } else {
                                        var86_73 = 32768L;
                                        var2_2 = var2_2 | var86_73 | var23_16;
                                    }
                                }
                                if ((var88_74 = (cfr_temp_2 = (var86_73 = var2_2 & var17_13) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
                                    if (var85_72 != 0) {
                                        var2_2 |= var31_20;
                                    } else {
                                        var86_73 = 8192L;
                                        var2_2 |= var86_73;
                                    }
                                }
                                if ((var88_74 = (cfr_temp_3 = (var86_73 = var2_2 & var17_13) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
                                    var86_73 = var14_10 != false ? 262144L : 131072L;
                                    var2_2 |= var86_73;
                                }
                                if ((var88_74 = (cfr_temp_4 = (var86_73 = var2_2 & var17_13) - var4_3) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != false) {
                                    var86_73 = var65_52 != 0 ? 256L : 128L;
                                    var2_2 |= var86_73;
                                }
                                if ((var88_74 = (cfr_temp_5 = (var86_73 = var2_2 & var17_13) - var4_3) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1)) != false) {
                                    var86_73 = var68_55 != 0 ? 1024L : 512L;
                                    var2_2 |= var86_73;
                                }
                                if ((var88_74 = (cfr_temp_6 = (var86_73 = var2_2 & var17_13) - var4_3) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1)) != false) {
                                    var86_73 = var71_58 != 0 ? 0x4000000000000L : 0x2000000000000L;
                                    var2_2 |= var86_73;
                                }
                                if ((var88_74 = (cfr_temp_7 = (var86_73 = var2_2 & var17_13) - var4_3) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1)) != false) {
                                    var86_73 = var74_61 != 0 ? 0x100000000000000L : 0x80000000000000L;
                                    var2_2 |= var86_73;
                                }
                                if ((var88_74 = (cfr_temp_8 = (var86_73 = var2_2 & var17_13) - var4_3) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1)) != false) {
                                    var86_73 = var53_41 != 0 ? 0x100000000000L : 0x80000000000L;
                                    var2_2 |= var86_73;
                                }
                                if ((var88_74 = (cfr_temp_9 = (var86_73 = var2_2 & var17_13) - var4_3) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1)) != false) {
                                    var86_73 = var77_64 != 0 ? 0x400000000L : 0x200000000L;
                                    var2_2 |= var86_73;
                                }
                                if ((var88_74 = (cfr_temp_10 = (var86_73 = var2_2 & var17_13) - var4_3) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1)) != false) {
                                    var86_73 = var80_67 != false ? 0x10000000000L : 0x8000000000L;
                                    var2_2 |= var86_73;
                                }
                                if ((var88_74 = (cfr_temp_11 = (var86_73 = var2_2 & var17_13) - var4_3) == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1)) != false) {
                                    var86_73 = var56_44 != 0 ? 0x1000000L : 0x800000L;
                                    var2_2 |= var86_73;
                                }
                                if (var51_39 != null) {
                                    var89_75 = var44_32 = var51_39.getStringRes();
                                } else {
                                    var89_75 = 0;
                                    var90_77 = null;
                                }
                                if (var84_71 != 0) {
                                    var91_78 /* !! */  = var33_21;
                                } else {
                                    var91_78 /* !! */  = 0;
                                    var92_79 = null;
                                }
                                if (var14_10 != false) {
                                    var14_10 = var33_21;
                                } else {
                                    var14_10 = 0;
                                    var15_11 = null;
                                }
                                if (var65_52 != 0) {
                                    var44_32 = var33_21;
                                    var52_40 = var34_22;
                                } else {
                                    var44_32 = 0;
                                    var51_39 = null;
                                    var52_40 = 0.0f;
                                }
                                if (var68_55 != 0) {
                                    var65_52 = var33_21;
                                    var66_53 = var34_22;
                                } else {
                                    var65_52 = 0;
                                    var64_51 = null;
                                    var66_53 = 0.0f;
                                }
                                if (var71_58 != 0) {
                                    var68_55 = var33_21;
                                    var69_56 = var34_22;
                                } else {
                                    var68_55 = 0;
                                    var67_54 = null;
                                    var69_56 = 0.0f;
                                }
                                if (var74_61 != 0) {
                                    var71_58 = var33_21;
                                    var72_59 = var34_22;
                                } else {
                                    var71_58 = 0;
                                    var70_57 = null;
                                    var72_59 = 0.0f;
                                }
                                if (var53_41 != 0) {
                                    var53_41 = var33_21;
                                    var54_42 = var34_22;
                                } else {
                                    var53_41 = 0;
                                    var45_33 = null;
                                    var54_42 = 0.0f;
                                }
                                if (var77_64 != 0) {
                                    var74_61 = var33_21;
                                    var75_62 = var34_22;
                                } else {
                                    var74_61 = 0;
                                    var73_60 = null;
                                    var75_62 = 0.0f;
                                }
                                if (var80_67) {
                                    var77_64 = var33_21;
                                    var78_65 = var34_22;
                                } else {
                                    var77_64 = 0;
                                    var76_63 = null;
                                    var78_65 = 0.0f;
                                }
                                if (var56_44 != 0) {
                                    var56_44 = var33_21;
                                    var57_45 = var34_22;
                                } else {
                                    var56_44 = 0;
                                    var50_38 = null;
                                    var57_45 = 0.0f;
                                }
                                var79_66 = this.getRoot();
                                var93_80 = d.v.f.i.g.m(var79_66.getContext(), var89_75);
                                if (var59_47 != null) {
                                    var94_81 = var59_47.getStringRes();
                                } else {
                                    var94_81 = 0;
                                    var59_47 = null;
                                }
                                var95_83 = this.getRoot().getContext();
                                var59_47 = d.v.f.i.g.m(var95_83, var94_81);
                                var96_85 = var91_78 /* !! */ ;
                                var90_77 = var37_25;
                                var97_86 = var38_26;
                                var98_87 = var39_27;
                                var99_88 = var40_28;
                                var100_89 = var41_29;
                                var101_90 = var42_30;
                                var102_91 = var44_32;
                                var103_92 = var53_41;
                                var104_93 = var47_35;
                                var105_94 = var48_36;
                                var106_95 = var49_37;
                                var107_96 = var56_44;
                                var108_97 = var57_45;
                                var109_98 = var61_49;
                                var110_99 = var65_52;
                                var111_100 = var66_53;
                                var112_101 = var68_55;
                                var113_102 = var71_58;
                                var114_103 = var74_61;
                                var115_104 = var77_64;
                            } else {
                                var14_10 = 0;
                                var15_11 = null;
                                var82_69 = 0;
                                var81_68 /* !! */  = null;
                                var83_70 = 0.0f;
                                var96_85 = 0;
                                var95_84 = null;
                                var60_48 = 0;
                                var84_71 = 0;
                                var85_72 = 0;
                                var102_91 = 0;
                                var103_92 = 0;
                                var107_96 = 0;
                                var108_97 = 0.0f;
                                var110_99 = 0;
                                var111_100 = 0.0f;
                                var112_101 = 0;
                                var113_102 = 0;
                                var114_103 = 0;
                                var115_104 = 0;
                                var116_105 = 0;
                                var58_46 /* !! */  = null;
                                var94_82 = false;
                                var59_47 = null;
                                var93_80 = null;
                                var89_76 = false;
                                var90_77 = null;
                                var43_31 = null;
                                var46_34 = null;
                                var97_86 = null;
                                var98_87 = null;
                                var99_88 = null;
                                var100_89 = null;
                                var101_90 = null;
                                var104_93 = null;
                                var105_94 = null;
                                var106_95 = null;
                                var109_98 = null;
                            }
                            var117_106 = 30;
                            cfr_temp_12 = (var2_2 & var117_106) - var4_3;
                            var91_78 /* !! */  = cfr_temp_12 == 0L ? 0 : (cfr_temp_12 < 0L ? -1 : 1);
                            var119_107 = 0x20000000000L;
                            var121_108 = 0x8000000L;
                            var123_109 = 0x20000000L;
                            var125_110 = 24;
                            if (var91_78 /* !! */  == false) break block191;
                            var127_111 = var2_2 & var125_110;
                            cfr_temp_13 = var127_111 - var4_3;
                            var91_78 /* !! */  = (long)(cfr_temp_13 == 0L ? 0 : (cfr_temp_13 < 0L ? -1 : 1));
                            if (var91_78 /* !! */  != false) {
                                if (var9_7 /* !! */  == null) {
                                    var55_43 = var35_23;
                                } else {
                                    var55_43 = 0;
                                    var49_37 = null;
                                }
                                if (var91_78 /* !! */  != false) {
                                    if (var55_43 != 0) {
                                        var2_2 |= 0x10000000L;
                                        var129_112 = 0x40000000000L;
                                        var2_2 |= var129_112;
                                    } else {
                                        var2_2 = var2_2 | var121_108 | var119_107;
                                    }
                                }
                            } else {
                                var55_43 = 0;
                                var49_37 = null;
                            }
                            if ((var131_113 /* !! */  = FeedbackSet$DealStatus.TO_BE) == var9_7 /* !! */ ) {
                                var132_114 = var35_23;
                                var133_115 = var36_24;
                            } else {
                                var132_114 = 0;
                                var131_113 /* !! */  = null;
                                var133_115 = 0.0f;
                            }
                            var134_116 = var2_2 & var117_106;
                            var129_112 = 0L;
                            var136_117 = var134_116 == var129_112 ? 0 : (var134_116 < var129_112 ? -1 : 1);
                            if (var136_117 != false) {
                                if (var132_114 != 0) {
                                    var134_116 = 0x40000000L;
                                    var2_2 |= var134_116;
                                    break block184;
                                } else {
                                    var2_2 |= var123_109;
                                }
                            }
                            break block184;
                        }
                        var129_112 = var4_3;
                        var132_114 = 0;
                        var131_113 /* !! */  = null;
                        var133_115 = 0.0f;
                        var55_43 = 0;
                        var49_37 = null;
                    }
                    if ((var136_117 = (cfr_temp_14 = (var121_108 = var2_2 & var121_108) - var129_112) == 0L ? 0 : (cfr_temp_14 < 0L ? -1 : 1)) != false) {
                        if (var9_7 /* !! */  != null) {
                            var137_118 /* !! */  = var9_7 /* !! */ .getColorStr();
                        } else {
                            var136_117 = 0;
                            var137_118 /* !! */  = null;
                        }
                        var136_117 = Color.parseColor((String)var137_118 /* !! */ );
                    } else {
                        var136_117 = 0;
                        var137_118 /* !! */  = null;
                    }
                    var25_17 = var2_2 & var25_17;
                    var91_78 /* !! */  = var25_17 == var129_112 ? 0 : (var25_17 < var129_112 ? -1 : 1);
                    if (var91_78 /* !! */  == false) ** GOTO lbl-1000
                    if (var46_34 != null) {
                        var91_78 /* !! */  = var46_34.size();
                    } else {
                        var91_78 /* !! */  = 0;
                        var92_79 = null;
                    }
                    if (var91_78 /* !! */  <= 0) {
                        var91_78 /* !! */  = var35_23;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var91_78 /* !! */  = 0;
                        var92_79 = null;
                    }
                    var25_17 = var2_2 & var123_109;
                    cfr_temp_15 = var25_17 - 0L;
                    var138_119 = cfr_temp_15 == 0L ? 0 : (cfr_temp_15 < 0L ? -1 : 1);
                    var121_108 = 0x100000000L;
                    var139_120 = var136_117;
                    if (var138_119 != false) {
                        var137_118 /* !! */  = FeedbackSet$DealStatus.CLOSE;
                        if (var137_118 /* !! */  == var9_7 /* !! */ ) {
                            var136_117 = var35_23;
                        } else {
                            var136_117 = 0;
                            var137_118 /* !! */  = null;
                        }
                        if (var138_119 != false) {
                            if (var136_117 != false) {
                                var2_2 |= var121_108;
                            } else {
                                var134_116 = 0x80000000L;
                                var2_2 |= var134_116;
                            }
                        }
                    } else {
                        var136_117 = 0;
                        var137_118 /* !! */  = null;
                    }
                    var134_116 = var2_2 & 0x2000004000L;
                    var129_112 = 0L;
                    var138_119 = var134_116 == var129_112 ? 0 : (var134_116 < var129_112 ? -1 : 1);
                    var134_116 = 0x800000000000L;
                    if (var138_119 != false) {
                        if (var7_5 != null) {
                            var43_31 = var7_5.getType();
                        }
                        var58_46 /* !! */  = FeedbackSet$Type.from(var43_31);
                        cfr_temp_16 = (var23_16 = var2_2 & var23_16) - var129_112;
                        var140_121 = (int)(cfr_temp_16 == 0L ? 0 : (cfr_temp_16 < 0L ? -1 : 1));
                        if (var140_121 != 0) {
                            if (var58_46 /* !! */  != null) {
                                var141_122 = var58_46 /* !! */ .getStringRes();
                                var140_121 = var82_69;
                                var142_123 = var83_70;
                                var82_69 = var141_122;
                            } else {
                                var140_121 = var82_69;
                                var142_124 = var83_70;
                                var82_69 = 0;
                                var81_68 /* !! */  = null;
                                var83_70 = 0.0f;
                            }
                            var143_127 /* !! */  = this.getRoot();
                            var144_128 = var6_4 /* !! */ ;
                            var6_4 /* !! */  = d.v.f.i.g.m(var143_127 /* !! */ .getContext(), var82_69);
                        } else {
                            var144_128 = var6_4 /* !! */ ;
                            var140_121 = var82_69;
                            var142_125 = var83_70;
                            var16_12 = 0;
                            var6_4 /* !! */  = null;
                        }
                        var145_129 = var2_2 & var31_20;
                        var129_112 = 0L;
                        var82_69 = (int)(var145_129 == var129_112 ? 0 : (var145_129 < var129_112 ? -1 : 1));
                        var143_127 /* !! */  = var6_4 /* !! */ ;
                        if (var82_69 != 0) {
                            var6_4 /* !! */  = FeedbackSet$Type.SOFTWARE;
                            if (var6_4 /* !! */  == var58_46 /* !! */ ) {
                                var16_12 = var35_23;
                            } else {
                                var16_12 = 0;
                                var6_4 /* !! */  = null;
                            }
                            if (var82_69 != 0) {
                                if (var16_12 != 0) {
                                    var145_129 = 0x1000000000000L;
                                    var2_2 |= var145_129;
                                } else {
                                    var2_2 |= var134_116;
                                }
                            }
                            var145_129 = var2_2;
                            var147_130 = var16_12;
                            var6_4 /* !! */  = var143_127 /* !! */ ;
                        } else {
                            var145_129 = var2_2;
                            var147_130 = 0;
                            var148_131 = null;
                        }
                    } else {
                        var144_128 = var6_4 /* !! */ ;
                        var140_121 = var82_69;
                        var142_126 = var83_70;
                        var145_129 = var2_2;
                        var147_130 = 0;
                        var148_131 = null;
                        var16_12 = 0;
                        var6_4 /* !! */  = null;
                    }
                    var119_107 = var145_129 & var119_107;
                    var129_112 = 0L;
                    var149_132 = var119_107 == var129_112 ? 0 : (var119_107 < var129_112 ? -1 : 1);
                    if (var149_132 != false) {
                        if (var9_7 /* !! */  != null) {
                            var149_132 = var9_7 /* !! */ .getStringRes();
                        } else {
                            var149_132 = 0;
                            var150_133 /* !! */  = null;
                        }
                        var9_7 /* !! */  = this.getRoot().getContext();
                        var150_133 /* !! */  = d.v.f.i.g.m((Context)var9_7 /* !! */ , (int)var149_132);
                    } else {
                        var149_132 = 0;
                        var150_133 /* !! */  = null;
                    }
                    var119_107 = var145_129 & var125_110;
                    var129_112 = 0L;
                    var151_134 = var119_107 == var129_112 ? 0 : (var119_107 < var129_112 ? -1 : 1);
                    if (var151_134 != false) {
                        if (var55_43 != 0) {
                            var139_120 = 0;
                        }
                        if (var55_43 != 0) {
                            var150_133 /* !! */  = "@string/share_default";
                        }
                        var151_134 = var139_120;
                    } else {
                        var151_134 = 0;
                        var9_7 /* !! */  = null;
                        var149_132 = 0;
                        var150_133 /* !! */  = null;
                    }
                    var127_111 = var145_129 & (long)18;
                    var119_107 = 0L;
                    var82_69 = (int)(var127_111 == var119_107 ? 0 : (var127_111 < var119_107 ? -1 : 1));
                    if (var82_69 != 0) {
                        if (var84_71 != 0) {
                            var6_4 /* !! */  = "@string/share_default";
                        }
                        if (var60_48 != 0) {
                            var91_78 /* !! */  = var35_23;
                        }
                        if (var82_69 != 0) {
                            var119_107 = var91_78 /* !! */  != false ? 0x4000000L : 0x2000000L;
                            var145_129 |= var119_107;
                        }
                        if (var91_78 /* !! */  != false) {
                            var82_69 = var33_21;
                            var83_70 = var34_22;
                        } else {
                            var82_69 = 0;
                            var81_68 /* !! */  = null;
                            var83_70 = 0.0f;
                        }
                    } else {
                        var82_69 = 0;
                        var81_68 /* !! */  = null;
                        var83_70 = 0.0f;
                        var16_12 = 0;
                        var6_4 /* !! */  = null;
                    }
                    var119_107 = var145_129 & var134_116;
                    var127_111 = 0L;
                    var91_78 /* !! */  = var119_107 == var127_111 ? 0 : (var119_107 < var127_111 ? -1 : 1);
                    if (var91_78 /* !! */  != false) {
                        var92_79 = var150_133 /* !! */ ;
                        var150_133 /* !! */  = FeedbackSet$Type.FIRMWARE;
                        if (var150_133 /* !! */  == var58_46 /* !! */ ) {
                            var149_132 = var35_23;
                        } else {
                            var149_132 = 0;
                            var150_133 /* !! */  = null;
                        }
                        var23_16 = 18;
                        var119_107 = var145_129 & var23_16;
                        var116_105 = var119_107 == var127_111 ? 0 : (var119_107 < var127_111 ? -1 : 1);
                        if (var116_105 != 0) {
                            if (var149_132 != false) {
                                var21_15 = var145_129 | var29_19;
                                var145_129 = var21_15 | var27_18;
                            } else {
                                var21_15 = var145_129 | var21_15;
                                var23_16 = 0x800000000L;
                                var145_129 = var21_15 | var23_16;
                            }
                        }
                    } else {
                        var92_79 = var150_133 /* !! */ ;
                        var149_132 = var140_121;
                    }
                    if ((var116_105 = (cfr_temp_17 = (var21_15 = var145_129 & var121_108) - (var23_16 = 0L)) == 0L ? 0 : (cfr_temp_17 < 0L ? -1 : 1)) != 0) {
                        if (var7_5 != null) {
                            var152_135 = var7_5.isCanActive();
                        } else {
                            var152_135 = 0;
                            var7_5 = null;
                        }
                        var152_135 ^= 1;
                    } else {
                        var152_135 = 0;
                        var7_5 = null;
                    }
                    var21_15 = var145_129 & var123_109;
                    var23_16 = 0L;
                    var116_105 = var21_15 == var23_16 ? 0 : (var21_15 < var23_16 ? -1 : 1);
                    if (var116_105 == 0 || var136_117 == false) {
                        var152_135 = 0;
                        var7_5 = null;
                    }
                    var21_15 = var145_129 & var31_20;
                    var136_117 = var21_15 == var23_16 ? 0 : (var21_15 < var23_16 ? -1 : 1);
                    if (var136_117 != false) {
                        var147_130 = var147_130 != 0 ? var35_23 : (int)var149_132;
                    } else {
                        var147_130 = 0;
                        var148_131 = null;
                    }
                    var21_15 = 18;
                    var31_20 = var145_129 & var21_15;
                    var136_117 = var31_20 == var23_16 ? 0 : (var31_20 < var23_16 ? -1 : 1);
                    if (var136_117 == false) ** GOTO lbl-1000
                    if (var85_72 == 0) {
                        var147_130 = 0;
                        var148_131 = null;
                    }
                    if (var136_117 != false) {
                        var21_15 = var147_130 != 0 ? 0x100000L : 524288L;
                        var145_129 |= var21_15;
                    }
                    if (var147_130 == 0) {
                        var147_130 = var33_21;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var147_130 = 0;
                        var148_131 = null;
                    }
                    var21_15 = var145_129 & var117_106;
                    var23_16 = 0L;
                    var136_117 = var21_15 == var23_16 ? 0 : (var21_15 < var23_16 ? -1 : 1);
                    var21_15 = 0x20000000000000L;
                    if (var136_117 != false) {
                        if (var132_114 != 0) {
                            var152_135 = var35_23;
                        }
                        if (var136_117 != false) {
                            if (var152_135 != 0) {
                                var4_3 = 0x40000000000000L;
                                var145_129 |= var4_3;
                            } else {
                                var145_129 |= var21_15;
                            }
                        }
                    } else {
                        var152_135 = 0;
                        var7_5 = null;
                    }
                    if ((var132_114 = (int)((cfr_temp_18 = (var4_3 = var145_129 & var29_19) - (var23_16 = 0L)) == 0L ? 0 : (cfr_temp_18 < 0L ? -1 : 1))) != 0) {
                        if (var90_77 != null) {
                            var131_113 /* !! */  = var90_77.trim();
                        } else {
                            var132_114 = 0;
                            var133_115 = 0.0f;
                            var131_113 /* !! */  = null;
                        }
                        var132_114 = TextUtils.isEmpty((CharSequence)var131_113 /* !! */ ) ^ 1;
                    } else {
                        var132_114 = 0;
                        var131_113 /* !! */  = null;
                        var133_115 = 0.0f;
                    }
                    var23_16 = var145_129 & var27_18;
                    var153_136 = 0L;
                    var136_117 = var23_16 == var153_136 ? 0 : (var23_16 < var153_136 ? -1 : 1);
                    if (var136_117 != false) {
                        var137_118 /* !! */  = var105_94;
                        if (var105_94 != null) {
                            var58_46 /* !! */  = var105_94.trim();
                        } else {
                            var116_105 = 0;
                            var58_46 /* !! */  = null;
                        }
                        var116_105 = TextUtils.isEmpty((CharSequence)var58_46 /* !! */ ) ^ 1;
                    } else {
                        var137_118 /* !! */  = var105_94;
                        var116_105 = 0;
                        var58_46 /* !! */  = null;
                    }
                    var21_15 = var145_129 & var21_15;
                    var23_16 = 0L;
                    var155_137 = var21_15 == var23_16 ? 0 : (var21_15 < var23_16 ? -1 : 1);
                    if (var155_137 == false) break block192;
                    var155_137 = var132_114;
                    var131_113 /* !! */  = PagingRequestHelper$Status.SUCCESS;
                    if (var131_113 /* !! */  == var8_6) break block193;
                    var132_114 = var35_23;
                    var133_115 = var36_24;
                    break block194;
                }
                var155_137 = var132_114;
            }
            var132_114 = 0;
            var131_113 /* !! */  = null;
            var133_115 = 0.0f;
        }
        var153_136 = 18;
        var156_138 = var145_129 & var153_136;
        var158_139 = var156_138 == var23_16 ? 0 : (var156_138 < var23_16 ? -1 : 1);
        if (var158_139 != false) {
            if (var149_132 == false) {
                var155_137 = 0;
            }
            if (var149_132 == false) {
                var116_105 = 0;
                var58_46 /* !! */  = null;
            }
            if (var158_139 != false) {
                var159_140 = var155_137 != false ? 0x400000L : 0x200000L;
                var145_129 |= var159_140;
            }
            if ((var149_132 = (cfr_temp_19 = (var153_136 = var145_129 & (long)18) - (var159_140 = 0L)) == 0L ? 0 : (cfr_temp_19 < 0L ? -1 : 1)) != false) {
                var159_140 = var116_105 != 0 ? 0x400000000000L : 0x200000000000L;
                var145_129 = var159_140 = var145_129 | var159_140;
            }
            if (var155_137 != false) {
                var149_132 = 0;
                var150_133 /* !! */  = null;
            } else {
                var149_132 = var33_21;
            }
            if (var116_105 != 0) {
                var158_139 = 0;
                var8_6 = null;
            } else {
                var158_139 = var33_21;
            }
        } else {
            var149_132 = 0;
            var150_133 /* !! */  = null;
            var158_139 = 0;
            var8_6 = null;
        }
        var21_15 = var145_129 & var117_106;
        var23_16 = 0L;
        var116_105 = var21_15 == var23_16 ? 0 : (var21_15 < var23_16 ? -1 : 1);
        if (var116_105 != 0) {
            if (var152_135 == 0) {
                var35_23 = var132_114;
                var36_24 = var133_115;
            }
            if (var116_105 != 0) {
                var21_15 = var35_23 != 0 ? (long)64 : (long)32;
                var145_129 |= var21_15;
            }
            if (var35_23 == 0) {
                var33_21 = 0;
                var34_22 = 0.0f;
            }
            var132_114 = var33_21;
            var133_115 = var34_22;
        } else {
            var132_114 = 0;
            var131_113 /* !! */  = null;
            var133_115 = 0.0f;
        }
        var21_15 = var145_129 & (long)16;
        var23_16 = 0L;
        var152_135 = (int)(var21_15 == var23_16 ? 0 : (var21_15 < var23_16 ? -1 : 1));
        if (var152_135 != 0) {
            var7_5 = var1_1.e;
            var58_46 /* !! */  = var1_1.S;
            var7_5.setOnClickListener((View.OnClickListener)var58_46 /* !! */ );
            var7_5 = var1_1.f;
            var58_46 /* !! */  = var1_1.R;
            d.v.f.e.c.f((View)var7_5, (d)var58_46 /* !! */ );
            var7_5 = var1_1.h;
            var116_105 = ViewDataBinding.getColorFromResource((View)var7_5, 2131099772);
            var7_5.setBackgroundColor(var116_105);
            var7_5 = var1_1.h;
            var58_46 /* !! */  = var7_5.getContext();
            var155_137 = var151_134;
            var151_134 = 2131231806;
            var9_7 /* !! */  = AppCompatResources.getDrawable((Context)var58_46 /* !! */ , (int)var151_134);
            var7_5.setErrorImage((Drawable)var9_7 /* !! */ );
            var7_5 = var1_1.h;
            var9_7 /* !! */  = "@string/request_error";
            var7_5.setErrorText((String)var9_7 /* !! */ );
        } else {
            var155_137 = var151_134;
        }
        var161_141 = var145_129 & var117_106;
        var159_140 = 0L;
        var152_135 = (int)(var161_141 == var159_140 ? 0 : (var161_141 < var159_140 ? -1 : 1));
        if (var152_135 != 0) {
            var7_5 = var1_1.f;
            var7_5.setVisibility(var132_114);
        }
        if ((var132_114 = (int)((cfr_temp_20 = (var161_141 = var145_129 & (long)18) - var159_140) == 0L ? 0 : (cfr_temp_20 < 0L ? -1 : 1))) != 0) {
            var131_113 /* !! */  = var1_1.o;
            var152_135 = var102_91;
            var131_113 /* !! */ .setVisibility(var102_91);
            var131_113 /* !! */  = var1_1.p;
            var7_5 = var98_87;
            var151_134 = 0;
            var9_7 /* !! */  = null;
            l.a.q.g0.u.n((TextView)var131_113 /* !! */ , var98_87, null, null);
            var1_1.q.setVisibility((int)var14_10);
            var131_113 /* !! */  = var1_1.r;
            var7_5 = var97_86;
            l.a.q.g0.u.n((TextView)var131_113 /* !! */ , var97_86, null, null);
            var131_113 /* !! */  = var1_1.s;
            var152_135 = var115_104;
            var131_113 /* !! */ .setVisibility(var115_104);
            var131_113 /* !! */  = var1_1.t;
            var7_5 = var106_95;
            l.a.q.g0.u.n((TextView)var131_113 /* !! */ , var106_95, null, null);
            var131_113 /* !! */  = var1_1.u;
            var152_135 = var113_102;
            var131_113 /* !! */ .setVisibility(var113_102);
            var131_113 /* !! */  = var1_1.v;
            var7_5 = var101_90;
            l.a.q.g0.u.n((TextView)var131_113 /* !! */ , var101_90, null, null);
            var131_113 /* !! */  = var1_1.w;
            var152_135 = var103_92;
            var131_113 /* !! */ .setVisibility(var103_92);
            l.a.q.g0.u.n(var1_1.x, var93_80, null, null);
            var131_113 /* !! */  = var1_1.y;
            var152_135 = var114_103;
            var131_113 /* !! */ .setVisibility(var114_103);
            var131_113 /* !! */  = var1_1.z;
            var7_5 = var104_93;
            l.a.q.g0.u.n((TextView)var131_113 /* !! */ , var104_93, null, null);
            var131_113 /* !! */  = var1_1.A;
            var152_135 = var112_101;
            var131_113 /* !! */ .setVisibility(var112_101);
            var131_113 /* !! */  = var1_1.B;
            var7_5 = var100_89;
            l.a.q.g0.u.n((TextView)var131_113 /* !! */ , var100_89, null, null);
            var1_1.C.setVisibility(var147_130);
            l.a.q.g0.u.n(var1_1.D, (String)var59_47, null, null);
            var148_131 = var1_1.E;
            var132_114 = var110_99;
            var133_115 = var111_100;
            var148_131.setVisibility(var110_99);
            var148_131 = var1_1.F;
            var131_113 /* !! */  = var99_88;
            l.a.q.g0.u.n((TextView)var148_131, var99_88, null, null);
            var148_131 = var1_1.G;
            var132_114 = var107_96;
            var133_115 = var108_97;
            var148_131.setVisibility(var107_96);
            var148_131 = var1_1.H;
            var131_113 /* !! */  = var109_98;
            l.a.q.g0.u.n((TextView)var148_131, var109_98, null, null);
            var1_1.J.setVisibility(var82_69);
            var1_1.L.setVisibility(var96_85);
            var148_131 = var1_1.M;
            l.a.q.g0.u.n((TextView)var148_131, (String)var6_4 /* !! */ , null, null);
            var1_1.N.setVisibility((int)var158_139);
            l.a.q.g0.u.n(var1_1.O, var137_118 /* !! */ , null, null);
            var1_1.P.setVisibility((int)var149_132);
            var6_4 /* !! */  = var1_1.Q;
            l.a.q.g0.u.n((TextView)var6_4 /* !! */ , var90_77, null, null);
        } else {
            var151_134 = 0;
            var9_7 /* !! */  = null;
        }
        var2_2 = var145_129 & var125_110;
        var4_3 = 0L;
        var16_12 = (int)(var2_2 == var4_3 ? 0 : (var2_2 < var4_3 ? -1 : 1));
        if (var16_12 != 0) {
            var6_4 /* !! */  = var1_1.I;
            var147_130 = (int)var155_137;
            var6_4 /* !! */ .setTextColor((int)var155_137);
            var6_4 /* !! */  = var1_1.I;
            var150_133 /* !! */  = var92_79;
            l.a.q.g0.u.n((TextView)var6_4 /* !! */ , var92_79, null, null);
        }
        if ((var16_12 = (int)((cfr_temp_21 = (var2_2 = var145_129 & (long)17) - var4_3) == 0L ? 0 : (cfr_temp_21 < 0L ? -1 : 1))) != 0) {
            var6_4 /* !! */  = var1_1.K;
            var81_68 /* !! */  = var144_128;
            var6_4 /* !! */ .setOnClickListener((View.OnClickListener)var144_128);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.U;
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
            this.U = l10 = (long)16;
        }
        this.requestRebind();
    }

    public final void m(int n10, View view) {
        FeedbackDetailFragment$b feedbackDetailFragment$b = this.j;
        Feedback feedback = this.k;
        FeedbackSet$DealStatus feedbackSet$DealStatus = this.l;
        boolean bl2 = feedbackDetailFragment$b != null;
        if (bl2) {
            feedbackDetailFragment$b.n(view, feedback, feedbackSet$DealStatus);
        }
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            FeedbackDetailFragment$b feedbackDetailFragment$b = (FeedbackDetailFragment$b)object;
            this.C(feedbackDetailFragment$b);
            return 1 != 0;
        } else {
            n11 = 57;
            if (n11 == n10) {
                Feedback feedback = (Feedback)object;
                this.E(feedback);
                return 1 != 0;
            } else {
                n11 = 97;
                if (n11 == n10) {
                    PagingRequestHelper$Status pagingRequestHelper$Status = (PagingRequestHelper$Status)((Object)object);
                    this.F(pagingRequestHelper$Status);
                    return 1 != 0;
                } else {
                    n11 = 34;
                    if (n11 != n10) return 0 != 0;
                    FeedbackSet$DealStatus feedbackSet$DealStatus = (FeedbackSet$DealStatus)((Object)object);
                    this.D(feedbackSet$DealStatus);
                }
            }
        }
        return 1 != 0;
    }
}

