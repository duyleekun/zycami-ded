/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.gson;

import cn.leancloud.upload.FileUploadToken;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class FileUploadTokenAdapter
extends TypeAdapter {
    private static final String FIELD_BUCKET = "bucket";
    private static final String FIELD_KEY = "key";
    private static final String FIELD_OBJECTID = "objectId";
    private static final String FIELD_PROVIDER = "provider";
    private static final String FIELD_TOKEN = "token";
    private static final String FIELD_UPLOAD_URL = "upload_url";
    private static final String FIELD_URL = "url";

    public FileUploadToken read(JsonReader object) {
        boolean bl2;
        Object object2 = TypeAdapters.JSON_ELEMENT;
        if ((object = (JsonElement)((TypeAdapter)object2).read((JsonReader)object)) == null && !(bl2 = ((JsonElement)object).isJsonObject())) {
            return null;
        }
        object = ((JsonElement)object).getAsJsonObject();
        object2 = new FileUploadToken();
        String string2 = FIELD_BUCKET;
        boolean bl3 = ((JsonObject)object).has(string2);
        if (bl3) {
            string2 = ((JsonObject)object).get(string2).getAsString();
            ((FileUploadToken)object2).setBucket(string2);
        }
        if (bl3 = ((JsonObject)object).has(string2 = FIELD_OBJECTID)) {
            string2 = ((JsonObject)object).get(string2).getAsString();
            ((FileUploadToken)object2).setObjectId(string2);
        }
        if (bl3 = ((JsonObject)object).has(string2 = FIELD_UPLOAD_URL)) {
            string2 = ((JsonObject)object).get(string2).getAsString();
            ((FileUploadToken)object2).setUploadUrl(string2);
        }
        if (bl3 = ((JsonObject)object).has(string2 = FIELD_PROVIDER)) {
            string2 = ((JsonObject)object).get(string2).getAsString();
            ((FileUploadToken)object2).setProvider(string2);
        }
        if (bl3 = ((JsonObject)object).has(string2 = FIELD_TOKEN)) {
            string2 = ((JsonObject)object).get(string2).getAsString();
            ((FileUploadToken)object2).setToken(string2);
        }
        if (bl3 = ((JsonObject)object).has(string2 = FIELD_URL)) {
            string2 = ((JsonObject)object).get(string2).getAsString();
            ((FileUploadToken)object2).setUrl(string2);
        }
        if (bl3 = ((JsonObject)object).has(string2 = FIELD_KEY)) {
            object = ((JsonObject)object).get(string2).getAsString();
            ((FileUploadToken)object2).setKey((String)object);
        }
        return object2;
    }

    public void write(JsonWriter jsonWriter, FileUploadToken object) {
        JsonObject jsonObject = new JsonObject();
        String string2 = ((FileUploadToken)object).getBucket();
        jsonObject.addProperty(FIELD_BUCKET, string2);
        string2 = ((FileUploadToken)object).getObjectId();
        jsonObject.addProperty(FIELD_OBJECTID, string2);
        string2 = ((FileUploadToken)object).getUploadUrl();
        jsonObject.addProperty(FIELD_UPLOAD_URL, string2);
        string2 = ((FileUploadToken)object).getProvider();
        jsonObject.addProperty(FIELD_PROVIDER, string2);
        string2 = ((FileUploadToken)object).getToken();
        jsonObject.addProperty(FIELD_TOKEN, string2);
        string2 = ((FileUploadToken)object).getUrl();
        jsonObject.addProperty(FIELD_URL, string2);
        object = ((FileUploadToken)object).getKey();
        jsonObject.addProperty(FIELD_KEY, (String)object);
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonObject);
    }
}

