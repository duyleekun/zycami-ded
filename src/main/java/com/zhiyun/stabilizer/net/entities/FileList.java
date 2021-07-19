/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer.net.entities;

import com.zhiyun.net.BaseEntity;
import java.util.ArrayList;
import java.util.List;

public class FileList
extends BaseEntity {
    private List a;

    public FileList() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    public List getList() {
        return this.a;
    }

    public void setList(List list) {
        this.a = list;
    }
}

