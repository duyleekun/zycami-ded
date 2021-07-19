/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  org.json.JSONObject
 */
package cn.sharesdk.framework;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.utils.Hashon;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class InnerShareParams {
    public static final String ACTIVITY = "activity";
    public static final String ADDRESS = "address";
    public static final String AUTHOR = "author";
    public static final String COMMENT = "comment";
    public static final String CONTENT_TYPE = "contentType";
    public static final String CUSTOM_FLAG = "customFlag";
    public static final String EXECUTE_URL = "executeUrl";
    public static final String EXT_INFO = "extInfo";
    public static final String FILE_IMAGE = "file_image";
    public static final String FILE_PATH = "filePath";
    public static final String FILE_STICKER = "file_sticker";
    public static final String FILE_VIDEO = "file_video";
    public static final String GROPU_ID = "groupID";
    public static final String HASHTAG = "HASHTAG";
    public static final String HIDDEN = "hidden";
    public static final String IMAGE_ARRAY = "imageArray";
    public static final String IMAGE_DATA = "imageData";
    public static final String IMAGE_FILE_PROVIDER_PATH = "image_provider_path";
    public static final String IMAGE_PATH = "imagePath";
    public static final String IMAGE_URI_LIST = "imageUriList";
    public static final String IMAGE_URL = "imageUrl";
    public static final String IMAGE_URL_LIST = "imageUrlList";
    public static final String INSTALL_URL = "installUrl";
    public static final String IS_FAMILY = "isFamily";
    public static final String IS_FRIEND = "isFriend";
    public static final String IS_LOG_EVEN = "isLogEven";
    public static final String IS_PUBLIC = "isPublic";
    public static final String IS_SHARE_TENCENT_WEIBO = "isShareTencentWeibo";
    public static final String KAKAO_CUSTOM_TEMPLATE = "kaokao_custom_template";
    public static final String KAKAO_CUSTOM_TEMPLATEID = "kakao_custom_templateid";
    public static final String KAKAO_TEMPLATE_ADDBUTTON_MOBILEWEBURL = "kaokao_template_button_mobileweburl";
    public static final String KAKAO_TEMPLATE_ADDBUTTON_TITLE = "kakao_template_button_title";
    public static final String KAKAO_TEMPLATE_ADDBUTTON_WEBURL = "kakao_template_button_weburl";
    public static final String KAKAO_TEMPLATE_COMMENTCOUNT = "kakao_template_commentcount";
    public static final String KAKAO_TEMPLATE_DISCOUNTPRICE = "kakao_template_discountprice";
    public static final String KAKAO_TEMPLATE_DISCOUNTRATE = "kakao_template_discountrate";
    public static final String KAKAO_TEMPLATE_LIKECOUNT = "kakao_template_likecount";
    public static final String KAKAO_TEMPLATE_MOBILEWEBURL = "kakao_template_mobileweburl";
    public static final String KAKAO_TEMPLATE_PRODUCTNAME = "kakao_template_productname";
    public static final String KAKAO_TEMPLATE_REGULARPRICE = "kaokao_template_regularprice";
    public static final String KAKAO_TEMPLATE_SHARECOUNT = "kakao_template_sharecount";
    public static final String KAKAO_TEMPLATE_WEBURL = "kakao_template_weburl";
    public static final String LATITUDE = "latitude";
    public static final String LC_CREATE_AT = "lc_create_at";
    public static final String LC_DISPLAY_NAME = "lc_display_name";
    public static final String LC_IMAGE = "lc_image";
    public static final String LC_OBJECT_TYPE = "lc_object_type";
    public static final String LC_SUMMARY = "lc_summary";
    public static final String LC_URL = "lc_url";
    public static final String LINKEDIN_DESCRIPTION = "linkedinDescription";
    public static final String LONGITUDE = "longitude";
    public static final String LOOPSHARE_PARAMS_MOBID = "loopshare_params_mobid";
    public static final String MUSIC_URL = "musicUrl";
    public static final String NOTEBOOK = "notebook";
    public static final String QQ_MINI_PROGRAM_APPID = "mini_program_appid";
    public static final String QQ_MINI_PROGRAM_PATH = "mini_program_path";
    public static final String QQ_MINI_PROGRAM_TYPE = "mini_program_type";
    public static final String QUOTE = "QUOTE";
    public static final String SAFETY_LEVEL = "safetyLevel";
    public static final String SCENCE = "scene";
    public static final String SHARE_TYPE = "shareType";
    public static final String SITE = "site";
    public static final String SITE_URL = "siteUrl";
    public static final String STACK = "stack";
    public static final String SUBREDDIT = "sr";
    public static final String TAGS = "tags";
    public static final String TEXT = "text";
    public static final String TITLE = "title";
    public static final String TITLE_URL = "titleUrl";
    public static final String URL = "url";
    public static final String VENUE_DESCRIPTION = "venueDescription";
    public static final String VENUE_NAME = "venueName";
    public static final String VIDEO_ARRAY = "videoArray";
    public static final String VIDEO_PATH_OASIS = "video_path_oasis";
    public static final String VIDEO_URI = "video_uri";
    public static final String VIDEO_URI_OASIS = "video_uri_oasis";
    public static final String WX_MINIPROGRAM_MINIPROGRAM_TYPE = "wxMiniProgramType";
    public static final String WX_MINIPROGRAM_PATH = "wxPath";
    public static final String WX_MINIPROGRAM_USER_NAME = "wxUserName";
    public static final String WX_MINIPROGRAM_WITH_SHARETICKET = "wxWithShareTicket";
    public static final String WX_RESERVED = "wx_reserved";
    public static final String WX_SCENE = "wx_scene";
    public static final String WX_TEMPLATEID = "wx_templateid";
    private HashMap params;

    public InnerShareParams() {
        HashMap hashMap;
        this.params = hashMap = new HashMap();
    }

    public InnerShareParams(String object) {
        Hashon hashon = new Hashon();
        object = hashon.fromJson((String)object);
        this((HashMap)object);
    }

    public InnerShareParams(HashMap hashMap) {
        this();
        if (hashMap != null) {
            HashMap hashMap2 = this.params;
            hashMap2.putAll(hashMap);
        }
    }

    public Object get(String clazz, Class clazz2) {
        HashMap hashMap = this.params;
        if ((clazz = hashMap.get(clazz)) != null) {
            return clazz2.cast(clazz);
        }
        clazz = Byte.class;
        boolean bl2 = clazz.equals(clazz2);
        hashMap = null;
        if (!bl2 && !(bl2 = (clazz = Byte.TYPE).equals(clazz2))) {
            clazz = Short.class;
            bl2 = clazz.equals(clazz2);
            if (!bl2 && !(bl2 = (clazz = Short.TYPE).equals(clazz2))) {
                clazz = Integer.class;
                bl2 = clazz.equals(clazz2);
                if (!bl2 && !(bl2 = (clazz = Integer.TYPE).equals(clazz2))) {
                    clazz = Long.class;
                    bl2 = clazz.equals(clazz2);
                    if (!bl2 && !(bl2 = (clazz = Long.TYPE).equals(clazz2))) {
                        clazz = Float.class;
                        bl2 = clazz.equals(clazz2);
                        if (!bl2 && !(bl2 = (clazz = Float.TYPE).equals(clazz2))) {
                            clazz = Double.class;
                            bl2 = clazz.equals(clazz2);
                            if (!bl2 && !(bl2 = (clazz = Double.TYPE).equals(clazz2))) {
                                clazz = Boolean.class;
                                bl2 = clazz.equals(clazz2);
                                if (!bl2 && !(bl2 = (clazz = Boolean.TYPE).equals(clazz2))) {
                                    clazz = HashMap.class;
                                    bl2 = clazz.equals(clazz2);
                                    if (!bl2 && !(bl2 = (clazz = Map.class).equals(clazz2))) {
                                        return null;
                                    }
                                    clazz = new Class();
                                    return clazz2.cast(clazz);
                                }
                                clazz = Boolean.FALSE;
                                return clazz2.cast(clazz);
                            }
                            clazz = new Class(0.0);
                            return clazz2.cast(clazz);
                        }
                        clazz = new Class(0.0f);
                        return clazz2.cast(clazz);
                    }
                    clazz = new Class(0L);
                    return clazz2.cast(clazz);
                }
                clazz = new Class(0);
                return clazz2.cast(clazz);
            }
            clazz = new Class(0);
            return clazz2.cast(clazz);
        }
        clazz = new Class(0);
        return clazz2.cast(clazz);
    }

    public Activity getActivity() {
        return (Activity)this.get(ACTIVITY, Activity.class);
    }

    public String getAddress() {
        return (String)this.get(ADDRESS, String.class);
    }

    public String getAuthor() {
        return (String)this.get(AUTHOR, String.class);
    }

    public String getComment() {
        return (String)this.get(COMMENT, String.class);
    }

    public int getContentType() {
        return (Integer)this.get(CONTENT_TYPE, Integer.class);
    }

    public String[] getCustomFlag() {
        return (String[])this.get(CUSTOM_FLAG, String[].class);
    }

    public String getExtInfo() {
        return (String)this.get(EXT_INFO, String.class);
    }

    public File getFileImage() {
        return (File)this.get(FILE_IMAGE, File.class);
    }

    public String getFilePath() {
        return (String)this.get(FILE_PATH, String.class);
    }

    public File getFileVideo() {
        return (File)this.get(FILE_VIDEO, File.class);
    }

    public String getGroupId() {
        return (String)this.get(GROPU_ID, String.class);
    }

    public String getHashtag() {
        return (String)this.get(HASHTAG, String.class);
    }

    public int getHidden() {
        return (Integer)this.get(HIDDEN, Integer.class);
    }

    public String[] getImageArray() {
        return (String[])this.get(IMAGE_ARRAY, String[].class);
    }

    public Bitmap getImageData() {
        return (Bitmap)this.get(IMAGE_DATA, Bitmap.class);
    }

    public String getImageFileProviderPath() {
        return (String)this.get(IMAGE_FILE_PROVIDER_PATH, String.class);
    }

    public String getImagePath() {
        return (String)this.get(IMAGE_PATH, String.class);
    }

    public List getImageUriList() {
        return (List)this.get(IMAGE_URI_LIST, List.class);
    }

    public String getImageUrl() {
        return (String)this.get(IMAGE_URL, String.class);
    }

    public List getImageUrlList() {
        return (List)this.get(IMAGE_URL_LIST, List.class);
    }

    public String getKakaoAddbuttonMobileweburl() {
        return (String)this.get(KAKAO_TEMPLATE_ADDBUTTON_MOBILEWEBURL, String.class);
    }

    public String getKakaoAddbuttonTitle() {
        return (String)this.get(KAKAO_TEMPLATE_ADDBUTTON_TITLE, String.class);
    }

    public String getKakaoAddbuttonWeburl() {
        return (String)this.get(KAKAO_TEMPLATE_ADDBUTTON_WEBURL, String.class);
    }

    public int getKakaoCommentcount() {
        return (Integer)this.get(KAKAO_TEMPLATE_COMMENTCOUNT, Integer.class);
    }

    public HashMap getKakaoCustomTemplate() {
        return (HashMap)this.get(KAKAO_CUSTOM_TEMPLATE, HashMap.class);
    }

    public String getKakaoCustomTemplateId() {
        return (String)this.get(KAKAO_CUSTOM_TEMPLATEID, String.class);
    }

    public int getKakaoDiscountprice() {
        return (Integer)this.get(KAKAO_TEMPLATE_DISCOUNTPRICE, Integer.class);
    }

    public int getKakaoDiscountrate() {
        return (Integer)this.get(KAKAO_TEMPLATE_DISCOUNTRATE, Integer.class);
    }

    public int getKakaoLikecount() {
        return (Integer)this.get(KAKAO_TEMPLATE_LIKECOUNT, Integer.class);
    }

    public String getKakaoMobileweburl() {
        return (String)this.get(KAKAO_TEMPLATE_MOBILEWEBURL, String.class);
    }

    public int getKakaoRegularprice() {
        return (Integer)this.get(KAKAO_TEMPLATE_REGULARPRICE, Integer.class);
    }

    public int getKakaoSharecount() {
        return (Integer)this.get(KAKAO_TEMPLATE_SHARECOUNT, Integer.class);
    }

    public String getKakaoTemplateProductname() {
        return (String)this.get(KAKAO_TEMPLATE_PRODUCTNAME, String.class);
    }

    public String getKakaoWebUrl() {
        return (String)this.get(KAKAO_TEMPLATE_WEBURL, String.class);
    }

    public float getLatitude() {
        return ((Float)this.get(LATITUDE, Float.class)).floatValue();
    }

    public String getLcCreateAt() {
        return (String)this.get(LC_CREATE_AT, String.class);
    }

    public String getLcDisplayName() {
        return (String)this.get(LC_DISPLAY_NAME, String.class);
    }

    public JSONObject getLcImage() {
        return (JSONObject)this.get(LC_IMAGE, JSONObject.class);
    }

    public String getLcObjectType() {
        return (String)this.get(LC_OBJECT_TYPE, String.class);
    }

    public String getLcSummary() {
        return (String)this.get(LC_SUMMARY, String.class);
    }

    public String getLcUrl() {
        return (String)this.get(LC_URL, String.class);
    }

    public String getLinkedinDsscription() {
        return (String)this.get(LINKEDIN_DESCRIPTION, String.class);
    }

    public float getLongitude() {
        return ((Float)this.get(LONGITUDE, Float.class)).floatValue();
    }

    public HashMap getLoopshareCustomParams() {
        return (HashMap)this.get(LOOPSHARE_PARAMS_MOBID, HashMap.class);
    }

    public String getMusicUrl() {
        return (String)this.get(MUSIC_URL, String.class);
    }

    public String getNotebook() {
        return (String)this.get(NOTEBOOK, String.class);
    }

    public boolean getOpenCustomEven() {
        return (Boolean)this.get(IS_LOG_EVEN, Boolean.class);
    }

    public String getQQMiniProgramAppid() {
        return (String)this.get(QQ_MINI_PROGRAM_APPID, String.class);
    }

    public String getQQMiniProgramPath() {
        return (String)this.get(QQ_MINI_PROGRAM_PATH, String.class);
    }

    public String getQQMiniProgramType() {
        return (String)this.get(QQ_MINI_PROGRAM_TYPE, String.class);
    }

    public String getQuote() {
        return (String)this.get(QUOTE, String.class);
    }

    public int getSafetyLevel() {
        return (Integer)this.get(SAFETY_LEVEL, Integer.class);
    }

    public int getScence() {
        return (Integer)this.get(SCENCE, Integer.class);
    }

    public int getShareType() {
        return (Integer)this.get(SHARE_TYPE, Integer.class);
    }

    public String getSite() {
        return (String)this.get(SITE, String.class);
    }

    public String getSiteUrl() {
        return (String)this.get(SITE_URL, String.class);
    }

    public String getStack() {
        return (String)this.get(STACK, String.class);
    }

    public File getStickerFile() {
        return (File)this.get(FILE_STICKER, File.class);
    }

    public String getSubreddit() {
        return (String)this.get(SUBREDDIT, String.class);
    }

    public String[] getTags() {
        return (String[])this.get(TAGS, String[].class);
    }

    public String getText() {
        return (String)this.get(TEXT, String.class);
    }

    public String getTitle() {
        return (String)this.get(TITLE, String.class);
    }

    public String getTitleUrl() {
        return (String)this.get(TITLE_URL, String.class);
    }

    public String getUrl() {
        return (String)this.get(URL, String.class);
    }

    public String getVenueDescription() {
        return (String)this.get(VENUE_DESCRIPTION, String.class);
    }

    public String getVenueName() {
        return (String)this.get(VENUE_NAME, String.class);
    }

    public String[] getVideoPathArray() {
        return (String[])this.get(VIDEO_ARRAY, String[].class);
    }

    public String getVideoPathOasis() {
        return (String)this.get(VIDEO_PATH_OASIS, String.class);
    }

    public Uri getVideoUri() {
        return (Uri)this.get(VIDEO_URI, Uri.class);
    }

    public Uri getVideoUriOasis() {
        return (Uri)this.get(VIDEO_URI_OASIS, Uri.class);
    }

    public int getWxMiniProgramType() {
        return (Integer)this.get(WX_MINIPROGRAM_MINIPROGRAM_TYPE, Integer.class);
    }

    public String getWxPath() {
        return (String)this.get(WX_MINIPROGRAM_PATH, String.class);
    }

    public String getWxReserved() {
        return (String)this.get(WX_RESERVED, String.class);
    }

    public String getWxTemplateid() {
        return (String)this.get(WX_TEMPLATEID, String.class);
    }

    public String getWxUserName() {
        return (String)this.get(WX_MINIPROGRAM_USER_NAME, String.class);
    }

    public boolean getWxWithShareTicket() {
        return (Boolean)this.get(WX_MINIPROGRAM_WITH_SHARETICKET, Boolean.class);
    }

    public boolean isFamily() {
        return (Boolean)this.get(IS_FAMILY, Boolean.class);
    }

    public boolean isFriend() {
        return (Boolean)this.get(IS_FRIEND, Boolean.class);
    }

    public boolean isPublic() {
        return (Boolean)this.get(IS_PUBLIC, Boolean.class);
    }

    public boolean isShareTencentWeibo() {
        return (Boolean)this.get(IS_SHARE_TENCENT_WEIBO, Boolean.class);
    }

    public void set(String string2, Object object) {
        this.params.put(string2, object);
    }

    public void setActivity(Activity activity) {
        this.set(ACTIVITY, activity);
    }

    public void setAddress(String string2) {
        this.set(ADDRESS, string2);
    }

    public void setAuthor(String string2) {
        this.set(AUTHOR, string2);
    }

    public void setComment(String string2) {
        this.set(COMMENT, string2);
    }

    public void setContentType(int n10) {
        Integer n11 = n10;
        this.set(CONTENT_TYPE, n11);
    }

    public void setCustomFlag(String[] stringArray) {
        this.set(CUSTOM_FLAG, stringArray);
    }

    public void setExtInfo(String string2) {
        this.set(EXT_INFO, string2);
    }

    public void setFamily(boolean bl2) {
        Boolean bl3 = bl2;
        this.set(IS_FAMILY, bl3);
    }

    public void setFileImage(File file) {
        this.set(FILE_IMAGE, file);
    }

    public void setFilePath(String string2) {
        this.set(FILE_PATH, string2);
    }

    public void setFileSticker(File file) {
        this.set(FILE_STICKER, file);
    }

    public void setFileVideo(File file) {
        this.set(FILE_VIDEO, file);
    }

    public void setFriend(boolean bl2) {
        Boolean bl3 = bl2;
        this.set(IS_FRIEND, bl3);
    }

    public void setGroupId(String string2) {
        this.set(GROPU_ID, string2);
    }

    public void setHashtag(String string2) {
        this.set(HASHTAG, string2);
    }

    public void setHidden(int n10) {
        Integer n11 = n10;
        this.set(HIDDEN, n11);
    }

    public void setImageArray(String[] stringArray) {
        this.set(IMAGE_ARRAY, stringArray);
    }

    public void setImageData(Bitmap bitmap) {
        this.set(IMAGE_DATA, bitmap);
    }

    public void setImageFileProviderPath(String string2) {
        this.set(IMAGE_FILE_PROVIDER_PATH, string2);
    }

    public void setImagePath(String string2) {
        this.set(IMAGE_PATH, string2);
    }

    public void setImageUriList(List list) {
        this.set(IMAGE_URI_LIST, list);
    }

    public void setImageUrl(String string2) {
        this.set(IMAGE_URL, string2);
    }

    public void setImageUrlList(List list) {
        this.set(IMAGE_URL_LIST, list);
    }

    public void setKakaoAddbuttonMobileweburl(String string2) {
        this.set(KAKAO_TEMPLATE_ADDBUTTON_MOBILEWEBURL, string2);
    }

    public void setKakaoAddbuttonTitle(String string2) {
        this.set(KAKAO_TEMPLATE_ADDBUTTON_TITLE, string2);
    }

    public void setKakaoAddbuttonWeburl(String string2) {
        this.set(KAKAO_TEMPLATE_ADDBUTTON_WEBURL, string2);
    }

    public void setKakaoCommentcount(int n10) {
        Integer n11 = n10;
        this.set(KAKAO_TEMPLATE_COMMENTCOUNT, n11);
    }

    public void setKakaoCustomTemplate(HashMap hashMap) {
        this.set(KAKAO_CUSTOM_TEMPLATE, hashMap);
    }

    public void setKakaoCustomTemplateId(String string2) {
        this.set(KAKAO_CUSTOM_TEMPLATEID, string2);
    }

    public void setKakaoDiscountprice(int n10) {
        Integer n11 = n10;
        this.set(KAKAO_TEMPLATE_DISCOUNTPRICE, n11);
    }

    public void setKakaoDiscountrate(int n10) {
        Integer n11 = n10;
        this.set(KAKAO_TEMPLATE_DISCOUNTRATE, n11);
    }

    public void setKakaoLikecount(int n10) {
        Integer n11 = n10;
        this.set(KAKAO_TEMPLATE_LIKECOUNT, n11);
    }

    public void setKakaoMobileWebUrl(String string2) {
        this.set(KAKAO_TEMPLATE_MOBILEWEBURL, string2);
    }

    public void setKakaoProductname(String string2) {
        this.set(KAKAO_TEMPLATE_PRODUCTNAME, string2);
    }

    public void setKakaoRegularprice(int n10) {
        Integer n11 = n10;
        this.set(KAKAO_TEMPLATE_REGULARPRICE, n11);
    }

    public void setKakaoSharecount(int n10) {
        Integer n11 = n10;
        this.set(KAKAO_TEMPLATE_SHARECOUNT, n11);
    }

    public void setKakaoWebUrl(String string2) {
        this.set(KAKAO_TEMPLATE_WEBURL, string2);
    }

    public void setLatitude(float f10) {
        Float f11 = Float.valueOf(f10);
        this.set(LATITUDE, f11);
    }

    public void setLcCreateAt(String string2) {
        this.set(LC_CREATE_AT, string2);
    }

    public void setLcDisplayName(String string2) {
        this.set(LC_DISPLAY_NAME, string2);
    }

    public void setLcImage(JSONObject jSONObject) {
        this.set(LC_IMAGE, jSONObject);
    }

    public void setLcObjectType(String string2) {
        this.set(LC_OBJECT_TYPE, string2);
    }

    public void setLcSummary(String string2) {
        this.set(LC_SUMMARY, string2);
    }

    public void setLcUrl(String string2) {
        this.set(LC_URL, string2);
    }

    public void setLinkedinDescription(String string2) {
        this.set(LINKEDIN_DESCRIPTION, string2);
    }

    public void setLongitude(float f10) {
        Float f11 = Float.valueOf(f10);
        this.set(LONGITUDE, f11);
    }

    public void setLoopshareCustomParams(HashMap hashMap) {
        this.set(LOOPSHARE_PARAMS_MOBID, hashMap);
    }

    public void setMusicUrl(String string2) {
        this.set(MUSIC_URL, string2);
    }

    public void setNotebook(String string2) {
        this.set(NOTEBOOK, string2);
    }

    public void setOpenCustomEven(boolean bl2) {
        Boolean bl3 = bl2;
        this.set(IS_LOG_EVEN, bl3);
    }

    public void setPublic(boolean bl2) {
        Boolean bl3 = bl2;
        this.set(IS_PUBLIC, bl3);
    }

    public void setQQMiniProgramAppid(String string2) {
        this.set(QQ_MINI_PROGRAM_APPID, string2);
    }

    public void setQQMiniProgramPath(String string2) {
        this.set(QQ_MINI_PROGRAM_PATH, string2);
    }

    public void setQQMiniProgramType(String string2) {
        this.set(QQ_MINI_PROGRAM_TYPE, string2);
    }

    public void setQuote(String string2) {
        this.set(QUOTE, string2);
    }

    public void setSafetyLevel(int n10) {
        Integer n11 = n10;
        this.set(SAFETY_LEVEL, n11);
    }

    public void setScence(int n10) {
        Integer n11 = n10;
        this.set(SCENCE, n11);
    }

    public void setShareTencentWeibo(boolean bl2) {
        Boolean bl3 = bl2;
        this.set(IS_SHARE_TENCENT_WEIBO, bl3);
    }

    public void setShareType(int n10) {
        Integer n11 = n10;
        this.set(SHARE_TYPE, n11);
    }

    public void setSite(String string2) {
        this.set(SITE, string2);
    }

    public void setSiteUrl(String string2) {
        this.set(SITE_URL, string2);
    }

    public void setStack(String string2) {
        this.set(STACK, string2);
    }

    public void setSubreddit(String string2) {
        this.set(SUBREDDIT, string2);
    }

    public void setTags(String[] stringArray) {
        this.set(TAGS, stringArray);
    }

    public void setText(String string2) {
        this.set(TEXT, string2);
    }

    public void setTitle(String string2) {
        this.set(TITLE, string2);
    }

    public void setTitleUrl(String string2) {
        this.set(TITLE_URL, string2);
    }

    public void setUrl(String string2) {
        this.set(URL, string2);
    }

    public void setVenueDescription(String string2) {
        this.set(VENUE_DESCRIPTION, string2);
    }

    public void setVenueName(String string2) {
        this.set(VENUE_NAME, string2);
    }

    public void setVideoPathArray(String[] stringArray) {
        this.set(VIDEO_ARRAY, stringArray);
    }

    public void setVideoPathOasis(String string2) {
        this.set(VIDEO_PATH_OASIS, string2);
    }

    public void setVideoUri(Uri uri) {
        this.set(VIDEO_URI, uri);
    }

    public void setVideoUriOasis(Uri uri) {
        this.set(VIDEO_URI_OASIS, uri);
    }

    public void setWxMiniProgramType(int n10) {
        Integer n11 = n10;
        this.set(WX_MINIPROGRAM_MINIPROGRAM_TYPE, n11);
    }

    public void setWxPath(String string2) {
        this.set(WX_MINIPROGRAM_PATH, string2);
    }

    public void setWxReserved(String string2) {
        this.set(WX_RESERVED, string2);
    }

    public void setWxTemplateid(String string2) {
        this.set(WX_TEMPLATEID, string2);
    }

    public void setWxUserName(String string2) {
        this.set(WX_MINIPROGRAM_USER_NAME, string2);
    }

    public void setWxWithShareTicket(boolean bl2) {
        Boolean bl3 = bl2;
        this.set(WX_MINIPROGRAM_WITH_SHARETICKET, bl3);
    }

    public HashMap toMap() {
        HashMap hashMap = this.params;
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        return hashMap;
    }

    public String toString() {
        HashMap hashMap;
        Hashon hashon;
        try {
            hashon = new Hashon();
            hashMap = this.params;
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            return null;
        }
        return hashon.fromHashMap(hashMap);
    }
}

