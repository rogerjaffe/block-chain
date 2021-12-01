
/**
 * Write a description of class GenesisBlock here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GenesisBlockData implements BlockData
{
    private String simpleData;
    
    public GenesisBlockData() {
        this.simpleData = "Genesis block data";
    }
    
    public String toString() {
        return this.simpleData;
    }
}
