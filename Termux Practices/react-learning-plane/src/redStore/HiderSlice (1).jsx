import {createSlice} from "@reduxjs/toolkit";

const hiderSlice = createSlice({
    name: "hider",
    initialState: {hide: false},
    reducers:{
        hide: (state)=>{
            state.hide= false;
        },
        show: (state)=>{
            state.hide= true;
        },
    },
});


export const {hide,show} = hiderSlice.actions;
export default hiderSlice.reducer;
