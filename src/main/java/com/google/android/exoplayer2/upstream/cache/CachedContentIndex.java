/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  android.util.SparseBooleanArray
 */
package com.google.android.exoplayer2.upstream.cache;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.upstream.cache.CachedContent;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex$DatabaseStorage;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations;
import com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;

public class CachedContentIndex {
    public static final String FILE_NAME_ATOMIC = "cached_content_index.exi";
    private static final int INCREMENTAL_METADATA_READ_LENGTH = 0xA00000;
    private final SparseArray idToKey;
    private final HashMap keyToContent;
    private final SparseBooleanArray newIds;
    private CachedContentIndex$Storage previousStorage;
    private final SparseBooleanArray removedIds;
    private CachedContentIndex$Storage storage;

    public CachedContentIndex(DatabaseProvider databaseProvider) {
        this(databaseProvider, null, null, false, false);
    }

    public CachedContentIndex(DatabaseProvider object, File file, byte[] byArray, boolean bl2, boolean bl3) {
        Object object2;
        boolean bl4;
        if (object == null && file == null) {
            bl4 = false;
            object2 = null;
        } else {
            bl4 = true;
        }
        Assertions.checkState(bl4);
        this.keyToContent = object2 = new HashMap();
        this.idToKey = object2 = new SparseArray();
        this.removedIds = object2;
        super();
        this.newIds = object2;
        bl4 = false;
        object2 = null;
        CachedContentIndex$DatabaseStorage cachedContentIndex$DatabaseStorage = object != null ? new CachedContentIndex$DatabaseStorage((DatabaseProvider)object) : null;
        if (file != null) {
            String string2 = FILE_NAME_ATOMIC;
            object = new File(file, string2);
            super((File)object, byArray, bl2);
        }
        if (!(cachedContentIndex$DatabaseStorage == null || object2 != null && bl3)) {
            this.storage = cachedContentIndex$DatabaseStorage;
            this.previousStorage = object2;
        } else {
            this.storage = object = (CachedContentIndex$Storage)Util.castNonNull(object2);
            this.previousStorage = cachedContentIndex$DatabaseStorage;
        }
    }

    public static /* synthetic */ Cipher access$000() {
        return CachedContentIndex.getCipher();
    }

    public static /* synthetic */ DefaultContentMetadata access$100(DataInputStream dataInputStream) {
        return CachedContentIndex.readContentMetadata(dataInputStream);
    }

    public static /* synthetic */ void access$200(DefaultContentMetadata defaultContentMetadata, DataOutputStream dataOutputStream) {
        CachedContentIndex.writeContentMetadata(defaultContentMetadata, dataOutputStream);
    }

    private CachedContent addNew(String string2) {
        int n10 = CachedContentIndex.getNewId(this.idToKey);
        CachedContent cachedContent = new CachedContent(n10, string2);
        this.keyToContent.put(string2, cachedContent);
        this.idToKey.put(n10, (Object)string2);
        this.newIds.put(n10, true);
        this.storage.onUpdate(cachedContent);
        return cachedContent;
    }

    public static void delete(DatabaseProvider databaseProvider, long l10) {
        CachedContentIndex$DatabaseStorage.delete(databaseProvider, l10);
    }

    private static Cipher getCipher() {
        int n10 = Util.SDK_INT;
        String string2 = "AES/CBC/PKCS5PADDING";
        int n11 = 18;
        if (n10 == n11) {
            String string3 = "BC";
            try {
                return Cipher.getInstance(string2, string3);
            }
            catch (Throwable throwable) {}
        }
        return Cipher.getInstance(string2);
    }

    public static int getNewId(SparseArray sparseArray) {
        int n10;
        int n11 = sparseArray.size();
        int n12 = 0;
        if (n11 == 0) {
            n10 = 0;
        } else {
            n10 = n11 + -1;
            n10 = sparseArray.keyAt(n10) + 1;
        }
        if (n10 < 0) {
            while (n12 < n11 && n12 == (n10 = sparseArray.keyAt(n12))) {
                ++n12;
            }
            n10 = n12;
        }
        return n10;
    }

    public static boolean isIndexFile(String string2) {
        return string2.startsWith(FILE_NAME_ATOMIC);
    }

