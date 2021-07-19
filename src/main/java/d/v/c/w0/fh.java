/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.story.video.StoryReviewVideoView;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.h7.q0.x$a;
import d.v.c.s0.h7.q0.z;
import d.v.c.w0.eh;

public class fh
extends eh
implements b$a {
    private static final ViewDataBinding$IncludedLayouts r;
    private static final SparseIntArray s;
    private final ConstraintLayout m;
    private final ImageView n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private long q;

    static {
        SparseIntArray sparseIntArray;
        s = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363568, 4);
        sparseIntArray.put(2131363683, 5);
        sparseIntArray.put(2131363423, 6);
        sparseIntArray.put(2131363595, 7);
        sparseIntArray.put(2131363594, 8);
        sparseIntArray.put(2131363676, 9);
        sparseIntArray.put(2131362977, 10);
        sparseIntArray.put(2131363366, 11);
    }

    public fh(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = r;
        SparseIntArray sparseIntArray = s;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 12, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private fh(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[10];
        object2 = (ProgressBar)object;
        Object object3 = object = objectArray[3];
        object3 = (FrameLayout)object;
        int n10 = 1;
        Object object4 = object = objectArray[n10];
        object4 = (StoryReviewVideoView)((Object)object);
        Object object5 = object = objectArray[11];
        object5 = (TextView)object;
        Object object6 = object = objectArray[6];
        object6 = (TextView)object;
        Object object7 = object = objectArray[4];
        object7 = (TextView)object;
        Object object8 = object = objectArray[8];
        object8 = (TextView)object;
        Object object9 = object = objectArray[7];
        object9 = (TextView)object;
        Object object10 = object = objectArray[9];
        object10 = (View)object;
        Object object11 = object = objectArray[5];
        object11 = (ImageView)object;
        object = this;
        Object object12 = dataBindingComponent;
        View view2 = view;
        super(dataBindingComponent, view, 1, (ProgressBar)object2, (FrameLayout)object3, (StoryReviewVideoView)((Object)object4), (TextView)object5, (TextView)object6, (TextView)object7, (TextView)object8, (TextView)object9, (View)object10, (ImageView)object11);
        this.q = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.m = object;
        object.setTag(null);
        int n11 = 2;
        view2 = (ImageView)objectArray[n11];
        this.n = view2;
        view2.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        object12 = view;
        this.setRootTag(view);
        object12 = new b(this, n11);
        this.o = object12;
        object = new b(this, n10);
        this.p = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(MutableLiveData mutableLiveData, int n10) {
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
    public void A(x$a x$a) {
        this.l = x$a;
        synchronized (this) {
            long l10 = this.q;
            long l11 = 2;
            this.q = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(z z10) {
        this.k = z10;
        synchronized (this) {
            long l10 = this.q;
            long l11 = 4;
            this.q = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        TemplatePOJO templatePOJO = null;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                x$a x$a = this.l;
                Object object = this.k;
                int n14 = x$a != null ? n12 : 0;
                if (n14 != 0 && (n14 = object != null ? n12 : 0) != 0) {
                    object = ((z)object).b;
                    if (object != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        templatePOJO = (TemplatePOJO)((LiveData)object).getValue();
                        x$a.a(view, templatePOJO);
                    }
                }
            }
        } else {
            x$a x$a = this.l;
            if (x$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                x$a.c();
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
        int n10;
        long l14;
        long l15;
        synchronized (this) {
            l15 = this.q;
            this.q = l14 = 0L;
        }
        Object object = this.k;
        long l16 = 13;
        long l17 = l15 & l16;
        long l18 = l17 == l14 ? 0 : (l17 < l14 ? -1 : 1);
        int n11 = 0;
        if (l18 != false) {
            TemplateData templateData = null;
            if (object != null) {
                object = ((z)object).b;
            } else {
                n10 = 0;
                object = null;
            }
            this.updateLiveDataRegistration(0, (LiveData)object);
            if (object != null) {
                object = (TemplatePOJO)((LiveData)object).getValue();
            } else {
                n10 = 0;
                object = null;
            }
            if (object != null) {
                templateData = ((TemplatePOJO)object).getTemplateData();
            }
            if (templateData != null) {
                n10 = templateData.isPrimeUsable();
            } else {
                n10 = 0;
                object = null;
            }
            if (l18 != false) {
                l13 = n10 != 0 ? (long)32 : (long)16;
                l15 |= l13;
            }
            if (n10 == 0) {
                n11 = n10 = 4;
            }
        }
        if ((n10 = (l12 = (l13 = (long)8 & l15) - l14) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != 0) {
            object = this.m;
            View.OnClickListener onClickListener = this.p;
            object.setOnClickListener(onClickListener);
            object = this.b;
            onClickListener = this.o;
            object.setOnClickListener(onClickListener);
            n10 = ViewDataBinding.getBuildSdkInt();
            l18 = 21;
            if (n10 >= l18) {
                object = this.c;
                l18 = 1;
                object.setClipToOutline((boolean)l18);
            }
        }
        if ((l11 = (l10 = (l15 &= l16) - l14) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            ImageView imageView = this.n;
            imageView.setVisibility(n11);
        }
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
            this.q = l10 = (long)8;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (MutableLiveData)object;
        return this.C((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (x$a)object;
            this.A((x$a)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 != n10) return 0 != 0;
            object = (z)object;
            this.B((z)object);
        }
        return 1 != 0;
    }
}

