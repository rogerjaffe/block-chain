const Blockchain = require('./Blockchain');

let blockchain = new Blockchain();

const ts1 = (new Date()).getTime();
blockchain.addBlock({
  from: "Viet",
  to: "David",
  amount: 100
})

blockchain.addBlock({
  from: "Adam",
  to: "Beck",
  amount: 150
})

const ts2 = (new Date()).getTime();
console.log(((ts2 - ts1) / 1000)+' sec');
console.log(blockchain);
