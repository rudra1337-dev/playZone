import {useState} from "react";


function Todo(){
	const [task,setTask] = useState("");
	const [todos,setTodo] = useState([]);

const handleAdd = ()=>{
	if(task != ""){
		setTodo([...todos,task]);
		setTask("");
	}
}


const handleDelete =(deleteIndex)=>{
	const updatedTodos = todos.filter((todo,index)=> (index !== deleteIndex));
	setTodo(updatedTodos);
}




	return (
		<>
			<h1>Todo APP</h1>
			<input type="text" placeholder="Task" value={task} onChange={(e)=>setTask(e.target.value)} />
			<button onClick={handleAdd} >Add</button>

			<ul>
				{todos.map((todo,index)=>(
				<>
					<li key={index}>{todo}</li>
					<button onClick={()=>handleDelete(index)}>x</button>
				</>
				))}
			</ul>
		</>
	);
}


export default Todo;
