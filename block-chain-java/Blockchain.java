import java.util.ArrayList;

/**
 * Write a description of class Blockchain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Blockchain
{

    ArrayList<Block> chain = new ArrayList();
    private final int DIFFICULTY = 2;
    
    public Blockchain() {
        BlockData genesisBlockData = new GenesisBlockData();
        Block genesisBlock = new Block("0", genesisBlockData);
        chain.add(genesisBlock);
    }
    
    public void addBlock(BlockData newBlockData) {
        Block lastBlock = chain.get(chain.size()-1);
        Block newBlock = new Block(lastBlock.getHash(), newBlockData);
        newBlock.mine(DIFFICULTY);
        chain.add(newBlock);
    }
    
    public boolean isValid() {
        for (int i=1; i<chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i-1);
            
            if (currentBlock.getHash() != currentBlock.calculateHash()) 
                return false;
            if (currentBlock.getPreviousHash() != previousBlock.getHash()) 
                return false;
        }
        return true;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<chain.size(); i++) {
            sb.append(chain.get(i).toString());
        }
        return sb.toString();
    }
}
