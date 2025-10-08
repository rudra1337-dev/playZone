import {atom} from "recoil";

export const counterAtom = atom({
    key: "Counter",
    default: 0,
});



import {selector} from "recoil";

export const doubleCount = selector({
    key: "doubleCount",
    get: ({get})=> get(counterAtom)*2,
});


export const  user = selector({
    key: "Users",
    get: async ()=>{
        const res = await fetch("https://jsonplaceholder.typicode.com/users");
        const data = await res.json();
        return data;
    }
})

