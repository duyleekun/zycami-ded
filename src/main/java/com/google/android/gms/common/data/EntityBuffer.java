/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.data;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class EntityBuffer
extends AbstractDataBuffer {
    private boolean zame = false;
    private ArrayList zamf;

    public EntityBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void zacb() {
        synchronized (this) {
            int n10 = this.zame;
            if (n10 == 0) {
                Object object = this.mDataHolder;
                n10 = ((DataHolder)object).getCount();
                Object object2 = new ArrayList();
                this.zamf = object2;
                int n11 = 1;
                if (n10 > 0) {
                    Object object3 = null;
                    Object object4 = 0;
                    ((ArrayList)object2).add(object4);
                    object2 = this.getPrimaryDataMarkerColumn();
                    object4 = this.mDataHolder;
                    int n12 = ((DataHolder)object4).getWindowIndex(0);
                    Object object5 = this.mDataHolder;
                    object3 = ((DataHolder)object5).getString((String)object2, 0, n12);
                    for (n12 = (int)n11; n12 < n10; ++n12) {
                        object5 = this.mDataHolder;
                        int n13 = ((DataHolder)object5).getWindowIndex(n12);
                        Object object6 = this.mDataHolder;
                        if ((object6 = ((DataHolder)object6).getString((String)object2, n12, n13)) == null) {
                            String string2 = String.valueOf(object2);
                            n11 = string2.length() + 78;
                            object3 = new StringBuilder(n11);
                            string2 = "Missing value for markerColumn: ";
                            ((StringBuilder)object3).append(string2);
                            ((StringBuilder)object3).append((String)object2);
                            object2 = ", at row: ";
                            ((StringBuilder)object3).append((String)object2);
                            ((StringBuilder)object3).append(n12);
                            object2 = ", for window: ";
                            ((StringBuilder)object3).append((String)object2);
                            ((StringBuilder)object3).append(n13);
                            object2 = ((StringBuilder)object3).toString();
                            object = new NullPointerException((String)object2);
                            throw object;
                        }
                        n13 = (int)(((String)object6).equals(object3) ? 1 : 0);
                        if (n13 != 0) continue;
                        object3 = this.zamf;
                        object5 = n12;
                        ((ArrayList)object3).add(object5);
                        object3 = object6;
                    }
                }
                this.zame = n11;
            }
            return;
        }
    }

    private final int zah(int n10) {
        Serializable serializable;
        int n11;
        if (n10 >= 0 && n10 < (n11 = ((ArrayList)(serializable = this.zamf)).size())) {
            return (Integer)this.zamf.get(n10);
        }
        StringBuilder stringBuilder = new StringBuilder(53);
        stringBuilder.append("Position ");
        stringBuilder.append(n10);
        stringBuilder.append(" is out of bounds for this buffer");
        String string2 = stringBuilder.toString();
        serializable = new IllegalArgumentException(string2);
        throw serializable;
    }

    public final Object get(int n10) {
        int n11;
        int n12;
        block5: {
            int n13;
            block6: {
                DataHolder dataHolder;
                String string2;
                int n14;
                Object object;
                Object object2;
                this.zacb();
                n12 = this.zah(n10);
                n11 = 0;
                if (n10 < 0 || n10 == (n13 = ((ArrayList)(object2 = this.zamf)).size())) break block5;
                object2 = this.zamf;
                n13 = ((ArrayList)object2).size();
                int n15 = 1;
                if (n10 == (n13 -= n15)) {
                    object2 = this.mDataHolder;
                    n13 = ((DataHolder)object2).getCount();
                    object = (Integer)this.zamf.get(n10);
                    n14 = (Integer)object;
                } else {
                    object2 = this.zamf;
                    n14 = n10 + 1;
                    object2 = (Integer)((ArrayList)object2).get(n14);
                    n13 = (Integer)object2;
                    object = (Integer)this.zamf.get(n10);
                    n14 = (Integer)object;
                }
                if ((n13 -= n14) != n15) break block6;
                n10 = this.zah(n10);
                DataHolder dataHolder2 = this.mDataHolder;
                n15 = dataHolder2.getWindowIndex(n10);
                object = this.getChildDataMarkerColumn();
                if (object != null && (string2 = (dataHolder = this.mDataHolder).getString((String)object, n10, n15)) == null) break block5;
            }
            n11 = n13;
        }
        return this.getEntry(n12, n11);
    }

    public String getChildDataMarkerColumn() {
        return null;
    }

    public int getCount() {
        this.zacb();
        return this.zamf.size();
    }

    public abstract Object getEntry(int var1, int var2);

    public abstract String getPrimaryDataMarkerColumn();
}

