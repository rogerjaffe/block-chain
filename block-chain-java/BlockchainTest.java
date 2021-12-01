
/**
 * Write a description of class BlockTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BlockchainTest
{
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        BlockData b1 = new BlockDataTest("Jaffe","Roger",100);
        BlockData b2 = new BlockDataTest("Newton","Isaac",50);
        BlockData b3 = new BlockDataTest("Cooper","Sheldon",175);
        
        blockchain.addBlock(b1);
        blockchain.addBlock(b2);
        blockchain.addBlock(b3);
        System.out.println(blockchain.toString());
    }
}
