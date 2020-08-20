package br.com.loom.copypaste.step;

import br.com.loom.copypaste.CopyPaste;
import br.com.loom.copypaste.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Echo extends Step {

    private static final Logger log = LoggerFactory.getLogger(CopyPaste.class);

    @Override
    public Message execute(Message message) {
        log.info("executing: " + message.toString());
        return super.execute(message);
    }

    @Override
    public Message revert(Message message) {
        log.info("revert: " + message.toString());
        return super.revert(message);
    }
}
