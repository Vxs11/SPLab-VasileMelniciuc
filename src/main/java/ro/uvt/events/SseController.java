package ro.uvt.events;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.observer.EventsSubject;

@RestController
public class SseController {

    private final EventsSubject subject;

    public SseController(EventsSubject subject) {
        this.subject = subject;
    }

    @GetMapping("/events")
    public SseEmitter subscribe() {
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        subject.registerEmitter(emitter);
        emitter.onCompletion(() -> subject.removeEmitter(emitter));
        emitter.onTimeout(() -> subject.removeEmitter(emitter));
        emitter.onError(e -> subject.removeEmitter(emitter));
        return emitter;
    }
}
