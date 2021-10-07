package br.com.loom.copypaste.message;

import com.google.gson.JsonElement;

import java.util.LinkedHashMap;

public class Message extends LinkedHashMap<String, String> {

    protected String process;
    protected String version;
    protected String step;

    protected JsonElement element;

}
