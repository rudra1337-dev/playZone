import {useQuery} from "@tanstack/react-query";

export function UsersQuery(){
    const {data, isLoading, isError} = useQuery({
      queryKey: ["uset"],
      queryFn: async ()=>{
        const res = await fetch("https://jsonplaceholder.typicode.com/users");
        const data = res.json();
        return data;
      }
    });
    
    if(isLoading) return (<p>Loading...</p>);
    if(isError) return (<h3>error</h3>);
    
    return (<>
      <h3>Users</h3>
      <ol type="a">
        {data.map((userr)=>(
        <li key={userr.id}>{userr.name}</li>))}
      </ol>
    </>);
}



import {useMutation} from "@tanstack/react-query";
import {useState} from "react";

const addUser = async (user)=>{
  const res = await fetch("https://jsonplaceholder.typicode.com/users",{
    method: "POST",
    headers: {"Content-Type" : "application/json"},
    body: JSON.stringify(user),
  });
  const data = await res.json();
  return data;
}
 
export function UserMutation(){
  const [name,setName] = useState("");
  const mutation = useMutation({
    mutationFn: addUser,
    onSuccess: (data)=>{
      alert("User added sucessfully "+data.name);
      setName("");
    },
    onError: (err)=>{
      alert("User update faild, "+err);
    },
  });
  
  function handleSubmit(e){
    e.preventDefault();
    mutation.mutate({name});
    setName("");
  }
  
  return (<>
    <form onSubmit={handleSubmit}>
      <input type="text" onChange={(e)=>setName(e.target.value)} value={name} name="name" placeholder="Name" />
        <button type="submit">Submit</button>
    </form>
  </>);
}






async function getUser1(page){
  const res = await fetch(`https://randomuser.me/api/?page=${page}&results=10&seed=abc`);
  const data = await res.json();
  return data;
}

export function Pegination(){
  const [page,setPage] = useState(1);
  
  const {data, isLoading, error, isFetching} = useQuery({
    queryKey: ["pegination", page],
    queryFn: ()=> getUser1(page),
    keepPreviousData: true,
  })  ;
  
  if(isLoading) return (<p>Loading...</p>);
  if(error) return (<p>Error: {error.message}</p>);
  
  return (<>
    <h2>Pgination</h2>
    <ol type="desc">
      {data.results.map((person)=> (
      <li key={person.location.number+1}>{person.name.first}</li>))}
    </ol>
    <h3>Page no. {page}</h3>
    <button onClick={()=> setPage((pre)=> Math.max(pre-1, 1))}>Prew</button>
    <button onClick={()=> setPage((pre)=> pre+1)}>Forw</button>
    {isFetching && (<p>Fetching...</p>)}
  </>)

}






import {useInfiniteQuery} from "@tanstack/react-query";

async function getUser2({pageParam= 1}){
  const res = await fetch(`https://randomuser.me/api/?page=${pageParam}&results=10&seed=abc`);
  const data = await res.json();
  return {...data, page: pageParam};
}

export function InfiniteScroling(){
  
  const [page,setPage] = useState(0);
  const {
    data,
    error,
    fetchNextPage,
    hasNextPage,
    isFetchingNextPage,
    status
  } = useInfiniteQuery({
    queryKey: ["infinite"],
    queryFn: getUser2,
  //  keepPreviousData: true,
    getNextPageParam: (lastPage,allPage)=>{
      const nextPage = lastPage.page + 1;
      return (nextPage <= 10 ? nextPage : undefined);
    }
  });
  
  if(status == "pending") return <p>Loading...</p>;
  if(status == "error") return <p>Something went wrong.</p>;
  
  return (<>
    <h2>Infinite scroling</h2>
    <ol>
      {data.pages.map((page)=>{
        return page.results.map((user,idx)=>(<li key={idx}>{user.name.first}</li>))
      })}
    </ol>
    
    <button onClick={fetchNextPage}>Fetch next page</button>
    {isFetchingNextPage && <p>Fetching...</p>}
  </>);
}





import axios from "axios";
import {useEffect} from "react";

export function Axios(){
  const user = async ()=>{
    const res = await
    axios.get(`https://jsonplaceholder.typicode.com/posts/${count}`);
    setData(res.data);
  }
  
const [data,setData] = useState({});
const [count,setCount] = useState(1);

useEffect(()=>{
  user();
},[count]);


return (<>
  <h3>Axios user</h3>
  <p>{data.title}</p>
  <button onClick={()=>setCount(count+1)}>Change</button>
</>)
}


