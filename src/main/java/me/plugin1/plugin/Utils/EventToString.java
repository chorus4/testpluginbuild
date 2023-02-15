package me.plugin1.plugin.Utils;

import org.bukkit.event.Event;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class EventToString {
    static String eventToString(Event e) {
        try{
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
            dataOutput.writeObject(e);
            return Base64Coder.encodeLines(outputStream.toByteArray());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    static Event stringToEvent(String e) {
        try{
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(e));
            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
            Event event = (Event) dataInput.readObject();
            return event;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
