/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package d.v.c.v0.u;

import android.os.Build;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource$Factory;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList$BoundaryCallback;
import androidx.paging.PagedList$Config;
import androidx.paging.PagedList$Config$Builder;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.data.me.remote.AccountManager;
import com.zhiyun.cama.data.MessagePageType;
import com.zhiyun.cama.data.PagingRequestHelper;
import com.zhiyun.cama.data.api.entity.ShareInfo;
import com.zhiyun.cama.data.database.DatabaseHelper;
import com.zhiyun.cama.data.database.model.Approval;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.cama.data.me.remote.AliyunManager;
import com.zhiyun.cama.data.me.remote.AliyunManager$OnAliyunCallback;
import com.zhiyun.cama.data.me.remote.AppealTask;
import com.zhiyun.cama.data.me.remote.CommunityManager;
import com.zhiyun.cama.data.me.remote.SharePlatformManager;
import com.zhiyun.cama.data.me.remote.SharePlatformManager$OnShareCallback;
import com.zhiyun.common.util.Times;
import com.zhiyun.net.Punish;
import d.v.a.f.b.a;
import d.v.c.v0.u.b0.b;
import d.v.c.v0.u.b0.d;
import d.v.c.v0.u.e;
import d.v.c.v0.u.f;
import d.v.c.v0.u.g;
import d.v.c.v0.u.h;
import d.v.c.v0.u.i;
import d.v.c.v0.u.j;
import d.v.c.v0.u.k;
import d.v.c.v0.u.s;
import d.v.c.v0.u.t;
import d.v.c.v0.u.v$a;
import d.v.c.v0.u.v$b;
import d.v.c.v0.u.v$c;
import d.v.c.v0.u.v$d;
import d.v.c.v0.u.v$e;
import d.v.c.v0.u.v$f;
import d.v.c.v0.u.v$g;
import d.v.c.v0.u.v$h;
import d.v.c.v0.u.v$i;
import d.v.c.v0.u.x;
import d.v.e.l.c1;
import d.v.e.l.d1;
import d.v.e.l.w1;
import java.util.List;
import java.util.concurrent.Executor;

