/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.media.MediaMetadataRetriever
 *  android.os.Build
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.webkit.URLUtil
 *  d.v.e.l.h1
 */
package d.v.c.v0.u;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.URLUtil;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.zhiyun.cama.data.PublishState;
import com.zhiyun.cama.data.database.model.PublishWorks;
import com.zhiyun.cama.data.me.PublishLogManager;
import com.zhiyun.cama.data.me.PublishLogManager$ReasonCode;
import com.zhiyun.cama.data.me.remote.AliyunManager;
import com.zhiyun.cama.data.me.remote.CommunityManager;
import com.zhiyun.cama.data.me.remote.data.KwaiShareData;
import com.zhiyun.cama.data.me.remote.data.KwaiShareData$KuaishouBean;
import com.zhiyun.cama.data.me.remote.data.KwaiShareData$OssBean;
import com.zhiyun.common.util.Devices;
import com.zhiyun.image.Images;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.c.d.d;
import d.v.c.v0.f;
import d.v.c.v0.k;
import d.v.c.v0.u.b0.b;
import d.v.c.v0.u.o;
import d.v.c.v0.u.p;
import d.v.c.v0.u.q;
import d.v.c.v0.u.r;
import d.v.c.v0.u.y$a;
import d.v.e.l.c1;
import d.v.e.l.d1;
import d.v.e.l.h1;
import d.v.e.l.k2;
import d.v.e.l.m1;
import d.v.e.l.q2.c;
import d.v.e.l.s1;
import d.v.f.i.g;
import d.v.j.e.g.z;
import d.v.v.q.h;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import m.a.a;

