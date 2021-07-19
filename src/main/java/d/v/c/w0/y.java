/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.HorizontalScrollView
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.album.AlbumListFragment$a;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.o0.u0;
import d.v.c.w0.x;

public class y
extends x
implements b$a {
    private static final ViewDataBinding$IncludedLayouts A;
    private static final SparseIntArray B;
    private final ConstraintLayout q;
    private final View.OnClickListener r;
    private final View.OnClickListener s;
    private final View.OnClickListener t;
    private final View.OnClickListener u;
    private final View.OnClickListener v;
    private final View.OnClickListener w;
    private final View.OnClickListener x;
    private final View.OnClickListener y;
    private long z;

    static {
        SparseIntArray sparseIntArray;
        B = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362565, 10);
        sparseIntArray.put(2131363091, 11);
        sparseIntArray.put(2131362527, 12);
    }

    public y(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = A;
        SparseIntArray sparseIntArray = B;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 13, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private y(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[7];
        object2 = (ImageButton)object;
        Object object3 = object = objectArray[2];
        object3 = (TextView)object;
        Object object4 = object = objectArray[1];
        object4 = (ImageView)object;
        Object object5 = object = objectArray[8];
        object5 = (ImageButton)object;
        Object object6 = object = objectArray[5];
        object6 = (TextView)object;
        Object object7 = object = objectArray[12];
        object7 = (Group)((Object)object);
        Object object8 = object = objectArray[10];
        object8 = (HorizontalScrollView)object;
        Object object9 = object = objectArray[9];
        object9 = (ProgressBar)object;
        Object object10 = object = objectArray[4];
        object10 = (TextView)object;
        Object object11 = object = objectArray[11];
        object11 = (RecyclerView)object;
        Object object12 = object = objectArray[6];
        object12 = (TextView)object;
        Object object13 = object = objectArray[3];
        object13 = (TextView)object;
        object = this;
        int n10 = 4;
        super(dataBindingComponent, view, n10, (ImageButton)object2, (TextView)object3, (ImageView)object4, (ImageButton)object5, (TextView)object6, (Group)((Object)object7), (HorizontalScrollView)object8, (ProgressBar)object9, (TextView)object10, (RecyclerView)object11, (TextView)object12, (TextView)object13);
        this.z = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.h.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.q = object;
        object.setTag(null);
        this.i.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, 6);
        this.r = object;
        object = new b(this, 1);
        this.s = object;
        object = new b(this, 7);
        this.t = object;
        object = new b(this, 3);
        this.u = object;
        object = new b(this, 2);
        this.v = object;
        object = new b(this, 4);
        this.w = object;
        object = new b(this, 8);
        this.x = object;
        object = new b(this, 5);
        this.y = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean G(ObservableBoolean observableBoolean, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.z;
                long l11 = 4;
                this.z = l10 |= l11;
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
    private boolean H(ObservableInt observableInt, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.z;
                long l11 = 2;
                this.z = l10 |= l11;
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
    private boolean I(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.z;
                long l11 = 8;
                this.z = l10 |= l11;
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
    private boolean J(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.z;
                long l11 = 1L;
                this.z = l10 |= l11;
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
    public void C(AlbumListFragment$a albumListFragment$a) {
        this.p = albumListFragment$a;
        synchronized (this) {
            long l10 = this.z;
            long l11 = 32;
            this.z = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(ObservableBoolean observableBoolean) {
        int n10 = 2;
        this.updateRegistration(n10, observableBoolean);
        this.o = observableBoolean;
        synchronized (this) {
            long l10 = this.z;
            long l11 = 4;
            this.z = l10 |= l11;
        }
        this.notifyPropertyChanged(117);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(ObservableInt observableInt) {
        int n10 = 1;
        this.updateRegistration(n10, observableInt);
        this.n = observableInt;
        synchronized (this) {
            long l10 = this.z;
            long l11 = 2;
            this.z = l10 |= l11;
        }
        this.notifyPropertyChanged(123);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(u0 u02) {
        this.m = u02;
        synchronized (this) {
            long l10 = this.z;
            long l11 = 16;
            this.z = l10 |= l11;
        }
        this.notifyPropertyChanged(154);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 1;
        int n12 = 0;
        switch (n10) {
            default: {
                break;
            }
            case 8: {
                AlbumListFragment$a albumListFragment$a = this.p;
                if (albumListFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                albumListFragment$a.d();
                break;
            }
            case 7: {
                AlbumListFragment$a albumListFragment$a = this.p;
                if (albumListFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                albumListFragment$a.e();
                break;
            }
            case 6: {
                AlbumListFragment$a albumListFragment$a = this.p;
                if (albumListFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                albumListFragment$a.c();
                break;
            }
            case 5: {
                AlbumListFragment$a albumListFragment$a = this.p;
                if (albumListFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                n11 = 3;
                albumListFragment$a.b(n11);
                break;
            }
            case 4: {
                AlbumListFragment$a albumListFragment$a = this.p;
                if (albumListFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                n11 = 2;
                albumListFragment$a.b(n11);
                break;
            }
            case 3: {
                AlbumListFragment$a albumListFragment$a = this.p;
                if (albumListFragment$a != null) {
                    n12 = n11;
                }
                if (n12 == 0) break;
                albumListFragment$a.b(n11);
                break;
            }
            case 2: {
                AlbumListFragment$a albumListFragment$a = this.p;
                if (albumListFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                albumListFragment$a.b(0);
                break;
            }
            case 1: {
                AlbumListFragment$a albumListFragment$a = this.p;
                if (albumListFragment$a == null) {
                    n11 = 0;
                }
                if (n11 == 0) break;
                albumListFragment$a.a();
            }
        }
    }

    /*
     * Exception decompiling
     */
    public void executeBindings() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [3 : 1547->1549)] java.lang.Throwable
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
            long l10 = this.z;
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
            this.z = l10 = (long)64;
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
                        return false;
                    }
                    object = (MutableLiveData)object;
                    return this.I((MutableLiveData)object, n11);
                }
                object = (ObservableBoolean)object;
                return this.G((ObservableBoolean)object, n11);
            }
            object = (ObservableInt)object;
            return this.H((ObservableInt)object, n11);
        }
        object = (MutableLiveData)object;
        return this.J((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 154;
        if (n11 == n10) {
            object = (u0)object;
            this.F((u0)object);
            return 1 != 0;
        } else {
            n11 = 123;
            if (n11 == n10) {
                object = (ObservableInt)object;
                this.E((ObservableInt)object);
                return 1 != 0;
            } else {
                n11 = 117;
                if (n11 == n10) {
                    object = (ObservableBoolean)object;
                    this.D((ObservableBoolean)object);
                    return 1 != 0;
                } else {
                    n11 = 25;
                    if (n11 != n10) return 0 != 0;
                    object = (AlbumListFragment$a)object;
                    this.C((AlbumListFragment$a)object);
                }
            }
        }
        return 1 != 0;
    }
}

