package com.gmail.slisenko.dm.getgif.buffer;

import com.gmail.slisenko.dm.getgif.dao.GifDao;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.*;

public class GifBuffer {
    private static final Logger LOG = LoggerFactory.getLogger(GifBuffer.class);
    private final GifDao dao;
    private final ConcurrentLinkedQueue<String> buffer;
    private final BufferWorker task;
    private final ExecutorService executor;
    private Future<?> status;

    public GifBuffer(GifDao dao) {
        this.dao = dao;
        this.buffer = new ConcurrentLinkedQueue<>();
        task = new BufferWorker();
        ThreadFactory factory = new ThreadFactoryBuilder()
                .setNameFormat("gif-loader")
                .build();
        executor = Executors.newSingleThreadExecutor(factory);
    }

    public Optional<String> getGif() {
        Optional<String> gif = Optional.ofNullable(buffer.poll());
        if (!gif.isPresent()) {
            fillBuffer();
        }
        return gif;
    }

    private void fillBuffer() {
        if (status != null && !status.isDone()) {
            return;
        }
        status = executor.submit(task);
    }

    private class BufferWorker implements Runnable {
        @Override
        public void run() {
            LOG.info("Load GIFs to buffer...");
            try {
                buffer.addAll(dao.getGifs());
            } catch (IOException e) {
                LOG.error("Can't load GIFs: {}", e.getMessage());
            }
        }
    }

}
