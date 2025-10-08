const http = require('http');
const URL = require('url');

let myServer = http.createServer((req,res)=>{

	let myUrl = URL.parse('https://www.rudra.dev/about?name=Rudra&age=18',true);
	console.log(myUrl);
let obj={protocol: "https",
  hostname: "example.com",
  port: "3000",
  pathname: "/dashboard",
  query: { user: "Rudra", role: "admin" },
}
myUrl=URL.format(obj);
//let myUrl = new URL.URL(req.url);
	res.writeHead(200,{'Content-Type':'application/json'});
	res.end(JSON.stringify(myUrl));
	});

myServer.listen(3000,()=>{
	console.log('Server is listening on port no 3000');
	});