public class v
implements x {
    private static final PagedList$Config g;
    private static volatile v h;
    private c1 a;
    private d b;
    private b c;
    private CommunityManager d;
    private final MutableLiveData e;
    private final MutableLiveData f;

    static {
        PagedList$Config$Builder pagedList$Config$Builder = new PagedList$Config$Builder();
        int n10 = 20;
        g = pagedList$Config$Builder.setPageSize(n10).setEnablePlaceholders(false).setInitialLoadSizeHint(n10).build();
    }

    private v(c1 c12, CommunityManager communityManager, b b10, d d10) {
        MutableLiveData mutableLiveData;
        this.e = mutableLiveData = new MutableLiveData();
        this.f = mutableLiveData = new MutableLiveData();
        this.a = c12;
        this.c = b10;
        this.b = d10;
        this.d = communityManager;
    }

    public static /* synthetic */ d I(v v10) {
        return v10.b;
    }

    public static /* synthetic */ c1 J(v v10) {
        return v10.a;
    }

    public static /* synthetic */ CommunityManager K(v v10) {
        return v10.d;
    }

    public static /* synthetic */ b L(v v10) {
        return v10.c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static v M(c1 c12, CommunityManager communityManager, b b10, d d10) {
        Object object = h;
        if (object != null) return h;
        object = v.class;
        synchronized (object) {
            v v10 = h;
            if (v10 != null) return h;
            h = v10 = new v(c12, communityManager, b10, d10);
            return h;
        }
    }

    private String N() {
        return d.v.a.f.c.b.N().i().getToken();
    }

    private /* synthetic */ void O(MessagePageType messagePageType) {
        b b10 = this.c;
        int n10 = d.v.a.f.c.b.N().i().getId();
        b10.b(messagePageType, n10);
    }

    private /* synthetic */ void Q(int n10) {
        this.c.c(n10);
    }

    private /* synthetic */ void S() {
        this.c.e();
    }

    private /* synthetic */ void U(int n10) {
        this.c.f(n10);
    }

    private /* synthetic */ void W() {
        MutableLiveData mutableLiveData = this.e;
        Boolean bl2 = Boolean.TRUE;
        mutableLiveData.setValue(bl2);
    }

    private /* synthetic */ void Y() {
        MutableLiveData mutableLiveData = this.f;
        Boolean bl2 = Boolean.TRUE;
        mutableLiveData.setValue(bl2);
    }

    private /* synthetic */ void a0() {
        MutableLiveData mutableLiveData = this.e;
        Boolean bl2 = Boolean.FALSE;
        mutableLiveData.setValue(bl2);
    }

    private /* synthetic */ void c0() {
        MutableLiveData mutableLiveData = this.f;
        Boolean bl2 = Boolean.FALSE;
        mutableLiveData.setValue(bl2);
    }

    private static d.v.c.v0.g e0(d.v.c.v0.u.a0.e object, DataSource$Factory object2) {
        Object object3 = g;
        Object object4 = new LivePagedListBuilder((DataSource$Factory)object2, (PagedList$Config)object3);
        object2 = ((LivePagedListBuilder)object4).setBoundaryCallback((PagedList$BoundaryCallback)object).build();
        object4 = ((d.v.c.v0.u.a0.e)object).h();
        ((d.v.c.v0.u.a0.e)object).onZeroItemsLoaded();
        object.getClass();
        t t10 = new t((d.v.c.v0.u.a0.e)object);
        object = ((d.v.c.v0.u.a0.e)object).g();
        object.getClass();
        s s10 = new s((PagingRequestHelper)object);
        object3 = new d.v.c.v0.g((LiveData)object2, (LiveData)object4, t10, s10);
        return object3;
    }

    private void f0(String string2, String string3, String string4, AliyunManager$OnAliyunCallback aliyunManager$OnAliyunCallback) {
        AliyunManager.instance().uploadHeadImgFile(string2, string3, string4, aliyunManager$OnAliyunCallback);
    }

    public void A(MessagePageType messagePageType) {
        Executor executor = this.a.a();
        j j10 = new j(this, messagePageType);
        executor.execute(j10);
    }

    public void B(int n10) {
        Executor executor = this.a.a();
        e e10 = new e(this, n10);
        executor.execute(e10);
    }

    public void C() {
        Executor executor = this.a.c();
        h h10 = new h(this);
        executor.execute(h10);
    }

    public void D(String string2, a a10) {
        d.v.c.v0.l.d.a.h(string2).h(a10);
    }

    public void E(String string2, Approval approval, Punish punish, String string3, List list, a a10) {
        if (approval != null || punish != null) {
            Executor executor = this.a.e();
            AppealTask appealTask = new AppealTask(string2, approval, punish, string3, list, a10);
            executor.execute(appealTask);
        }
    }

    public void F(a a10) {
        d.v.c.v0.l.j j10 = d.v.c.v0.l.j.a;
        String string2 = w1.a();
        j10.f(10, string2).h(a10);
    }

    public LiveData G() {
        return this.c.m();
    }

    public void H(int n10) {
        Executor executor = this.a.a();
        g g10 = new g(this, n10);
        executor.execute(g10);
    }

    public /* synthetic */ void P(MessagePageType messagePageType) {
        this.O(messagePageType);
    }

    public /* synthetic */ void R(int n10) {
        this.Q(n10);
    }

    public /* synthetic */ void T() {
        this.S();
    }

    public /* synthetic */ void V(int n10) {
        this.U(n10);
    }

    public /* synthetic */ void X() {
        this.W();
    }

    public /* synthetic */ void Z() {
        this.Y();
    }

    public void a(a a10) {
        d.v.c.v0.l.j.a.a().h(a10);
    }

    public void b(String string2, String string3, String string4, a a10) {
        d.v.c.v0.l.d d10 = d.v.c.v0.l.d.a;
        String string5 = this.N();
        d10.k(string5, string2, string3, string4).h(a10);
    }

    public /* synthetic */ void b0() {
        this.a0();
    }

    public void c(ThirdPlatform thirdPlatform, ShareInfo shareInfo, SharePlatformManager$OnShareCallback sharePlatformManager$OnShareCallback) {
        SharePlatformManager.getInstance().goShare(thirdPlatform, shareInfo, sharePlatformManager$OnShareCallback);
    }

    public void d(String string2, a a10) {
        this.d.getAppealDetail(string2).h(a10);
    }

    public /* synthetic */ void d0() {
        this.c0();
    }

    public void e(String object, int n10) {
        object = this.d.createMessageRead(n10, (String)object);
        v$f v$f = new v$f(this);
        object.h(v$f);
    }

    public void f() {
        Executor executor = this.a.c();
        i i10 = new i(this);
        executor.execute(i10);
    }

    public void g(int n10, a a10) {
        Object object = d.v.c.v0.l.d.a;
        String string2 = this.N();
        k.d d10 = object.j(n10, string2);
        object = new v$h(this, a10);
        d10.h((k.f)object);
    }

    public LiveData h() {
        return this.e;
    }

    public LiveData i() {
        return this.f;
    }

    public void j() {
        Executor executor = this.a.c();
        k k10 = new k(this);
        executor.execute(k10);
    }

    public void k(Feedback feedback, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, a a10) {
        Object object = string11;
        CharSequence charSequence = "";
        if (feedback != null) {
            d.v.c.v0.l.d d10 = d.v.c.v0.l.d.a;
            String string12 = this.N();
            object = new StringBuilder();
            int n10 = feedback.getId();
            ((StringBuilder)object).append(n10);
            ((StringBuilder)object).append((String)charSequence);
            String string13 = ((StringBuilder)object).toString();
            String string14 = string2;
            String string15 = string3;
            String string16 = string7;
            object = d10.a(string12, string13, string2, string3, string4, string5, string6, string7, string8, string9, string10);
            object.h(a10);
        } else {
            CharSequence charSequence2 = new StringBuilder();
            UserInfo userInfo = d.v.a.f.c.b.N().i();
            int n11 = userInfo.getId();
            charSequence2.append(n11);
            charSequence2.append((String)charSequence);
            String string17 = charSequence2.toString();
            String string18 = d.v.a.f.c.b.N().i().getNickname();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string11);
            charSequence2 = d1.g();
            ((StringBuilder)charSequence).append((String)charSequence2);
            String string19 = ((StringBuilder)charSequence).toString();
            String string20 = Build.MODEL;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string11);
            object = Build.VERSION.RELEASE;
            ((StringBuilder)charSequence).append((String)object);
            String string21 = ((StringBuilder)charSequence).toString();
            String string22 = w1.a();
            d.v.c.v0.l.d d11 = d.v.c.v0.l.d.a;
            String string23 = "2";
            object = d11.i(string17, string18, string2, string3, string4, string19, string5, string6, string7, string20, string21, string22, string8, string9, string10, string23);
            object.h(a10);
        }
    }

    public LiveData l() {
        c1 c12 = this.a;
        v$d v$d = new v$d(this, c12);
        return v$d.d();
    }

    public d.v.c.v0.g loadFeedbackList() {
        int n10 = v.g.pageSize;
        d.v.c.v0.u.a0.f f10 = new d.v.c.v0.u.a0.f(n10);
        DataSource$Factory dataSource$Factory = DatabaseHelper.getInstance().getDataBase().feedbackDao().loadFeedbackList();
        return v.e0(f10, dataSource$Factory);
    }

    public d.v.c.v0.g loadMessageLike() {
        int n10 = v.g.pageSize;
        d.v.c.v0.u.a0.g g10 = new d.v.c.v0.u.a0.g(n10);
        DataSource$Factory dataSource$Factory = DatabaseHelper.getInstance().getDataBase().messageDao().loadMessageLike();
        return v.e0(g10, dataSource$Factory);
    }

    public d.v.c.v0.g loadMessageSystem() {
        int n10 = v.g.pageSize;
        d.v.c.v0.u.a0.h h10 = new d.v.c.v0.u.a0.h(n10);
        DataSource$Factory dataSource$Factory = DatabaseHelper.getInstance().getDataBase().messageDao().loadMessageSystem();
        return v.e0(h10, dataSource$Factory);
    }

    public d.v.c.v0.g loadMessageViolation() {
        int n10 = v.g.pageSize;
        d.v.c.v0.u.a0.i i10 = new d.v.c.v0.u.a0.i(n10);
        DataSource$Factory dataSource$Factory = DatabaseHelper.getInstance().getDataBase().messageDao().loadMessageViolation();
        return v.e0(i10, dataSource$Factory);
    }

    public d.v.c.v0.g m(int n10) {
        int n11 = v.g.pageSize;
        d.v.c.v0.u.a0.k k10 = d.v.c.v0.u.a0.k.q(n10, n11);
        DataSource$Factory dataSource$Factory = DatabaseHelper.getInstance().getDataBase().worksDao().loadWorksWithUserId(n10);
        return v.e0(k10, dataSource$Factory);
    }

    public void n(a a10) {
        d.v.c.v0.l.d.a.c().h(a10);
    }

    public void o(a a10) {
        d.v.c.v0.l.d d10 = d.v.c.v0.l.d.a;
        String string2 = d.v.a.f.c.d.d.F().K();
        d10.d(string2, 1, 0).h(a10);
    }

    public void p(a a10) {
        Object object = d.v.c.v0.l.j.a;
        Object object2 = this.N();
        object = object.i((String)object2);
        object2 = new v$c(this, a10);
        object.h((k.f)object2);
    }

    public void q(String string2, a a10) {
        d.v.c.v0.l.d d10 = d.v.c.v0.l.d.a;
        String string3 = this.N();
        d10.m(string3, string2).h(a10);
    }

    public void r() {
        Executor executor = this.a.a();
        f f10 = new f(this);
        executor.execute(f10);
    }

    public LiveData s(int n10, boolean bl2) {
        c1 c12 = this.a;
        v$a v$a = new v$a(this, c12, bl2, n10);
        return v$a.d();
    }

    public void t(UserInfo userInfo, a a10) {
        String string2 = userInfo.getAvatar();
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) {
            string2 = d.v.a.f.c.b.N().i().getAvatar();
            userInfo.setAvatar(string2);
            AccountManager.updateUserDetail(userInfo, a10);
        } else {
            n10 = d.v.a.f.c.b.N().i().getId();
            string2 = String.valueOf(n10);
            CharSequence charSequence = new StringBuilder();
            String string3 = Times.TIME.getDate();
            charSequence.append(string3);
            charSequence.append(".jpg");
            charSequence = charSequence.toString();
            string3 = userInfo.getAvatar();
            v$i v$i = new v$i(this, userInfo, a10);
            this.f0(string2, (String)charSequence, string3, v$i);
        }
    }

    public d.v.c.v0.g u(int n10) {
        int n11 = v.g.pageSize;
        d.v.c.v0.u.a0.j j10 = d.v.c.v0.u.a0.j.q(n10, n11);
        DataSource$Factory dataSource$Factory = DatabaseHelper.getInstance().getDataBase().worksDao().loadLikesWithUserId(n10);
        return v.e0(j10, dataSource$Factory);
    }

    public void v(int n10) {
        k.d d10 = this.d.createAddReadCount(n10);
        v$g v$g = new v$g(this);
        d10.h(v$g);
    }

    public void w() {
        Executor executor = this.a.c();
        d.v.c.v0.u.d d10 = new d.v.c.v0.u.d(this);
        executor.execute(d10);
    }

    public void x(MessagePageType object) {
        Object object2 = d.v.c.v0.l.g.a;
        String string2 = this.N();
        object = ((MessagePageType)((Object)object)).getType();
        object = object2.f(string2, (String)object);
        object2 = new v$b(this);
        object.h((k.f)object2);
    }

    public void y(MessagePageType messagePageType, int n10, a a10) {
        k.d d10 = this.d.createDeleteMessage(n10);
        v$e v$e = new v$e(this, messagePageType, n10, a10);
        d10.h(v$e);
    }

    public void z(String string2, a a10) {
        d.v.c.v0.l.d d10 = d.v.c.v0.l.d.a;
        String string3 = this.N();
        d10.l(string3, string2).h(a10);
    }
}

