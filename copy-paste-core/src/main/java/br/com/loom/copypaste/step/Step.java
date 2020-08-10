package br.com.loom.copypaste.step;

import br.com.loom.copypaste.message.Message;

public class Step {

    public Message execute(Message message) {
        return message;
    }

    public Message revert(Message message) {
        return message;
    }

}
