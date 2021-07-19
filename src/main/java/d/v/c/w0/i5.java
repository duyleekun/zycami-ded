/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.text.Editable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter$AfterTextChanged;
import d.v.c.f1.a.a;
import d.v.c.f1.a.a$a;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.m1.d.o$b;
import d.v.c.w0.h5;

public class i5
extends h5
implements b$a,
a$a {
    private static final ViewDataBinding$IncludedLayouts s;
    private static final SparseIntArray t;
    private final ConstraintLayout m;
    private final View.OnClickListener n;
    private final TextViewBindingAdapter$AfterTextChanged o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;
    private long r;

    static {
        SparseIntArray sparseIntArray;
        t = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362553, 5);
        sparseIntArray.put(2131362505, 6);
        sparseIntArray.put(2131363608, 7);
        sparseIntArray.put(2131362478, 8);
        sparseIntArray.put(2131362891, 9);
        sparseIntArray.put(2131362278, 10);
        sparseIntArray.put(2131363671, 11);
    }

    public i5(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = s;
        SparseIntArray sparseIntArray = t;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 12, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private i5(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[10];
        object2 = (View)object;
        Object object3 = object = objectArray[1];
        object3 = (EditText)object;
        Object object4 = object = objectArray[8];
        object4 = (FrameLayout)object;
        Object object5 = object = objectArray[6];
        object5 = (View)object;
        Object object6 = object = objectArray[5];
        object6 = (Guideline)((Object)object);
        Object object7 = object = objectArray[9];
        object7 = (TextView)object;
        Object object8 = object = objectArray[3];
        object8 = (Button)object;
        Object object9 = object = objectArray[4];
        object9 = (Button)object;
        Object object10 = object = objectArray[7];
        object10 = (TextView)object;
        Object object11 = object = objectArray[11];
        object11 = (View)object;
        Object object12 = object = objectArray[2];
        object12 = (View)object;
        object = this;
        super(dataBindingComponent, view, 0, (View)object2, (EditText)object3, (FrameLayout)object4, (View)object5, (Guideline)((Object)object6), (TextView)object7, (Button)object8, (Button)object9, (TextView)object10, (View)object11, (View)object12);
        this.r = -1;
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.m = object;
        object.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.k.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, 2);
        this.n = object;
        object = new a(this, 1);
        this.o = object;
        object = new b(this, 4);
        this.p = object;
        object = new b(this, 3);
        this.q = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        int n11 = 2;
        boolean bl2 = true;
        if (n10 != n11) {
            n11 = 3;
            if (n10 != n11) {
                n11 = 4;
                if (n10 == n11) {
                    o$b o$b = this.l;
                    if (o$b == null) {
                        bl2 = false;
                    }
                    if (bl2) {
                        o$b.d();
                    }
                }
            } else {
                o$b o$b = this.l;
                if (o$b == null) {
                    bl2 = false;
                }
                if (bl2) {
                    o$b.c();
                }
            }
        } else {
            o$b o$b = this.l;
            if (o$b == null) {
                bl2 = false;
            }
            if (bl2) {
                o$b.b();
            }
        }
    }

    public final void b(int n10, Editable editable) {
        o$b o$b = this.l;
        boolean bl2 = o$b != null;
        if (bl2) {
            o$b.a();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        synchronized (this) {
            long l11 = this.r;
            this.r = l10 = 0L;
        }
        long l12 = 2;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            EditText editText = this.b;
            TextViewBindingAdapter$AfterTextChanged textViewBindingAdapter$AfterTextChanged = this.o;
            TextViewBindingAdapter.setTextWatcher((TextView)editText, null, null, textViewBindingAdapter$AfterTextChanged, null);
            editText = this.g;
            textViewBindingAdapter$AfterTextChanged = this.q;
            editText.setOnClickListener((View.OnClickListener)textViewBindingAdapter$AfterTextChanged);
            editText = this.h;
            textViewBindingAdapter$AfterTextChanged = this.p;
            editText.setOnClickListener((View.OnClickListener)textViewBindingAdapter$AfterTextChanged);
            editText = this.k;
            textViewBindingAdapter$AfterTextChanged = this.n;
            editText.setOnClickListener((View.OnClickListener)textViewBindingAdapter$AfterTextChanged);
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
            this.r = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (o$b)object;
            this.z((o$b)object);
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
    public void z(o$b o$b) {
        this.l = o$b;
        synchronized (this) {
            long l10 = this.r;
            long l11 = 1L;
            this.r = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }
}

