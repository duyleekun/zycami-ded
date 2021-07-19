/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.b0;

import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.MessagePageType;
import com.zhiyun.cama.data.PublishState;
import com.zhiyun.cama.data.api.entity.UnReadMessageEntity;
import com.zhiyun.cama.data.api.entity.UnReadMessageEntity$CountBaseEntity;
import com.zhiyun.cama.data.api.entity.UnReadMessageEntity$PersonalCountEntity;
import com.zhiyun.cama.data.database.AppDatabase;
import com.zhiyun.cama.data.database.DatabaseHelper;
import com.zhiyun.cama.data.database.dao.FeedbackDao;
import com.zhiyun.cama.data.database.dao.MessageDao;
import com.zhiyun.cama.data.database.dao.WorksDao;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.data.database.model.MessageUnReadCount;
import com.zhiyun.cama.data.database.model.MessageViolation;
import com.zhiyun.cama.data.database.model.PublishWorks;
import com.zhiyun.cama.data.database.model.Works;
import d.v.a.f.c.d.d;
import d.v.c.v0.u.b0.a;
import d.v.c.v0.u.b0.b$a;
import d.v.e.l.a2;
import d.v.e.l.s1;
import java.util.List;

public class b {
    private static volatile b e;
    private AppDatabase a;
    private WorksDao b;
    private MessageDao c;
    private FeedbackDao d;

