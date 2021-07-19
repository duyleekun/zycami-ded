/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.BaseObservableField;
import androidx.databinding.Observable;
import java.io.Serializable;

public class ObservableField
extends BaseObservableField
implements Serializable {
    public static final long serialVersionUID = 1L;
    private Object mValue;

    public ObservableField() {
    }

    public ObservableField(Object object) {
        this.mValue = object;
    }

    public ObservableField(Observable ... observableArray) {
        super(observableArray);
    }

    public Object get() {
        return this.mValue;
    }

    public void set(Object object) {
        Object object2 = this.mValue;
        if (object != object2) {
            this.mValue = object;
            this.notifyChange();
        }
    }
}

