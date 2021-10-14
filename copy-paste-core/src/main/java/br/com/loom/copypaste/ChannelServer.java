package br.com.loom.copypaste;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ChannelServer {

    public static void main(String[] args) {

        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverChannel = ServerSocketChannel.open();

            serverChannel.bind(new InetSocketAddress("localhost", 12345));
            serverChannel.configureBlocking(false);
            int ops = serverChannel.validOps();
            SelectionKey selectKy = serverChannel.register(selector, ops, null);

            System.out.println("Server started...");

            while (true) {

                selector.select();

                // token representing the registration of a SelectableChannel with a Selector
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> i = selectedKeys.iterator();
                while (i.hasNext()) {

                    SelectionKey selectedKey = i.next();

                    System.out.println("Thread: " + Thread.currentThread().getName());

                    try {
                        if (selectedKey.isAcceptable()) {
                            SocketChannel clientChannel = serverChannel.accept();

                            clientChannel.configureBlocking(false);

                            clientChannel.register(selector, SelectionKey.OP_READ);
                            System.out.println("Connection Accepted: " + clientChannel.getLocalAddress());

                        } else if (selectedKey.isReadable()) {

                            SocketChannel clientChannel = (SocketChannel) selectedKey.channel();

                            ByteBuffer buff = ByteBuffer.allocate(256);
                            clientChannel.read(buff);
                            String result = new String(buff.array()).trim();

                            CompletableFuture<Void> f = CompletableFuture.runAsync(() -> {
                                try {
                                    System.out.println("Requesting " + Thread.currentThread().getName());
                                    Thread.sleep(10000);
                                    System.out.println("Responded " + Thread.currentThread().getName());
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            });
                            f.whenCompleteAsync((unused, throwable) -> {
                                try {

                                    System.out.println("Message received: " + result + " " + Thread.currentThread().getName());
                                    clientChannel.write(ByteBuffer.wrap(result.getBytes()));

                                    if (result.equals("close")) {
                                        System.out.println("Closing connection: " + clientChannel.getLocalAddress());
                                        clientChannel.close();
                                    }

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });


                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    i.remove();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
