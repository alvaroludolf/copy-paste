package br.com.loom.copypaste.message;

import com.google.gson.JsonNull;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class MessageFactory {

    public static Message message() {

        Message message = new Message();
        message.element = JsonNull.INSTANCE;

        return message;
    }

    public static Message message(InputStream is) {

        Message message = new Message();
        message.element = JsonParser.parseReader(new InputStreamReader(is, StandardCharsets.UTF_8));

        return message;
    }

    public static Message message(Reader r) {

        Message message = new Message();
        message.element = JsonParser.parseReader(r);

        return message;
    }

}
