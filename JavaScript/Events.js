let body=document.getElementsByTagName("body")[0];


let h2m1=document.createElement("h3");
let border1=document.createElement("p");
h2m1.innerText="~~~~~~~~~~~Mouse Events~~~~~~~~~~~~";
body.prepend(h2m1);

//click
let div1=document.createElement("div");
h2m1.after(div1);
div1.innerText="click";
div1.addEventListener('click',()=>{
				console.log("CLICK");
				div1.style.backgroundColor="green";
});

//dblclick
let div2=document.createElement("div");
div1.after(div2);
div2.innerText="dblclick";
div2.addEventListener('dblclick',()=>{
				console.log("DBLCLICK");
				div2.style.backgroundColor="green";
});

//mousedown
let div3=document.createElement("div");
div2.after(div3);
div3.innerText="mousedown";
div3.addEventListener('mousedown',()=>{
				console.log("MOUSEDOWN");
				div3.style.backgroundColor="green";
});

//mouseup
let div4=document.createElement("div");
div3.after(div4);
div4.innerText="mouseup";
div4.addEventListener('mouseup',()=>{
				console.log("MOUSEUP");
				div4.style.backgroundColor="green";
});

//mousemove
let div5=document.createElement("div");
div4.after(div5);
div5.innerText="mousemove";
div5.addEventListener('mousemove',()=>{
				console.log("MOUSEMOVE");
				div5.style.backgroundColor="green";
});

//mouseover
let div6=document.createElement("div");
div5.after(div6);
div6.innerText="mouseover";
div6.addEventListener('mouseover',()=>{
				console.log("MOUSEOVER");
				div6.style.backgroundColor="green";
});

//mouseout
let div7=document.createElement("div");
div6.after(div7);
div7.innerText="mouseout";
div7.addEventListener('mouseout',()=>{
				console.log("MOUSEOUT");
				div7.style.backgroundColor="green";
});

//mouseenter
let div8=document.createElement("div");
div7.after(div8);
div8.innerText="mouseenter";
div8.addEventListener('mouseenter',()=>{
				console.log("MOUSEENTER");
				div8.style.backgroundColor="green";
});

//mouseleave
let div9=document.createElement("div");
div8.after(div9);
div9.innerText="mouseleave";
div9.addEventListener('mouseleave',()=>{
				console.log("MOUSELEAVE");
				div9.style.backgroundColor="green";
});


let h2m2=document.createElement("h3");
h2m2.innerText="\n\n~~~~~~~~~~~Key Board Events~~~~~~~~~~~~";
div9.after(h2m2);

//keydown
let div10=document.createElement("div");
h2m2.after(div10);
div10.innerText="keydown";
div10.addEventListener('keydown',()=>{
				console.log("KEYDOWN");
				div10.style.backgroundColor="green";
});

//keypress
let div11=document.createElement("div");
div10.after(div11);
div11.innerText="keypress";
div11.addEventListener('keypress',()=>{
				console.log("KYPRESS");
				div11.style.backgroundColor="green";
});

//keydown
let div12=document.createElement("div");
div11.after(div12);
div12.innerText="keyup";
div12.addEventListener('keyup',()=>{
				console.log("KEYUP");
				div12.style.backgroundColor="green";
});




let h=document.createElement("h2");
div12.after(h);
h.innerText="~~~~~~~~~~~~~~~~~~Form Submit~~~~~~~~~~~~~~~~~~~";


let div13=document.createElement("div");
h.after(div13);
div13.innerText="submit";
div13.addEventListener('submit',()=>{
				console.log("SUBMIT");
				div13.style.backgroundColor="green";
});


let div14=document.createElement("div");
div13.after(div14);
div14.innerText="change";
div14.addEventListener('change',()=>{
				console.log("CHANGE");
				div14.style.backgroundColor="green";
});

let div15=document.createElement("div");
div14.after(div15);
div15.innerText="input";
div15.addEventListener('input',()=>{
				console.log("input");
				div15.style.backgroundColor="green";
});


let div16=document.createElement("div");
div15.after(div16);
div16.innerText="focus";
div16.addEventListener('foccus',()=>{
				console.log("FOCUS");
				div16.style.backgroundColor="green";
});

let div17=document.createElement("div");
div16.after(div17);
div17.innerText="blur";
div17.addEventListener('blur',()=>{
				console.log("BLUR");
				div17.style.backgroundColor="green";
})


