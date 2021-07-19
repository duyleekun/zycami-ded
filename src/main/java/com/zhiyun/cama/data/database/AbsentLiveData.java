/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import androidx.lifecycle.LiveData;

public class AbsentLiveData
extends LiveData {
    private AbsentLiveData() {
        this.postValue(null);
    }

    public static LiveData create() {
        AbsentLiveData absentLiveData = new AbsentLiveData();
        return absentLiveData;
    }
}

