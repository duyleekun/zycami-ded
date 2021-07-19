/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.HorizontalScrollView
 *  android.widget.RadioGroup
 */
package d.v.c.w0;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.RadioGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.decoration.sticker.EditorStickerFragment$b;
import d.v.c.w0.j4;
import d.v.c.w0.v7;

public class w7
extends v7 {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private final ConstraintLayout g;
    private long h;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        i = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(6);
        String[] stringArray = new String[]{"editor_bottom_choice_layout"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 2;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558529;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        j = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131362571, 3);
        viewDataBinding$IncludedLayouts.put(2131363104, 4);
        viewDataBinding$IncludedLayouts.put(2131363709, 5);
    }

    public w7(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private w7(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[2];
        object3 = (j4)object2;
        Object object4 = object2 = objectArray[3];
        object4 = (HorizontalScrollView)object2;
        Object object5 = object2 = objectArray[4];
        object5 = (RadioGroup)object2;
        Object object6 = object2 = objectArray[1];
        object6 = (StatusView)((Object)object2);
        Object object7 = object2 = objectArray[5];
        object7 = (ViewPager2)((Object)object2);
        super(object, view, 1, (j4)object3, (HorizontalScrollView)object4, (RadioGroup)object5, (StatusView)((Object)object6), (ViewPager2)((Object)object7));
        this.h = -1;
        object = this.a;
        this.setContainedBinding((ViewDataBinding)object);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.g = object;
        object.setTag(null);
        this.d.setTag(null);
        this.setRootTag(view);
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
                long l10 = this.h;
                long l11 = 1L;
                this.h = l10 |= l11;
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
    public void executeBindings() {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        synchronized (this) {
            l14 = this.h;
            this.h = l13 = 0L;
        }
        EditorStickerFragment$b editorStickerFragment$b = this.f;
        long l15 = (long)6 & l14;
        long l16 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1);
        if (l16 != false) {
            j4 j42 = this.a;
            j42.z(editorStickerFragment$b);
        }
        if ((l12 = (l11 = (l14 &= (l10 = (long)4)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            StatusView statusView = this.d;
            int n10 = ViewDataBinding.getColorFromResource((View)statusView, 2131099860);
            statusView.setBackgroundColor(n10);
            statusView = this.d;
            Object object = statusView.getContext();
            int n11 = 2131231805;
            object = AppCompatResources.getDrawable(object, n11);
            statusView.setErrorImage((Drawable)object);
            statusView = this.d;
            object = "@string/request_error";
            statusView.setErrorText((String)object);
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
            long l10 = this.h;
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
            this.h = l10 = (long)4;
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
            object = (EditorStickerFragment$b)object;
            this.z((EditorStickerFragment$b)object);
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
    public void z(EditorStickerFragment$b editorStickerFragment$b) {
        this.f = editorStickerFragment$b;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 2;
            this.h = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }
}

