package ro.uvt.observer;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class EventsSubject implements Subject {

    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    @Override
    public void register(Observer observer) {
    }

    public void registerEmitter(SseEmitter emitter) {
        emitters.add(emitter);
    }

    @Override
    public void unregister(Observer observer) {
    }

    public void removeEmitter(SseEmitter emitter) {
        emitters.remove(emitter);
    }

    @Override
    public void notifyObservers(String message) {
        for (SseEmitter emitter : emitters) {
            try {
                emitter.send(SseEmitter.event().data(message));
            } catch (IOException e) {
                emitters.remove(emitter);
            }
        }
    }
}
