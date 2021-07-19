/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.zhiyun.account.widget.StatusView;
import d.v.c.w0.b0;

public class c0
extends b0 {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private long h;

    static {
        SparseIntArray sparseIntArray;
        j = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362498, 2);
        sparseIntArray.put(2131362773, 3);
        sparseIntArray.put(2131363615, 4);
        sparseIntArray.put(2131363234, 5);
        sparseIntArray.put(2131363145, 6);
    }

    public c0(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private c0(DataBindingComponent dataBindingComponent, View view, Object[] object) {
        Object object2;
        Object object3 = object2 = object[2];
        object3 = (FrameLayout)object2;
        Object object4 = object2 = object[3];
        object4 = (ImageView)object2;
        Object object5 = object2 = object[0];
        object5 = (LinearLayout)object2;
        Object object6 = object2 = object[6];
        object6 = (RecyclerView)object2;
        Object object7 = object2 = object[5];
        object7 = (SwipeRefreshLayout)object2;
        Object object8 = object2 = object[1];
        object8 = (StatusView)((Object)object2);
        object = object[4];
        TextView textView = object;
        textView = (TextView)object;
        super(dataBindingComponent, view, 0, (FrameLayout)object3, (ImageView)object4, (LinearLayout)object5, (RecyclerView)object6, (SwipeRefreshLayout)object7, (StatusView)((Object)object8), textView);
        this.h = -1;
        this.c.setTag(null);
        this.f.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
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
        long l12 = 1L;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            StatusView statusView = this.f;
            Context context = statusView.getContext();
            int n10 = 2131231806;
            context = AppCompatResources.getDrawable(context, n10);
            statusView.setErrorImage((Drawable)context);
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
            this.h = l10 = 1L;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        return true;
    }
}

