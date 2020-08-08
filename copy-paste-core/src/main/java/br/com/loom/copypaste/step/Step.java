package br.com.loom.copypaste.step;

import br.com.loom.copypaste.Message;

public class Step {

    private Step next;

    public Message execute(Message message) {
        if (next != null)
            return next.execute(message);
        else
            return message;
    }

    public Message revert(Message message) {
        return message;
    }

}
