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
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.cama.data.PublishState;
import com.zhiyun.cama.data.database.TypeListStringConverters;
import com.zhiyun.cama.data.database.TypePublishStateConverters;
import com.zhiyun.cama.data.database.dao.WorksDao_Impl;
import com.zhiyun.cama.data.database.model.PublishWorks;
import java.util.List;
import java.util.concurrent.Callable;

public class WorksDao_Impl$11
implements Callable {
    public final /* synthetic */ WorksDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public WorksDao_Impl$11(WorksDao_Impl worksDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = worksDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public PublishWorks call() {
        Object object;
        RoomSQLiteQuery roomSQLiteQuery;
        block119: {
            int n10;
            block84: {
                Object object2;
                block118: {
                    int n11;
                    block117: {
                        String string2;
                        int n12;
                        block116: {
                            int n13;
                            block115: {
                                int n14;
                                block114: {
                                    int n15;
                                    block113: {
                                        int n16;
                                        block112: {
                                            int n17;
                                            block111: {
                                                Object object3;
                                                Object object4;
                                                Object object5;
                                                int n18;
                                                int n19;
                                                Object object6;
                                                int n20;
                                                int n21;
                                                int n22;
                                                Object object7;
                                                List list;
                                                List list2;
                                                Object object8;
                                                int n23;
                                                PublishState publishState;
                                                Object object9;
                                                Object object10;
                                                Object object11;
                                                Object object12;
                                                int n24;
                                                int n25;
                                                block110: {
                                                    int n26;
                                                    block109: {
                                                        block108: {
                                                            int n27;
                                                            block107: {
                                                                block106: {
                                                                    int n28;
                                                                    int n29;
                                                                    block105: {
                                                                        int n30;
                                                                        block104: {
                                                                            int n31;
                                                                            block103: {
                                                                                int n32;
                                                                                int n33;
                                                                                block102: {
                                                                                    int n34;
                                                                                    block101: {
                                                                                        block100: {
                                                                                            int n35;
                                                                                            block99: {
                                                                                                block98: {
                                                                                                    int n36;
                                                                                                    block97: {
                                                                                                        block96: {
                                                                                                            int n37;
                                                                                                            block95: {
                                                                                                                int n38;
                                                                                                                block94: {
                                                                                                                    int n39;
                                                                                                                    block93: {
                                                                                                                        block92: {
                                                                                                                            int n40;
                                                                                                                            block91: {
                                                                                                                                block90: {
                                                                                                                                    int n41;
                                                                                                                                    block89: {
                                                                                                                                        block88: {
                                                                                                                                            int n42;
                                                                                                                                            block87: {
                                                                                                                                                block86: {
                                                                                                                                                    block85: {
                                                                                                                                                        String string3;
                                                                                                                                                        Object object13 = this;
                                                                                                                                                        object2 = WorksDao_Impl.access$000(this.this$0);
                                                                                                                                                        roomSQLiteQuery = this.val$_statement;
                                                                                                                                                        n12 = 0;
                                                                                                                                                        string2 = null;
                                                                                                                                                        n10 = 0;
                                                                                                                                                        object = null;
                                                                                                                                                        roomSQLiteQuery = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
                                                                                                                                                        object2 = "filePath";
                                                                                                                                                        try {
                                                                                                                                                            n25 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
                                                                                                                                                            string3 = "coverPath";
                                                                                                                                                        }
                                                                                                                                                        catch (Throwable throwable) {
                                                                                                                                                            roomSQLiteQuery.close();
                                                                                                                                                            throw throwable;
                                                                                                                                                        }
                                                                                                                                                        n42 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
                                                                                                                                                        String string4 = "fileDuration";
                                                                                                                                                        n41 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
                                                                                                                                                        String string5 = "worksDes";
                                                                                                                                                        n40 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
                                                                                                                                                        String string6 = "state";
                                                                                                                                                        n39 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
                                                                                                                                                        String string7 = "percent";
                                                                                                                                                        n38 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
                                                                                                                                                        String string8 = "title";
                                                                                                                                                        n37 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
                                                                                                                                                        String string9 = "tags";
                                                                                                                                                        n36 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
                                                                                                                                                        String string10 = "devices";
                                                                                                                                                        n35 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
                                                                                                                                                        String string11 = "address";
                                                                                                                                                        n34 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
                                                                                                                                                        String string12 = "activeId";
                                                                                                                                                        n33 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string12);
                                                                                                                                                        String string13 = "themeId";
                                                                                                                                                        n32 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string13);
                                                                                                                                                        string2 = "needToDelete";
                                                                                                                                                        n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
                                                                                                                                                        object = "config";
                                                                                                                                                        n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                                                                                                                                                        object13 = "publishFromType";
                                                                                                                                                        n31 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object13);
                                                                                                                                                        object13 = "worksId";
                                                                                                                                                        n30 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object13);
                                                                                                                                                        object13 = "postUrl";
                                                                                                                                                        n29 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object13);
                                                                                                                                                        object13 = "smallImgUrl";
                                                                                                                                                        n28 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object13);
                                                                                                                                                        object13 = "fileUrl";
                                                                                                                                                        n27 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object13);
                                                                                                                                                        object13 = "circleId";
                                                                                                                                                        n26 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object13);
                                                                                                                                                        object13 = "type";
                                                                                                                                                        n24 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object13);
                                                                                                                                                        object13 = "archive";
                                                                                                                                                        n17 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object13);
                                                                                                                                                        object13 = "shareToKwai";
                                                                                                                                                        n16 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object13);
                                                                                                                                                        object13 = "kwaiToken";
                                                                                                                                                        n15 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object13);
                                                                                                                                                        object13 = "resolution";
                                                                                                                                                        n14 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object13);
                                                                                                                                                        object13 = "coverObjectKey";
                                                                                                                                                        n13 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object13);
                                                                                                                                                        object13 = "fileObjectKey";
                                                                                                                                                        n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object13);
                                                                                                                                                        boolean bl2 = roomSQLiteQuery.moveToFirst();
                                                                                                                                                        if (!bl2) break block84;
                                                                                                                                                        bl2 = roomSQLiteQuery.isNull(n25);
                                                                                                                                                        if (!bl2) break block85;
                                                                                                                                                        object12 = null;
                                                                                                                                                        break block86;
                                                                                                                                                    }
                                                                                                                                                    object12 = object2 = roomSQLiteQuery.getString(n25);
                                                                                                                                                }
                                                                                                                                                n25 = (int)(roomSQLiteQuery.isNull(n42) ? 1 : 0);
                                                                                                                                                if (n25 == 0) break block87;
                                                                                                                                                object11 = null;
                                                                                                                                                break block88;
                                                                                                                                            }
                                                                                                                                            object11 = object2 = roomSQLiteQuery.getString(n42);
                                                                                                                                        }
                                                                                                                                        n25 = (int)(roomSQLiteQuery.isNull(n41) ? 1 : 0);
                                                                                                                                        if (n25 == 0) break block89;
                                                                                                                                        object10 = null;
                                                                                                                                        break block90;
                                                                                                                                    }
                                                                                                                                    object10 = object2 = roomSQLiteQuery.getString(n41);
                                                                                                                                }
                                                                                                                                n25 = (int)(roomSQLiteQuery.isNull(n40) ? 1 : 0);
                                                                                                                                if (n25 == 0) break block91;
                                                                                                                                object9 = null;
                                                                                                                                break block92;
                                                                                                                            }
                                                                                                                            object9 = object2 = roomSQLiteQuery.getString(n40);
                                                                                                                        }
                                                                                                                        n25 = (int)(roomSQLiteQuery.isNull(n39) ? 1 : 0);
                                                                                                                        if (n25 == 0) break block93;
                                                                                                                        n25 = 0;
                                                                                                                        object2 = null;
                                                                                                                        break block94;
                                                                                                                    }
                                                                                                                    object2 = roomSQLiteQuery.getString(n39);
                                                                                                                }
                                                                                                                publishState = TypePublishStateConverters.publishStateToString((String)object2);
                                                                                                                n23 = roomSQLiteQuery.getInt(n38);
                                                                                                                n25 = (int)(roomSQLiteQuery.isNull(n37) ? 1 : 0);
                                                                                                                if (n25 == 0) break block95;
                                                                                                                object8 = null;
                                                                                                                break block96;
                                                                                                            }
                                                                                                            object8 = object2 = roomSQLiteQuery.getString(n37);
                                                                                                        }
                                                                                                        n25 = (int)(roomSQLiteQuery.isNull(n36) ? 1 : 0);
                                                                                                        if (n25 == 0) break block97;
                                                                                                        n25 = 0;
                                                                                                        object2 = null;
                                                                                                        break block98;
                                                                                                    }
                                                                                                    object2 = roomSQLiteQuery.getString(n36);
                                                                                                }
                                                                                                list2 = TypeListStringConverters.stringToStringList((String)object2);
                                                                                                n25 = (int)(roomSQLiteQuery.isNull(n35) ? 1 : 0);
                                                                                                if (n25 == 0) break block99;
                                                                                                n25 = 0;
                                                                                                object2 = null;
                                                                                                break block100;
                                                                                            }
                                                                                            object2 = roomSQLiteQuery.getString(n35);
                                                                                        }
                                                                                        list = TypeListStringConverters.stringToStringList((String)object2);
                                                                                        n25 = (int)(roomSQLiteQuery.isNull(n34) ? 1 : 0);
                                                                                        if (n25 == 0) break block101;
                                                                                        object7 = null;
                                                                                        break block102;
                                                                                    }
                                                                                    object7 = object2 = roomSQLiteQuery.getString(n34);
                                                                                }
                                                                                n22 = roomSQLiteQuery.getInt(n33);
                                                                                n21 = roomSQLiteQuery.getInt(n32);
                                                                                n25 = roomSQLiteQuery.getInt(n12);
                                                                                n20 = n25 != 0 ? (n12 = 1) : 0;
                                                                                n25 = (int)(roomSQLiteQuery.isNull(n10) ? 1 : 0);
                                                                                if (n25 == 0) break block103;
                                                                                n25 = n31;
                                                                                object6 = null;
                                                                                break block104;
                                                                            }
                                                                            object6 = object2 = roomSQLiteQuery.getString(n10);
                                                                            n25 = n31;
                                                                        }
                                                                        n19 = roomSQLiteQuery.getInt(n25);
                                                                        n25 = n30;
                                                                        n18 = roomSQLiteQuery.getInt(n30);
                                                                        n25 = n29;
                                                                        n12 = (int)(roomSQLiteQuery.isNull(n29) ? 1 : 0);
                                                                        if (n12 == 0) break block105;
                                                                        n25 = n28;
                                                                        object5 = null;
                                                                        break block106;
                                                                    }
                                                                    object5 = object2 = roomSQLiteQuery.getString(n29);
                                                                    n25 = n28;
                                                                }
                                                                n12 = (int)(roomSQLiteQuery.isNull(n25) ? 1 : 0);
                                                                if (n12 == 0) break block107;
                                                                n25 = n27;
                                                                object4 = null;
                                                                break block108;
                                                            }
                                                            object4 = object2 = roomSQLiteQuery.getString(n25);
                                                            n25 = n27;
                                                        }
                                                        n12 = (int)(roomSQLiteQuery.isNull(n25) ? 1 : 0);
                                                        if (n12 == 0) break block109;
                                                        n25 = n26;
                                                        object3 = null;
                                                        break block110;
                                                    }
                                                    object3 = object2 = roomSQLiteQuery.getString(n25);
                                                    n25 = n26;
                                                }
                                                int n43 = roomSQLiteQuery.getInt(n25);
                                                n25 = n24;
                                                int n44 = roomSQLiteQuery.getInt(n24);
                                                object2 = new PublishWorks((String)object12, (String)object11, (String)object10, (String)object9, publishState, n23, (String)object8, list2, list, (String)object7, n22, n21, n20 != 0, (String)object6, n18, (String)object5, (String)object4, (String)object3, n43, n44, n19);
                                                n12 = n17;
                                                n10 = (int)(roomSQLiteQuery.isNull(n17) ? 1 : 0);
                                                if (n10 == 0) break block111;
                                                n12 = 0;
                                                string2 = null;
                                                break block112;
                                            }
                                            string2 = roomSQLiteQuery.getString(n17);
                                        }
                                        ((PublishWorks)object2).setArchive(string2);
                                        n12 = n16;
                                        n12 = roomSQLiteQuery.getInt(n16);
                                        ((PublishWorks)object2).setShareToKwai(n12);
                                        n12 = n15;
                                        n10 = (int)(roomSQLiteQuery.isNull(n15) ? 1 : 0);
                                        if (n10 == 0) break block113;
                                        n12 = 0;
                                        string2 = null;
                                        break block114;
                                    }
                                    string2 = roomSQLiteQuery.getString(n15);
                                }
                                ((PublishWorks)object2).setKwaiToken(string2);
                                n12 = n14;
                                n12 = roomSQLiteQuery.getInt(n14);
                                ((PublishWorks)object2).setResolution(n12);
                                n12 = n13;
                                n10 = (int)(roomSQLiteQuery.isNull(n13) ? 1 : 0);
                                if (n10 == 0) break block115;
                                n12 = 0;
                                string2 = null;
                                break block116;
                            }
                            string2 = roomSQLiteQuery.getString(n13);
                        }
                        ((PublishWorks)object2).setCoverObjectKey(string2);
                        n12 = (int)(roomSQLiteQuery.isNull(n11) ? 1 : 0);
                        if (n12 == 0) break block117;
                        n10 = 0;
                        object = null;
                        break block118;
                    }
                    object = roomSQLiteQuery.getString(n11);
                }
                ((PublishWorks)object2).setFileObjectKey((String)object);
                object = object2;
                break block119;
            }
            n10 = 0;
            object = null;
        }
        roomSQLiteQuery.close();
        return object;
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

