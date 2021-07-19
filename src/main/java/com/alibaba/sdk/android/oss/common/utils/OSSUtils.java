/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo$State
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.webkit.MimeTypeMap
 *  org.json.JSONObject
 */
package com.alibaba.sdk.android.oss.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.auth.HmacSHA1Signature;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.alibaba.sdk.android.oss.common.utils.HttpUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils$MetadataDirective;
import com.alibaba.sdk.android.oss.exception.InconsistentException;
import com.alibaba.sdk.android.oss.internal.RequestMessage;
import com.alibaba.sdk.android.oss.model.CopyObjectRequest;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleRequest;
import com.alibaba.sdk.android.oss.model.DeleteBucketLoggingRequest;
import com.alibaba.sdk.android.oss.model.DeleteBucketRequest;
import com.alibaba.sdk.android.oss.model.DeleteMultipleObjectRequest;
import com.alibaba.sdk.android.oss.model.GetBucketACLRequest;
import com.alibaba.sdk.android.oss.model.GetBucketInfoRequest;
import com.alibaba.sdk.android.oss.model.GetBucketLifecycleRequest;
import com.alibaba.sdk.android.oss.model.GetBucketLoggingRequest;
import com.alibaba.sdk.android.oss.model.GetBucketRefererRequest;
import com.alibaba.sdk.android.oss.model.ListBucketsRequest;
import com.alibaba.sdk.android.oss.model.ListMultipartUploadsRequest;
import com.alibaba.sdk.android.oss.model.ListObjectsRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.PutBucketLifecycleRequest;
import com.alibaba.sdk.android.oss.model.PutBucketLoggingRequest;
import com.alibaba.sdk.android.oss.model.PutBucketRefererRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class OSSUtils {
    private static final String NEW_LINE = "\n";
    private static final List SIGNED_PARAMTERS = Arrays.asList("bucketInfo", "acl", "uploads", "location", "cors", "logging", "website", "referer", "lifecycle", "delete", "append", "uploadId", "partNumber", "security-token", "position", "response-cache-control", "response-content-disposition", "response-content-encoding", "response-content-language", "response-content-type", "response-expires", "x-oss-process", "sequential", "symlink", "restore");

    public static void addDateHeader(Map map, String string2, Date object) {
        if (object != null) {
            object = DateUtil.formatRfc822Date((Date)object);
            map.put(string2, object);
        }
    }

    public static void addHeader(Map map, String string2, String string3) {
        if (string3 != null) {
            map.put(string2, string3);
        }
    }

    public static void addStringListHeader(Map map, String string2, List object) {
        boolean bl2;
        if (object != null && !(bl2 = object.isEmpty())) {
            object = OSSUtils.join((List)object);
            map.put(string2, object);
        }
    }

    public static void assertTrue(boolean bl2, String string2) {
        if (bl2) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static String buildBaseLogInfo(Context object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("=====[device info]=====\n");
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("[INFO]: android_version\uff1a");
        String string2 = Build.VERSION.RELEASE;
        ((StringBuilder)charSequence).append(string2);
        string2 = NEW_LINE;
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("[INFO]: mobile_model\uff1a");
        CharSequence charSequence2 = Build.MODEL;
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = OSSUtils.getOperatorName(object);
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (!bl2) {
            charSequence2 = new StringBuilder();
            String string3 = "[INFO]: operator_name\uff1a";
            ((StringBuilder)charSequence2).append(string3);
            ((StringBuilder)charSequence2).append((String)charSequence);
            ((StringBuilder)charSequence2).append(string2);
            charSequence = ((StringBuilder)charSequence2).toString();
            stringBuilder.append((String)charSequence);
        }
        if ((object = ((ConnectivityManager)object.getSystemService((String)(charSequence = "connectivity"))).getActiveNetworkInfo()) != null && (charSequence = object.getState()) == (charSequence2 = NetworkInfo.State.CONNECTED)) {
            charSequence = new StringBuilder();
            object = object.getTypeName();
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(" ");
            object = ((StringBuilder)charSequence).toString();
            charSequence = "connected";
        } else {
            charSequence = "unconnected";
            object = "unknown";
        }
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("[INFO]: network_state\uff1a");
        ((StringBuilder)charSequence2).append((String)charSequence);
        ((StringBuilder)charSequence2).append(string2);
        charSequence = ((StringBuilder)charSequence2).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("[INFO]: network_type\uff1a");
        ((StringBuilder)charSequence).append((String)object);
        object = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public static String buildCanonicalString(RequestMessage object) {
        boolean bl2;
        Map.Entry entry;
        StringBuilder stringBuilder = new StringBuilder();
        Object object2 = new StringBuilder();
        String string2 = ((RequestMessage)object).getMethod().toString();
        ((StringBuilder)object2).append(string2);
        string2 = NEW_LINE;
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        stringBuilder.append((String)object2);
        object2 = ((RequestMessage)object).getHeaders();
        Object object3 = new TreeMap();
        String string3 = "x-oss-";
        String string4 = "Content-MD5";
        String string5 = "Content-Type";
        if (object2 != null) {
            boolean bl3;
            object2 = object2.entrySet().iterator();
            while (bl3 = object2.hasNext()) {
                String string6;
                boolean bl4;
                entry = object2.next();
                Object object4 = entry.getKey();
                if (object4 == null || !(bl4 = ((String)(object4 = ((String)entry.getKey()).toLowerCase())).equals(string6 = string5.toLowerCase())) && !(bl4 = ((String)object4).equals(string6 = string4.toLowerCase())) && !(bl4 = ((String)object4).equals(string6 = "Date".toLowerCase())) && !(bl4 = ((String)object4).startsWith(string3))) continue;
                entry = ((String)entry.getValue()).trim();
                ((TreeMap)object3).put(object4, entry);
            }
        }
        object2 = string5.toLowerCase();
        boolean bl5 = ((TreeMap)object3).containsKey(object2);
        entry = "";
        if (!bl5) {
            object2 = string5.toLowerCase();
            ((TreeMap)object3).put(object2, entry);
        }
        if (!(bl5 = ((TreeMap)object3).containsKey(object2 = string4.toLowerCase()))) {
            object2 = string4.toLowerCase();
            ((TreeMap)object3).put(object2, entry);
        }
        object2 = ((TreeMap)object3).entrySet().iterator();
        while (bl2 = object2.hasNext()) {
            object3 = object2.next();
            string4 = (String)object3.getKey();
            object3 = object3.getValue();
            boolean bl6 = string4.startsWith(string3);
            if (bl6) {
                stringBuilder.append(string4);
                char c10 = ':';
                stringBuilder.append(c10);
                stringBuilder.append(object3);
            } else {
                stringBuilder.append(object3);
            }
            stringBuilder.append(string2);
        }
        object2 = ((RequestMessage)object).getBucketName();
        string2 = ((RequestMessage)object).getObjectKey();
        object = ((RequestMessage)object).getParameters();
        object = OSSUtils.buildCanonicalizedResource((String)object2, string2, (Map)object);
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public static String buildCanonicalizedResource(String string2, String charSequence, Map map) {
        String string3 = "/";
        if (string2 != null || charSequence != null) {
            if (charSequence == null) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                stringBuilder.append(string2);
                stringBuilder.append(string3);
                stringBuilder.append((String)charSequence);
                string3 = stringBuilder.toString();
            }
        }
        return OSSUtils.buildCanonicalizedResource(string3, map);
    }

    public static String buildCanonicalizedResource(String objectArray, Map map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)objectArray);
        if (map != null) {
            objectArray = map.keySet();
            Object object = new String[map.size()];
            objectArray = objectArray.toArray((T[])object);
            Arrays.sort(objectArray);
            int n10 = 63;
            int n11 = objectArray.length;
            for (int i10 = 0; i10 < n11; ++i10) {
                List list = SIGNED_PARAMTERS;
                Object object2 = objectArray[i10];
                boolean bl2 = list.contains(object2);
                if (!bl2) continue;
                stringBuilder.append((char)n10);
                stringBuilder.append((String)object2);
                object = (String)map.get(object2);
                boolean bl3 = OSSUtils.isEmptyString((String)object);
                if (!bl3) {
                    object2 = "=";
                    stringBuilder.append((String)object2);
                    stringBuilder.append((String)object);
                }
                n10 = 38;
            }
        }
        return stringBuilder.toString();
    }

    public static String buildImagePersistentBody(String object, String charSequence, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("x-oss-process=");
        String string3 = "image/";
        boolean bl2 = string2.startsWith(string3);
        if (bl2) {
            stringBuilder.append(string2);
        } else {
            stringBuilder.append(string3);
            stringBuilder.append(string2);
        }
        string2 = "|sys/";
        stringBuilder.append(string2);
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)charSequence)) == 0) {
            object = ((String)object).getBytes();
            n10 = 2;
            object = Base64.encodeToString((byte[])object, (int)n10);
            charSequence = Base64.encodeToString((byte[])((String)charSequence).getBytes(), (int)n10);
            string2 = "saveas,o_";
            stringBuilder.append(string2);
            stringBuilder.append((String)charSequence);
            charSequence = ",b_";
            stringBuilder.append((String)charSequence);
            stringBuilder.append((String)object);
        }
        object = stringBuilder.toString();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("ImagePersistent body : ");
        ((StringBuilder)charSequence).append((String)object);
        OSSLog.logDebug(((StringBuilder)charSequence).toString());
        return object;
    }

    public static String buildTriggerCallbackBody(Map object, Map map) {
        int n10;
        int n11;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "x-oss-process=trigger/callback,callback_";
        stringBuilder.append(string2);
        int n12 = 2;
        if (object != null && (n11 = object.size()) > 0) {
            JSONObject jSONObject = new JSONObject((Map)object);
            object = Base64.encodeToString((byte[])jSONObject.toString().getBytes(), (int)n12);
            stringBuilder.append((String)object);
        }
        object = ",callback-var_";
        stringBuilder.append((String)object);
        if (map != null && (n10 = map.size()) > 0) {
            object = new JSONObject(map);
            object = Base64.encodeToString((byte[])object.toString().getBytes(), (int)n12);
            stringBuilder.append((String)object);
        }
        return stringBuilder.toString();
    }

    public static String buildXMLFromPartEtagList(List object) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        Object object2 = "<CompleteMultipartUpload>\n";
        stringBuilder.append((String)object2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (PartETag)object.next();
            stringBuilder.append("<Part>\n");
            CharSequence charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("<PartNumber>");
            int n10 = ((PartETag)object2).getPartNumber();
            ((StringBuilder)charSequence).append(n10);
            ((StringBuilder)charSequence).append("</PartNumber>\n");
            charSequence = ((StringBuilder)charSequence).toString();
            stringBuilder.append((String)charSequence);
            charSequence = new StringBuilder();
            String string2 = "<ETag>";
            ((StringBuilder)charSequence).append(string2);
            object2 = ((PartETag)object2).getETag();
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append("</ETag>\n");
            object2 = ((StringBuilder)charSequence).toString();
            stringBuilder.append((String)object2);
            object2 = "</Part>\n";
            stringBuilder.append((String)object2);
        }
        stringBuilder.append("</CompleteMultipartUpload>\n");
        return stringBuilder.toString();
    }

    public static void checkChecksum(Long l10, Long l11, String string2) {
        boolean bl2;
        if (l10 != null && l11 != null && !(bl2 = l10.equals(l11))) {
            InconsistentException inconsistentException = new InconsistentException(l10, l11, string2);
            throw inconsistentException;
        }
    }

    public static boolean checkParamRange(long l10, long l11, boolean bl2, long l12, boolean bl3) {
        long l13;
        boolean bl4 = true;
        if (bl2 && bl3) {
            long l14;
            Object object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
            if (object <= 0 && (l14 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) <= 0) {
                return bl4;
            }
            return false;
        }
        if (bl2 && !bl3) {
            long l15;
            Object object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
            if (object <= 0 && (l15 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) < 0) {
                return bl4;
            }
            return false;
        }
        if (!bl2 && !bl3) {
            long l16;
            Object object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
            if (object < 0 && (l16 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) < 0) {
                return bl4;
            }
            return false;
        }
        Object object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if (object < 0 && (l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) <= 0) {
            return bl4;
        }
        return false;
    }

    public static String determineContentType(String string2, String string3, String string4) {
        int n10;
        if (string2 != null) {
            return string2;
        }
        string2 = MimeTypeMap.getSingleton();
        int n11 = 46;
        if (string3 != null) {
            int n12 = string3.lastIndexOf(n11) + 1;
            string3 = string3.substring(n12);
            if ((string3 = string2.getMimeTypeFromExtension(string3)) != null) {
                return string3;
            }
        }
        if (string4 != null && (string2 = string2.getMimeTypeFromExtension(string3 = string4.substring(n10 = string4.lastIndexOf(n11) + 1))) != null) {
            return string2;
        }
        return "application/octet-stream";
    }

    public static boolean doesBucketNameValid(OSSRequest oSSRequest) {
        boolean bl2 = oSSRequest instanceof ListBucketsRequest;
        return !bl2;
    }

    public static boolean doesRequestNeedObjectKey(OSSRequest oSSRequest) {
        boolean bl2;
        boolean bl3;
        boolean bl4 = oSSRequest instanceof ListObjectsRequest;
        return !(bl4 || (bl4 = oSSRequest instanceof ListBucketsRequest) || (bl4 = oSSRequest instanceof CreateBucketRequest) || (bl4 = oSSRequest instanceof DeleteBucketRequest) || (bl4 = oSSRequest instanceof GetBucketInfoRequest) || (bl4 = oSSRequest instanceof GetBucketACLRequest) || (bl4 = oSSRequest instanceof DeleteMultipleObjectRequest) || (bl4 = oSSRequest instanceof ListMultipartUploadsRequest) || (bl4 = oSSRequest instanceof GetBucketRefererRequest) || (bl4 = oSSRequest instanceof PutBucketRefererRequest) || (bl4 = oSSRequest instanceof PutBucketLoggingRequest) || (bl3 = oSSRequest instanceof GetBucketLoggingRequest) || bl4 || bl3 || (bl4 = oSSRequest instanceof DeleteBucketLoggingRequest) || (bl4 = oSSRequest instanceof PutBucketLifecycleRequest) || (bl4 = oSSRequest instanceof GetBucketLifecycleRequest) || (bl2 = oSSRequest instanceof DeleteBucketLifecycleRequest));
        {
        }
    }

    public static void ensureBucketNameValid(String object) {
        boolean bl2 = OSSUtils.validateBucketName((String)object);
        if (bl2) {
            return;
        }
        object = new IllegalArgumentException("The bucket name is invalid. \nA bucket name must: \n1) be comprised of lower-case characters, numbers or dash(-); \n2) start with lower case or numbers; \n3) be between 3-63 characters long. ");
        throw object;
    }

    public static void ensureObjectKeyValid(String object) {
        boolean bl2 = OSSUtils.validateObjectKey((String)object);
        if (bl2) {
            return;
        }
        object = new IllegalArgumentException("The object key is invalid. \nAn object name should be: \n1) between 1 - 1023 bytes long when encoded as UTF-8 \n2) cannot contain LF or CR or unsupported chars in XML1.0, \n3) cannot begin with \"/\" or \"\\\".");
        throw object;
    }

    public static void ensureRequestValid(OSSRequest object, RequestMessage object2) {
        boolean bl2;
        boolean bl3 = OSSUtils.doesBucketNameValid((OSSRequest)object);
        if (bl3) {
            String string2 = ((RequestMessage)object2).getBucketName();
            OSSUtils.ensureBucketNameValid(string2);
        }
        if (bl3 = OSSUtils.doesRequestNeedObjectKey((OSSRequest)object)) {
            object2 = ((RequestMessage)object2).getObjectKey();
            OSSUtils.ensureObjectKeyValid((String)object2);
        }
        if (bl2 = object instanceof CopyObjectRequest) {
            object = ((CopyObjectRequest)object).getDestinationKey();
            OSSUtils.ensureObjectKeyValid((String)object);
        }
    }

    private static String getOperatorName(Context object) {
        String string2 = "phone";
        if ((object = ((TelephonyManager)object.getSystemService(string2)).getSimOperator()) != null) {
            string2 = "46000";
            boolean bl2 = ((String)object).equals(string2);
            if (!bl2 && !(bl2 = ((String)object).equals(string2 = "46002"))) {
                string2 = "46001";
                bl2 = ((String)object).equals(string2);
                if (bl2) {
                    object = "CUCC";
                } else {
                    string2 = "46003";
                    bl2 = ((String)object).equals(string2);
                    if (bl2) {
                        object = "CTCC";
                    }
                }
            } else {
                object = "CMCC";
            }
        } else {
            object = "";
        }
        return object;
    }

    public static boolean isCname(String string2) {
        for (String string3 : OSSConstants.DEFAULT_CNAME_EXCLUDE_LIST) {
            String string4 = string2.toLowerCase();
            boolean bl2 = string4.endsWith(string3);
            if (!bl2) continue;
            return false;
        }
        return true;
    }

    public static boolean isEmptyString(String string2) {
        return TextUtils.isEmpty((CharSequence)string2);
    }

    public static boolean isInCustomCnameExcludeList(String string2, List object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            String string3 = ((String)object.next()).toLowerCase();
            bl2 = string2.endsWith(string3);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static boolean isOssOriginHost(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return false;
        }
        for (String string3 : OSSConstants.OSS_ORIGN_HOST) {
            String string4 = string2.toLowerCase();
            boolean bl3 = string4.endsWith(string3);
            if (!bl3) continue;
            return true;
        }
        return false;
    }

    public static boolean isValidateIP(String object) {
        if (object != null) {
            try {
                String string2 = InetAddress.getByName((String)object).getHostAddress();
                boolean bl2 = ((String)object).equals(string2);
                if (bl2) {
                    return true;
                }
            }
            catch (UnknownHostException unknownHostException) {}
            return false;
        }
        object = new Exception("host is null");
        throw object;
    }

    public static String join(List object) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        object = object.iterator();
        boolean bl3 = true;
        while (bl2 = object.hasNext()) {
            String string2;
            String string3 = (String)object.next();
            if (!bl3) {
                string2 = ", ";
                stringBuilder.append(string2);
            }
            stringBuilder.append(string3);
            bl3 = false;
            string2 = null;
        }
        return stringBuilder.toString();
    }

    public static String paramToQueryString(Map object, String string2) {
        boolean bl2;
        if (object != null && !(bl2 = object.isEmpty())) {
            boolean bl3;
            StringBuilder stringBuilder = new StringBuilder();
            boolean bl4 = true;
            object = object.entrySet().iterator();
            while (bl3 = object.hasNext()) {
                String string3;
                Object object2 = (Map.Entry)object.next();
                String string4 = (String)object2.getKey();
                object2 = (String)object2.getValue();
                if (!bl4) {
                    string3 = "&";
                    stringBuilder.append(string3);
                }
                string3 = HttpUtil.urlEncode(string4, string2);
                stringBuilder.append(string3);
                bl4 = OSSUtils.isEmptyString((String)object2);
                if (!bl4) {
                    stringBuilder.append("=");
                    string3 = HttpUtil.urlEncode((String)object2, string2);
                    stringBuilder.append(string3);
                }
                bl4 = false;
                string3 = null;
            }
            return stringBuilder.toString();
        }
        return null;
    }

    public static void populateCopyObjectHeaders(CopyObjectRequest object, Map map) {
        Object object2 = new StringBuilder();
        String string2 = "/";
        ((StringBuilder)object2).append(string2);
        String string3 = ((CopyObjectRequest)object).getSourceBucketName();
        ((StringBuilder)object2).append(string3);
        ((StringBuilder)object2).append(string2);
        string2 = ((CopyObjectRequest)object).getSourceKey();
        string3 = "utf-8";
        string2 = HttpUtil.urlEncode(string2, string3);
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        map.put("x-oss-copy-source", object2);
        object2 = ((CopyObjectRequest)object).getModifiedSinceConstraint();
        OSSUtils.addDateHeader(map, "x-oss-copy-source-if-modified-since", (Date)object2);
        object2 = ((CopyObjectRequest)object).getUnmodifiedSinceConstraint();
        OSSUtils.addDateHeader(map, "x-oss-copy-source-if-unmodified-since", (Date)object2);
        object2 = ((CopyObjectRequest)object).getMatchingETagConstraints();
        OSSUtils.addStringListHeader(map, "x-oss-copy-source-if-match", (List)object2);
        object2 = ((CopyObjectRequest)object).getNonmatchingEtagConstraints();
        OSSUtils.addStringListHeader(map, "x-oss-copy-source-if-none-match", (List)object2);
        object2 = ((CopyObjectRequest)object).getServerSideEncryption();
        string2 = "x-oss-server-side-encryption";
        OSSUtils.addHeader(map, string2, (String)object2);
        object = ((CopyObjectRequest)object).getNewObjectMetadata();
        if (object != null) {
            object2 = OSSUtils$MetadataDirective.REPLACE.toString();
            string2 = "x-oss-metadata-directive";
            map.put(string2, object2);
            OSSUtils.populateRequestMetadata(map, (ObjectMetadata)object);
        }
        OSSUtils.removeHeader(map, "Content-Length");
    }

    public static void populateListBucketRequestParameters(ListBucketsRequest object, Map map) {
        String string2;
        Object object2 = ((ListBucketsRequest)object).getPrefix();
        if (object2 != null) {
            object2 = ((ListBucketsRequest)object).getPrefix();
            string2 = "prefix";
            map.put(string2, object2);
        }
        if ((object2 = ((ListBucketsRequest)object).getMarker()) != null) {
            object2 = ((ListBucketsRequest)object).getMarker();
            string2 = "marker";
            map.put(string2, object2);
        }
        if ((object2 = ((ListBucketsRequest)object).getMaxKeys()) != null) {
            int n10 = ((ListBucketsRequest)object).getMaxKeys();
            object = Integer.toString(n10);
            object2 = "max-keys";
            map.put(object2, object);
        }
    }

    public static void populateListMultipartUploadsRequestParameters(ListMultipartUploadsRequest object, Map map) {
        String string2;
        Object object2 = ((ListMultipartUploadsRequest)object).getDelimiter();
        if (object2 != null) {
            object2 = ((ListMultipartUploadsRequest)object).getDelimiter();
            string2 = "delimiter";
            map.put(string2, object2);
        }
        if ((object2 = ((ListMultipartUploadsRequest)object).getMaxUploads()) != null) {
            int n10 = ((ListMultipartUploadsRequest)object).getMaxUploads();
            object2 = Integer.toString(n10);
            string2 = "max-uploads";
            map.put(string2, object2);
        }
        if ((object2 = ((ListMultipartUploadsRequest)object).getKeyMarker()) != null) {
            object2 = ((ListMultipartUploadsRequest)object).getKeyMarker();
            string2 = "key-marker";
            map.put(string2, object2);
        }
        if ((object2 = ((ListMultipartUploadsRequest)object).getPrefix()) != null) {
            object2 = ((ListMultipartUploadsRequest)object).getPrefix();
            string2 = "prefix";
            map.put(string2, object2);
        }
        if ((object2 = ((ListMultipartUploadsRequest)object).getUploadIdMarker()) != null) {
            object2 = ((ListMultipartUploadsRequest)object).getUploadIdMarker();
            string2 = "upload-id-marker";
            map.put(string2, object2);
        }
        if ((object2 = ((ListMultipartUploadsRequest)object).getEncodingType()) != null) {
            object = ((ListMultipartUploadsRequest)object).getEncodingType();
            object2 = "encoding-type";
            map.put(object2, object);
        }
    }

    public static void populateListObjectsRequestParameters(ListObjectsRequest object, Map map) {
        String string2;
        Object object2 = ((ListObjectsRequest)object).getPrefix();
        if (object2 != null) {
            object2 = ((ListObjectsRequest)object).getPrefix();
            string2 = "prefix";
            map.put(string2, object2);
        }
        if ((object2 = ((ListObjectsRequest)object).getMarker()) != null) {
            object2 = ((ListObjectsRequest)object).getMarker();
            string2 = "marker";
            map.put(string2, object2);
        }
        if ((object2 = ((ListObjectsRequest)object).getDelimiter()) != null) {
            object2 = ((ListObjectsRequest)object).getDelimiter();
            string2 = "delimiter";
            map.put(string2, object2);
        }
        if ((object2 = ((ListObjectsRequest)object).getMaxKeys()) != null) {
            int n10 = ((ListObjectsRequest)object).getMaxKeys();
            object2 = Integer.toString(n10);
            string2 = "max-keys";
            map.put(string2, object2);
        }
        if ((object2 = ((ListObjectsRequest)object).getEncodingType()) != null) {
            object = ((ListObjectsRequest)object).getEncodingType();
            object2 = "encoding-type";
            map.put(object2, object);
        }
    }

    public static String populateMapToBase64JsonString(Map map) {
        JSONObject jSONObject = new JSONObject(map);
        return Base64.encodeToString((byte[])jSONObject.toString().getBytes(), (int)2);
    }

    public static void populateRequestMetadata(Map map, ObjectMetadata iterator2) {
        Object object;
        if (iterator2 == null) {
            return;
        }
        Object object2 = ((ObjectMetadata)((Object)iterator2)).getRawMetadata();
        if (object2 != null) {
            boolean bl2;
            object2 = object2.entrySet().iterator();
            while (bl2 = object2.hasNext()) {
                object = (Map.Entry)object2.next();
                Object k10 = object.getKey();
                object = object.getValue().toString();
                map.put(k10, object);
            }
        }
        if ((iterator2 = ((ObjectMetadata)((Object)iterator2)).getUserMetadata()) != null) {
            boolean bl3;
            iterator2 = iterator2.entrySet().iterator();
            while (bl3 = iterator2.hasNext()) {
                object2 = iterator2.next();
                object = (String)object2.getKey();
                object2 = (String)object2.getValue();
                if (object != null) {
                    object = ((String)object).trim();
                }
                if (object2 != null) {
                    object2 = ((String)object2).trim();
                }
                map.put(object, object2);
            }
        }
    }

    public static void removeHeader(Map map, String string2) {
        boolean bl2;
        if (string2 != null && (bl2 = map.containsKey(string2))) {
            map.remove(string2);
        }
    }

    public static String sign(String string2, String object, String charSequence) {
        HmacSHA1Signature hmacSHA1Signature;
        try {
            hmacSHA1Signature = new HmacSHA1Signature();
        }
        catch (Exception exception) {
            object = new IllegalStateException("Compute signature failed!", exception);
            throw object;
        }
        object = hmacSHA1Signature.computeSignature((String)object, (String)charSequence);
        object = ((String)object).trim();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("OSS ");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(":");
        ((StringBuilder)charSequence).append((String)object);
        return ((StringBuilder)charSequence).toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void signRequest(RequestMessage object) {
        Object object2;
        Object object3 = "signRequest start";
        OSSLog.logDebug((String)object3);
        boolean bl2 = ((RequestMessage)object).isAuthorizationRequired();
        if (!bl2) {
            return;
        }
        object3 = ((RequestMessage)object).getCredentialProvider();
        if (object3 == null) {
            object = new IllegalStateException("\u5f53\u524dCredentialProvider\u4e3a\u7a7a\uff01\uff01\uff01\n1. \u8bf7\u68c0\u67e5\u60a8\u662f\u5426\u5728\u521d\u59cb\u5316OSSService\u65f6\u8bbe\u7f6eCredentialProvider;\n2. \u5982\u679c\u60a8bucket\u4e3a\u516c\u5171\u6743\u9650\uff0c\u8bf7\u786e\u8ba4\u83b7\u53d6\u5230Bucket\u540e\u5df2\u7ecf\u8c03\u7528Bucket\u4e2d\u63a5\u53e3\u58f0\u660eACL;");
            throw object;
        }
        object3 = ((RequestMessage)object).getCredentialProvider();
        boolean bl3 = false;
        Object object4 = null;
        boolean bl4 = object3 instanceof OSSFederationCredentialProvider;
        String string2 = "x-oss-security-token";
        if (bl4) {
            object4 = object3;
            object4 = ((OSSFederationCredentialProvider)object3).getValidFederationToken();
            if (object4 == null) {
                object = "Can't get a federation token";
                OSSLog.logError((String)object);
                object3 = new IOException((String)object);
                throw object3;
            }
            object2 = ((RequestMessage)object).getHeaders();
            String string3 = ((OSSFederationToken)object4).getSecurityToken();
            object2.put(string2, string3);
        } else {
            boolean bl5 = object3 instanceof OSSStsTokenCredentialProvider;
            if (bl5) {
                object4 = ((OSSCredentialProvider)object3).getFederationToken();
                object2 = ((RequestMessage)object).getHeaders();
                String string4 = ((OSSFederationToken)object4).getSecurityToken();
                object2.put(string2, string4);
            }
        }
        string2 = OSSUtils.buildCanonicalString((RequestMessage)object);
        object2 = "get contentToSign";
        OSSLog.logDebug((String)object2);
        if (!bl4 && !(bl4 = object3 instanceof OSSStsTokenCredentialProvider)) {
            bl3 = object3 instanceof OSSPlainTextAKSKCredentialProvider;
            if (bl3) {
                object3 = (OSSPlainTextAKSKCredentialProvider)object3;
                object4 = ((OSSPlainTextAKSKCredentialProvider)object3).getAccessKeyId();
                object3 = ((OSSPlainTextAKSKCredentialProvider)object3).getAccessKeySecret();
                object3 = OSSUtils.sign((String)object4, (String)object3, string2);
            } else {
                bl3 = object3 instanceof OSSCustomSignerCredentialProvider;
                object3 = bl3 ? ((OSSCustomSignerCredentialProvider)object3).signContent(string2) : "---initValue---";
            }
        } else {
            object3 = ((OSSFederationToken)object4).getTempAK();
            object4 = ((OSSFederationToken)object4).getTempSK();
            object3 = OSSUtils.sign((String)object3, (String)object4, string2);
        }
        object4 = new StringBuilder();
        ((StringBuilder)object4).append("signed content: ");
        ((StringBuilder)object4).append(string2);
        ((StringBuilder)object4).append("   \n ---------   signature: ");
        ((StringBuilder)object4).append((String)object3);
        OSSLog.logDebug(((StringBuilder)object4).toString(), false);
        OSSLog.logDebug("get signature");
        ((RequestMessage)object).getHeaders().put("Authorization", object3);
    }

    public static boolean validateBucketName(String string2) {
        if (string2 == null) {
            return false;
        }
        return string2.matches("^[a-z0-9][a-z0-9\\-]{1,61}[a-z0-9]$");
    }

    public static boolean validateObjectKey(String object) {
        int n10;
        if (object == null) {
            return false;
        }
        Object object2 = ((String)object).length();
        if (object2 > 0 && (object2 = ((String)object).length()) <= (n10 = 1023)) {
            String string2 = "utf-8";
            try {
                ((String)object).getBytes(string2);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {}
            object = ((String)object).toCharArray();
            object2 = object[0];
            n10 = 47;
            if (object2 != n10 && object2 != (n10 = 92)) {
                for (Object object3 : object) {
                    int n11 = 9;
                    if (object3 == n11 || object3 >= (n11 = 32)) continue;
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}

