/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.core.util.Pools$SynchronizedPool;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.CallbackRegistry$NotifierCallback;
import androidx.databinding.ListChangeRegistry$1;
import androidx.databinding.ListChangeRegistry$ListChanges;
import androidx.databinding.ObservableList;

public class ListChangeRegistry
extends CallbackRegistry {
    private static final int ALL = 0;
    private static final int CHANGED = 1;
    private static final int INSERTED = 2;
    private static final int MOVED = 3;
    private static final CallbackRegistry$NotifierCallback NOTIFIER_CALLBACK;
    private static final int REMOVED = 4;
    private static final Pools$SynchronizedPool sListChanges;

    static {
        Object object = new Pools$SynchronizedPool(10);
        sListChanges = object;
        NOTIFIER_CALLBACK = object = new ListChangeRegistry$1();
    }

    public ListChangeRegistry() {
        CallbackRegistry$NotifierCallback callbackRegistry$NotifierCallback = NOTIFIER_CALLBACK;
        super(callbackRegistry$NotifierCallback);
    }

    private static ListChangeRegistry$ListChanges acquire(int n10, int n11, int n12) {
        ListChangeRegistry$ListChanges listChangeRegistry$ListChanges = (ListChangeRegistry$ListChanges)sListChanges.acquire();
        if (listChangeRegistry$ListChanges == null) {
            listChangeRegistry$ListChanges = new ListChangeRegistry$ListChanges();
        }
        listChangeRegistry$ListChanges.start = n10;
        listChangeRegistry$ListChanges.to = n11;
        listChangeRegistry$ListChanges.count = n12;
        return listChangeRegistry$ListChanges;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void notifyCallbacks(ObservableList object, int n10, ListChangeRegistry$ListChanges listChangeRegistry$ListChanges) {
        synchronized (this) {
            void var3_3;
            void var2_2;
            super.notifyCallbacks(object, (int)var2_2, var3_3);
            if (var3_3 != null) {
                object = sListChanges;
                ((Pools$SynchronizedPool)object).release(var3_3);
            }
            return;
        }
    }

    public void notifyChanged(ObservableList observableList) {
        this.notifyCallbacks(observableList, 0, null);
    }

    public void notifyChanged(ObservableList observableList, int n10, int n11) {
        ListChangeRegistry$ListChanges listChangeRegistry$ListChanges = ListChangeRegistry.acquire(n10, 0, n11);
        this.notifyCallbacks(observableList, 1, listChangeRegistry$ListChanges);
    }

    public void notifyInserted(ObservableList observableList, int n10, int n11) {
        ListChangeRegistry$ListChanges listChangeRegistry$ListChanges = ListChangeRegistry.acquire(n10, 0, n11);
        this.notifyCallbacks(observableList, 2, listChangeRegistry$ListChanges);
    }

    public void notifyMoved(ObservableList observableList, int n10, int n11, int n12) {
        ListChangeRegistry$ListChanges listChangeRegistry$ListChanges = ListChangeRegistry.acquire(n10, n11, n12);
        this.notifyCallbacks(observableList, 3, listChangeRegistry$ListChanges);
    }

    public void notifyRemoved(ObservableList observableList, int n10, int n11) {
        ListChangeRegistry$ListChanges listChangeRegistry$ListChanges = ListChangeRegistry.acquire(n10, 0, n11);
        this.notifyCallbacks(observableList, 4, listChangeRegistry$ListChanges);
    }
}

