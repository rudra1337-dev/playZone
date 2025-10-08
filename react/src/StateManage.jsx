
{/*}
import {useContext} from "react";

function Child(){
    const theme = useContext(MyContext);
    return <p>Theme: {theme}</p>;
}
*/}




import {createContext} from "react";
const MyContext = createContext();

export function Parent(){
    const theme = "Dark";
    return (
        <MyContext.Provider value={theme}>
            <Child />
        </MyContext.Provider>
    );

}



import {useContext} from "react";

 function Child(){
     const theme = useContext(MyContext);
     return (<p>Theme: {theme}</p>)
 }






import {useReducer} from "react";

export function UseReducer(){

    const iniState = {count: 1};
    function reducer(state,action){

        switch(action.type){
            case "Increase": 
                return {count : state.count+1};

            case "Decrease":
                return {count : state.count-1};

            case "Reset":
                return {count : 0};

            default :
                return state;
        }
    
    }

}




import {useSelector,useDispatch} from "react-redux";
import {increase,decrease,reset} from "./redStore/CounterSlice.jsx";


export function RTKCounter(){
    const count = useSelector((state)=>state.counter.count);
    const dispatch = useDispatch();

    return (<>
        <h3>RTK = {count}</h3>
        <button onClick={()=>{dispatch(increase())}}>+</button>
        <button onClick={()=>{dispatch(decrease())}}>-</button>
        <button onClick={()=>{dispatch(reset())}}>Reset</button>
        </>);

}



import {hide,show} from "./redStore/HiderSlice.jsx";

export function RTKHider(){

    const condition = useSelector((state)=>state.hider.hide);
    const dispatch = useDispatch();

    return (<>
        {condition && <h3>Hidden content</h3>}
        <button onClick={()=>dispatch(hide())}>Hide</button>
        <button onClick={()=>dispatch(show())}>Show</button>
        </>)
}






import {fetchUser} from "./redStore/UserSlice.jsx";
import {useEffect} from "react";


export function RTKUsers(){
    const dispatch = useDispatch();
    const {user, loading, error} = useSelector((state)=>state.users);


    useEffect(()=>{
        dispatch(fetchUser());

    },[dispatch]);

    return (<>

        {loading && <p>Loading...</p>}
        {error && <p>{error}</p>}

        <ol>
            {user.map((user,index)=>(<li key={index}>Name: {user.name}, Email: {user.email}</li>)
            )}
        </ol>

        </>);
}



import counterStore from "./redStore/ZustandStore.jsx";

export function ZustandCounter(){
    const {count, increase, decrease, reset} = counterStore();

    return (<>
        <h2>Z count = {count}</h2>
        <button onClick={increase}>+</button>
        <button onClick={decrease}>-</button>
        <button onClick={reset}>Reset</button>
        </>)
}





import {counterAtom} from "./redStore/Atoms.jsx";
import {useRecoilState} from "recoil";
import {doubleCount} from "./redStore/Atoms.jsx";
import {useRecoilValue} from "recoil";
import {useRecoilValueLoadable} from "recoil";
import {user} from "./redStore/Atoms.jsx";

export function RecoilCounter(){
    const [count,setCount] = useRecoilState(counterAtom);
    const count2 = useRecoilValue(doubleCount);
    const users = useRecoilValueLoadable(user);

    if(users.state === "loading"){
        return (<p>Loading...</p>);
    }
    if(users.state === "hasError"){
        return (<p>Something went wrong</p>);
    }


    return (<>
        <h2>RecoilCount = {count}, DoubleCount={count2}</h2>

        <ol>
            {users.contents.map((userr,index)=>(
                <li key={index}>Name: {userr.name}</li>
            ))}
        </ol>
        <button onClick={()=> setCount(count+1)}>+</button>
        <button onClick={()=> setCount(count-1)}>-</button>
        <button onClick={()=> setCount(0)}>Reset</button>
        </>);
}
