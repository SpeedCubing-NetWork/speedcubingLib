package top.speedcubing.lib.api.hypixel.guild;

import com.google.gson.*;
import top.speedcubing.lib.api.hypixel.HypixelLib;
import top.speedcubing.lib.utils.UUIDUtils;

import java.io.*;
import java.net.*;
import java.util.*;

public class HypixelGuild {
    private final JsonObject guild;

    public static HypixelGuild get(String id) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("https://api.hypixel.net/guild?key=" + HypixelLib.key + "&id=" + id).openConnection();
            if (connection.getResponseCode() == 200) {
                JsonObject object = new JsonParser().parse(new InputStreamReader(connection.getInputStream())).getAsJsonObject();
                return object == null ? null : new HypixelGuild(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private HypixelGuild(JsonObject obj) {
        guild = obj == null ? null : obj.getAsJsonObject().getAsJsonObject("guild");
    }

    public List<String> getMembers() {
        List<String> uuids = new ArrayList<>();
        for (JsonElement o : guild.getAsJsonArray("members"))
            uuids.add(UUIDUtils.addDash(o.getAsJsonObject().get("uuid").getAsString()));
        return uuids;
    }
}