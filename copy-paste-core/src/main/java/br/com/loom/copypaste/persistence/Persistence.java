package br.com.loom.copypaste.persistence;

import br.com.loom.copypaste.message.Message;

import java.util.List;

public interface Persistence {

    void store(Message message);

    List<Message> fetch();

}
