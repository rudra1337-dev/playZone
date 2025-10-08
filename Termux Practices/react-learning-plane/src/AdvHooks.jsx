import {useState,useRef,useMemo,useCallback} from "react";

export function Useref(){

    const target = useRef(null);
    
    function handle(){
        target.current.style.color="red";
        target.current.value = "You can't enter";
        target.current.focus();
        target.current.select();
    }

    return (<>

        <input type="text" ref={target} />
        <button onClick={handle}>Click me</button>

        </>)
}







export function Usememo({num}) {

    const [count,setCount] = useState(1);
    const [letter,setLetter] = useState("");

    const multi = useMemo(()=>{
    for(let i=1; i<=10000000; i++){}
 
    return count*num;
    },[count]);

    return (
        <>
           <h5>{count} , {multi}</h5>
           <button onClick={()=>setCount(count+1)}>Increase</button>

           <h5>{letter}</h5>
           <input type="text" onChange={(e)=>setLetter(e.target.value)}     />
         </>
       );
    
}







export function Usecallback(){

    const [counter,setCounter] = useState(0);

    const handleer = useCallback(()=>{
        console.log("Count is =", counter);
    },[counter]);


    return (<>

        <p>{counter}</p>
        <button onClick={()=>setCounter(counter+1)}>Increment</button>

        <button onClick={handleer}>Press</button>

        </>);

}








import React from "react";

export function Child({count}){
    console.log("From normal child");
    return <p>Count = {count}</p>
}

function MemoChild({count}){
    console.log("From React.memo child");
    return <p>Count = {count}</p>
}

 export const ChildMemo = React.memo(MemoChild);









function Heavy(){
    return <h3>I am heavy component</h3>;
}

export default Heavy;







{/*Custom hooks*/}


export function useCounter(num = 0){

    const [counter ,setCounter] = useState(num);

    const increase = ()=>setCounter(counter+1);
    const decrease = ()=>setCounter(counter-1);
    const reset = ()=>setCounter(num);

    return {counter,increase,decrease,reset};
}






import {FixedSizeList} from "react-window";

const items = Array.from({length:1000},(_,index)=>`Item ${index+1}` );

export function Virtualization(){

    return (
        <FixedSizeList height={800} width={600} itemCount={items.length} itemSize={80}>
        {({index,style})=>(
            <div style={style}>
                {items[index]}
            </div>
        )}
        </FixedSizeList>
    );
}
