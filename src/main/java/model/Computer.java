package model;

import java.util.Optional;

public class Computer {
    private Optional<Soundcard> soundcard;
    public Optional<Soundcard> getSoundcard() {
        return soundcard;
    }
}
