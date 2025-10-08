import {useState,useEffect} from "react";


function  ApiUser(){
	const [users,setUser] = useState([]);
	const [loading,setLoading] = useState(true);



useEffect(()=>{
	const getData = async ()=>{
		try{
			const res = await fetch("https://jsonplaceholder.typicode.com/users");
			const userData = await res.json();
			setUser(userData);
			setLoading(false);

		}catch(error){
			console.log(error);
		}
	}

	getData();
},[]);




	return (
		<>
			<h3>User Data From API</h3>
			{loading ? <p>User data loading...</p> : (<ul>
					{users.map((user)=>(
						<li key={user.id}>{user.name} - {user.email}</li>
					))}	
				</ul> 
				)}
		</>
	);
}

export default ApiUser;
