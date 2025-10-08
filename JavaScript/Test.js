/*

//1
const product={
				name : "Parker Jter Standard CT Ball Pen(Black)",
				rating : 5,
				isDeal : true,
				price : 270,
				offer : "5% off"
};

console.log(product["name"]);
console.log(product["rating"]);
console.log(product.isDeal);
console.log(product.price);
console.log(product["offer"]);

*/

/*

//2

const profile={
				name : "Rudra",
				post : 196,
				followers : 569000,
				following : 4,
				profession : "Programmer",
				isFollow : true,
				bio : "I an Rudra Narayan Maharana, i am 18 years old"
};
				
				console.log(profile.name);
				console.log(profile.post);
				console.log(profile.followers);
				console.log(profile.following);
				console.log(profile.profession);
				console.log(profile.isFollow);
				console.log(profile.bio);

*/

/*
//3

let input = prompt("Enter a number");

if(input%5===0){
				console.log(input," is a multiple of 5");
}else{
				console.log(input," is not a multiple of 5");
}

*/

/*

//4

let mark = prompt("Enter your total mark to check your grade");

console.log("Your mark = ",mark);
if(0<=mark && mark<=49){
				console.log("Your grade is F");
}else if(50<=mark && mark<=59){
				console.log("Your grade is D");
}else if(60<=mark && mark<=69){
				console.log("Your grade is C");
}else if(70<=mark && mark<=79){
				console.log("Your grade is B");
}else if(80<=mark && mark<=100){
				console.log("Your grade is A");
}

*/

/*
 
 // 5
console.log("These are the EVEN numbers from 0 to 100");
for(let i = 0; i<=100; i++){
				if(i%2===0){
								console.log(i);
				}
}

*/

/*

//6
console.log("GESS GAME");
let num;
for(let i=0; i<=1000; i++){
				num = prompt("Guess the game number");
				if(num==65){
								let a ="YOU WON THE GAME";
								console.log(a);
								i=1000
				}
}

*/

/*

//7
let arr = [85,97,44,37,76,60];
let sum=0;
for(let i=0; i<arr.length; i++){
				sum+=arr[i];
}
console.log("The avarage marks of the class-:",sum/arr.length);

*/


/*

//8
let arr = [250,645,300,900,50];
console.log("Before dicount ",arr);
for(let i=0; i<arr.length; i++){
				arr[i] = arr[i]*0.1;
}

console.log("After discount of 10% ",arr);


*/


/*

//9
let companies = ["Bloombetg","Microsoft","Ubar","Google","IBM","Netflix"];
console.log(companies);
companies.shift();
console.log(companies);
companies.splice(1,1,"Ola");
console.log(companies);
companies.push("Amazone");
console.log(companies);

*/

/*

//10

let str = prompt("Enter the string");
function findVowel(str){
				let a = 0;
				for(let i=0; i<str.length; i++){
								if(str[i]==='a'){
												a++;
								}else if(str[i]==='e'){
												a++;
								}else if(str[i]==='i'){
												a++;
								}else if(str[i]==='o'){
												a++;
								}else if(str[i]==='u'){
												a++;
								}
				}
				return a;
}

console.log("The total number of vowels in (",str,") =",findVowel(str));

*/


/*

//11

let str = prompt("Enter the string");
let findVowel=(str)=>{
				let a = 0;
				for(let i=0; i<str.length; i++){
								if(str[i]==='a'){
												a++;
								}else if(str[i]==='e'){
												a++;
								}else if(str[i]==='i'){
												a++;
								}else if(str[i]==='o'){
												a++;
								}else if(str[i]==='u'){
												a++;
								}
				}
				return a;
}

console.log("The total number of vowels in (",str,") =",findVowel(str));

*/

/*
//12

let arr = [5,67,7,35,65,66,7,3,9];

arr.forEach((number,index) => {
				console.log(`Square of ${number} = ${number*number}`);
});

*/

/*

//12
let marks = [60,55,98,59,30,99,93,85,60,32,45,46,87];
let markAbove90 = [];

for(let i=0; i<marks.length; i++){
				if(marks[i]>=90){
				markAbove90[i] = marks[i];
				}
}

console.log("Total marks of students{",marks,"}");
console.log("Marks of students who secured 90+{",markAbove90,"}");

*/

