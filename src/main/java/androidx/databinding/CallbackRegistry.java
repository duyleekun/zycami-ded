/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.CallbackRegistry$NotifierCallback;
import java.util.ArrayList;
import java.util.List;

public class CallbackRegistry
implements Cloneable {
    private static final String TAG = "CallbackRegistry";
    private List mCallbacks;
    private long mFirst64Removed;
    private int mNotificationLevel;
    private final CallbackRegistry$NotifierCallback mNotifier;
    private long[] mRemainderRemoved;

    public CallbackRegistry(CallbackRegistry$NotifierCallback callbackRegistry$NotifierCallback) {
        ArrayList arrayList;
        this.mCallbacks = arrayList = new ArrayList();
        this.mFirst64Removed = 0L;
        this.mNotifier = callbackRegistry$NotifierCallback;
    }

    private boolean isRemoved(int n10) {
        long l10 = 0L;
        long l11 = 1L;
        int n11 = 1;
        int n12 = 64;
        if (n10 < n12) {
            l11 <<= n10;
            long l12 = this.mFirst64Removed;
            long l13 = (l11 &= l12) - l10;
            n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n10 == 0) {
                n11 = 0;
            }
            return n11 != 0;
        }
        long[] lArray = this.mRemainderRemoved;
        if (lArray == null) {
            return false;
        }
        int n13 = n10 / 64 - n11;
        int n14 = lArray.length;
        if (n13 >= n14) {
            return false;
        }
        long l14 = lArray[n13];
        n10 %= n12;
        long l15 = (l11 = l11 << n10 & l14) - l10;
        if ((n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1))) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    private void notifyCallbacks(Object object, int n10, Object object2, int n11, int n12, long l10) {
        long l11 = 1L;
        while (n11 < n12) {
            long l12 = l10 & l11;
            long l13 = 0L;
            long l14 = l12 - l13;
            Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object3 == false) {
                CallbackRegistry$NotifierCallback callbackRegistry$NotifierCallback = this.mNotifier;
                Object e10 = this.mCallbacks.get(n11);
                callbackRegistry$NotifierCallback.onNotifyCallback(e10, object, n10, object2);
            }
            object3 = 1;
            l11 <<= object3;
            ++n11;
        }
    }

    private void notifyFirst64(Object object, int n10, Object object2) {
        int n11 = this.mCallbacks.size();
        int n12 = Math.min(64, n11);
        long l10 = this.mFirst64Removed;
        this.notifyCallbacks(object, n10, object2, 0, n12, l10);
    }

    private void notifyRecurse(Object object, int n10, Object object2) {
        int n11 = this.mCallbacks.size();
        long[] lArray = this.mRemainderRemoved;
        int n12 = lArray == null ? -1 : lArray.length + -1;
        this.notifyRemainder(object, n10, object2, n12);
        int n13 = (n12 + 2) * 64;
        this.notifyCallbacks(object, n10, object2, n13, n11, 0L);
    }

    private void notifyRemainder(Object object, int n10, Object object2, int n11) {
        if (n11 < 0) {
            this.notifyFirst64(object, n10, object2);
        } else {
            long l10 = this.mRemainderRemoved[n11];
            int n12 = (n11 + 1) * 64;
            List list = this.mCallbacks;
            int n13 = list.size();
            int n14 = n12 + 64;
            int n15 = Math.min(n13, n14);
            this.notifyRemainder(object, n10, object2, n11 += -1);
            this.notifyCallbacks(object, n10, object2, n12, n15, l10);
        }
    }

    private void removeRemovedCallbacks(int n10, long l10) {
        int n11 = n10 + 64;
        int n12 = 1;
        n11 -= n12;
        long l11 = Long.MIN_VALUE;
        while (n11 >= n10) {
            long l12 = l10 & l11;
            long l13 = 0L;
            long l14 = l12 - l13;
            Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object != false) {
                List list = this.mCallbacks;
                list.remove(n11);
            }
            l11 >>>= n12;
            n11 += -1;
        }
    }

    private void setRemovalBit(int n10) {
        long l10 = 1L;
        int n11 = 64;
        if (n10 < n11) {
            l10 <<= n10;
            long l11 = this.mFirst64Removed;
            this.mFirst64Removed = l10 |= l11;
        } else {
            int n12 = n10 / 64 + -1;
            long[] lArray = this.mRemainderRemoved;
            if (lArray == null) {
                int n13 = this.mCallbacks.size() / n11;
                this.mRemainderRemoved = lArray = new long[n13];
            } else {
                int n14 = lArray.length;
                if (n14 <= n12) {
                    n14 = this.mCallbacks.size() / n11;
                    lArray = new long[n14];
                    long[] lArray2 = this.mRemainderRemoved;
                    int n15 = lArray2.length;
                    System.arraycopy(lArray2, 0, lArray, 0, n15);
                    this.mRemainderRemoved = lArray;
                }
            }
            l10 <<= (n10 %= n11);
            long[] lArray3 = this.mRemainderRemoved;
            long l12 = lArray3[n12];
            lArray3[n12] = l10 |= l12;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void add(Object object) {
        synchronized (this) {
            Throwable throwable2;
            if (object != null) {
                try {
                    List list = this.mCallbacks;
                    int n10 = list.lastIndexOf(object);
                    if (n10 < 0 || (n10 = (int)(this.isRemoved(n10) ? 1 : 0)) != 0) {
                        list = this.mCallbacks;
                        list.add(object);
                    }
                    return;
                }
                catch (Throwable throwable2) {}
            } else {
                String string2 = "callback cannot be null";
                object = new IllegalArgumentException(string2);
                throw object;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clear() {
        synchronized (this) {
            int n10 = this.mNotificationLevel;
            if (n10 == 0) {
                List list = this.mCallbacks;
                list.clear();
            } else {
                List list = this.mCallbacks;
                n10 = (int)(list.isEmpty() ? 1 : 0);
                if (n10 == 0) {
                    list = this.mCallbacks;
                    for (n10 = list.size() + -1; n10 >= 0; n10 += -1) {
                        this.setRemovalBit(n10);
                    }
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CallbackRegistry clone() {
        synchronized (this) {
            Throwable throwable2;
            block10: {
                Object object;
                block9: {
                    CloneNotSupportedException cloneNotSupportedException;
                    block8: {
                        int n10 = 0;
                        cloneNotSupportedException = null;
                        try {
                            long l10;
                            try {
                                object = super.clone();
                                object = (CallbackRegistry)object;
                                l10 = 0L;
                            }
                            catch (CloneNotSupportedException cloneNotSupportedException2) {
                                object = null;
                                cloneNotSupportedException = cloneNotSupportedException2;
                                break block8;
                            }
                            try {
                                ((CallbackRegistry)object).mFirst64Removed = l10;
                                ((CallbackRegistry)object).mRemainderRemoved = null;
                                cloneNotSupportedException = null;
                                ((CallbackRegistry)object).mNotificationLevel = 0;
                                List list = new List();
                                ((CallbackRegistry)object).mCallbacks = list;
                                list = this.mCallbacks;
                                int n11 = list.size();
                                for (n10 = 0; n10 < n11; ++n10) {
                                    boolean bl2 = this.isRemoved(n10);
                                    if (bl2) continue;
                                    List list2 = ((CallbackRegistry)object).mCallbacks;
                                    List list3 = this.mCallbacks;
                                    list3 = list3.get(n10);
                                    list2.add(list3);
                                }
                                break block9;
                            }
                            catch (CloneNotSupportedException cloneNotSupportedException3) {
                            }
                        }
                        catch (Throwable throwable2) {
                            break block10;
                        }
                    }
                    cloneNotSupportedException.printStackTrace();
                }
                return object;
            }
            throw throwable2;
        }
    }

    public ArrayList copyCallbacks() {
        synchronized (this) {
            List list = this.mCallbacks;
            int n10 = list.size();
            ArrayList<List> arrayList = new ArrayList<List>(n10);
            list = this.mCallbacks;
            n10 = list.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                boolean bl2 = this.isRemoved(i10);
                if (bl2) continue;
                List list2 = this.mCallbacks;
                list2 = list2.get(i10);
                arrayList.add(list2);
            }
            return arrayList;
        }
    }

    public void copyCallbacks(List list) {
        synchronized (this) {
            list.clear();
            List list2 = this.mCallbacks;
            int n10 = list2.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                boolean bl2 = this.isRemoved(i10);
                if (bl2) continue;
                List list3 = this.mCallbacks;
                list3 = list3.get(i10);
                list.add(list3);
            }
            return;
        }
    }

    public boolean isEmpty() {
        synchronized (this) {
            boolean bl2;
            int n10;
            List list;
            block10: {
                block9: {
                    list = this.mCallbacks;
                    n10 = list.isEmpty();
                    bl2 = true;
                    if (n10 == 0) break block9;
                    return bl2;
                }
                n10 = this.mNotificationLevel;
                if (n10 != 0) break block10;
                return false;
            }
            list = this.mCallbacks;
            n10 = list.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                boolean bl3 = this.isRemoved(i10);
                if (bl3) continue;
                return false;
            }
            return bl2;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void notifyCallbacks(Object object, int n10, Object object2) {
        synchronized (this) {
            int n11;
            void var3_3;
            void var2_2;
            int n12;
            this.mNotificationLevel = n12 = this.mNotificationLevel + 1;
            this.notifyRecurse(object, (int)var2_2, var3_3);
            this.mNotificationLevel = n11 = this.mNotificationLevel + -1;
            if (n11 == 0) {
                long l10;
                long l11;
                object = this.mRemainderRemoved;
                long l12 = 0L;
                if (object != null) {
                    for (n11 = ((Object)object).length + -1; n11 >= 0; n11 += -1) {
                        long[] lArray = this.mRemainderRemoved;
                        long l13 = lArray[n11];
                        long l14 = l13 - l12;
                        n12 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
                        if (n12 == 0) continue;
                        n12 = (n11 + 1) * 64;
                        this.removeRemovedCallbacks(n12, l13);
                        lArray = this.mRemainderRemoved;
                        lArray[n11] = l12;
                    }
                }
                if ((n11 = (int)((l11 = (l10 = this.mFirst64Removed) - l12) == 0L ? 0 : (l11 < 0L ? -1 : 1))) != 0) {
                    n11 = 0;
                    object = null;
                    this.removeRemovedCallbacks(0, l10);
                    this.mFirst64Removed = l12;
                }
            }
            return;
        }
    }

    public void remove(Object object) {
        synchronized (this) {
            int n10 = this.mNotificationLevel;
            if (n10 == 0) {
                List list = this.mCallbacks;
                list.remove(object);
            } else {
                List list = this.mCallbacks;
                int n11 = list.lastIndexOf(object);
                if (n11 >= 0) {
                    this.setRemovalBit(n11);
                }
            }
            return;
        }
    }
}

