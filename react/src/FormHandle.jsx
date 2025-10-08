import {useState} from "react";


function FormHandle(){
	const [data,setData] = useState({name:"",email:""});
    const [error,setError] = useState({});


	function handleChange(e){
		const {name,value} = e.target;
		setData((pre)=>({
			...pre,[name]:value
			}));
	}

    function validate(){
        const newError = {};

        if(!data.name.trim()){
            newError.name = "Name must be entered";
        }

        if(!data.email.trim()){
            newError.email = "Email must be entered";
        }

        return newError;
    }

	function handleSubmit(e){
        e.preventDefault();
        const validation = validate();
        setError(validation);

        if(Object.keys(validation).length > 0){
            setError(validation);
            alert(validation.name || validation.email);
        }else{
            const {name} = data;
            console.log("Form submited Data:-", data);
            alert(`Thank you ${name}`);
            setData({name:"",email:"",});
        }
    }
		

    
	return (
        
		<form onSubmit={handleSubmit}>
			<input 
				type="text" 
				placeholder="Name" 
				value={data.name} 
				name="name" 
				onChange={handleChange} />

			<input 
				type="email" 
				placeholder="Email" 
				value={data.email} 
				name="email" 
				onChange={handleChange} />

			<button type="submit">Submit</button>
				
			

		</form>
        
	);

}


export default FormHandle;
