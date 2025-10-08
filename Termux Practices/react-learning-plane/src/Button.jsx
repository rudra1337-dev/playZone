import {useState} from "react";

function Button(){
	const [count,setCount] = useState(0);

	return (
		<>
			<button onClick={()=>setCount(count+1)}>Click Me</button>
			<h2>Count = {count}</h2>
		</>
	);

}

export default Button;

export const year = 1947;
