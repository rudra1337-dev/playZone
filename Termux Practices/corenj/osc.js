const os=require("os");

console.log("Os typé:",os.type());
console.log("Os platform:",os.platform());

console.log("Architecture:", os.arch());

console.log("Total disk:",os.totalmem()/(1024*1024)+"mb");
console.log("Free disk:", os.freemem()/(1024*1024)+"mb");

console.log("User info:", os.userInfo());
console.log("CPU INFO:", os.cpus());



