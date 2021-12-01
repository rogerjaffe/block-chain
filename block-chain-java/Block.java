import java.util.Date;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

/**
 * Represents a Block in the Blockchain
 *
 * @author (Mr. Jaffe)
 * @version (2021-11-30)
 */
public class Block
{
    private BlockData data;
    private String hash;
    private String previousHash;
    private Date timestamp;
    private int proofOfWork;

    public Block(String previousHash, BlockData data) {
        this.data = data;
        this.hash = this.calculateHash();
        this.previousHash = previousHash;
        this.timestamp = new Date();
        this.proofOfWork = 0;
    }

    public String calculateHash() {
        String toHash = this.previousHash + 
            this.data.toString() + 
            this.timestamp + 
            this.proofOfWork;
        return hash(toHash).toString();
    }

    public String hash(String toHash) {
        MessageDigest digest = null;
        try
        {
            digest = MessageDigest.getInstance("SHA-256");
        }
        catch (java.security.NoSuchAlgorithmException nsae)
        {
            nsae.printStackTrace();
        }
        byte[] encodedhash = digest.digest(
                toHash.getBytes(StandardCharsets.UTF_8)
            );
        return bytesToHex(encodedhash);    
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    
    public void mine(int difficulty) {
        String startsWith = "";
        for (int i=0; i<difficulty; i++) 
            startsWith = startsWith + "0";
        while (!this.hash.startsWith(startsWith)) {
            this.proofOfWork++;
            this.hash = this.calculateHash();
        }
    }
    
    public String getHash() {
        return this.hash;
    }

    public String getPreviousHash() {
        return this.previousHash;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("***** Block *****\n");
        sb.append("=> Data\n");
        sb.append(this.data.toString());
        sb.append("\n");
        sb.append("=> Hash: "+this.hash);
        sb.append("\n");
        sb.append("=> PrevHash: "+this.previousHash);
        sb.append("\n");
        sb.append("=> Timestamp: "+this.timestamp);
        sb.append("\n");
        sb.append("=> ProofOfWork: "+this.proofOfWork);
        sb.append("\n");
        sb.append("\n");
        return sb.toString();
    }
}
