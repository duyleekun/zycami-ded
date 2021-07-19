/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.CannedAccessControlList;
import com.alibaba.sdk.android.oss.model.Owner;
import java.util.Date;

public class OSSBucketSummary {
    private CannedAccessControlList acl;
    public Date createDate;
    public String extranetEndpoint;
    public String intranetEndpoint;
    public String location;
    public String name;
    public Owner owner;
    public String storageClass;

    public String getAcl() {
        Object object = this.acl;
        object = object != null ? object.toString() : null;
        return object;
    }

    public void setAcl(String object) {
        object = CannedAccessControlList.parseACL(object);
        this.acl = object;
    }

    public String toString() {
        CharSequence charSequence = this.storageClass;
        String string2 = "]";
        String string3 = ", location=";
        String string4 = ", owner=";
        Object object = ", creationDate=";
        String string5 = "OSSBucket [name=";
        if (charSequence == null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string5);
            string5 = this.name;
            ((StringBuilder)charSequence).append(string5);
            ((StringBuilder)charSequence).append((String)object);
            object = this.createDate;
            ((StringBuilder)charSequence).append(object);
            ((StringBuilder)charSequence).append(string4);
            string4 = this.owner.toString();
            ((StringBuilder)charSequence).append(string4);
            ((StringBuilder)charSequence).append(string3);
            string3 = this.location;
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string2);
            return ((StringBuilder)charSequence).toString();
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string5);
        string5 = this.name;
        ((StringBuilder)charSequence).append(string5);
        ((StringBuilder)charSequence).append((String)object);
        object = this.createDate;
        ((StringBuilder)charSequence).append(object);
        ((StringBuilder)charSequence).append(string4);
        string4 = this.owner.toString();
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append(string3);
        string3 = this.location;
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(", storageClass=");
        string3 = this.storageClass;
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string2);
        return ((StringBuilder)charSequence).toString();
    }
}

