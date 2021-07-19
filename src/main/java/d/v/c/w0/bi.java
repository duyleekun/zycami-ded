/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckedTextView
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.camera.story.review.StoryReviewViewModel;
import com.zhiyun.cama.camera.widget.StoryProgressBar;
import com.zhiyun.cama.camera.widget.StoryProgressBar$a;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import com.zhiyun.editorsdk.fundation.PlayerWrapperView;
import d.v.c.d1.h;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.f1.a.n;
import d.v.c.f1.a.n$a;
import d.v.c.s0.h7.s0.y$b;
import d.v.c.w0.ai;
import d.v.c.z1.e;

public class bi
extends ai
implements b$a,
n$a {
    private static final ViewDataBinding$IncludedLayouts B;
    private static final SparseIntArray C;
    private long A;
    private final ConstraintLayout r;
    private final View s;
    private final CheckedTextView t;
    private final CheckedTextView u;
    private final View.OnClickListener v;
    private final StoryProgressBar$a w;
    private final View.OnClickListener x;
    private final View.OnClickListener y;
    private final View.OnClickListener z;

    static {
        SparseIntArray sparseIntArray;
        C = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363201, 6);
        sparseIntArray.put(2131363200, 7);
        sparseIntArray.put(2131362152, 8);
        sparseIntArray.put(2131363633, 9);
        sparseIntArray.put(2131363087, 10);
        sparseIntArray.put(2131363428, 11);
        sparseIntArray.put(2131363072, 12);
        sparseIntArray.put(2131363565, 13);
        sparseIntArray.put(2131363695, 14);
        sparseIntArray.put(2131363460, 15);
    }

    public bi(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = B;
        SparseIntArray sparseIntArray = C;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 16, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private bi(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        View view2;
        Object object;
        Object object2 = object = objectArray[8];
        object2 = (View)object;
        Object object3 = object = objectArray[1];
        object3 = (ImageView)object;
        Object object4 = object = objectArray[12];
        object4 = (RecyclerView)object;
        Object object5 = object = objectArray[10];
        object5 = (RecyclerView)object;
        Object object6 = object = objectArray[7];
        object6 = (FrameLayout)object;
        Object object7 = object = objectArray[6];
        object7 = (PlayerWrapperView)((Object)object);
        Object object8 = object = objectArray[2];
        object8 = (StoryProgressBar)object;
        Object object9 = object = objectArray[11];
        object9 = (TextView)object;
        Object object10 = object = objectArray[15];
        object10 = (TextView)object;
        Object object11 = object = objectArray[13];
        object11 = (TextView)object;
        Object object12 = object = objectArray[9];
        object12 = (TextView)object;
        Object object13 = object = objectArray[14];
        object13 = (View)object;
        object = this;
        Object object14 = dataBindingComponent;
        super(dataBindingComponent, view, 1, (View)object2, (ImageView)object3, (RecyclerView)object4, (RecyclerView)object5, (FrameLayout)object6, (PlayerWrapperView)((Object)object7), (StoryProgressBar)object8, (TextView)object9, (TextView)object10, (TextView)object11, (TextView)object12, (View)object13);
        this.A = -1;
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.r = object;
        object.setTag(null);
        int n10 = 3;
        this.s = view2 = (View)objectArray[n10];
        view2.setTag(null);
        int n11 = 4;
        object2 = (CheckedTextView)objectArray[n11];
        this.t = object2;
        object2.setTag(null);
        int n12 = 5;
        object3 = (CheckedTextView)objectArray[n12];
        this.u = object3;
        object3.setTag(null);
        this.g.setTag(null);
        object14 = view;
        this.setRootTag(view);
        object14 = new b(this, n11);
        this.v = object14;
        this.w = object14 = new n(this, 2);
        object14 = new b(this, n12);
        this.x = object14;
        object14 = new b(this, 1);
        this.y = object14;
        object14 = new b(this, n10);
        this.z = object14;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean I(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.A;
                long l11 = 1L;
                this.A = l10 |= l11;
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
    public void D(y$b y$b) {
        this.m = y$b;
        synchronized (this) {
            long l10 = this.A;
            long l11 = 4;
            this.A = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    public void E(h h10) {
        this.o = h10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(TemplateEditViewModel templateEditViewModel) {
        this.q = templateEditViewModel;
        synchronized (this) {
            long l10 = this.A;
            long l11 = 16;
            this.A = l10 |= l11;
        }
        this.notifyPropertyChanged(136);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void G(StoryReviewViewModel storyReviewViewModel) {
        this.n = storyReviewViewModel;
        synchronized (this) {
            long l10 = this.A;
            long l11 = 32;
            this.A = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public void H(e e10) {
        this.p = e10;
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 3;
            if (n10 != n13) {
                n13 = 4;
                if (n10 != n13) {
                    n13 = 5;
                    if (n10 == n13) {
                        y$b y$b = this.m;
                        if (y$b != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            y$b.c(view, n12);
                        }
                    }
                } else {
                    y$b y$b = this.m;
                    if (y$b == null) {
                        n12 = 0;
                    }
                    if (n12 != 0) {
                        y$b.c(view, 0);
                    }
                }
            } else {
                y$b y$b = this.m;
                if (y$b != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    y$b.b();
                }
            }
        } else {
            TemplateEditViewModel templateEditViewModel = this.q;
            if (templateEditViewModel != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                templateEditViewModel.W0();
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
        synchronized (this) {
            var1_1 = this.A;
            this.A = var3_2 = 0L;
        }
        var5_3 = this.q;
        var6_4 = this.n;
        var7_5 = 81;
        var9_6 = var1_1 & var7_5;
        var11_7 = var9_6 == var3_2 ? 0 : (var9_6 < var3_2 ? -1 : 1);
        var12_8 = false;
        if (var11_7 == false) ** GOTO lbl-1000
        var13_9 = false;
        var14_10 = null;
        if (var5_3 != null) {
            var5_3 = var5_3.V();
        } else {
            var15_11 = 0;
            var5_3 = null;
        }
        this.updateLiveDataRegistration(0, (LiveData)var5_3);
        if (var5_3 != null) {
            var14_10 = var5_3 = var5_3.getValue();
            var14_10 = (Boolean)var5_3;
        }
        var15_11 = ViewDataBinding.safeUnbox(var14_10);
        if (var11_7 != false) {
            var16_12 = var15_11 != 0 ? 256L : 128L;
            var1_1 |= var16_12;
        }
        if (var15_11 != 0) {
            var15_11 = 8;
        } else lbl-1000:
        // 2 sources

        {
            var15_11 = 0;
            var5_3 = null;
        }
        var16_12 = (long)96 & var1_1;
        var11_7 = var16_12 == var3_2 ? 0 : (var16_12 < var3_2 ? -1 : 1);
        if (var11_7 != false && var6_4 != null) {
            var12_8 = var6_4.t();
            var18_13 = var6_4.u();
            var19_14 = var12_8;
            var12_8 = var18_13;
            var18_13 = var19_14;
        } else {
            var18_13 = false;
            var6_4 = null;
        }
        var16_12 = (long)64 & var1_1;
        var13_9 = var16_12 == var3_2 ? 0 : (var16_12 < var3_2 ? -1 : 1);
        if (var13_9) {
            var14_10 = this.b;
            var20_15 /* !! */  = this.y;
            var14_10.setOnClickListener(var20_15 /* !! */ );
            var14_10 = this.s;
            var20_15 /* !! */  = this.z;
            var14_10.setOnClickListener(var20_15 /* !! */ );
            var14_10 = this.t;
            var20_15 /* !! */  = this.v;
            var14_10.setOnClickListener(var20_15 /* !! */ );
            var14_10 = this.u;
            var20_15 /* !! */  = this.x;
            var14_10.setOnClickListener(var20_15 /* !! */ );
            var14_10 = this.g;
            var20_15 /* !! */  = this.w;
            var14_10.setOnStoryItemClickListener((StoryProgressBar$a)var20_15 /* !! */ );
        }
        if ((var21_16 = (cfr_temp_0 = (var1_1 &= var7_5) - var3_2) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false) {
            var22_17 = this.b;
            var22_17.setVisibility(var15_11);
        }
        if (var11_7 != false) {
            this.t.setChecked(var12_8);
            var22_17 = this.u;
            var22_17.setChecked(var18_13);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.A;
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
            this.A = l10 = (long)64;
        }
        this.requestRebind();
    }

    public final void k(int n10, int n11) {
        y$b y$b = this.m;
        boolean bl2 = y$b != null;
        if (bl2) {
            y$b.i(n11);
        }
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (MutableLiveData)object;
        return this.I((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 156;
        if (n11 == n10) {
            object = (e)object;
            this.H((e)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 == n10) {
                object = (y$b)object;
                this.D((y$b)object);
                return 1 != 0;
            } else {
                n11 = 53;
                if (n11 == n10) {
                    object = (h)object;
                    this.E((h)object);
                    return 1 != 0;
                } else {
                    n11 = 136;
                    if (n11 == n10) {
                        object = (TemplateEditViewModel)object;
                        this.F((TemplateEditViewModel)object);
                        return 1 != 0;
                    } else {
                        n11 = 152;
                        if (n11 != n10) return 0 != 0;
                        object = (StoryReviewViewModel)object;
                        this.G((StoryReviewViewModel)object);
                    }
                }
            }
        }
        return 1 != 0;
    }
}

