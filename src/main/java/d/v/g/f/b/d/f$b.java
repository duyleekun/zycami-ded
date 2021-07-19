/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b.d;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.device.data.local.entity.FirmwareInfo;
import d.v.g.f.b.d.f;

public class f$b
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ f a;

    public f$b(f f10, RoomDatabase roomDatabase) {
        this.a = f10;
        super(roomDatabase);
    }

    public void a(SupportSQLiteStatement supportSQLiteStatement, FirmwareInfo firmwareInfo) {
        long l10 = firmwareInfo.getId();
        supportSQLiteStatement.bindLong(1, l10);
        int n10 = firmwareInfo.getSerial();
        l10 = n10;
        int n11 = 2;
        supportSQLiteStatement.bindLong(n11, l10);
        String string2 = firmwareInfo.getUnionVer();
        int n12 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = firmwareInfo.getUnionVer();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = firmwareInfo.getVer();
        n12 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = firmwareInfo.getVer();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = firmwareInfo.getReleaseDate();
        n12 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = firmwareInfo.getReleaseDate();
            supportSQLiteStatement.bindString(n12, string2);
        }
        long l11 = (long)firmwareInfo.isForceUpdate();
        supportSQLiteStatement.bindLong(6, l11);
        l11 = (long)firmwareInfo.isNeedUpdate();
        supportSQLiteStatement.bindLong(7, l11);
        n10 = (int)(firmwareInfo.isOtaUpdate() ? 1 : 0);
        l11 = n10;
        supportSQLiteStatement.bindLong(8, l11);
        string2 = firmwareInfo.getNotice();
        n12 = 9;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = firmwareInfo.getNotice();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = firmwareInfo.getReleaseNotes();
        n12 = 10;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = firmwareInfo.getReleaseNotes();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = firmwareInfo.getBeforeUpgradeTip();
        n12 = 11;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = firmwareInfo.getBeforeUpgradeTip();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = firmwareInfo.getAfterUpgradeTip();
        n12 = 12;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = firmwareInfo.getAfterUpgradeTip();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = firmwareInfo.getMd5();
        n12 = 13;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = firmwareInfo.getMd5();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = firmwareInfo.getUrl();
        n12 = 14;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = firmwareInfo.getUrl();
            supportSQLiteStatement.bindString(n12, string2);
        }
        string2 = firmwareInfo.getPath();
        n12 = 15;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n12);
        } else {
            string2 = firmwareInfo.getPath();
            supportSQLiteStatement.bindString(n12, string2);
        }
        long l12 = firmwareInfo.getFilesize();
        supportSQLiteStatement.bindLong(16, l12);
        l12 = firmwareInfo.getHasPopup();
        supportSQLiteStatement.bindLong(17, l12);
        l12 = firmwareInfo.getSerial();
        supportSQLiteStatement.bindLong(18, l12);
    }

    public String createQuery() {
        return "UPDATE OR ABORT `firmware_info` SET `_id` = ?,`serial` = ?,`union_version` = ?,`version` = ?,`release_date` = ?,`force_update` = ?,`need_update` = ?,`ota_update` = ?,`notice` = ?,`release_notes` = ?,`before_update_tip` = ?,`after_update_tip` = ?,`md5` = ?,`url` = ?,`path` = ?,`filesize` = ?,`has_popup` = ? WHERE `serial` = ?";
    }
}

