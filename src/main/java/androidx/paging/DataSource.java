/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource$1;
import androidx.paging.DataSource$InvalidatedCallback;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class DataSource {
    private AtomicBoolean mInvalid;
    private CopyOnWriteArrayList mOnInvalidatedCallbacks;

    public DataSource() {
        Serializable serializable;
        this.mInvalid = serializable = new AtomicBoolean(false);
        this.mOnInvalidatedCallbacks = serializable;
    }

    public static List convert(Function object, List object2) {
        int n10;
        Object object3 = (List)object.apply(object2);
        int n11 = object3.size();
        if (n11 == (n10 = object2.size())) {
            return object3;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Invalid Function ");
        ((StringBuilder)object3).append(object);
        ((StringBuilder)object3).append(" changed return size. This is not supported.");
        object = ((StringBuilder)object3).toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public static Function createListFunction(Function function) {
        DataSource$1 dataSource$1 = new DataSource$1(function);
        return dataSource$1;
    }

    public void addInvalidatedCallback(DataSource$InvalidatedCallback dataSource$InvalidatedCallback) {
        this.mOnInvalidatedCallbacks.add(dataSource$InvalidatedCallback);
    }

    public void invalidate() {
        Object object = this.mInvalid;
        boolean bl2 = false;
        DataSource$InvalidatedCallback dataSource$InvalidatedCallback = null;
        boolean bl3 = true;
        boolean bl4 = ((AtomicBoolean)object).compareAndSet(false, bl3);
        if (bl4) {
            object = this.mOnInvalidatedCallbacks.iterator();
            while (bl2 = object.hasNext()) {
                dataSource$InvalidatedCallback = (DataSource$InvalidatedCallback)object.next();
                dataSource$InvalidatedCallback.onInvalidated();
            }
        }
    }

    public abstract boolean isContiguous();

    public boolean isInvalid() {
        return this.mInvalid.get();
    }

    public abstract DataSource map(Function var1);

    public abstract DataSource mapByPage(Function var1);

    public void removeInvalidatedCallback(DataSource$InvalidatedCallback dataSource$InvalidatedCallback) {
        this.mOnInvalidatedCallbacks.remove(dataSource$InvalidatedCallback);
    }
}

