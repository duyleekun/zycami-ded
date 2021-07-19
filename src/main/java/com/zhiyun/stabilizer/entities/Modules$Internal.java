/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer.entities;

import com.zhiyun.protocol.message.bl.other.UpgradeLink;

public class Modules$Internal {
    private UpgradeLink link;
    private int module;
    private String suffix;
    private float version;

    public Modules$Internal(UpgradeLink upgradeLink, int n10, float f10, String string2) {
        this.link = upgradeLink;
        this.module = n10;
        this.version = f10;
        this.suffix = string2;
    }

    public UpgradeLink getLink() {
        return this.link;
    }

    public int getModule() {
        return this.module;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public float getVersion() {
        return this.version;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Internal{link=");
        Object object = this.link;
        stringBuilder.append(object);
        stringBuilder.append(", module=");
        int n10 = this.module;
        stringBuilder.append(n10);
        stringBuilder.append(", version=");
        float f10 = this.version;
        stringBuilder.append(f10);
        stringBuilder.append(", suffix='");
        object = this.suffix;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

