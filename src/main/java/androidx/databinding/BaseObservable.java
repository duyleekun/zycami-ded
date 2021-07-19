/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.Observable;
import androidx.databinding.Observable$OnPropertyChangedCallback;
import androidx.databinding.PropertyChangeRegistry;

public class BaseObservable
implements Observable {
    private transient PropertyChangeRegistry mCallbacks;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addOnPropertyChangedCallback(Observable$OnPropertyChangedCallback observable$OnPropertyChangedCallback) {
        synchronized (this) {
            PropertyChangeRegistry propertyChangeRegistry = this.mCallbacks;
            if (propertyChangeRegistry == null) {
                this.mCallbacks = propertyChangeRegistry = new PropertyChangeRegistry();
            }
        }
        this.mCallbacks.add(observable$OnPropertyChangedCallback);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void notifyChange() {
        PropertyChangeRegistry propertyChangeRegistry;
        synchronized (this) {
            propertyChangeRegistry = this.mCallbacks;
            if (propertyChangeRegistry == null) {
                return;
            }
        }
        propertyChangeRegistry.notifyCallbacks(this, 0, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void notifyPropertyChanged(int n10) {
        PropertyChangeRegistry propertyChangeRegistry;
        synchronized (this) {
            propertyChangeRegistry = this.mCallbacks;
            if (propertyChangeRegistry == null) {
                return;
            }
        }
        propertyChangeRegistry.notifyCallbacks(this, n10, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeOnPropertyChangedCallback(Observable$OnPropertyChangedCallback observable$OnPropertyChangedCallback) {
        PropertyChangeRegistry propertyChangeRegistry;
        synchronized (this) {
            propertyChangeRegistry = this.mCallbacks;
            if (propertyChangeRegistry == null) {
                return;
            }
        }
        propertyChangeRegistry.remove(observable$OnPropertyChangedCallback);
    }
}

