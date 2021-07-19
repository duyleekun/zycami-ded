/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b.d;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.device.data.local.entity.ActivationData;
import d.v.g.f.b.d.b;

public class b$a
extends EntityInsertionAdapter {
    public final /* synthetic */ b a;

    public b$a(b b10, RoomDatabase roomDatabase) {
        this.a = b10;
        super(roomDatabase);
    }

    public void a(SupportSQLiteStatement supportSQLiteStatement, ActivationData object) {
        long l10 = ((ActivationData)object).getId();
        supportSQLiteStatement.bindLong(1, l10);
        int n10 = ((ActivationData)object).getUserId();
        l10 = n10;
        int n11 = 2;
        supportSQLiteStatement.bindLong(n11, l10);
        String string2 = ((ActivationData)object).getAccount();
        int n12 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((ActivationData)object).getAccount();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((ActivationData)object).getSerialNum();
        n12 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((ActivationData)object).getSerialNum();
            supportSQLiteStatement.bindString(n12, string2);
        }
        n10 = 5;
        long l11 = ((ActivationData)object).getDeviceModel();
        supportSQLiteStatement.bindLong(n10, l11);
        string2 = ((ActivationData)object).getDeviceName();
        n12 = 6;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((ActivationData)object).getDeviceName();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((ActivationData)object).getAppVersion();
        n12 = 7;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((ActivationData)object).getAppVersion();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((ActivationData)object).getLongitude();
        n12 = 8;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((ActivationData)object).getLongitude();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((ActivationData)object).getLatitude();
        n12 = 9;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((ActivationData)object).getLatitude();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((ActivationData)object).getActiveCode();
        n12 = 10;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((ActivationData)object).getActiveCode();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((ActivationData)object).getActiveAt();
        n12 = 11;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((ActivationData)object).getActiveAt();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = ((ActivationData)object).getActiveStatus();
        n12 = 12;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = ((ActivationData)object).getActiveStatus();
            supportSQLiteStatement.bindString(n12, string2);
        }
        n10 = (int)(((ActivationData)object).isVisitor() ? 1 : 0);
        long l12 = n10;
        supportSQLiteStatement.bindLong(13, l12);
        string2 = ((ActivationData)object).getEx();
        n12 = 14;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            object = ((ActivationData)object).getEx();
            supportSQLiteStatement.bindString(n12, (String)object);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `activation_data` (`id`,`userId`,`account`,`serialNum`,`deviceModel`,`deviceName`,`appVersion`,`longitude`,`latitude`,`activeCode`,`activeAt`,`activeStatus`,`isVisitor`,`ex`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}

