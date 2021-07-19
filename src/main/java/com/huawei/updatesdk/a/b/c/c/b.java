/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.huawei.updatesdk.a.b.c.c;

import com.huawei.updatesdk.a.a.a;
import com.huawei.updatesdk.a.a.d.f;
import com.huawei.updatesdk.a.b.c.c.b$a;
import com.huawei.updatesdk.service.appmgr.bean.SDKNetTransmission;
import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class b {
    private static final char COMMA = ',';
    private static final String END_FLAG = "_";
    private static final String TAG = "b";

    private String arrayToJson(Object object) {
        int n10 = Array.getLength(object);
        if (n10 <= 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = Array.get(object, i10);
            if ((object2 = this.valueToJson(object2)) == null) continue;
            stringBuilder.append((String)object2);
            char c10 = ',';
            stringBuilder.append(c10);
        }
        this.formatJsonStr(stringBuilder);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private void formatJsonStr(StringBuilder stringBuilder) {
        char c10;
        int n10;
        char c11;
        int n11 = stringBuilder.length();
        if (n11 > 0 && (c11 = stringBuilder.charAt(n10 = n11 + -1)) == (c10 = ',')) {
            stringBuilder.delete(n10, n11);
        }
    }

    private boolean isPrimitiveObj(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof Integer;
        if (!(bl3 || (bl3 = object instanceof Long) || (bl3 = object instanceof Boolean) || (bl3 = object instanceof Float) || (bl3 = object instanceof Byte) || (bl3 = object instanceof Character) || (bl3 = object instanceof Double) || (bl2 = object instanceof Short))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private Object jsonBeanFromJson(Class object, Object object2) {
        object = (b)((Class)object).newInstance();
        object2 = (JSONObject)object2;
        ((b)object).fromJson((JSONObject)object2);
        return object;
    }

    private String mapToJson(Map object) {
        int n10 = object.size();
        if (n10 <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object object2 = "{";
        stringBuilder.append((String)object2);
        object = object.entrySet().iterator();
        while (true) {
            boolean bl2;
            object2 = (Map.Entry)object.next();
            String string2 = (String)object2.getKey();
            object2 = object2.getValue();
            if ((object2 = this.valueToJson(object2)) != null) {
                String string3 = "\"";
                stringBuilder.append(string3);
                stringBuilder.append(string2);
                string2 = "\":";
                stringBuilder.append(string2);
                stringBuilder.append((String)object2);
            }
            if (!(bl2 = object.hasNext())) break;
            if (object2 == null) continue;
            char c10 = ',';
            stringBuilder.append(c10);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void processValueError(Field field, Object object) {
        if (object == null) return;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            return;
        }
        try {
            Object object2 = field.getType();
            boolean bl3 = ((Class)object2).isPrimitive();
            if (!bl3) {
                return;
            }
            String string2 = "int";
            bl3 = string2.equals(object2 = ((Class)object2).getName());
            if (bl3) {
                object = (String)object;
                int n10 = Integer.parseInt((String)object);
                object = n10;
            } else {
                string2 = "float";
                bl3 = string2.equals(object2);
                if (bl3) {
                    object = (String)object;
                    float f10 = Float.parseFloat((String)object);
                    object = Float.valueOf(f10);
                } else {
                    string2 = "long";
                    bl3 = string2.equals(object2);
                    if (bl3) {
                        object = (String)object;
                        long l10 = Long.parseLong((String)object);
                        object = l10;
                    } else {
                        string2 = "boolean";
                        bl3 = string2.equals(object2);
                        if (bl3) {
                            object = (String)object;
                            boolean bl4 = Boolean.parseBoolean((String)object);
                            object = bl4;
                        } else {
                            string2 = "double";
                            bl3 = string2.equals(object2);
                            if (bl3) {
                                object = (String)object;
                                double d10 = Double.parseDouble((String)object);
                                object = d10;
                            } else {
                                string2 = "short";
                                bl3 = string2.equals(object2);
                                if (bl3) {
                                    object = (String)object;
                                    short s10 = Short.parseShort((String)object);
                                    object = s10;
                                } else {
                                    string2 = "byte";
                                    bl3 = string2.equals(object2);
                                    if (bl3) {
                                        object = (String)object;
                                        byte by2 = Byte.parseByte((String)object);
                                        object = by2;
                                    } else {
                                        string2 = "char";
                                        bl2 = string2.equals(object2);
                                        if (!bl2) return;
                                        object = (String)object;
                                        bl2 = false;
                                        object2 = null;
                                        char c10 = ((String)object).charAt(0);
                                        object = Character.valueOf(c10);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            field.set(this, object);
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            object = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "processValueError Throwable:";
            stringBuilder.append(string3);
            String string4 = illegalAccessException.getMessage();
            stringBuilder.append(string4);
            string4 = stringBuilder.toString();
            com.huawei.updatesdk.a.a.c.a.a.a.b((String)object, string4);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Object valueFromJson(Class object, Class object2, Object object3) {
        Class clazz;
        Class clazz2 = b.class;
        boolean bl2 = ((Class)object).isPrimitive();
        if (!bl2 && !(bl2 = object.equals(clazz = String.class))) {
            clazz = List.class;
            bl2 = clazz.isAssignableFrom((Class<?>)object);
            if (bl2) {
                return this.listFromJson((Class)object2, object3);
            }
            bl2 = clazz2.isAssignableFrom((Class<?>)object);
            if (bl2) {
                boolean bl3 = object.equals(clazz2);
                if (!bl3) {
                    return this.jsonBeanFromJson((Class)object, object3);
                }
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("error type, type:");
                ((StringBuilder)object3).append(object);
                object = ((StringBuilder)object3).toString();
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
            clazz2 = Map.class;
            boolean bl4 = clazz2.isAssignableFrom((Class<?>)object);
            if (bl4) {
                return this.mapFromJson((Class)object2, object3);
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("unsupport type, Type:");
            ((StringBuilder)object3).append(object);
            object = ((StringBuilder)object3).toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object2 = "float";
        boolean bl5 = ((String)object2).equals(object = ((Class)object).getName());
        if (!bl5) return object3;
        bl5 = object3 instanceof Double;
        if (!bl5) return object3;
        float f10 = ((Double)object3).floatValue();
        return Float.valueOf(f10);
    }

    private String valueToJson(Object object) {
        String string2 = null;
        if (object != null) {
            boolean bl2 = object instanceof String;
            if (bl2) {
                object = object.toString();
                string2 = JSONObject.quote((String)object);
            } else {
                bl2 = this.isPrimitiveObj(object);
                if (bl2) {
                    string2 = String.valueOf(object);
                } else {
                    bl2 = object instanceof b;
                    if (bl2) {
                        object = (b)object;
                        string2 = ((b)object).toJson();
                    } else {
                        bl2 = object instanceof List;
                        if (bl2) {
                            object = (List)object;
                            string2 = this.listToJson((List)object);
                        } else {
                            bl2 = object instanceof Map;
                            if (bl2) {
                                object = (Map)object;
                                string2 = this.mapToJson((Map)object);
                            } else {
                                Class<?> clazz = object.getClass();
                                bl2 = clazz.isArray();
                                if (bl2) {
                                    string2 = this.arrayToJson(object);
                                }
                            }
                        }
                    }
                }
            }
        }
        return string2;
    }

    public void fromJson(JSONObject jSONObject) {
        int n10;
        Field[] fieldArray = f.a(this.getClass());
        Object object = null;
        for (int i10 = 0; i10 < (n10 = fieldArray.length); ++i10) {
            boolean bl2;
            Object object2 = fieldArray[i10];
            Object object3 = new b$a((Field)object2);
            AccessController.doPrivileged(object3);
            object3 = fieldArray[i10].getName();
            object2 = fieldArray[i10];
            int n11 = ((AccessibleObject)object2).isAnnotationPresent(SDKNetTransmission.class);
            Class<?> clazz = END_FLAG;
            if (n11 == 0 && (n11 = ((String)object3).endsWith((String)((Object)clazz))) == 0) continue;
            n11 = ((String)object3).endsWith((String)((Object)clazz));
            if (n11 != 0) {
                n11 = ((String)object3).length() + -1;
                object3 = ((String)object3).substring(0, n11);
            }
            if ((n11 = jSONObject.has((String)object3)) == 0 || (bl2 = (clazz = JSONObject.NULL).equals(object2 = jSONObject.get((String)object3)))) continue;
            clazz = fieldArray[i10];
            clazz = ((Field)((Object)clazz)).getType();
            Object object4 = fieldArray[i10];
            object4 = f.a((Field)object4);
            object = this.valueFromJson(clazz, (Class)object4, object2);
            object2 = fieldArray[i10];
            try {
                ((Field)object2).set(this, object);
                continue;
            }
            catch (Exception exception) {
                clazz = TAG;
                object4 = new StringBuilder();
                String string2 = this.getClass().getName();
                ((StringBuilder)object4).append(string2);
                string2 = ".fromJson error, fieldName:";
                ((StringBuilder)object4).append(string2);
                ((StringBuilder)object4).append((String)object3);
                object3 = exception.toString();
                ((StringBuilder)object4).append((String)object3);
                object3 = ((StringBuilder)object4).toString();
                a.a(clazz, (String)object3);
                object3 = fieldArray[i10];
                this.processValueError((Field)object3, object);
            }
        }
    }

    public Object listFromJson(Class serializable, Object object) {
        if (serializable != null) {
            boolean bl2 = object instanceof JSONArray;
            if (bl2) {
                int n10;
                ArrayList arrayList = new ArrayList();
                object = (JSONArray)object;
                for (int i10 = 0; i10 < (n10 = object.length()); ++i10) {
                    Object object2 = object.get(i10);
                    boolean bl3 = false;
                    Class<?> clazz = null;
                    if ((object2 = this.valueFromJson((Class)serializable, null, object2)) == null) continue;
                    clazz = object2.getClass();
                    bl3 = serializable.equals(clazz);
                    if (bl3) {
                        arrayList.add((Class<?>)object2);
                        continue;
                    }
                    clazz = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("listFromJson error, memberClass:");
                    stringBuilder.append(serializable);
                    String string2 = ", valueClass:";
                    stringBuilder.append(string2);
                    object2 = object2.getClass();
                    stringBuilder.append(object2);
                    object2 = stringBuilder.toString();
                    com.huawei.updatesdk.a.a.c.a.a.a.b((String)((Object)clazz), (String)object2);
                }
                return arrayList;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("jsonobject is not JSONArray, jsonValue:");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            serializable = new IllegalArgumentException((String)object);
            throw serializable;
        }
        serializable = new IllegalArgumentException("generic type is null");
        throw serializable;
    }

    public String listToJson(List list) {
        char c10;
        int n10 = list.size();
        if (n10 <= 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (char c11 = '\u0000'; c11 < (c10 = list.size()); ++c11) {
            Object object = list.get(c11);
            if ((object = this.valueToJson(object)) == null) continue;
            stringBuilder.append((String)object);
            c10 = ',';
            stringBuilder.append(c10);
        }
        this.formatJsonStr(stringBuilder);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public Object mapFromJson(Class serializable, Object object) {
        if (serializable != null) {
            boolean bl2 = object instanceof JSONObject;
            if (bl2) {
                boolean bl3;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                object = (JSONObject)object;
                Iterator iterator2 = object.keys();
                while (bl3 = iterator2.hasNext()) {
                    String string2 = (String)iterator2.next();
                    Object object2 = object.get(string2);
                    boolean bl4 = false;
                    Serializable serializable2 = null;
                    if ((object2 = this.valueFromJson((Class)serializable, null, object2)) == null) continue;
                    serializable2 = object2.getClass();
                    bl4 = serializable.equals(serializable2);
                    if (bl4) {
                        linkedHashMap.put(string2, (Class<?>)object2);
                        continue;
                    }
                    string2 = TAG;
                    serializable2 = new StringBuilder();
                    ((StringBuilder)serializable2).append("mapFromJson error, memberClass:");
                    ((StringBuilder)serializable2).append(serializable);
                    String string3 = ", valueClass:";
                    ((StringBuilder)serializable2).append(string3);
                    object2 = object2.getClass();
                    ((StringBuilder)serializable2).append(object2);
                    object2 = ((StringBuilder)serializable2).toString();
                    com.huawei.updatesdk.a.a.c.a.a.a.b(string2, (String)object2);
                }
                return linkedHashMap;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("jsonobject is not JSONObject, jsonValue:");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            serializable = new IllegalArgumentException((String)object);
            throw serializable;
        }
        serializable = new IllegalArgumentException("generic type is null");
        throw serializable;
    }

    public String toJson() {
        char c10;
        Field[] fieldArray = f.a(this.getClass());
        int n10 = fieldArray.length;
        if (n10 <= 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (char c11 = '\u0000'; c11 < (c10 = fieldArray.length); ++c11) {
            Object object = fieldArray[c11];
            Object object2 = new b$a((Field)object);
            AccessController.doPrivileged(object2);
            object2 = fieldArray[c11].getName();
            object = fieldArray[c11];
            int n11 = ((AccessibleObject)object).isAnnotationPresent(SDKNetTransmission.class);
            String string2 = END_FLAG;
            if (n11 == 0 && (object2 == null || (n11 = ((String)object2).endsWith(string2)) == 0)) continue;
            n11 = ((String)object2).endsWith(string2);
            if (n11 != 0) {
                n11 = ((String)object2).length() + -1;
                object2 = ((String)object2).substring(0, n11);
            }
            object = fieldArray[c11].get(this);
            if ((object = this.valueToJson(object)) == null) continue;
            string2 = "\"";
            stringBuilder.append(string2);
            stringBuilder.append((String)object2);
            object2 = "\":";
            stringBuilder.append((String)object2);
            stringBuilder.append((String)object);
            c10 = ',';
            stringBuilder.append(c10);
        }
        this.formatJsonStr(stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

