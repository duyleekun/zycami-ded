/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer.entities;

import com.zhiyun.protocol.constants.Model;
import com.zhiyun.protocol.message.bl.other.UpgradeLink;
import java.util.Arrays;

public class Modules$External {
    private boolean dependency;
    private UpgradeLink link;
    private Model model;
    private String name;
    private String[] suffix;
    private float version;

    public Modules$External(String string2, UpgradeLink upgradeLink, Model model, float f10, boolean bl2, String[] stringArray) {
        this.name = string2;
        this.link = upgradeLink;
        this.model = model;
        this.version = f10;
        this.dependency = bl2;
        this.suffix = stringArray;
    }

    public UpgradeLink getLink() {
        return this.link;
    }

    public Model getModel() {
        return this.model;
    }

    public String getName() {
        return this.name;
    }

    public String[] getSuffix() {
        return this.suffix;
    }

    public float getVersion() {
        return this.version;
    }

    public boolean isDependency() {
        return this.dependency;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("External{model=");
        Object object = this.model;
        stringBuilder.append(object);
        stringBuilder.append(", version=");
        float f10 = this.version;
        stringBuilder.append(f10);
        stringBuilder.append(", dependency=");
        boolean bl2 = this.dependency;
        stringBuilder.append(bl2);
        stringBuilder.append(", suffix=");
        object = Arrays.toString(this.suffix);
        stringBuilder.append((String)object);
        stringBuilder.append(", name='");
        object = this.name;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append(", link=");
        object = this.link;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

