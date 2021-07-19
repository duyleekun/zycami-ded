/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 */
package d.v.c.s0.d7;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public class x$a
extends RecyclerView$ViewHolder {
    public RelativeLayout a;
    public TextView b;
    public ImageView c;

    public x$a(View view) {
        super(view);
        RelativeLayout relativeLayout;
        this.a = relativeLayout = (RelativeLayout)view.findViewById(2131363134);
        relativeLayout = (TextView)view.findViewById(2131363490);
        this.b = relativeLayout;
        view = (ImageView)view.findViewById(2131362684);
        this.c = view;
    }
}

