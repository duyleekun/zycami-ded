/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.WorksDao_Impl;
import com.zhiyun.cama.data.database.model.Appeal;
import com.zhiyun.cama.data.database.model.Approval;
import com.zhiyun.cama.data.database.model.Works;

public class WorksDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ WorksDao_Impl this$0;

    public WorksDao_Impl$1(WorksDao_Impl worksDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = worksDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, Works object) {
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        int n10;
        String string8;
        int n11;
        long l10 = ((Works)object).getId();
        int n12 = 1;
        supportSQLiteStatement.bindLong(n12, l10);
        Object object2 = ((Works)object).getSourceUrls();
        int n13 = 2;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            object2 = ((Works)object).getSourceUrls();
            supportSQLiteStatement.bindString(n13, (String)object2);
        }
        object2 = ((Works)object).getDes();
        n13 = 3;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            object2 = ((Works)object).getDes();
            supportSQLiteStatement.bindString(n13, (String)object2);
        }
        object2 = ((Works)object).getCommentCnt();
        n13 = 4;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            object2 = ((Works)object).getCommentCnt();
            supportSQLiteStatement.bindString(n13, (String)object2);
        }
        object2 = ((Works)object).getLikeCnt();
        n13 = 5;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            object2 = ((Works)object).getLikeCnt();
            supportSQLiteStatement.bindString(n13, (String)object2);
        }
        object2 = ((Works)object).getShareCnt();
        n13 = 6;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            object2 = ((Works)object).getShareCnt();
            supportSQLiteStatement.bindString(n13, (String)object2);
        }
        object2 = ((Works)object).getPublishAt();
        n13 = 7;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            object2 = ((Works)object).getPublishAt();
            supportSQLiteStatement.bindString(n13, (String)object2);
        }
        object2 = ((Works)object).getDuration();
        n13 = 8;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            object2 = ((Works)object).getDuration();
            supportSQLiteStatement.bindString(n13, (String)object2);
        }
        object2 = ((Works)object).getThumbwh();
        n13 = 9;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            object2 = ((Works)object).getThumbwh();
            supportSQLiteStatement.bindString(n13, (String)object2);
        }
        object2 = ((Works)object).getPv();
        if (object2 == null) {
            n11 = 10;
            supportSQLiteStatement.bindNull(n11);
        } else {
            n11 = 10;
            string8 = ((Works)object).getPv();
            supportSQLiteStatement.bindString(n11, string8);
        }
        object2 = ((Works)object).getAddress();
        if (object2 == null) {
            n11 = 11;
            supportSQLiteStatement.bindNull(n11);
        } else {
            n11 = 11;
            string8 = ((Works)object).getAddress();
            supportSQLiteStatement.bindString(n11, string8);
        }
        object2 = ((Works)object).getStatus();
        if (object2 == null) {
            n11 = 12;
            supportSQLiteStatement.bindNull(n11);
        } else {
            n11 = 12;
            string8 = ((Works)object).getStatus();
            supportSQLiteStatement.bindString(n11, string8);
        }
        object2 = ((Works)object).getIsChoice();
        if (object2 == null) {
            n11 = 13;
            supportSQLiteStatement.bindNull(n11);
        } else {
            n11 = 13;
            string8 = ((Works)object).getIsChoice();
            supportSQLiteStatement.bindString(n11, string8);
        }
        object2 = ((Works)object).getUserId();
        if (object2 == null) {
            n11 = 14;
            supportSQLiteStatement.bindNull(n11);
        } else {
            n11 = 14;
            string8 = ((Works)object).getUserId();
            supportSQLiteStatement.bindString(n11, string8);
        }
        object2 = ((Works)object).getAvatar();
        if (object2 == null) {
            n11 = 15;
            supportSQLiteStatement.bindNull(n11);
        } else {
            n11 = 15;
            string8 = ((Works)object).getAvatar();
            supportSQLiteStatement.bindString(n11, string8);
        }
        object2 = ((Works)object).getVerified();
        if (object2 == null) {
            n11 = 16;
            supportSQLiteStatement.bindNull(n11);
        } else {
            n11 = 16;
            string8 = ((Works)object).getVerified();
            supportSQLiteStatement.bindString(n11, string8);
        }
        object2 = ((Works)object).getNickname();
        if (object2 == null) {
            n11 = 17;
            supportSQLiteStatement.bindNull(n11);
        } else {
            n11 = 17;
            string8 = ((Works)object).getNickname();
            supportSQLiteStatement.bindString(n11, string8);
        }
        object2 = ((Works)object).getCountry();
        if (object2 == null) {
            n11 = 18;
            supportSQLiteStatement.bindNull(n11);
        } else {
            n11 = 18;
            string8 = ((Works)object).getCountry();
            supportSQLiteStatement.bindString(n11, string8);
        }
        object2 = ((Works)object).getCity();
        if (object2 == null) {
            n11 = 19;
            supportSQLiteStatement.bindNull(n11);
        } else {
            n11 = 19;
            string8 = ((Works)object).getCity();
            supportSQLiteStatement.bindString(n11, string8);
        }
        object2 = ((Works)object).getTags();
        if (object2 == null) {
            n11 = 20;
            supportSQLiteStatement.bindNull(n11);
        } else {
            n11 = 20;
            string8 = ((Works)object).getTags();
            supportSQLiteStatement.bindString(n11, string8);
        }
        object2 = ((Works)object).getDeviceTags();
        if (object2 == null) {
            n11 = 21;
            supportSQLiteStatement.bindNull(n11);
        } else {
            n11 = 21;
            string8 = ((Works)object).getDeviceTags();
            supportSQLiteStatement.bindString(n11, string8);
        }
        object2 = ((Works)object).getApproval();
        n13 = 29;
        n12 = 28;
        int n14 = 27;
        int n15 = 26;
        int n16 = 25;
        int n17 = 24;
        int n18 = 23;
        if (object2 != null) {
            n10 = 22;
            int n19 = ((Approval)object2).getId();
            long l11 = n19;
            supportSQLiteStatement.bindLong(n10, l11);
            String string9 = ((Approval)object2).getDegree();
            if (string9 == null) {
                supportSQLiteStatement.bindNull(n18);
            } else {
                string9 = ((Approval)object2).getDegree();
                supportSQLiteStatement.bindString(n18, string9);
            }
            string7 = ((Approval)object2).getCreateAt();
            if (string7 == null) {
                supportSQLiteStatement.bindNull(n17);
            } else {
                string7 = ((Approval)object2).getCreateAt();
                supportSQLiteStatement.bindString(n17, string7);
            }
            string6 = ((Approval)object2).getRefuse_reason();
            if (string6 == null) {
                supportSQLiteStatement.bindNull(n16);
            } else {
                string6 = ((Approval)object2).getRefuse_reason();
                supportSQLiteStatement.bindString(n16, string6);
            }
            string5 = ((Approval)object2).getClassify();
            if (string5 == null) {
                supportSQLiteStatement.bindNull(n15);
            } else {
                string5 = ((Approval)object2).getClassify();
                supportSQLiteStatement.bindString(n15, string5);
            }
            string4 = ((Approval)object2).getCircle_name();
            if (string4 == null) {
                supportSQLiteStatement.bindNull(n14);
            } else {
                string4 = ((Approval)object2).getCircle_name();
                supportSQLiteStatement.bindString(n14, string4);
            }
            string3 = ((Approval)object2).getModify();
            if (string3 == null) {
                supportSQLiteStatement.bindNull(n12);
            } else {
                string3 = ((Approval)object2).getModify();
                supportSQLiteStatement.bindString(n12, string3);
            }
            string2 = ((Approval)object2).getComment();
            if (string2 == null) {
                supportSQLiteStatement.bindNull(n13);
            } else {
                object2 = ((Approval)object2).getComment();
                supportSQLiteStatement.bindString(n13, (String)object2);
            }
        } else {
            n11 = 22;
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(n18);
            supportSQLiteStatement.bindNull(n17);
            supportSQLiteStatement.bindNull(n16);
            supportSQLiteStatement.bindNull(n15);
            supportSQLiteStatement.bindNull(n14);
            supportSQLiteStatement.bindNull(n12);
            supportSQLiteStatement.bindNull(n13);
        }
        object = ((Works)object).getAppeal();
        n11 = 39;
        n13 = 38;
        n12 = 37;
        n14 = 36;
        n15 = 33;
        n16 = 32;
        n17 = 31;
        if (object != null) {
            n18 = 30;
            n10 = ((Appeal)object).getId();
            long l12 = n10;
            supportSQLiteStatement.bindLong(n18, l12);
            string7 = ((Appeal)object).getApproval_id();
            if (string7 == null) {
                supportSQLiteStatement.bindNull(n17);
            } else {
                string7 = ((Appeal)object).getApproval_id();
                supportSQLiteStatement.bindString(n17, string7);
            }
            string6 = ((Appeal)object).getAppeal_reason();
            if (string6 == null) {
                supportSQLiteStatement.bindNull(n16);
            } else {
                string6 = ((Appeal)object).getAppeal_reason();
                supportSQLiteStatement.bindString(n16, string6);
            }
            string5 = ((Appeal)object).getPunish_id();
            if (string5 == null) {
                supportSQLiteStatement.bindNull(n15);
            } else {
                string5 = ((Appeal)object).getPunish_id();
                supportSQLiteStatement.bindString(n15, string5);
            }
            long l13 = ((Appeal)object).getClassify();
            supportSQLiteStatement.bindLong(34, l13);
            n15 = 35;
            n16 = ((Appeal)object).getStatus();
            l13 = n16;
            supportSQLiteStatement.bindLong(n15, l13);
            string4 = ((Appeal)object).getSourceUrls();
            if (string4 == null) {
                supportSQLiteStatement.bindNull(n14);
            } else {
                string4 = ((Appeal)object).getSourceUrls();
                supportSQLiteStatement.bindString(n14, string4);
            }
            string3 = ((Appeal)object).getCreateAt();
            if (string3 == null) {
                supportSQLiteStatement.bindNull(n12);
            } else {
                string3 = ((Appeal)object).getCreateAt();
                supportSQLiteStatement.bindString(n12, string3);
            }
            string2 = ((Appeal)object).getRefuse_reason();
            if (string2 == null) {
                supportSQLiteStatement.bindNull(n13);
            } else {
                string2 = ((Appeal)object).getRefuse_reason();
                supportSQLiteStatement.bindString(n13, string2);
            }
            string8 = ((Appeal)object).getComment();
            if (string8 == null) {
                supportSQLiteStatement.bindNull(n11);
            } else {
                object = ((Appeal)object).getComment();
                supportSQLiteStatement.bindString(n11, (String)object);
            }
        } else {
            supportSQLiteStatement.bindNull(30);
            supportSQLiteStatement.bindNull(n17);
            supportSQLiteStatement.bindNull(n16);
            supportSQLiteStatement.bindNull(n15);
            supportSQLiteStatement.bindNull(34);
            int n20 = 35;
            supportSQLiteStatement.bindNull(n20);
            supportSQLiteStatement.bindNull(n14);
            supportSQLiteStatement.bindNull(n12);
            supportSQLiteStatement.bindNull(n13);
            supportSQLiteStatement.bindNull(n11);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `Works` (`id`,`sourceUrls`,`des`,`commentCnt`,`likeCnt`,`shareCnt`,`publishAt`,`duration`,`thumbwh`,`pv`,`address`,`status`,`isChoice`,`userId`,`avatar`,`verified`,`nickname`,`country`,`city`,`tags`,`deviceTags`,`approval_id`,`approval_degree`,`approval_createAt`,`approval_refuse_reason`,`approval_classify`,`approval_circle_name`,`approval_modify`,`approval_comment`,`appeal_id`,`appeal_approval_id`,`appeal_appeal_reason`,`appeal_punish_id`,`appeal_classify`,`appeal_status`,`appeal_sourceUrls`,`appeal_createAt`,`appeal_refuse_reason`,`appeal_comment`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}

