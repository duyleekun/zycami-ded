/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.track;

import java.util.Objects;

public class ScriptTrackMetaData {
    private long id;
    private String name;
    private String product;
    private long trackMetadataId;
    private int version;

    public ScriptTrackMetaData() {
    }

    public ScriptTrackMetaData(long l10, String string2, String string3, int n10) {
        this.trackMetadataId = l10;
        this.product = string2;
        this.name = string3;
        this.version = n10;
    }

    public ScriptTrackMetaData(String string2, String string3, int n10) {
        this.product = string2;
        this.name = string3;
        this.version = n10;
    }

    public ScriptTrackMetaData clone() {
        long l10 = this.trackMetadataId;
        String string2 = this.product;
        String string3 = this.name;
        int n10 = this.version;
        ScriptTrackMetaData scriptTrackMetaData = new ScriptTrackMetaData(l10, string2, string3, n10);
        return scriptTrackMetaData;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            int n10;
            long l10;
            object = (ScriptTrackMetaData)object;
            long l11 = this.id;
            long l12 = ((ScriptTrackMetaData)object).id;
            long l13 = l11 - l12;
            Object object4 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object4 != false || (object4 = (l10 = (l11 = this.trackMetadataId) - (l12 = ((ScriptTrackMetaData)object).trackMetadataId)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false || (object4 = (Object)this.version) != (n10 = ((ScriptTrackMetaData)object).version) || (object4 = (Object)Objects.equals(object3 = this.product, object2 = ((ScriptTrackMetaData)object).product)) == false || !(bl3 = Objects.equals(object3 = this.name, object = ((ScriptTrackMetaData)object).name))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getProduct() {
        return this.product;
    }

    public long getTrackMetadataId() {
        return this.trackMetadataId;
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = Long.valueOf(this.trackMetadataId), object = this.product, object = this.name, object = Integer.valueOf(this.version)};
        return Objects.hash(objectArray);
    }

    public void setId(long l10) {
        this.id = l10;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setProduct(String string2) {
        this.product = string2;
    }

    public void setTrackMetadataId(long l10) {
        this.trackMetadataId = l10;
    }

    public void setVersion(int n10) {
        this.version = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ScriptTrackMetaData{id=");
        long l10 = this.id;
        stringBuilder.append(l10);
        stringBuilder.append(", trackMetadataId=");
        l10 = this.trackMetadataId;
        stringBuilder.append(l10);
        stringBuilder.append(", product='");
        String string2 = this.product;
        stringBuilder.append(string2);
        int n10 = 39;
        stringBuilder.append((char)n10);
        stringBuilder.append(", name='");
        String string3 = this.name;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", version=");
        n10 = this.version;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

