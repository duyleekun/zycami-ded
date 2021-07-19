/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVQuery;

public class AVSaveOption {
    public boolean fetchWhenSave;
    public AVQuery matchQuery;

    public AVSaveOption query(AVQuery aVQuery) {
        this.matchQuery = aVQuery;
        return this;
    }

    public AVSaveOption setFetchWhenSave(boolean bl2) {
        this.fetchWhenSave = bl2;
        return this;
    }
}

