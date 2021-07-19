/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.kwai.opensdk.sdk.model.base;

import android.os.Bundle;
import com.kwai.opensdk.sdk.constants.KwaiOpenSdkCmdEnum;
import com.kwai.opensdk.sdk.utils.BundleUtil;
import java.util.ArrayList;

public abstract class BaseReq {
    private String[] platformArray;
    public String sessionId;
    public String thirdExtraInfo;
    public String transaction;

    public abstract boolean checkArgs();

    public void fromBundle(Bundle object) {
        String string2;
        this.transaction = string2 = BundleUtil.getStringExtra(object, "kwai_bundle_transaction");
        this.sessionId = string2 = BundleUtil.getStringExtra(object, "kwai_bundle_session_id");
        object = BundleUtil.getStringExtra(object, "kwai_bundle_third_extra_info");
        this.thirdExtraInfo = object;
    }

    public abstract String getBundleKey();

    public abstract KwaiOpenSdkCmdEnum getCommand();

    public String[] getPlatformArray() {
        int n10;
        Object object = this.platformArray;
        String[] stringArray = "kwai_app";
        if (object != null && (n10 = ((String[])object).length) != 0) {
            int n11 = 2;
            object = new ArrayList(n11);
            for (String string2 : this.platformArray) {
                String string3;
                boolean bl2 = stringArray.equals(string2);
                if (!bl2 && !(bl2 = (string3 = "nebula_app").equals(string2))) continue;
                ((ArrayList)object).add(string2);
            }
            n11 = ((ArrayList)object).size();
            if (n11 > 0) {
                stringArray = new String[n11];
                object = ((ArrayList)object).toArray(stringArray);
                this.platformArray = object;
            } else {
                object = new String[]{stringArray};
                this.platformArray = object;
            }
        } else {
            object = new String[]{stringArray};
            this.platformArray = object;
        }
        return this.platformArray;
    }

    public void setPlatformArray(String[] stringArray) {
        this.platformArray = stringArray;
    }

    public void toBundle(Bundle bundle) {
        String string2 = this.getCommand().getCmdString();
        bundle.putString("kwai_bundle_command", string2);
        string2 = this.transaction;
        bundle.putString("kwai_bundle_transaction", string2);
        string2 = this.sessionId;
        bundle.putString("kwai_bundle_session_id", string2);
        string2 = this.thirdExtraInfo;
        bundle.putString("kwai_bundle_third_extra_info", string2);
    }
}

