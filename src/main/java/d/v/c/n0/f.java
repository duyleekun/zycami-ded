/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 */
package d.v.c.n0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import d.v.c.n0.f$a;
import d.v.c.w0.p1;

public class f
extends RecyclerView$Adapter {
    private p1 a;
    private final int b;

    public f(int n10) {
        this.b = n10;
    }

    public static /* synthetic */ p1 a(f f10) {
        return f10.a;
    }

    public void b(f$a object, int n10) {
        int n11 = this.b;
        int n12 = 1;
        int n13 = 4;
        if (n11 == 0) {
            if (n10 == 0) {
                ImageView imageView = f$a.a((f$a)object).c;
                imageView.setVisibility(0);
                object = f$a.a((f$a)object).a;
                object.setVisibility(n13);
            } else if (n10 == n12) {
                ImageView imageView = f$a.a((f$a)object).c;
                imageView.setVisibility(n13);
                object = f$a.a((f$a)object).a;
                object.setVisibility(0);
            }
        } else if (n11 == n12) {
            ImageView imageView = f$a.a((f$a)object).c;
            imageView.setVisibility(n13);
            object = f$a.a((f$a)object).a;
            object.setVisibility(0);
        }
    }

    public f$a c(ViewGroup object, int n10) {
        object = p1.v(LayoutInflater.from((Context)object.getContext()), (ViewGroup)object, false);
        this.a = object;
        object = ((ViewDataBinding)object).getRoot();
        f$a f$a = new f$a(this, (View)object);
        return f$a;
    }

    public int getItemCount() {
        return 2;
    }
}