/*
//13
let n = prompt("Enter a number here");

let arr = [];


for(let i=1; i<=n; i++){
				arr[i-1] = i;
}
let sum = arr.reduce((acc,curr)=>{
				return acc+curr;
});

let mul = arr.reduce((acc,curr)=>{
				return acc*curr;
});

console.log(`Values =[${arr}]`);
console.log(`THhe addition of the values is =${sum}`);
console.log(`THhe multiplication of the values is =${mul}`);


*/

//<-------------------------------------DOM------------------------------------>

/*
//14
let h2 = document.createElement("h2");
let body = document.querySelector("body");
body.append(h2);
h2.innerText="Hii";
let j=" Yarr";
h2.innerText=h2.innerText.concat(j);

*/

/*

//15
let div1= document.createElement("div");
let div2 = document.createElement("div");
let div3 = document.createElement("div");
let body =document.querySelector("body");
div1.setAttribute("class","BOX");
div2.setAttribute("class","BOX");
div3.setAttribute("class","BOX");
body.append(div1);
body.append(div2);
body.append(div3);
let divs = document.querySelectorAll("div");
console.dir(div1.innerText)
let index=1;
for(div of divs){
				div.style.backgroundColor="lightblue";
				div.style.height="100px";
				div.style.color="red";
				div.style.width="100px";
				div.style.border="dashed,red";
				div.innerText=`new unique value ${index}`;
				index++;
}

*/

/*

//16

let button=document.createElement("button");
let body=document.querySelector("body");
body.append(button);
button.innerText="Click Me";
button.style.backgroundColor="blue";
button.style.color="white";

*/

/*

//17
let para=document.createElement("p");
let body=document.querySelector("body");
body.append(para);
para.setAttribute("class","para");
para.innerText="Hii bro how are you";
console.log(para.getAttribute("class"));
para.style.backgroundColor="blue";
para.style.fontSize="10vw";
para.classList.add("para1");
console.log(para.getAttribute("class"));

*/

let button=document.createElement("button");
let body=document.getElementsByTagName("body")[0];
let text=document.querySelector("textarea");
let hed=document.querySelector("h2");
body.append(button);
button.innerText="Click Me";

button.onclick=(e)=>{
			console.log("hii");
			body.style.backgroundColor="red";
			console.log(e.type);
			console.log(e.target);
			console.log(e.clientX);
			console.log(e.clientY);

			
console.log(text.innerContent);
}

body.addEventListener("touchstart",()=>{
			console.log("jellllllllllll");
			body.style.backgroundColor="green";
			
});


























































/*

let button=document.createElement("button");
let body= document.getElementsByTagName("body")[0];
let hed = document.getElementsByTagName("h2")[0];
hed.before(button);
button.innerText="Click Me";
button.style.height="40vh";
button.style.width="40%";
button.style.fontSize="110px";
let c="red";
button.addEventListener("click",()=>{
				console.log("fjfjfkfjfjfjfjfjkf");
				button.style.backgroundColor=c;
				hed.style.color=c;
				button.innerText=c;
					if(c=="red"){
								c="black";
				}else if(c=="black"){
								c="red";
				}
				body.style.backgroundColor=c;
				button.style.color=c;
				hed.innerText=c;
				
});

*/


/*

let bg = document.getElementById("brg");

console.log(bg);
console.dir(bg);
let heading = document.querySelector("h1");
console.dir(heading.innerText);

heading.innerText = "hii";
heading.innerHTML = "<I>IGUKGIUG</I>";
let q1=document.querySelector("#brg");


console.dir(q1);

console.log(q1.innerText);

let hr=document.querySelector("h1");
console.dir(hr.tagName);

let q2=document.querySelector(".h100");
console.dir(q2.innerText);
console.dir(q2.innerHTML);

console.log(q2.getAttribute("class"));
q2.setAttribute("class","hii");
console.log(q2.getAttribute("class"));

q2.style.backgroundColor = "red";




const fragment = document.createElement("div");
const li = fragment
  .appendChild(document.createElement("section"))
  .appendChild(document.createElement("ul"))
  .appendChild(document.createElement("li"));
li.textContent = "hello world";

document.body.appendChild(fragment);

*/


