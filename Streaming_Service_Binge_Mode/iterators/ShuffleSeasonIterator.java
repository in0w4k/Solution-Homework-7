package Streaming_Service_Binge_Mode.iterators;

import Streaming_Service_Binge_Mode.Episode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private final List<Episode> shuffledEpisodes;
    private int currentEpisodeIndex;

    public ShuffleSeasonIterator(List<Episode> episodes) {
        shuffledEpisodes = new ArrayList<>(episodes);
        Collections.shuffle(shuffledEpisodes, new Random(123));
    }

    @Override
    public boolean hasNext() {
        return currentEpisodeIndex < shuffledEpisodes.size();
    }

    @Override
    public Episode next() {
        return shuffledEpisodes.get(currentEpisodeIndex++);
    }

}
