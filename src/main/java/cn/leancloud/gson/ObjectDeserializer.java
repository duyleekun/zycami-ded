/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.gson;

import cn.leancloud.AVFile;
import cn.leancloud.AVInstallation;
import cn.leancloud.AVObject;
import cn.leancloud.AVRole;
import cn.leancloud.AVStatus;
import cn.leancloud.AVUser;
import cn.leancloud.Transformer;
import cn.leancloud.gson.MapDeserializerDoubleAsIntFix;
import cn.leancloud.json.JSONObject;
import cn.leancloud.ops.Utils;
import cn.leancloud.utils.StringUtil;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.internal.LinkedTreeMap;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

public class ObjectDeserializer
implements JsonDeserializer {
    public static final String KEY_SERVERDATA = "serverData";
    public static final String KEY_VERSION = "_version";
    private MapDeserializerDoubleAsIntFix mapDeserializer;

    public ObjectDeserializer() {
        MapDeserializerDoubleAsIntFix mapDeserializerDoubleAsIntFix;
        this.mapDeserializer = mapDeserializerDoubleAsIntFix = new MapDeserializerDoubleAsIntFix();
    }

    private AVObject generateObject(Map object, String object2) {
        Object object3 = KEY_VERSION;
        int n10 = object.containsKey(object3);
        String string2 = "className";
        Object object4 = KEY_SERVERDATA;
        if (n10 != 0) {
            object2 = (String)object.get(string2);
            n10 = object.containsKey(object4);
            if (n10 != 0) {
                object = (Map)object.get(object4);
            }
        } else {
            n10 = object.containsKey(string2);
            if (n10 != 0) {
                object2 = (String)object.get(string2);
                object.remove(string2);
                n10 = object.containsKey(object4);
                if (n10 != 0) {
                    object3 = (LinkedTreeMap)object.get(object4);
                    object.remove(object4);
                    object.putAll(object3);
                }
                object3 = "operationQueue";
                object.remove(object3);
            }
        }
        object2 = (n10 = ((String)object2).endsWith((String)(object3 = AVFile.class.getCanonicalName()))) != 0 ? new AVFile() : ((n10 = ((String)object2).endsWith((String)(object3 = AVUser.class.getCanonicalName()))) != 0 ? new AVUser() : ((n10 = ((String)object2).endsWith((String)(object3 = AVInstallation.class.getCanonicalName()))) != 0 ? new AVInstallation() : ((n10 = ((String)object2).endsWith((String)(object3 = AVStatus.class.getCanonicalName()))) != 0 ? new AVStatus() : ((n10 = ((String)object2).endsWith((String)(object3 = AVRole.class.getCanonicalName()))) != 0 ? new AVRole() : ((n10 = StringUtil.isEmpty((String)object2)) == 0 && (n10 = ((String)object2).indexOf((String)(object3 = "."))) < 0 ? Transformer.objectFromClassName((String)object2) : new AVObject())))));
        object3 = "@type";
        object.remove(object3);
        object = object.entrySet().iterator();
        while ((n10 = object.hasNext()) != 0) {
            object3 = (Map.Entry)object.next();
            string2 = (String)object3.getKey();
            boolean bl2 = (object3 = object3.getValue()) instanceof String;
            if (!(bl2 || (bl2 = object3 instanceof Number) || (bl2 = object3 instanceof Boolean) || (bl2 = object3 instanceof Byte) || (bl2 = object3 instanceof Character))) {
                bl2 = object3 instanceof Map;
                if (!bl2 && !(bl2 = object3 instanceof JSONObject)) {
                    bl2 = object3 instanceof Collection;
                    if (bl2) {
                        object4 = ((AVObject)object2).getServerData();
                        object3 = Utils.getObjectFrom(object3);
                        object4.put(string2, object3);
                        continue;
                    }
                    if (object3 == null) continue;
                    object4 = ((AVObject)object2).getServerData();
                    object4.put(string2, object3);
                    continue;
                }
                object4 = ((AVObject)object2).getServerData();
                object3 = Utils.getObjectFrom(object3);
                object4.put(string2, object3);
                continue;
            }
            object4 = ((AVObject)object2).getServerData();
            object4.put(string2, object3);
        }
        return object2;
    }

    public AVObject deserialize(JsonElement object, Type object2, JsonDeserializationContext jsonDeserializationContext) {
        boolean bl2;
        if (object != null && (bl2 = ((JsonElement)object).isJsonObject())) {
            object = this.mapDeserializer.deserialize((JsonElement)object, (Type)object2, jsonDeserializationContext);
            object2 = ((Class)object2).getCanonicalName();
            return this.generateObject((Map)object, (String)object2);
        }
        return null;
    }
}

