public class StadiumEntrance {

    private String doorName;

    public StadiumEntrance(String doorName) {
        this.doorName = doorName;
    }

    public void totalEntrances(Entry entry, long timeStamp){
        System.out.println("The entry "
                + entry.getName()
                + " the begins to entrance process "
                + " in the time "
                + (System.currentTimeMillis()-timeStamp)/1000
                + " seconds");

        for (int i = 0; i < entry.getTotalEntrance().length; i++){
            this.waitBySeconds(entry.getTotalEntrance()[i]);
            System.out.println("Entries processed"
                    + (i+1)
                    + " -- seconds: "
                    + (System.currentTimeMillis()-timeStamp)/1000);
        }

        System.out.println("The entry  "
                + entry.getName()
                + " has finished processing "
                + " in the time: "
                + (System.currentTimeMillis()-timeStamp)/1000);

    }

    private void waitBySeconds(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException exception){
            Thread.currentThread().interrupt();
        }
    }
}
