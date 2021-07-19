/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.room;

import android.util.Log;
import androidx.room.migration.Migration;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class RoomDatabase$MigrationContainer {
    private HashMap mMigrations;

    public RoomDatabase$MigrationContainer() {
        HashMap hashMap;
        this.mMigrations = hashMap = new HashMap();
    }

    private void addMigration(Migration migration) {
        Object object;
        int n10 = migration.startVersion;
        int n11 = migration.endVersion;
        AbstractMap abstractMap = this.mMigrations;
        Object object2 = n10;
        if ((abstractMap = (TreeMap)((HashMap)abstractMap).get(object2)) == null) {
            abstractMap = new TreeMap();
            object2 = this.mMigrations;
            object = n10;
            ((HashMap)object2).put(object, abstractMap);
        }
        object = n11;
        if ((object = (Migration)((TreeMap)abstractMap).get(object)) != null) {
            object2 = new StringBuilder();
            String string2 = "Overriding migration ";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append(" with ");
            ((StringBuilder)object2).append(migration);
            object = ((StringBuilder)object2).toString();
            object2 = "ROOM";
            Log.w((String)object2, (String)object);
        }
        object = n11;
        ((TreeMap)abstractMap).put(object, migration);
    }

    /*
     * Enabled aggressive block sorting
     */
    private List findUpMigrationPath(List list, boolean bl2, int n10, int n11) {
        boolean bl3;
        do {
            int n12;
            boolean bl4;
            if (bl2) {
                if (n10 >= n11) return list;
            } else if (n10 <= n11) return list;
            AbstractMap abstractMap = this.mMigrations;
            Integer n13 = n10;
            abstractMap = (TreeMap)((HashMap)abstractMap).get(n13);
            n13 = null;
            if (abstractMap == null) {
                return null;
            }
            Set set = bl2 ? ((TreeMap)abstractMap).descendingKeySet() : ((TreeMap)abstractMap).keySet();
            set = set.iterator();
            do {
                n12 = set.hasNext();
                bl3 = true;
                bl4 = false;
                if (n12 == 0) return null;
                Integer n14 = (Integer)set.next();
                n12 = n14;
                if (!(bl2 ? n12 <= n11 && n12 > n10 : n12 >= n11 && n12 < n10)) continue;
                bl4 = bl3;
            } while (!bl4);
            Object object = n12;
            object = (Migration)((TreeMap)abstractMap).get(object);
            list.add(object);
            n10 = n12;
        } while (bl3);
        return null;
    }

    public void addMigrations(Migration ... migrationArray) {
        for (Migration migration : migrationArray) {
            this.addMigration(migration);
        }
    }

    public List findMigrationPath(int n10, int n11) {
        if (n10 == n11) {
            return Collections.emptyList();
        }
        boolean bl2 = n11 > n10;
        ArrayList arrayList = new ArrayList();
        return this.findUpMigrationPath(arrayList, bl2, n10, n11);
    }
}

