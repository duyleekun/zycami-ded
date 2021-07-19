/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.DefaultDateTypeAdapter;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class GsonBuilder {
    private boolean complexMapKeySerialization;
    private String datePattern;
    private int dateStyle;
    private boolean escapeHtmlChars;
    private Excluder excluder;
    private final List factories;
    private FieldNamingStrategy fieldNamingPolicy;
    private boolean generateNonExecutableJson;
    private final List hierarchyFactories;
    private final Map instanceCreators;
    private boolean lenient;
    private LongSerializationPolicy longSerializationPolicy;
    private boolean prettyPrinting;
    private boolean serializeNulls;
    private boolean serializeSpecialFloatingPointValues;
    private int timeStyle;

    public GsonBuilder() {
        int n10;
        Object object;
        this.excluder = object = Excluder.DEFAULT;
        object = LongSerializationPolicy.DEFAULT;
        this.longSerializationPolicy = object;
        object = FieldNamingPolicy.IDENTITY;
        this.fieldNamingPolicy = object;
        this.instanceCreators = object;
        super();
        this.factories = object;
        super();
        this.hierarchyFactories = object;
        this.serializeNulls = false;
        this.dateStyle = n10 = 2;
        this.timeStyle = n10;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
    }

    public GsonBuilder(Gson object) {
        int n10;
        int n11;
        ArrayList arrayList;
        ArrayList arrayList2;
        Object object2;
        this.excluder = object2 = Excluder.DEFAULT;
        object2 = LongSerializationPolicy.DEFAULT;
        this.longSerializationPolicy = object2;
        object2 = FieldNamingPolicy.IDENTITY;
        this.fieldNamingPolicy = object2;
        this.instanceCreators = object2;
        this.factories = arrayList2 = new ArrayList();
        this.hierarchyFactories = arrayList = new ArrayList();
        this.serializeNulls = false;
        this.dateStyle = n11 = 2;
        this.timeStyle = n11;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
        Object object3 = ((Gson)object).excluder;
        this.excluder = object3;
        this.fieldNamingPolicy = object3 = ((Gson)object).fieldNamingStrategy;
        object3 = ((Gson)object).instanceCreators;
        object2.putAll(object3);
        this.serializeNulls = n10 = ((Gson)object).serializeNulls;
        this.complexMapKeySerialization = n10 = ((Gson)object).complexMapKeySerialization;
        this.generateNonExecutableJson = n10 = ((Gson)object).generateNonExecutableJson;
        this.escapeHtmlChars = n10 = ((Gson)object).htmlSafe;
        this.prettyPrinting = n10 = ((Gson)object).prettyPrinting;
        this.lenient = n10 = ((Gson)object).lenient;
        this.serializeSpecialFloatingPointValues = n10 = ((Gson)object).serializeSpecialFloatingPointValues;
        object2 = ((Gson)object).longSerializationPolicy;
        this.longSerializationPolicy = object2;
        object2 = ((Gson)object).datePattern;
        this.datePattern = object2;
        this.dateStyle = n10 = ((Gson)object).dateStyle;
        this.timeStyle = n10 = ((Gson)object).timeStyle;
        object2 = ((Gson)object).builderFactories;
        arrayList2.addAll(object2);
        object = ((Gson)object).builderHierarchyFactories;
        arrayList.addAll(object);
    }

    private void addTypeAdaptersForDate(String object, int n10, int n11, List list) {
        block4: {
            Object object2;
            Object object3;
            Class<Date> clazz;
            block3: {
                Class<Date> clazz2;
                block2: {
                    boolean bl2;
                    if (object == null || (bl2 = ((String)((Object)(clazz2 = ""))).equals(clazz = ((String)object).trim()))) break block2;
                    object3 = new DefaultDateTypeAdapter(java.util.Date.class, (String)object);
                    object2 = new DefaultDateTypeAdapter(Timestamp.class, (String)object);
                    clazz2 = Date.class;
                    clazz = new Class<Date>(clazz2, (String)object);
                    break block3;
                }
                int n12 = 2;
                if (n10 == n12 || n11 == n12) break block4;
                object = new DefaultDateTypeAdapter(java.util.Date.class, n10, n11);
                clazz = new Class<Date>(Timestamp.class, n10, n11);
                Class<Date> clazz3 = Date.class;
                clazz2 = new Class<Date>(clazz3, n10, n11);
                object3 = object;
                object2 = clazz;
                clazz = clazz2;
            }
            object = TypeAdapters.newFactory(java.util.Date.class, (TypeAdapter)object3);
            list.add(object);
            object = TypeAdapters.newFactory(Timestamp.class, (TypeAdapter)object2);
            list.add(object);
            object = TypeAdapters.newFactory(Date.class, clazz);
            list.add(object);
        }
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy object) {
        this.excluder = object = this.excluder.withExclusionStrategy((ExclusionStrategy)object, false, true);
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy object) {
        this.excluder = object = this.excluder.withExclusionStrategy((ExclusionStrategy)object, true, false);
        return this;
    }

    public Gson create() {
        Gson gson;
        Object object;
        ArrayList arrayList = object;
        int n10 = this.factories.size();
        int n11 = this.hierarchyFactories.size();
        n10 = n10 + n11 + 3;
        object = new ArrayList(n10);
        Object object2 = this.factories;
        object.addAll(object2);
        Collections.reverse(object);
        Object object3 = this.hierarchyFactories;
        object2 = new ArrayList(object3);
        Collections.reverse(object2);
        object.addAll(object2);
        object2 = this.datePattern;
        n11 = this.dateStyle;
        int n12 = this.timeStyle;
        this.addTypeAdaptersForDate((String)object2, n11, n12, (List)object);
        object = gson;
        object2 = this.excluder;
        object3 = this.fieldNamingPolicy;
        Map map = this.instanceCreators;
        boolean bl2 = this.serializeNulls;
        boolean bl3 = this.complexMapKeySerialization;
        boolean bl4 = this.generateNonExecutableJson;
        boolean bl5 = this.escapeHtmlChars;
        boolean bl6 = this.prettyPrinting;
        boolean bl7 = this.lenient;
        boolean bl8 = this.serializeSpecialFloatingPointValues;
        LongSerializationPolicy longSerializationPolicy = this.longSerializationPolicy;
        String string2 = this.datePattern;
        int n13 = this.dateStyle;
        int n14 = this.timeStyle;
        List list = this.factories;
        List list2 = this.hierarchyFactories;
        object = gson;
        gson = new Gson((Excluder)object2, (FieldNamingStrategy)object3, map, bl2, bl3, bl4, bl5, bl6, bl7, bl8, longSerializationPolicy, string2, n13, n14, list, list2, arrayList);
        return gson;
    }

    public GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public GsonBuilder disableInnerClassSerialization() {
        Excluder excluder;
        this.excluder = excluder = this.excluder.disableInnerClassSerialization();
        return this;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithModifiers(int ... object) {
        object = this.excluder.withModifiers((int)object);
        this.excluder = object;
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        Excluder excluder;
        this.excluder = excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type object, Object object2) {
        Object object3;
        Object object4;
        boolean bl2;
        boolean bl3 = object2 instanceof JsonSerializer;
        if (!(bl3 || (bl2 = object2 instanceof JsonDeserializer) || (bl2 = object2 instanceof InstanceCreator) || (bl2 = object2 instanceof TypeAdapter))) {
            bl2 = false;
            object4 = null;
        } else {
            bl2 = true;
        }
        $Gson$Preconditions.checkArgument(bl2);
        bl2 = object2 instanceof InstanceCreator;
        if (bl2) {
            object4 = this.instanceCreators;
            Object object5 = object2;
            object5 = (InstanceCreator)object2;
            object4.put(object, object5);
        }
        if (bl3 || (bl3 = object2 instanceof JsonDeserializer)) {
            object3 = TypeToken.get((Type)object);
            object4 = this.factories;
            object3 = TreeTypeAdapter.newFactoryWithMatchRawType((TypeToken)object3, object2);
            object4.add(object3);
        }
        if (bl3 = object2 instanceof TypeAdapter) {
            object3 = this.factories;
            object = TypeToken.get((Type)object);
            object2 = (TypeAdapter)object2;
            object = TypeAdapters.newFactory((TypeToken)object, (TypeAdapter)object2);
            object3.add(object);
        }
        return this;
    }

    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory typeAdapterFactory) {
        this.factories.add(typeAdapterFactory);
        return this;
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class object, Object object2) {
        List list;
        TypeAdapterFactory typeAdapterFactory;
        boolean bl2;
        boolean bl3 = object2 instanceof JsonSerializer;
        if (!(bl3 || (bl2 = object2 instanceof JsonDeserializer) || (bl2 = object2 instanceof TypeAdapter))) {
            bl2 = false;
            typeAdapterFactory = null;
        } else {
            bl2 = true;
        }
        $Gson$Preconditions.checkArgument(bl2);
        bl2 = object2 instanceof JsonDeserializer;
        if (bl2 || bl3) {
            list = this.hierarchyFactories;
            typeAdapterFactory = TreeTypeAdapter.newTypeHierarchyFactory((Class)object, object2);
            list.add(typeAdapterFactory);
        }
        if (bl3 = object2 instanceof TypeAdapter) {
            list = this.factories;
            object2 = (TypeAdapter)object2;
            object = TypeAdapters.newTypeHierarchyFactory((Class)object, (TypeAdapter)object2);
            list.add(object);
        }
        return this;
    }

    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public GsonBuilder setDateFormat(int n10) {
        this.dateStyle = n10;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(int n10, int n11) {
        this.dateStyle = n10;
        this.timeStyle = n11;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(String string2) {
        this.datePattern = string2;
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy ... exclusionStrategyArray) {
        for (ExclusionStrategy exclusionStrategy : exclusionStrategyArray) {
            Excluder object;
            Excluder excluder = this.excluder;
            boolean bl2 = true;
            this.excluder = object = excluder.withExclusionStrategy(exclusionStrategy, bl2, bl2);
        }
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy fieldNamingPolicy) {
        this.fieldNamingPolicy = fieldNamingPolicy;
        return this;
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        this.fieldNamingPolicy = fieldNamingStrategy;
        return this;
    }

    public GsonBuilder setLenient() {
        this.lenient = true;
        return this;
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy longSerializationPolicy) {
        this.longSerializationPolicy = longSerializationPolicy;
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }

    public GsonBuilder setVersion(double d10) {
        Excluder excluder;
        this.excluder = excluder = this.excluder.withVersion(d10);
        return this;
    }
}

