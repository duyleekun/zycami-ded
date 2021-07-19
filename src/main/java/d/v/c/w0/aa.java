/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.SeekBar
 *  android.widget.TextView
 *  android.widget.VideoView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import com.zhiyun.cama.album.AlbumSection;
import com.zhiyun.cama.album.ZYSubsamplingScaleImageView;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.w0.z9;
import d.v.e.l.m1;
import l.a.q.g0.u;

public class aa
extends z9 {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private final ConstraintLayout l;
    private long m;

    public aa(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 9, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private aa(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[1];
        object2 = (ZYSubsamplingScaleImageView)((Object)object);
        Object object3 = object = objectArray[4];
        object3 = (ImageView)object;
        Object object4 = object = objectArray[5];
        object4 = (ZYTextView)object;
        Object object5 = object = objectArray[6];
        object5 = (AppCompatSeekBar)((Object)object);
        Object object6 = object = objectArray[7];
        object6 = (ZYTextView)object;
        Object object7 = object = objectArray[2];
        object7 = (VideoView)object;
        Object object8 = object = objectArray[3];
        object8 = (ImageView)object;
        Object object9 = object = objectArray[8];
        object9 = (ImageView)object;
        object = this;
        super(dataBindingComponent, view, 5, (ZYSubsamplingScaleImageView)((Object)object2), (ImageView)object3, (ZYTextView)object4, (AppCompatSeekBar)((Object)object5), (ZYTextView)object6, (VideoView)object7, (ImageView)object8, (ImageView)object9);
        this.m = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.l = object;
        object.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        object = view;
        this.setRootTag(view);
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
                long l10 = this.m;
                long l11 = 8;
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
    private boolean F(ObservableBoolean observableBoolean, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.m;
                long l11 = 16;
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
    private boolean G(ObservableInt observableInt, int n10) {
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
    private boolean H(ObservableBoolean observableBoolean, int n10) {
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
    private boolean I(ObservableInt observableInt, int n10) {
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
    public void B(ObservableBoolean observableBoolean) {
        int n10 = 3;
        this.updateRegistration(n10, observableBoolean);
        this.j = observableBoolean;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 8;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(100);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(ObservableBoolean observableBoolean) {
        int n10 = 4;
        this.updateRegistration(n10, observableBoolean);
        this.i = observableBoolean;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 16;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(106);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(AlbumSection albumSection) {
        this.k = albumSection;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 32;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(116);
        super.requestRebind();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block75: {
            block70: {
                block74: {
                    block73: {
                        block72: {
                            block71: {
                                var1_1 = this;
                                synchronized (this) {
                                    var2_2 = this.m;
                                    this.m = var4_3 = 0L;
                                }
                                var6_4 /* !! */  = this.k;
                                var7_5 = this.j;
                                var8_6 = this.i;
                                var9_7 = (long)103 & var2_2;
                                var11_8 = var9_7 == var4_3 ? 0 : (var9_7 < var4_3 ? -1 : 1);
                                var12_9 = 0x100000L;
                                var14_10 = 4096L;
                                var16_11 = 2048L;
                                var18_12 = 100;
                                var20_13 = 97;
                                var22_14 = 1;
                                var23_15 = 262144L;
                                var25_16 = 96;
                                var27_17 = 98;
                                var29_18 = 0;
                                var30_19 = 0.0f;
                                var31_20 = null;
                                if (var11_8 == false) break block70;
                                if (var6_4 /* !! */  != null) {
                                    var32_21 = var6_4 /* !! */ .getAlbum();
                                } else {
                                    var11_8 = 0;
                                    var32_21 = null;
                                }
                                var33_23 = var2_2 & var20_13;
                                var35_24 = var33_23 == var4_3 ? 0 : (var33_23 < var4_3 ? -1 : 1);
                                if (var35_24 != false) {
                                    if (var32_21 != null) {
                                        var36_25 = var32_21.playedSec;
                                    } else {
                                        var37_26 = 0;
                                        var36_25 = null;
                                    }
                                    var1_1.updateRegistration(0, (Observable)var36_25);
                                    if (var36_25 != null) {
                                        var37_26 = var36_25.get();
                                    } else {
                                        var37_26 = 0;
                                        var36_25 = null;
                                    }
                                    var36_25 = m1.D(var37_26);
                                } else {
                                    var37_27 = false;
                                    var36_25 = null;
                                }
                                var38_29 = var2_2 & var25_16;
                                var40_30 = var38_29 == var4_3 ? 0 : (var38_29 < var4_3 ? -1 : 1);
                                if (var40_30 != false) {
                                    if (var32_21 != null) {
                                        var29_18 = var41_31 = var32_21.getDurationSec();
                                    }
                                    var30_19 = var29_18;
                                    var29_18 = Math.round(var30_19);
                                    var31_20 = m1.D(var29_18);
                                } else {
                                    var29_18 = 0;
                                    var30_19 = 0.0f;
                                    var31_20 = null;
                                }
                                var42_32 = var2_2 & var27_17;
                                var44_33 = var42_32 == var4_3 ? 0 : (var42_32 < var4_3 ? -1 : 1);
                                if (var44_33 == false) break block71;
                                if (var32_21 != null) {
                                    var45_34 = var32_21.playing;
                                    var46_35 = var32_21.isVideo;
                                } else {
                                    var47_36 = false;
                                    var45_34 = null;
                                    var46_35 = false;
                                }
                                var1_1.updateRegistration(var22_14, (Observable)var45_34);
                                if (var40_30 != false) {
                                    if (var46_35) {
                                        var2_2 = var2_2 | var14_10 | var12_9;
                                    } else {
                                        var2_2 |= var16_11;
                                        var33_23 = 524288L;
                                        var2_2 |= var33_23;
                                    }
                                }
                                if ((var40_30 = (cfr_temp_0 = (var48_37 = var2_2 & var27_17) - (var42_32 = 0L)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false) {
                                    if (var46_35) {
                                        var2_2 |= var23_15;
                                    } else {
                                        var50_38 = 131072L;
                                        var2_2 |= var50_38;
                                    }
                                }
                                if (var45_34 != null) {
                                    var47_36 = var45_34.get();
                                } else {
                                    var47_36 = false;
                                    var45_34 = null;
                                }
                                var48_37 = var2_2 & var27_17;
                                var42_32 = 0L;
                                var40_30 = var48_37 == var42_32 ? 0 : (var48_37 < var42_32 ? -1 : 1);
                                if (var40_30 != false) {
                                    var48_37 = var47_36 != false ? 65536L : 32768L;
                                    var2_2 |= var48_37;
                                }
                                var52_39 = var1_1.b.getContext();
                                var53_40 = var47_36 != false ? 2131231620 : 2131231619;
                                var52_39 = AppCompatResources.getDrawable(var52_39, var53_40);
                                var54_41 = var2_2 & var25_16;
                                var42_32 = 0L;
                                cfr_temp_1 = var54_41 - var42_32;
                                var53_40 = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                                if (var53_40 == 0) break block72;
                                var53_40 = var46_35 != false ? 0 : 8;
                                if (!var46_35) break block73;
                                var40_30 = 8;
                                break block74;
                            }
                            var47_36 = false;
                            var45_34 = null;
                            var46_35 = false;
                            var52_39 = null;
                        }
                        var53_40 = 0;
                    }
                    var40_30 = 0;
                }
                var54_41 = var2_2 & var18_12;
                var42_32 = 0L;
                var56_42 = var54_41 == var42_32 ? 0 : (var54_41 < var42_32 ? -1 : 1);
                if (var56_42 == false) ** GOTO lbl-1000
                if (var32_21 != null) {
                    var57_43 = var32_21.progress;
                } else {
                    var58_45 = 0;
                    var57_43 = null;
                }
                var59_46 = 2;
                var1_1.updateRegistration(var59_46, var57_43);
                if (var57_43 != null) {
                    var58_45 = var57_43.get();
                    var60_48 = var31_20;
                } else lbl-1000:
                // 2 sources

                {
                    var60_48 = var31_20;
                    var58_45 = 0;
                    var57_43 = null;
                }
                var31_20 = var32_21;
                var11_8 = var40_30;
                break block75;
            }
            var47_36 = false;
            var45_34 = null;
            var46_35 = false;
            var11_8 = 0;
            var32_22 = null;
            var29_18 = 0;
            var30_19 = 0.0f;
            var31_20 = null;
            var52_39 = null;
            var53_40 = 0;
            var58_45 = 0;
            var57_44 = null;
            var59_47 = false;
            var60_48 = null;
            var37_28 = false;
            var36_25 = null;
        }
        var61_49 = 72;
        var63_50 = var2_2 & var61_49;
        var42_32 = 0L;
        var40_30 = var63_50 == var42_32 ? 0 : (var63_50 < var42_32 ? -1 : 1);
        if (var40_30 != false) {
            if (var7_5 != null) {
                var65_51 = var7_5.get();
            } else {
                var65_51 = false;
                var7_5 = null;
            }
            if (var40_30 != false) {
                var63_50 = var65_51 != false ? 0x400000L : 0x200000L;
                var2_2 |= var63_50;
            }
            if (var65_51) {
                var7_5 = var1_1.h.getContext();
                var22_14 = 2131231618;
            } else {
                var7_5 = var1_1.h.getContext();
                var22_14 = 2131231622;
            }
            var7_5 = AppCompatResources.getDrawable((Context)var7_5, var22_14);
        } else {
            var65_52 = false;
            var7_5 = null;
        }
        var63_50 = 112;
        var66_53 = var2_2 & var63_50;
        var42_32 = 0L;
        var22_14 = (int)(var66_53 == var42_32 ? 0 : (var66_53 < var42_32 ? -1 : 1));
        var66_53 = 1024L;
        if (var22_14 != 0) {
            if (var8_6 != null) {
                var68_54 = var8_6.get();
            } else {
                var68_54 = false;
                var8_6 = null;
            }
            var40_30 = 1;
            var68_54 ^= true;
            if (var22_14 != 0) {
                if (var68_54) {
                    var2_2 |= var66_53;
                } else {
                    var69_55 = 512L;
                    var2_2 |= var69_55;
                }
            }
        } else {
            var68_54 = false;
            var8_6 = null;
        }
        if ((var22_14 = (int)((cfr_temp_2 = (var66_53 = var2_2 & var66_53) - (var42_32 = 0L)) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) != 0) {
            if (var6_4 /* !! */  != null) {
                var31_20 = var6_4 /* !! */ .getAlbum();
            }
            if (var31_20 != null) {
                var46_35 = var31_20.isVideo;
            }
            if ((var73_57 = (cfr_temp_3 = (var71_56 = var2_2 & var25_16) - var42_32) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
                if (var46_35) {
                    var2_2 |= 4096L;
                    var71_56 = 0x100000L;
                } else {
                    var2_2 |= var16_11;
                    var71_56 = 524288L;
                }
                var2_2 |= var71_56;
            }
            if ((var73_57 = (cfr_temp_4 = (var71_56 = var2_2 & var27_17) - var42_32) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1)) != false) {
                if (var46_35) {
                    var2_2 |= var23_15;
                } else {
                    var71_56 = 131072L;
                    var2_2 |= var71_56;
                }
            }
        }
        if ((var73_57 = (cfr_temp_5 = (var71_56 = var2_2 & var63_50) - var42_32) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1)) == false) ** GOTO lbl-1000
        if (var68_54) {
            var68_54 = var46_35;
        } else {
            var68_54 = false;
            var8_6 = null;
        }
        if (var73_57 != false) {
            var71_56 = var68_54 != false ? 256L : 128L;
            var2_2 |= var71_56;
        }
        if (!var68_54) {
            var73_57 = 8;
        } else lbl-1000:
        // 2 sources

        {
            var73_57 = 0;
            var6_4 /* !! */  = null;
        }
        var71_56 = var2_2 & var23_15;
        var16_11 = 0L;
        var68_54 = var71_56 == var16_11 ? 0 : (var71_56 < var16_11 ? -1 : 1);
        if (var68_54) {
            var68_54 = true;
            var47_36 ^= var68_54;
        } else {
            var47_36 = false;
            var45_34 = null;
        }
        var71_56 = var2_2 & var27_17;
        var68_54 = var71_56 == var16_11 ? 0 : (var71_56 < var16_11 ? -1 : 1);
        if (!var68_54) ** GOTO lbl-1000
        if (!var46_35) {
            var47_36 = false;
            var45_34 = null;
        }
        if (var68_54) {
            var71_56 = var47_36 != false ? 16384L : 8192L;
            var2_2 |= var71_56;
        }
        if (!var47_36) {
            var29_18 = 8;
            var30_19 = 1.1E-44f;
        } else lbl-1000:
        // 2 sources

        {
            var29_18 = 0;
            var30_19 = 0.0f;
            var31_20 = null;
        }
        var4_3 = var2_2 & var25_16;
        var74_58 = 0L;
        var47_36 = var4_3 == var74_58 ? 0 : (var4_3 < var74_58 ? -1 : 1);
        if (var47_36) {
            var1_1.a.setVisibility((int)var11_8);
            var45_34 = var1_1.e;
            var46_35 = false;
            u.n((TextView)var45_34, (String)var60_48, null, null);
            var45_34 = var1_1.f;
            var45_34.setVisibility(var53_40);
        }
        if (var47_36 = (cfr_temp_6 = (var4_3 = var2_2 & var27_17) - var74_58) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1)) {
            ImageViewBindingAdapter.setImageDrawable(var1_1.b, (Drawable)var52_39);
            var45_34 = var1_1.g;
            var45_34.setVisibility(var29_18);
        }
        if (var47_36 = (cfr_temp_7 = (var4_3 = var2_2 & var63_50) - var74_58) == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1)) {
            var1_1.b.setVisibility((int)var73_57);
            var1_1.c.setVisibility((int)var73_57);
            var1_1.d.setVisibility((int)var73_57);
            var1_1.e.setVisibility((int)var73_57);
            var45_34 = var1_1.h;
            var45_34.setVisibility((int)var73_57);
        }
        if ((var73_57 = (cfr_temp_8 = (var4_3 = var2_2 & var20_13) - (var76_59 = 0L)) == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1)) != false) {
            var6_4 /* !! */  = var1_1.c;
            var47_36 = false;
            var45_34 = null;
            u.n((TextView)var6_4 /* !! */ , (String)var36_25, null, null);
        }
        if ((var73_57 = (cfr_temp_9 = (var4_3 = var2_2 & var18_12) - var76_59) == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1)) != false) {
            var6_4 /* !! */  = var1_1.d;
            SeekBarBindingAdapter.setProgress((SeekBar)var6_4 /* !! */ , var58_45);
        }
        if ((var73_57 = (cfr_temp_10 = (var2_2 &= var61_49) - var76_59) == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1)) != false) {
            var6_4 /* !! */  = var1_1.h;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var6_4 /* !! */ , (Drawable)var7_5);
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
                    n12 = 3;
                    if (n10 != n12) {
                        n12 = 4;
                        if (n10 != n12) {
                            return false;
                        }
                        object = (ObservableBoolean)object;
                        return this.F((ObservableBoolean)object, n11);
                    }
                    object = (ObservableBoolean)object;
                    return this.E((ObservableBoolean)object, n11);
                }
                object = (ObservableInt)object;
                return this.I((ObservableInt)object, n11);
            }
            object = (ObservableBoolean)object;
            return this.H((ObservableBoolean)object, n11);
        }
        object = (ObservableInt)object;
        return this.G((ObservableInt)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 116;
        if (n11 == n10) {
            object = (AlbumSection)object;
            this.D((AlbumSection)object);
            return 1 != 0;
        } else {
            n11 = 100;
            if (n11 == n10) {
                object = (ObservableBoolean)object;
                this.B((ObservableBoolean)object);
                return 1 != 0;
            } else {
                n11 = 106;
                if (n11 != n10) return 0 != 0;
                object = (ObservableBoolean)object;
                this.C((ObservableBoolean)object);
            }
        }
        return 1 != 0;
    }
}

