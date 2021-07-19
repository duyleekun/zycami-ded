/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.a.i.b;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public class i
extends RecyclerView$ViewHolder {
    public ViewDataBinding a;

    public i(ViewDataBinding viewDataBinding) {
        View view = viewDataBinding.getRoot();
        super(view);
        this.a = viewDataBinding;
    }
}

