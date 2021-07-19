/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.SectionEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;
import f.h2.t.u;
import java.util.List;

public abstract class BaseSectionQuickAdapter
extends BaseMultiItemQuickAdapter {
    private final int sectionHeadResId;

    public BaseSectionQuickAdapter(int n10) {
        this(n10, null, 2, null);
    }

    public BaseSectionQuickAdapter(int n10, int n11, List list) {
        this(n10, list);
        this.setNormalLayout(n11);
    }

    public /* synthetic */ BaseSectionQuickAdapter(int n10, int n11, List list, int n12, u u10) {
        if ((n12 &= 4) != 0) {
            list = null;
        }
        this(n10, n11, list);
    }

    public BaseSectionQuickAdapter(int n10, List list) {
        super(list);
        this.sectionHeadResId = n10;
        this.addItemType(-99, n10);
    }

    public /* synthetic */ BaseSectionQuickAdapter(int n10, List list, int n11, u u10) {
        if ((n11 &= 2) != 0) {
            list = null;
        }
        this(n10, list);
    }

    public abstract void convertHeader(BaseViewHolder var1, SectionEntity var2);

    public void convertHeader(BaseViewHolder baseViewHolder, SectionEntity sectionEntity, List list) {
        f0.q(baseViewHolder, "helper");
        f0.q(sectionEntity, "item");
        f0.q(list, "payloads");
    }

    public boolean isFixedViewType(int n10) {
        int n11 = super.isFixedViewType(n10);
        n10 = n11 == 0 && n10 != (n11 = -99) ? 0 : 1;
        return n10 != 0;
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int n10) {
        String string2 = "holder";
        f0.q(baseViewHolder, string2);
        int n11 = baseViewHolder.getItemViewType();
        int n12 = -99;
        if (n11 == n12) {
            n11 = this.getHeaderLayoutCount();
            SectionEntity sectionEntity = (SectionEntity)this.getItem(n10 -= n11);
            this.convertHeader(baseViewHolder, sectionEntity);
        } else {
            super.onBindViewHolder(baseViewHolder, n10);
        }
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int n10, List list) {
        int n11;
        f0.q(baseViewHolder, "holder");
        String string2 = "payloads";
        f0.q(list, string2);
        int n12 = list.isEmpty();
        if (n12 != 0) {
            this.onBindViewHolder(baseViewHolder, n10);
            return;
        }
        n12 = baseViewHolder.getItemViewType();
        if (n12 == (n11 = -99)) {
            n12 = this.getHeaderLayoutCount();
            SectionEntity sectionEntity = (SectionEntity)this.getItem(n10 -= n12);
            this.convertHeader(baseViewHolder, sectionEntity, list);
        } else {
            super.onBindViewHolder(baseViewHolder, n10, list);
        }
    }

    public final void setNormalLayout(int n10) {
        this.addItemType(-100, n10);
    }
}

