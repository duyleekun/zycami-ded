/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.ops;

import cn.leancloud.AVACL;
import cn.leancloud.AVFile;
import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.codec.Base64;
import cn.leancloud.json.JSONArray;
import cn.leancloud.json.JSONObject;
import cn.leancloud.ops.NullOperation;
import cn.leancloud.ops.ObjectFieldOperation;
import cn.leancloud.types.AVGeoPoint;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public abstract class BaseOperation
implements ObjectFieldOperation {
    public static final String KEY_AMOUNT = "amount";
    public static final String KEY_BODY = "body";
    public static final String KEY_HTTP_METHOD = "method";
    public static final String KEY_INTERNAL_ID = "__internalId";
    public static final String KEY_OBJECTS = "objects";
    public static final String KEY_OP = "__op";
    public static final String KEY_PATH = "path";
    public static final String KEY_VALUE = "value";
    public static final AVLogger LOGGER = LogUtil.getLogger(BaseOperation.class);
    public String field = null;
    public boolean isFinal = false;
    public String op = null;
    public Object value = null;

    public BaseOperation() {
    }

    public BaseOperation(String string2, String string3, Object object, boolean bl2) {
        this.op = string2;
        this.field = string3;
        this.value = object;
        this.isFinal = bl2;
    }

    private static boolean checkValueCircleReference(Map map, Object iterator2) {
        boolean bl2 = false;
        Boolean bl3 = null;
        if (iterator2 != null && map != null) {
            boolean bl4 = iterator2 instanceof AVObject;
            boolean bl5 = true;
            if (bl4) {
                bl2 = map.containsKey(iterator2 = (AVObject)((Object)iterator2));
                if (bl2 && (bl2 = (bl3 = (Boolean)map.get(iterator2)).booleanValue()) == bl5) {
                    return bl5;
                }
                bl2 = ((AVObject)((Object)iterator2)).hasCircleReference(map);
                Boolean bl6 = bl2;
                map.put(iterator2, bl6);
                return bl2;
            }
            bl4 = iterator2 instanceof Collection;
            if (bl4) {
                iterator2 = ((Collection)((Object)iterator2)).iterator();
                while (bl4 = iterator2.hasNext()) {
                    Object e10 = iterator2.next();
                    bl4 = BaseOperation.checkValueCircleReference(map, e10);
                    if (!bl4) continue;
                    return bl5;
                }
            }
        }
        return false;
    }

    public static Object encodeAVFile(AVFile object) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("__type", "_File");
        Map map = ((AVFile)object).getMetaData();
        hashMap.put("metaData", map);
        object = ((AVFile)object).getName();
        hashMap.put("id", object);
        return hashMap;
    }

    public static Object encodeAVObject(AVObject object, boolean bl2) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String string2 = ((AVObject)object).getClassName();
        String string3 = "className";
        hashMap.put(string3, string2);
        string2 = ((AVObject)object).getObjectId();
        boolean bl3 = StringUtil.isEmpty(string2);
        if (!bl3) {
            string2 = ((AVObject)object).getObjectId();
            string3 = "objectId";
            hashMap.put(string3, string2);
        }
        string2 = "__type";
        if (bl2) {
            hashMap.put(string2, "Object");
            object = ((AVObject)object).getServerData();
            bl2 = false;
            object = (Map)BaseOperation.encodeMap((Map)object, false);
            if (object != null && !(bl2 = object.isEmpty())) {
                hashMap.putAll((Map<String, Object>)object);
            }
        } else {
            object = "Pointer";
            hashMap.put(string2, object);
        }
        return hashMap;
    }

    public static Object encodeByteArray(byte[] object) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("__type", "Bytes");
        object = Base64.encodeToString(object, 2);
        hashMap.put("base64", object);
        return hashMap;
    }

    public static Object encodeCollection(Collection object, boolean bl2) {
        int n10 = object.size();
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = BaseOperation.encodeObject(object.next(), bl2);
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static Map encodeDate(Date object) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("__type", "Date");
        object = StringUtil.stringFromDate((Date)object);
        hashMap.put("iso", object);
        return hashMap;
    }

    public static Object encodeGeoPointer(AVGeoPoint object) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("__type", "GeoPoint");
        Double d10 = ((AVGeoPoint)object).getLatitude();
        hashMap.put("latitude", d10);
        object = ((AVGeoPoint)object).getLongitude();
        hashMap.put("longitude", object);
        return hashMap;
    }

    public static Object encodeMap(Map object, boolean bl2) {
        int n10 = object.size();
        HashMap<String, Object> hashMap = new HashMap<String, Object>(n10);
        object = object.entrySet().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = (Map.Entry)object.next();
            String string2 = (String)object2.getKey();
            object2 = BaseOperation.encodeObject(object2.getValue(), bl2);
            hashMap.put(string2, object2);
        }
        return hashMap;
    }

    public static Object encodeObject(Object object) {
        return BaseOperation.encodeObject(object, false);
    }

    public static Object encodeObject(Object object, boolean bl2) {
        if (object == null) {
            return null;
        }
        boolean bl3 = object instanceof Map;
        if (bl3) {
            return BaseOperation.encodeMap((Map)object, bl2);
        }
        bl3 = object instanceof Collection;
        if (bl3) {
            return BaseOperation.encodeCollection((Collection)object, bl2);
        }
        bl3 = object instanceof AVObject;
        if (bl3) {
            return BaseOperation.encodeAVObject((AVObject)object, bl2);
        }
        bl2 = object instanceof AVGeoPoint;
        if (bl2) {
            return BaseOperation.encodeGeoPointer((AVGeoPoint)object);
        }
        bl2 = object instanceof AVACL;
        if (bl2) {
            return ((AVACL)object).toJSONObject();
        }
        bl2 = object instanceof AVFile;
        if (bl2) {
            return BaseOperation.encodeAVFile((AVFile)object);
        }
        bl2 = object instanceof Date;
        if (bl2) {
            return BaseOperation.encodeDate((Date)object);
        }
        bl2 = object instanceof byte[];
        if (bl2) {
            return BaseOperation.encodeByteArray((byte[])object);
        }
        bl2 = object instanceof JSONObject;
        if (bl2 || (bl2 = object instanceof JSONArray)) {
            // empty if block
        }
        return object;
    }

    public abstract Object apply(Object var1);

    public boolean checkCircleReference(Map map) {
        if (map == null) {
            return false;
        }
        Object object = this.value;
        return BaseOperation.checkValueCircleReference(map, object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object concatCollections(Object object, Object iterator2) {
        if (object != null && iterator2 != null) {
            List<Object> list = new List<Object>();
            boolean bl2 = object instanceof Collection;
            if (bl2) {
                object = (Collection)object;
                list.addAll((Collection<Object>)object);
            } else {
                list.add(object);
            }
            boolean bl3 = iterator2 instanceof Collection;
            if (bl3) {
                iterator2 = (Collection)((Object)iterator2);
                list.addAll((Collection<Object>)((Object)iterator2));
            } else {
                list.add(iterator2);
            }
            try {
                int n10 = list.size();
                object = new HashSet(n10);
                iterator2 = list.iterator();
                while (true) {
                    if (!(bl2 = iterator2.hasNext())) {
                        object = ((HashSet)object).toArray();
                        return Arrays.asList(object);
                    }
                    Object e10 = iterator2.next();
                    ((HashSet)object).add(e10);
                }
            }
            catch (Exception exception) {
                iterator2 = LOGGER;
                String string2 = "failed to concat collections.";
                ((AVLogger)((Object)iterator2)).w(string2, exception);
            }
            return list;
        }
        if (object != null) return object;
        return iterator2;
    }

    public abstract Map encode();

    public String getField() {
        return this.field;
    }

    public String getOperation() {
        return this.op;
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isFinal() {
        return this.isFinal;
    }

    public ObjectFieldOperation merge(ObjectFieldOperation objectFieldOperation) {
        boolean bl2;
        if (objectFieldOperation != null && !(bl2 = objectFieldOperation instanceof NullOperation)) {
            bl2 = this.isFinal;
            if (bl2) {
                return this;
            }
            return this.mergeWithPrevious(objectFieldOperation);
        }
        return this;
    }

    public ObjectFieldOperation mergeWithPrevious(ObjectFieldOperation objectFieldOperation) {
        return NullOperation.gInstance;
    }

    public void reportIllegalOperations(ObjectFieldOperation object, ObjectFieldOperation objectFieldOperation) {
        AVLogger aVLogger = LOGGER;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("illegal operations. current=");
        object = object.getClass().getSimpleName();
        stringBuilder.append((String)object);
        stringBuilder.append(", prev=");
        object = objectFieldOperation.getClass().getSimpleName();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        aVLogger.w((String)object);
    }

    public void setField(String string2) {
        this.field = string2;
    }

    public void setFinal(boolean bl2) {
        this.isFinal = bl2;
    }

    public void setOp(String string2) {
        this.op = string2;
    }

    public void setValue(Object object) {
        this.value = object;
    }
}

