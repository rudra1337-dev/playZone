import {useState} from "react";

function Form(){
	const [name,setName] = useState("");

	return (
		<>
			<input type="text" placeholder="Name" 
				onChange={(e)=>setName(e.target.value)} />
			<h3>Hello, {name}</h3>

		</>
	);
}

export default Form;
