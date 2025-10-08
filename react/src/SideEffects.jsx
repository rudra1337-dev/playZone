import {useState,useEffect} from "react";


function Effect(){
	const [count,setCount] = useState(0);
	const [color,setColor] = useState("white");
	useEffect(()=>{
		if(count%2 == 0){
			setColor("red");
		}else{
			setColor("green");
		}
	},[count]);

	return (
		<>
			<button onClick={()=>setCount(count+1)}>Increase</button>
			<p style={{color: color}}>Count = {count}</p>
		</>
	);
}

export default Effect;
