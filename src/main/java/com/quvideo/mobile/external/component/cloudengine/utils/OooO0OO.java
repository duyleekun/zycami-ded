/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaMetadataRetriever
 */
package com.quvideo.mobile.external.component.cloudengine.utils;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.MediaType;
import com.quvideo.mobile.external.component.cloudengine.model.CompositeConfig$Media;
import com.quvideo.mobile.external.platform.log.OooO00o;
import java.util.List;

public class OooO0OO {
    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean OooO00o(Context object, List object2) {
        MediaType mediaType;
        Object object3;
        String string2 = "VideoHelper";
        Object object4 = "start to calculate duration";
        OooO00o.OooO00o(string2, (String)object4);
        object3 = object3.iterator();
        while (true) {
            int n10 = object3.hasNext();
            boolean bl2 = true;
            if (n10 != 0) {
                block28: {
                    MediaType mediaType2;
                    object4 = (CompositeConfig$Media)object3.next();
                    mediaType = ((CompositeConfig$Media)object4).getMediaType();
                    if (mediaType != (mediaType2 = MediaType.VIDEO)) continue;
                    mediaType = new MediaMetadataRetriever();
                    object4 = ((CompositeConfig$Media)object4).getUri();
                    object4 = object4.getPath();
                    mediaType.setDataSource((String)object4);
                    n10 = 9;
                    object4 = mediaType.extractMetadata(n10);
                    if (object4 == null) break block28;
                    int n11 = ((String)object4).length();
                    if (n11 <= 0) break block28;
                    long l10 = Long.parseLong((String)object4);
                    long l11 = 60000L;
                    n11 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
                    if (n11 <= 0) {
                        mediaType.release();
                    }
                }
                object3 = new StringBuilder();
                String string3 = "duration of video is out of range(<60s) - ";
                ((StringBuilder)object3).append(string3);
                ((StringBuilder)object3).append((String)object4);
                object3 = ((StringBuilder)object3).toString();
                OooO00o.OooO00o(string2, (String)object3);
                Object var0_2 = null;
                mediaType.release();
                return false;
                catch (Throwable throwable) {
                    String string4 = throwable.getMessage();
                    OooO00o.OooO00o(string2, string4);
                    return bl2;
                }
            }
            OooO00o.OooO00o(string2, "end to calculate duration");
            return bl2;
            catch (Exception exception) {}
        }
        catch (Exception exception) {
            return false;
        }
        {
            finally {
                mediaType.release();
            }
        }
    }
}

