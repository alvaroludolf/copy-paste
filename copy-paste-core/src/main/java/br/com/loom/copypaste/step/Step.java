package br.com.loom.copypaste.step;

import br.com.loom.copypaste.message.Message;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Echo.class, name = "echo"),
        @JsonSubTypes.Type(value = Terminal.class, name = "terminal")
})
public class Step {

    private static final Logger log = LoggerFactory.getLogger(Step.class);

    public Message execute(Message message) {
        return message;
    }

    public Message revert(Message message) {
        return message;
    }

    protected Map<String, String> properties = new HashMap<>();

    @JsonAnySetter
    protected void add(String key, String value) {
        properties.put(key, value);
    }

}