    private b() {
        Object object = DatabaseHelper.getInstance().getDataBase();
        this.a = object;
        this.b = object = ((AppDatabase)object).worksDao();
        this.c = object = this.a.messageDao();
        this.d = object = this.a.feedbackDao();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b g() {
        Object object = e;
        if (object != null) return e;
        object = b.class;
        synchronized (object) {
            b b10 = e;
            if (b10 != null) return e;
            e = b10 = new b();
            return e;
        }
    }

    private int h() {
        return d.v.a.f.c.d.d.F().L().getId();
    }

    private /* synthetic */ void i(int n10) {
        boolean bl2;
        List list;
        Object object = this.b.loadWorksData(n10);
        if (object != null) {
            WorksDao worksDao = this.b;
            worksDao.deleteWorks((Works)object);
        }
        if ((list = (object = this.b).loadLikesData(n10)) != null && !(bl2 = list.isEmpty())) {
            object = this.b;
            object.deleteLikes(list);
        }
    }

    public void a(PublishWorks object) {
        int n10 = ((PublishWorks)object).getWorksId();
        long l10 = n10;
        Works works = new Works(l10);
        Works[] worksArray = new StringBuilder();
        CharSequence charSequence = ((PublishWorks)object).getSmallImgUrl();
        worksArray.append((String)charSequence);
        worksArray.append(",");
        charSequence = ((PublishWorks)object).getFileUrl();
        worksArray.append((String)charSequence);
        worksArray = worksArray.toString();
        works.setSourceUrls((String)worksArray);
        worksArray = d.v.a.f.c.d.d.F().L();
        charSequence = new StringBuilder();
        int n11 = worksArray.getId();
        ((StringBuilder)charSequence).append(n11);
        ((StringBuilder)charSequence).append("");
        charSequence = ((StringBuilder)charSequence).toString();
        works.setUserId((String)charSequence);
        charSequence = worksArray.getAvatar();
        works.setAvatar((String)charSequence);
        works.setStatus("2");
        worksArray = worksArray.getNickname();
        works.setNickname((String)worksArray);
        object = ((PublishWorks)object).getFileDuration();
        works.setDuration((String)object);
        object = this.b;
        worksArray = new Works[]{works};
        object.insertWorks(worksArray);
    }

    public void b(MessagePageType messagePageType, int n10) {
        int n11;
        int n12;
        Object object;
        Object object2 = this.c;
        MessageUnReadCount messageUnReadCount = object2.loadMessageUnreadCountData(n10);
        if (messageUnReadCount == null) {
            boolean bl2 = false;
            object2 = messageUnReadCount;
            messageUnReadCount = new MessageUnReadCount(0, 0, 0, 0, 0, 0, 0, false);
        }
        if ((object = (object2 = (Object)b$a.a)[n12 = messagePageType.ordinal()]) != (n11 = 1)) {
            int n13 = 2;
            if (object != n13) {
                int n14 = 3;
                if (object == n14) {
                    int n15 = messageUnReadCount.getPersonal() + n11;
                    messageUnReadCount.setPersonal(n15);
                    messageUnReadCount.setPunished(n11 != 0);
                }
            } else {
                int n16 = messageUnReadCount.getNotice() + n11;
                messageUnReadCount.setNotice(n16);
            }
        } else {
            int n17 = messageUnReadCount.getLike() + n11;
            messageUnReadCount.setLike(n17);
        }
        this.c.insertMessageUnreadCount(messageUnReadCount);
    }

    public void c(int n10) {
        boolean bl2;
        WorksDao worksDao = this.b;
        int n11 = this.h();
        List list = worksDao.loadLikesData(n11, n10);
        if (list != null && !(bl2 = list.isEmpty())) {
            worksDao = this.b;
            worksDao.deleteLikes(list);
        }
    }

    public void d(MessagePageType object, int n10) {
        MessagePageType messagePageType = MessagePageType.MESSAGE_LIKE;
        boolean bl2 = messagePageType.equals(object);
        if (bl2) {
            object = this.c;
            object.deleteMessageLike(n10);
        } else {
            messagePageType = MessagePageType.MESSAGE_SYSTEM;
            boolean bl3 = messagePageType.equals(object);
            if (bl3) {
                object = this.c;
                object.deleteMessageSystem(n10);
            }
        }
    }

    public void e() {
        PublishWorks publishWorks = this.b.loadPublishWorksData();
        if (publishWorks != null) {
            Object[] objectArray;
            Object object;
            boolean bl2 = publishWorks.isNeedToDelete();
            if (bl2 && (object = PublishState.STATE_SUCCESS) == (objectArray = publishWorks.getState())) {
                bl2 = s1.h(publishWorks.getFilePath());
                boolean bl3 = a2.c(publishWorks.getFilePath());
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("deletePublishWorks:");
                String string2 = publishWorks.getFilePath();
                stringBuilder.append(string2);
                stringBuilder.append(bl2);
                stringBuilder.append(bl3);
                object = stringBuilder.toString();
                bl3 = false;
                objectArray = new Object[]{};
                m.a.a.b((String)object, objectArray);
            }
            object = this.b;
            object.deletePublishWorks(publishWorks);
        }
        this.b.deletedAllPublish();
    }

    public void f(int n10) {
        AppDatabase appDatabase = this.a;
        a a10 = new a(this, n10);
        appDatabase.runInTransaction(a10);
    }

    public /* synthetic */ void j(int n10) {
        this.i(n10);
    }

    public LiveData k() {
        MessageDao messageDao = this.c;
        int n10 = this.h();
        return messageDao.loadMessageUnreadCount(n10);
    }

    public MessageViolation l(String string2, int n10) {
        return this.c.loadMessageViolation(string2, n10);
    }

    public LiveData m() {
        return this.b.loadPublishWorks();
    }

    public Works n(int n10) {
        return this.b.loadWorksDataWithApprovalId(n10);
    }

    public void o(Feedback feedback) {
        if (feedback != null) {
            int n10;
            String string2;
            Feedback[] feedbackArray;
            Object object = this.d;
            int n11 = feedback.getId();
            if ((object = object.loadFeedback(n11)) != null && ((n11 = (int)((feedbackArray = ((Feedback)object).getTitle()).equals(string2 = feedback.getTitle()) ? 1 : 0)) == 0 || (n10 = ((Feedback)object).getDealStatus()) != (n11 = feedback.getDealStatus()))) {
                object = this.d;
                n11 = 1;
                feedbackArray = new Feedback[n11];
                string2 = null;
                feedbackArray[0] = feedback;
                object.insertFeedback(feedbackArray);
            }
        }
    }

    public void p(UnReadMessageEntity object) {
        if (object != null) {
            MessageUnReadCount messageUnReadCount;
            boolean bl2;
            boolean bl3;
            int n10 = this.h();
            Object object2 = ((UnReadMessageEntity)object).message;
            boolean bl4 = false;
            boolean bl5 = object2 != null ? (bl3 = ((UnReadMessageEntity$CountBaseEntity)object2).count) : false;
            object2 = ((UnReadMessageEntity)object).comment;
            boolean bl6 = object2 != null ? (bl3 = ((UnReadMessageEntity$CountBaseEntity)object2).count) : false;
            object2 = ((UnReadMessageEntity)object).follow;
            boolean bl7 = object2 != null ? (bl3 = ((UnReadMessageEntity$CountBaseEntity)object2).count) : false;
            object2 = ((UnReadMessageEntity)object).like;
            boolean bl8 = object2 != null ? (bl3 = ((UnReadMessageEntity$CountBaseEntity)object2).count) : false;
            object2 = ((UnReadMessageEntity)object).personal;
            boolean bl9 = object2 != null ? ((UnReadMessageEntity$CountBaseEntity)object2).count : false;
            object = ((UnReadMessageEntity)object).notice;
            if (object != null) {
                bl2 = ((UnReadMessageEntity$CountBaseEntity)object).count;
            } else {
                bl2 = false;
                object = null;
            }
            boolean bl10 = object2 != null && (bl3 = (boolean)((UnReadMessageEntity$PersonalCountEntity)object2).punished) ? (bl3 = true) : false;
            object2 = messageUnReadCount;
            bl4 = bl5;
            bl5 = bl6;
            bl6 = bl7;
            bl7 = bl8;
            bl8 = bl9;
            bl9 = bl2;
            messageUnReadCount = new MessageUnReadCount(n10, (int)(bl4 ? 1 : 0), (int)(bl5 ? 1 : 0), (int)(bl6 ? 1 : 0), (int)(bl7 ? 1 : 0), (int)(bl8 ? 1 : 0), (int)(bl2 ? 1 : 0), bl10);
            object = this.c;
            object.insertMessageUnreadCount(messageUnReadCount);
        }
    }

    public void q(MessageViolation messageViolation) {
        MessageDao messageDao = this.c;
        MessageViolation[] messageViolationArray = new MessageViolation[]{messageViolation};
        messageDao.insertMessageViolation(messageViolationArray);
    }

    public void r(PublishWorks publishWorks) {
        this.b.insertPublishWorks(publishWorks);
    }

    public void s(Works works) {
        WorksDao worksDao = this.b;
        Works[] worksArray = new Works[]{works};
        worksDao.insertWorks(worksArray);
    }
}

