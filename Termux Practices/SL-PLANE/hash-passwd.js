const bcrypt = require(`bcryptjs`);

let passwd = "rudra@123";

async function hash(){
let hashedPasswd = await bcrypt.hash(passwd, 10);

console.log(hashedPasswd);

console.log( await bcrypt.compare(passwd, hashedPasswd));


}

hash();
