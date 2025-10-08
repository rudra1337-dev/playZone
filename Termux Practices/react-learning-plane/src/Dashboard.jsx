import {Link,Outlet} from "react-router-dom";



export function Profile(){

    return <h2>Welcome to profile</h2>;
}


export function Settings(){

    return <h2>Welcome to Settings</h2>;
}




export function Dashboard(){


    return (
        <>
            <nav>
                <Link to="profile">Profile</Link> <br />
                <Link to="settings">Settings</Link>
            </nav>

            <Outlet />
        </>
    );
}



