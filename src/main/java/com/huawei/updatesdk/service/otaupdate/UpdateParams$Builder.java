/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.service.otaupdate;

import com.huawei.updatesdk.service.otaupdate.UpdateParams;
import com.huawei.updatesdk.service.otaupdate.f;
import java.util.List;

public final class UpdateParams$Builder {
    private boolean isShowImmediate;
    private int minIntervalDay;
    private boolean mustBtnOne;
    private List packageList;
    private List paramList;
    private String serviceZone;
    private String targetPkgName;

    public UpdateParams$Builder() {
        String string2;
        this.serviceZone = string2 = f.f().b();
    }

    public static /* synthetic */ String access$000(UpdateParams$Builder updateParams$Builder) {
        return updateParams$Builder.serviceZone;
    }

    public static /* synthetic */ String access$100(UpdateParams$Builder updateParams$Builder) {
        return updateParams$Builder.targetPkgName;
    }

    public static /* synthetic */ boolean access$200(UpdateParams$Builder updateParams$Builder) {
        return updateParams$Builder.isShowImmediate;
    }

    public static /* synthetic */ int access$300(UpdateParams$Builder updateParams$Builder) {
        return updateParams$Builder.minIntervalDay;
    }

    public static /* synthetic */ boolean access$400(UpdateParams$Builder updateParams$Builder) {
        return updateParams$Builder.mustBtnOne;
    }

    public static /* synthetic */ List access$500(UpdateParams$Builder updateParams$Builder) {
        return updateParams$Builder.packageList;
    }

    public static /* synthetic */ List access$600(UpdateParams$Builder updateParams$Builder) {
        return updateParams$Builder.paramList;
    }

    public UpdateParams build() {
        UpdateParams updateParams = new UpdateParams(this, null);
        return updateParams;
    }

    public UpdateParams$Builder setIsShowImmediate(boolean bl2) {
        this.isShowImmediate = bl2;
        return this;
    }

    public UpdateParams$Builder setMinIntervalDay(int n10) {
        this.minIntervalDay = n10;
        return this;
    }

    public UpdateParams$Builder setMustBtnOne(boolean bl2) {
        this.mustBtnOne = bl2;
        return this;
    }

    public UpdateParams$Builder setPackageList(List list) {
        this.packageList = list;
        return this;
    }

    public UpdateParams$Builder setParamList(List list) {
        this.paramList = list;
        return this;
    }

    public UpdateParams$Builder setServiceZone(String string2) {
        this.serviceZone = string2;
        return this;
    }

    public UpdateParams$Builder setTargetPkgName(String string2) {
        this.targetPkgName = string2;
        return this;
    }
}

