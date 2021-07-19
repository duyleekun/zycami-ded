/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity.speed;

import com.zhiyun.cama.data.api.entity.speed.CurveTemp;
import com.zhiyun.cama.data.database.model.ResourceData;

public class CurveTemp$CurveTempBean
extends ResourceData {
    private boolean canSelected;
    private String curveString;
    public final /* synthetic */ CurveTemp this$0;
    private String thumb;

    public CurveTemp$CurveTempBean(CurveTemp curveTemp, long l10, String string2, String string3, String string4, int n10, String string5, String string6) {
        this.this$0 = curveTemp;
        super(l10, string2, string3, string4, n10);
        this.thumb = string5;
        this.curveString = string6;
    }

    public String getCurveString() {
        return this.curveString;
    }

    public String getThumb() {
        return this.thumb;
    }

    public boolean isCanSelected() {
        return this.canSelected;
    }

    public CurveTemp$CurveTempBean setCanSelected(boolean bl2) {
        this.canSelected = bl2;
        return this;
    }

    public CurveTemp$CurveTempBean setCurveString(String string2) {
        this.curveString = string2;
        return this;
    }

    public CurveTemp$CurveTempBean setThumb(String string2) {
        this.thumb = string2;
        return this;
    }
}

