/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.fragment.app;

import android.os.Bundle;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.LifecycleOwner;

public interface FragmentResultOwner {
    public void clearFragmentResult(String var1);

    public void clearFragmentResultListener(String var1);

    public void setFragmentResult(String var1, Bundle var2);

    public void setFragmentResultListener(String var1, LifecycleOwner var2, FragmentResultListener var3);
}

