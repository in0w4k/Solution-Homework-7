package Streaming_Service_Binge_Mode;

import Streaming_Service_Binge_Mode.iterators.*;

public class Main {
    public static void main(String[] args) {
        Season season1 = new Season();
        season1.addEpisode(new Episode("S1E1"));
        season1.addEpisode(new Episode("S1E2"));
        season1.addEpisode(new Episode("S1E3"));
        season1.addEpisode(new Episode("S1E4"));
        season1.addEpisode(new Episode("S1E5"));
        season1.addEpisode(new Episode("S1E6"));
        season1.addEpisode(new Episode("S1E7"));
        season1.addEpisode(new Episode("S1E8"));

        System.out.println("Normal Order:");
        EpisodeIterator normal = new SeasonIterator(season1.getEpisodes());
        while (normal.hasNext()) {
            System.out.println(normal.next().title());
        }

        System.out.println("\nReverse Order:");
        EpisodeIterator reverse = new ReverseSeasonIterator(season1.getEpisodes());
        while (reverse.hasNext()) {
            System.out.println(reverse.next().title());
        }

        System.out.println("\nShuffle Order:");
        EpisodeIterator shuffle = new ShuffleSeasonIterator(season1.getEpisodes());
        while (shuffle.hasNext()) {
            System.out.println(shuffle.next().title());
        }

        System.out.println("\nBinge Mode:");
        Season season2 = new Season();
        season2.addEpisode(new Episode("S2E1"));
        season2.addEpisode(new Episode("S2E2"));
        season2.addEpisode(new Episode("S2E3"));
        season2.addEpisode(new Episode("S2E4"));
        season2.addEpisode(new Episode("S2E5"));
        season2.addEpisode(new Episode("S2E6"));
        season2.addEpisode(new Episode("S2E7"));
        season2.addEpisode(new Episode("S2E8"));

        Series series = new Series();
        series.addSeason(season1);
        series.addSeason(season2);

        EpisodeIterator binge = new BingeIterator(series.getSeasons());
        while (binge.hasNext()) {
            System.out.println(binge.next().title());
        }
    }
}
