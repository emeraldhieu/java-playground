package com.emeraldhieu.uuid;

import org.hashids.Hashids;

import java.util.concurrent.ThreadLocalRandom;

public class UniqueIdentifier {

    private Hashids hashids = new Hashids("saltThatOnlyYouKnow");

    public String getId() {
        return hashids.encode(getNumber());
    }

    public long getNumber() {
        return ThreadLocalRandom.current().nextLong(Hashids.MAX_NUMBER) + 1;
    }
}
