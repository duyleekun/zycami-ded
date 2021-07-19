/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.quvideo.mobile.external.platform.uploader;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.quvideo.mobile.external.platform.uploader.OooO;
import com.quvideo.mobile.external.platform.uploader.OooO$OooO0OO;
import com.quvideo.mobile.external.platform.uploader.OooO00o;
import com.quvideo.mobile.external.platform.uploader.OooO0O0$a;
import com.quvideo.mobile.external.platform.uploader.OooO0O0$b;
import com.quvideo.mobile.external.platform.uploader.OooO0O0$c;
import com.quvideo.mobile.external.platform.uploader.OooO0O0$d;
import com.quvideo.mobile.external.platform.uploader.OooO0O0$e;
import com.quvideo.mobile.external.platform.uploader.db.OooO0OO;
import java.io.File;

public class OooO0O0
extends OooO00o {
    private volatile long OooOO0O = 0L;
    private volatile long OooOO0o = 524288L;
    private volatile OSSAsyncTask OooOOO = null;
    private volatile OSSClient OooOOO0;
    private volatile OSSFederationToken OooOOOO;
    private ClientConfiguration OooOOOo;
    private boolean OooOOo0 = false;

    public OooO0O0(String object) {
        super((String)object);
        this.OooOOOo = object = new ClientConfiguration();
        int n10 = 60000;
        ((ClientConfiguration)object).setConnectionTimeout(n10);
        this.OooOOOo.setSocketTimeout(n10);
        this.OooOOOo.setMaxConcurrentRequest(1);
        this.OooOOOo.setMaxErrorRetry(2);
    }

    public static /* synthetic */ OSSFederationToken OooO00o(OooO0O0 oooO0O0) {
        return oooO0O0.OooOOOO;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void OooO00o(long l10, long l11) {
        synchronized (this) {
            Object object = this.OooO0o;
            if (object == 0 && (object = this.OooO) == 0) {
                long l12;
                long l13 = this.OooOO0O;
                long l14 = l13 - l10;
                object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object < 0 && (object = (Object)((l12 = (l13 = this.OooOO0O) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0) {
                    l13 = this.OooOO0O;
                    long l15 = 100;
                    l13 *= l15;
                    object = (int)(l13 /= l11);
                    this.OooOO0O = l10;
                    l10 *= l15;
                    int n10 = (int)(l10 /= l11);
                    if (object != n10) {
                        this.OooO0Oo = n10;
                        com.quvideo.mobile.external.platform.uploader.listener.OooO0O0 oooO0O0 = this.OooOO0;
                        String string2 = this.OooO0O0;
                        int n11 = this.OooO0Oo;
                        oooO0O0.OooO00o(string2, n11);
                    }
                }
                return;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void OooO00o(ClientException object, ServiceException object2) {
        synchronized (this) {
            block11: {
                int n10;
                String string2;
                CharSequence charSequence;
                String string3;
                int n11;
                int n12;
                long l10;
                String string4;
                boolean bl2;
                block14: {
                    block13: {
                        block12: {
                            bl2 = this.OooO0o;
                            if (bl2 || (bl2 = this.OooO)) break block11;
                            string4 = this.OooO0O0;
                            int n13 = 4;
                            l10 = this.OooO0O0(string4, n13);
                            n12 = 7000;
                            boolean bl3 = this.OooO0o();
                            n11 = 7001;
                            if (!bl3) {
                                n12 = n11;
                            }
                            string3 = "";
                            if (charSequence == null) break block12;
                            string3 = ((ServiceException)((Object)charSequence)).getErrorCode();
                            string2 = ((ServiceException)((Object)charSequence)).getRequestId();
                            String string5 = ((ServiceException)((Object)charSequence)).getHostId();
                            String string6 = ((ServiceException)((Object)charSequence)).getRawMessage();
                            boolean bl4 = TextUtils.isEmpty((CharSequence)string3);
                            if (bl4 && (bl4 = TextUtils.isEmpty((CharSequence)string6)) && object != null) break block13;
                            n12 = this.OooO0Oo(string3);
                            StringBuilder stringBuilder = new StringBuilder();
                            String string7 = "[timeoffset:";
                            stringBuilder.append(string7);
                            stringBuilder.append(l10);
                            string7 = "][aliErrcode=";
                            stringBuilder.append(string7);
                            String string8 = stringBuilder.toString();
                            StringBuilder stringBuilder2 = new StringBuilder(string8);
                            stringBuilder2.append(string3);
                            string3 = "][reqID=";
                            stringBuilder2.append(string3);
                            stringBuilder2.append(string2);
                            string3 = "][hostid=";
                            stringBuilder2.append(string3);
                            stringBuilder2.append(string5);
                            string3 = "][rawMsg=";
                            stringBuilder2.append(string3);
                            stringBuilder2.append(string6);
                            string3 = "][expMsg=";
                            stringBuilder2.append(string3);
                            charSequence = ((Throwable)((Object)charSequence)).getMessage();
                            stringBuilder2.append((String)charSequence);
                            charSequence = "]";
                            stringBuilder2.append((String)charSequence);
                            string3 = stringBuilder2.toString();
                            break block14;
                        }
                        if (object == null) break block14;
                    }
                    string3 = ((ClientException)object).getMessage();
                }
                charSequence = new StringBuilder();
                string2 = ":process:";
                ((StringBuilder)charSequence).append(string2);
                int n14 = this.OooO0Oo;
                ((StringBuilder)charSequence).append(n14);
                string2 = ":[timeoffset:";
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append(l10);
                string4 = "]";
                ((StringBuilder)charSequence).append(string4);
                ((StringBuilder)charSequence).append(string3);
                charSequence = ((StringBuilder)charSequence).toString();
                if (n12 == n11) {
                    charSequence = "network is not available";
                }
                if (!((bl2 = this.OooO0O0(n12)) || object != null && (n10 = this.OooO00o((String)(object = ((String)charSequence).toLowerCase()))) != 0)) {
                    n10 = 0;
                    object = null;
                } else {
                    n10 = 1;
                }
                bl2 = this.OooO0oO;
                if (!bl2 && n10 != 0) {
                    this.OooO00o(n12, (String)charSequence);
                    return;
                }
                object = this.OooO0o0;
                string4 = this.OooO0O0;
                ((OooO0OO)object).OooO00o(string4);
                object = this.OooOO0;
                string4 = this.OooO0O0;
                object.OooO00o(string4, n12, (String)charSequence);
                n10 = this.OooO0oO;
                if (n10 != 0) {
                    n10 = this.OooO0oo;
                    this.OooO00o(n10, n12);
                }
                return;
            }
            return;
        }
    }

    public static /* synthetic */ void OooO00o(OooO0O0 oooO0O0, long l10, long l11) {
        oooO0O0.OooO00o(l10, l11);
    }

    public static /* synthetic */ void OooO00o(OooO0O0 oooO0O0, ClientException clientException, ServiceException serviceException) {
        oooO0O0.OooO00o(clientException, serviceException);
    }

    public static /* synthetic */ void OooO0O0(OooO0O0 oooO0O0) {
        oooO0O0.OooOOO0();
    }

    private boolean OooO0O0(int n10) {
        int n11 = 7003;
        return n10 == n11 || n10 == (n11 = 7004) || n10 == (n11 = 7005) || n10 == (n11 = 7006) || n10 == (n11 = 7011) || n10 == (n11 = 7013) || n10 == (n11 = 7014) || n10 == (n11 = 7015) || n10 == (n11 = 7016) || n10 == (n11 = 7017) || n10 == n11 || n10 == (n11 = 7020) || n10 == (n11 = 7021) || n10 == n11 || n10 == (n11 = 7025);
        {
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int OooO0Oo(String string2) {
        String string3;
        if (string2 == null) return 7000;
        boolean bl2 = (string2 = string2.trim().toLowerCase()).equals(string3 = "requesttimeout");
        if (bl2) {
            return 7002;
        }
        string3 = "securitytokenexpired";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7003;
        }
        string3 = "invalidsecuritytoken";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7025;
        }
        string3 = "accessdenied";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7004;
        }
        string3 = "bucketalreadyexists";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7005;
        }
        string3 = "bucketnotempty";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7006;
        }
        string3 = "entitytoolarge";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7007;
        }
        string3 = "entitytoosmall";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7008;
        }
        string3 = "fielditemtoolong";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7009;
        }
        string3 = "filepartinterity";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7010;
        }
        string3 = "filepartnotexist";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7011;
        }
        string3 = "filepartstale";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7012;
        }
        string3 = "invalidaccesskeyid";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7013;
        }
        string3 = "invalidbucketname";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7014;
        }
        string3 = "invaliddigest";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7015;
        }
        string3 = "invalidobjectname";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7016;
        }
        string3 = "invalidpart";
        bl2 = string2.equals(string3);
        if (bl2 || (bl2 = string2.equals(string3 = "invalidpartorder"))) {
            return 7017;
        }
        string3 = "internalerror";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7019;
        }
        string3 = "nosuchbucket";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7020;
        }
        string3 = "nosuchkey";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7021;
        }
        string3 = "nosuchupload";
        bl2 = string2.equals(string3);
        if (bl2) {
            return 7022;
        }
        string3 = "requesttimetooskewed";
        int n10 = (int)(string2.equals(string3) ? 1 : 0);
        if (n10 == 0) return 7000;
        return 7023;
    }

    private ObjectMetadata OooOO0O() {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("video/mp4");
        return objectMetadata;
    }

    private OSSCredentialProvider OooOO0o() {
        OooO0O0$a oooO0O0$a = new OooO0O0$a(this);
        return oooO0O0$a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void OooOOO0() {
        synchronized (this) {
            boolean bl2 = this.OooO0o;
            if (!bl2 && !(bl2 = this.OooO)) {
                Object object = this.OooO0o0;
                String string2 = this.OooO0O0;
                ((OooO0OO)object).OooO00o(string2);
                object = this.OooOO0;
                string2 = this.OooO0O0;
                Object object2 = this.OooO0OO;
                object2 = ((OooO)object2).OooO0oO;
                object2 = ((OooO$OooO0OO)object2).OooOO0;
                object.OooO00o(string2, (String)object2);
                return;
            }
            return;
        }
    }

    public void OooO() {
        boolean bl2;
        this.OooO0o = bl2 = true;
        OSSAsyncTask oSSAsyncTask = this.OooOOO;
        if (oSSAsyncTask != null) {
            oSSAsyncTask = this.OooOOO;
            oSSAsyncTask.cancel();
        }
    }

    public String OooO0OO() {
        return "AliError";
    }

    public void OooO0o0() {
        Object object = this.OooOOO0;
        if (object != null) {
            this.OooOOO0 = null;
        }
        if ((object = this.OooOOO) != null) {
            this.OooOOO = null;
        }
    }

    public void OooO0oo() {
        Object object;
        Object object2 = this.OooO0OO.OooO0oO.OooO0OO;
        String string2 = this.OooO0OO.OooO0oO.OooO0Oo;
        Object object3 = this.OooO0OO.OooO0oO.OooO0o0;
        long l10 = this.OooO0OO.OooO0oO.OooO0O0;
        Object object4 = object;
        object = new OSSFederationToken((String)object2, string2, (String)object3, l10);
        this.OooOOOO = object;
        object2 = this.OooO00o;
        string2 = this.OooO0OO.OooO0oO.OooO0o;
        object3 = this.OooOO0o();
        Object object5 = this.OooOOOo;
        this.OooOOO0 = object4 = new OSSClient((Context)object2, string2, (OSSCredentialProvider)object3, (ClientConfiguration)object5);
        boolean bl2 = this.OooOOo0;
        object2 = ".mp4";
        string2 = null;
        if (!bl2) {
            object3 = this.OooO0OO.OooO0oO.OooO;
            object5 = this.OooO0OO.OooO0oO.OooO0oO;
            String string3 = this.OooO0OO.OooO00o;
            object = this.OooO0Oo();
            object4 = new ResumableUploadRequest((String)object3, (String)object5, string3, (String)object);
            object3 = new OooO0O0$e(this, null);
            ((MultipartUploadRequest)object4).setProgressCallback((OSSProgressCallback)object3);
            object3 = Boolean.FALSE;
            ((ResumableUploadRequest)object4).setDeleteUploadOnCancelling((Boolean)object3);
            object3 = this.OooO0OO.OooO00o;
            boolean bl3 = ((String)object3).endsWith((String)object2);
            if (bl3) {
                object2 = this.OooOO0O();
                ((MultipartUploadRequest)object4).setMetadata((ObjectMetadata)object2);
            }
            object2 = this.OooOOO0;
            object3 = new OooO0O0$d(this, null);
            object4 = ((OSSClient)object2).asyncResumableUpload((ResumableUploadRequest)object4, (OSSCompletedCallback)object3);
        } else {
            object3 = this.OooO0OO.OooO0oO.OooO;
            object5 = this.OooO0OO.OooO0oO.OooO0oO;
            String string4 = this.OooO0OO.OooO00o;
            object4 = new PutObjectRequest((String)object3, (String)object5, string4);
            object3 = new OooO0O0$c(this, null);
            ((PutObjectRequest)object4).setProgressCallback((OSSProgressCallback)object3);
            object3 = this.OooO0OO.OooO00o;
            boolean bl4 = ((String)object3).endsWith((String)object2);
            if (bl4) {
                object2 = this.OooOO0O();
                ((PutObjectRequest)object4).setMetadata((ObjectMetadata)object2);
            }
            object2 = this.OooOOO0;
            object3 = new OooO0O0$b(this, null);
            object4 = ((OSSClient)object2).asyncPutObject((PutObjectRequest)object4, (OSSCompletedCallback)object3);
        }
        this.OooOOO = object4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void OooOO0() {
        long l10 = 0L;
        try {
            long l11;
            long l12;
            long l13;
            this.OooOO0O = l10;
            Object object = this.OooO0OO;
            object = ((OooO)object).OooO00o;
            Object object2 = new File((String)object);
            int n10 = ((File)object2).exists();
            int n11 = 1;
            if (n10 != 0 && (l13 = (l12 = (l10 = ((File)object2).length()) - (l11 = this.OooOO0o)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) < 0) {
                this.OooOOo0 = n11;
            }
            this.OooO00o();
            object2 = this.OooO0O0;
            n10 = 4;
            l13 = this.OooO00o((String)object2, n10);
            if (l13 == false) {
                object2 = this.OooO0O0;
                this.OooO00o((String)object2, n11, n10);
            }
            object2 = this.OooO0O0;
            this.OooO0O0((String)object2);
            this.OooO0oo();
            return;
        }
        catch (Exception exception) {
            com.quvideo.mobile.external.platform.uploader.listener.OooO0O0 oooO0O0 = this.OooOO0;
            String string2 = this.OooO0O0;
            int n12 = 7026;
            String string3 = "create upload failure";
            oooO0O0.OooO00o(string2, n12, string3);
        }
    }
}

