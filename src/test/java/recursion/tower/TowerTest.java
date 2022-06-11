package recursion.tower;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TowerTest {

    @Test
    public void addItem() {
        Tower tower = new Tower(3);

        tower.add(3);

        assertEquals(3, tower.getIndex());
        assertEquals(3, tower.peek());
    }

    @Test
    public void addTwoItem() {
        Tower tower = new Tower(3);

        tower.add(3);
        tower.add(2);

        assertEquals(3, tower.getIndex());
        assertEquals(2, tower.peek());
    }

    @Test
    public void addItemInInvalidOrder() {
        Tower tower = new Tower(3);

        tower.add(1);
        tower.add(3);

        assertEquals(3, tower.getIndex());
        assertEquals(1, tower.peek());
    }

    @Test
    public void moveDisk() {
        Tower[] tower = new Tower[3];
        for (int i = 0; i < tower.length; i++) {
            tower[i] = new Tower(i);
        }

        int diskCount = 3;
        for (int i = diskCount; i > 0; i--)
            tower[0].add(i);

        tower[0].moveDisks(diskCount, tower[2], tower[1]);
        assertEquals(0, tower[0].size());
        assertEquals(0, tower[1].size());
        assertEquals(3, tower[2].size());
    }

}