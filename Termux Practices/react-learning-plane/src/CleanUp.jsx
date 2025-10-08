import {useState,useEffect} from "react";


function Timer(){
	const [count,setCount] = useState(0);
	const [stop,setStop] = useState(true);
	

	useEffect(()=>{
		let intervalId;
		
		if(stop){
			intervalId = setInterval(()=>{
				setCount((pre)=>pre+1);
				},1000);
		}

		return ()=>{
			clearInterval(intervalId);
		}
	},[stop]);


	return (
		<>
			<p>Timer: {count}</p>
			<button onClick={()=>setStop(false)}>Stop</button>
			<button onClick={()=>setStop(true)}>Start</button>
		</>
	);
}






export default Timer;