export function AxiosPOST(){
  
  const [data1,setData] = useState({});
  const [title,setTitle] = useState("");
  
  
  
  
  const url ="https://jsonplaceholder.typicode.com/users";
  
  
    
    const config = {
      headers: {
        "Content-Type": "application/json",
      },
    }
  
  async function user(url,body,config){
    const res = await axios.post(url,body,config);
    setData(res.data);
  }
  
  
  function handleSubmit(e){
    e.preventDefault();
  const body = {
      title: title,
      body: "I want to see the gods.",
    }
  user(url,body,config);
  }
  
  return (<>
    <h4>Title: {data1.title}</h4>
    <form onSubmit={handleSubmit}>
      <input placeholder="Title" onChange={(e)=>setTitle(e.target.value)} />
      <button type="submit">Submit</button>
    </form>
  </>)
}








import {useForm} from "react-hook-form";

export function Form1(){
  const {
    register,
    handleSubmit,
    formState: {errors},
    reset,
    watch,
  } = useForm();
  
  
  function onSubmit(Data){
    alert("Form submited onSuccessfully."+JSON.stringify(Data));
  }
  
  let email1 = watch("email");
  const [condition,setCondition] = useState(false);
  
  return (<>
    <form onSubmit={handleSubmit(onSubmit)}>
          <input placeholder="Name" {...register("name",{
      required: "Name must entered",
    })} />
    {errors.name && <p>{errors.name.message}</p>}
    
    <input placeholder="Email" {...register("email",{
      required: "Emal must entered.",
      pattern: {
        value: /\S+@\S+\.\S+/,
        message: "Invalid email addres",
      },
    })} />
    {errors.email && <p>{errors.email.message}</p>}
    
    <button type="submit">Submit</button>
    <button type="button" onClick={()=>reset()}>Reset</button>
    
    </form>
    
    <button onClick={()=>setCondition(!condition)}>Watch</button>
    {condition && <p>Email: {email1}</p>}
  </>);
}



import React from "react";

export class ErrorWrapper extends React.Component{
  constructor(props){
    super(props);
    this.state = { hasError: false};
  }
  
  static getDerivedStateFromError(error){
    return {hasError: true}
  }
  
  componentDidCatch(error,errorInfo){
    console.log("Error: ",error,errorInfo);
  }
  
  render(){
    if(this.state.hasError) return <p>Something went wrong.</p>;
    return this.props.children;
  }
}














import {createPortal} from "react-dom";

export function Model({children, onClose}){
  
  
  return createPortal((
    <div>
      <div>
        <button onClick={onClose}>Close portal</button>
        <div>{children}</div>
      </div>
    </div>)
  ,document.getElementById("portal1"));
}


export function Portal(){
  const [show,setShow] = useState(false);
  
  return (<>
    <h2>Portal1</h2>
    <button onClick={()=>setShow(true)}>Show Portals</button>
    
    {show && (
      <Model onClose={()=>setShow(false)}>
      <h3>Welcome to Portal1</h3>
      <p>These are the portal elements...</p>
    </Model>
    )}
  </>)
}









 //higherOrder Components
//import {useState} from "react";

function Dashboard(){
  return <h1>WELCOME TO DASHBOARD</h1>;
}

function auth(Component){
  return function enhancedFunc({isLogedin,...others}){
    if(isLogedin) return <Component {...others} />;
    return <p>Please first login...</p>;
  }
}

export function User45(){
  const [isLogedin,setLogin] = useState(false);
  const EnhancedComp = auth(Dashboard);
  
  return (<>
    <EnhancedComp isLogedin={isLogedin} />
    <button onClick={()=>setLogin(!isLogedin)}>{isLogedin ? "Logout" :
    "Login"}</button>
  </>);
  
}






//props rendering pattern

function ToggleProps({funcChild}){
  const [on,setOn] = useState(false);
  function toggle(){
    setOn((pre)=>!pre);
  }
  return funcChild({on,setOn,toggle});
}


export function Toggle(){
  const {on1,setOn1,toggle1} = Toggle1(false);
  
  return (<>
    <h3>Toogle</h3>
    <h2>Props rendering pattern</h2>
    <ToggleProps funcChild={({on,setOn,toggle})=>(
      <>
        <p>{on ? "ON" : "OFF"}</p>
      <button onClick={()=>toggle()}>Toogle</button>
      </>
      )} />
      
      <h2>Custom hook technique</h2>
      <div>
        <p>{on1 ? "ON" : "OFF"}</p>
        <button onClick={()=>toggle1()}>Toggle</button>
      </div>
      
  </>)
}


export function Toggle1(init){
  const [on1,setOn1] = useState(init);
  function toggle1(){
    setOn1((pre)=>!pre);
  }
  return {on1,setOn1,toggle1};
}