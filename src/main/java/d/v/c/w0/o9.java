/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.story.review.StoryReviewViewModel;
import com.zhiyun.cama.camera.story.review.StoryReviewViewModel$ReviewStatus;
import com.zhiyun.cama.camera.widget.RetProgressBar;
import com.zhiyun.cama.camera.widget.StoryProgressBar;
import com.zhiyun.cama.camera.widget.StoryProgressBar$a;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import com.zhiyun.cama.widget.ZYTextView;
import com.zhiyun.editorsdk.fundation.PlayerWrapperView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.f1.a.n;
import d.v.c.f1.a.n$a;
import d.v.c.s0.a7.j1;
import d.v.c.s0.h7.s0.y$b;
import d.v.c.w0.ai;
import d.v.c.w0.n9;
import d.v.c.w0.p3;
import d.v.e.l.l2;
import d.v.f.e.c;
import l.a.q.g0.u;

public class o9
extends n9
implements b$a,
n$a {
    private static final ViewDataBinding$IncludedLayouts G;
    private static final SparseIntArray H;
    private final View.OnClickListener A;
    private final StoryProgressBar$a B;
    private final View.OnClickListener C;
    private final View.OnClickListener D;
    private final View.OnClickListener E;
    private long F;
    private final p3 z;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        G = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(22);
        String[] stringArray = new String[]{"story_review_setting"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 15;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558791;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        stringArray = new String[]{"dialog_fragment_remind"};
        nArray = new int[n10];
        nArray[0] = 14;
        int[] nArray3 = new int[n10];
        nArray3[0] = 2131558519;
        viewDataBinding$IncludedLayouts.setIncludes(5, stringArray, nArray, nArray3);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        H = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131362552, 16);
        viewDataBinding$IncludedLayouts.put(2131362550, 17);
        viewDataBinding$IncludedLayouts.put(2131362551, 18);
        viewDataBinding$IncludedLayouts.put(2131362995, 19);
        viewDataBinding$IncludedLayouts.put(2131363712, 20);
        viewDataBinding$IncludedLayouts.put(2131362996, 21);
    }

    public o9(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = G;
        SparseIntArray sparseIntArray = H;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 22, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private o9(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object = this;
        ConstraintLayout constraintLayout = (ConstraintLayout)((Object)objectArray[0]);
        FrameLayout frameLayout = (FrameLayout)objectArray[5];
        FrameLayout frameLayout2 = (FrameLayout)objectArray[3];
        FrameLayout frameLayout3 = (FrameLayout)objectArray[12];
        Group group = (Group)((Object)objectArray[1]);
        Group group2 = (Group)((Object)objectArray[2]);
        Guideline guideline = (Guideline)((Object)objectArray[17]);
        Guideline guideline2 = (Guideline)((Object)objectArray[18]);
        Guideline guideline3 = (Guideline)((Object)objectArray[16]);
        ImageView imageView = (ImageView)objectArray[6];
        ImageView imageView2 = (ImageView)objectArray[10];
        PlayerWrapperView playerWrapperView = (PlayerWrapperView)((Object)objectArray[19]);
        PlayerWrapperView playerWrapperView2 = (PlayerWrapperView)((Object)objectArray[21]);
        RetProgressBar retProgressBar = (RetProgressBar)((Object)objectArray[4]);
        ai ai2 = (ai)objectArray[15];
        StoryProgressBar storyProgressBar = (StoryProgressBar)objectArray[13];
        ZYTextView zYTextView = (ZYTextView)objectArray[11];
        TextView textView = (TextView)objectArray[9];
        TextView textView2 = (TextView)objectArray[8];
        TextView textView3 = (TextView)objectArray[7];
        View view2 = (View)objectArray[20];
        int n10 = 8;
        super(dataBindingComponent, view, n10, constraintLayout, frameLayout, frameLayout2, frameLayout3, group, group2, guideline, guideline2, guideline3, imageView, imageView2, playerWrapperView, playerWrapperView2, retProgressBar, ai2, storyProgressBar, zYTextView, textView, textView2, textView3, view2);
        this.F = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        object = (p3)objectArray[14];
        this.z = object;
        this.setContainedBinding((ViewDataBinding)object);
        this.n.setTag(null);
        object = this.o;
        this.setContainedBinding((ViewDataBinding)object);
        this.p.setTag(null);
        this.q.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.t.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, 4);
        this.A = object;
        this.B = object = new n(this, 5);
        object = new b(this, 1);
        this.C = object;
        object = new b(this, 2);
        this.D = object;
        object = new b(this, 3);
        this.E = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean G(ai ai2, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 64;
                this.F = l10 |= l11;
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
                long l10 = this.F;
                long l11 = 16;
                this.F = l10 |= l11;
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
                long l10 = this.F;
                long l11 = 1L;
                this.F = l10 |= l11;
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
    private boolean J(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 128L;
                this.F = l10 |= l11;
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
    private boolean K(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 4;
                this.F = l10 |= l11;
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
    private boolean L(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 8;
                this.F = l10 |= l11;
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
    private boolean M(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 2;
                this.F = l10 |= l11;
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
    private boolean N(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.F;
                long l11 = 32;
                this.F = l10 |= l11;
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
    public void C(y$b y$b) {
        this.v = y$b;
        synchronized (this) {
            long l10 = this.F;
            long l11 = 512L;
            this.F = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(j1 j12) {
        this.y = j12;
        synchronized (this) {
            long l10 = this.F;
            long l11 = 256L;
            this.F = l10 |= l11;
        }
        this.notifyPropertyChanged(111);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(TemplateEditViewModel templateEditViewModel) {
        this.x = templateEditViewModel;
        synchronized (this) {
            long l10 = this.F;
            long l11 = 1024L;
            this.F = l10 |= l11;
        }
        this.notifyPropertyChanged(136);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(StoryReviewViewModel storyReviewViewModel) {
        this.w = storyReviewViewModel;
        synchronized (this) {
            long l10 = this.F;
            long l11 = 2048L;
            this.F = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 != n13) {
                    int n14 = 4;
                    if (n10 == n14) {
                        TemplateEditViewModel templateEditViewModel = this.x;
                        if (templateEditViewModel != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            templateEditViewModel.W0();
                        }
                    }
                } else {
                    StoryReviewViewModel$ReviewStatus storyReviewViewModel$ReviewStatus;
                    int n15;
                    y$b y$b = this.v;
                    Object object = this.w;
                    if (object != null) {
                        n15 = n12;
                    } else {
                        n15 = 0;
                        storyReviewViewModel$ReviewStatus = null;
                    }
                    if (n15 != 0) {
                        if ((object = ((StoryReviewViewModel)object).n()) != null) {
                            n15 = n12;
                        } else {
                            n15 = 0;
                            storyReviewViewModel$ReviewStatus = null;
                        }
                        if (n15 != 0) {
                            if ((object = (StoryReviewViewModel$ReviewStatus)((Object)((LiveData)object).getValue())) == (storyReviewViewModel$ReviewStatus = StoryReviewViewModel$ReviewStatus.SETTING_REVIEW)) {
                                n13 = n12;
                            } else {
                                n13 = 0;
                                object = null;
                            }
                            if (n13 == 0) {
                                if (y$b != null) {
                                    n11 = n12;
                                }
                                if (n11 != 0) {
                                    y$b.k(view);
                                }
                            }
                        }
                    }
                }
            } else {
                y$b y$b = this.v;
                if (y$b != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    y$b.j(view);
                }
            }
        } else {
            y$b y$b = this.v;
            if (y$b != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                y$b.a();
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
        block108: {
            block107: {
                block106: {
                    block104: {
                        block105: {
                            var1_1 = this;
                            synchronized (this) {
                                var2_2 = this.F;
                                this.F = var4_3 = 0L;
                            }
                            var6_4 = this.y;
                            var7_5 = this.v;
                            var8_6 = this.x;
                            var9_7 /* !! */  = this.w;
                            var10_8 = 4608L;
                            var12_9 = var2_2 & var10_8;
                            var14_10 = var12_9 == var4_3 ? 0 : (var12_9 < var4_3 ? -1 : 1);
                            if (var14_10 != false && var7_5 != null) {
                                var15_11 = var7_5.l();
                            } else {
                                var14_10 = 0;
                                var15_11 = null;
                            }
                            var16_12 = 5249L;
                            var18_13 = var2_2 & var16_12;
                            var20_14 = var18_13 == var4_3 ? 0 : (var18_13 < var4_3 ? -1 : 1);
                            var21_15 = 0;
                            var22_16 = null;
                            if (var20_14 != false) {
                                if (var8_6 != null) {
                                    var23_17 = var8_6.Z();
                                    var24_18 = var8_6.j0();
                                    var25_19 = var24_18;
                                } else {
                                    var26_20 = 0;
                                    var25_19 = null;
                                    var20_14 = 0;
                                    var23_17 = null;
                                }
                                var1_1.updateLiveDataRegistration(0, (LiveData)var23_17);
                                var27_21 /* !! */  = 7;
                                var1_1.updateLiveDataRegistration((int)var27_21 /* !! */ , (LiveData)var25_19);
                                if (var23_17 != null) {
                                    var28_22 = (Long)var23_17.getValue();
                                } else {
                                    var27_21 /* !! */  = 0;
                                    var28_22 = null;
                                }
                                if (var25_19 != null) {
                                    var25_19 = (Long)var25_19.getValue();
                                } else {
                                    var26_20 = 0;
                                    var25_19 = null;
                                }
                                var29_23 = ViewDataBinding.safeUnbox((Long)var28_22);
                                var31_24 = ViewDataBinding.safeUnbox((Long)var25_19);
                                var25_19 = l2.d(var29_23);
                                var28_22 = l2.d(var31_24);
                                var23_17 = new StringBuilder();
                                var23_17.append((String)var25_19);
                                var23_17.append("/ ");
                                var25_19 = var23_17.toString();
                                var23_17 = new StringBuilder();
                                var23_17.append((String)var25_19);
                                var23_17.append((String)var28_22);
                                var25_19 = var23_17.toString();
                            } else {
                                var26_20 = 0;
                                var25_19 = null;
                            }
                            var29_23 = 7230L & var2_2;
                            var27_21 /* !! */  = var29_23 == var4_3 ? 0 : (var29_23 < var4_3 ? -1 : 1);
                            var31_24 = 0x10000000L;
                            var33_25 = 0x8000000L;
                            var35_26 = 16384L;
                            var37_27 = 8192L;
                            var39_28 = 7216L;
                            var41_29 = 6152L;
                            var43_30 = 6180L;
                            var45_31 = 0x4000000L;
                            var47_32 = 6146L;
                            var49_33 = 262144L;
                            var51_34 = 6176L;
                            var53_35 = 8;
                            var54_36 = 1.1E-44f;
                            var21_15 = 1;
                            if (var27_21 /* !! */  == false) break block105;
                            var55_37 = var2_2 & var47_32;
                            cfr_temp_0 = var55_37 - var4_3;
                            var27_21 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                            if (var27_21 /* !! */  != false) {
                                if (var9_7 /* !! */  != null) {
                                    var28_22 = var9_7 /* !! */ .m();
                                } else {
                                    var27_21 /* !! */  = 0;
                                    var28_22 = null;
                                }
                                var1_1.updateLiveDataRegistration(var21_15, (LiveData)var28_22);
                                if (var28_22 != null) {
                                    var28_22 = (Integer)var28_22.getValue();
                                } else {
                                    var27_21 /* !! */  = 0;
                                    var28_22 = null;
                                }
                                var27_21 /* !! */  = ViewDataBinding.safeUnbox((Integer)var28_22);
                            } else {
                                var27_21 /* !! */  = 0;
                                var28_22 = null;
                            }
                            var55_37 = var2_2 & var43_30;
                            var57_38 = var55_37 == var4_3 ? 0 : (var55_37 < var4_3 ? -1 : 1);
                            if (var57_38 != false) {
                                if (var9_7 /* !! */  != null) {
                                    var58_39 = var9_7 /* !! */ .f();
                                    var59_40 /* !! */  = var58_39;
                                } else {
                                    var60_42 = 0;
                                    var61_43 = 0.0f;
                                    var59_40 /* !! */  = null;
                                }
                                var62_45 = 2;
                                var63_46 = 2.8E-45f;
                                var1_1.updateLiveDataRegistration(var62_45, (LiveData)var59_40 /* !! */ );
                                if (var59_40 /* !! */  != null) {
                                    var59_40 /* !! */  = (Boolean)var59_40 /* !! */ .getValue();
                                } else {
                                    var60_42 = 0;
                                    var61_43 = 0.0f;
                                    var59_40 /* !! */  = null;
                                }
                                var60_42 = ViewDataBinding.safeUnbox((Boolean)var59_40 /* !! */ );
                                if (var57_38 != false) {
                                    if (var60_42 != 0) {
                                        var2_2 |= var49_33;
                                    } else {
                                        var64_48 = 131072L;
                                        var2_2 |= var64_48;
                                    }
                                }
                            } else {
                                var60_42 = 0;
                                var61_43 = 0.0f;
                                var59_40 /* !! */  = null;
                            }
                            if ((var62_45 = (int)((cfr_temp_1 = (var64_48 = var2_2 & var41_29) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) == 0) ** GOTO lbl-1000
                            if (var9_7 /* !! */  != null) {
                                var66_49 = var9_7 /* !! */ .j();
                                var22_16 = var66_49;
                            } else {
                                var21_15 = 0;
                                var22_16 = null;
                            }
                            var20_14 = 3;
                            var1_1.updateLiveDataRegistration((int)var20_14, (LiveData)var22_16);
                            if (var22_16 != null) {
                                var22_16 = (Integer)var22_16.getValue();
                            } else {
                                var21_15 = 0;
                                var22_16 = null;
                            }
                            var21_15 = ViewDataBinding.safeUnbox((Integer)var22_16);
                            if (var21_15 == 0) {
                                var21_15 = 1;
                            } else {
                                var21_15 = 0;
                                var22_16 = null;
                            }
                            if (var62_45 != 0) {
                                var67_50 = var21_15 != 0 ? 0x40000000L : 0x20000000L;
                                var2_2 |= var67_50;
                            }
                            if (var21_15 != 0) {
                                var62_45 = var53_35;
                                var63_46 = var54_36;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var62_45 = 0;
                                var63_46 = 0.0f;
                            }
                            var67_50 = var2_2 & var39_28;
                            var21_15 = (int)(var67_50 == var4_3 ? 0 : (var67_50 < var4_3 ? -1 : 1));
                            if (var21_15 != 0) {
                                if (var9_7 /* !! */  != null) {
                                    var23_17 = var9_7 /* !! */ .n();
                                    var69_51 = 5;
                                } else {
                                    var69_51 = 5;
                                    var20_14 = 0;
                                    var23_17 = null;
                                }
                                var1_1.updateLiveDataRegistration(var69_51, (LiveData)var23_17);
                                if (var23_17 != null) {
                                    var70_52 = (StoryReviewViewModel$ReviewStatus)var23_17.getValue();
                                } else {
                                    var69_51 = 0;
                                    var70_52 = null;
                                }
                                var71_53 /* !! */  = StoryReviewViewModel$ReviewStatus.TOTAL_REVIEW;
                                if (var70_52 == var71_53 /* !! */ ) {
                                    var72_54 = 1;
                                    var73_55 = 1.4E-45f;
                                } else {
                                    var72_54 = 0;
                                    var73_55 = 0.0f;
                                    var71_53 /* !! */  = null;
                                }
                                if (var21_15 != 0) {
                                    if (var72_54 != 0) {
                                        var2_2 |= var45_31;
                                    } else {
                                        var74_58 = 0x2000000L;
                                        var2_2 |= var74_58;
                                    }
                                }
                                if ((var21_15 = (int)((cfr_temp_2 = (var74_58 = var2_2 & var51_34) - (var67_50 = 0L)) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) != 0) {
                                    var74_58 = var72_54 != 0 ? 0x100000000L : 0x80000000L;
                                    var2_2 |= var74_58;
                                }
                                if ((var21_15 = (int)((cfr_temp_3 = (var74_58 = var2_2 & var51_34) - var67_50) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) != 0 && var72_54 == 0) {
                                    var76_59 = var53_35;
                                } else {
                                    var76_59 = 0;
                                    var77_62 = null;
                                }
                                var78_63 = var72_54;
                                var79_66 = var73_55;
                                if (var21_15 != 0) {
                                    var71_53 /* !! */  = StoryReviewViewModel$ReviewStatus.SINGLE_REVIEW;
                                    if (var70_52 != var71_53 /* !! */ ) {
                                        var80_69 = 1;
                                        var81_70 = 1.4E-45f;
                                    } else {
                                        var80_69 = 0;
                                        var81_70 = 0.0f;
                                    }
                                    var82_74 = var60_42;
                                    if (var70_52 == var71_53 /* !! */ ) {
                                        var72_54 = 1;
                                        var73_55 = 1.4E-45f;
                                    } else {
                                        var72_54 = 0;
                                        var73_55 = 0.0f;
                                        var71_53 /* !! */  = null;
                                    }
                                    var59_40 /* !! */  = StoryReviewViewModel$ReviewStatus.SETTING_REVIEW;
                                    if (var70_52 == var59_40 /* !! */ ) {
                                        var60_42 = 1;
                                        var61_43 = 1.4E-45f;
                                    } else {
                                        var60_42 = 0;
                                        var61_43 = 0.0f;
                                        var59_40 /* !! */  = null;
                                    }
                                    if (var21_15 != 0) {
                                        var83_75 = var80_69 != 0 ? 0x100000L : 524288L;
                                        var2_2 |= var83_75;
                                    }
                                    if ((var21_15 = (int)((cfr_temp_4 = (var83_75 = var2_2 & var49_33) - (var67_50 = 0L)) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) != 0) {
                                        var2_2 = var72_54 != 0 ? (var2_2 |= var35_26) : (var2_2 |= var37_27);
                                    }
                                    if ((var21_15 = (int)((cfr_temp_5 = (var83_75 = var2_2 & var51_34) - var67_50) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0) {
                                        var2_2 = var72_54 != 0 ? (var2_2 |= var31_24) : (var2_2 |= var33_25);
                                    }
                                    if ((var21_15 = (int)((cfr_temp_6 = (var83_75 = var2_2 & var51_34) - var67_50) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1))) != 0) {
                                        if (var60_42 != 0) {
                                            var2_2 |= 65536L;
                                            var83_75 = 0x1000000L;
                                        } else {
                                            var2_2 |= 32768L;
                                            var83_75 = 0x800000L;
                                        }
                                        var2_2 |= var83_75;
                                    }
                                    if (var80_69 != 0) {
                                        var21_15 = 0;
                                        var22_16 = null;
                                    } else {
                                        var21_15 = var53_35;
                                    }
                                    if (var72_54 != 0) {
                                        var80_69 = 0;
                                        var81_70 = 0.0f;
                                    } else {
                                        var80_69 = var53_35;
                                        var81_70 = var54_36;
                                    }
                                    if (var60_42 != 0) {
                                        var85_76 = 0;
                                        var86_77 = null;
                                    } else {
                                        var85_76 = var53_35;
                                    }
                                    if (var60_42 != 0) {
                                        var60_42 = var53_35;
                                        var61_43 = var54_36;
                                    } else {
                                        var60_42 = 0;
                                        var61_43 = 0.0f;
                                        var59_40 /* !! */  = null;
                                    }
                                    var87_78 /* !! */  = var70_52;
                                    var69_51 = var76_59;
                                    var77_62 = var23_17;
                                    var20_14 = var27_21 /* !! */ ;
                                    var27_21 /* !! */  = var21_15;
                                    var21_15 = var62_45;
                                    var62_45 = var60_42;
                                    var63_46 = var61_43;
                                    var60_42 = var80_69;
                                    var61_43 = var81_70;
                                    var80_69 = var72_54;
                                    var81_70 = var73_55;
                                    var72_54 = var78_63;
                                    var73_55 = var79_66;
                                    var86_77 = var25_19;
                                    var26_20 = var85_76;
                                    break block104;
                                } else {
                                    var82_74 = var60_42;
                                    var21_15 = var62_45;
                                    var86_77 = var25_19;
                                    var60_42 = 0;
                                    var61_43 = 0.0f;
                                    var59_40 /* !! */  = null;
                                    var62_45 = 0;
                                    var63_46 = 0.0f;
                                    var26_20 = 0;
                                    var25_19 = null;
                                    var80_69 = 0;
                                    var81_71 = 0.0f;
                                    var87_78 /* !! */  = var70_52;
                                    var69_51 = var76_59;
                                    var77_62 = var23_17;
                                    var20_14 = var27_21 /* !! */ ;
                                    var27_21 /* !! */  = 0;
                                    var28_22 = null;
                                }
                                break block104;
                            } else {
                                var82_74 = var60_42;
                                var21_15 = var62_45;
                                var86_77 = var25_19;
                                var20_14 = var27_21 /* !! */ ;
                                var69_51 = 0;
                                var70_52 = null;
                                var72_54 = 0;
                                var73_56 = 0.0f;
                                var71_53 /* !! */  = null;
                                var60_42 = 0;
                                var61_43 = 0.0f;
                                var59_40 /* !! */  = null;
                                var62_45 = 0;
                                var63_46 = 0.0f;
                                var26_20 = 0;
                                var25_19 = null;
                                var27_21 /* !! */  = 0;
                                var28_22 = null;
                                var76_60 = false;
                                var77_62 = null;
                                var78_64 = false;
                                var79_67 = 0.0f;
                                var87_78 /* !! */  = null;
                                var80_69 = 0;
                                var81_72 = 0.0f;
                            }
                            break block104;
                        }
                        var86_77 = var25_19;
                        var69_51 = 0;
                        var70_52 = null;
                        var72_54 = 0;
                        var73_57 = 0.0f;
                        var71_53 /* !! */  = null;
                        var60_42 = 0;
                        var61_44 = 0.0f;
                        var59_41 = null;
                        var62_45 = 0;
                        var63_47 = 0.0f;
                        var21_15 = 0;
                        var22_16 = null;
                        var26_20 = 0;
                        var25_19 = null;
                        var27_21 /* !! */  = 0;
                        var28_22 = null;
                        var20_14 = 0;
                        var23_17 = null;
                        var76_61 = false;
                        var77_62 = null;
                        var78_65 = false;
                        var79_68 = 0.0f;
                        var87_78 /* !! */  = null;
                        var80_69 = 0;
                        var81_73 = 0.0f;
                        var82_74 = 0;
                    }
                    var49_33 = var2_2 & var49_33;
                    var67_50 = 0L;
                    var88_79 = var49_33 == var67_50 ? 0 : (var49_33 < var67_50 ? -1 : 1);
                    if (var88_79 != false) {
                        if (var9_7 /* !! */  != null) {
                            var77_62 = var9_7 /* !! */ .n();
                        }
                        var89_80 = var9_7 /* !! */ ;
                        var90_81 = var15_11;
                        var9_7 /* !! */  = var77_62;
                        var14_10 = 5;
                        var1_1.updateLiveDataRegistration((int)var14_10, (LiveData)var77_62);
                        var9_7 /* !! */  = var77_62 != null ? (StoryReviewViewModel$ReviewStatus)var77_62.getValue() : var87_78 /* !! */ ;
                        var15_11 = StoryReviewViewModel$ReviewStatus.SINGLE_REVIEW;
                        if (var9_7 /* !! */  == var15_11) {
                            var91_82 = 1;
                        } else {
                            var91_82 = 0;
                            var9_7 /* !! */  = null;
                        }
                        if (var88_79 != false) {
                            var2_2 = var91_82 != 0 ? (var2_2 |= var35_26) : (var2_2 |= var37_27);
                        }
                        if ((var14_10 = (cfr_temp_7 = (var35_26 = var2_2 & var51_34) - (var37_27 = 0L)) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1)) != false) {
                            var2_2 = var91_82 != 0 ? (var2_2 |= var31_24) : (var2_2 |= var33_25);
                        }
                        var15_11 = var91_82 != 0 ? "@string/story_preview_all" : "@string/set_str";
                    } else {
                        var89_80 = var9_7 /* !! */ ;
                        var90_81 = var15_11;
                        var91_82 = var80_69;
                        var14_10 = 0;
                        var15_11 = null;
                    }
                    var31_24 = var2_2 & var45_31;
                    var33_25 = 0L;
                    var92_83 = var31_24 == var33_25 ? 0 : (var31_24 < var33_25 ? -1 : 1);
                    if (var92_83 == false) break block106;
                    if (var8_6 != null) {
                        var93_84 /* !! */  = var8_6.V();
                        var94_85 = var8_6;
                        var95_86 /* !! */  = var93_84 /* !! */ ;
                        var93_84 /* !! */  = var15_11;
                        var15_11 = var95_86 /* !! */ ;
                    } else {
                        var94_85 = var8_6;
                        var93_84 /* !! */  = var15_11;
                        var14_10 = 0;
                        var15_11 = null;
                    }
                    var96_87 = 4;
                    var97_88 = 5.6E-45f;
                    var1_1.updateLiveDataRegistration(var96_87, (LiveData)var15_11);
                    if (var15_11 != null) {
                        var8_6 = (Boolean)var15_11.getValue();
                    } else {
                        var96_87 = 0;
                        var97_88 = 0.0f;
                        var8_6 = null;
                    }
                    var96_87 = (int)ViewDataBinding.safeUnbox((Boolean)var8_6);
                    if (var92_83 != false) {
                        var98_89 = var96_87 != 0 ? 0x400000L : 0x200000L;
                        var2_2 |= var98_89;
                    }
                    if (var96_87 == 0) break block107;
                    var96_87 = var53_35;
                    var97_88 = var54_36;
                    break block108;
                }
                var94_85 = var8_6;
                var93_84 /* !! */  = var15_11;
            }
            var96_87 = 0;
            var97_88 = 0.0f;
            var8_6 = null;
        }
        var98_89 = var2_2 & var43_30;
        var100_90 = 0L;
        var14_10 = var98_89 == var100_90 ? 0 : (var98_89 < var100_90 ? -1 : 1);
        if (var14_10 != false) {
            var102_91 /* !! */  = var82_74 != 0 ? var93_84 /* !! */  : "@string/story_record_next";
            var95_86 /* !! */  = var102_91 /* !! */ ;
            var92_83 = var96_87;
            var103_92 = var97_88;
            var8_6 = var102_91 /* !! */ ;
        } else {
            var92_83 = var96_87;
            var103_92 = var97_88;
            var96_87 = 0;
            var97_88 = 0.0f;
            var8_6 = null;
        }
        var98_89 = var2_2 & var39_28;
        var104_93 = var98_89 == var100_90 ? 0 : (var98_89 < var100_90 ? -1 : 1);
        if (var104_93 != false) {
            if (var72_54 == 0) {
                var92_83 = var53_35;
                var103_92 = var54_36;
            }
            var102_91 /* !! */  = var8_6;
            var96_87 = (int)var92_83;
            var97_88 = var103_92;
        } else {
            var102_91 /* !! */  = var8_6;
            var96_87 = 0;
            var97_88 = 0.0f;
            var8_6 = null;
        }
        var98_89 = var2_2 & var41_29;
        var105_94 = var98_89 == var100_90 ? 0 : (var98_89 < var100_90 ? -1 : 1);
        if (var105_94 != false) {
            var105_94 = var14_10;
            var15_11 = var1_1.b;
            var15_11.setVisibility(var21_15);
        } else {
            var105_94 = var14_10;
        }
        var12_9 = 4096L & var2_2;
        var14_10 = var12_9 == var100_90 ? 0 : (var12_9 < var100_90 ? -1 : 1);
        if (var14_10 != false) {
            var14_10 = ViewDataBinding.getBuildSdkInt();
            if (var14_10 >= (var21_15 = 21)) {
                var15_11 = var1_1.c;
                var21_15 = 1;
                var15_11.setClipToOutline((boolean)var21_15);
            }
            var15_11 = var1_1.j;
            var22_16 = var1_1.C;
            var15_11.setOnClickListener((View.OnClickListener)var22_16);
            var15_11 = var1_1.k;
            var22_16 = var1_1.A;
            var15_11.setOnClickListener((View.OnClickListener)var22_16);
            var15_11 = var1_1.p;
            var22_16 = var1_1.B;
            var15_11.setOnStoryItemClickListener((StoryProgressBar$a)var22_16);
            var15_11 = var1_1.r;
            var22_16 = var1_1.E;
            var15_11.setOnClickListener((View.OnClickListener)var22_16);
            var15_11 = var1_1.s;
            var22_16 = var1_1.D;
            var15_11.setOnClickListener((View.OnClickListener)var22_16);
        }
        if ((var14_10 = (cfr_temp_8 = (var12_9 = var2_2 & var51_34) - (var35_26 = 0L)) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1)) != false) {
            var1_1.d.setVisibility(var62_45);
            var15_11 = var1_1.e;
            var15_11.setClickable((boolean)var91_82);
            var1_1.e.setVisibility(var60_42);
            var9_7 /* !! */  = var1_1.f;
            var9_7 /* !! */ .setClickable((boolean)var72_54);
            var71_53 /* !! */  = var1_1.f;
            var71_53 /* !! */ .setVisibility(var69_51);
            var1_1.o.getRoot().setVisibility(var26_20);
            var1_1.r.setVisibility(var62_45);
            var70_52 = var1_1.t;
            var70_52.setVisibility((int)var27_21 /* !! */ );
        }
        if (var104_93 != false) {
            var70_52 = var1_1.k;
            var70_52.setVisibility(var96_87);
        }
        if ((var69_51 = (int)((cfr_temp_9 = (var4_3 = 4352L & var2_2) - (var106_95 = 0L)) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1))) != 0) {
            var70_52 = var1_1.z;
            var70_52.z((j1)var6_4);
        }
        if ((var108_96 = (cfr_temp_10 = (var4_3 = var2_2 & var47_32) - var106_95) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.n;
            var6_4.setProgress((int)var20_14);
        }
        if ((var108_96 = (cfr_temp_11 = (var4_3 = 4608L & var2_2) - var106_95) == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1)) != false) {
            var1_1.o.D(var7_5);
            var6_4 = var1_1.t;
            var15_11 = var90_81;
            d.v.f.e.c.f((View)var6_4, var90_81);
        }
        if ((var108_96 = (cfr_temp_12 = (var4_3 = 5120L & var2_2) - var106_95) == 0L ? 0 : (cfr_temp_12 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.o;
            var70_52 = var94_85;
            var6_4.F(var94_85);
        }
        if ((var108_96 = (cfr_temp_13 = (var4_3 = 6144L & var2_2) - var106_95) == 0L ? 0 : (cfr_temp_13 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.o;
            var70_52 = var89_80;
            var6_4.G(var89_80);
        }
        if ((var108_96 = (cfr_temp_14 = (var2_2 &= (var4_3 = 5249L)) - var106_95) == 0L ? 0 : (cfr_temp_14 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.q;
            var25_19 = var86_77;
            l.a.q.g0.u.n((TextView)var6_4, (String)var86_77, null, null);
        }
        if (var105_94 != false) {
            var6_4 = var1_1.r;
            l.a.q.g0.u.n((TextView)var6_4, (String)var102_91 /* !! */ , null, null);
        }
        ViewDataBinding.executeBindingsOn(var1_1.z);
        ViewDataBinding.executeBindingsOn(var1_1.o);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.F;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            ViewDataBinding viewDataBinding = this.z;
            l12 = (long)viewDataBinding.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            viewDataBinding = this.o;
            l12 = (long)viewDataBinding.hasPendingBindings();
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
            this.F = l10 = 4096L;
        }
        this.z.invalidateAll();
        this.o.invalidateAll();
        this.requestRebind();
    }

    public final void k(int n10, int n11) {
        y$b y$b = this.v;
        boolean bl2 = y$b != null;
        if (bl2) {
            y$b.i(n11);
        }
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        switch (n10) {
            default: {
                return false;
            }
            case 7: {
                object = (LiveData)object;
                return this.J((LiveData)object, n11);
            }
            case 6: {
                object = (ai)object;
                return this.G((ai)object, n11);
            }
            case 5: {
                object = (MutableLiveData)object;
                return this.N((MutableLiveData)object, n11);
            }
            case 4: {
                object = (MutableLiveData)object;
                return this.H((MutableLiveData)object, n11);
            }
            case 3: {
                object = (MutableLiveData)object;
                return this.L((MutableLiveData)object, n11);
            }
            case 2: {
                object = (MutableLiveData)object;
                return this.K((MutableLiveData)object, n11);
            }
            case 1: {
                object = (MutableLiveData)object;
                return this.M((MutableLiveData)object, n11);
            }
            case 0: 
        }
        object = (MutableLiveData)object;
        return this.I((MutableLiveData)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.z.setLifecycleOwner(lifecycleOwner);
        this.o.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 111;
        if (n11 == n10) {
            object = (j1)object;
            this.D((j1)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 == n10) {
                object = (y$b)object;
                this.C((y$b)object);
                return 1 != 0;
            } else {
                n11 = 136;
                if (n11 == n10) {
                    object = (TemplateEditViewModel)object;
                    this.E((TemplateEditViewModel)object);
                    return 1 != 0;
                } else {
                    n11 = 152;
                    if (n11 != n10) return 0 != 0;
                    object = (StoryReviewViewModel)object;
                    this.F((StoryReviewViewModel)object);
                }
            }
        }
        return 1 != 0;
    }
}

