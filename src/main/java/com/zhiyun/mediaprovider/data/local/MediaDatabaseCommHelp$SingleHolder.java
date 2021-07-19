/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.mediaprovider.data.local;

import com.zhiyun.mediaprovider.data.local.MediaDatabaseCommHelp;

public class MediaDatabaseCommHelp$SingleHolder {
    private static final MediaDatabaseCommHelp INSTANCE;

    static {
        MediaDatabaseCommHelp mediaDatabaseCommHelp;
        INSTANCE = mediaDatabaseCommHelp = new MediaDatabaseCommHelp();
    }

    private MediaDatabaseCommHelp$SingleHolder() {
    }

    public static /* synthetic */ MediaDatabaseCommHelp access$000() {
        return INSTANCE;
    }
}

