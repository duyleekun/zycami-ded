/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSResult;
import java.util.ArrayList;
import java.util.List;

public class DeleteMultipleObjectResult
extends OSSResult {
    private List deletedObjects;
    private List failedObjects;
    private boolean isQuiet;

    public void addDeletedObject(String string2) {
        ArrayList arrayList = this.deletedObjects;
        if (arrayList == null) {
            this.deletedObjects = arrayList = new ArrayList();
        }
        this.deletedObjects.add(string2);
    }

    public void addFailedObjects(String string2) {
        ArrayList arrayList = this.failedObjects;
        if (arrayList == null) {
            this.failedObjects = arrayList = new ArrayList();
        }
        this.failedObjects.add(string2);
    }

    public void clear() {
        List list = this.deletedObjects;
        if (list != null) {
            list.clear();
        }
        if ((list = this.failedObjects) != null) {
            list.clear();
        }
    }

    public List getDeletedObjects() {
        return this.deletedObjects;
    }

    public List getFailedObjects() {
        return this.failedObjects;
    }

    public boolean getQuiet() {
        return this.isQuiet;
    }

    public void setQuiet(boolean bl2) {
        this.isQuiet = bl2;
    }
}

