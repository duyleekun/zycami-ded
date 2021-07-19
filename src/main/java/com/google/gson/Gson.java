/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson$1;
import com.google.gson.Gson$2;
import com.google.gson.Gson$3;
import com.google.gson.Gson$4;
import com.google.gson.Gson$5;
import com.google.gson.Gson$FutureTypeAdapter;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class Gson {
    public static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    public static final boolean DEFAULT_ESCAPE_HTML = true;
    public static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    public static final boolean DEFAULT_LENIENT = false;
    public static final boolean DEFAULT_PRETTY_PRINT = false;
    public static final boolean DEFAULT_SERIALIZE_NULLS = false;
    public static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private static final TypeToken NULL_KEY_SURROGATE = TypeToken.get(Object.class);
    public final List builderFactories;
    public final List builderHierarchyFactories;
    private final ThreadLocal calls;
    public final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;
    public final String datePattern;
    public final int dateStyle;
    public final Excluder excluder;
    public final List factories;
    public final FieldNamingStrategy fieldNamingStrategy;
    public final boolean generateNonExecutableJson;
    public final boolean htmlSafe;
    public final Map instanceCreators;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    public final boolean lenient;
    public final LongSerializationPolicy longSerializationPolicy;
    public final boolean prettyPrinting;
    public final boolean serializeNulls;
    public final boolean serializeSpecialFloatingPointValues;
    public final int timeStyle;
    private final Map typeTokenCache;

    public Gson() {
        Excluder excluder = Excluder.DEFAULT;
        FieldNamingPolicy fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        Map map = Collections.emptyMap();
        LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        List list = Collections.emptyList();
        List list2 = Collections.emptyList();
        List list3 = Collections.emptyList();
        this(excluder, fieldNamingPolicy, map, false, false, false, true, false, false, false, longSerializationPolicy, null, 2, 2, list, list2, list3);
    }

    public Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map map, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, LongSerializationPolicy longSerializationPolicy, String string2, int n10, int n11, List list, List list2, List list3) {
        Object object = excluder;
        Object object2 = map;
        Object object3 = new ThreadLocal();
        this.calls = object3;
        object3 = new ConcurrentHashMap();
        this.typeTokenCache = object3;
        this.excluder = excluder;
        this.fieldNamingStrategy = fieldNamingStrategy;
        this.instanceCreators = map;
        this.constructorConstructor = object3 = new ConstructorConstructor(map);
        this.serializeNulls = bl2;
        this.complexMapKeySerialization = bl3;
        this.generateNonExecutableJson = bl4;
        this.htmlSafe = bl5;
        this.prettyPrinting = bl6;
        this.lenient = bl7;
        this.serializeSpecialFloatingPointValues = bl8;
        object2 = longSerializationPolicy;
        this.longSerializationPolicy = longSerializationPolicy;
        ArrayList<TypeAdapterFactory> arrayList = string2;
        this.datePattern = string2;
        this.dateStyle = n10;
        this.timeStyle = n11;
        arrayList = list;
        this.builderFactories = list;
        arrayList = list2;
        this.builderHierarchyFactories = list2;
        arrayList = new ArrayList<TypeAdapterFactory>();
        Object object4 = TypeAdapters.JSON_ELEMENT_FACTORY;
        arrayList.add((TypeAdapterFactory)object4);
        object4 = ObjectTypeAdapter.FACTORY;
        arrayList.add((TypeAdapterFactory)object4);
        arrayList.add(excluder);
        object4 = list3;
        arrayList.addAll(list3);
        object4 = TypeAdapters.STRING_FACTORY;
        arrayList.add((TypeAdapterFactory)object4);
        object4 = TypeAdapters.INTEGER_FACTORY;
        arrayList.add((TypeAdapterFactory)object4);
        object4 = TypeAdapters.BOOLEAN_FACTORY;
        arrayList.add((TypeAdapterFactory)object4);
        object4 = TypeAdapters.BYTE_FACTORY;
        arrayList.add((TypeAdapterFactory)object4);
        object4 = TypeAdapters.SHORT_FACTORY;
        arrayList.add((TypeAdapterFactory)object4);
        object2 = Gson.longAdapter(longSerializationPolicy);
        object4 = TypeAdapters.newFactory(Long.TYPE, Long.class, (TypeAdapter)object2);
        arrayList.add((TypeAdapterFactory)object4);
        object4 = Double.TYPE;
        TypeAdapter typeAdapter = this.doubleAdapter(bl8);
        object4 = TypeAdapters.newFactory(object4, Double.class, typeAdapter);
        arrayList.add((TypeAdapterFactory)object4);
        object4 = Float.TYPE;
        Object object5 = this.floatAdapter(bl8);
        object5 = TypeAdapters.newFactory(object4, Float.class, (TypeAdapter)object5);
        arrayList.add((TypeAdapterFactory)object5);
        object5 = TypeAdapters.NUMBER_FACTORY;
        arrayList.add((TypeAdapterFactory)object5);
        object5 = TypeAdapters.ATOMIC_INTEGER_FACTORY;
        arrayList.add((TypeAdapterFactory)object5);
        object5 = TypeAdapters.ATOMIC_BOOLEAN_FACTORY;
        arrayList.add((TypeAdapterFactory)object5);
        object4 = Gson.atomicLongAdapter((TypeAdapter)object2);
        object5 = TypeAdapters.newFactory(AtomicLong.class, (TypeAdapter)object4);
        arrayList.add((TypeAdapterFactory)object5);
        object2 = Gson.atomicLongArrayAdapter((TypeAdapter)object2);
        object2 = TypeAdapters.newFactory(AtomicLongArray.class, (TypeAdapter)object2);
        arrayList.add((TypeAdapterFactory)object2);
        object2 = TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        object2 = TypeAdapters.CHARACTER_FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        object2 = TypeAdapters.STRING_BUILDER_FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        object2 = TypeAdapters.STRING_BUFFER_FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        object5 = TypeAdapters.BIG_DECIMAL;
        object2 = TypeAdapters.newFactory(BigDecimal.class, (TypeAdapter)object5);
        arrayList.add((TypeAdapterFactory)object2);
        object5 = TypeAdapters.BIG_INTEGER;
        object2 = TypeAdapters.newFactory(BigInteger.class, (TypeAdapter)object5);
        arrayList.add((TypeAdapterFactory)object2);
        object2 = TypeAdapters.URL_FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        object2 = TypeAdapters.URI_FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        object2 = TypeAdapters.UUID_FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        object2 = TypeAdapters.CURRENCY_FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        object2 = TypeAdapters.LOCALE_FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        object2 = TypeAdapters.INET_ADDRESS_FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        object2 = TypeAdapters.BIT_SET_FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        object2 = DateTypeAdapter.FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        object2 = TypeAdapters.CALENDAR_FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        object2 = TimeTypeAdapter.FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        object2 = SqlDateTypeAdapter.FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        object2 = TypeAdapters.TIMESTAMP_FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        object2 = ArrayTypeAdapter.FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        object2 = TypeAdapters.CLASS_FACTORY;
        arrayList.add((TypeAdapterFactory)object2);
        super((ConstructorConstructor)object3);
        arrayList.add((TypeAdapterFactory)object2);
        super((ConstructorConstructor)object3, bl3);
        arrayList.add((TypeAdapterFactory)object2);
        super((ConstructorConstructor)object3);
        this.jsonAdapterFactory = object2;
        arrayList.add((TypeAdapterFactory)object2);
        TypeAdapterFactory typeAdapterFactory = TypeAdapters.ENUM_FACTORY;
        arrayList.add(typeAdapterFactory);
        super((ConstructorConstructor)object3, fieldNamingStrategy, excluder, (JsonAdapterAnnotationTypeAdapterFactory)object2);
        arrayList.add(typeAdapterFactory);
        this.factories = object = Collections.unmodifiableList(arrayList);
    }

    private static void assertFullConsumption(Object object, JsonReader object2) {
        block7: {
            if (object != null) {
                object = ((JsonReader)object2).peek();
                object2 = JsonToken.END_DOCUMENT;
                if (object == object2) break block7;
                object2 = "JSON document was not fully consumed.";
                try {
                    object = new JsonIOException((String)object2);
                    throw object;
                }
                catch (IOException iOException) {
                    object2 = new JsonIOException(iOException);
                    throw object2;
                }
                catch (MalformedJsonException malformedJsonException) {
                    object2 = new JsonSyntaxException(malformedJsonException);
                    throw object2;
                }
            }
        }
    }

    private static TypeAdapter atomicLongAdapter(TypeAdapter typeAdapter) {
        Gson$4 gson$4 = new Gson$4(typeAdapter);
        return gson$4.nullSafe();
    }

    private static TypeAdapter atomicLongArrayAdapter(TypeAdapter typeAdapter) {
        Gson$5 gson$5 = new Gson$5(typeAdapter);
        return gson$5.nullSafe();
    }

    public static void checkValidFloatingPoint(double d10) {
        boolean bl2 = Double.isNaN(d10);
        if (!bl2 && !(bl2 = Double.isInfinite(d10))) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d10);
        stringBuilder.append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    private TypeAdapter doubleAdapter(boolean bl2) {
        if (bl2) {
            return TypeAdapters.DOUBLE;
        }
        Gson$1 gson$1 = new Gson$1(this);
        return gson$1;
    }

    private TypeAdapter floatAdapter(boolean bl2) {
        if (bl2) {
            return TypeAdapters.FLOAT;
        }
        Gson$2 gson$2 = new Gson$2(this);
        return gson$2;
    }

    private static TypeAdapter longAdapter(LongSerializationPolicy object) {
        LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        if (object == longSerializationPolicy) {
            return TypeAdapters.LONG;
        }
        object = new Gson$3();
        return object;
    }

    public Excluder excluder() {
        return this.excluder;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public Object fromJson(JsonElement object, Class clazz) {
        object = this.fromJson((JsonElement)object, (Type)clazz);
        return Primitives.wrap(clazz).cast(object);
    }

    public Object fromJson(JsonElement jsonElement, Type type) {
        if (jsonElement == null) {
            return null;
        }
        JsonTreeReader jsonTreeReader = new JsonTreeReader(jsonElement);
        return this.fromJson(jsonTreeReader, type);
    }

    /*
     * Exception decompiling
     */
    public Object fromJson(JsonReader var1_1, Type var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 4[TRYBLOCK] [20 : 54->57)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public Object fromJson(Reader closeable, Class clazz) {
        closeable = this.newJsonReader((Reader)closeable);
        Object object = this.fromJson((JsonReader)closeable, (Type)clazz);
        Gson.assertFullConsumption(object, (JsonReader)closeable);
        return Primitives.wrap(clazz).cast(object);
    }

    public Object fromJson(Reader closeable, Type object) {
        closeable = this.newJsonReader((Reader)closeable);
        object = this.fromJson((JsonReader)closeable, (Type)object);
        Gson.assertFullConsumption(object, (JsonReader)closeable);
        return object;
    }

    public Object fromJson(String object, Class clazz) {
        object = this.fromJson((String)object, (Type)clazz);
        return Primitives.wrap(clazz).cast(object);
    }

    public Object fromJson(String string2, Type type) {
        if (string2 == null) {
            return null;
        }
        StringReader stringReader = new StringReader(string2);
        return this.fromJson((Reader)stringReader, type);
    }

    public TypeAdapter getAdapter(TypeToken object) {
        Object object2;
        HashMap<TypeToken, Gson$FutureTypeAdapter> hashMap = this.typeTokenCache;
        Object object3 = object == null ? NULL_KEY_SURROGATE : object;
        if ((hashMap = (TypeAdapter)hashMap.get(object3)) != null) {
            return hashMap;
        }
        hashMap = (Map)this.calls.get();
        boolean bl2 = false;
        object3 = null;
        if (hashMap == null) {
            hashMap = new HashMap<TypeToken, Gson$FutureTypeAdapter>();
            object3 = this.calls;
            ((ThreadLocal)object3).set(hashMap);
            bl2 = true;
        }
        if ((object2 = (Gson$FutureTypeAdapter)hashMap.get(object)) != null) {
            return object2;
        }
        try {
            Object object4;
            boolean bl3;
            object2 = new Gson$FutureTypeAdapter();
            hashMap.put((TypeToken)object, (Gson$FutureTypeAdapter)object2);
            Object object5 = this.factories;
            object5 = object5.iterator();
            while (bl3 = object5.hasNext()) {
                object4 = object5.next();
                object4 = (TypeAdapterFactory)object4;
                if ((object4 = object4.create(this, (TypeToken)object)) == null) continue;
                ((Gson$FutureTypeAdapter)object2).setDelegate((TypeAdapter)object4);
                object2 = this.typeTokenCache;
                object2.put(object, object4);
                return object4;
            }
            object5 = new StringBuilder();
            object4 = "GSON (2.8.7) cannot handle ";
            ((StringBuilder)object5).append((String)object4);
            ((StringBuilder)object5).append(object);
            object5 = ((StringBuilder)object5).toString();
            object2 = new IllegalArgumentException((String)object5);
            throw object2;
        }
        finally {
            hashMap.remove(object);
            if (bl2) {
                object = this.calls;
                ((ThreadLocal)object).remove();
            }
        }
    }

    public TypeAdapter getAdapter(Class object) {
        object = TypeToken.get((Class)object);
        return this.getAdapter((TypeToken)object);
    }

    public TypeAdapter getDelegateAdapter(TypeAdapterFactory object, TypeToken object2) {
        boolean bl2;
        Object object3 = this.factories;
        boolean bl3 = object3.contains(object);
        if (!bl3) {
            object = this.jsonAdapterFactory;
        }
        bl3 = false;
        object3 = null;
        Iterator iterator2 = this.factories.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object4 = (TypeAdapterFactory)iterator2.next();
            if (!bl3) {
                if (object4 != object) continue;
                bl3 = true;
                continue;
            }
            if ((object4 = object4.create(this, (TypeToken)object2)) == null) continue;
            return object4;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("GSON cannot serialize ");
        ((StringBuilder)object3).append(object2);
        object2 = ((StringBuilder)object3).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    public GsonBuilder newBuilder() {
        GsonBuilder gsonBuilder = new GsonBuilder(this);
        return gsonBuilder;
    }

    public JsonReader newJsonReader(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        boolean bl2 = this.lenient;
        jsonReader.setLenient(bl2);
        return jsonReader;
    }

    public JsonWriter newJsonWriter(Writer object) {
        Object object2;
        boolean bl2 = this.generateNonExecutableJson;
        if (bl2) {
            object2 = JSON_NON_EXECUTABLE_PREFIX;
            ((Writer)object).write((String)object2);
        }
        object2 = new JsonWriter((Writer)object);
        boolean bl3 = this.prettyPrinting;
        if (bl3) {
            object = "  ";
            ((JsonWriter)object2).setIndent((String)object);
        }
        bl3 = this.serializeNulls;
        ((JsonWriter)object2).setSerializeNulls(bl3);
        return object2;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public String toJson(JsonElement jsonElement) {
        StringWriter stringWriter = new StringWriter();
        this.toJson(jsonElement, (Appendable)stringWriter);
        return stringWriter.toString();
    }

    public String toJson(Object object) {
        if (object == null) {
            object = JsonNull.INSTANCE;
            return this.toJson((JsonElement)object);
        }
        Class<?> clazz = object.getClass();
        return this.toJson(object, clazz);
    }

    public String toJson(Object object, Type type) {
        StringWriter stringWriter = new StringWriter();
        this.toJson(object, type, stringWriter);
        return stringWriter.toString();
    }

    /*
     * Exception decompiling
     */
    public void toJson(JsonElement var1_1, JsonWriter var2_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [3 : 74->77)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void toJson(JsonElement jsonElement, Appendable object) {
        try {
            object = Streams.writerForAppendable((Appendable)object);
        }
        catch (IOException iOException) {
            object = new JsonIOException(iOException);
            throw object;
        }
        object = this.newJsonWriter((Writer)object);
        this.toJson(jsonElement, (JsonWriter)object);
    }

    public void toJson(Object object, Appendable appendable) {
        if (object != null) {
            Class<?> clazz = object.getClass();
            this.toJson(object, clazz, appendable);
        } else {
            object = JsonNull.INSTANCE;
            this.toJson((JsonElement)object, appendable);
        }
    }

    /*
     * Exception decompiling
     */
    public void toJson(Object var1_1, Type var2_5, JsonWriter var3_6) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [3 : 88->91)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void toJson(Object object, Type object2, Appendable object3) {
        try {
            object3 = Streams.writerForAppendable((Appendable)object3);
        }
        catch (IOException iOException) {
            object2 = new JsonIOException(iOException);
            throw object2;
        }
        object3 = this.newJsonWriter((Writer)object3);
        this.toJson(object, (Type)object2, (JsonWriter)object3);
    }

    public JsonElement toJsonTree(Object object) {
        if (object == null) {
            return JsonNull.INSTANCE;
        }
        Class<?> clazz = object.getClass();
        return this.toJsonTree(object, clazz);
    }

    public JsonElement toJsonTree(Object object, Type type) {
        JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
        this.toJson(object, type, jsonTreeWriter);
        return jsonTreeWriter.get();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{serializeNulls:");
        boolean bl2 = this.serializeNulls;
        stringBuilder.append(bl2);
        stringBuilder.append(",factories:");
        Object object = this.factories;
        stringBuilder.append(object);
        stringBuilder.append(",instanceCreators:");
        object = this.constructorConstructor;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

