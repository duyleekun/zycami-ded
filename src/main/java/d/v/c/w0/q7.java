/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
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
import com.zhiyun.cama.rotate.EditorRotateFragment$a;
import com.zhiyun.cama.widget.HorizontalScrollView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.p1.e;
import d.v.c.w0.b5;
import d.v.c.w0.j4;
import d.v.c.w0.p7;
import l.a.q.g0.u;

public class q7
extends p7
implements b$a {
    private static final ViewDataBinding$IncludedLayouts r;
    private static final SparseIntArray s;
    private final ConstraintLayout k;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private long q;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        r = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(9);
        String[] stringArray = new String[]{"editor_reset_global_layout", "editor_bottom_choice_layout"};
        int n10 = 2;
        int[] nArray = new int[n10];
        nArray[0] = 6;
        nArray[1] = 7;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558538;
        nArray2[1] = 2131558529;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        s = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131362564, 8);
    }

    public q7(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = r;
        SparseIntArray sparseIntArray = s;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 9, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private q7(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[7];
        object2 = (j4)object;
        Object object3 = object = objectArray[6];
        object3 = (b5)object;
        Object object4 = object = objectArray[8];
        object4 = (HorizontalScrollView)((Object)object);
        int n10 = 5;
        Object object5 = object = objectArray[n10];
        object5 = (ImageView)object;
        Object object6 = object = objectArray[3];
        object6 = (ImageView)object;
        Object object7 = object = objectArray[2];
        object7 = (ImageView)object;
        int n11 = 4;
        Object object8 = object = objectArray[n11];
        object8 = (ImageView)object;
        int n12 = 1;
        Object object9 = object = objectArray[n12];
        object9 = (TextView)object;
        object = this;
        int n13 = n12;
        n12 = 3;
        super(dataBindingComponent, view, n12, (j4)object2, (b5)object3, (HorizontalScrollView)((Object)object4), (ImageView)object5, (ImageView)object6, (ImageView)object7, (ImageView)object8, (TextView)object9);
        this.q = -1;
        object = this.a;
        this.setContainedBinding((ViewDataBinding)object);
        object = this.b;
        this.setContainedBinding((ViewDataBinding)object);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.k = object;
        object.setTag(null);
        this.h.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n13);
        this.l = object;
        object = new b(this, n10);
        this.m = object;
        object = new b(this, n11);
        this.n = object;
        object = new b(this, 2);
        this.o = object;
        object = new b(this, 3);
        this.p = object;
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
                long l10 = this.q;
                long l11 = 4;
                this.q = l10 |= l11;
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
                long l10 = this.q;
                long l11 = 1L;
                this.q = l10 |= l11;
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
                long l10 = this.q;
                long l11 = 2;
                this.q = l10 |= l11;
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
    public void A(EditorRotateFragment$a editorRotateFragment$a) {
        this.i = editorRotateFragment$a;
        synchronized (this) {
            long l10 = this.q;
            long l11 = 8;
            this.q = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(e e10) {
        this.j = e10;
        synchronized (this) {
            long l10 = this.q;
            long l11 = 16;
            this.q = l10 |= l11;
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
                int n14 = 3;
                if (n10 != n14) {
                    n13 = 4;
                    if (n10 != n13) {
                        n13 = 5;
                        if (n10 == n13) {
                            EditorRotateFragment$a editorRotateFragment$a = this.i;
                            if (editorRotateFragment$a != null) {
                                n11 = n12;
                            }
                            if (n11 != 0) {
                                n11 = 90;
                                editorRotateFragment$a.j(n11);
                            }
                        }
                    } else {
                        EditorRotateFragment$a editorRotateFragment$a = this.i;
                        if (editorRotateFragment$a != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            n11 = -90;
                            editorRotateFragment$a.j(n11);
                        }
                    }
                } else {
                    EditorRotateFragment$a editorRotateFragment$a = this.i;
                    if (editorRotateFragment$a != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        editorRotateFragment$a.h(n13);
                    }
                }
            } else {
                EditorRotateFragment$a editorRotateFragment$a = this.i;
                if (editorRotateFragment$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    editorRotateFragment$a.h(n12);
                }
            }
        } else {
            EditorRotateFragment$a editorRotateFragment$a = this.i;
            if (editorRotateFragment$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                editorRotateFragment$a.i();
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
        b5 b52;
        String string2;
        long l14;
        int n10;
        long l15;
        long l16;
        synchronized (this) {
            l16 = this.q;
            this.q = l15 = 0L;
        }
        EditorRotateFragment$a editorRotateFragment$a = this.i;
        Object object = this.j;
        long l17 = 50;
        long l18 = l16 & l17;
        long l19 = l18 == l15 ? 0 : (l18 < l15 ? -1 : 1);
        if (l19 != false) {
            boolean bl2;
            if (object != null) {
                object = ((e)object).g();
            } else {
                bl2 = false;
                object = null;
            }
            n10 = 1;
            this.updateLiveDataRegistration(n10, (LiveData)object);
            if (object != null) {
                object = (Boolean)((LiveData)object).getValue();
            } else {
                bl2 = false;
                object = null;
            }
            bl2 = ViewDataBinding.safeUnbox((Boolean)object);
            if (l19 != false) {
                if (bl2) {
                    l16 |= 0x80L;
                    l14 = 512L;
                } else {
                    l16 |= (long)64;
                    l14 = 256L;
                }
                l16 |= l14;
            }
            string2 = bl2 ? "@string/edit_reduction" : "@string/edit_fast_adapter";
            if (bl2) {
                object = this.h.getContext();
                n10 = 2131231222;
            } else {
                object = this.h.getContext();
                n10 = 2131231175;
            }
            object = AppCompatResources.getDrawable((Context)object, n10);
        } else {
            boolean bl3 = false;
            object = null;
            l19 = 0;
            string2 = null;
        }
        l14 = (long)40 & l16;
        n10 = (int)(l14 == l15 ? 0 : (l14 < l15 ? -1 : 1));
        if (n10 != 0) {
            this.a.z(editorRotateFragment$a);
            b52 = this.b;
            b52.z(editorRotateFragment$a);
        }
        if ((l13 = (l12 = (l14 = (long)32 & l16) - l15) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            editorRotateFragment$a = this.d;
            b52 = this.m;
            editorRotateFragment$a.setOnClickListener((View.OnClickListener)b52);
            editorRotateFragment$a = this.e;
            b52 = this.p;
            editorRotateFragment$a.setOnClickListener((View.OnClickListener)b52);
            editorRotateFragment$a = this.f;
            b52 = this.o;
            editorRotateFragment$a.setOnClickListener((View.OnClickListener)b52);
            editorRotateFragment$a = this.g;
            b52 = this.n;
            editorRotateFragment$a.setOnClickListener((View.OnClickListener)b52);
            editorRotateFragment$a = this.h;
            b52 = this.l;
            editorRotateFragment$a.setOnClickListener((View.OnClickListener)b52);
        }
        if ((l11 = (l10 = (l16 &= l17) - l15) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            TextViewBindingAdapter.setDrawableStart(this.h, (Drawable)object);
            TextView textView = this.h;
            u.n(textView, string2, null, null);
        }
        ViewDataBinding.executeBindingsOn(this.b);
        ViewDataBinding.executeBindingsOn(this.a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.q;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            ViewDataBinding viewDataBinding = this.b;
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
            this.q = l10 = (long)32;
        }
        this.b.invalidateAll();
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
        this.b.setLifecycleOwner(lifecycleOwner);
        this.a.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (EditorRotateFragment$a)object;
            this.A((EditorRotateFragment$a)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 != n10) return 0 != 0;
            object = (e)object;
            this.B((e)object);
        }
        return 1 != 0;
    }
}

