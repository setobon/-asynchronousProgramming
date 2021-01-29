public class StadiumMainRunnable{


    private StadiumEntrance stadiumEntrance;
    private Entry entry;
    private long initialTime;


    public StadiumMainRunnable(StadiumEntrance stadiumEntrance, Entry entry, long initialTime) {
        this.stadiumEntrance = stadiumEntrance;
        this.entry = entry;
        this.initialTime = initialTime;
    }


    public static void main(String[] args) {

        Entry entry1 = new Entry("001", new int[]{2, 2, 1, 5, 2, 3});
        Entry entry2 = new Entry("002", new int[]{4, 1, 4, 1, 1});

        StadiumEntrance stadiumEntrance1 = new StadiumEntrance("Oriental");
        StadiumEntrance stadiumEntrance2 = new StadiumEntrance("Occidental");

        long initialTime = System.currentTimeMillis();

        Runnable processOne = ()-> stadiumEntrance1.totalEntrances(entry1,initialTime);
        Runnable processTwo = ()-> stadiumEntrance2.totalEntrances(entry2,initialTime);

        new Thread(processOne).start();
        new Thread(processTwo).start();
    }


}