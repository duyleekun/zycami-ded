/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.cama.ratio.EditorRatioFragment$a;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.j4;
import d.v.c.w0.j7;

public class k7
extends j7
implements b$a {
    private static final ViewDataBinding$IncludedLayouts G;
    private static final SparseIntArray H;
    private final View.OnClickListener A;
    private final View.OnClickListener B;
    private final View.OnClickListener C;
    private final View.OnClickListener D;
    private final View.OnClickListener E;
    private long F;
    private final ConstraintLayout q;
    private final View r;
    private final View s;
    private final View t;
    private final View u;
    private final View v;
    private final View w;
    private final View x;
    private final View.OnClickListener y;
    private final View.OnClickListener z;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        G = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(23);
        String[] stringArray = new String[]{"editor_bottom_choice_layout"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 8;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558529;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        H = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131362128, 9);
        viewDataBinding$IncludedLayouts.put(2131362129, 10);
        viewDataBinding$IncludedLayouts.put(2131362102, 11);
        viewDataBinding$IncludedLayouts.put(2131362103, 12);
        viewDataBinding$IncludedLayouts.put(2131362110, 13);
        viewDataBinding$IncludedLayouts.put(2131362111, 14);
        viewDataBinding$IncludedLayouts.put(2131362108, 15);
        viewDataBinding$IncludedLayouts.put(2131362109, 16);
        viewDataBinding$IncludedLayouts.put(2131362106, 17);
        viewDataBinding$IncludedLayouts.put(2131362107, 18);
        viewDataBinding$IncludedLayouts.put(2131362104, 19);
        viewDataBinding$IncludedLayouts.put(2131362105, 20);
        viewDataBinding$IncludedLayouts.put(2131362118, 21);
        viewDataBinding$IncludedLayouts.put(2131362119, 22);
    }

    public k7(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = G;
        SparseIntArray sparseIntArray = H;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 23, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private k7(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        k7 k72 = this;
        Object object = this;
        Object object2 = dataBindingComponent;
        Object object3 = (j4)objectArray[8];
        Object object4 = (CheckBox)objectArray[19];
        CheckBox checkBox = (CheckBox)objectArray[20];
        CheckBox checkBox2 = (CheckBox)objectArray[11];
        Object object5 = (CheckBox)objectArray[12];
        CheckBox checkBox3 = (CheckBox)objectArray[17];
        CheckBox checkBox4 = (CheckBox)objectArray[18];
        CheckBox checkBox5 = (CheckBox)objectArray[15];
        CheckBox checkBox6 = (CheckBox)objectArray[16];
        CheckBox checkBox7 = (CheckBox)objectArray[13];
        CheckBox checkBox8 = (CheckBox)objectArray[14];
        CheckBox checkBox9 = (CheckBox)objectArray[21];
        CheckBox checkBox10 = (CheckBox)objectArray[22];
        CheckBox checkBox11 = (CheckBox)objectArray[9];
        CheckBox checkBox12 = (CheckBox)objectArray[10];
        int n10 = 1;
        super(dataBindingComponent, view, n10, (j4)object3, (CheckBox)object4, checkBox, checkBox2, (CheckBox)object5, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11, checkBox12);
        this.F = -1;
        object = this.a;
        this.setContainedBinding((ViewDataBinding)object);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.q = object;
        object.setTag(null);
        int n11 = 1;
        object2 = (View)objectArray[n11];
        this.r = object2;
        object2.setTag((Object)"4");
        int n12 = 2;
        k72 = (View)objectArray[n12];
        this.s = k72;
        k72.setTag("0");
        n10 = 3;
        object3 = (View)objectArray[n10];
        this.t = object3;
        object3.setTag((Object)"1");
        int n13 = 4;
        object4 = (View)objectArray[n13];
        this.u = object4;
        object4.setTag((Object)"2");
        int n14 = 5;
        checkBox = (View)objectArray[n14];
        this.v = checkBox;
        checkBox.setTag((Object)"5");
        int n15 = 6;
        checkBox2 = (View)objectArray[n15];
        this.w = checkBox2;
        checkBox2.setTag((Object)"3");
        int n16 = 7;
        object5 = (View)objectArray[n16];
        this.x = object5;
        object5.setTag((Object)"6");
        object5 = view;
        this.setRootTag(view);
        super(this, n14);
        this.y = object5;
        super(this, n13);
        this.z = object4;
        object3 = new b(this, n16);
        this.A = object3;
        object3 = new b(this, n15);
        this.B = object3;
        object3 = new b(this, n12);
        this.C = object3;
        object2 = new b(this, n11);
        this.D = object2;
        super(this, n10);
        this.E = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean A(j4 j42, int n10) {
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

    public final void a(int n10, View view) {
        int n11 = 1;
        int n12 = 0;
        switch (n10) {
            default: {
                break;
            }
            case 7: {
                EditorRatioFragment$a editorRatioFragment$a = this.p;
                if (editorRatioFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                n11 = 6;
                editorRatioFragment$a.h(view, n11);
                break;
            }
            case 6: {
                EditorRatioFragment$a editorRatioFragment$a = this.p;
                if (editorRatioFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                n11 = 3;
                editorRatioFragment$a.h(view, n11);
                break;
            }
            case 5: {
                EditorRatioFragment$a editorRatioFragment$a = this.p;
                if (editorRatioFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                n11 = 5;
                editorRatioFragment$a.h(view, n11);
                break;
            }
            case 4: {
                EditorRatioFragment$a editorRatioFragment$a = this.p;
                if (editorRatioFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                n11 = 2;
                editorRatioFragment$a.h(view, n11);
                break;
            }
            case 3: {
                EditorRatioFragment$a editorRatioFragment$a = this.p;
                if (editorRatioFragment$a != null) {
                    n12 = n11;
                }
                if (n12 == 0) break;
                editorRatioFragment$a.h(view, n11);
                break;
            }
            case 2: {
                EditorRatioFragment$a editorRatioFragment$a = this.p;
                if (editorRatioFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                editorRatioFragment$a.h(view, 0);
                break;
            }
            case 1: {
                EditorRatioFragment$a editorRatioFragment$a = this.p;
                if (editorRatioFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                n11 = 4;
                editorRatioFragment$a.h(view, n11);
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
        long l14;
        synchronized (this) {
            l14 = this.F;
            this.F = l13 = 0L;
        }
        EditorRatioFragment$a editorRatioFragment$a = this.p;
        long l15 = (long)6 & l14;
        long l16 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1);
        if (l16 != false) {
            j4 j42 = this.a;
            j42.z(editorRatioFragment$a);
        }
        if ((l12 = (l11 = (l14 &= (l10 = (long)4)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            View view = this.r;
            View.OnClickListener onClickListener = this.D;
            view.setOnClickListener(onClickListener);
            view = this.s;
            onClickListener = this.C;
            view.setOnClickListener(onClickListener);
            view = this.t;
            onClickListener = this.E;
            view.setOnClickListener(onClickListener);
            view = this.u;
            onClickListener = this.z;
            view.setOnClickListener(onClickListener);
            view = this.v;
            onClickListener = this.y;
            view.setOnClickListener(onClickListener);
            view = this.w;
            onClickListener = this.B;
            view.setOnClickListener(onClickListener);
            view = this.x;
            onClickListener = this.A;
            view.setOnClickListener(onClickListener);
        }
        ViewDataBinding.executeBindingsOn(this.a);
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
            j4 j42 = this.a;
            l12 = (long)j42.hasPendingBindings();
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
            this.F = l10 = (long)4;
        }
        this.a.invalidateAll();
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (j4)object;
        return this.A((j4)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.a.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (EditorRatioFragment$a)object;
            this.z((EditorRatioFragment$a)object);
            n10 = 1;
        } else {
            n10 = 0;
        }
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void z(EditorRatioFragment$a editorRatioFragment$a) {
        this.p = editorRatioFragment$a;
        synchronized (this) {
            long l10 = this.F;
            long l11 = 2;
            this.F = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }
}

