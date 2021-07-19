/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.loader.app;

import android.os.Bundle;
import androidx.loader.content.Loader;

public interface LoaderManager$LoaderCallbacks {
    public Loader onCreateLoader(int var1, Bundle var2);

    public void onLoadFinished(Loader var1, Object var2);

    public void onLoaderReset(Loader var1);
}

