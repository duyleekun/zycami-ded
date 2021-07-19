/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.main.me.edit.EditProfileFragment$e;
import d.v.c.f1.a.b$a;
import d.v.c.w0.ie;
import d.v.c.w0.je$a;
import d.v.c.w0.je$b;
import d.v.c.w0.je$c;
import d.v.c.w0.je$d;

public class je
extends ie
implements b$a {
    private static final ViewDataBinding$IncludedLayouts x;
    private static final SparseIntArray y;
    private final ConstraintLayout q;
    private final View.OnClickListener r;
    private je$d s;
    private je$a t;
    private je$b u;
    private je$c v;
    private long w;

    static {
        SparseIntArray sparseIntArray;
        y = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362498, 6);
        sparseIntArray.put(2131363549, 7);
        sparseIntArray.put(2131362626, 8);
        sparseIntArray.put(2131363514, 9);
        sparseIntArray.put(2131362379, 10);
        sparseIntArray.put(2131363573, 11);
        sparseIntArray.put(2131363397, 12);
        sparseIntArray.put(2131363479, 13);
        sparseIntArray.put(2131362373, 14);
        sparseIntArray.put(2131363485, 15);
    }

    public je(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = x;
        SparseIntArray sparseIntArray = y;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 16, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private je(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object = this;
        EditText editText = (EditText)objectArray[14];
        EditText editText2 = (EditText)objectArray[10];
        FrameLayout frameLayout = (FrameLayout)objectArray[6];
        ImageView imageView = (ImageView)objectArray[3];
        TextView textView = (TextView)objectArray[8];
        ImageView imageView2 = (ImageView)objectArray[1];
        TextView textView2 = (TextView)objectArray[5];
        TextView textView3 = (TextView)objectArray[12];
        TextView textView4 = (TextView)objectArray[13];
        TextView textView5 = (TextView)objectArray[15];
        TextView textView6 = (TextView)objectArray[9];
        TextView textView7 = (TextView)objectArray[7];
        TextView textView8 = (TextView)objectArray[4];
        TextView textView9 = (TextView)objectArray[11];
        TextView textView10 = (TextView)objectArray[2];
        super(dataBindingComponent, view, 0, editText, editText2, frameLayout, imageView, textView, imageView2, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
        this.w = -1;
        this.d.setTag(null);
        this.f.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.q = object;
        object.setTag(null);
        this.g.setTag(null);
        this.m.setTag(null);
        this.o.setTag(null);
        object = view;
        this.setRootTag(view);
        super(this, 1);
        this.r = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        EditProfileFragment$e editProfileFragment$e = this.p;
        boolean bl2 = editProfileFragment$e != null;
        if (bl2) {
            editProfileFragment$e.e(view);
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
        je$b je$b;
        je$a je$a;
        long l13;
        long l14;
        synchronized (this) {
            l14 = this.w;
            this.w = l13 = 0L;
        }
        Object object = this.p;
        long l15 = (long)3 & l14;
        long l16 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1);
        Object object2 = null;
        if (l16 != false && object != null) {
            object2 = this.s;
            if (object2 == null) {
                object2 = new je$d();
                this.s = object2;
            }
            object2 = ((je$d)object2).b((EditProfileFragment$e)object);
            je$a = this.t;
            if (je$a == null) {
                this.t = je$a = new je$a();
            }
            je$a = je$a.b((EditProfileFragment$e)object);
            je$b = this.u;
            if (je$b == null) {
                this.u = je$b = new je$b();
            }
            je$b = je$b.b((EditProfileFragment$e)object);
            je$c je$c = this.v;
            if (je$c == null) {
                this.v = je$c = new je$c();
            }
            object = je$c.b((EditProfileFragment$e)object);
            je$d je$d = object2;
            object2 = object;
            object = je$d;
        } else {
            object = null;
            je$a = null;
            je$b = null;
        }
        if (l16 != false) {
            this.d.setOnClickListener((View.OnClickListener)object2);
            this.g.setOnClickListener((View.OnClickListener)je$a);
            TextView textView = this.m;
            textView.setOnClickListener((View.OnClickListener)object);
            object = this.o;
            object.setOnClickListener((View.OnClickListener)je$b);
        }
        if ((l12 = (l11 = (l14 &= (l10 = (long)2)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            ImageView imageView = this.f;
            View.OnClickListener onClickListener = this.r;
            imageView.setOnClickListener(onClickListener);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.w;
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
            this.w = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (EditProfileFragment$e)object;
            this.z((EditProfileFragment$e)object);
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
    public void z(EditProfileFragment$e editProfileFragment$e) {
        this.p = editProfileFragment$e;
        synchronized (this) {
            long l10 = this.w;
            long l11 = 1L;
            this.w = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

