/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import java.util.HashMap;

public class VersionInfoEntity$Result {
    public String channel;
    public String fileURL;
    public boolean forceUpdate;
    public boolean isLatest;
    public HashMap notice;
    public String platform;
    public HashMap releaseNotes;
    public String version;
    public String versionType;

    public VersionInfoEntity$Result() {
        String string2;
        this.fileURL = string2 = "";
        this.channel = string2;
        this.version = string2;
        this.platform = string2;
    }
}