public class y
implements Runnable {
    private static final String f = "PublishWorksTask";
    private c1 a;
    private CommunityManager b;
    private b c;
    private z d;
    private PublishWorks e;

    public y(PublishWorks publishWorks) {
        Object object = c1.b();
        this.a = object;
        this.b = object = CommunityManager.getInstance();
        this.c = object = d.v.c.v0.u.b0.b.g();
        this.d = object = d.v.j.e.g.y.q();
        this.e = publishWorks;
    }

    public static /* synthetic */ PublishWorks a(y y10) {
        return y10.e;
    }

    public static /* synthetic */ b b(y y10) {
        return y10.c;
    }

    public static /* synthetic */ z c(y y10) {
        return y10.d;
    }

    public static /* synthetic */ void d(y y10, PublishWorks publishWorks) {
        y10.r(publishWorks);
    }

    public static /* synthetic */ void e(y y10) {
        y10.t();
    }

    private static String f(String string2) {
        JsonObject jsonObject = new JsonObject();
        CharSequence charSequence = new StringBuilder();
        String string3 = Build.BRAND;
        ((StringBuilder)charSequence).append(string3);
        string3 = "";
        ((StringBuilder)charSequence).append(string3);
        charSequence = ((StringBuilder)charSequence).toString();
        jsonObject.addProperty("brand", (String)charSequence);
        charSequence = new StringBuilder();
        String string4 = Build.MODEL;
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append(string3);
        charSequence = ((StringBuilder)charSequence).toString();
        jsonObject.addProperty("model", (String)charSequence);
        jsonObject.addProperty("reason", string2);
        return jsonObject.toString();
    }

    private String g(List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            int n10;
            StringBuilder stringBuilder = new StringBuilder();
            Iterator iterator2 = list.iterator();
            while ((n10 = iterator2.hasNext()) != 0) {
                int n11;
                String string2 = (String)iterator2.next();
                stringBuilder.append(string2);
                n10 = list.indexOf(string2);
                if (n10 == (n11 = list.size() + -1)) continue;
                string2 = ",";
                stringBuilder.append(string2);
            }
            return stringBuilder.toString();
        }
        return null;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Bitmap h(String string2) {
        Throwable throwable2222222;
        MediaMetadataRetriever mediaMetadataRetriever;
        block4: {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            HashMap hashMap = new HashMap();
            mediaMetadataRetriever.setDataSource(string2, hashMap);
            string2 = mediaMetadataRetriever.getFrameAtTime();
            {
                catch (Throwable throwable2222222) {
                    break block4;
                }
                catch (IllegalArgumentException illegalArgumentException) {}
                {
                    illegalArgumentException.printStackTrace();
                }
                mediaMetadataRetriever.release();
                return null;
            }
            mediaMetadataRetriever.release();
            return string2;
        }
        mediaMetadataRetriever.release();
        throw throwable2222222;
    }

    private String i(int n10) {
        return g.m(d.v.e.f.a().c(), n10);
    }

    public static /* synthetic */ void j(String string2, String string3, PublishLogManager$ReasonCode publishLogManager$ReasonCode, PublishWorks object) {
        String string4 = ((PublishWorks)object).getSmallImgUrl();
        object = ((PublishWorks)object).getFileUrl();
        y.y(string2, string3, publishLogManager$ReasonCode, string4, (String)object);
    }

    public static /* synthetic */ void k() {
        d.v.a.f.c.d.d.F().z(1);
    }

    private /* synthetic */ void l(int n10, int n11) {
        PublishWorks publishWorks = this.e;
        float f10 = n10;
        float f11 = (float)(100 - n10) / 100.0f;
        float f12 = n11;
        n10 = (int)(f10 + (f11 *= f12));
        publishWorks.setPercent(n10);
        PublishWorks publishWorks2 = this.e;
        this.r(publishWorks2);
    }

    private /* synthetic */ void o() {
        Object object = k2.y("publish");
        CharSequence charSequence = new StringBuilder();
        long l10 = System.currentTimeMillis();
        charSequence.append(l10);
        charSequence.append(".mp4");
        charSequence = charSequence.toString();
        Object object2 = new File((File)object, (String)charSequence);
        object2 = ((File)object2).getAbsolutePath();
        object = this.e.getFilePath();
        int n10 = this.e.getResolution();
        y$a y$a = new y$a(this);
        h.n0((String)object, (String)object2, n10, y$a);
    }

    private void q(String string2, String string3, PublishLogManager$ReasonCode publishLogManager$ReasonCode, PublishWorks publishWorks) {
        Object object = PublishState.STATE_FAILED;
        publishWorks.setState((PublishState)((Object)object));
        this.c.r(publishWorks);
        object = this.d;
        int n10 = 4;
        object.c(n10);
        object = publishWorks.getTranscodingPath();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            object = publishWorks.getTranscodingPath();
            s1.h((String)object);
        }
        object = this.a.c();
        r r10 = new r(string2, string3, publishLogManager$ReasonCode, publishWorks);
        object.execute(r10);
    }

    private void r(PublishWorks publishWorks) {
        PublishState publishState = PublishState.STATE_PUBLISHING;
        publishWorks.setState(publishState);
        this.c.r(publishWorks);
    }

    private void s(PublishWorks publishWorks) {
        Object object = PublishState.STATE_SUCCESS;
        publishWorks.setState((PublishState)((Object)object));
        this.c.r(publishWorks);
        object = this.a.c();
        o o10 = o.a;
        object.execute(o10);
        object = this.c;
        ((b)object).a(publishWorks);
        long l10 = 200L;
        try {
            Thread.sleep(l10);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        this.c.e();
        this.d.a();
        d.v.c.v0.f.a().f();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void t() {
        String string2;
        int n10;
        String string3;
        Object object;
        y y10;
        block32: {
            void var3_28;
            int n11;
            Object object2;
            block33: {
                int n12;
                String string4;
                int n13;
                int n14;
                String string5;
                Object object3;
                Object object4;
                String string6;
                void var14_62;
                String string7;
                int n15;
                Object object5;
                Object object6;
                int n16;
                void var12_44;
                y10 = this;
                object2 = "zhiyundata";
                String string8 = "video";
                object = "titlePage";
                int n17 = this.e.getWorksId();
                string3 = String.valueOf(n17);
                n11 = d.v.a.f.c.d.d.F().L().getId();
                Object object7 = String.valueOf(n11);
                Object object8 = new StringBuilder();
                long l10 = System.currentTimeMillis();
                String string9 = m1.h(l10);
                object8.append(string9);
                object8.append(".jpg");
                object8 = object8.toString();
                String string10 = this.e.getTranscodingPath();
                boolean bl2 = TextUtils.isEmpty((CharSequence)string10);
                if (bl2) {
                    String string11 = this.e.getFilePath();
                } else {
                    String string12 = this.e.getTranscodingPath();
                }
                String string13 = y10.e.getCoverPath();
                int n18 = TextUtils.isEmpty((CharSequence)string13);
                if (n18 != 0) {
                    void var14_53;
                    try {
                        n18 = URLUtil.isHttpsUrl((String)var12_44);
                        n16 = 600;
                        if (n18 == 0 && (n18 = URLUtil.isHttpUrl((String)var12_44)) == 0) {
                            d.v.e.f f10 = d.v.e.f.a();
                            Context context = f10.c();
                            Bitmap bitmap2 = Images.n(context, var12_44);
                            bitmap2 = h1.z((Bitmap)bitmap2, (int)n16);
                        } else {
                            Bitmap bitmap = y.h((String)var12_44);
                            h1.z((Bitmap)bitmap, (int)n16);
                        }
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                        StringBuilder stringBuilder = new StringBuilder();
                        object = y10.i(2131952791);
                        stringBuilder.append((String)object);
                        String string14 = exception.toString();
                        stringBuilder.append(string14);
                        string14 = stringBuilder.toString();
                        PublishLogManager$ReasonCode publishLogManager$ReasonCode = PublishLogManager$ReasonCode.OTHER;
                        object = y10.e;
                        y10.q(string3, string14, publishLogManager$ReasonCode, (PublishWorks)object);
                        return;
                    }
                    object6 = k2.Q();
                    object5 = new File((File)object6, (String)object8);
                    object6 = Bitmap.CompressFormat.JPEG;
                    n15 = 100;
                    String string15 = ((File)object5).getPath();
                    n18 = h1.D((Bitmap)var14_53, (Bitmap.CompressFormat)object6, (int)n15, (String)string15);
                    if (n18 == 0) {
                        PublishWorks publishWorks = y10.e;
                        object5 = ((File)object5).getPath();
                        publishWorks.setCoverPath((String)object5);
                    }
                }
                if ((n18 = TextUtils.isEmpty((CharSequence)(string7 = y10.e.getCoverPath()))) != 0) {
                    object2 = y10.i(2131952794);
                    PublishLogManager$ReasonCode publishLogManager$ReasonCode = PublishLogManager$ReasonCode.OTHER;
                    object = y10.e;
                    y10.q(string3, (String)object2, publishLogManager$ReasonCode, (PublishWorks)object);
                    return;
                }
                String string16 = y10.e.getSmallImgUrl();
                n16 = (int)(TextUtils.isEmpty((CharSequence)string16) ? 1 : 0);
                object6 = null;
                n15 = 2131952788;
                int n19 = 2131952789;
                if (n16 != 0) {
                    try {
                        AliyunManager aliyunManager = AliyunManager.instance();
                        object8 = aliyunManager.getAliyunObjectKey((String)object7, string3, (String)object8);
                        PublishWorks publishWorks = y10.e;
                        publishWorks.setCoverObjectKey((String)object8);
                        AliyunManager aliyunManager2 = AliyunManager.instance();
                        object5 = y10.e;
                        object5 = ((PublishWorks)object5).getCoverPath();
                        String string17 = aliyunManager2.uploadShareFileSync((String)object8, (String)object5, null);
                        object = y10.e;
                        ((PublishWorks)object).setSmallImgUrl(string17);
                    }
                    catch (ServiceException serviceException) {
                        serviceException.printStackTrace();
                        String string18 = y10.w((String)object, n15, serviceException);
                        PublishLogManager$ReasonCode publishLogManager$ReasonCode = PublishLogManager$ReasonCode.UPLOAD_IMAGE_FAILED;
                        object = y10.e;
                        y10.q(string3, string18, publishLogManager$ReasonCode, (PublishWorks)object);
                        return;
                    }
                    catch (ClientException clientException) {
                        clientException.printStackTrace();
                        String string19 = y10.v((String)object, n19, clientException);
                        PublishLogManager$ReasonCode publishLogManager$ReasonCode = PublishLogManager$ReasonCode.NETWORK_ERROR;
                        object = y10.e;
                        y10.q(string3, string19, publishLogManager$ReasonCode, (PublishWorks)object);
                        return;
                    }
                }
                object = var14_62;
                int n20 = (int)(URLUtil.isHttpsUrl((String)var12_44) ? 1 : 0);
                if (n20 != 0 || (n20 = URLUtil.isHttpUrl((String)var12_44)) != 0) {
                    object8 = y10.e;
                    object8.setFileUrl((String)var12_44);
                }
                object8 = y10.e.getFileUrl();
                n18 = (int)(TextUtils.isEmpty((CharSequence)object8) ? 1 : 0);
                n16 = 0;
                object5 = null;
                if (n18 != 0 || (n18 = (int)(object8.startsWith(string6 = "http") ? 1 : 0)) == 0) {
                    n18 = (int)(TextUtils.isEmpty((CharSequence)object8) ? 1 : 0);
                    if (n18 != 0) {
                        void var14_70;
                        object8 = new StringBuilder();
                        long l11 = System.currentTimeMillis();
                        long l12 = 1000L;
                        String string20 = m1.h(l11 += l12);
                        object8.append(string20);
                        object8.append(".");
                        String string21 = s1.J(y10.e.getFilePath());
                        n18 = (int)(TextUtils.isEmpty((CharSequence)string21) ? 1 : 0);
                        if (n18 != 0) {
                            String string22 = "jpg";
                        } else {
                            String string23 = s1.J(y10.e.getFilePath());
                        }
                        object8.append((String)var14_70);
                        object8 = object8.toString();
                        PublishWorks publishWorks = y10.e;
                        publishWorks.setFileUrl((String)object8);
                    }
                    try {
                        AliyunManager aliyunManager = AliyunManager.instance();
                        object8 = aliyunManager.getAliyunObjectKey((String)object7, string3, (String)object8);
                        PublishWorks publishWorks = y10.e;
                        publishWorks.setFileObjectKey((String)object8);
                        PublishWorks publishWorks2 = y10.e;
                        String string24 = publishWorks2.getTranscodingPath();
                        n18 = (int)(TextUtils.isEmpty((CharSequence)string24) ? 1 : 0);
                        if (n18 != 0) {
                            n18 = 0;
                            Object var14_77 = null;
                        } else {
                            n18 = 30;
                        }
                        AliyunManager aliyunManager3 = AliyunManager.instance();
                        q q10 = new q(y10, n18);
                        object8 = aliyunManager3.uploadShareResumeFileSync((String)object8, (String)var12_44, q10);
                        PublishWorks publishWorks3 = y10.e;
                        publishWorks3.setFileUrl((String)object8);
                    }
                    catch (ServiceException serviceException) {
                        serviceException.printStackTrace();
                        String string25 = y10.w(string8, n15, serviceException);
                        PublishLogManager$ReasonCode publishLogManager$ReasonCode = PublishLogManager$ReasonCode.UPLOAD_VIDEO_FAILED;
                        object = y10.e;
                        y10.q(string3, string25, publishLogManager$ReasonCode, (PublishWorks)object);
                        return;
                    }
                    catch (ClientException clientException) {
                        clientException.printStackTrace();
                        String string26 = y10.v(string8, n19, clientException);
                        PublishLogManager$ReasonCode publishLogManager$ReasonCode = PublishLogManager$ReasonCode.NETWORK_ERROR;
                        object = y10.e;
                        y10.q(string3, string26, publishLogManager$ReasonCode, (PublishWorks)object);
                        return;
                    }
                }
                Object[] objectArray = object8;
                object8 = y10.e.getTranscodingPath();
                n20 = TextUtils.isEmpty((CharSequence)object8);
                if (n20 == 0) {
                    object8 = y10.e.getTranscodingPath();
                    s1.h((String)object8);
                }
                String[] stringArray = new String[2];
                stringArray[0] = object;
                n20 = 1;
                stringArray[n20] = objectArray;
                int n21 = 2131952793;
                try {
                    PublishWorks publishWorks = y10.e;
                    n18 = publishWorks.getShareToKwai();
                    if (n18 == n20) {
                        KwaiShareData kwaiShareData = new KwaiShareData();
                        object6 = "kuaishou";
                        kwaiShareData.setPlatform((String)object6);
                        object6 = y10.e;
                        object6 = ((PublishWorks)object6).getKwaiToken();
                        kwaiShareData.setAccess_token((String)object6);
                        object6 = "ks680887970458072564";
                        kwaiShareData.setAppid((String)object6);
                        n11 = Integer.parseInt((String)object7);
                        kwaiShareData.setUserid(n11);
                        kwaiShareData.setFile_url((String)objectArray);
                        object7 = "android";
                        kwaiShareData.setDevice_platform((String)object7);
                        object6 = y10.e;
                        object6 = ((PublishWorks)object6).getFileObjectKey();
                        object7 = new KwaiShareData$OssBean((String)object2, (String)object6, 0);
                        kwaiShareData.setOss((KwaiShareData$OssBean)object7);
                        object7 = new KwaiShareData$KuaishouBean();
                        object6 = "...";
                        ((KwaiShareData$KuaishouBean)object7).setCaption((String)object6);
                        ((KwaiShareData$KuaishouBean)object7).setCover((String)object);
                        object6 = "NOT_SPHERICAL_VIDEO";
                        ((KwaiShareData$KuaishouBean)object7).setStereo_type((String)object6);
                        object4 = y10.e;
                        object4 = ((PublishWorks)object4).getCoverObjectKey();
                        object6 = new KwaiShareData$OssBean((String)object2, (String)object4, 0);
                        ((KwaiShareData$KuaishouBean)object7).setOss((KwaiShareData$OssBean)object6);
                        kwaiShareData.setKuaishou((KwaiShareData$KuaishouBean)object7);
                        long l13 = System.currentTimeMillis();
                        kwaiShareData.setTs(l13);
                        object2 = KwaiShareData.class;
                        object2 = d.v.e.l.q2.c.h(object2, kwaiShareData);
                        object7 = "json = %s";
                        Object[] objectArray2 = new Object[n20];
                        objectArray2[0] = object2;
                        m.a.a.b((String)object7, objectArray2);
                        object2 = ((String)object2).getBytes();
                        object2 = Base64.encodeToString((byte[])object2, (int)0);
                        object7 = "jsonBase64 = %s";
                        object8 = new Object[n20];
                        object8[0] = object2;
                        m.a.a.b((String)object7, object8);
                        object3 = object2;
                    } else {
                        object3 = null;
                    }
                    object7 = y10.b;
                    object2 = y10.e;
                    string5 = ((PublishWorks)object2).getWorksDes();
                    object2 = y10.e;
                    object5 = ((PublishWorks)object2).getFileDuration();
                    object2 = y10.e;
                    object2 = ((PublishWorks)object2).getTags();
                    object6 = y10.g((List)object2);
                    object2 = y10.e;
                    object2 = ((PublishWorks)object2).getDevices();
                    object4 = y10.g((List)object2);
                    object2 = y10.e;
                    n19 = ((PublishWorks)object2).getActiveId();
                    object2 = y10.e;
                    n14 = ((PublishWorks)object2).getThemeId();
                    object2 = y10.e;
                    n13 = ((PublishWorks)object2).getCircleId();
                    object2 = y10.e;
                    object2 = ((PublishWorks)object2).getAddress();
                    object8 = y10.e;
                    string4 = object8.getArchive();
                    object8 = y10.e;
                    n12 = object8.getShareToKwai();
                    object8 = string3;
                }
                catch (Exception exception) {
                    n10 = n21;
                    break block32;
                }
                try {
                    object2 = ((CommunityManager)object7).createPublishWorks(string3, stringArray, string5, (String)object5, (String)object6, (String)object4, n19, n14, n13, (String)object2, string4, n12, (String)object3);
                    object2 = object2.execute();
                    object2 = ((k.r)object2).a();
                    object2 = (BaseEntity)object2;
                    if (object2 == null || (n11 = ((BaseEntity)object2).errcode) != 0 && (n20 = 10305) != n11) break block33;
                    object2 = y10.e;
                }
                catch (Exception exception) {
                    n10 = 2131952793;
                    break block32;
                }
                n11 = Integer.parseInt(string3);
                long l14 = n11;
                object7 = k.a(l14);
                ((PublishWorks)object2).setPostUrl((String)object7);
                y10.e.setSmallImgUrl((String)object);
                y10.e.setFileUrl((String)objectArray);
                object2 = y10.e;
                y10.s((PublishWorks)object2);
                object2 = y10.e.getConfig();
                boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
                if (bl3) return;
                object2 = y10.e.getConfig();
                y10.u(string3, (String)object2);
                return;
            }
            int n22 = 2131952793;
            String string27 = y10.i(n22);
            if (object2 != null) {
                object = d.v.a.f.c.b.N();
                n11 = ((BaseEntity)object2).errcode;
                ((d.v.a.f.c.b)object).g(n11);
                object = new StringBuilder();
                ((StringBuilder)object).append(string27);
                String string28 = " ";
                ((StringBuilder)object).append(string28);
                n11 = ((BaseEntity)object2).errcode;
                ((StringBuilder)object).append(n11);
                ((StringBuilder)object).append(string28);
                object2 = ((BaseEntity)object2).errmsg;
                ((StringBuilder)object).append((String)object2);
                String string29 = ((StringBuilder)object).toString();
            }
            object2 = PublishLogManager$ReasonCode.API_FAILED;
            object = y10.e;
            y10.q(string3, (String)var3_28, (PublishLogManager$ReasonCode)((Object)object2), (PublishWorks)object);
            return;
        }
        ((Throwable)((Object)string2)).printStackTrace();
        object = new StringBuilder();
        String string30 = y10.i(n10);
        ((StringBuilder)object).append(string30);
        string2 = ((Throwable)((Object)string2)).toString();
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        PublishLogManager$ReasonCode publishLogManager$ReasonCode = PublishLogManager$ReasonCode.NETWORK_ERROR;
        object = y10.e;
        y10.q(string3, string2, publishLogManager$ReasonCode, (PublishWorks)object);
    }

    private void u(String object, String string2) {
        CommunityManager communityManager = this.b;
        object = communityManager.createSaveTemplateConfig((String)object, string2);
        try {
            object.execute();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private String v(String charSequence, int n10, ClientException object) {
        JsonObject jsonObject = new JsonObject();
        Boolean bl2 = ((ClientException)object).isCanceledException();
        jsonObject.addProperty("isCanceledException", bl2);
        object = ((ClientException)object).getMessage();
        jsonObject.addProperty("Message", (String)object);
        object = new JsonObject();
        ((JsonObject)object).addProperty("type", (String)charSequence);
        ((JsonObject)object).add("oss", jsonObject);
        charSequence = new StringBuilder();
        String string2 = this.i(n10);
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(", ");
        string2 = ((JsonElement)object).toString();
        ((StringBuilder)charSequence).append(string2);
        return ((StringBuilder)charSequence).toString();
    }

    private String w(String charSequence, int n10, ServiceException object) {
        JsonObject jsonObject = new JsonObject();
        Object object2 = ((ServiceException)object).getHostId();
        jsonObject.addProperty("hostId", (String)object2);
        object2 = ((ServiceException)object).getRequestId();
        jsonObject.addProperty("requestId", (String)object2);
        object2 = ((ServiceException)object).getStatusCode();
        jsonObject.addProperty("statusCode", (Number)object2);
        object2 = ((ServiceException)object).getErrorCode();
        jsonObject.addProperty("errorCode", (String)object2);
        object = ((Throwable)object).getMessage();
        jsonObject.addProperty("Message", (String)object);
        object = new JsonObject();
        ((JsonObject)object).addProperty("type", (String)charSequence);
        ((JsonObject)object).add("oss", jsonObject);
        charSequence = new StringBuilder();
        String string2 = this.i(n10);
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(", ");
        string2 = ((JsonElement)object).toString();
        ((StringBuilder)charSequence).append(string2);
        return ((StringBuilder)charSequence).toString();
    }

    public static void x(String string2, PublishLogManager$ReasonCode publishLogManager$ReasonCode) {
        String string3 = "";
        y.y(null, string2, publishLogManager$ReasonCode, string3, string3);
    }

    public static void y(String string2, String object, PublishLogManager$ReasonCode publishLogManager$ReasonCode, String string3, String string4) {
        String string5 = y.f((String)object);
        object = d.v.a.f.c.d.d.F();
        boolean n10 = ((d)object).Q();
        if (n10) {
            int n11 = d.v.a.f.c.d.d.F().L().getId();
            object = String.valueOf(n11);
        } else {
            boolean bl2 = false;
            object = null;
        }
        Object object2 = object;
        String string6 = Devices.k(d.v.e.f.a().c());
        String string7 = d1.g();
        PublishLogManager.d().b((String)object2, string2, string6, string5, publishLogManager$ReasonCode, string3, string4, string7);
    }

    public /* synthetic */ void m(int n10, int n11) {
        this.l(n10, n11);
    }

    public /* synthetic */ void p() {
        this.o();
    }

    public void run() {
        boolean bl2;
        Object object = this.e;
        this.r((PublishWorks)object);
        object = this.e.getFileUrl();
        Object object2 = this.e;
        int n10 = ((PublishWorks)object2).getResolution();
        if (n10 != 0 && ((n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0)) != 0 || (bl2 = ((String)object).startsWith((String)(object2 = "http"))))) {
            object = this.a.c();
            object2 = new p(this);
            object.execute((Runnable)object2);
        } else {
            this.t();
        }
    }
}

