/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 */
package com.alibaba.sdk.android.oss.model;

import android.util.Xml;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.model.MultipartUpload;
import com.alibaba.sdk.android.oss.model.OSSResult;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class ListMultipartUploadsResult
extends OSSResult {
    private String bucketName;
    private List commonPrefixes;
    private String delimiter;
    private boolean isTruncated;
    private String keyMarker;
    private int maxUploads;
    private List multipartUploads;
    private String nextKeyMarker;
    private String nextUploadIdMarker;
    private String prefix;
    private String uploadIdMarker;

    public ListMultipartUploadsResult() {
        ArrayList arrayList;
        this.multipartUploads = arrayList = new ArrayList();
        this.commonPrefixes = arrayList = new ArrayList();
    }

    public void addCommonPrefix(String string2) {
        this.commonPrefixes.add(string2);
    }

    public void addMultipartUpload(MultipartUpload multipartUpload) {
        this.multipartUploads.add(multipartUpload);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public List getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getKeyMarker() {
        return this.keyMarker;
    }

    public int getMaxUploads() {
        return this.maxUploads;
    }

    public List getMultipartUploads() {
        return this.multipartUploads;
    }

    public String getNextKeyMarker() {
        return this.nextKeyMarker;
    }

    public String getNextUploadIdMarker() {
        return this.nextUploadIdMarker;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getUploadIdMarker() {
        return this.uploadIdMarker;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public ListMultipartUploadsResult parseData(ResponseMessage object) {
        int n10;
        int n11;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        XmlPullParser xmlPullParser = Xml.newPullParser();
        object = ((ResponseMessage)object).getContent();
        xmlPullParser.setInput((InputStream)object, "utf-8");
        int bl3 = xmlPullParser.getEventType();
        Object object2 = null;
        int n12 = 0;
        while (n11 != (n10 = 1)) {
            int n13 = 2;
            String string2 = "CommonPrefixes";
            String string3 = "Upload";
            if (n11 != n13) {
                n10 = 3;
                if (n11 == n10) {
                    object = xmlPullParser.getName();
                    n11 = (int)(string3.equals(object) ? 1 : 0);
                    if (n11) {
                        arrayList.add(object2);
                    } else {
                        object = xmlPullParser.getName();
                        n11 = (int)(string2.equals(object) ? 1 : 0);
                        if (n11) {
                            n12 = 0;
                        }
                    }
                }
            } else {
                String string4 = "Bucket";
                object = xmlPullParser.getName();
                n13 = (int)(string4.equals(object) ? 1 : 0);
                if (n13 != 0) {
                    object = xmlPullParser.nextText();
                    this.setBucketName((String)object);
                } else {
                    string4 = "Delimiter";
                    n13 = (int)(string4.equals(object) ? 1 : 0);
                    if (n13 != 0) {
                        object = xmlPullParser.nextText();
                        this.setDelimiter((String)object);
                    } else {
                        string4 = "Prefix";
                        n13 = (int)(string4.equals(object) ? 1 : 0);
                        if (n13 != 0) {
                            if (n12) {
                                object = xmlPullParser.nextText();
                                n10 = (int)(OSSUtils.isEmptyString((String)object) ? 1 : 0);
                                if (!n10) {
                                    this.addCommonPrefix((String)object);
                                }
                            } else {
                                object = xmlPullParser.nextText();
                                this.setPrefix((String)object);
                            }
                        } else {
                            string4 = "MaxUploads";
                            n13 = (int)(string4.equals(object) ? 1 : 0);
                            if (n13 != 0) {
                                object = xmlPullParser.nextText();
                                n10 = (int)(OSSUtils.isEmptyString((String)object) ? 1 : 0);
                                if (!n10) {
                                    object = Integer.valueOf((String)object);
                                    n11 = (Integer)object;
                                    this.setMaxUploads(n11);
                                }
                            } else {
                                string4 = "IsTruncated";
                                n13 = (int)(string4.equals(object) ? 1 : 0);
                                if (n13 != 0) {
                                    object = xmlPullParser.nextText();
                                    n10 = (int)(OSSUtils.isEmptyString((String)object) ? 1 : 0);
                                    if (!n10) {
                                        object = Boolean.valueOf((String)object);
                                        n11 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                                        this.setTruncated(n11 != 0);
                                    }
                                } else {
                                    string4 = "KeyMarker";
                                    n13 = (int)(string4.equals(object) ? 1 : 0);
                                    if (n13 != 0) {
                                        object = xmlPullParser.nextText();
                                        this.setKeyMarker((String)object);
                                    } else {
                                        string4 = "UploadIdMarker";
                                        n13 = (int)(string4.equals(object) ? 1 : 0);
                                        if (n13 != 0) {
                                            object = xmlPullParser.nextText();
                                            this.setUploadIdMarker((String)object);
                                        } else {
                                            string4 = "NextKeyMarker";
                                            n13 = (int)(string4.equals(object) ? 1 : 0);
                                            if (n13 != 0) {
                                                object = xmlPullParser.nextText();
                                                this.setNextKeyMarker((String)object);
                                            } else {
                                                string4 = "NextUploadIdMarker";
                                                n13 = (int)(string4.equals(object) ? 1 : 0);
                                                if (n13 != 0) {
                                                    object = xmlPullParser.nextText();
                                                    this.setNextUploadIdMarker((String)object);
                                                } else {
                                                    n13 = (int)(string3.equals(object) ? 1 : 0);
                                                    if (n13 != 0) {
                                                        object2 = object = new MultipartUpload();
                                                    } else {
                                                        string4 = "Key";
                                                        n13 = (int)(string4.equals(object) ? 1 : 0);
                                                        if (n13 != 0) {
                                                            object = xmlPullParser.nextText();
                                                            ((MultipartUpload)object2).setKey((String)object);
                                                        } else {
                                                            string4 = "UploadId";
                                                            n13 = (int)(string4.equals(object) ? 1 : 0);
                                                            if (n13 != 0) {
                                                                object = xmlPullParser.nextText();
                                                                ((MultipartUpload)object2).setUploadId((String)object);
                                                            } else {
                                                                string4 = "Initiated";
                                                                n13 = (int)(string4.equals(object) ? 1 : 0);
                                                                if (n13 != 0) {
                                                                    object = DateUtil.parseIso8601Date(xmlPullParser.nextText());
                                                                    ((MultipartUpload)object2).setInitiated((Date)object);
                                                                } else {
                                                                    string4 = "StorageClass";
                                                                    n13 = (int)(string4.equals(object) ? 1 : 0);
                                                                    if (n13 != 0) {
                                                                        object = xmlPullParser.nextText();
                                                                        ((MultipartUpload)object2).setStorageClass((String)object);
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
            if ((n11 = xmlPullParser.next()) != (n10 = 4)) continue;
            n11 = xmlPullParser.next();
        }
        int n14 = arrayList.size();
        if (n14 > 0) {
            this.setMultipartUploads(arrayList);
        }
        return this;
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }

    public void setCommonPrefixes(List list) {
        boolean bl2;
        List list2 = this.commonPrefixes;
        list2.clear();
        if (list != null && !(bl2 = list.isEmpty())) {
            list2 = this.commonPrefixes;
            list2.addAll(list);
        }
    }

    public void setDelimiter(String string2) {
        this.delimiter = string2;
    }

    public void setKeyMarker(String string2) {
        this.keyMarker = string2;
    }

    public void setMaxUploads(int n10) {
        this.maxUploads = n10;
    }

    public void setMultipartUploads(List list) {
        boolean bl2;
        List list2 = this.multipartUploads;
        list2.clear();
        if (list != null && !(bl2 = list.isEmpty())) {
            list2 = this.multipartUploads;
            list2.addAll(list);
        }
    }

    public void setNextKeyMarker(String string2) {
        this.nextKeyMarker = string2;
    }

    public void setNextUploadIdMarker(String string2) {
        this.nextUploadIdMarker = string2;
    }

    public void setPrefix(String string2) {
        this.prefix = string2;
    }

    public void setTruncated(boolean bl2) {
        this.isTruncated = bl2;
    }

    public void setUploadIdMarker(String string2) {
        this.uploadIdMarker = string2;
    }
}

