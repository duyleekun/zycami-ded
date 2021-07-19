/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.CursorUtil;
import com.zhiyun.cama.data.database.dao.WorksDao_Impl$10;
import com.zhiyun.cama.data.database.model.Appeal;
import com.zhiyun.cama.data.database.model.Approval;
import com.zhiyun.cama.data.database.model.Works;
import java.util.ArrayList;
import java.util.List;

public class WorksDao_Impl$10$1
extends LimitOffsetDataSource {
    public final /* synthetic */ WorksDao_Impl$10 this$1;

    public WorksDao_Impl$10$1(WorksDao_Impl$10 worksDao_Impl$10, RoomDatabase roomDatabase, RoomSQLiteQuery roomSQLiteQuery, boolean bl2, boolean bl3, String ... stringArray) {
        this.this$1 = worksDao_Impl$10;
        super(roomDatabase, roomSQLiteQuery, bl2, bl3, stringArray);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public List convertRows(Cursor cursor) {
        int n10;
        Cursor cursor2 = cursor;
        Object object = "id";
        int n11 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
        Object object2 = "sourceUrls";
        int n12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
        String string2 = "des";
        int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
        String string3 = "commentCnt";
        int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
        String string4 = "likeCnt";
        int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
        String string5 = "shareCnt";
        int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
        String string6 = "publishAt";
        int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
        String string7 = "duration";
        int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
        String string8 = "thumbwh";
        int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
        String string9 = "pv";
        int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
        String string10 = "address";
        int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
        String string11 = "status";
        int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
        String string12 = "isChoice";
        int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
        String string13 = "userId";
        int n24 = CursorUtil.getColumnIndexOrThrow(cursor, string13);
        int n25 = CursorUtil.getColumnIndexOrThrow(cursor, "avatar");
        int n26 = CursorUtil.getColumnIndexOrThrow(cursor, "verified");
        int n27 = CursorUtil.getColumnIndexOrThrow(cursor, "nickname");
        int n28 = CursorUtil.getColumnIndexOrThrow(cursor, "country");
        int n29 = CursorUtil.getColumnIndexOrThrow(cursor, "city");
        int n30 = CursorUtil.getColumnIndexOrThrow(cursor, "tags");
        int n31 = CursorUtil.getColumnIndexOrThrow(cursor, "deviceTags");
        int n32 = CursorUtil.getColumnIndexOrThrow(cursor, "approval_id");
        int n33 = CursorUtil.getColumnIndexOrThrow(cursor, "approval_degree");
        int n34 = CursorUtil.getColumnIndexOrThrow(cursor, "approval_createAt");
        int n35 = CursorUtil.getColumnIndexOrThrow(cursor, "approval_refuse_reason");
        int n36 = CursorUtil.getColumnIndexOrThrow(cursor, "approval_classify");
        int n37 = CursorUtil.getColumnIndexOrThrow(cursor, "approval_circle_name");
        int n38 = CursorUtil.getColumnIndexOrThrow(cursor, "approval_modify");
        int n39 = CursorUtil.getColumnIndexOrThrow(cursor, "approval_comment");
        int n40 = CursorUtil.getColumnIndexOrThrow(cursor, "appeal_id");
        int n41 = CursorUtil.getColumnIndexOrThrow(cursor, "appeal_approval_id");
        int n42 = CursorUtil.getColumnIndexOrThrow(cursor, "appeal_appeal_reason");
        int n43 = CursorUtil.getColumnIndexOrThrow(cursor, "appeal_punish_id");
        int n44 = CursorUtil.getColumnIndexOrThrow(cursor, "appeal_classify");
        int n45 = CursorUtil.getColumnIndexOrThrow(cursor, "appeal_status");
        int n46 = CursorUtil.getColumnIndexOrThrow(cursor, "appeal_sourceUrls");
        int n47 = CursorUtil.getColumnIndexOrThrow(cursor, "appeal_createAt");
        int n48 = CursorUtil.getColumnIndexOrThrow(cursor, "appeal_refuse_reason");
        int n49 = n10 = CursorUtil.getColumnIndexOrThrow(cursor, "appeal_comment");
        int n50 = n24;
        n24 = cursor.getCount();
        ArrayList<Object> arrayList = new ArrayList<Object>(n24);
        while (true) {
            int n51;
            String string14;
            String string15;
            String string16;
            String string17;
            String string18;
            String string19;
            String string20;
            int n52;
            String string21;
            String string22;
            String string23;
            String string24;
            String string25;
            String string26;
            String string27;
            String string28;
            String string29;
            String string30;
            String string31;
            String string32;
            String string33;
            Object object3;
            long l10;
            block43: {
                void var91_108;
                void var90_101;
                void var89_94;
                String string34;
                Object object4;
                int n53;
                int n54;
                int n55;
                block44: {
                    block42: {
                        block41: {
                            block40: {
                                block39: {
                                    block38: {
                                        block37: {
                                            block36: {
                                                block35: {
                                                    block34: {
                                                        block33: {
                                                            void var91_105;
                                                            void var90_98;
                                                            void var89_91;
                                                            String string35;
                                                            String string36;
                                                            Object object5;
                                                            String string37;
                                                            block32: {
                                                                block31: {
                                                                    block30: {
                                                                        block29: {
                                                                            block28: {
                                                                                block27: {
                                                                                    block26: {
                                                                                        block25: {
                                                                                            String string38;
                                                                                            if ((n24 = (int)(cursor.moveToNext() ? 1 : 0)) == 0) {
                                                                                                return arrayList;
                                                                                            }
                                                                                            l10 = cursor2.getLong(n11);
                                                                                            n24 = (int)(cursor2.isNull(n12) ? 1 : 0);
                                                                                            object3 = null;
                                                                                            string33 = n24 != 0 ? null : (string13 = cursor2.getString(n12));
                                                                                            n24 = (int)(cursor2.isNull(n13) ? 1 : 0);
                                                                                            string32 = n24 != 0 ? null : (string13 = cursor2.getString(n13));
                                                                                            n24 = (int)(cursor2.isNull(n14) ? 1 : 0);
                                                                                            string31 = n24 != 0 ? null : (string13 = cursor2.getString(n14));
                                                                                            n24 = (int)(cursor2.isNull(n15) ? 1 : 0);
                                                                                            string30 = n24 != 0 ? null : (string13 = cursor2.getString(n15));
                                                                                            n24 = (int)(cursor2.isNull(n16) ? 1 : 0);
                                                                                            string29 = n24 != 0 ? null : (string13 = cursor2.getString(n16));
                                                                                            n24 = (int)(cursor2.isNull(n17) ? 1 : 0);
                                                                                            string28 = n24 != 0 ? null : (string13 = cursor2.getString(n17));
                                                                                            n24 = (int)(cursor2.isNull(n18) ? 1 : 0);
                                                                                            string27 = n24 != 0 ? null : (string13 = cursor2.getString(n18));
                                                                                            n24 = (int)(cursor2.isNull(n19) ? 1 : 0);
                                                                                            string26 = n24 != 0 ? null : (string13 = cursor2.getString(n19));
                                                                                            n24 = (int)(cursor2.isNull(n20) ? 1 : 0);
                                                                                            string25 = n24 != 0 ? null : (string13 = cursor2.getString(n20));
                                                                                            n24 = (int)(cursor2.isNull(n21) ? 1 : 0);
                                                                                            string24 = n24 != 0 ? null : (string13 = cursor2.getString(n21));
                                                                                            n24 = (int)(cursor2.isNull(n22) ? 1 : 0);
                                                                                            string23 = n24 != 0 ? null : (string13 = cursor2.getString(n22));
                                                                                            n24 = (int)(cursor2.isNull(n23) ? 1 : 0);
                                                                                            if (n24 != 0) {
                                                                                                n24 = n50;
                                                                                                string22 = null;
                                                                                            } else {
                                                                                                string22 = string13 = cursor2.getString(n23);
                                                                                                n24 = n50;
                                                                                            }
                                                                                            n50 = (int)(cursor2.isNull(n24) ? 1 : 0);
                                                                                            string21 = n50 != 0 ? null : (string38 = cursor2.getString(n24));
                                                                                            n52 = n25;
                                                                                            n25 = n11;
                                                                                            n11 = n52;
                                                                                            n50 = (int)(cursor2.isNull(n52) ? 1 : 0);
                                                                                            string20 = n50 != 0 ? null : (string38 = cursor2.getString(n52));
                                                                                            n52 = n26;
                                                                                            n26 = n11;
                                                                                            n11 = n52;
                                                                                            n50 = (int)(cursor2.isNull(n52) ? 1 : 0);
                                                                                            string19 = n50 != 0 ? null : (string38 = cursor2.getString(n52));
                                                                                            n52 = n27;
                                                                                            n27 = n11;
                                                                                            n11 = n52;
                                                                                            n50 = (int)(cursor2.isNull(n52) ? 1 : 0);
                                                                                            string18 = n50 != 0 ? null : (string38 = cursor2.getString(n52));
                                                                                            n52 = n28;
                                                                                            n28 = n11;
                                                                                            n11 = n52;
                                                                                            n50 = (int)(cursor2.isNull(n52) ? 1 : 0);
                                                                                            string17 = n50 != 0 ? null : (string38 = cursor2.getString(n52));
                                                                                            n52 = n29;
                                                                                            n29 = n11;
                                                                                            n11 = n52;
                                                                                            n50 = (int)(cursor2.isNull(n52) ? 1 : 0);
                                                                                            string16 = n50 != 0 ? null : (string38 = cursor2.getString(n52));
                                                                                            n52 = n30;
                                                                                            n30 = n11;
                                                                                            n11 = n52;
                                                                                            n50 = (int)(cursor2.isNull(n52) ? 1 : 0);
                                                                                            string15 = n50 != 0 ? null : (string38 = cursor2.getString(n52));
                                                                                            n52 = n31;
                                                                                            n31 = n11;
                                                                                            n11 = n52;
                                                                                            n50 = (int)(cursor2.isNull(n52) ? 1 : 0);
                                                                                            string14 = n50 != 0 ? null : (string38 = cursor2.getString(n52));
                                                                                            n52 = n32;
                                                                                            n32 = n11;
                                                                                            n11 = n52;
                                                                                            n50 = (int)(cursor2.isNull(n52) ? 1 : 0);
                                                                                            if (n50 == 0) break block25;
                                                                                            n50 = n12;
                                                                                            n12 = n33;
                                                                                            if ((n33 = (int)(cursor2.isNull(n33) ? 1 : 0)) == 0) break block26;
                                                                                            n33 = n13;
                                                                                            n13 = n34;
                                                                                            if ((n34 = (int)(cursor2.isNull(n34) ? 1 : 0)) == 0) break block27;
                                                                                            n34 = n14;
                                                                                            n14 = n35;
                                                                                            if ((n35 = (int)(cursor2.isNull(n35) ? 1 : 0)) == 0) break block28;
                                                                                            n35 = n15;
                                                                                            n15 = n36;
                                                                                            if ((n36 = (int)(cursor2.isNull(n36) ? 1 : 0)) == 0) break block29;
                                                                                            n36 = n16;
                                                                                            n16 = n37;
                                                                                            if ((n37 = (int)(cursor2.isNull(n37) ? 1 : 0)) == 0) break block30;
                                                                                            n37 = n17;
                                                                                            n17 = n38;
                                                                                            if ((n38 = (int)(cursor2.isNull(n38) ? 1 : 0)) == 0) break block31;
                                                                                            n38 = n18;
                                                                                            n18 = n39;
                                                                                            if ((n39 = (int)(cursor2.isNull(n39) ? 1 : 0)) == 0) break block32;
                                                                                            n51 = n52;
                                                                                            n39 = n12;
                                                                                            n12 = n40;
                                                                                            n11 = 0;
                                                                                            object = null;
                                                                                            break block33;
                                                                                        }
                                                                                        n50 = n12;
                                                                                        n12 = n33;
                                                                                    }
                                                                                    n33 = n13;
                                                                                    n13 = n34;
                                                                                }
                                                                                n34 = n14;
                                                                                n14 = n35;
                                                                            }
                                                                            n35 = n15;
                                                                            n15 = n36;
                                                                        }
                                                                        n36 = n16;
                                                                        n16 = n37;
                                                                    }
                                                                    n37 = n17;
                                                                    n17 = n38;
                                                                }
                                                                n38 = n18;
                                                                n18 = n39;
                                                            }
                                                            int n56 = cursor2.getInt(n11);
                                                            n39 = (int)(cursor2.isNull(n12) ? 1 : 0);
                                                            if (n39 != 0) {
                                                                n55 = 0;
                                                                string37 = null;
                                                            } else {
                                                                object5 = cursor2.getString(n12);
                                                                string37 = object5;
                                                            }
                                                            n39 = (int)(cursor2.isNull(n13) ? 1 : 0);
                                                            if (n39 != 0) {
                                                                Object var89_89 = null;
                                                            } else {
                                                                object5 = cursor2.getString(n13);
                                                                String string39 = object5;
                                                            }
                                                            n39 = (int)(cursor2.isNull(n14) ? 1 : 0);
                                                            if (n39 != 0) {
                                                                Object var90_96 = null;
                                                            } else {
                                                                object5 = cursor2.getString(n14);
                                                                String string40 = object5;
                                                            }
                                                            n39 = (int)(cursor2.isNull(n15) ? 1 : 0);
                                                            if (n39 != 0) {
                                                                Object var91_103 = null;
                                                            } else {
                                                                object5 = cursor2.getString(n15);
                                                                String string41 = object5;
                                                            }
                                                            n39 = (int)(cursor2.isNull(n16) ? 1 : 0);
                                                            if (n39 != 0) {
                                                                n54 = 0;
                                                                string36 = null;
                                                            } else {
                                                                object5 = cursor2.getString(n16);
                                                                string36 = object5;
                                                            }
                                                            n39 = (int)(cursor2.isNull(n17) ? 1 : 0);
                                                            if (n39 != 0) {
                                                                n53 = 0;
                                                                string35 = null;
                                                            } else {
                                                                object5 = cursor2.getString(n17);
                                                                string35 = object5;
                                                            }
                                                            n39 = (int)(cursor2.isNull(n18) ? 1 : 0);
                                                            object4 = n39 != 0 ? null : (object5 = cursor2.getString(n18));
                                                            object5 = new Approval(n56, string37, (String)var89_91, (String)var90_98, (String)var91_105, string36, string35, (String)object4);
                                                            n51 = n11;
                                                            object = object5;
                                                            n39 = n12;
                                                            n12 = n40;
                                                        }
                                                        n40 = (int)(cursor2.isNull(n12) ? 1 : 0);
                                                        if (n40 == 0) break block34;
                                                        n40 = n13;
                                                        n13 = n41;
                                                        if ((n41 = (int)(cursor2.isNull(n41) ? 1 : 0)) == 0) break block35;
                                                        n41 = n14;
                                                        n14 = n42;
                                                        if ((n42 = (int)(cursor2.isNull(n42) ? 1 : 0)) == 0) break block36;
                                                        n42 = n15;
                                                        n15 = n43;
                                                        if ((n43 = (int)(cursor2.isNull(n43) ? 1 : 0)) == 0) break block37;
                                                        n43 = n16;
                                                        n16 = n44;
                                                        if ((n44 = (int)(cursor2.isNull(n44) ? 1 : 0)) == 0) break block38;
                                                        n44 = n17;
                                                        n17 = n45;
                                                        if ((n45 = (int)(cursor2.isNull(n45) ? 1 : 0)) == 0) break block39;
                                                        n45 = n18;
                                                        n18 = n46;
                                                        if ((n46 = (int)(cursor2.isNull(n46) ? 1 : 0)) == 0) break block40;
                                                        n46 = n19;
                                                        n19 = n47;
                                                        if ((n47 = (int)(cursor2.isNull(n47) ? 1 : 0)) == 0) break block41;
                                                        n47 = n20;
                                                        n20 = n48;
                                                        if ((n48 = (int)(cursor2.isNull(n48) ? 1 : 0)) == 0) break block42;
                                                        n48 = n21;
                                                        n21 = n49;
                                                        if ((n49 = (int)(cursor2.isNull(n49) ? 1 : 0)) != 0) break block43;
                                                        break block44;
                                                    }
                                                    n40 = n13;
                                                    n13 = n41;
                                                }
                                                n41 = n14;
                                                n14 = n42;
                                            }
                                            n42 = n15;
                                            n15 = n43;
                                        }
                                        n43 = n16;
                                        n16 = n44;
                                    }
                                    n44 = n17;
                                    n17 = n45;
                                }
                                n45 = n18;
                                n18 = n46;
                            }
                            n46 = n19;
                            n19 = n47;
                        }
                        n47 = n20;
                        n20 = n48;
                    }
                    n48 = n21;
                    n21 = n49;
                }
                n55 = cursor2.getInt(n12);
                n49 = (int)(cursor2.isNull(n13) ? 1 : 0);
                if (n49 != 0) {
                    Object var89_92 = null;
                } else {
                    String string42 = string34 = cursor2.getString(n13);
                }
                n49 = (int)(cursor2.isNull(n14) ? 1 : 0);
                if (n49 != 0) {
                    Object var90_99 = null;
                } else {
                    String string43 = string34 = cursor2.getString(n14);
                }
                n49 = (int)(cursor2.isNull(n15) ? 1 : 0);
                if (n49 != 0) {
                    Object var91_106 = null;
                } else {
                    String string44 = string34 = cursor2.getString(n15);
                }
                n54 = cursor2.getInt(n16);
                n53 = cursor2.getInt(n17);
                n49 = (int)(cursor2.isNull(n18) ? 1 : 0);
                if (n49 != 0) {
                    object4 = null;
                } else {
                    string34 = cursor2.getString(n18);
                    object4 = string34;
                }
                n49 = (int)(cursor2.isNull(n19) ? 1 : 0);
                String string45 = n49 != 0 ? null : (string34 = cursor2.getString(n19));
                n49 = (int)(cursor2.isNull(n20) ? 1 : 0);
                String string46 = n49 != 0 ? null : (string34 = cursor2.getString(n20));
                n49 = (int)(cursor2.isNull(n21) ? 1 : 0);
                if (n49 == 0) {
                    object3 = cursor2.getString(n21);
                }
                Object object6 = object3;
                object3 = new Appeal(n55, (String)var89_94, (String)var90_101, (String)var91_108, n54, n53, (String)object4, string45, string46, (String)object6);
            }
            n49 = n12;
            cursor2 = object3;
            object3 = object2;
            object2 = new Works(l10, string33, string32, string31, string30, string29, string28, string27, string26, string25, string24, string23, string22, string21, string20, string19, string18, string17, string16, string15, string14);
            ((Works)object2).setApproval((Approval)object);
            ((Works)object2).setAppeal((Appeal)cursor2);
            arrayList.add(object2);
            cursor2 = cursor;
            n11 = n25;
            n25 = n26;
            n26 = n27;
            n27 = n28;
            n28 = n29;
            n29 = n30;
            n30 = n31;
            n31 = n32;
            n12 = n50;
            n32 = n51;
            n50 = n24;
            n52 = n41;
            n41 = n13;
            n13 = n33;
            n33 = n39;
            n39 = n45;
            n45 = n17;
            n17 = n37;
            n37 = n43;
            n43 = n15;
            n15 = n35;
            n35 = n52;
            int n57 = n42;
            n42 = n14;
            n14 = n34;
            n34 = n40;
            n40 = n49;
            n49 = n21;
            n21 = n48;
            n48 = n20;
            n20 = n47;
            n47 = n19;
            n19 = n46;
            n46 = n18;
            n18 = n38;
            n38 = n44;
            n44 = n16;
            n16 = n36;
            n36 = n57;
        }
    }
}

