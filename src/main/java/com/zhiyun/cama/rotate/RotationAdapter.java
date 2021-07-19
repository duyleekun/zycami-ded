/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.rotate;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import d.v.c.w0.ac;

public class RotationAdapter
extends BaseQuickAdapter {
    private int a;

    public RotationAdapter(int n10) {
        super(n10);
    }

    public void a(BaseDataBindingHolder object, String string2) {
        object = (ac)((BaseDataBindingHolder)object).getDataBinding();
        this.getItemPosition(string2);
    }
}

