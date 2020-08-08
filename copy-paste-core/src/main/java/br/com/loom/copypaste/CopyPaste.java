package br.com.loom.copypaste;

import br.com.loom.copypaste.step.Entrypoint;

import java.util.Map;

public class CopyPaste {

    Map<String, Entrypoint> entryPoints;

    public Message process(String process, Message message) {
        return entryPoints.get(process).execute(message);
    }

}
