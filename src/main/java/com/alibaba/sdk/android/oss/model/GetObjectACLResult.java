/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.CannedAccessControlList;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.alibaba.sdk.android.oss.model.Owner;

public class GetObjectACLResult
extends OSSResult {
    private CannedAccessControlList objectACL;
    private Owner objectOwner;

    public GetObjectACLResult() {
        Owner owner;
        this.objectOwner = owner = new Owner();
    }

    public String getObjectACL() {
        Object object = this.objectACL;
        object = object != null ? object.toString() : null;
        return object;
    }

    public String getObjectOwner() {
        return this.objectOwner.getDisplayName();
    }

    public String getObjectOwnerID() {
        return this.objectOwner.getId();
    }

    public Owner getOwner() {
        return this.objectOwner;
    }

    public void setObjectACL(String object) {
        object = CannedAccessControlList.parseACL(object);
        this.objectACL = object;
    }

    public void setObjectOwner(String string2) {
        this.objectOwner.setDisplayName(string2);
    }

    public void setObjectOwnerID(String string2) {
        this.objectOwner.setId(string2);
    }
}

