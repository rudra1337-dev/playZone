const event=require("events");

let Emitter=new event.EventEmitter();

Emitter.on("greet",()=>{
console.log("hii");
});

Emitter.on("welcome",(name)=>{
console.log("Welcome ",name);
});

Emitter.once("once",()=>{
console.log("once");
});

Emitter.emit("once");
Emitter.emit("once");

Emitter.emit("welcome","Rudra");

Emitter.emit("greet");

