public class Entry {

    private String name;
    private int[] totalEntrance;

    public Entry(String name, int[] totalEntrance) {
        this.name = name;
        this.totalEntrance = totalEntrance;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getTotalEntrance() {
        return totalEntrance;
    }

    public void setTotalEntrance(int[] totalEntrance) {
        this.totalEntrance = totalEntrance;
    }
}
