package test;

import entity.RssFeed;
import observee.SimpleObserveeImpl;
import observer.PcRssReader;
import observer.SmartphoneRssReader;
import org.junit.Test;

public class RSSreaderTest {

    @Test
    public void testRssReader() {

        RssFeed rssFeed = new RssFeed(new SimpleObserveeImpl());
        PcRssReader pc1 = new PcRssReader("PC 1", rssFeed);
        PcRssReader pc2 = new PcRssReader("PC 2", rssFeed);
        SmartphoneRssReader smartphone = new SmartphoneRssReader("Android Phone", rssFeed);

        rssFeed.publishToFeed("Man jumped while celebrating!");

        rssFeed.subscribeToRssChannel(pc1);
        rssFeed.subscribeToRssChannel(smartphone);

        rssFeed.publishToFeed("Click to this to win 10 000 BitCoins!");

        System.out.println();
        rssFeed.unsubscribeFromRssChannel(pc1);

        rssFeed.publishToFeed("PC 1 unsubscribed! Hot news!");
    }
}
