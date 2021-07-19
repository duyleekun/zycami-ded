/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateStickerDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateBaseData;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class G_TemplateStickerDao_Impl$8
implements Callable {
    public final /* synthetic */ G_TemplateStickerDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateStickerDao_Impl$8(G_TemplateStickerDao_Impl g_TemplateStickerDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateStickerDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        Object object = this;
        ArrayList<Object> arrayList = G_TemplateStickerDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        int n10 = 0;
        String string2 = null;
        int n11 = 0;
        String string3 = null;
        roomSQLiteQuery = DBUtil.query((RoomDatabase)((Object)arrayList), roomSQLiteQuery, false, null);
        arrayList = "id";
        try {
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            String string4 = "temp_id";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
            String string5 = "start_time";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
            String string6 = "end_time";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
            String string7 = "angle";
            int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
            String string8 = "center";
            int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
            String string9 = "type";
            int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
            String string10 = "sticker_type_id";
            int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
            String string11 = "scale";
            int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
            String string12 = "text_font_size";
            int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string12);
            String string13 = "text_color";
            int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string13);
            String string14 = "text_content";
            int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string14);
            string2 = "text_caption_name";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
            string3 = "caption_local_source";
            n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
            object = "text_font_name";
            int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            int n25 = n13;
            string4 = "image_name";
            n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
            int n26 = n12;
            arrayList = "gif_name";
            int n27 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "thumb_url";
            int n28 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "local_source";
            int n29 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "customer_uuid";
            int n30 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            int n31 = n13;
            n13 = roomSQLiteQuery.getCount();
            arrayList = new ArrayList<Object>(n13);
            while ((n13 = (int)(roomSQLiteQuery.moveToNext() ? 1 : 0)) != 0) {
                int n32;
                String string15;
                String string16;
                long l10 = roomSQLiteQuery.getLong(n14);
                long l11 = roomSQLiteQuery.getLong(n15);
                float f10 = roomSQLiteQuery.getFloat(n16);
                n13 = (int)(roomSQLiteQuery.isNull(n17) ? 1 : 0);
                String string17 = n13 != 0 ? null : (string4 = roomSQLiteQuery.getString(n17));
                n13 = (int)(roomSQLiteQuery.isNull(n18) ? 1 : 0);
                String string18 = n13 != 0 ? null : (string4 = roomSQLiteQuery.getString(n18));
                long l12 = roomSQLiteQuery.getLong(n19);
                float f11 = roomSQLiteQuery.getFloat(n20);
                float f12 = roomSQLiteQuery.getFloat(n21);
                n13 = (int)(roomSQLiteQuery.isNull(n22) ? 1 : 0);
                String string19 = n13 != 0 ? null : (string4 = roomSQLiteQuery.getString(n22));
                n13 = (int)(roomSQLiteQuery.isNull(n23) ? 1 : 0);
                String string20 = n13 != 0 ? null : (string4 = roomSQLiteQuery.getString(n23));
                n13 = (int)(roomSQLiteQuery.isNull(n10) ? 1 : 0);
                String string21 = n13 != 0 ? null : (string4 = roomSQLiteQuery.getString(n10));
                n13 = roomSQLiteQuery.getInt(n11);
                int n33 = 1;
                int n34 = n13 != 0 ? n33 : 0;
                n13 = (int)(roomSQLiteQuery.isNull(n24) ? 1 : 0);
                if (n13 != 0) {
                    n13 = n31;
                    string16 = null;
                } else {
                    string16 = string4 = roomSQLiteQuery.getString(n24);
                    n13 = n31;
                }
                n31 = (int)(roomSQLiteQuery.isNull(n13) ? 1 : 0);
                String string22 = n31 != 0 ? null : (string15 = roomSQLiteQuery.getString(n13));
                int n35 = n27;
                n27 = n24;
                n24 = n35;
                n31 = (int)(roomSQLiteQuery.isNull(n35) ? 1 : 0);
                String string23 = n31 != 0 ? null : (string15 = roomSQLiteQuery.getString(n35));
                n35 = n28;
                n28 = n24;
                n24 = n35;
                n31 = (int)(roomSQLiteQuery.isNull(n35) ? 1 : 0);
                String string24 = n31 != 0 ? null : (string15 = roomSQLiteQuery.getString(n35));
                n35 = n29;
                n29 = n24;
                n24 = n35;
                n31 = roomSQLiteQuery.getInt(n35);
                if (n31 != 0) {
                    n31 = n35;
                    n32 = n33;
                } else {
                    n31 = n35;
                    n32 = 0;
                }
                object = new TemplateSticker(l10, l11, f10, string17, string18, l12, f11, f12, string16, string19, string20, string21, n34 != 0, string22, string23, string24, n32 != 0);
                n33 = n10;
                int n36 = n13;
                n10 = n26;
                n26 = n11;
                long l13 = roomSQLiteQuery.getLong(n10);
                ((TemplateSticker)object).setId(l13);
                n11 = n25;
                n25 = n14;
                long l14 = roomSQLiteQuery.getLong(n11);
                ((TemplateSticker)object).setTempId(l14);
                n13 = n30;
                n14 = (int)(roomSQLiteQuery.isNull(n30) ? 1 : 0);
                if (n14 != 0) {
                    n14 = 0;
                    string5 = null;
                } else {
                    string5 = roomSQLiteQuery.getString(n30);
                }
                ((TemplateBaseData)object).setCustomerUUID(string5);
                arrayList.add(object);
                n30 = n13;
                n14 = n25;
                n24 = n27;
                n27 = n28;
                n28 = n29;
                n29 = n31;
                n31 = n36;
                n25 = n11;
                n11 = n26;
                n26 = n10;
                n10 = n33;
            }
            return arrayList;
        }
        finally {
            roomSQLiteQuery.close();
        }
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

