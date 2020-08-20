package br.com.loom.copypaste;

import br.com.loom.copypaste.configuration.Configuration;
import br.com.loom.copypaste.message.Message;
import br.com.loom.copypaste.step.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.stream.Collectors;

public class CopyPaste {

    private static final Logger log = LoggerFactory.getLogger(CopyPaste.class);

    Map<String, Step> entryPoints;

    protected CopyPaste(Configuration configuration) {
        entryPoints = configuration
                .getProcesses()
                .stream()
                .collect(Collectors.toMap(
                        process -> process.getName(),
                        process -> new Step())
                );

    }

    public Message process(String process, Message message) {
        return null;
    }

}
