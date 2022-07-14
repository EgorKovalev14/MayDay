package ru.timcock.mayday.presentation;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.security.Provider;
import java.util.List;
import java.util.Map;

public class Service extends Provider.Service {
    public Service(Provider provider, String type, String algorithm, String className, List<String> aliases, Map<String, String> attributes) {
        super(provider, type, algorithm, className, aliases, attributes);
        java.util.TimeZone.getDefault();
        String temp = DateTime.now().toLocalTime().toString(DateTimeFormat
                .forPattern("yyyy:MM:DD:HH:mm"));

    }
}
