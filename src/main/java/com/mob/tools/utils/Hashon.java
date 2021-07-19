/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.mob.tools.utils;

import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon$TabulateAdapter;
import com.mob.tools.utils.ReflectHelper;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class Hashon {
    private ArrayList arrayToList(Object list) {
        int n10;
        boolean bl2 = list instanceof byte[];
        if (bl2) {
            ArrayList<Byte> arrayList = new ArrayList<Byte>();
            for (Object object : (List<String>)((byte[])list)) {
                Byte by2 = (byte)object;
                arrayList.add(by2);
            }
            return arrayList;
        }
        bl2 = list instanceof short[];
        if (bl2) {
            ArrayList<Short> arrayList = new ArrayList<Short>();
            list = (List<String>)((short[])list);
            int n11 = ((Object)list).length;
            while (n10 < n11) {
                Object object = list[n10];
                Short s10 = (short)object;
                arrayList.add(s10);
                ++n10;
            }
            return arrayList;
        }
        bl2 = list instanceof int[];
        if (bl2) {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            list = (List<String>)((int[])list);
            int n12 = ((Object)list).length;
            while (n10 < n12) {
                Object object = list[n10];
                Integer n13 = (int)object;
                arrayList.add(n13);
                ++n10;
            }
            return arrayList;
        }
        bl2 = list instanceof long[];
        if (bl2) {
            ArrayList<Long> arrayList = new ArrayList<Long>();
            list = (List<String>)((long[])list);
            int n14 = ((Object)list).length;
            while (n10 < n14) {
                Object object = list[n10];
                Long l10 = (long)object;
                arrayList.add(l10);
                ++n10;
            }
            return arrayList;
        }
        bl2 = list instanceof float[];
        if (bl2) {
            ArrayList<Float> arrayList = new ArrayList<Float>();
            list = (List<String>)((float[])list);
            int n15 = ((Object)list).length;
            while (n10 < n15) {
                Object object = list[n10];
                Float f10 = Float.valueOf((float)object);
                arrayList.add(f10);
                ++n10;
            }
            return arrayList;
        }
        bl2 = list instanceof double[];
        if (bl2) {
            ArrayList<Double> arrayList = new ArrayList<Double>();
            list = (List<String>)((double[])list);
            int n16 = ((Object)list).length;
            while (n10 < n16) {
                Object object = list[n10];
                Double d10 = (double)object;
                arrayList.add(d10);
                ++n10;
            }
            return arrayList;
        }
        bl2 = list instanceof char[];
        if (bl2) {
            ArrayList<Character> arrayList = new ArrayList<Character>();
            list = (List<String>)((char[])list);
            int n17 = ((Object)list).length;
            while (n10 < n17) {
                Object object = list[n10];
                Character c10 = Character.valueOf((char)object);
                arrayList.add(c10);
                ++n10;
            }
            return arrayList;
        }
        bl2 = list instanceof boolean[];
        if (bl2) {
            ArrayList<Boolean> arrayList = new ArrayList<Boolean>();
            list = (List<String>)((boolean[])list);
            int n18 = ((Object)list).length;
            while (n10 < n18) {
                List<String> list2 = list[n10];
                Boolean bl3 = Boolean.valueOf(list2);
                arrayList.add(bl3);
                ++n10;
            }
            return arrayList;
        }
        bl2 = list instanceof String[];
        if (bl2) {
            list = Arrays.asList((String[])list);
            ArrayList<String> arrayList = new ArrayList<String>(list);
            return arrayList;
        }
        return null;
    }

    private String format(String string2, ArrayList object) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[\n");
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string2);
        charSequence.append("\t");
        charSequence = charSequence.toString();
        object = ((ArrayList)object).iterator();
        int n10 = 0;
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            if (n10 > 0) {
                String string3 = ",\n";
                stringBuilder.append(string3);
            }
            stringBuilder.append((String)charSequence);
            char c10 = object2 instanceof HashMap;
            if (c10 != '\u0000') {
                object2 = (HashMap)object2;
                object2 = this.format((String)charSequence, (HashMap)object2);
                stringBuilder.append((String)object2);
            } else {
                c10 = object2 instanceof ArrayList;
                if (c10 != '\u0000') {
                    object2 = (ArrayList)object2;
                    object2 = this.format((String)charSequence, (ArrayList)object2);
                    stringBuilder.append((String)object2);
                } else {
                    c10 = object2 instanceof String;
                    if (c10 != '\u0000') {
                        c10 = '\"';
                        stringBuilder.append(c10);
                        stringBuilder.append(object2);
                        stringBuilder.append(c10);
                    } else {
                        stringBuilder.append(object2);
                    }
                }
            }
            ++n10;
        }
        stringBuilder.append('\n');
        stringBuilder.append(string2);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private String format(String string2, HashMap object) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string2);
        charSequence.append("\t");
        charSequence = charSequence.toString();
        object = ((HashMap)object).entrySet().iterator();
        int n10 = 0;
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            if (n10 > 0) {
                String string3 = ",\n";
                stringBuilder.append(string3);
            }
            stringBuilder.append((String)charSequence);
            char c10 = '\"';
            stringBuilder.append(c10);
            String string4 = (String)object2.getKey();
            stringBuilder.append(string4);
            string4 = "\":";
            stringBuilder.append(string4);
            object2 = object2.getValue();
            boolean bl3 = object2 instanceof HashMap;
            if (bl3) {
                object2 = (HashMap)object2;
                object2 = this.format((String)charSequence, (HashMap)object2);
                stringBuilder.append((String)object2);
            } else {
                bl3 = object2 instanceof ArrayList;
                if (bl3) {
                    object2 = (ArrayList)object2;
                    object2 = this.format((String)charSequence, (ArrayList)object2);
                    stringBuilder.append((String)object2);
                } else {
                    bl3 = object2 instanceof String;
                    if (bl3) {
                        stringBuilder.append(c10);
                        stringBuilder.append(object2);
                        stringBuilder.append(c10);
                    } else {
                        stringBuilder.append(object2);
                    }
                }
            }
            ++n10;
        }
        stringBuilder.append('\n');
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    private ArrayList fromJson(JSONArray jSONArray) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n10 = jSONArray.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = jSONArray.opt(i10);
            boolean bl2 = object instanceof JSONObject;
            if (bl2) {
                object = (JSONObject)object;
                object = this.fromJson((JSONObject)object);
            } else {
                bl2 = object instanceof JSONArray;
                if (bl2) {
                    object = (JSONArray)object;
                    object = this.fromJson((JSONArray)object);
                }
            }
            arrayList.add(object);
        }
        return arrayList;
    }

    private HashMap fromJson(JSONObject jSONObject) {
        boolean bl2;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Iterator iterator2 = jSONObject.keys();
        while (bl2 = iterator2.hasNext()) {
            Object object = JSONObject.NULL;
            String string2 = (String)iterator2.next();
            Object object2 = jSONObject.opt(string2);
            boolean bl3 = object.equals(object2);
            if (bl3) {
                object2 = null;
            }
            if (object2 == null) continue;
            bl3 = object2 instanceof JSONObject;
            if (bl3) {
                object2 = (JSONObject)object2;
                object2 = this.fromJson((JSONObject)object2);
            } else {
                bl3 = object2 instanceof JSONArray;
                if (bl3) {
                    object2 = (JSONArray)object2;
                    object2 = this.fromJson((JSONArray)object2);
                }
            }
            hashMap.put(string2, object2);
        }
        return hashMap;
    }

    private JSONArray getJSONArray(ArrayList object) {
        boolean bl2;
        JSONArray jSONArray = new JSONArray();
        object = ((ArrayList)object).iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            boolean bl3 = object2 instanceof HashMap;
            if (bl3) {
                object2 = (HashMap)object2;
                object2 = this.getJSONObject((HashMap)object2);
            } else {
                bl3 = object2 instanceof ArrayList;
                if (bl3) {
                    object2 = (ArrayList)object2;
                    object2 = this.getJSONArray((ArrayList)object2);
                }
            }
            jSONArray.put(object2);
        }
        return jSONArray;
    }

    private JSONObject getJSONObject(HashMap object) {
        boolean bl2;
        JSONObject jSONObject = new JSONObject();
        object = ((HashMap)object).entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            Object object3 = object2.getValue();
            boolean bl3 = object3 instanceof HashMap;
            if (bl3) {
                object3 = (HashMap)object3;
                object3 = this.getJSONObject((HashMap)object3);
            } else {
                bl3 = object3 instanceof ArrayList;
                if (bl3) {
                    object3 = (ArrayList)object3;
                    object3 = this.getJSONArray((ArrayList)object3);
                } else {
                    bl3 = this.isBasicArray(object3);
                    if (bl3) {
                        object3 = this.arrayToList(object3);
                        object3 = this.getJSONArray((ArrayList)object3);
                    }
                }
            }
            object2 = (String)object2.getKey();
            jSONObject.put((String)object2, object3);
        }
        return jSONObject;
    }

    private boolean isBasicArray(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof byte[];
        if (!(bl3 || (bl3 = object instanceof short[]) || (bl3 = object instanceof int[]) || (bl3 = object instanceof long[]) || (bl3 = object instanceof float[]) || (bl3 = object instanceof double[]) || (bl3 = object instanceof char[]) || (bl3 = object instanceof boolean[]) || (bl2 = object instanceof String[]))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private Object tabulate(Object iterator2) {
        Object object;
        boolean bl2;
        if (!(iterator2 == null || (bl2 = ((Class)(object = iterator2.getClass())).isPrimitive()) || (bl2 = iterator2 instanceof String) || (bl2 = iterator2 instanceof Number) || (bl2 = iterator2 instanceof Character) || (bl2 = iterator2 instanceof Boolean))) {
            boolean bl3;
            Class<Object> clazz;
            boolean bl4;
            int n10;
            bl2 = iterator2 instanceof Hashon$TabulateAdapter;
            if (bl2) {
                iterator2 = ((Hashon$TabulateAdapter)((Object)iterator2)).tabulate();
                return this.tabulate(iterator2);
            }
            bl2 = iterator2 instanceof Enum;
            if (bl2) {
                object = new HashMap();
                iterator2 = ((Enum)((Object)iterator2)).name();
                ((HashMap)object).put("enum", iterator2);
                return object;
            }
            object = iterator2.getClass();
            bl2 = ((Class)object).isArray();
            Object object3 = null;
            if (bl2) {
                object = new ArrayList();
                int n11 = Array.getLength(iterator2);
                for (n10 = 0; n10 < n11; ++n10) {
                    Object object4 = Array.get(iterator2, n10);
                    object4 = this.tabulate(object4);
                    ((ArrayList)object).add(object4);
                }
                return object;
            }
            bl2 = iterator2 instanceof Collection;
            if (bl2) {
                object = new ArrayList();
                iterator2 = ((Collection)((Object)iterator2)).iterator();
                while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                    object3 = iterator2.next();
                    object3 = this.tabulate(object3);
                    ((ArrayList)object).add(object3);
                }
                return object;
            }
            bl2 = iterator2 instanceof Map;
            if (bl2) {
                object = new HashMap();
                iterator2 = ((Map)((Object)iterator2)).entrySet().iterator();
                while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                    object3 = (Map.Entry)iterator2.next();
                    Object object2 = object3.getKey();
                    boolean bl5 = object2 instanceof String;
                    if (!bl5) continue;
                    object3 = object3.getValue();
                    object2 = (String)object2;
                    object3 = this.tabulate(object3);
                    ((HashMap)object).put(object2, object3);
                }
                return object;
            }
            object = iterator2.getClass();
            Object object4 = new ArrayList();
            while (!(bl4 = object.equals(clazz = Object.class))) {
                ((ArrayList)object4).add(0, object);
                object = ((Class)object).getSuperclass();
            }
            object = new ArrayList();
            object4 = ((ArrayList)object4).iterator();
            while (bl4 = object4.hasNext()) {
                for (Field field : ((Class)object4.next()).getDeclaredFields()) {
                    String string2;
                    String string3;
                    boolean bl6 = Modifier.isStatic(field.getModifiers());
                    if (bl6 || (bl6 = (string3 = field.getName()).contains(string2 = "$"))) continue;
                    ((ArrayList)object).add(field);
                }
            }
            object3 = new HashMap();
            object = ((ArrayList)object).iterator();
            while (bl3 = object.hasNext()) {
                object4 = (Field)object.next();
                bl4 = true;
                ((Field)object4).setAccessible(bl4);
                Object object5 = ((Field)object4).get(iterator2);
                object4 = ((Field)object4).getName();
                Object object6 = this.tabulate(object5);
                ((HashMap)object3).put(object4, object6);
            }
            return object3;
        }
        return iterator2;
    }

    private Object tabulate(Object object, Class object2, Type[] object3) {
        boolean bl2;
        Object object4;
        boolean bl3;
        Class<Object> clazz = Character.class;
        Object object5 = Boolean.class;
        Object object6 = Object.class;
        boolean n10 = ((Class)object2).isPrimitive();
        Object object7 = null;
        if (!(n10 || (bl3 = (object4 = Number.class).isAssignableFrom((Class<?>)object2)) || (bl2 = object2.equals(clazz)))) {
            boolean bl4;
            clazz = Hashon$TabulateAdapter.class;
            boolean bl5 = clazz.isAssignableFrom((Class<?>)object2);
            boolean bl6 = true;
            if (bl5) {
                try {
                    object2 = ((Class)object2).getName();
                }
                catch (Throwable throwable) {
                    return null;
                }
                object2 = ReflectHelper.importClass((String)object2);
                object3 = "valueOf";
                clazz = new Object[bl6];
                clazz[0] = object;
                return ReflectHelper.invokeStaticMethod((String)object2, (String)object3, (Object[])clazz);
            }
            clazz = String.class;
            boolean bl7 = object2.equals(clazz);
            if (!bl7 && !(bl4 = object2.equals(object5))) {
                boolean bl8;
                Object object8;
                boolean bl9;
                boolean bl10;
                int n11;
                boolean bl11 = ((Class)object2).isEnum();
                if (bl11) {
                    object = String.valueOf(((HashMap)object).get("enum"));
                    return Enum.valueOf(object2, (String)object);
                }
                boolean bl12 = ((Class)object2).isArray();
                if (bl12) {
                    object = (ArrayList)object;
                    object2 = ((Class)object2).getComponentType();
                    int n12 = ((ArrayList)object).size();
                    object3 = Array.newInstance(object2, n12);
                    int n13 = ((ArrayList)object).size();
                    for (n11 = 0; n11 < n13; ++n11) {
                        object5 = ((ArrayList)object).get(n11);
                        object5 = this.tabulate(object5, (Class)object2, null);
                        Array.set(object3, n11, object5);
                    }
                    return object3;
                }
                clazz = Collection.class;
                boolean bl13 = clazz.isAssignableFrom((Class<?>)object2);
                if (bl13) {
                    int n14;
                    object2 = (Collection)((Class)object2).newInstance();
                    if (object3 != null && (n14 = ((Object)object3).length) > 0) {
                        object3 = object3[0];
                    } else {
                        boolean bl14 = false;
                        object3 = null;
                    }
                    object = (ArrayList)object;
                    int n15 = ((ArrayList)object).size();
                    while (n11 < n15) {
                        boolean bl15;
                        if (object3 != null && (bl15 = object3 instanceof Class) && !(bl15 = object3.equals(object6))) {
                            object5 = ((ArrayList)object).get(n11);
                            object4 = object3;
                            object4 = (Class)object3;
                            object5 = this.tabulate(object5, (Class)object4, null);
                            object2.add(object5);
                        } else if (object3 != null && (bl15 = object3 instanceof ParameterizedType)) {
                            object5 = object3;
                            object5 = (ParameterizedType)object3;
                            object4 = object5.getActualTypeArguments();
                            object5 = (Class)object5.getRawType();
                            Object e10 = ((ArrayList)object).get(n11);
                            object5 = this.tabulate(e10, (Class)object5, (Type[])object4);
                            object2.add(object5);
                        } else {
                            object5 = ((ArrayList)object).get(n11);
                            object2.add(object5);
                        }
                        ++n11;
                    }
                    return object2;
                }
                clazz = Map.class;
                boolean bl16 = clazz.isAssignableFrom((Class<?>)object2);
                if (bl16) {
                    boolean bl17;
                    boolean bl18;
                    object2 = (Map)((Class)object2).newInstance();
                    if (object3 != null && (bl18 = ((Object)object3).length) > bl6) {
                        clazz = object3[0];
                        object3 = object3[bl6];
                    } else {
                        boolean bl19 = false;
                        object3 = null;
                        boolean bl20 = false;
                        clazz = null;
                    }
                    object = (HashMap)object;
                    object5 = ((HashMap)object).keySet().iterator();
                    while (bl17 = object5.hasNext()) {
                        boolean bl21;
                        Object object9;
                        object4 = object5.next();
                        if (clazz != null && (n11 = clazz instanceof Class) != 0 && (n11 = (int)(object3.equals(object6) ? 1 : 0)) == 0) {
                            object7 = clazz;
                            object7 = clazz;
                            object7 = this.tabulate(object4, (Class)object7, null);
                        } else if (clazz != null && (n11 = clazz instanceof ParameterizedType) != 0) {
                            object7 = clazz;
                            object7 = (ParameterizedType)((Object)clazz);
                            object9 = object7.getActualTypeArguments();
                            object7 = (Class)object7.getRawType();
                            object7 = this.tabulate(object4, (Class)object7, (Type[])object9);
                        } else {
                            object7 = object4;
                        }
                        if (object3 != null && (bl21 = object3 instanceof Class) && !(bl21 = object3.equals(object6))) {
                            object4 = ((HashMap)object).get(object4);
                            object9 = object3;
                            object9 = (Class)object3;
                            object4 = this.tabulate(object4, (Class)object9, null);
                        } else if (object3 != null && (bl21 = object3 instanceof ParameterizedType)) {
                            object9 = object3;
                            object9 = (ParameterizedType)object3;
                            Type[] typeArray = object9.getActualTypeArguments();
                            object9 = (Class)object9.getRawType();
                            object4 = ((HashMap)object).get(object4);
                            object4 = this.tabulate(object4, (Class)object9, typeArray);
                        } else {
                            object4 = ((HashMap)object).get(object4);
                        }
                        object2.put(object7, object4);
                    }
                    return object2;
                }
                object3 = new ArrayList();
                clazz = object2;
                while (!(bl10 = clazz.equals(object6))) {
                    ((ArrayList)object3).add(clazz);
                    clazz = clazz.getSuperclass();
                }
                object = (HashMap)object;
                clazz = new Class<Object>();
                object5 = ((HashMap)object).keySet().iterator();
                block12: while (bl9 = object5.hasNext()) {
                    object6 = (String)object5.next();
                    object8 = ((HashMap)object).get(object6);
                    if (object8 == null) continue;
                    object8 = ((ArrayList)object3).iterator();
                    while (bl8 = object8.hasNext()) {
                        AnnotatedElement annotatedElement = (Class)object8.next();
                        try {
                            annotatedElement = annotatedElement.getDeclaredField((String)object6);
                        }
                        catch (Throwable throwable) {
                            bl8 = false;
                            annotatedElement = null;
                        }
                        if (annotatedElement == null) continue;
                        ((HashMap)((Object)clazz)).put(object6, annotatedElement);
                        continue block12;
                    }
                }
                object2 = ReflectHelper.getName((Class)object2);
                object3 = new Object[]{};
                object2 = ReflectHelper.newInstance((String)object2, (Object[])object3);
                object3 = ((HashMap)((Object)clazz)).keySet().iterator();
                while (bl10 = object3.hasNext()) {
                    object5 = (String)object3.next();
                    object6 = ((HashMap)object).get(object5);
                    object5 = (Field)((HashMap)((Object)clazz)).get(object5);
                    object7 = ((Field)object5).getType();
                    object8 = ((Field)object5).getGenericType();
                    bl8 = object8 instanceof ParameterizedType;
                    if (bl8) {
                        object8 = ((ParameterizedType)object8).getActualTypeArguments();
                    } else {
                        boolean bl22 = false;
                        object8 = null;
                    }
                    ((Field)object5).setAccessible(bl6);
                    object6 = this.tabulate(object6, (Class)object7, (Type[])object8);
                    ((Field)object5).set(object2, object6);
                }
                return object2;
            }
            return object;
        }
        object3 = Boolean.TYPE;
        boolean bl23 = object2.equals(object3);
        if (!bl23 && !(bl23 = object2.equals(object5))) {
            object3 = Character.TYPE;
            bl23 = object2.equals(object3);
            if (!bl23 && !(bl23 = object2.equals(clazz))) {
                object3 = Byte.TYPE;
                bl23 = object2.equals(object3);
                if (!bl23 && !(bl23 = object2.equals(object3 = Byte.class))) {
                    object3 = Short.TYPE;
                    bl23 = object2.equals(object3);
                    if (!bl23 && !(bl23 = object2.equals(object3 = Short.class))) {
                        object3 = Integer.TYPE;
                        bl23 = object2.equals(object3);
                        if (!bl23 && !(bl23 = object2.equals(object3 = Integer.class))) {
                            object3 = Long.TYPE;
                            bl23 = object2.equals(object3);
                            if (!bl23 && !(bl23 = object2.equals(object3 = Long.class))) {
                                boolean bl24;
                                object3 = Float.TYPE;
                                bl23 = object2.equals(object3);
                                if (!bl23 && !(bl24 = object2.equals(object3 = Float.class))) {
                                    return Double.valueOf(String.valueOf(object));
                                }
                                return Float.valueOf(String.valueOf(object));
                            }
                            return Long.valueOf(String.valueOf(object));
                        }
                        return Integer.valueOf(String.valueOf(object));
                    }
                    return Short.valueOf(String.valueOf(object));
                }
                return Byte.valueOf(String.valueOf(object));
            }
            return Character.valueOf(String.valueOf(object).charAt(0));
        }
        object = String.valueOf(object);
        return "true".equals(object);
    }

    public String format(String object) {
        String string2 = "";
        try {
            object = this.fromJson((String)object);
        }
        catch (Throwable throwable) {
            MobLog.getInstance().w(throwable);
            return string2;
        }
        return this.format(string2, (HashMap)object);
    }

    public String fromHashMap(HashMap hashMap) {
        block3: {
            String string2 = "";
            try {
                hashMap = this.getJSONObject(hashMap);
                if (hashMap != null) break block3;
                return string2;
            }
            catch (Throwable throwable) {
                MobLog.getInstance().w(throwable);
                return string2;
            }
        }
        return hashMap.toString();
    }

    public Object fromJson(String object, Class clazz) {
        boolean bl2;
        Object object2 = this.fromJson((String)object);
        Object object3 = "[";
        boolean bl3 = ((String)object).startsWith((String)object3);
        if (bl3 && (bl2 = ((String)object).endsWith((String)(object3 = "]")))) {
            object = "fakelist";
            object2 = ((HashMap)object2).get(object);
        }
        bl2 = false;
        object = null;
        object3 = clazz.getGenericSuperclass();
        boolean bl4 = object3 instanceof ParameterizedType;
        if (bl4) {
            object3 = (ParameterizedType)object3;
            object3 = object3.getActualTypeArguments();
        } else {
            bl3 = false;
            object3 = null;
        }
        try {
            object = this.tabulate(object2, clazz, (Type[])object3);
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).w(throwable);
        }
        return object;
    }

    public HashMap fromJson(String object) {
        boolean bl2;
        if (object != null && !(bl2 = ((String)object).isEmpty())) {
            CharSequence charSequence;
            block12: {
                charSequence = "[";
                try {
                    bl2 = ((String)object).startsWith((String)charSequence);
                    if (!bl2) break block12;
                    charSequence = "]";
                }
                catch (Throwable throwable) {
                    MobLog.getInstance().w((String)object);
                    MobLog.getInstance().w(throwable);
                    object = new HashMap();
                    return object;
                }
                bl2 = ((String)object).endsWith((String)charSequence);
                if (!bl2) break block12;
                charSequence = new StringBuilder();
                String string2 = "{\"fakelist\":";
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append((String)object);
                string2 = "}";
                ((StringBuilder)charSequence).append(string2);
                object = ((StringBuilder)charSequence).toString();
            }
            charSequence = new JSONObject(object);
            return this.fromJson((JSONObject)charSequence);
        }
        object = new HashMap();
        return object;
    }

    public String fromObject(Object object) {
        HashMap<String, Object> hashMap;
        try {
            object = this.tabulate(object);
        }
        catch (Throwable throwable) {
            hashMap = MobLog.getInstance();
            ((NLog)((Object)hashMap)).w(throwable);
            object = null;
        }
        if (object == null) {
            return "";
        }
        boolean bl2 = object instanceof ArrayList;
        if (bl2) {
            hashMap = new HashMap<String, Object>();
            hashMap.put("list", object);
            object = this.fromHashMap(hashMap);
            int n10 = ((String)object).length() + -1;
            return ((String)object).substring(8, n10).trim();
        }
        object = (HashMap)object;
        return this.fromHashMap((HashMap)object);
    }
}

