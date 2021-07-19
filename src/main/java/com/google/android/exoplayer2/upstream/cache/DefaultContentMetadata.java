/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class DefaultContentMetadata
implements ContentMetadata {
    public static final DefaultContentMetadata EMPTY;
    private int hashCode;
    private final Map metadata;

    static {
        DefaultContentMetadata defaultContentMetadata;
        Map map = Collections.emptyMap();
        EMPTY = defaultContentMetadata = new DefaultContentMetadata(map);
    }

    public DefaultContentMetadata() {
        Map map = Collections.emptyMap();
        this(map);
    }

    public DefaultContentMetadata(Map map) {
        this.metadata = map = Collections.unmodifiableMap(map);
    }

    private static void addValues(HashMap hashMap, Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            String string2 = (String)object2.getKey();
            object2 = DefaultContentMetadata.getBytes(object2.getValue());
            hashMap.put(string2, object2);
        }
    }

    private static Map applyMutations(Map object, ContentMetadataMutations contentMetadataMutations) {
        HashMap hashMap = new HashMap(object);
        object = contentMetadataMutations.getRemovedValues();
        DefaultContentMetadata.removeValues(hashMap, (List)object);
        object = contentMetadataMutations.getEditedValues();
        DefaultContentMetadata.addValues(hashMap, (Map)object);
        return hashMap;
    }

    private static byte[] getBytes(Object object) {
        boolean bl2 = object instanceof Long;
        if (bl2) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(8);
            long l10 = (Long)object;
            return byteBuffer.putLong(l10).array();
        }
        bl2 = object instanceof String;
        if (bl2) {
            object = (String)object;
            Charset charset = Charsets.UTF_8;
            return ((String)object).getBytes(charset);
        }
        bl2 = object instanceof byte[];
        if (bl2) {
            return (byte[])object;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    private static boolean isMetadataEqual(Map object, Map map) {
        int n10;
        int n11 = object.size();
        if (n11 != (n10 = map.size())) {
            return false;
        }
        object = object.entrySet().iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = (Map.Entry)object.next();
            byte[] byArray = (byte[])object2.getValue();
            object2 = object2.getKey();
            n11 = (int)(Arrays.equals(byArray, (byte[])(object2 = (Object)((byte[])map.get(object2)))) ? 1 : 0);
            if (n11 != 0) continue;
            return false;
        }
        return true;
    }

    private static void removeValues(HashMap hashMap, List list) {
        int n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Object e10 = list.get(i10);
            hashMap.remove(e10);
        }
    }

    public final boolean contains(String string2) {
        return this.metadata.containsKey(string2);
    }

    public DefaultContentMetadata copyWithMutationsApplied(ContentMetadataMutations object) {
        Object object2 = this.metadata;
        boolean bl2 = DefaultContentMetadata.isMetadataEqual((Map)object2, (Map)(object = DefaultContentMetadata.applyMutations(this.metadata, (ContentMetadataMutations)object)));
        if (bl2) {
            return this;
        }
        object2 = new DefaultContentMetadata((Map)object);
        return object2;
    }

    public Set entrySet() {
        return this.metadata.entrySet();
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        if (this == object) {
            return true;
        }
        if (object != null && (object2 = DefaultContentMetadata.class) == (clazz = object.getClass())) {
            object2 = this.metadata;
            object = ((DefaultContentMetadata)object).metadata;
            return DefaultContentMetadata.isMetadataEqual((Map)object2, (Map)object);
        }
        return false;
    }

    public final long get(String object, long l10) {
        Map map = this.metadata;
        if ((object = (Object)((byte[])map.get(object))) != null) {
            return ByteBuffer.wrap((byte[])object).getLong();
        }
        return l10;
    }

    public final String get(String object, String string2) {
        Object object2 = this.metadata;
        if ((object = (Object)((byte[])object2.get(object))) != null) {
            object2 = Charsets.UTF_8;
            string2 = new String((byte[])object, (Charset)object2);
        }
        return string2;
    }

    public final byte[] get(String object, byte[] byArray) {
        Map map = this.metadata;
        if ((object = (Object)((byte[])map.get(object))) != null) {
            int n10 = ((Object)object).length;
            return Arrays.copyOf((byte[])object, n10);
        }
        return byArray;
    }

    public int hashCode() {
        int n10 = this.hashCode;
        if (n10 == 0) {
            int n11;
            n10 = 0;
            Iterator iterator2 = this.metadata.entrySet().iterator();
            while ((n11 = iterator2.hasNext()) != 0) {
                Object object = iterator2.next();
                String string2 = (String)object.getKey();
                int n12 = string2.hashCode();
                object = (byte[])object.getValue();
                n11 = Arrays.hashCode((byte[])object) ^ n12;
                n10 += n11;
            }
            this.hashCode = n10;
        }
        return this.hashCode;
    }
}

