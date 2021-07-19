/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.listener;

import com.chad.library.adapter.base.listener.GridSpanSizeLookup;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemChildLongClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;

public interface BaseListenerImp {
    public void setGridSpanSizeLookup(GridSpanSizeLookup var1);

    public void setOnItemChildClickListener(OnItemChildClickListener var1);

    public void setOnItemChildLongClickListener(OnItemChildLongClickListener var1);

    public void setOnItemClickListener(OnItemClickListener var1);

    public void setOnItemLongClickListener(OnItemLongClickListener var1);
}

