/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  android.view.ViewGroup$LayoutParams
 */
package com.zhiyun.cama.voice.record;

import android.util.Size;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zhiyun.common.util.Windows;
import d.v.c.w0.cd;
import d.v.e.l.h2;
import java.util.List;

public class TimelineAdapter
extends BaseQuickAdapter {
    private double a = 4.0E-4;
    private long b = 1000000L;

    public TimelineAdapter(List list) {
        super(2131558660, list);
    }

    public void a(BaseViewHolder object, String string2) {
        object = (cd)DataBindingUtil.getBinding(((RecyclerView$ViewHolder)object).itemView);
        int n10 = this.getItemPosition(string2);
        if (object != null) {
            Object[] objectArray;
            float f10;
            ((cd)object).a.setGravity(17);
            RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)((cd)object).a.getLayoutParams();
            recyclerView$LayoutParams.setMarginStart(0);
            recyclerView$LayoutParams.setMarginEnd(0);
            long l10 = this.b;
            double d10 = l10;
            double d11 = this.a;
            int n11 = (int)(d10 *= d11);
            Size size = Windows.l(((ViewDataBinding)object).getRoot().getContext());
            int n12 = 0x40000000;
            float f11 = 2.0f;
            int n13 = 1;
            if (n10 == 0) {
                long l11 = this.b;
                f10 = (float)l11 / f11;
                double d12 = f10;
                double d13 = this.a;
                n11 = (int)(d12 *= d13);
                objectArray = ((cd)object).a;
                n12 = 0x800003;
                f11 = 1.1754948E-38f;
                objectArray.setGravity(n12);
                n10 = size.getWidth() >> n13;
                recyclerView$LayoutParams.setMarginStart(n10);
            } else {
                List list = this.getData();
                int n14 = list.size() - n13;
                if (n10 == n14) {
                    double d14 = size.getWidth() >> n13;
                    long l12 = this.b;
                    f10 = (float)l12 / f11;
                    double d15 = f10;
                    double d16 = this.a;
                    n10 = (int)(d14 += (d15 *= d16));
                    recyclerView$LayoutParams.setMarginEnd(n10);
                }
            }
            recyclerView$LayoutParams.width = n11;
            f10 = 12.0f;
            recyclerView$LayoutParams.height = n10 = h2.b(f10);
            ((cd)object).a.setLayoutParams((ViewGroup.LayoutParams)recyclerView$LayoutParams);
            object = ((cd)object).a;
            objectArray = new Object[n13];
            objectArray[0] = string2;
            string2 = String.format("%s''", objectArray);
            object.setText((CharSequence)string2);
        }
    }

    public void b(long l10) {
        this.b = l10;
    }

    public void c(double d10) {
        this.a = d10;
    }

    public int getItemViewType(int n10) {
        return super.getItemViewType(n10);
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int n10) {
        super.onBindViewHolder(baseViewHolder, n10);
    }

    public void onItemViewHolderCreated(BaseViewHolder baseViewHolder, int n10) {
        super.onItemViewHolderCreated(baseViewHolder, n10);
        DataBindingUtil.bind(baseViewHolder.itemView);
    }
}

