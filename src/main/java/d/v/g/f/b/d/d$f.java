/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b.d;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import d.v.g.f.b.d.d;

public class d$f
extends SharedSQLiteStatement {
    public final /* synthetic */ d a;

    public d$f(d d10, RoomDatabase roomDatabase) {
        this.a = d10;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM device_info";
    }
}

