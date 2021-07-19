/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.AbstractWindowedCursor
 *  android.database.Cursor
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 */
package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.ArrayList;

public class DBUtil {
    private DBUtil() {
    }

    public static CancellationSignal createCancellationSignal() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            return cancellationSignal;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void dropFtsSyncTriggers(SupportSQLiteDatabase supportSQLiteDatabase) {
        CharSequence charSequence;
        boolean bl3;
        Object object = new ArrayList();
        Object object2 = supportSQLiteDatabase.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (bl3 = object2.moveToNext()) {
            bl3 = false;
            charSequence = null;
            charSequence = object2.getString(0);
            object.add(charSequence);
        }
        object = object.iterator();
        while (true) {
            boolean bl2;
            if (!(bl2 = object.hasNext())) {
                return;
            }
            object2 = (String)object.next();
            bl3 = ((String)object2).startsWith((String)(charSequence = "room_fts_content_sync_"));
            if (!bl3) continue;
            charSequence = new StringBuilder();
            String string2 = "DROP TRIGGER IF EXISTS ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append((String)object2);
            object2 = ((StringBuilder)charSequence).toString();
            supportSQLiteDatabase.execSQL((String)object2);
        }
        finally {
            object2.close();
        }
    }

    public static Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean bl2) {
        return DBUtil.query(roomDatabase, supportSQLiteQuery, bl2, null);
    }

    public static Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery object, boolean n10, CancellationSignal cancellationSignal) {
        boolean bl2;
        roomDatabase = roomDatabase.query((SupportSQLiteQuery)object, cancellationSignal);
        if (n10 != 0 && (bl2 = roomDatabase instanceof AbstractWindowedCursor)) {
            object = roomDatabase;
            object = (AbstractWindowedCursor)roomDatabase;
            n10 = object.getCount();
            int n11 = object.hasWindow();
            if (n11 != 0) {
                cancellationSignal = object.getWindow();
                n11 = cancellationSignal.getNumRows();
            } else {
                n11 = n10;
            }
            int n12 = Build.VERSION.SDK_INT;
            int n13 = 23;
            if (n12 < n13 || n11 < n10) {
                roomDatabase = CursorUtil.copyAndClose((Cursor)object);
            }
        }
        return (Cursor)roomDatabase;
    }

    public static int readVersion(File serializable) {
        AbstractInterruptibleChannel abstractInterruptibleChannel;
        block12: {
            int n10 = 4;
            abstractInterruptibleChannel = null;
            ByteBuffer byteBuffer = ByteBuffer.allocate(n10);
            FileInputStream fileInputStream = new FileInputStream((File)serializable);
            abstractInterruptibleChannel = fileInputStream.getChannel();
            long l10 = 60;
            long l11 = 4;
            boolean bl2 = true;
            ((FileChannel)abstractInterruptibleChannel).tryLock(l10, l11, bl2);
            long l12 = 60;
            ((FileChannel)abstractInterruptibleChannel).position(l12);
            int n11 = ((FileChannel)abstractInterruptibleChannel).read(byteBuffer);
            if (n11 != n10) break block12;
            byteBuffer.rewind();
            n11 = byteBuffer.getInt();
            return n11;
        }
        String string2 = "Bad database header, unable to read 4 bytes at offset 60";
        try {
            serializable = new IOException(string2);
            throw serializable;
        }
        finally {
            if (abstractInterruptibleChannel != null) {
                abstractInterruptibleChannel.close();
            }
        }
    }
}

