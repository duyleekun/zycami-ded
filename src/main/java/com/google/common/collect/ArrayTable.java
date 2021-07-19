/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractTable;
import com.google.common.collect.ArrayTable$1;
import com.google.common.collect.ArrayTable$2;
import com.google.common.collect.ArrayTable$3;
import com.google.common.collect.ArrayTable$Column;
import com.google.common.collect.ArrayTable$ColumnMap;
import com.google.common.collect.ArrayTable$Row;
import com.google.common.collect.ArrayTable$RowMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Table$Cell;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ArrayTable
extends AbstractTable
implements Serializable {
    private static final long serialVersionUID;
    private final Object[][] array;
    private final ImmutableMap columnKeyToIndex;
    private final ImmutableList columnList;
    private transient ArrayTable$ColumnMap columnMap;
    private final ImmutableMap rowKeyToIndex;
    private final ImmutableList rowList;
    private transient ArrayTable$RowMap rowMap;

    private ArrayTable(ArrayTable arrayTable) {
        Object[][] objectArray;
        ImmutableList immutableList;
        Object[][] objectArray2 = arrayTable.rowList;
        this.rowList = objectArray2;
        this.columnList = immutableList = arrayTable.columnList;
        Object object = arrayTable.rowKeyToIndex;
        this.rowKeyToIndex = object;
        object = arrayTable.columnKeyToIndex;
        this.columnKeyToIndex = object;
        int n10 = objectArray2.size();
        int n11 = immutableList.size();
        object = new int[2];
        int n12 = 1;
        object[n12] = n11;
        n11 = 0;
        immutableList = null;
        object[0] = n10;
        objectArray2 = (Object[][])Array.newInstance(Object.class, (int[])object);
        this.array = objectArray2;
        object = null;
        for (int i10 = 0; i10 < (n12 = (objectArray = this.rowList).size()); ++i10) {
            objectArray = arrayTable.array;
            Object[] objectArray3 = objectArray[i10];
            Object[] objectArray4 = objectArray2[i10];
            objectArray = objectArray[i10];
            n12 = objectArray.length;
            System.arraycopy(objectArray3, 0, objectArray4, 0, n12);
        }
    }

    private ArrayTable(Table table) {
        Set set = table.rowKeySet();
        Set set2 = table.columnKeySet();
        this(set, set2);
        this.putAll(table);
    }

    /*
     * WARNING - void declaration
     */
    private ArrayTable(Iterable objectArray, Iterable iterable) {
        void var3_6;
        Object object;
        this.rowList = objectArray = ImmutableList.copyOf((Iterable)objectArray);
        iterable = ImmutableList.copyOf(iterable);
        this.columnList = iterable;
        boolean n10 = ((AbstractCollection)objectArray).isEmpty();
        boolean bl2 = ((AbstractCollection)iterable).isEmpty();
        int n11 = 1;
        if (n10 == bl2) {
            int n12 = n11;
        } else {
            boolean bl3 = false;
            object = null;
        }
        Preconditions.checkArgument((boolean)var3_6);
        object = Maps.indexMap((Collection)objectArray);
        this.rowKeyToIndex = object;
        object = Maps.indexMap((Collection)iterable);
        this.columnKeyToIndex = object;
        int n13 = ((AbstractCollection)objectArray).size();
        int n14 = ((AbstractCollection)iterable).size();
        object = new int[2];
        object[n11] = n14;
        object[0] = n13;
        objectArray = (Object[][])Array.newInstance(Object.class, (int[])object);
        this.array = objectArray;
        this.eraseAll();
    }

    public static /* synthetic */ Table$Cell access$000(ArrayTable arrayTable, int n10) {
        return arrayTable.getCell(n10);
    }

    public static /* synthetic */ ImmutableList access$100(ArrayTable arrayTable) {
        return arrayTable.columnList;
    }

    public static /* synthetic */ ImmutableList access$200(ArrayTable arrayTable) {
        return arrayTable.rowList;
    }

    public static /* synthetic */ ImmutableMap access$300(ArrayTable arrayTable) {
        return arrayTable.rowKeyToIndex;
    }

    public static /* synthetic */ ImmutableMap access$600(ArrayTable arrayTable) {
        return arrayTable.columnKeyToIndex;
    }

    public static /* synthetic */ Object access$800(ArrayTable arrayTable, int n10) {
        return arrayTable.getValue(n10);
    }

    public static ArrayTable create(Table table) {
        ArrayTable arrayTable;
        boolean bl2 = table instanceof ArrayTable;
        if (bl2) {
            table = (ArrayTable)table;
            arrayTable = new ArrayTable((ArrayTable)table);
        } else {
            arrayTable = new ArrayTable(table);
        }
        return arrayTable;
    }

    public static ArrayTable create(Iterable iterable, Iterable iterable2) {
        ArrayTable arrayTable = new ArrayTable(iterable, iterable2);
        return arrayTable;
    }

    private Table$Cell getCell(int n10) {
        ArrayTable$2 arrayTable$2 = new ArrayTable$2(this, n10);
        return arrayTable$2;
    }

    private Object getValue(int n10) {
        int n11 = this.columnList.size();
        n11 = n10 / n11;
        int n12 = this.columnList.size();
        return this.at(n11, n10 %= n12);
    }

    public Object at(int n10, int n11) {
        int n12 = this.rowList.size();
        Preconditions.checkElementIndex(n10, n12);
        n12 = this.columnList.size();
        Preconditions.checkElementIndex(n11, n12);
        return this.array[n10][n11];
    }

    public Iterator cellIterator() {
        int n10 = this.size();
        ArrayTable$1 arrayTable$1 = new ArrayTable$1(this, n10);
        return arrayTable$1;
    }

    public Set cellSet() {
        return super.cellSet();
    }

    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public Map column(Object object) {
        Preconditions.checkNotNull(object);
        Map map = this.columnKeyToIndex;
        object = (Integer)map.get(object);
        if (object == null) {
            object = ImmutableMap.of();
        } else {
            int n10 = (Integer)object;
            map = new ArrayTable$Column(this, n10);
            object = map;
        }
        return object;
    }

    public ImmutableList columnKeyList() {
        return this.columnList;
    }

    public ImmutableSet columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    public Map columnMap() {
        ArrayTable$ColumnMap arrayTable$ColumnMap = this.columnMap;
        if (arrayTable$ColumnMap == null) {
            this.columnMap = arrayTable$ColumnMap = new ArrayTable$ColumnMap(this, null);
        }
        return arrayTable$ColumnMap;
    }

    public boolean contains(Object object, Object object2) {
        boolean bl2 = this.containsRow(object);
        if (bl2 && (bl2 = this.containsColumn(object2))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean containsColumn(Object object) {
        return this.columnKeyToIndex.containsKey(object);
    }

    public boolean containsRow(Object object) {
        return this.rowKeyToIndex.containsKey(object);
    }

    public boolean containsValue(Object object) {
        for (Object[] objectArray : this.array) {
            for (Object object2 : objectArray) {
                boolean bl2 = Objects.equal(object, object2);
                if (!bl2) continue;
                return true;
            }
        }
        return false;
    }

    public Object erase(Object object, Object object2) {
        object = (Integer)this.rowKeyToIndex.get(object);
        object2 = (Integer)this.columnKeyToIndex.get(object2);
        if (object != null && object2 != null) {
            int n10 = (Integer)object;
            int n11 = (Integer)object2;
            return this.set(n10, n11, null);
        }
        return null;
    }

    public void eraseAll() {
        for (Object[] objectArray : this.array) {
            Arrays.fill(objectArray, null);
        }
    }

    public Object get(Object object, Object object2) {
        object = (Integer)this.rowKeyToIndex.get(object);
        ImmutableMap immutableMap = this.columnKeyToIndex;
        object2 = (Integer)immutableMap.get(object2);
        if (object != null && object2 != null) {
            int n10 = (Integer)object;
            int n11 = (Integer)object2;
            object = this.at(n10, n11);
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    public boolean isEmpty() {
        ImmutableList immutableList = this.rowList;
        boolean bl2 = immutableList.isEmpty();
        if (!bl2 && !(bl2 = (immutableList = this.columnList).isEmpty())) {
            bl2 = false;
            immutableList = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Object put(Object object, Object object2, Object object3) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        Integer n10 = (Integer)this.rowKeyToIndex.get(object);
        boolean bl2 = true;
        ImmutableList immutableList = null;
        boolean bl3 = n10 != null ? bl2 : false;
        ImmutableList immutableList2 = this.rowList;
        String string2 = "Row %s not in %s";
        Preconditions.checkArgument(bl3, string2, object, (Object)immutableList2);
        object = (Integer)this.columnKeyToIndex.get(object2);
        if (object == null) {
            bl2 = false;
        }
        immutableList = this.columnList;
        Preconditions.checkArgument(bl2, "Column %s not in %s", object2, (Object)immutableList);
        int n11 = n10;
        int n12 = (Integer)object;
        return this.set(n11, n12, object3);
    }

    public void putAll(Table table) {
        super.putAll(table);
    }

    public Object remove(Object object, Object object2) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public Map row(Object object) {
        Preconditions.checkNotNull(object);
        Map map = this.rowKeyToIndex;
        object = (Integer)map.get(object);
        if (object == null) {
            object = ImmutableMap.of();
        } else {
            int n10 = (Integer)object;
            map = new ArrayTable$Row(this, n10);
            object = map;
        }
        return object;
    }

    public ImmutableList rowKeyList() {
        return this.rowList;
    }

    public ImmutableSet rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    public Map rowMap() {
        ArrayTable$RowMap arrayTable$RowMap = this.rowMap;
        if (arrayTable$RowMap == null) {
            this.rowMap = arrayTable$RowMap = new ArrayTable$RowMap(this, null);
        }
        return arrayTable$RowMap;
    }

    public Object set(int n10, int n11, Object object) {
        int n12 = this.rowList.size();
        Preconditions.checkElementIndex(n10, n12);
        n12 = this.columnList.size();
        Preconditions.checkElementIndex(n11, n12);
        Object[][] objectArray = this.array;
        Object object2 = objectArray[n10][n11];
        objectArray[n10][n11] = object;
        return object2;
    }

    public int size() {
        int n10 = this.rowList.size();
        int n11 = this.columnList.size();
        return n10 * n11;
    }

    public Object[][] toArray(Class objectArray) {
        int n10;
        int[] nArray = new int[2];
        nArray[0] = n10 = this.rowList.size();
        Object[][] objectArray2 = this.columnList;
        n10 = objectArray2.size();
        int n11 = 1;
        nArray[n11] = n10;
        objectArray = (Object[][])Array.newInstance(objectArray, nArray);
        nArray = null;
        for (int i10 = 0; i10 < (n10 = (objectArray2 = this.rowList).size()); ++i10) {
            objectArray2 = this.array;
            Object[] objectArray3 = objectArray2[i10];
            Object[] objectArray4 = objectArray[i10];
            objectArray2 = objectArray2[i10];
            n10 = objectArray2.length;
            System.arraycopy(objectArray3, 0, objectArray4, 0, n10);
        }
        return objectArray;
    }

    public Collection values() {
        return super.values();
    }

    public Iterator valuesIterator() {
        int n10 = this.size();
        ArrayTable$3 arrayTable$3 = new ArrayTable$3(this, n10);
        return arrayTable$3;
    }
}

