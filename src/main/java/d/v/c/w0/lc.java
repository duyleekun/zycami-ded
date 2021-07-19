/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.c.s0.h7.m0;
import d.v.c.w0.kc;
import d.v.l.g.a;
import l.a.q.g0.u;

public class lc
extends kc {
    private static final ViewDataBinding$IncludedLayouts j;
    private static final SparseIntArray k;
    private final ConstraintLayout d;
    private final FrameLayout e;
    private final ImageView f;
    private final View g;
    private final TextView h;
    private long i;

    public lc(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = j;
        SparseIntArray sparseIntArray = k;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private lc(DataBindingComponent object, View view, Object[] objectArray) {
        int n10 = 1;
        super(object, view, n10);
        this.i = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.d = object;
        object.setTag(null);
        object = (FrameLayout)objectArray[n10];
        this.e = object;
        object.setTag(null);
        object = (ImageView)objectArray[2];
        this.f = object;
        object.setTag(null);
        object = (View)objectArray[3];
        this.g = object;
        object.setTag(null);
        object = (TextView)objectArray[4];
        this.h = object;
        object.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.i;
                long l11 = 1L;
                this.i = l10 |= l11;
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
    public void B(Integer n10) {
        this.c = n10;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 2;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(101);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(TemplateData templateData) {
        this.b = templateData;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 4;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(134);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(m0 m02) {
        this.a = m02;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 8;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        float f10;
        int n10;
        long l15;
        String string2;
        String string3;
        long l16;
        int n11;
        int n12;
        int n13;
        long l17;
        int n14;
        long l18;
        Object object;
        long l19;
        Object object2;
        Object object3;
        Integer n15;
        long l20;
        long l21;
        lc lc2;
        block35: {
            block34: {
                block33: {
                    long l22;
                    long l23;
                    long l24;
                    long l25;
                    lc2 = this;
                    synchronized (this) {
                        l21 = this.i;
                        this.i = l20 = 0L;
                    }
                    n15 = this.c;
                    object3 = this.b;
                    object2 = this.a;
                    l19 = (long)31 & l21;
                    object = l19 == l20 ? 0 : (l19 < l20 ? -1 : 1);
                    l18 = 1024L;
                    n14 = 1;
                    float f11 = Float.MIN_VALUE;
                    l17 = 22;
                    n13 = 0;
                    if (object != false && (object = (l25 = (l24 = l21 & l17) - l20) == 0L ? 0 : (l25 < 0L ? -1 : 1)) != false) {
                        long l26;
                        n12 = ViewDataBinding.safeUnbox(n15);
                        n11 = n12 == 0 ? n14 : 0;
                        n12 = n12 != 0 ? n14 : 0;
                        if (object != false) {
                            l16 = n11 != 0 ? 256L : 128L;
                            l21 |= l16;
                        }
                        if ((object = (l26 = (l16 = l21 & l17) - l20) == 0L ? 0 : (l26 < 0L ? -1 : 1)) != false) {
                            if (n12) {
                                l21 |= l18;
                            } else {
                                l16 = 512L;
                                l21 |= l16;
                            }
                        }
                    } else {
                        n12 = 0;
                        n11 = 0;
                    }
                    string2 = (object = (l23 = (l22 = l21 & (l16 = (long)20)) - l20) == 0L ? 0 : (l23 < 0L ? -1 : 1)) != false && object3 != null ? (string3 = ((TemplateData)object3).getCoverUrl()) : null;
                    l15 = 27;
                    long l27 = l21 & l15;
                    long l28 = l27 - l20;
                    object = l28 == 0L ? 0 : (l28 < 0L ? -1 : 1);
                    if (object != false) {
                        object2 = object2 != null ? ((m0)object2).l() : null;
                        lc2.updateLiveDataRegistration(0, (LiveData)object2);
                        object2 = object2 != null ? (Integer)((LiveData)object2).getValue() : null;
                        if (object2 == n15) {
                            n10 = n14;
                            f10 = f11;
                        } else {
                            n10 = 0;
                            n15 = null;
                            f10 = 0.0f;
                        }
                        if (object != false) {
                            if (n10) {
                                l21 |= (long)64;
                                l14 = 4096L;
                            } else {
                                l21 |= (long)32;
                                l14 = 2048L;
                            }
                            l21 |= l14;
                        }
                        if (n10) {
                            object2 = lc2.g.getContext();
                            object = 2131232124;
                            object2 = AppCompatResources.getDrawable((Context)object2, (int)object);
                        } else {
                            object2 = null;
                        }
                        if (n10) {
                            n10 = 1065353216;
                            f10 = 1.0f;
                        } else {
                            n10 = 0x3F000000;
                            f10 = 0.5f;
                        }
                    } else {
                        object2 = null;
                        n10 = 0;
                        f10 = 0.0f;
                        n15 = null;
                    }
                    l22 = l21 & 0x480L;
                    object = l22 == l20 ? 0 : (l22 < l20 ? -1 : 1);
                    if (object == false) break block33;
                    object3 = object3 != null ? ((TemplateData)object3).showTitle() : null;
                    l19 = l21 & l18;
                    long l29 = l19 - l20;
                    object = l29 == 0L ? 0 : (l29 < 0L ? -1 : 1);
                    if (object == false) break block34;
                    object = TextUtils.isEmpty((CharSequence)object3);
                    break block35;
                }
                object3 = null;
            }
            object = 0;
            string3 = null;
        }
        l18 = l21 & l17;
        long l30 = l18 == l20 ? 0 : (l18 < l20 ? -1 : 1);
        if (l30 != false) {
            if (n11) {
                object3 = "@string/story_personal";
            }
            if (!n12) {
                object = 0;
                string3 = null;
            }
            if (l30 != false) {
                l18 = object != false ? 16384L : 8192L;
                l21 |= l18;
            }
            if (object != false) {
                object = 4;
                n13 = object;
            }
        } else {
            object3 = null;
        }
        if ((object = (l13 = (l19 = (long)16 & l21) - l20) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false && (object = (Object)ViewDataBinding.getBuildSdkInt()) >= (l30 = (long)21)) {
            string3 = lc2.e;
            string3.setClipToOutline(n14 != 0);
        }
        if ((object = (l12 = (l19 = l21 & l15) - l20) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            object = ViewDataBinding.getBuildSdkInt();
            if (object >= (l30 = (long)11)) {
                lc2.f.setAlpha(f10);
                string3 = lc2.h;
                string3.setAlpha(f10);
            }
            n15 = lc2.g;
            ViewBindingAdapter.setBackground((View)n15, (Drawable)object2);
        }
        if (n10 = (l11 = (l14 = l21 & l16) - l20) == 0L ? 0 : (l11 < 0L ? -1 : 1)) {
            n15 = lc2.f;
            boolean bl2 = true;
            d.v.l.g.a.b((ImageView)n15, string2, null, null, 0, bl2, false, null, null, null);
        }
        if (n10 = (l10 = (l21 &= l17) - l20) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            lc2.h.setVisibility(n13);
            n15 = lc2.h;
            u.n((TextView)n15, (String)object3, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.i;
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
            this.i = l10 = (long)16;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (LiveData)object;
        return this.E((LiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 101;
        if (n11 == n10) {
            object = (Integer)object;
            this.B((Integer)object);
            return 1 != 0;
        } else {
            n11 = 134;
            if (n11 == n10) {
                object = (TemplateData)object;
                this.C((TemplateData)object);
                return 1 != 0;
            } else {
                n11 = 152;
                if (n11 != n10) return 0 != 0;
                object = (m0)object;
                this.D((m0)object);
            }
        }
        return 1 != 0;
    }
}