    private static DefaultContentMetadata readContentMetadata(DataInputStream object) {
        int n10 = ((DataInputStream)object).readInt();
        Serializable serializable = new HashMap();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = ((DataInputStream)object).readUTF();
            int n11 = ((DataInputStream)object).readInt();
            if (n11 >= 0) {
                int n12 = 0xA00000;
                int n13 = Math.min(n11, n12);
                byte[] byArray = Util.EMPTY_BYTE_ARRAY;
                int n14 = 0;
                while (n14 != n11) {
                    int n15 = n14 + n13;
                    byArray = Arrays.copyOf(byArray, n15);
                    ((DataInputStream)object).readFully(byArray, n14, n13);
                    n13 = Math.min(n11 - n15, n12);
                    n14 = n15;
                }
                ((HashMap)serializable).put(string2, byArray);
                continue;
            }
            serializable = new StringBuilder(31);
            ((StringBuilder)serializable).append("Invalid value size: ");
            ((StringBuilder)serializable).append(n11);
            String string3 = ((StringBuilder)serializable).toString();
            object = new IOException(string3);
            throw object;
        }
        object = new DefaultContentMetadata((Map)((Object)serializable));
        return object;
    }

    private static void writeContentMetadata(DefaultContentMetadata iterator2, DataOutputStream dataOutputStream) {
        iterator2 = ((DefaultContentMetadata)((Object)iterator2)).entrySet();
        int n10 = iterator2.size();
        dataOutputStream.writeInt(n10);
        iterator2 = iterator2.iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            Object object = (Map.Entry)iterator2.next();
            String string2 = (String)object.getKey();
            dataOutputStream.writeUTF(string2);
            object = (byte[])object.getValue();
            int n11 = ((Object)object).length;
            dataOutputStream.writeInt(n11);
            dataOutputStream.write((byte[])object);
        }
    }

    public void applyContentMetadataMutations(String object, ContentMetadataMutations object2) {
        boolean bl2 = ((CachedContent)(object = this.getOrAdd((String)object))).applyMetadataMutations((ContentMetadataMutations)object2);
        if (bl2) {
            object2 = this.storage;
            object2.onUpdate((CachedContent)object);
        }
    }

    public int assignIdForKey(String string2) {
        return this.getOrAdd((String)string2).id;
    }

    public CachedContent get(String string2) {
        return (CachedContent)this.keyToContent.get(string2);
    }

    public Collection getAll() {
        return Collections.unmodifiableCollection(this.keyToContent.values());
    }

    public ContentMetadata getContentMetadata(String object) {
        object = (object = this.get((String)object)) != null ? ((CachedContent)object).getMetadata() : DefaultContentMetadata.EMPTY;
        return object;
    }

    public String getKeyForId(int n10) {
        return (String)this.idToKey.get(n10);
    }

    public Set getKeys() {
        return this.keyToContent.keySet();
    }

    public CachedContent getOrAdd(String string2) {
        CachedContent cachedContent = (CachedContent)this.keyToContent.get(string2);
        if (cachedContent == null) {
            cachedContent = this.addNew(string2);
        }
        return cachedContent;
    }

    public void initialize(long l10) {
        CachedContentIndex$Storage cachedContentIndex$Storage;
        boolean bl2;
        this.storage.initialize(l10);
        CachedContentIndex$Storage cachedContentIndex$Storage2 = this.previousStorage;
        if (cachedContentIndex$Storage2 != null) {
            cachedContentIndex$Storage2.initialize(l10);
        }
        if (!(bl2 = (cachedContentIndex$Storage = this.storage).exists()) && (cachedContentIndex$Storage = this.previousStorage) != null && (bl2 = cachedContentIndex$Storage.exists())) {
            cachedContentIndex$Storage = this.previousStorage;
            HashMap hashMap = this.keyToContent;
            cachedContentIndex$Storage2 = this.idToKey;
            cachedContentIndex$Storage.load(hashMap, (SparseArray)cachedContentIndex$Storage2);
            cachedContentIndex$Storage = this.storage;
            hashMap = this.keyToContent;
            cachedContentIndex$Storage.storeFully(hashMap);
        } else {
            cachedContentIndex$Storage = this.storage;
            HashMap hashMap = this.keyToContent;
            cachedContentIndex$Storage2 = this.idToKey;
            cachedContentIndex$Storage.load(hashMap, (SparseArray)cachedContentIndex$Storage2);
        }
        cachedContentIndex$Storage = this.previousStorage;
        if (cachedContentIndex$Storage != null) {
            cachedContentIndex$Storage.delete();
            bl2 = false;
            cachedContentIndex$Storage = null;
            this.previousStorage = null;
        }
    }

    public void maybeRemove(String string2) {
        boolean bl2;
        CachedContent cachedContent = (CachedContent)this.keyToContent.get(string2);
        if (cachedContent != null && (bl2 = cachedContent.isEmpty()) && (bl2 = cachedContent.isFullyUnlocked())) {
            this.keyToContent.remove(string2);
            int n10 = cachedContent.id;
            SparseBooleanArray sparseBooleanArray = this.newIds;
            bl2 = sparseBooleanArray.get(n10);
            CachedContentIndex$Storage cachedContentIndex$Storage = this.storage;
            cachedContentIndex$Storage.onRemove(cachedContent, bl2);
            if (bl2) {
                this.idToKey.remove(n10);
                cachedContent = this.newIds;
                cachedContent.delete(n10);
            } else {
                cachedContent = this.idToKey;
                sparseBooleanArray = null;
                cachedContent.put(n10, null);
                cachedContent = this.removedIds;
                bl2 = true;
                cachedContent.put(n10, bl2);
            }
        }
    }

    public void removeEmpty() {
        boolean bl2;
        UnmodifiableIterator unmodifiableIterator = ImmutableSet.copyOf(this.keyToContent.keySet()).iterator();
        while (bl2 = unmodifiableIterator.hasNext()) {
            String string2 = (String)unmodifiableIterator.next();
            this.maybeRemove(string2);
        }
    }

    public void store() {
        CachedContentIndex$Storage cachedContentIndex$Storage = this.storage;
        HashMap hashMap = this.keyToContent;
        cachedContentIndex$Storage.storeIncremental(hashMap);
        cachedContentIndex$Storage = this.removedIds;
        int n10 = cachedContentIndex$Storage.size();
        hashMap = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            SparseArray sparseArray = this.idToKey;
            SparseBooleanArray sparseBooleanArray = this.removedIds;
            int n11 = sparseBooleanArray.keyAt(i10);
            sparseArray.remove(n11);
        }
        this.removedIds.clear();
        this.newIds.clear();
    }
}

