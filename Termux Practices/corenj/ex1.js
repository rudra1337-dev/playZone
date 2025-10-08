const fs= require("fs");

let data=fs.readFileSync("ex.js","utf8");

fs.writeFileSync("http.js",data);

fs.writeFileSync("ex.js","");

