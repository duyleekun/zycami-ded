/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.api.client.SubAppInfo;
import java.lang.ref.WeakReference;
import java.util.List;

public class ClientSettings {
    private List apiName;
    private String appId;
    private String clientClassName;
    private String clientPackageName;
    private WeakReference cpActivity;
    private boolean hasActivity;
    private String innerHmsPkg;
    private String mCpID;
    private List scopes;
    private SubAppInfo subAppId;

    public ClientSettings(String string2, String string3, List list, String string4, List list2) {
        this.clientPackageName = string2;
        this.clientClassName = string3;
        this.scopes = list;
        this.appId = string4;
        this.apiName = list2;
    }

    public ClientSettings(String string2, String string3, List list, String string4, List list2, SubAppInfo subAppInfo) {
        this(string2, string3, list, string4, list2);
        this.setSubAppId(subAppInfo);
    }

    public List getApiName() {
        return this.apiName;
    }

    public String getAppID() {
        return this.appId;
    }

    public String getClientClassName() {
        return this.clientClassName;
    }

    public String getClientPackageName() {
        return this.clientPackageName;
    }

    public Activity getCpActivity() {
        WeakReference weakReference = this.cpActivity;
        weakReference = weakReference == null ? null : (Activity)weakReference.get();
        return weakReference;
    }

    public String getCpID() {
        return this.mCpID;
    }

    public String getInnerHmsPkg() {
        return this.innerHmsPkg;
    }

    public List getScopes() {
        return this.scopes;
    }

    public SubAppInfo getSubAppID() {
        return this.subAppId;
    }

    public boolean isHasActivity() {
        return this.hasActivity;
    }

    public void setApiName(List list) {
        this.apiName = list;
    }

    public void setAppID(String string2) {
        this.appId = string2;
    }

    public void setClientClassName(String string2) {
        this.clientClassName = string2;
    }

    public void setClientPackageName(String string2) {
        this.clientPackageName = string2;
    }

    public void setCpActivity(Activity activity) {
        WeakReference<Activity> weakReference;
        this.cpActivity = weakReference = new WeakReference<Activity>(activity);
        this.hasActivity = true;
    }

    public void setCpID(String string2) {
        this.mCpID = string2;
    }

    public void setInnerHmsPkg(String string2) {
        this.innerHmsPkg = string2;
    }

    public void setScopes(List list) {
        this.scopes = list;
    }

    public void setSubAppId(SubAppInfo subAppInfo) {
        this.subAppId = subAppInfo;
    }
}

