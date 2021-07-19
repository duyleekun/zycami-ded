/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.SortedList$BatchedCallback;
import androidx.recyclerview.widget.SortedList$Callback;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

public class SortedList {
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = 255;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private SortedList$BatchedCallback mBatchedCallback;
    private SortedList$Callback mCallback;
    public Object[] mData;
    private int mNewDataStart;
    private Object[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class mTClass;

    public SortedList(Class clazz, SortedList$Callback callback) {
        this(clazz, callback, 10);
    }

    public SortedList(Class objectArray, SortedList$Callback callback, int n10) {
        this.mTClass = objectArray;
        objectArray = (Object[])Array.newInstance(objectArray, n10);
        this.mData = objectArray;
        this.mCallback = callback;
        this.mSize = 0;
    }

    private int add(Object object, boolean bl2) {
        Object object2 = this.mData;
        int n10 = this.mSize;
        boolean bl3 = false;
        SortedList$Callback sortedList$Callback = null;
        int n11 = 1;
        int n12 = this.findIndexOf(object, (Object[])object2, 0, n10, n11);
        int n13 = 1;
        int n14 = -1;
        if (n12 == n14) {
            n12 = 0;
        } else {
            n14 = this.mSize;
            if (n12 < n14 && (bl3 = (sortedList$Callback = this.mCallback).areItemsTheSame(object2 = this.mData[n12], object))) {
                SortedList$Callback sortedList$Callback2 = this.mCallback;
                bl2 = sortedList$Callback2.areContentsTheSame(object2, object);
                if (bl2) {
                    this.mData[n12] = object;
                    return n12;
                }
                this.mData[n12] = object;
                sortedList$Callback2 = this.mCallback;
                object = sortedList$Callback2.getChangePayload(object2, object);
                sortedList$Callback2.onChanged(n12, n13, object);
                return n12;
            }
        }
        this.addToData(n12, object);
        if (bl2) {
            object = this.mCallback;
            object.onInserted(n12, n13);
        }
        return n12;
    }

    private void addAllInternal(Object[] object) {
        int n10 = ((Object[])object).length;
        int n11 = 1;
        if (n10 < n11) {
            return;
        }
        n10 = this.sortAndDedup((Object[])object);
        n11 = this.mSize;
        if (n11 == 0) {
            this.mData = object;
            this.mSize = n10;
            object = this.mCallback;
            n11 = 0;
            object.onInserted(0, n10);
        } else {
            this.merge((Object[])object, n10);
        }
    }

    private void addToData(int n10, Object objectArray) {
        int n11 = this.mSize;
        if (n10 <= n11) {
            Object[] objectArray2 = this.mData;
            int n12 = objectArray2.length;
            if (n11 == n12) {
                Object[] objectArray3 = this.mTClass;
                int n13 = objectArray2.length + 10;
                objectArray3 = (Object[])Array.newInstance(objectArray3, n13);
                objectArray2 = this.mData;
                System.arraycopy(objectArray2, 0, objectArray3, 0, n10);
                objectArray3[n10] = objectArray;
                objectArray = this.mData;
                n13 = n10 + 1;
                n12 = this.mSize - n10;
                System.arraycopy(objectArray, n10, objectArray3, n13, n12);
                this.mData = objectArray3;
            } else {
                n12 = n10 + 1;
                System.arraycopy(objectArray2, n10, objectArray2, n12, n11 -= n10);
                Object[] objectArray4 = this.mData;
                objectArray4[n10] = objectArray;
            }
            this.mSize = n10 = this.mSize + 1;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cannot add item to ");
        stringBuilder.append(n10);
        stringBuilder.append(" because size is ");
        n10 = this.mSize;
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        objectArray = new IndexOutOfBoundsException(string2);
        throw objectArray;
    }

    private Object[] copyArray(Object[] objectArray) {
        Object[] objectArray2 = this.mTClass;
        int n10 = objectArray.length;
        objectArray2 = (Object[])Array.newInstance(objectArray2, n10);
        n10 = objectArray.length;
        System.arraycopy(objectArray, 0, objectArray2, 0, n10);
        return objectArray2;
    }

    private int findIndexOf(Object object, Object[] object2, int n10, int n11, int n12) {
        int n13;
        int n14;
        while (true) {
            n14 = -1;
            n13 = 1;
            if (n10 >= n11) break;
            SortedList$Callback sortedList$Callback = this.mCallback;
            int n15 = (n10 + n11) / 2;
            Object object3 = object2[n15];
            int n16 = sortedList$Callback.compare(object3, object);
            if (n16 < 0) {
                n10 = ++n15;
                continue;
            }
            if (n16 == 0) {
                object2 = this.mCallback;
                boolean bl2 = ((SortedList$Callback)object2).areItemsTheSame(object3, object);
                if (bl2) {
                    return n15;
                }
                int n17 = this.linearEqualitySearch(object, n15, n10, n11);
                if (n12 == n13) {
                    if (n17 != n14) {
                        n15 = n17;
                    }
                    return n15;
                }
                return n17;
            }
            n11 = n15;
        }
        if (n12 != n13) {
            n10 = n14;
        }
        return n10;
    }

    private int findSameItem(Object object, Object[] objectArray, int n10, int n11) {
        while (n10 < n11) {
            SortedList$Callback sortedList$Callback = this.mCallback;
            Object object2 = objectArray[n10];
            boolean bl2 = sortedList$Callback.areItemsTheSame(object2, object);
            if (bl2) {
                return n10;
            }
            ++n10;
        }
        return -1;
    }

    private int linearEqualitySearch(Object object, int n10, int n11, int n12) {
        Object object2;
        SortedList$Callback sortedList$Callback;
        Object object3;
        SortedList$Callback sortedList$Callback2;
        int n13;
        int n14;
        for (n14 = n10 + -1; n14 >= n11 && (n13 = (sortedList$Callback2 = this.mCallback).compare(object3 = this.mData[n14], object)) == 0; n14 += -1) {
            sortedList$Callback2 = this.mCallback;
            boolean bl2 = sortedList$Callback2.areItemsTheSame(object3, object);
            if (!bl2) continue;
            return n14;
        }
        while (++n10 < n12 && (n14 = (sortedList$Callback = this.mCallback).compare(object2 = this.mData[n10], object)) == 0) {
            sortedList$Callback = this.mCallback;
            n11 = (int)(sortedList$Callback.areItemsTheSame(object2, object) ? 1 : 0);
            if (n11 == 0) continue;
            return n10;
        }
        return -1;
    }

    private void merge(Object[] objectArray, int n10) {
        int n11;
        SortedList$Callback sortedList$Callback = this.mCallback;
        boolean bl2 = sortedList$Callback instanceof SortedList$BatchedCallback;
        int n12 = 1;
        if (bl2 ^= n12) {
            this.beginBatchedUpdates();
        }
        Object[] objectArray2 = this.mData;
        this.mOldData = objectArray2;
        int n13 = 0;
        objectArray2 = null;
        this.mOldDataStart = 0;
        this.mOldDataSize = n11 = this.mSize;
        n11 = n11 + n10 + 10;
        Object object = this.mTClass;
        Object object2 = (Object[])Array.newInstance(object, n11);
        this.mData = object2;
        this.mNewDataStart = 0;
        while (true) {
            int n14;
            block10: {
                int n15;
                block8: {
                    int n16;
                    block9: {
                        if ((n11 = this.mOldDataStart) >= (n16 = this.mOldDataSize) && n13 >= n10) break block8;
                        if (n11 != n16) break block9;
                        Object object3 = this.mData;
                        n11 = this.mNewDataStart;
                        System.arraycopy(objectArray, n13, object3, n11, n10 -= n13);
                        this.mNewDataStart = n15 = this.mNewDataStart + n10;
                        this.mSize = n12 = this.mSize + n10;
                        object3 = this.mCallback;
                        object3.onInserted(n15 -= n10, n10);
                        break block8;
                    }
                    if (n13 != n10) break block10;
                    objectArray = this.mOldData;
                    Object[] objectArray3 = this.mData;
                    n12 = this.mNewDataStart;
                    System.arraycopy(objectArray, n11, objectArray3, n12, n16 -= n11);
                    this.mNewDataStart = n15 = this.mNewDataStart + n16;
                }
                n15 = 0;
                objectArray = null;
                this.mOldData = null;
                if (bl2) {
                    this.endBatchedUpdates();
                }
                return;
            }
            Object object4 = this.mCallback;
            object2 = this.mOldData[n11];
            object = objectArray[n13];
            int n17 = ((SortedList$Callback)object4).compare(object2, object);
            if (n17 > 0) {
                object2 = this.mData;
                n17 = this.mNewDataStart;
                this.mNewDataStart = n14 = n17 + 1;
                object2[n17] = object;
                this.mSize = n11 = this.mSize + n12;
                ++n13;
                object2 = this.mCallback;
                object2.onInserted(n14 -= n12, n12);
                continue;
            }
            if (n17 == 0 && (n17 = (int)(((SortedList$Callback)(object4 = this.mCallback)).areItemsTheSame(object2, object) ? 1 : 0)) != 0) {
                int n18;
                object4 = this.mData;
                n14 = this.mNewDataStart;
                this.mNewDataStart = n18 = n14 + 1;
                object4[n14] = object;
                ++n13;
                this.mOldDataStart = n17 = this.mOldDataStart + n12;
                object4 = this.mCallback;
                n17 = (int)(((SortedList$Callback)object4).areContentsTheSame(object2, object) ? 1 : 0);
                if (n17 != 0) continue;
                object4 = this.mCallback;
                n14 = this.mNewDataStart - n12;
                object2 = ((SortedList$Callback)object4).getChangePayload(object2, object);
                ((SortedList$Callback)object4).onChanged(n14, n12, object2);
                continue;
            }
            object = this.mData;
            n17 = this.mNewDataStart;
            this.mNewDataStart = n14 = n17 + 1;
            object[n17] = object2;
            this.mOldDataStart = n11 = this.mOldDataStart + n12;
        }
    }

    private boolean remove(Object object, boolean bl2) {
        int n10;
        Object[] objectArray = this.mData;
        int n11 = this.mSize;
        int n12 = 2;
        int n13 = this.findIndexOf(object, objectArray, 0, n11, n12);
        if (n13 == (n10 = -1)) {
            return false;
        }
        this.removeItemAtIndex(n13, bl2);
        return true;
    }

    private void removeItemAtIndex(int n10, boolean bl2) {
        int n11;
        Object[] objectArray = this.mData;
        int n12 = n10 + 1;
        int n13 = this.mSize - n10;
        int n14 = 1;
        System.arraycopy(objectArray, n12, objectArray, n10, n13 -= n14);
        this.mSize = n11 = this.mSize - n14;
        Object[] objectArray2 = this.mData;
        n13 = 0;
        objectArray2[n11] = null;
        if (bl2) {
            SortedList$Callback sortedList$Callback = this.mCallback;
            sortedList$Callback.onRemoved(n10, n14);
        }
    }

    private void replaceAllInsert(Object object) {
        int n10;
        Object object2 = this.mData;
        int n11 = this.mNewDataStart;
        object2[n11] = object;
        int n12 = 1;
        this.mNewDataStart = n11 += n12;
        this.mSize = n10 = this.mSize + n12;
        object2 = this.mCallback;
        object2.onInserted(n11 -= n12, n12);
    }

    private void replaceAllInternal(Object[] object) {
        int n10;
        SortedList$Callback sortedList$Callback = this.mCallback;
        boolean bl2 = sortedList$Callback instanceof SortedList$BatchedCallback;
        int n11 = 1;
        if (bl2 ^= n11) {
            this.beginBatchedUpdates();
        }
        this.mOldDataStart = 0;
        this.mOldDataSize = n10 = this.mSize;
        Object object2 = this.mData;
        this.mOldData = object2;
        this.mNewDataStart = 0;
        int n12 = this.sortAndDedup((Object[])object);
        this.mData = object2 = (Object[])Array.newInstance(this.mTClass, n12);
        while (true) {
            int n13;
            int n14;
            block11: {
                int n15;
                block9: {
                    block10: {
                        if ((n10 = this.mNewDataStart) >= n12 && (n14 = this.mOldDataStart) >= (n13 = this.mOldDataSize)) break block9;
                        n14 = this.mOldDataStart;
                        n13 = this.mOldDataSize;
                        if (n14 < n13) break block10;
                        Object[] objectArray = this.mData;
                        System.arraycopy(object, n10, objectArray, n10, n12 -= n10);
                        this.mNewDataStart = n15 = this.mNewDataStart + n12;
                        this.mSize = n15 = this.mSize + n12;
                        object = this.mCallback;
                        object.onInserted(n10, n12);
                        break block9;
                    }
                    if (n10 < n12) break block11;
                    this.mSize = n15 = this.mSize - (n13 -= n14);
                    object = this.mCallback;
                    object.onRemoved(n10, n13);
                }
                n15 = 0;
                object = null;
                this.mOldData = null;
                if (bl2) {
                    this.endBatchedUpdates();
                }
                return;
            }
            Object object3 = this.mCallback;
            Object object4 = this.mOldData[n14];
            object2 = object[n10];
            n13 = ((SortedList$Callback)object3).compare(object4, object2);
            if (n13 < 0) {
                this.replaceAllRemove();
                continue;
            }
            if (n13 > 0) {
                this.replaceAllInsert(object2);
                continue;
            }
            object3 = this.mCallback;
            n13 = (int)(((SortedList$Callback)object3).areItemsTheSame(object4, object2) ? 1 : 0);
            if (n13 == 0) {
                this.replaceAllRemove();
                this.replaceAllInsert(object2);
                continue;
            }
            object3 = this.mData;
            int n16 = this.mNewDataStart;
            object3[n16] = object2;
            this.mOldDataStart = n13 = this.mOldDataStart + n11;
            this.mNewDataStart = n16 += n11;
            object3 = this.mCallback;
            n13 = (int)(((SortedList$Callback)object3).areContentsTheSame(object4, object2) ? 1 : 0);
            if (n13 != 0) continue;
            object3 = this.mCallback;
            n16 = this.mNewDataStart - n11;
            object2 = ((SortedList$Callback)object3).getChangePayload(object4, object2);
            ((SortedList$Callback)object3).onChanged(n16, n11, object2);
        }
    }

    private void replaceAllRemove() {
        int n10 = this.mSize;
        int n11 = 1;
        this.mSize = n10 -= n11;
        this.mOldDataStart = n10 = this.mOldDataStart + n11;
        SortedList$Callback sortedList$Callback = this.mCallback;
        int n12 = this.mNewDataStart;
        sortedList$Callback.onRemoved(n12, n11);
    }

    private int sortAndDedup(Object[] objectArray) {
        int n10;
        int n11 = objectArray.length;
        int n12 = 0;
        if (n11 == 0) {
            return 0;
        }
        SortedList$Callback sortedList$Callback = this.mCallback;
        Arrays.sort(objectArray, sortedList$Callback);
        int n13 = 0;
        n12 = n11;
        for (n11 = 1; n11 < (n10 = objectArray.length); ++n11) {
            SortedList$Callback sortedList$Callback2 = this.mCallback;
            Object object = objectArray[n13];
            Object object2 = objectArray[n11];
            int n14 = sortedList$Callback2.compare(object, object2);
            if (n14 == 0) {
                int n15;
                n14 = this.findSameItem(object2, objectArray, n13, n12);
                if (n14 != (n15 = -1)) {
                    objectArray[n14] = object2;
                    continue;
                }
                if (n12 != n11) {
                    objectArray[n12] = object2;
                }
                ++n12;
                continue;
            }
            if (n12 != n11) {
                objectArray[n12] = object2;
            }
            int n16 = n12 + 1;
            n13 = n12;
            n12 = n16;
        }
        return n12;
    }

    private void throwIfInMutationOperation() {
        Object object = this.mOldData;
        if (object == null) {
            return;
        }
        object = new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        throw object;
    }

    public int add(Object object) {
        this.throwIfInMutationOperation();
        return this.add(object, true);
    }

    public void addAll(Collection objectArray) {
        Object[] objectArray2 = this.mTClass;
        int n10 = objectArray.size();
        objectArray2 = (Object[])Array.newInstance(objectArray2, n10);
        objectArray = objectArray.toArray(objectArray2);
        this.addAll(objectArray, true);
    }

    public void addAll(Object ... objectArray) {
        this.addAll(objectArray, false);
    }

    public void addAll(Object[] objectArray, boolean bl2) {
        this.throwIfInMutationOperation();
        int n10 = objectArray.length;
        if (n10 == 0) {
            return;
        }
        if (bl2) {
            this.addAllInternal(objectArray);
        } else {
            objectArray = this.copyArray(objectArray);
            this.addAllInternal(objectArray);
        }
    }

    public void beginBatchedUpdates() {
        this.throwIfInMutationOperation();
        SortedList$Callback sortedList$Callback = this.mCallback;
        boolean bl2 = sortedList$Callback instanceof SortedList$BatchedCallback;
        if (bl2) {
            return;
        }
        SortedList$BatchedCallback sortedList$BatchedCallback = this.mBatchedCallback;
        if (sortedList$BatchedCallback == null) {
            this.mBatchedCallback = sortedList$BatchedCallback = new SortedList$BatchedCallback(sortedList$Callback);
        }
        this.mCallback = sortedList$Callback = this.mBatchedCallback;
    }

    public void clear() {
        this.throwIfInMutationOperation();
        int n10 = this.mSize;
        if (n10 == 0) {
            return;
        }
        Arrays.fill(this.mData, 0, n10, null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, n10);
    }

    public void endBatchedUpdates() {
        SortedList$BatchedCallback sortedList$BatchedCallback;
        this.throwIfInMutationOperation();
        SortedList$Callback sortedList$Callback = this.mCallback;
        boolean bl2 = sortedList$Callback instanceof SortedList$BatchedCallback;
        if (bl2) {
            sortedList$Callback = (SortedList$BatchedCallback)sortedList$Callback;
            ((SortedList$BatchedCallback)sortedList$Callback).dispatchLastEvent();
        }
        if ((sortedList$Callback = this.mCallback) == (sortedList$BatchedCallback = this.mBatchedCallback)) {
            this.mCallback = sortedList$Callback = sortedList$BatchedCallback.mWrappedCallback;
        }
    }

    public Object get(int n10) {
        int n11 = this.mSize;
        if (n10 < n11 && n10 >= 0) {
            int n12;
            Object[] objectArray = this.mOldData;
            if (objectArray != null && n10 >= (n12 = this.mNewDataStart)) {
                n10 -= n12;
                n12 = this.mOldDataStart;
                return objectArray[n10 += n12];
            }
            return this.mData[n10];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Asked to get item at ");
        stringBuilder.append(n10);
        stringBuilder.append(" but size is ");
        n10 = this.mSize;
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public int indexOf(Object object) {
        Object object2 = this.mOldData;
        if (object2 != null) {
            int n10;
            Object object3 = this.mData;
            boolean bl2 = false;
            Object[] objectArray = null;
            int n11 = this.mNewDataStart;
            int n12 = 4;
            Object object4 = object;
            int n13 = this.findIndexOf(object, (Object[])object3, 0, n11, n12);
            if (n13 != (n10 = -1)) {
                return n13;
            }
            objectArray = this.mOldData;
            n11 = this.mOldDataStart;
            n12 = this.mOldDataSize;
            int n14 = 4;
            object4 = this;
            object3 = object;
            int n15 = this.findIndexOf(object, objectArray, n11, n12, n14);
            if (n15 != n10) {
                n13 = this.mOldDataStart;
                n15 -= n13;
                n13 = this.mNewDataStart;
                return n15 + n13;
            }
            return n10;
        }
        Object[] objectArray = this.mData;
        int n16 = this.mSize;
        object2 = this;
        return this.findIndexOf(object, objectArray, 0, n16, 4);
    }

    public void recalculatePositionOfItemAt(int n10) {
        this.throwIfInMutationOperation();
        Object object = this.get(n10);
        SortedList$Callback sortedList$Callback = null;
        this.removeItemAtIndex(n10, false);
        int n11 = this.add(object, false);
        if (n10 != n11) {
            sortedList$Callback = this.mCallback;
            sortedList$Callback.onMoved(n10, n11);
        }
    }

    public boolean remove(Object object) {
        this.throwIfInMutationOperation();
        return this.remove(object, true);
    }

    public Object removeItemAt(int n10) {
        this.throwIfInMutationOperation();
        Object object = this.get(n10);
        this.removeItemAtIndex(n10, true);
        return object;
    }

    public void replaceAll(Collection objectArray) {
        Object[] objectArray2 = this.mTClass;
        int n10 = objectArray.size();
        objectArray2 = (Object[])Array.newInstance(objectArray2, n10);
        objectArray = objectArray.toArray(objectArray2);
        this.replaceAll(objectArray, true);
    }

    public void replaceAll(Object ... objectArray) {
        this.replaceAll(objectArray, false);
    }

    public void replaceAll(Object[] objectArray, boolean bl2) {
        this.throwIfInMutationOperation();
        if (bl2) {
            this.replaceAllInternal(objectArray);
        } else {
            objectArray = this.copyArray(objectArray);
            this.replaceAllInternal(objectArray);
        }
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int n10, Object object) {
        SortedList$Callback sortedList$Callback;
        int n11;
        SortedList$Callback sortedList$Callback2;
        int n12;
        this.throwIfInMutationOperation();
        Object object2 = this.get(n10);
        Object object3 = null;
        int n13 = 1;
        if (object2 != object && (n12 = (sortedList$Callback2 = this.mCallback).areContentsTheSame(object2, object)) != 0) {
            n12 = 0;
            sortedList$Callback2 = null;
        } else {
            n12 = n13;
        }
        if (object2 != object && (n11 = (sortedList$Callback = this.mCallback).compare(object2, object)) == 0) {
            object3 = this.mData;
            object3[n10] = object;
            if (n12 != 0) {
                object3 = this.mCallback;
                object = ((SortedList$Callback)object3).getChangePayload(object2, object);
                ((SortedList$Callback)object3).onChanged(n10, n13, object);
            }
            return;
        }
        if (n12 != 0) {
            sortedList$Callback2 = this.mCallback;
            object2 = sortedList$Callback2.getChangePayload(object2, object);
            sortedList$Callback2.onChanged(n10, n13, object2);
        }
        this.removeItemAtIndex(n10, false);
        int n14 = this.add(object, false);
        if (n10 != n14) {
            object2 = this.mCallback;
            object2.onMoved(n10, n14);
        }
    }
}

