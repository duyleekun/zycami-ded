/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.databinding;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.Collections;
import java.util.List;

public abstract class DataBinderMapper {
    public List collectDependencies() {
        return Collections.emptyList();
    }

    public abstract String convertBrIdToString(int var1);

    public abstract ViewDataBinding getDataBinder(DataBindingComponent var1, View var2, int var3);

    public abstract ViewDataBinding getDataBinder(DataBindingComponent var1, View[] var2, int var3);

    public abstract int getLayoutId(String var1);
}

