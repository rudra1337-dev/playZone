const http= require("http");
const url= require("url");


const server = new http.createServer((req,res)=>{
const myUrl=url.parse(req.url,true);

if(req.url=="/"){
res.writeHead(200,{"Content-Type":"text/plain"});
res.end("Welcome to home\nThe servr is working properly.");
}else if(req.url=="/about"){
res.writeHead(200,{"Content-Type":"text/plain"});
res.end("Read about me");
}else if(req.url=="/contact"){
res.writeHead(200,{"Content-Type":"text/plain"});
res.end("Thank for contact me");
}else if(req.url=="/json"){
res.writeHead(200,{"Content-Type":"application/json"});
let obj={
	Name:"Rudra",
	Age:18,
	}

res.end(JSON.stringify(obj));
}else if(myUrl.pathname=="/search"){
res.writeHead(200,{"Content-Type":"text/plain"});
let username=myUrl.query.name;
res.end(`Hii ${username}`);
}else{
res.writeHead(404,{"Content-Type":"text/plain"});
res.end("page not found");
}



console.log("end");

});

server.listen(3000,()=>{
console.log("listening on port 3000");
});


