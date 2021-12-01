
/**
 * Write a description of class BlockDataTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BlockDataTest implements BlockData
{
    private String from;
    private String to;
    private int amount;
    
    public BlockDataTest(String from, String to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
    
    public String toString() {
        return this.from+":"+this.to+":"+this.amount;
    }
}
