import {configureStore} from "@reduxjs/toolkit";
import counterReducer from "./CounterSlice.jsx";
import hiderSlice from "./HiderSlice.jsx";
import userReducer from "./UserSlice.jsx";


const Store = configureStore({
    reducer:{
        counter: counterReducer,
        hider: hiderSlice,
        users: userReducer,
    },
});

export default Store;
