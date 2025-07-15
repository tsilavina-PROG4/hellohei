package school.prog.hellohei.endpoint.event.consumer.model;

import school.prog.hellohei.PojaGenerated;
import school.prog.hellohei.endpoint.event.model.PojaEvent;

@PojaGenerated
public record TypedEvent(String typeName, PojaEvent payload) {}
