/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations$2;

public class Transformations$2$1
implements Observer {
    public final /* synthetic */ Transformations$2 this$0;

    public Transformations$2$1(Transformations$2 transformations$2) {
        this.this$0 = transformations$2;
    }

    public void onChanged(Object object) {
        this.this$0.val$result.setValue(object);
    }
}

