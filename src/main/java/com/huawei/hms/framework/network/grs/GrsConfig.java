/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.PackageUtils;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;

public class GrsConfig {
    private String appName;
    private String countrySource;
    private String issueCountry;
    private String regCountry;
    private String serCountry;
    private String userId;
    private String versionName;

    public boolean equal(GrsConfig object) {
        boolean bl2;
        String string2;
        String string3;
        boolean bl3;
        if (object != null && (bl3 = StringUtils.strEquals(string3 = this.appName, string2 = ((GrsConfig)object).getAppName())) && (bl3 = StringUtils.strEquals(string3 = this.serCountry, string2 = ((GrsConfig)object).getSerCountry())) && (bl3 = StringUtils.strEquals(string3 = this.regCountry, string2 = ((GrsConfig)object).getRegCountry())) && (bl3 = StringUtils.strEquals(string3 = this.issueCountry, string2 = ((GrsConfig)object).getIssueCountry())) && (bl3 = StringUtils.strEquals(string3 = this.userId, string2 = ((GrsConfig)object).getuserId())) && (bl3 = StringUtils.strEquals(string3 = this.versionName, string2 = ((GrsConfig)object).getVersionName())) && (bl2 = StringUtils.strEquals(string3 = this.countrySource, (String)(object = ((GrsConfig)object).getCountrySource())))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getCountrySource() {
        return this.countrySource;
    }

    public GrsBaseInfo getGrsBaseInfo(Context object) {
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        String string2 = this.serCountry;
        grsBaseInfo.setSerCountry(string2);
        string2 = this.versionName;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        object = bl2 ? PackageUtils.getVersionName(object) : this.versionName;
        grsBaseInfo.setVersionName((String)object);
        object = this.appName;
        grsBaseInfo.setAppName((String)object);
        object = this.userId;
        grsBaseInfo.setUid((String)object);
        object = this.regCountry;
        grsBaseInfo.setRegCountry((String)object);
        object = this.issueCountry;
        grsBaseInfo.setIssueCountry((String)object);
        object = this.countrySource;
        grsBaseInfo.setCountrySource((String)object);
        return grsBaseInfo;
    }

    public String getIssueCountry() {
        return this.issueCountry;
    }

    public String getRegCountry() {
        return this.regCountry;
    }

    public String getSerCountry() {
        return this.serCountry;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public String getuserId() {
        return this.userId;
    }

    public void setAppName(String string2) {
        this.appName = string2;
    }

    public void setCountrySource(String string2) {
        this.countrySource = string2;
    }

    public void setIssueCountry(String string2) {
        this.issueCountry = string2;
    }

    public void setRegCountry(String string2) {
        this.regCountry = string2;
    }

    public void setSerCountry(String string2) {
        this.serCountry = string2;
    }

    public void setUserId(String string2) {
        this.userId = string2;
    }

    public void setVersionName(String string2) {
        this.versionName = string2;
    }
}

