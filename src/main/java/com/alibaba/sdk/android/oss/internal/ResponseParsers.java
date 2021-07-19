/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import android.util.Xml;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.model.BucketLifecycleRule;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.CopyObjectResult;
import com.alibaba.sdk.android.oss.model.DeleteMultipleObjectResult;
import com.alibaba.sdk.android.oss.model.GetBucketACLResult;
import com.alibaba.sdk.android.oss.model.GetBucketInfoResult;
import com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult;
import com.alibaba.sdk.android.oss.model.GetBucketLoggingResult;
import com.alibaba.sdk.android.oss.model.GetBucketRefererResult;
import com.alibaba.sdk.android.oss.model.GetObjectACLResult;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.ListBucketsResult;
import com.alibaba.sdk.android.oss.model.ListObjectsResult;
import com.alibaba.sdk.android.oss.model.ListPartsResult;
import com.alibaba.sdk.android.oss.model.OSSBucketSummary;
import com.alibaba.sdk.android.oss.model.OSSObjectSummary;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.Owner;
import com.alibaba.sdk.android.oss.model.PartSummary;
import g.c0;
import g.d0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ResponseParsers {
    public static /* synthetic */ GetObjectACLResult access$000(InputStream inputStream, GetObjectACLResult getObjectACLResult) {
        return ResponseParsers.parseGetObjectACLResponse(inputStream, getObjectACLResult);
    }

    public static /* synthetic */ CopyObjectResult access$100(InputStream inputStream, CopyObjectResult copyObjectResult) {
        return ResponseParsers.parseCopyObjectResponseXML(inputStream, copyObjectResult);
    }

    public static /* synthetic */ InitiateMultipartUploadResult access$1000(InputStream inputStream, InitiateMultipartUploadResult initiateMultipartUploadResult) {
        return ResponseParsers.parseInitMultipartResponseXML(inputStream, initiateMultipartUploadResult);
    }

    public static /* synthetic */ CompleteMultipartUploadResult access$1100(InputStream inputStream, CompleteMultipartUploadResult completeMultipartUploadResult) {
        return ResponseParsers.parseCompleteMultipartUploadResponseXML(inputStream, completeMultipartUploadResult);
    }

    public static /* synthetic */ ListPartsResult access$1200(InputStream inputStream, ListPartsResult listPartsResult) {
        return ResponseParsers.parseListPartsResponseXML(inputStream, listPartsResult);
    }

    public static /* synthetic */ GetBucketInfoResult access$200(InputStream inputStream, GetBucketInfoResult getBucketInfoResult) {
        return ResponseParsers.parseGetBucketInfoResponse(inputStream, getBucketInfoResult);
    }

    public static /* synthetic */ GetBucketACLResult access$300(InputStream inputStream, GetBucketACLResult getBucketACLResult) {
        return ResponseParsers.parseGetBucketACLResponse(inputStream, getBucketACLResult);
    }

    public static /* synthetic */ GetBucketRefererResult access$400(InputStream inputStream, GetBucketRefererResult getBucketRefererResult) {
        return ResponseParsers.parseGetBucketRefererResponse(inputStream, getBucketRefererResult);
    }

    public static /* synthetic */ GetBucketLoggingResult access$500(InputStream inputStream, GetBucketLoggingResult getBucketLoggingResult) {
        return ResponseParsers.parseGetBucketLoggingResponse(inputStream, getBucketLoggingResult);
    }

    public static /* synthetic */ GetBucketLifecycleResult access$600(InputStream inputStream, GetBucketLifecycleResult getBucketLifecycleResult) {
        return ResponseParsers.parseGetBucketLifecycleResponse(inputStream, getBucketLifecycleResult);
    }

    public static /* synthetic */ DeleteMultipleObjectResult access$700(InputStream inputStream, DeleteMultipleObjectResult deleteMultipleObjectResult) {
        return ResponseParsers.parseDeleteMultipleObjectResponse(inputStream, deleteMultipleObjectResult);
    }

    public static /* synthetic */ ListObjectsResult access$800(InputStream inputStream, ListObjectsResult listObjectsResult) {
        return ResponseParsers.parseObjectListResponse(inputStream, listObjectsResult);
    }

    public static /* synthetic */ ListBucketsResult access$900(InputStream inputStream, ListBucketsResult listBucketsResult) {
        return ResponseParsers.parseBucketListResponse(inputStream, listBucketsResult);
    }

    private static ListBucketsResult parseBucketListResponse(InputStream object, ListBucketsResult listBucketsResult) {
        boolean bl2;
        boolean bl3;
        listBucketsResult.clearBucketList();
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput((InputStream)object, "utf-8");
        int bl32 = xmlPullParser.getEventType();
        Object object2 = null;
        while (bl3 != (bl2 = true)) {
            bl2 = 2 != 0;
            String string2 = "Bucket";
            if (bl3 != bl2) {
                bl2 = 3 != 0;
                if (bl3 == bl2 && (bl3 = (boolean)string2.equals(object = xmlPullParser.getName())) && object2 != null) {
                    listBucketsResult.addBucket((OSSBucketSummary)object2);
                }
            } else {
                object = xmlPullParser.getName();
                if (object != null) {
                    String string3 = "Prefix";
                    bl2 = string3.equals(object);
                    if (bl2) {
                        object = xmlPullParser.nextText();
                        listBucketsResult.setPrefix((String)object);
                    } else {
                        string3 = "Marker";
                        bl2 = string3.equals(object);
                        if (bl2) {
                            object = xmlPullParser.nextText();
                            listBucketsResult.setMarker((String)object);
                        } else {
                            string3 = "MaxKeys";
                            bl2 = string3.equals(object);
                            if (bl2) {
                                object = xmlPullParser.nextText();
                                if (object != null) {
                                    object = Integer.valueOf((String)object);
                                    bl3 = ((Integer)object).intValue();
                                    listBucketsResult.setMaxKeys((int)(bl3 ? 1 : 0));
                                }
                            } else {
                                string3 = "IsTruncated";
                                bl2 = string3.equals(object);
                                if (bl2) {
                                    object = xmlPullParser.nextText();
                                    if (object != null) {
                                        object = Boolean.valueOf((String)object);
                                        bl3 = (Boolean)object;
                                        listBucketsResult.setTruncated(bl3);
                                    }
                                } else {
                                    string3 = "NextMarker";
                                    bl2 = string3.equals(object);
                                    if (bl2) {
                                        object = xmlPullParser.nextText();
                                        listBucketsResult.setNextMarker((String)object);
                                    } else {
                                        string3 = "ID";
                                        bl2 = string3.equals(object);
                                        if (bl2) {
                                            object = xmlPullParser.nextText();
                                            listBucketsResult.setOwnerId((String)object);
                                        } else {
                                            string3 = "DisplayName";
                                            bl2 = string3.equals(object);
                                            if (bl2) {
                                                object = xmlPullParser.nextText();
                                                listBucketsResult.setOwnerDisplayName((String)object);
                                            } else {
                                                bl2 = string2.equals(object);
                                                if (bl2) {
                                                    object2 = object = new OSSBucketSummary();
                                                } else {
                                                    string3 = "CreationDate";
                                                    bl2 = string3.equals(object);
                                                    if (bl2) {
                                                        if (object2 != null) {
                                                            ((OSSBucketSummary)object2).createDate = object = DateUtil.parseIso8601Date(xmlPullParser.nextText());
                                                        }
                                                    } else {
                                                        string3 = "ExtranetEndpoint";
                                                        bl2 = string3.equals(object);
                                                        if (bl2) {
                                                            if (object2 != null) {
                                                                ((OSSBucketSummary)object2).extranetEndpoint = object = xmlPullParser.nextText();
                                                            }
                                                        } else {
                                                            string3 = "IntranetEndpoint";
                                                            bl2 = string3.equals(object);
                                                            if (bl2) {
                                                                if (object2 != null) {
                                                                    ((OSSBucketSummary)object2).intranetEndpoint = object = xmlPullParser.nextText();
                                                                }
                                                            } else {
                                                                string3 = "Location";
                                                                bl2 = string3.equals(object);
                                                                if (bl2) {
                                                                    if (object2 != null) {
                                                                        ((OSSBucketSummary)object2).location = object = xmlPullParser.nextText();
                                                                    }
                                                                } else {
                                                                    string3 = "Name";
                                                                    bl2 = string3.equals(object);
                                                                    if (bl2) {
                                                                        if (object2 != null) {
                                                                            ((OSSBucketSummary)object2).name = object = xmlPullParser.nextText();
                                                                        }
                                                                    } else {
                                                                        string3 = "StorageClass";
                                                                        bl3 = string3.equals(object);
                                                                        if (bl3 && object2 != null) {
                                                                            ((OSSBucketSummary)object2).storageClass = object = xmlPullParser.nextText();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if ((bl3 = xmlPullParser.next()) != (bl2 = 4 != 0)) continue;
            bl3 = xmlPullParser.next();
        }
        return listBucketsResult;
    }

    private static CompleteMultipartUploadResult parseCompleteMultipartUploadResponseXML(InputStream object, CompleteMultipartUploadResult completeMultipartUploadResult) {
        int n10;
        XmlPullParser xmlPullParser = Xml.newPullParser();
        String string2 = "utf-8";
        xmlPullParser.setInput((InputStream)object, string2);
        int n11 = xmlPullParser.getEventType();
        while (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 == n10) {
                string2 = "Location";
                object = xmlPullParser.getName();
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 != 0) {
                    object = xmlPullParser.nextText();
                    completeMultipartUploadResult.setLocation((String)object);
                } else {
                    string2 = "Bucket";
                    n10 = (int)(string2.equals(object) ? 1 : 0);
                    if (n10 != 0) {
                        object = xmlPullParser.nextText();
                        completeMultipartUploadResult.setBucketName((String)object);
                    } else {
                        string2 = "Key";
                        n10 = (int)(string2.equals(object) ? 1 : 0);
                        if (n10 != 0) {
                            object = xmlPullParser.nextText();
                            completeMultipartUploadResult.setObjectKey((String)object);
                        } else {
                            string2 = "ETag";
                            n11 = (int)(string2.equals(object) ? 1 : 0);
                            if (n11 != 0) {
                                object = xmlPullParser.nextText();
                                completeMultipartUploadResult.setETag((String)object);
                            }
                        }
                    }
                }
            }
            if ((n11 = xmlPullParser.next()) != (n10 = 4)) continue;
            n11 = xmlPullParser.next();
        }
        return completeMultipartUploadResult;
    }

    private static CopyObjectResult parseCopyObjectResponseXML(InputStream object, CopyObjectResult copyObjectResult) {
        int n10;
        XmlPullParser xmlPullParser = Xml.newPullParser();
        String string2 = "utf-8";
        xmlPullParser.setInput((InputStream)object, string2);
        int n11 = xmlPullParser.getEventType();
        while (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 == n10) {
                string2 = "LastModified";
                object = xmlPullParser.getName();
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 != 0) {
                    object = DateUtil.parseIso8601Date(xmlPullParser.nextText());
                    copyObjectResult.setLastModified((Date)object);
                } else {
                    string2 = "ETag";
                    n11 = (int)(string2.equals(object) ? 1 : 0);
                    if (n11 != 0) {
                        object = xmlPullParser.nextText();
                        copyObjectResult.setEtag((String)object);
                    }
                }
            }
            if ((n11 = xmlPullParser.next()) != (n10 = 4)) continue;
            n11 = xmlPullParser.next();
        }
        return copyObjectResult;
    }

    private static DeleteMultipleObjectResult parseDeleteMultipleObjectResponse(InputStream object, DeleteMultipleObjectResult deleteMultipleObjectResult) {
        int n10;
        XmlPullParser xmlPullParser = Xml.newPullParser();
        String string2 = "utf-8";
        xmlPullParser.setInput((InputStream)object, string2);
        int n11 = xmlPullParser.getEventType();
        while (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 == n10 && (n11 = (int)((string2 = "Key").equals(object = xmlPullParser.getName()) ? 1 : 0)) != 0) {
                object = xmlPullParser.nextText();
                deleteMultipleObjectResult.addDeletedObject((String)object);
            }
            if ((n11 = xmlPullParser.next()) != (n10 = 4)) continue;
            n11 = xmlPullParser.next();
        }
        return deleteMultipleObjectResult;
    }

    private static GetBucketACLResult parseGetBucketACLResponse(InputStream object, GetBucketACLResult getBucketACLResult) {
        int n10;
        XmlPullParser xmlPullParser = Xml.newPullParser();
        String string2 = "utf-8";
        xmlPullParser.setInput((InputStream)object, string2);
        int n11 = xmlPullParser.getEventType();
        while (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 == n10) {
                string2 = "Grant";
                object = xmlPullParser.getName();
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 != 0) {
                    object = xmlPullParser.nextText();
                    getBucketACLResult.setBucketACL((String)object);
                } else {
                    string2 = "ID";
                    n10 = (int)(string2.equals(object) ? 1 : 0);
                    if (n10 != 0) {
                        object = xmlPullParser.nextText();
                        getBucketACLResult.setBucketOwnerID((String)object);
                    } else {
                        string2 = "DisplayName";
                        n11 = (int)(string2.equals(object) ? 1 : 0);
                        if (n11 != 0) {
                            object = xmlPullParser.nextText();
                            getBucketACLResult.setBucketOwner((String)object);
                        }
                    }
                }
            }
            if ((n11 = xmlPullParser.next()) != (n10 = 4)) continue;
            n11 = xmlPullParser.next();
        }
        return getBucketACLResult;
    }

    private static GetBucketInfoResult parseGetBucketInfoResponse(InputStream object, GetBucketInfoResult getBucketInfoResult) {
        int n10;
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput((InputStream)object, "utf-8");
        int n11 = xmlPullParser.getEventType();
        Object object2 = null;
        Object object3 = null;
        while (n11 != (n10 = 1)) {
            n10 = 2;
            String string2 = "Bucket";
            String string3 = "Owner";
            if (n11 != n10) {
                n10 = 3;
                if (n11 == n10 && (object = xmlPullParser.getName()) != null) {
                    n10 = (int)(string2.equals(object) ? 1 : 0);
                    if (n10 != 0) {
                        if (object2 != null) {
                            getBucketInfoResult.setBucket((OSSBucketSummary)object2);
                        }
                    } else {
                        n11 = (int)(string3.equals(object) ? 1 : 0);
                        if (n11 != 0 && object2 != null) {
                            ((OSSBucketSummary)object2).owner = object3;
                        }
                    }
                }
            } else {
                object = xmlPullParser.getName();
                if (object != null) {
                    n10 = (int)(string3.equals(object) ? 1 : 0);
                    if (n10 != 0) {
                        object3 = object = new Owner();
                    } else {
                        String string4 = "ID";
                        n10 = (int)(string4.equals(object) ? 1 : 0);
                        if (n10 != 0) {
                            if (object3 != null) {
                                object = xmlPullParser.nextText();
                                ((Owner)object3).setId((String)object);
                            }
                        } else {
                            string4 = "DisplayName";
                            n10 = (int)(string4.equals(object) ? 1 : 0);
                            if (n10 != 0) {
                                if (object3 != null) {
                                    object = xmlPullParser.nextText();
                                    ((Owner)object3).setDisplayName((String)object);
                                }
                            } else {
                                n10 = (int)(string2.equals(object) ? 1 : 0);
                                if (n10 != 0) {
                                    object2 = object = new OSSBucketSummary();
                                } else {
                                    string4 = "CreationDate";
                                    n10 = (int)(string4.equals(object) ? 1 : 0);
                                    if (n10 != 0) {
                                        if (object2 != null) {
                                            ((OSSBucketSummary)object2).createDate = object = DateUtil.parseIso8601Date(xmlPullParser.nextText());
                                        }
                                    } else {
                                        string4 = "ExtranetEndpoint";
                                        n10 = (int)(string4.equals(object) ? 1 : 0);
                                        if (n10 != 0) {
                                            if (object2 != null) {
                                                ((OSSBucketSummary)object2).extranetEndpoint = object = xmlPullParser.nextText();
                                            }
                                        } else {
                                            string4 = "IntranetEndpoint";
                                            n10 = (int)(string4.equals(object) ? 1 : 0);
                                            if (n10 != 0) {
                                                if (object2 != null) {
                                                    ((OSSBucketSummary)object2).intranetEndpoint = object = xmlPullParser.nextText();
                                                }
                                            } else {
                                                string4 = "Location";
                                                n10 = (int)(string4.equals(object) ? 1 : 0);
                                                if (n10 != 0) {
                                                    if (object2 != null) {
                                                        ((OSSBucketSummary)object2).location = object = xmlPullParser.nextText();
                                                    }
                                                } else {
                                                    string4 = "Name";
                                                    n10 = (int)(string4.equals(object) ? 1 : 0);
                                                    if (n10 != 0) {
                                                        if (object2 != null) {
                                                            ((OSSBucketSummary)object2).name = object = xmlPullParser.nextText();
                                                        }
                                                    } else {
                                                        string4 = "StorageClass";
                                                        n10 = (int)(string4.equals(object) ? 1 : 0);
                                                        if (n10 != 0) {
                                                            if (object2 != null) {
                                                                ((OSSBucketSummary)object2).storageClass = object = xmlPullParser.nextText();
                                                            }
                                                        } else {
                                                            string4 = "Grant";
                                                            n11 = (int)(string4.equals(object) ? 1 : 0);
                                                            if (n11 != 0 && object2 != null) {
                                                                object = xmlPullParser.nextText();
                                                                ((OSSBucketSummary)object2).setAcl((String)object);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if ((n11 = xmlPullParser.next()) != (n10 = 4)) continue;
            n11 = xmlPullParser.next();
        }
        return getBucketInfoResult;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static GetBucketLifecycleResult parseGetBucketLifecycleResponse(InputStream var0, GetBucketLifecycleResult var1_1) {
        var2_2 = var1_1;
        var3_3 = Xml.newPullParser();
        var4_4 = "utf-8";
        var5_5 = var0;
        var3_3.setInput(var0, var4_4);
        var6_6 = var3_3.getEventType();
        var7_7 = null;
        var8_8 = false;
        var9_9 = false;
        var10_10 = false;
        var11_11 = null;
        var12_12 = null;
        var13_13 = null;
        while (var6_6 != (var14_14 = true)) {
            block39: {
                block47: {
                    block46: {
                        block45: {
                            block41: {
                                block40: {
                                    block44: {
                                        block43: {
                                            block42: {
                                                var15_15 = 2 != 0;
                                                var16_16 = "Transition";
                                                var17_17 = "AbortMultipartUpload";
                                                var18_18 = "Expiration";
                                                var5_5 = "Rule";
                                                if (var6_6 == var15_15) break block40;
                                                var14_14 = 3 != 0;
                                                if (var6_6 != var14_14) break block41;
                                                var4_4 = var3_3.getName();
                                                var19_19 = var5_5.equals(var4_4);
                                                if (!var19_19) break block42;
                                                var2_2.addLifecycleRule(var7_7);
                                                break block41;
                                            }
                                            var19_19 = var18_18.equals(var4_4);
                                            if (!var19_19) break block43;
                                            var19_19 = false;
                                            var5_5 = null;
                                            var8_8 = false;
                                            break block39;
                                        }
                                        var19_19 = var17_17.equals(var4_4);
                                        if (!var19_19) break block44;
                                        var19_19 = false;
                                        var5_5 = null;
                                        var9_9 = false;
                                        break block39;
                                    }
                                    var6_6 = var16_16.equals(var4_4);
                                    if (!var6_6) break block41;
                                    var19_19 = false;
                                    var5_5 = null;
                                    var10_10 = false;
                                    var11_11 = null;
                                    var12_12 = null;
                                    var13_13 = null;
                                    break block39;
                                }
                                var4_4 = var3_3.getName();
                                var19_19 = var5_5.equals(var4_4);
                                if (!var19_19) break block45;
                                var7_7 = new BucketLifecycleRule();
                            }
lbl58:
                            // 4 sources

                            while (true) {
                                var19_19 = false;
                                var5_5 = null;
                                break block39;
                                break;
                            }
                        }
                        var5_5 = "ID";
                        var19_19 = var5_5.equals(var4_4);
                        if (!var19_19) break block46;
                        var4_4 = var3_3.nextText();
                        var7_7.setIdentifier(var4_4);
                        ** GOTO lbl58
                    }
                    var5_5 = "Prefix";
                    var19_19 = var5_5.equals(var4_4);
                    if (!var19_19) break block47;
                    var4_4 = var3_3.nextText();
                    var7_7.setPrefix(var4_4);
                    ** GOTO lbl58
                }
                var5_5 = "Status";
                var19_19 = var5_5.equals(var4_4);
                if (var19_19) {
                    var5_5 = "Enabled";
                    var4_4 = var3_3.nextText();
                    var6_6 = var5_5.equals(var4_4);
                    if (var6_6) {
                        var7_7.setStatus(var14_14);
                        ** continue;
                    }
                    var19_19 = false;
                    var5_5 = null;
                    var7_7.setStatus(false);
                } else {
                    var19_19 = false;
                    var5_5 = null;
                    var20_20 = var18_18.equals(var4_4);
                    if (var20_20) {
                        var8_8 = var14_14;
                    } else {
                        var20_20 = var17_17.equals(var4_4);
                        if (var20_20) {
                            var9_9 = var14_14;
                        } else {
                            var20_20 = var16_16.equals(var4_4);
                            if (var20_20) {
                                var10_10 = var14_14;
                            } else {
                                var18_18 = "Days";
                                var20_20 = var18_18.equals(var4_4);
                                var21_21 = "Archive";
                                var22_22 = "IA";
                                if (var20_20) {
                                    var11_11 = var3_3.nextText();
                                    if (var7_7 != null) {
                                        if (var8_8) {
                                            var7_7.setDays(var11_11);
                                        } else if (var9_9) {
                                            var7_7.setMultipartDays(var11_11);
                                        } else if (var10_10 && var13_13 != null) {
                                            var6_6 = var22_22.equals(var13_13);
                                            if (var6_6) {
                                                var7_7.setIADays(var11_11);
                                            } else {
                                                var6_6 = var21_21.equals(var13_13);
                                                if (var6_6) {
                                                    var7_7.setArchiveDays(var11_11);
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    var18_18 = "Date";
                                    var20_20 = var18_18.equals(var4_4);
                                    if (var20_20) {
                                        var12_12 = var3_3.nextText();
                                        if (var7_7 != null) {
                                            if (var8_8) {
                                                var7_7.setExpireDate(var12_12);
                                            } else if (var9_9) {
                                                var7_7.setMultipartExpireDate(var12_12);
                                            } else if (var10_10 && var13_13 != null) {
                                                var6_6 = var22_22.equals(var13_13);
                                                if (var6_6) {
                                                    var7_7.setIAExpireDate(var12_12);
                                                } else {
                                                    var6_6 = var21_21.equals(var13_13);
                                                    if (var6_6) {
                                                        var7_7.setArchiveExpireDate(var12_12);
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        var18_18 = "StorageClass";
                                        var6_6 = var18_18.equals(var4_4);
                                        if (var6_6) {
                                            var13_13 = var3_3.nextText();
                                            if (var7_7 != null) {
                                                var6_6 = var22_22.equals(var13_13);
                                                if (var6_6) {
                                                    var7_7.setIADays(var11_11);
                                                    var7_7.setIAExpireDate(var12_12);
                                                } else {
                                                    var6_6 = var21_21.equals(var13_13);
                                                    if (var6_6) {
                                                        var7_7.setArchiveDays(var12_12);
                                                        var7_7.setArchiveExpireDate(var12_12);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if ((var6_6 = var3_3.next()) != (var20_20 = 4 != 0)) continue;
            var6_6 = var3_3.next();
        }
        return var2_2;
    }

    private static GetBucketLoggingResult parseGetBucketLoggingResponse(InputStream object, GetBucketLoggingResult getBucketLoggingResult) {
        int n10;
        int n11;
        XmlPullParser xmlPullParser = Xml.newPullParser();
        String string2 = "utf-8";
        xmlPullParser.setInput((InputStream)object, string2);
        int bl3 = xmlPullParser.getEventType();
        while (n11 != (n10 = 1)) {
            int n12 = 2;
            if (n11 == n12) {
                String string3 = "LoggingEnabled";
                object = xmlPullParser.getName();
                n12 = (int)(string3.equals(object) ? 1 : 0);
                if (n12 != 0) {
                    getBucketLoggingResult.setLoggingEnabled(n10 != 0);
                } else {
                    string2 = "TargetBucket";
                    n10 = string2.equals(object);
                    if (n10 != 0) {
                        object = xmlPullParser.nextText();
                        getBucketLoggingResult.setTargetBucketName((String)object);
                    } else {
                        string2 = "TargetPrefix";
                        n11 = string2.equals(object);
                        if (n11 != 0) {
                            object = xmlPullParser.nextText();
                            getBucketLoggingResult.setTargetPrefix((String)object);
                        }
                    }
                }
            }
            if ((n11 = xmlPullParser.next()) != (n10 = 4)) continue;
            n11 = xmlPullParser.next();
        }
        return getBucketLoggingResult;
    }

    private static GetBucketRefererResult parseGetBucketRefererResponse(InputStream object, GetBucketRefererResult getBucketRefererResult) {
        int n10;
        XmlPullParser xmlPullParser = Xml.newPullParser();
        String string2 = "utf-8";
        xmlPullParser.setInput((InputStream)object, string2);
        int n11 = xmlPullParser.getEventType();
        while (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 == n10 && (n11 = (int)((string2 = "Referer").equals(object = xmlPullParser.getName()) ? 1 : 0)) != 0) {
                object = xmlPullParser.nextText();
                getBucketRefererResult.addReferer((String)object);
            }
            if ((n11 = xmlPullParser.next()) != (n10 = 4)) continue;
            n11 = xmlPullParser.next();
        }
        return getBucketRefererResult;
    }

    private static GetObjectACLResult parseGetObjectACLResponse(InputStream object, GetObjectACLResult getObjectACLResult) {
        int n10;
        XmlPullParser xmlPullParser = Xml.newPullParser();
        String string2 = "utf-8";
        xmlPullParser.setInput((InputStream)object, string2);
        int n11 = xmlPullParser.getEventType();
        while (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 == n10) {
                string2 = "Grant";
                object = xmlPullParser.getName();
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 != 0) {
                    object = xmlPullParser.nextText();
                    getObjectACLResult.setObjectACL((String)object);
                } else {
                    string2 = "ID";
                    n10 = (int)(string2.equals(object) ? 1 : 0);
                    if (n10 != 0) {
                        object = xmlPullParser.nextText();
                        getObjectACLResult.setObjectOwnerID((String)object);
                    } else {
                        string2 = "DisplayName";
                        n11 = (int)(string2.equals(object) ? 1 : 0);
                        if (n11 != 0) {
                            object = xmlPullParser.nextText();
                            getObjectACLResult.setObjectOwner((String)object);
                        }
                    }
                }
            }
            if ((n11 = xmlPullParser.next()) != (n10 = 4)) continue;
            n11 = xmlPullParser.next();
        }
        return getObjectACLResult;
    }

    private static InitiateMultipartUploadResult parseInitMultipartResponseXML(InputStream object, InitiateMultipartUploadResult initiateMultipartUploadResult) {
        int n10;
        XmlPullParser xmlPullParser = Xml.newPullParser();
        String string2 = "utf-8";
        xmlPullParser.setInput((InputStream)object, string2);
        int n11 = xmlPullParser.getEventType();
        while (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 == n10) {
                string2 = "Bucket";
                object = xmlPullParser.getName();
                n10 = (int)(string2.equals(object) ? 1 : 0);
                if (n10 != 0) {
                    object = xmlPullParser.nextText();
                    initiateMultipartUploadResult.setBucketName((String)object);
                } else {
                    string2 = "Key";
                    n10 = (int)(string2.equals(object) ? 1 : 0);
                    if (n10 != 0) {
                        object = xmlPullParser.nextText();
                        initiateMultipartUploadResult.setObjectKey((String)object);
                    } else {
                        string2 = "UploadId";
                        n11 = (int)(string2.equals(object) ? 1 : 0);
                        if (n11 != 0) {
                            object = xmlPullParser.nextText();
                            initiateMultipartUploadResult.setUploadId((String)object);
                        }
                    }
                }
            }
            if ((n11 = xmlPullParser.next()) != (n10 = 4)) continue;
            n11 = xmlPullParser.next();
        }
        return initiateMultipartUploadResult;
    }

    private static ListPartsResult parseListPartsResponseXML(InputStream object, ListPartsResult listPartsResult) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput((InputStream)object, "utf-8");
        int n11 = xmlPullParser.getEventType();
        Object object2 = null;
        while (n11 != (n10 = 1)) {
            n10 = 2;
            String string2 = "Part";
            if (n11 != n10) {
                n10 = 3;
                if (n11 == n10 && (n11 = (int)(string2.equals(object = xmlPullParser.getName()) ? 1 : 0)) != 0) {
                    arrayList.add(object2);
                }
            } else {
                String string3 = "Bucket";
                object = xmlPullParser.getName();
                n10 = (int)(string3.equals(object) ? 1 : 0);
                if (n10 != 0) {
                    object = xmlPullParser.nextText();
                    listPartsResult.setBucketName((String)object);
                } else {
                    string3 = "Key";
                    n10 = (int)(string3.equals(object) ? 1 : 0);
                    if (n10 != 0) {
                        object = xmlPullParser.nextText();
                        listPartsResult.setKey((String)object);
                    } else {
                        string3 = "UploadId";
                        n10 = (int)(string3.equals(object) ? 1 : 0);
                        if (n10 != 0) {
                            object = xmlPullParser.nextText();
                            listPartsResult.setUploadId((String)object);
                        } else {
                            string3 = "PartNumberMarker";
                            n10 = (int)(string3.equals(object) ? 1 : 0);
                            if (n10 != 0) {
                                object = xmlPullParser.nextText();
                                n10 = (int)(OSSUtils.isEmptyString((String)object) ? 1 : 0);
                                if (n10 == 0) {
                                    n11 = Integer.parseInt((String)object);
                                    listPartsResult.setPartNumberMarker(n11);
                                }
                            } else {
                                string3 = "NextPartNumberMarker";
                                n10 = (int)(string3.equals(object) ? 1 : 0);
                                if (n10 != 0) {
                                    object = xmlPullParser.nextText();
                                    n10 = (int)(OSSUtils.isEmptyString((String)object) ? 1 : 0);
                                    if (n10 == 0) {
                                        n11 = Integer.parseInt((String)object);
                                        listPartsResult.setNextPartNumberMarker(n11);
                                    }
                                } else {
                                    string3 = "MaxParts";
                                    n10 = (int)(string3.equals(object) ? 1 : 0);
                                    if (n10 != 0) {
                                        object = xmlPullParser.nextText();
                                        n10 = (int)(OSSUtils.isEmptyString((String)object) ? 1 : 0);
                                        if (n10 == 0) {
                                            n11 = Integer.parseInt((String)object);
                                            listPartsResult.setMaxParts(n11);
                                        }
                                    } else {
                                        string3 = "IsTruncated";
                                        n10 = (int)(string3.equals(object) ? 1 : 0);
                                        if (n10 != 0) {
                                            object = xmlPullParser.nextText();
                                            n10 = (int)(OSSUtils.isEmptyString((String)object) ? 1 : 0);
                                            if (n10 == 0) {
                                                object = Boolean.valueOf((String)object);
                                                n11 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                                                listPartsResult.setTruncated(n11 != 0);
                                            }
                                        } else {
                                            string3 = "StorageClass";
                                            n10 = (int)(string3.equals(object) ? 1 : 0);
                                            if (n10 != 0) {
                                                object = xmlPullParser.nextText();
                                                listPartsResult.setStorageClass((String)object);
                                            } else {
                                                n10 = (int)(string2.equals(object) ? 1 : 0);
                                                if (n10 != 0) {
                                                    object2 = object = new PartSummary();
                                                } else {
                                                    string3 = "PartNumber";
                                                    n10 = string3.equals(object);
                                                    if (n10 != 0) {
                                                        object = xmlPullParser.nextText();
                                                        n10 = OSSUtils.isEmptyString((String)object);
                                                        if (n10 == 0) {
                                                            object = Integer.valueOf((String)object);
                                                            n11 = (Integer)object;
                                                            ((PartSummary)object2).setPartNumber(n11);
                                                        }
                                                    } else {
                                                        string3 = "LastModified";
                                                        n10 = string3.equals(object);
                                                        if (n10 != 0) {
                                                            object = DateUtil.parseIso8601Date(xmlPullParser.nextText());
                                                            ((PartSummary)object2).setLastModified((Date)object);
                                                        } else {
                                                            string3 = "ETag";
                                                            n10 = (int)(string3.equals(object) ? 1 : 0);
                                                            if (n10 != 0) {
                                                                object = xmlPullParser.nextText();
                                                                ((PartSummary)object2).setETag((String)object);
                                                            } else {
                                                                string3 = "Size";
                                                                n11 = (int)(string3.equals(object) ? 1 : 0);
                                                                if (n11 != 0 && (n10 = (int)(OSSUtils.isEmptyString((String)(object = xmlPullParser.nextText())) ? 1 : 0)) == 0) {
                                                                    object = Long.valueOf((String)object);
                                                                    long l10 = (Long)object;
                                                                    ((PartSummary)object2).setSize(l10);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if ((n11 = xmlPullParser.next()) != (n10 = 4)) continue;
            n11 = xmlPullParser.next();
        }
        n11 = arrayList.size();
        if (n11 > 0) {
            listPartsResult.setParts(arrayList);
        }
        return listPartsResult;
    }

    private static ListObjectsResult parseObjectListResponse(InputStream object, ListObjectsResult listObjectsResult) {
        int n10;
        int n11;
        listObjectsResult.clearCommonPrefixes();
        listObjectsResult.clearObjectSummaries();
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput((InputStream)object, "utf-8");
        int bl3 = xmlPullParser.getEventType();
        Object object2 = null;
        int n12 = 0;
        Object object3 = null;
        while (n11 != (n10 = 1)) {
            int n13 = 2;
            String string2 = "CommonPrefixes";
            String string3 = "Contents";
            String string4 = "Owner";
            if (n11 != n13) {
                n10 = 3;
                if (n11 == n10) {
                    object = xmlPullParser.getName();
                    String string5 = xmlPullParser.getName();
                    n10 = (int)(string4.equals(string5) ? 1 : 0);
                    if (n10) {
                        if (object2 != null) {
                            ((OSSObjectSummary)object3).setOwner((Owner)object2);
                        }
                    } else {
                        n10 = (int)(string3.equals(object) ? 1 : 0);
                        if (n10) {
                            if (object3 != null) {
                                object = listObjectsResult.getBucketName();
                                ((OSSObjectSummary)object3).setBucketName((String)object);
                                listObjectsResult.addObjectSummary((OSSObjectSummary)object3);
                            }
                        } else {
                            n11 = (int)(string2.equals(object) ? 1 : 0);
                            if (n11) {
                                n12 = 0;
                            }
                        }
                    }
                }
            } else {
                String string6 = "Name";
                object = xmlPullParser.getName();
                n13 = (int)(string6.equals(object) ? 1 : 0);
                if (n13 != 0) {
                    object = xmlPullParser.nextText();
                    listObjectsResult.setBucketName((String)object);
                } else {
                    string6 = "Prefix";
                    n13 = (int)(string6.equals(object) ? 1 : 0);
                    if (n13 != 0) {
                        if (n12) {
                            object = xmlPullParser.nextText();
                            n10 = (int)(OSSUtils.isEmptyString((String)object) ? 1 : 0);
                            if (!n10) {
                                listObjectsResult.addCommonPrefix((String)object);
                            }
                        } else {
                            object = xmlPullParser.nextText();
                            listObjectsResult.setPrefix((String)object);
                        }
                    } else {
                        string6 = "Marker";
                        n13 = (int)(string6.equals(object) ? 1 : 0);
                        if (n13 != 0) {
                            object = xmlPullParser.nextText();
                            listObjectsResult.setMarker((String)object);
                        } else {
                            string6 = "Delimiter";
                            n13 = (int)(string6.equals(object) ? 1 : 0);
                            if (n13 != 0) {
                                object = xmlPullParser.nextText();
                                listObjectsResult.setDelimiter((String)object);
                            } else {
                                string6 = "EncodingType";
                                n13 = (int)(string6.equals(object) ? 1 : 0);
                                if (n13 != 0) {
                                    object = xmlPullParser.nextText();
                                    listObjectsResult.setEncodingType((String)object);
                                } else {
                                    string6 = "MaxKeys";
                                    n13 = (int)(string6.equals(object) ? 1 : 0);
                                    if (n13 != 0) {
                                        object = xmlPullParser.nextText();
                                        n10 = (int)(OSSUtils.isEmptyString((String)object) ? 1 : 0);
                                        if (!n10) {
                                            object = Integer.valueOf((String)object);
                                            n11 = (Integer)object;
                                            listObjectsResult.setMaxKeys(n11);
                                        }
                                    } else {
                                        string6 = "NextMarker";
                                        n13 = (int)(string6.equals(object) ? 1 : 0);
                                        if (n13 != 0) {
                                            object = xmlPullParser.nextText();
                                            listObjectsResult.setNextMarker((String)object);
                                        } else {
                                            string6 = "IsTruncated";
                                            n13 = (int)(string6.equals(object) ? 1 : 0);
                                            if (n13 != 0) {
                                                object = xmlPullParser.nextText();
                                                n10 = (int)(OSSUtils.isEmptyString((String)object) ? 1 : 0);
                                                if (!n10) {
                                                    object = Boolean.valueOf((String)object);
                                                    n11 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                                                    listObjectsResult.setTruncated(n11 != 0);
                                                }
                                            } else {
                                                n13 = (int)(string3.equals(object) ? 1 : 0);
                                                if (n13 != 0) {
                                                    object3 = object = new OSSObjectSummary();
                                                } else {
                                                    string6 = "Key";
                                                    n13 = (int)(string6.equals(object) ? 1 : 0);
                                                    if (n13 != 0) {
                                                        object = xmlPullParser.nextText();
                                                        ((OSSObjectSummary)object3).setKey((String)object);
                                                    } else {
                                                        string6 = "LastModified";
                                                        n13 = (int)(string6.equals(object) ? 1 : 0);
                                                        if (n13 != 0) {
                                                            object = DateUtil.parseIso8601Date(xmlPullParser.nextText());
                                                            ((OSSObjectSummary)object3).setLastModified((Date)object);
                                                        } else {
                                                            string6 = "Size";
                                                            n13 = (int)(string6.equals(object) ? 1 : 0);
                                                            if (n13 != 0) {
                                                                object = xmlPullParser.nextText();
                                                                n10 = OSSUtils.isEmptyString((String)object);
                                                                if (!n10) {
                                                                    object = Long.valueOf((String)object);
                                                                    long l10 = (Long)object;
                                                                    ((OSSObjectSummary)object3).setSize(l10);
                                                                }
                                                            } else {
                                                                string6 = "ETag";
                                                                n13 = (int)(string6.equals(object) ? 1 : 0);
                                                                if (n13 != 0) {
                                                                    object = xmlPullParser.nextText();
                                                                    ((OSSObjectSummary)object3).setETag((String)object);
                                                                } else {
                                                                    string6 = "Type";
                                                                    n13 = (int)(string6.equals(object) ? 1 : 0);
                                                                    if (n13 != 0) {
                                                                        object = xmlPullParser.nextText();
                                                                        ((OSSObjectSummary)object3).setType((String)object);
                                                                    } else {
                                                                        string6 = "StorageClass";
                                                                        n13 = (int)(string6.equals(object) ? 1 : 0);
                                                                        if (n13 != 0) {
                                                                            object = xmlPullParser.nextText();
                                                                            ((OSSObjectSummary)object3).setStorageClass((String)object);
                                                                        } else {
                                                                            n13 = (int)(string4.equals(object) ? 1 : 0);
                                                                            if (n13 != 0) {
                                                                                object2 = object = new Owner();
                                                                            } else {
                                                                                string6 = "ID";
                                                                                n13 = (int)(string6.equals(object) ? 1 : 0);
                                                                                if (n13 != 0) {
                                                                                    object = xmlPullParser.nextText();
                                                                                    ((Owner)object2).setId((String)object);
                                                                                } else {
                                                                                    string6 = "DisplayName";
                                                                                    n13 = (int)(string6.equals(object) ? 1 : 0);
                                                                                    if (n13 != 0) {
                                                                                        object = xmlPullParser.nextText();
                                                                                        ((Owner)object2).setDisplayName((String)object);
                                                                                    } else {
                                                                                        n11 = string2.equals(object);
                                                                                        if (n11) {
                                                                                            n12 = n10;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if ((n11 = xmlPullParser.next()) != (n10 = 4)) continue;
            n11 = xmlPullParser.next();
        }
        return listObjectsResult;
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public static ObjectMetadata parseObjectMetadata(Map map) {
        try {
            boolean bl2;
            Object object = new ObjectMetadata();
            Object object2 = map.keySet();
            object2 = object2.iterator();
            while (bl2 = object2.hasNext()) {
                Object object3 = object2.next();
                Object object4 = "x-oss-meta-";
                int n10 = ((String)(object3 = (String)object3)).indexOf((String)object4);
                if (n10 >= 0) {
                    object4 = map.get(object3);
                    ((ObjectMetadata)object).addUserMetadata((String)object3, (String)object4);
                    continue;
                }
                object4 = "Last-Modified";
                n10 = (int)(((String)object3).equalsIgnoreCase((String)object4) ? 1 : 0);
                if (n10 == 0 && (n10 = (int)(((String)object3).equalsIgnoreCase((String)(object4 = "Date")) ? 1 : 0)) == 0) {
                    object4 = "Content-Length";
                    n10 = (int)(((String)object3).equalsIgnoreCase((String)object4) ? 1 : 0);
                    if (n10 != 0) {
                        object4 = map.get(object3);
                        object4 = (String)object4;
                        object4 = Long.valueOf((String)object4);
                        ((ObjectMetadata)object).setHeader((String)object3, object4);
                        continue;
                    }
                    object4 = "ETag";
                    n10 = (int)(((String)object3).equalsIgnoreCase((String)object4) ? 1 : 0);
                    if (n10 != 0) {
                        object4 = map.get(object3);
                        object4 = (String)object4;
                        object4 = ResponseParsers.trimQuotes((String)object4);
                        ((ObjectMetadata)object).setHeader((String)object3, object4);
                        continue;
                    }
                    object4 = map.get(object3);
                    ((ObjectMetadata)object).setHeader((String)object3, object4);
                    continue;
                }
                try {
                    object4 = map.get(object3);
                    object4 = DateUtil.parseRfc822Date((String)object4);
                    ((ObjectMetadata)object).setHeader((String)object3, object4);
                }
                catch (ParseException parseException) {
                    object2 = parseException.getMessage();
                    object = new IOException((String)object2, parseException);
                    throw object;
                }
            }
            return object;
        }
        catch (Exception exception) {
            String string2 = exception.getMessage();
            IOException iOException = new IOException(string2, exception);
            throw iOException;
        }
    }

    public static ServiceException parseResponseErrorXML(ResponseMessage object, boolean n10) {
        String string2;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        Object object7;
        Object object8;
        int n11;
        block44: {
            block43: {
                int n12;
                n11 = ((ResponseMessage)object).getStatusCode();
                object8 = ((ResponseMessage)object).getResponse().y0("x-oss-request-id");
                object7 = null;
                if (n10 != 0) break block43;
                object = ((ResponseMessage)object).getResponse();
                object = ((c0)object).r0();
                object = ((d0)object).string();
                object6 = new StringBuilder();
                object5 = "errorMessage  \uff1a  \n ";
                ((StringBuilder)object6).append((String)object5);
                ((StringBuilder)object6).append((String)object);
                object6 = ((StringBuilder)object6).toString();
                OSSLog.logDebug((String)object6);
                object5 = ((String)object).getBytes();
                object6 = new ByteArrayInputStream((byte[])object5);
                object5 = Xml.newPullParser();
                object4 = "utf-8";
                try {
                    object5.setInput((InputStream)object6, (String)object4);
                    n10 = object5.getEventType();
                    object4 = null;
                    object3 = null;
                    object2 = null;
                    string2 = null;
                }
                catch (XmlPullParserException xmlPullParserException) {
                    object6 = new ClientException(xmlPullParserException);
                    throw object6;
                }
                catch (IOException iOException) {
                    object6 = new ClientException(iOException);
                    throw object6;
                }
                while (n10 != (n12 = 1)) {
                    block42: {
                        n12 = 2;
                        if (n10 == n12) {
                            String string3;
                            block41: {
                                block40: {
                                    block39: {
                                        block38: {
                                            block37: {
                                                object6 = "Code";
                                                string3 = object5.getName();
                                                n10 = (int)(((String)object6).equals(string3) ? 1 : 0);
                                                if (n10 == 0) break block37;
                                                object7 = object6 = object5.nextText();
                                            }
                                            object6 = "Message";
                                            string3 = object5.getName();
                                            n10 = (int)(((String)object6).equals(string3) ? 1 : 0);
                                            if (n10 == 0) break block38;
                                            object4 = object6 = object5.nextText();
                                        }
                                        object6 = "RequestId";
                                        string3 = object5.getName();
                                        n10 = (int)(((String)object6).equals(string3) ? 1 : 0);
                                        if (n10 == 0) break block39;
                                        object8 = object6 = object5.nextText();
                                    }
                                    object6 = "HostId";
                                    string3 = object5.getName();
                                    n10 = (int)(((String)object6).equals(string3) ? 1 : 0);
                                    if (n10 == 0) break block40;
                                    object3 = object6 = object5.nextText();
                                }
                                object6 = "PartNumber";
                                string3 = object5.getName();
                                n10 = (int)(((String)object6).equals(string3) ? 1 : 0);
                                if (n10 == 0) break block41;
                                object2 = object5.nextText();
                            }
                            object6 = "PartEtag";
                            string3 = object5.getName();
                            n10 = (int)(((String)object6).equals(string3) ? 1 : 0);
                            if (n10 == 0) break block42;
                            string2 = object5.nextText();
                        }
                    }
                    n10 = object5.next();
                    if (n10 != (n12 = 4)) continue;
                    n10 = object5.next();
                }
                object5 = object7;
                object7 = object4;
                object4 = object8;
                Object object9 = object2;
                object2 = object;
                object = object9;
                break block44;
            }
            object4 = object8;
            object = null;
            object5 = null;
            object3 = null;
            object2 = null;
            string2 = null;
        }
        object8 = object6;
        object6 = new ServiceException(n11, (String)object7, (String)object5, (String)object4, (String)object3, (String)object2);
        boolean bl2 = TextUtils.isEmpty(string2);
        if (!bl2) {
            ((ServiceException)object6).setPartEtag(string2);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            ((ServiceException)object6).setPartNumber((String)object);
        }
        return object6;
    }

    public static String trimQuotes(String string2) {
        boolean bl2;
        if (string2 == null) {
            return null;
        }
        string2 = string2.trim();
        String string3 = "\"";
        int n10 = string2.startsWith(string3);
        int n11 = 1;
        if (n10 != 0) {
            string2 = string2.substring(n11);
        }
        if (bl2 = string2.endsWith(string3)) {
            bl2 = false;
            string3 = null;
            n10 = string2.length() - n11;
            string2 = string2.substring(0, n10);
        }
        return string2;
    }
}

