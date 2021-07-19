/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.account.data.database.dao;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.account.data.database.dao.UserInfoDao_Impl;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.net.BaseEntity;
import java.util.concurrent.Callable;

public class UserInfoDao_Impl$2
implements Callable {
    public final /* synthetic */ UserInfoDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public UserInfoDao_Impl$2(UserInfoDao_Impl userInfoDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = userInfoDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public UserInfo call() {
        Object object;
        RoomSQLiteQuery roomSQLiteQuery;
        block110: {
            int n10;
            block84: {
                int n11;
                int n12;
                int n13;
                Object object2;
                block109: {
                    int n14;
                    String string2;
                    block108: {
                        int n15;
                        int n16;
                        int n17;
                        int n18;
                        int n19;
                        double d10;
                        double d11;
                        Object object3;
                        int n20;
                        Object object4;
                        Object object5;
                        int n21;
                        int n22;
                        Object object6;
                        int n23;
                        int n24;
                        int n25;
                        int n26;
                        String string3;
                        String string4;
                        String string5;
                        String string6;
                        String string7;
                        String string8;
                        String string9;
                        int n27;
                        int n28;
                        int n29;
                        block107: {
                            int n30;
                            int n31;
                            int n32;
                            int n33;
                            int n34;
                            int n35;
                            int n36;
                            block106: {
                                int n37;
                                int n38;
                                block105: {
                                    block104: {
                                        int n39;
                                        block103: {
                                            block102: {
                                                int n40;
                                                int n41;
                                                block101: {
                                                    int n42;
                                                    int n43;
                                                    block100: {
                                                        block99: {
                                                            int n44;
                                                            int n45;
                                                            block98: {
                                                                int n46;
                                                                String string10;
                                                                block97: {
                                                                    int n47;
                                                                    block96: {
                                                                        int n48;
                                                                        block95: {
                                                                            block94: {
                                                                                int n49;
                                                                                block93: {
                                                                                    block92: {
                                                                                        int n50;
                                                                                        block91: {
                                                                                            block90: {
                                                                                                int n51;
                                                                                                block89: {
                                                                                                    block88: {
                                                                                                        int n52;
                                                                                                        block87: {
                                                                                                            block86: {
                                                                                                                int n53;
                                                                                                                block85: {
                                                                                                                    String string11;
                                                                                                                    object2 = this;
                                                                                                                    Object object7 = UserInfoDao_Impl.access$000(this.this$0);
                                                                                                                    roomSQLiteQuery = this.val$_statement;
                                                                                                                    n13 = 0;
                                                                                                                    string2 = null;
                                                                                                                    n10 = 0;
                                                                                                                    object = null;
                                                                                                                    roomSQLiteQuery = DBUtil.query((RoomDatabase)object7, roomSQLiteQuery, false, null);
                                                                                                                    object7 = "errcode";
                                                                                                                    try {
                                                                                                                        n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
                                                                                                                        string11 = "errmsg";
                                                                                                                    }
                                                                                                                    catch (Throwable throwable) {
                                                                                                                        roomSQLiteQuery.close();
                                                                                                                        throw throwable;
                                                                                                                    }
                                                                                                                    n43 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
                                                                                                                    string10 = "id";
                                                                                                                    n47 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
                                                                                                                    String string12 = "avatar";
                                                                                                                    n53 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string12);
                                                                                                                    String string13 = "nickname";
                                                                                                                    n52 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string13);
                                                                                                                    String string14 = "birthday";
                                                                                                                    n51 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string14);
                                                                                                                    String string15 = "country";
                                                                                                                    n50 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string15);
                                                                                                                    String string16 = "city";
                                                                                                                    n49 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string16);
                                                                                                                    String string17 = "introduction";
                                                                                                                    n48 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string17);
                                                                                                                    String string18 = "hobby";
                                                                                                                    n46 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string18);
                                                                                                                    String string19 = "sex";
                                                                                                                    n45 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string19);
                                                                                                                    String string20 = "share_post_count";
                                                                                                                    n44 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string20);
                                                                                                                    string2 = "follows_count";
                                                                                                                    n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
                                                                                                                    object = "followers_count";
                                                                                                                    n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                                                                                                                    object2 = "token";
                                                                                                                    n29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
                                                                                                                    n14 = n43;
                                                                                                                    string11 = "followed";
                                                                                                                    n43 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
                                                                                                                    n28 = n12;
                                                                                                                    object7 = "verified";
                                                                                                                    n42 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
                                                                                                                    object7 = "mobile";
                                                                                                                    n41 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
                                                                                                                    object7 = "mail";
                                                                                                                    n40 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
                                                                                                                    object7 = "adnotification";
                                                                                                                    n39 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
                                                                                                                    object7 = "status";
                                                                                                                    n38 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
                                                                                                                    object7 = "longitude";
                                                                                                                    n37 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
                                                                                                                    object7 = "latitude";
                                                                                                                    n36 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
                                                                                                                    object7 = "memberId";
                                                                                                                    n35 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
                                                                                                                    object7 = "applicantId";
                                                                                                                    n34 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
                                                                                                                    object7 = "activity";
                                                                                                                    n33 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
                                                                                                                    object7 = "rank";
                                                                                                                    n32 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
                                                                                                                    object7 = "isAgree";
                                                                                                                    n31 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
                                                                                                                    object7 = "blocked";
                                                                                                                    n30 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
                                                                                                                    object7 = "prime";
                                                                                                                    n11 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
                                                                                                                    object7 = "primeId";
                                                                                                                    n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
                                                                                                                    boolean bl2 = roomSQLiteQuery.moveToFirst();
                                                                                                                    if (!bl2) break block84;
                                                                                                                    n27 = roomSQLiteQuery.getInt(n47);
                                                                                                                    n47 = (int)(roomSQLiteQuery.isNull(n53) ? 1 : 0);
                                                                                                                    if (n47 == 0) break block85;
                                                                                                                    string9 = null;
                                                                                                                    break block86;
                                                                                                                }
                                                                                                                string9 = string10 = roomSQLiteQuery.getString(n53);
                                                                                                            }
                                                                                                            n47 = (int)(roomSQLiteQuery.isNull(n52) ? 1 : 0);
                                                                                                            if (n47 == 0) break block87;
                                                                                                            string8 = null;
                                                                                                            break block88;
                                                                                                        }
                                                                                                        string8 = string10 = roomSQLiteQuery.getString(n52);
                                                                                                    }
                                                                                                    n47 = (int)(roomSQLiteQuery.isNull(n51) ? 1 : 0);
                                                                                                    if (n47 == 0) break block89;
                                                                                                    string7 = null;
                                                                                                    break block90;
                                                                                                }
                                                                                                string7 = string10 = roomSQLiteQuery.getString(n51);
                                                                                            }
                                                                                            n47 = (int)(roomSQLiteQuery.isNull(n50) ? 1 : 0);
                                                                                            if (n47 == 0) break block91;
                                                                                            string6 = null;
                                                                                            break block92;
                                                                                        }
                                                                                        string6 = string10 = roomSQLiteQuery.getString(n50);
                                                                                    }
                                                                                    n47 = (int)(roomSQLiteQuery.isNull(n49) ? 1 : 0);
                                                                                    if (n47 == 0) break block93;
                                                                                    string5 = null;
                                                                                    break block94;
                                                                                }
                                                                                string5 = string10 = roomSQLiteQuery.getString(n49);
                                                                            }
                                                                            n47 = (int)(roomSQLiteQuery.isNull(n48) ? 1 : 0);
                                                                            if (n47 == 0) break block95;
                                                                            string4 = null;
                                                                            break block96;
                                                                        }
                                                                        string4 = string10 = roomSQLiteQuery.getString(n48);
                                                                    }
                                                                    n47 = (int)(roomSQLiteQuery.isNull(n46) ? 1 : 0);
                                                                    if (n47 == 0) break block97;
                                                                    string3 = null;
                                                                    break block98;
                                                                }
                                                                string3 = string10 = roomSQLiteQuery.getString(n46);
                                                            }
                                                            n26 = roomSQLiteQuery.getInt(n45);
                                                            n25 = roomSQLiteQuery.getInt(n44);
                                                            n24 = roomSQLiteQuery.getInt(n13);
                                                            n23 = roomSQLiteQuery.getInt(n10);
                                                            n13 = (int)(roomSQLiteQuery.isNull(n29) ? 1 : 0);
                                                            if (n13 == 0) break block99;
                                                            object6 = null;
                                                            break block100;
                                                        }
                                                        object6 = object2 = roomSQLiteQuery.getString(n29);
                                                    }
                                                    n22 = roomSQLiteQuery.getInt(n43);
                                                    n29 = n42;
                                                    n21 = roomSQLiteQuery.getInt(n42);
                                                    n29 = n41;
                                                    n13 = (int)(roomSQLiteQuery.isNull(n41) ? 1 : 0);
                                                    if (n13 == 0) break block101;
                                                    n29 = n40;
                                                    object5 = null;
                                                    break block102;
                                                }
                                                object5 = object2 = roomSQLiteQuery.getString(n41);
                                                n29 = n40;
                                            }
                                            n13 = (int)(roomSQLiteQuery.isNull(n29) ? 1 : 0);
                                            if (n13 == 0) break block103;
                                            n29 = n39;
                                            object4 = null;
                                            break block104;
                                        }
                                        object4 = object2 = roomSQLiteQuery.getString(n29);
                                        n29 = n39;
                                    }
                                    n20 = roomSQLiteQuery.getInt(n29);
                                    n29 = n38;
                                    n13 = (int)(roomSQLiteQuery.isNull(n38) ? 1 : 0);
                                    if (n13 == 0) break block105;
                                    n29 = n37;
                                    object3 = null;
                                    break block106;
                                }
                                object3 = object2 = roomSQLiteQuery.getString(n38);
                                n29 = n37;
                            }
                            d11 = roomSQLiteQuery.getDouble(n29);
                            n29 = n36;
                            d10 = roomSQLiteQuery.getDouble(n36);
                            n29 = n35;
                            n19 = roomSQLiteQuery.getInt(n35);
                            n29 = n34;
                            n18 = roomSQLiteQuery.getInt(n34);
                            n29 = n33;
                            n17 = roomSQLiteQuery.getInt(n33);
                            n29 = n32;
                            n16 = roomSQLiteQuery.getInt(n32);
                            n29 = n31;
                            n29 = roomSQLiteQuery.getInt(n31);
                            if (n29 != 0) {
                                n15 = n13 = 1;
                                n29 = n30;
                                break block107;
                            }
                            n29 = n30;
                            n15 = 0;
                        }
                        int n54 = roomSQLiteQuery.getInt(n29);
                        object2 = new UserInfo(n27, string9, string8, string7, string6, string5, string4, string3, n26, n25, n24, n23, (String)object6, n22, n21, (String)object5, (String)object4, n20, (String)object3, d11, d10, n19, n18, n17, n16, n15 != 0, n54);
                        n13 = n28;
                        n13 = roomSQLiteQuery.getInt(n28);
                        ((BaseEntity)object2).errcode = n13;
                        n13 = n14;
                        n10 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0);
                        if (n10 == 0) break block108;
                        n10 = 0;
                        object = null;
                        ((BaseEntity)object2).errmsg = null;
                        break block109;
                    }
                    string2 = roomSQLiteQuery.getString(n14);
                    ((BaseEntity)object2).errmsg = string2;
                }
                n13 = n11;
                n13 = roomSQLiteQuery.getInt(n11);
                ((UserInfo)object2).setPrime(n13);
                n12 = roomSQLiteQuery.getInt(n12);
                ((UserInfo)object2).setPrimeId(n12);
                object = object2;
                break block110;
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

