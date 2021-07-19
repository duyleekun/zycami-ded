/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.n0;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public class e
extends RecyclerView$ViewHolder {
    public ViewDataBinding a;

    public e(ViewDataBinding viewDataBinding) {
        View view = viewDataBinding.getRoot();
        super(view);
        this.a = viewDataBinding;
    }
}

