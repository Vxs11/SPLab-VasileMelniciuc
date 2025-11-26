package ro.uvt.events;

import org.springframework.web.bind.annotation.*;
import ro.uvt.observer.EventsSubject;

@RestController
@RequestMapping("/trigger")
public class TriggerController {

    private final EventsSubject subject;

    public TriggerController(EventsSubject subject) {
        this.subject = subject;
    }

    @PostMapping
    public void sendMessage(@RequestBody String msg) {
        subject.notifyObservers(msg);
    }
}
