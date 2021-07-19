/*
 * Decompiled with CFR 0.151.
 */
package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;

public abstract class ActivityResultLauncher {
    public abstract ActivityResultContract getContract();

    public void launch(Object object) {
        this.launch(object, null);
    }

    public abstract void launch(Object var1, ActivityOptionsCompat var2);

    public abstract void unregister();
}

