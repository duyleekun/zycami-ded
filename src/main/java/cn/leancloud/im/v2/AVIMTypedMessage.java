/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessageManagerHelper;
import cn.leancloud.im.v2.annotation.AVIMMessageField;
import cn.leancloud.im.v2.annotation.AVIMMessageType;
import cn.leancloud.json.JSON;
import cn.leancloud.json.JSONObject;
import cn.leancloud.json.JSONObject$Builder;
import cn.leancloud.util.FieldAttribute;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class AVIMTypedMessage
extends AVIMMessage {
    private static final String KEY_MESSAGE_CONTENT = "msg";
    private static final String KEY_MESSAGE_FROM = "msg_from";
    private static final String KEY_MESSAGE_ID = "msg_mid";
    private static final String KEY_MESSAGE_TIMESTAMP = "msg_timestamp";
    public static ConcurrentMap fieldCache;
    private int messageType;

    static {
        ConcurrentHashMap concurrentHashMap;
        fieldCache = concurrentHashMap = new ConcurrentHashMap();
    }

    public AVIMTypedMessage() {
        this.initMessageType();
    }

    public AVIMTypedMessage(int n10) {
        this.initMessageType(n10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void computeFieldAttribute(Class clazz) {
        Class<Object> clazz2;
        Serializable serializable;
        Class clazz3 = clazz;
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        Object object = new LinkedList();
        for (serializable = clazz; serializable != null && serializable != (clazz2 = Object.class); serializable = ((Class)serializable).getSuperclass()) {
            Method[] methodArray = ((Class)serializable).getDeclaredMethods();
            AbstractMap.SimpleEntry<Method[], Class> simpleEntry = new AbstractMap.SimpleEntry<Method[], Class>(methodArray, (Class)serializable);
            object.add(simpleEntry);
        }
        Collections.reverse(object);
        object = object.iterator();
        block1: while (true) {
            boolean bl2;
            if (!(bl2 = object.hasNext())) {
                fieldCache.put(clazz3, hashMap);
                return;
            }
            serializable = (AbstractMap.SimpleEntry)object.next();
            Class clazz4 = (Class)((AbstractMap.SimpleEntry)serializable).getValue();
            serializable = (Method[])((AbstractMap.SimpleEntry)serializable).getKey();
            int n10 = ((Serializable)serializable).length;
            int n11 = 0;
            while (true) {
                block18: {
                    Object object2;
                    Object object3;
                    int n12;
                    boolean bl3;
                    Class clazz5;
                    Object object4;
                    Class clazz6;
                    Object object5;
                    boolean bl4;
                    int n13;
                    int n14;
                    int n15;
                    Object object6;
                    Serializable serializable2;
                    block21: {
                        block26: {
                            block28: {
                                block27: {
                                    block23: {
                                        block25: {
                                            block24: {
                                                boolean bl5;
                                                block19: {
                                                    block22: {
                                                        block20: {
                                                            Class<?>[] classArray;
                                                            Class<?>[] classArray2;
                                                            Class<?> clazz7;
                                                            if (n11 >= n10) continue block1;
                                                            serializable2 = serializable[n11];
                                                            object6 = ((Method)((Object)serializable2)).getName();
                                                            n15 = ((String)object6).length();
                                                            if (n15 < (n14 = 3) || (n15 = (int)(Modifier.isStatic(((Method)((Object)serializable2)).getModifiers()) ? 1 : 0)) || (n15 = (int)((clazz7 = ((Method)((Object)serializable2)).getReturnType()).equals(clazz3) ? 1 : 0)) || (n15 = (classArray2 = ((Method)((Object)serializable2)).getParameterTypes()).length) != (n13 = 1) && (n15 = (classArray = ((Method)((Object)serializable2)).getParameterTypes()).length)) break block18;
                                                            String string2 = "set";
                                                            bl4 = ((String)object6).startsWith(string2);
                                                            object5 = "get";
                                                            clazz6 = "is";
                                                            if (!bl4 && (bl4 = ((String)(object4 = ((Method)((Object)serializable2)).getName())).equals(clazz5 = "getMetaClass")) && (bl4 = ((String)(object4 = ((Method)((Object)serializable2)).getReturnType().getName())).equals(clazz5 = "groovy.lang.MetaClass")) && !(bl4 = ((String)object6).startsWith((String)object5)) && !(bl4 = ((String)object6).startsWith((String)((Object)clazz6)))) break block18;
                                                            n15 = (int)(((String)object6).startsWith(string2) ? 1 : 0);
                                                            bl4 = ((String)object6).startsWith((String)object5);
                                                            bl3 = ((String)object6).startsWith((String)((Object)clazz6));
                                                            n13 = 4;
                                                            if (!n15) break block19;
                                                            n12 = ((String)object6).charAt(n14);
                                                            bl5 = Character.isUpperCase((char)n12);
                                                            if (!bl5) break block20;
                                                            object3 = new StringBuilder();
                                                            n14 = Character.toLowerCase(((String)object6).charAt(n14));
                                                            ((StringBuilder)object3).append((char)n14);
                                                            object6 = ((String)object6).substring(n13);
                                                            ((StringBuilder)object3).append((String)object6);
                                                            object3 = ((StringBuilder)object3).toString();
                                                            break block21;
                                                        }
                                                        n14 = 95;
                                                        if (n12 != n14) break block22;
                                                        object3 = ((String)object6).substring(n13);
                                                        break block21;
                                                    }
                                                    n14 = 102;
                                                    if (n12 != n14) break block18;
                                                    n12 = 3;
                                                    object3 = ((String)object6).substring(n12);
                                                    break block21;
                                                }
                                                if (!bl4) break block23;
                                                n12 = ((String)object6).length();
                                                if (n12 < n13 || (n12 = (int)(((String)object6).equals(object3 = "getClass") ? 1 : 0))) break block18;
                                                n12 = 3;
                                                n14 = ((String)object6).charAt(n12);
                                                bl5 = Character.isUpperCase((char)n14);
                                                if (!bl5) break block24;
                                                object2 = new StringBuilder();
                                                n12 = Character.toLowerCase(((String)object6).charAt(n12));
                                                ((StringBuilder)object2).append((char)n12);
                                                object3 = ((String)object6).substring(n13);
                                                ((StringBuilder)object2).append((String)object3);
                                                object3 = ((StringBuilder)object2).toString();
                                                break block21;
                                            }
                                            n12 = 95;
                                            if (n14 != n12) break block25;
                                            object3 = ((String)object6).substring(n13);
                                            break block21;
                                        }
                                        n12 = 102;
                                        if (n14 != n12) break block18;
                                        n12 = 3;
                                        object3 = ((String)object6).substring(n12);
                                        break block21;
                                    }
                                    if (!bl3) break block26;
                                    n12 = 2;
                                    n14 = ((String)object6).charAt(n12);
                                    n13 = (int)(Character.isUpperCase((char)n14) ? 1 : 0);
                                    if (!n13) break block27;
                                    object2 = new StringBuilder();
                                    n12 = Character.toLowerCase(((String)object6).charAt(n12));
                                    ((StringBuilder)object2).append((char)n12);
                                    n13 = 3;
                                    object3 = ((String)object6).substring(n13);
                                    ((StringBuilder)object2).append((String)object3);
                                    object3 = ((StringBuilder)object2).toString();
                                    break block21;
                                }
                                n12 = 95;
                                n13 = 3;
                                if (n14 != n12) break block28;
                                object3 = ((String)object6).substring(n13);
                                break block21;
                            }
                            n12 = 102;
                            if (n14 != n12) break block18;
                            n12 = 2;
                            object3 = ((String)object6).substring(n12);
                            break block21;
                        }
                        n12 = 0;
                        object3 = null;
                    }
                    object6 = AVIMTypedMessage.getField(clazz4, (String)object3);
                    if (object6 == null && (bl3 || n15)) {
                        object6 = new StringBuilder();
                        ((StringBuilder)object6).append((String)((Object)clazz6));
                        n13 = 0;
                        clazz5 = null;
                        n14 = Character.toUpperCase(((String)object3).charAt(0));
                        ((StringBuilder)object6).append((char)n14);
                        n14 = 1;
                        clazz6 = ((String)object3).substring(n14);
                        ((StringBuilder)object6).append((String)((Object)clazz6));
                        object6 = ((StringBuilder)object6).toString();
                        object2 = AVIMTypedMessage.getField(clazz4, (String)object6);
                        if (object2 != null) {
                            object3 = object6;
                        }
                        object6 = object2;
                    } else {
                        n13 = 0;
                        clazz5 = null;
                    }
                    if (object6 != null && (object2 = ((Field)object6).getAnnotation(AVIMMessageField.class)) != null) {
                        object2 = object2.name();
                        boolean bl6 = hashMap.containsKey(object3);
                        if (bl6) {
                            clazz6 = (FieldAttribute)hashMap.get(object3);
                        } else {
                            bl6 = false;
                            clazz6 = null;
                        }
                        if (n15) {
                            if (clazz6 == null) {
                                bl4 = false;
                                object4 = null;
                                Class<?> clazz8 = ((Field)object6).getType();
                                object6 = clazz6;
                                CharSequence charSequence = object3;
                                object5 = serializable2;
                                clazz5 = clazz6;
                                clazz6 = clazz8;
                                object6 = new FieldAttribute((String)object3, (String)object2, null, (Method)((Object)serializable2), clazz8);
                                hashMap.put(object3, object6);
                            } else {
                                ((FieldAttribute)((Object)clazz6)).setSetterMethod((Method)((Object)serializable2));
                            }
                        } else if (bl3 || bl4) {
                            if (clazz6 == null) {
                                bl3 = false;
                                object5 = null;
                                clazz6 = ((Field)object6).getType();
                                object6 = clazz5;
                                Object object7 = object3;
                                object4 = serializable2;
                                clazz5 = new Class((String)object3, (String)object2, (Method)((Object)serializable2), null, clazz6);
                                hashMap.put(object3, clazz5);
                            } else {
                                ((FieldAttribute)((Object)clazz6)).setGetterMethod((Method)((Object)serializable2));
                            }
                        }
                        n12 = 1;
                        ((Method)((Object)serializable2)).setAccessible(n12 != 0);
                    }
                }
                ++n11;
            }
            break;
        }
    }

    private static Field getField(Class clazz, String string2) {
        try {
            return clazz.getDeclaredField(string2);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static AVIMMessage getMessage(String string2, String string3, String string4, String string5, long l10, long l11, long l12) {
        AVIMMessage aVIMMessage = new AVIMMessage(string2, string5, l10, l11, l12);
        aVIMMessage.setMessageId(string3);
        aVIMMessage.setContent(string4);
        return AVIMMessageManagerHelper.parseTypedMessage(aVIMMessage);
    }

    private void initMessageType() {
        int n10 = this.getClass().getAnnotation(AVIMMessageType.class).type();
        this.initMessageType(n10);
    }

    private void initMessageType(int n10) {
        this.messageType = n10;
    }

    public static AVIMMessage parseMessage(String string2, Map object) {
        Object object2;
        boolean bl2;
        if (object != null && (bl2 = object.containsKey(object2 = KEY_MESSAGE_ID))) {
            long l10;
            String string3 = KEY_MESSAGE_FROM;
            String string4 = string3 = object.get(string3);
            string4 = string3;
            string3 = KEY_MESSAGE_CONTENT;
            string3 = object.get(string3);
            Object object3 = KEY_MESSAGE_TIMESTAMP;
            object3 = object.get(object3);
            boolean bl3 = object3 instanceof Double;
            if (bl3) {
                object3 = (Double)object3;
                l10 = ((Double)object3).longValue();
            } else {
                bl3 = object3 instanceof Number;
                if (bl3) {
                    object3 = (Number)object3;
                    l10 = ((Number)object3).longValue();
                } else {
                    object3 = (Long)object3;
                    l10 = (Long)object3;
                }
            }
            object = object.get(object2);
            object = (String)object;
            long l11 = -1;
            object3 = object2;
            object2 = new AVIMMessage(string2, string4, l10, l11);
            ((AVIMMessage)object2).setMessageId((String)object);
            try {
                ((AVIMMessage)object2).setContent(string3);
                return AVIMMessageManagerHelper.parseTypedMessage((AVIMMessage)object2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public boolean equals(Object object) {
        int n10 = super.equals(object);
        boolean bl2 = false;
        if (n10 == 0) {
            return false;
        }
        n10 = this.messageType;
        object = (AVIMTypedMessage)object;
        int n11 = ((AVIMTypedMessage)object).messageType;
        if (n10 == n11) {
            bl2 = true;
        }
        return bl2;
    }

    public final String getContent() {
        int n10;
        int n11;
        Object object = fieldCache;
        Serializable serializable = this.getClass();
        boolean bl2 = object.containsKey(serializable);
        if (!bl2) {
            object = this.getClass();
            AVIMTypedMessage.computeFieldAttribute((Class)object);
        }
        object = fieldCache;
        serializable = this.getClass();
        if ((object = (Map)object.get(serializable)) != null && (n11 = object.size()) >= (n10 = 1)) {
            n11 = 0;
            serializable = JSONObject$Builder.create(null);
            n10 = this.getMessageType();
            Object object2 = n10;
            Object object3 = "_lctype";
            serializable.put(object3, object2);
            object = object.values().iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = (FieldAttribute)object.next();
                object3 = ((FieldAttribute)object2).get(this);
                object2 = ((FieldAttribute)object2).getAliaName();
                serializable.put(object2, object3);
            }
            return ((JSONObject)serializable).toJSONString();
        }
        return super.getContent();
    }

    public int getMessageType() {
        return this.messageType;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final void setContent(String object) {
        int n10;
        int n11;
        Map map = (Map)JSON.parseObject((String)object, Map.class);
        Object object2 = fieldCache;
        Class<?> clazz = this.getClass();
        boolean bl2 = object2.containsKey(clazz);
        if (!bl2) {
            object2 = this.getClass();
            AVIMTypedMessage.computeFieldAttribute((Class)object2);
        }
        object2 = fieldCache;
        clazz = this.getClass();
        if ((object2 = (Map)object2.get(clazz)) != null && (n11 = object2.size()) >= (n10 = 1)) {
            object = object2.values().iterator();
            while (bl2 = object.hasNext()) {
                Class clazz2;
                object2 = (FieldAttribute)object.next();
                clazz = ((FieldAttribute)object2).getAliaName();
                n10 = (clazz = map.get(clazz)) instanceof Map;
                if (n10 != 0 && (clazz2 = ((FieldAttribute)object2).getFieldType()) != null) {
                    clazz = JSON.toJSONString(clazz);
                    clazz2 = ((FieldAttribute)object2).getFieldType();
                    clazz = JSON.parseObject((String)((Object)clazz), clazz2);
                }
                ((FieldAttribute)object2).set(this, clazz);
            }
        } else {
            super.setContent((String)object);
        }
    }

    public void setMessageType(int n10) {
        this.messageType = n10;
    }
}

