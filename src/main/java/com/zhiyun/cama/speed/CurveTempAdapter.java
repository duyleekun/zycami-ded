/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.ImageView
 */
package com.zhiyun.cama.speed;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.zhiyun.cama.data.api.entity.speed.CurveTemp$CurveTempBean;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.image.Images;
import d.v.c.w0.oa;
import java.util.List;

public class CurveTempAdapter
extends BaseQuickAdapter {
    private int a = -1;

    public CurveTempAdapter(List list) {
        super(2131558625, list);
    }

    /*
     * WARNING - void declaration
     */
    public void a(BaseDataBindingHolder object, CurveTemp$CurveTempBean object2) {
        void var4_7;
        String string2;
        float f10;
        object = (oa)((BaseDataBindingHolder)object).getDataBinding();
        Object object3 = ((oa)object).c;
        int n10 = this.getItemPosition(object2);
        int n11 = this.a;
        boolean bl2 = true;
        float f11 = Float.MIN_VALUE;
        if (n10 == n11) {
            boolean bl3 = bl2;
            f10 = f11;
        } else {
            boolean bl4 = false;
            string2 = null;
            f10 = 0.0f;
        }
        object3.setSelected((boolean)var4_7);
        object3 = ((oa)object).b;
        int n12 = this.getItemPosition(object2);
        n11 = this.a;
        if (n12 != n11) {
            bl2 = false;
            f11 = 0.0f;
        }
        object3.setSelected(bl2);
        object3 = ((oa)object).a;
        boolean bl5 = ((CurveTemp$CurveTempBean)object2).isCanSelected();
        if (bl5) {
            int n13 = 1065353216;
            f10 = 1.0f;
        } else {
            int n14 = 1045220557;
            f10 = 0.2f;
        }
        object3.setAlpha(f10);
        object3 = ((oa)object).b;
        string2 = ((CurveTemp$CurveTempBean)object2).getThumb();
        Images.e((ImageView)object3, string2);
        object = ((oa)object).c;
        object2 = ((ResourceData)object2).showLabel();
        object.setText((CharSequence)object2);
    }

    public void b(int n10) {
        this.a = n10;
        this.notifyDataSetChanged();
    }
}

