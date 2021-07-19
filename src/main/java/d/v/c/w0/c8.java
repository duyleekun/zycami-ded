/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.zhiyun.cama.template.list.EditorTemplateListFragment$d;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.b8;

public class c8
extends b8
implements b$a {
    private static final ViewDataBinding$IncludedLayouts j;
    private static final SparseIntArray k;
    private final View.OnClickListener h;
    private long i;

    static {
        SparseIntArray sparseIntArray;
        k = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362842, 2);
        sparseIntArray.put(2131363238, 3);
        sparseIntArray.put(2131363708, 4);
        sparseIntArray.put(2131363278, 5);
    }

    public c8(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = j;
        SparseIntArray sparseIntArray = k;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private c8(DataBindingComponent object, View view, Object[] object2) {
        Object object3;
        int n10 = 1;
        Object object4 = object3 = object2[n10];
        object4 = (ImageView)object3;
        Object object5 = object3 = object2[0];
        object5 = (ConstraintLayout)((Object)object3);
        Object object6 = object3 = object2[2];
        object6 = (LinearLayout)object3;
        Object object7 = object3 = object2[3];
        object7 = (SwipeRefreshLayout)object3;
        Object object8 = object3 = object2[5];
        object8 = (TabLayout)((Object)object3);
        Object object9 = object2 = object2[4];
        object9 = (ViewPager)((Object)object2);
        super(object, view, 0, (ImageView)object4, (ConstraintLayout)((Object)object5), (LinearLayout)object6, (SwipeRefreshLayout)object7, (TabLayout)((Object)object8), (ViewPager)((Object)object9));
        this.i = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.setRootTag(view);
        object = new b(this, n10);
        this.h = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        EditorTemplateListFragment$d editorTemplateListFragment$d = this.g;
        boolean bl2 = editorTemplateListFragment$d != null;
        if (bl2) {
            editorTemplateListFragment$d.a();
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
            long l11 = this.i;
            this.i = l10 = 0L;
        }
        long l12 = 2;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            ImageView imageView = this.a;
            View.OnClickListener onClickListener = this.h;
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
            this.i = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (EditorTemplateListFragment$d)object;
            this.z((EditorTemplateListFragment$d)object);
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
    public void z(EditorTemplateListFragment$d editorTemplateListFragment$d) {
        this.g = editorTemplateListFragment$d;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 1L;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

