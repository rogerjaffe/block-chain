const Block = require('./Block');
const DIFFICULTY = 5;

module.exports = class Blockchain {
  constructor() {
    let genesisBlock = new Block("0", { isGenesis: true });
    this.chain = [genesisBlock];
  }

  addBlock(data) {
    let lastBlock = this.chain[this.chain.length - 1];
    let newBlock = new Block(lastBlock.hash, data);
    newBlock.mine(DIFFICULTY);
    this.chain.push(newBlock);
  }

  isValid() {
    for (let i=1; i < this.chain.length; i++) {
      const currentBlock = this.chain[i];
      const previousBlock = this.chain[i-1];

      if (currentBlock.hash != currentBlock.calculateHash()) return false;
      if (currentBlock.previousHash != previousBlock.hash) return false;
    }
    return true;
  }
}