let h3=document.createElement("div");
div17.after(h3);
h3.innerText="~~~~~~~~~~~~~Window Event~~~~~~~~~~~~";


let div18=document.createElement("div");
h3.after(div18);
div18.innerText="load";
 div18.addEventListener('load',()=>{
 				console.log("LOAD");
 				div18.style.backgrooundColor="green";
 });

let div19=document.createElement("div");
div18.after(div19);
div19.innerText="resize";
div19.addEventListener('resize',()=>{
				console.log("LOAD");
				div19.style.backgroundColor="green";
});

let div20=document.createElement("div");
div19.after(div20);
div20.innerText="scroll";
div20.addEventListener('scroll',()=>{
				console.log("SCROLL");
				div20.style.backgroundColor="green";
});

let div21=document.createElement("div");
div20.after(div21);
div21.innerText="unloded";
div21.addEventListener('unloaded',()=>{
				console.log("UNLODED");
				div21.style.backgroundColor="green";
});

let h4=document.createElement("h2");
div21.after(h4);
h4.innerText="~~~~~~~~~~~~~~~Touch Events(FOR MOBILE)~`~~~~~~~~~~~~~";


let div22=document.createElement("div");
h4.after(div22);
div22.innerText="touchstart";
div22.addEventListener('touchstart',()=>{
				console.log("TOUCHSTART");
				div22.style.backgroundColor="green";
});

let div23=document.createElement("div");
div22.after(div23);
div23.innerText="touchmove";
div23.addEventListener('touchmove',()=>{
				console.log("TOUCHMOVE");
				div23.style.backgroundColor="green";
});

let div24=document.createElement("div");
div23.after(div24);
div24.innerText="touchend";
div24.addEventListener('touchend',()=>{
				console.log("TOUCHEND");
				div24.style.backgroundColor="green";
});

let h5=document.createElement("h2");
div24.after(h5);
h5.innerText="~~~~~~~~~~~~~~~~Drag and Drop~~~~~~~~~~~~";

let div25=document.createElement("div");
h5.after(div25);
div25.innerText="dragstart";
div25.addEventListener('dragstart',()=>{
				console.log("DRAGSTART");
				div25.style.backgroundColor="green";
});

let div26=document.createElement("div");
div25.after(div26);
div26.innerText="drag";
div26.addEventListener('drag',()=>{
				console.log("DRAG");
				div26.style.backgroundColor="green";
});


let div27=document.createElement("div");
div26.after(div27);
div27.innerText="dragend";
div27.addEventListener('dragend',()=>{
				console.log("DRAGEND");
				div27.style.backgroundColor="green";
});


let div28=document.createElement("div");
div27.after(div28);
div28.innerText="dragover";
div28.addEventListener('dragover',()=>{
				console.log("DRAGOVER");
				div28.style.backgroundColor="green";
});


let div29=document.createElement("div");
div28.after(div29);
div29.innerText="drop";
div29.addEventListener('drop',()=>{
				console.log("DROP");
				div29.style.backgroundColor="green";
});


let h6=document.createElement("h2");
div29.after(h6);
h6.innerText="~~~~~~~~~~~~~Media~~~~~~~~~~~~~";

let div30=document.createElement("div");
h6.after(div30);
div30.innerText="play";
div30.addEventListener('play',()=>{
				console.log("PLAY");
				div30.style.backgroundColor="green";
});

let div31=document.createElement("div");
div30.after(div31);
div31.innerText="pause";
div31.addEventListener('pause',()=>{
				console.log("PAUSE");
				div31.style.backgroundColor="green";
});

let div32=document.createElement("div");
div31.after(div32);
div32.innerText="ended";
div32.addEventListener('ended',()=>{
				console.log("ENDED");
				div32.style.backgroundColor="green";
});

let div33=document.createElement("div");
div32.after(div33);
div33.innerText="volumechange";
div33.addEventListener('volumechange',()=>{
				console.log("VOLUMECHANGE");
				div33.style.backgroundColor="green";
});


let h8=document.createElement("h2");
div33.after(h8);
h8.innerText="~~~~~~~~~~~~Others~~~~~~~~~~";

let div34=document.createElement("div");
h8.after(div34);
div34.innerText="contextmenu";
div34.addEventListener('contextmenu',()=>{
				console.log("CONTEXTMENUE");
				div34.style.backgroundColor="green";
});

let div35=document.createElement("div");
div34.after(div35);
div35.innerText="error";
div35.addEventListener('error',()=>{
				console.log("ERROR");
				div35.style.backgroundColor="green";
});