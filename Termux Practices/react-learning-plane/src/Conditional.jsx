import {useState} from "react";

function Message(){
	const [show,setShow] = useState(true);

	return (
		<>
			<button onClick={()=>setShow(!show)}>
				{show ? "Hide" : "Show"}
			</button>

			{show && <p>This is secret message</p>}
		</>
	);
}


export default Message;
