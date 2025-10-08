import {Navigate} from "react-router-dom"
import Home from "./Home.jsx";
import {Dashboard} from "./Dashboard.jsx";
import {useState} from "react";
import {Link,Routes,Route} from "react-router-dom";

function ProtectedRoute({isLogedin,children}){

    if(!isLogedin){
        return <Navigate to="/home" replace/>
    }

    return children;
}


function Protected(){

    const [isLogedin,setLogedin] = useState(false);

    return (
        <>
            <nav>
                <Link to="/home">Home</Link>
                <Link to="/dashboard">Dashboard</Link>
                <button onClick={()=>setLogedin(!isLogedin)} >
                    {isLogedin ? "Logout" : "Login"}
                </button>
            </nav>


            <Routes>
                <Route path="/home" element={<Home />}  />
                <Route path="/dashboard" element={
                   <ProtectedRoute isLogedin={isLogedin}>
                        <Dashboard />   
                    </ProtectedRoute>
                    } />

            </Routes>
        </>

    );

}



export default Protected;


