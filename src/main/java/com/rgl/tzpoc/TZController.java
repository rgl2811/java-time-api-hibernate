package com.rgl.tzpoc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Optional;

@RestController
public class TZController {

    private TZEntityRepository repo;

    public TZController(TZEntityRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/")
    public TZEntity test() {
        TZEntity entity = new TZEntity();

        OffsetDateTime dt = OffsetDateTime.now().atZoneSameInstant(ZoneOffset.UTC).toOffsetDateTime();
        entity.setDateOffset(dt);

        ZonedDateTime zonedDateTimeAmerica = ZonedDateTime.now(ZoneId.of("America/Virgin"));
        entity.setZonedDateTimeAmerica(zonedDateTimeAmerica);

        ZonedDateTime zonedDateTimeLocal = ZonedDateTime.now();
        entity.setZonedDateTimeLocal(zonedDateTimeLocal);

        Instant instant = Instant.now();
        entity.setInstant(instant);

        Duration duration = Duration.between(instant, zonedDateTimeLocal
                .plusMonths(1)
                .plusDays(3)
                .plusHours(9)
                .plusMinutes(1)
                .plusSeconds(10));
        entity.setDuration(duration);

        repo.save(entity);

        return entity;
    }

    @RequestMapping(value = "/{id}")
    public TZEntity testGet(@PathVariable("id") long id) {
        Optional<TZEntity> entity = repo.findById(id);
        entity.get().setZonedDateTimeAmerica(entity.get().getZonedDateTimeAmerica().withZoneSameInstant(ZoneId.of("America/Virgin")));
        return entity.orElse(null);
    }

}
