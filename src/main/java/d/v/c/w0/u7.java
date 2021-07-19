/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.speed.EditorSpeedFragment$b;
import com.zhiyun.cama.widget.CurveView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.b5;
import d.v.c.w0.j4;
import d.v.c.w0.t7;
import d.v.f.e.a;
import l.a.q.g0.u;

public class u7
extends t7
implements b$a {
    private static final ViewDataBinding$IncludedLayouts o;
    private static final SparseIntArray p;
    private final ConstraintLayout k;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private long n;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        o = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(9);
        String[] stringArray = new String[]{"editor_reset_global_layout", "editor_bottom_choice_layout"};
        int n10 = 2;
        int[] nArray = new int[n10];
        nArray[0] = 5;
        nArray[1] = 6;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558538;
        nArray2[1] = 2131558529;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        p = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131363520, 7);
        viewDataBinding$IncludedLayouts.put(2131363512, 8);
    }

    public u7(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = o;
        SparseIntArray sparseIntArray = p;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 9, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private u7(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[6];
        object2 = (j4)object;
        Object object3 = object = objectArray[3];
        object3 = (CurveView)((Object)object);
        Object object4 = object = objectArray[5];
        object4 = (b5)object;
        Object object5 = object = objectArray[4];
        object5 = (RecyclerView)object;
        int n10 = 2;
        Object object6 = object = objectArray[n10];
        object6 = (TextView)object;
        Object object7 = object = objectArray[8];
        object7 = (TextView)object;
        Object object8 = object = objectArray[7];
        object8 = (TextView)object;
        int n11 = 1;
        Object object9 = object = objectArray[n11];
        object9 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 3, (j4)object2, (CurveView)((Object)object3), (b5)object4, (RecyclerView)object5, (TextView)object6, (TextView)object7, (TextView)object8, (TextView)object9);
        this.n = -1;
        object = this.a;
        this.setContainedBinding((ViewDataBinding)object);
        this.b.setTag(null);
        object = this.c;
        this.setContainedBinding((ViewDataBinding)object);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.k = object;
        object.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.h.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n10);
        this.l = object;
        object = new b(this, n11);
        this.m = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(j4 j42, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.n;
                long l11 = 4;
                this.n = l10 |= l11;
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
    private boolean D(b5 b52, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.n;
                long l11 = 1L;
                this.n = l10 |= l11;
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
                long l10 = this.n;
                long l11 = 2;
                this.n = l10 |= l11;
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
    public void A(EditorSpeedFragment$b editorSpeedFragment$b) {
        this.i = editorSpeedFragment$b;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 8;
            this.n = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(d.v.c.s1.u u10) {
        this.j = u10;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 16;
            this.n = l10 |= l11;
        }
        this.notifyPropertyChanged(126);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                EditorSpeedFragment$b editorSpeedFragment$b = this.i;
                if (editorSpeedFragment$b != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    editorSpeedFragment$b.h();
                }
            }
        } else {
            EditorSpeedFragment$b editorSpeedFragment$b = this.i;
            if (editorSpeedFragment$b != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                editorSpeedFragment$b.i();
            }
        }
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
        String string2;
        Context context;
        int n10;
        long l14;
        long l15;
        u7 u72 = this;
        synchronized (this) {
            l15 = this.n;
            this.n = l14 = 0L;
        }
        EditorSpeedFragment$b editorSpeedFragment$b = this.i;
        d.v.c.s1.u u10 = this.j;
        long l16 = 50;
        long l17 = l15 & l16;
        long l18 = l17 == l14 ? 0 : (l17 < l14 ? -1 : 1);
        boolean bl2 = true;
        int n11 = 0;
        if (l18 != false) {
            float f10;
            int n12;
            Object object;
            if (u10 != null) {
                object = u10.i();
            } else {
                n12 = 0;
                object = null;
                f10 = 0.0f;
            }
            u72.updateLiveDataRegistration((int)(bl2 ? 1 : 0), (LiveData)object);
            if (object != null) {
                object = (Integer)((LiveData)object).getValue();
            } else {
                n12 = 0;
                object = null;
                f10 = 0.0f;
            }
            n12 = ViewDataBinding.safeUnbox((Integer)object);
            if (u10 != null) {
                n10 = u10.l(n12);
            } else {
                n10 = 0;
                u10 = null;
            }
            if (l18 != false) {
                long l19;
                if (n10 != 0) {
                    l15 = l15 | 0x80L | 0x200L | 0x800L;
                    l19 = 8192L;
                } else {
                    l15 = l15 | (long)64 | 0x100L | 0x400L;
                    l19 = 4096L;
                }
                l15 |= l19;
            }
            l18 = 8;
            float f11 = 1.1E-44f;
            if (n10 != 0) {
                n12 = (int)l18;
                f10 = f11;
            } else {
                n12 = 0;
                object = null;
                f10 = 0.0f;
            }
            context = u72.h.getContext();
            int n13 = n10 != 0 ? 2131231226 : 2131231188;
            context = AppCompatResources.getDrawable(context, n13);
            string2 = n10 != 0 ? "@string/editor_speed_standard" : "@string/editor_speed_curve";
            if (n10 == 0) {
                n11 = (int)l18;
            }
            n10 = n11;
            n11 = n12;
        } else {
            n10 = 0;
            u10 = null;
            context = null;
            boolean bl3 = false;
            string2 = null;
        }
        long l20 = l15 & (long)40;
        l18 = l20 == l14 ? 0 : (l20 < l14 ? -1 : 1);
        if (l18 != false) {
            u72.a.z(editorSpeedFragment$b);
            b5 b52 = u72.c;
            b52.z(editorSpeedFragment$b);
        }
        if ((l13 = (l12 = (l16 &= l15) - l14) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            u72.b.setVisibility(n11);
            u72.d.setVisibility(n10);
            u72.e.setVisibility(n11);
            TextViewBindingAdapter.setDrawableStart(u72.h, (Drawable)context);
            editorSpeedFragment$b = u72.h;
            u.n((TextView)editorSpeedFragment$b, string2, null, null);
        }
        if ((l13 = (l11 = (l15 &= (l10 = (long)32)) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            d.v.f.e.a.a(u72.d, bl2);
            editorSpeedFragment$b = u72.e;
            View.OnClickListener onClickListener = u72.l;
            editorSpeedFragment$b.setOnClickListener(onClickListener);
            editorSpeedFragment$b = u72.h;
            onClickListener = u72.m;
            editorSpeedFragment$b.setOnClickListener(onClickListener);
        }
        ViewDataBinding.executeBindingsOn(u72.c);
        ViewDataBinding.executeBindingsOn(u72.a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.n;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            ViewDataBinding viewDataBinding = this.c;
            l12 = (long)viewDataBinding.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            viewDataBinding = this.a;
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
            this.n = l10 = (long)32;
        }
        this.c.invalidateAll();
        this.a.invalidateAll();
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
                object = (j4)object;
                return this.C((j4)object, n11);
            }
            object = (MutableLiveData)object;
            return this.E((MutableLiveData)object, n11);
        }
        object = (b5)object;
        return this.D((b5)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.c.setLifecycleOwner(lifecycleOwner);
        this.a.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (EditorSpeedFragment$b)object;
            this.A((EditorSpeedFragment$b)object);
            return 1 != 0;
        } else {
            n11 = 126;
            if (n11 != n10) return 0 != 0;
            object = (d.v.c.s1.u)object;
            this.B((d.v.c.s1.u)object);
        }
        return 1 != 0;
    }
}

