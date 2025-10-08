let url = "https://api.chucknorris.io/jokes/random";

/*
let promise=fetch(url);
promise.then((res)=>{
    return res.json();
}).then((res)=>{
    console.log(res);
    for(let key in res){
        console.log(`key=${key},value=${res[key]}`);
    }
}).catch((err)=>{
    console.log(err);
});
 */

async function getJokes(){
    let promise= await fetch(url,[]);
    let res = await promise.json();
    console.log(res);
    for(let key in res){
        console.log(`key=${key},value=${res[key]}`);
    }
}

getJokes();