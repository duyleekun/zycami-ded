/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase$Builder;

public class Room {
    private static final String CURSOR_CONV_SUFFIX = "_CursorConverter";
    public static final String LOG_TAG = "ROOM";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    public static RoomDatabase$Builder databaseBuilder(Context object, Class clazz, String string2) {
        Object object2;
        int n10;
        if (string2 != null && (n10 = ((String)(object2 = string2.trim())).length()) != 0) {
            object2 = new RoomDatabase$Builder((Context)object, clazz, string2);
            return object2;
        }
        object = new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        throw object;
    }

    public static Object getGeneratedImplementation(Class object, String object2) {
        int n10;
        Object object3;
        Object object4;
        block14: {
            block13: {
                object4 = ((Class)object).getPackage().getName();
                object3 = ((Class)object).getCanonicalName();
                boolean n11 = ((String)object4).isEmpty();
                n10 = 1;
                if (!n11) {
                    int n12 = ((String)object4).length() + n10;
                    object3 = ((String)object3).substring(n12);
                }
                StringBuilder stringBuilder = new StringBuilder();
                char c10 = '.';
                char c11 = '_';
                object3 = ((String)object3).replace(c10, c11);
                stringBuilder.append((String)object3);
                stringBuilder.append((String)object2);
                object2 = stringBuilder.toString();
                boolean bl2 = ((String)object4).isEmpty();
                if (!bl2) break block13;
                object4 = object2;
                break block14;
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object4);
            object4 = ".";
            ((StringBuilder)object3).append((String)object4);
            ((StringBuilder)object3).append((String)object2);
            object4 = ((StringBuilder)object3).toString();
        }
        object3 = ((Class)object).getClassLoader();
        object4 = Class.forName((String)object4, n10 != 0, (ClassLoader)object3);
        try {
            return ((Class)object4).newInstance();
        }
        catch (InstantiationException instantiationException) {
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("Failed to create an instance of ");
            object = ((Class)object).getCanonicalName();
            ((StringBuilder)object4).append((String)object);
            object = ((StringBuilder)object4).toString();
            object2 = new RuntimeException((String)object);
            throw object2;
        }
        catch (IllegalAccessException illegalAccessException) {
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("Cannot access the constructor");
            object = ((Class)object).getCanonicalName();
            ((StringBuilder)object4).append((String)object);
            object = ((StringBuilder)object4).toString();
            object2 = new RuntimeException((String)object);
            throw object2;
        }
        catch (ClassNotFoundException classNotFoundException) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("cannot find implementation for ");
            object = ((Class)object).getCanonicalName();
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append(". ");
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(" does not exist");
            object = ((StringBuilder)object3).toString();
            object4 = new RuntimeException((String)object);
            throw object4;
        }
    }

    public static RoomDatabase$Builder inMemoryDatabaseBuilder(Context context, Class clazz) {
        RoomDatabase$Builder roomDatabase$Builder = new RoomDatabase$Builder(context, clazz, null);
        return roomDatabase$Builder;
    }
}

