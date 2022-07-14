package ru.timcock.mayday.presentation;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Service extends Provider.Service {
    public Service(Provider provider, String type, String algorithm, String className, List<String> aliases, Map<String, String> attributes) {
        super(provider, type, algorithm, className, aliases, attributes);
//        ArrayList<>
    }
}
