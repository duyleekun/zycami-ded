/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer.entities;

import com.google.gson.GsonBuilder;
import com.zhiyun.protocol.constants.Model;
import com.zhiyun.protocol.message.bl.other.UpgradeLink;
import com.zhiyun.stabilizer.entities.Modules$1;
import com.zhiyun.stabilizer.entities.Modules$Deserializer;
import java.lang.reflect.Type;
import java.util.List;

public class Modules {
    private static final String SUFFIX_CCS = ".ccs";
    private static final String SUFFIX_COV = ".cov";
    private static final String SUFFIX_PTZ = ".ptz";
    private static final String SUFFIX_UPDATE = ".update";
    private List external;
    private List internal;
    private UpgradeLink link;
    private Model model;
    private String raw;
    private String ssid = "";
    private float version;

    private Modules(String string2) {
        Object object;
        this.link = object = UpgradeLink.BLE;
        this.internal = object;
        super();
        this.external = object;
        this.raw = string2;
    }

    public /* synthetic */ Modules(String string2, Modules$1 modules$1) {
        this(string2);
    }

    public static Modules fromJson(String string2) {
        Object object;
        Object object2;
        Class<Modules> clazz = Modules.class;
        if (string2 != null) {
            string2 = string2.trim();
            object2 = " ";
            object = "";
            string2 = string2.replaceAll((String)object2, (String)object);
        }
        object2 = new GsonBuilder();
        object = new Modules$Deserializer(null);
        return (Modules)((GsonBuilder)object2).registerTypeAdapter((Type)((Object)clazz), object).create().fromJson(string2, clazz);
    }

    public List getExternal() {
        return this.external;
    }

    public List getInternal() {
        return this.internal;
    }

    public UpgradeLink getLink() {
        return this.link;
    }

    public Model getModel() {
        return this.model;
    }

    public String getRaw() {
        return this.raw;
    }

    public String getSsid() {
        return this.ssid;
    }

    public float getVersion() {
        return this.version;
    }

    public void setExternal(List list) {
        this.external = list;
    }

    public void setInternals(List list) {
        this.internal = list;
    }

    public void setLink(UpgradeLink upgradeLink) {
        this.link = upgradeLink;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setRaw(String string2) {
        this.raw = string2;
    }

    public void setSsid(String string2) {
        this.ssid = string2;
    }

    public void setVersion(float f10) {
        this.version = f10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Modules{version=");
        float f10 = this.version;
        stringBuilder.append(f10);
        stringBuilder.append(", link=");
        Object object = this.link;
        stringBuilder.append(object);
        stringBuilder.append(", internal=");
        object = this.internal;
        stringBuilder.append(object);
        stringBuilder.append(", external=");
        object = this.external;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

