/*
 * Decompiled with CFR 0.151.
 */
package androidx.room.util;

import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class FtsTableInfo {
    private static final String[] FTS_OPTIONS = new String[]{"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    public final Set columns;
    public final String name;
    public final Set options;

    public FtsTableInfo(String object, Set set, String string2) {
        this.name = object;
        this.columns = set;
        this.options = object = FtsTableInfo.parseOptions(string2);
    }

    public FtsTableInfo(String string2, Set set, Set set2) {
        this.name = string2;
        this.columns = set;
        this.options = set2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Set parseOptions(String hashSet) {
        Object object;
        Character c10;
        int n10;
        int n11;
        int n12;
        int n13 = ((String)((Object)hashSet)).isEmpty();
        if (n13 != 0) {
            return new HashSet<Object>();
        }
        n13 = ((String)((Object)hashSet)).indexOf(40) + 1;
        int n14 = ((String)((Object)hashSet)).lastIndexOf(41);
        hashSet = ((String)((Object)hashSet)).substring(n13, n14);
        Object object2 = new ArrayList();
        Object object3 = new ArrayDeque();
        int n15 = -1;
        for (n12 = 0; n12 < (n11 = ((String)((Object)hashSet)).length()); ++n12) {
            block13: {
                n11 = ((String)((Object)hashSet)).charAt(n12);
                if (n11 != (n10 = 34) && n11 != (n10 = 39)) {
                    n10 = 44;
                    if (n11 != n10) {
                        n10 = 91;
                        if (n11 != n10) {
                            int n16 = 93;
                            if (n11 != n16) {
                                n10 = 96;
                                if (n11 != n10) {
                                    continue;
                                }
                                break block13;
                            } else {
                                n11 = (int)(((ArrayDeque)object3).isEmpty() ? 1 : 0);
                                if (n11 != 0 || (n11 = (int)(c10 = (Character)((ArrayDeque)object3).peek()).charValue()) != n10) continue;
                                ((ArrayDeque)object3).pop();
                                continue;
                            }
                        }
                        n10 = (int)(((ArrayDeque)object3).isEmpty() ? 1 : 0);
                        if (n10 == 0) continue;
                        c10 = Character.valueOf((char)n11);
                        ((ArrayDeque)object3).push(c10);
                        continue;
                    }
                    n11 = (int)(((ArrayDeque)object3).isEmpty() ? 1 : 0);
                    if (n11 == 0) continue;
                    String string2 = ((String)((Object)hashSet)).substring(++n15, n12).trim();
                    object2.add(string2);
                    n15 = n12;
                    continue;
                }
            }
            if ((n10 = (int)(((ArrayDeque)object3).isEmpty() ? 1 : 0)) != 0) {
                c10 = Character.valueOf((char)n11);
                ((ArrayDeque)object3).push(c10);
                continue;
            }
            object = (Character)((ArrayDeque)object3).peek();
            n10 = ((Character)object).charValue();
            if (n10 != n11) continue;
            ((ArrayDeque)object3).pop();
        }
        hashSet = ((String)((Object)hashSet)).substring(++n15).trim();
        object2.add(hashSet);
        hashSet = new HashSet<Object>();
        object2 = object2.iterator();
        block1: while ((n14 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
            object3 = (String)object2.next();
            String[] stringArray = FTS_OPTIONS;
            n12 = stringArray.length;
            n11 = 0;
            c10 = null;
            while (true) {
                if (n11 >= n12) continue block1;
                object = stringArray[n11];
                n10 = (int)(((String)object3).startsWith((String)object) ? 1 : 0);
                if (n10 != 0) {
                    hashSet.add(object3);
                }
                ++n11;
            }
            break;
        }
        return hashSet;
    }

    public static FtsTableInfo read(SupportSQLiteDatabase object, String string2) {
        Set set = FtsTableInfo.readColumns((SupportSQLiteDatabase)object, string2);
        object = FtsTableInfo.readOptions((SupportSQLiteDatabase)object, string2);
        FtsTableInfo ftsTableInfo = new FtsTableInfo(string2, set, (Set)object);
        return ftsTableInfo;
    }

    private static Set readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String hashSet) {
        block7: {
            CharSequence charSequence = new StringBuilder();
            String string2 = "PRAGMA table_info(`";
            charSequence.append(string2);
            charSequence.append((String)((Object)hashSet));
            charSequence.append("`)");
            hashSet = charSequence.toString();
            supportSQLiteDatabase = supportSQLiteDatabase.query((String)((Object)hashSet));
            hashSet = new HashSet<String>();
            int n10 = supportSQLiteDatabase.getColumnCount();
            if (n10 <= 0) break block7;
            charSequence = "name";
            try {
                n10 = supportSQLiteDatabase.getColumnIndex((String)charSequence);
            }
            catch (Throwable throwable) {
                supportSQLiteDatabase.close();
                throw throwable;
            }
            while (true) {
                boolean bl2 = supportSQLiteDatabase.moveToNext();
                if (!bl2) break;
                string2 = supportSQLiteDatabase.getString(n10);
                hashSet.add(string2);
                continue;
                break;
            }
        }
        supportSQLiteDatabase.close();
        return hashSet;
    }

    private static Set readOptions(SupportSQLiteDatabase supportSQLiteDatabase, String string2) {
        block5: {
            block4: {
                int n10;
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "SELECT * FROM sqlite_master WHERE `name` = '";
                stringBuilder.append(string3);
                stringBuilder.append(string2);
                stringBuilder.append("'");
                string2 = stringBuilder.toString();
                supportSQLiteDatabase = supportSQLiteDatabase.query(string2);
                try {
                    n10 = supportSQLiteDatabase.moveToFirst();
                    if (n10 == 0) break block4;
                    string2 = "sql";
                }
                catch (Throwable throwable) {
                    supportSQLiteDatabase.close();
                    throw throwable;
                }
                n10 = supportSQLiteDatabase.getColumnIndexOrThrow(string2);
                string2 = supportSQLiteDatabase.getString(n10);
                break block5;
            }
            string2 = "";
        }
        supportSQLiteDatabase.close();
        return FtsTableInfo.parseOptions(string2);
    }

    public boolean equals(Object object) {
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof FtsTableInfo;
        if (!bl3) {
            return false;
        }
        object = (FtsTableInfo)object;
        Object object3 = this.name;
        if (object3 != null ? !(bl3 = ((String)object3).equals(object2 = ((FtsTableInfo)object).name)) : (object3 = ((FtsTableInfo)object).name) != null) {
            return false;
        }
        object3 = this.columns;
        if (object3 != null ? !(bl3 = object3.equals(object2 = ((FtsTableInfo)object).columns)) : (object3 = ((FtsTableInfo)object).columns) != null) {
            return false;
        }
        object3 = this.options;
        object = ((FtsTableInfo)object).options;
        if (object3 != null) {
            bl2 = object3.equals(object);
        } else if (object != null) {
            bl2 = false;
        }
        return bl2;
    }

    public int hashCode() {
        int n10;
        int n11;
        String string2 = this.name;
        int n12 = 0;
        if (string2 != null) {
            n11 = string2.hashCode();
        } else {
            n11 = 0;
            string2 = null;
        }
        n11 *= 31;
        Set set = this.columns;
        if (set != null) {
            n10 = set.hashCode();
        } else {
            n10 = 0;
            set = null;
        }
        n11 = (n11 + n10) * 31;
        set = this.options;
        if (set != null) {
            n12 = set.hashCode();
        }
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FtsTableInfo{name='");
        Object object = this.name;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append(", columns=");
        object = this.columns;
        stringBuilder.append(object);
        stringBuilder.append(", options=");
        object = this.options;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

