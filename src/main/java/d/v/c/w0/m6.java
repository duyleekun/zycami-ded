/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.draft.EditorDraftFragment$a;
import d.v.c.f1.a.b$a;
import d.v.c.w0.l6;
import d.v.f.e.a;

public class m6
extends l6
implements b$a {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private final ConstraintLayout f;
    private final View.OnClickListener g;
    private long h;

    static {
        SparseIntArray sparseIntArray;
        j = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363319, 3);
        sparseIntArray.put(2131363276, 4);
    }

    public m6(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private m6(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        int n10 = 1;
        Object object3 = object2 = objectArray[n10];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[2];
        object4 = (RecyclerView)object2;
        Object object5 = object2 = objectArray[4];
        object5 = (StatusView)((Object)object2);
        Object object6 = object2 = objectArray[3];
        object6 = (TextView)object2;
        super(object, view, 0, (ImageView)object3, (RecyclerView)object4, (StatusView)((Object)object5), (TextView)object6);
        this.h = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.f = object;
        object.setTag(null);
        this.b.setTag(null);
        this.setRootTag(view);
        super(this, n10);
        this.g = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        EditorDraftFragment$a editorDraftFragment$a = this.e;
        boolean bl2 = editorDraftFragment$a != null;
        if (bl2) {
            editorDraftFragment$a.a();
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
            long l11 = this.h;
            this.h = l10 = 0L;
        }
        long l12 = 2;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            Object object = this.a;
            View.OnClickListener onClickListener = this.g;
            object.setOnClickListener(onClickListener);
            object = this.b;
            boolean bl2 = true;
            d.v.f.e.a.a((RecyclerView)object, bl2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.h;
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
            this.h = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (EditorDraftFragment$a)object;
            this.z((EditorDraftFragment$a)object);
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
    public void z(EditorDraftFragment$a editorDraftFragment$a) {
        this.e = editorDraftFragment$a;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 1L;
            this.h = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

