import {useParams} from "react-router-dom";


function User(){
    const {id} = useParams();

    return (
        <>
            <h2>Welcome to user rout</h2>
            <p>User ID : {id}</p>
        </>
    );
}

export default User;
