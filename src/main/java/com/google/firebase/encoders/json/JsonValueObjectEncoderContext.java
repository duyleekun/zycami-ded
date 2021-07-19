/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  android.util.JsonWriter
 */
package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

public final class JsonValueObjectEncoderContext
implements ObjectEncoderContext,
ValueEncoderContext {
    private boolean active = true;
    private JsonValueObjectEncoderContext childContext = null;
    private final ObjectEncoder fallbackEncoder;
    private final boolean ignoreNullValues;
    private final JsonWriter jsonWriter;
    private final Map objectEncoders;
    private final Map valueEncoders;

    private JsonValueObjectEncoderContext(JsonValueObjectEncoderContext jsonValueObjectEncoderContext) {
        boolean bl2;
        Object object;
        this.jsonWriter = object = jsonValueObjectEncoderContext.jsonWriter;
        object = jsonValueObjectEncoderContext.objectEncoders;
        this.objectEncoders = object;
        object = jsonValueObjectEncoderContext.valueEncoders;
        this.valueEncoders = object;
        object = jsonValueObjectEncoderContext.fallbackEncoder;
        this.fallbackEncoder = object;
        this.ignoreNullValues = bl2 = jsonValueObjectEncoderContext.ignoreNullValues;
    }

    public JsonValueObjectEncoderContext(Writer writer, Map map, Map map2, ObjectEncoder objectEncoder, boolean bl2) {
        JsonWriter jsonWriter;
        this.jsonWriter = jsonWriter = new JsonWriter(writer);
        this.objectEncoders = map;
        this.valueEncoders = map2;
        this.fallbackEncoder = objectEncoder;
        this.ignoreNullValues = bl2;
    }

    private boolean cannotBeInline(Object object) {
        boolean bl2;
        Class<?> clazz;
        boolean bl3;
        if (!(object == null || (bl3 = (clazz = object.getClass()).isArray()) || (bl3 = object instanceof Collection) || (bl3 = object instanceof Date) || (bl3 = object instanceof Enum) || (bl2 = object instanceof Number))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private JsonValueObjectEncoderContext internalAdd(String string2, Object object) {
        this.maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        jsonWriter.name(string2);
        if (object == null) {
            this.jsonWriter.nullValue();
            return this;
        }
        return this.add(object, false);
    }

    private JsonValueObjectEncoderContext internalAddIgnoreNullValues(String string2, Object object) {
        if (object == null) {
            return this;
        }
        this.maybeUnNest();
        this.jsonWriter.name(string2);
        return this.add(object, false);
    }

    private void maybeUnNest() {
        boolean bl2 = this.active;
        if (bl2) {
            JsonValueObjectEncoderContext jsonValueObjectEncoderContext = this.childContext;
            if (jsonValueObjectEncoderContext != null) {
                jsonValueObjectEncoderContext.maybeUnNest();
                this.childContext.active = false;
                bl2 = false;
                this.childContext = null;
                jsonValueObjectEncoderContext = this.jsonWriter;
                jsonValueObjectEncoderContext.endObject();
            }
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        throw illegalStateException;
    }

    public ObjectEncoderContext add(FieldDescriptor object, double d10) {
        object = ((FieldDescriptor)object).getName();
        return this.add((String)object, d10);
    }

    public ObjectEncoderContext add(FieldDescriptor object, float f10) {
        object = ((FieldDescriptor)object).getName();
        double d10 = f10;
        return this.add((String)object, d10);
    }

    public ObjectEncoderContext add(FieldDescriptor object, int n10) {
        object = ((FieldDescriptor)object).getName();
        return this.add((String)object, n10);
    }

    public ObjectEncoderContext add(FieldDescriptor object, long l10) {
        object = ((FieldDescriptor)object).getName();
        return this.add((String)object, l10);
    }

    public ObjectEncoderContext add(FieldDescriptor object, Object object2) {
        object = ((FieldDescriptor)object).getName();
        return this.add((String)object, object2);
    }

    public ObjectEncoderContext add(FieldDescriptor object, boolean bl2) {
        object = ((FieldDescriptor)object).getName();
        return this.add((String)object, bl2);
    }

    public JsonValueObjectEncoderContext add(double d10) {
        this.maybeUnNest();
        this.jsonWriter.value(d10);
        return this;
    }

    public JsonValueObjectEncoderContext add(float f10) {
        this.maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        double d10 = f10;
        jsonWriter.value(d10);
        return this;
    }

    public JsonValueObjectEncoderContext add(int n10) {
        this.maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        long l10 = n10;
        jsonWriter.value(l10);
        return this;
    }

    public JsonValueObjectEncoderContext add(long l10) {
        this.maybeUnNest();
        this.jsonWriter.value(l10);
        return this;
    }

    /*
     * WARNING - void declaration
     */
    public JsonValueObjectEncoderContext add(Object object, boolean n10) {
        boolean bl2;
        int bl3 = 1;
        Class<?> clazz = null;
        if (n10 != 0 && (bl2 = this.cannotBeInline(object))) {
            Object[] objectArray = new Object[bl3];
            object = object == null ? null : object.getClass();
            objectArray[0] = object;
            object = String.format("%s cannot be encoded inline", objectArray);
            EncodingException encodingException = new EncodingException((String)object);
            throw encodingException;
        }
        if (object == null) {
            this.jsonWriter.nullValue();
            return this;
        }
        bl2 = object instanceof Number;
        if (bl2) {
            JsonWriter jsonWriter = this.jsonWriter;
            object = (Number)object;
            jsonWriter.value((Number)object);
            return this;
        }
        Object object2 = object.getClass();
        bl2 = ((Class)object2).isArray();
        if (bl2) {
            n10 = object instanceof byte[];
            if (n10 != 0) {
                object = (byte[])object;
                return this.add((byte[])object);
            }
            JsonWriter jsonWriter = this.jsonWriter;
            jsonWriter.beginArray();
            n10 = object instanceof int[];
            if (n10 != 0) {
                for (Object object3 : (Object)((int[])object)) {
                    object2 = this.jsonWriter;
                    long l10 = (long)object3;
                    object2.value(l10);
                }
            } else {
                int n11;
                n10 = object instanceof long[];
                if (n10 != 0) {
                    object = (long[])object;
                    n10 = ((Object)object).length;
                    while (n11 < n10) {
                        Object object4 = object[n11];
                        this.add((long)object4);
                        ++n11;
                    }
                } else {
                    n10 = object instanceof double[];
                    if (n10 != 0) {
                        object = (double[])object;
                        n10 = ((Object)object).length;
                        while (n11 < n10) {
                            Object object5 = object[n11];
                            JsonWriter jsonWriter2 = this.jsonWriter;
                            jsonWriter2.value((double)object5);
                            ++n11;
                        }
                    } else {
                        n10 = object instanceof boolean[];
                        if (n10 != 0) {
                            object = (boolean[])object;
                            n10 = ((Object[])object).length;
                            while (n11 < n10) {
                                Object object6 = object[n11];
                                object2 = this.jsonWriter;
                                object2.value((boolean)object6);
                                ++n11;
                            }
                        } else {
                            n10 = object instanceof Number[];
                            if (n10 != 0) {
                                void var3_8;
                                object = (Number[])object;
                                n10 = ((Object[])object).length;
                                boolean bl4 = false;
                                Object var8_22 = null;
                                while (++var3_8 < n10) {
                                    object2 = object[var3_8];
                                    this.add(object2, false);
                                }
                            } else {
                                void var3_10;
                                n10 = ((Object[])object).length;
                                boolean bl5 = false;
                                Object var8_23 = null;
                                while (++var3_10 < n10) {
                                    object2 = object[var3_10];
                                    this.add(object2, false);
                                }
                            }
                        }
                    }
                }
            }
            this.jsonWriter.endArray();
            return this;
        }
        bl2 = object instanceof Collection;
        if (bl2) {
            object = (Collection)object;
            Object object7 = this.jsonWriter;
            object7.beginArray();
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object7 = object.next();
                this.add(object7, false);
            }
            this.jsonWriter.endArray();
            return this;
        }
        bl2 = object instanceof Map;
        if (bl2) {
            object = (Map)object;
            Object object8 = this.jsonWriter;
            object8.beginObject();
            object = object.entrySet().iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object8 = (Map.Entry)object.next();
                object2 = object8.getKey();
                Object[] objectArray = object2;
                try {
                    objectArray = (String)object2;
                }
                catch (ClassCastException classCastException) {
                    objectArray = new Object[2];
                    objectArray[0] = object2;
                    objectArray[bl3] = clazz = object2.getClass();
                    String string2 = String.format("Only String keys are currently supported in maps, got %s of type %s instead.", objectArray);
                    object8 = new EncodingException(string2, classCastException);
                    throw object8;
                }
                object8 = object8.getValue();
                this.add((String)objectArray, object8);
            }
            this.jsonWriter.endObject();
            return this;
        }
        Object object9 = this.objectEncoders;
        clazz = object.getClass();
        if ((object9 = (ObjectEncoder)object9.get(clazz)) != null) {
            return this.doEncode((ObjectEncoder)object9, object, n10 != 0);
        }
        object9 = this.valueEncoders;
        clazz = object.getClass();
        if ((object9 = (ValueEncoder)object9.get(clazz)) != null) {
            object9.encode(object, this);
            return this;
        }
        boolean bl6 = object instanceof Enum;
        if (bl6) {
            object = ((Enum)object).name();
            this.add((String)object);
            return this;
        }
        object9 = this.fallbackEncoder;
        return this.doEncode((ObjectEncoder)object9, object, n10 != 0);
    }

    public JsonValueObjectEncoderContext add(String string2) {
        this.maybeUnNest();
        this.jsonWriter.value(string2);
        return this;
    }

    public JsonValueObjectEncoderContext add(String string2, double d10) {
        this.maybeUnNest();
        this.jsonWriter.name(string2);
        return this.add(d10);
    }

    public JsonValueObjectEncoderContext add(String string2, int n10) {
        this.maybeUnNest();
        this.jsonWriter.name(string2);
        return this.add(n10);
    }

    public JsonValueObjectEncoderContext add(String string2, long l10) {
        this.maybeUnNest();
        this.jsonWriter.name(string2);
        return this.add(l10);
    }

    public JsonValueObjectEncoderContext add(String string2, Object object) {
        boolean bl2 = this.ignoreNullValues;
        if (bl2) {
            return this.internalAddIgnoreNullValues(string2, object);
        }
        return this.internalAdd(string2, object);
    }

    public JsonValueObjectEncoderContext add(String string2, boolean bl2) {
        this.maybeUnNest();
        this.jsonWriter.name(string2);
        return this.add(bl2);
    }

    public JsonValueObjectEncoderContext add(boolean bl2) {
        this.maybeUnNest();
        this.jsonWriter.value(bl2);
        return this;
    }

    public JsonValueObjectEncoderContext add(byte[] object) {
        this.maybeUnNest();
        if (object == null) {
            object = this.jsonWriter;
            object.nullValue();
        } else {
            JsonWriter jsonWriter = this.jsonWriter;
            int n10 = 2;
            object = Base64.encodeToString((byte[])object, (int)n10);
            jsonWriter.value((String)object);
        }
        return this;
    }

    public void close() {
        this.maybeUnNest();
        this.jsonWriter.flush();
    }

    public JsonValueObjectEncoderContext doEncode(ObjectEncoder objectEncoder, Object object, boolean bl2) {
        if (!bl2) {
            JsonWriter jsonWriter = this.jsonWriter;
            jsonWriter.beginObject();
        }
        objectEncoder.encode(object, this);
        if (!bl2) {
            objectEncoder = this.jsonWriter;
            objectEncoder.endObject();
        }
        return this;
    }

    public ObjectEncoderContext inline(Object object) {
        return this.add(object, true);
    }

    public ObjectEncoderContext nested(FieldDescriptor object) {
        object = ((FieldDescriptor)object).getName();
        return this.nested((String)object);
    }

    public ObjectEncoderContext nested(String string2) {
        JsonValueObjectEncoderContext jsonValueObjectEncoderContext;
        this.maybeUnNest();
        this.childContext = jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(this);
        this.jsonWriter.name(string2);
        this.jsonWriter.beginObject();
        return this.childContext;
    }
}

