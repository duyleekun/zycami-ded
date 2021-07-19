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
 *  android.widget.TextView
 */
package d.v.g0.t;

import android.text.Editable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter$AfterTextChanged;
import com.zhiyun.ui.R$id;
import d.v.g0.h;
import d.v.g0.k$c;
import d.v.g0.t.e;
import d.v.g0.u.a.a;
import d.v.g0.u.a.a$a;
import d.v.g0.u.a.b;
import d.v.g0.u.a.b$a;

public class f
extends e
implements b$a,
a$a {
    private static final ViewDataBinding$IncludedLayouts s;
    private static final SparseIntArray t;
    private final ConstraintLayout m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private final TextViewBindingAdapter$AfterTextChanged p;
    private final View.OnClickListener q;
    private long r;

    static {
        SparseIntArray sparseIntArray;
        t = sparseIntArray = new SparseIntArray();
        int n10 = R$id.guideline2;
        sparseIntArray.put(n10, 5);
        n10 = R$id.forehead;
        sparseIntArray.put(n10, 6);
        n10 = R$id.tv_title;
        sparseIntArray.put(n10, 7);
        n10 = R$id.fl_message_container;
        sparseIntArray.put(n10, 8);
        n10 = R$id.tv_message;
        sparseIntArray.put(n10, 9);
        n10 = R$id.tv_num_input;
        sparseIntArray.put(n10, 10);
        n10 = R$id.divider;
        sparseIntArray.put(n10, 11);
    }

    public f(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = s;
        SparseIntArray sparseIntArray = t;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 12, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private f(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[11];
        object2 = (View)object;
        Object object3 = object = objectArray[1];
        object3 = (EditText)object;
        Object object4 = object = objectArray[8];
        object4 = (ConstraintLayout)((Object)object);
        Object object5 = object = objectArray[6];
        object5 = (View)object;
        Object object6 = object = objectArray[5];
        object6 = (Guideline)((Object)object);
        Object object7 = object = objectArray[3];
        object7 = (Button)object;
        Object object8 = object = objectArray[4];
        object8 = (Button)object;
        Object object9 = object = objectArray[9];
        object9 = (TextView)object;
        Object object10 = object = objectArray[10];
        object10 = (TextView)object;
        Object object11 = object = objectArray[7];
        object11 = (TextView)object;
        Object object12 = object = objectArray[2];
        object12 = (View)object;
        object = this;
        super(dataBindingComponent, view, 0, (View)object2, (EditText)object3, (ConstraintLayout)((Object)object4), (View)object5, (Guideline)((Object)object6), (Button)object7, (Button)object8, (TextView)object9, (TextView)object10, (TextView)object11, (View)object12);
        this.r = -1;
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.m = object;
        object.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.k.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, 3);
        this.n = object;
        object = new b(this, 4);
        this.o = object;
        object = new a(this, 1);
        this.p = object;
        object = new b(this, 2);
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
                    k$c k$c = this.l;
                    if (k$c == null) {
                        bl2 = false;
                    }
                    if (bl2) {
                        k$c.d();
                    }
                }
            } else {
                k$c k$c = this.l;
                if (k$c == null) {
                    bl2 = false;
                }
                if (bl2) {
                    k$c.c();
                }
            }
        } else {
            k$c k$c = this.l;
            if (k$c == null) {
                bl2 = false;
            }
            if (bl2) {
                k$c.b();
            }
        }
    }

    public final void b(int n10, Editable editable) {
        k$c k$c = this.l;
        boolean bl2 = k$c != null;
        if (bl2) {
            k$c.a();
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
            TextViewBindingAdapter$AfterTextChanged textViewBindingAdapter$AfterTextChanged = this.p;
            TextViewBindingAdapter.setTextWatcher((TextView)editText, null, null, textViewBindingAdapter$AfterTextChanged, null);
            editText = this.f;
            textViewBindingAdapter$AfterTextChanged = this.n;
            editText.setOnClickListener((View.OnClickListener)textViewBindingAdapter$AfterTextChanged);
            editText = this.g;
            textViewBindingAdapter$AfterTextChanged = this.o;
            editText.setOnClickListener((View.OnClickListener)textViewBindingAdapter$AfterTextChanged);
            editText = this.k;
            textViewBindingAdapter$AfterTextChanged = this.q;
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
        int n11 = d.v.g0.h.z;
        if (n11 == n10) {
            object = (k$c)object;
            this.z((k$c)object);
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
    public void z(k$c k$c) {
        this.l = k$c;
        synchronized (this) {
            long l10 = this.r;
            long l11 = 1L;
            this.r = l10 |= l11;
        }
        int n10 = d.v.g0.h.z;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }
}

