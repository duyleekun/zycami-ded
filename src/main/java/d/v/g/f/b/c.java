/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.g.f.b;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase$Builder;
import androidx.room.migration.Migration;
import com.zhiyun.device.data.local.DeviceDatabaseComm;
import d.v.e.f;
import d.v.g.f.b.a;
import d.v.g.f.b.c$a;
import java.io.File;

public class c {
    private static final String b = "device.db";
    private DeviceDatabaseComm a;

    public static c b() {
        return c$a.a();
    }

    public DeviceDatabaseComm a() {
        Object object = this.a;
        if (object == null) {
            object = f.a().b();
            Migration[] migrationArray = object.getDatabasePath("zycama.db");
            Object object2 = new Object[1];
            boolean bl2 = migrationArray.exists();
            Boolean bl3 = bl2;
            object2[0] = bl3;
            m.a.a.i("zycama.db\u662f\u5426\u5b58\u5728 %s", object2);
            object2 = DeviceDatabaseComm.class;
            String string2 = b;
            object = Room.databaseBuilder((Context)object, (Class)object2, string2);
            boolean bl4 = migrationArray.exists();
            if (bl4) {
                ((RoomDatabase$Builder)object).createFromFile((File)migrationArray);
            }
            migrationArray = d.v.g.f.b.a.k;
            this.a = object = (DeviceDatabaseComm)((RoomDatabase$Builder)object).addMigrations(migrationArray).allowMainThreadQueries().build();
        }
        return this.a;
    }
}

