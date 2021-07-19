/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageButton
 *  android.widget.LinearLayout
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import com.zhiyun.cama.main.EditorMainFragment$g;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.i1.h2;
import d.v.c.w0.p4;

public class q4
extends p4
implements b$a {
    private static final ViewDataBinding$IncludedLayouts k;
    private static final SparseIntArray l;
    private final LinearLayout c;
    private final ImageButton d;
    private final ImageButton e;
    private final ImageButton f;
    private final View.OnClickListener g;
    private final View.OnClickListener h;
    private final View.OnClickListener i;
    private long j;

    public q4(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = k;
        SparseIntArray sparseIntArray = l;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private q4(DataBindingComponent object, View object2, Object[] imageButton) {
        ImageButton imageButton2;
        int n10 = 1;
        super(object, (View)object2, n10);
        this.j = -1;
        object = (LinearLayout)imageButton[0];
        this.c = object;
        object.setTag(null);
        object = (ImageButton)imageButton[n10];
        this.d = object;
        object.setTag(null);
        int n11 = 2;
        this.e = imageButton2 = (ImageButton)imageButton[n11];
        imageButton2.setTag(null);
        int n12 = 3;
        this.f = imageButton = (ImageButton)imageButton[n12];
        imageButton.setTag(null);
        this.setRootTag((View)object2);
        super(this, n11);
        this.g = object2;
        object = new b(this, n10);
        this.h = object;
        object = new b(this, n12);
        this.i = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.j;
                long l11 = 1L;
                this.j = l10 |= l11;
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
    public void A(EditorMainFragment$g editorMainFragment$g) {
        this.a = editorMainFragment$g;
        synchronized (this) {
            long l10 = this.j;
            long l11 = 4;
            this.j = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(h2 h22) {
        this.b = h22;
        synchronized (this) {
            long l10 = this.j;
            long l11 = 2;
            this.j = l10 |= l11;
        }
        this.notifyPropertyChanged(48);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 == n13) {
                    EditorMainFragment$g editorMainFragment$g = this.a;
                    if (editorMainFragment$g != null) {
                        n11 = n12;
                    }
                    if (n11) {
                        editorMainFragment$g.H();
                    }
                }
            } else {
                EditorMainFragment$g editorMainFragment$g = this.a;
                if (editorMainFragment$g != null) {
                    n11 = n12;
                }
                if (n11) {
                    editorMainFragment$g.E();
                }
            }
        } else {
            EditorMainFragment$g editorMainFragment$g = this.a;
            if (editorMainFragment$g != null) {
                n11 = n12;
            }
            if (n11) {
                editorMainFragment$g.c(n12 != 0);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        ImageButton imageButton;
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        synchronized (this) {
            l14 = this.j;
            this.j = l13 = 0L;
        }
        Object object = this.b;
        long l15 = (long)11 & l14;
        long l16 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1);
        boolean bl2 = false;
        if (l16 != false) {
            Object object2 = null;
            object = object != null ? ((h2)object).L() : null;
            this.updateLiveDataRegistration(0, (LiveData)object);
            if (object != null) {
                object2 = object = ((LiveData)object).getValue();
                object2 = (Boolean)object;
            }
            bl2 = ViewDataBinding.safeUnbox(object2);
        }
        if ((l12 = (l11 = (l14 &= (l10 = (long)8)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            imageButton = this.d;
            View.OnClickListener onClickListener = this.h;
            imageButton.setOnClickListener(onClickListener);
            imageButton = this.e;
            onClickListener = this.g;
            imageButton.setOnClickListener(onClickListener);
            imageButton = this.f;
            onClickListener = this.i;
            imageButton.setOnClickListener(onClickListener);
        }
        if (l16 != false) {
            imageButton = this.e;
            imageButton.setEnabled(bl2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.j;
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
            this.j = l10 = (long)8;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (LiveData)object;
        return this.C((LiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 48;
        if (n11 == n10) {
            object = (h2)object;
            this.B((h2)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 != n10) return 0 != 0;
            object = (EditorMainFragment$g)object;
            this.A((EditorMainFragment$g)object);
        }
        return 1 != 0;
    }
}

