/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.service.otaupdate;

import com.huawei.updatesdk.service.otaupdate.UpdateParams$Builder;
import com.huawei.updatesdk.service.otaupdate.UpdateParams$a;
import java.util.List;

public class UpdateParams {
    private boolean isShowImmediate = false;
    private int minIntervalDay = 0;
    private boolean mustBtnOne = false;
    private List packageList;
    private List paramList;
    private String serviceZone;
    private String targetPkgName;

    private UpdateParams(UpdateParams$Builder object) {
        int n10;
        Object object2 = UpdateParams$Builder.access$000((UpdateParams$Builder)object);
        this.serviceZone = object2;
        object2 = UpdateParams$Builder.access$100((UpdateParams$Builder)object);
        this.targetPkgName = object2;
        this.isShowImmediate = n10 = UpdateParams$Builder.access$200((UpdateParams$Builder)object);
        this.minIntervalDay = n10 = UpdateParams$Builder.access$300((UpdateParams$Builder)object);
        n10 = (int)(UpdateParams$Builder.access$400((UpdateParams$Builder)object) ? 1 : 0);
        this.mustBtnOne = n10;
        this.packageList = object2 = UpdateParams$Builder.access$500((UpdateParams$Builder)object);
        this.paramList = object = UpdateParams$Builder.access$600((UpdateParams$Builder)object);
    }

    public /* synthetic */ UpdateParams(UpdateParams$Builder updateParams$Builder, UpdateParams$a updateParams$a) {
        this(updateParams$Builder);
    }

    public int getMinIntervalDay() {
        return this.minIntervalDay;
    }

    public List getPackageList() {
        return this.packageList;
    }

    public List getParamList() {
        return this.paramList;
    }

    public String getServiceZone() {
        return this.serviceZone;
    }

    public String getTargetPkgName() {
        return this.targetPkgName;
    }

    public boolean isMustBtnOne() {
        return this.mustBtnOne;
    }

    public boolean isShowImmediate() {
        return this.isShowImmediate;
    }

    public void resetParamList() {
        this.paramList = null;
    }
}

