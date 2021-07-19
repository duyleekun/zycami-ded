/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package d.v.g.f.b.d;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.device.data.local.entity.FirmwareInfo;
import d.v.g.f.b.d.f;
import java.util.concurrent.Callable;

public class f$c
implements Callable {
    public final /* synthetic */ RoomSQLiteQuery a;
    public final /* synthetic */ f b;

    public f$c(f f10, RoomSQLiteQuery roomSQLiteQuery) {
        this.b = f10;
        this.a = roomSQLiteQuery;
    }

    /*
     * WARNING - void declaration
     */
    public FirmwareInfo a() {
        Object object;
        RoomSQLiteQuery roomSQLiteQuery;
        block61: {
            int n10;
            block57: {
                boolean bl2;
                int n11;
                int n12;
                int n13;
                int n14;
                int n15;
                int n16;
                int n17;
                int n19;
                Object object2;
                Object object3;
                block60: {
                    void var8_19;
                    int n18;
                    String string2;
                    block59: {
                        void var8_15;
                        boolean bl3;
                        int n20;
                        block58: {
                            int n21;
                            int n182;
                            object3 = this;
                            object2 = f.g(this.b);
                            roomSQLiteQuery = this.a;
                            n19 = 0;
                            String string3 = null;
                            n10 = 0;
                            object = null;
                            roomSQLiteQuery = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
                            object2 = "_id";
                            try {
                                n182 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
                                string2 = "serial";
                            }
                            catch (Throwable throwable) {
                                roomSQLiteQuery.close();
                                throw throwable;
                            }
                            int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
                            String string4 = "union_version";
                            int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
                            String string5 = "version";
                            int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
                            String string6 = "release_date";
                            int n25 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
                            String string7 = "force_update";
                            int n26 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
                            String string8 = "need_update";
                            n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
                            String string9 = "ota_update";
                            n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
                            String string10 = "notice";
                            n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
                            String string11 = "release_notes";
                            n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
                            String string12 = "before_update_tip";
                            n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string12);
                            String string13 = "after_update_tip";
                            n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string13);
                            string3 = "md5";
                            n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
                            object = "url";
                            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                            object3 = "path";
                            n13 = n21 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                            object3 = "filesize";
                            n12 = n21 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                            object3 = "has_popup";
                            n21 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                            n11 = roomSQLiteQuery.moveToFirst();
                            if (n11 == 0) break block57;
                            n11 = n21;
                            object3 = new FirmwareInfo();
                            int n27 = roomSQLiteQuery.getInt(n182);
                            ((FirmwareInfo)object3).setId(n27);
                            int n28 = roomSQLiteQuery.getInt(n22);
                            ((FirmwareInfo)object3).setSerial(n28);
                            object2 = roomSQLiteQuery.getString(n23);
                            ((FirmwareInfo)object3).setUnionVer((String)object2);
                            object2 = roomSQLiteQuery.getString(n24);
                            ((FirmwareInfo)object3).setVer((String)object2);
                            object2 = roomSQLiteQuery.getString(n25);
                            ((FirmwareInfo)object3).setReleaseDate((String)object2);
                            int n29 = roomSQLiteQuery.getInt(n26);
                            bl3 = true;
                            if (n29 != 0) {
                                boolean bl4 = bl3;
                                break block58;
                            }
                            boolean bl5 = false;
                            object2 = null;
                        }
                        ((FirmwareInfo)object3).setForceUpdate((boolean)var8_15);
                        int n30 = roomSQLiteQuery.getInt(n20);
                        if (n30 != 0) {
                            boolean bl6 = bl3;
                            break block59;
                        }
                        boolean bl7 = false;
                        object2 = null;
                    }
                    ((FirmwareInfo)object3).setNeedUpdate((boolean)var8_19);
                    int n31 = roomSQLiteQuery.getInt(n18);
                    if (n31 != 0) break block60;
                    bl2 = false;
                    string2 = null;
                }
                ((FirmwareInfo)object3).setOtaUpdate(bl2);
                object2 = roomSQLiteQuery.getString(n17);
                ((FirmwareInfo)object3).setNotice((String)object2);
                object2 = roomSQLiteQuery.getString(n16);
                ((FirmwareInfo)object3).setReleaseNotes((String)object2);
                object2 = roomSQLiteQuery.getString(n15);
                ((FirmwareInfo)object3).setBeforeUpgradeTip((String)object2);
                object2 = roomSQLiteQuery.getString(n14);
                ((FirmwareInfo)object3).setAfterUpgradeTip((String)object2);
                object2 = roomSQLiteQuery.getString(n19);
                ((FirmwareInfo)object3).setMd5((String)object2);
                object2 = roomSQLiteQuery.getString(n10);
                ((FirmwareInfo)object3).setUrl((String)object2);
                int n32 = n13;
                object2 = roomSQLiteQuery.getString(n13);
                ((FirmwareInfo)object3).setPath((String)object2);
                int n33 = n12;
                long l10 = roomSQLiteQuery.getLong(n12);
                ((FirmwareInfo)object3).setFilesize(l10);
                int n35 = n11;
                n35 = roomSQLiteQuery.getInt(n11);
                ((FirmwareInfo)object3).setHasPopup(n35);
                object = object3;
                break block61;
            }
            n10 = 0;
            object = null;
        }
        roomSQLiteQuery.close();
        return object;
    }

    public void finalize() {
        this.a.release();
    }
}

