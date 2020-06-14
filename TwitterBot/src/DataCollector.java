public class DataCollector extends Thread {

    @Override
    public void run() {
        int lastUpdatedAmount = 0;
        Tweet twit = new Tweet();
        while (true) {
            try {
                Scraper youtube = new Scraper();
                int subsCount = youtube.scrape();
                if (lastUpdatedAmount < subsCount) {
                   twit.send(subsCount);
                    System.out.println("Congratulations Michael! You have reached " + subsCount + " subscribers!");
                    lastUpdatedAmount = subsCount;
                } else { System.out.println("waiting for sub count change");
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("interruption detected");
            }
        }
    }
}
