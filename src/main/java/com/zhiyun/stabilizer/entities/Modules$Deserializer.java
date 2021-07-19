/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer.entities;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.zhiyun.protocol.constants.Model;
import com.zhiyun.protocol.message.bl.other.UpgradeLink;
import com.zhiyun.stabilizer.entities.Modules;
import com.zhiyun.stabilizer.entities.Modules$1;
import com.zhiyun.stabilizer.entities.Modules$External;
import com.zhiyun.stabilizer.entities.Modules$Internal;
import d.v.y.d.h;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Modules$Deserializer
implements JsonDeserializer {
    private Modules$Deserializer() {
    }

    public /* synthetic */ Modules$Deserializer(Modules$1 modules$1) {
        this();
    }

    private List parseExternal(JsonArray jsonArray) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i10 = 0; i10 < (n10 = jsonArray.size()); ++i10) {
            Object object;
            Object object2 = jsonArray.get(i10).getAsJsonArray();
            Model model = Model.UNKNOWN;
            int n11 = 0;
            float f10 = 0.0f;
            Object object3 = null;
            String[] stringArray = new String[]{};
            String[] stringArray2 = UpgradeLink.BLE;
            object2 = ((JsonArray)object2).iterator();
            String string2 = "";
            int n12 = 0;
            Object object4 = model;
            float f11 = 0.0f;
            String[] stringArray3 = stringArray;
            Object object5 = stringArray2;
            Object object6 = string2;
            int n13 = 0;
            model = null;
            while ((n11 = object2.hasNext()) != 0) {
                object3 = (JsonElement)object2.next();
                if (n13 != 0) {
                    int n14 = 1;
                    float f12 = Float.MIN_VALUE;
                    if (n13 != n14) {
                        int n15 = 2;
                        if (n13 != n15) {
                            int n16 = 3;
                            if (n13 != n16) {
                                n16 = 4;
                                if (n13 == n16) {
                                    object3 = object3.getAsString();
                                    string2 = ",";
                                    n16 = ((Object)(object3 = ((String)object3).split(string2))).length;
                                    if (n16 >= n14) {
                                        object6 = object3[0];
                                    }
                                    if ((n16 = ((Object)object3).length) >= n15) {
                                        n11 = Integer.valueOf((String)object3[n14]);
                                        object3 = h.f(n11);
                                        object5 = object3;
                                    }
                                }
                            } else {
                                object3 = object3.getAsJsonArray();
                                n14 = ((JsonArray)object3).size();
                                stringArray2 = new String[n14];
                                string2 = null;
                                for (n16 = 0; n16 < n14; ++n16) {
                                    stringArray2[n16] = object = ((JsonArray)object3).get(n16).getAsString();
                                }
                                stringArray3 = stringArray2;
                            }
                        } else {
                            n11 = object3.getAsInt();
                            n12 = n11 == 0 ? n14 : 0;
                        }
                    } else {
                        n11 = object3.getAsInt();
                        f10 = (float)n11 * 1.0f;
                        n14 = 1120403456;
                        f12 = 100.0f;
                        f11 = f10 /= f12;
                    }
                } else {
                    n11 = object3.getAsInt();
                    object3 = Model.from(n11);
                    object4 = object3;
                }
                ++n13;
            }
            object = object2;
            object2 = new Modules$External((String)object6, (UpgradeLink)((Object)object5), (Model)((Object)object4), f11, n12 != 0, stringArray3);
            arrayList.add(object2);
        }
        return arrayList;
    }

    private List parseInternal(JsonArray jsonArray) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i10 = 0; i10 < (n10 = jsonArray.size()); ++i10) {
            int n11;
            Object object = jsonArray.get(i10).getAsJsonArray();
            UpgradeLink upgradeLink = UpgradeLink.BLE;
            int n12 = 0;
            float f10 = 0.0f;
            object = ((JsonArray)object).iterator();
            String string2 = "";
            int n13 = 0;
            UpgradeLink upgradeLink2 = null;
            int n14 = 0;
            while ((n11 = object.hasNext()) != 0) {
                JsonElement jsonElement = (JsonElement)object.next();
                if (n14 != 0) {
                    int n15 = 1;
                    if (n14 != n15) {
                        n15 = 2;
                        if (n14 == n15) {
                            string2 = jsonElement.getAsString();
                        }
                    } else {
                        n12 = jsonElement.getAsInt();
                        f10 = (float)n12 * 1.0f;
                        n11 = 1120403456;
                        float f11 = 100.0f;
                        f10 /= f11;
                    }
                } else {
                    int n16 = jsonElement.getAsInt();
                    upgradeLink2 = h.f(n16);
                    n13 = n16 = h.e(n16);
                    upgradeLink = upgradeLink2;
                }
                ++n14;
            }
            object = new Modules$Internal(upgradeLink, n13, f10, string2);
            arrayList.add(object);
        }
        return arrayList;
    }

    public Modules deserialize(JsonElement jsonElement, Type object, JsonDeserializationContext object2) {
        boolean bl2;
        boolean bl3;
        float f10;
        int n10;
        object2 = jsonElement.toString();
        float f11 = 0.0f;
        Object object3 = null;
        object = new Modules((String)object2, null);
        boolean n11 = ((JsonObject)(jsonElement = jsonElement.getAsJsonObject())).has((String)(object2 = "version"));
        if (n11) {
            object2 = ((JsonObject)jsonElement).get((String)object2);
            n10 = ((JsonElement)object2).getAsInt();
            f10 = n10;
            int n12 = 1120403456;
            f11 = 100.0f;
            ((Modules)object).setVersion(f10 /= f11);
        }
        if (bl3 = ((JsonObject)jsonElement).has((String)(object2 = "channel"))) {
            n10 = ((JsonObject)jsonElement).get((String)object2).getAsInt();
            object2 = h.f(n10);
            ((Modules)object).setLink((UpgradeLink)((Object)object2));
        }
        if (bl2 = ((JsonObject)jsonElement).has((String)(object2 = "modules"))) {
            int n13;
            jsonElement = ((JsonObject)jsonElement).get((String)object2).getAsJsonArray();
            f10 = 0.0f;
            object2 = null;
            for (n10 = 0; n10 < (n13 = ((JsonArray)jsonElement).size()); ++n10) {
                Object object4;
                object3 = ((JsonArray)jsonElement).get(n10).getAsJsonObject();
                boolean bl4 = ((JsonObject)object3).has((String)(object4 = "internal"));
                if (bl4) {
                    object4 = ((JsonObject)object3).get((String)object4).getAsJsonArray();
                    object4 = this.parseInternal((JsonArray)object4);
                    ((Modules)object).setInternals((List)object4);
                }
                if (!(bl4 = ((JsonObject)object3).has((String)(object4 = "external")))) continue;
                object3 = ((JsonObject)object3).get((String)object4).getAsJsonArray();
                object3 = this.parseExternal((JsonArray)object3);
                ((Modules)object).setExternal((List)object3);
            }
        }
        return object;
    }
}

