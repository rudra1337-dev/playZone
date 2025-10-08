import {createSlice, createAsyncThunk} from "@reduxjs/toolkit";

export const fetchUser = createAsyncThunk("user/fetch", async ()=>{
    try{
        const res = await fetch("https://jsonplaceholder.typicode.com/users");
        const data = await res.json();
        return data;
        
    }catch(error){
        console.log(error.message);
    }
});


const userSlice = createSlice({
    name: "users",
    initialState: {
        user: [],
        loading: false,
        error: null,
    },
    reducers: {},
    extraReducers: (builder)=>{
        builder.addCase(fetchUser.pending, (state)=>{
             state.loading = true;
        });
        builder.addCase(fetchUser.fulfilled, (state,action)=>{
            state.loading = false;
            state.user = action.payload;
        });
        builder.addCase(fetchUser.rejected, (state,action)=>{
            state.loading = false;
            state.error = "Something went wrong!";
        });
        
    },
});



export default userSlice.reducer;
