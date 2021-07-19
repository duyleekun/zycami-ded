/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.ListChangeRegistry;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableList$OnListChangedCallback;
import java.util.ArrayList;
import java.util.Collection;

public class ObservableArrayList
extends ArrayList
implements ObservableList {
    private transient ListChangeRegistry mListeners;

    public ObservableArrayList() {
        ListChangeRegistry listChangeRegistry;
        this.mListeners = listChangeRegistry = new ListChangeRegistry();
    }

    private void notifyAdd(int n10, int n11) {
        ListChangeRegistry listChangeRegistry = this.mListeners;
        if (listChangeRegistry != null) {
            listChangeRegistry.notifyInserted(this, n10, n11);
        }
    }

    private void notifyRemove(int n10, int n11) {
        ListChangeRegistry listChangeRegistry = this.mListeners;
        if (listChangeRegistry != null) {
            listChangeRegistry.notifyRemoved(this, n10, n11);
        }
    }

    public void add(int n10, Object object) {
        super.add(n10, object);
        this.notifyAdd(n10, 1);
    }

    public boolean add(Object object) {
        super.add(object);
        int n10 = this.size();
        int n11 = 1;
        this.notifyAdd(n10 -= n11, n11);
        return n11 != 0;
    }

    public boolean addAll(int n10, Collection collection) {
        boolean bl2 = super.addAll(n10, collection);
        if (bl2) {
            int n11 = collection.size();
            this.notifyAdd(n10, n11);
        }
        return bl2;
    }

    public boolean addAll(Collection collection) {
        int n10 = this.size();
        boolean bl2 = super.addAll(collection);
        if (bl2) {
            int n11 = this.size() - n10;
            this.notifyAdd(n10, n11);
        }
        return bl2;
    }

    public void addOnListChangedCallback(ObservableList$OnListChangedCallback observableList$OnListChangedCallback) {
        ListChangeRegistry listChangeRegistry = this.mListeners;
        if (listChangeRegistry == null) {
            this.mListeners = listChangeRegistry = new ListChangeRegistry();
        }
        this.mListeners.add(observableList$OnListChangedCallback);
    }

    public void clear() {
        int n10 = this.size();
        super.clear();
        if (n10 != 0) {
            this.notifyRemove(0, n10);
        }
    }

    public Object remove(int n10) {
        Object e10 = super.remove(n10);
        this.notifyRemove(n10, 1);
        return e10;
    }

    public boolean remove(Object object) {
        int n10 = this.indexOf(object);
        if (n10 >= 0) {
            this.remove(n10);
            return true;
        }
        return false;
    }

    public void removeOnListChangedCallback(ObservableList$OnListChangedCallback observableList$OnListChangedCallback) {
        ListChangeRegistry listChangeRegistry = this.mListeners;
        if (listChangeRegistry != null) {
            listChangeRegistry.remove(observableList$OnListChangedCallback);
        }
    }

    public void removeRange(int n10, int n11) {
        super.removeRange(n10, n11);
        this.notifyRemove(n10, n11 -= n10);
    }

    public Object set(int n10, Object object) {
        object = super.set(n10, object);
        ListChangeRegistry listChangeRegistry = this.mListeners;
        if (listChangeRegistry != null) {
            int n11 = 1;
            listChangeRegistry.notifyChanged(this, n10, n11);
        }
        return object;
    }
}

