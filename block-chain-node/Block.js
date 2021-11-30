const hash = require('crypto-js/sha256');

module.exports = class Block {

  constructor(previousHash, data) {
    this.data = data;
    this.hash = this.calculateHash();
    this.previousHash = previousHash;
    this.timeStamp = new Date();
    this.proofOfWork = 0;
  }

  calculateHash() {
    const toHash = this.previousHash + JSON.stringify(this.data) + this.timeStamp + this.proofOfWork;
    return hash(toHash).toString();
  }

  mine(difficulty) {
    // Find the hash
    while (!this.hash.startsWith("0".repeat(difficulty))) {
      this.proofOfWork++;
      this.hash = this.calculateHash();
    }
  }
}
