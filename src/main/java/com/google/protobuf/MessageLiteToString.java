/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$ExtendableMessage;
import com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor;
import com.google.protobuf.MessageLite;
import com.google.protobuf.TextFormatEscaper;
import com.google.protobuf.UnknownFieldSetLite;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final String LIST_SUFFIX = "List";
    private static final String MAP_SUFFIX = "Map";

    private static final String camelCaseToSnakeCase(String string2) {
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i10 = 0; i10 < (n10 = string2.length()); ++i10) {
            n10 = string2.charAt(i10);
            boolean bl2 = Character.isUpperCase((char)n10);
            if (bl2) {
                String string3 = "_";
                stringBuilder.append(string3);
            }
            n10 = Character.toLowerCase((char)n10);
            stringBuilder.append((char)n10);
        }
        return stringBuilder.toString();
    }

    private static boolean isDefaultValue(Object object) {
        boolean bl2 = object instanceof Boolean;
        boolean bl3 = true;
        if (bl2) {
            return (Boolean)object ^ bl3;
        }
        bl2 = object instanceof Integer;
        if (bl2) {
            int n10 = (Integer)(object = (Integer)object);
            if (n10 != 0) {
                bl3 = false;
            }
            return bl3;
        }
        bl2 = object instanceof Float;
        if (bl2) {
            object = (Float)object;
            float f10 = ((Float)object).floatValue();
            bl2 = false;
            Object var5_8 = null;
            float f11 = f10 - 0.0f;
            Object object2 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
            if (object2 != false) {
                bl3 = false;
            }
            return bl3;
        }
        bl2 = object instanceof Double;
        if (bl2) {
            double d10;
            double d11 = (Double)(object = (Double)object);
            double d12 = d11 - (d10 = 0.0);
            Object object3 = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
            if (object3 != false) {
                bl3 = false;
            }
            return bl3;
        }
        bl2 = object instanceof String;
        if (bl2) {
            return object.equals("");
        }
        bl2 = object instanceof ByteString;
        if (bl2) {
            ByteString byteString = ByteString.EMPTY;
            return object.equals(byteString);
        }
        bl2 = object instanceof MessageLite;
        if (bl2) {
            Object object4 = object;
            object4 = ((MessageLite)object).getDefaultInstanceForType();
            if (object != object4) {
                bl3 = false;
            }
            return bl3;
        }
        bl2 = object instanceof Enum;
        if (bl2) {
            int n11 = ((Enum)(object = (Enum)object)).ordinal();
            if (n11 != 0) {
                bl3 = false;
            }
            return bl3;
        }
        return false;
    }

    public static final void printField(StringBuilder stringBuilder, int n10, String string2, Object object) {
        char c10;
        int n11 = object instanceof List;
        if (n11 != 0) {
            object = ((List)object).iterator();
            while ((n11 = object.hasNext()) != 0) {
                Object e10 = object.next();
                MessageLiteToString.printField(stringBuilder, n10, string2, e10);
            }
            return;
        }
        n11 = object instanceof Map;
        if (n11 != 0) {
            object = ((Map)object).entrySet().iterator();
            while ((n11 = object.hasNext()) != 0) {
                Map.Entry entry = (Map.Entry)object.next();
                MessageLiteToString.printField(stringBuilder, n10, string2, entry);
            }
            return;
        }
        stringBuilder.append('\n');
        n11 = 0;
        Object var5_7 = null;
        char c11 = '\u0000';
        String string3 = null;
        while (true) {
            c10 = ' ';
            if (c11 >= n10) break;
            stringBuilder.append(c10);
            ++c11;
        }
        stringBuilder.append(string2);
        int n12 = object instanceof String;
        c11 = '\"';
        String string4 = ": \"";
        if (n12 != 0) {
            stringBuilder.append(string4);
            object = (String)object;
            String string5 = TextFormatEscaper.escapeText((String)object);
            stringBuilder.append(string5);
            stringBuilder.append(c11);
        } else {
            n12 = object instanceof ByteString;
            if (n12 != 0) {
                stringBuilder.append(string4);
                object = (ByteString)object;
                String string6 = TextFormatEscaper.escapeBytes((ByteString)object);
                stringBuilder.append(string6);
                stringBuilder.append(c11);
            } else {
                n12 = object instanceof GeneratedMessageLite;
                string3 = "}";
                string4 = "\n";
                String string7 = " {";
                if (n12 != 0) {
                    stringBuilder.append(string7);
                    object = (GeneratedMessageLite)object;
                    n12 = n10 + 2;
                    MessageLiteToString.reflectivePrintWithIndent((MessageLite)object, stringBuilder, n12);
                    stringBuilder.append(string4);
                    while (n11 < n10) {
                        stringBuilder.append(c10);
                        ++n11;
                    }
                    stringBuilder.append(string3);
                } else {
                    n12 = object instanceof Map.Entry;
                    if (n12 != 0) {
                        stringBuilder.append(string7);
                        object = (Map.Entry)object;
                        n12 = n10 + 2;
                        string7 = object.getKey();
                        String string8 = "key";
                        MessageLiteToString.printField(stringBuilder, n12, string8, string7);
                        object = object.getValue();
                        string7 = "value";
                        MessageLiteToString.printField(stringBuilder, n12, string7, object);
                        stringBuilder.append(string4);
                        while (n11 < n10) {
                            stringBuilder.append(c10);
                            ++n11;
                        }
                        stringBuilder.append(string3);
                    } else {
                        stringBuilder.append(": ");
                        String string9 = object.toString();
                        stringBuilder.append(string9);
                    }
                }
            }
        }
    }

    private static void reflectivePrintWithIndent(MessageLite object, StringBuilder stringBuilder, int n10) {
        int n11;
        int n12;
        Object object2;
        Object[] objectArray;
        String string2;
        Object object3 = new HashMap();
        Object object4 = new HashMap();
        Object object5 = new TreeSet();
        Object object6 = object.getClass().getDeclaredMethods();
        int n13 = ((Method[])object6).length;
        int n14 = 0;
        Object[] objectArray2 = null;
        while (true) {
            string2 = "get";
            if (n14 >= n13) break;
            objectArray = object6[n14];
            object2 = objectArray.getName();
            object4.put(object2, objectArray);
            object2 = objectArray.getParameterTypes();
            n12 = ((Class<?>[])object2).length;
            if (n12 == 0) {
                object2 = objectArray.getName();
                object3.put(object2, objectArray);
                object2 = objectArray.getName();
                boolean bl2 = ((String)object2).startsWith(string2);
                if (bl2) {
                    string2 = objectArray.getName();
                    object5.add(string2);
                }
            }
            ++n14;
        }
        object5 = object5.iterator();
        while ((n11 = object5.hasNext()) != 0) {
            boolean bl3;
            object6 = (String)object5.next();
            n13 = (int)(((String)object6).startsWith(string2) ? 1 : 0);
            n14 = 3;
            Object object7 = n13 != 0 ? ((String)object6).substring(n14) : object6;
            objectArray = LIST_SUFFIX;
            n12 = (int)(((String)object7).endsWith((String)objectArray) ? 1 : 0);
            int n15 = 1;
            if (n12 != 0 && (n12 = (int)(((String)object7).endsWith((String)(object2 = BUILDER_LIST_SUFFIX)) ? 1 : 0)) == 0 && !(bl3 = ((String)object7).equals(objectArray))) {
                Class<List> clazz;
                Class<?> clazz2;
                boolean bl4;
                objectArray = new StringBuilder();
                object2 = ((String)object7).substring(0, n15).toLowerCase();
                objectArray.append((String)object2);
                n12 = ((String)object7).length() + -4;
                object2 = ((String)object7).substring(n15, n12);
                objectArray.append((String)object2);
                objectArray = objectArray.toString();
                object2 = (Method)object3.get(object6);
                if (object2 != null && (bl4 = (clazz2 = ((Method)object2).getReturnType()).equals(clazz = List.class))) {
                    object6 = MessageLiteToString.camelCaseToSnakeCase(objectArray);
                    object7 = new Object[]{};
                    object7 = GeneratedMessageLite.invokeOrDie((Method)object2, object, (Object[])object7);
                    MessageLiteToString.printField(stringBuilder, n10, (String)object6, object7);
                    continue;
                }
            }
            if ((n12 = (int)(((String)object7).endsWith((String)(objectArray = MAP_SUFFIX)) ? 1 : 0)) != 0 && !(bl3 = ((String)object7).equals(objectArray))) {
                objectArray = new StringBuilder();
                object2 = ((String)object7).substring(0, n15).toLowerCase();
                objectArray.append((String)object2);
                n12 = ((String)object7).length() - n14;
                objectArray2 = ((String)object7).substring(n15, n12);
                objectArray.append((String)objectArray2);
                objectArray2 = objectArray.toString();
                object6 = (Method)object3.get(object6);
                if (object6 != null && (bl3 = (objectArray = ((Method)object6).getReturnType()).equals(object2 = Map.class)) && !(bl3 = ((AccessibleObject)object6).isAnnotationPresent((Class<? extends Annotation>)(objectArray = Deprecated.class))) && (bl3 = Modifier.isPublic(((Method)object6).getModifiers()))) {
                    object7 = MessageLiteToString.camelCaseToSnakeCase((String)objectArray2);
                    objectArray2 = new Object[]{};
                    object6 = GeneratedMessageLite.invokeOrDie((Method)object6, object, objectArray2);
                    MessageLiteToString.printField(stringBuilder, n10, (String)object7, object6);
                    continue;
                }
            }
            object6 = new StringBuilder();
            objectArray2 = "set";
            ((StringBuilder)object6).append((String)objectArray2);
            ((StringBuilder)object6).append((String)object7);
            object6 = ((StringBuilder)object6).toString();
            if ((object6 = (Method)object4.get(object6)) == null) continue;
            object6 = BYTES_SUFFIX;
            n11 = (int)(((String)object7).endsWith((String)object6) ? 1 : 0);
            if (n11 != 0) {
                object6 = new StringBuilder();
                ((StringBuilder)object6).append(string2);
                n14 = ((String)object7).length() + -5;
                objectArray2 = ((String)object7).substring(0, n14);
                ((StringBuilder)object6).append((String)objectArray2);
                object6 = ((StringBuilder)object6).toString();
                n11 = (int)(object3.containsKey(object6) ? 1 : 0);
                if (n11 != 0) continue;
            }
            object6 = new StringBuilder();
            objectArray2 = ((String)object7).substring(0, n15).toLowerCase();
            ((StringBuilder)object6).append((String)objectArray2);
            objectArray2 = ((String)object7).substring(n15);
            ((StringBuilder)object6).append((String)objectArray2);
            object6 = ((StringBuilder)object6).toString();
            objectArray2 = new StringBuilder();
            objectArray2.append(string2);
            objectArray2.append((String)object7);
            objectArray2 = objectArray2.toString();
            objectArray2 = (Method)object3.get(objectArray2);
            objectArray = new StringBuilder();
            object2 = "has";
            objectArray.append((String)object2);
            objectArray.append((String)object7);
            object7 = objectArray.toString();
            object7 = (Method)object3.get(object7);
            if (objectArray2 == null) continue;
            objectArray = new Object[]{};
            objectArray2 = GeneratedMessageLite.invokeOrDie((Method)objectArray2, object, objectArray);
            if (object7 == null) {
                n13 = (int)(MessageLiteToString.isDefaultValue(objectArray2) ? 1 : 0);
                if (n13 != 0) {
                    n15 = 0;
                }
            } else {
                objectArray = new Object[]{};
                object7 = (Boolean)GeneratedMessageLite.invokeOrDie((Method)object7, object, objectArray);
                n15 = (int)(((Boolean)object7).booleanValue() ? 1 : 0);
            }
            if (n15 == 0) continue;
            object6 = MessageLiteToString.camelCaseToSnakeCase((String)object6);
            MessageLiteToString.printField(stringBuilder, n10, (String)object6, objectArray2);
        }
        boolean bl5 = object instanceof GeneratedMessageLite$ExtendableMessage;
        if (bl5) {
            boolean bl6;
            object3 = object;
            object3 = ((GeneratedMessageLite$ExtendableMessage)object).extensions.iterator();
            while (bl6 = object3.hasNext()) {
                object4 = (Map.Entry)object3.next();
                object5 = new StringBuilder();
                ((StringBuilder)object5).append("[");
                n11 = ((GeneratedMessageLite$ExtensionDescriptor)object4.getKey()).getNumber();
                ((StringBuilder)object5).append(n11);
                object6 = "]";
                ((StringBuilder)object5).append((String)object6);
                object5 = ((StringBuilder)object5).toString();
                object4 = object4.getValue();
                MessageLiteToString.printField(stringBuilder, n10, (String)object5, object4);
            }
        }
        if ((object = ((GeneratedMessageLite)object).unknownFields) != null) {
            ((UnknownFieldSetLite)object).printWithIndent(stringBuilder, n10);
        }
    }

    public static String toString(MessageLite messageLite, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("# ");
        stringBuilder.append(string2);
        MessageLiteToString.reflectivePrintWithIndent(messageLite, stringBuilder, 0);
        return stringBuilder.toString();
    }
}

