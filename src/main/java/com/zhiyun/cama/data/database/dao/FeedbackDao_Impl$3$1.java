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
import com.zhiyun.cama.data.database.dao.FeedbackDao_Impl$3;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.net.BaseEntity;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDao_Impl$3$1
extends LimitOffsetDataSource {
    public final /* synthetic */ FeedbackDao_Impl$3 this$1;

    public FeedbackDao_Impl$3$1(FeedbackDao_Impl$3 feedbackDao_Impl$3, RoomDatabase roomDatabase, RoomSQLiteQuery roomSQLiteQuery, boolean bl2, boolean bl3, String ... stringArray) {
        this.this$1 = feedbackDao_Impl$3;
        super(roomDatabase, roomSQLiteQuery, bl2, bl3, stringArray);
    }

    public List convertRows(Cursor cursor) {
        int n10;
        Object object = cursor;
        String string2 = "errcode";
        int n11 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
        String string3 = "errmsg";
        int n12 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
        String string4 = "id";
        int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
        String string5 = "userId";
        int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
        String string6 = "name";
        int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
        String string7 = "contact";
        int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
        String string8 = "title";
        int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
        String string9 = "content";
        int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
        String string10 = "type";
        int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
        String string11 = "platform";
        int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
        String string12 = "mobileModel";
        int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
        String string13 = "mobileOSVersion";
        int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string13);
        String string14 = "appVersion";
        int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string14);
        Object object2 = "deviceModel";
        int n24 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
        int n25 = CursorUtil.getColumnIndexOrThrow(cursor, "images");
        int n26 = CursorUtil.getColumnIndexOrThrow(cursor, "user_lang");
        int n27 = CursorUtil.getColumnIndexOrThrow(cursor, "firmwareVersion");
        int n28 = CursorUtil.getColumnIndexOrThrow(cursor, "frequency");
        int n29 = CursorUtil.getColumnIndexOrThrow(cursor, "advice_target");
        int n30 = CursorUtil.getColumnIndexOrThrow(cursor, "dealStatus");
        int n31 = CursorUtil.getColumnIndexOrThrow(cursor, "createAt");
        int n32 = CursorUtil.getColumnIndexOrThrow(cursor, "closedAt");
        int n33 = n10 = CursorUtil.getColumnIndexOrThrow(cursor, "canActive");
        int n34 = n24;
        n24 = cursor.getCount();
        ArrayList<Object> arrayList = new ArrayList<Object>(n24);
        while ((n24 = (int)(cursor.moveToNext() ? 1 : 0)) != 0) {
            String string15;
            String string16;
            object2 = new Feedback();
            ArrayList<Object> arrayList2 = arrayList;
            ((BaseEntity)object2).errcode = n10 = object.getInt(n11);
            n10 = (int)(object.isNull(n12) ? 1 : 0);
            int n35 = n11;
            n11 = 0;
            string2 = null;
            if (n10 != 0) {
                ((BaseEntity)object2).errmsg = null;
            } else {
                arrayList = object.getString(n12);
                ((BaseEntity)object2).errmsg = arrayList;
            }
            n10 = object.getInt(n13);
            ((Feedback)object2).setId(n10);
            n10 = n12;
            long l10 = object.getLong(n14);
            ((Feedback)object2).setUserId(l10);
            n11 = (int)(object.isNull(n15) ? 1 : 0);
            if (n11 != 0) {
                n11 = 0;
                string2 = null;
            } else {
                string2 = object.getString(n15);
            }
            ((Feedback)object2).setName(string2);
            n11 = (int)(object.isNull(n16) ? 1 : 0);
            if (n11 != 0) {
                n11 = 0;
                string2 = null;
            } else {
                string2 = object.getString(n16);
            }
            ((Feedback)object2).setContact(string2);
            n11 = (int)(object.isNull(n17) ? 1 : 0);
            if (n11 != 0) {
                n11 = 0;
                string2 = null;
            } else {
                string2 = object.getString(n17);
            }
            ((Feedback)object2).setTitle(string2);
            n11 = (int)(object.isNull(n18) ? 1 : 0);
            if (n11 != 0) {
                n11 = 0;
                string2 = null;
            } else {
                string2 = object.getString(n18);
            }
            ((Feedback)object2).setContent(string2);
            n11 = (int)(object.isNull(n19) ? 1 : 0);
            if (n11 != 0) {
                n11 = 0;
                string2 = null;
            } else {
                string2 = object.getString(n19);
            }
            ((Feedback)object2).setType(string2);
            n11 = (int)(object.isNull(n20) ? 1 : 0);
            if (n11 != 0) {
                n11 = 0;
                string2 = null;
            } else {
                string2 = object.getString(n20);
            }
            ((Feedback)object2).setPlatform(string2);
            n11 = (int)(object.isNull(n21) ? 1 : 0);
            if (n11 != 0) {
                n11 = 0;
                string2 = null;
            } else {
                string2 = object.getString(n21);
            }
            ((Feedback)object2).setMobileModel(string2);
            n11 = (int)(object.isNull(n22) ? 1 : 0);
            if (n11 != 0) {
                n11 = 0;
                string2 = null;
            } else {
                string2 = object.getString(n22);
            }
            ((Feedback)object2).setMobileOSVersion(string2);
            n11 = (int)(object.isNull(n23) ? 1 : 0);
            if (n11 != 0) {
                n11 = 0;
                string2 = null;
            } else {
                string2 = object.getString(n23);
            }
            ((Feedback)object2).setAppVersion(string2);
            n11 = n34;
            n12 = (int)(object.isNull(n34) ? 1 : 0);
            if (n12 != 0) {
                n12 = 0;
                string3 = null;
            } else {
                string3 = object.getString(n34);
            }
            ((Feedback)object2).setDeviceModel(string3);
            n12 = n25;
            n25 = (int)(object.isNull(n25) ? 1 : 0);
            if (n25 != 0) {
                n34 = n11;
                n11 = 0;
                string2 = null;
            } else {
                string16 = object.getString(n12);
                n34 = n11;
                string2 = string16;
            }
            ((Feedback)object2).setImages(string2);
            n11 = n26;
            n25 = (int)(object.isNull(n26) ? 1 : 0);
            if (n25 != 0) {
                n11 = 0;
                string2 = null;
            } else {
                string2 = string16 = object.getString(n26);
            }
            ((Feedback)object2).setUser_lang(string2);
            n11 = n27;
            n25 = (int)(object.isNull(n27) ? 1 : 0);
            if (n25 != 0) {
                n11 = 0;
                string2 = null;
            } else {
                string2 = string16 = object.getString(n27);
            }
            ((Feedback)object2).setFirmwareVersion(string2);
            n25 = n12;
            n11 = n28;
            n12 = object.getInt(n28);
            ((Feedback)object2).setFrequency(n12);
            n12 = n29;
            n28 = (int)(object.isNull(n29) ? 1 : 0);
            if (n28 != 0) {
                n29 = n11;
                n11 = 0;
                string2 = null;
            } else {
                String string17 = object.getString(n29);
                n29 = n11;
                string2 = string17;
            }
            ((Feedback)object2).setAdvice_target(string2);
            n28 = n12;
            n11 = n30;
            n12 = object.getInt(n30);
            ((Feedback)object2).setDealStatus(n12);
            n12 = n31;
            n30 = (int)(object.isNull(n31) ? 1 : 0);
            if (n30 != 0) {
                n31 = n11;
                n11 = 0;
                string2 = null;
            } else {
                string15 = object.getString(n31);
                n31 = n11;
                string2 = string15;
            }
            ((Feedback)object2).setCreateAt(string2);
            n11 = n32;
            n30 = (int)(object.isNull(n32) ? 1 : 0);
            if (n30 != 0) {
                n11 = 0;
                string2 = null;
            } else {
                string2 = string15 = object.getString(n32);
            }
            ((Feedback)object2).setClosedAt(string2);
            n11 = n33;
            n30 = object.getInt(n33);
            if (n30 != 0) {
                n30 = 1;
            } else {
                n30 = 0;
                string15 = null;
            }
            ((Feedback)object2).setCanActive(n30 != 0);
            object = arrayList2;
            arrayList2.add(object2);
            n33 = n11;
            n30 = n31;
            n11 = n35;
            n31 = n12;
            n12 = n10;
            arrayList = arrayList2;
            object = cursor;
            int n36 = n29;
            n29 = n28;
            n28 = n36;
        }
        object = arrayList;
        return arrayList;
    }
}

