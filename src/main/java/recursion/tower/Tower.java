package recursion.tower;

import java.util.Stack;

public class Tower {
    private final int index;
    private Stack<Integer> disks;

    public Tower(int index) {
        this.disks = new Stack<>();
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void add(int disk) {
        if (disks.empty() || peek() >= disk)
            disks.push(disk);
        else
            System.out.println("Error to place disk " + disk);
    }

    public int peek() {
        return disks.peek();
    }

    public void moveDisks(int diskCount, Tower destination, Tower buffer) {
        if (diskCount > 0) {
            moveDisks(diskCount - 1, buffer, destination);
            moveTopDisk(destination);
            buffer.moveDisks(diskCount - 1, destination, this);
        }
    }

    private void moveTopDisk(Tower destination) {
        int topDisk = this.disks.pop();
        destination.add(topDisk);
    }

    public int size() {
        return this.disks.size();
    }
}
