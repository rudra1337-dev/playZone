import './App.css'
import Button from "./Button.jsx";
import {year} from "./Button";
import Form from "./Form.jsx";
import Message from "./Conditional.jsx";
import Fruits from "./List.jsx";
import Todo from "./Todo.jsx";
import Effect from "./SideEffects.jsx";
import ApiUser from "./API.jsx";
import Timer from "./CleanUp.jsx";
import FormHandle from "./FormHandle.jsx";


import Example from "./Example.jsx";


import {Routes,Route,Link} from "react-router-dom";
import Home from "./Home.jsx";
import About from "./About.jsx";
import User from "./Params.jsx";
import {Dashboard,Profile,Settings} from "./Dashboard.jsx";
import NoPage from "./NoPage.jsx";
import Protected from "./Protected.jsx";


import {Useref,Usememo,Usecallback} from "./AdvHooks.jsx";
import {Child,ChildMemo} from "./AdvHooks.jsx";
import React,{useState,Suspense} from "react";
{/*Custom Hook*/}
import {useCounter} from "./AdvHooks.jsx";

import {Virtualization} from "./AdvHooks.jsx";



import {Parent} from "./StateManage.jsx";
import {UseReducer} from "./StateManage.jsx";
import {RTKCounter} from "./StateManage.jsx";
import {RTKHider} from "./StateManage.jsx";
import {RTKUsers} from "./StateManage.jsx";
import {ZustandCounter} from "./StateManage.jsx";
import {RecoilCounter} from "./StateManage.jsx";



function Xz(){
	return (
        <>
			<h1 style={{ color: 'red' }}>Hello</h1>
		</>
	);
}



function Great(props){
	return (
		<>
			<h2> Hello {props.name}</h2>
		</>
	);
}



function App() {

    const [count,setCount] = useState(0);
    const [toogle,setToogle] = useState(false);

    const [render,setRender] = useState(false);
    const HeavyComp = React.lazy(()=> import("./AdvHooks.jsx"));

    const {counter,increase,decrease,reset} = useCounter(3);
  return (
    <>
	<h1>Hello world</h1>
	<Xz></Xz>
	<Xz />
	<Great name="Rudra" />
	<Great name="Susee" />
	<Button />
	<h4>year = {year}</h4>
	<Form />
	<Fruits />
	<Message />
	<Todo />

	<h5>----------------------------------------------------------------------</h5>

	<Effect />
	<ApiUser />
	<Timer />
	<FormHandle />
    


    <h5>----------------------------------------------------------------------</h5>

    <nav>
      <Link to="/" >Home</Link> <br /> 
      <Link to="/About" >About</Link>
        <p>Enter the URL to /user/your-id</p>
      <Link to="/dashboard">Dashboard</Link>
    </nav>

      <Routes>
        <Route path="/" element={<Home />} />
         <Route path="/About" element={<About />} />
         <Route path="/user/:id" element={<User />} />
         <Route path="/dashboard" element={<Dashboard />} >
            <Route path="profile" element={<Profile />} />
            <Route path="settings" element={<Settings />} />
        </Route>   

         <Route path="*" element={<NoPage />} />
      </Routes>

       <Protected />


<h5>------------------------------------------------------------------------------</h5>
   

      <Useref />
      <Usememo num={123}/>
      <Usecallback />

      <Child count={count} />
      <ChildMemo count={count} />
      <button onClick={()=>setCount(count+1)}>Increase</button>
      <button onClick={()=>setToogle(!toogle)}>Toogle</button>
        
      <h2>Havy component</h2>
      <Suspense fallback={<p>Loading....</p>}>
      {render && <HeavyComp />}
      </Suspense>
      <button onClick={()=>setRender(true)}>Render</button>

      <h4>{counter}</h4>
      <button onClick={increase}>+</button>
      <button onClick={decrease}>-</button>
      <button onClick={reset}>Reset</button>

      <Virtualization />


<h5>--------------------------------------------------------------------------------</h5>

      <Parent />
      <UseReducer />
      <RTKCounter />
      <RTKHider />
      <RTKUsers />
      <ZustandCounter />
      <RecoilCounter />






      
<Example num={123} />
    </>
  )
}

export default App;
