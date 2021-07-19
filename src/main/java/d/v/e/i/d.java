/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.i;

import androidx.lifecycle.LiveData;

public class d
extends LiveData {
    private d() {
        this.postValue(null);
    }

    public static LiveData create() {
        d d10 = new d();
        return d10;
    }
}

