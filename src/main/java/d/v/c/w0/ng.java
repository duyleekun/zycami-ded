/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.set.SetCacheFragment$a;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.q1.g0;
import d.v.c.w0.mg;
import d.v.c.w0.ng$a;
import d.v.c.w0.ng$b;
import d.v.c.w0.ng$c;
import d.v.c.w0.ng$d;
import d.v.c.w0.ng$e;

public class ng
extends mg
implements b$a {
    private static final ViewDataBinding$IncludedLayouts w;
    private static final SparseIntArray x;
    private final LinearLayout e;
    private final FrameLayout f;
    private final TextView g;
    private final FrameLayout h;
    private final TextView i;
    private final FrameLayout j;
    private final TextView k;
    private final FrameLayout l;
    private final TextView m;
    private final FrameLayout n;
    private final TextView o;
    private final View.OnClickListener p;
    private ng$e q;
    private ng$a r;
    private ng$b s;
    private ng$c t;
    private ng$d u;
    private long v;

    static {
        SparseIntArray sparseIntArray;
        x = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363612, 12);
    }

    public ng(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = w;
        SparseIntArray sparseIntArray = x;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 13, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private ng(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        int n10 = 1;
        Object object3 = object2 = objectArray[n10];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[12];
        object4 = (TextView)object2;
        super(object, view, 5, (ImageView)object3, (TextView)object4);
        this.v = -1;
        this.a.setTag(null);
        object = (LinearLayout)objectArray[0];
        this.e = object;
        object.setTag(null);
        object = (FrameLayout)objectArray[10];
        this.f = object;
        object.setTag(null);
        object = (TextView)objectArray[11];
        this.g = object;
        object.setTag(null);
        object = (FrameLayout)objectArray[2];
        this.h = object;
        object.setTag(null);
        object = (TextView)objectArray[3];
        this.i = object;
        object.setTag(null);
        object = (FrameLayout)objectArray[4];
        this.j = object;
        object.setTag(null);
        object = (TextView)objectArray[5];
        this.k = object;
        object.setTag(null);
        object = (FrameLayout)objectArray[6];
        this.l = object;
        object.setTag(null);
        object = (TextView)objectArray[7];
        this.m = object;
        object.setTag(null);
        object = (FrameLayout)objectArray[8];
        this.n = object;
        object.setTag(null);
        object = (TextView)objectArray[9];
        this.o = object;
        object.setTag(null);
        this.setRootTag(view);
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
                long l10 = this.v;
                long l11 = 4;
                this.v = l10 |= l11;
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
    private boolean D(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.v;
                long l11 = 16;
                this.v = l10 |= l11;
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
    private boolean E(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.v;
                long l11 = 8;
                this.v = l10 |= l11;
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
    private boolean F(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.v;
                long l11 = 2;
                this.v = l10 |= l11;
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
    private boolean G(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.v;
                long l11 = 1L;
                this.v = l10 |= l11;
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
    public void A(SetCacheFragment$a setCacheFragment$a) {
        this.c = setCacheFragment$a;
        synchronized (this) {
            long l10 = this.v;
            long l11 = 32;
            this.v = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(g0 g02) {
        this.d = g02;
        synchronized (this) {
            long l10 = this.v;
            long l11 = 64;
            this.v = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        SetCacheFragment$a setCacheFragment$a = this.c;
        boolean bl2 = setCacheFragment$a != null;
        if (bl2) {
            setCacheFragment$a.f(view);
        }
    }

    /*
     * Exception decompiling
     */
    public void executeBindings() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [3 : 1106->1108)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.v;
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
            this.v = l10 = 128L;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    n12 = 3;
                    if (n10 != n12) {
                        n12 = 4;
                        if (n10 != n12) {
                            return false;
                        }
                        object = (MutableLiveData)object;
                        return this.D((MutableLiveData)object, n11);
                    }
                    object = (MutableLiveData)object;
                    return this.E((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.C((MutableLiveData)object, n11);
            }
            object = (LiveData)object;
            return this.F((LiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.G((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (SetCacheFragment$a)object;
            this.A((SetCacheFragment$a)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 != n10) return 0 != 0;
            object = (g0)object;
            this.B((g0)object);
        }
        return 1 != 0;
    }
}

